package androidx.constraintlayout.solver.widgets;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
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
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
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
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
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
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r5 = new int[DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r5;
            r5[DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L36:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L58:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L10:
            int[] r10 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = r10;
            r10[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L34:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L56:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L40:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L48:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
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
            DimensionBehaviour r5 = new DimensionBehaviour("FIXED", 0);
            FIXED = r5;
            DimensionBehaviour r10 = new DimensionBehaviour("WRAP_CONTENT", 1);
            WRAP_CONTENT = r10;
            DimensionBehaviour r11 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            MATCH_CONSTRAINT = r11;
            DimensionBehaviour r12 = new DimensionBehaviour("MATCH_PARENT", 3);
            MATCH_PARENT = r12;
            $VALUES = new DimensionBehaviour[]{r5, r10, r11, r12};
        }

        private DimensionBehaviour(String r5, int r10) {
            super(r5, r10);
        }

        public static DimensionBehaviour valueOf(String r5) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, r5);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) $VALUES.clone();
        }
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
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
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
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r12 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r12;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r12};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r5 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r5, r5};
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
        float r10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r10;
        this.mVerticalBiasPercent = r10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
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
        int r5 = (r14 ? 1 : 0) + 1;
    L9:
        if (r16 == false) goto L11;
        r5 = r5 + 1;
    L11:
        if (r48 == false) goto L13;
        int r18 = 3;
    L14:
        int r17 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[r39.ordinal()];
        if (r17 != 1) goto L17;
    L22:
        int r19 = r18;
    L23:
        boolean r110 = false;
    L28:
        if (this.mVisibility != 8) goto L30;
        int r111 = 0;
        r110 = false;
    L31:
        if (r58 == false) goto L40;
        if (r14 == true) goto L37;
        if (r15 == true) goto L37;
        if (r16 == true) goto L37;
        r32.addEquality(r10, r43);
    L36:
        int r20 = 8;
    L41:
        if (r110 == true) goto L54;
        if (r40 == false) goto L49;
        int r21 = 0;
        r32.addEquality(r11, r10, 0, 3);
        if (r45 <= 0) goto L47;
        r32.addGreaterThan(r11, r10, r45, 8);
    L47:
        if (r46 >= Integer.MAX_VALUE) goto L50;
        r32.addLowerThan(r11, r10, r46, 8);
    L50:
        int r22 = r55;
        int r23 = r56;
        int r112 = r21;
    L51:
        boolean r24 = r110;
    L52:
        int r25 = r5;
    L103:
        if (r58 == false) goto L320;
        if (r50 == false) goto L106;
        char r26 = 2;
    L321:
        if (r25 >= r26) goto L353;
        if (r34 == false) goto L354;
        if (r36 == false) goto L355;
        r32.addGreaterThan(r10, r37, r112, 8);
        if (r33 == false) goto L327;
    L330:
        int r113 = 1;
    L331:
        if (r33 == true) goto L342;
        ConstraintAnchor r27 = this.mBaseline.mTarget;
        if (r27 == null) goto L342;
        ConstraintWidget r28 = r27.mOwner;
        if (r28.mDimensionRatio == 0.0f) goto L341;
        DimensionBehaviour[] r29 = r28.mListDimensionBehaviors;
        DimensionBehaviour r30 = r29[r112];
        DimensionBehaviour r31 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r30 != r31) goto L341;
        if (r29[1] != r31) goto L341;
        int r114 = 1;
    L343:
        if (r114 == 0) goto L356;
        r32.addGreaterThan(r38, r11, r112, 8);
        return;
    L356:
        return;
    L341:
        r114 = r112;
    L342:
        r114 = r113;
        goto L343
    L327:
        if (this.mBaseline.mTarget == null) goto L330;
        r113 = r112;
        goto L331
    L355:
        return;
    L354:
        return;
    L353:
        return;
    L106:
        if (r14 == true) goto L110;
        if (r15 == true) goto L110;
        if (r16 == true) goto L110;
    L109:
        int r59 = r112;
    L299:
        boolean r210 = r34;
    L300:
        if (r210 == false) goto L350;
        if (r36 == true) goto L303;
        return;
    L303:
        if (r42.mTarget == null) goto L306;
        r59 = r42.getMargin();
    L306:
        if (r13 != r38) goto L308;
        return;
    L308:
        if (this.OPTIMIZE_WRAP == true) goto L310;
    L318:
        r32.addGreaterThan(r38, r11, r59, 5);
        return;
    L310:
        if (r11.isFinalValue == false) goto L318;
        ConstraintWidget r60 = this.mParent;
        if (r60 == null) goto L318;
        ConstraintWidgetContainer r61 = (ConstraintWidgetContainer) r60;
        if (r33 == false) goto L316;
        r61.addHorizontalWrapMaxVariable(r42);
        return;
    L316:
        r61.addVerticalWrapMaxVariable(r42);
        return;
    L350:
        return;
    L110:
        if (r14 == false) goto L113;
        if (r15 == false) goto L109;
    L113:
        if (r14 == true) goto L129;
        if (r15 == false) goto L129;
        r32.addEquality(r11, r13, -r42.getMargin(), 8);
        if (r34 == false) goto L109;
        if (this.OPTIMIZE_WRAP == true) goto L120;
    L128:
        int r62 = r112;
        r32.addGreaterThan(r10, r37, r62, 5);
    L127:
        r59 = r62;
        goto L299
    L120:
        if (r10.isFinalValue == false) goto L128;
        ConstraintWidget r63 = this.mParent;
        if (r63 == null) goto L128;
        ConstraintWidgetContainer r64 = (ConstraintWidgetContainer) r63;
        if (r33 == false) goto L126;
        r62 = r112;
        r64.addHorizontalWrapMinVariable(r41);
        goto L127
    L126:
        r62 = r112;
        r64.addVerticalWrapMinVariable(r41);
    L129:
        r62 = r112;
        if (r14 == false) goto L127;
        if (r15 == false) goto L127;
        ConstraintWidget r115 = r41.mTarget.mOwner;
        ConstraintWidget r65 = r42.mTarget.mOwner;
        ConstraintWidget r66 = getParent();
        int r116 = 6;
        if (r24 == false) goto L194;
        if (r19 != 0) goto L154;
        if (r23 != 0) goto L144;
        if (r22 != 0) goto L144;
        if (r12.isFinalValue == true) goto L140;
    L143:
        int r67 = r62;
        int r117 = r67;
        int r68 = 1;
        int r211 = 8;
        int r212 = 8;
    L146:
        if ((r115 instanceof Barrier) == false) goto L148;
    L152:
        r212 = 4;
    L151:
        int r213 = r68;
        r116 = 6;
    L208:
        if (r117 == 0) goto L212;
        if (r12 != r13) goto L212;
        if (r115 == r66) goto L212;
        r117 = 0;
        boolean r214 = false;
    L213:
        if (r67 == 0) goto L222;
        if (r24 == true) goto L220;
        if (r49 == true) goto L220;
        if (r51 == true) goto L220;
        if (r12 != r37) goto L220;
        if (r13 != r38) goto L220;
        r210 = false;
        int r215 = 8;
        boolean r216 = false;
        int r217 = 8;
    L221:
        int r310 = r19;
        ConstraintWidget r218 = r66;
        r32.addCentering(r10, r12, r41.getMargin(), r47, r13, r11, r42.getMargin(), r215);
        r214 = r216;
    L224:
        if (this.mVisibility == 8) goto L226;
    L228:
        if (r117 == 0) goto L239;
        if (r210 == false) goto L237;
        if (r12 == r13) goto L237;
        if (r24 == true) goto L237;
        if ((r115 instanceof Barrier) == false) goto L235;
    L236:
        int r69 = 6;
    L238:
        r32.addGreaterThan(r10, r12, r41.getMargin(), r69);
        SolverVariable r70 = r11;
        r32.addLowerThan(r70, r13, -r42.getMargin(), r69);
        r217 = r69;
    L240:
        if (r210 == false) goto L247;
        if (r52 == false) goto L247;
        if ((r115 instanceof Barrier) == true) goto L247;
        if ((r65 instanceof Barrier) == true) goto L247;
        int r71 = 6;
        int r72 = 6;
        r214 = true;
    L248:
        if (r214 == false) goto L280;
        if (r213 == 0) goto L253;
        if (r51 == false) goto L252;
        if (r35 == false) goto L253;
    L252:
        ConstraintWidget r73 = r218;
        if (r115 == r73) goto L259;
        if (r65 == r73) goto L259;
        r116 = r71;
    L259:
        if ((r115 instanceof Guideline) == false) goto L261;
    L262:
        r116 = 5;
    L264:
        if ((r115 instanceof Barrier) == false) goto L266;
    L267:
        r116 = 5;
    L268:
        if (r51 == false) goto L270;
        int r74 = 5;
    L271:
        r71 = Math.max(r74, r71);
    L272:
        if (r210 == false) goto L279;
        r71 = Math.min(r72, r71);
        if (r48 == false) goto L279;
        if (r51 == true) goto L279;
        if (r115 == r73) goto L278;
        if (r65 != r73) goto L279;
    L278:
        r71 = 4;
    L279:
        r32.addEquality(r10, r12, r41.getMargin(), r71);
        r32.addEquality(r70, r13, -r42.getMargin(), r71);
        goto L280
    L270:
        r74 = r116;
        goto L271
    L266:
        if ((r65 instanceof Barrier) == false) goto L268;
    L261:
        if ((r65 instanceof Guideline) == false) goto L264;
    L253:
        r73 = r218;
    L280:
        if (r210 == true) goto L282;
    L287:
        if (r210 == false) goto L298;
        if (r24 == false) goto L298;
        r11 = r70;
        if (r45 != 0) goto L297;
        if (r22 != 0) goto L297;
        if (r24 == true) goto L294;
    L296:
        r59 = 0;
        r32.addGreaterThan(r11, r10, 0, 5);
        goto L300
    L294:
        if (r310 != 3) goto L296;
        r59 = 0;
        r32.addGreaterThan(r11, r10, 0, 8);
    L297:
        r59 = 0;
    L298:
        r11 = r70;
        goto L297
    L282:
        if (r37 != r12) goto L284;
        int r75 = r41.getMargin();
    L285:
        if (r12 == r37) goto L287;
        r32.addGreaterThan(r10, r37, r75, 5);
        goto L287
    L284:
        r75 = 0;
    L247:
        r71 = r212;
        r72 = r217;
        goto L248
    L235:
        if ((r65 instanceof Barrier) == true) goto L236;
    L237:
        r69 = r217;
        goto L238
    L239:
        r70 = r11;
        goto L240
    L226:
        if (r42.hasDependents() == true) goto L228;
        return;
    L220:
        r217 = r211;
        r216 = r214;
        r210 = r34;
        r215 = r116;
        goto L221
    L222:
        r310 = r19;
        r218 = r66;
        r217 = r211;
        r210 = r34;
    L212:
        r214 = true;
        goto L213
    L148:
        if ((r65 instanceof Barrier) == false) goto L151;
    L140:
        if (r13.isFinalValue == false) goto L143;
        r32.addEquality(r10, r12, r41.getMargin(), 8);
        r32.addEquality(r11, r13, -r42.getMargin(), 8);
        return;
    L144:
        r68 = r62;
        r67 = 1;
        r117 = 1;
        r211 = 5;
        r212 = 5;
        goto L146
    L154:
        if (r19 != 1) goto L158;
        r38 = r38;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 0;
        r212 = 4;
    L156:
        r211 = 8;
        goto L208
    L158:
        if (r19 == 3) goto L160;
        r67 = 0;
        r117 = 0;
    L192:
        r213 = 0;
    L190:
        r212 = 4;
    L179:
        r211 = 5;
        goto L208
    L160:
        if (this.mResolvedDimensionRatioSide != (-1)) goto L168;
        if (r51 == false) goto L167;
        r38 = r38;
        r67 = 1;
        if (r34 == false) goto L166;
        r116 = 5;
    L165:
        r117 = 1;
        r213 = 1;
        r212 = 5;
        goto L156
    L166:
        r116 = 4;
        goto L165
    L167:
        r38 = r38;
        r67 = 1;
        r116 = 8;
        goto L165
    L168:
        if (r48 == true) goto L170;
        if (r23 <= 0) goto L180;
        r38 = r38;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 1;
        r212 = 5;
        goto L179
    L180:
        if (r23 != 0) goto L189;
        if (r22 != 0) goto L189;
        if (r51 == true) goto L184;
        r38 = r38;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 1;
        r212 = 8;
        goto L179
    L184:
        if (r115 == r66) goto L187;
        if (r65 == r66) goto L187;
        int r76 = 4;
    L188:
        r38 = r38;
        r211 = r76;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 1;
        r212 = 4;
    L187:
        r76 = 5;
    L189:
        r38 = r38;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 1;
        goto L190
    L170:
        if (r54 != 2) goto L172;
    L175:
        int r77 = 5;
        int r78 = 4;
    L176:
        r38 = r38;
        r211 = r77;
        r212 = r78;
        r116 = 6;
        r67 = 1;
        r117 = 1;
        r213 = 1;
        goto L208
    L172:
        if (r54 == 1) goto L175;
        r77 = 8;
        r78 = 5;
        goto L176
    L194:
        if (r12.isFinalValue == true) goto L196;
    L207:
        r67 = 1;
        r117 = 1;
        goto L192
    L196:
        if (r13.isFinalValue == false) goto L207;
        r32.addCentering(r10, r12, r41.getMargin(), r47, r13, r11, r42.getMargin(), 8);
        if (r34 == false) goto L346;
        if (r36 == true) goto L201;
        return;
    L201:
        if (r42.mTarget == null) goto L203;
        int r79 = r42.getMargin();
    L204:
        if (r13 == r38) goto L348;
        r32.addGreaterThan(r38, r11, r79, 5);
        return;
    L348:
        return;
    L203:
        r79 = 0;
        goto L204
    L346:
        return;
    L320:
        r26 = 2;
        goto L321
    L49:
        int r118 = r20;
        r21 = 0;
        r32.addEquality(r11, r10, r111, r118);
        goto L50
    L54:
        if (r5 == 2) goto L64;
        if (r48 == true) goto L64;
        if (r19 == 1) goto L59;
        if (r19 != 0) goto L64;
    L59:
        int r80 = Math.max(r55, r111);
        if (r56 <= 0) goto L62;
        r80 = Math.min(r56, r80);
    L62:
        r32.addEquality(r11, r10, r80, 8);
        r22 = r55;
        r23 = r56;
        r112 = 0;
        r24 = false;
        r12 = r12;
        r11 = r11;
    L64:
        if (r55 != (-2)) goto L66;
        int r119 = r111;
    L67:
        if (r56 != (-2)) goto L69;
        r23 = r111;
    L70:
        if (r111 <= 0) goto L75;
        if (r19 == 1) goto L75;
        r111 = 0;
    L75:
        if (r119 <= 0) goto L78;
        r32.addGreaterThan(r11, r10, r119, 8);
        r111 = Math.max(r111, r119);
    L78:
        if (r23 <= 0) goto L84;
        if (r34 == false) goto L82;
        if (r19 != 1) goto L82;
    L83:
        r111 = Math.min(r111, r23);
    L82:
        r32.addLowerThan(r11, r10, r23, 8);
    L84:
        if (r19 != 1) goto L92;
        if (r34 == false) goto L87;
        r32.addEquality(r11, r10, r111, 8);
    L90:
        r112 = 0;
        r22 = r119;
        goto L51
    L87:
        if (r50 == false) goto L89;
        r32.addEquality(r11, r10, r111, 5);
        r32.addLowerThan(r11, r10, r111, 8);
        goto L90
    L89:
        r32.addEquality(r11, r10, r111, 5);
        r32.addLowerThan(r11, r10, r111, 8);
        goto L90
    L92:
        if (r19 != 2) goto L102;
        ConstraintAnchor.Type r81 = r41.getType();
        ConstraintAnchor.Type r82 = ConstraintAnchor.Type.TOP;
        if (r81 != r82) goto L96;
    L100:
        SolverVariable r83 = r32.createObjectVariable(this.mParent.getAnchor(r82));
        SolverVariable r84 = r32.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
    L99:
        SolverVariable r120 = r83;
        SolverVariable r85 = r84;
        ArrayRow r86 = r32.createRow();
        int r410 = r119;
        r13 = r13;
        r112 = 0;
        r25 = r5 == true ? 1 : 0;
        r12 = r12;
        r11 = r11;
        r32.addConstraint(r86.createRowDimensionRatio(r11, r10, r85, r120, r57));
        r36 = r36;
        r22 = r410;
        r24 = false;
        goto L103
    L96:
        if (r41.getType() == ConstraintAnchor.Type.BOTTOM) goto L100;
        r83 = r32.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
        r84 = r32.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
        goto L99
    L102:
        r112 = 0;
        r12 = r12;
        r11 = r11;
        int r411 = r119;
        r13 = r13;
        r25 = r5;
        r22 = r411;
        r24 = r110;
        r36 = true;
        goto L103
    L69:
        r23 = r56;
        goto L70
    L66:
        r119 = r55;
    L37:
        if (r14 == false) goto L36;
        if (r15 == true) goto L36;
        r20 = 8;
        r32.addEquality(r10, r12, r41.getMargin(), 8);
        goto L41
    L40:
        r20 = 8;
        goto L41
    L30:
        r111 = r44;
        goto L31
    L17:
        if (r17 == 2) goto L22;
        if (r17 == 3) goto L22;
        if (r17 != 4) goto L22;
        r19 = r18;
        if (r19 == 4) goto L23;
        r110 = true;
        goto L28
    L13:
        r18 = r53;
        goto L14
    L8:
        r5 = r14 ? 1 : 0;
        goto L9
    }

    private boolean isChainHead(int r5) {
        int r10 = r5 * 2;
        ConstraintAnchor[] r11 = this.mListAnchors;
        ConstraintAnchor r12 = r11[r10];
        ConstraintAnchor r13 = r12.mTarget;
        if (r13 != null) goto L5;
    L11:
        return false;
    L5:
        if (r13.mTarget == r12) goto L11;
        ConstraintAnchor r14 = r11[r10 + 1];
        ConstraintAnchor r15 = r14.mTarget;
        if (r15 == null) goto L11;
        if (r15.mTarget != r14) goto L11;
        return true;
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

    public boolean addFirst() {
        if ((this instanceof VirtualLayout) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Guideline) == true) goto L8;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r53v0, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    public void addToSolver(LinearSystem r54, boolean r55) {
        SolverVariable r13 = r54.createObjectVariable(this.mLeft);
        SolverVariable r12 = r54.createObjectVariable(this.mRight);
        SolverVariable r11 = r54.createObjectVariable(this.mTop);
        SolverVariable r10 = r54.createObjectVariable(this.mBottom);
        SolverVariable r14 = r54.createObjectVariable(this.mBaseline);
        ConstraintWidget r5 = this.mParent;
        if (r5 == null) goto L15;
        if (r5 != null) goto L6;
    L8:
        boolean r15 = false;
    L9:
        if (r5 != null) goto L11;
    L13:
        boolean r16 = false;
    L14:
        boolean r17 = r16;
        boolean r18 = r15;
    L17:
        if (this.mVisibility == 8) goto L19;
    L25:
        boolean r19 = this.resolvedHorizontal;
        if (r19 == false) goto L28;
    L29:
        if (r19 == false) goto L39;
        r54.addEquality(r13, this.mX);
        r54.addEquality(r12, this.mX + this.mWidth);
        if (r18 == false) goto L39;
        ConstraintWidget r20 = this.mParent;
        if (r20 == null) goto L39;
        if (this.OPTIMIZE_WRAP_ON_RESOLVED == false) goto L37;
        ConstraintWidgetContainer r21 = (ConstraintWidgetContainer) r20;
        r21.addVerticalWrapMinVariable(this.mLeft);
        r21.addHorizontalWrapMaxVariable(this.mRight);
        goto L39
    L37:
        r54.addGreaterThan(r54.createObjectVariable(r20.mRight), r12, 0, 5);
    L39:
        if (this.resolvedVertical == false) goto L51;
        r54.addEquality(r11, this.mY);
        r54.addEquality(r10, this.mY + this.mHeight);
        if (this.mBaseline.hasDependents() == false) goto L43;
        r54.addEquality(r14, this.mY + this.mBaselineDistance);
    L43:
        if (r17 == false) goto L51;
        ConstraintWidget r22 = this.mParent;
        if (r22 == null) goto L51;
        if (this.OPTIMIZE_WRAP_ON_RESOLVED == false) goto L49;
        ConstraintWidgetContainer r23 = (ConstraintWidgetContainer) r22;
        r23.addVerticalWrapMinVariable(this.mTop);
        r23.addVerticalWrapMaxVariable(this.mBottom);
        goto L51
    L49:
        r54.addGreaterThan(r54.createObjectVariable(r22.mBottom), r10, 0, 5);
    L51:
        if (this.resolvedHorizontal == true) goto L53;
    L56:
        Metrics r24 = LinearSystem.sMetrics;
        if (r24 == null) goto L59;
        r24.widgets++;
    L59:
        if (r55 == false) goto L91;
        HorizontalWidgetRun r25 = this.horizontalRun;
        if (r25 == null) goto L91;
        VerticalWidgetRun r26 = this.verticalRun;
        if (r26 == null) goto L91;
        DependencyNode r27 = r25.start;
        if (r27.resolved == false) goto L91;
        if (r25.end.resolved == false) goto L91;
        if (r26.start.resolved == false) goto L91;
        if (r26.end.resolved == false) goto L91;
        if (r24 == null) goto L74;
        r24.graphSolved++;
    L74:
        r54.addEquality(r13, r27.value);
        r54.addEquality(r12, this.horizontalRun.end.value);
        r54.addEquality(r11, this.verticalRun.start.value);
        r54.addEquality(r10, this.verticalRun.end.value);
        r54.addEquality(r14, this.verticalRun.baseline.value);
        if (this.mParent == null) goto L88;
        if (r18 == true) goto L78;
    L82:
        if (r17 == false) goto L88;
        if (this.isTerminalWidget[1] == false) goto L88;
        if (isInVerticalChain() == true) goto L88;
        boolean r28 = false;
        r54.addGreaterThan(r54.createObjectVariable(this.mParent.mBottom), r10, 0, 8);
    L89:
        this.resolvedHorizontal = r28;
        this.resolvedVertical = r28;
        return;
    L78:
        if (this.isTerminalWidget[0] == false) goto L82;
        if (isInHorizontalChain() == true) goto L82;
        r54.addGreaterThan(r54.createObjectVariable(this.mParent.mRight), r12, 0, 8);
    L88:
        r28 = false;
    L91:
        if (r24 == null) goto L94;
        r24.linearSolved++;
    L94:
        if (this.mParent != null) goto L96;
        boolean r29 = false;
        boolean r210 = false;
    L126:
        int r30 = this.mWidth;
        int r31 = this.mMinWidth;
        if (r30 < r31) goto L130;
        r31 = r30;
    L130:
        int r32 = this.mHeight;
        int r33 = this.mMinHeight;
        if (r32 < r33) goto L134;
        r33 = r32;
    L134:
        DimensionBehaviour[] r34 = this.mListDimensionBehaviors;
        DimensionBehaviour r35 = r34[0];
        DimensionBehaviour r36 = DimensionBehaviour.MATCH_CONSTRAINT;
        int r211 = r31;
        if (r35 == r36) goto L138;
        boolean r37 = true;
    L139:
        DimensionBehaviour r38 = r34[1];
        int r212 = r33;
        SolverVariable r213 = r14;
        if (r38 == r36) goto L142;
        boolean r39 = true;
    L143:
        int r40 = this.mDimensionRatioSide;
        this.mResolvedDimensionRatioSide = r40;
        SolverVariable r214 = r10;
        float r110 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = r110;
        SolverVariable r215 = r11;
        int r111 = this.mMatchConstraintDefaultWidth;
        SolverVariable r310 = r12;
        int r112 = this.mMatchConstraintDefaultHeight;
        if (r110 > 0.0f) goto L146;
    L179:
        r111 = r111;
        r112 = r112;
        int r311 = r212;
    L176:
        boolean r113 = false;
    L180:
        int[] r41 = this.mResolvedMatchConstraintDefault;
        r41[0] = r111;
        r41[1] = r112;
        this.mResolvedHasRatio = r113;
        if (r113 == false) goto L186;
        int r42 = this.mResolvedDimensionRatioSide;
        int r43 = -1;
        if (r42 == 0) goto L185;
        if (r42 == (-1)) goto L185;
    L187:
        boolean r216 = false;
    L188:
        if (r113 == false) goto L193;
        int r44 = this.mResolvedDimensionRatioSide;
        if (r44 == 1) goto L192;
        if (r44 != r43) goto L193;
    L192:
        boolean r312 = true;
    L194:
        DimensionBehaviour r45 = this.mListDimensionBehaviors[0];
        DimensionBehaviour r114 = DimensionBehaviour.WRAP_CONTENT;
        if (r45 == r114) goto L197;
    L199:
        boolean r46 = false;
    L200:
        if (r46 == false) goto L202;
        int r217 = 0;
    L203:
        boolean r313 = !this.mCenter.isConnected();
        boolean[] r47 = this.mIsInBarrier;
        boolean r314 = r47[0];
        boolean r315 = r47[1];
        if (this.mHorizontalResolution != 2) goto L206;
    L226:
        SolverVariable r48 = r13;
    L240:
        if (r55 == false) goto L258;
        ?? r115 = this;
        VerticalWidgetRun r49 = r115.verticalRun;
        if (r49 == null) goto L257;
        DependencyNode r50 = r49.start;
        if (r50.resolved == false) goto L257;
        if (r49.end.resolved == false) goto L257;
        r54 = r54;
        r215 = r215;
        r54.addEquality(r215, r50.value);
        r214 = r214;
        r54.addEquality(r214, r115.verticalRun.end.value);
        r213 = r213;
        r54.addEquality(r213, r115.verticalRun.baseline.value);
        ConstraintWidget r51 = r115.mParent;
        if (r51 == null) goto L255;
        if (r29 == true) goto L255;
        if (r17 == false) goto L255;
        int r116 = 1;
        if (r115.isTerminalWidget[1] == false) goto L254;
        int r52 = 8;
        int r117 = 0;
        r54.addGreaterThan(r54.createObjectVariable(r51.mBottom), r214, 0, 8);
    L256:
        int r53 = r117;
        ?? r118 = r115;
    L261:
        if (r118.mVerticalResolution != 2) goto L263;
        int r56 = r117;
    L264:
        if (r56 == 0) goto L305;
        if (r118.resolvedVertical == true) goto L305;
        if (r118.mListDimensionBehaviors[r116] == r114) goto L270;
    L272:
        ?? r57 = r117;
    L273:
        if (r57 == 0) goto L275;
        r311 = r117;
    L275:
        ConstraintWidget r58 = r118.mParent;
        if (r58 == null) goto L278;
        SolverVariable r59 = r54.createObjectVariable(r58.mBottom);
    L279:
        ConstraintWidget r60 = r118.mParent;
        if (r60 == null) goto L282;
        SolverVariable r61 = r54.createObjectVariable(r60.mTop);
    L284:
        if (r118.mBaselineDistance > 0) goto L288;
        if (r118.mVisibility == r52) goto L288;
    L297:
        ?? r218 = r313;
    L298:
        boolean r62 = r118.isTerminalWidget[r116];
        DimensionBehaviour[] r63 = r118.mListDimensionBehaviors;
        DimensionBehaviour r64 = r63[r116];
        ConstraintAnchor r65 = r118.mTop;
        ConstraintAnchor r66 = r118.mBottom;
        int r67 = r118.mY;
        int r68 = r118.mMinHeight;
        int r119 = r118.mMaxDimension[r116];
        float r120 = r118.mVerticalBiasPercent;
        if (r63[0] != r36) goto L301;
        boolean r121 = true;
    L302:
        applyConstraints(r54, false, r17, r18, r62, r61, r59, r64, r57, r65, r66, r67, r311, r68, r119, r120, r312, r121, r29, r210, r315, r112, r111, r118.mMatchConstraintMinHeight, r118.mMatchConstraintMaxHeight, r118.mMatchConstraintPercentHeight, r218);
        goto L305
    L301:
        r121 = false;
    L288:
        if (r118.mBaseline.mTarget == null) goto L294;
        r54.addEquality(r213, r215, getBaselineDistance(), r52);
        r54.addEquality(r213, r54.createObjectVariable(r118.mBaseline.mTarget), r117, r52);
        if (r17 == 0) goto L292;
        r54.addGreaterThan(r59, r54.createObjectVariable(r118.mBottom), r117, 5);
    L292:
        r218 = r117;
        goto L298
    L294:
        if (r118.mVisibility != r52) goto L296;
        r54.addEquality(r213, r215, r117, r52);
        goto L297
    L296:
        r54.addEquality(r213, r215, getBaselineDistance(), r52);
        goto L297
    L282:
        r61 = null;
        goto L284
    L278:
        r59 = null;
        goto L279
    L270:
        if ((r118 instanceof ConstraintWidgetContainer) == false) goto L272;
        r57 = r116;
    L305:
        if (r113 == false) goto L311;
        if (this.mResolvedDimensionRatioSide != 1) goto L309;
        r54.addRatio(r214, r215, r310, r48, this.mResolvedDimensionRatio, 8);
        goto L311
    L309:
        r54.addRatio(r310, r48, r214, r215, this.mResolvedDimensionRatio, 8);
    L311:
        if (this.mCenter.isConnected() == false) goto L313;
        r54.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float) Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
    L313:
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        return;
    L263:
        r56 = r53;
        goto L264
    L254:
        r52 = 8;
        r117 = 0;
    L255:
        r52 = 8;
        r117 = 0;
        r116 = 1;
    L257:
        r52 = 8;
        r117 = 0;
        r116 = 1;
        ?? r122 = r115;
    L259:
        r53 = r116;
        r118 = r122;
        goto L261
    L258:
        r52 = 8;
        r117 = 0;
        r116 = 1;
        r122 = this;
        goto L259
    L206:
        if (this.resolvedHorizontal == true) goto L226;
        if (r55 == false) goto L227;
        HorizontalWidgetRun r69 = this.horizontalRun;
        if (r69 == null) goto L227;
        DependencyNode r70 = r69.start;
        if (r70.resolved == false) goto L227;
        if (r69.end.resolved == false) goto L227;
        if (r55 == false) goto L226;
        r54.addEquality(r13, r70.value);
        r54.addEquality(r310, this.horizontalRun.end.value);
        if (this.mParent == null) goto L224;
        if (r18 == false) goto L224;
        if (this.isTerminalWidget[0] == false) goto L224;
        if (isInHorizontalChain() == true) goto L224;
        r54.addGreaterThan(r54.createObjectVariable(this.mParent.mRight), r310, 0, 8);
    L224:
        r310 = r310;
        r48 = r13;
    L227:
        ConstraintWidget r71 = this.mParent;
        if (r71 == null) goto L230;
        SolverVariable r123 = r54.createObjectVariable(r71.mRight);
    L231:
        ConstraintWidget r72 = this.mParent;
        if (r72 == null) goto L234;
        SolverVariable r316 = r54.createObjectVariable(r72.mLeft);
    L235:
        boolean r317 = this.isTerminalWidget[0];
        DimensionBehaviour[] r73 = this.mListDimensionBehaviors;
        DimensionBehaviour r410 = r73[0];
        ConstraintAnchor r74 = this.mLeft;
        ConstraintAnchor r75 = this.mRight;
        int r76 = this.mX;
        int r77 = this.mMinWidth;
        int r411 = this.mMaxDimension[0];
        float r78 = this.mHorizontalBiasPercent;
        if (r73[1] != r36) goto L238;
        boolean r412 = true;
    L239:
        r310 = r310;
        r48 = r13;
        applyConstraints(r54, true, r18, r17, r317, r316, r123, r410, r46, r74, r75, r76, r217, r77, r411, r78, r216, r412, r210, r29, r314, r111, r112, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, r313);
        goto L240
    L238:
        r412 = false;
        goto L239
    L234:
        r316 = null;
        goto L235
    L230:
        r123 = null;
        goto L231
    L202:
        r217 = r211;
        goto L203
    L197:
        if ((this instanceof ConstraintWidgetContainer) == false) goto L199;
        r46 = true;
    L193:
        r312 = false;
    L185:
        r216 = true;
        goto L188
    L186:
        r43 = -1;
        goto L187
    L146:
        if (this.mVisibility == 8) goto L179;
        if (r35 != r36) goto L151;
        if (r111 != 0) goto L151;
        r111 = 3;
    L151:
        if (r38 != r36) goto L154;
        if (r112 != 0) goto L154;
        r112 = 3;
    L154:
        if (r35 != r36) goto L160;
        if (r38 != r36) goto L160;
        if (r111 != 3) goto L160;
        if (r112 != 3) goto L160;
        setupDimensionRatio(r18, r17, r37, r39);
    L178:
        r211 = r211;
    L166:
        r311 = r212;
    L167:
        r113 = true;
    L160:
        if (r35 != r36) goto L168;
        if (r111 != 3) goto L168;
        this.mResolvedDimensionRatioSide = 0;
        int r79 = (int) (r110 * r32);
        if (r38 == r36) goto L165;
        r111 = 4;
        r112 = r112;
        r311 = r212;
        r113 = false;
        r211 = r79;
        goto L180
    L165:
        r211 = r79;
    L168:
        if (r38 != r36) goto L178;
        if (r112 != 3) goto L178;
        this.mResolvedDimensionRatioSide = 1;
        if (r40 != (-1)) goto L173;
        this.mResolvedDimensionRatio = 1.0f / r110;
    L173:
        int r80 = (int) (this.mResolvedDimensionRatio * r30);
        if (r35 == r36) goto L177;
        r112 = 4;
        r311 = r80;
        r111 = r111;
        goto L176
    L177:
        r311 = r80;
        r111 = r111;
        r112 = r112;
        r211 = r211;
        goto L167
    L142:
        r39 = false;
        goto L143
    L138:
        r37 = false;
        goto L139
    L96:
        if (isChainHead(0) == false) goto L99;
        ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
        boolean r81 = true;
    L101:
        if (isChainHead(1) == false) goto L103;
        ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
        boolean r82 = true;
    L104:
        if (r81 == true) goto L113;
        if (r18 == false) goto L113;
        if (this.mVisibility == 8) goto L113;
        if (this.mLeft.mTarget != null) goto L113;
        if (this.mRight.mTarget != null) goto L113;
        r54.addGreaterThan(r54.createObjectVariable(this.mParent.mRight), r12, 0, 1);
    L113:
        if (r82 == true) goto L124;
        if (r17 == false) goto L124;
        if (this.mVisibility == 8) goto L124;
        if (this.mTop.mTarget != null) goto L124;
        if (this.mBottom.mTarget != null) goto L124;
        if (this.mBaseline != null) goto L124;
        r54.addGreaterThan(r54.createObjectVariable(this.mParent.mBottom), r10, 0, 1);
    L124:
        r210 = r81;
        r29 = r82;
        goto L126
    L103:
        r82 = isInVerticalChain();
        goto L104
    L99:
        r81 = isInHorizontalChain();
        goto L101
    L53:
        if (this.resolvedVertical == false) goto L56;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        return;
    L28:
        if (this.resolvedVertical == false) goto L56;
    L19:
        if (hasDependencies() == true) goto L25;
        boolean[] r83 = this.mIsInBarrier;
        if (r83[0] == true) goto L25;
        if (r83[1] == true) goto L25;
        return;
    L11:
        if (r5.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT) goto L13;
        r16 = true;
        goto L14
    L6:
        if (r5.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) goto L8;
        r15 = true;
        goto L9
    L15:
        r18 = false;
        r17 = false;
        goto L17
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility == 8) goto L5;
        return true;
    L5:
        return false;
    }

    public void connect(ConstraintAnchor r5, ConstraintAnchor r10, int r11) {
        if (r5.getOwner() != this) goto L6;
        connect(r5.getType(), r10.getOwner(), r10.getType(), r11);
        return;
    }

    public void connectCircularConstraint(ConstraintWidget r10, float r11, int r12) {
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.CENTER;
        immediateConnect(r5, r10, r5, r12, 0);
        this.mCircleConstraintAngle = r11;
    }

    public void copy(ConstraintWidget r10, HashMap<ConstraintWidget, ConstraintWidget> r11) {
        this.mHorizontalResolution = r10.mHorizontalResolution;
        this.mVerticalResolution = r10.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = r10.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = r10.mMatchConstraintDefaultHeight;
        int[] r5 = this.mResolvedMatchConstraintDefault;
        int[] r12 = r10.mResolvedMatchConstraintDefault;
        r5[0] = r12[0];
        r5[1] = r12[1];
        this.mMatchConstraintMinWidth = r10.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = r10.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = r10.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = r10.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = r10.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = r10.mIsWidthWrapContent;
        this.mIsHeightWrapContent = r10.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = r10.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = r10.mResolvedDimensionRatio;
        int[] r13 = r10.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(r13, r13.length);
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
        ConstraintWidget r14 = null;
        if (this.mParent != null) goto L5;
        ConstraintWidget r15 = null;
    L6:
        this.mParent = r15;
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
        float[] r16 = this.mWeight;
        float[] r17 = r10.mWeight;
        r16[0] = r17[0];
        r16[1] = r17[1];
        ConstraintWidget[] r18 = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] r19 = r10.mListNextMatchConstraintsWidget;
        r18[0] = r19[0];
        r18[1] = r19[1];
        ConstraintWidget[] r20 = this.mNextChainWidget;
        ConstraintWidget[] r21 = r10.mNextChainWidget;
        r20[0] = r21[0];
        r20[1] = r21[1];
        ConstraintWidget r22 = r10.mHorizontalNextWidget;
        if (r22 != null) goto L9;
        ConstraintWidget r23 = null;
    L10:
        this.mHorizontalNextWidget = r23;
        ConstraintWidget r24 = r10.mVerticalNextWidget;
        if (r24 == null) goto L14;
        r14 = r11.get(r24);
    L14:
        this.mVerticalNextWidget = r14;
        return;
    L9:
        r23 = r11.get(r22);
        goto L10
    L5:
        r15 = r11.get(r10.mParent);
        goto L6
    }

    public void createObjectVariables(LinearSystem r5) {
        r5.createObjectVariable(this.mLeft);
        r5.createObjectVariable(this.mTop);
        r5.createObjectVariable(this.mRight);
        r5.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance <= 0) goto L6;
        r5.createObjectVariable(this.mBaseline);
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

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type r5) {
        switch(AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r5.ordinal()]) {
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
        throw new AssertionError(r5.name());
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

    public float getBiasPercent(int r5) {
        if (r5 != 0) goto L6;
        return this.mHorizontalBiasPercent;
    L6:
        if (r5 == 1) goto L8;
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

    public DimensionBehaviour getDimensionBehaviour(int r5) {
        if (r5 != 0) goto L6;
        return getHorizontalDimensionBehaviour();
    L6:
        if (r5 == 1) goto L8;
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
        ConstraintWidget r5 = this;
        ConstraintWidget r10 = null;
    L5:
        if (r10 != null) goto L26;
        if (r5 == null) goto L26;
        ConstraintAnchor r11 = r5.getAnchor(ConstraintAnchor.Type.LEFT);
        if (r11 != null) goto L10;
        ConstraintAnchor r12 = null;
    L11:
        if (r12 != null) goto L13;
        ConstraintWidget r13 = null;
    L15:
        if (r13 == getParent()) goto L37;
        if (r13 != null) goto L19;
        ConstraintAnchor r14 = null;
    L20:
        if (r14 == null) goto L24;
        if (r14.getOwner() == r5) goto L24;
        r10 = r5;
    L24:
        r5 = r13;
        goto L5
    L19:
        r14 = r13.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
        goto L20
    L37:
        return r5;
    L13:
        r13 = r12.getOwner();
        goto L15
    L10:
        r12 = r11.getTarget();
    L26:
        return r10;
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
        ConstraintAnchor r5 = this.mLeft;
        if (r5 == null) goto L5;
        int r10 = r5.mMargin;
    L6:
        ConstraintAnchor r11 = this.mRight;
        if (r11 != null) goto L9;
        return r10;
    L9:
        return r10 + r11.mMargin;
    L5:
        r10 = 0;
        goto L6
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

    public int getLength(int r5) {
        if (r5 != 0) goto L6;
        return getWidth();
    L6:
        if (r5 == 1) goto L8;
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

    public ConstraintWidget getNextChainMember(int r5) {
        if (r5 != 0) goto L10;
        ConstraintAnchor r10 = this.mRight;
        ConstraintAnchor r11 = r10.mTarget;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.mTarget == r10) goto L8;
        return null;
    L8:
        return r11.mOwner;
    L10:
        if (r5 != 1) goto L20;
        ConstraintAnchor r12 = this.mBottom;
        ConstraintAnchor r13 = r12.mTarget;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.mTarget == r12) goto L16;
        return null;
    L16:
        return r13.mOwner;
    L20:
        return null;
    }

    public int getOptimizerWrapHeight() {
        int r5 = this.mHeight;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r5;
    L5:
        if (this.mMatchConstraintDefaultHeight != 1) goto L7;
        int r10 = Math.max(this.mMatchConstraintMinHeight, r5);
    L11:
        int r11 = this.mMatchConstraintMaxHeight;
        if (r11 <= 0) goto L17;
        if (r11 < r10) goto L15;
        return r10;
    L15:
        return r11;
    L17:
        return r10;
    L7:
        r10 = this.mMatchConstraintMinHeight;
        if (r10 <= 0) goto L10;
        this.mHeight = r10;
        goto L11
    L10:
        r10 = 0;
        goto L11
    }

    public int getOptimizerWrapWidth() {
        int r5 = this.mWidth;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return r5;
    L5:
        if (this.mMatchConstraintDefaultWidth != 1) goto L7;
        int r10 = Math.max(this.mMatchConstraintMinWidth, r5);
    L11:
        int r11 = this.mMatchConstraintMaxWidth;
        if (r11 <= 0) goto L17;
        if (r11 < r10) goto L15;
        return r10;
    L15:
        return r11;
    L17:
        return r10;
    L7:
        r10 = this.mMatchConstraintMinWidth;
        if (r10 <= 0) goto L10;
        this.mWidth = r10;
        goto L11
    L10:
        r10 = 0;
        goto L11
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int r5) {
        if (r5 != 0) goto L10;
        ConstraintAnchor r10 = this.mLeft;
        ConstraintAnchor r11 = r10.mTarget;
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.mTarget == r10) goto L8;
        return null;
    L8:
        return r11.mOwner;
    L10:
        if (r5 != 1) goto L20;
        ConstraintAnchor r12 = this.mTop;
        ConstraintAnchor r13 = r12.mTarget;
        if (r13 != null) goto L14;
        return null;
    L14:
        if (r13.mTarget == r12) goto L16;
        return null;
    L16:
        return r13.mOwner;
    L20:
        return null;
    }

    public int getRelativePositioning(int r5) {
        if (r5 != 0) goto L6;
        return this.mRelX;
    L6:
        if (r5 == 1) goto L8;
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

    public WidgetRun getRun(int r5) {
        if (r5 != 0) goto L6;
        return this.horizontalRun;
    L6:
        if (r5 == 1) goto L8;
        return null;
    L8:
        return this.verticalRun;
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
        ConstraintWidget r5 = this;
        ConstraintWidget r10 = null;
    L5:
        if (r10 != null) goto L26;
        if (r5 == null) goto L26;
        ConstraintAnchor r11 = r5.getAnchor(ConstraintAnchor.Type.TOP);
        if (r11 != null) goto L10;
        ConstraintAnchor r12 = null;
    L11:
        if (r12 != null) goto L13;
        ConstraintWidget r13 = null;
    L15:
        if (r13 == getParent()) goto L37;
        if (r13 != null) goto L19;
        ConstraintAnchor r14 = null;
    L20:
        if (r14 == null) goto L24;
        if (r14.getOwner() == r5) goto L24;
        r10 = r5;
    L24:
        r5 = r13;
        goto L5
    L19:
        r14 = r13.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
        goto L20
    L37:
        return r5;
    L13:
        r13 = r12.getOwner();
        goto L15
    L10:
        r12 = r11.getTarget();
    L26:
        return r10;
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
        if (this.mLeft == null) goto L5;
        int r5 = this.mTop.mMargin;
    L7:
        if (this.mRight != null) goto L9;
        return r5;
    L9:
        return r5 + this.mBottom.mMargin;
    L5:
        r5 = 0;
        goto L7
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

    public int getX() {
        ConstraintWidget r5 = this.mParent;
        if (r5 == null) goto L9;
        if ((r5 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r5).mPaddingLeft + this.mX;
    L9:
        return this.mX;
    }

    public int getY() {
        ConstraintWidget r5 = this.mParent;
        if (r5 == null) goto L9;
        if ((r5 instanceof ConstraintWidgetContainer) == false) goto L9;
        return ((ConstraintWidgetContainer) r5).mPaddingTop + this.mY;
    L9:
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int r5) {
        if (r5 != 0) goto L17;
        if (this.mLeft.mTarget == null) goto L7;
        int r10 = 1;
    L9:
        if (this.mRight.mTarget == null) goto L11;
        int r11 = 1;
    L13:
        if ((r10 + r11) < 2) goto L15;
        return false;
    L15:
        return true;
    L11:
        r11 = 0;
        goto L13
    L7:
        r10 = 0;
        goto L9
    L17:
        if (this.mTop.mTarget == null) goto L19;
        int r12 = 1;
    L21:
        if (this.mBottom.mTarget == null) goto L23;
        int r13 = 1;
    L24:
        int r14 = r12 + r13;
        if (this.mBaseline.mTarget == null) goto L27;
        int r15 = 1;
    L29:
        if ((r14 + r15) < 2) goto L31;
        return false;
    L31:
        return true;
    L27:
        r15 = 0;
        goto L29
    L23:
        r13 = 0;
        goto L24
    L19:
        r12 = 0;
        goto L21
    }

    public boolean hasDependencies() {
        int r5 = this.mAnchors.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L9;
        if (this.mAnchors.get(r10).hasDependents() == true) goto L6;
        r10 = r10 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type r5, ConstraintWidget r10, ConstraintAnchor.Type r11, int r12, int r13) {
        getAnchor(r5).connect(r10.getAnchor(r11), r12, r13, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor r5 = this.mLeft;
        ConstraintAnchor r10 = r5.mTarget;
        if (r10 != null) goto L5;
    L6:
        ConstraintAnchor r11 = this.mRight;
        ConstraintAnchor r12 = r11.mTarget;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.mTarget != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.mTarget != r5) goto L6;
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor r5 = this.mTop;
        ConstraintAnchor r10 = r5.mTarget;
        if (r10 != null) goto L5;
    L6:
        ConstraintAnchor r11 = this.mBottom;
        ConstraintAnchor r12 = r11.mTarget;
        if (r12 != null) goto L9;
        return false;
    L9:
        if (r12.mTarget != r11) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r10.mTarget != r5) goto L6;
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
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

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int r5) {
        if (r5 != 0) goto L5;
        char r10 = 1;
    L6:
        DimensionBehaviour[] r11 = this.mListDimensionBehaviors;
        DimensionBehaviour r12 = r11[r5];
        DimensionBehaviour r13 = r11[r10];
        DimensionBehaviour r14 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r12 != r14) goto L11;
        if (r13 == r14) goto L10;
        return false;
    L10:
        return true;
    L11:
        return false;
    L5:
        r10 = 0;
        goto L6
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] r5 = this.mListDimensionBehaviors;
        DimensionBehaviour r10 = r5[0];
        DimensionBehaviour r11 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (r10 == r11) goto L5;
        return false;
    L5:
        if (r5[1] == r11) goto L7;
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
        float r5 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r5;
        this.mVerticalBiasPercent = r5;
        DimensionBehaviour[] r10 = this.mListDimensionBehaviors;
        DimensionBehaviour r11 = DimensionBehaviour.FIXED;
        r10[0] = r11;
        r10[1] = r11;
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
        float[] r12 = this.mWeight;
        r12[0] = -1.0f;
        r12[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] r13 = this.mMaxDimension;
        r13[0] = Integer.MAX_VALUE;
        r13[1] = Integer.MAX_VALUE;
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
        boolean[] r14 = this.isTerminalWidget;
        r14[0] = true;
        r14[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] r15 = this.mIsInBarrier;
        r15[0] = false;
        r15[1] = false;
        this.mMeasureRequested = true;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor r10) {
        if (getParent() != null) goto L5;
    L9:
        ConstraintAnchor r5 = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r11 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor r12 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r13 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor r14 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor r15 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor r16 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (r10 == r14) goto L12;
        if (r10 == r15) goto L28;
        if (r10 == r16) goto L37;
        if (r10 == r5) goto L55;
        if (r10 == r11) goto L55;
        if (r10 == r12) goto L50;
        if (r10 == r13) goto L50;
    L59:
        r10.reset();
        return;
    L50:
        if (r12.isConnected() == false) goto L59;
        if (r12.getTarget() != r13.getTarget()) goto L59;
        r14.reset();
    L55:
        if (r5.isConnected() == false) goto L59;
        if (r5.getTarget() != r11.getTarget()) goto L59;
        r14.reset();
        goto L59
    L37:
        if (r12.isConnected() == true) goto L39;
    L43:
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L39:
        if (r13.isConnected() == false) goto L43;
        if (r12.getTarget().getOwner() != r13.getTarget().getOwner()) goto L43;
        r12.reset();
        r13.reset();
        goto L43
    L28:
        if (r5.isConnected() == true) goto L30;
    L34:
        this.mHorizontalBiasPercent = 0.5f;
        goto L59
    L30:
        if (r11.isConnected() == false) goto L34;
        if (r5.getTarget().getOwner() != r11.getTarget().getOwner()) goto L34;
        r5.reset();
        r11.reset();
        goto L34
    L12:
        if (r5.isConnected() == false) goto L19;
        if (r11.isConnected() == false) goto L19;
        if (r5.getTarget() != r11.getTarget()) goto L19;
        r5.reset();
        r11.reset();
    L19:
        if (r12.isConnected() == true) goto L21;
    L25:
        this.mHorizontalBiasPercent = 0.5f;
        this.mVerticalBiasPercent = 0.5f;
        goto L59
    L21:
        if (r13.isConnected() == false) goto L25;
        if (r12.getTarget() != r13.getTarget()) goto L25;
        r12.reset();
        r13.reset();
        goto L25
    L5:
        if ((getParent() instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetAnchors() {
        ConstraintWidget r5 = getParent();
        if (r5 != null) goto L5;
    L9:
        int r10 = this.mAnchors.size();
        int r11 = 0;
    L10:
        if (r11 >= r10) goto L12;
        this.mAnchors.get(r11).reset();
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L5:
        if ((r5 instanceof ConstraintWidgetContainer) == false) goto L9;
        if (((ConstraintWidgetContainer) getParent()).handlesInternalConstraints() == false) goto L9;
    }

    public void resetFinalResolution() {
        int r5 = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int r10 = this.mAnchors.size();
    L3:
        if (r5 >= r10) goto L5;
        this.mAnchors.get(r5).resetFinalResolution();
        r5 = r5 + 1;
        goto L3
    }

    public void resetSolverVariables(Cache r5) {
        this.mLeft.resetSolverVariable(r5);
        this.mTop.resetSolverVariable(r5);
        this.mRight.resetSolverVariable(r5);
        this.mBottom.resetSolverVariable(r5);
        this.mBaseline.resetSolverVariable(r5);
        this.mCenter.resetSolverVariable(r5);
        this.mCenterX.resetSolverVariable(r5);
        this.mCenterY.resetSolverVariable(r5);
    }

    public void setBaselineDistance(int r5) {
        this.mBaselineDistance = r5;
        if (r5 <= 0) goto L5;
        boolean r10 = true;
    L6:
        this.hasBaseline = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public void setCompanionWidget(Object r5) {
        this.mCompanionWidget = r5;
    }

    public void setContainerItemSkip(int r5) {
        if (r5 < 0) goto L4;
        this.mContainerItemSkip = r5;
        return;
    L4:
        this.mContainerItemSkip = 0;
    }

    public void setDebugName(String r5) {
        this.mDebugName = r5;
    }

    public void setDebugSolverName(LinearSystem r10, String r11) {
        this.mDebugName = r11;
        SolverVariable r5 = r10.createObjectVariable(this.mLeft);
        SolverVariable r12 = r10.createObjectVariable(this.mTop);
        SolverVariable r13 = r10.createObjectVariable(this.mRight);
        SolverVariable r14 = r10.createObjectVariable(this.mBottom);
        r5.setName(r11 + ".left");
        r12.setName(r11 + ".top");
        r13.setName(r11 + ".right");
        r14.setName(r11 + ".bottom");
        r10.createObjectVariable(this.mBaseline).setName(r11 + ".baseline");
    }

    public void setDimension(int r5, int r10) {
        this.mWidth = r5;
        int r11 = this.mMinWidth;
        if (r5 >= r11) goto L5;
        this.mWidth = r11;
    L5:
        this.mHeight = r10;
        int r12 = this.mMinHeight;
        if (r10 >= r12) goto L9;
        this.mHeight = r12;
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0086 -> B:40:0x0087). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String r10) {
        int r5 = 0;
        if (r10 != null) goto L5;
    L44:
        this.mDimensionRatio = 0.0f;
        return;
    L5:
        if (r10.length() == 0) goto L44;
        int r11 = r10.length();
        int r12 = r10.indexOf(44);
        int r13 = 0;
        int r14 = -1;
        if (r12 > 0) goto L10;
    L19:
        int r15 = r10.indexOf(58);
        if (r15 >= 0) goto L22;
    L35:
        String r16 = r10.substring(r13);
        if (r16.length() <= 0) goto L39;
        float r17 = Float.parseFloat(r16);     // Catch: NumberFormatException -> L46
    L40:
        r5 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1));
        if (r5 <= 0) goto L49;
        this.mDimensionRatio = r17;
        this.mDimensionRatioSide = r14;
        return;
    L49:
        return;
    L22:
        if (r15 >= (r11 - 1)) goto L35;
        String r18 = r10.substring(r13, r15);
        String r19 = r10.substring(r15 + 1);
        if (r18.length() <= 0) goto L39;
        if (r19.length() <= 0) goto L39;
        float r20 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L46
        float r21 = Float.parseFloat(r19);     // Catch: NumberFormatException -> L46
        if (r20 <= 0.0f) goto L39;
        if (r21 <= 0.0f) goto L39;
        if (r14 != 1) goto L33;
        r17 = Math.abs(r21 / r20);     // Catch: NumberFormatException -> L46
        goto L40
    L33:
        r17 = Math.abs(r20 / r21);     // Catch: NumberFormatException -> L46
    L39:
        r17 = r5;
        goto L40
    L10:
        if (r12 >= (r11 - 1)) goto L19;
        String r22 = r10.substring(0, r12);
        if (r22.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L15;
    L18:
        r14 = r13;
        r13 = r12 + 1;
        goto L19
    L15:
        if (r22.equalsIgnoreCase("H") == false) goto L17;
        r13 = 1;
        goto L18
    L17:
        r13 = -1;
        goto L18
    }

    public void setFinalBaseline(int r5) {
        if (this.hasBaseline == true) goto L5;
        return;
    L5:
        int r10 = r5 - this.mBaselineDistance;
        int r11 = this.mHeight + r10;
        this.mY = r10;
        this.mTop.setFinalValue(r10);
        this.mBottom.setFinalValue(r11);
        this.mBaseline.setFinalValue(r5);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int r5, int r10, int r11, int r12, int r13, int r14) {
        setFrame(r5, r10, r11, r12);
        setBaselineDistance(r13);
        if (r14 != 0) goto L5;
        this.resolvedHorizontal = true;
        this.resolvedVertical = false;
        return;
    L5:
        if (r14 != 1) goto L8;
        this.resolvedHorizontal = false;
        this.resolvedVertical = true;
        return;
    L8:
        if (r14 != 2) goto L10;
        this.resolvedHorizontal = true;
        this.resolvedVertical = true;
        return;
    L10:
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
    }

    public void setFinalHorizontal(int r5, int r10) {
        this.mLeft.setFinalValue(r5);
        this.mRight.setFinalValue(r10);
        this.mX = r5;
        this.mWidth = r10 - r5;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int r5) {
        this.mLeft.setFinalValue(r5);
        this.mX = r5;
    }

    public void setFinalTop(int r5) {
        this.mTop.setFinalValue(r5);
        this.mY = r5;
    }

    public void setFinalVertical(int r5, int r10) {
        this.mTop.setFinalValue(r5);
        this.mBottom.setFinalValue(r10);
        this.mY = r5;
        this.mHeight = r10 - r5;
        if (this.hasBaseline == false) goto L5;
        this.mBaseline.setFinalValue(r5 + this.mBaselineDistance);
    L5:
        this.resolvedVertical = true;
    }

    public void setFrame(int r5, int r10, int r11, int r12) {
        int r13 = r11 - r5;
        int r14 = r12 - r10;
        this.mX = r5;
        this.mY = r10;
        if (this.mVisibility != 8) goto L6;
        this.mWidth = 0;
        this.mHeight = 0;
        return;
    L6:
        DimensionBehaviour[] r15 = this.mListDimensionBehaviors;
        DimensionBehaviour r16 = r15[0];
        DimensionBehaviour r17 = DimensionBehaviour.FIXED;
        if (r16 != r17) goto L12;
        int r18 = this.mWidth;
        if (r13 >= r18) goto L12;
        r13 = r18;
    L12:
        if (r15[1] != r17) goto L16;
        int r19 = this.mHeight;
        if (r14 >= r19) goto L16;
        r14 = r19;
    L16:
        this.mWidth = r13;
        this.mHeight = r14;
        int r20 = this.mMinHeight;
        if (r14 >= r20) goto L19;
        this.mHeight = r20;
    L19:
        int r21 = this.mMinWidth;
        if (r13 >= r21) goto L23;
        this.mWidth = r21;
        return;
    }

    public void setGoneMargin(ConstraintAnchor.Type r5, int r10) {
        int r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[r5.ordinal()];
        if (r11 != 1) goto L5;
        this.mLeft.mGoneMargin = r10;
        return;
    L5:
        if (r11 != 2) goto L7;
        this.mTop.mGoneMargin = r10;
        return;
    L7:
        if (r11 != 3) goto L9;
        this.mRight.mGoneMargin = r10;
        return;
    L9:
        if (r11 != 4) goto L19;
        this.mBottom.mGoneMargin = r10;
        return;
    }

    public void setHasBaseline(boolean r5) {
        this.hasBaseline = r5;
    }

    public void setHeight(int r5) {
        this.mHeight = r5;
        int r10 = this.mMinHeight;
        if (r5 >= r10) goto L6;
        this.mHeight = r10;
        return;
    }

    public void setHeightWrapContent(boolean r5) {
        this.mIsHeightWrapContent = r5;
    }

    public void setHorizontalBiasPercent(float r5) {
        this.mHorizontalBiasPercent = r5;
    }

    public void setHorizontalChainStyle(int r5) {
        this.mHorizontalChainStyle = r5;
    }

    public void setHorizontalDimension(int r5, int r10) {
        this.mX = r5;
        int r11 = r10 - r5;
        this.mWidth = r11;
        int r12 = this.mMinWidth;
        if (r11 >= r12) goto L6;
        this.mWidth = r12;
        return;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour r5) {
        this.mListDimensionBehaviors[0] = r5;
    }

    public void setHorizontalMatchStyle(int r5, int r10, int r11, float r12) {
        this.mMatchConstraintDefaultWidth = r5;
        this.mMatchConstraintMinWidth = r10;
        if (r11 != Integer.MAX_VALUE) goto L5;
        r11 = 0;
    L5:
        this.mMatchConstraintMaxWidth = r11;
        this.mMatchConstraintPercentWidth = r12;
        if (r12 > 0.0f) goto L8;
        return;
    L8:
        if (r12 >= 1.0f) goto L13;
        if (r5 != 0) goto L14;
        this.mMatchConstraintDefaultWidth = 2;
        return;
    L14:
        return;
    }

    public void setHorizontalWeight(float r5) {
        this.mWeight[0] = r5;
    }

    public void setInBarrier(int r5, boolean r10) {
        this.mIsInBarrier[r5] = r10;
    }

    public void setInPlaceholder(boolean r5) {
        this.inPlaceholder = r5;
    }

    public void setInVirtualLayout(boolean r5) {
        this.mInVirtuaLayout = r5;
    }

    public void setLastMeasureSpec(int r5, int r10) {
        this.mLastHorizontalMeasureSpec = r5;
        this.mLastVerticalMeasureSpec = r10;
        setMeasureRequested(false);
    }

    public void setLength(int r5, int r10) {
        if (r10 != 0) goto L5;
        setWidth(r5);
        return;
    L5:
        if (r10 != 1) goto L9;
        setHeight(r5);
        return;
    }

    public void setMaxHeight(int r5) {
        this.mMaxDimension[1] = r5;
    }

    public void setMaxWidth(int r5) {
        this.mMaxDimension[0] = r5;
    }

    public void setMeasureRequested(boolean r5) {
        this.mMeasureRequested = r5;
    }

    public void setMinHeight(int r5) {
        if (r5 >= 0) goto L4;
        this.mMinHeight = 0;
        return;
    L4:
        this.mMinHeight = r5;
    }

    public void setMinWidth(int r5) {
        if (r5 >= 0) goto L4;
        this.mMinWidth = 0;
        return;
    L4:
        this.mMinWidth = r5;
    }

    public void setOffset(int r5, int r10) {
        this.mOffsetX = r5;
        this.mOffsetY = r10;
    }

    public void setOrigin(int r5, int r10) {
        this.mX = r5;
        this.mY = r10;
    }

    public void setParent(ConstraintWidget r5) {
        this.mParent = r5;
    }

    public void setRelativePositioning(int r5, int r10) {
        if (r10 != 0) goto L5;
        this.mRelX = r5;
        return;
    L5:
        if (r10 != 1) goto L9;
        this.mRelY = r5;
        return;
    }

    public void setType(String r5) {
        this.mType = r5;
    }

    public void setVerticalBiasPercent(float r5) {
        this.mVerticalBiasPercent = r5;
    }

    public void setVerticalChainStyle(int r5) {
        this.mVerticalChainStyle = r5;
    }

    public void setVerticalDimension(int r5, int r10) {
        this.mY = r5;
        int r11 = r10 - r5;
        this.mHeight = r11;
        int r12 = this.mMinHeight;
        if (r11 >= r12) goto L6;
        this.mHeight = r12;
        return;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour r5) {
        this.mListDimensionBehaviors[1] = r5;
    }

    public void setVerticalMatchStyle(int r5, int r10, int r11, float r12) {
        this.mMatchConstraintDefaultHeight = r5;
        this.mMatchConstraintMinHeight = r10;
        if (r11 != Integer.MAX_VALUE) goto L5;
        r11 = 0;
    L5:
        this.mMatchConstraintMaxHeight = r11;
        this.mMatchConstraintPercentHeight = r12;
        if (r12 > 0.0f) goto L8;
        return;
    L8:
        if (r12 >= 1.0f) goto L13;
        if (r5 != 0) goto L14;
        this.mMatchConstraintDefaultHeight = 2;
        return;
    L14:
        return;
    }

    public void setVerticalWeight(float r5) {
        this.mWeight[1] = r5;
    }

    public void setVisibility(int r5) {
        this.mVisibility = r5;
    }

    public void setWidth(int r5) {
        this.mWidth = r5;
        int r10 = this.mMinWidth;
        if (r5 >= r10) goto L6;
        this.mWidth = r10;
        return;
    }

    public void setWidthWrapContent(boolean r5) {
        this.mIsWidthWrapContent = r5;
    }

    public void setX(int r5) {
        this.mX = r5;
    }

    public void setY(int r5) {
        this.mY = r5;
    }

    public void setupDimensionRatio(boolean r5, boolean r10, boolean r11, boolean r12) {
        if (this.mResolvedDimensionRatioSide != (-1)) goto L13;
        if (r11 == false) goto L7;
        if (r12 == true) goto L7;
        this.mResolvedDimensionRatioSide = 0;
    L7:
        if (r11 == true) goto L13;
        if (r12 == false) goto L13;
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
        int r13 = this.mMatchConstraintMinWidth;
        if (r13 > 0) goto L51;
    L53:
        if (r13 == 0) goto L55;
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
        StringBuilder r5 = new StringBuilder();
        String r10 = "";
        if (this.mType == null) goto L5;
        String r11 = j0.q(new StringBuilder("type: "), this.mType, " ");
    L6:
        r5.append(r11);
        if (this.mDebugName == null) goto L9;
        r10 = j0.q(new StringBuilder("id: "), this.mDebugName, " ");
    L9:
        r5.append(r10);
        r5.append("(");
        r5.append(this.mX);
        r5.append(", ");
        r5.append(this.mY);
        r5.append(") - (");
        r5.append(this.mWidth);
        r5.append(" x ");
        return a.s(r5, this.mHeight, ")");
    L5:
        r11 = "";
        goto L6
    }

    public void updateFromRuns(boolean r10, boolean r11) {
        boolean r12 = r10 & this.horizontalRun.isResolved();
        boolean r13 = r11 & this.verticalRun.isResolved();
        HorizontalWidgetRun r5 = this.horizontalRun;
        int r14 = r5.start.value;
        VerticalWidgetRun r15 = this.verticalRun;
        int r16 = r15.start.value;
        int r17 = r5.end.value;
        int r18 = r15.end.value;
        int r19 = r18 - r16;
        if ((r17 - r14) < 0) goto L15;
        if (r19 < 0) goto L15;
        if (r14 == Integer.MIN_VALUE) goto L15;
        if (r14 == Integer.MAX_VALUE) goto L15;
        if (r16 == Integer.MIN_VALUE) goto L15;
        if (r16 == Integer.MAX_VALUE) goto L15;
        if (r17 == Integer.MIN_VALUE) goto L15;
        if (r17 == Integer.MAX_VALUE) goto L15;
        if (r18 == Integer.MIN_VALUE) goto L15;
        if (r18 == Integer.MAX_VALUE) goto L15;
    L16:
        int r20 = r17 - r14;
        int r21 = r18 - r16;
        if (r12 == false) goto L19;
        this.mX = r14;
    L19:
        if (r13 == false) goto L22;
        this.mY = r16;
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
        int r22 = this.mHeight;
        if (r21 >= r22) goto L40;
        r21 = r22;
    L40:
        this.mHeight = r21;
        int r23 = this.mMinHeight;
        if (r21 >= r23) goto L45;
        this.mHeight = r23;
        return;
    L45:
        return;
    L27:
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED) goto L31;
        int r24 = this.mWidth;
        if (r20 >= r24) goto L31;
        r20 = r24;
    L31:
        this.mWidth = r20;
        int r25 = this.mMinWidth;
        if (r20 >= r25) goto L34;
        this.mWidth = r25;
    L15:
        r17 = 0;
        r14 = 0;
        r18 = 0;
        r16 = 0;
        goto L16
    }

    public void updateFromSolver(LinearSystem r10, boolean r11) {
        int r5 = r10.getObjectVariableValue(this.mLeft);
        int r12 = r10.getObjectVariableValue(this.mTop);
        int r13 = r10.getObjectVariableValue(this.mRight);
        int r14 = r10.getObjectVariableValue(this.mBottom);
        if (r11 == false) goto L11;
        HorizontalWidgetRun r15 = this.horizontalRun;
        if (r15 == null) goto L11;
        DependencyNode r16 = r15.start;
        if (r16.resolved == false) goto L11;
        DependencyNode r17 = r15.end;
        if (r17.resolved == false) goto L11;
        r5 = r16.value;
        r13 = r17.value;
    L11:
        if (r11 == false) goto L19;
        VerticalWidgetRun r18 = this.verticalRun;
        if (r18 == null) goto L19;
        DependencyNode r19 = r18.start;
        if (r19.resolved == false) goto L19;
        DependencyNode r20 = r18.end;
        if (r20.resolved == false) goto L19;
        r12 = r19.value;
        r14 = r20.value;
    L19:
        int r21 = r14 - r12;
        if ((r13 - r5) < 0) goto L32;
        if (r21 < 0) goto L32;
        if (r5 == Integer.MIN_VALUE) goto L32;
        if (r5 == Integer.MAX_VALUE) goto L32;
        if (r12 == Integer.MIN_VALUE) goto L32;
        if (r12 == Integer.MAX_VALUE) goto L32;
        if (r13 == Integer.MIN_VALUE) goto L32;
        if (r13 == Integer.MAX_VALUE) goto L32;
        if (r14 == Integer.MIN_VALUE) goto L32;
        if (r14 == Integer.MAX_VALUE) goto L32;
    L33:
        setFrame(r5, r12, r13, r14);
        return;
    L32:
        r5 = 0;
        r14 = 0;
        r12 = 0;
        r13 = 0;
        goto L33
    }

    public void connect(ConstraintAnchor.Type r5, ConstraintWidget r10, ConstraintAnchor.Type r11) {
        connect(r5, r10, r11, 0);
    }

    public void connect(ConstraintAnchor.Type r10, ConstraintWidget r11, ConstraintAnchor.Type r12, int r13) {
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.CENTER;
        if (r10 != r5) goto L40;
        if (r12 != r5) goto L29;
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor r15 = getAnchor(r14);
        ConstraintAnchor.Type r16 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor r17 = getAnchor(r16);
        ConstraintAnchor.Type r18 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor r19 = getAnchor(r18);
        ConstraintAnchor.Type r20 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor r21 = getAnchor(r20);
        boolean r22 = true;
        if (r15 != null) goto L8;
    L9:
        if (r17 != null) goto L11;
    L13:
        connect(r14, r11, r14, 0);
        connect(r16, r11, r16, 0);
        boolean r23 = true;
    L14:
        if (r19 != null) goto L16;
    L17:
        if (r21 != null) goto L19;
    L21:
        connect(r18, r11, r18, 0);
        connect(r20, r11, r20, 0);
    L22:
        if (r23 == false) goto L25;
        if (r22 == false) goto L25;
        getAnchor(r5).connect(r11.getAnchor(r5), 0);
        return;
    L25:
        if (r23 == false) goto L27;
        ConstraintAnchor.Type r24 = ConstraintAnchor.Type.CENTER_X;
        getAnchor(r24).connect(r11.getAnchor(r24), 0);
        return;
    L27:
        if (r22 == false) goto L98;
        ConstraintAnchor.Type r25 = ConstraintAnchor.Type.CENTER_Y;
        getAnchor(r25).connect(r11.getAnchor(r25), 0);
        return;
    L98:
        return;
    L19:
        if (r21.isConnected() == false) goto L21;
    L20:
        r22 = false;
        goto L22
    L16:
        if (r19.isConnected() == true) goto L20;
    L11:
        if (r17.isConnected() == false) goto L13;
    L12:
        r23 = false;
        goto L14
    L8:
        if (r15.isConnected() == true) goto L12;
    L29:
        ConstraintAnchor.Type r26 = ConstraintAnchor.Type.LEFT;
        if (r12 != r26) goto L32;
    L39:
        connect(r26, r11, r12, 0);
        connect(ConstraintAnchor.Type.RIGHT, r11, r12, 0);
        getAnchor(r5).connect(r11.getAnchor(r12), 0);
        return;
    L32:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L39;
        ConstraintAnchor.Type r27 = ConstraintAnchor.Type.TOP;
        if (r12 != r27) goto L37;
    L38:
        connect(r27, r11, r12, 0);
        connect(ConstraintAnchor.Type.BOTTOM, r11, r12, 0);
        getAnchor(r5).connect(r11.getAnchor(r12), 0);
        return;
    L37:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L38;
        return;
    L40:
        ConstraintAnchor.Type r28 = ConstraintAnchor.Type.CENTER_X;
        if (r10 != r28) goto L47;
        ConstraintAnchor.Type r29 = ConstraintAnchor.Type.LEFT;
        if (r12 != r29) goto L45;
    L46:
        ConstraintAnchor r30 = getAnchor(r29);
        ConstraintAnchor r110 = r11.getAnchor(r12);
        ConstraintAnchor r111 = getAnchor(ConstraintAnchor.Type.RIGHT);
        r30.connect(r110, 0);
        r111.connect(r110, 0);
        getAnchor(r28).connect(r110, 0);
        return;
    L45:
        if (r12 == ConstraintAnchor.Type.RIGHT) goto L46;
    L47:
        ConstraintAnchor.Type r31 = ConstraintAnchor.Type.CENTER_Y;
        if (r10 != r31) goto L54;
        ConstraintAnchor.Type r32 = ConstraintAnchor.Type.TOP;
        if (r12 != r32) goto L52;
    L53:
        ConstraintAnchor r33 = r11.getAnchor(r12);
        getAnchor(r32).connect(r33, 0);
        getAnchor(ConstraintAnchor.Type.BOTTOM).connect(r33, 0);
        getAnchor(r31).connect(r33, 0);
        return;
    L52:
        if (r12 == ConstraintAnchor.Type.BOTTOM) goto L53;
    L54:
        if (r10 != r28) goto L57;
        if (r12 != r28) goto L57;
        ConstraintAnchor.Type r34 = ConstraintAnchor.Type.LEFT;
        getAnchor(r34).connect(r11.getAnchor(r34), 0);
        ConstraintAnchor.Type r35 = ConstraintAnchor.Type.RIGHT;
        getAnchor(r35).connect(r11.getAnchor(r35), 0);
        getAnchor(r28).connect(r11.getAnchor(r12), 0);
        return;
    L57:
        if (r10 != r31) goto L60;
        if (r12 != r31) goto L60;
        ConstraintAnchor.Type r36 = ConstraintAnchor.Type.TOP;
        getAnchor(r36).connect(r11.getAnchor(r36), 0);
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.BOTTOM;
        getAnchor(r37).connect(r11.getAnchor(r37), 0);
        getAnchor(r31).connect(r11.getAnchor(r12), 0);
        return;
    L60:
        ConstraintAnchor r38 = getAnchor(r10);
        ConstraintAnchor r112 = r11.getAnchor(r12);
        if (r38.isValidConnection(r112) == false) goto L107;
        ConstraintAnchor.Type r113 = ConstraintAnchor.Type.BASELINE;
        if (r10 != r113) goto L71;
        ConstraintAnchor r39 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r40 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (r39 == null) goto L67;
        r39.reset();
    L67:
        if (r40 == null) goto L69;
        r40.reset();
    L69:
        r13 = 0;
    L94:
        r38.connect(r112, r13);
        return;
    L71:
        if (r10 != ConstraintAnchor.Type.TOP) goto L73;
    L85:
        ConstraintAnchor r114 = getAnchor(r113);
        if (r114 == null) goto L88;
        r114.reset();
    L88:
        ConstraintAnchor r115 = getAnchor(r5);
        if (r115.getTarget() == r112) goto L91;
        r115.reset();
    L91:
        ConstraintAnchor r41 = getAnchor(r10).getOpposite();
        ConstraintAnchor r42 = getAnchor(r31);
        if (r42.isConnected() == false) goto L94;
        r41.reset();
        r42.reset();
        goto L94
    L73:
        if (r10 == ConstraintAnchor.Type.BOTTOM) goto L85;
        if (r10 != ConstraintAnchor.Type.LEFT) goto L78;
    L79:
        ConstraintAnchor r116 = getAnchor(r5);
        if (r116.getTarget() == r112) goto L82;
        r116.reset();
    L82:
        ConstraintAnchor r43 = getAnchor(r10).getOpposite();
        ConstraintAnchor r44 = getAnchor(r28);
        if (r44.isConnected() == false) goto L94;
        r43.reset();
        r44.reset();
        goto L94
    L78:
        if (r10 != ConstraintAnchor.Type.RIGHT) goto L94;
    }

    public void setFrame(int r5, int r10, int r11) {
        if (r11 != 0) goto L5;
        setHorizontalDimension(r5, r10);
        return;
    L5:
        if (r11 != 1) goto L9;
        setVerticalDimension(r5, r10);
        return;
    }

    public void setDimensionRatio(float r5, int r10) {
        this.mDimensionRatio = r5;
        this.mDimensionRatioSide = r10;
    }

    public ConstraintWidget(String r14) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
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
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r12 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r12;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r12};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r5 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r5, r5};
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
        float r10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = r10;
        this.mVerticalBiasPercent = r10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
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
        setDebugName(r14);
    }

    public ConstraintWidget(int r15, int r16, int r17, int r18) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
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
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor r13 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = r13;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, r13};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour r10 = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{r10, r10};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
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
        this.mX = r15;
        this.mY = r16;
        this.mWidth = r17;
        this.mHeight = r18;
        addAnchors();
    }

    public ConstraintWidget(String r5, int r10, int r11, int r12, int r13) {
        this(r10, r11, r12, r13);
        setDebugName(r5);
    }

    public ConstraintWidget(int r5, int r10) {
        this(0, 0, r5, r10);
    }

    public ConstraintWidget(String r5, int r10, int r11) {
        this(r10, r11);
        setDebugName(r5);
    }
}
