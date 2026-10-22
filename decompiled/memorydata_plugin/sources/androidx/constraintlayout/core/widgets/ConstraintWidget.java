package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            int[] r0 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0;
            r0[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r4 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r4;
            r4[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
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
            DimensionBehaviour r0 = new DimensionBehaviour("FIXED", 0);
            FIXED = r0;
            DimensionBehaviour r1 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r1;
            DimensionBehaviour r3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r3;
            DimensionBehaviour r5 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r5;
            $VALUES = new DimensionBehaviour[]{r0, r1, r3, r5};
        }

        private DimensionBehaviour(String r1, int r2) {
            super(r1, r2);
        }

        public static DimensionBehaviour valueOf(String r2) {
            return (DimensionBehaviour) ZeusTransformUtils.preCheckCast(Enum.valueOf(DimensionBehaviour.class, r2), DimensionBehaviour.class, "com.obric.memorydata.plugin");
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DimensionBehaviour[].class, "com.obric.memorydata.plugin");
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
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
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
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
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

    public ConstraintWidget(int r2, int r3) {
        this(0, 0, r2, r3);
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
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
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
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
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
        ConstraintAnchor r6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r6;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r6};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
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
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
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

    public ConstraintWidget(String r1, int r2, int r3) {
        this(r2, r3);
        setDebugName(r1);
    }

    public ConstraintWidget(String r1, int r2, int r3, int r4, int r5) {
        this(r2, r3, r4, r5);
        setDebugName(r1);
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

    private void applyConstraints(LinearSystem r34, boolean r35, boolean r36, boolean r37, boolean r38, SolverVariable r39, SolverVariable r40, DimensionBehaviour r41, boolean r42, ConstraintAnchor r43, ConstraintAnchor r44, int r45, int r46, int r47, int r48, float r49, boolean r50, boolean r51, boolean r52, boolean r53, boolean r54, int r55, int r56, int r57, int r58, float r59, boolean r60) {
        SolverVariable r9 = r34.createObjectVariable(r43);
        SolverVariable r8 = r34.createObjectVariable(r44);
        SolverVariable r7 = r34.createObjectVariable(r43.getTarget());
        SolverVariable r6 = r34.createObjectVariable(r44.getTarget());
        if (LinearSystem.getMetrics() == null) goto L5;
        LinearSystem.getMetrics().nonresolvedWidgets++;
    L5:
        boolean r11 = r43.isConnected();
        boolean r12 = r44.isConnected();
        boolean r16 = this.mCenter.isConnected();
        if (r12 == false) goto L8;
        int r5 = (r11 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r5 = r5 + 1;
    L11:
        if (r50 == false) goto L13;
        int r18 = 3;
    L14:
        int r2 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r41.ordinal()];
        if (r2 != 1) goto L17;
    L22:
        int r3 = r18;
    L23:
        boolean r19 = false;
    L27:
        int r14 = this.mWidthOverride;
        if (r14 == (-1)) goto L31;
        if (r35 == false) goto L31;
        this.mWidthOverride = -1;
        r19 = false;
    L32:
        int r10 = this.mHeightOverride;
        if (r10 == (-1)) goto L37;
        if (r35 == true) goto L37;
        this.mHeightOverride = -1;
        r14 = r10;
        r19 = false;
    L37:
        if (this.mVisibility != 8) goto L39;
        r14 = 0;
        r19 = false;
    L39:
        if (r60 == false) goto L47;
        if (r11 == true) goto L44;
        if (r12 == true) goto L44;
        if (r16 == true) goto L44;
        r34.addEquality(r9, r45);
    L44:
        if (r11 == false) goto L47;
        if (r12 == true) goto L47;
        r34.addEquality(r9, r7, r43.getMargin(), 8);
    L47:
        if (r19 == true) goto L58;
        if (r42 == false) goto L55;
        r34.addEquality(r8, r9, 0, 3);
        if (r47 <= 0) goto L53;
        r34.addGreaterThan(r8, r9, r47, 8);
    L53:
        if (r48 >= Integer.MAX_VALUE) goto L56;
        r34.addLowerThan(r8, r9, r48, 8);
    L56:
        int r1 = r58;
        int r410 = r5;
        boolean r23 = r19;
        boolean r110 = r38;
        int r21 = r57;
    L111:
        if (r60 == false) goto L353;
        if (r52 == false) goto L114;
        int r4 = 0;
        char r13 = 2;
    L354:
        if (r410 >= r13) goto L386;
        if (r36 == false) goto L387;
        if (r110 == false) goto L388;
        r34.addGreaterThan(r9, r39, r4, 8);
        if (r35 == false) goto L360;
    L363:
        int r15 = 1;
    L364:
        if (r35 == false) goto L366;
    L375:
        int r17 = r15;
    L376:
        if (r17 == 0) goto L389;
        r34.addGreaterThan(r40, r8, r4, 8);
        return;
    L389:
        return;
    L366:
        if (this.mBaseline.mTarget == null) goto L375;
        ConstraintWidget r0 = this.mBaseline.mTarget.mOwner;
        if (r0.mDimensionRatio != 0.0f) goto L370;
    L374:
        r17 = r4;
        goto L376
    L370:
        if (r0.mListDimensionBehaviors[r4] != DimensionBehaviour.MATCH_CONSTRAINT) goto L374;
        if (r0.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L374;
        r17 = 1;
        goto L376
    L360:
        if (this.mBaseline.mTarget == null) goto L363;
        r15 = r4;
        goto L364
    L388:
        return;
    L387:
        return;
    L386:
        return;
    L114:
        String r32 = "com.obric.memorydata.plugin";
        if (r11 == true) goto L119;
        if (r12 == true) goto L119;
        if (r16 == true) goto L119;
        int r20 = 5;
        int r22 = 0;
    L331:
        boolean r24 = r36;
    L332:
        int r25 = r20;
    L333:
        if (r24 == false) goto L383;
        if (r110 == true) goto L336;
        return;
    L336:
        if (r44.mTarget == null) goto L338;
        int r111 = r44.getMargin();
    L339:
        if (r6 != r40) goto L341;
        return;
    L341:
        if (this.OPTIMIZE_WRAP == true) goto L343;
    L351:
        r34.addGreaterThan(r40, r8, r111, r25);
        return;
    L343:
        if (r8.isFinalValue == false) goto L351;
        ConstraintWidget r26 = this.mParent;
        if (r26 == null) goto L351;
        ConstraintWidgetContainer r27 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r26, ConstraintWidgetContainer.class, r32);
        if (r35 == false) goto L349;
        r27.addHorizontalWrapMaxVariable(r44);
        return;
    L349:
        r27.addVerticalWrapMaxVariable(r44);
        return;
    L338:
        r111 = r22;
        goto L339
    L383:
        return;
    L119:
        if (r11 == false) goto L129;
        if (r12 == true) goto L129;
        ConstraintWidget r28 = r43.mTarget.mOwner;
        if (r36 == true) goto L124;
    L126:
        int r112 = 5;
    L127:
        r24 = r36;
        r22 = 0;
        r32 = r32;
        r25 = r112;
        r8 = r8;
        goto L333
    L124:
        if (ZeusTransformUtils.instanceOf(r28, Barrier.class) == false) goto L126;
        r112 = 8;
    L129:
        if (r11 == true) goto L145;
        if (r12 == false) goto L145;
        r34.addEquality(r8, r6, -r44.getMargin(), 8);
        if (r36 == true) goto L134;
    L330:
        r22 = 0;
        r20 = 5;
        goto L331
    L134:
        if (this.OPTIMIZE_WRAP == true) goto L136;
    L143:
        r20 = 5;
        r34.addGreaterThan(r9, r39, 0, 5);
        r22 = 0;
        goto L331
    L136:
        if (r9.isFinalValue == false) goto L143;
        ConstraintWidget r29 = this.mParent;
        if (r29 == null) goto L143;
        ConstraintWidgetContainer r30 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r29, ConstraintWidgetContainer.class, r32);
        if (r35 == false) goto L142;
        r30.addHorizontalWrapMinVariable(r43);
        goto L330
    L142:
        r30.addVerticalWrapMinVariable(r43);
    L145:
        if (r11 == false) goto L330;
        if (r12 == false) goto L330;
        ConstraintWidget r113 = r43.mTarget.mOwner;
        ConstraintWidget r31 = r44.mTarget.mOwner;
        ConstraintWidget r33 = getParent();
        int r114 = 6;
        if (r23 == false) goto L220;
        if (r3 != 0) goto L169;
        if (r1 != 0) goto L159;
        if (r21 != 0) goto L159;
        if (r7.isFinalValue == true) goto L155;
    L158:
        boolean r210 = false;
        boolean r211 = false;
        int r61 = 8;
        int r115 = 8;
        boolean r212 = true;
    L161:
        if (ZeusTransformUtils.instanceOf(r113, Barrier.class) == false) goto L163;
    L167:
        r40 = r40;
        r3 = r3;
        boolean r213 = r212;
        int r62 = r61;
        r114 = 6;
        boolean r214 = r210;
        int r215 = 4;
    L238:
        if (r211 == false) goto L242;
        if (r7 != r6) goto L242;
        if (r113 == r33) goto L242;
        r211 = false;
        boolean r216 = false;
    L243:
        if (r214 == false) goto L252;
        if (r23 == true) goto L250;
        if (r51 == true) goto L250;
        if (r53 == true) goto L250;
        if (r7 != r39) goto L250;
        if (r6 != r40) goto L250;
        r24 = false;
        int r217 = 8;
        int r218 = 8;
        boolean r219 = false;
    L251:
        ConstraintWidget r411 = r33;
        r34.addCentering(r9, r7, r43.getMargin(), r49, r6, r8, r44.getMargin(), r218);
        r62 = r217;
        r216 = r219;
    L254:
        if (this.mVisibility == 8) goto L256;
    L258:
        if (r211 == false) goto L268;
        if (r24 == false) goto L267;
        if (r7 == r6) goto L267;
        if (r23 == true) goto L267;
        if (ZeusTransformUtils.instanceOf(r113, Barrier.class) == false) goto L265;
    L266:
        r62 = 6;
        goto L267
    L265:
        if (ZeusTransformUtils.instanceOf(r31, Barrier.class) == true) goto L266;
    L267:
        r34.addGreaterThan(r9, r7, r43.getMargin(), r62);
        SolverVariable r63 = r8;
        r34.addLowerThan(r63, r6, -r44.getMargin(), r62);
    L269:
        if (r24 == false) goto L278;
        if (r54 == false) goto L278;
        if (ZeusTransformUtils.instanceOf(r113, Barrier.class) == true) goto L278;
        if (ZeusTransformUtils.instanceOf(r31, Barrier.class) == true) goto L278;
        ConstraintWidget r64 = r411;
        if (r31 == r64) goto L279;
        r62 = 6;
        int r65 = 6;
        r216 = true;
    L280:
        if (r216 == false) goto L311;
        if (r213 == false) goto L302;
        if (r53 == false) goto L284;
        if (r37 == false) goto L302;
    L284:
        if (r113 == r64) goto L288;
        if (r31 == r64) goto L288;
        int r66 = r65;
    L290:
        if (ZeusTransformUtils.instanceOf(r113, Guideline.class) == false) goto L292;
    L293:
        r66 = 5;
    L295:
        if (ZeusTransformUtils.instanceOf(r113, Barrier.class) == false) goto L297;
    L298:
        r66 = 5;
    L299:
        if (r53 == false) goto L301;
        r66 = 5;
    L301:
        r65 = Math.max(r66, r65);
        goto L302
    L297:
        if (ZeusTransformUtils.instanceOf(r31, Barrier.class) == false) goto L299;
    L292:
        if (ZeusTransformUtils.instanceOf(r31, Guideline.class) == false) goto L295;
    L288:
        r66 = 6;
    L302:
        if (r24 == false) goto L310;
        int r67 = Math.min(r62, r65);
        if (r50 == false) goto L309;
        if (r53 == true) goto L309;
        if (r113 == r64) goto L308;
        if (r31 != r64) goto L309;
    L308:
        r65 = 4;
    L309:
        r65 = r67;
    L310:
        r34.addEquality(r9, r7, r43.getMargin(), r65);
        r34.addEquality(r63, r6, -r44.getMargin(), r65);
    L311:
        if (r24 == true) goto L313;
    L318:
        if (r24 == false) goto L328;
        if (r23 == false) goto L328;
        r8 = r63;
        if (r47 != 0) goto L329;
        if (r21 != 0) goto L329;
        if (r23 == true) goto L325;
    L327:
        r22 = 0;
        r20 = 5;
        r34.addGreaterThan(r8, r9, 0, 5);
        goto L332
    L325:
        if (r3 != 3) goto L327;
        r22 = 0;
        r34.addGreaterThan(r8, r9, 0, 8);
        r20 = 5;
    L329:
        r20 = 5;
        r22 = 0;
    L328:
        r8 = r63;
        goto L329
    L313:
        if (r39 != r7) goto L315;
        int r68 = r43.getMargin();
    L316:
        if (r7 == r39) goto L318;
        r34.addGreaterThan(r9, r39, r68, 5);
        goto L318
    L315:
        r68 = 0;
    L279:
        r65 = r215;
    L278:
        r64 = r411;
        goto L279
    L268:
        r63 = r8;
        goto L269
    L256:
        if (r44.hasDependents() == true) goto L258;
        return;
    L250:
        r24 = r36;
        r218 = r114;
        r219 = r216;
        r217 = r62;
        goto L251
    L252:
        r411 = r33;
        r24 = r36;
    L242:
        r216 = true;
        goto L243
    L163:
        if (ZeusTransformUtils.instanceOf(r31, Barrier.class) == true) goto L167;
        r213 = r212;
        r214 = r210;
        r215 = r115;
        r3 = r3;
    L166:
        r62 = r61;
        r114 = 6;
        goto L238
    L155:
        if (r6.isFinalValue == false) goto L158;
        r34.addEquality(r9, r7, r43.getMargin(), 8);
        r34.addEquality(r8, r6, -r44.getMargin(), 8);
        return;
    L159:
        r212 = false;
        r61 = 5;
        r115 = 5;
        r210 = true;
        r211 = true;
        goto L161
    L169:
        if (r3 != 2) goto L178;
        if (ZeusTransformUtils.instanceOf(r113, Barrier.class) == true) goto L234;
        if (ZeusTransformUtils.instanceOf(r31, Barrier.class) == true) goto L234;
        r40 = r40;
        r3 = r3;
        r114 = 6;
        r62 = 5;
        r215 = 5;
    L236:
        r214 = true;
        r211 = true;
    L237:
        r213 = false;
    L234:
        r62 = 5;
    L235:
        r215 = 4;
        goto L236
    L178:
        if (r3 != 1) goto L181;
        r40 = r40;
        r3 = r3;
        r62 = 8;
        goto L235
    L181:
        if (r3 != 3) goto L218;
        r3 = r3;
        if (this.mResolvedDimensionRatioSide == (-1)) goto L185;
        if (r50 == true) goto L195;
        if (r1 <= 0) goto L207;
        r114 = 6;
        r62 = 5;
    L191:
        r215 = 5;
    L192:
        r214 = true;
        r211 = true;
        r213 = true;
        goto L238
    L207:
        if (r1 != 0) goto L216;
        if (r21 != 0) goto L216;
        if (r53 == true) goto L211;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 8;
        goto L192
    L211:
        if (r113 == r33) goto L214;
        if (r31 == r33) goto L214;
        int r69 = 4;
    L215:
        r62 = r69;
    L217:
        r215 = 4;
    L214:
        r69 = 5;
    L216:
        r62 = 5;
        goto L217
    L195:
        if (r56 != 2) goto L197;
    L200:
        boolean r70 = true;
    L201:
        if (r70 == true) goto L203;
        r61 = 8;
        int r71 = 5;
    L204:
        r215 = r71;
        r214 = true;
        r211 = true;
        r213 = true;
        goto L166
    L203:
        r61 = 5;
        r71 = 4;
        goto L204
    L197:
        if (r56 == 1) goto L200;
        r70 = false;
        goto L201
    L185:
        if (r53 == false) goto L189;
        if (r36 == false) goto L188;
        r114 = 5;
    L190:
        r62 = 8;
        goto L191
    L188:
        r114 = 4;
        goto L190
    L189:
        r114 = 8;
        goto L190
    L218:
        r3 = r3;
        r40 = r40;
        r114 = 6;
        r62 = 5;
        r215 = 4;
        r214 = false;
        r211 = false;
        goto L237
    L220:
        if (r7.isFinalValue == false) goto L234;
        if (r6.isFinalValue == false) goto L234;
        r34.addCentering(r9, r7, r43.getMargin(), r49, r6, r8, r44.getMargin(), 8);
        if (r36 == false) goto L379;
        if (r110 == true) goto L227;
        return;
    L227:
        if (r44.mTarget == null) goto L229;
        int r116 = r44.getMargin();
    L230:
        if (r6 == r40) goto L381;
        r34.addGreaterThan(r40, r8, r116, 5);
        return;
    L381:
        return;
    L229:
        r116 = 0;
        goto L230
    L379:
        return;
    L353:
        r4 = 0;
        r13 = 2;
        goto L354
    L55:
        r34.addEquality(r8, r9, r14, 8);
        goto L56
    L58:
        if (r5 == 2) goto L68;
        if (r50 == true) goto L68;
        if (r3 == 1) goto L63;
        if (r3 != 0) goto L68;
    L63:
        int r72 = Math.max(r57, r14);
        if (r58 <= 0) goto L66;
        r72 = Math.min(r58, r72);
    L66:
        r34.addEquality(r8, r9, r72, 8);
        r110 = r38;
        r1 = r58;
        r410 = r5;
        r23 = false;
        r21 = r57;
    L68:
        if (r57 != (-2)) goto L70;
        int r73 = r14;
    L71:
        if (r58 != (-2)) goto L73;
        r1 = r14;
    L74:
        if (r14 > 0) goto L76;
    L78:
        if (r73 <= 0) goto L80;
        r34.addGreaterThan(r8, r9, r73, 8);
        r14 = Math.max(r14, r73);
    L80:
        if (r1 <= 0) goto L90;
        if (r36 == true) goto L83;
    L85:
        boolean r74 = true;
    L86:
        if (r74 == false) goto L88;
        int r75 = 8;
        r34.addLowerThan(r8, r9, r1, 8);
    L89:
        r14 = Math.min(r14, r1);
    L92:
        if (r3 != 1) goto L98;
        if (r36 == false) goto L95;
        r34.addEquality(r8, r9, r14, r75);
    L96:
        r410 = r5;
        r23 = r19;
        r110 = r38;
        r21 = r73;
        goto L111
    L95:
        r34.addEquality(r8, r9, r14, 5);
        r34.addLowerThan(r8, r9, r14, r75);
        goto L96
    L98:
        if (r3 == 2) goto L100;
        r410 = r5;
        r21 = r73;
        r23 = r19;
        r110 = true;
        goto L111
    L100:
        if (r43.getType() != ConstraintAnchor.Type.TOP) goto L102;
    L105:
        SolverVariable r76 = r34.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
        ConstraintWidget r77 = this.mParent;
        ConstraintAnchor.Type r117 = ConstraintAnchor.Type.BOTTOM;
    L106:
        SolverVariable r78 = r34.createObjectVariable(r77.getAnchor(r117));
        SolverVariable r220 = r76;
        ArrayRow r79 = r34.createRow();
        r410 = r5 == true ? 1 : 0;
        r21 = r73;
        r34.addConstraint(r79.createRowDimensionRatio(r8, r9, r78, r220, r59));
        if (r36 == false) goto L109;
        r19 = false;
    L109:
        r23 = r19;
        r110 = r38;
        goto L111
    L102:
        if (r43.getType() == ConstraintAnchor.Type.BOTTOM) goto L105;
        r76 = r34.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        r77 = this.mParent;
        r117 = ConstraintAnchor.Type.RIGHT;
        goto L106
    L88:
        r75 = 8;
        goto L89
    L83:
        if (r3 != 1) goto L85;
        r74 = false;
        goto L86
    L90:
        r75 = 8;
        goto L92
    L76:
        if (r3 == 1) goto L78;
        r14 = 0;
        goto L78
    L73:
        r1 = r58;
        goto L74
    L70:
        r73 = r57;
    L31:
        r14 = r46;
        goto L32
    L17:
        if (r2 == 2) goto L22;
        if (r2 == 3) goto L22;
        if (r2 != 4) goto L22;
        r3 = r18;
        if (r3 == 4) goto L23;
        r19 = true;
        goto L27
    L13:
        r18 = r55;
        goto L14
    L8:
        r5 = r11 ? 1 : 0;
        goto L9
    }

    private void getSceneString(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, float r10) {
        r1.append(r2);
        r1.append(" :  {\n");
        serializeAttribute(r1, "      size", r3, 0);
        serializeAttribute(r1, "      min", r4, 0);
        serializeAttribute(r1, "      max", r5, Integer.MAX_VALUE);
        serializeAttribute(r1, "      matchMin", r7, 0);
        serializeAttribute(r1, "      matchDef", r8, 0);
        serializeAttribute(r1, "      matchPercent", r9, 1.0f);
        r1.append("    },\n");
    }

    private void getSceneString(StringBuilder r2, String r3, ConstraintAnchor r4) {
        if (r4.mTarget != null) goto L5;
        return;
    L5:
        r2.append("    ");
        r2.append(r3);
        r2.append(" : [ '");
        r2.append(r4.mTarget);
        r2.append("'");
        if (r4.mGoneMargin == Integer.MIN_VALUE) goto L8;
    L9:
        r2.append(",");
        r2.append(r4.mMargin);
        if (r4.mGoneMargin == Integer.MIN_VALUE) goto L12;
        r2.append(",");
        r2.append(r4.mGoneMargin);
        r2.append(",");
    L12:
        r2.append(" ] ,\n");
        return;
    L8:
        if (r4.mMargin == 0) goto L12;
        goto L9
    }

    private boolean isChainHead(int r5) {
        int r6 = r5 * 2;
        if (this.mListAnchors[r6].mTarget == null) goto L11;
        ConstraintAnchor r0 = this.mListAnchors[r6].mTarget.mTarget;
        ConstraintAnchor[] r2 = this.mListAnchors;
        if (r0 == r2[r6]) goto L11;
        int r7 = r6 + 1;
        if (r2[r7].mTarget == null) goto L11;
        if (this.mListAnchors[r7].mTarget.mTarget != this.mListAnchors[r7]) goto L11;
        return true;
    L11:
        return false;
    }

    private void serializeAnchor(StringBuilder r1, String r2, ConstraintAnchor r3) {
        if (r3.mTarget != null) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" : [ '");
        r1.append(r3.mTarget);
        r1.append("',");
        r1.append(r3.mMargin);
        r1.append(",");
        r1.append(r3.mGoneMargin);
        r1.append(",");
        r1.append(" ] ,\n");
    }

    private void serializeAttribute(StringBuilder r1, String r2, float r3, float r4) {
        if (r3 != r4) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void serializeAttribute(StringBuilder r1, String r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        r1.append(r2);
        r1.append(" :   ");
        r1.append(r3);
        r1.append(",\n");
    }

    private void serializeCircle(StringBuilder r1, ConstraintAnchor r2, float r3) {
        if (r2.mTarget != null) goto L5;
        return;
    L5:
        r1.append("circle : [ '");
        r1.append(r2.mTarget);
        r1.append("',");
        r1.append(r2.mMargin);
        r1.append(",");
        r1.append(r3);
        r1.append(",");
        r1.append(" ] ,\n");
    }

    private void serializeDimensionRatio(StringBuilder r1, String r2, float r3, int r4) {
        if (r3 != 0.0f) goto L5;
        return;
    L5:
        r1.append(r2);
        r1.append(" :  [");
        r1.append(r3);
        r1.append(",");
        r1.append(r4);
        r1.append("");
        r1.append("],\n");
    }

    private void serializeSize(StringBuilder r1, String r2, int r3, int r4, int r5, int r6, int r7, int r8, float r9, float r10) {
        r1.append(r2);
        r1.append(" :  {\n");
        serializeAttribute(r1, "size", r3, Integer.MIN_VALUE);
        serializeAttribute(r1, "min", r4, 0);
        serializeAttribute(r1, "max", r5, Integer.MAX_VALUE);
        serializeAttribute(r1, "matchMin", r7, 0);
        serializeAttribute(r1, "matchDef", r8, 0);
        serializeAttribute(r1, "matchPercent", r8, 1);
        r1.append("},\n");
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer r9, LinearSystem r10, HashSet<ConstraintWidget> r11, int r12, boolean r13) {
        if (r13 == false) goto L8;
        if (r11.contains(this) == true) goto L6;
        return;
    L6:
        Optimizer.checkMatchParent(r9, r10, this);
        r11.remove(this);
        addToSolver(r10, r9.optimizeFor(64));
    L8:
        if (r12 != 0) goto L21;
        HashSet<ConstraintAnchor> r0 = this.mLeft.getDependents();
        if (r0 == null) goto L15;
        Iterator<ConstraintAnchor> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L15;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r1.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner.addChildrenToSolverByDependency(r9, r10, r11, r12, true);
    L15:
        HashSet<ConstraintAnchor> r8 = this.mRight.getDependents();
        if (r8 == null) goto L39;
        Iterator<ConstraintAnchor> r14 = r8.iterator();
    L19:
        if (r14.hasNext() == false) goto L46;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r14.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner.addChildrenToSolverByDependency(r9, r10, r11, r12, true);
        goto L19
    L46:
        return;
    L39:
        return;
    L21:
        HashSet<ConstraintAnchor> r2 = this.mTop.getDependents();
        if (r2 == null) goto L27;
        Iterator<ConstraintAnchor> r3 = r2.iterator();
    L25:
        if (r3.hasNext() == false) goto L27;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner.addChildrenToSolverByDependency(r9, r10, r11, r12, true);
    L27:
        HashSet<ConstraintAnchor> r4 = this.mBottom.getDependents();
        if (r4 == null) goto L33;
        Iterator<ConstraintAnchor> r5 = r4.iterator();
    L31:
        if (r5.hasNext() == false) goto L33;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r5.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner.addChildrenToSolverByDependency(r9, r10, r11, r12, true);
    L33:
        HashSet<ConstraintAnchor> r15 = this.mBaseline.getDependents();
        if (r15 == null) goto L45;
        Iterator<ConstraintAnchor> r16 = r15.iterator();
    L37:
        if (r16.hasNext() == false) goto L47;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(r16.next(), ConstraintAnchor.class, "com.obric.memorydata.plugin")).mOwner.addChildrenToSolverByDependency(r9, r10, r11, r12, true);
        goto L37
    L47:
        return;
    }

    boolean addFirst() {
        if (ZeusTransformUtils.instanceOf(this, VirtualLayout.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(this, Guideline.class) == true) goto L8;
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 16031. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public void addToSolver(androidx.constraintlayout.core.LinearSystem r51, boolean r52) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: IGET (r0v0 ?? I:androidx.constraintlayout.core.widgets.ConstraintAnchor) = (r50v0 'this' ?? I:androidx.constraintlayout.core.widgets.ConstraintWidget A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] androidx.constraintlayout.core.widgets.ConstraintWidget.mLeft androidx.constraintlayout.core.widgets.ConstraintAnchor in method: androidx.constraintlayout.core.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.core.LinearSystem, boolean):void, file: classes.dex
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
            Method dump skipped, instruction units count: 1603
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

    public void connect(ConstraintAnchor.Type r2, ConstraintWidget r3, ConstraintAnchor.Type r4) {
        connect(r2, r3, r4, 0);
    }

    public void connect(ConstraintAnchor.Type r4, ConstraintWidget r5, ConstraintAnchor.Type r6, int r7) {
        if (r4 != ConstraintAnchor.Type.CENTER) goto L46;
        if (r6 != ConstraintAnchor.Type.CENTER) goto L32;
        ConstraintAnchor r8 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r9 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r10 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r0 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        boolean r2 = true;
        if (r8 != null) goto L9;
    L10:
        if (r9 != null) goto L12;
    L14:
        connect(ConstraintAnchor.Type.LEFT, r5, ConstraintAnchor.Type.LEFT, 0);
        connect(ConstraintAnchor.Type.RIGHT, r5, ConstraintAnchor.Type.RIGHT, 0);
        boolean r11 = true;
    L15:
        if (r10 != null) goto L17;
    L18:
        if (r0 != null) goto L20;
    L22:
        connect(ConstraintAnchor.Type.TOP, r5, ConstraintAnchor.Type.TOP, 0);
        connect(ConstraintAnchor.Type.BOTTOM, r5, ConstraintAnchor.Type.BOTTOM, 0);
    L23:
        if (r11 == false) goto L26;
        if (r2 == false) goto L26;
        ConstraintAnchor r3 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.CENTER;
    L28:
        ConstraintAnchor r13 = r5.getAnchor(r12);
    L44:
        r3.connect(r13, 0);
        return;
    L26:
        if (r11 == false) goto L29;
        r3 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        r12 = ConstraintAnchor.Type.CENTER_X;
        goto L28
    L29:
        if (r2 == false) goto L105;
        r3 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        r12 = ConstraintAnchor.Type.CENTER_Y;
        goto L28
    L105:
        return;
    L20:
        if (r0.isConnected() == false) goto L22;
    L21:
        r2 = false;
        goto L23
    L17:
        if (r10.isConnected() == true) goto L21;
    L12:
        if (r9.isConnected() == false) goto L14;
    L13:
        r11 = false;
        goto L15
    L9:
        if (r8.isConnected() == true) goto L13;
    L32:
        if (r6 != ConstraintAnchor.Type.LEFT) goto L34;
    L41:
        connect(ConstraintAnchor.Type.LEFT, r5, r6, 0);
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.RIGHT;
    L42:
        connect(r14, r5, r6, 0);
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.CENTER;
    L43:
        r3 = getAnchor(r15);
        r13 = r5.getAnchor(r6);
        goto L44
    L34:
        if (r6 == ConstraintAnchor.Type.RIGHT) goto L41;
        if (r6 != ConstraintAnchor.Type.TOP) goto L39;
    L40:
        connect(ConstraintAnchor.Type.TOP, r5, r6, 0);
        r14 = ConstraintAnchor.Type.BOTTOM;
        goto L42
    L39:
        if (r6 == ConstraintAnchor.Type.BOTTOM) goto L40;
        return;
    L46:
        if (r4 != ConstraintAnchor.Type.CENTER_X) goto L53;
        if (r6 != ConstraintAnchor.Type.LEFT) goto L50;
    L51:
        ConstraintAnchor r16 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r17 = r5.getAnchor(r6);
        ConstraintAnchor r18 = getAnchor(ConstraintAnchor.Type.RIGHT);
        r16.connect(r17, 0);
        r18.connect(r17, 0);
        getAnchor(ConstraintAnchor.Type.CENTER_X).connect(r17, 0);
        return;
    L50:
        if (r6 == ConstraintAnchor.Type.RIGHT) goto L51;
    L53:
        if (r4 != ConstraintAnchor.Type.CENTER_Y) goto L60;
        if (r6 != ConstraintAnchor.Type.TOP) goto L57;
    L58:
        r13 = r5.getAnchor(r6);
        getAnchor(ConstraintAnchor.Type.TOP).connect(r13, 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r13, 0);
        r3 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        goto L44
    L57:
        if (r6 == ConstraintAnchor.Type.BOTTOM) goto L58;
    L60:
        if (r4 != ConstraintAnchor.Type.CENTER_X) goto L65;
        if (r6 != ConstraintAnchor.Type.CENTER_X) goto L65;
        getAnchor(ConstraintAnchor.Type.LEFT).connect(r5.getAnchor(ConstraintAnchor.Type.LEFT), 0);
        getAnchor(ConstraintAnchor.Type.RIGHT).connect(r5.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
        r15 = ConstraintAnchor.Type.CENTER_X;
    L65:
        if (r4 == ConstraintAnchor.Type.CENTER_Y) goto L67;
    L69:
        ConstraintAnchor r1 = getAnchor(r4);
        ConstraintAnchor r19 = r5.getAnchor(r6);
        if (r1.isValidConnection(r19) == true) goto L72;
        return;
    L72:
        if (r4 != ConstraintAnchor.Type.BASELINE) goto L79;
        ConstraintAnchor r20 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r21 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r20 == null) goto L76;
        r20.reset();
    L76:
        if (r21 != null) goto L93;
    L103:
        r1.connect(r19, r7);
        return;
    L93:
        r21.reset();
        goto L103
    L79:
        if (r4 != ConstraintAnchor.Type.TOP) goto L81;
    L94:
        ConstraintAnchor r22 = getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r22 == null) goto L97;
        r22.reset();
    L97:
        ConstraintAnchor r23 = getAnchor(ConstraintAnchor.Type.CENTER);
        if (r23.getTarget() == r19) goto L100;
        r23.reset();
    L100:
        ConstraintAnchor r24 = getAnchor(r4).getOpposite();
        r21 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r21.isConnected() == false) goto L103;
    L92:
        r24.reset();
        goto L93
    L81:
        if (r4 == ConstraintAnchor.Type.BOTTOM) goto L94;
        if (r4 != ConstraintAnchor.Type.LEFT) goto L86;
    L87:
        ConstraintAnchor r25 = getAnchor(ConstraintAnchor.Type.CENTER);
        if (r25.getTarget() == r19) goto L90;
        r25.reset();
    L90:
        r24 = getAnchor(r4).getOpposite();
        r21 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        if (r21.isConnected() == false) goto L103;
    L86:
        if (r4 != ConstraintAnchor.Type.RIGHT) goto L103;
    L67:
        if (r6 != ConstraintAnchor.Type.CENTER_Y) goto L69;
        getAnchor(ConstraintAnchor.Type.TOP).connect(r5.getAnchor(ConstraintAnchor.Type.TOP), 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r5.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
        r15 = ConstraintAnchor.Type.CENTER_Y;
        goto L43
    }

    public void connect(ConstraintAnchor r2, ConstraintAnchor r3, int r4) {
        if (r2.getOwner() != this) goto L6;
        connect(r2.getType(), r3.getOwner(), r3.getType(), r4);
        return;
    }

    public void connectCircularConstraint(ConstraintWidget r7, float r8, int r9) {
        immediateConnect(ConstraintAnchor.Type.CENTER, r7, ConstraintAnchor.Type.CENTER, r9, 0);
        this.mCircleConstraintAngle = r8;
    }

    public void copy(ConstraintWidget r9, HashMap<ConstraintWidget, ConstraintWidget> r10) {
        this.mHorizontalResolution = r9.mHorizontalResolution;
        this.mVerticalResolution = r9.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = r9.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = r9.mMatchConstraintDefaultHeight;
        int[] r1 = this.mResolvedMatchConstraintDefault;
        int[] r2 = r9.mResolvedMatchConstraintDefault;
        r1[0] = r2[0];
        r1[1] = r2[1];
        this.mMatchConstraintMinWidth = r9.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = r9.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = r9.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = r9.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = r9.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = r9.mIsWidthWrapContent;
        this.mIsHeightWrapContent = r9.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = r9.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = r9.mResolvedDimensionRatio;
        int[] r3 = r9.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(r3, r3.length);
        this.mCircleConstraintAngle = r9.mCircleConstraintAngle;
        this.hasBaseline = r9.hasBaseline;
        this.inPlaceholder = r9.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.mListDimensionBehaviors, 2), DimensionBehaviour[].class, "com.obric.memorydata.plugin");
        ConstraintWidget r4 = null;
        if (this.mParent != null) goto L5;
        ConstraintWidget r5 = null;
    L6:
        this.mParent = r5;
        this.mWidth = r9.mWidth;
        this.mHeight = r9.mHeight;
        this.mDimensionRatio = r9.mDimensionRatio;
        this.mDimensionRatioSide = r9.mDimensionRatioSide;
        this.mX = r9.mX;
        this.mY = r9.mY;
        this.mRelX = r9.mRelX;
        this.mRelY = r9.mRelY;
        this.mOffsetX = r9.mOffsetX;
        this.mOffsetY = r9.mOffsetY;
        this.mBaselineDistance = r9.mBaselineDistance;
        this.mMinWidth = r9.mMinWidth;
        this.mMinHeight = r9.mMinHeight;
        this.mHorizontalBiasPercent = r9.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = r9.mVerticalBiasPercent;
        this.mCompanionWidget = r9.mCompanionWidget;
        this.mContainerItemSkip = r9.mContainerItemSkip;
        this.mVisibility = r9.mVisibility;
        this.mAnimated = r9.mAnimated;
        this.mDebugName = r9.mDebugName;
        this.mType = r9.mType;
        this.mDistToTop = r9.mDistToTop;
        this.mDistToLeft = r9.mDistToLeft;
        this.mDistToRight = r9.mDistToRight;
        this.mDistToBottom = r9.mDistToBottom;
        this.mLeftHasCentered = r9.mLeftHasCentered;
        this.mRightHasCentered = r9.mRightHasCentered;
        this.mTopHasCentered = r9.mTopHasCentered;
        this.mBottomHasCentered = r9.mBottomHasCentered;
        this.mHorizontalWrapVisited = r9.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = r9.mVerticalWrapVisited;
        this.mHorizontalChainStyle = r9.mHorizontalChainStyle;
        this.mVerticalChainStyle = r9.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = r9.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = r9.mVerticalChainFixedPosition;
        float[] r6 = this.mWeight;
        float[] r7 = r9.mWeight;
        r6[0] = r7[0];
        r6[1] = r7[1];
        ConstraintWidget[] r8 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] r11 = r9.mListNextMatchConstraintsWidget;
        r8[0] = r11[0];
        r8[1] = r11[1];
        ConstraintWidget[] r12 = this.mNextChainWidget;
        ConstraintWidget[] r13 = r9.mNextChainWidget;
        r12[0] = r13[0];
        r12[1] = r13[1];
        ConstraintWidget r14 = r9.mHorizontalNextWidget;
        if (r14 != null) goto L9;
        ConstraintWidget r15 = null;
    L10:
        this.mHorizontalNextWidget = r15;
        ConstraintWidget r16 = r9.mVerticalNextWidget;
        if (r16 == null) goto L14;
        r4 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r16), ConstraintWidget.class, "com.obric.memorydata.plugin");
    L14:
        this.mVerticalNextWidget = r4;
        return;
    L9:
        r15 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r14), ConstraintWidget.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r5 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r10.get(r9.mParent), ConstraintWidget.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void createObjectVariables(LinearSystem r2) {
        r2.createObjectVariable(this.mLeft);
        r2.createObjectVariable(this.mTop);
        r2.createObjectVariable(this.mRight);
        r2.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance <= 0) goto L6;
        r2.createObjectVariable(this.mBaseline);
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

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r3) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r3.ordinal()]) {
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
        throw new AssertionError(r3.name());
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

    public float getBiasPercent(int r2) {
        if (r2 != 0) goto L6;
        return this.mHorizontalBiasPercent;
    L6:
        if (r2 == 1) goto L8;
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

    public DimensionBehaviour getDimensionBehaviour(int r2) {
        if (r2 != 0) goto L6;
        return getHorizontalDimensionBehaviour();
    L6:
        if (r2 == 1) goto L8;
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
        ConstraintWidget r2 = this;
        ConstraintWidget r0 = null;
    L5:
        if (r0 != null) goto L26;
        if (r2 == null) goto L26;
        ConstraintAnchor r3 = r2.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r3 != null) goto L10;
        ConstraintAnchor r4 = null;
    L11:
        if (r4 != null) goto L13;
        ConstraintWidget r5 = null;
    L15:
        if (r5 == getParent()) goto L37;
        if (r5 != null) goto L19;
        ConstraintAnchor r6 = null;
    L20:
        if (r6 == null) goto L24;
        if (r6.getOwner() == r2) goto L24;
        r0 = r2;
    L24:
        r2 = r5;
        goto L5
    L19:
        r6 = r5.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        goto L20
    L37:
        return r2;
    L13:
        r5 = r4.getOwner();
        goto L15
    L10:
        r4 = r3.getTarget();
    L26:
        return r0;
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
        ConstraintAnchor r0 = this.mLeft;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 + r0.mMargin;
    L5:
        ConstraintAnchor r2 = this.mRight;
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r1 + r2.mMargin;
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

    public int getLength(int r2) {
        if (r2 != 0) goto L6;
        return getWidth();
    L6:
        if (r2 == 1) goto L8;
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

    public ConstraintWidget getNextChainMember(int r2) {
        if (r2 != 0) goto L10;
        if (this.mRight.mTarget == null) goto L16;
        ConstraintAnchor r3 = this.mRight.mTarget.mTarget;
        ConstraintAnchor r1 = this.mRight;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.mTarget.mOwner;
    L16:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.mBottom.mTarget == null) goto L20;
        ConstraintAnchor r4 = this.mBottom.mTarget.mTarget;
        r1 = this.mBottom;
        if (r4 == r1) goto L8;
        return null;
    L20:
        return null;
    }

    public int getOptimizerWrapHeight() {
        int r0 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r0;
    L5:
        if (this.mMatchConstraintDefaultHeight != 1) goto L7;
        int r1 = Math.max(this.mMatchConstraintMinHeight, r0);
    L11:
        int r4 = this.mMatchConstraintMaxHeight;
        if (r4 <= 0) goto L17;
        if (r4 < r1) goto L15;
        return r1;
    L15:
        return r4;
    L17:
        return r1;
    L7:
        r1 = this.mMatchConstraintMinHeight;
        if (r1 <= 0) goto L10;
        this.mHeight = r1;
        goto L11
    L10:
        r1 = 0;
        goto L11
    }

    public int getOptimizerWrapWidth() {
        int r0 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r0;
    L5:
        if (this.mMatchConstraintDefaultWidth != 1) goto L7;
        int r1 = Math.max(this.mMatchConstraintMinWidth, r0);
    L11:
        int r4 = this.mMatchConstraintMaxWidth;
        if (r4 <= 0) goto L17;
        if (r4 < r1) goto L15;
        return r1;
    L15:
        return r4;
    L17:
        return r1;
    L7:
        r1 = this.mMatchConstraintMinWidth;
        if (r1 <= 0) goto L10;
        this.mWidth = r1;
        goto L11
    L10:
        r1 = 0;
        goto L11
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int r2) {
        if (r2 != 0) goto L10;
        if (this.mLeft.mTarget == null) goto L16;
        ConstraintAnchor r3 = this.mLeft.mTarget.mTarget;
        ConstraintAnchor r1 = this.mLeft;
        if (r3 == r1) goto L8;
        return null;
    L8:
        return r1.mTarget.mOwner;
    L16:
        return null;
    L10:
        if (r2 == 1) goto L12;
        return null;
    L12:
        if (this.mTop.mTarget == null) goto L20;
        ConstraintAnchor r4 = this.mTop.mTarget.mTarget;
        r1 = this.mTop;
        if (r4 == r1) goto L8;
        return null;
    L20:
        return null;
    }

    int getRelativePositioning(int r2) {
        if (r2 != 0) goto L6;
        return this.mRelX;
    L6:
        if (r2 == 1) goto L8;
        return 0;
    L8:
        return this.mRelY;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int r2) {
        if (r2 != 0) goto L6;
        return this.horizontalRun;
    L6:
        if (r2 == 1) goto L8;
        return null;
    L8:
        return this.verticalRun;
    }

    public void getSceneString(StringBuilder r13) {
        r13.append("  " + this.stringId + ":{\n");
        r13.append("    actualWidth:" + this.mWidth);
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
        ConstraintWidget r2 = this;
        ConstraintWidget r0 = null;
    L5:
        if (r0 != null) goto L26;
        if (r2 == null) goto L26;
        ConstraintAnchor r3 = r2.getAnchor(ConstraintAnchor.Type.TOP);
        if (r3 != null) goto L10;
        ConstraintAnchor r4 = null;
    L11:
        if (r4 != null) goto L13;
        ConstraintWidget r5 = null;
    L15:
        if (r5 == getParent()) goto L37;
        if (r5 != null) goto L19;
        ConstraintAnchor r6 = null;
    L20:
        if (r6 == null) goto L24;
        if (r6.getOwner() == r2) goto L24;
        r0 = r2;
    L24:
        r2 = r5;
        goto L5
    L19:
        r6 = r5.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        goto L20
    L37:
        return r2;
    L13:
        r5 = r4.getOwner();
        goto L15
    L10:
        r4 = r3.getTarget();
    L26:
        return r0;
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
        int r1 = 0;
        if (this.mLeft == null) goto L6;
        r1 = 0 + this.mTop.mMargin;
    L6:
        if (this.mRight != null) goto L8;
        return r1;
    L8:
        return r1 + this.mBottom.mMargin;
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
        ConstraintWidget r0 = this.mParent;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, ConstraintWidgetContainer.class) == false) goto L9;
        return ((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(this.mParent, ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).mPaddingLeft + this.mX;
    L9:
        return this.mX;
    }

    public int getY() {
        ConstraintWidget r0 = this.mParent;
        if (r0 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r0, ConstraintWidgetContainer.class) == false) goto L9;
        return ((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(this.mParent, ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).mPaddingTop + this.mY;
    L9:
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int r5) {
        if (r5 != 0) goto L18;
        if (this.mLeft.mTarget == null) goto L7;
        int r6 = 1;
    L9:
        if (this.mRight.mTarget == null) goto L11;
        int r4 = 1;
    L13:
        if ((r6 + r4) >= 2) goto L16;
        return true;
    L16:
        return false;
    L11:
        r4 = 0;
        goto L13
    L7:
        r6 = 0;
        goto L9
    L18:
        if (this.mTop.mTarget == null) goto L20;
        int r7 = 1;
    L22:
        if (this.mBottom.mTarget == null) goto L24;
        int r3 = 1;
    L25:
        int r8 = r7 + r3;
        if (this.mBaseline.mTarget == null) goto L28;
        int r9 = 1;
    L30:
        if ((r8 + r9) >= 2) goto L33;
        return true;
    L33:
        return false;
    L28:
        r9 = 0;
        goto L30
    L24:
        r3 = 0;
        goto L25
    L20:
        r7 = 0;
        goto L22
    }

    public boolean hasDependencies() {
        int r0 = this.mAnchors.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.mAnchors.get(r2), ConstraintAnchor.class, "com.obric.memorydata.plugin")).hasDependents() == true) goto L6;
        r2 = r2 + 1;
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

    public boolean hasResolvedTargets(int r4, int r5) {
        if (r4 != 0) goto L18;
        if (this.mLeft.mTarget != null) goto L7;
    L30:
        return false;
    L7:
        if (this.mLeft.mTarget.hasFinalValue() == false) goto L30;
        if (this.mRight.mTarget == null) goto L30;
        if (this.mRight.mTarget.hasFinalValue() == false) goto L30;
        if (((this.mRight.mTarget.getFinalValue() - this.mRight.getMargin()) - (this.mLeft.mTarget.getFinalValue() + this.mLeft.getMargin())) < r5) goto L16;
        return true;
    L16:
        return false;
    L18:
        if (this.mTop.mTarget == null) goto L30;
        if (this.mTop.mTarget.hasFinalValue() == false) goto L30;
        if (this.mBottom.mTarget == null) goto L30;
        if (this.mBottom.mTarget.hasFinalValue() == false) goto L30;
        if (((this.mBottom.mTarget.getFinalValue() - this.mBottom.getMargin()) - (this.mTop.mTarget.getFinalValue() + this.mTop.getMargin())) < r5) goto L29;
        return true;
    L29:
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type r1, ConstraintWidget r2, ConstraintAnchor.Type r3, int r4, int r5) {
        getAnchor(r1).connect(r2.getAnchor(r3), r4, r5, true);
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

    public boolean isInBarrier(int r1) {
        return this.mIsInBarrier[r1];
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget == null) goto L7;
        if (this.mLeft.mTarget.mTarget != this.mLeft) goto L7;
        return true;
    L7:
        if (this.mRight.mTarget != null) goto L9;
        return false;
    L9:
        if (this.mRight.mTarget.mTarget != this.mRight) goto L15;
        return true;
    L15:
        return false;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget == null) goto L7;
        if (this.mTop.mTarget.mTarget != this.mTop) goto L7;
        return true;
    L7:
        if (this.mBottom.mTarget != null) goto L9;
        return false;
    L9:
        if (this.mBottom.mTarget.mTarget != this.mBottom) goto L15;
        return true;
    L15:
        return false;
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

    public boolean oppositeDimensionDependsOn(int r4) {
        if (r4 != 0) goto L5;
        char r2 = 1;
    L6:
        DimensionBehaviour[] r3 = this.mListDimensionBehaviors;
        DimensionBehaviour r5 = r3[r4];
        DimensionBehaviour r6 = r3[r2];
        if (r5 != DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        if (r6 != DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        return true;
    L12:
        return false;
    L5:
        r2 = 0;
        goto L6
    }

    public boolean oppositeDimensionsTied() {
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return false;
    L5:
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
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
        float r3 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r3;
        this.mVerticalBiasPercent = r3;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
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
        float[] r0 = this.mWeight;
        r0[0] = -1.0f;
        r0[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r1 = this.mMaxDimension;
        r1[0] = Integer.MAX_VALUE;
        r1[1] = Integer.MAX_VALUE;
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
        boolean[] r2 = this.isTerminalWidget;
        r2[0] = true;
        r2[1] = true;
        this.mInVirtualLayout = false;
        boolean[] r4 = this.mIsInBarrier;
        r4[0] = false;
        r4[1] = false;
        this.mMeasureRequested = true;
        int[] r5 = this.mResolvedMatchConstraintDefault;
        r5[0] = 0;
        r5[1] = 0;
        this.mWidthOverride = -1;
        this.mHeightOverride = -1;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor r9) {
        if (getParent() != null) goto L5;
    L9:
        ConstraintAnchor r0 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r1 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r2 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r3 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor r4 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor r5 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor r6 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r9 == r4) goto L12;
        if (r9 == r5) goto L29;
        if (r9 == r6) goto L38;
        if (r9 == r0) goto L55;
        if (r9 == r1) goto L55;
        if (r9 == r2) goto L50;
        if (r9 == r3) goto L50;
    L59:
        r9.reset();
        return;
    L50:
        if (r2.isConnected() == false) goto L59;
        if (r2.getTarget() != r3.getTarget()) goto L59;
    L58:
        r4.reset();
    L55:
        if (r0.isConnected() == false) goto L59;
        if (r0.getTarget() != r1.getTarget()) goto L59;
    L38:
        if (r2.isConnected() == true) goto L40;
    L26:
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L40:
        if (r3.isConnected() == false) goto L26;
        if (r2.getTarget().getOwner() != r3.getTarget().getOwner()) goto L26;
        r2.reset();
        r3.reset();
        goto L26
    L29:
        if (r0.isConnected() == true) goto L31;
    L35:
        this.mHorizontalBiasPercent = 0.5f;
        goto L59
    L31:
        if (r1.isConnected() == false) goto L35;
        if (r0.getTarget().getOwner() != r1.getTarget().getOwner()) goto L35;
        r0.reset();
        r1.reset();
        goto L35
    L12:
        if (r0.isConnected() == false) goto L19;
        if (r1.isConnected() == false) goto L19;
        if (r0.getTarget() != r1.getTarget()) goto L19;
        r0.reset();
        r1.reset();
    L19:
        if (r2.isConnected() == true) goto L21;
    L25:
        this.mHorizontalBiasPercent = 0.5f;
        goto L26
    L21:
        if (r3.isConnected() == false) goto L25;
        if (r2.getTarget() != r3.getTarget()) goto L25;
        r2.reset();
        r3.reset();
        goto L25
    L5:
        if (ZeusTransformUtils.instanceOf(getParent(), ConstraintWidgetContainer.class) == false) goto L9;
        if (((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).handlesInternalConstraints() == false) goto L9;
    }

    public void resetAnchors() {
        ConstraintWidget r0 = getParent();
        if (r0 != null) goto L5;
    L9:
        int r1 = 0;
        int r2 = this.mAnchors.size();
    L10:
        if (r1 >= r2) goto L12;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.mAnchors.get(r1), ConstraintAnchor.class, "com.obric.memorydata.plugin")).reset();
        r1 = r1 + 1;
        goto L10
    L12:
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, ConstraintWidgetContainer.class) == false) goto L9;
        if (((ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin")).handlesInternalConstraints() == false) goto L9;
    }

    public void resetFinalResolution() {
        int r0 = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.horizontalSolvingPass = false;
        this.verticalSolvingPass = false;
        int r1 = this.mAnchors.size();
    L3:
        if (r0 >= r1) goto L5;
        ((ConstraintAnchor) ZeusTransformUtils.preCheckCast(this.mAnchors.get(r0), ConstraintAnchor.class, "com.obric.memorydata.plugin")).resetFinalResolution();
        r0 = r0 + 1;
        goto L3
    }

    public void resetSolverVariables(Cache r2) {
        this.mLeft.resetSolverVariable(r2);
        this.mTop.resetSolverVariable(r2);
        this.mRight.resetSolverVariable(r2);
        this.mBottom.resetSolverVariable(r2);
        this.mBaseline.resetSolverVariable(r2);
        this.mCenter.resetSolverVariable(r2);
        this.mCenterX.resetSolverVariable(r2);
        this.mCenterY.resetSolverVariable(r2);
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

    public void setAnimated(boolean r1) {
        this.mAnimated = r1;
    }

    public void setBaselineDistance(int r1) {
        this.mBaselineDistance = r1;
        if (r1 <= 0) goto L5;
        boolean r2 = true;
    L6:
        this.hasBaseline = r2;
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void setCompanionWidget(Object r1) {
        this.mCompanionWidget = r1;
    }

    public void setContainerItemSkip(int r1) {
        if (r1 >= 0) goto L5;
        r1 = 0;
    L5:
        this.mContainerItemSkip = r1;
    }

    public void setDebugName(String r1) {
        this.mDebugName = r1;
    }

    public void setDebugSolverName(LinearSystem r7, String r8) {
        this.mDebugName = r8;
        SolverVariable r0 = r7.createObjectVariable(this.mLeft);
        SolverVariable r1 = r7.createObjectVariable(this.mTop);
        SolverVariable r2 = r7.createObjectVariable(this.mRight);
        SolverVariable r3 = r7.createObjectVariable(this.mBottom);
        r0.setName(r8 + ".left");
        r1.setName(r8 + ".top");
        r2.setName(r8 + ".right");
        r3.setName(r8 + ".bottom");
        r7.createObjectVariable(this.mBaseline).setName(r8 + ".baseline");
    }

    public void setDimension(int r2, int r3) {
        this.mWidth = r2;
        int r0 = this.mMinWidth;
        if (r2 >= r0) goto L5;
        this.mWidth = r0;
    L5:
        this.mHeight = r3;
        int r4 = this.mMinHeight;
        if (r3 >= r4) goto L9;
        this.mHeight = r4;
        return;
    }

    public void setDimensionRatio(float r1, int r2) {
        this.mDimensionRatio = r1;
        this.mDimensionRatioSide = r2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String r9) {
        int r0 = 0;
        if (r9 != null) goto L5;
    L43:
        this.mDimensionRatio = 0.0f;
        return;
    L5:
        if (r9.length() == 0) goto L43;
        int r1 = -1;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L10;
    L18:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L21;
    L34:
        String r10 = r9.substring(r4);
        if (r10.length() <= 0) goto L38;
        float r11 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L45
    L39:
        r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1));
        if (r0 <= 0) goto L48;
        this.mDimensionRatio = r11;
        this.mDimensionRatioSide = r1;
        return;
    L48:
        return;
    L21:
        if (r5 >= (r2 - 1)) goto L34;
        String r6 = r9.substring(r4, r5);
        String r12 = r9.substring(r5 + 1);
        if (r6.length() <= 0) goto L38;
        if (r12.length() <= 0) goto L38;
        float r7 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L45
        float r13 = Float.parseFloat(r12);     // Catch: NumberFormatException -> L45
        if (r7 <= 0.0f) goto L38;
        if (r13 <= 0.0f) goto L38;
        if (r1 != 1) goto L32;
        r11 = Math.abs(r13 / r7);     // Catch: NumberFormatException -> L45
        goto L39
    L32:
        r11 = Math.abs(r7 / r13);     // Catch: NumberFormatException -> L45
    L38:
        r11 = r0;
        goto L39
    L10:
        if (r3 >= (r2 - 1)) goto L18;
        String r8 = r9.substring(0, r3);
        if (r8.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L15;
        r1 = 0;
    L17:
        r4 = r3 + 1;
        goto L18
    L15:
        if (r8.equalsIgnoreCase(i.n) == false) goto L17;
        r1 = 1;
        goto L17
    }

    public void setFinalBaseline(int r4) {
        if (this.hasBaseline == true) goto L5;
        return;
    L5:
        int r0 = r4 - this.mBaselineDistance;
        int r1 = this.mHeight + r0;
        this.mY = r0;
        this.mTop.setFinalValue(r0);
        this.mBottom.setFinalValue(r1);
        this.mBaseline.setFinalValue(r4);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int r1, int r2, int r3, int r4, int r5, int r6) {
        setFrame(r1, r2, r3, r4);
        setBaselineDistance(r5);
        if (r6 != 0) goto L6;
        this.resolvedHorizontal = true;
    L5:
        this.resolvedVertical = false;
        return;
    L6:
        if (r6 != 1) goto L10;
        this.resolvedHorizontal = false;
    L8:
        this.resolvedVertical = true;
        return;
    L10:
        if (r6 != 2) goto L12;
        this.resolvedHorizontal = true;
        goto L8
    L12:
        this.resolvedHorizontal = false;
        goto L5
    }

    public void setFinalHorizontal(int r2, int r3) {
        if (this.resolvedHorizontal == false) goto L5;
        return;
    L5:
        this.mLeft.setFinalValue(r2);
        this.mRight.setFinalValue(r3);
        this.mX = r2;
        this.mWidth = r3 - r2;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int r2) {
        this.mLeft.setFinalValue(r2);
        this.mX = r2;
    }

    public void setFinalTop(int r2) {
        this.mTop.setFinalValue(r2);
        this.mY = r2;
    }

    public void setFinalVertical(int r2, int r3) {
        if (this.resolvedVertical == false) goto L5;
        return;
    L5:
        this.mTop.setFinalValue(r2);
        this.mBottom.setFinalValue(r3);
        this.mY = r2;
        this.mHeight = r3 - r2;
        if (this.hasBaseline == false) goto L8;
        this.mBaseline.setFinalValue(r2 + this.mBaselineDistance);
    L8:
        this.resolvedVertical = true;
    }

    public void setFrame(int r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        setHorizontalDimension(r2, r3);
        return;
    L5:
        if (r4 != 1) goto L9;
        setVerticalDimension(r2, r3);
        return;
    }

    public void setFrame(int r3, int r4, int r5, int r6) {
        int r7 = r5 - r3;
        int r8 = r6 - r4;
        this.mX = r3;
        this.mY = r4;
        if (this.mVisibility != 8) goto L7;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L7:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L12;
        int r9 = this.mWidth;
        if (r7 >= r9) goto L12;
        r7 = r9;
    L12:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) goto L16;
        int r10 = this.mHeight;
        if (r8 >= r10) goto L16;
        r8 = r10;
    L16:
        this.mWidth = r7;
        this.mHeight = r8;
        int r11 = this.mMinHeight;
        if (r8 >= r11) goto L19;
        this.mHeight = r11;
    L19:
        int r12 = this.mMinWidth;
        if (r7 >= r12) goto L23;
        this.mWidth = r12;
    L23:
        if (this.mMatchConstraintMaxWidth <= 0) goto L28;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) goto L28;
        this.mWidth = Math.min(this.mWidth, this.mMatchConstraintMaxWidth);
    L28:
        if (this.mMatchConstraintMaxHeight > 0) goto L30;
    L32:
        int r13 = this.mWidth;
        if (r7 == r13) goto L35;
        this.mWidthOverride = r13;
    L35:
        int r14 = this.mHeight;
        if (r8 == r14) goto L39;
        this.mHeightOverride = r14;
        return;
    L39:
        return;
    L30:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        this.mHeight = Math.min(this.mHeight, this.mMatchConstraintMaxHeight);
        goto L32
    }

    public void setGoneMargin(ConstraintAnchor.Type r2, int r3) {
        int r4 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r2.ordinal()];
        if (r4 != 1) goto L5;
        ConstraintAnchor r1 = this.mLeft;
    L18:
        r1.mGoneMargin = r3;
        return;
    L5:
        if (r4 != 2) goto L7;
        r1 = this.mTop;
        goto L18
    L7:
        if (r4 != 3) goto L9;
        r1 = this.mRight;
        goto L18
    L9:
        if (r4 != 4) goto L11;
        r1 = this.mBottom;
        goto L18
    L11:
        if (r4 != 5) goto L20;
        r1 = this.mBaseline;
        goto L18
    }

    public void setHasBaseline(boolean r1) {
        this.hasBaseline = r1;
    }

    public void setHeight(int r2) {
        this.mHeight = r2;
        int r0 = this.mMinHeight;
        if (r2 >= r0) goto L6;
        this.mHeight = r0;
        return;
    }

    public void setHeightWrapContent(boolean r1) {
        this.mIsHeightWrapContent = r1;
    }

    public void setHorizontalBiasPercent(float r1) {
        this.mHorizontalBiasPercent = r1;
    }

    public void setHorizontalChainStyle(int r1) {
        this.mHorizontalChainStyle = r1;
    }

    public void setHorizontalDimension(int r1, int r2) {
        this.mX = r1;
        int r3 = r2 - r1;
        this.mWidth = r3;
        int r4 = this.mMinWidth;
        if (r3 >= r4) goto L6;
        this.mWidth = r4;
        return;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour r2) {
        this.mListDimensionBehaviors[0] = r2;
    }

    public void setHorizontalMatchStyle(int r1, int r2, int r3, float r4) {
        this.mMatchConstraintDefaultWidth = r1;
        this.mMatchConstraintMinWidth = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.mMatchConstraintMaxWidth = r3;
        this.mMatchConstraintPercentWidth = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.mMatchConstraintDefaultWidth = 2;
        return;
    L14:
        return;
    }

    public void setHorizontalWeight(float r2) {
        this.mWeight[0] = r2;
    }

    public void setInBarrier(int r1, boolean r2) {
        this.mIsInBarrier[r1] = r2;
    }

    public void setInPlaceholder(boolean r1) {
        this.inPlaceholder = r1;
    }

    public void setInVirtualLayout(boolean r1) {
        this.mInVirtualLayout = r1;
    }

    public void setLastMeasureSpec(int r1, int r2) {
        this.mLastHorizontalMeasureSpec = r1;
        this.mLastVerticalMeasureSpec = r2;
        setMeasureRequested(false);
    }

    public void setLength(int r2, int r3) {
        if (r3 != 0) goto L5;
        setWidth(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        setHeight(r2);
        return;
    }

    public void setMaxHeight(int r2) {
        this.mMaxDimension[1] = r2;
    }

    public void setMaxWidth(int r2) {
        this.mMaxDimension[0] = r2;
    }

    public void setMeasureRequested(boolean r1) {
        this.mMeasureRequested = r1;
    }

    public void setMinHeight(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.mMinHeight = r1;
    }

    public void setMinWidth(int r1) {
        if (r1 >= 0) goto L4;
        r1 = 0;
    L4:
        this.mMinWidth = r1;
    }

    public void setOffset(int r1, int r2) {
        this.mOffsetX = r1;
        this.mOffsetY = r2;
    }

    public void setOrigin(int r1, int r2) {
        this.mX = r1;
        this.mY = r2;
    }

    public void setParent(ConstraintWidget r1) {
        this.mParent = r1;
    }

    void setRelativePositioning(int r2, int r3) {
        if (r3 != 0) goto L5;
        this.mRelX = r2;
        return;
    L5:
        if (r3 != 1) goto L9;
        this.mRelY = r2;
        return;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public void setVerticalBiasPercent(float r1) {
        this.mVerticalBiasPercent = r1;
    }

    public void setVerticalChainStyle(int r1) {
        this.mVerticalChainStyle = r1;
    }

    public void setVerticalDimension(int r1, int r2) {
        this.mY = r1;
        int r3 = r2 - r1;
        this.mHeight = r3;
        int r4 = this.mMinHeight;
        if (r3 >= r4) goto L6;
        this.mHeight = r4;
        return;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour r2) {
        this.mListDimensionBehaviors[1] = r2;
    }

    public void setVerticalMatchStyle(int r1, int r2, int r3, float r4) {
        this.mMatchConstraintDefaultHeight = r1;
        this.mMatchConstraintMinHeight = r2;
        if (r3 != Integer.MAX_VALUE) goto L5;
        r3 = 0;
    L5:
        this.mMatchConstraintMaxHeight = r3;
        this.mMatchConstraintPercentHeight = r4;
        if (r4 > 0.0f) goto L8;
        return;
    L8:
        if (r4 >= 1.0f) goto L13;
        if (r1 != 0) goto L14;
        this.mMatchConstraintDefaultHeight = 2;
        return;
    L14:
        return;
    }

    public void setVerticalWeight(float r2) {
        this.mWeight[1] = r2;
    }

    public void setVisibility(int r1) {
        this.mVisibility = r1;
    }

    public void setWidth(int r2) {
        this.mWidth = r2;
        int r0 = this.mMinWidth;
        if (r2 >= r0) goto L6;
        this.mWidth = r0;
        return;
    }

    public void setWidthWrapContent(boolean r1) {
        this.mIsWidthWrapContent = r1;
    }

    public void setWrapBehaviorInParent(int r2) {
        if (r2 >= 0) goto L4;
        return;
    L4:
        if (r2 > 3) goto L8;
        this.mWrapBehaviorInParent = r2;
        return;
    }

    public void setX(int r1) {
        this.mX = r1;
    }

    public void setY(int r1) {
        this.mY = r1;
    }

    public void setupDimensionRatio(boolean r4, boolean r5, boolean r6, boolean r7) {
        if (this.mResolvedDimensionRatioSide != (-1)) goto L13;
        if (r6 == false) goto L7;
        if (r7 == true) goto L7;
        this.mResolvedDimensionRatioSide = 0;
    L7:
        if (r6 == true) goto L13;
        if (r7 == false) goto L13;
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
        int r8 = this.mMatchConstraintMinWidth;
        if (r8 > 0) goto L51;
    L53:
        if (r8 == 0) goto L55;
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
        StringBuilder r0 = new StringBuilder();
        String r3 = "";
        if (this.mType == null) goto L5;
        String r1 = "type: " + this.mType + " ";
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.mDebugName == null) goto L10;
        r3 = "id: " + this.mDebugName + " ";
    L10:
        return r2.append(r3).append("(").append(this.mX).append(", ").append(this.mY).append(") - (").append(this.mWidth).append(" x ").append(this.mHeight).append(")").toString();
    L5:
        r1 = "";
        goto L6
    }

    public void updateFromRuns(boolean r8, boolean r9) {
        boolean r10 = r8 & this.horizontalRun.isResolved();
        boolean r11 = r9 & this.verticalRun.isResolved();
        int r0 = this.horizontalRun.start.value;
        int r1 = this.verticalRun.start.value;
        int r2 = this.horizontalRun.end.value;
        int r3 = this.verticalRun.end.value;
        int r5 = r3 - r1;
        if ((r2 - r0) < 0) goto L15;
        if (r5 < 0) goto L15;
        if (r0 == Integer.MIN_VALUE) goto L15;
        if (r0 == Integer.MAX_VALUE) goto L15;
        if (r1 == Integer.MIN_VALUE) goto L15;
        if (r1 == Integer.MAX_VALUE) goto L15;
        if (r2 == Integer.MIN_VALUE) goto L15;
        if (r2 == Integer.MAX_VALUE) goto L15;
        if (r3 == Integer.MIN_VALUE) goto L15;
        if (r3 == Integer.MAX_VALUE) goto L15;
    L16:
        int r4 = r2 - r0;
        int r6 = r3 - r1;
        if (r10 == false) goto L19;
        this.mX = r0;
    L19:
        if (r11 == false) goto L22;
        this.mY = r1;
    L22:
        if (this.mVisibility != 8) goto L25;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L25:
        if (r10 == true) goto L27;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED) goto L40;
        int r12 = this.mHeight;
        if (r6 >= r12) goto L40;
        r6 = r12;
    L40:
        this.mHeight = r6;
        int r13 = this.mMinHeight;
        if (r6 >= r13) goto L45;
        this.mHeight = r13;
        return;
    L45:
        return;
    L27:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L31;
        int r14 = this.mWidth;
        if (r4 >= r14) goto L31;
        r4 = r14;
    L31:
        this.mWidth = r4;
        int r15 = this.mMinWidth;
        if (r4 >= r15) goto L34;
        this.mWidth = r15;
    L15:
        r0 = 0;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        goto L16
    }

    public void updateFromSolver(LinearSystem r6, boolean r7) {
        int r0 = r6.getObjectVariableValue(this.mLeft);
        int r1 = r6.getObjectVariableValue(this.mTop);
        int r2 = r6.getObjectVariableValue(this.mRight);
        int r8 = r6.getObjectVariableValue(this.mBottom);
        if (r7 == false) goto L11;
        HorizontalWidgetRun r3 = this.horizontalRun;
        if (r3 == null) goto L11;
        if (r3.start.resolved == false) goto L11;
        if (this.horizontalRun.end.resolved == false) goto L11;
        r0 = this.horizontalRun.start.value;
        r2 = this.horizontalRun.end.value;
    L11:
        if (r7 == false) goto L19;
        VerticalWidgetRun r9 = this.verticalRun;
        if (r9 == null) goto L19;
        if (r9.start.resolved == false) goto L19;
        if (this.verticalRun.end.resolved == false) goto L19;
        r1 = this.verticalRun.start.value;
        r8 = this.verticalRun.end.value;
    L19:
        int r4 = r8 - r1;
        if ((r2 - r0) < 0) goto L32;
        if (r4 < 0) goto L32;
        if (r0 == Integer.MIN_VALUE) goto L32;
        if (r0 == Integer.MAX_VALUE) goto L32;
        if (r1 == Integer.MIN_VALUE) goto L32;
        if (r1 == Integer.MAX_VALUE) goto L32;
        if (r2 == Integer.MIN_VALUE) goto L32;
        if (r2 == Integer.MAX_VALUE) goto L32;
        if (r8 == Integer.MIN_VALUE) goto L32;
        if (r8 == Integer.MAX_VALUE) goto L32;
    L33:
        setFrame(r0, r1, r2, r8);
        return;
    L32:
        r8 = 0;
        r0 = 0;
        r1 = 0;
        r2 = 0;
        goto L33
    }
}
