package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget r5) {
        this.mChildren.add(r5);
        if (r5.getParent() == null) goto L5;
        ((WidgetContainer) r5.getParent()).remove(r5);
    L5:
        r5.setParent(this);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget r5 = getParent();
        if ((this instanceof ConstraintWidgetContainer) == false) goto L5;
        ConstraintWidgetContainer r10 = (ConstraintWidgetContainer) this;
    L6:
        if (r5 == null) goto L11;
        ConstraintWidget r11 = r5.getParent();
        if ((r5 instanceof ConstraintWidgetContainer) == false) goto L10;
        r10 = (ConstraintWidgetContainer) r5;
    L10:
        r5 = r11;
        goto L6
    L11:
        return r10;
    L5:
        r10 = null;
        goto L6
    }

    public void layout() {
        ArrayList<ConstraintWidget> r5 = this.mChildren;
        if (r5 != null) goto L5;
        return;
    L5:
        int r10 = r5.size();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L11;
        ConstraintWidget r12 = this.mChildren.get(r11);
        if ((r12 instanceof WidgetContainer) == false) goto L10;
        ((WidgetContainer) r12).layout();
    L10:
        r11 = r11 + 1;
        goto L6
    }

    public void remove(ConstraintWidget r5) {
        this.mChildren.remove(r5);
        r5.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache r5) {
        super.resetSolverVariables(r5);
        int r10 = this.mChildren.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        this.mChildren.get(r11).resetSolverVariables(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int r5, int r10) {
        super.setOffset(r5, r10);
        int r11 = this.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildren.get(r12).setOffset(getRootX(), getRootY());
        r12 = r12 + 1;
        goto L3
    }

    public WidgetContainer(int r5, int r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r5, int r10) {
        super(r5, r10);
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget... r5) {
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        add(r5[r11]);
        r11 = r11 + 1;
        goto L3
    }
}
