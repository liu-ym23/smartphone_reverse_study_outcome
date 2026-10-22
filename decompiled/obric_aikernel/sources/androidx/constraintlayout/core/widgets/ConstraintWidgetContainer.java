package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
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

    public ConstraintWidgetContainer(int r10, int r11) {
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
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r10, int r11, int r12, int r13) {
        super(r10, r11, r12, r13);
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

    public ConstraintWidgetContainer(String r10, int r11, int r12) {
        super(r11, r12);
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
        setDebugName(r10);
    }

    private void addHorizontalChain(ConstraintWidget r10) {
        int r11 = this.mHorizontalChainsSize + 1;
        ChainHead[] r12 = this.mHorizontalChainsArray;
        if (r11 < r12.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r10, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.mSystem.createObjectVariable(r10);
        this.mSystem.addGreaterThan(r11, r12, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor r10, SolverVariable r11) {
        SolverVariable r12 = this.mSystem.createObjectVariable(r10);
        this.mSystem.addGreaterThan(r12, r11, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget r10) {
        int r11 = this.mVerticalChainsSize + 1;
        ChainHead[] r12 = this.mVerticalChainsArray;
        if (r11 < r12.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(r12, r12.length * 2);
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r10, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public static boolean measure(int r10, ConstraintWidget r11, BasicMeasure.Measurer r12, BasicMeasure.Measure r13, int r14) {
        if (r12 != null) goto L6;
        return false;
    L6:
        if (r11.getVisibility() != 8) goto L8;
    L88:
        r13.measuredWidth = 0;
        r13.measuredHeight = 0;
        return false;
    L8:
        if ((r11 instanceof Guideline) == true) goto L88;
        if ((r11 instanceof Barrier) == true) goto L88;
        r13.horizontalBehavior = r11.getHorizontalDimensionBehaviour();
        r13.verticalBehavior = r11.getVerticalDimensionBehaviour();
        r13.horizontalDimension = r11.getWidth();
        r13.verticalDimension = r11.getHeight();
        r13.measuredNeedsSolverPass = false;
        r13.measureStrategy = r14;
        ConstraintWidget.DimensionBehaviour r15 = r13.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r15 != r16) goto L15;
        boolean r17 = true;
    L17:
        if (r13.verticalBehavior != r16) goto L19;
        boolean r18 = true;
    L21:
        if (r17 == true) goto L23;
    L25:
        boolean r19 = false;
    L26:
        if (r18 == true) goto L28;
    L30:
        boolean r20 = false;
    L31:
        if (r17 == true) goto L33;
    L43:
        if (r18 == false) goto L56;
        if (r11.hasDanglingDimension(1) == false) goto L56;
        if (r11.mMatchConstraintDefaultHeight != 0) goto L56;
        if (r20 == true) goto L56;
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r17 == true) goto L52;
    L54:
        r18 = false;
        goto L56
    L52:
        if (r11.mMatchConstraintDefaultWidth != 0) goto L54;
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r11.isResolvedHorizontally() == false) goto L59;
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r17 = false;
    L59:
        if (r11.isResolvedVertically() == false) goto L62;
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r18 = false;
    L62:
        if (r19 == true) goto L64;
    L72:
        if (r20 == true) goto L74;
    L86:
        r12.measure(r11, r13);
        r11.setWidth(r13.measuredWidth);
        r11.setHeight(r13.measuredHeight);
        r11.setHasBaseline(r13.measuredHasBaseline);
        r11.setBaselineDistance(r13.measuredBaseline);
        r13.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r13.measuredNeedsSolverPass;
    L74:
        if (r11.mResolvedMatchConstraintDefault[1] != 4) goto L76;
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L86
    L76:
        if (r17 == true) goto L86;
        ConstraintWidget.DimensionBehaviour r21 = r13.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r22 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r21 != r22) goto L80;
        int r23 = r13.horizontalDimension;
    L81:
        r13.verticalBehavior = r22;
        if (r11.getDimensionRatioSide() != (-1)) goto L84;
        int r24 = (int) (r23 / r11.getDimensionRatio());
    L85:
        r13.verticalDimension = r24;
        goto L86
    L84:
        r24 = (int) (r11.getDimensionRatio() * r23);
        goto L85
    L80:
        r13.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r23 = r13.measuredWidth;
        goto L81
    L64:
        if (r11.mResolvedMatchConstraintDefault[0] != 4) goto L66;
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r18 == true) goto L72;
        ConstraintWidget.DimensionBehaviour r25 = r13.verticalBehavior;
        ConstraintWidget.DimensionBehaviour r26 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r25 != r26) goto L70;
        int r27 = r13.verticalDimension;
    L71:
        r13.horizontalBehavior = r26;
        r13.horizontalDimension = (int) (r11.getDimensionRatio() * r27);
        goto L72
    L70:
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r12.measure(r11, r13);
        r27 = r13.measuredHeight;
        goto L71
    L33:
        if (r11.hasDanglingDimension(0) == false) goto L43;
        if (r11.mMatchConstraintDefaultWidth != 0) goto L43;
        if (r19 == true) goto L43;
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 == true) goto L40;
    L42:
        r17 = false;
        goto L43
    L40:
        if (r11.mMatchConstraintDefaultHeight != 0) goto L42;
        r13.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r11.mDimensionRatio <= 0.0f) goto L30;
        r20 = true;
        goto L31
    L23:
        if (r11.mDimensionRatio <= 0.0f) goto L25;
        r19 = true;
        goto L26
    L19:
        r18 = false;
        goto L21
    L15:
        r17 = false;
        goto L17
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget r10, int r11) {
        if (r11 != 0) goto L5;
        addHorizontalChain(r10);
        return;
    L5:
        if (r11 != 1) goto L9;
        addVerticalChain(r10);
        return;
    }

    public boolean addChildrenToSolver(LinearSystem r13) {
        boolean r10 = optimizeFor(64);
        addToSolver(r13, r10);
        int r11 = this.mChildren.size();
        int r12 = 0;
        boolean r14 = false;
    L4:
        if (r12 >= r11) goto L9;
        ConstraintWidget r15 = this.mChildren.get(r12);
        r15.setInBarrier(0, false);
        r15.setInBarrier(1, false);
        if ((r15 instanceof Barrier) == false) goto L8;
        r14 = true;
    L8:
        r12 = r12 + 1;
        goto L4
    L9:
        if (r14 == false) goto L16;
        int r16 = 0;
    L11:
        if (r16 >= r11) goto L16;
        ConstraintWidget r17 = this.mChildren.get(r16);
        if ((r17 instanceof Barrier) == false) goto L15;
        ((Barrier) r17).markWidgets();
    L15:
        r16 = r16 + 1;
    L16:
        this.widgetsToAdd.clear();
        int r18 = 0;
    L17:
        if (r18 >= r11) goto L26;
        ConstraintWidget r19 = this.mChildren.get(r18);
        if (r19.addFirst() == false) goto L24;
        if ((r19 instanceof VirtualLayout) == false) goto L23;
        this.widgetsToAdd.add(r19);
        goto L24
    L23:
        r19.addToSolver(r13, r10);
    L24:
        r18 = r18 + 1;
    L26:
        if (this.widgetsToAdd.size() <= 0) goto L41;
        int r20 = this.widgetsToAdd.size();
        Iterator<ConstraintWidget> r21 = this.widgetsToAdd.iterator();
    L29:
        if (r21.hasNext() == false) goto L34;
        VirtualLayout r22 = (VirtualLayout) r21.next();
        if (r22.contains(this.widgetsToAdd) == false) goto L29;
        r22.addToSolver(r13, r10);
        this.widgetsToAdd.remove(r22);
    L34:
        if (r20 != this.widgetsToAdd.size()) goto L26;
        Iterator<ConstraintWidget> r23 = this.widgetsToAdd.iterator();
    L37:
        if (r23.hasNext() == false) goto L39;
        r23.next().addToSolver(r13, r10);
        goto L37
    L39:
        this.widgetsToAdd.clear();
        goto L26
    L41:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L56;
        HashSet<ConstraintWidget> r24 = new HashSet();
        int r25 = 0;
    L43:
        if (r25 >= r11) goto L49;
        ConstraintWidget r26 = this.mChildren.get(r25);
        if (r26.addFirst() == true) goto L47;
        r24.add(r26);
    L47:
        r25 = r25 + 1;
        goto L43
    L49:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r110 = 0;
    L52:
        addChildrenToSolverByDependency(this, r13, r24, r110, false);
        Iterator<ConstraintWidget> r27 = r24.iterator();
    L54:
        if (r27.hasNext() == false) goto L75;
        ConstraintWidget r28 = r27.next();
        Optimizer.checkMatchParent(this, r13, r28);
        r28.addToSolver(r13, r10);
    L75:
        if (this.mHorizontalChainsSize <= 0) goto L78;
        Chain.applyChainConstraints(this, r13, null, 0);
    L78:
        if (this.mVerticalChainsSize <= 0) goto L80;
        Chain.applyChainConstraints(this, r13, null, 1);
    L80:
        return true;
    L51:
        r110 = 1;
        goto L52
    L56:
        int r29 = 0;
    L57:
        if (r29 >= r11) goto L75;
        ConstraintWidget r30 = this.mChildren.get(r29);
        if ((r30 instanceof ConstraintWidgetContainer) == false) goto L70;
        ConstraintWidget.DimensionBehaviour[] r31 = r30.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r32 = r31[0];
        ConstraintWidget.DimensionBehaviour r33 = r31[1];
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r32 != r34) goto L63;
        r30.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L63:
        if (r33 != r34) goto L65;
        r30.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L65:
        r30.addToSolver(r13, r10);
        if (r32 != r34) goto L68;
        r30.setHorizontalDimensionBehaviour(r32);
    L68:
        if (r33 != r34) goto L73;
        r30.setVerticalDimensionBehaviour(r33);
    L73:
        r29 = r29 + 1;
        goto L57
    L70:
        Optimizer.checkMatchParent(this, r13, r30);
        if (r30.addFirst() == true) goto L73;
        r30.addToSolver(r13, r10);
        goto L73
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r10) {
        WeakReference<ConstraintAnchor> r11 = this.horizontalWrapMax;
        if (r11 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r10) {
        WeakReference<ConstraintAnchor> r11 = this.horizontalWrapMin;
        if (r11 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) goto L8;
    }

    void addVerticalWrapMaxVariable(ConstraintAnchor r10) {
        WeakReference<ConstraintAnchor> r11 = this.verticalWrapMax;
        if (r11 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) goto L8;
    }

    void addVerticalWrapMinVariable(ConstraintAnchor r10) {
        WeakReference<ConstraintAnchor> r11 = this.verticalWrapMin;
        if (r11 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r10);
        return;
    L5:
        if (r11.get() == null) goto L8;
        if (r10.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) goto L8;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean r10) {
        return this.mDependencyGraph.directMeasure(r10);
    }

    public boolean directMeasureSetup(boolean r10) {
        return this.mDependencyGraph.directMeasureSetup(r10);
    }

    public boolean directMeasureWithOrientation(boolean r10, int r11) {
        return this.mDependencyGraph.directMeasureWithOrientation(r10, r11);
    }

    public void fillMetrics(Metrics r10) {
        this.mMetrics = r10;
        this.mSystem.fillMetrics(r10);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r10 = new ArrayList();
        int r11 = this.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = this.mChildren.get(r12);
        if ((r13 instanceof Guideline) == false) goto L9;
        Guideline r14 = (Guideline) r13;
        if (r14.getOrientation() != 0) goto L9;
        r10.add(r14);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r10;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder r10) {
        r10.append(this.stringId + ":{\n");
        r10.append("  actualWidth:" + this.mWidth);
        r10.append("\n");
        r10.append("  actualHeight:" + this.mHeight);
        r10.append("\n");
        Iterator<ConstraintWidget> r11 = getChildren().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().getSceneString(r10);
        r10.append(",\n");
        goto L4
    L6:
        r10.append("}");
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r10 = new ArrayList();
        int r11 = this.mChildren.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = this.mChildren.get(r12);
        if ((r13 instanceof Guideline) == false) goto L9;
        Guideline r14 = (Guideline) r13;
        if (r14.getOrientation() != 1) goto L9;
        r10.add(r14);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return r10;
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
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    public void layout() {
        int r10 = 0;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r11 = this.mChildren.size();
        int r12 = Math.max(0, getWidth());
        int r13 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] r14 = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r15 = r14[1];
        ConstraintWidget.DimensionBehaviour r16 = r14[0];
        Metrics r17 = this.mMetrics;
        if (r17 == null) goto L6;
        r17.layouts++;
    L6:
        if (this.pass != 0) goto L34;
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L34;
        Direct.solvingPass(this, getMeasurer());
        int r18 = 0;
    L10:
        if (r18 >= r11) goto L34;
        ConstraintWidget r19 = this.mChildren.get(r18);
        if (r19.isMeasureRequested() == false) goto L32;
        if ((r19 instanceof Guideline) == true) goto L32;
        if ((r19 instanceof Barrier) == true) goto L32;
        if ((r19 instanceof VirtualLayout) == true) goto L32;
        if (r19.isInVirtualLayout() == true) goto L32;
        ConstraintWidget.DimensionBehaviour r110 = r19.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r111 = r19.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r112 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 == r112) goto L24;
    L29:
        boolean r113 = false;
    L30:
        if (r113 == true) goto L32;
        measure(0, r19, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L32
    L24:
        if (r19.mMatchConstraintDefaultWidth == 1) goto L29;
        if (r111 != r112) goto L29;
        if (r19.mMatchConstraintDefaultHeight == 1) goto L29;
        r113 = true;
    L32:
        r18 = r18 + 1;
    L34:
        if (r11 <= 2) goto L55;
        ConstraintWidget.DimensionBehaviour r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r16 == r20) goto L39;
        if (r15 != r20) goto L55;
    L39:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L55;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L55;
        if (r16 == r20) goto L44;
    L48:
        if (r15 == r20) goto L50;
    L54:
        int r21 = r13;
        int r22 = r12;
        boolean r23 = true;
    L57:
        if (optimizeFor(64) == false) goto L59;
    L62:
        boolean r114 = true;
    L63:
        LinearSystem r115 = this.mSystem;
        r115.graphOptimizer = false;
        r115.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L67;
        if (r114 == false) goto L67;
        r115.newgraphOptimizer = true;
    L67:
        ArrayList<ConstraintWidget> r116 = this.mChildren;
        ConstraintWidget.DimensionBehaviour r117 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r118 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r117 != r118) goto L70;
    L73:
        boolean r119 = true;
    L74:
        resetChains();
        int r120 = 0;
    L75:
        if (r120 >= r11) goto L80;
        ConstraintWidget r121 = this.mChildren.get(r120);
        if ((r121 instanceof WidgetContainer) == false) goto L79;
        ((WidgetContainer) r121).layout();
    L79:
        r120 = r120 + 1;
        goto L75
    L80:
        boolean r122 = optimizeFor(64);
        ?? r123 = r23;
        int r24 = 0;
        boolean r124 = true;
    L81:
        if (r124 == false) goto L161;
        int r125 = r24 + 1;
        this.mSystem.reset();     // Catch: Exception -> L109
        resetChains();     // Catch: Exception -> L109
        createObjectVariables(this.mSystem);     // Catch: Exception -> L109
        int r25 = r10;
    L84:
        if (r25 >= r11) goto L86;
        this.mChildren.get(r25).createObjectVariables(this.mSystem);     // Catch: Exception -> L109
        r25 = r25 + 1;     // Catch: Exception -> L109
        goto L84
    L86:
        r124 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L109
        WeakReference<ConstraintAnchor> r26 = this.verticalWrapMin;     // Catch: Exception -> L109
        if (r26 != null) goto L89;
    L91:
        WeakReference<ConstraintAnchor> r27 = this.verticalWrapMax;     // Catch: Exception -> L109
        if (r27 != null) goto L94;
    L96:
        WeakReference<ConstraintAnchor> r28 = this.horizontalWrapMin;     // Catch: Exception -> L109
        if (r28 != null) goto L99;
    L101:
        WeakReference<ConstraintAnchor> r29 = this.horizontalWrapMax;     // Catch: Exception -> L109
        if (r29 != null) goto L104;
    L106:
        if (r124 == false) goto L111;
        this.mSystem.minimize();     // Catch: Exception -> L109
    L111:
        LinearSystem r30 = this.mSystem;
        if (r124 == false) goto L114;
        boolean r31 = updateChildrenFromSolver(r30, Optimizer.flags);
    L119:
        if (r119 == false) goto L135;
        if (r125 >= 8) goto L135;
        if (Optimizer.flags[2] == false) goto L135;
        int r32 = 0;
        int r33 = 0;
        int r126 = 0;
    L124:
        if (r32 >= r11) goto L126;
        ConstraintWidget r34 = this.mChildren.get(r32);
        r126 = Math.max(r126, r34.mX + r34.getWidth());
        r33 = Math.max(r33, r34.mY + r34.getHeight());
        r32 = r32 + 1;
        r31 = r31;
        goto L124
    L126:
        boolean r127 = r31;
        int r35 = Math.max(this.mMinWidth, r126);
        int r36 = Math.max(this.mMinHeight, r33);
        ConstraintWidget.DimensionBehaviour r37 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r123 = r123;
        if (r16 != r37) goto L131;
        r123 = r123;
        if (getWidth() >= r35) goto L131;
        setWidth(r35);
        this.mListDimensionBehaviors[0] = r37;
        r123 = 1;
        r127 = true;
    L131:
        if (r15 == r37) goto L133;
    L136:
        int r38 = Math.max(this.mMinWidth, getWidth());
        ?? r128 = r123;
        if (r38 <= getWidth()) goto L139;
        setWidth(r38);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r128 = 1;
        r127 = true;
    L139:
        int r39 = Math.max(this.mMinHeight, getHeight());
        if (r39 <= getHeight()) goto L142;
        setHeight(r39);
        ?? r40 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r41 = 1;
        r127 = true;
    L143:
        if (r41 != 0) goto L156;
        ConstraintWidget.DimensionBehaviour r42 = this.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r129 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r41 = r41;
        r41 = r41;
        if (r42 != r129) goto L151;
        if (r22 <= 0) goto L151;
        r41 = r41;
        if (getWidth() <= r22) goto L151;
        this.mWidthMeasuredTooSmall = r40;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r22);
        ?? r43 = r40;
        r127 = r43 == true ? 1 : 0;
        r41 = r43;
    L151:
        if (this.mListDimensionBehaviors[r40] != r129) goto L156;
        if (r21 <= 0) goto L156;
        if (getHeight() <= r21) goto L156;
        this.mHeightMeasuredTooSmall = r40;
        this.mListDimensionBehaviors[r40] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r21);
        int r44 = 8;
        boolean r45 = true;
        ?? r130 = 1;
    L157:
        if (r125 <= r44) goto L159;
        r124 = false;
    L160:
        r24 = r125;
        r10 = 0;
        r123 = r130;
        goto L81
    L159:
        r124 = r45;
    L156:
        r130 = r41;
        r45 = r127;
        r44 = 8;
        goto L157
    L142:
        r40 = 1;
        r41 = r128;
        goto L143
    L133:
        if (getHeight() >= r36) goto L136;
        setHeight(r36);
        this.mListDimensionBehaviors[1] = r37;
        r123 = 1;
        r127 = true;
    L135:
        r127 = r31;
        goto L136
    L114:
        updateFromSolver(r30, r122);
        int r46 = 0;
    L115:
        if (r46 >= r11) goto L117;
        this.mChildren.get(r46).updateFromSolver(this.mSystem, r122);
        r46 = r46 + 1;
        goto L115
    L117:
        r31 = false;
        goto L119
    L104:
        if (r29.get() == null) goto L106;
        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L109
        this.horizontalWrapMax = null;     // Catch: Exception -> L109
        goto L106
    L99:
        if (r28.get() == null) goto L101;
        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L109
        this.horizontalWrapMin = null;     // Catch: Exception -> L109
        goto L101
    L94:
        if (r27.get() == null) goto L96;
        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L109
        this.verticalWrapMax = null;     // Catch: Exception -> L109
        goto L96
    L89:
        if (r26.get() == null) goto L91;
        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L109
        this.verticalWrapMin = null;     // Catch: Exception -> L109
    L109:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L111
    L161:
        this.mChildren = r116;
        if (r123 == 0) goto L164;
        ConstraintWidget.DimensionBehaviour[] r47 = this.mListDimensionBehaviors;
        r47[0] = r16;
        r47[1] = r15;
    L164:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L70:
        if (getVerticalDimensionBehaviour() == r118) goto L73;
        r119 = false;
        goto L74
    L59:
        if (optimizeFor(128) == true) goto L62;
        r114 = false;
        goto L63
    L50:
        if (r13 >= getHeight()) goto L53;
        if (r13 <= 0) goto L53;
        setHeight(r13);
        this.mHeightMeasuredTooSmall = true;
    L53:
        r13 = getHeight();
        goto L54
    L44:
        if (r12 >= getWidth()) goto L47;
        if (r12 <= 0) goto L47;
        setWidth(r12);
        this.mWidthMeasuredTooSmall = true;
    L47:
        r12 = getWidth();
    L55:
        r21 = r13;
        r22 = r12;
        r23 = false;
        goto L57
    }

    public long measure(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.mPaddingLeft = r19;
        this.mPaddingTop = r20;
        return this.mBasicMeasureSolver.solverMeasure(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean optimizeFor(int r10) {
        if ((this.mOptimizationLevel & r10) != r10) goto L5;
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

    public void setMeasurer(BasicMeasure.Measurer r10) {
        this.mMeasurer = r10;
        this.mDependencyGraph.setMeasurer(r10);
    }

    public void setOptimizationLevel(int r10) {
        this.mOptimizationLevel = r10;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int r10, int r11, int r12, int r13) {
        this.mPaddingLeft = r10;
        this.mPaddingTop = r11;
        this.mPaddingRight = r12;
        this.mPaddingBottom = r13;
    }

    public void setPass(int r10) {
        this.pass = r10;
    }

    public void setRtl(boolean r10) {
        this.mIsRtl = r10;
    }

    public boolean updateChildrenFromSolver(LinearSystem r10, boolean[] r11) {
        int r12 = 0;
        r11[2] = false;
        boolean r13 = optimizeFor(64);
        updateFromSolver(r10, r13);
        int r14 = this.mChildren.size();
        boolean r15 = false;
    L3:
        if (r12 >= r14) goto L8;
        ConstraintWidget r16 = this.mChildren.get(r12);
        r16.updateFromSolver(r10, r13);
        if (r16.hasDimensionOverride() == false) goto L7;
        r15 = true;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r15;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean r10, boolean r11) {
        super.updateFromRuns(r10, r11);
        int r12 = this.mChildren.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        this.mChildren.get(r13).updateFromRuns(r10, r11);
        r13 = r13 + 1;
        goto L3
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}
