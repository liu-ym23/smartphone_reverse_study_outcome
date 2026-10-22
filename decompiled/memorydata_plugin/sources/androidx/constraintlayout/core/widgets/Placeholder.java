package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends VirtualLayout {
    public Placeholder() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r2, boolean r3) {
        super.addToSolver(r2, r3);
        if (this.mWidgetsCount <= 0) goto L6;
        ConstraintWidget r4 = this.mWidgets[0];
        r4.resetAllConstraints();
        r4.connect(ConstraintAnchor.Type.LEFT, this, ConstraintAnchor.Type.LEFT);
        r4.connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT);
        r4.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
        r4.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r6, int r7, int r8, int r9) {
        int r0 = getPaddingLeft() + getPaddingRight();
        boolean r1 = false;
        int r2 = r0 + 0;
        int r3 = (getPaddingTop() + getPaddingBottom()) + 0;
        if (this.mWidgetsCount <= 0) goto L5;
        r2 = r2 + this.mWidgets[0].getWidth();
        r3 = r3 + this.mWidgets[0].getHeight();
    L5:
        int r4 = Math.max(getMinWidth(), r2);
        int r5 = Math.max(getMinHeight(), r3);
        if (r6 == 1073741824) goto L13;
        if (r6 != Integer.MIN_VALUE) goto L10;
        r7 = Math.min(r4, r7);
        goto L13
    L10:
        if (r6 != 0) goto L12;
        r7 = r4;
        goto L13
    L12:
        r7 = 0;
    L13:
        if (r8 == 1073741824) goto L20;
        if (r8 != Integer.MIN_VALUE) goto L17;
        r9 = Math.min(r5, r9);
        goto L20
    L17:
        if (r8 != 0) goto L19;
        r9 = r5;
        goto L20
    L19:
        r9 = 0;
    L20:
        setMeasure(r7, r9);
        setWidth(r7);
        setHeight(r9);
        if (this.mWidgetsCount <= 0) goto L23;
        r1 = true;
    L23:
        needsCallbackFromSolver(r1);
    }
}
