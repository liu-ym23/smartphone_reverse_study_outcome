package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget;
    private int mBarrierType;
    private int mMargin;
    boolean resolved;

    public Barrier() {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    public Barrier(String r10) {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(r10);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r13, boolean r14) {
        ConstraintAnchor[] r15 = this.mListAnchors;
        r15[0] = this.mLeft;
        r15[2] = this.mTop;
        r15[1] = this.mRight;
        r15[3] = this.mBottom;
        int r16 = 0;
    L3:
        ConstraintAnchor[] r10 = this.mListAnchors;
        if (r16 >= r10.length) goto L6;
        r10[r16].mSolverVariable = r13.createObjectVariable(r10[r16]);
        r16 = r16 + 1;
        goto L3
    L6:
        int r17 = this.mBarrierType;
        if (r17 >= 0) goto L9;
        return;
    L9:
        if (r17 >= 4) goto L129;
        ConstraintAnchor r18 = r10[r17];
        if (this.resolved == true) goto L14;
        allSolved();
    L14:
        if (this.resolved == false) goto L25;
        this.resolved = false;
        int r19 = this.mBarrierType;
        if (r19 == 0) goto L22;
        if (r19 == 1) goto L22;
        if (r19 == 2) goto L21;
        if (r19 == 3) goto L21;
        return;
    L21:
        r13.addEquality(this.mTop.mSolverVariable, this.mY);
        SolverVariable r110 = this.mBottom.mSolverVariable;
        int r12 = this.mY;
    L23:
        r13.addEquality(r110, r12);
        return;
    L22:
        r13.addEquality(this.mLeft.mSolverVariable, this.mX);
        r110 = this.mRight.mSolverVariable;
        r12 = this.mX;
        goto L23
    L25:
        int r11 = 0;
    L27:
        if (r11 >= this.mWidgetsCount) goto L54;
        ConstraintWidget r20 = this.mWidgets[r11];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        int r21 = this.mBarrierType;
        if (r21 == 0) goto L37;
        if (r21 == 1) goto L37;
    L43:
        int r22 = this.mBarrierType;
        if (r22 == 2) goto L47;
        if (r22 == 3) goto L47;
    L53:
        r11 = r11 + 1;
    L47:
        if (r20.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L53;
        if (r20.mTop.mTarget == null) goto L53;
        if (r20.mBottom.mTarget == null) goto L53;
    L42:
        boolean r23 = true;
    L56:
        if (this.mLeft.hasCenteredDependents() == false) goto L58;
    L61:
        boolean r24 = true;
    L63:
        if (this.mTop.hasCenteredDependents() == false) goto L65;
    L68:
        boolean r25 = true;
    L69:
        if (r23 == true) goto L80;
        int r26 = this.mBarrierType;
        if (r26 != 0) goto L73;
        if (r24 == false) goto L73;
    L79:
        boolean r27 = true;
    L81:
        int r28 = 5;
        if (r27 == true) goto L84;
        r28 = 4;
    L84:
        int r29 = 0;
    L86:
        if (r29 >= this.mWidgetsCount) goto L105;
        ConstraintWidget r30 = this.mWidgets[r29];
        if (this.mAllowsGoneWidget == false) goto L90;
    L92:
        SolverVariable r31 = r13.createObjectVariable(r30.mListAnchors[this.mBarrierType]);
        ConstraintAnchor[] r32 = r30.mListAnchors;
        int r111 = this.mBarrierType;
        r32[r111].mSolverVariable = r31;
        if (r32[r111].mTarget != null) goto L95;
    L97:
        int r33 = 0;
    L98:
        if (r111 == 0) goto L102;
        if (r111 == 2) goto L102;
        r13.addGreaterBarrier(r18.mSolverVariable, r31, this.mMargin + r33, r23);
    L103:
        r13.addEquality(r18.mSolverVariable, r31, this.mMargin + r33, r28);
    L104:
        r29 = r29 + 1;
    L102:
        r13.addLowerBarrier(r18.mSolverVariable, r31, this.mMargin - r33, r23);
        goto L103
    L95:
        if (r32[r111].mTarget.mOwner != this) goto L97;
        r33 = r32[r111].mMargin + 0;
        goto L98
    L90:
        if (r30.allowedInBarrier() == true) goto L92;
    L105:
        int r112 = this.mBarrierType;
        if (r112 != 0) goto L109;
        r13.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        SolverVariable r113 = this.mLeft.mSolverVariable;
        ConstraintAnchor r114 = this.mParent.mLeft;
    L108:
        r13.addEquality(r113, r114.mSolverVariable, 0, 0);
        return;
    L109:
        if (r112 != 1) goto L111;
        r13.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r113 = this.mLeft.mSolverVariable;
        r114 = this.mParent.mRight;
        goto L108
    L111:
        if (r112 != 2) goto L113;
        r13.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r113 = this.mTop.mSolverVariable;
        r114 = this.mParent.mTop;
        goto L108
    L113:
        if (r112 != 3) goto L131;
        r13.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r113 = this.mTop.mSolverVariable;
        r114 = this.mParent.mBottom;
        goto L108
    L131:
        return;
    L73:
        if (r26 != 2) goto L75;
        if (r25 == true) goto L79;
    L75:
        if (r26 != 1) goto L77;
        if (r24 == true) goto L79;
    L77:
        if (r26 != 3) goto L80;
        if (r25 == true) goto L79;
    L80:
        r27 = false;
        goto L81
    L65:
        if (this.mBottom.hasCenteredDependents() == true) goto L68;
        r25 = false;
        goto L69
    L58:
        if (this.mRight.hasCenteredDependents() == true) goto L61;
        r24 = false;
    L37:
        if (r20.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L43;
        if (r20.mLeft.mTarget == null) goto L43;
        if (r20.mRight.mTarget == null) goto L43;
    L31:
        if (r20.allowedInBarrier() == true) goto L33;
    L54:
        r23 = false;
        goto L56
    }

    public boolean allSolved() {
        int r10 = 0;
        int r11 = 0;
        boolean r12 = true;
    L3:
        int r13 = this.mWidgetsCount;
        if (r11 >= r13) goto L23;
        ConstraintWidget r14 = this.mWidgets[r11];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r15 = this.mBarrierType;
        if (r15 == 0) goto L14;
        if (r15 == 1) goto L14;
    L16:
        int r16 = this.mBarrierType;
        if (r16 == 2) goto L20;
        if (r16 == 3) goto L20;
    L22:
        r11 = r11 + 1;
    L20:
        if (r14.isResolvedVertically() == true) goto L22;
    L15:
        r12 = false;
    L14:
        if (r14.isResolvedHorizontally() == true) goto L16;
    L8:
        if (r14.allowedInBarrier() == true) goto L10;
    L23:
        if (r12 == false) goto L65;
        if (r13 <= 0) goto L65;
        int r17 = 0;
        boolean r18 = false;
    L27:
        if (r10 >= this.mWidgetsCount) goto L57;
        ConstraintWidget r19 = this.mWidgets[r10];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        if (r18 == true) goto L45;
        int r20 = this.mBarrierType;
        if (r20 != 0) goto L38;
        ConstraintAnchor.Type r21 = ConstraintAnchor.Type.LEFT;
    L37:
        r17 = r19.getAnchor(r21).getFinalValue();
    L44:
        r18 = true;
        goto L45
    L38:
        if (r20 != 1) goto L40;
        r21 = ConstraintAnchor.Type.RIGHT;
        goto L37
    L40:
        if (r20 != 2) goto L42;
        r21 = ConstraintAnchor.Type.TOP;
        goto L37
    L42:
        if (r20 != 3) goto L44;
        r21 = ConstraintAnchor.Type.BOTTOM;
    L45:
        int r22 = this.mBarrierType;
        if (r22 != 0) goto L49;
        ConstraintAnchor.Type r23 = ConstraintAnchor.Type.LEFT;
    L48:
        r17 = Math.min(r17, r19.getAnchor(r23).getFinalValue());
    L56:
        r10 = r10 + 1;
        goto L27
    L49:
        if (r22 != 1) goto L52;
        ConstraintAnchor.Type r24 = ConstraintAnchor.Type.RIGHT;
    L51:
        r17 = Math.max(r17, r19.getAnchor(r24).getFinalValue());
        goto L56
    L52:
        if (r22 != 2) goto L54;
        r23 = ConstraintAnchor.Type.TOP;
        goto L48
    L54:
        if (r22 != 3) goto L56;
        r24 = ConstraintAnchor.Type.BOTTOM;
        goto L51
    L31:
        if (r19.allowedInBarrier() == true) goto L33;
    L57:
        int r25 = r17 + this.mMargin;
        int r26 = this.mBarrierType;
        if (r26 == 0) goto L62;
        if (r26 == 1) goto L62;
        setFinalVertical(r25, r25);
    L63:
        this.resolved = true;
        return true;
    L62:
        setFinalHorizontal(r25, r25);
    L65:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        super.copy(r10, r11);
        Barrier r12 = (Barrier) r10;
        this.mBarrierType = r12.mBarrierType;
        this.mAllowsGoneWidget = r12.mAllowsGoneWidget;
        this.mMargin = r12.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int r10 = this.mBarrierType;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        if (r10 != 1) goto L7;
        return 0;
    L7:
        if (r10 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r10 == 3) goto L12;
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    protected void markWidgets() {
        int r10 = 0;
    L4:
        if (r10 >= this.mWidgetsCount) goto L21;
        ConstraintWidget r11 = this.mWidgets[r10];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r12 = this.mBarrierType;
        if (r12 == 0) goto L19;
        if (r12 == 1) goto L19;
        if (r12 != 2) goto L17;
    L18:
        r11.setInBarrier(1, true);
    L20:
        r10 = r10 + 1;
        goto L4
    L17:
        if (r12 != 3) goto L20;
    L19:
        r11.setInBarrier(0, true);
        goto L20
    L8:
        if (r11.allowedInBarrier() == true) goto L10;
    }

    public void setAllowsGoneWidget(boolean r10) {
        this.mAllowsGoneWidget = r10;
    }

    public void setBarrierType(int r10) {
        this.mBarrierType = r10;
    }

    public void setMargin(int r10) {
        this.mMargin = r10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r10 = "[Barrier] " + getDebugName() + " {";
        int r11 = 0;
    L4:
        if (r11 >= this.mWidgetsCount) goto L10;
        ConstraintWidget r12 = this.mWidgets[r11];
        if (r11 <= 0) goto L8;
        r10 = r10 + ", ";
    L8:
        r10 = r10 + r12.getDebugName();
        r11 = r11 + 1;
        goto L4
    L10:
        return r10 + "}";
    }
}
