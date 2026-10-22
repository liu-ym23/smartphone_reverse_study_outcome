package androidx.room.jarjarred.org.antlr.v4.gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: classes.dex */
public class JFileChooserConfirmOverwrite extends JFileChooser {
    public JFileChooserConfirmOverwrite() {
        setMultiSelectionEnabled(false);
    }

    public void approveSelection() {
        if (getSelectedFile().exists() == true) goto L5;
    L7:
        super.approveSelection();
        return;
    L5:
        if (JOptionPane.showConfirmDialog(this, "Overwrite existing file?", "Overwrite?", 0) == 0) goto L7;
    }
}
