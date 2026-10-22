package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r10 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r10;
            r10[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;
        public String dimensionRatio;
        int dimensionRatioSide;
        float dimensionRatioValue;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;
        boolean heightSet;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        boolean horizontalDimensionFixed;
        public float horizontalWeight;
        boolean isGuideline;
        boolean isHelper;
        boolean isInPlaceholder;
        boolean isVirtualGroup;
        public int leftToLeft;
        public int leftToRight;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;
        boolean needsBaseline;
        public int orientation;
        int resolveGoneLeftMargin;
        int resolveGoneRightMargin;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias;
        int resolvedLeftToLeft;
        int resolvedLeftToRight;
        int resolvedRightToLeft;
        int resolvedRightToRight;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        boolean verticalDimensionFixed;
        public float verticalWeight;
        ConstraintWidget widget;
        boolean widthSet;
        public int wrapBehaviorInParent;

        private static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int GUIDELINE_USE_RTL = 67;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF = 53;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF = 52;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_CREATOR = 42;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_BOTTOM_OF = 15;
            public static final int LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF = 14;
            public static final int LAYOUT_CONSTRAINT_CIRCLE = 2;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_ANGLE = 4;
            public static final int LAYOUT_CONSTRAINT_CIRCLE_RADIUS = 3;
            public static final int LAYOUT_CONSTRAINT_DIMENSION_RATIO = 44;
            public static final int LAYOUT_CONSTRAINT_END_TO_END_OF = 20;
            public static final int LAYOUT_CONSTRAINT_END_TO_START_OF = 19;
            public static final int LAYOUT_CONSTRAINT_GUIDE_BEGIN = 5;
            public static final int LAYOUT_CONSTRAINT_GUIDE_END = 6;
            public static final int LAYOUT_CONSTRAINT_GUIDE_PERCENT = 7;
            public static final int LAYOUT_CONSTRAINT_HEIGHT = 65;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_DEFAULT = 32;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MAX = 37;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_MIN = 36;
            public static final int LAYOUT_CONSTRAINT_HEIGHT_PERCENT = 38;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_BIAS = 29;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_CHAINSTYLE = 47;
            public static final int LAYOUT_CONSTRAINT_HORIZONTAL_WEIGHT = 45;
            public static final int LAYOUT_CONSTRAINT_LEFT_CREATOR = 39;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_LEFT_OF = 8;
            public static final int LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF = 9;
            public static final int LAYOUT_CONSTRAINT_RIGHT_CREATOR = 41;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_LEFT_OF = 10;
            public static final int LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF = 11;
            public static final int LAYOUT_CONSTRAINT_START_TO_END_OF = 17;
            public static final int LAYOUT_CONSTRAINT_START_TO_START_OF = 18;
            public static final int LAYOUT_CONSTRAINT_TAG = 51;
            public static final int LAYOUT_CONSTRAINT_TOP_CREATOR = 40;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF = 13;
            public static final int LAYOUT_CONSTRAINT_TOP_TO_TOP_OF = 12;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_BIAS = 30;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE = 48;
            public static final int LAYOUT_CONSTRAINT_VERTICAL_WEIGHT = 46;
            public static final int LAYOUT_CONSTRAINT_WIDTH = 64;
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BASELINE = 55;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int LAYOUT_MARGIN_BASELINE = 54;
            public static final int LAYOUT_WRAP_BEHAVIOR_IN_PARENT = 66;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = null;

            static {
                SparseIntArray r10 = new SparseIntArray();
                map = r10;
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                r10.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                r10.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                r10.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }

            private Table() {
            }
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r10 = 0;
        L3:
            if (r10 >= r14) goto L119;
            int r15 = r13.getIndex(r10);
            int r16 = Table.map.get(r15);
            switch(r16) {
                case 1: goto L117;
                case 2: goto L114;
                case 3: goto L113;
                case 4: goto L110;
                case 5: goto L109;
                case 6: goto L108;
                case 7: goto L107;
                case 8: goto L104;
                case 9: goto L101;
                case 10: goto L98;
                case 11: goto L95;
                case 12: goto L92;
                case 13: goto L89;
                case 14: goto L86;
                case 15: goto L83;
                case 16: goto L80;
                case 17: goto L77;
                case 18: goto L74;
                case 19: goto L71;
                case 20: goto L68;
                case 21: goto L67;
                case 22: goto L66;
                case 23: goto L65;
                case 24: goto L64;
                case 25: goto L63;
                case 26: goto L62;
                case 27: goto L61;
                case 28: goto L60;
                case 29: goto L59;
                case 30: goto L58;
                case 31: goto L54;
                case 32: goto L51;
                case 33: goto L123;
                case 34: goto L127;
                case 35: goto L40;
                case 36: goto L121;
                case 37: goto L125;
                case 38: goto L29;
                default: goto L6;
            };
        L6:
            switch(r16) {
                case 44: goto L28;
                case 45: goto L27;
                case 46: goto L26;
                case 47: goto L25;
                case 48: goto L24;
                case 49: goto L23;
                case 50: goto L22;
                case 51: goto L21;
                case 52: goto L18;
                case 53: goto L15;
                case 54: goto L14;
                case 55: goto L13;
                default: goto L7;
            };
        L7:
            switch(r16) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L118;
            };
        L9:
            this.guidelineUseRtl = r13.getBoolean(r15, this.guidelineUseRtl);
            goto L118
        L10:
            this.wrapBehaviorInParent = r13.getInt(r15, this.wrapBehaviorInParent);
            goto L118
        L11:
            ConstraintSet.parseDimensionConstraints(this, r13, r15, 1);
            this.heightSet = true;
            goto L118
        L12:
            ConstraintSet.parseDimensionConstraints(this, r13, r15, 0);
            this.widthSet = true;
        L118:
            r10 = r10 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r13.getDimensionPixelSize(r15, this.goneBaselineMargin);
            goto L118
        L14:
            this.baselineMargin = r13.getDimensionPixelSize(r15, this.baselineMargin);
            goto L118
        L15:
            int r17 = r13.getResourceId(r15, this.baselineToBottom);
            this.baselineToBottom = r17;
            if (r17 != (-1)) goto L118;
            this.baselineToBottom = r13.getInt(r15, -1);
            goto L118
        L18:
            int r18 = r13.getResourceId(r15, this.baselineToTop);
            this.baselineToTop = r18;
            if (r18 != (-1)) goto L118;
            this.baselineToTop = r13.getInt(r15, -1);
            goto L118
        L21:
            this.constraintTag = r13.getString(r15);
            goto L118
        L22:
            this.editorAbsoluteY = r13.getDimensionPixelOffset(r15, this.editorAbsoluteY);
            goto L118
        L23:
            this.editorAbsoluteX = r13.getDimensionPixelOffset(r15, this.editorAbsoluteX);
            goto L118
        L24:
            this.verticalChainStyle = r13.getInt(r15, 0);
            goto L118
        L25:
            this.horizontalChainStyle = r13.getInt(r15, 0);
            goto L118
        L26:
            this.verticalWeight = r13.getFloat(r15, this.verticalWeight);
            goto L118
        L27:
            this.horizontalWeight = r13.getFloat(r15, this.horizontalWeight);
            goto L118
        L28:
            ConstraintSet.parseDimensionRatioString(this, r13.getString(r15));
            goto L118
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r13.getFloat(r15, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L118
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r13.getFloat(r15, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L118
        L51:
            int r19 = r13.getInt(r15, 0);
            this.matchConstraintDefaultHeight = r19;
            if (r19 != 1) goto L118;
            String r20 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
        L57:
            Log.e(ConstraintLayout.TAG, r20);
            goto L118
        L54:
            int r21 = r13.getInt(r15, 0);
            this.matchConstraintDefaultWidth = r21;
            if (r21 != 1) goto L118;
            r20 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            goto L57
        L58:
            this.verticalBias = r13.getFloat(r15, this.verticalBias);
            goto L118
        L59:
            this.horizontalBias = r13.getFloat(r15, this.horizontalBias);
            goto L118
        L60:
            this.constrainedHeight = r13.getBoolean(r15, this.constrainedHeight);
            goto L118
        L61:
            this.constrainedWidth = r13.getBoolean(r15, this.constrainedWidth);
            goto L118
        L62:
            this.goneEndMargin = r13.getDimensionPixelSize(r15, this.goneEndMargin);
            goto L118
        L63:
            this.goneStartMargin = r13.getDimensionPixelSize(r15, this.goneStartMargin);
            goto L118
        L64:
            this.goneBottomMargin = r13.getDimensionPixelSize(r15, this.goneBottomMargin);
            goto L118
        L65:
            this.goneRightMargin = r13.getDimensionPixelSize(r15, this.goneRightMargin);
            goto L118
        L66:
            this.goneTopMargin = r13.getDimensionPixelSize(r15, this.goneTopMargin);
            goto L118
        L67:
            this.goneLeftMargin = r13.getDimensionPixelSize(r15, this.goneLeftMargin);
            goto L118
        L68:
            int r22 = r13.getResourceId(r15, this.endToEnd);
            this.endToEnd = r22;
            if (r22 != (-1)) goto L118;
            this.endToEnd = r13.getInt(r15, -1);
            goto L118
        L71:
            int r23 = r13.getResourceId(r15, this.endToStart);
            this.endToStart = r23;
            if (r23 != (-1)) goto L118;
            this.endToStart = r13.getInt(r15, -1);
            goto L118
        L74:
            int r24 = r13.getResourceId(r15, this.startToStart);
            this.startToStart = r24;
            if (r24 != (-1)) goto L118;
            this.startToStart = r13.getInt(r15, -1);
            goto L118
        L77:
            int r25 = r13.getResourceId(r15, this.startToEnd);
            this.startToEnd = r25;
            if (r25 != (-1)) goto L118;
            this.startToEnd = r13.getInt(r15, -1);
            goto L118
        L80:
            int r26 = r13.getResourceId(r15, this.baselineToBaseline);
            this.baselineToBaseline = r26;
            if (r26 != (-1)) goto L118;
            this.baselineToBaseline = r13.getInt(r15, -1);
            goto L118
        L83:
            int r27 = r13.getResourceId(r15, this.bottomToBottom);
            this.bottomToBottom = r27;
            if (r27 != (-1)) goto L118;
            this.bottomToBottom = r13.getInt(r15, -1);
            goto L118
        L86:
            int r28 = r13.getResourceId(r15, this.bottomToTop);
            this.bottomToTop = r28;
            if (r28 != (-1)) goto L118;
            this.bottomToTop = r13.getInt(r15, -1);
            goto L118
        L89:
            int r29 = r13.getResourceId(r15, this.topToBottom);
            this.topToBottom = r29;
            if (r29 != (-1)) goto L118;
            this.topToBottom = r13.getInt(r15, -1);
            goto L118
        L92:
            int r30 = r13.getResourceId(r15, this.topToTop);
            this.topToTop = r30;
            if (r30 != (-1)) goto L118;
            this.topToTop = r13.getInt(r15, -1);
            goto L118
        L95:
            int r31 = r13.getResourceId(r15, this.rightToRight);
            this.rightToRight = r31;
            if (r31 != (-1)) goto L118;
            this.rightToRight = r13.getInt(r15, -1);
            goto L118
        L98:
            int r32 = r13.getResourceId(r15, this.rightToLeft);
            this.rightToLeft = r32;
            if (r32 != (-1)) goto L118;
            this.rightToLeft = r13.getInt(r15, -1);
            goto L118
        L101:
            int r33 = r13.getResourceId(r15, this.leftToRight);
            this.leftToRight = r33;
            if (r33 != (-1)) goto L118;
            this.leftToRight = r13.getInt(r15, -1);
            goto L118
        L104:
            int r34 = r13.getResourceId(r15, this.leftToLeft);
            this.leftToLeft = r34;
            if (r34 != (-1)) goto L118;
            this.leftToLeft = r13.getInt(r15, -1);
            goto L118
        L107:
            this.guidePercent = r13.getFloat(r15, this.guidePercent);
            goto L118
        L108:
            this.guideEnd = r13.getDimensionPixelOffset(r15, this.guideEnd);
            goto L118
        L109:
            this.guideBegin = r13.getDimensionPixelOffset(r15, this.guideBegin);
            goto L118
        L110:
            float r35 = r13.getFloat(r15, this.circleAngle) % 360.0f;
            this.circleAngle = r35;
            if (r35 >= 0.0f) goto L118;
            this.circleAngle = (360.0f - r35) % 360.0f;
            goto L118
        L113:
            this.circleRadius = r13.getDimensionPixelSize(r15, this.circleRadius);
            goto L118
        L114:
            int r36 = r13.getResourceId(r15, this.circleConstraint);
            this.circleConstraint = r36;
            if (r36 != (-1)) goto L118;
            this.circleConstraint = r13.getInt(r15, -1);
            goto L118
        L117:
            this.orientation = r13.getInt(r15, this.orientation);
            goto L118
        L121:
            this.matchConstraintMinHeight = r13.getDimensionPixelSize(r15, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r13.getInt(r15, this.matchConstraintMinHeight) != (-2)) goto L118;
            this.matchConstraintMinHeight = -2;
            goto L118
        L123:
            this.matchConstraintMinWidth = r13.getDimensionPixelSize(r15, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r13.getInt(r15, this.matchConstraintMinWidth) != (-2)) goto L118;
            this.matchConstraintMinWidth = -2;
            goto L118
        L125:
            this.matchConstraintMaxHeight = r13.getDimensionPixelSize(r15, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r13.getInt(r15, this.matchConstraintMaxHeight) != (-2)) goto L118;
            this.matchConstraintMaxHeight = -2;
            goto L118
        L127:
            this.matchConstraintMaxWidth = r13.getDimensionPixelSize(r15, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r13.getInt(r15, this.matchConstraintMaxWidth) != (-2)) goto L118;
            this.matchConstraintMaxWidth = -2;
            goto L118
        L119:
            r13.recycle();
            validate();
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.widthSet = true;
            this.heightSet = true;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.dimensionRatioValue = 0.0f;
            this.dimensionRatioSide = 1;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = Integer.MIN_VALUE;
            this.resolveGoneRightMargin = Integer.MIN_VALUE;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = r10.guideBegin;
            this.guideEnd = r10.guideEnd;
            this.guidePercent = r10.guidePercent;
            this.guidelineUseRtl = r10.guidelineUseRtl;
            this.leftToLeft = r10.leftToLeft;
            this.leftToRight = r10.leftToRight;
            this.rightToLeft = r10.rightToLeft;
            this.rightToRight = r10.rightToRight;
            this.topToTop = r10.topToTop;
            this.topToBottom = r10.topToBottom;
            this.bottomToTop = r10.bottomToTop;
            this.bottomToBottom = r10.bottomToBottom;
            this.baselineToBaseline = r10.baselineToBaseline;
            this.baselineToTop = r10.baselineToTop;
            this.baselineToBottom = r10.baselineToBottom;
            this.circleConstraint = r10.circleConstraint;
            this.circleRadius = r10.circleRadius;
            this.circleAngle = r10.circleAngle;
            this.startToEnd = r10.startToEnd;
            this.startToStart = r10.startToStart;
            this.endToStart = r10.endToStart;
            this.endToEnd = r10.endToEnd;
            this.goneLeftMargin = r10.goneLeftMargin;
            this.goneTopMargin = r10.goneTopMargin;
            this.goneRightMargin = r10.goneRightMargin;
            this.goneBottomMargin = r10.goneBottomMargin;
            this.goneStartMargin = r10.goneStartMargin;
            this.goneEndMargin = r10.goneEndMargin;
            this.goneBaselineMargin = r10.goneBaselineMargin;
            this.baselineMargin = r10.baselineMargin;
            this.horizontalBias = r10.horizontalBias;
            this.verticalBias = r10.verticalBias;
            this.dimensionRatio = r10.dimensionRatio;
            this.dimensionRatioValue = r10.dimensionRatioValue;
            this.dimensionRatioSide = r10.dimensionRatioSide;
            this.horizontalWeight = r10.horizontalWeight;
            this.verticalWeight = r10.verticalWeight;
            this.horizontalChainStyle = r10.horizontalChainStyle;
            this.verticalChainStyle = r10.verticalChainStyle;
            this.constrainedWidth = r10.constrainedWidth;
            this.constrainedHeight = r10.constrainedHeight;
            this.matchConstraintDefaultWidth = r10.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r10.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r10.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r10.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r10.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r10.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r10.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r10.matchConstraintPercentHeight;
            this.editorAbsoluteX = r10.editorAbsoluteX;
            this.editorAbsoluteY = r10.editorAbsoluteY;
            this.orientation = r10.orientation;
            this.horizontalDimensionFixed = r10.horizontalDimensionFixed;
            this.verticalDimensionFixed = r10.verticalDimensionFixed;
            this.needsBaseline = r10.needsBaseline;
            this.isGuideline = r10.isGuideline;
            this.resolvedLeftToLeft = r10.resolvedLeftToLeft;
            this.resolvedLeftToRight = r10.resolvedLeftToRight;
            this.resolvedRightToLeft = r10.resolvedRightToLeft;
            this.resolvedRightToRight = r10.resolvedRightToRight;
            this.resolveGoneLeftMargin = r10.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = r10.resolveGoneRightMargin;
            this.resolvedHorizontalBias = r10.resolvedHorizontalBias;
            this.constraintTag = r10.constraintTag;
            this.wrapBehaviorInParent = r10.wrapBehaviorInParent;
            this.widget = r10.widget;
            this.widthSet = r10.widthSet;
            this.heightSet = r10.heightSet;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget r10 = this.widget;
            if (r10 == null) goto L6;
            r10.reset();
            return;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int r11) {
            int r10 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r12 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            boolean r13 = false;
            if (Build.VERSION.SDK_INT < 17) goto L7;
            super.resolveLayoutDirection(r11);
            if (1 != getLayoutDirection()) goto L7;
            boolean r14 = true;
        L8:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r15 = this.horizontalBias;
            this.resolvedHorizontalBias = r15;
            int r16 = this.guideBegin;
            this.resolvedGuideBegin = r16;
            int r17 = this.guideEnd;
            this.resolvedGuideEnd = r17;
            float r18 = this.guidePercent;
            this.resolvedGuidePercent = r18;
            if (r14 == false) goto L46;
            int r19 = this.startToEnd;
            if (r19 == (-1)) goto L14;
            this.resolvedRightToLeft = r19;
        L13:
            r13 = true;
        L17:
            int r110 = this.endToStart;
            if (r110 == (-1)) goto L20;
            this.resolvedLeftToRight = r110;
            r13 = true;
        L20:
            int r111 = this.endToEnd;
            if (r111 == (-1)) goto L23;
            this.resolvedLeftToLeft = r111;
            r13 = true;
        L23:
            int r112 = this.goneStartMargin;
            if (r112 == Integer.MIN_VALUE) goto L26;
            this.resolveGoneRightMargin = r112;
        L26:
            int r113 = this.goneEndMargin;
            if (r113 == Integer.MIN_VALUE) goto L30;
            this.resolveGoneLeftMargin = r113;
        L30:
            if (r13 == false) goto L33;
            this.resolvedHorizontalBias = 1.0f - r15;
        L33:
            if (this.isGuideline == false) goto L65;
            if (this.orientation != 1) goto L65;
            if (this.guidelineUseRtl == false) goto L65;
            if (r18 == (-1.0f)) goto L41;
            this.resolvedGuidePercent = 1.0f - r18;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L65
        L41:
            if (r16 == (-1)) goto L44;
            this.resolvedGuideEnd = r16;
            this.resolvedGuideBegin = -1;
        L43:
            this.resolvedGuidePercent = -1.0f;
            goto L65
        L44:
            if (r17 == (-1)) goto L65;
            this.resolvedGuideBegin = r17;
            this.resolvedGuideEnd = -1;
        L65:
            if (this.endToStart == (-1)) goto L67;
            return;
        L67:
            if (this.endToEnd == (-1)) goto L69;
            return;
        L69:
            if (this.startToStart == (-1)) goto L71;
            return;
        L71:
            if (this.startToEnd != (-1)) goto L99;
            int r114 = this.rightToLeft;
            if (r114 == (-1)) goto L78;
            this.resolvedRightToLeft = r114;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L84;
            if (r12 <= 0) goto L84;
        L77:
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r12;
        L84:
            int r115 = this.leftToLeft;
            if (r115 == (-1)) goto L90;
            this.resolvedLeftToLeft = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L100;
            if (r10 <= 0) goto L101;
        L89:
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10;
            return;
        L101:
            return;
        L100:
            return;
        L90:
            int r116 = this.leftToRight;
            if (r116 == (-1)) goto L103;
            this.resolvedLeftToRight = r116;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L104;
            if (r10 > 0) goto L89;
            return;
        L104:
            return;
        L103:
            return;
        L78:
            int r117 = this.rightToRight;
            if (r117 == (-1)) goto L84;
            this.resolvedRightToRight = r117;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L84;
            if (r12 <= 0) goto L84;
        L99:
            return;
        L14:
            int r118 = this.startToStart;
            if (r118 == (-1)) goto L17;
            this.resolvedRightToRight = r118;
            goto L13
        L46:
            int r119 = this.startToEnd;
            if (r119 == (-1)) goto L49;
            this.resolvedLeftToRight = r119;
        L49:
            int r120 = this.startToStart;
            if (r120 == (-1)) goto L52;
            this.resolvedLeftToLeft = r120;
        L52:
            int r121 = this.endToStart;
            if (r121 == (-1)) goto L55;
            this.resolvedRightToLeft = r121;
        L55:
            int r122 = this.endToEnd;
            if (r122 == (-1)) goto L58;
            this.resolvedRightToRight = r122;
        L58:
            int r123 = this.goneStartMargin;
            if (r123 == Integer.MIN_VALUE) goto L61;
            this.resolveGoneLeftMargin = r123;
        L61:
            int r124 = this.goneEndMargin;
            if (r124 == Integer.MIN_VALUE) goto L65;
            this.resolveGoneRightMargin = r124;
        L7:
            r14 = false;
            goto L8
        }

        public void setWidgetDebugName(String r10) {
            this.widget.setDebugName(r10);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int r10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r10 == (-2)) goto L5;
        L9:
            int r11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r11 != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (r10 == 0) goto L19;
            if (r10 == (-1)) goto L19;
        L24:
            if (r11 == 0) goto L26;
            if (r11 == (-1)) goto L26;
        L32:
            if (this.guidePercent == (-1.0f)) goto L34;
        L37:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if ((this.widget instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L40;
            this.widget = new androidx.constraintlayout.core.widgets.Guideline();
        L40:
            ((androidx.constraintlayout.core.widgets.Guideline) this.widget).setOrientation(this.orientation);
            return;
        L34:
            if (this.guideBegin != (-1)) goto L37;
            if (this.guideEnd != (-1)) goto L37;
            return;
        L26:
            this.verticalDimensionFixed = false;
            if (r11 != 0) goto L32;
            if (this.matchConstraintDefaultHeight != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.constrainedHeight = true;
        L19:
            this.horizontalDimensionFixed = false;
            if (r10 != 0) goto L24;
            if (this.matchConstraintDefaultWidth != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.constrainedWidth = true;
            goto L24
        L5:
            if (this.constrainedWidth == false) goto L9;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L9;
            this.matchConstraintDefaultWidth = 1;
            goto L9
        }
    }

    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;
        final /* synthetic */ ConstraintLayout this$0;

        public Measurer(ConstraintLayout r10, ConstraintLayout r11) {
            this.this$0 = r10;
            this.layout = r11;
        }

        private boolean isSimilarSpec(int r10, int r11, int r12) {
            if (r10 != r11) goto L5;
            return true;
        L5:
            int r13 = View.MeasureSpec.getMode(r10);
            View.MeasureSpec.getSize(r10);
            int r14 = View.MeasureSpec.getMode(r11);
            int r15 = View.MeasureSpec.getSize(r11);
            if (r14 == 1073741824) goto L8;
            return false;
        L8:
            if (r13 == Integer.MIN_VALUE) goto L10;
            if (r13 == 0) goto L10;
            return false;
        L10:
            if (r12 != r15) goto L15;
            return true;
        L15:
            return false;
        }

        public void captureLayoutInfo(int r10, int r11, int r12, int r13, int r14, int r15) {
            this.paddingTop = r12;
            this.paddingBottom = r13;
            this.paddingWidth = r14;
            this.paddingHeight = r15;
            this.layoutWidthSpec = r10;
            this.layoutHeightSpec = r11;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r10 = this.layout.getChildCount();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L8;
            View r13 = this.layout.getChildAt(r12);
            if ((r13 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r13).updatePostMeasure(this.layout);
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            int r14 = ConstraintLayout.access$100(this.layout).size();
            if (r14 <= 0) goto L12;
        L10:
            if (r11 >= r14) goto L17;
            ((ConstraintHelper) ConstraintLayout.access$100(this.layout).get(r11)).updatePostMeasure(this.layout);
            r11 = r11 + 1;
            goto L10
        L17:
            return;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget r18, BasicMeasure.Measure r19) {
            if (r18 != null) goto L6;
            return;
        L6:
            if (r18.getVisibility() != 8) goto L12;
            if (r18.isInPlaceholder() == true) goto L12;
            r19.measuredWidth = 0;
            r19.measuredHeight = 0;
            r19.measuredBaseline = 0;
            return;
        L12:
            if (r18.getParent() != null) goto L14;
            return;
        L14:
            ConstraintWidget.DimensionBehaviour r10 = r19.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r11 = r19.verticalBehavior;
            int r12 = r19.horizontalDimension;
            int r13 = r19.verticalDimension;
            int r14 = this.paddingTop + this.paddingBottom;
            int r15 = this.paddingWidth;
            View r16 = (View) r18.getCompanionWidget();
            int[] r17 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;
            int r110 = r17[r10.ordinal()];
            if (r110 == 1) goto L49;
            if (r110 == 2) goto L47;
            if (r110 == 3) goto L46;
            if (r110 == 4) goto L20;
            int r20 = 0;
        L50:
            int r21 = r17[r11.ordinal()];
            if (r21 == 1) goto L87;
            if (r21 != 2) goto L54;
            int r22 = this.layoutHeightSpec;
            int r23 = -2;
        L86:
            int r24 = ViewGroup.getChildMeasureSpec(r22, r14, r23);
        L88:
            ConstraintWidgetContainer r25 = (ConstraintWidgetContainer) r18.getParent();
            if (r25 != null) goto L91;
        L113:
            ConstraintWidget.DimensionBehaviour r26 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r10 != r26) goto L116;
            boolean r27 = true;
        L117:
            if (r11 != r26) goto L119;
            boolean r28 = true;
        L120:
            ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r11 != r111) goto L123;
        L126:
            boolean r29 = true;
        L127:
            if (r10 != r111) goto L129;
        L132:
            boolean r30 = true;
        L134:
            if (r27 == true) goto L136;
        L138:
            boolean r112 = false;
        L139:
            if (r28 == true) goto L141;
        L143:
            boolean r113 = false;
        L144:
            if (r16 != null) goto L146;
            return;
        L146:
            LayoutParams r114 = (LayoutParams) r16.getLayoutParams();
            int r115 = r19.measureStrategy;
            if (r115 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L159;
            if (r115 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L159;
            if (r27 == false) goto L159;
            if (r18.mMatchConstraintDefaultWidth != 0) goto L159;
            if (r28 == false) goto L159;
            if (r18.mMatchConstraintDefaultHeight != 0) goto L159;
            int r31 = -1;
            int r32 = 0;
            int r116 = 0;
            int r117 = 0;
        L198:
            if (r116 == r31) goto L200;
            boolean r33 = true;
        L202:
            if (r117 == r19.horizontalDimension) goto L204;
        L207:
            boolean r34 = true;
        L208:
            r19.measuredNeedsSolverPass = r34;
            if (r114.needsBaseline == false) goto L211;
            r33 = true;
        L211:
            if (r33 == true) goto L213;
        L217:
            r19.measuredWidth = r117;
            r19.measuredHeight = r32;
            r19.measuredHasBaseline = r33;
            r19.measuredBaseline = r116;
            return;
        L213:
            if (r116 == (-1)) goto L217;
            if (r18.getBaselineDistance() == r116) goto L217;
            r19.measuredNeedsSolverPass = true;
            goto L217
        L204:
            if (r32 != r19.verticalDimension) goto L207;
            r34 = false;
            goto L208
        L200:
            r33 = false;
        L159:
            if ((r16 instanceof VirtualLayout) == true) goto L161;
        L163:
            r16.measure(r20, r24);
        L164:
            r18.setLastMeasureSpec(r20, r24);
            int r35 = r16.getMeasuredWidth();
            int r36 = r16.getMeasuredHeight();
            r116 = r16.getBaseline();
            int r118 = r18.mMatchConstraintMinWidth;
            if (r118 <= 0) goto L167;
            r117 = Math.max(r118, r35);
        L168:
            int r37 = r18.mMatchConstraintMaxWidth;
            if (r37 <= 0) goto L171;
            r117 = Math.min(r37, r117);
        L171:
            int r38 = r18.mMatchConstraintMinHeight;
            if (r38 <= 0) goto L174;
            r32 = Math.max(r38, r36);
        L175:
            int r39 = r18.mMatchConstraintMaxHeight;
            if (r39 <= 0) goto L179;
            r32 = Math.min(r39, r32);
        L179:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L181;
        L187:
            if (r35 != r117) goto L192;
            if (r36 != r32) goto L192;
        L190:
            r31 = -1;
        L192:
            if (r35 == r117) goto L194;
            int r40 = View.MeasureSpec.makeMeasureSpec(r117, 1073741824);
        L195:
            if (r36 == r32) goto L197;
            r24 = View.MeasureSpec.makeMeasureSpec(r32, 1073741824);
        L197:
            r16.measure(r40, r24);
            r18.setLastMeasureSpec(r40, r24);
            r117 = r16.getMeasuredWidth();
            r32 = r16.getMeasuredHeight();
            r116 = r16.getBaseline();
            goto L190
        L194:
            r40 = r20;
            goto L195
        L181:
            if (r112 == false) goto L184;
            if (r29 == false) goto L184;
            r117 = (int) ((r32 * r18.mDimensionRatio) + 0.5f);
        L184:
            if (r113 == false) goto L187;
            if (r30 == false) goto L187;
            r32 = (int) ((r117 / r18.mDimensionRatio) + 0.5f);
            goto L187
        L174:
            r32 = r36;
            goto L175
        L167:
            r117 = r35;
            goto L168
        L161:
            if ((r18 instanceof androidx.constraintlayout.core.widgets.VirtualLayout) == false) goto L163;
            ((VirtualLayout) r16).onMeasure((androidx.constraintlayout.core.widgets.VirtualLayout) r18, r20, r24);
            goto L164
        L141:
            if (r18.mDimensionRatio <= 0.0f) goto L143;
            r113 = true;
            goto L144
        L136:
            if (r18.mDimensionRatio <= 0.0f) goto L138;
            r112 = true;
            goto L139
        L129:
            if (r10 == ConstraintWidget.DimensionBehaviour.FIXED) goto L132;
            r30 = false;
            goto L134
        L123:
            if (r11 == ConstraintWidget.DimensionBehaviour.FIXED) goto L126;
            r29 = false;
            goto L127
        L119:
            r28 = false;
            goto L120
        L116:
            r27 = false;
            goto L117
        L91:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L113;
            if (r16.getMeasuredWidth() != r18.getWidth()) goto L113;
            if (r16.getMeasuredWidth() >= r25.getWidth()) goto L113;
            if (r16.getMeasuredHeight() != r18.getHeight()) goto L113;
            if (r16.getMeasuredHeight() >= r25.getHeight()) goto L113;
            if (r16.getBaseline() != r18.getBaselineDistance()) goto L113;
            if (r18.isMeasureRequested() == true) goto L113;
            if (isSimilarSpec(r18.getLastHorizontalMeasureSpec(), r20, r18.getWidth()) == true) goto L107;
        L109:
            boolean r41 = false;
        L110:
            if (r41 == false) goto L113;
            r19.measuredWidth = r18.getWidth();
            r19.measuredHeight = r18.getHeight();
            r19.measuredBaseline = r18.getBaselineDistance();
            return;
        L107:
            if (isSimilarSpec(r18.getLastVerticalMeasureSpec(), r24, r18.getHeight()) == false) goto L109;
            r41 = true;
            goto L110
        L54:
            if (r21 != 3) goto L56;
            r22 = this.layoutHeightSpec;
            r14 = r14 + r18.getVerticalMargin();
            r23 = -1;
            goto L86
        L56:
            if (r21 == 4) goto L58;
            r24 = 0;
            goto L88
        L58:
            r24 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r14, -2);
            if (r18.mMatchConstraintDefaultHeight != 1) goto L61;
            boolean r42 = true;
        L62:
            int r43 = r19.measureStrategy;
            if (r43 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L67;
            if (r43 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L88;
        L67:
            if (r16.getMeasuredWidth() != r18.getWidth()) goto L69;
            boolean r44 = true;
        L71:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L81;
            if (r42 == false) goto L81;
            if (r42 == false) goto L76;
            if (r44 == true) goto L81;
        L76:
            if ((r16 instanceof Placeholder) == true) goto L81;
            if (r18.isResolvedVertically() == true) goto L81;
            boolean r45 = false;
        L82:
            if (r45 == false) goto L88;
            r13 = r18.getHeight();
        L81:
            r45 = true;
            goto L82
        L69:
            r44 = false;
            goto L71
        L61:
            r42 = false;
        L87:
            r24 = View.MeasureSpec.makeMeasureSpec(r13, 1073741824);
            goto L88
        L20:
            r20 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r15, -2);
            if (r18.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r46 = true;
        L24:
            int r119 = r19.measureStrategy;
            if (r119 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (r119 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L50;
        L29:
            if (r16.getMeasuredHeight() != r18.getHeight()) goto L31;
            boolean r120 = true;
        L33:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L43;
            if (r46 == false) goto L43;
            if (r46 == false) goto L38;
            if (r120 == true) goto L43;
        L38:
            if ((r16 instanceof Placeholder) == true) goto L43;
            if (r18.isResolvedHorizontally() == true) goto L43;
            boolean r47 = false;
        L44:
            if (r47 == false) goto L50;
            r12 = r18.getWidth();
        L43:
            r47 = true;
            goto L44
        L31:
            r120 = false;
            goto L33
        L23:
            r46 = false;
            goto L24
        L46:
            int r48 = this.layoutWidthSpec;
            r15 = r15 + r18.getHorizontalMargin();
            int r121 = -1;
        L48:
            r20 = ViewGroup.getChildMeasureSpec(r48, r15, r121);
            goto L50
        L47:
            r48 = this.layoutWidthSpec;
            r121 = -2;
        L49:
            r20 = View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
            goto L50
        }
    }

    static {
    }

    public ConstraintLayout(@NonNull Context r10) {
        super(r10);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r11, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r11, r12, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(r11, r12, r13);
    }

    static /* synthetic */ int access$000(ConstraintLayout r10) {
        return r10.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout r10) {
        return r10.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int r10 = 0;
        int r11 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r10 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
    L5:
        if (r10 > 0) goto L7;
        return r11;
    L7:
        return r10;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int r10) {
        if (r10 == 0) goto L4;
        View r11 = this.mChildrenByIds.get(r10);
        if (r11 != null) goto L13;
        r11 = findViewById(r10);
        if (r11 == null) goto L13;
        if (r11 == this) goto L13;
        if (r11.getParent() != this) goto L13;
        onViewAdded(r11);
    L13:
        if (r11 == this) goto L15;
        if (r11 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) r11.getLayoutParams()).widget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    private void init(AttributeSet r10, int r11, int r12) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r10 == null) goto L37;
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R.styleable.ConstraintLayout_Layout, r11, r12);
        int r14 = r13.getIndexCount();
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L36;
        int r16 = r13.getIndex(r15);
        if (r16 != R.styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.mMinWidth = r13.getDimensionPixelOffset(r16, this.mMinWidth);
    L35:
        r15 = r15 + 1;
        goto L5
    L10:
        if (r16 != R.styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.mMinHeight = r13.getDimensionPixelOffset(r16, this.mMinHeight);
        goto L35
    L13:
        if (r16 != R.styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.mMaxWidth = r13.getDimensionPixelOffset(r16, this.mMaxWidth);
        goto L35
    L16:
        if (r16 != R.styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.mMaxHeight = r13.getDimensionPixelOffset(r16, this.mMaxHeight);
        goto L35
    L19:
        if (r16 != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.mOptimizationLevel = r13.getInt(r16, this.mOptimizationLevel);
        goto L35
    L22:
        if (r16 != R.styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r17 = r13.getResourceId(r16, 0);
        if (r17 == 0) goto L35;
        parseLayoutDescription(r17);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r16 != R.styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r18 = r13.getResourceId(r16, 0);
        ConstraintSet r19 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r19;     // Catch: Resources.NotFoundException -> L33
        r19.load(getContext(), r18);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r18;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean r10 = isInEditMode();
        int r11 = getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        ConstraintWidget r13 = getViewWidget(getChildAt(r12));
        if (r13 == null) goto L8;
        r13.reset();
    L8:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r10 == false) goto L20;
        int r14 = 0;
    L12:
        if (r14 >= r11) goto L20;
        View r15 = getChildAt(r14);
        String r16 = getResources().getResourceName(r15.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r16, Integer.valueOf(r15.getId()));     // Catch: Resources.NotFoundException -> L54
        int r17 = r16.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r17 == (-1)) goto L17;
        r16 = r16.substring(r17 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r15.getId()).setDebugName(r16);     // Catch: Resources.NotFoundException -> L54
    L18:
        r14 = r14 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r18 = 0;
    L22:
        if (r18 >= r11) goto L29;
        View r19 = getChildAt(r18);
        if (r19.getId() != this.mConstraintSetId) goto L28;
        if ((r19 instanceof Constraints) == false) goto L28;
        this.mConstraintSet = ((Constraints) r19).getConstraintSet();
    L28:
        r18 = r18 + 1;
    L29:
        ConstraintSet r20 = this.mConstraintSet;
        if (r20 == null) goto L32;
        r20.applyToInternal(this, true);
    L32:
        this.mLayoutWidget.removeAllChildren();
        int r21 = this.mConstraintHelpers.size();
        if (r21 <= 0) goto L37;
        int r22 = 0;
    L35:
        if (r22 >= r21) goto L37;
        this.mConstraintHelpers.get(r22).updatePreLayout(this);
        r22 = r22 + 1;
    L37:
        int r23 = 0;
    L38:
        if (r23 >= r11) goto L43;
        View r24 = getChildAt(r23);
        if ((r24 instanceof Placeholder) == false) goto L42;
        ((Placeholder) r24).updatePreLayout(this);
    L42:
        r23 = r23 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r25 = 0;
    L44:
        if (r25 >= r11) goto L46;
        View r26 = getChildAt(r25);
        this.mTempMapIdToWidget.put(r26.getId(), getViewWidget(r26));
        r25 = r25 + 1;
        goto L44
    L46:
        int r27 = 0;
    L47:
        if (r27 >= r11) goto L53;
        View r28 = getChildAt(r27);
        ConstraintWidget r29 = getViewWidget(r28);
        if (r29 == null) goto L52;
        LayoutParams r30 = (LayoutParams) r28.getLayoutParams();
        this.mLayoutWidget.add(r29);
        applyConstraintsFromLayoutParams(r10, r28, r29, r30, this.mTempMapIdToWidget);
    L52:
        r27 = r27 + 1;
        goto L47
    }

    private void setWidgetBaseline(ConstraintWidget r10, LayoutParams r11, SparseArray<ConstraintWidget> r12, int r13, ConstraintAnchor.Type r14) {
        View r15 = this.mChildrenByIds.get(r13);
        ConstraintWidget r16 = r12.get(r13);
        if (r16 == null) goto L12;
        if (r15 != null) goto L6;
        return;
    L6:
        if ((r15.getLayoutParams() instanceof LayoutParams) == false) goto L14;
        r11.needsBaseline = true;
        ConstraintAnchor.Type r17 = ConstraintAnchor.Type.BASELINE;
        if (r14 != r17) goto L10;
        LayoutParams r18 = (LayoutParams) r15.getLayoutParams();
        r18.needsBaseline = true;
        r18.widget.setHasBaseline(true);
    L10:
        r10.getAnchor(r17).connect(r16.getAnchor(r14), r11.baselineMargin, r11.goneBaselineMargin, true);
        r10.setHasBaseline(true);
        r10.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r10.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        return;
    L14:
        return;
    }

    private boolean updateHierarchy() {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L8;
        if (getChildAt(r12).isLayoutRequested() == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r11 = true;
    L8:
        if (r11 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r11;
    }

    protected void applyConstraintsFromLayoutParams(boolean r17, View r18, ConstraintWidget r19, LayoutParams r20, SparseArray<ConstraintWidget> r21) {
        r20.validate();
        r20.helped = false;
        r19.setVisibility(r18.getVisibility());
        if (r20.isInPlaceholder == false) goto L5;
        r19.setInPlaceholder(true);
        r19.setVisibility(8);
    L5:
        r19.setCompanionWidget(r18);
        if ((r18 instanceof ConstraintHelper) == false) goto L10;
        ((ConstraintHelper) r18).resolveRtl(r19, this.mLayoutWidget.isRtl());
    L10:
        if (r20.isGuideline == false) goto L21;
        androidx.constraintlayout.core.widgets.Guideline r10 = (androidx.constraintlayout.core.widgets.Guideline) r19;
        int r11 = r20.resolvedGuideBegin;
        int r12 = r20.resolvedGuideEnd;
        float r13 = r20.resolvedGuidePercent;
        if (Build.VERSION.SDK_INT >= 17) goto L15;
        r11 = r20.guideBegin;
        r12 = r20.guideEnd;
        r13 = r20.guidePercent;
    L15:
        if (r13 == (-1.0f)) goto L17;
        r10.setGuidePercent(r13);
        return;
    L17:
        if (r11 == (-1)) goto L19;
        r10.setGuideBegin(r11);
        return;
    L19:
        if (r12 == (-1)) goto L140;
        r10.setGuideEnd(r12);
        return;
    L140:
        return;
    L21:
        int r14 = r20.resolvedLeftToLeft;
        int r15 = r20.resolvedLeftToRight;
        int r16 = r20.resolvedRightToLeft;
        int r22 = r20.resolvedRightToRight;
        int r23 = r20.resolveGoneLeftMargin;
        int r110 = r20.resolveGoneRightMargin;
        float r111 = r20.resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT >= 17) goto L42;
        r14 = r20.leftToLeft;
        int r24 = r20.leftToRight;
        int r25 = r20.rightToLeft;
        int r26 = r20.rightToRight;
        int r27 = r20.goneLeftMargin;
        int r28 = r20.goneRightMargin;
        float r112 = r20.horizontalBias;
        if (r14 != (-1)) goto L32;
        if (r24 != (-1)) goto L32;
        int r113 = r20.startToStart;
        if (r113 == (-1)) goto L29;
        r14 = r113;
        goto L32
    L29:
        int r114 = r20.startToEnd;
        if (r114 == (-1)) goto L32;
        r24 = r114;
    L32:
        if (r25 != (-1)) goto L40;
        if (r26 != (-1)) goto L40;
        int r115 = r20.endToStart;
        if (r115 != (-1)) goto L41;
        int r116 = r20.endToEnd;
        if (r116 == (-1)) goto L40;
        int r117 = r28;
        float r118 = r112;
        r23 = r27;
        int r119 = r116;
        r15 = r24;
        r115 = r25;
    L43:
        int r29 = r20.circleConstraint;
        if (r29 == (-1)) goto L48;
        ConstraintWidget r30 = r21.get(r29);
        if (r30 == null) goto L104;
        r19.connectCircularConstraint(r30, r20.circleAngle, r20.circleRadius);
    L104:
        if (r17 == false) goto L111;
        int r31 = r20.editorAbsoluteX;
        if (r31 == (-1)) goto L108;
    L109:
        r19.setOrigin(r31, r20.editorAbsoluteY);
        goto L111
    L108:
        if (r20.editorAbsoluteY != (-1)) goto L109;
    L111:
        if (r20.horizontalDimensionFixed == false) goto L113;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setWidth(((ViewGroup.MarginLayoutParams) r20).width);
        if (((ViewGroup.MarginLayoutParams) r20).width != (-2)) goto L124;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L124:
        if (r20.verticalDimensionFixed == false) goto L126;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r19.setHeight(((ViewGroup.MarginLayoutParams) r20).height);
        if (((ViewGroup.MarginLayoutParams) r20).height != (-2)) goto L136;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L136:
        r19.setDimensionRatio(r20.dimensionRatio);
        r19.setHorizontalWeight(r20.horizontalWeight);
        r19.setVerticalWeight(r20.verticalWeight);
        r19.setHorizontalChainStyle(r20.horizontalChainStyle);
        r19.setVerticalChainStyle(r20.verticalChainStyle);
        r19.setWrapBehaviorInParent(r20.wrapBehaviorInParent);
        r19.setHorizontalMatchStyle(r20.matchConstraintDefaultWidth, r20.matchConstraintMinWidth, r20.matchConstraintMaxWidth, r20.matchConstraintPercentWidth);
        r19.setVerticalMatchStyle(r20.matchConstraintDefaultHeight, r20.matchConstraintMinHeight, r20.matchConstraintMaxHeight, r20.matchConstraintPercentHeight);
        return;
    L126:
        if (((ViewGroup.MarginLayoutParams) r20).height == (-1)) goto L128;
        r19.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setHeight(0);
        goto L136
    L128:
        if (r20.constrainedHeight == false) goto L130;
        ConstraintWidget.DimensionBehaviour r32 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L131:
        r19.setVerticalDimensionBehaviour(r32);
        ConstraintAnchor r33 = r19.getAnchor(ConstraintAnchor.Type.TOP);
        r33.mMargin = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        ConstraintAnchor r34 = r19.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r34.mMargin = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        goto L136
    L130:
        r32 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L131
    L113:
        if (((ViewGroup.MarginLayoutParams) r20).width == (-1)) goto L115;
        r19.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r19.setWidth(0);
        goto L124
    L115:
        if (r20.constrainedWidth == false) goto L117;
        ConstraintWidget.DimensionBehaviour r35 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L118:
        r19.setHorizontalDimensionBehaviour(r35);
        ConstraintAnchor r36 = r19.getAnchor(ConstraintAnchor.Type.LEFT);
        r36.mMargin = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor r37 = r19.getAnchor(ConstraintAnchor.Type.RIGHT);
        r37.mMargin = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        goto L124
    L117:
        r35 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L118
    L48:
        if (r14 == (-1)) goto L52;
        ConstraintWidget r38 = r21.get(r14);
        if (r38 == null) goto L57;
        ConstraintAnchor.Type r39 = ConstraintAnchor.Type.LEFT;
        int r40 = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
        ConstraintAnchor.Type r41 = r39;
    L56:
        r19.immediateConnect(r41, r38, r39, r40, r23);
    L57:
        if (r115 == (-1)) goto L61;
        ConstraintWidget r42 = r21.get(r115);
        if (r42 == null) goto L66;
        ConstraintAnchor.Type r43 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type r44 = ConstraintAnchor.Type.LEFT;
        int r45 = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
    L65:
        r19.immediateConnect(r43, r42, r44, r45, r117);
    L66:
        int r46 = r20.topToTop;
        if (r46 == (-1)) goto L71;
        ConstraintWidget r47 = r21.get(r46);
        if (r47 == null) goto L77;
        ConstraintAnchor.Type r48 = ConstraintAnchor.Type.TOP;
        int r49 = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        int r50 = r20.goneTopMargin;
        ConstraintAnchor.Type r51 = r48;
    L76:
        r19.immediateConnect(r51, r47, r48, r49, r50);
    L77:
        int r52 = r20.bottomToTop;
        if (r52 == (-1)) goto L82;
        ConstraintWidget r53 = r21.get(r52);
        if (r53 == null) goto L88;
        ConstraintAnchor.Type r54 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type r55 = ConstraintAnchor.Type.TOP;
        int r56 = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        int r57 = r20.goneBottomMargin;
    L87:
        r19.immediateConnect(r54, r53, r55, r56, r57);
    L88:
        int r58 = r20.baselineToBaseline;
        if (r58 == (-1)) goto L92;
        ConstraintAnchor.Type r59 = ConstraintAnchor.Type.BASELINE;
    L91:
        setWidgetBaseline(r19, r20, r21, r58, r59);
    L99:
        if (r118 < 0.0f) goto L101;
        r19.setHorizontalBiasPercent(r118);
    L101:
        float r60 = r20.verticalBias;
        if (r60 < 0.0f) goto L104;
        r19.setVerticalBiasPercent(r60);
        goto L104
    L92:
        r58 = r20.baselineToTop;
        if (r58 == (-1)) goto L95;
        r59 = ConstraintAnchor.Type.TOP;
        goto L91
    L95:
        r58 = r20.baselineToBottom;
        if (r58 == (-1)) goto L99;
        r59 = ConstraintAnchor.Type.BOTTOM;
        goto L91
    L82:
        int r61 = r20.bottomToBottom;
        if (r61 == (-1)) goto L88;
        r53 = r21.get(r61);
        if (r53 == null) goto L88;
        r55 = ConstraintAnchor.Type.BOTTOM;
        r56 = ((ViewGroup.MarginLayoutParams) r20).bottomMargin;
        r57 = r20.goneBottomMargin;
        r54 = r55;
        goto L87
    L71:
        int r62 = r20.topToBottom;
        if (r62 == (-1)) goto L77;
        r47 = r21.get(r62);
        if (r47 == null) goto L77;
        r51 = ConstraintAnchor.Type.TOP;
        r48 = ConstraintAnchor.Type.BOTTOM;
        r49 = ((ViewGroup.MarginLayoutParams) r20).topMargin;
        r50 = r20.goneTopMargin;
        goto L76
    L61:
        if (r119 == (-1)) goto L66;
        r42 = r21.get(r119);
        if (r42 == null) goto L66;
        r44 = ConstraintAnchor.Type.RIGHT;
        r45 = ((ViewGroup.MarginLayoutParams) r20).rightMargin;
        r43 = r44;
        goto L65
    L52:
        if (r15 == (-1)) goto L57;
        r38 = r21.get(r15);
        if (r38 == null) goto L57;
        r41 = ConstraintAnchor.Type.LEFT;
        r39 = ConstraintAnchor.Type.RIGHT;
        r40 = ((ViewGroup.MarginLayoutParams) r20).leftMargin;
    L41:
        r117 = r28;
        r118 = r112;
        r23 = r27;
        r119 = r26;
        r15 = r24;
    L40:
        r115 = r25;
        goto L41
    L42:
        r117 = r110;
        r118 = r111;
        r115 = r16;
        r119 = r22;
        goto L43
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r21) {
        ArrayList<ConstraintHelper> r10 = this.mConstraintHelpers;
        if (r10 == null) goto L9;
        int r11 = r10.size();
        if (r11 <= 0) goto L9;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L9;
        this.mConstraintHelpers.get(r12).updatePreDraw(this);
        r12 = r12 + 1;
    L9:
        super.dispatchDraw(r21);
        if (isInEditMode() == false) goto L24;
        float r13 = getWidth();
        float r14 = getHeight();
        int r15 = getChildCount();
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L32;
        View r17 = getChildAt(r16);
        if (r17.getVisibility() == 8) goto L23;
        Object r18 = r17.getTag();
        if (r18 == null) goto L23;
        if ((r18 instanceof String) == false) goto L23;
        String[] r19 = ((String) r18).split(",");
        if (r19.length != 4) goto L23;
        int r20 = Integer.parseInt(r19[0]);
        int r110 = Integer.parseInt(r19[1]);
        int r111 = Integer.parseInt(r19[2]);
        int r22 = (int) ((r20 / 1080.0f) * r13);
        int r112 = (int) ((r110 / 1920.0f) * r14);
        int r23 = (int) ((Integer.parseInt(r19[3]) / 1920.0f) * r14);
        Paint r113 = new Paint();
        r113.setColor(-65536);
        float r114 = r22;
        float r115 = r112;
        float r24 = r22 + ((int) ((r111 / 1080.0f) * r13));
        r21.drawLine(r114, r115, r24, r115, r113);
        float r25 = r112 + r23;
        r21.drawLine(r24, r115, r24, r25, r113);
        r21.drawLine(r24, r25, r114, r25, r113);
        r21.drawLine(r114, r25, r114, r115, r113);
        r113.setColor(-16711936);
        r21.drawLine(r114, r115, r24, r25, r113);
        r21.drawLine(r114, r25, r24, r115, r113);
    L23:
        r16 = r16 + 1;
        goto L12
    L32:
        return;
    }

    public void fillMetrics(Metrics r10) {
        this.mMetrics = r10;
        this.mLayoutWidget.fillMetrics(r10);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public Object getDesignInformation(int r10, Object r11) {
        if (r10 == 0) goto L4;
        return null;
    L4:
        if ((r11 instanceof String) == false) goto L13;
        String r12 = (String) r11;
        HashMap<String, Integer> r13 = this.mDesignIds;
        if (r13 != null) goto L8;
        return null;
    L8:
        if (r13.containsKey(r12) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r12);
    L13:
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        StringBuilder r10 = new StringBuilder();
        if (this.mLayoutWidget.stringId != null) goto L9;
        int r11 = getId();
        if (r11 == (-1)) goto L7;
        this.mLayoutWidget.stringId = getContext().getResources().getResourceEntryName(r11);
        goto L9
    L7:
        this.mLayoutWidget.stringId = "parent";
    L9:
        if (this.mLayoutWidget.getDebugName() != null) goto L11;
        ConstraintWidgetContainer r12 = this.mLayoutWidget;
        r12.setDebugName(r12.stringId);
        Log.v(TAG, " setDebugName " + this.mLayoutWidget.getDebugName());
    L11:
        Iterator<ConstraintWidget> r13 = this.mLayoutWidget.getChildren().iterator();
    L13:
        if (r13.hasNext() == false) goto L24;
        ConstraintWidget r14 = r13.next();
        View r15 = (View) r14.getCompanionWidget();
        if (r15 == null) goto L13;
        if (r14.stringId != null) goto L22;
        int r16 = r15.getId();
        if (r16 == (-1)) goto L22;
        r14.stringId = getContext().getResources().getResourceEntryName(r16);
    L22:
        if (r14.getDebugName() != null) goto L13;
        r14.setDebugName(r14.stringId);
        Log.v(TAG, " setDebugName " + r14.getDebugName());
        goto L13
    L24:
        this.mLayoutWidget.getSceneString(r10);
        return r10.toString();
    }

    public View getViewById(int r10) {
        return this.mChildrenByIds.get(r10);
    }

    public final ConstraintWidget getViewWidget(View r10) {
        if (r10 == this) goto L4;
        if (r10 != null) goto L7;
        return null;
    L7:
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        r10.setLayoutParams(generateLayoutParams(r10.getLayoutParams()));
        if ((r10.getLayoutParams() instanceof LayoutParams) == true) goto L9;
        return null;
    L9:
        return ((LayoutParams) r10.getLayoutParams()).widget;
    L4:
        return this.mLayoutWidget;
    }

    protected boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if ((getContext().getApplicationInfo().flags & 4194304) == 0) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L10;
        return false;
    L10:
        if (1 == getLayoutDirection()) goto L12;
        return false;
    L12:
        return true;
    L7:
        r10 = false;
        goto L8
    }

    public void loadLayoutDescription(int r10) {
        if (r10 != 0) goto L9;
    L6:
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r10);     // Catch: Resources.NotFoundException -> L8
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        boolean r16 = isInEditMode();
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L23;
        View r19 = getChildAt(r18);
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        ConstraintWidget r21 = r20.widget;
        if (r19.getVisibility() != 8) goto L15;
        if (r20.isGuideline == true) goto L15;
        if (r20.isHelper == true) goto L15;
        if (r20.isVirtualGroup == true) goto L15;
        if (r16 == true) goto L15;
    L22:
        r18 = r18 + 1;
    L15:
        if (r20.isInPlaceholder == true) goto L22;
        int r22 = r21.getX();
        int r23 = r21.getY();
        int r24 = r21.getWidth() + r22;
        int r25 = r21.getHeight() + r23;
        r19.layout(r22, r23, r24, r25);
        if ((r19 instanceof Placeholder) == false) goto L22;
        View r110 = ((Placeholder) r19).getContent();
        if (r110 == null) goto L22;
        r110.setVisibility(0);
        r110.layout(r22, r23, r24, r25);
        goto L22
    L23:
        int r26 = this.mConstraintHelpers.size();
        if (r26 <= 0) goto L27;
    L25:
        if (r17 >= r26) goto L35;
        this.mConstraintHelpers.get(r17).updatePostLayout(this);
        r17 = r17 + 1;
        goto L25
    L35:
        return;
    }

    @Override // android.view.View
    protected void onMeasure(int r10, int r11) {
        if (this.mOnMeasureWidthMeasureSpec != r10) goto L6;
        int r12 = this.mOnMeasureHeightMeasureSpec;
    L6:
        if (this.mDirtyHierarchy == true) goto L13;
        int r13 = getChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        if (getChildAt(r14).isLayoutRequested() == true) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        this.mDirtyHierarchy = true;
    L13:
        boolean r15 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r10;
        this.mOnMeasureHeightMeasureSpec = r11;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L18;
        this.mLayoutWidget.updateHierarchy();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r10, r11);
        resolveMeasuredDimension(r10, r11, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        super.onViewAdded(r10);
        ConstraintWidget r11 = getViewWidget(r10);
        if ((r10 instanceof Guideline) == false) goto L8;
        if ((r11 instanceof androidx.constraintlayout.core.widgets.Guideline) == true) goto L8;
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        androidx.constraintlayout.core.widgets.Guideline r13 = new androidx.constraintlayout.core.widgets.Guideline();
        r12.widget = r13;
        r12.isGuideline = true;
        r13.setOrientation(r12.orientation);
    L8:
        if ((r10 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r14 = (ConstraintHelper) r10;
        r14.validateParams();
        ((LayoutParams) r10.getLayoutParams()).isHelper = true;
        if (this.mConstraintHelpers.contains(r14) == true) goto L12;
        this.mConstraintHelpers.add(r14);
    L12:
        this.mChildrenByIds.put(r10.getId(), r10);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        this.mChildrenByIds.remove(r10.getId());
        ConstraintWidget r11 = getViewWidget(r10);
        this.mLayoutWidget.remove(r11);
        this.mConstraintHelpers.remove(r10);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int r10) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int r10, int r11, int r12, int r13, boolean r14, boolean r15) {
        Measurer r16 = this.mMeasurer;
        int r17 = r16.paddingHeight;
        int r18 = ViewGroup.resolveSizeAndState(r12 + r16.paddingWidth, r10, 0);
        int r19 = ViewGroup.resolveSizeAndState(r13 + r17, r11, 0);
        int r20 = r18 & ViewCompat.MEASURED_SIZE_MASK;
        int r21 = r19 & ViewCompat.MEASURED_SIZE_MASK;
        int r22 = Math.min(this.mMaxWidth, r20);
        int r23 = Math.min(this.mMaxHeight, r21);
        if (r14 == false) goto L5;
        r22 = r22 | 16777216;
    L5:
        if (r15 == false) goto L7;
        r23 = r23 | 16777216;
    L7:
        setMeasuredDimension(r22, r23);
        this.mLastMeasureWidth = r22;
        this.mLastMeasureHeight = r23;
    }

    protected void resolveSystem(ConstraintWidgetContainer r18, int r19, int r20, int r21) {
        int r10 = View.MeasureSpec.getMode(r20);
        int r11 = View.MeasureSpec.getSize(r20);
        int r12 = View.MeasureSpec.getMode(r21);
        int r13 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r14 = Math.max(0, getPaddingBottom());
        int r15 = r16 + r14;
        int r17 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(r20, r21, r16, r14, r17, r15);
        if (Build.VERSION.SDK_INT < 17) goto L13;
        int r22 = Math.max(0, getPaddingStart());
        int r23 = Math.max(0, getPaddingEnd());
        if (r22 > 0) goto L10;
        if (r23 > 0) goto L10;
        r22 = Math.max(0, getPaddingLeft());
    L12:
        int r24 = r22;
    L14:
        int r110 = r11 - r17;
        int r111 = r13 - r15;
        setSelfDimensionBehaviour(r18, r10, r110, r12, r111);
        r18.measure(r19, r10, r110, r12, r111, this.mLastMeasureWidth, this.mLastMeasureHeight, r24, r16);
        return;
    L10:
        if (isRtl() == false) goto L12;
        r22 = r23;
        goto L12
    L13:
        r24 = Math.max(0, getPaddingLeft());
        goto L14
    }

    public void setConstraintSet(ConstraintSet r10) {
        this.mConstraintSet = r10;
    }

    public void setDesignInformation(int r10, Object r11, Object r12) {
        if (r10 == 0) goto L4;
        return;
    L4:
        if ((r11 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r12 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r13 = (String) r11;
        int r14 = r13.indexOf("/");
        if (r14 == (-1)) goto L13;
        r13 = r13.substring(r14 + 1);
    L13:
        int r15 = ((Integer) r12).intValue();
        this.mDesignIds.put(r13, Integer.valueOf(r15));
    }

    @Override // android.view.View
    public void setId(int r10) {
        this.mChildrenByIds.remove(getId());
        super.setId(r10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r10) {
        if (r10 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r10;
        requestLayout();
    }

    public void setMaxWidth(int r10) {
        if (r10 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r10;
        requestLayout();
    }

    public void setMinHeight(int r10) {
        if (r10 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r10;
        requestLayout();
    }

    public void setMinWidth(int r10) {
        if (r10 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r10;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r10) {
        this.mConstraintsChangedListener = r10;
        ConstraintLayoutStates r11 = this.mConstraintLayoutSpec;
        if (r11 == null) goto L6;
        r11.setOnConstraintsChanged(r10);
        return;
    }

    public void setOptimizationLevel(int r10) {
        this.mOptimizationLevel = r10;
        this.mLayoutWidget.setOptimizationLevel(r10);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer r10, int r11, int r12, int r13, int r14) {
        Measurer r15 = this.mMeasurer;
        int r16 = r15.paddingHeight;
        int r17 = r15.paddingWidth;
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r19 = getChildCount();
        if (r11 == Integer.MIN_VALUE) goto L12;
        if (r11 == 0) goto L9;
        if (r11 == 1073741824) goto L8;
        ConstraintWidget.DimensionBehaviour r20 = r18;
    L7:
        r12 = 0;
    L15:
        if (r13 == Integer.MIN_VALUE) goto L23;
        if (r13 == 0) goto L20;
        if (r13 == 1073741824) goto L19;
    L18:
        r14 = 0;
    L27:
        if (r12 == r10.getWidth()) goto L29;
    L30:
        r10.invalidateMeasures();
    L31:
        r10.setX(0);
        r10.setY(0);
        r10.setMaxWidth(this.mMaxWidth - r17);
        r10.setMaxHeight(this.mMaxHeight - r16);
        r10.setMinWidth(0);
        r10.setMinHeight(0);
        r10.setHorizontalDimensionBehaviour(r20);
        r10.setWidth(r12);
        r10.setVerticalDimensionBehaviour(r18);
        r10.setHeight(r14);
        r10.setMinWidth(this.mMinWidth - r17);
        r10.setMinHeight(this.mMinHeight - r16);
        return;
    L29:
        if (r14 == r10.getHeight()) goto L31;
    L19:
        r14 = Math.min(this.mMaxHeight - r16, r14);
        goto L27
    L20:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L18;
    L25:
        r14 = Math.max(0, this.mMinHeight);
        goto L27
    L23:
        r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L27;
    L8:
        r12 = Math.min(this.mMaxWidth - r17, r12);
        r20 = r18;
        goto L15
    L9:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L7;
    L14:
        r12 = Math.max(0, this.mMinWidth);
        goto L15
    L12:
        r20 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != 0) goto L15;
        goto L14
    }

    public void setState(int r10, int r11, int r12) {
        ConstraintLayoutStates r13 = this.mConstraintLayoutSpec;
        if (r13 == null) goto L6;
        r13.updateConstraints(r10, r11, r12);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
