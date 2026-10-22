package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static BasicMeasure.Measure measure;

    static {
        measure = new BasicMeasure.Measure();
    }

    public Direct() {
    }

    private static boolean canMeasure(ConstraintWidget r10) {
        ConstraintWidget.DimensionBehaviour r5 = r10.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r11 = r10.getVerticalDimensionBehaviour();
        if (r10.getParent() == null) goto L5;
        ConstraintWidgetContainer r12 = (ConstraintWidgetContainer) r10.getParent();
    L6:
        if (r12 == null) goto L8;
        r12.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r13 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r12 == null) goto L10;
        r12.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r5 != r15) goto L13;
    L26:
        boolean r16 = true;
    L27:
        if (r11 != r15) goto L29;
    L42:
        boolean r17 = true;
    L44:
        if (r10.mDimensionRatio <= 0.0f) goto L48;
        if (r16 == true) goto L47;
        if (r17 == false) goto L48;
    L47:
        return true;
    L48:
        if (r16 == false) goto L52;
        if (r17 == true) goto L51;
        return false;
    L51:
        return true;
    L52:
        return false;
    L29:
        if (r11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L42;
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        if (r10.mMatchConstraintDefaultHeight != 0) goto L39;
        if (r10.mDimensionRatio != 0.0f) goto L39;
        if (r10.hasDanglingDimension(1) == true) goto L42;
    L39:
        if (r10.isResolvedVertically() == true) goto L42;
        r17 = false;
        goto L44
    L13:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L26;
        if (r5 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L23;
        if (r10.mMatchConstraintDefaultWidth != 0) goto L23;
        if (r10.mDimensionRatio != 0.0f) goto L23;
        if (r10.hasDanglingDimension(0) == true) goto L26;
    L23:
        if (r10.isResolvedHorizontally() == true) goto L26;
        r16 = false;
        goto L27
    L5:
        r12 = null;
        goto L6
    }

    private static void horizontalSolvingPass(ConstraintWidget r11, BasicMeasure.Measurer r12, boolean r13) {
        if ((r11 instanceof ConstraintWidgetContainer) == false) goto L5;
    L9:
        ConstraintAnchor r5 = r11.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r10 = r11.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r14 = r5.getFinalValue();
        int r15 = r10.getFinalValue();
        if (r5.getDependents() == null) goto L77;
        if (r5.hasFinalValue() == false) goto L77;
        Iterator<ConstraintAnchor> r16 = r5.getDependents().iterator();
    L15:
        if (r16.hasNext() == false) goto L77;
        ConstraintAnchor r17 = r16.next();
        ConstraintWidget r18 = r17.mOwner;
        boolean r19 = canMeasure(r18);
        if (r18.isMeasureRequested() == false) goto L20;
        if (r19 == false) goto L20;
        ConstraintWidgetContainer.measure(r18, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        ConstraintWidget.DimensionBehaviour r20 = r18.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r20 != r110) goto L56;
        if (r19 == true) goto L56;
        if (r18.getHorizontalDimensionBehaviour() != r110) goto L15;
        if (r18.mMatchConstraintMaxWidth < 0) goto L15;
        if (r18.mMatchConstraintMinWidth < 0) goto L15;
        if (r18.getVisibility() == 8) goto L37;
        if (r18.mMatchConstraintDefaultWidth != 0) goto L15;
        if (r18.getDimensionRatio() != 0.0f) goto L15;
    L37:
        if (r18.isInHorizontalChain() == true) goto L15;
        if (r18.isInVirtualLayout() == true) goto L15;
        if (r17 != r18.mLeft) goto L47;
        ConstraintAnchor r21 = r18.mRight.mTarget;
        if (r21 == null) goto L47;
        if (r21.hasFinalValue() == false) goto L47;
    L53:
        if (r18.isInHorizontalChain() == true) goto L15;
        solveHorizontalMatchConstraint(r11, r12, r18, r13);
    L47:
        if (r17 != r18.mRight) goto L15;
        ConstraintAnchor r22 = r18.mLeft.mTarget;
        if (r22 == null) goto L15;
        if (r22.hasFinalValue() == false) goto L15;
    L56:
        if (r18.isMeasureRequested() == true) goto L15;
        ConstraintAnchor r23 = r18.mLeft;
        if (r17 != r23) goto L63;
        if (r18.mRight.mTarget != null) goto L63;
        int r24 = r23.getMargin() + r14;
        r18.setFinalHorizontal(r24, r18.getWidth() + r24);
        horizontalSolvingPass(r18, r12, r13);
    L63:
        ConstraintAnchor r25 = r18.mRight;
        if (r17 != r25) goto L68;
        if (r23.mTarget != null) goto L68;
        int r26 = r14 - r25.getMargin();
        r18.setFinalHorizontal(r26 - r18.getWidth(), r26);
        horizontalSolvingPass(r18, r12, r13);
    L68:
        if (r17 != r23) goto L15;
        ConstraintAnchor r27 = r25.mTarget;
        if (r27 == null) goto L15;
        if (r27.hasFinalValue() == false) goto L15;
        if (r18.isInHorizontalChain() == true) goto L15;
        solveHorizontalCenterConstraints(r12, r18, r13);
    L77:
        if ((r11 instanceof Guideline) == false) goto L80;
        return;
    L80:
        if (r10.getDependents() != null) goto L82;
        return;
    L82:
        if (r10.hasFinalValue() == false) goto L235;
        Iterator<ConstraintAnchor> r28 = r10.getDependents().iterator();
    L85:
        if (r28.hasNext() == false) goto L236;
        ConstraintAnchor r29 = r28.next();
        ConstraintWidget r30 = r29.mOwner;
        boolean r31 = canMeasure(r30);
        if (r30.isMeasureRequested() == false) goto L91;
        if (r31 == false) goto L91;
        ConstraintWidgetContainer.measure(r30, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L91:
        if (r29 != r30.mLeft) goto L97;
        ConstraintAnchor r32 = r30.mRight.mTarget;
        if (r32 == null) goto L97;
        if (r32.hasFinalValue() == false) goto L97;
    L102:
        boolean r33 = true;
    L104:
        ConstraintWidget.DimensionBehaviour r34 = r30.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r35 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r34 != r35) goto L129;
        if (r31 == true) goto L129;
        if (r30.getHorizontalDimensionBehaviour() != r35) goto L85;
        if (r30.mMatchConstraintMaxWidth < 0) goto L85;
        if (r30.mMatchConstraintMinWidth < 0) goto L85;
        if (r30.getVisibility() == 8) goto L121;
        if (r30.mMatchConstraintDefaultWidth != 0) goto L85;
        if (r30.getDimensionRatio() != 0.0f) goto L85;
    L121:
        if (r30.isInHorizontalChain() == true) goto L85;
        if (r30.isInVirtualLayout() == true) goto L85;
        if (r33 == false) goto L85;
        if (r30.isInHorizontalChain() == true) goto L85;
        solveHorizontalMatchConstraint(r11, r12, r30, r13);
    L129:
        if (r30.isMeasureRequested() == true) goto L85;
        ConstraintAnchor r36 = r30.mLeft;
        if (r29 != r36) goto L136;
        if (r30.mRight.mTarget != null) goto L136;
        int r37 = r36.getMargin() + r15;
        r30.setFinalHorizontal(r37, r30.getWidth() + r37);
        horizontalSolvingPass(r30, r12, r13);
    L136:
        ConstraintAnchor r38 = r30.mRight;
        if (r29 != r38) goto L141;
        if (r36.mTarget != null) goto L141;
        int r39 = r15 - r38.getMargin();
        r30.setFinalHorizontal(r39 - r30.getWidth(), r39);
        horizontalSolvingPass(r30, r12, r13);
    L141:
        if (r33 == false) goto L85;
        if (r30.isInHorizontalChain() == true) goto L85;
        solveHorizontalCenterConstraints(r12, r30, r13);
    L97:
        if (r29 != r30.mRight) goto L103;
        ConstraintAnchor r40 = r30.mLeft.mTarget;
        if (r40 == null) goto L103;
        if (r40.hasFinalValue() == true) goto L102;
    L103:
        r33 = false;
        goto L104
    L236:
        return;
    L235:
        return;
    L5:
        if (r11.isMeasureRequested() == false) goto L9;
        if (canMeasure(r11) == false) goto L9;
        ConstraintWidgetContainer.measure(r11, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L9
    }

    private static void solveBarrier(Barrier r5, BasicMeasure.Measurer r10, int r11, boolean r12) {
        if (r5.allSolved() == false) goto L8;
        if (r11 != 0) goto L6;
        horizontalSolvingPass(r5, r10, r12);
        return;
    L6:
        verticalSolvingPass(r5, r10);
        return;
    }

    public static boolean solveChain(ConstraintWidgetContainer r18, LinearSystem r19, int r20, int r21, ChainHead r22, boolean r23, boolean r24, boolean r25) {
        if (r25 == false) goto L5;
        return false;
    L5:
        if (r20 != 0) goto L10;
        if (r18.isResolvedHorizontally() == true) goto L12;
        return false;
    L12:
        boolean r5 = r18.isRtl();
        ConstraintWidget r10 = r22.getFirst();
        ConstraintWidget r11 = r22.getLast();
        ConstraintWidget r12 = r22.getFirstVisibleWidget();
        ConstraintWidget r13 = r22.getLastVisibleWidget();
        ConstraintWidget r14 = r22.getHead();
        ConstraintAnchor r15 = r10.mListAnchors[r21];
        int r16 = r21 + 1;
        ConstraintAnchor r17 = r11.mListAnchors[r16];
        ConstraintAnchor r26 = r15.mTarget;
        if (r26 != null) goto L15;
        return false;
    L15:
        if (r17.mTarget != null) goto L18;
        return false;
    L18:
        if (r26.hasFinalValue() == true) goto L20;
        return false;
    L20:
        if (r17.mTarget.hasFinalValue() == false) goto L139;
        if (r12 == null) goto L136;
        if (r13 == null) goto L140;
        int r27 = r12.mListAnchors[r21].getMargin() + r15.mTarget.getFinalValue();
        int r28 = r17.mTarget.getFinalValue() - r13.mListAnchors[r16].getMargin();
        int r29 = r28 - r27;
        if (r29 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r110 = new BasicMeasure.Measure();
        boolean r111 = false;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        ConstraintWidget r115 = r10;
    L29:
        ConstraintWidget r116 = null;
        if (r111 == true) goto L62;
        ConstraintAnchor r30 = r115.mListAnchors[r21];
        if (canMeasure(r115) == false) goto L33;
        ConstraintWidget r117 = r10;
        if (r115.mListDimensionBehaviors[r20] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        if (r115.isMeasureRequested() == false) goto L42;
        ConstraintWidgetContainer.measure(r115, r18.getMeasurer(), r110, BasicMeasure.Measure.SELF_DIMENSIONS);
    L42:
        int r31 = r115.mListAnchors[r21].getMargin() + r114;
        if (r20 != 0) goto L46;
        int r32 = r115.getWidth();
    L47:
        r114 = r115.mListAnchors[r16].getMargin() + (r32 + r31);
        r113 = r113 + 1;
        if (r115.getVisibility() == 8) goto L50;
        r112 = r112 + 1;
    L50:
        ConstraintAnchor r33 = r115.mListAnchors[r16].mTarget;
        if (r33 == null) goto L58;
        ConstraintWidget r34 = r33.mOwner;
        ConstraintAnchor r35 = r34.mListAnchors[r21].mTarget;
        if (r35 == null) goto L58;
        if (r35.mOwner != r115) goto L58;
        r116 = r34;
    L58:
        if (r116 == null) goto L60;
        r115 = r116;
    L61:
        r10 = r117;
        goto L29
    L60:
        r111 = true;
        goto L61
    L46:
        r32 = r115.getHeight();
        goto L47
    L37:
        return false;
    L33:
        return false;
    L62:
        ConstraintWidget r118 = r10;
        if (r112 != 0) goto L67;
        return false;
    L67:
        if (r112 == r113) goto L69;
        return false;
    L69:
        if (r29 >= r114) goto L71;
        return false;
    L71:
        int r36 = r29 - r114;
        if (r23 == false) goto L75;
        r36 = r36 / (r112 + 1);
    L74:
        int r37 = 1;
    L78:
        if (r112 != r37) goto L88;
        if (r20 != 0) goto L81;
        float r38 = r14.getHorizontalBiasPercent();
    L82:
        int r39 = (int) ((r36 * r38) + (r27 + 0.5f));
        if (r20 != 0) goto L85;
        r12.setFinalHorizontal(r39, r12.getWidth() + r39);
    L86:
        horizontalSolvingPass(r12, r18.getMeasurer(), r5);
        return true;
    L85:
        r12.setFinalVertical(r39, r12.getHeight() + r39);
        goto L86
    L81:
        r38 = r14.getVerticalBiasPercent();
        goto L82
    L88:
        if (r23 == false) goto L114;
        int r40 = r27 + r36;
        ConstraintWidget r41 = r118;
        boolean r42 = false;
    L90:
        if (r42 == true) goto L113;
        ConstraintAnchor r43 = r41.mListAnchors[r21];
        if (r41.getVisibility() != 8) goto L97;
        if (r20 != 0) goto L95;
        r41.setFinalHorizontal(r40, r40);
        horizontalSolvingPass(r41, r18.getMeasurer(), r5);
    L96:
        boolean r44 = false;
    L103:
        r41.addToSolver(r19, r44);
        ConstraintAnchor r45 = r41.mListAnchors[r16].mTarget;
        if (r45 == null) goto L109;
        ConstraintWidget r46 = r45.mOwner;
        ConstraintAnchor r47 = r46.mListAnchors[r21].mTarget;
        if (r47 == null) goto L109;
        if (r47.mOwner != r41) goto L109;
    L110:
        if (r46 != null) goto L111;
        r42 = true;
        goto L90
    L111:
        r41 = r46;
    L109:
        r46 = null;
        goto L110
    L95:
        r41.setFinalVertical(r40, r40);
        verticalSolvingPass(r41, r18.getMeasurer());
        goto L96
    L97:
        int r48 = r41.mListAnchors[r21].getMargin() + r40;
        if (r20 != 0) goto L101;
        r41.setFinalHorizontal(r48, r41.getWidth() + r48);
        horizontalSolvingPass(r41, r18.getMeasurer(), r5);
        int r49 = r41.getWidth();
    L102:
        r40 = (r41.mListAnchors[r16].getMargin() + (r49 + r48)) + r36;
        r44 = false;
        goto L103
    L101:
        r41.setFinalVertical(r48, r41.getHeight() + r48);
        verticalSolvingPass(r41, r18.getMeasurer());
        r49 = r41.getHeight();
    L113:
        return true;
    L114:
        if (r24 == false) goto L113;
        if (r112 != 2) goto L121;
        if (r20 != 0) goto L119;
        r12.setFinalHorizontal(r27, r12.getWidth() + r27);
        r13.setFinalHorizontal(r28 - r13.getWidth(), r28);
        horizontalSolvingPass(r12, r18.getMeasurer(), r5);
        horizontalSolvingPass(r13, r18.getMeasurer(), r5);
        return true;
    L119:
        r12.setFinalVertical(r27, r12.getHeight() + r27);
        r13.setFinalVertical(r28 - r13.getHeight(), r28);
        verticalSolvingPass(r12, r18.getMeasurer());
        verticalSolvingPass(r13, r18.getMeasurer());
        return true;
    L121:
        return false;
    L75:
        if (r24 == false) goto L74;
        if (r112 <= 2) goto L74;
        r37 = 1;
        r36 = (r36 / r112) - 1;
        goto L78
    L140:
        return false;
    L136:
        return false;
    L139:
        return false;
    L10:
        if (r18.isResolvedVertically() == true) goto L12;
        return false;
    }

    private static void solveHorizontalCenterConstraints(BasicMeasure.Measurer r10, ConstraintWidget r11, boolean r12) {
        float r5 = r11.getHorizontalBiasPercent();
        int r13 = r11.mLeft.mTarget.getFinalValue();
        int r14 = r11.mRight.mTarget.getFinalValue();
        int r15 = r11.mLeft.getMargin() + r13;
        int r16 = r14 - r11.mRight.getMargin();
        if (r13 != r14) goto L5;
        r5 = 0.5f;
    L6:
        int r17 = r11.getWidth();
        int r18 = (r14 - r13) - r17;
        if (r13 <= r14) goto L9;
        r18 = (r13 - r14) - r17;
    L9:
        int r19 = ((int) ((r5 * r18) + 0.5f)) + r13;
        int r20 = r19 + r17;
        if (r13 <= r14) goto L12;
        r20 = r19 - r17;
    L12:
        r11.setFinalHorizontal(r19, r20);
        horizontalSolvingPass(r11, r10, r12);
        return;
    L5:
        r13 = r15;
        r14 = r16;
        goto L6
    }

    private static void solveHorizontalMatchConstraint(ConstraintWidget r10, BasicMeasure.Measurer r11, ConstraintWidget r12, boolean r13) {
        float r5 = r12.getHorizontalBiasPercent();
        int r14 = r12.mLeft.getMargin() + r12.mLeft.mTarget.getFinalValue();
        int r15 = r12.mRight.mTarget.getFinalValue() - r12.mRight.getMargin();
        if (r15 < r14) goto L20;
        int r16 = r12.getWidth();
        if (r12.getVisibility() == 8) goto L18;
        int r17 = r12.mMatchConstraintDefaultWidth;
        if (r17 == 2) goto L9;
        if (r17 != 0) goto L15;
        r16 = r15 - r14;
    L15:
        r16 = Math.max(r12.mMatchConstraintMinWidth, r16);
        int r18 = r12.mMatchConstraintMaxWidth;
        if (r18 <= 0) goto L18;
        r16 = Math.min(r18, r16);
        goto L18
    L9:
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r19 = r10.getWidth();
    L12:
        r16 = (int) ((r12.getHorizontalBiasPercent() * 0.5f) * r19);
        goto L15
    L11:
        r19 = r10.getParent().getWidth();
    L18:
        int r20 = r14 + ((int) ((r5 * ((r15 - r14) - r16)) + 0.5f));
        r12.setFinalHorizontal(r20, r16 + r20);
        horizontalSolvingPass(r12, r11, r13);
        return;
    }

    private static void solveVerticalCenterConstraints(BasicMeasure.Measurer r10, ConstraintWidget r11) {
        float r5 = r11.getVerticalBiasPercent();
        int r12 = r11.mTop.mTarget.getFinalValue();
        int r13 = r11.mBottom.mTarget.getFinalValue();
        int r14 = r11.mTop.getMargin() + r12;
        int r15 = r13 - r11.mBottom.getMargin();
        if (r12 != r13) goto L5;
        r5 = 0.5f;
    L6:
        int r16 = r11.getHeight();
        int r17 = (r13 - r12) - r16;
        if (r12 <= r13) goto L9;
        r17 = (r12 - r13) - r16;
    L9:
        int r18 = (int) ((r5 * r17) + 0.5f);
        int r19 = r12 + r18;
        int r20 = r19 + r16;
        if (r12 <= r13) goto L12;
        r19 = r12 - r18;
        r20 = r19 - r16;
    L12:
        r11.setFinalVertical(r19, r20);
        verticalSolvingPass(r11, r10);
        return;
    L5:
        r12 = r14;
        r13 = r15;
        goto L6
    }

    private static void solveVerticalMatchConstraint(ConstraintWidget r10, BasicMeasure.Measurer r11, ConstraintWidget r12) {
        float r5 = r12.getVerticalBiasPercent();
        int r13 = r12.mTop.getMargin() + r12.mTop.mTarget.getFinalValue();
        int r14 = r12.mBottom.mTarget.getFinalValue() - r12.mBottom.getMargin();
        if (r14 < r13) goto L20;
        int r15 = r12.getHeight();
        if (r12.getVisibility() == 8) goto L18;
        int r16 = r12.mMatchConstraintDefaultHeight;
        if (r16 == 2) goto L9;
        if (r16 != 0) goto L15;
        r15 = r14 - r13;
    L15:
        r15 = Math.max(r12.mMatchConstraintMinHeight, r15);
        int r17 = r12.mMatchConstraintMaxHeight;
        if (r17 <= 0) goto L18;
        r15 = Math.min(r17, r15);
        goto L18
    L9:
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r18 = r10.getHeight();
    L12:
        r15 = (int) ((r5 * 0.5f) * r18);
        goto L15
    L11:
        r18 = r10.getParent().getHeight();
    L18:
        int r19 = r13 + ((int) ((r5 * ((r14 - r13) - r15)) + 0.5f));
        r12.setFinalVertical(r19, r15 + r19);
        verticalSolvingPass(r12, r11);
        return;
    }

    public static void solvingPass(ConstraintWidgetContainer r13, BasicMeasure.Measurer r14) {
        ConstraintWidget.DimensionBehaviour r5 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r10 = r13.getVerticalDimensionBehaviour();
        r13.resetFinalResolution();
        ArrayList<ConstraintWidget> r11 = r13.getChildren();
        int r12 = r11.size();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r16 >= r12) goto L5;
        r11.get(r16).resetFinalResolution();
        r16 = r16 + 1;
        goto L3
    L5:
        boolean r17 = r13.isRtl();
        if (r5 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r13.setFinalHorizontal(0, r13.getWidth());
    L9:
        int r18 = 0;
        boolean r19 = false;
        boolean r20 = false;
    L11:
        if (r18 >= r12) goto L34;
        ConstraintWidget r110 = r11.get(r18);
        if ((r110 instanceof Guideline) == false) goto L29;
        Guideline r111 = (Guideline) r110;
        if (r111.getOrientation() != 1) goto L33;
        if (r111.getRelativeBegin() == (-1)) goto L20;
        r111.setFinalValue(r111.getRelativeBegin());
    L27:
        r19 = true;
        goto L33
    L20:
        if (r111.getRelativeEnd() == (-1)) goto L25;
        if (r13.isResolvedHorizontally() == false) goto L25;
        r111.setFinalValue(r13.getWidth() - r111.getRelativeEnd());
    L25:
        if (r13.isResolvedHorizontally() == false) goto L27;
        r111.setFinalValue((int) ((r111.getRelativePercent() * r13.getWidth()) + 0.5f));
    L33:
        r18 = r18 + 1;
        goto L11
    L29:
        if ((r110 instanceof Barrier) == false) goto L33;
        if (((Barrier) r110).getOrientation() != 0) goto L33;
        r20 = true;
        goto L33
    L34:
        if (r19 == false) goto L43;
        int r21 = 0;
    L36:
        if (r21 >= r12) goto L43;
        ConstraintWidget r22 = r11.get(r21);
        if ((r22 instanceof Guideline) == false) goto L42;
        Guideline r23 = (Guideline) r22;
        if (r23.getOrientation() != 1) goto L42;
        horizontalSolvingPass(r23, r14, r17);
    L42:
        r21 = r21 + 1;
    L43:
        horizontalSolvingPass(r13, r14, r17);
        if (r20 == false) goto L54;
        int r24 = 0;
    L46:
        if (r24 >= r12) goto L54;
        ConstraintWidget r25 = r11.get(r24);
        if ((r25 instanceof Barrier) == false) goto L52;
        Barrier r26 = (Barrier) r25;
        if (r26.getOrientation() != 0) goto L52;
        solveBarrier(r26, r14, 0, r17);
    L52:
        r24 = r24 + 1;
    L54:
        if (r10 != ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        r13.setFinalVertical(0, r13.getHeight());
    L57:
        int r27 = 0;
        boolean r28 = false;
        boolean r29 = false;
    L58:
        if (r27 >= r12) goto L81;
        ConstraintWidget r30 = r11.get(r27);
        if ((r30 instanceof Guideline) == false) goto L76;
        Guideline r31 = (Guideline) r30;
        if (r31.getOrientation() != 0) goto L80;
        if (r31.getRelativeBegin() == (-1)) goto L67;
        r31.setFinalValue(r31.getRelativeBegin());
    L74:
        r28 = true;
        goto L80
    L67:
        if (r31.getRelativeEnd() == (-1)) goto L72;
        if (r13.isResolvedVertically() == false) goto L72;
        r31.setFinalValue(r13.getHeight() - r31.getRelativeEnd());
    L72:
        if (r13.isResolvedVertically() == false) goto L74;
        r31.setFinalValue((int) ((r31.getRelativePercent() * r13.getHeight()) + 0.5f));
    L80:
        r27 = r27 + 1;
        goto L58
    L76:
        if ((r30 instanceof Barrier) == false) goto L80;
        if (((Barrier) r30).getOrientation() != 1) goto L80;
        r29 = true;
        goto L80
    L81:
        if (r28 == false) goto L90;
        int r32 = 0;
    L83:
        if (r32 >= r12) goto L90;
        ConstraintWidget r33 = r11.get(r32);
        if ((r33 instanceof Guideline) == false) goto L89;
        Guideline r34 = (Guideline) r33;
        if (r34.getOrientation() != 0) goto L89;
        verticalSolvingPass(r34, r14);
    L89:
        r32 = r32 + 1;
    L90:
        verticalSolvingPass(r13, r14);
        if (r29 == false) goto L100;
        int r112 = 0;
    L93:
        if (r112 >= r12) goto L100;
        ConstraintWidget r35 = r11.get(r112);
        if ((r35 instanceof Barrier) == false) goto L99;
        Barrier r36 = (Barrier) r35;
        if (r36.getOrientation() != 1) goto L99;
        solveBarrier(r36, r14, 1, r17);
    L99:
        r112 = r112 + 1;
    L100:
        if (r15 >= r12) goto L107;
        ConstraintWidget r113 = r11.get(r15);
        if (r113.isMeasureRequested() == false) goto L106;
        if (canMeasure(r113) == false) goto L106;
        ConstraintWidgetContainer.measure(r113, r14, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        horizontalSolvingPass(r113, r14, r17);
        verticalSolvingPass(r113, r14);
    L106:
        r15 = r15 + 1;
        goto L100
    L107:
        return;
    L56:
        r13.setFinalTop(0);
        goto L57
    L8:
        r13.setFinalLeft(0);
        goto L9
    }

    private static void verticalSolvingPass(ConstraintWidget r11, BasicMeasure.Measurer r12) {
        if ((r11 instanceof ConstraintWidgetContainer) == false) goto L5;
    L9:
        ConstraintAnchor r5 = r11.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r10 = r11.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r13 = r5.getFinalValue();
        int r14 = r10.getFinalValue();
        if (r5.getDependents() == null) goto L75;
        if (r5.hasFinalValue() == false) goto L75;
        Iterator<ConstraintAnchor> r15 = r5.getDependents().iterator();
    L15:
        if (r15.hasNext() == false) goto L75;
        ConstraintAnchor r16 = r15.next();
        ConstraintWidget r17 = r16.mOwner;
        boolean r18 = canMeasure(r17);
        if (r17.isMeasureRequested() == false) goto L20;
        if (r18 == false) goto L20;
        ConstraintWidgetContainer.measure(r17, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L20:
        ConstraintWidget.DimensionBehaviour r19 = r17.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 != r110) goto L56;
        if (r18 == true) goto L56;
        if (r17.getVerticalDimensionBehaviour() != r110) goto L15;
        if (r17.mMatchConstraintMaxHeight < 0) goto L15;
        if (r17.mMatchConstraintMinHeight < 0) goto L15;
        if (r17.getVisibility() == 8) goto L37;
        if (r17.mMatchConstraintDefaultHeight != 0) goto L15;
        if (r17.getDimensionRatio() != 0.0f) goto L15;
    L37:
        if (r17.isInVerticalChain() == true) goto L15;
        if (r17.isInVirtualLayout() == true) goto L15;
        if (r16 != r17.mTop) goto L47;
        ConstraintAnchor r20 = r17.mBottom.mTarget;
        if (r20 == null) goto L47;
        if (r20.hasFinalValue() == false) goto L47;
    L53:
        if (r17.isInVerticalChain() == true) goto L15;
        solveVerticalMatchConstraint(r11, r12, r17);
    L47:
        if (r16 != r17.mBottom) goto L15;
        ConstraintAnchor r21 = r17.mTop.mTarget;
        if (r21 == null) goto L15;
        if (r21.hasFinalValue() == false) goto L15;
    L56:
        if (r17.isMeasureRequested() == true) goto L15;
        ConstraintAnchor r22 = r17.mTop;
        if (r16 != r22) goto L63;
        if (r17.mBottom.mTarget != null) goto L63;
        int r23 = r22.getMargin() + r13;
        r17.setFinalVertical(r23, r17.getHeight() + r23);
        verticalSolvingPass(r17, r12);
    L63:
        ConstraintAnchor r24 = r17.mBottom;
        if (r16 != r24) goto L68;
        if (r24.mTarget != null) goto L68;
        int r25 = r13 - r24.getMargin();
        r17.setFinalVertical(r25 - r17.getHeight(), r25);
        verticalSolvingPass(r17, r12);
    L68:
        if (r16 != r22) goto L15;
        ConstraintAnchor r26 = r24.mTarget;
        if (r26 == null) goto L15;
        if (r26.hasFinalValue() == false) goto L15;
        solveVerticalCenterConstraints(r12, r17);
    L75:
        if ((r11 instanceof Guideline) == false) goto L78;
        return;
    L78:
        if (r10.getDependents() != null) goto L80;
    L143:
        ConstraintAnchor r111 = r11.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r111.getDependents() != null) goto L146;
        return;
    L146:
        if (r111.hasFinalValue() == false) goto L261;
        int r27 = r111.getFinalValue();
        Iterator<ConstraintAnchor> r112 = r111.getDependents().iterator();
    L149:
        if (r112.hasNext() == false) goto L262;
        ConstraintAnchor r28 = r112.next();
        ConstraintWidget r29 = r28.mOwner;
        boolean r30 = canMeasure(r29);
        if (r29.isMeasureRequested() == false) goto L155;
        if (r30 == false) goto L155;
        ConstraintWidgetContainer.measure(r29, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L155:
        if (r29.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L158;
        if (r30 == false) goto L149;
    L158:
        if (r29.isMeasureRequested() == true) goto L149;
        if (r28 != r29.mBaseline) goto L149;
        r29.setFinalBaseline(r27);
        verticalSolvingPass(r29, r12);
        goto L149
    L262:
        return;
    L261:
        return;
    L80:
        if (r10.hasFinalValue() == false) goto L143;
        Iterator<ConstraintAnchor> r31 = r10.getDependents().iterator();
    L83:
        if (r31.hasNext() == false) goto L143;
        ConstraintAnchor r32 = r31.next();
        ConstraintWidget r33 = r32.mOwner;
        boolean r34 = canMeasure(r33);
        if (r33.isMeasureRequested() == false) goto L89;
        if (r34 == false) goto L89;
        ConstraintWidgetContainer.measure(r33, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L89:
        if (r32 != r33.mTop) goto L95;
        ConstraintAnchor r35 = r33.mBottom.mTarget;
        if (r35 == null) goto L95;
        if (r35.hasFinalValue() == false) goto L95;
    L100:
        boolean r36 = true;
    L102:
        ConstraintWidget.DimensionBehaviour r37 = r33.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r38 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r37 != r38) goto L127;
        if (r34 == true) goto L127;
        if (r33.getVerticalDimensionBehaviour() != r38) goto L83;
        if (r33.mMatchConstraintMaxHeight < 0) goto L83;
        if (r33.mMatchConstraintMinHeight < 0) goto L83;
        if (r33.getVisibility() == 8) goto L119;
        if (r33.mMatchConstraintDefaultHeight != 0) goto L83;
        if (r33.getDimensionRatio() != 0.0f) goto L83;
    L119:
        if (r33.isInVerticalChain() == true) goto L83;
        if (r33.isInVirtualLayout() == true) goto L83;
        if (r36 == false) goto L83;
        if (r33.isInVerticalChain() == true) goto L83;
        solveVerticalMatchConstraint(r11, r12, r33);
    L127:
        if (r33.isMeasureRequested() == true) goto L83;
        ConstraintAnchor r39 = r33.mTop;
        if (r32 != r39) goto L134;
        if (r33.mBottom.mTarget != null) goto L134;
        int r40 = r39.getMargin() + r14;
        r33.setFinalVertical(r40, r33.getHeight() + r40);
        verticalSolvingPass(r33, r12);
    L134:
        ConstraintAnchor r41 = r33.mBottom;
        if (r32 != r41) goto L139;
        if (r39.mTarget != null) goto L139;
        int r42 = r14 - r41.getMargin();
        r33.setFinalVertical(r42 - r33.getHeight(), r42);
        verticalSolvingPass(r33, r12);
    L139:
        if (r36 == false) goto L83;
        if (r33.isInVerticalChain() == true) goto L83;
        solveVerticalCenterConstraints(r12, r33);
    L95:
        if (r32 != r33.mBottom) goto L101;
        ConstraintAnchor r43 = r33.mTop.mTarget;
        if (r43 == null) goto L101;
        if (r43.hasFinalValue() == true) goto L100;
    L101:
        r36 = false;
        goto L102
    L5:
        if (r11.isMeasureRequested() == false) goto L9;
        if (canMeasure(r11) == false) goto L9;
        ConstraintWidgetContainer.measure(r11, r12, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L9
    }
}
