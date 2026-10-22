package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
    public static final int WRAP_BEHAVIOR_INCLUDED = 0;
    public static final int WRAP_BEHAVIOR_SKIPPED = 3;
    public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    public WidgetFrame frame;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean horizontalSolvingPass;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    private boolean mAnimated;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    private int mHeightOverride;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtualLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    private int mWidthOverride;
    private int mWrapBehaviorInParent;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public String stringId;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;
    private boolean verticalSolvingPass;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r10 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r10;
            r10[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r11 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r11;
            r11[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
            return;
        }
    }

    public static final enum DimensionBehaviour extends Enum<DimensionBehaviour> {
        private static final /* synthetic */ DimensionBehaviour[] $VALUES = null;
        public static final DimensionBehaviour FIXED = null;
        public static final DimensionBehaviour MATCH_CONSTRAINT = null;
        public static final DimensionBehaviour MATCH_PARENT = null;
        public static final DimensionBehaviour WRAP_CONTENT = null;

        static {
            DimensionBehaviour r10 = new DimensionBehaviour("FIXED", 0);
            FIXED = r10;
            DimensionBehaviour r11 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r11;
            DimensionBehaviour r12 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r12;
            DimensionBehaviour r13 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r13;
            $VALUES = new DimensionBehaviour[]{r10, r11, r12, r13};
        }

        private DimensionBehaviour(String r10, int r11) {
            super(r10, r11);
        }

        public static DimensionBehaviour valueOf(String r10) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, r10);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) $VALUES.clone();
        }
    }

    static {
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r10 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r10;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r10};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r11 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r11, r11};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r12 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r12;
        this.mVerticalBiasPercent = r12;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    public ConstraintWidget(int r10, int r11) {
        this(0, 0, r10, r11);
    }

    public ConstraintWidget(int r11, int r12, int r13, int r14) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r10 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r10;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r10};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r15 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r15, r15};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r16 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r16;
        this.mVerticalBiasPercent = r16;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = r11;
        this.mY = r12;
        this.mWidth = r13;
        this.mHeight = r14;
        addAnchors();
    }

    public ConstraintWidget(String r11) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
        this.frame = new WidgetFrame(this);
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mWrapBehaviorInParent = 0;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtualLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r10 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r10;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r10};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r12 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r12, r12};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float r13 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r13;
        this.mVerticalBiasPercent = r13;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mAnimated = false;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(r11);
    }

    public ConstraintWidget(String r10, int r11, int r12) {
        this(r11, r12);
        setDebugName(r10);
    }

    public ConstraintWidget(String r10, int r11, int r12, int r13, int r14) {
        this(r11, r12, r13, r14);
        setDebugName(r10);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    private void applyConstraints(LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, SolverVariable r37, SolverVariable r38, DimensionBehaviour r39, boolean r40, ConstraintAnchor r41, ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        SolverVariable r10 = r32.createObjectVariable(r41);
        SolverVariable r11 = r32.createObjectVariable(r42);
        SolverVariable r12 = r32.createObjectVariable(r41.getTarget());
        SolverVariable r13 = r32.createObjectVariable(r42.getTarget());
        if (LinearSystem.getMetrics() == null) goto L5;
        LinearSystem.getMetrics().nonresolvedWidgets++;
    L5:
        boolean r14 = r41.isConnected();
        boolean r15 = r42.isConnected();
        boolean r16 = this.mCenter.isConnected();
        if (r15 == false) goto L8;
        int r17 = (r14 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r17 = r17 + 1;
    L11:
        if (r48 == false) goto L13;
        int r18 = 3;
    L14:
        int r19 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r39.ordinal()];
        if (r19 != 1) goto L17;
    L22:
        int r20 = r18;
    L23:
        boolean r110 = false;
    L27:
        int r111 = this.mWidthOverride;
        if (r111 == (-1)) goto L31;
        if (r33 == false) goto L31;
        this.mWidthOverride = -1;
        r110 = false;
    L32:
        int r21 = this.mHeightOverride;
        if (r21 == (-1)) goto L37;
        if (r33 == true) goto L37;
        this.mHeightOverride = -1;
        r111 = r21;
        r110 = false;
    L37:
        if (this.mVisibility != 8) goto L39;
        r111 = 0;
        r110 = false;
    L39:
        if (r58 == false) goto L47;
        if (r14 == true) goto L44;
        if (r15 == true) goto L44;
        if (r16 == true) goto L44;
        r32.addEquality(r10, r43);
    L44:
        if (r14 == false) goto L47;
        if (r15 == true) goto L47;
        r32.addEquality(r10, r12, r41.getMargin(), 8);
    L47:
        if (r110 == true) goto L58;
        if (r40 == false) goto L55;
        r32.addEquality(r11, r10, 0, 3);
        if (r45 <= 0) goto L53;
        r32.addGreaterThan(r11, r10, r45, 8);
    L53:
        if (r46 >= Integer.MAX_VALUE) goto L56;
        r32.addLowerThan(r11, r10, r46, 8);
    L56:
        int r22 = r56;
        int r410 = r17;
        boolean r23 = r110;
        boolean r112 = r36;
        int r24 = r55;
    L111:
        if (r58 == false) goto L348;
        if (r50 == false) goto L114;
        int r25 = 0;
        char r26 = 2;
    L349:
        if (r410 >= r26) goto L381;
        if (r34 == false) goto L382;
        if (r112 == false) goto L383;
        r32.addGreaterThan(r10, r37, r25, 8);
        if (r33 == false) goto L355;
    L358:
        int r113 = 1;
    L359:
        if (r33 == true) goto L370;
        ConstraintAnchor r27 = this.mBaseline.mTarget;
        if (r27 == null) goto L370;
        ConstraintWidget r28 = r27.mOwner;
        if (r28.mDimensionRatio == 0.0f) goto L369;
        DimensionBehaviour[] r29 = r28.mListDimensionBehaviors;
        DimensionBehaviour r30 = r29[r25];
        DimensionBehaviour r31 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r30 != r31) goto L369;
        if (r29[1] != r31) goto L369;
        int r114 = 1;
    L371:
        if (r114 == 0) goto L384;
        r32.addGreaterThan(r38, r11, r25, 8);
        return;
    L384:
        return;
    L369:
        r114 = r25;
    L370:
        r114 = r113;
        goto L371
    L355:
        if (this.mBaseline.mTarget == null) goto L358;
        r113 = r25;
        goto L359
    L383:
        return;
    L382:
        return;
    L381:
        return;
    L114:
        if (r14 == true) goto L118;
        if (r15 == true) goto L118;
        if (r16 == true) goto L118;
        int r59 = 5;
        int r60 = 0;
    L326:
        boolean r210 = r34;
    L327:
        int r61 = r59;
    L328:
        if (r210 == false) goto L378;
        if (r112 == true) goto L331;
        return;
    L331:
        if (r42.mTarget == null) goto L333;
        int r115 = r42.getMargin();
    L334:
        if (r13 != r38) goto L336;
        return;
    L336:
        if (this.OPTIMIZE_WRAP == true) goto L338;
    L346:
        r32.addGreaterThan(r38, r11, r115, r61);
        return;
    L338:
        if (r11.isFinalValue == false) goto L346;
        ConstraintWidget r62 = this.mParent;
        if (r62 == null) goto L346;
        ConstraintWidgetContainer r63 = (ConstraintWidgetContainer) r62;
        if (r33 == false) goto L344;
        r63.addHorizontalWrapMaxVariable(r42);
        return;
    L344:
        r63.addVerticalWrapMaxVariable(r42);
        return;
    L333:
        r115 = r60;
        goto L334
    L378:
        return;
    L118:
        if (r14 == false) goto L128;
        if (r15 == true) goto L128;
        ConstraintWidget r64 = r41.mTarget.mOwner;
        if (r34 == true) goto L123;
    L125:
        int r116 = 5;
    L126:
        r210 = r34;
        r60 = 0;
        r61 = r116;
        r11 = r11;
        goto L328
    L123:
        if ((r64 instanceof Barrier) == false) goto L125;
        r116 = 8;
    L128:
        if (r14 == true) goto L144;
        if (r15 == false) goto L144;
        r32.addEquality(r11, r13, -r42.getMargin(), 8);
        if (r34 == true) goto L133;
    L325:
        r60 = 0;
        r59 = 5;
        goto L326
    L133:
        if (this.OPTIMIZE_WRAP == true) goto L135;
    L142:
        r59 = 5;
        r32.addGreaterThan(r10, r37, 0, 5);
        r60 = 0;
        goto L326
    L135:
        if (r10.isFinalValue == false) goto L142;
        ConstraintWidget r65 = this.mParent;
        if (r65 == null) goto L142;
        ConstraintWidgetContainer r66 = (ConstraintWidgetContainer) r65;
        if (r33 == false) goto L141;
        r66.addHorizontalWrapMinVariable(r41);
        goto L325
    L141:
        r66.addVerticalWrapMinVariable(r41);
    L144:
        if (r14 == false) goto L325;
        if (r15 == false) goto L325;
        ConstraintWidget r117 = r41.mTarget.mOwner;
        ConstraintWidget r67 = r42.mTarget.mOwner;
        ConstraintWidget r68 = getParent();
        int r118 = 6;
        if (r23 == false) goto L218;
        if (r20 != 0) goto L167;
        if (r22 != 0) goto L158;
        if (r24 != 0) goto L158;
        if (r12.isFinalValue == true) goto L154;
    L157:
        boolean r119 = false;
        boolean r211 = false;
        int r69 = 8;
        int r70 = 8;
        boolean r212 = true;
    L160:
        if ((r117 instanceof Barrier) == false) goto L162;
    L166:
        r38 = r38;
        int r71 = r69;
        r118 = 6;
        boolean r213 = r212;
        boolean r214 = r119;
        int r120 = 4;
    L235:
        if (r211 == false) goto L239;
        if (r12 != r13) goto L239;
        if (r117 == r68) goto L239;
        r211 = false;
        boolean r215 = false;
    L240:
        if (r214 == false) goto L249;
        if (r23 == true) goto L247;
        if (r49 == true) goto L247;
        if (r51 == true) goto L247;
        if (r12 != r37) goto L247;
        if (r13 != r38) goto L247;
        r210 = false;
        int r216 = 8;
        int r217 = 8;
        boolean r218 = false;
    L248:
        int r310 = r20;
        ConstraintWidget r219 = r68;
        r32.addCentering(r10, r12, r41.getMargin(), r47, r13, r11, r42.getMargin(), r217);
        r71 = r216;
        r215 = r218;
    L251:
        if (this.mVisibility == 8) goto L253;
    L255:
        if (r211 == false) goto L265;
        if (r210 == false) goto L264;
        if (r12 == r13) goto L264;
        if (r23 == true) goto L264;
        if ((r117 instanceof Barrier) == false) goto L262;
    L263:
        r71 = 6;
        goto L264
    L262:
        if ((r67 instanceof Barrier) == true) goto L263;
    L264:
        r32.addGreaterThan(r10, r12, r41.getMargin(), r71);
        r11 = r11;
        r32.addLowerThan(r11, r13, -r42.getMargin(), r71);
    L266:
        if (r210 == false) goto L275;
        if (r52 == false) goto L275;
        if ((r117 instanceof Barrier) == true) goto L275;
        if ((r67 instanceof Barrier) == true) goto L275;
        ConstraintWidget r72 = r219;
        if (r67 == r72) goto L276;
        r71 = 6;
        int r73 = 6;
        r215 = true;
    L277:
        if (r215 == false) goto L308;
        if (r213 == false) goto L299;
        if (r51 == false) goto L281;
        if (r35 == false) goto L299;
    L281:
        if (r117 == r72) goto L285;
        if (r67 == r72) goto L285;
        int r74 = r73;
    L287:
        if ((r117 instanceof Guideline) == false) goto L289;
    L290:
        r74 = 5;
    L292:
        if ((r117 instanceof Barrier) == false) goto L294;
    L295:
        r74 = 5;
    L296:
        if (r51 == false) goto L298;
        r74 = 5;
    L298:
        r73 = Math.max(r74, r73);
        goto L299
    L294:
        if ((r67 instanceof Barrier) == false) goto L296;
    L289:
        if ((r67 instanceof Guideline) == false) goto L292;
    L285:
        r74 = 6;
    L299:
        if (r210 == false) goto L307;
        int r75 = Math.min(r71, r73);
        if (r48 == false) goto L306;
        if (r51 == true) goto L306;
        if (r117 == r72) goto L305;
        if (r67 != r72) goto L306;
    L305:
        r73 = 4;
    L306:
        r73 = r75;
    L307:
        r32.addEquality(r10, r12, r41.getMargin(), r73);
        r32.addEquality(r11, r13, -r42.getMargin(), r73);
    L308:
        if (r210 == true) goto L310;
    L315:
        if (r210 == false) goto L324;
        if (r23 == false) goto L324;
        if (r45 != 0) goto L324;
        if (r24 != 0) goto L324;
        if (r23 == true) goto L321;
    L323:
        r60 = 0;
        r59 = 5;
        r32.addGreaterThan(r11, r10, 0, 5);
        goto L327
    L321:
        if (r310 != 3) goto L323;
        r60 = 0;
        r32.addGreaterThan(r11, r10, 0, 8);
        r59 = 5;
    L324:
        r59 = 5;
        r60 = 0;
        goto L327
    L310:
        if (r37 != r12) goto L312;
        int r76 = r41.getMargin();
    L313:
        if (r12 == r37) goto L315;
        r32.addGreaterThan(r10, r37, r76, 5);
        goto L315
    L312:
        r76 = 0;
    L276:
        r73 = r120;
    L275:
        r72 = r219;
        goto L276
    L265:
        r11 = r11;
        goto L266
    L253:
        if (r42.hasDependents() == true) goto L255;
        return;
    L247:
        r210 = r34;
        r217 = r118;
        r218 = r215;
        r216 = r71;
        goto L248
    L249:
        r310 = r20;
        r219 = r68;
        r210 = r34;
    L239:
        r215 = true;
        goto L240
    L162:
        if ((r67 instanceof Barrier) == true) goto L166;
        r213 = r212;
        r214 = r119;
        r120 = r70;
    L165:
        r71 = r69;
        r118 = 6;
        goto L235
    L154:
        if (r13.isFinalValue == false) goto L157;
        r32.addEquality(r10, r12, r41.getMargin(), 8);
        r32.addEquality(r11, r13, -r42.getMargin(), 8);
        return;
    L158:
        r212 = false;
        r69 = 5;
        r70 = 5;
        r119 = true;
        r211 = true;
        goto L160
    L167:
        if (r20 != 2) goto L176;
        if ((r117 instanceof Barrier) == true) goto L231;
        if ((r67 instanceof Barrier) == true) goto L231;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 5;
    L233:
        r214 = true;
        r211 = true;
    L234:
        r213 = false;
    L231:
        r71 = 5;
    L232:
        r120 = 4;
        goto L233
    L176:
        if (r20 != 1) goto L179;
        r71 = 8;
        goto L232
    L179:
        if (r20 == 3) goto L181;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 4;
        r214 = false;
        r211 = false;
        goto L234
    L181:
        if (this.mResolvedDimensionRatioSide == (-1)) goto L183;
        if (r48 == true) goto L193;
        if (r22 <= 0) goto L205;
        r118 = 6;
        r71 = 5;
    L189:
        r120 = 5;
    L190:
        r214 = true;
        r211 = true;
        r213 = true;
        goto L235
    L205:
        if (r22 != 0) goto L214;
        if (r24 != 0) goto L214;
        if (r51 == true) goto L209;
        r38 = r38;
        r118 = 6;
        r71 = 5;
        r120 = 8;
        goto L190
    L209:
        if (r117 == r68) goto L212;
        if (r67 == r68) goto L212;
        int r77 = 4;
    L213:
        r71 = r77;
    L215:
        r120 = 4;
    L212:
        r77 = 5;
    L214:
        r71 = 5;
        goto L215
    L193:
        if (r54 != 2) goto L195;
    L198:
        boolean r78 = true;
    L199:
        if (r78 == true) goto L201;
        r69 = 8;
        int r79 = 5;
    L202:
        r120 = r79;
        r214 = true;
        r211 = true;
        r213 = true;
        goto L165
    L201:
        r69 = 5;
        r79 = 4;
        goto L202
    L195:
        if (r54 == 1) goto L198;
        r78 = false;
        goto L199
    L183:
        if (r51 == false) goto L187;
        if (r34 == false) goto L186;
        r118 = 5;
    L188:
        r71 = 8;
        goto L189
    L186:
        r118 = 4;
        goto L188
    L187:
        r118 = 8;
        goto L188
    L218:
        if (r12.isFinalValue == false) goto L231;
        if (r13.isFinalValue == false) goto L231;
        r32.addCentering(r10, r12, r41.getMargin(), r47, r13, r11, r42.getMargin(), 8);
        if (r34 == false) goto L374;
        if (r112 == true) goto L225;
        return;
    L225:
        if (r42.mTarget == null) goto L227;
        int r121 = r42.getMargin();
    L228:
        if (r13 == r38) goto L376;
        r32.addGreaterThan(r38, r11, r121, 5);
        return;
    L376:
        return;
    L227:
        r121 = 0;
        goto L228
    L374:
        return;
    L348:
        r25 = 0;
        r26 = 2;
        goto L349
    L55:
        r32.addEquality(r11, r10, r111, 8);
        goto L56
    L58:
        if (r17 == 2) goto L68;
        if (r48 == true) goto L68;
        if (r20 == 1) goto L63;
        if (r20 != 0) goto L68;
    L63:
        int r80 = Math.max(r55, r111);
        if (r56 <= 0) goto L66;
        r80 = Math.min(r56, r80);
    L66:
        r32.addEquality(r11, r10, r80, 8);
        r112 = r36;
        r22 = r56;
        r410 = r17;
        r23 = false;
        r24 = r55;
    L68:
        if (r55 != (-2)) goto L70;
        int r81 = r111;
    L71:
        if (r56 != (-2)) goto L73;
        r22 = r111;
    L74:
        if (r111 > 0) goto L76;
    L78:
        if (r81 <= 0) goto L80;
        r32.addGreaterThan(r11, r10, r81, 8);
        r111 = Math.max(r111, r81);
    L80:
        if (r22 <= 0) goto L90;
        if (r34 == true) goto L83;
    L85:
        boolean r82 = true;
    L86:
        if (r82 == false) goto L88;
        int r83 = 8;
        r32.addLowerThan(r11, r10, r22, 8);
    L89:
        r111 = Math.min(r111, r22);
    L92:
        if (r20 != 1) goto L98;
        if (r34 == false) goto L95;
        r32.addEquality(r11, r10, r111, r83);
    L96:
        r410 = r17;
        r23 = r110;
        r112 = r36;
        r24 = r81;
        goto L111
    L95:
        r32.addEquality(r11, r10, r111, 5);
        r32.addLowerThan(r11, r10, r111, r83);
        goto L96
    L98:
        if (r20 != 2) goto L110;
        ConstraintAnchor.Type r84 = r41.getType();
        ConstraintAnchor.Type r85 = ConstraintAnchor.Type.TOP;
        if (r84 != r85) goto L102;
    L105:
        SolverVariable r86 = r32.createObjectVariable(this.mParent.getAnchor(r85));
        ConstraintWidget r87 = this.mParent;
        ConstraintAnchor.Type r122 = ConstraintAnchor.Type.BOTTOM;
    L106:
        SolverVariable r88 = r32.createObjectVariable(r87.getAnchor(r122));
        SolverVariable r220 = r86;
        ArrayRow r89 = r32.createRow();
        r410 = r17 == true ? 1 : 0;
        r24 = r81;
        r32.addConstraint(r89.createRowDimensionRatio(r11, r10, r88, r220, r57));
        if (r34 == false) goto L109;
        r110 = false;
    L109:
        r23 = r110;
        r112 = r36;
        goto L111
    L102:
        if (r41.getType() == ConstraintAnchor.Type.BOTTOM) goto L105;
        r86 = r32.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        r87 = this.mParent;
        r122 = ConstraintAnchor.Type.RIGHT;
        goto L106
    L110:
        r410 = r17;
        r24 = r81;
        r23 = r110;
        r112 = true;
        goto L111
    L88:
        r83 = 8;
        goto L89
    L83:
        if (r20 != 1) goto L85;
        r82 = false;
        goto L86
    L90:
        r83 = 8;
        goto L92
    L76:
        if (r20 == 1) goto L78;
        r111 = 0;
        goto L78
    L73:
        r22 = r56;
        goto L74
    L70:
        r81 = r55;
    L31:
        r111 = r44;
        goto L32
    L17:
        if (r19 == 2) goto L22;
        if (r19 == 3) goto L22;
        if (r19 != 4) goto L22;
        r20 = r18;
        if (r20 == 4) goto L23;
        r110 = true;
        goto L27
    L13:
        r18 = r53;
        goto L14
    L8:
        r17 = r14 ? 1 : 0;
        goto L9
    }

    private void getSceneString(StringBuilder r10, String r11, int r12, int r13, int r14, int r15, int r16, int r17, float r18, float r19) {
        r10.append(r11);
        r10.append(" :  {\n");
        serializeAttribute(r10, "      size", r12, 0);
        serializeAttribute(r10, "      min", r13, 0);
        serializeAttribute(r10, "      max", r14, Integer.MAX_VALUE);
        serializeAttribute(r10, "      matchMin", r16, 0);
        serializeAttribute(r10, "      matchDef", r17, 0);
        serializeAttribute(r10, "      matchPercent", r18, 1.0f);
        r10.append("    },\n");
    }

    private void getSceneString(StringBuilder r10, String r11, ConstraintAnchor r12) {
        if (r12.mTarget != null) goto L5;
        return;
    L5:
        r10.append("    ");
        r10.append(r11);
        r10.append(" : [ '");
        r10.append(r12.mTarget);
        r10.append("'");
        if (r12.mGoneMargin == Integer.MIN_VALUE) goto L8;
    L9:
        r10.append(",");
        r10.append(r12.mMargin);
        if (r12.mGoneMargin == Integer.MIN_VALUE) goto L12;
        r10.append(",");
        r10.append(r12.mGoneMargin);
        r10.append(",");
    L12:
        r10.append(" ] ,\n");
        return;
    L8:
        if (r12.mMargin == 0) goto L12;
        goto L9
    }

    private boolean isChainHead(int r10) {
        int r11 = r10 * 2;
        ConstraintAnchor[] r12 = this.mListAnchors;
        if (r12[r11].mTarget != null) goto L5;
    L11:
        return false;
    L5:
        if (r12[r11].mTarget.mTarget == r12[r11]) goto L11;
        int r13 = r11 + 1;
        if (r12[r13].mTarget == null) goto L11;
        if (r12[r13].mTarget.mTarget != r12[r13]) goto L11;
        return true;
    }

    private void serializeAnchor(StringBuilder r10, String r11, ConstraintAnchor r12) {
        if (r12.mTarget != null) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" : [ '");
        r10.append(r12.mTarget);
        r10.append("',");
        r10.append(r12.mMargin);
        r10.append(",");
        r10.append(r12.mGoneMargin);
        r10.append(",");
        r10.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder r10, String r11, float r12, float r13) {
        if (r12 != r13) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" :   ");
        r10.append(r12);
        r10.append(",\n");
    }

    private void serializeAttribute(StringBuilder r10, String r11, int r12, int r13) {
        if (r12 != r13) goto L4;
        return;
    L4:
        r10.append(r11);
        r10.append(" :   ");
        r10.append(r12);
        r10.append(",\n");
    }

    private void serializeCircle(StringBuilder r10, ConstraintAnchor r11, float r12) {
        if (r11.mTarget != null) goto L5;
        return;
    L5:
        r10.append("circle : [ '");
        r10.append(r11.mTarget);
        r10.append("',");
        r10.append(r11.mMargin);
        r10.append(",");
        r10.append(r12);
        r10.append(",");
        r10.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder r10, String r11, float r12, int r13) {
        if (r12 != 0.0f) goto L5;
        return;
    L5:
        r10.append(r11);
        r10.append(" :  [");
        r10.append(r12);
        r10.append(",");
        r10.append(r13);
        r10.append("");
        r10.append("],\n");
    }

    private void serializeSize(StringBuilder r10, String r11, int r12, int r13, int r14, int r15, int r16, int r17, float r18, float r19) {
        r10.append(r11);
        r10.append(" :  {\n");
        serializeAttribute(r10, "size", r12, Integer.MIN_VALUE);
        serializeAttribute(r10, "min", r13, 0);
        serializeAttribute(r10, "max", r14, Integer.MAX_VALUE);
        serializeAttribute(r10, "matchMin", r16, 0);
        serializeAttribute(r10, "matchDef", r17, 0);
        serializeAttribute(r10, "matchPercent", r17, 1);
        r10.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer r10, LinearSystem r11, HashSet<ConstraintWidget> r12, int r13, boolean r14) {
        if (r14 == true) goto L4;
    L7:
        if (r13 != 0) goto L20;
        HashSet<ConstraintAnchor> r15 = this.mLeft.getDependents();
        if (r15 == null) goto L14;
        Iterator<ConstraintAnchor> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r16.next().mOwner.addChildrenToSolverByDependency(r10, r11, r12, r13, true);
    L14:
        HashSet<ConstraintAnchor> r17 = this.mRight.getDependents();
        if (r17 == null) goto L38;
        Iterator<ConstraintAnchor> r18 = r17.iterator();
    L18:
        if (r18.hasNext() == false) goto L45;
        r18.next().mOwner.addChildrenToSolverByDependency(r10, r11, r12, r13, true);
        goto L18
    L45:
        return;
    L38:
        return;
    L20:
        HashSet<ConstraintAnchor> r19 = this.mTop.getDependents();
        if (r19 == null) goto L26;
        Iterator<ConstraintAnchor> r110 = r19.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        r110.next().mOwner.addChildrenToSolverByDependency(r10, r11, r12, r13, true);
    L26:
        HashSet<ConstraintAnchor> r111 = this.mBottom.getDependents();
        if (r111 == null) goto L32;
        Iterator<ConstraintAnchor> r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        r112.next().mOwner.addChildrenToSolverByDependency(r10, r11, r12, r13, true);
    L32:
        HashSet<ConstraintAnchor> r20 = this.mBaseline.getDependents();
        if (r20 == null) goto L44;
        Iterator<ConstraintAnchor> r21 = r20.iterator();
    L36:
        if (r21.hasNext() == false) goto L46;
        r21.next().mOwner.addChildrenToSolverByDependency(r10, r11, r12, r13, true);
        goto L36
    L46:
        return;
    L44:
        return;
    L4:
        if (r12.contains(this) == true) goto L6;
        return;
    L6:
        Optimizer.checkMatchParent(r10, r11, this);
        r12.remove(this);
        addToSolver(r11, r10.optimizeFor(64));
        goto L7
    }

    boolean addFirst() {
        if ((this instanceof VirtualLayout) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Guideline) == true) goto L8;
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15631. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r54, boolean r55) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: IGET (r0v0 ?? I:androidx.constraintlayout.core.widgets.ConstraintAnchor) = (r53v0 'this' ?? I:androidx.constraintlayout.core.widgets.ConstraintWidget A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] androidx.constraintlayout.core.widgets.ConstraintWidget.mLeft androidx.constraintlayout.core.widgets.ConstraintAnchor in method: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 1563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void connect(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12) {
        connect(r10, r11, r12, 0);
    }

    public void connect(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13) {
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.CENTER;
        if (r10 != r14) goto L44;
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.LEFT;
        if (r12 != r14) goto L31;
        ConstraintAnchor r16 = getAnchor(r15);
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r18 = getAnchor(r17);
        ConstraintAnchor.Type r19 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r20 = getAnchor(r19);
        ConstraintAnchor.Type r21 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r22 = getAnchor(r21);
        boolean r23 = true;
        if (r16 != null) goto L9;
    L10:
        if (r18 != null) goto L12;
    L14:
        connect(r15, r11, r15, 0);
        connect(r17, r11, r17, 0);
        boolean r24 = true;
    L15:
        if (r20 != null) goto L17;
    L18:
        if (r22 != null) goto L20;
    L22:
        connect(r19, r11, r19, 0);
        connect(r21, r11, r21, 0);
    L23:
        if (r24 == false) goto L26;
        if (r23 == false) goto L26;
        ConstraintAnchor r25 = getAnchor(r14);
        ConstraintAnchor r26 = r11.getAnchor(r14);
    L43:
        r25.connect(r26, 0);
        return;
    L26:
        if (r24 == false) goto L29;
        ConstraintAnchor.Type r27 = ConstraintAnchor.Type.CENTER_X;
    L28:
        r25 = getAnchor(r27);
        r26 = r11.getAnchor(r27);
        goto L43
    L29:
        if (r23 == false) goto L100;
        r27 = ConstraintAnchor.Type.CENTER_Y;
        goto L28
    L100:
        return;
    L20:
        if (r22.isConnected() == false) goto L22;
    L21:
        r23 = false;
        goto L23
    L17:
        if (r20.isConnected() == true) goto L21;
    L12:
        if (r18.isConnected() == false) goto L14;
    L13:
        r24 = false;
        goto L15
    L9:
        if (r16.isConnected() == true) goto L13;
    L31:
        if (r12 != r15) goto L33;
    L40:
        connect(r15, r11, r12, 0);
        ConstraintAnchor.Type r28 = ConstraintAnchor.Type.RIGHT;
    L41:
        connect(r28, r11, r12, 0);
        r25 = getAnchor(r14);
    L42:
        r26 = r11.getAnchor(r12);
        goto L43
    L33:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L40;
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.TOP;
        if (r12 != r29) goto L38;
    L39:
        connect(r29, r11, r12, 0);
        r28 = ConstraintAnchor.Type.BOTTOM;
        goto L41
    L38:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L39;
        return;
    L44:
        ConstraintAnchor.Type r30 = ConstraintAnchor.Type.CENTER_X;
        if (r10 != r30) goto L51;
        ConstraintAnchor.Type r31 = ConstraintAnchor.Type.LEFT;
        if (r12 != r31) goto L49;
    L50:
        ConstraintAnchor r32 = getAnchor(r31);
        ConstraintAnchor r110 = r11.getAnchor(r12);
        ConstraintAnchor r111 = getAnchor(ConstraintAnchor.Type.RIGHT);
        r32.connect(r110, 0);
        r111.connect(r110, 0);
        getAnchor(r30).connect(r110, 0);
        return;
    L49:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L50;
    L51:
        ConstraintAnchor.Type r33 = ConstraintAnchor.Type.CENTER_Y;
        if (r10 != r33) goto L58;
        ConstraintAnchor.Type r34 = ConstraintAnchor.Type.TOP;
        if (r12 != r34) goto L56;
    L57:
        r26 = r11.getAnchor(r12);
        getAnchor(r34).connect(r26, 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r26, 0);
        r25 = getAnchor(r33);
        goto L43
    L56:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L57;
    L58:
        if (r10 != r30) goto L61;
        if (r12 != r30) goto L61;
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.LEFT;
        getAnchor(r35).connect(r11.getAnchor(r35), 0);
        ConstraintAnchor.Type r36 = ConstraintAnchor.Type.RIGHT;
        getAnchor(r36).connect(r11.getAnchor(r36), 0);
        r25 = getAnchor(r30);
    L61:
        if (r10 != r33) goto L64;
        if (r12 != r33) goto L64;
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.TOP;
        getAnchor(r37).connect(r11.getAnchor(r37), 0);
        ConstraintAnchor.Type r38 = ConstraintAnchor.Type.BOTTOM;
        getAnchor(r38).connect(r11.getAnchor(r38), 0);
        r25 = getAnchor(r33);
    L64:
        ConstraintAnchor r39 = getAnchor(r10);
        ConstraintAnchor r112 = r11.getAnchor(r12);
        if (r39.isValidConnection(r112) == false) goto L104;
        ConstraintAnchor.Type r113 = ConstraintAnchor.Type.BASELINE;
        if (r10 != r113) goto L74;
        ConstraintAnchor r40 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r41 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r40 == null) goto L71;
        r40.reset();
    L71:
        if (r41 != null) goto L88;
    L98:
        r39.connect(r112, r13);
        return;
    L88:
        r41.reset();
        goto L98
    L74:
        if (r10 != ConstraintAnchor.Type.TOP) goto L76;
    L89:
        ConstraintAnchor r114 = getAnchor(r113);
        if (r114 == null) goto L92;
        r114.reset();
    L92:
        ConstraintAnchor r115 = getAnchor(r14);
        if (r115.getTarget() == r112) goto L95;
        r115.reset();
    L95:
        ConstraintAnchor r42 = getAnchor(r10).getOpposite();
        r41 = getAnchor(r33);
        if (r41.isConnected() == false) goto L98;
    L87:
        r42.reset();
        goto L88
    L76:
        if (r10 == ConstraintAnchor.Type.BOTTOM) goto L89;
        if (r10 != ConstraintAnchor.Type.LEFT) goto L81;
    L82:
        ConstraintAnchor r116 = getAnchor(r14);
        if (r116.getTarget() == r112) goto L85;
        r116.reset();
    L85:
        r42 = getAnchor(r10).getOpposite();
        r41 = getAnchor(r30);
        if (r41.isConnected() == false) goto L98;
    L81:
        if (r10 != ConstraintAnchor.Type.RIGHT) goto L98;
    }

    public void connect(ConstraintAnchor r10, ConstraintAnchor r11, int r12) {
        if (r10.getOwner() != this) goto L6;
        connect(r10.getType(), r11.getOwner(), r11.getType(), r12);
        return;
    }

    public void connectCircularConstraint(ConstraintWidget r10, float r11, int r12) {
        ConstraintAnchor.Type r13 = ConstraintAnchor.Type.CENTER;
        immediateConnect(r13, r10, r13, r12, 0);
        this.mCircleConstraintAngle = r11;
    }

    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        this.mHorizontalResolution = r10.mHorizontalResolution;
        this.mVerticalResolution = r10.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = r10.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = r10.mMatchConstraintDefaultHeight;
        int[] r12 = this.mResolvedMatchConstraintDefault;
        int[] r13 = r10.mResolvedMatchConstraintDefault;
        r12[0] = r13[0];
        r12[1] = r13[1];
        this.mMatchConstraintMinWidth = r10.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = r10.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = r10.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = r10.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = r10.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = r10.mIsWidthWrapContent;
        this.mIsHeightWrapContent = r10.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = r10.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = r10.mResolvedDimensionRatio;
        int[] r14 = r10.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(r14, r14.length);
        this.mCircleConstraintAngle = r10.mCircleConstraintAngle;
        this.hasBaseline = r10.hasBaseline;
        this.inPlaceholder = r10.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget r15 = null;
        if (this.mParent != null) goto L5;
        ConstraintWidget r16 = null;
    L6:
        this.mParent = r16;
        this.mWidth = r10.mWidth;
        this.mHeight = r10.mHeight;
        this.mDimensionRatio = r10.mDimensionRatio;
        this.mDimensionRatioSide = r10.mDimensionRatioSide;
        this.mX = r10.mX;
        this.mY = r10.mY;
        this.mRelX = r10.mRelX;
        this.mRelY = r10.mRelY;
        this.mOffsetX = r10.mOffsetX;
        this.mOffsetY = r10.mOffsetY;
        this.mBaselineDistance = r10.mBaselineDistance;
        this.mMinWidth = r10.mMinWidth;
        this.mMinHeight = r10.mMinHeight;
        this.mHorizontalBiasPercent = r10.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = r10.mVerticalBiasPercent;
        this.mCompanionWidget = r10.mCompanionWidget;
        this.mContainerItemSkip = r10.mContainerItemSkip;
        this.mVisibility = r10.mVisibility;
        this.mAnimated = r10.mAnimated;
        this.mDebugName = r10.mDebugName;
        this.mType = r10.mType;
        this.mDistToTop = r10.mDistToTop;
        this.mDistToLeft = r10.mDistToLeft;
        this.mDistToRight = r10.mDistToRight;
        this.mDistToBottom = r10.mDistToBottom;
        this.mLeftHasCentered = r10.mLeftHasCentered;
        this.mRightHasCentered = r10.mRightHasCentered;
        this.mTopHasCentered = r10.mTopHasCentered;
        this.mBottomHasCentered = r10.mBottomHasCentered;
        this.mHorizontalWrapVisited = r10.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = r10.mVerticalWrapVisited;
        this.mHorizontalChainStyle = r10.mHorizontalChainStyle;
        this.mVerticalChainStyle = r10.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = r10.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = r10.mVerticalChainFixedPosition;
        float[] r17 = this.mWeight;
        float[] r18 = r10.mWeight;
        r17[0] = r18[0];
        r17[1] = r18[1];
        ConstraintWidget[] r19 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] r20 = r10.mListNextMatchConstraintsWidget;
        r19[0] = r20[0];
        r19[1] = r20[1];
        ConstraintWidget[] r21 = this.mNextChainWidget;
        ConstraintWidget[] r22 = r10.mNextChainWidget;
        r21[0] = r22[0];
        r21[1] = r22[1];
        ConstraintWidget r23 = r10.mHorizontalNextWidget;
        if (r23 != null) goto L9;
        ConstraintWidget r24 = null;
    L10:
        this.mHorizontalNextWidget = r24;
        ConstraintWidget r25 = r10.mVerticalNextWidget;
        if (r25 == null) goto L14;
        r15 = r11.get(r25);
    L14:
        this.mVerticalNextWidget = r15;
        return;
    L9:
        r24 = r11.get(r23);
        goto L10
    L5:
        r16 = r11.get(r10.mParent);
        goto L6
    }

    public void createObjectVariables(LinearSystem r10) {
        r10.createObjectVariable(this.mLeft);
        r10.createObjectVariable(this.mTop);
        r10.createObjectVariable(this.mRight);
        r10.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance <= 0) goto L6;
        r10.createObjectVariable(this.mBaseline);
        return;
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun != null) goto L6;
        this.horizontalRun = new HorizontalWidgetRun(this);
    L6:
        if (this.verticalRun != null) goto L9;
        this.verticalRun = new VerticalWidgetRun(this);
        return;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r10) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r10.ordinal()]) {
            case 1: goto L23;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L6;
            default: goto L5;
        };
    L6:
        return null;
    L5:
        throw new AssertionError(r10.name());
    L9:
        return this.mCenterY;
    L11:
        return this.mCenterX;
    L13:
        return this.mCenter;
    L15:
        return this.mBaseline;
    L17:
        return this.mBottom;
    L19:
        return this.mRight;
    L21:
        return this.mTop;
    L23:
        return this.mLeft;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int r10) {
        if (r10 != 0) goto L6;
        return this.mHorizontalBiasPercent;
    L6:
        if (r10 == 1) goto L8;
        return -1.0f;
    L8:
        return this.mVerticalBiasPercent;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int r10) {
        if (r10 != 0) goto L6;
        return getHorizontalDimensionBehaviour();
    L6:
        if (r10 == 1) goto L8;
        return null;
    L8:
        return getVerticalDimensionBehaviour();
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (isInHorizontalChain() == false) goto L36;
        ConstraintWidget r10 = this;
        ConstraintWidget r11 = null;
    L5:
        if (r11 != null) goto L26;
        if (r10 == null) goto L26;
        ConstraintAnchor r12 = r10.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r12 != null) goto L10;
        ConstraintAnchor r13 = null;
    L11:
        if (r13 != null) goto L13;
        ConstraintWidget r14 = null;
    L15:
        if (r14 == getParent()) goto L37;
        if (r14 != null) goto L19;
        ConstraintAnchor r15 = null;
    L20:
        if (r15 == null) goto L24;
        if (r15.getOwner() == r10) goto L24;
        r11 = r10;
    L24:
        r10 = r14;
        goto L5
    L19:
        r15 = r14.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        goto L20
    L37:
        return r10;
    L13:
        r14 = r13.getOwner();
        goto L15
    L10:
        r13 = r12.getTarget();
    L26:
        return r11;
    L36:
        return null;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor r10 = this.mLeft;
        int r11 = 0;
        if (r10 == null) goto L5;
        r11 = 0 + r10.mMargin;
    L5:
        ConstraintAnchor r12 = this.mRight;
        if (r12 != null) goto L8;
        return r11;
    L8:
        return r11 + r12.mMargin;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int r10) {
        if (r10 != 0) goto L6;
        return getWidth();
    L6:
        if (r10 == 1) goto L8;
        return 0;
    L8:
        return getHeight();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.mRight;
        ConstraintAnchor r12 = r11.mTarget;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.mTarget == r11) goto L8;
        return null;
    L8:
        return r12.mOwner;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.mBottom;
        ConstraintAnchor r14 = r13.mTarget;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.mTarget == r13) goto L16;
        return null;
    L16:
        return r14.mOwner;
    L20:
        return null;
    }

    public int getOptimizerWrapHeight() {
        int r10 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r10;
    L5:
        if (this.mMatchConstraintDefaultHeight != 1) goto L7;
        int r11 = Math.max(this.mMatchConstraintMinHeight, r10);
    L11:
        int r12 = this.mMatchConstraintMaxHeight;
        if (r12 <= 0) goto L17;
        if (r12 < r11) goto L15;
        return r11;
    L15:
        return r12;
    L17:
        return r11;
    L7:
        r11 = this.mMatchConstraintMinHeight;
        if (r11 <= 0) goto L10;
        this.mHeight = r11;
        goto L11
    L10:
        r11 = 0;
        goto L11
    }

    public int getOptimizerWrapWidth() {
        int r10 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r10;
    L5:
        if (this.mMatchConstraintDefaultWidth != 1) goto L7;
        int r11 = Math.max(this.mMatchConstraintMinWidth, r10);
    L11:
        int r12 = this.mMatchConstraintMaxWidth;
        if (r12 <= 0) goto L17;
        if (r12 < r11) goto L15;
        return r11;
    L15:
        return r12;
    L17:
        return r11;
    L7:
        r11 = this.mMatchConstraintMinWidth;
        if (r11 <= 0) goto L10;
        this.mWidth = r11;
        goto L11
    L10:
        r11 = 0;
        goto L11
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int r10) {
        if (r10 != 0) goto L10;
        ConstraintAnchor r11 = this.mLeft;
        ConstraintAnchor r12 = r11.mTarget;
        if (r12 != null) goto L6;
        return null;
    L6:
        if (r12.mTarget == r11) goto L8;
        return null;
    L8:
        return r12.mOwner;
    L10:
        if (r10 != 1) goto L20;
        ConstraintAnchor r13 = this.mTop;
        ConstraintAnchor r14 = r13.mTarget;
        if (r14 != null) goto L14;
        return null;
    L14:
        if (r14.mTarget == r13) goto L16;
        return null;
    L16:
        return r14.mOwner;
    L20:
        return null;
    }

    int getRelativePositioning(int r10) {
        if (r10 != 0) goto L6;
        return this.mRelX;
    L6:
        if (r10 == 1) goto L8;
        return 0;
    L8:
        return this.mRelY;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int r10) {
        if (r10 != 0) goto L6;
        return this.horizontalRun;
    L6:
        if (r10 == 1) goto L8;
        return null;
    L8:
        return this.verticalRun;
    }

    public void getSceneString(StringBuilder r13) {
        r13.append("  " + this.stringId + ":{\n");
        StringBuilder r10 = new StringBuilder();
        r10.append("    actualWidth:");
        r10.append(this.mWidth);
        r13.append(r10.toString());
        r13.append("\n");
        r13.append("    actualHeight:" + this.mHeight);
        r13.append("\n");
        r13.append("    actualLeft:" + this.mX);
        r13.append("\n");
        r13.append("    actualTop:" + this.mY);
        r13.append("\n");
        getSceneString(r13, "left", this.mLeft);
        getSceneString(r13, "top", this.mTop);
        getSceneString(r13, "right", this.mRight);
        getSceneString(r13, "bottom", this.mBottom);
        getSceneString(r13, "baseline", this.mBaseline);
        getSceneString(r13, "centerX", this.mCenterX);
        getSceneString(r13, "centerY", this.mCenterY);
        getSceneString(r13, "    width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        getSceneString(r13, "    height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(r13, "    dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(r13, "    horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r13, "    verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r13, "    horizontalChainStyle", this.mHorizontalChainStyle, 0);
        serializeAttribute(r13, "    verticalChainStyle", this.mVerticalChainStyle, 0);
        r13.append("  }");
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (isInVerticalChain() == false) goto L36;
        ConstraintWidget r10 = this;
        ConstraintWidget r11 = null;
    L5:
        if (r11 != null) goto L26;
        if (r10 == null) goto L26;
        ConstraintAnchor r12 = r10.getAnchor(ConstraintAnchor.Type.TOP);
        if (r12 != null) goto L10;
        ConstraintAnchor r13 = null;
    L11:
        if (r13 != null) goto L13;
        ConstraintWidget r14 = null;
    L15:
        if (r14 == getParent()) goto L37;
        if (r14 != null) goto L19;
        ConstraintAnchor r15 = null;
    L20:
        if (r15 == null) goto L24;
        if (r15.getOwner() == r10) goto L24;
        r11 = r10;
    L24:
        r10 = r14;
        goto L5
    L19:
        r15 = r14.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        goto L20
    L37:
        return r10;
    L13:
        r14 = r13.getOwner();
        goto L15
    L10:
        r13 = r12.getTarget();
    L26:
        return r11;
    L36:
        return null;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int r10 = 0;
        if (this.mLeft == null) goto L6;
        r10 = 0 + this.mTop.mMargin;
    L6:
        if (this.mRight != null) goto L8;
        return r10;
    L8:
        return r10 + this.mBottom.mMargin;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility != 8) goto L7;
        return 0;
    L7:
        return this.mWidth;
    }

    public int getWrapBehaviorInParent() {
        return this.mWrapBehaviorInParent;
    }

    public int getX() {
        ConstraintWidget r10 = this.mParent;
        if (r10 == null) goto L9;
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r10).mPaddingLeft + this.mX;
    L9:
        return this.mX;
    }

    public int getY() {
        ConstraintWidget r10 = this.mParent;
        if (r10 == null) goto L9;
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r10).mPaddingTop + this.mY;
    L9:
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int r10) {
        if (r10 != 0) goto L18;
        if (this.mLeft.mTarget == null) goto L7;
        int r11 = 1;
    L9:
        if (this.mRight.mTarget == null) goto L11;
        int r12 = 1;
    L13:
        if ((r11 + r12) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r12 = 0;
        goto L13
    L7:
        r11 = 0;
        goto L9
    L18:
        if (this.mTop.mTarget == null) goto L20;
        int r13 = 1;
    L22:
        if (this.mBottom.mTarget == null) goto L24;
        int r14 = 1;
    L25:
        int r15 = r13 + r14;
        if (this.mBaseline.mTarget == null) goto L28;
        int r16 = 1;
    L30:
        if ((r15 + r16) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r16 = 0;
        goto L30
    L24:
        r14 = 0;
        goto L25
    L20:
        r13 = 0;
        goto L22
    }

    public boolean hasDependencies() {
        int r10 = this.mAnchors.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L9;
        if (this.mAnchors.get(r11).hasDependents() == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean hasDimensionOverride() {
        if (this.mWidthOverride == (-1)) goto L5;
    L8:
        return true;
    L5:
        if (this.mHeightOverride != (-1)) goto L8;
        return false;
    }

    public boolean hasResolvedTargets(int r10, int r11) {
        if (r10 != 0) goto L17;
        ConstraintAnchor r12 = this.mLeft.mTarget;
        if (r12 != null) goto L7;
    L30:
        return false;
    L7:
        if (r12.hasFinalValue() == false) goto L30;
        ConstraintAnchor r13 = this.mRight.mTarget;
        if (r13 == null) goto L30;
        if (r13.hasFinalValue() == false) goto L30;
        if (((this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin())) < r11) goto L16;
        return true;
    L16:
        return false;
    L17:
        ConstraintAnchor r14 = this.mTop.mTarget;
        if (r14 == null) goto L30;
        if (r14.hasFinalValue() == false) goto L30;
        ConstraintAnchor r15 = this.mBottom.mTarget;
        if (r15 == null) goto L30;
        if (r15.hasFinalValue() == false) goto L30;
        if (((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin())) < r11) goto L29;
        return true;
    L29:
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13, int r14) {
        getAnchor(r10).connect(r11.getAnchor(r12), r13, r14, true);
    }

    public boolean isAnimated() {
        return this.mAnimated;
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isHorizontalSolvingPassDone() {
        return this.horizontalSolvingPass;
    }

    public boolean isInBarrier(int r10) {
        return this.mIsInBarrier[r10];
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor r10 = this.mLeft;
        ConstraintAnchor r11 = r10.mTarget;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.mRight;
        ConstraintAnchor r13 = r12.mTarget;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.mTarget != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.mTarget != r10) goto L6;
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor r10 = this.mTop;
        ConstraintAnchor r11 = r10.mTarget;
        if (r11 != null) goto L5;
    L6:
        ConstraintAnchor r12 = this.mBottom;
        ConstraintAnchor r13 = r12.mTarget;
        if (r13 != null) goto L9;
        return false;
    L9:
        if (r13.mTarget != r12) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r11.mTarget != r10) goto L6;
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtualLayout;
    }

    public boolean isMeasureRequested() {
        if (this.mMeasureRequested == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mVisibility == 8) goto L7;
        return true;
    }

    public boolean isResolvedHorizontally() {
        if (this.resolvedHorizontal == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mLeft.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mRight.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isResolvedVertically() {
        if (this.resolvedVertical == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mTop.hasFinalValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mBottom.hasFinalValue() == false) goto L9;
        goto L9
    }

    public boolean isRoot() {
        if (this.mParent != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0) goto L5;
    L13:
        return false;
    L5:
        if (this.mDimensionRatio != 0.0f) goto L13;
        if (this.mMatchConstraintMinHeight != 0) goto L13;
        if (this.mMatchConstraintMaxHeight != 0) goto L13;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
        return true;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth == 0) goto L5;
        return false;
    L5:
        if (this.mDimensionRatio == 0.0f) goto L7;
        return false;
    L7:
        if (this.mMatchConstraintMinWidth == 0) goto L9;
        return false;
    L9:
        if (this.mMatchConstraintMaxWidth == 0) goto L11;
        return false;
    L11:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        return true;
    L18:
        return false;
    }

    public boolean isVerticalSolvingPassDone() {
        return this.verticalSolvingPass;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void markHorizontalSolvingPassDone() {
        this.horizontalSolvingPass = true;
    }

    public void markVerticalSolvingPassDone() {
        this.verticalSolvingPass = true;
    }

    public boolean oppositeDimensionDependsOn(int r10) {
        if (r10 != 0) goto L5;
        char r11 = 1;
    L6:
        DimensionBehaviour[] r12 = this.mListDimensionBehaviors;
        DimensionBehaviour r13 = r12[r10];
        DimensionBehaviour r14 = r12[r11];
        DimensionBehaviour r15 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 != r15) goto L11;
        if (r14 != r15) goto L11;
        return true;
    L11:
        return false;
    L5:
        r11 = 0;
        goto L6
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] r10 = this.mListDimensionBehaviors;
        DimensionBehaviour r11 = r10[0];
        DimensionBehaviour r12 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r11 == r12) goto L5;
        return false;
    L5:
        if (r10[1] == r12) goto L7;
        return false;
    L7:
        return true;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float r10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r10;
        this.mVerticalBiasPercent = r10;
        DimensionBehaviour[] r11 = this.mListDimensionBehaviors;
        DimensionBehaviour r12 = DimensionBehaviour.FIXED;
        r11[0] = r12;
        r11[1] = r12;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] r13 = this.mWeight;
        r13[0] = -1.0f;
        r13[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r14 = this.mMaxDimension;
        r14[0] = Integer.MAX_VALUE;
        r14[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] r15 = this.isTerminalWidget;
        r15[0] = true;
        r15[1] = true;
        this.mInVirtualLayout = false;
        boolean[] r16 = this.mIsInBarrier;
        r16[0] = false;
        r16[1] = false;
        this.mMeasureRequested = true;
        int[] r17 = this.mResolvedMatchConstraintDefault;
        r17[0] = 0;
        r17[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor r10) {
        if (getParent() != null) goto L5;
    L9:
        ConstraintAnchor r11 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r12 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r13 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r14 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor r15 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor r16 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor r17 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r10 == r15) goto L12;
        if (r10 == r16) goto L29;
        if (r10 == r17) goto L38;
        if (r10 == r11) goto L55;
        if (r10 == r12) goto L55;
        if (r10 == r13) goto L50;
        if (r10 == r14) goto L50;
    L59:
        r10.reset();
        return;
    L50:
        if (r13.isConnected() == false) goto L59;
        if (r13.getTarget() != r14.getTarget()) goto L59;
    L58:
        r15.reset();
    L55:
        if (r11.isConnected() == false) goto L59;
        if (r11.getTarget() != r12.getTarget()) goto L59;
    L38:
        if (r13.isConnected() == true) goto L40;
    L26:
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L40:
        if (r14.isConnected() == false) goto L26;
        if (r13.getTarget().getOwner() != r14.getTarget().getOwner()) goto L26;
        r13.reset();
        r14.reset();
        goto L26
    L29:
        if (r11.isConnected() == true) goto L31;
    L35:
        this.mHorizontalBiasPercent = 0.5f;
        goto L59
    L31:
        if (r12.isConnected() == false) goto L35;
        if (r11.getTarget().getOwner() != r12.getTarget().getOwner()) goto L35;
        r11.reset();
        r12.reset();
        goto L35
    L12:
        if (r11.isConnected() == false) goto L19;
        if (r12.isConnected() == false) goto L19;
        if (r11.getTarget() != r12.getTarget()) goto L19;
        r11.reset();
        r12.reset();
    L19:
        if (r13.isConnected() == true) goto L21;
    L25:
        this.mHorizontalBiasPercent = 0.5f;
        goto L26
    L21:
        if (r14.isConnected() == false) goto L25;
        if (r13.getTarget() != r14.getTarget()) goto L25;
        r13.reset();
        r14.reset();
        goto L25
    L5:
        if ((getParent() instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetAnchors() {
        ConstraintWidget r10 = getParent();
        if (r10 != null) goto L5;
    L9:
        int r11 = 0;
        int r12 = this.mAnchors.size();
    L10:
        if (r11 >= r12) goto L12;
        this.mAnchors.get(r11).reset();
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L5:
        if ((r10 instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetFinalResolution() {
        int r10 = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int r11 = this.mAnchors.size();
    L3:
        if (r10 >= r11) goto L5;
        this.mAnchors.get(r10).resetFinalResolution();
        r10 = r10 + 1;
        goto L3
    }

    public void resetSolverVariables(Cache r10) {
        this.mLeft.resetSolverVariable(r10);
        this.mTop.resetSolverVariable(r10);
        this.mRight.resetSolverVariable(r10);
        this.mBottom.resetSolverVariable(r10);
        this.mBaseline.resetSolverVariable(r10);
        this.mCenter.resetSolverVariable(r10);
        this.mCenterX.resetSolverVariable(r10);
        this.mCenterY.resetSolverVariable(r10);
    }

    public void resetSolvingPassFlag() {
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
    }

    public StringBuilder serialize(StringBuilder r12) {
        r12.append("{\n");
        serializeAnchor(r12, "left", this.mLeft);
        serializeAnchor(r12, "top", this.mTop);
        serializeAnchor(r12, "right", this.mRight);
        serializeAnchor(r12, "bottom", this.mBottom);
        serializeAnchor(r12, "baseline", this.mBaseline);
        serializeAnchor(r12, "centerX", this.mCenterX);
        serializeAnchor(r12, "centerY", this.mCenterY);
        serializeCircle(r12, this.mCenter, this.mCircleConstraintAngle);
        serializeSize(r12, "width", this.mWidth, this.mMinWidth, this.mMaxDimension[0], this.mWidthOverride, this.mMatchConstraintMinWidth, this.mMatchConstraintDefaultWidth, this.mMatchConstraintPercentWidth, this.mWeight[0]);
        serializeSize(r12, "height", this.mHeight, this.mMinHeight, this.mMaxDimension[1], this.mHeightOverride, this.mMatchConstraintMinHeight, this.mMatchConstraintDefaultHeight, this.mMatchConstraintPercentHeight, this.mWeight[1]);
        serializeDimensionRatio(r12, "dimensionRatio", this.mDimensionRatio, this.mDimensionRatioSide);
        serializeAttribute(r12, "horizontalBias", this.mHorizontalBiasPercent, DEFAULT_BIAS);
        serializeAttribute(r12, "verticalBias", this.mVerticalBiasPercent, DEFAULT_BIAS);
        r12.append("}\n");
        return r12;
    }

    public void setAnimated(boolean r10) {
        this.mAnimated = r10;
    }

    public void setBaselineDistance(int r10) {
        this.mBaselineDistance = r10;
        if (r10 <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.hasBaseline = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setCompanionWidget(Object r10) {
        this.mCompanionWidget = r10;
    }

    public void setContainerItemSkip(int r10) {
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        this.mContainerItemSkip = r10;
    }

    public void setDebugName(String r10) {
        this.mDebugName = r10;
    }

    public void setDebugSolverName(LinearSystem r10, String r11) {
        this.mDebugName = r11;
        SolverVariable r12 = r10.createObjectVariable(this.mLeft);
        SolverVariable r13 = r10.createObjectVariable(this.mTop);
        SolverVariable r14 = r10.createObjectVariable(this.mRight);
        SolverVariable r15 = r10.createObjectVariable(this.mBottom);
        r12.setName(r11 + ".left");
        r13.setName(r11 + ".top");
        r14.setName(r11 + ".right");
        r15.setName(r11 + ".bottom");
        r10.createObjectVariable(this.mBaseline).setName(r11 + ".baseline");
    }

    public void setDimension(int r10, int r11) {
        this.mWidth = r10;
        int r12 = this.mMinWidth;
        if (r10 >= r12) goto L5;
        this.mWidth = r12;
    L5:
        this.mHeight = r11;
        int r13 = this.mMinHeight;
        if (r11 >= r13) goto L9;
        this.mHeight = r13;
        return;
    }

    public void setDimensionRatio(float r10, int r11) {
        this.mDimensionRatio = r10;
        this.mDimensionRatioSide = r11;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String r10) {
        int r11 = 0;
        if (r10 != null) goto L5;
    L43:
        this.mDimensionRatio = 0.0f;
        return;
    L5:
        if (r10.length() == 0) goto L43;
        int r12 = -1;
        int r13 = r10.length();
        int r14 = r10.indexOf(44);
        int r15 = 0;
        if (r14 > 0) goto L10;
    L18:
        int r16 = r10.indexOf(58);
        if (r16 >= 0) goto L21;
    L34:
        String r17 = r10.substring(r15);
        if (r17.length() <= 0) goto L38;
        float r18 = Float.parseFloat(r17);     // Catch: NumberFormatException -> L45
    L39:
        r11 = (r18 > r11 ? 1 : (r18 == r11 ? 0 : -1));
        if (r11 <= 0) goto L48;
        this.mDimensionRatio = r18;
        this.mDimensionRatioSide = r12;
        return;
    L48:
        return;
    L21:
        if (r16 >= (r13 - 1)) goto L34;
        String r19 = r10.substring(r15, r16);
        String r20 = r10.substring(r16 + 1);
        if (r19.length() <= 0) goto L38;
        if (r20.length() <= 0) goto L38;
        float r21 = Float.parseFloat(r19);     // Catch: NumberFormatException -> L45
        float r22 = Float.parseFloat(r20);     // Catch: NumberFormatException -> L45
        if (r21 <= 0.0f) goto L38;
        if (r22 <= 0.0f) goto L38;
        if (r12 != 1) goto L32;
        r18 = Math.abs(r22 / r21);     // Catch: NumberFormatException -> L45
        goto L39
    L32:
        r18 = Math.abs(r21 / r22);     // Catch: NumberFormatException -> L45
    L38:
        r18 = r11;
        goto L39
    L10:
        if (r14 >= (r13 - 1)) goto L18;
        String r23 = r10.substring(0, r14);
        if (r23.equalsIgnoreCase("W") == false) goto L15;
        r12 = 0;
    L17:
        r15 = r14 + 1;
        goto L18
    L15:
        if (r23.equalsIgnoreCase("H") == false) goto L17;
        r12 = 1;
        goto L17
    }

    public void setFinalBaseline(int r10) {
        if (this.hasBaseline == true) goto L5;
        return;
    L5:
        int r11 = r10 - this.mBaselineDistance;
        int r12 = this.mHeight + r11;
        this.mY = r11;
        this.mTop.setFinalValue(r11);
        this.mBottom.setFinalValue(r12);
        this.mBaseline.setFinalValue(r10);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int r10, int r11, int r12, int r13, int r14, int r15) {
        setFrame(r10, r11, r12, r13);
        setBaselineDistance(r14);
        if (r15 != 0) goto L6;
        this.resolvedHorizontal = true;
    L5:
        this.resolvedVertical = false;
        return;
    L6:
        if (r15 != 1) goto L10;
        this.resolvedHorizontal = false;
    L8:
        this.resolvedVertical = true;
        return;
    L10:
        if (r15 != 2) goto L12;
        this.resolvedHorizontal = true;
        goto L8
    L12:
        this.resolvedHorizontal = false;
        goto L5
    }

    public void setFinalHorizontal(int r10, int r11) {
        if (this.resolvedHorizontal == false) goto L5;
        return;
    L5:
        this.mLeft.setFinalValue(r10);
        this.mRight.setFinalValue(r11);
        this.mX = r10;
        this.mWidth = r11 - r10;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int r10) {
        this.mLeft.setFinalValue(r10);
        this.mX = r10;
    }

    public void setFinalTop(int r10) {
        this.mTop.setFinalValue(r10);
        this.mY = r10;
    }

    public void setFinalVertical(int r10, int r11) {
        if (this.resolvedVertical == false) goto L5;
        return;
    L5:
        this.mTop.setFinalValue(r10);
        this.mBottom.setFinalValue(r11);
        this.mY = r10;
        this.mHeight = r11 - r10;
        if (this.hasBaseline == false) goto L8;
        this.mBaseline.setFinalValue(r10 + this.mBaselineDistance);
    L8:
        this.resolvedVertical = true;
    }

    public void setFrame(int r10, int r11, int r12) {
        if (r12 != 0) goto L5;
        setHorizontalDimension(r10, r11);
        return;
    L5:
        if (r12 != 1) goto L9;
        setVerticalDimension(r10, r11);
        return;
    }

    public void setFrame(int r10, int r11, int r12, int r13) {
        int r14 = r12 - r10;
        int r15 = r13 - r11;
        this.mX = r10;
        this.mY = r11;
        if (this.mVisibility != 8) goto L6;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L6:
        DimensionBehaviour[] r16 = this.mListDimensionBehaviors;
        DimensionBehaviour r17 = r16[0];
        DimensionBehaviour r18 = DimensionBehaviour.FIXED;
        if (r17 != r18) goto L12;
        int r19 = this.mWidth;
        if (r14 >= r19) goto L12;
        r14 = r19;
    L12:
        if (r16[1] != r18) goto L16;
        int r20 = this.mHeight;
        if (r15 >= r20) goto L16;
        r15 = r20;
    L16:
        this.mWidth = r14;
        this.mHeight = r15;
        int r21 = this.mMinHeight;
        if (r15 >= r21) goto L19;
        this.mHeight = r21;
    L19:
        int r22 = this.mMinWidth;
        if (r14 >= r22) goto L22;
        this.mWidth = r22;
    L22:
        int r23 = this.mMatchConstraintMaxWidth;
        if (r23 > 0) goto L25;
    L27:
        int r24 = this.mMatchConstraintMaxHeight;
        if (r24 > 0) goto L30;
    L32:
        int r25 = this.mWidth;
        if (r14 == r25) goto L35;
        this.mWidthOverride = r25;
    L35:
        int r26 = this.mHeight;
        if (r15 == r26) goto L39;
        this.mHeightOverride = r26;
        return;
    L39:
        return;
    L30:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.mHeight = Math.min(this.mHeight, r24);
        goto L32
    L25:
        if (r16[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
        this.mWidth = Math.min(this.mWidth, r23);
        goto L27
    }

    public void setGoneMargin(ConstraintAnchor.Type r10, int r11) {
        int r12 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r10.ordinal()];
        if (r12 != 1) goto L5;
        ConstraintAnchor r13 = this.mLeft;
    L18:
        r13.mGoneMargin = r11;
        return;
    L5:
        if (r12 != 2) goto L7;
        r13 = this.mTop;
        goto L18
    L7:
        if (r12 != 3) goto L9;
        r13 = this.mRight;
        goto L18
    L9:
        if (r12 != 4) goto L11;
        r13 = this.mBottom;
        goto L18
    L11:
        if (r12 != 5) goto L20;
        r13 = this.mBaseline;
        goto L18
    }

    public void setHasBaseline(boolean r10) {
        this.hasBaseline = r10;
    }

    public void setHeight(int r10) {
        this.mHeight = r10;
        int r11 = this.mMinHeight;
        if (r10 >= r11) goto L6;
        this.mHeight = r11;
        return;
    }

    public void setHeightWrapContent(boolean r10) {
        this.mIsHeightWrapContent = r10;
    }

    public void setHorizontalBiasPercent(float r10) {
        this.mHorizontalBiasPercent = r10;
    }

    public void setHorizontalChainStyle(int r10) {
        this.mHorizontalChainStyle = r10;
    }

    public void setHorizontalDimension(int r10, int r11) {
        this.mX = r10;
        int r12 = r11 - r10;
        this.mWidth = r12;
        int r13 = this.mMinWidth;
        if (r12 >= r13) goto L6;
        this.mWidth = r13;
        return;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour r10) {
        this.mListDimensionBehaviors[0] = r10;
    }

    public void setHorizontalMatchStyle(int r10, int r11, int r12, float r13) {
        this.mMatchConstraintDefaultWidth = r10;
        this.mMatchConstraintMinWidth = r11;
        if (r12 != Integer.MAX_VALUE) goto L5;
        r12 = 0;
    L5:
        this.mMatchConstraintMaxWidth = r12;
        this.mMatchConstraintPercentWidth = r13;
        if (r13 > 0.0f) goto L8;
        return;
    L8:
        if (r13 >= 1.0f) goto L13;
        if (r10 != 0) goto L14;
        this.mMatchConstraintDefaultWidth = 2;
        return;
    L14:
        return;
    }

    public void setHorizontalWeight(float r10) {
        this.mWeight[0] = r10;
    }

    protected void setInBarrier(int r10, boolean r11) {
        this.mIsInBarrier[r10] = r11;
    }

    public void setInPlaceholder(boolean r10) {
        this.inPlaceholder = r10;
    }

    public void setInVirtualLayout(boolean r10) {
        this.mInVirtualLayout = r10;
    }

    public void setLastMeasureSpec(int r10, int r11) {
        this.mLastHorizontalMeasureSpec = r10;
        this.mLastVerticalMeasureSpec = r11;
        setMeasureRequested(false);
    }

    public void setLength(int r10, int r11) {
        if (r11 != 0) goto L5;
        setWidth(r10);
        return;
    L5:
        if (r11 != 1) goto L9;
        setHeight(r10);
        return;
    }

    public void setMaxHeight(int r10) {
        this.mMaxDimension[1] = r10;
    }

    public void setMaxWidth(int r10) {
        this.mMaxDimension[0] = r10;
    }

    public void setMeasureRequested(boolean r10) {
        this.mMeasureRequested = r10;
    }

    public void setMinHeight(int r10) {
        if (r10 >= 0) goto L4;
        r10 = 0;
    L4:
        this.mMinHeight = r10;
    }

    public void setMinWidth(int r10) {
        if (r10 >= 0) goto L4;
        r10 = 0;
    L4:
        this.mMinWidth = r10;
    }

    public void setOffset(int r10, int r11) {
        this.mOffsetX = r10;
        this.mOffsetY = r11;
    }

    public void setOrigin(int r10, int r11) {
        this.mX = r10;
        this.mY = r11;
    }

    public void setParent(ConstraintWidget r10) {
        this.mParent = r10;
    }

    void setRelativePositioning(int r10, int r11) {
        if (r11 != 0) goto L5;
        this.mRelX = r10;
        return;
    L5:
        if (r11 != 1) goto L9;
        this.mRelY = r10;
        return;
    }

    public void setType(String r10) {
        this.mType = r10;
    }

    public void setVerticalBiasPercent(float r10) {
        this.mVerticalBiasPercent = r10;
    }

    public void setVerticalChainStyle(int r10) {
        this.mVerticalChainStyle = r10;
    }

    public void setVerticalDimension(int r10, int r11) {
        this.mY = r10;
        int r12 = r11 - r10;
        this.mHeight = r12;
        int r13 = this.mMinHeight;
        if (r12 >= r13) goto L6;
        this.mHeight = r13;
        return;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour r10) {
        this.mListDimensionBehaviors[1] = r10;
    }

    public void setVerticalMatchStyle(int r10, int r11, int r12, float r13) {
        this.mMatchConstraintDefaultHeight = r10;
        this.mMatchConstraintMinHeight = r11;
        if (r12 != Integer.MAX_VALUE) goto L5;
        r12 = 0;
    L5:
        this.mMatchConstraintMaxHeight = r12;
        this.mMatchConstraintPercentHeight = r13;
        if (r13 > 0.0f) goto L8;
        return;
    L8:
        if (r13 >= 1.0f) goto L13;
        if (r10 != 0) goto L14;
        this.mMatchConstraintDefaultHeight = 2;
        return;
    L14:
        return;
    }

    public void setVerticalWeight(float r10) {
        this.mWeight[1] = r10;
    }

    public void setVisibility(int r10) {
        this.mVisibility = r10;
    }

    public void setWidth(int r10) {
        this.mWidth = r10;
        int r11 = this.mMinWidth;
        if (r10 >= r11) goto L6;
        this.mWidth = r11;
        return;
    }

    public void setWidthWrapContent(boolean r10) {
        this.mIsWidthWrapContent = r10;
    }

    public void setWrapBehaviorInParent(int r10) {
        if (r10 >= 0) goto L4;
        return;
    L4:
        if (r10 > 3) goto L8;
        this.mWrapBehaviorInParent = r10;
        return;
    }

    public void setX(int r10) {
        this.mX = r10;
    }

    public void setY(int r10) {
        this.mY = r10;
    }

    public void setupDimensionRatio(boolean r10, boolean r11, boolean r12, boolean r13) {
        if (this.mResolvedDimensionRatioSide != (-1)) goto L13;
        if (r12 == false) goto L7;
        if (r13 == true) goto L7;
        this.mResolvedDimensionRatioSide = 0;
    L7:
        if (r12 == true) goto L13;
        if (r13 == false) goto L13;
        this.mResolvedDimensionRatioSide = 1;
        if (this.mDimensionRatioSide != (-1)) goto L13;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
    L13:
        if (this.mResolvedDimensionRatioSide != 0) goto L20;
        if (this.mTop.isConnected() == true) goto L17;
    L18:
        this.mResolvedDimensionRatioSide = 1;
    L27:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L47;
        if (this.mTop.isConnected() == false) goto L37;
        if (this.mBottom.isConnected() == false) goto L37;
        if (this.mLeft.isConnected() == false) goto L37;
        if (this.mRight.isConnected() == true) goto L47;
    L37:
        if (this.mTop.isConnected() == false) goto L42;
        if (this.mBottom.isConnected() == false) goto L42;
        this.mResolvedDimensionRatioSide = 0;
    L42:
        if (this.mLeft.isConnected() == false) goto L47;
        if (this.mRight.isConnected() == false) goto L47;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
    L47:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L58;
        int r14 = this.mMatchConstraintMinWidth;
        if (r14 > 0) goto L51;
    L53:
        if (r14 == 0) goto L55;
        return;
    L55:
        if (this.mMatchConstraintMinHeight <= 0) goto L61;
        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
        this.mResolvedDimensionRatioSide = 1;
        return;
    L61:
        return;
    L51:
        if (this.mMatchConstraintMinHeight != 0) goto L53;
        this.mResolvedDimensionRatioSide = 0;
        return;
    L58:
        return;
    L17:
        if (this.mBottom.isConnected() == false) goto L18;
    L20:
        if (this.mResolvedDimensionRatioSide != 1) goto L27;
        if (this.mLeft.isConnected() == true) goto L24;
    L25:
        this.mResolvedDimensionRatioSide = 0;
        goto L27
    L24:
        if (this.mRight.isConnected() == true) goto L27;
        goto L25
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        String r11 = "";
        if (this.mType == null) goto L5;
        String r12 = "type: " + this.mType + " ";
    L6:
        r10.append(r12);
        if (this.mDebugName == null) goto L9;
        r11 = "id: " + this.mDebugName + " ";
    L9:
        r10.append(r11);
        r10.append("(");
        r10.append(this.mX);
        r10.append(", ");
        r10.append(this.mY);
        r10.append(") - (");
        r10.append(this.mWidth);
        r10.append(" x ");
        r10.append(this.mHeight);
        r10.append(")");
        return r10.toString();
    L5:
        r12 = "";
        goto L6
    }

    public void updateFromRuns(boolean r10, boolean r11) {
        boolean r12 = r10 & this.horizontalRun.isResolved();
        boolean r13 = r11 & this.verticalRun.isResolved();
        HorizontalWidgetRun r14 = this.horizontalRun;
        int r15 = r14.start.value;
        VerticalWidgetRun r16 = this.verticalRun;
        int r17 = r16.start.value;
        int r18 = r14.end.value;
        int r19 = r16.end.value;
        int r20 = r19 - r17;
        if ((r18 - r15) < 0) goto L15;
        if (r20 < 0) goto L15;
        if (r15 == Integer.MIN_VALUE) goto L15;
        if (r15 == Integer.MAX_VALUE) goto L15;
        if (r17 == Integer.MIN_VALUE) goto L15;
        if (r17 == Integer.MAX_VALUE) goto L15;
        if (r18 == Integer.MIN_VALUE) goto L15;
        if (r18 == Integer.MAX_VALUE) goto L15;
        if (r19 == Integer.MIN_VALUE) goto L15;
        if (r19 == Integer.MAX_VALUE) goto L15;
    L16:
        int r21 = r18 - r15;
        int r22 = r19 - r17;
        if (r12 == false) goto L19;
        this.mX = r15;
    L19:
        if (r13 == false) goto L22;
        this.mY = r17;
    L22:
        if (this.mVisibility != 8) goto L25;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L25:
        if (r12 == true) goto L27;
    L34:
        if (r13 == true) goto L36;
        return;
    L36:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) goto L40;
        int r23 = this.mHeight;
        if (r22 >= r23) goto L40;
        r22 = r23;
    L40:
        this.mHeight = r22;
        int r24 = this.mMinHeight;
        if (r22 >= r24) goto L45;
        this.mHeight = r24;
        return;
    L45:
        return;
    L27:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L31;
        int r25 = this.mWidth;
        if (r21 >= r25) goto L31;
        r21 = r25;
    L31:
        this.mWidth = r21;
        int r26 = this.mMinWidth;
        if (r21 >= r26) goto L34;
        this.mWidth = r26;
    L15:
        r18 = 0;
        r15 = 0;
        r19 = 0;
        r17 = 0;
        goto L16
    }

    public void updateFromSolver(LinearSystem r10, boolean r11) {
        int r12 = r10.getObjectVariableValue(this.mLeft);
        int r13 = r10.getObjectVariableValue(this.mTop);
        int r14 = r10.getObjectVariableValue(this.mRight);
        int r15 = r10.getObjectVariableValue(this.mBottom);
        if (r11 == false) goto L11;
        HorizontalWidgetRun r16 = this.horizontalRun;
        if (r16 == null) goto L11;
        DependencyNode r17 = r16.start;
        if (r17.resolved == false) goto L11;
        DependencyNode r18 = r16.end;
        if (r18.resolved == false) goto L11;
        r12 = r17.value;
        r14 = r18.value;
    L11:
        if (r11 == false) goto L19;
        VerticalWidgetRun r19 = this.verticalRun;
        if (r19 == null) goto L19;
        DependencyNode r20 = r19.start;
        if (r20.resolved == false) goto L19;
        DependencyNode r21 = r19.end;
        if (r21.resolved == false) goto L19;
        r13 = r20.value;
        r15 = r21.value;
    L19:
        int r22 = r15 - r13;
        if ((r14 - r12) < 0) goto L32;
        if (r22 < 0) goto L32;
        if (r12 == Integer.MIN_VALUE) goto L32;
        if (r12 == Integer.MAX_VALUE) goto L32;
        if (r13 == Integer.MIN_VALUE) goto L32;
        if (r13 == Integer.MAX_VALUE) goto L32;
        if (r14 == Integer.MIN_VALUE) goto L32;
        if (r14 == Integer.MAX_VALUE) goto L32;
        if (r15 == Integer.MIN_VALUE) goto L32;
        if (r15 == Integer.MAX_VALUE) goto L32;
    L33:
        setFrame(r12, r13, r14, r15);
        return;
    L32:
        r15 = 0;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        goto L33
    }
}
