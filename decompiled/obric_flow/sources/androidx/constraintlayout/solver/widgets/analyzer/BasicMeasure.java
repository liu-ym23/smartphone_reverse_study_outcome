package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r5, Measure r10);
    }

    public BasicMeasure(ConstraintWidgetContainer r5) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r5;
    }

    private boolean measure(Measurer r10, ConstraintWidget r11, int r12) {
        this.mMeasure.horizontalBehavior = r11.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r11.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r11.getWidth();
        this.mMeasure.verticalDimension = r11.getHeight();
        Measure r5 = this.mMeasure;
        r5.measuredNeedsSolverPass = false;
        r5.measureStrategy = r12;
        ConstraintWidget.DimensionBehaviour r13 = r5.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 != r14) goto L5;
        boolean r15 = true;
    L7:
        if (r5.verticalBehavior != r14) goto L9;
        boolean r16 = true;
    L11:
        if (r15 == true) goto L13;
    L15:
        boolean r17 = false;
    L16:
        if (r16 == true) goto L18;
    L20:
        boolean r18 = false;
    L22:
        if (r17 == true) goto L24;
    L26:
        if (r18 == true) goto L28;
    L30:
        r10.measure(r11, r5);
        r11.setWidth(this.mMeasure.measuredWidth);
        r11.setHeight(this.mMeasure.measuredHeight);
        r11.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r11.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure r19 = this.mMeasure;
        r19.measureStrategy = Measure.SELF_DIMENSIONS;
        return r19.measuredNeedsSolverPass;
    L28:
        if (r11.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        r5.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r11.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        r5.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r11.mDimensionRatio <= 0.0f) goto L20;
        r18 = true;
        goto L22
    L13:
        if (r11.mDimensionRatio <= 0.0f) goto L15;
        r17 = true;
        goto L16
    L9:
        r16 = false;
        goto L11
    L5:
        r15 = false;
        goto L7
    }

    private void measureChildren(ConstraintWidgetContainer r13) {
        int r5 = r13.mChildren.size();
        boolean r10 = r13.optimizeFor(64);
        Measurer r11 = r13.getMeasurer();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L63;
        ConstraintWidget r14 = r13.mChildren.get(r12);
        if ((r14 instanceof Guideline) == true) goto L62;
        if ((r14 instanceof Barrier) == true) goto L62;
        if (r14.isInVirtualLayout() == true) goto L62;
        if (r10 == false) goto L23;
        HorizontalWidgetRun r15 = r14.horizontalRun;
        if (r15 == null) goto L23;
        VerticalWidgetRun r16 = r14.verticalRun;
        if (r16 == null) goto L23;
        if (r15.dimension.resolved == false) goto L23;
        if (r16.dimension.resolved == true) goto L62;
    L23:
        ConstraintWidget.DimensionBehaviour r17 = r14.getDimensionBehaviour(0);
        boolean r18 = true;
        ConstraintWidget.DimensionBehaviour r19 = r14.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r17 == r20) goto L26;
    L31:
        boolean r110 = false;
    L32:
        if (r110 == false) goto L34;
    L56:
        r18 = r110;
    L57:
        if (r18 == true) goto L62;
        measure(r11, r14, Measure.SELF_DIMENSIONS);
        Metrics r21 = r13.mMetrics;
        if (r21 == null) goto L62;
        r21.measuredWidgets++;
        goto L62
    L34:
        if (r13.optimizeFor(1) == false) goto L56;
        if ((r14 instanceof VirtualLayout) == true) goto L56;
        if (r17 == r20) goto L39;
    L44:
        if (r19 == r20) goto L46;
    L51:
        if (r17 == r20) goto L54;
        if (r19 != r20) goto L56;
    L54:
        if (r14.mDimensionRatio <= 0.0f) goto L56;
    L46:
        if (r14.mMatchConstraintDefaultHeight != 0) goto L51;
        if (r17 == r20) goto L51;
        if (r14.isInHorizontalChain() == true) goto L51;
        r110 = true;
        goto L51
    L39:
        if (r14.mMatchConstraintDefaultWidth != 0) goto L44;
        if (r19 == r20) goto L44;
        if (r14.isInHorizontalChain() == true) goto L44;
        r110 = true;
        goto L44
    L26:
        if (r14.mMatchConstraintDefaultWidth == 1) goto L31;
        if (r19 != r20) goto L31;
        if (r14.mMatchConstraintDefaultHeight == 1) goto L31;
        r110 = true;
    L62:
        r12 = r12 + 1;
        goto L3
    L63:
        r11.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r5, String r10, int r11, int r12) {
        int r13 = r5.getMinWidth();
        int r14 = r5.getMinHeight();
        r5.setMinWidth(0);
        r5.setMinHeight(0);
        r5.setWidth(r11);
        r5.setHeight(r12);
        r5.setMinWidth(r13);
        r5.setMinHeight(r14);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32) {
        Measurer r5 = r23.getMeasurer();
        int r10 = r23.mChildren.size();
        int r11 = r23.getWidth();
        int r12 = r23.getHeight();
        boolean r13 = Optimizer.enabled(r24, 128);
        if (r13 == false) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == false) goto L44;
        int r15 = 0;
    L11:
        if (r15 >= r10) goto L44;
        ConstraintWidget r16 = r23.mChildren.get(r15);
        ConstraintWidget.DimensionBehaviour r17 = r16.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r17 != r18) goto L15;
        boolean r19 = true;
    L17:
        if (r16.getVerticalDimensionBehaviour() != r18) goto L19;
        boolean r110 = true;
    L20:
        if (r19 == false) goto L25;
        if (r110 == false) goto L25;
        if (r16.getDimensionRatio() <= 0.0f) goto L25;
        boolean r111 = true;
    L27:
        if (r16.isInHorizontalChain() == false) goto L31;
        if (r111 == false) goto L31;
    L29:
        r14 = false;
    L31:
        if (r16.isInVerticalChain() == false) goto L35;
        if (r111 == true) goto L29;
    L35:
        if ((r16 instanceof VirtualLayout) == true) goto L29;
        if (r16.isInHorizontalChain() == true) goto L29;
        if (r16.isInVerticalChain() == true) goto L29;
        r15 = r15 + 1;
    L25:
        r111 = false;
        goto L27
    L19:
        r110 = false;
        goto L20
    L15:
        r19 = false;
    L44:
        if (r14 == false) goto L49;
        Metrics r112 = LinearSystem.sMetrics;
        if (r112 == null) goto L49;
        r112.measures++;
    L49:
        if (r27 != 1073741824) goto L51;
        if (r29 != 1073741824) goto L51;
    L52:
        boolean r113 = true;
    L54:
        boolean r20 = r14 & r113;
        int r114 = 2;
        if (r20 == false) goto L83;
        int r115 = Math.min(r23.getMaxWidth(), r28);
        int r116 = Math.min(r23.getMaxHeight(), r30);
        if (r27 == 1073741824) goto L59;
    L61:
        if (r29 == 1073741824) goto L63;
    L65:
        if (r27 != 1073741824) goto L68;
        if (r29 != 1073741824) goto L68;
        boolean r21 = r23.directMeasure(r13);
        int r117 = 2;
    L75:
        if (r21 == false) goto L84;
        if (r27 != 1073741824) goto L78;
        boolean r118 = true;
    L79:
        if (r29 != 1073741824) goto L81;
        boolean r22 = true;
    L82:
        r23.updateFromRuns(r118, r22);
        goto L84
    L81:
        r22 = false;
        goto L82
    L78:
        r118 = false;
    L84:
        if (r21 == false) goto L86;
        if (r117 != 2) goto L86;
        return 0;
    L86:
        int r33 = r23.getOptimizationLevel();
        if (r10 <= 0) goto L89;
        measureChildren(r23);
    L89:
        updateHierarchy(r23);
        int r34 = this.mVariableDimensionsWidgets.size();
        if (r10 <= 0) goto L92;
        solveLinearSystem(r23, "First pass", r11, r12);
    L92:
        if (r34 <= 0) goto L195;
        ConstraintWidget.DimensionBehaviour r35 = r23.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r35 != r36) goto L96;
        boolean r119 = true;
    L98:
        if (r23.getVerticalDimensionBehaviour() != r36) goto L100;
        boolean r37 = true;
    L101:
        int r38 = Math.max(r23.getWidth(), this.constraintWidgetContainer.getMinWidth());
        int r120 = Math.max(r23.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int r121 = 0;
        boolean r122 = false;
    L102:
        if (r121 >= r34) goto L127;
        ConstraintWidget r123 = this.mVariableDimensionsWidgets.get(r121);
        if ((r123 instanceof VirtualLayout) == false) goto L126;
        int r124 = r123.getWidth();
        int r39 = r123.getHeight();
        boolean r40 = measure(r5, r123, Measure.TRY_GIVEN_DIMENSIONS) | r122;
        Metrics r125 = r23.mMetrics;
        if (r125 == null) goto L109;
        r125.measuredMatchWidgets++;
    L109:
        int r41 = r123.getWidth();
        int r42 = r123.getHeight();
        if (r41 == r124) goto L117;
        r123.setWidth(r41);
        if (r119 == true) goto L114;
    L116:
        boolean r43 = true;
    L118:
        if (r42 == r39) goto L125;
        r123.setHeight(r42);
        if (r37 == true) goto L122;
    L124:
        r43 = true;
        goto L125
    L122:
        if (r123.getBottom() <= r120) goto L124;
        r120 = Math.max(r120, r123.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + r123.getBottom());
    L125:
        r122 = r43 | ((VirtualLayout) r123).needSolverPass();
        goto L126
    L114:
        if (r123.getRight() <= r38) goto L116;
        r38 = Math.max(r38, r123.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + r123.getRight());
        goto L116
    L117:
        r43 = r40;
    L126:
        r121 = r121 + 1;
        r33 = r33;
        r11 = r11;
        r12 = r12;
        r114 = 2;
        goto L102
    L127:
        int r210 = r33;
        int r126 = r11;
        int r127 = r12;
        int r44 = r114;
        int r45 = 0;
    L128:
        if (r45 >= r44) goto L183;
        int r46 = 0;
    L130:
        if (r46 >= r34) goto L179;
        ConstraintWidget r128 = this.mVariableDimensionsWidgets.get(r46);
        if ((r128 instanceof Helper) == false) goto L136;
        if ((r128 instanceof VirtualLayout) == true) goto L136;
    L149:
        boolean r129 = r20;
        int r211 = r34;
        Measurer r130 = r5;
    L178:
        r46 = r46 + 1;
        r34 = r211;
        r5 = r130;
        r20 = r129;
    L136:
        if ((r128 instanceof Guideline) == true) goto L149;
        if (r128.getVisibility() == 8) goto L149;
        if (r20 == false) goto L148;
        if (r128.horizontalRun.dimension.resolved == false) goto L148;
        if (r128.verticalRun.dimension.resolved == true) goto L149;
    L148:
        if ((r128 instanceof VirtualLayout) == true) goto L149;
        int r131 = r128.getWidth();
        int r132 = r128.getHeight();
        int r47 = r128.getBaselineDistance();
        int r133 = Measure.TRY_GIVEN_DIMENSIONS;
        r129 = r20;
        if (r45 != 1) goto L153;
        r133 = Measure.USE_GIVEN_DIMENSIONS;
    L153:
        boolean r48 = measure(r5, r128, r133) | r122;
        Metrics r134 = r23.mMetrics;
        r211 = r34;
        r130 = r5;
        if (r134 == null) goto L157;
        r134.measuredMatchWidgets++;
    L157:
        int r49 = r128.getWidth();
        int r50 = r128.getHeight();
        if (r49 == r131) goto L165;
        r128.setWidth(r49);
        if (r119 == true) goto L162;
    L164:
        r48 = true;
        goto L165
    L162:
        if (r128.getRight() <= r38) goto L164;
        r38 = Math.max(r38, r128.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + r128.getRight());
    L165:
        if (r50 == r132) goto L173;
        r128.setHeight(r50);
        if (r37 == true) goto L169;
    L171:
        r48 = true;
        goto L173
    L169:
        if (r128.getBottom() <= r120) goto L171;
        r120 = Math.max(r120, r128.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + r128.getBottom());
    L173:
        if (r128.hasBaseline() == true) goto L175;
    L177:
        r122 = r48;
        goto L178
    L175:
        if (r47 == r128.getBaselineDistance()) goto L177;
        r122 = true;
        goto L178
    L179:
        boolean r135 = r20;
        int r212 = r34;
        Measurer r136 = r5;
        if (r122 == false) goto L183;
        solveLinearSystem(r23, "intermediate pass", r126, r127);
        r45 = r45 + 1;
        r5 = r136;
        r20 = r135;
        r44 = 2;
        r122 = false;
        r34 = r212;
    L183:
        if (r122 == false) goto L194;
        solveLinearSystem(r23, "2nd pass", r126, r127);
        if (r23.getWidth() >= r38) goto L187;
        r23.setWidth(r38);
        boolean r137 = true;
    L189:
        if (r23.getHeight() >= r120) goto L191;
        r23.setHeight(r120);
        boolean r138 = true;
    L192:
        if (r138 == false) goto L194;
        solveLinearSystem(r23, "3rd pass", r126, r127);
        goto L194
    L191:
        r138 = r137;
        goto L192
    L187:
        r137 = false;
    L194:
        int r51 = r210;
    L196:
        r23.setOptimizationLevel(r51);
        return 0;
    L100:
        r37 = false;
        goto L101
    L96:
        r119 = false;
        goto L98
    L195:
        r51 = r33;
    L68:
        boolean r139 = r23.directMeasureSetup(r13);
        if (r27 != 1073741824) goto L71;
        r139 = r139 & r23.directMeasureWithOrientation(r13, 0);
        r117 = 1;
    L72:
        if (r29 != 1073741824) goto L74;
        r21 = r23.directMeasureWithOrientation(r13, 1) & r139;
        r117 = r117 + 1;
        goto L75
    L74:
        r21 = r139;
        goto L75
    L71:
        r117 = 0;
        goto L72
    L63:
        if (r23.getHeight() == r116) goto L65;
        r23.setHeight(r116);
        r23.invalidateGraph();
        goto L65
    L59:
        if (r23.getWidth() == r115) goto L61;
        r23.setWidth(r115);
        r23.invalidateGraph();
        goto L61
    L83:
        r21 = false;
        r117 = 0;
    L51:
        if (r13 == true) goto L52;
        r113 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r24, 64) == true) goto L8;
        r14 = false;
        goto L9
    }

    public void updateHierarchy(ConstraintWidgetContainer r10) {
        this.mVariableDimensionsWidgets.clear();
        int r5 = r10.mChildren.size();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L10;
        ConstraintWidget r12 = r10.mChildren.get(r11);
        ConstraintWidget.DimensionBehaviour r13 = r12.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 != r14) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r12);
    L9:
        r11 = r11 + 1;
        goto L3
    L7:
        if (r12.getVerticalDimensionBehaviour() != r14) goto L9;
    L10:
        r10.invalidateGraph();
    }
}
