package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public Barrier(String r3) {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(r3);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r13, boolean r14) {
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        int r15 = 0;
    L4:
        if (r15 >= this.mListAnchors.length) goto L6;
        this.mListAnchors[r15].mSolverVariable = r13.createObjectVariable(this.mListAnchors[r15]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = this.mBarrierType;
        if (r16 >= 0) goto L9;
        return;
    L9:
        if (r16 >= 4) goto L130;
        ConstraintAnchor r17 = this.mListAnchors[this.mBarrierType];
        if (this.resolved == true) goto L14;
        allSolved();
    L14:
        if (this.resolved == false) goto L25;
        this.resolved = false;
        int r18 = this.mBarrierType;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L22;
        if (r18 == 2) goto L21;
        if (r18 == 3) goto L21;
        return;
    L21:
        r13.addEquality(this.mTop.mSolverVariable, this.mY);
        SolverVariable r19 = this.mBottom.mSolverVariable;
        int r12 = this.mY;
    L23:
        r13.addEquality(r19, r12);
        return;
    L22:
        r13.addEquality(this.mLeft.mSolverVariable, this.mX);
        r19 = this.mRight.mSolverVariable;
        r12 = this.mX;
        goto L23
    L25:
        int r5 = 0;
    L27:
        if (r5 >= this.mWidgetsCount) goto L54;
        ConstraintWidget r6 = this.mWidgets[r5];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        int r7 = this.mBarrierType;
        if (r7 == 0) goto L37;
        if (r7 == 1) goto L37;
    L43:
        int r8 = this.mBarrierType;
        if (r8 == 2) goto L47;
        if (r8 == 3) goto L47;
    L53:
        r5 = r5 + 1;
    L47:
        if (r6.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L53;
        if (r6.mTop.mTarget == null) goto L53;
        if (r6.mBottom.mTarget == null) goto L53;
    L42:
        boolean r9 = true;
    L56:
        if (this.mLeft.hasCenteredDependents() == false) goto L58;
    L61:
        boolean r10 = true;
    L63:
        if (this.mTop.hasCenteredDependents() == false) goto L65;
    L68:
        boolean r11 = true;
    L69:
        if (r9 == true) goto L80;
        int r20 = this.mBarrierType;
        if (r20 != 0) goto L73;
        if (r10 == false) goto L73;
    L79:
        boolean r21 = true;
    L81:
        int r22 = 5;
        if (r21 == true) goto L84;
        r22 = 4;
    L84:
        int r23 = 0;
    L86:
        if (r23 >= this.mWidgetsCount) goto L106;
        ConstraintWidget r24 = this.mWidgets[r23];
        if (this.mAllowsGoneWidget == false) goto L90;
    L92:
        SolverVariable r25 = r13.createObjectVariable(r24.mListAnchors[this.mBarrierType]);
        r24.mListAnchors[this.mBarrierType].mSolverVariable = r25;
        if (r24.mListAnchors[this.mBarrierType].mTarget != null) goto L95;
    L97:
        int r26 = 0;
    L98:
        int r110 = this.mBarrierType;
        if (r110 == 0) goto L103;
        if (r110 == 2) goto L103;
        r13.addGreaterBarrier(r17.mSolverVariable, r25, this.mMargin + r26, r9);
    L104:
        r13.addEquality(r17.mSolverVariable, r25, this.mMargin + r26, r22);
    L105:
        r23 = r23 + 1;
    L103:
        r13.addLowerBarrier(r17.mSolverVariable, r25, this.mMargin - r26, r9);
        goto L104
    L95:
        if (r24.mListAnchors[this.mBarrierType].mTarget.mOwner != this) goto L97;
        r26 = r24.mListAnchors[this.mBarrierType].mMargin + 0;
        goto L98
    L90:
        if (r24.allowedInBarrier() == true) goto L92;
    L106:
        int r111 = this.mBarrierType;
        if (r111 != 0) goto L110;
        r13.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        SolverVariable r112 = this.mLeft.mSolverVariable;
        ConstraintAnchor r113 = this.mParent.mLeft;
    L109:
        r13.addEquality(r112, r113.mSolverVariable, 0, 0);
        return;
    L110:
        if (r111 != 1) goto L112;
        r13.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r112 = this.mLeft.mSolverVariable;
        r113 = this.mParent.mRight;
        goto L109
    L112:
        if (r111 != 2) goto L114;
        r13.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r112 = this.mTop.mSolverVariable;
        r113 = this.mParent.mTop;
        goto L109
    L114:
        if (r111 != 3) goto L132;
        r13.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r112 = this.mTop.mSolverVariable;
        r113 = this.mParent.mBottom;
        goto L109
    L132:
        return;
    L73:
        if (r20 != 2) goto L75;
        if (r11 == true) goto L79;
    L75:
        if (r20 != 1) goto L77;
        if (r10 == true) goto L79;
    L77:
        if (r20 != 3) goto L80;
        if (r11 == true) goto L79;
    L80:
        r21 = false;
        goto L81
    L65:
        if (this.mBottom.hasCenteredDependents() == true) goto L68;
        r11 = false;
        goto L69
    L58:
        if (this.mRight.hasCenteredDependents() == true) goto L61;
        r10 = false;
    L37:
        if (r6.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L43;
        if (r6.mLeft.mTarget == null) goto L43;
        if (r6.mRight.mTarget == null) goto L43;
    L31:
        if (r6.allowedInBarrier() == true) goto L33;
    L54:
        r9 = false;
        goto L56
    }

    public boolean allSolved() {
        int r0 = 0;
        int r2 = 0;
        boolean r3 = true;
    L4:
        if (r2 >= this.mWidgetsCount) goto L23;
        ConstraintWidget r4 = this.mWidgets[r2];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r7 = this.mBarrierType;
        if (r7 == 0) goto L14;
        if (r7 == 1) goto L14;
    L16:
        int r8 = this.mBarrierType;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
    L22:
        r2 = r2 + 1;
    L20:
        if (r4.isResolvedVertically() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r4.isResolvedHorizontally() == true) goto L16;
    L8:
        if (r4.allowedInBarrier() == true) goto L10;
    L23:
        if (r3 == true) goto L25;
    L66:
        return false;
    L25:
        if (this.mWidgetsCount <= 0) goto L66;
        int r5 = 0;
        boolean r6 = false;
    L28:
        if (r0 >= this.mWidgetsCount) goto L58;
        ConstraintWidget r9 = this.mWidgets[r0];
        if (this.mAllowsGoneWidget == false) goto L32;
    L34:
        if (r6 == true) goto L46;
        int r10 = this.mBarrierType;
        if (r10 != 0) goto L39;
        ConstraintAnchor.Type r11 = ConstraintAnchor.Type.LEFT;
    L38:
        r5 = r9.getAnchor(r11).getFinalValue();
    L45:
        r6 = true;
        goto L46
    L39:
        if (r10 != 1) goto L41;
        r11 = ConstraintAnchor.Type.RIGHT;
        goto L38
    L41:
        if (r10 != 2) goto L43;
        r11 = ConstraintAnchor.Type.TOP;
        goto L38
    L43:
        if (r10 != 3) goto L45;
        r11 = ConstraintAnchor.Type.BOTTOM;
    L46:
        int r12 = this.mBarrierType;
        if (r12 != 0) goto L50;
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.LEFT;
    L49:
        r5 = Math.min(r5, r9.getAnchor(r13).getFinalValue());
    L57:
        r0 = r0 + 1;
        goto L28
    L50:
        if (r12 != 1) goto L53;
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
    L52:
        r5 = Math.max(r5, r9.getAnchor(r14).getFinalValue());
        goto L57
    L53:
        if (r12 != 2) goto L55;
        r13 = ConstraintAnchor.Type.TOP;
        goto L49
    L55:
        if (r12 != 3) goto L57;
        r14 = ConstraintAnchor.Type.BOTTOM;
        goto L52
    L32:
        if (r9.allowedInBarrier() == true) goto L34;
    L58:
        int r15 = r5 + this.mMargin;
        int r1 = this.mBarrierType;
        if (r1 == 0) goto L63;
        if (r1 == 1) goto L63;
        setFinalVertical(r15, r15);
    L64:
        this.resolved = true;
        return true;
    L63:
        setFinalHorizontal(r15, r15);
        goto L64
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
    public void copy(ConstraintWidget r2, HashMap<ConstraintWidget, ConstraintWidget> r3) {
        super.copy(r2, r3);
        Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.memorydata.plugin");
        this.mBarrierType = r4.mBarrierType;
        this.mAllowsGoneWidget = r4.mAllowsGoneWidget;
        this.mMargin = r4.mMargin;
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
        int r2 = this.mBarrierType;
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        return 0;
    L7:
        if (r2 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r2 == 3) goto L12;
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

    public void markWidgets() {
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L21;
        ConstraintWidget r2 = this.mWidgets[r1];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r3 = this.mBarrierType;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L17;
    L18:
        r2.setInBarrier(1, true);
    L20:
        r1 = r1 + 1;
        goto L4
    L17:
        if (r3 != 3) goto L20;
    L19:
        r2.setInBarrier(0, true);
        goto L20
    L8:
        if (r2.allowedInBarrier() == true) goto L10;
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mAllowsGoneWidget = r1;
    }

    public void setBarrierType(int r1) {
        this.mBarrierType = r1;
    }

    public void setMargin(int r1) {
        this.mMargin = r1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r0 = "[Barrier] " + getDebugName() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L10;
        ConstraintWidget r2 = this.mWidgets[r1];
        if (r1 <= 0) goto L8;
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.getDebugName();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }
}
