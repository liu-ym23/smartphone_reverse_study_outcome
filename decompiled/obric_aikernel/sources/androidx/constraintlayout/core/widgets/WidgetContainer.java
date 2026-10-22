package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r10, int r11) {
        super(r10, r11);
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r10, int r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget r10) {
        this.mChildren.add(r10);
        if (r10.getParent() == null) goto L5;
        ((WidgetContainer) r10.getParent()).remove(r10);
    L5:
        r10.setParent(this);
    }

    public void add(ConstraintWidget... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        add(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget r10 = getParent();
        if ((this instanceof ConstraintWidgetContainer) == false) goto L5;
        ConstraintWidgetContainer r11 = (ConstraintWidgetContainer) this;
    L6:
        if (r10 == null) goto L11;
        ConstraintWidget r12 = r10.getParent();
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L10;
        r11 = (ConstraintWidgetContainer) r10;
    L10:
        r10 = r12;
        goto L6
    L11:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    public void layout() {
        ArrayList<ConstraintWidget> r10 = this.mChildren;
        if (r10 != null) goto L5;
        return;
    L5:
        int r11 = r10.size();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        ConstraintWidget r13 = this.mChildren.get(r12);
        if ((r13 instanceof WidgetContainer) == false) goto L10;
        ((WidgetContainer) r13).layout();
    L10:
        r12 = r12 + 1;
        goto L6
    }

    public void remove(ConstraintWidget r10) {
        this.mChildren.remove(r10);
        r10.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void resetSolverVariables(Cache r10) {
        super.resetSolverVariables(r10);
        int r11 = this.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildren.get(r12).resetSolverVariables(r10);
        r12 = r12 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void setOffset(int r10, int r11) {
        super.setOffset(r10, r11);
        int r12 = this.mChildren.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.mChildren.get(r13).setOffset(getRootX(), getRootY());
        r13 = r13 + 1;
        goto L3
    }
}
