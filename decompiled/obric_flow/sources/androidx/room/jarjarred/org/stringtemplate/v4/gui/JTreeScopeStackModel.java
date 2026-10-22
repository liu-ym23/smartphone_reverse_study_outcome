package androidx.room.jarjarred.org.stringtemplate.v4.gui;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.AddAttributeEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.MultiMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: classes.dex */
public class JTreeScopeStackModel implements TreeModel {
    CommonTree root;

    public static class StringTree extends CommonTree {
        String text;

        public StringTree(String r5) {
            this.text = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public boolean isNil() {
            if (this.text != null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree, androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public String toString() {
            if (isNil() == false) goto L5;
            return "nil";
        L5:
            return this.text.toString();
        }
    }

    public JTreeScopeStackModel(InstanceScope r10) {
        this.root = new StringTree("Scope stack:");
        HashSet r5 = new HashSet();
        Iterator<InstanceScope> r11 = Interpreter.getScopeStack(r10, false).iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        InstanceScope r12 = r11.next();
        StringTree r13 = new StringTree(r12.f675st.getName());
        this.root.insertChild(0, r13);
        addAttributeDescriptions(r12.f675st, r13, r5);
        goto L4
    }

    public void addAttributeDescriptions(ST r10, StringTree r11, Set<String> r12) {
        Map<String, Object> r13 = r10.getAttributes();
        if (r13 != null) goto L5;
        return;
    L5:
        Iterator<String> r5 = r13.keySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L30;
        String r14 = r5.next();
        ST.DebugState r15 = r10.debugState;
        if (r15 == null) goto L25;
        MultiMap<String, AddAttributeEvent> r16 = r15.addAttrEvents;
        if (r16 == null) goto L25;
        List r17 = (List) r16.get(r14);
        StringBuilder r18 = new StringBuilder();
        if (r17 == null) goto L22;
        Iterator r19 = r17.iterator();
        int r20 = 0;
    L16:
        if (r19.hasNext() == false) goto L22;
        AddAttributeEvent r21 = (AddAttributeEvent) r19.next();
        if (r20 <= 0) goto L20;
        r18.append(", ");
    L20:
        r18.append(r21.getFileName() + ":" + r21.getLine());
        r20 = r20 + 1;
    L22:
        if (r18.length() <= 0) goto L24;
        StringBuilder r22 = j0.w(r14, " = ");
        r22.append(r13.get(r14));
        r22.append(" @ ");
        r22.append(r18.toString());
        String r23 = r22.toString();
    L27:
        if (r12.add(r14) == true) goto L29;
        r23 = "<html><font color=\"gray\">" + StringRenderer.escapeHTML(r23) + "</font></html>";
    L29:
        r11.addChild(new StringTree(r23));
        goto L7
    L24:
        StringBuilder r24 = j0.w(r14, " = ");
        r24.append(r13.get(r14));
        r23 = r24.toString();
    L25:
        StringBuilder r25 = j0.w(r14, " = ");
        r25.append(r13.get(r14));
        r23 = r25.toString();
        goto L27
    }

    public void addTreeModelListener(TreeModelListener r5) {
    }

    public Object getChild(Object r5, int r10) {
        return ((StringTree) r5).getChild(r10);
    }

    public int getChildCount(Object r5) {
        return ((StringTree) r5).getChildCount();
    }

    public int getIndexOfChild(Object r5, Object r10) {
        return ((StringTree) r10).getChildIndex();
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
}
