package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ChainHead;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private static boolean canMeasure(int r5, ConstraintWidget r6) {
        ConstraintWidget.DimensionBehaviour r7 = r6.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r0 = r6.getVerticalDimensionBehaviour();
        if (r6.getParent() == null) goto L5;
        ConstraintWidgetContainer r1 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r6.getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L8;
        r1.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r1 == null) goto L11;
        r1.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
    L11:
        if (r7 != ConstraintWidget.DimensionBehaviour.FIXED) goto L13;
    L32:
        boolean r8 = true;
    L34:
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
    L55:
        boolean r4 = true;
    L57:
        if (r6.mDimensionRatio <= 0.0f) goto L61;
        if (r8 == true) goto L60;
        if (r4 == false) goto L61;
    L60:
        return true;
    L61:
        if (r8 == false) goto L65;
        if (r4 == true) goto L64;
        return false;
    L64:
        return true;
    L65:
        return false;
    L36:
        if (r6.isResolvedVertically() == true) goto L55;
        if (r0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L55;
        if (r0 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r6.mMatchConstraintDefaultHeight != 0) goto L48;
        if (r6.mDimensionRatio != 0.0f) goto L48;
        if (r6.hasDanglingDimension(1) == true) goto L55;
    L48:
        if (r0 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L50;
    L54:
        r4 = false;
        goto L57
    L50:
        if (r6.mMatchConstraintDefaultHeight != 1) goto L54;
        if (r6.hasResolvedTargets(1, r6.getHeight()) == false) goto L54;
    L13:
        if (r6.isResolvedHorizontally() == true) goto L32;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
        if (r6.mMatchConstraintDefaultWidth != 0) goto L25;
        if (r6.mDimensionRatio != 0.0f) goto L25;
        if (r6.hasDanglingDimension(0) == true) goto L32;
    L25:
        if (r7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
    L31:
        r8 = false;
        goto L34
    L27:
        if (r6.mMatchConstraintDefaultWidth != 1) goto L31;
        if (r6.hasResolvedTargets(0, r6.getWidth()) == false) goto L31;
    L5:
        r1 = null;
        goto L6
    }

    private static void horizontalSolvingPass(int r17, ConstraintWidget r18, BasicMeasure.Measurer r19, boolean r20) {
        BasicMeasure.Measurer r2 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r19, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        if (r18.isHorizontalSolvingPassDone() == false) goto L5;
        return;
    L5:
        hcount++;
        if (ZeusTransformUtils.instanceOf(r18, ConstraintWidgetContainer.class) == false) goto L8;
    L12:
        ConstraintAnchor r4 = r18.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r6 = r18.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r7 = r4.getFinalValue();
        int r8 = r6.getFinalValue();
        if (r4.getDependents() == null) goto L80;
        if (r4.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r5 = r4.getDependents().iterator();
    L18:
        if (r5.hasNext() == false) goto L80;
        ConstraintAnchor r9 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r5.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r13 = r9.mOwner;
        int r14 = r17 + 1;
        boolean r15 = canMeasure(r14, r13);
        if (r13.isMeasureRequested() == false) goto L24;
        if (r15 == false) goto L24;
        ConstraintWidgetContainer.measure(r14, r13, r2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r9 != r13.mLeft) goto L30;
        if (r13.mRight.mTarget == null) goto L30;
        if (r13.mRight.mTarget.hasFinalValue() == false) goto L30;
    L35:
        boolean r10 = true;
    L38:
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r15 == true) goto L62;
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        if (r13.mMatchConstraintMaxWidth < 0) goto L18;
        if (r13.mMatchConstraintMinWidth < 0) goto L18;
        if (r13.getVisibility() == 8) goto L54;
        if (r13.mMatchConstraintDefaultWidth != 0) goto L18;
        if (r13.getDimensionRatio() != 0.0f) goto L18;
    L54:
        if (r13.isInHorizontalChain() == true) goto L18;
        if (r13.isInVirtualLayout() == true) goto L18;
        if (r10 == false) goto L18;
        if (r13.isInHorizontalChain() == true) goto L18;
        solveHorizontalMatchConstraint(r14, r18, r2, r13, r20);
    L62:
        if (r13.isMeasureRequested() == true) goto L18;
        if (r9 != r13.mLeft) goto L71;
        if (r13.mRight.mTarget != null) goto L71;
        int r11 = r13.mLeft.getMargin() + r7;
        r13.setFinalHorizontal(r11, r13.getWidth() + r11);
    L69:
        horizontalSolvingPass(r14, r13, r2, r20);
    L71:
        if (r9 == r13.mRight) goto L73;
    L75:
        if (r10 == false) goto L18;
        if (r13.isInHorizontalChain() == true) goto L18;
        solveHorizontalCenterConstraints(r14, r2, r13, r20);
        goto L18
    L73:
        if (r13.mLeft.mTarget != null) goto L75;
        int r12 = r7 - r13.mRight.getMargin();
        r13.setFinalHorizontal(r12 - r13.getWidth(), r12);
    L30:
        if (r9 == r13.mRight) goto L32;
    L36:
        r10 = false;
        goto L38
    L32:
        if (r13.mLeft.mTarget == null) goto L36;
        if (r13.mLeft.mTarget.hasFinalValue() == false) goto L36;
    L80:
        if (ZeusTransformUtils.instanceOf(r18, Guideline.class) == false) goto L83;
        return;
    L83:
        if (r6.getDependents() != null) goto L85;
    L152:
        r18.markHorizontalSolvingPassDone();
        return;
    L85:
        if (r6.hasFinalValue() == false) goto L152;
        Iterator<ConstraintAnchor> r16 = r6.getDependents().iterator();
    L88:
        if (r16.hasNext() == false) goto L152;
        ConstraintAnchor r21 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r16.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r22 = r21.mOwner;
        int r23 = r17 + 1;
        boolean r110 = canMeasure(r23, r22);
        if (r22.isMeasureRequested() == false) goto L94;
        if (r110 == false) goto L94;
        ConstraintWidgetContainer.measure(r23, r22, r2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r21 != r22.mLeft) goto L100;
        if (r22.mRight.mTarget == null) goto L100;
        if (r22.mRight.mTarget.hasFinalValue() == false) goto L100;
    L105:
        boolean r111 = true;
    L108:
        if (r22.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L135;
        if (r110 == true) goto L135;
        if (r22.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L88;
        if (r22.mMatchConstraintMaxWidth < 0) goto L88;
        if (r22.mMatchConstraintMinWidth < 0) goto L88;
        if (r22.getVisibility() == 8) goto L126;
        if (r22.mMatchConstraintDefaultWidth != 0) goto L88;
        if (r22.getDimensionRatio() != 0.0f) goto L88;
    L126:
        if (r22.isInHorizontalChain() == true) goto L88;
        if (r22.isInVirtualLayout() == true) goto L88;
        if (r111 == false) goto L88;
        if (r22.isInHorizontalChain() == true) goto L88;
        solveHorizontalMatchConstraint(r23, r18, r2, r22, r20);
    L135:
        if (r22.isMeasureRequested() == true) goto L88;
        if (r21 != r22.mLeft) goto L144;
        if (r22.mRight.mTarget != null) goto L144;
        int r24 = r22.mLeft.getMargin() + r8;
        r22.setFinalHorizontal(r24, r22.getWidth() + r24);
    L142:
        horizontalSolvingPass(r23, r22, r2, r20);
    L144:
        if (r21 != r22.mRight) goto L148;
        if (r22.mLeft.mTarget != null) goto L148;
        int r25 = r8 - r22.mRight.getMargin();
        r22.setFinalHorizontal(r25 - r22.getWidth(), r25);
    L148:
        if (r111 == false) goto L88;
        if (r22.isInHorizontalChain() == true) goto L88;
        solveHorizontalCenterConstraints(r23, r2, r22, r20);
    L100:
        if (r21 == r22.mRight) goto L102;
    L106:
        r111 = false;
        goto L108
    L102:
        if (r22.mLeft.mTarget == null) goto L106;
        if (r22.mLeft.mTarget.hasFinalValue() == false) goto L106;
    L8:
        if (r18.isMeasureRequested() == false) goto L12;
        int r26 = r17 + 1;
        if (canMeasure(r26, r18) == false) goto L12;
        ConstraintWidgetContainer.measure(r26, r18, r2, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }

    public static String ls(int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.append("  ");
        r1 = r1 + 1;
        goto L3
    L5:
        r0.append("+-(" + r3 + ") ");
        return r0.toString();
    }

    private static void solveBarrier(int r2, Barrier r3, BasicMeasure.Measurer r4, int r5, boolean r6) {
        BasicMeasure.Measurer r7 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r4, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        if (r3.allSolved() == false) goto L9;
        int r8 = r2 + 1;
        if (r5 != 0) goto L7;
        horizontalSolvingPass(r8, r3, r7, r6);
        return;
    L7:
        verticalSolvingPass(r8, r3, r7);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    public static boolean solveChain(ConstraintWidgetContainer r20, LinearSystem r21, int r22, int r23, ChainHead r24, boolean r25, boolean r26, boolean r27) {
        if (r27 == false) goto L5;
        return false;
    L5:
        if (r22 != 0) goto L10;
        if (r20.isResolvedHorizontally() == true) goto L12;
        return false;
    L12:
        boolean r1 = r20.isRtl();
        ConstraintWidget r2 = r24.getFirst();
        ConstraintWidget r3 = r24.getLast();
        ConstraintWidget r4 = r24.getFirstVisibleWidget();
        ConstraintWidget r5 = r24.getLastVisibleWidget();
        ConstraintWidget r6 = r24.getHead();
        ConstraintAnchor r7 = r2.mListAnchors[r23];
        int r8 = r23 + 1;
        ConstraintAnchor r9 = r3.mListAnchors[r8];
        if (r7.mTarget != null) goto L15;
    L119:
        return false;
    L15:
        if (r9.mTarget == null) goto L119;
        if (r7.mTarget.hasFinalValue() == false) goto L119;
        if (r9.mTarget.hasFinalValue() == false) goto L119;
        if (r4 == null) goto L119;
        if (r5 == null) goto L119;
        int r10 = r7.mTarget.getFinalValue() + r4.mListAnchors[r23].getMargin();
        int r11 = r9.mTarget.getFinalValue() - r5.mListAnchors[r8].getMargin();
        int r12 = r11 - r10;
        if (r12 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r13 = new BasicMeasure.Measure();
        boolean r14 = false;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        ConstraintWidget r18 = r2;
    L29:
        ConstraintWidget r19 = null;
        if (r14 == true) goto L60;
        if (canMeasure(1, r18) == false) goto L33;
        ConstraintWidget r110 = r2;
        if (r18.mListDimensionBehaviors[r22] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        if (r18.isMeasureRequested() == false) goto L41;
        ConstraintWidgetContainer.measure(1, r18, r20.getMeasurer(), r13, BasicMeasure.Measure.SELF_DIMENSIONS);
    L41:
        int r111 = r17 + r18.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L44;
        int r0 = r18.getWidth();
    L45:
        r17 = (r111 + r0) + r18.mListAnchors[r8].getMargin();
        r16 = r16 + 1;
        if (r18.getVisibility() == 8) goto L48;
        r15 = r15 + 1;
    L48:
        ConstraintAnchor r28 = r18.mListAnchors[r8].mTarget;
        if (r28 == null) goto L56;
        ConstraintWidget r29 = r28.mOwner;
        if (r29.mListAnchors[r23].mTarget == null) goto L56;
        if (r29.mListAnchors[r23].mTarget.mOwner != r18) goto L56;
        r19 = r29;
    L56:
        if (r19 == null) goto L58;
        r18 = r19;
        r14 = r14;
    L59:
        r2 = r110;
        goto L29
    L58:
        r14 = true;
        goto L59
    L44:
        r0 = r18.getHeight();
        goto L45
    L36:
        return false;
    L33:
        return false;
    L60:
        ConstraintWidget r112 = r2;
        if (r15 != 0) goto L63;
        return false;
    L63:
        if (r15 == r16) goto L65;
        return false;
    L65:
        if (r12 >= r17) goto L67;
        return false;
    L67:
        int r30 = r12 - r17;
        if (r25 == false) goto L71;
        r30 = r30 / (r15 + 1);
    L70:
        int r31 = 1;
    L74:
        if (r15 != r31) goto L84;
        if (r22 != 0) goto L77;
        float r32 = r6.getHorizontalBiasPercent();
    L78:
        int r33 = (int) ((r10 + 0.5f) + (r30 * r32));
        if (r22 != 0) goto L81;
        r4.setFinalHorizontal(r33, r4.getWidth() + r33);
    L82:
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        return true;
    L81:
        r4.setFinalVertical(r33, r4.getHeight() + r33);
        goto L82
    L77:
        r32 = r6.getVerticalBiasPercent();
        goto L78
    L84:
        if (r25 == false) goto L109;
        int r34 = r10 + r30;
        ConstraintWidget r35 = r112;
        boolean r36 = false;
        ?? r37 = r31;
    L86:
        if (r36 == true) goto L129;
        if (r35.getVisibility() != 8) goto L93;
        if (r22 != 0) goto L91;
        r35.setFinalHorizontal(r34, r34);
        horizontalSolvingPass(r37, r35, r20.getMeasurer(), r1);
    L98:
        r35.addToSolver(r21, false);
        ConstraintAnchor r38 = r35.mListAnchors[r8].mTarget;
        if (r38 == null) goto L104;
        ConstraintWidget r39 = r38.mOwner;
        if (r39.mListAnchors[r23].mTarget == null) goto L104;
        if (r39.mListAnchors[r23].mTarget.mOwner != r35) goto L104;
    L105:
        if (r39 == null) goto L107;
        r35 = r39;
    L108:
        r37 = 1;
        goto L86
    L107:
        r36 = true;
    L104:
        r39 = null;
        goto L105
    L91:
        r35.setFinalVertical(r34, r34);
        verticalSolvingPass(r37, r35, r20.getMeasurer());
        goto L98
    L93:
        int r40 = r34 + r35.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L96;
        r35.setFinalHorizontal(r40, r35.getWidth() + r40);
        horizontalSolvingPass(1, r35, r20.getMeasurer(), r1);
        int r41 = r35.getWidth();
    L97:
        r34 = ((r40 + r41) + r35.mListAnchors[r8].getMargin()) + r30;
        goto L98
    L96:
        r35.setFinalVertical(r40, r35.getHeight() + r40);
        verticalSolvingPass(1, r35, r20.getMeasurer());
        r41 = r35.getHeight();
        goto L97
    L129:
        return r37;
    L109:
        if (r26 == false) goto L117;
        if (r15 != 2) goto L115;
        if (r22 != 0) goto L113;
        r4.setFinalHorizontal(r10, r4.getWidth() + r10);
        r5.setFinalHorizontal(r11 - r5.getWidth(), r11);
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        horizontalSolvingPass(1, r5, r20.getMeasurer(), r1);
        return true;
    L113:
        r4.setFinalVertical(r10, r4.getHeight() + r10);
        r5.setFinalVertical(r11 - r5.getHeight(), r11);
        verticalSolvingPass(1, r4, r20.getMeasurer());
        verticalSolvingPass(1, r5, r20.getMeasurer());
        return true;
    L115:
        return false;
    L117:
        return true;
    L71:
        if (r26 == false) goto L70;
        if (r15 <= 2) goto L70;
        r31 = 1;
        r30 = (r30 / r15) - 1;
        goto L74
    L10:
        if (r20.isResolvedVertically() == true) goto L12;
        return false;
    }

    private static void solveHorizontalCenterConstraints(int r6, BasicMeasure.Measurer r7, ConstraintWidget r8, boolean r9) {
        BasicMeasure.Measurer r10 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r7, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        float r0 = r8.getHorizontalBiasPercent();
        int r1 = r8.mLeft.mTarget.getFinalValue();
        int r2 = r8.mRight.mTarget.getFinalValue();
        int r3 = r8.mLeft.getMargin() + r1;
        int r4 = r2 - r8.mRight.getMargin();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.getWidth();
        int r11 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r11 = (r1 - r2) - r5;
    L9:
        if (r11 <= 0) goto L11;
        float r12 = (r0 * r11) + 0.5f;
    L12:
        int r13 = ((int) r12) + r1;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r14 = r13 - r5;
    L15:
        r8.setFinalHorizontal(r13, r14);
        horizontalSolvingPass(r6 + 1, r8, r10, r9);
        return;
    L11:
        r12 = r0 * r11;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void solveHorizontalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10, boolean r11) {
        BasicMeasure.Measurer r12 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r9, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        float r0 = r10.getHorizontalBiasPercent();
        int r1 = r10.mLeft.mTarget.getFinalValue() + r10.mLeft.getMargin();
        int r2 = r10.mRight.mTarget.getFinalValue() - r10.mRight.getMargin();
        if (r2 < r1) goto L21;
        int r3 = r10.getWidth();
        if (r10.getVisibility() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalHorizontal(r4, r3 + r4);
        horizontalSolvingPass(r7 + 1, r10, r12, r11);
        return;
    L7:
        if (r10.mMatchConstraintDefaultWidth != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, ConstraintWidgetContainer.class) == true) goto L12;
        r8 = r8.getParent();
    L12:
        r3 = (int) ((r10.getHorizontalBiasPercent() * 0.5f) * r8.getWidth());
    L16:
        r3 = Math.max(r10.mMatchConstraintMinWidth, r3);
        if (r10.mMatchConstraintMaxWidth <= 0) goto L19;
        r3 = Math.min(r10.mMatchConstraintMaxWidth, r3);
        goto L19
    L14:
        if (r10.mMatchConstraintDefaultWidth != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static void solveVerticalCenterConstraints(int r6, BasicMeasure.Measurer r7, ConstraintWidget r8) {
        BasicMeasure.Measurer r9 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r7, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        float r0 = r8.getVerticalBiasPercent();
        int r1 = r8.mTop.mTarget.getFinalValue();
        int r2 = r8.mBottom.mTarget.getFinalValue();
        int r3 = r8.mTop.getMargin() + r1;
        int r4 = r2 - r8.mBottom.getMargin();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.getHeight();
        int r10 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r10 = (r1 - r2) - r5;
    L9:
        if (r10 <= 0) goto L11;
        float r11 = (r0 * r10) + 0.5f;
    L12:
        int r12 = (int) r11;
        int r13 = r1 + r12;
        int r14 = r13 + r5;
        if (r1 <= r2) goto L15;
        r13 = r1 - r12;
        r14 = r13 - r5;
    L15:
        r8.setFinalVertical(r13, r14);
        verticalSolvingPass(r6 + 1, r8, r9);
        return;
    L11:
        r11 = r0 * r10;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void solveVerticalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10) {
        BasicMeasure.Measurer r11 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r9, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        float r0 = r10.getVerticalBiasPercent();
        int r1 = r10.mTop.mTarget.getFinalValue() + r10.mTop.getMargin();
        int r2 = r10.mBottom.mTarget.getFinalValue() - r10.mBottom.getMargin();
        if (r2 < r1) goto L21;
        int r3 = r10.getHeight();
        if (r10.getVisibility() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalVertical(r4, r3 + r4);
        verticalSolvingPass(r7 + 1, r10, r11);
        return;
    L7:
        if (r10.mMatchConstraintDefaultHeight != 2) goto L14;
        if (ZeusTransformUtils.instanceOf(r8, ConstraintWidgetContainer.class) == true) goto L12;
        r8 = r8.getParent();
    L12:
        r3 = (int) ((r0 * 0.5f) * r8.getHeight());
    L16:
        r3 = Math.max(r10.mMatchConstraintMinHeight, r3);
        if (r10.mMatchConstraintMaxHeight <= 0) goto L19;
        r3 = Math.min(r10.mMatchConstraintMaxHeight, r3);
        goto L19
    L14:
        if (r10.mMatchConstraintDefaultHeight != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    public static void solvingPass(ConstraintWidgetContainer r14, BasicMeasure.Measurer r15) {
        BasicMeasure.Measurer r16 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r15, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        ConstraintWidget.DimensionBehaviour r0 = r14.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r2 = r14.getVerticalDimensionBehaviour();
        hcount = 0;
        vcount = 0;
        r14.resetFinalResolution();
        ArrayList<ConstraintWidget> r4 = r14.getChildren();
        int r5 = r4.size();
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin")).resetFinalResolution();
        r6 = r6 + 1;
        goto L3
    L5:
        boolean r7 = r14.isRtl();
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r14.setFinalHorizontal(0, r14.getWidth());
    L9:
        int r1 = 0;
        boolean r8 = false;
        boolean r9 = false;
    L11:
        if (r1 >= r5) goto L35;
        ConstraintWidget r12 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r12, Guideline.class) == false) goto L30;
        Guideline r13 = (Guideline) ZeusTransformUtils.preCheckCast(r12, Guideline.class, "com.obric.memorydata.plugin");
        if (r13.getOrientation() != 1) goto L34;
        if (r13.getRelativeBegin() == (-1)) goto L21;
        int r10 = r13.getRelativeBegin();
    L19:
        r13.setFinalValue(r10);
    L28:
        r8 = true;
        goto L34
    L21:
        if (r13.getRelativeEnd() == (-1)) goto L26;
        if (r14.isResolvedHorizontally() == false) goto L26;
        r10 = r14.getWidth() - r13.getRelativeEnd();
    L26:
        if (r14.isResolvedHorizontally() == false) goto L28;
        r10 = (int) ((r13.getRelativePercent() * r14.getWidth()) + 0.5f);
    L34:
        r1 = r1 + 1;
        goto L11
    L30:
        if (ZeusTransformUtils.instanceOf(r12, Barrier.class) == false) goto L34;
        if (((Barrier) ZeusTransformUtils.preCheckCast(r12, Barrier.class, "com.obric.memorydata.plugin")).getOrientation() != 0) goto L34;
        r9 = true;
        goto L34
    L35:
        if (r8 == false) goto L44;
        int r3 = 0;
    L37:
        if (r3 >= r5) goto L44;
        ConstraintWidget r11 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Guideline.class) == false) goto L43;
        Guideline r17 = (Guideline) ZeusTransformUtils.preCheckCast(r11, Guideline.class, "com.obric.memorydata.plugin");
        if (r17.getOrientation() != 1) goto L43;
        horizontalSolvingPass(0, r17, r16, r7);
    L43:
        r3 = r3 + 1;
    L44:
        horizontalSolvingPass(0, r14, r16, r7);
        if (r9 == false) goto L55;
        int r18 = 0;
    L47:
        if (r18 >= r5) goto L55;
        ConstraintWidget r19 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r18), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Barrier.class) == false) goto L53;
        Barrier r20 = (Barrier) ZeusTransformUtils.preCheckCast(r19, Barrier.class, "com.obric.memorydata.plugin");
        if (r20.getOrientation() != 0) goto L53;
        solveBarrier(0, r20, r16, 0, r7);
    L53:
        r18 = r18 + 1;
    L55:
        if (r2 != ConstraintWidget.DimensionBehaviour.FIXED) goto L57;
        r14.setFinalVertical(0, r14.getHeight());
    L58:
        int r21 = 0;
        boolean r22 = false;
        boolean r23 = false;
    L59:
        if (r21 >= r5) goto L83;
        ConstraintWidget r24 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r21), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r24, Guideline.class) == false) goto L78;
        Guideline r25 = (Guideline) ZeusTransformUtils.preCheckCast(r24, Guideline.class, "com.obric.memorydata.plugin");
        if (r25.getOrientation() != 0) goto L82;
        if (r25.getRelativeBegin() == (-1)) goto L69;
        int r26 = r25.getRelativeBegin();
    L67:
        r25.setFinalValue(r26);
    L76:
        r22 = true;
        goto L82
    L69:
        if (r25.getRelativeEnd() == (-1)) goto L74;
        if (r14.isResolvedVertically() == false) goto L74;
        r26 = r14.getHeight() - r25.getRelativeEnd();
    L74:
        if (r14.isResolvedVertically() == false) goto L76;
        r26 = (int) ((r25.getRelativePercent() * r14.getHeight()) + 0.5f);
    L82:
        r21 = r21 + 1;
        goto L59
    L78:
        if (ZeusTransformUtils.instanceOf(r24, Barrier.class) == false) goto L82;
        if (((Barrier) ZeusTransformUtils.preCheckCast(r24, Barrier.class, "com.obric.memorydata.plugin")).getOrientation() != 1) goto L82;
        r23 = true;
        goto L82
    L83:
        if (r22 == false) goto L92;
        int r27 = 0;
    L85:
        if (r27 >= r5) goto L92;
        ConstraintWidget r28 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r27), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r28, Guideline.class) == false) goto L91;
        Guideline r29 = (Guideline) ZeusTransformUtils.preCheckCast(r28, Guideline.class, "com.obric.memorydata.plugin");
        if (r29.getOrientation() != 0) goto L91;
        verticalSolvingPass(1, r29, r16);
    L91:
        r27 = r27 + 1;
    L92:
        verticalSolvingPass(0, r14, r16);
        if (r23 == false) goto L102;
        int r110 = 0;
    L95:
        if (r110 >= r5) goto L102;
        ConstraintWidget r30 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r110), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r30, Barrier.class) == false) goto L101;
        Barrier r31 = (Barrier) ZeusTransformUtils.preCheckCast(r30, Barrier.class, "com.obric.memorydata.plugin");
        if (r31.getOrientation() != 1) goto L101;
        solveBarrier(0, r31, r16, 1, r7);
    L101:
        r110 = r110 + 1;
    L102:
        int r111 = 0;
    L103:
        if (r111 >= r5) goto L117;
        ConstraintWidget r32 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r4.get(r111), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r32.isMeasureRequested() == false) goto L116;
        if (canMeasure(0, r32) == false) goto L116;
        ConstraintWidgetContainer.measure(0, r32, r16, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        if (ZeusTransformUtils.instanceOf(r32, Guideline.class) == true) goto L111;
        horizontalSolvingPass(0, r32, r16, r7);
    L115:
        verticalSolvingPass(0, r32, r16);
        goto L116
    L111:
        if (((Guideline) ZeusTransformUtils.preCheckCast(r32, Guideline.class, "com.obric.memorydata.plugin")).getOrientation() == 0) goto L115;
        horizontalSolvingPass(0, r32, r16, r7);
    L116:
        r111 = r111 + 1;
        goto L103
    L117:
        return;
    L57:
        r14.setFinalTop(0);
        goto L58
    L8:
        r14.setFinalLeft(0);
        goto L9
    }

    private static void verticalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18) {
        BasicMeasure.Measurer r1 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r18, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        if (r17.isVerticalSolvingPassDone() == false) goto L5;
        return;
    L5:
        boolean r4 = true;
        vcount++;
        if (ZeusTransformUtils.instanceOf(r17, ConstraintWidgetContainer.class) == false) goto L8;
    L12:
        ConstraintAnchor r3 = r17.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r5 = r17.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r6 = r3.getFinalValue();
        int r7 = r5.getFinalValue();
        if (r3.getDependents() == null) goto L80;
        if (r3.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r8 = r3.getDependents().iterator();
    L18:
        if (r8.hasNext() == false) goto L80;
        ConstraintAnchor r9 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r8.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r12 = r9.mOwner;
        int r13 = r16 + 1;
        boolean r14 = canMeasure(r13, r12);
        if (r12.isMeasureRequested() == false) goto L24;
        if (r14 == false) goto L24;
        ConstraintWidgetContainer.measure(r13, r12, r1, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r9 != r12.mTop) goto L30;
        if (r12.mBottom.mTarget == null) goto L30;
        if (r12.mBottom.mTarget.hasFinalValue() == false) goto L30;
    L35:
        boolean r11 = r4;
    L38:
        if (r12.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r14 == true) goto L62;
        if (r12.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
        if (r12.mMatchConstraintMaxHeight < 0) goto L63;
        if (r12.mMatchConstraintMinHeight < 0) goto L63;
        if (r12.getVisibility() == 8) goto L54;
        if (r12.mMatchConstraintDefaultHeight != 0) goto L63;
        if (r12.getDimensionRatio() != 0.0f) goto L63;
    L54:
        if (r12.isInVerticalChain() == true) goto L63;
        if (r12.isInVirtualLayout() == true) goto L63;
        if (r11 == false) goto L63;
        if (r12.isInVerticalChain() == true) goto L63;
        solveVerticalMatchConstraint(r13, r17, r1, r12);
    L63:
        r4 = true;
    L62:
        if (r12.isMeasureRequested() == true) goto L63;
        if (r9 != r12.mTop) goto L71;
        if (r12.mBottom.mTarget != null) goto L71;
        int r10 = r12.mTop.getMargin() + r6;
        r12.setFinalVertical(r10, r12.getHeight() + r10);
    L69:
        verticalSolvingPass(r13, r12, r1);
    L71:
        if (r9 == r12.mBottom) goto L73;
    L75:
        if (r11 == false) goto L63;
        if (r12.isInVerticalChain() == true) goto L63;
        solveVerticalCenterConstraints(r13, r1, r12);
        goto L63
    L73:
        if (r12.mTop.mTarget != null) goto L75;
        int r15 = r6 - r12.mBottom.getMargin();
        r12.setFinalVertical(r15 - r12.getHeight(), r15);
    L30:
        if (r9 == r12.mBottom) goto L32;
    L36:
        r11 = false;
        goto L38
    L32:
        if (r12.mTop.mTarget == null) goto L36;
        if (r12.mTop.mTarget.hasFinalValue() == false) goto L36;
    L80:
        if (ZeusTransformUtils.instanceOf(r17, Guideline.class) == false) goto L83;
        return;
    L83:
        if (r5.getDependents() != null) goto L85;
    L149:
        ConstraintAnchor r19 = r17.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r19.getDependents() != null) goto L152;
    L169:
        r17.markVerticalSolvingPassDone();
        return;
    L152:
        if (r19.hasFinalValue() == false) goto L169;
        int r20 = r19.getFinalValue();
        Iterator<ConstraintAnchor> r21 = r19.getDependents().iterator();
    L155:
        if (r21.hasNext() == false) goto L169;
        ConstraintAnchor r22 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r21.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r23 = r22.mOwner;
        int r24 = r16 + 1;
        boolean r25 = canMeasure(r24, r23);
        if (r23.isMeasureRequested() == false) goto L161;
        if (r25 == false) goto L161;
        ConstraintWidgetContainer.measure(r24, r23, r1, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L161:
        if (r23.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L164;
        if (r25 == false) goto L155;
    L164:
        if (r23.isMeasureRequested() == true) goto L155;
        if (r22 != r23.mBaseline) goto L155;
        r23.setFinalBaseline(r22.getMargin() + r20);
        verticalSolvingPass(r24, r23, r1);
        goto L155
    L85:
        if (r5.hasFinalValue() == false) goto L149;
        Iterator<ConstraintAnchor> r26 = r5.getDependents().iterator();
    L88:
        if (r26.hasNext() == false) goto L149;
        ConstraintAnchor r27 = (ConstraintAnchor) ZeusTransformUtils.preCheckCast(r26.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin");
        ConstraintWidget r28 = r27.mOwner;
        int r29 = r16 + 1;
        boolean r30 = canMeasure(r29, r28);
        if (r28.isMeasureRequested() == false) goto L94;
        if (r30 == false) goto L94;
        ConstraintWidgetContainer.measure(r29, r28, r1, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r27 != r28.mTop) goto L100;
        if (r28.mBottom.mTarget == null) goto L100;
        if (r28.mBottom.mTarget.hasFinalValue() == false) goto L100;
    L105:
        boolean r110 = true;
    L108:
        if (r28.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L132;
        if (r30 == true) goto L132;
        if (r28.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L88;
        if (r28.mMatchConstraintMaxHeight < 0) goto L88;
        if (r28.mMatchConstraintMinHeight < 0) goto L88;
        if (r28.getVisibility() == 8) goto L124;
        if (r28.mMatchConstraintDefaultHeight != 0) goto L88;
        if (r28.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r28.isInVerticalChain() == true) goto L88;
        if (r28.isInVirtualLayout() == true) goto L88;
        if (r110 == false) goto L88;
        if (r28.isInVerticalChain() == true) goto L88;
        solveVerticalMatchConstraint(r29, r17, r1, r28);
    L132:
        if (r28.isMeasureRequested() == true) goto L88;
        if (r27 != r28.mTop) goto L141;
        if (r28.mBottom.mTarget != null) goto L141;
        int r31 = r28.mTop.getMargin() + r7;
        r28.setFinalVertical(r31, r28.getHeight() + r31);
    L139:
        verticalSolvingPass(r29, r28, r1);
    L141:
        if (r27 != r28.mBottom) goto L145;
        if (r28.mTop.mTarget != null) goto L145;
        int r32 = r7 - r28.mBottom.getMargin();
        r28.setFinalVertical(r32 - r28.getHeight(), r32);
    L145:
        if (r110 == false) goto L88;
        if (r28.isInVerticalChain() == true) goto L88;
        solveVerticalCenterConstraints(r29, r1, r28);
    L100:
        if (r27 == r28.mBottom) goto L102;
    L106:
        r110 = false;
        goto L108
    L102:
        if (r28.mTop.mTarget == null) goto L106;
        if (r28.mTop.mTarget.hasFinalValue() == false) goto L106;
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r33 = r16 + 1;
        if (canMeasure(r33, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r33, r17, r1, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }
}
