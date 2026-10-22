package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    static int myCounter;
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
    private int pass;
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;
    HashSet<ConstraintWidget> widgetsToAdd;

    static {
    }

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
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r3, int r4) {
        super(r3, r4);
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
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
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
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String r3, int r4, int r5) {
        super(r4, r5);
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
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(r3);
    }

    private void addHorizontalChain(ConstraintWidget r6) {
        int r0 = this.mHorizontalChainsSize + 1;
        ChainHead[] r1 = this.mHorizontalChainsArray;
        if (r0 < r1.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), ChainHead[].class, "com.obric.memorydata.plugin");
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r6, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r4, r5, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r5, r4, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget r6) {
        int r0 = this.mVerticalChainsSize + 1;
        ChainHead[] r2 = this.mVerticalChainsArray;
        if (r0 < r2.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), ChainHead[].class, "com.obric.memorydata.plugin");
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r6, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public static boolean measure(int r5, ConstraintWidget r6, BasicMeasure.Measurer r7, BasicMeasure.Measure r8, int r9) {
        BasicMeasure.Measurer r10 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r7, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r6.getVisibility() != 8) goto L8;
    L88:
        r8.measuredWidth = 0;
        r8.measuredHeight = 0;
        return false;
    L8:
        if (ZeusTransformUtils.instanceOf(r6, Guideline.class) == true) goto L88;
        if (ZeusTransformUtils.instanceOf(r6, Barrier.class) == true) goto L88;
        r8.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        r8.verticalBehavior = r6.getVerticalDimensionBehaviour();
        r8.horizontalDimension = r6.getWidth();
        r8.verticalDimension = r6.getHeight();
        r8.measuredNeedsSolverPass = false;
        r8.measureStrategy = r9;
        if (r8.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L15;
        boolean r11 = true;
    L17:
        if (r8.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        boolean r0 = true;
    L21:
        if (r11 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r0 == true) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r11 == true) goto L33;
    L43:
        if (r0 == false) goto L56;
        if (r6.hasDanglingDimension(1) == false) goto L56;
        if (r6.mMatchConstraintDefaultHeight != 0) goto L56;
        if (r2 == true) goto L56;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 == true) goto L52;
    L54:
        r0 = false;
        goto L56
    L52:
        if (r6.mMatchConstraintDefaultWidth != 0) goto L54;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r6.isResolvedHorizontally() == false) goto L59;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r11 = false;
    L59:
        if (r6.isResolvedVertically() == false) goto L62;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r0 = false;
    L62:
        if (r3 == true) goto L64;
    L72:
        if (r2 == true) goto L74;
    L86:
        r10.measure(r6, r8);
        r6.setWidth(r8.measuredWidth);
        r6.setHeight(r8.measuredHeight);
        r6.setHasBaseline(r8.measuredHasBaseline);
        r6.setBaselineDistance(r8.measuredBaseline);
        r8.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r8.measuredNeedsSolverPass;
    L74:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L76;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L86
    L76:
        if (r11 == true) goto L86;
        if (r8.horizontalBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L80;
        int r12 = r8.horizontalDimension;
    L81:
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r6.getDimensionRatioSide() != (-1)) goto L84;
        int r13 = (int) (r12 / r6.getDimensionRatio());
    L85:
        r8.verticalDimension = r13;
        goto L86
    L84:
        r13 = (int) (r6.getDimensionRatio() * r12);
        goto L85
    L80:
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r10.measure(r6, r8);
        r12 = r8.measuredWidth;
        goto L81
    L64:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L66;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r0 == true) goto L72;
        if (r8.verticalBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L70;
        int r14 = r8.verticalDimension;
    L71:
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r8.horizontalDimension = (int) (r6.getDimensionRatio() * r14);
        goto L72
    L70:
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r10.measure(r6, r8);
        r14 = r8.measuredHeight;
        goto L71
    L33:
        if (r6.hasDanglingDimension(0) == false) goto L43;
        if (r6.mMatchConstraintDefaultWidth != 0) goto L43;
        if (r3 == true) goto L43;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 == true) goto L40;
    L42:
        r11 = false;
        goto L43
    L40:
        if (r6.mMatchConstraintDefaultHeight != 0) goto L42;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r6.mDimensionRatio <= 0.0f) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r6.mDimensionRatio <= 0.0f) goto L25;
        r3 = true;
        goto L26
    L19:
        r0 = false;
        goto L21
    L15:
        r11 = false;
        goto L17
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget r2, int r3) {
        if (r3 != 0) goto L5;
        addHorizontalChain(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        addVerticalChain(r2);
        return;
    }

    public boolean addChildrenToSolver(LinearSystem r14) {
        boolean r0 = optimizeFor(64);
        addToSolver(r14, r0);
        int r1 = this.mChildren.size();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L9;
        ConstraintWidget r5 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r3), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r5.setInBarrier(0, false);
        r5.setInBarrier(1, false);
        if (ZeusTransformUtils.instanceOf(r5, Barrier.class) == false) goto L8;
        r4 = true;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r4 == false) goto L16;
        int r6 = 0;
    L11:
        if (r6 >= r1) goto L16;
        ConstraintWidget r7 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Barrier.class) == false) goto L15;
        ((Barrier) ZeusTransformUtils.preCheckCast(r7, Barrier.class, "com.obric.memorydata.plugin")).markWidgets();
    L15:
        r6 = r6 + 1;
    L16:
        this.widgetsToAdd.clear();
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L26;
        ConstraintWidget r9 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r8), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r9.addFirst() == false) goto L24;
        if (ZeusTransformUtils.instanceOf(r9, VirtualLayout.class) == false) goto L23;
        this.widgetsToAdd.add(r9);
        goto L24
    L23:
        r9.addToSolver(r14, r0);
    L24:
        r8 = r8 + 1;
    L26:
        if (this.widgetsToAdd.size() <= 0) goto L41;
        int r10 = this.widgetsToAdd.size();
        Iterator<ConstraintWidget> r11 = this.widgetsToAdd.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        VirtualLayout r12 = (VirtualLayout) ZeusTransformUtils.preCheckCast((ConstraintWidget) ZeusTransformUtils.preCheckCast(r11.next(), ConstraintWidget.class, "com.obric.memorydata.plugin"), VirtualLayout.class, "com.obric.memorydata.plugin");
        if (r12.contains(this.widgetsToAdd) == false) goto L29;
        r12.addToSolver(r14, r0);
        this.widgetsToAdd.remove(r12);
    L34:
        if (r10 != this.widgetsToAdd.size()) goto L26;
        Iterator<ConstraintWidget> r13 = this.widgetsToAdd.iterator();
    L37:
        if (r13.hasNext() == false) goto L39;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r13.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).addToSolver(r14, r0);
        goto L37
    L39:
        this.widgetsToAdd.clear();
        goto L26
    L41:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L56;
        HashSet<ConstraintWidget> r15 = new HashSet();
        int r16 = 0;
    L43:
        if (r16 >= r1) goto L49;
        ConstraintWidget r17 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r16), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r17.addFirst() == true) goto L47;
        r15.add(r17);
    L47:
        r16 = r16 + 1;
        goto L43
    L49:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r18 = 0;
    L52:
        addChildrenToSolverByDependency(this, r14, r15, r18, false);
        Iterator<ConstraintWidget> r2 = r15.iterator();
    L54:
        if (r2.hasNext() == false) goto L77;
        ConstraintWidget r19 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r2.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        Optimizer.checkMatchParent(this, r14, r19);
        r19.addToSolver(r14, r0);
    L77:
        if (this.mHorizontalChainsSize <= 0) goto L80;
        Chain.applyChainConstraints(this, r14, null, 0);
    L80:
        if (this.mVerticalChainsSize <= 0) goto L82;
        Chain.applyChainConstraints(this, r14, null, 1);
    L82:
        return true;
    L51:
        r18 = 1;
        goto L52
    L56:
        int r20 = 0;
    L57:
        if (r20 >= r1) goto L77;
        ConstraintWidget r21 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r20), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r21, ConstraintWidgetContainer.class) == false) goto L72;
        ConstraintWidget.DimensionBehaviour r22 = r21.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r23 = r21.mListDimensionBehaviors[1];
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L64;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L64:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L66;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L66:
        r21.addToSolver(r14, r0);
        if (r22 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L70;
        r21.setHorizontalDimensionBehaviour(r22);
    L70:
        if (r23 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L75;
        r21.setVerticalDimensionBehaviour(r23);
    L75:
        r20 = r20 + 1;
        goto L57
    L72:
        Optimizer.checkMatchParent(this, r14, r21);
        if (r21.addFirst() == true) goto L75;
        r21.addToSolver(r14, r0);
        goto L75
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.getFinalValue() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.horizontalWrapMax.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.getFinalValue() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.horizontalWrapMin.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).getFinalValue()) goto L8;
    }

    void addVerticalWrapMaxVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.getFinalValue() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.verticalWrapMax.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).getFinalValue()) goto L8;
    }

    void addVerticalWrapMinVariable(ConstraintAnchor r5) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r5);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r5.getFinalValue() > ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.verticalWrapMin.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).getFinalValue()) goto L8;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean r1) {
        return this.mDependencyGraph.directMeasure(r1);
    }

    public boolean directMeasureSetup(boolean r1) {
        return this.mDependencyGraph.directMeasureSetup(r1);
    }

    public boolean directMeasureWithOrientation(boolean r1, int r2) {
        return this.mDependencyGraph.directMeasureWithOrientation(r1, r2);
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mSystem.fillMetrics(r1);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r2), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Guideline.class) == false) goto L9;
        Guideline r4 = (Guideline) ZeusTransformUtils.preCheckCast(r3, Guideline.class, "com.obric.memorydata.plugin");
        if (r4.getOrientation() != 0) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder r4) {
        r4.append(this.stringId + ":{\n");
        r4.append("  actualWidth:" + this.mWidth);
        r4.append("\n");
        r4.append("  actualHeight:" + this.mHeight);
        r4.append("\n");
        Iterator<ConstraintWidget> r3 = getChildren().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintWidget.class, "com.obric.memorydata.plugin")).getSceneString(r4);
        r4.append(",\n");
        goto L4
    L6:
        r4.append("}");
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r2), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Guideline.class) == false) goto L9;
        Guideline r4 = (Guideline) ZeusTransformUtils.preCheckCast(r3, Guideline.class, "com.obric.memorydata.plugin");
        if (r4.getOrientation() != 1) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
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
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v35 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38 */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v40 */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v42 */
    /* JADX WARN: Type inference failed for: r11v43 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v47 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [boolean] */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    public void layout() {
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r3 = this.mChildren.size();
        int r0 = Math.max(0, getWidth());
        int r4 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour r5 = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour r7 = this.mListDimensionBehaviors[0];
        Metrics r8 = this.mMetrics;
        if (r8 == null) goto L6;
        r8.layouts++;
    L6:
        if (this.pass != 0) goto L35;
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L35;
        Direct.solvingPass(this, getMeasurer());
        int r9 = 0;
    L10:
        if (r9 >= r3) goto L35;
        ConstraintWidget r10 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r9), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r10.isMeasureRequested() == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, Guideline.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, Barrier.class) == true) goto L33;
        if (ZeusTransformUtils.instanceOf(r10, VirtualLayout.class) == true) goto L33;
        if (r10.isInVirtualLayout() == true) goto L33;
        ConstraintWidget.DimensionBehaviour r11 = r10.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r12 = r10.getDimensionBehaviour(1);
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
    L30:
        boolean r13 = false;
    L31:
        if (r13 == true) goto L33;
        measure(0, r10, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L33
    L24:
        if (r10.mMatchConstraintDefaultWidth == 1) goto L30;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        if (r10.mMatchConstraintDefaultHeight == 1) goto L30;
        r13 = true;
    L33:
        r9 = r9 + 1;
    L35:
        if (r3 > 2) goto L37;
    L59:
        int r14 = r4;
        int r6 = r0;
        boolean r1 = false;
    L61:
        if (optimizeFor(64) == false) goto L63;
    L66:
        boolean r15 = true;
    L67:
        this.mSystem.graphOptimizer = false;
        this.mSystem.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L71;
        if (r15 == false) goto L71;
        this.mSystem.newgraphOptimizer = true;
    L71:
        ArrayList<ConstraintWidget> r16 = this.mChildren;
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L74;
    L77:
        boolean r17 = true;
    L78:
        resetChains();
        int r18 = 0;
    L79:
        if (r18 >= r3) goto L84;
        ConstraintWidget r2 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r18), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, WidgetContainer.class) == false) goto L83;
        ((WidgetContainer) ZeusTransformUtils.preCheckCast(r2, WidgetContainer.class, "com.obric.memorydata.plugin")).layout();
    L83:
        r18 = r18 + 1;
        goto L79
    L84:
        boolean r19 = optimizeFor(64);
        ?? r110 = r1;
        boolean r111 = true;
        int r20 = 0;
    L85:
        if (r111 == false) goto L167;
        int r112 = r20 + 1;
        this.mSystem.reset();     // Catch: Exception -> L113
        resetChains();     // Catch: Exception -> L113
        createObjectVariables(this.mSystem);     // Catch: Exception -> L113
        int r21 = 0;
    L88:
        if (r21 >= r3) goto L90;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r21), ConstraintWidget.class, "com.obric.memorydata.plugin")).createObjectVariables(this.mSystem);     // Catch: Exception -> L113
        r21 = r21 + 1;     // Catch: Exception -> L113
        goto L88
    L90:
        boolean r113 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L113
        WeakReference<ConstraintAnchor> r22 = this.verticalWrapMin;     // Catch: Exception -> L113
        if (r22 != null) goto L93;
    L95:
        WeakReference<ConstraintAnchor> r23 = this.verticalWrapMax;     // Catch: Exception -> L113
        if (r23 != null) goto L98;
    L100:
        WeakReference<ConstraintAnchor> r24 = this.horizontalWrapMin;     // Catch: Exception -> L113
        if (r24 != null) goto L103;
    L105:
        WeakReference<ConstraintAnchor> r25 = this.horizontalWrapMax;     // Catch: Exception -> L113
        if (r25 != null) goto L108;
    L110:
        if (r113 == false) goto L115;
        this.mSystem.minimize();     // Catch: Exception -> L113
    L115:
        LinearSystem r26 = this.mSystem;
        if (r113 == false) goto L118;
        boolean r27 = updateChildrenFromSolver(r26, Optimizer.flags);
    L123:
        if (r17 == false) goto L141;
        if (r112 >= 8) goto L141;
        if (Optimizer.flags[2] == false) goto L141;
        int r28 = 0;
        int r29 = 0;
        int r114 = 0;
    L128:
        boolean r115 = r27;
        if (r29 >= r3) goto L131;
        ConstraintWidget r30 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r29), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r114 = Math.max(r114, r30.mX + r30.getWidth());
        r28 = Math.max(r28, r30.mY + r30.getHeight());
        r29 = r29 + 1;
        r27 = r115 ? 1 : 0;
        r19 = r19;
        goto L128
    L131:
        boolean r116 = r19;
        int r31 = Math.max(this.mMinWidth, r114);
        int r32 = Math.max(this.mMinHeight, r28);
        ?? r117 = r110;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L136;
        r117 = r110;
        if (getWidth() >= r31) goto L136;
        setWidth(r31);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r117 = 1;
        r115 = true;
    L136:
        ?? r118 = r117;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L142;
        r118 = r117;
        if (getHeight() >= r32) goto L142;
        setHeight(r32);
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r118 = 1;
        r115 = true;
    L142:
        int r33 = Math.max(this.mMinWidth, getWidth());
        ?? r119 = r118;
        if (r33 <= getWidth()) goto L145;
        setWidth(r33);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r119 = 1;
        r115 = true;
    L145:
        int r34 = Math.max(this.mMinHeight, getHeight());
        if (r34 <= getHeight()) goto L148;
        setHeight(r34);
        ?? r35 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r120 = 1;
        r115 = true;
    L149:
        if (r120 != 0) goto L162;
        r120 = r120;
        r120 = r120;
        if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L157;
        if (r6 <= 0) goto L157;
        r120 = r120;
        if (getWidth() <= r6) goto L157;
        this.mWidthMeasuredTooSmall = r35;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r6);
        ?? r121 = r35;
        r115 = r121 == true ? 1 : 0;
        r120 = r121;
    L157:
        if (this.mListDimensionBehaviors[r35] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L162;
        if (r14 <= 0) goto L162;
        if (getHeight() <= r14) goto L162;
        this.mHeightMeasuredTooSmall = r35;
        this.mListDimensionBehaviors[r35] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r14);
        int r36 = 8;
        boolean r37 = true;
        ?? r122 = 1;
    L163:
        if (r112 <= r36) goto L165;
        r111 = false;
    L166:
        r20 = r112;
        r19 = r116;
        r110 = r122;
        goto L85
    L165:
        r111 = r37;
    L162:
        r37 = r115;
        r36 = 8;
        r122 = r120;
        goto L163
    L148:
        r35 = 1;
        r120 = r119;
    L141:
        r115 = r27 ? 1 : 0;
        r116 = r19;
        r118 = r110;
        goto L142
    L118:
        updateFromSolver(r26, r19);
        int r38 = 0;
    L119:
        if (r38 >= r3) goto L121;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r38), ConstraintWidget.class, "com.obric.memorydata.plugin")).updateFromSolver(this.mSystem, r19);
        r38 = r38 + 1;
        goto L119
    L121:
        r27 = false;
        goto L123
    L108:
        if (r25.get() == null) goto L110;
        addMaxWrap((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.horizontalWrapMax.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L113
        this.horizontalWrapMax = null;     // Catch: Exception -> L113
        goto L110
    L103:
        if (r24.get() == null) goto L105;
        addMinWrap((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.horizontalWrapMin.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L113
        this.horizontalWrapMin = null;     // Catch: Exception -> L113
        goto L105
    L98:
        if (r23.get() == null) goto L100;
        addMaxWrap((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.verticalWrapMax.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L113
        this.verticalWrapMax = null;     // Catch: Exception -> L113
        goto L100
    L93:
        if (r22.get() == null) goto L95;
        addMinWrap((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.verticalWrapMin.get(), ConstraintAnchor.class, "com.obric.memorydata.plugin"), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L113
        this.verticalWrapMin = null;     // Catch: Exception -> L113
    L113:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        r113 = r111 ? 1 : 0;
        goto L115
    L167:
        this.mChildren = (ArrayList) ZeusTransformUtils.preCheckCast(r16, ArrayList.class, "com.obric.memorydata.plugin");
        if (r110 == 0) goto L170;
        this.mListDimensionBehaviors[0] = r7;
        this.mListDimensionBehaviors[1] = r5;
    L170:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L74:
        if (getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L77;
        r17 = false;
        goto L78
    L63:
        if (optimizeFor(128) == true) goto L66;
        r15 = false;
        goto L67
    L37:
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L41;
        if (r5 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L59;
    L41:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L59;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L59;
        if (r7 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        if (r0 >= getWidth()) goto L50;
        if (r0 <= 0) goto L50;
        setWidth(r0);
        this.mWidthMeasuredTooSmall = true;
    L50:
        r0 = getWidth();
    L52:
        if (r5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L54;
    L58:
        r14 = r4;
        r6 = r0;
        r1 = true;
        goto L61
    L54:
        if (r4 >= getHeight()) goto L57;
        if (r4 <= 0) goto L57;
        setHeight(r4);
        this.mHeightMeasuredTooSmall = true;
    L57:
        r4 = getHeight();
        goto L58
    }

    public long measure(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.mPaddingLeft = r19;
        this.mPaddingTop = r20;
        return this.mBasicMeasureSolver.solverMeasure(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean optimizeFor(int r1) {
        if ((this.mOptimizationLevel & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer r3) {
        BasicMeasure.Measurer r4 = (BasicMeasure.Measurer) ZeusTransformUtils.wrapperContextForParams(r3, BasicMeasure.Measurer.class, "com.obric.memorydata.plugin");
        this.mMeasurer = r4;
        this.mDependencyGraph.setMeasurer(r4);
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int r1, int r2, int r3, int r4) {
        this.mPaddingLeft = r1;
        this.mPaddingTop = r2;
        this.mPaddingRight = r3;
        this.mPaddingBottom = r4;
    }

    public void setPass(int r1) {
        this.pass = r1;
    }

    public void setRtl(boolean r1) {
        this.mIsRtl = r1;
    }

    public boolean updateChildrenFromSolver(LinearSystem r7, boolean[] r8) {
        int r1 = 0;
        r8[2] = false;
        boolean r9 = optimizeFor(64);
        updateFromSolver(r7, r9);
        int r0 = this.mChildren.size();
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        ConstraintWidget r3 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        r3.updateFromSolver(r7, r9);
        if (r3.hasDimensionOverride() == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean r6, boolean r7) {
        super.updateFromRuns(r6, r7);
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((ConstraintWidget) ZeusTransformUtils.preCheckCast(this.mChildren.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin")).updateFromRuns(r6, r7);
        r1 = r1 + 1;
        goto L3
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}
