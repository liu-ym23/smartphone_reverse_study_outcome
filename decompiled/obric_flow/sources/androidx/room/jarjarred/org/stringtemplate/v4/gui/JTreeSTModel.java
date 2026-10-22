package androidx.room.jarjarred.org.stringtemplate.v4.gui;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.StringRenderer;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalTemplateEvent;
import java.util.Iterator;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: classes.dex */
public class JTreeSTModel implements TreeModel {
    public Interpreter interp;
    public Wrapper root;

    public static class Wrapper {
        EvalTemplateEvent event;

        public Wrapper(EvalTemplateEvent r5) {
            this.event = r5;
        }

        public boolean equals(Object r5) {
            if (this.event != ((Wrapper) r5).event) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        public String toString() {
            ST r5 = this.event.scope.f675st;
            if (r5.isAnonSubtemplate() == false) goto L6;
            return "{...}";
        L6:
            ST.DebugState r10 = r5.debugState;
            if (r10 == null) goto L13;
            if (r10.newSTEvent == null) goto L13;
            return "<html><b>" + StringRenderer.escapeHTML(r5.toString() + " @ " + r5.debugState.newSTEvent.getFileName() + ":" + r5.debugState.newSTEvent.getLine()) + "</b></html>";
        L13:
            return r5.toString();
        }
    }

    public JTreeSTModel(Interpreter r5, EvalTemplateEvent r10) {
        this.interp = r5;
        this.root = new Wrapper(r10);
    }

    public void addTreeModelListener(TreeModelListener r5) {
    }

    public Object getChild(Object r5, int r10) {
        return new Wrapper(((Wrapper) r5).event.scope.childEvalTemplateEvents.get(r10));
    }

    public int getChildCount(Object r5) {
        return ((Wrapper) r5).event.scope.childEvalTemplateEvents.size();
    }

    public int getIndexOfChild(Object r5, Object r10) {
        EvalTemplateEvent r11 = ((Wrapper) r5).event;
        Iterator<EvalTemplateEvent> r12 = r11.scope.childEvalTemplateEvents.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r12.next().scope.f675st == r11.scope.f675st) goto L7;
        r13 = r13 + 1;
        goto L4
    L7:
        return r13;
    L9:
        return -1;
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
