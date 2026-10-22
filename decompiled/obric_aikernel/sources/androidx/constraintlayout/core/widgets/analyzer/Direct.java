package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ChainHead;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static int hcount;
    private static BasicMeasure.Measure measure;
    private static int vcount;

    static {
        measure = new BasicMeasure.Measure();
        hcount = 0;
        vcount = 0;
    }

    public Direct() {
    }

    private static boolean canMeasure(int r10, ConstraintWidget r11) {
        ConstraintWidget.DimensionBehaviour r12 = r11.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r13 = r11.getVerticalDimensionBehaviour();
        if (r11.getParent() == null) goto L5;
        ConstraintWidgetContainer r14 = (ConstraintWidgetContainer) r11.getParent();
    L6:
        if (r14 == null) goto L8;
        r14.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r14 == null) goto L10;
        r14.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 != r17) goto L13;
    L31:
        boolean r18 = true;
    L32:
        if (r13 != r17) goto L34;
    L52:
        boolean r19 = true;
    L54:
        if (r11.mDimensionRatio <= 0.0f) goto L58;
        if (r18 == true) goto L57;
        if (r19 == false) goto L58;
    L57:
        return true;
    L58:
        if (r18 == false) goto L62;
        if (r19 == true) goto L61;
        return false;
    L61:
        return true;
    L62:
        return false;
    L34:
        if (r11.isResolvedVertically() == true) goto L52;
        if (r13 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r20) goto L40;
    L45:
        if (r13 == r20) goto L47;
    L51:
        r19 = false;
        goto L54
    L47:
        if (r11.mMatchConstraintDefaultHeight != 1) goto L51;
        if (r11.hasResolvedTargets(1, r11.getHeight()) == false) goto L51;
    L40:
        if (r11.mMatchConstraintDefaultHeight != 0) goto L45;
        if (r11.mDimensionRatio != 0.0f) goto L45;
        if (r11.hasDanglingDimension(1) == true) goto L52;
    L13:
        if (r11.isResolvedHorizontally() == true) goto L31;
        if (r12 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 == r21) goto L19;
    L24:
        if (r12 == r21) goto L26;
    L30:
        r18 = false;
        goto L32
    L26:
        if (r11.mMatchConstraintDefaultWidth != 1) goto L30;
        if (r11.hasResolvedTargets(0, r11.getWidth()) == false) goto L30;
    L19:
        if (r11.mMatchConstraintDefaultWidth != 0) goto L24;
        if (r11.mDimensionRatio != 0.0f) goto L24;
        if (r11.hasDanglingDimension(0) == true) goto L31;
    L5:
        r14 = null;
        goto L6
    }

    private static void horizontalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18, boolean r19) {
        if (r17.isHorizontalSolvingPassDone() == false) goto L5;
        return;
    L5:
        boolean r10 = true;
        hcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r11 = r17.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r12 = r17.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r13 = r11.getFinalValue();
        int r14 = r12.getFinalValue();
        if (r11.getDependents() == null) goto L80;
        if (r11.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r15 = r11.getDependents().iterator();
    L18:
        if (r15.hasNext() == false) goto L80;
        ConstraintAnchor r20 = r15.next();
        ConstraintWidget r110 = r20.mOwner;
        int r111 = r16 + 1;
        boolean r112 = canMeasure(r111, r110);
        if (r110.isMeasureRequested() == false) goto L24;
        if (r112 == false) goto L24;
        ConstraintWidgetContainer.measure(r111, r110, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r20 != r110.mLeft) goto L30;
        ConstraintAnchor r113 = r110.mRight.mTarget;
        if (r113 == null) goto L30;
        if (r113.hasFinalValue() == false) goto L30;
    L35:
        boolean r114 = r10;
    L37:
        ConstraintWidget.DimensionBehaviour r115 = r110.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r115 != r21) goto L62;
        if (r112 == true) goto L62;
        if (r110.getHorizontalDimensionBehaviour() != r21) goto L63;
        if (r110.mMatchConstraintMaxWidth < 0) goto L63;
        if (r110.mMatchConstraintMinWidth < 0) goto L63;
        if (r110.getVisibility() == 8) goto L54;
        if (r110.mMatchConstraintDefaultWidth != 0) goto L63;
        if (r110.getDimensionRatio() != 0.0f) goto L63;
    L54:
        if (r110.isInHorizontalChain() == true) goto L63;
        if (r110.isInVirtualLayout() == true) goto L63;
        if (r114 == false) goto L63;
        if (r110.isInHorizontalChain() == true) goto L63;
        solveHorizontalMatchConstraint(r111, r17, r18, r110, r19);
    L63:
        r10 = true;
    L62:
        if (r110.isMeasureRequested() == true) goto L63;
        ConstraintAnchor r22 = r110.mLeft;
        if (r20 == r22) goto L67;
    L70:
        ConstraintAnchor r116 = r110.mRight;
        if (r20 == r116) goto L73;
    L75:
        if (r114 == false) goto L63;
        if (r110.isInHorizontalChain() == true) goto L63;
        solveHorizontalCenterConstraints(r111, r18, r110, r19);
        goto L63
    L73:
        if (r22.mTarget != null) goto L75;
        int r23 = r13 - r116.getMargin();
        r110.setFinalHorizontal(r23 - r110.getWidth(), r23);
    L69:
        horizontalSolvingPass(r111, r110, r18, r19);
        goto L63
    L67:
        if (r110.mRight.mTarget != null) goto L70;
        int r24 = r22.getMargin() + r13;
        r110.setFinalHorizontal(r24, r110.getWidth() + r24);
    L30:
        if (r20 != r110.mRight) goto L36;
        ConstraintAnchor r117 = r110.mLeft.mTarget;
        if (r117 == null) goto L36;
        if (r117.hasFinalValue() == true) goto L35;
    L36:
        r114 = false;
    L80:
        if ((r17 instanceof Guideline) == false) goto L83;
        return;
    L83:
        if (r12.getDependents() != null) goto L85;
    L149:
        r17.markHorizontalSolvingPassDone();
        return;
    L85:
        if (r12.hasFinalValue() == false) goto L149;
        Iterator<ConstraintAnchor> r25 = r12.getDependents().iterator();
    L88:
        if (r25.hasNext() == false) goto L149;
        ConstraintAnchor r26 = r25.next();
        ConstraintWidget r27 = r26.mOwner;
        int r28 = r16 + 1;
        boolean r118 = canMeasure(r28, r27);
        if (r27.isMeasureRequested() == false) goto L94;
        if (r118 == false) goto L94;
        ConstraintWidgetContainer.measure(r28, r27, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r26 != r27.mLeft) goto L100;
        ConstraintAnchor r119 = r27.mRight.mTarget;
        if (r119 == null) goto L100;
        if (r119.hasFinalValue() == false) goto L100;
    L105:
        boolean r120 = true;
    L107:
        ConstraintWidget.DimensionBehaviour r121 = r27.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r122 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r121 != r122) goto L132;
        if (r118 == true) goto L132;
        if (r27.getHorizontalDimensionBehaviour() != r122) goto L88;
        if (r27.mMatchConstraintMaxWidth < 0) goto L88;
        if (r27.mMatchConstraintMinWidth < 0) goto L88;
        if (r27.getVisibility() == 8) goto L124;
        if (r27.mMatchConstraintDefaultWidth != 0) goto L88;
        if (r27.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r27.isInHorizontalChain() == true) goto L88;
        if (r27.isInVirtualLayout() == true) goto L88;
        if (r120 == false) goto L88;
        if (r27.isInHorizontalChain() == true) goto L88;
        solveHorizontalMatchConstraint(r28, r17, r18, r27, r19);
    L132:
        if (r27.isMeasureRequested() == true) goto L88;
        ConstraintAnchor r123 = r27.mLeft;
        if (r26 == r123) goto L137;
    L140:
        ConstraintAnchor r124 = r27.mRight;
        if (r26 != r124) goto L145;
        if (r123.mTarget != null) goto L145;
        int r29 = r14 - r124.getMargin();
        r27.setFinalHorizontal(r29 - r27.getWidth(), r29);
    L139:
        horizontalSolvingPass(r28, r27, r18, r19);
    L145:
        if (r120 == false) goto L88;
        if (r27.isInHorizontalChain() == true) goto L88;
        solveHorizontalCenterConstraints(r28, r18, r27, r19);
        goto L88
    L137:
        if (r27.mRight.mTarget != null) goto L140;
        int r30 = r123.getMargin() + r14;
        r27.setFinalHorizontal(r30, r27.getWidth() + r30);
    L100:
        if (r26 != r27.mRight) goto L106;
        ConstraintAnchor r125 = r27.mLeft.mTarget;
        if (r125 == null) goto L106;
        if (r125.hasFinalValue() == true) goto L105;
    L106:
        r120 = false;
        goto L107
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r31 = r16 + 1;
        if (canMeasure(r31, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r31, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }

    public static String ls(int r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11.append("  ");
        r12 = r12 + 1;
        goto L3
    L5:
        r11.append("+-(" + r10 + ") ");
        return r11.toString();
    }

    private static void solveBarrier(int r10, Barrier r11, BasicMeasure.Measurer r12, int r13, boolean r14) {
        if (r11.allSolved() == false) goto L9;
        int r15 = r10 + 1;
        if (r13 != 0) goto L7;
        horizontalSolvingPass(r15, r11, r12, r14);
        return;
    L7:
        verticalSolvingPass(r15, r11, r12);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    public static boolean solveChain(ConstraintWidgetContainer r20, LinearSystem r21, int r22, int r23, ChainHead r24, boolean r25, boolean r26, boolean r27) {
        if (r27 == false) goto L5;
        return false;
    L5:
        if (r22 != 0) goto L10;
        if (r20.isResolvedHorizontally() == true) goto L12;
        return false;
    L12:
        boolean r10 = r20.isRtl();
        ConstraintWidget r11 = r24.getFirst();
        ConstraintWidget r12 = r24.getLast();
        ConstraintWidget r13 = r24.getFirstVisibleWidget();
        ConstraintWidget r14 = r24.getLastVisibleWidget();
        ConstraintWidget r15 = r24.getHead();
        ConstraintAnchor r16 = r11.mListAnchors[r23];
        int r17 = r23 + 1;
        ConstraintAnchor r18 = r12.mListAnchors[r17];
        ConstraintAnchor r19 = r16.mTarget;
        if (r19 != null) goto L15;
    L119:
        return false;
    L15:
        if (r18.mTarget == null) goto L119;
        if (r19.hasFinalValue() == false) goto L119;
        if (r18.mTarget.hasFinalValue() == false) goto L119;
        if (r13 == null) goto L119;
        if (r14 == null) goto L119;
        int r28 = r16.mTarget.getFinalValue() + r13.mListAnchors[r23].getMargin();
        int r29 = r18.mTarget.getFinalValue() - r14.mListAnchors[r17].getMargin();
        int r30 = r29 - r28;
        if (r30 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r110 = new BasicMeasure.Measure();
        boolean r111 = false;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        ConstraintWidget r115 = r11;
    L29:
        ConstraintWidget r116 = null;
        if (r111 == true) goto L60;
        if (canMeasure(1, r115) == false) goto L33;
        ConstraintWidget r117 = r11;
        if (r115.mListDimensionBehaviors[r22] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        if (r115.isMeasureRequested() == false) goto L41;
        ConstraintWidgetContainer.measure(1, r115, r20.getMeasurer(), r110, BasicMeasure.Measure.SELF_DIMENSIONS);
    L41:
        int r118 = r114 + r115.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L44;
        int r31 = r115.getWidth();
    L45:
        r114 = (r118 + r31) + r115.mListAnchors[r17].getMargin();
        r113 = r113 + 1;
        if (r115.getVisibility() == 8) goto L48;
        r112 = r112 + 1;
    L48:
        ConstraintAnchor r32 = r115.mListAnchors[r17].mTarget;
        if (r32 == null) goto L56;
        ConstraintWidget r33 = r32.mOwner;
        ConstraintAnchor[] r34 = r33.mListAnchors;
        if (r34[r23].mTarget == null) goto L56;
        if (r34[r23].mTarget.mOwner != r115) goto L56;
        r116 = r33;
    L56:
        if (r116 == null) goto L58;
        r115 = r116;
        r111 = r111;
    L59:
        r11 = r117;
        goto L29
    L58:
        r111 = true;
        goto L59
    L44:
        r31 = r115.getHeight();
        goto L45
    L36:
        return false;
    L33:
        return false;
    L60:
        ConstraintWidget r119 = r11;
        if (r112 != 0) goto L63;
        return false;
    L63:
        if (r112 == r113) goto L65;
        return false;
    L65:
        if (r30 >= r114) goto L67;
        return false;
    L67:
        int r35 = r30 - r114;
        if (r25 == false) goto L71;
        r35 = r35 / (r112 + 1);
    L70:
        int r36 = 1;
    L74:
        if (r112 != r36) goto L84;
        if (r22 != 0) goto L77;
        float r37 = r15.getHorizontalBiasPercent();
    L78:
        int r38 = (int) ((r28 + 0.5f) + (r35 * r37));
        if (r22 != 0) goto L81;
        r13.setFinalHorizontal(r38, r13.getWidth() + r38);
    L82:
        horizontalSolvingPass(1, r13, r20.getMeasurer(), r10);
        return true;
    L81:
        r13.setFinalVertical(r38, r13.getHeight() + r38);
        goto L82
    L77:
        r37 = r15.getVerticalBiasPercent();
        goto L78
    L84:
        if (r25 == false) goto L109;
        int r39 = r28 + r35;
        ConstraintWidget r40 = r119;
        boolean r41 = false;
        ?? r42 = r36;
    L86:
        if (r41 == true) goto L129;
        if (r40.getVisibility() != 8) goto L93;
        if (r22 != 0) goto L91;
        r40.setFinalHorizontal(r39, r39);
        horizontalSolvingPass(r42, r40, r20.getMeasurer(), r10);
    L98:
        r40.addToSolver(r21, false);
        ConstraintAnchor r43 = r40.mListAnchors[r17].mTarget;
        if (r43 == null) goto L104;
        ConstraintWidget r44 = r43.mOwner;
        ConstraintAnchor[] r45 = r44.mListAnchors;
        if (r45[r23].mTarget == null) goto L104;
        if (r45[r23].mTarget.mOwner != r40) goto L104;
    L105:
        if (r44 == null) goto L107;
        r40 = r44;
    L108:
        r42 = 1;
        goto L86
    L107:
        r41 = true;
    L104:
        r44 = null;
        goto L105
    L91:
        r40.setFinalVertical(r39, r39);
        verticalSolvingPass(r42, r40, r20.getMeasurer());
        goto L98
    L93:
        int r46 = r39 + r40.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L96;
        r40.setFinalHorizontal(r46, r40.getWidth() + r46);
        horizontalSolvingPass(1, r40, r20.getMeasurer(), r10);
        int r47 = r40.getWidth();
    L97:
        r39 = ((r46 + r47) + r40.mListAnchors[r17].getMargin()) + r35;
        goto L98
    L96:
        r40.setFinalVertical(r46, r40.getHeight() + r46);
        verticalSolvingPass(1, r40, r20.getMeasurer());
        r47 = r40.getHeight();
        goto L97
    L129:
        return r42;
    L109:
        if (r26 == false) goto L117;
        if (r112 != 2) goto L115;
        if (r22 != 0) goto L113;
        r13.setFinalHorizontal(r28, r13.getWidth() + r28);
        r14.setFinalHorizontal(r29 - r14.getWidth(), r29);
        horizontalSolvingPass(1, r13, r20.getMeasurer(), r10);
        horizontalSolvingPass(1, r14, r20.getMeasurer(), r10);
        return true;
    L113:
        r13.setFinalVertical(r28, r13.getHeight() + r28);
        r14.setFinalVertical(r29 - r14.getHeight(), r29);
        verticalSolvingPass(1, r13, r20.getMeasurer());
        verticalSolvingPass(1, r14, r20.getMeasurer());
        return true;
    L115:
        return false;
    L117:
        return true;
    L71:
        if (r26 == false) goto L70;
        if (r112 <= 2) goto L70;
        r36 = 1;
        r35 = (r35 / r112) - 1;
        goto L74
    L10:
        if (r20.isResolvedVertically() == true) goto L12;
        return false;
    }

    private static void solveHorizontalCenterConstraints(int r10, BasicMeasure.Measurer r11, ConstraintWidget r12, boolean r13) {
        float r14 = r12.getHorizontalBiasPercent();
        int r15 = r12.mLeft.mTarget.getFinalValue();
        int r16 = r12.mRight.mTarget.getFinalValue();
        int r17 = r12.mLeft.getMargin() + r15;
        int r18 = r16 - r12.mRight.getMargin();
        if (r15 != r16) goto L5;
        r14 = 0.5f;
    L6:
        int r19 = r12.getWidth();
        int r20 = (r16 - r15) - r19;
        if (r15 <= r16) goto L9;
        r20 = (r15 - r16) - r19;
    L9:
        if (r20 <= 0) goto L11;
        float r21 = (r14 * r20) + 0.5f;
    L12:
        int r22 = ((int) r21) + r15;
        int r23 = r22 + r19;
        if (r15 <= r16) goto L15;
        r23 = r22 - r19;
    L15:
        r12.setFinalHorizontal(r22, r23);
        horizontalSolvingPass(r10 + 1, r12, r11, r13);
        return;
    L11:
        r21 = r14 * r20;
        goto L12
    L5:
        r15 = r17;
        r16 = r18;
        goto L6
    }

    private static void solveHorizontalMatchConstraint(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, ConstraintWidget r13, boolean r14) {
        float r15 = r13.getHorizontalBiasPercent();
        int r16 = r13.mLeft.mTarget.getFinalValue() + r13.mLeft.getMargin();
        int r17 = r13.mRight.mTarget.getFinalValue() - r13.mRight.getMargin();
        if (r17 < r16) goto L20;
        int r18 = r13.getWidth();
        if (r13.getVisibility() == 8) goto L18;
        int r19 = r13.mMatchConstraintDefaultWidth;
        if (r19 == 2) goto L9;
        if (r19 != 0) goto L15;
        r18 = r17 - r16;
    L15:
        r18 = Math.max(r13.mMatchConstraintMinWidth, r18);
        int r20 = r13.mMatchConstraintMaxWidth;
        if (r20 <= 0) goto L18;
        r18 = Math.min(r20, r18);
        goto L18
    L9:
        if ((r11 instanceof ConstraintWidgetContainer) == true) goto L12;
        r11 = r11.getParent();
    L12:
        r18 = (int) ((r13.getHorizontalBiasPercent() * 0.5f) * r11.getWidth());
    L18:
        int r21 = r16 + ((int) ((r15 * ((r17 - r16) - r18)) + 0.5f));
        r13.setFinalHorizontal(r21, r18 + r21);
        horizontalSolvingPass(r10 + 1, r13, r12, r14);
        return;
    }

    private static void solveVerticalCenterConstraints(int r10, BasicMeasure.Measurer r11, ConstraintWidget r12) {
        float r13 = r12.getVerticalBiasPercent();
        int r14 = r12.mTop.mTarget.getFinalValue();
        int r15 = r12.mBottom.mTarget.getFinalValue();
        int r16 = r12.mTop.getMargin() + r14;
        int r17 = r15 - r12.mBottom.getMargin();
        if (r14 != r15) goto L5;
        r13 = 0.5f;
    L6:
        int r18 = r12.getHeight();
        int r19 = (r15 - r14) - r18;
        if (r14 <= r15) goto L9;
        r19 = (r14 - r15) - r18;
    L9:
        if (r19 <= 0) goto L11;
        float r20 = (r13 * r19) + 0.5f;
    L12:
        int r21 = (int) r20;
        int r22 = r14 + r21;
        int r23 = r22 + r18;
        if (r14 <= r15) goto L15;
        r22 = r14 - r21;
        r23 = r22 - r18;
    L15:
        r12.setFinalVertical(r22, r23);
        verticalSolvingPass(r10 + 1, r12, r11);
        return;
    L11:
        r20 = r13 * r19;
        goto L12
    L5:
        r14 = r16;
        r15 = r17;
        goto L6
    }

    private static void solveVerticalMatchConstraint(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, ConstraintWidget r13) {
        float r14 = r13.getVerticalBiasPercent();
        int r15 = r13.mTop.mTarget.getFinalValue() + r13.mTop.getMargin();
        int r16 = r13.mBottom.mTarget.getFinalValue() - r13.mBottom.getMargin();
        if (r16 < r15) goto L20;
        int r17 = r13.getHeight();
        if (r13.getVisibility() == 8) goto L18;
        int r18 = r13.mMatchConstraintDefaultHeight;
        if (r18 == 2) goto L9;
        if (r18 != 0) goto L15;
        r17 = r16 - r15;
    L15:
        r17 = Math.max(r13.mMatchConstraintMinHeight, r17);
        int r19 = r13.mMatchConstraintMaxHeight;
        if (r19 <= 0) goto L18;
        r17 = Math.min(r19, r17);
        goto L18
    L9:
        if ((r11 instanceof ConstraintWidgetContainer) == true) goto L12;
        r11 = r11.getParent();
    L12:
        r17 = (int) ((r14 * 0.5f) * r11.getHeight());
    L18:
        int r20 = r15 + ((int) ((r14 * ((r16 - r15) - r17)) + 0.5f));
        r13.setFinalVertical(r20, r17 + r20);
        verticalSolvingPass(r10 + 1, r13, r12);
        return;
    }

    public static void solvingPass(ConstraintWidgetContainer r13, BasicMeasure.Measurer r14) {
        ConstraintWidget.DimensionBehaviour r10 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r11 = r13.getVerticalDimensionBehaviour();
        hcount = 0;
        vcount = 0;
        r13.resetFinalResolution();
        ArrayList<ConstraintWidget> r12 = r13.getChildren();
        int r15 = r12.size();
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L5;
        r12.get(r16).resetFinalResolution();
        r16 = r16 + 1;
        goto L3
    L5:
        boolean r17 = r13.isRtl();
        if (r10 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r13.setFinalHorizontal(0, r13.getWidth());
    L9:
        int r18 = 0;
        boolean r19 = false;
        boolean r20 = false;
    L11:
        if (r18 >= r15) goto L35;
        ConstraintWidget r110 = r12.get(r18);
        if ((r110 instanceof Guideline) == false) goto L30;
        Guideline r111 = (Guideline) r110;
        if (r111.getOrientation() != 1) goto L34;
        if (r111.getRelativeBegin() == (-1)) goto L21;
        int r21 = r111.getRelativeBegin();
    L19:
        r111.setFinalValue(r21);
    L28:
        r19 = true;
        goto L34
    L21:
        if (r111.getRelativeEnd() == (-1)) goto L26;
        if (r13.isResolvedHorizontally() == false) goto L26;
        r21 = r13.getWidth() - r111.getRelativeEnd();
    L26:
        if (r13.isResolvedHorizontally() == false) goto L28;
        r21 = (int) ((r111.getRelativePercent() * r13.getWidth()) + 0.5f);
    L34:
        r18 = r18 + 1;
        goto L11
    L30:
        if ((r110 instanceof Barrier) == false) goto L34;
        if (((Barrier) r110).getOrientation() != 0) goto L34;
        r20 = true;
        goto L34
    L35:
        if (r19 == false) goto L44;
        int r22 = 0;
    L37:
        if (r22 >= r15) goto L44;
        ConstraintWidget r23 = r12.get(r22);
        if ((r23 instanceof Guideline) == false) goto L43;
        Guideline r24 = (Guideline) r23;
        if (r24.getOrientation() != 1) goto L43;
        horizontalSolvingPass(0, r24, r14, r17);
    L43:
        r22 = r22 + 1;
    L44:
        horizontalSolvingPass(0, r13, r14, r17);
        if (r20 == false) goto L55;
        int r25 = 0;
    L47:
        if (r25 >= r15) goto L55;
        ConstraintWidget r26 = r12.get(r25);
        if ((r26 instanceof Barrier) == false) goto L53;
        Barrier r27 = (Barrier) r26;
        if (r27.getOrientation() != 0) goto L53;
        solveBarrier(0, r27, r14, 0, r17);
    L53:
        r25 = r25 + 1;
    L55:
        if (r11 != ConstraintWidget.DimensionBehaviour.FIXED) goto L57;
        r13.setFinalVertical(0, r13.getHeight());
    L58:
        int r28 = 0;
        boolean r29 = false;
        boolean r30 = false;
    L59:
        if (r28 >= r15) goto L83;
        ConstraintWidget r31 = r12.get(r28);
        if ((r31 instanceof Guideline) == false) goto L78;
        Guideline r32 = (Guideline) r31;
        if (r32.getOrientation() != 0) goto L82;
        if (r32.getRelativeBegin() == (-1)) goto L69;
        int r33 = r32.getRelativeBegin();
    L67:
        r32.setFinalValue(r33);
    L76:
        r29 = true;
        goto L82
    L69:
        if (r32.getRelativeEnd() == (-1)) goto L74;
        if (r13.isResolvedVertically() == false) goto L74;
        r33 = r13.getHeight() - r32.getRelativeEnd();
    L74:
        if (r13.isResolvedVertically() == false) goto L76;
        r33 = (int) ((r32.getRelativePercent() * r13.getHeight()) + 0.5f);
    L82:
        r28 = r28 + 1;
        goto L59
    L78:
        if ((r31 instanceof Barrier) == false) goto L82;
        if (((Barrier) r31).getOrientation() != 1) goto L82;
        r30 = true;
        goto L82
    L83:
        if (r29 == false) goto L92;
        int r34 = 0;
    L85:
        if (r34 >= r15) goto L92;
        ConstraintWidget r35 = r12.get(r34);
        if ((r35 instanceof Guideline) == false) goto L91;
        Guideline r36 = (Guideline) r35;
        if (r36.getOrientation() != 0) goto L91;
        verticalSolvingPass(1, r36, r14);
    L91:
        r34 = r34 + 1;
    L92:
        verticalSolvingPass(0, r13, r14);
        if (r30 == false) goto L102;
        int r112 = 0;
    L95:
        if (r112 >= r15) goto L102;
        ConstraintWidget r37 = r12.get(r112);
        if ((r37 instanceof Barrier) == false) goto L101;
        Barrier r38 = (Barrier) r37;
        if (r38.getOrientation() != 1) goto L101;
        solveBarrier(0, r38, r14, 1, r17);
    L101:
        r112 = r112 + 1;
    L102:
        int r113 = 0;
    L103:
        if (r113 >= r15) goto L117;
        ConstraintWidget r39 = r12.get(r113);
        if (r39.isMeasureRequested() == false) goto L116;
        if (canMeasure(0, r39) == false) goto L116;
        ConstraintWidgetContainer.measure(0, r39, r14, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        if ((r39 instanceof Guideline) == true) goto L111;
        horizontalSolvingPass(0, r39, r14, r17);
    L115:
        verticalSolvingPass(0, r39, r14);
        goto L116
    L111:
        if (((Guideline) r39).getOrientation() == 0) goto L115;
        horizontalSolvingPass(0, r39, r14, r17);
    L116:
        r113 = r113 + 1;
        goto L103
    L117:
        return;
    L57:
        r13.setFinalTop(0);
        goto L58
    L8:
        r13.setFinalLeft(0);
        goto L9
    }

    private static void verticalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18) {
        if (r17.isVerticalSolvingPassDone() == false) goto L5;
        return;
    L5:
        vcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r10 = r17.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r11 = r17.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r12 = r10.getFinalValue();
        int r13 = r11.getFinalValue();
        if (r10.getDependents() == null) goto L80;
        if (r10.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r14 = r10.getDependents().iterator();
    L18:
        if (r14.hasNext() == false) goto L80;
        ConstraintAnchor r15 = r14.next();
        ConstraintWidget r19 = r15.mOwner;
        int r110 = r16 + 1;
        boolean r111 = canMeasure(r110, r19);
        if (r19.isMeasureRequested() == false) goto L24;
        if (r111 == false) goto L24;
        ConstraintWidgetContainer.measure(r110, r19, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r15 != r19.mTop) goto L30;
        ConstraintAnchor r112 = r19.mBottom.mTarget;
        if (r112 == null) goto L30;
        if (r112.hasFinalValue() == false) goto L30;
    L35:
        boolean r113 = true;
    L37:
        ConstraintWidget.DimensionBehaviour r114 = r19.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r114 != r115) goto L62;
        if (r111 == true) goto L62;
        if (r19.getVerticalDimensionBehaviour() != r115) goto L18;
        if (r19.mMatchConstraintMaxHeight < 0) goto L18;
        if (r19.mMatchConstraintMinHeight < 0) goto L18;
        if (r19.getVisibility() == 8) goto L54;
        if (r19.mMatchConstraintDefaultHeight != 0) goto L18;
        if (r19.getDimensionRatio() != 0.0f) goto L18;
    L54:
        if (r19.isInVerticalChain() == true) goto L18;
        if (r19.isInVirtualLayout() == true) goto L18;
        if (r113 == false) goto L18;
        if (r19.isInVerticalChain() == true) goto L18;
        solveVerticalMatchConstraint(r110, r17, r18, r19);
    L62:
        if (r19.isMeasureRequested() == true) goto L18;
        ConstraintAnchor r116 = r19.mTop;
        if (r15 == r116) goto L67;
    L70:
        ConstraintAnchor r117 = r19.mBottom;
        if (r15 != r117) goto L75;
        if (r116.mTarget != null) goto L75;
        int r20 = r12 - r117.getMargin();
        r19.setFinalVertical(r20 - r19.getHeight(), r20);
    L69:
        verticalSolvingPass(r110, r19, r18);
    L75:
        if (r113 == false) goto L18;
        if (r19.isInVerticalChain() == true) goto L18;
        solveVerticalCenterConstraints(r110, r18, r19);
        goto L18
    L67:
        if (r19.mBottom.mTarget != null) goto L70;
        int r21 = r116.getMargin() + r12;
        r19.setFinalVertical(r21, r19.getHeight() + r21);
    L30:
        if (r15 != r19.mBottom) goto L36;
        ConstraintAnchor r118 = r19.mTop.mTarget;
        if (r118 == null) goto L36;
        if (r118.hasFinalValue() == true) goto L35;
    L36:
        r113 = false;
    L80:
        if ((r17 instanceof Guideline) == false) goto L83;
        return;
    L83:
        if (r11.getDependents() != null) goto L85;
    L149:
        ConstraintAnchor r22 = r17.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r22.getDependents() != null) goto L152;
    L169:
        r17.markVerticalSolvingPassDone();
        return;
    L152:
        if (r22.hasFinalValue() == false) goto L169;
        int r23 = r22.getFinalValue();
        Iterator<ConstraintAnchor> r24 = r22.getDependents().iterator();
    L155:
        if (r24.hasNext() == false) goto L169;
        ConstraintAnchor r25 = r24.next();
        ConstraintWidget r26 = r25.mOwner;
        int r27 = r16 + 1;
        boolean r28 = canMeasure(r27, r26);
        if (r26.isMeasureRequested() == false) goto L161;
        if (r28 == false) goto L161;
        ConstraintWidgetContainer.measure(r27, r26, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L161:
        if (r26.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L164;
        if (r28 == false) goto L155;
    L164:
        if (r26.isMeasureRequested() == true) goto L155;
        if (r25 != r26.mBaseline) goto L155;
        r26.setFinalBaseline(r25.getMargin() + r23);
        verticalSolvingPass(r27, r26, r18);
        goto L155
    L85:
        if (r11.hasFinalValue() == false) goto L149;
        Iterator<ConstraintAnchor> r29 = r11.getDependents().iterator();
    L88:
        if (r29.hasNext() == false) goto L149;
        ConstraintAnchor r30 = r29.next();
        ConstraintWidget r31 = r30.mOwner;
        int r32 = r16 + 1;
        boolean r119 = canMeasure(r32, r31);
        if (r31.isMeasureRequested() == false) goto L94;
        if (r119 == false) goto L94;
        ConstraintWidgetContainer.measure(r32, r31, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r30 != r31.mTop) goto L100;
        ConstraintAnchor r120 = r31.mBottom.mTarget;
        if (r120 == null) goto L100;
        if (r120.hasFinalValue() == false) goto L100;
    L105:
        boolean r121 = true;
    L107:
        ConstraintWidget.DimensionBehaviour r122 = r31.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r123 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r122 != r123) goto L132;
        if (r119 == true) goto L132;
        if (r31.getVerticalDimensionBehaviour() != r123) goto L88;
        if (r31.mMatchConstraintMaxHeight < 0) goto L88;
        if (r31.mMatchConstraintMinHeight < 0) goto L88;
        if (r31.getVisibility() == 8) goto L124;
        if (r31.mMatchConstraintDefaultHeight != 0) goto L88;
        if (r31.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r31.isInVerticalChain() == true) goto L88;
        if (r31.isInVirtualLayout() == true) goto L88;
        if (r121 == false) goto L88;
        if (r31.isInVerticalChain() == true) goto L88;
        solveVerticalMatchConstraint(r32, r17, r18, r31);
    L132:
        if (r31.isMeasureRequested() == true) goto L88;
        ConstraintAnchor r124 = r31.mTop;
        if (r30 == r124) goto L137;
    L140:
        ConstraintAnchor r125 = r31.mBottom;
        if (r30 != r125) goto L145;
        if (r124.mTarget != null) goto L145;
        int r33 = r13 - r125.getMargin();
        r31.setFinalVertical(r33 - r31.getHeight(), r33);
    L139:
        verticalSolvingPass(r32, r31, r18);
    L145:
        if (r121 == false) goto L88;
        if (r31.isInVerticalChain() == true) goto L88;
        solveVerticalCenterConstraints(r32, r18, r31);
        goto L88
    L137:
        if (r31.mBottom.mTarget != null) goto L140;
        int r34 = r124.getMargin() + r13;
        r31.setFinalVertical(r34, r31.getHeight() + r34);
    L100:
        if (r30 != r31.mBottom) goto L106;
        ConstraintAnchor r126 = r31.mTop.mTarget;
        if (r126 == null) goto L106;
        if (r126.hasFinalValue() == true) goto L105;
    L106:
        r121 = false;
        goto L107
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r35 = r16 + 1;
        if (canMeasure(r35, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r35, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }
}
