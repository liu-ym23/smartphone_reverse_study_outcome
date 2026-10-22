package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
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

        static {
        }

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r10, Measure r11);
    }

    public BasicMeasure(ConstraintWidgetContainer r10) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r10;
    }

    private boolean measure(Measurer r10, ConstraintWidget r11, int r12) {
        this.mMeasure.horizontalBehavior = r11.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r11.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r11.getWidth();
        this.mMeasure.verticalDimension = r11.getHeight();
        Measure r13 = this.mMeasure;
        r13.measuredNeedsSolverPass = false;
        r13.measureStrategy = r12;
        ConstraintWidget.DimensionBehaviour r14 = r13.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L5;
        boolean r16 = true;
    L7:
        if (r13.verticalBehavior != r15) goto L9;
        boolean r17 = true;
    L11:
        if (r16 == true) goto L13;
    L15:
        boolean r18 = false;
    L16:
        if (r17 == true) goto L18;
    L20:
        boolean r19 = false;
    L22:
        if (r18 == true) goto L24;
    L26:
        if (r19 == true) goto L28;
    L30:
        r10.measure(r11, r13);
        r11.setWidth(this.mMeasure.measuredWidth);
        r11.setHeight(this.mMeasure.measuredHeight);
        r11.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r11.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure r20 = this.mMeasure;
        r20.measureStrategy = Measure.SELF_DIMENSIONS;
        return r20.measuredNeedsSolverPass;
    L28:
        if (r11.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r11.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r11.mDimensionRatio <= 0.0f) goto L20;
        r19 = true;
        goto L22
    L13:
        if (r11.mDimensionRatio <= 0.0f) goto L15;
        r18 = true;
        goto L16
    L9:
        r17 = false;
        goto L11
    L5:
        r16 = false;
        goto L7
    }

    private void measureChildren(ConstraintWidgetContainer r13) {
        int r10 = r13.mChildren.size();
        boolean r11 = r13.optimizeFor(64);
        Measurer r12 = r13.getMeasurer();
        int r14 = 0;
    L3:
        if (r14 >= r10) goto L63;
        ConstraintWidget r15 = r13.mChildren.get(r14);
        if ((r15 instanceof Guideline) == true) goto L62;
        if ((r15 instanceof Barrier) == true) goto L62;
        if (r15.isInVirtualLayout() == true) goto L62;
        if (r11 == false) goto L23;
        HorizontalWidgetRun r16 = r15.horizontalRun;
        if (r16 == null) goto L23;
        VerticalWidgetRun r17 = r15.verticalRun;
        if (r17 == null) goto L23;
        if (r16.dimension.resolved == false) goto L23;
        if (r17.dimension.resolved == true) goto L62;
    L23:
        ConstraintWidget.DimensionBehaviour r18 = r15.getDimensionBehaviour(0);
        boolean r19 = true;
        ConstraintWidget.DimensionBehaviour r20 = r15.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 == r21) goto L26;
    L31:
        boolean r110 = false;
    L32:
        if (r110 == false) goto L34;
    L56:
        r19 = r110;
    L57:
        if (r19 == true) goto L62;
        measure(r12, r15, Measure.SELF_DIMENSIONS);
        Metrics r22 = r13.mMetrics;
        if (r22 == null) goto L62;
        r22.measuredWidgets++;
        goto L62
    L34:
        if (r13.optimizeFor(1) == false) goto L56;
        if ((r15 instanceof VirtualLayout) == true) goto L56;
        if (r18 == r21) goto L39;
    L44:
        if (r20 == r21) goto L46;
    L51:
        if (r18 == r21) goto L54;
        if (r20 != r21) goto L56;
    L54:
        if (r15.mDimensionRatio <= 0.0f) goto L56;
    L46:
        if (r15.mMatchConstraintDefaultHeight != 0) goto L51;
        if (r18 == r21) goto L51;
        if (r15.isInHorizontalChain() == true) goto L51;
        r110 = true;
        goto L51
    L39:
        if (r15.mMatchConstraintDefaultWidth != 0) goto L44;
        if (r20 == r21) goto L44;
        if (r15.isInHorizontalChain() == true) goto L44;
        r110 = true;
        goto L44
    L26:
        if (r15.mMatchConstraintDefaultWidth == 1) goto L31;
        if (r20 != r21) goto L31;
        if (r15.mMatchConstraintDefaultHeight == 1) goto L31;
        r110 = true;
    L62:
        r14 = r14 + 1;
        goto L3
    L63:
        r12.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r10, String r11, int r12, int r13, int r14) {
        int r15 = r10.getMinWidth();
        int r16 = r10.getMinHeight();
        r10.setMinWidth(0);
        r10.setMinHeight(0);
        r10.setWidth(r13);
        r10.setHeight(r14);
        r10.setMinWidth(r15);
        r10.setMinHeight(r16);
        this.constraintWidgetContainer.setPass(r12);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        Measurer r10 = r24.getMeasurer();
        int r11 = r24.mChildren.size();
        int r12 = r24.getWidth();
        int r13 = r24.getHeight();
        boolean r14 = Optimizer.enabled(r25, 128);
        if (r14 == false) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == false) goto L44;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L44;
        ConstraintWidget r17 = r24.mChildren.get(r16);
        ConstraintWidget.DimensionBehaviour r18 = r17.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r18 != r19) goto L15;
        boolean r110 = true;
    L17:
        if (r17.getVerticalDimensionBehaviour() != r19) goto L19;
        boolean r111 = true;
    L20:
        if (r110 == false) goto L25;
        if (r111 == false) goto L25;
        if (r17.getDimensionRatio() <= 0.0f) goto L25;
        boolean r112 = true;
    L27:
        if (r17.isInHorizontalChain() == false) goto L31;
        if (r112 == false) goto L31;
    L29:
        r15 = false;
    L31:
        if (r17.isInVerticalChain() == false) goto L35;
        if (r112 == true) goto L29;
    L35:
        if ((r17 instanceof VirtualLayout) == true) goto L29;
        if (r17.isInHorizontalChain() == true) goto L29;
        if (r17.isInVerticalChain() == true) goto L29;
        r16 = r16 + 1;
    L25:
        r112 = false;
        goto L27
    L19:
        r111 = false;
        goto L20
    L15:
        r110 = false;
    L44:
        if (r15 == false) goto L49;
        Metrics r113 = LinearSystem.sMetrics;
        if (r113 == null) goto L49;
        r113.measures++;
    L49:
        if (r28 != 1073741824) goto L51;
        if (r30 != 1073741824) goto L51;
    L52:
        boolean r114 = true;
    L54:
        boolean r20 = r15 & r114;
        int r115 = 2;
        if (r20 == false) goto L83;
        int r116 = Math.min(r24.getMaxWidth(), r29);
        int r117 = Math.min(r24.getMaxHeight(), r31);
        if (r28 == 1073741824) goto L59;
    L61:
        if (r30 == 1073741824) goto L63;
    L65:
        if (r28 != 1073741824) goto L68;
        if (r30 != 1073741824) goto L68;
        boolean r21 = r24.directMeasure(r14);
        int r118 = 2;
    L75:
        if (r21 == false) goto L84;
        if (r28 != 1073741824) goto L78;
        boolean r119 = true;
    L79:
        if (r30 != 1073741824) goto L81;
        boolean r22 = true;
    L82:
        r24.updateFromRuns(r119, r22);
        goto L84
    L81:
        r22 = false;
        goto L82
    L78:
        r119 = false;
    L84:
        if (r21 == false) goto L86;
        if (r118 != 2) goto L86;
        return 0;
    L86:
        int r23 = r24.getOptimizationLevel();
        if (r11 <= 0) goto L89;
        measureChildren(r24);
    L89:
        updateHierarchy(r24);
        int r34 = this.mVariableDimensionsWidgets.size();
        if (r11 <= 0) goto L92;
        solveLinearSystem(r24, "First pass", 0, r12, r13);
    L92:
        if (r34 <= 0) goto L183;
        ConstraintWidget.DimensionBehaviour r35 = r24.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r35 != r36) goto L96;
        boolean r120 = true;
    L98:
        if (r24.getVerticalDimensionBehaviour() != r36) goto L100;
        boolean r37 = true;
    L101:
        int r38 = Math.max(r24.getWidth(), this.constraintWidgetContainer.getMinWidth());
        int r121 = Math.max(r24.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int r122 = 0;
        boolean r123 = false;
    L102:
        if (r122 >= r34) goto L127;
        ConstraintWidget r124 = this.mVariableDimensionsWidgets.get(r122);
        if ((r124 instanceof VirtualLayout) == false) goto L126;
        int r125 = r124.getWidth();
        int r39 = r124.getHeight();
        boolean r40 = measure(r10, r124, Measure.TRY_GIVEN_DIMENSIONS) | r123;
        Metrics r126 = r24.mMetrics;
        if (r126 == null) goto L109;
        r126.measuredMatchWidgets++;
    L109:
        int r41 = r124.getWidth();
        int r42 = r124.getHeight();
        if (r41 == r125) goto L117;
        r124.setWidth(r41);
        if (r120 == true) goto L114;
    L116:
        boolean r43 = true;
    L118:
        if (r42 == r39) goto L125;
        r124.setHeight(r42);
        if (r37 == true) goto L122;
    L124:
        r43 = true;
        goto L125
    L122:
        if (r124.getBottom() <= r121) goto L124;
        r121 = Math.max(r121, r124.getBottom() + r124.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L125:
        r123 = r43 | ((VirtualLayout) r124).needSolverPass();
        goto L126
    L114:
        if (r124.getRight() <= r38) goto L116;
        r38 = Math.max(r38, r124.getRight() + r124.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
        goto L116
    L117:
        r43 = r40;
    L126:
        r122 = r122 + 1;
        r23 = r23;
        r13 = r13;
        r12 = r12;
        r115 = 2;
        goto L102
    L127:
        int r310 = r23;
        int r127 = r12;
        int r128 = r13;
        int r44 = r115;
        int r45 = 0;
    L128:
        if (r45 >= r44) goto L182;
        int r46 = 0;
    L130:
        if (r46 >= r34) goto L179;
        ConstraintWidget r129 = this.mVariableDimensionsWidgets.get(r46);
        if ((r129 instanceof Helper) == false) goto L136;
        if ((r129 instanceof VirtualLayout) == true) goto L136;
    L149:
        boolean r210 = r20;
        int r211 = r34;
        Measurer r212 = r10;
    L178:
        r46 = r46 + 1;
        r10 = r212;
        r20 = r210;
        r34 = r211;
    L136:
        if ((r129 instanceof Guideline) == true) goto L149;
        if (r129.getVisibility() == 8) goto L149;
        if (r20 == false) goto L148;
        if (r129.horizontalRun.dimension.resolved == false) goto L148;
        if (r129.verticalRun.dimension.resolved == true) goto L149;
    L148:
        if ((r129 instanceof VirtualLayout) == true) goto L149;
        int r130 = r129.getWidth();
        int r131 = r129.getHeight();
        int r47 = r129.getBaselineDistance();
        int r213 = Measure.TRY_GIVEN_DIMENSIONS;
        r210 = r20;
        if (r45 != 1) goto L153;
        r213 = Measure.USE_GIVEN_DIMENSIONS;
    L153:
        boolean r48 = measure(r10, r129, r213) | r123;
        Metrics r132 = r24.mMetrics;
        r211 = r34;
        r212 = r10;
        if (r132 == null) goto L157;
        r132.measuredMatchWidgets++;
    L157:
        int r49 = r129.getWidth();
        int r50 = r129.getHeight();
        if (r49 == r130) goto L165;
        r129.setWidth(r49);
        if (r120 == true) goto L162;
    L164:
        r48 = true;
        goto L165
    L162:
        if (r129.getRight() <= r38) goto L164;
        r38 = Math.max(r38, r129.getRight() + r129.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
    L165:
        if (r50 == r131) goto L173;
        r129.setHeight(r50);
        if (r37 == true) goto L169;
    L171:
        r48 = true;
        goto L173
    L169:
        if (r129.getBottom() <= r121) goto L171;
        r121 = Math.max(r121, r129.getBottom() + r129.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L173:
        if (r129.hasBaseline() == true) goto L175;
    L177:
        r123 = r48;
        goto L178
    L175:
        if (r47 == r129.getBaselineDistance()) goto L177;
        r123 = true;
        goto L178
    L179:
        boolean r214 = r20;
        int r215 = r34;
        Measurer r216 = r10;
        if (r123 == false) goto L182;
        r45 = r45 + 1;
        solveLinearSystem(r24, "intermediate pass", r45, r127, r128);
        r10 = r216;
        r20 = r214;
        r34 = r215;
        r44 = 2;
        r123 = false;
    L182:
        int r51 = r310;
    L184:
        r24.setOptimizationLevel(r51);
        return 0;
    L100:
        r37 = false;
        goto L101
    L96:
        r120 = false;
        goto L98
    L183:
        r51 = r23;
    L68:
        boolean r133 = r24.directMeasureSetup(r14);
        if (r28 != 1073741824) goto L71;
        r133 = r133 & r24.directMeasureWithOrientation(r14, 0);
        r118 = 1;
    L72:
        if (r30 != 1073741824) goto L74;
        r21 = r24.directMeasureWithOrientation(r14, 1) & r133;
        r118 = r118 + 1;
        goto L75
    L74:
        r21 = r133;
        goto L75
    L71:
        r118 = 0;
        goto L72
    L63:
        if (r24.getHeight() == r117) goto L65;
        r24.setHeight(r117);
        r24.invalidateGraph();
        goto L65
    L59:
        if (r24.getWidth() == r116) goto L61;
        r24.setWidth(r116);
        r24.invalidateGraph();
        goto L61
    L83:
        r21 = false;
        r118 = 0;
    L51:
        if (r14 == true) goto L52;
        r114 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r25, 64) == true) goto L8;
        r15 = false;
        goto L9
    }

    public void updateHierarchy(ConstraintWidgetContainer r10) {
        this.mVariableDimensionsWidgets.clear();
        int r11 = r10.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = r10.mChildren.get(r12);
        ConstraintWidget.DimensionBehaviour r14 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r13);
    L9:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13.getVerticalDimensionBehaviour() != r15) goto L9;
    L10:
        r10.invalidateGraph();
    }
}
