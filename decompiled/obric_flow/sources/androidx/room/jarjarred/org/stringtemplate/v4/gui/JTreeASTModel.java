package androidx.room.jarjarred.org.stringtemplate.v4.gui;

import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: classes.dex */
public class JTreeASTModel implements TreeModel {
    TreeAdaptor adaptor;
    Object root;

    public JTreeASTModel(TreeAdaptor r5, Object r10) {
        this.adaptor = r5;
        this.root = r10;
    }

    public void addTreeModelListener(TreeModelListener r5) {
    }

    public Object getChild(Object r5, int r10) {
        return this.adaptor.getChild(r5, r10);
    }

    public int getChildCount(Object r5) {
        return this.adaptor.getChildCount(r5);
    }

    public int getIndexOfChild(Object r5, Object r10) {
        if (r5 != null) goto L6;
        return -1;
    L6:
        return this.adaptor.getChildIndex(r10);
    }

    public Object getRoot() {
        return this.root;
    }

    public boolean isLeaf(Object r5) {
        if (getChildCount(r5) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void removeTreeModelListener(TreeModelListener r5) {
    }

    public void valueForPathChanged(TreePath r5, Object r10) {
    }

    public JTreeASTModel(Object r5) {
        this.adaptor = new CommonTreeAdaptor();
        this.root = r5;
    }
}
