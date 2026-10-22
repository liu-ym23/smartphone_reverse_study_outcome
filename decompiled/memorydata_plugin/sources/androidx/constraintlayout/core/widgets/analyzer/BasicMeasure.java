package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

        void measure(ConstraintWidget r1, Measure r2);
    }

    public BasicMeasure(ConstraintWidgetContainer r2) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r2;
    }

    private boolean measure(Measurer r5, ConstraintWidget r6, int r7) {
        Measurer r8 = (Measurer) ZeusTransformUtils.wrapperContextForParams(r5, Measurer.class, "com.obric.memorydata.plugin");
        this.mMeasure.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r6.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r6.getWidth();
        this.mMeasure.verticalDimension = r6.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.measureStrategy = r7;
        if (this.mMeasure.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        boolean r9 = true;
    L7:
        if (this.mMeasure.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
        boolean r0 = true;
    L11:
        if (r9 == true) goto L13;
    L15:
        boolean r10 = false;
    L16:
        if (r0 == true) goto L18;
    L20:
        boolean r1 = false;
    L22:
        if (r10 == true) goto L24;
    L26:
        if (r1 == true) goto L28;
    L30:
        r8.measure(r6, this.mMeasure);
        r6.setWidth(this.mMeasure.measuredWidth);
        r6.setHeight(this.mMeasure.measuredHeight);
        r6.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r6.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.measureStrategy = Measure.SELF_DIMENSIONS;
        return this.mMeasure.measuredNeedsSolverPass;
    L28:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r6.mDimensionRatio <= 0.0f) goto L20;
        r1 = true;
        goto L22
    L13:
        if (r6.mDimensionRatio <= 0.0f) goto L15;
        r10 = true;
        goto L16
    L9:
        r0 = false;
        goto L11
    L5:
        r9 = false;
        goto L7
    }

    private void measureChildren(ConstraintWidgetContainer r12) {
        int r0 = r12.mChildren.size();
        boolean r1 = r12.optimizeFor(64);
        Measurer r2 = r12.getMeasurer();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L70;
        ConstraintWidget r5 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r12.mChildren.get(r4), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Guideline.class) == true) goto L69;
        if (ZeusTransformUtils.instanceOf(r5, Barrier.class) == true) goto L69;
        if (r5.isInVirtualLayout() == true) goto L69;
        if (r1 == true) goto L15;
    L23:
        ConstraintWidget.DimensionBehaviour r6 = r5.getDimensionBehaviour(0);
        boolean r7 = true;
        ConstraintWidget.DimensionBehaviour r8 = r5.getDimensionBehaviour(1);
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L26;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
    L63:
        r7 = r9;
    L64:
        if (r7 == true) goto L69;
        measure(r2, r5, Measure.SELF_DIMENSIONS);
        if (r12.mMetrics == null) goto L69;
        r12.mMetrics.measuredWidgets++;
        goto L69
    L35:
        if (r12.optimizeFor(1) == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r5, VirtualLayout.class) == true) goto L63;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.mMatchConstraintDefaultWidth != 0) goto L48;
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.isInHorizontalChain() == true) goto L48;
        r9 = true;
    L48:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.mMatchConstraintDefaultHeight != 0) goto L57;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.isInHorizontalChain() == true) goto L57;
        r9 = true;
    L57:
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L61;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
    L61:
        if (r5.mDimensionRatio <= 0.0f) goto L63;
    L26:
        if (r5.mMatchConstraintDefaultWidth == 1) goto L32;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (r5.mMatchConstraintDefaultHeight == 1) goto L32;
        r9 = true;
        goto L33
    L15:
        if (r5.horizontalRun == null) goto L23;
        if (r5.verticalRun == null) goto L23;
        if (r5.horizontalRun.dimension.resolved == false) goto L23;
        if (r5.verticalRun.dimension.resolved == false) goto L23;
    L69:
        r4 = r4 + 1;
        goto L3
    L70:
        r2.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r3, String r4, int r5, int r6, int r7) {
        int r8 = r3.getMinWidth();
        int r0 = r3.getMinHeight();
        r3.setMinWidth(0);
        r3.setMinHeight(0);
        r3.setWidth(r6);
        r3.setHeight(r7);
        r3.setMinWidth(r8);
        r3.setMinHeight(r0);
        this.constraintWidgetContainer.setPass(r5);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        BasicMeasure r0 = this;
        ConstraintWidgetContainer r1 = r24;
        Measurer r5 = r24.getMeasurer();
        int r6 = r1.mChildren.size();
        int r7 = r24.getWidth();
        int r8 = r24.getHeight();
        boolean r9 = Optimizer.enabled(r25, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L45;
        int r13 = 0;
    L12:
        if (r13 >= r6) goto L45;
        ConstraintWidget r14 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r1.mChildren.get(r13), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r14.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L16;
        boolean r11 = true;
    L18:
        if (r14.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L20;
        boolean r10 = true;
    L21:
        if (r11 == false) goto L26;
        if (r10 == false) goto L26;
        if (r14.getDimensionRatio() <= 0.0f) goto L26;
        boolean r12 = true;
    L28:
        if (r14.isInHorizontalChain() == false) goto L32;
        if (r12 == false) goto L32;
    L30:
        r2 = false;
    L32:
        if (r14.isInVerticalChain() == false) goto L36;
        if (r12 == true) goto L30;
    L36:
        if (ZeusTransformUtils.instanceOf(r14, VirtualLayout.class) == true) goto L30;
        if (r14.isInHorizontalChain() == true) goto L30;
        if (r14.isInVerticalChain() == true) goto L30;
        r13 = r13 + 1;
    L26:
        r12 = false;
        goto L28
    L20:
        r10 = false;
        goto L21
    L16:
        r11 = false;
    L45:
        if (r2 == false) goto L50;
        if (LinearSystem.sMetrics == null) goto L50;
        LinearSystem.sMetrics.measures++;
    L50:
        if (r28 != 1073741824) goto L52;
        if (r30 != 1073741824) goto L52;
    L53:
        boolean r15 = true;
    L55:
        boolean r3 = r2 & r15;
        int r16 = 2;
        if (r3 == false) goto L84;
        int r17 = Math.min(r24.getMaxWidth(), r29);
        int r18 = Math.min(r24.getMaxHeight(), r31);
        if (r28 == 1073741824) goto L60;
    L62:
        if (r30 == 1073741824) goto L64;
    L66:
        if (r28 != 1073741824) goto L69;
        if (r30 != 1073741824) goto L69;
        boolean r19 = r1.directMeasure(r9);
        int r110 = 2;
    L76:
        if (r19 == false) goto L85;
        if (r28 != 1073741824) goto L79;
        boolean r111 = true;
    L80:
        if (r30 != 1073741824) goto L82;
        boolean r4 = true;
    L83:
        r1.updateFromRuns(r111, r4);
        goto L85
    L82:
        r4 = false;
        goto L83
    L79:
        r111 = false;
    L85:
        if (r19 == false) goto L87;
        if (r110 != 2) goto L87;
        return 0;
    L87:
        int r20 = r24.getOptimizationLevel();
        if (r6 <= 0) goto L90;
        measureChildren(r24);
    L90:
        updateHierarchy(r24);
        int r21 = r0.mVariableDimensionsWidgets.size();
        if (r6 <= 0) goto L93;
        solveLinearSystem(r24, "First pass", 0, r7, r8);
    L93:
        if (r21 > 0) goto L95;
        r24 = r1;
        int r22 = r20;
    L185:
        r24.setOptimizationLevel(r22);
        return 0;
    L95:
        if (r24.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L97;
        boolean r112 = true;
    L99:
        if (r24.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L101;
        boolean r23 = true;
    L102:
        int r34 = Math.max(r24.getWidth(), r0.constraintWidgetContainer.getMinWidth());
        int r113 = Math.max(r24.getHeight(), r0.constraintWidgetContainer.getMinHeight());
        int r114 = 0;
        boolean r115 = false;
    L103:
        if (r114 >= r21) goto L128;
        int r35 = r20;
        ConstraintWidget r36 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.mVariableDimensionsWidgets.get(r114), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r36, VirtualLayout.class) == true) goto L107;
        r3 = r3;
    L127:
        r114 = r114 + 1;
        r1 = r24;
        r20 = r35;
        r8 = r8;
        r7 = r7;
        r3 = r3;
        r16 = 2;
        goto L103
    L107:
        int r116 = r36.getWidth();
        int r37 = r36.getHeight();
        boolean r38 = r0.measure(r5, r36, Measure.TRY_GIVEN_DIMENSIONS) | r115;
        if (r1.mMetrics == null) goto L111;
        r1.mMetrics.measuredMatchWidgets++;
    L111:
        int r39 = r36.getWidth();
        int r40 = r36.getHeight();
        if (r39 == r116) goto L119;
        r36.setWidth(r39);
        if (r112 == true) goto L116;
    L118:
        r38 = true;
        goto L119
    L116:
        if (r36.getRight() <= r34) goto L118;
        r34 = Math.max(r34, r36.getRight() + r36.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
    L119:
        if (r40 == r37) goto L126;
        r36.setHeight(r40);
        if (r23 == true) goto L123;
    L125:
        r38 = true;
        goto L126
    L123:
        if (r36.getBottom() <= r113) goto L125;
        r113 = Math.max(r113, r36.getBottom() + r36.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L126:
        r115 = r38 | ((VirtualLayout) ZeusTransformUtils.preCheckCast(r36, VirtualLayout.class, "com.obric.memorydata.plugin")).needSolverPass();
        goto L127
    L128:
        boolean r210 = r3;
        int r310 = r20;
        int r211 = r7;
        int r117 = r8;
        int r41 = r16;
        int r42 = 0;
    L129:
        if (r42 >= r41) goto L183;
        int r43 = 0;
    L131:
        if (r43 >= r21) goto L179;
        ConstraintWidget r44 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r0.mVariableDimensionsWidgets.get(r43), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r44, Helper.class) == false) goto L137;
        if (ZeusTransformUtils.instanceOf(r44, VirtualLayout.class) == true) goto L137;
    L150:
        r21 = r21;
        r5 = r5;
        boolean r45 = r115;
    L178:
        r43 = r43 + 1;
        r0 = this;
        r115 = r45;
        r5 = r5;
        r21 = r21;
    L137:
        if (ZeusTransformUtils.instanceOf(r44, Guideline.class) == true) goto L150;
        if (r44.getVisibility() == 8) goto L150;
        if (r210 == false) goto L149;
        if (r44.horizontalRun.dimension.resolved == false) goto L149;
        if (r44.verticalRun.dimension.resolved == true) goto L150;
    L149:
        if (ZeusTransformUtils.instanceOf(r44, VirtualLayout.class) == true) goto L150;
        int r46 = r44.getWidth();
        int r118 = r44.getHeight();
        int r119 = r44.getBaselineDistance();
        int r120 = Measure.TRY_GIVEN_DIMENSIONS;
        if (r42 != 1) goto L154;
        r120 = Measure.USE_GIVEN_DIMENSIONS;
    L154:
        r45 = r0.measure(r5, r44, r120) | r115;
        if (r24.mMetrics == null) goto L158;
        r24.mMetrics.measuredMatchWidgets++;
    L158:
        int r47 = r44.getWidth();
        int r48 = r44.getHeight();
        if (r47 == r46) goto L166;
        r44.setWidth(r47);
        if (r112 == true) goto L163;
    L165:
        r45 = true;
        goto L166
    L163:
        if (r44.getRight() <= r34) goto L165;
        r34 = Math.max(r34, r44.getRight() + r44.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
    L166:
        if (r48 == r118) goto L174;
        r44.setHeight(r48);
        if (r23 == true) goto L170;
    L172:
        r45 = true;
        goto L174
    L170:
        if (r44.getBottom() <= r113) goto L172;
        r113 = Math.max(r113, r44.getBottom() + r44.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L174:
        if (r44.hasBaseline() == false) goto L178;
        if (r119 == r44.getBaselineDistance()) goto L178;
        r45 = true;
        goto L178
    L179:
        int r212 = r21;
        Measurer r121 = r5;
        if (r115 == false) goto L183;
        r42 = r42 + 1;
        solveLinearSystem(r24, "intermediate pass", r42, r211, r117);
        r0 = this;
        r5 = r121;
        r21 = r212;
        r41 = 2;
        r115 = false;
    L183:
        r22 = r310;
        goto L185
    L101:
        r23 = false;
        goto L102
    L97:
        r112 = false;
    L69:
        boolean r122 = r1.directMeasureSetup(r9);
        if (r28 != 1073741824) goto L72;
        r122 = r122 & r1.directMeasureWithOrientation(r9, 0);
        r110 = 1;
    L73:
        if (r30 != 1073741824) goto L75;
        r19 = r1.directMeasureWithOrientation(r9, 1) & r122;
        r110 = r110 + 1;
        goto L76
    L75:
        r19 = r122;
        goto L76
    L72:
        r110 = 0;
        goto L73
    L64:
        if (r24.getHeight() == r18) goto L66;
        r1.setHeight(r18);
        r24.invalidateGraph();
        goto L66
    L60:
        if (r24.getWidth() == r17) goto L62;
        r1.setWidth(r17);
        r24.invalidateGraph();
        goto L62
    L84:
        r19 = false;
        r110 = 0;
    L52:
        if (r9 == true) goto L53;
        r15 = false;
        goto L55
    L5:
        if (Optimizer.enabled(r25, 64) == true) goto L8;
        r2 = false;
        goto L10
    }

    public void updateHierarchy(ConstraintWidgetContainer r6) {
        this.mVariableDimensionsWidgets.clear();
        int r0 = r6.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r6.mChildren.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r2.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
    L10:
        r6.invalidateGraph();
    }
}
