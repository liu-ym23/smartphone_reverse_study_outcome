package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int mycounter;
    private WeakReference<ConstraintAnchor> horizontalWrapMax;
    private WeakReference<ConstraintAnchor> horizontalWrapMin;
    BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public BasicMeasure.Measure mMeasure;
    protected BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    private void addHorizontalChain(ConstraintWidget r10) {
        int r5 = this.mHorizontalChainsSize + 1;
        ChainHead[] r11 = this.mHorizontalChainsArray;
        if (r5 < r11.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(r11, r11.length * 2);
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r10, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor r5, SolverVariable r10) {
        SolverVariable r11 = this.mSystem.createObjectVariable(r5);
        this.mSystem.addGreaterThan(r10, r11, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor r5, SolverVariable r10) {
        SolverVariable r11 = this.mSystem.createObjectVariable(r5);
        this.mSystem.addGreaterThan(r11, r10, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget r10) {
        int r5 = this.mVerticalChainsSize + 1;
        ChainHead[] r11 = this.mVerticalChainsArray;
        if (r5 < r11.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(r11, r11.length * 2);
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r10, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void addChain(ConstraintWidget r5, int r10) {
        if (r10 != 0) goto L5;
        addHorizontalChain(r5);
        return;
    L5:
        if (r10 != 1) goto L9;
        addVerticalChain(r5);
        return;
    }

    public boolean addChildrenToSolver(LinearSystem r13) {
        boolean r5 = optimizeFor(64);
        addToSolver(r13, r5);
        int r10 = this.mChildren.size();
        int r11 = 0;
        boolean r12 = false;
    L4:
        if (r11 >= r10) goto L9;
        ConstraintWidget r14 = this.mChildren.get(r11);
        r14.setInBarrier(0, false);
        r14.setInBarrier(1, false);
        if ((r14 instanceof Barrier) == false) goto L8;
        r12 = true;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r12 == false) goto L16;
        int r15 = 0;
    L11:
        if (r15 >= r10) goto L16;
        ConstraintWidget r16 = this.mChildren.get(r15);
        if ((r16 instanceof Barrier) == false) goto L15;
        ((Barrier) r16).markWidgets();
    L15:
        r15 = r15 + 1;
    L16:
        int r17 = 0;
    L17:
        if (r17 >= r10) goto L23;
        ConstraintWidget r18 = this.mChildren.get(r17);
        if (r18.addFirst() == false) goto L21;
        r18.addToSolver(r13, r5);
    L21:
        r17 = r17 + 1;
        goto L17
    L23:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L38;
        HashSet<ConstraintWidget> r19 = new HashSet();
        int r20 = 0;
    L25:
        if (r20 >= r10) goto L31;
        ConstraintWidget r21 = this.mChildren.get(r20);
        if (r21.addFirst() == true) goto L29;
        r19.add(r21);
    L29:
        r20 = r20 + 1;
        goto L25
    L31:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L33;
        int r110 = 0;
    L34:
        addChildrenToSolverByDependency(this, r13, r19, r110, false);
        Iterator<ConstraintWidget> r22 = r19.iterator();
    L36:
        if (r22.hasNext() == false) goto L57;
        ConstraintWidget r23 = r22.next();
        Optimizer.checkMatchParent(this, r13, r23);
        r23.addToSolver(r13, r5);
    L57:
        if (this.mHorizontalChainsSize <= 0) goto L60;
        Chain.applyChainConstraints(this, r13, null, 0);
    L60:
        if (this.mVerticalChainsSize <= 0) goto L62;
        Chain.applyChainConstraints(this, r13, null, 1);
    L62:
        return true;
    L33:
        r110 = 1;
        goto L34
    L38:
        int r24 = 0;
    L39:
        if (r24 >= r10) goto L57;
        ConstraintWidget r25 = this.mChildren.get(r24);
        if ((r25 instanceof ConstraintWidgetContainer) == false) goto L52;
        ConstraintWidget.DimensionBehaviour[] r26 = r25.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r27 = r26[0];
        ConstraintWidget.DimensionBehaviour r28 = r26[1];
        ConstraintWidget.DimensionBehaviour r29 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r27 != r29) goto L45;
        r25.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L45:
        if (r28 != r29) goto L47;
        r25.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L47:
        r25.addToSolver(r13, r5);
        if (r27 != r29) goto L50;
        r25.setHorizontalDimensionBehaviour(r27);
    L50:
        if (r28 != r29) goto L55;
        r25.setVerticalDimensionBehaviour(r28);
    L55:
        r24 = r24 + 1;
        goto L39
    L52:
        Optimizer.checkMatchParent(this, r13, r25);
        if (r25.addFirst() == true) goto L55;
        r25.addToSolver(r13, r5);
        goto L55
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r10 = this.horizontalWrapMax;
        if (r10 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r5);
        return;
    L5:
        if (r10.get() == null) goto L8;
        if (r5.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r10 = this.horizontalWrapMin;
        if (r10 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r5);
        return;
    L5:
        if (r10.get() == null) goto L8;
        if (r5.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r10 = this.verticalWrapMax;
        if (r10 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r5);
        return;
    L5:
        if (r10.get() == null) goto L8;
        if (r5.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r10 = this.verticalWrapMin;
        if (r10 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r5);
        return;
    L5:
        if (r10.get() == null) goto L8;
        if (r5.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) goto L8;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean r5) {
        return this.mDependencyGraph.directMeasure(r5);
    }

    public boolean directMeasureSetup(boolean r5) {
        return this.mDependencyGraph.directMeasureSetup(r5);
    }

    public boolean directMeasureWithOrientation(boolean r5, int r10) {
        return this.mDependencyGraph.directMeasureWithOrientation(r5, r10);
    }

    public void fillMetrics(Metrics r5) {
        this.mMetrics = r5;
        this.mSystem.fillMetrics(r5);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r5 = new ArrayList();
        int r10 = this.mChildren.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        ConstraintWidget r12 = this.mChildren.get(r11);
        if ((r12 instanceof Guideline) == false) goto L9;
        Guideline r13 = (Guideline) r12;
        if (r13.getOrientation() != 0) goto L9;
        r5.add(r13);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return r5;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r5 = new ArrayList();
        int r10 = this.mChildren.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        ConstraintWidget r12 = this.mChildren.get(r11);
        if ((r12 instanceof Guideline) == false) goto L9;
        Guideline r13 = (Guideline) r12;
        if (r13.getOrientation() != 1) goto L9;
        r5.add(r13);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        return r5;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v77 */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79 */
    /* JADX WARN: Type inference failed for: r0v80 */
    /* JADX WARN: Type inference failed for: r0v81 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    public void layout() {
        int r5 = 0;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r10 = this.mChildren.size();
        int r11 = Math.max(0, getWidth());
        int r12 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] r13 = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r14 = r13[1];
        ConstraintWidget.DimensionBehaviour r15 = r13[0];
        Metrics r16 = this.mMetrics;
        if (r16 == null) goto L6;
        r16.layouts++;
    L6:
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L30;
        Direct.solvingPass(this, getMeasurer());
        int r17 = 0;
    L8:
        if (r17 >= r10) goto L30;
        ConstraintWidget r18 = this.mChildren.get(r17);
        if (r18.isMeasureRequested() == false) goto L28;
        if ((r18 instanceof Guideline) == true) goto L28;
        if ((r18 instanceof Barrier) == true) goto L28;
        if ((r18 instanceof VirtualLayout) == true) goto L28;
        if (r18.isInVirtualLayout() == true) goto L28;
        ConstraintWidget.DimensionBehaviour r19 = r18.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r110 = r18.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 == r111) goto L22;
    L27:
        measure(r18, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L28
    L22:
        if (r18.mMatchConstraintDefaultWidth == 1) goto L27;
        if (r110 != r111) goto L27;
        if (r18.mMatchConstraintDefaultHeight == 1) goto L27;
    L28:
        r17 = r17 + 1;
    L30:
        if (r10 <= 2) goto L51;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r15 == r20) goto L35;
        if (r14 != r20) goto L51;
    L35:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L51;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L51;
        if (r15 == r20) goto L40;
    L44:
        if (r14 == r20) goto L46;
    L50:
        int r21 = r12;
        int r22 = r11;
        boolean r23 = true;
    L53:
        if (optimizeFor(64) == false) goto L55;
    L58:
        boolean r112 = true;
    L59:
        LinearSystem r113 = this.mSystem;
        r113.graphOptimizer = false;
        r113.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L63;
        if (r112 == false) goto L63;
        r113.newgraphOptimizer = true;
    L63:
        ArrayList<ConstraintWidget> r114 = this.mChildren;
        ConstraintWidget.DimensionBehaviour r115 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r116 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r115 != r116) goto L66;
    L69:
        boolean r117 = true;
    L70:
        resetChains();
        int r118 = 0;
    L71:
        if (r118 >= r10) goto L76;
        ConstraintWidget r119 = this.mChildren.get(r118);
        if ((r119 instanceof WidgetContainer) == false) goto L75;
        ((WidgetContainer) r119).layout();
    L75:
        r118 = r118 + 1;
        goto L71
    L76:
        boolean r120 = optimizeFor(64);
        boolean r121 = r23;
        int r24 = 0;
        ?? r122 = 1;
    L77:
        if (r122 == 0) goto L154;
        int r123 = r24 + 1;
        this.mSystem.reset();     // Catch: Exception -> L82
        resetChains();     // Catch: Exception -> L82
        createObjectVariables(this.mSystem);     // Catch: Exception -> L82
        int r25 = r5;
    L80:
        if (r25 >= r10) goto L84;
        this.mChildren.get(r25).createObjectVariables(this.mSystem);     // Catch: Exception -> L82
        r25 = r25 + 1;     // Catch: Exception -> L82
        goto L80
    L84:
        r122 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L82
        WeakReference<ConstraintAnchor> r26 = this.verticalWrapMin;     // Catch: Exception -> L82
        if (r26 != null) goto L87;
    L89:
        WeakReference<ConstraintAnchor> r27 = this.verticalWrapMax;     // Catch: Exception -> L82
        if (r27 != null) goto L92;
    L94:
        WeakReference<ConstraintAnchor> r28 = this.horizontalWrapMin;     // Catch: Exception -> L82
        if (r28 != null) goto L97;
    L99:
        WeakReference<ConstraintAnchor> r29 = this.horizontalWrapMax;     // Catch: Exception -> L82
        if (r29 != null) goto L102;
    L104:
        if (r122 == 0) goto L108;
        this.mSystem.minimize();     // Catch: Exception -> L82
    L108:
        if (r122 == 0) goto L110;
        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
    L113:
        if (r117 == true) goto L115;
    L131:
        boolean r30 = false;
    L132:
        int r31 = Math.max(this.mMinWidth, getWidth());
        boolean r32 = r30;
        boolean r124 = r121;
        if (r31 <= getWidth()) goto L135;
        setWidth(r31);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r32 = true;
        r124 = true;
    L135:
        int r33 = Math.max(this.mMinHeight, getHeight());
        if (r33 <= getHeight()) goto L138;
        setHeight(r33);
        ?? r34 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r35 = 1;
        boolean r36 = true;
    L139:
        if (r36 == true) goto L152;
        ConstraintWidget.DimensionBehaviour r37 = this.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r125 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r35 = r35;
        r35 = r35;
        r36 = r36;
        r36 = r36;
        if (r37 != r125) goto L147;
        if (r22 <= 0) goto L147;
        r35 = r35;
        r36 = r36;
        if (getWidth() <= r22) goto L147;
        this.mWidthMeasuredTooSmall = r34;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r22);
        ?? r38 = r34;
        r36 = r38 == true ? 1 : 0;
        r35 = r38;
    L147:
        if (this.mListDimensionBehaviors[r34] != r125) goto L152;
        if (r21 <= 0) goto L152;
        if (getHeight() <= r21) goto L152;
        this.mHeightMeasuredTooSmall = r34;
        this.mListDimensionBehaviors[r34] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r21);
        boolean r126 = true;
        ?? r127 = 1;
    L153:
        r24 = r123;
        r5 = 0;
        r121 = r126;
        r122 = r127;
    L152:
        r127 = r35;
        r126 = r36;
        goto L153
    L138:
        r34 = 1;
        r36 = r124;
        r35 = r32;
        goto L139
    L115:
        if (r123 >= 8) goto L131;
        if (Optimizer.flags[2] == false) goto L131;
        int r39 = 0;
        int r40 = 0;
        int r41 = 0;
    L119:
        if (r39 >= r10) goto L121;
        ConstraintWidget r128 = this.mChildren.get(r39);
        r40 = Math.max(r40, r128.getWidth() + r128.mX);
        r41 = Math.max(r41, r128.getHeight() + r128.mY);
        r39 = r39 + 1;
        goto L119
    L121:
        int r42 = Math.max(this.mMinWidth, r40);
        int r43 = Math.max(this.mMinHeight, r41);
        ConstraintWidget.DimensionBehaviour r44 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r15 == r44) goto L124;
    L126:
        r30 = false;
        r121 = r121;
    L127:
        if (r14 != r44) goto L132;
        if (getHeight() >= r43) goto L132;
        setHeight(r43);
        this.mListDimensionBehaviors[1] = r44;
        r30 = true;
        r121 = true;
        goto L132
    L124:
        if (getWidth() >= r42) goto L126;
        setWidth(r42);
        this.mListDimensionBehaviors[0] = r44;
        r30 = true;
        r121 = true;
        goto L127
    L110:
        updateFromSolver(this.mSystem, r120);
        int r45 = 0;
    L111:
        if (r45 >= r10) goto L113;
        this.mChildren.get(r45).updateFromSolver(this.mSystem, r120);
        r45 = r45 + 1;
        goto L111
    L102:
        if (r29.get() == null) goto L104;
        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L82
        this.horizontalWrapMax = null;     // Catch: Exception -> L82
        goto L104
    L97:
        if (r28.get() == null) goto L99;
        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L82
        this.horizontalWrapMin = null;     // Catch: Exception -> L82
        goto L99
    L92:
        if (r27.get() == null) goto L94;
        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L82
        this.verticalWrapMax = null;     // Catch: Exception -> L82
        goto L94
    L87:
        if (r26.get() == null) goto L89;
        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L82
        this.verticalWrapMin = null;     // Catch: Exception -> L82
    L82:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L108
    L154:
        this.mChildren = r114;
        if (r121 == false) goto L157;
        ConstraintWidget.DimensionBehaviour[] r46 = this.mListDimensionBehaviors;
        r46[0] = r15;
        r46[1] = r14;
    L157:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L66:
        if (getVerticalDimensionBehaviour() == r116) goto L69;
        r117 = false;
        goto L70
    L55:
        if (optimizeFor(128) == true) goto L58;
        r112 = false;
        goto L59
    L46:
        if (r12 >= getHeight()) goto L49;
        if (r12 <= 0) goto L49;
        setHeight(r12);
        this.mHeightMeasuredTooSmall = true;
    L49:
        r12 = getHeight();
        goto L50
    L40:
        if (r11 >= getWidth()) goto L43;
        if (r11 <= 0) goto L43;
        setWidth(r11);
        this.mWidthMeasuredTooSmall = true;
    L43:
        r11 = getWidth();
    L51:
        r21 = r12;
        r22 = r11;
        r23 = false;
        goto L53
    }

    public long measure(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.mPaddingLeft = r19;
        this.mPaddingTop = r20;
        return this.mBasicMeasureSolver.solverMeasure(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean optimizeFor(int r5) {
        if ((this.mOptimizationLevel & r5) != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer r5) {
        this.mMeasurer = r5;
        this.mDependencyGraph.setMeasurer(r5);
    }

    public void setOptimizationLevel(int r5) {
        this.mOptimizationLevel = r5;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int r5, int r10, int r11, int r12) {
        this.mPaddingLeft = r5;
        this.mPaddingTop = r10;
        this.mPaddingRight = r11;
        this.mPaddingBottom = r12;
    }

    public void setRtl(boolean r5) {
        this.mIsRtl = r5;
    }

    public void updateChildrenFromSolver(LinearSystem r5, boolean[] r10) {
        int r11 = 0;
        r10[2] = false;
        boolean r12 = optimizeFor(64);
        updateFromSolver(r5, r12);
        int r13 = this.mChildren.size();
    L3:
        if (r11 >= r13) goto L5;
        this.mChildren.get(r11).updateFromSolver(r5, r12);
        r11 = r11 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromRuns(boolean r5, boolean r10) {
        super.updateFromRuns(r5, r10);
        int r11 = this.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildren.get(r12).updateFromRuns(r5, r10);
        r12 = r12 + 1;
        goto L3
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public static boolean measure(ConstraintWidget r10, BasicMeasure.Measurer r11, BasicMeasure.Measure r12, int r13) {
        if (r11 != null) goto L5;
        return false;
    L5:
        r12.horizontalBehavior = r10.getHorizontalDimensionBehaviour();
        r12.verticalBehavior = r10.getVerticalDimensionBehaviour();
        r12.horizontalDimension = r10.getWidth();
        r12.verticalDimension = r10.getHeight();
        r12.measuredNeedsSolverPass = false;
        r12.measureStrategy = r13;
        ConstraintWidget.DimensionBehaviour r14 = r12.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r5) goto L8;
        boolean r15 = true;
    L10:
        if (r12.verticalBehavior != r5) goto L12;
        boolean r16 = true;
    L14:
        if (r15 == true) goto L16;
    L18:
        boolean r17 = false;
    L19:
        if (r16 == true) goto L21;
    L23:
        boolean r18 = false;
    L24:
        if (r15 == true) goto L26;
    L36:
        if (r16 == false) goto L49;
        if (r10.hasDanglingDimension(1) == false) goto L49;
        if (r10.mMatchConstraintDefaultHeight != 0) goto L49;
        if (r18 == true) goto L49;
        r12.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r15 == true) goto L45;
    L47:
        r16 = false;
        goto L49
    L45:
        if (r10.mMatchConstraintDefaultWidth != 0) goto L47;
        r12.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L49:
        if (r10.isResolvedHorizontally() == false) goto L52;
        r12.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r15 = false;
    L52:
        if (r10.isResolvedVertically() == false) goto L55;
        r12.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r16 = false;
    L55:
        if (r17 == true) goto L57;
    L70:
        if (r18 == true) goto L72;
    L85:
        r11.measure(r10, r12);
        r10.setWidth(r12.measuredWidth);
        r10.setHeight(r12.measuredHeight);
        r10.setHasBaseline(r12.measuredHasBaseline);
        r10.setBaselineDistance(r12.measuredBaseline);
        r12.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r12.measuredNeedsSolverPass;
    L72:
        if (r10.mResolvedMatchConstraintDefault[1] != 4) goto L74;
        r12.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L74:
        if (r15 == true) goto L85;
        ConstraintWidget.DimensionBehaviour r19 = r12.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r19 != r20) goto L78;
        int r110 = r12.horizontalDimension;
    L79:
        r12.verticalBehavior = r20;
        int r21 = r10.mDimensionRatioSide;
        if (r21 == 0) goto L84;
        if (r21 == (-1)) goto L84;
        r12.verticalDimension = (int) (r10.getDimensionRatio() * r110);
    L84:
        r12.verticalDimension = (int) (r110 / r10.getDimensionRatio());
        goto L85
    L78:
        r12.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r11.measure(r10, r12);
        r110 = r12.measuredWidth;
        goto L79
    L57:
        if (r10.mResolvedMatchConstraintDefault[0] != 4) goto L59;
        r12.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L70
    L59:
        if (r16 == true) goto L70;
        ConstraintWidget.DimensionBehaviour r22 = r12.verticalBehavior;
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r22 != r23) goto L63;
        int r24 = r12.verticalDimension;
    L64:
        r12.horizontalBehavior = r23;
        int r25 = r10.mDimensionRatioSide;
        if (r25 == 0) goto L69;
        if (r25 == (-1)) goto L69;
        r12.horizontalDimension = (int) (r10.getDimensionRatio() / r24);
    L69:
        r12.horizontalDimension = (int) (r10.getDimensionRatio() * r24);
        goto L70
    L63:
        r12.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r11.measure(r10, r12);
        r24 = r12.measuredHeight;
        goto L64
    L26:
        if (r10.hasDanglingDimension(0) == false) goto L36;
        if (r10.mMatchConstraintDefaultWidth != 0) goto L36;
        if (r17 == true) goto L36;
        r12.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 == true) goto L33;
    L35:
        r15 = false;
        goto L36
    L33:
        if (r10.mMatchConstraintDefaultHeight != 0) goto L35;
        r12.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L35
    L21:
        if (r10.mDimensionRatio <= 0.0f) goto L23;
        r18 = true;
        goto L24
    L16:
        if (r10.mDimensionRatio <= 0.0f) goto L18;
        r17 = true;
        goto L19
    L12:
        r16 = false;
        goto L14
    L8:
        r15 = false;
        goto L10
    }

    public ConstraintWidgetContainer(int r5, int r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r5, int r10) {
        super(r5, r10);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String r5, int r10, int r11) {
        super(r10, r11);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(r5);
    }
}
