import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Ben on 12/18/2014.
 */
public class commands extends JFrame implements ActionListener{
    JPanel mainPanel;
    JButton control;
    JButton cmd;
    JButton powShell;
    JButton system;
    JButton regedit;
    JButton secpol;
    JButton lusrmgr;


    public commands() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new MigLayout());
        control = new JButton("Control Panel");
        control.addActionListener(this);
        cmd = new JButton("CMD");
        cmd.addActionListener(this);
        powShell = new JButton("Power Shell");
        powShell.addActionListener(this);
        system = new JButton("System32");
        system.addActionListener(this);
        regedit = new JButton("Regedit");
        regedit.addActionListener(this);
        secpol = new JButton("Security Policy");
        secpol.addActionListener(this);
        lusrmgr = new JButton("Local Users");
        lusrmgr.addActionListener(this);

        mainPanel.add(control, "wrap");
        mainPanel.add(cmd, "wrap");
        mainPanel.add(powShell, "wrap");
        mainPanel.add(system, "wrap");
        mainPanel.add(regedit, "wrap");
        mainPanel.add(secpol, "wrap");
        mainPanel.add(lusrmgr, "wrap");
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == control) {
            run("cmd /c control");
        } else if (event.getSource() == cmd) {
            run("cmd /c start cmd");
        } else if(event.getSource() == powShell) {
            run("cmd /k start powershell");
        } else if (event.getSource() == system) {
            run("cmd /c explorer C:\\Windows\\System32");
        } else if (event.getSource() == regedit) {
            run("cmd /c regedit");
        } else if (event.getSource() == secpol) {
            run("cmd /c secpol");
        } else if (event.getSource() == lusrmgr) {
            run("cmd /c lusrmgr");
        }
    }

    void run(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {}
    }

    public static void main(String args[]) {
        commands gui = new commands();
        gui.pack();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
    }
}
