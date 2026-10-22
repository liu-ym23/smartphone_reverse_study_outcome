package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends VirtualLayout {
    public Placeholder() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r10, boolean r11) {
        super.addToSolver(r10, r11);
        if (this.mWidgetsCount <= 0) goto L6;
        ConstraintWidget r12 = this.mWidgets[0];
        r12.resetAllConstraints();
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.LEFT;
        r12.connect(r13, this, r13);
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
        r12.connect(r14, this, r14);
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.TOP;
        r12.connect(r15, this, r15);
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.BOTTOM;
        r12.connect(r16, this, r16);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r10, int r11, int r12, int r13) {
        int r14 = getPaddingLeft() + getPaddingRight();
        boolean r15 = false;
        int r16 = r14 + 0;
        int r17 = (getPaddingTop() + getPaddingBottom()) + 0;
        if (this.mWidgetsCount <= 0) goto L5;
        r16 = r16 + this.mWidgets[0].getWidth();
        r17 = r17 + this.mWidgets[0].getHeight();
    L5:
        int r18 = Math.max(getMinWidth(), r16);
        int r19 = Math.max(getMinHeight(), r17);
        if (r10 == 1073741824) goto L13;
        if (r10 != Integer.MIN_VALUE) goto L10;
        r11 = Math.min(r18, r11);
        goto L13
    L10:
        if (r10 != 0) goto L12;
        r11 = r18;
        goto L13
    L12:
        r11 = 0;
    L13:
        if (r12 == 1073741824) goto L20;
        if (r12 != Integer.MIN_VALUE) goto L17;
        r13 = Math.min(r19, r13);
        goto L20
    L17:
        if (r12 != 0) goto L19;
        r13 = r19;
        goto L20
    L19:
        r13 = 0;
    L20:
        setMeasure(r11, r13);
        setWidth(r11);
        setHeight(r13);
        if (this.mWidgetsCount <= 0) goto L23;
        r15 = true;
    L23:
        needsCallbackFromSolver(r15);
    }
}
