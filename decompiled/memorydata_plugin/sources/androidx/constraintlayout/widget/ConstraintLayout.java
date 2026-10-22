package androidx.constraintlayout.widget;

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
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            int[] r0 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour = r0;
            r0[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
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
                SparseIntArray r0 = new SparseIntArray();
                map = r0;
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, "styleable", "ConstraintLayout_Layout_layout_constraintWidth"), 64);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, "styleable", "ConstraintLayout_Layout_layout_constraintHeight"), 65);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toLeftOf"), 8);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_toRightOf"), 9);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toLeftOf"), 10);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, "styleable", "ConstraintLayout_Layout_layout_constraintRight_toRightOf"), 11);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toTopOf"), 12);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintTop_toBottomOf"), 13);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toTopOf"), 14);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_toBottomOf"), 15);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf"), 16);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toTopOf"), 52);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf"), 53);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, "styleable", "ConstraintLayout_Layout_layout_constraintCircle"), 2);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, "styleable", "ConstraintLayout_Layout_layout_constraintCircleRadius"), 3);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, "styleable", "ConstraintLayout_Layout_layout_constraintCircleAngle"), 4);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteX"), 49);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, "styleable", "ConstraintLayout_Layout_layout_editor_absoluteY"), 50);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_begin"), 5);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_end"), 6);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, "styleable", "ConstraintLayout_Layout_layout_constraintGuide_percent"), 7);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, "styleable", "ConstraintLayout_Layout_guidelineUseRtl"), 67);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_orientation, "styleable", "ConstraintLayout_Layout_android_orientation"), 1);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toEndOf"), 17);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintStart_toStartOf"), 18);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toStartOf"), 19);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, "styleable", "ConstraintLayout_Layout_layout_constraintEnd_toEndOf"), 20);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, "styleable", "ConstraintLayout_Layout_layout_goneMarginLeft"), 21);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, "styleable", "ConstraintLayout_Layout_layout_goneMarginTop"), 22);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, "styleable", "ConstraintLayout_Layout_layout_goneMarginRight"), 23);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, "styleable", "ConstraintLayout_Layout_layout_goneMarginBottom"), 24);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, "styleable", "ConstraintLayout_Layout_layout_goneMarginStart"), 25);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, "styleable", "ConstraintLayout_Layout_layout_goneMarginEnd"), 26);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, "styleable", "ConstraintLayout_Layout_layout_goneMarginBaseline"), 55);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, "styleable", "ConstraintLayout_Layout_layout_marginBaseline"), 54);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_bias"), 29);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_bias"), 30);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, "styleable", "ConstraintLayout_Layout_layout_constraintDimensionRatio"), 44);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_weight"), 45);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_weight"), 46);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle"), 47);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, "styleable", "ConstraintLayout_Layout_layout_constraintVertical_chainStyle"), 48);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, "styleable", "ConstraintLayout_Layout_layout_constrainedWidth"), 27);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, "styleable", "ConstraintLayout_Layout_layout_constrainedHeight"), 28);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_default"), 31);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_default"), 32);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_min"), 33);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_max"), 34);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, "styleable", "ConstraintLayout_Layout_layout_constraintWidth_percent"), 35);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_min"), 36);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_max"), 37);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, "styleable", "ConstraintLayout_Layout_layout_constraintHeight_percent"), 38);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, "styleable", "ConstraintLayout_Layout_layout_constraintLeft_creator"), 39);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, "styleable", "ConstraintLayout_Layout_layout_constraintTop_creator"), 40);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, "styleable", "ConstraintLayout_Layout_layout_constraintRight_creator"), 41);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBottom_creator"), 42);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, "styleable", "ConstraintLayout_Layout_layout_constraintBaseline_creator"), 43);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_constraintTag, "styleable", "ConstraintLayout_Layout_layout_constraintTag"), 51);
                r0.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, "styleable", "ConstraintLayout_Layout_layout_wrapBehaviorInParent"), 66);
            }

            private Table() {
            }
        }

        public LayoutParams(int r7, int r8) {
            super(r7, r8);
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
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r13, r14);
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
            TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.ConstraintLayout_Layout);
            int r16 = r15.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r16) goto L119;
            int r5 = r15.getIndex(r1);
            int r6 = Table.map.get(r5);
            switch(r6) {
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
            switch(r6) {
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
            switch(r6) {
                case 64: goto L12;
                case 65: goto L11;
                case 66: goto L10;
                case 67: goto L9;
                default: goto L118;
            };
        L9:
            this.guidelineUseRtl = r15.getBoolean(r5, this.guidelineUseRtl);
            goto L118
        L10:
            this.wrapBehaviorInParent = r15.getInt(r5, this.wrapBehaviorInParent);
            goto L118
        L11:
            ConstraintSet.parseDimensionConstraints(this, r15, r5, 1);
            this.heightSet = true;
            goto L118
        L12:
            ConstraintSet.parseDimensionConstraints(this, r15, r5, 0);
            this.widthSet = true;
        L118:
            r1 = r1 + 1;
            goto L3
        L13:
            this.goneBaselineMargin = r15.getDimensionPixelSize(r5, this.goneBaselineMargin);
            goto L118
        L14:
            this.baselineMargin = r15.getDimensionPixelSize(r5, this.baselineMargin);
            goto L118
        L15:
            int r7 = r15.getResourceId(r5, this.baselineToBottom);
            this.baselineToBottom = r7;
            if (r7 != (-1)) goto L118;
            this.baselineToBottom = r15.getInt(r5, -1);
            goto L118
        L18:
            int r8 = r15.getResourceId(r5, this.baselineToTop);
            this.baselineToTop = r8;
            if (r8 != (-1)) goto L118;
            this.baselineToTop = r15.getInt(r5, -1);
            goto L118
        L21:
            this.constraintTag = r15.getString(r5);
            goto L118
        L22:
            this.editorAbsoluteY = r15.getDimensionPixelOffset(r5, this.editorAbsoluteY);
            goto L118
        L23:
            this.editorAbsoluteX = r15.getDimensionPixelOffset(r5, this.editorAbsoluteX);
            goto L118
        L24:
            this.verticalChainStyle = r15.getInt(r5, 0);
            goto L118
        L25:
            this.horizontalChainStyle = r15.getInt(r5, 0);
            goto L118
        L26:
            this.verticalWeight = r15.getFloat(r5, this.verticalWeight);
            goto L118
        L27:
            this.horizontalWeight = r15.getFloat(r5, this.horizontalWeight);
            goto L118
        L28:
            ConstraintSet.parseDimensionRatioString(this, r15.getString(r5));
            goto L118
        L29:
            this.matchConstraintPercentHeight = Math.max(0.0f, r15.getFloat(r5, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L118
        L40:
            this.matchConstraintPercentWidth = Math.max(0.0f, r15.getFloat(r5, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L118
        L51:
            int r9 = r15.getInt(r5, 0);
            this.matchConstraintDefaultHeight = r9;
            if (r9 != 1) goto L118;
            String r10 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.";
        L57:
            Log.e(ConstraintLayout.TAG, r10);
            goto L118
        L54:
            int r17 = r15.getInt(r5, 0);
            this.matchConstraintDefaultWidth = r17;
            if (r17 != 1) goto L118;
            r10 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.";
            goto L57
        L58:
            this.verticalBias = r15.getFloat(r5, this.verticalBias);
            goto L118
        L59:
            this.horizontalBias = r15.getFloat(r5, this.horizontalBias);
            goto L118
        L60:
            this.constrainedHeight = r15.getBoolean(r5, this.constrainedHeight);
            goto L118
        L61:
            this.constrainedWidth = r15.getBoolean(r5, this.constrainedWidth);
            goto L118
        L62:
            this.goneEndMargin = r15.getDimensionPixelSize(r5, this.goneEndMargin);
            goto L118
        L63:
            this.goneStartMargin = r15.getDimensionPixelSize(r5, this.goneStartMargin);
            goto L118
        L64:
            this.goneBottomMargin = r15.getDimensionPixelSize(r5, this.goneBottomMargin);
            goto L118
        L65:
            this.goneRightMargin = r15.getDimensionPixelSize(r5, this.goneRightMargin);
            goto L118
        L66:
            this.goneTopMargin = r15.getDimensionPixelSize(r5, this.goneTopMargin);
            goto L118
        L67:
            this.goneLeftMargin = r15.getDimensionPixelSize(r5, this.goneLeftMargin);
            goto L118
        L68:
            int r18 = r15.getResourceId(r5, this.endToEnd);
            this.endToEnd = r18;
            if (r18 != (-1)) goto L118;
            this.endToEnd = r15.getInt(r5, -1);
            goto L118
        L71:
            int r19 = r15.getResourceId(r5, this.endToStart);
            this.endToStart = r19;
            if (r19 != (-1)) goto L118;
            this.endToStart = r15.getInt(r5, -1);
            goto L118
        L74:
            int r20 = r15.getResourceId(r5, this.startToStart);
            this.startToStart = r20;
            if (r20 != (-1)) goto L118;
            this.startToStart = r15.getInt(r5, -1);
            goto L118
        L77:
            int r21 = r15.getResourceId(r5, this.startToEnd);
            this.startToEnd = r21;
            if (r21 != (-1)) goto L118;
            this.startToEnd = r15.getInt(r5, -1);
            goto L118
        L80:
            int r22 = r15.getResourceId(r5, this.baselineToBaseline);
            this.baselineToBaseline = r22;
            if (r22 != (-1)) goto L118;
            this.baselineToBaseline = r15.getInt(r5, -1);
            goto L118
        L83:
            int r23 = r15.getResourceId(r5, this.bottomToBottom);
            this.bottomToBottom = r23;
            if (r23 != (-1)) goto L118;
            this.bottomToBottom = r15.getInt(r5, -1);
            goto L118
        L86:
            int r24 = r15.getResourceId(r5, this.bottomToTop);
            this.bottomToTop = r24;
            if (r24 != (-1)) goto L118;
            this.bottomToTop = r15.getInt(r5, -1);
            goto L118
        L89:
            int r25 = r15.getResourceId(r5, this.topToBottom);
            this.topToBottom = r25;
            if (r25 != (-1)) goto L118;
            this.topToBottom = r15.getInt(r5, -1);
            goto L118
        L92:
            int r26 = r15.getResourceId(r5, this.topToTop);
            this.topToTop = r26;
            if (r26 != (-1)) goto L118;
            this.topToTop = r15.getInt(r5, -1);
            goto L118
        L95:
            int r27 = r15.getResourceId(r5, this.rightToRight);
            this.rightToRight = r27;
            if (r27 != (-1)) goto L118;
            this.rightToRight = r15.getInt(r5, -1);
            goto L118
        L98:
            int r28 = r15.getResourceId(r5, this.rightToLeft);
            this.rightToLeft = r28;
            if (r28 != (-1)) goto L118;
            this.rightToLeft = r15.getInt(r5, -1);
            goto L118
        L101:
            int r29 = r15.getResourceId(r5, this.leftToRight);
            this.leftToRight = r29;
            if (r29 != (-1)) goto L118;
            this.leftToRight = r15.getInt(r5, -1);
            goto L118
        L104:
            int r30 = r15.getResourceId(r5, this.leftToLeft);
            this.leftToLeft = r30;
            if (r30 != (-1)) goto L118;
            this.leftToLeft = r15.getInt(r5, -1);
            goto L118
        L107:
            this.guidePercent = r15.getFloat(r5, this.guidePercent);
            goto L118
        L108:
            this.guideEnd = r15.getDimensionPixelOffset(r5, this.guideEnd);
            goto L118
        L109:
            this.guideBegin = r15.getDimensionPixelOffset(r5, this.guideBegin);
            goto L118
        L110:
            float r31 = r15.getFloat(r5, this.circleAngle) % 360.0f;
            this.circleAngle = r31;
            if (r31 >= 0.0f) goto L118;
            this.circleAngle = (360.0f - r31) % 360.0f;
            goto L118
        L113:
            this.circleRadius = r15.getDimensionPixelSize(r5, this.circleRadius);
            goto L118
        L114:
            int r32 = r15.getResourceId(r5, this.circleConstraint);
            this.circleConstraint = r32;
            if (r32 != (-1)) goto L118;
            this.circleConstraint = r15.getInt(r5, -1);
            goto L118
        L117:
            this.orientation = r15.getInt(r5, this.orientation);
            goto L118
        L121:
            this.matchConstraintMinHeight = r15.getDimensionPixelSize(r5, this.matchConstraintMinHeight);     // Catch: Exception -> L37
        L38:
            if (r15.getInt(r5, this.matchConstraintMinHeight) != (-2)) goto L118;
            this.matchConstraintMinHeight = -2;
            goto L118
        L123:
            this.matchConstraintMinWidth = r15.getDimensionPixelSize(r5, this.matchConstraintMinWidth);     // Catch: Exception -> L48
        L49:
            if (r15.getInt(r5, this.matchConstraintMinWidth) != (-2)) goto L118;
            this.matchConstraintMinWidth = -2;
            goto L118
        L125:
            this.matchConstraintMaxHeight = r15.getDimensionPixelSize(r5, this.matchConstraintMaxHeight);     // Catch: Exception -> L32
        L33:
            if (r15.getInt(r5, this.matchConstraintMaxHeight) != (-2)) goto L118;
            this.matchConstraintMaxHeight = -2;
            goto L118
        L127:
            this.matchConstraintMaxWidth = r15.getDimensionPixelSize(r5, this.matchConstraintMaxWidth);     // Catch: Exception -> L43
        L44:
            if (r15.getInt(r5, this.matchConstraintMaxWidth) != (-2)) goto L118;
            this.matchConstraintMaxWidth = -2;
            goto L118
        L119:
            r15.recycle();
            validate();
        }

        public LayoutParams(ViewGroup.LayoutParams r8) {
            super(r8);
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

        public LayoutParams(LayoutParams r9) {
            super(r9);
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
            this.guideBegin = r9.guideBegin;
            this.guideEnd = r9.guideEnd;
            this.guidePercent = r9.guidePercent;
            this.guidelineUseRtl = r9.guidelineUseRtl;
            this.leftToLeft = r9.leftToLeft;
            this.leftToRight = r9.leftToRight;
            this.rightToLeft = r9.rightToLeft;
            this.rightToRight = r9.rightToRight;
            this.topToTop = r9.topToTop;
            this.topToBottom = r9.topToBottom;
            this.bottomToTop = r9.bottomToTop;
            this.bottomToBottom = r9.bottomToBottom;
            this.baselineToBaseline = r9.baselineToBaseline;
            this.baselineToTop = r9.baselineToTop;
            this.baselineToBottom = r9.baselineToBottom;
            this.circleConstraint = r9.circleConstraint;
            this.circleRadius = r9.circleRadius;
            this.circleAngle = r9.circleAngle;
            this.startToEnd = r9.startToEnd;
            this.startToStart = r9.startToStart;
            this.endToStart = r9.endToStart;
            this.endToEnd = r9.endToEnd;
            this.goneLeftMargin = r9.goneLeftMargin;
            this.goneTopMargin = r9.goneTopMargin;
            this.goneRightMargin = r9.goneRightMargin;
            this.goneBottomMargin = r9.goneBottomMargin;
            this.goneStartMargin = r9.goneStartMargin;
            this.goneEndMargin = r9.goneEndMargin;
            this.goneBaselineMargin = r9.goneBaselineMargin;
            this.baselineMargin = r9.baselineMargin;
            this.horizontalBias = r9.horizontalBias;
            this.verticalBias = r9.verticalBias;
            this.dimensionRatio = r9.dimensionRatio;
            this.dimensionRatioValue = r9.dimensionRatioValue;
            this.dimensionRatioSide = r9.dimensionRatioSide;
            this.horizontalWeight = r9.horizontalWeight;
            this.verticalWeight = r9.verticalWeight;
            this.horizontalChainStyle = r9.horizontalChainStyle;
            this.verticalChainStyle = r9.verticalChainStyle;
            this.constrainedWidth = r9.constrainedWidth;
            this.constrainedHeight = r9.constrainedHeight;
            this.matchConstraintDefaultWidth = r9.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = r9.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = r9.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = r9.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = r9.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = r9.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = r9.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = r9.matchConstraintPercentHeight;
            this.editorAbsoluteX = r9.editorAbsoluteX;
            this.editorAbsoluteY = r9.editorAbsoluteY;
            this.orientation = r9.orientation;
            this.horizontalDimensionFixed = r9.horizontalDimensionFixed;
            this.verticalDimensionFixed = r9.verticalDimensionFixed;
            this.needsBaseline = r9.needsBaseline;
            this.isGuideline = r9.isGuideline;
            this.resolvedLeftToLeft = r9.resolvedLeftToLeft;
            this.resolvedLeftToRight = r9.resolvedLeftToRight;
            this.resolvedRightToLeft = r9.resolvedRightToLeft;
            this.resolvedRightToRight = r9.resolvedRightToRight;
            this.resolveGoneLeftMargin = r9.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = r9.resolveGoneRightMargin;
            this.resolvedHorizontalBias = r9.resolvedHorizontalBias;
            this.constraintTag = r9.constraintTag;
            this.wrapBehaviorInParent = r9.wrapBehaviorInParent;
            this.widget = r9.widget;
            this.widthSet = r9.widthSet;
            this.heightSet = r9.heightSet;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget r0 = this.widget;
            if (r0 == null) goto L6;
            r0.reset();
            return;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        public void resolveLayoutDirection(int r11) {
            int r0 = this.leftMargin;
            int r1 = this.rightMargin;
            boolean r3 = false;
            if (Build.VERSION.SDK_INT < 17) goto L7;
            super.resolveLayoutDirection(r11);
            if (1 != getLayoutDirection()) goto L7;
            boolean r12 = true;
        L8:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r5 = this.horizontalBias;
            this.resolvedHorizontalBias = r5;
            int r6 = this.guideBegin;
            this.resolvedGuideBegin = r6;
            int r7 = this.guideEnd;
            this.resolvedGuideEnd = r7;
            float r8 = this.guidePercent;
            this.resolvedGuidePercent = r8;
            if (r12 == false) goto L46;
            int r13 = this.startToEnd;
            if (r13 == (-1)) goto L14;
            this.resolvedRightToLeft = r13;
        L13:
            r3 = true;
        L17:
            int r14 = this.endToStart;
            if (r14 == (-1)) goto L20;
            this.resolvedLeftToRight = r14;
            r3 = true;
        L20:
            int r15 = this.endToEnd;
            if (r15 == (-1)) goto L23;
            this.resolvedLeftToLeft = r15;
            r3 = true;
        L23:
            int r16 = this.goneStartMargin;
            if (r16 == Integer.MIN_VALUE) goto L26;
            this.resolveGoneRightMargin = r16;
        L26:
            int r17 = this.goneEndMargin;
            if (r17 == Integer.MIN_VALUE) goto L30;
            this.resolveGoneLeftMargin = r17;
        L30:
            if (r3 == false) goto L33;
            this.resolvedHorizontalBias = 1.0f - r5;
        L33:
            if (this.isGuideline == false) goto L65;
            if (this.orientation != 1) goto L65;
            if (this.guidelineUseRtl == false) goto L65;
            if (r8 == (-1.0f)) goto L41;
            this.resolvedGuidePercent = 1.0f - r8;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L65
        L41:
            if (r6 == (-1)) goto L44;
            this.resolvedGuideEnd = r6;
            this.resolvedGuideBegin = -1;
        L43:
            this.resolvedGuidePercent = -1.0f;
            goto L65
        L44:
            if (r7 == (-1)) goto L65;
            this.resolvedGuideBegin = r7;
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
            int r18 = this.rightToLeft;
            if (r18 == (-1)) goto L78;
            this.resolvedRightToLeft = r18;
            if (this.rightMargin > 0) goto L84;
            if (r1 <= 0) goto L84;
        L77:
            this.rightMargin = r1;
        L84:
            int r19 = this.leftToLeft;
            if (r19 == (-1)) goto L90;
            this.resolvedLeftToLeft = r19;
            if (this.leftMargin > 0) goto L100;
            if (r0 <= 0) goto L101;
        L89:
            this.leftMargin = r0;
            return;
        L101:
            return;
        L100:
            return;
        L90:
            int r110 = this.leftToRight;
            if (r110 == (-1)) goto L103;
            this.resolvedLeftToRight = r110;
            if (this.leftMargin > 0) goto L104;
            if (r0 > 0) goto L89;
            return;
        L104:
            return;
        L103:
            return;
        L78:
            int r111 = this.rightToRight;
            if (r111 == (-1)) goto L84;
            this.resolvedRightToRight = r111;
            if (this.rightMargin > 0) goto L84;
            if (r1 <= 0) goto L84;
        L99:
            return;
        L14:
            int r112 = this.startToStart;
            if (r112 == (-1)) goto L17;
            this.resolvedRightToRight = r112;
            goto L13
        L46:
            int r113 = this.startToEnd;
            if (r113 == (-1)) goto L49;
            this.resolvedLeftToRight = r113;
        L49:
            int r114 = this.startToStart;
            if (r114 == (-1)) goto L52;
            this.resolvedLeftToLeft = r114;
        L52:
            int r115 = this.endToStart;
            if (r115 == (-1)) goto L55;
            this.resolvedRightToLeft = r115;
        L55:
            int r116 = this.endToEnd;
            if (r116 == (-1)) goto L58;
            this.resolvedRightToRight = r116;
        L58:
            int r117 = this.goneStartMargin;
            if (r117 == Integer.MIN_VALUE) goto L61;
            this.resolveGoneLeftMargin = r117;
        L61:
            int r118 = this.goneEndMargin;
            if (r118 == Integer.MIN_VALUE) goto L65;
            this.resolveGoneRightMargin = r118;
        L7:
            r12 = false;
            goto L8
        }

        public void setWidgetDebugName(String r1) {
            this.widget.setDebugName(r1);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (this.width != (-2)) goto L10;
            if (this.constrainedWidth == false) goto L10;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L10;
            this.matchConstraintDefaultWidth = 1;
        L10:
            if (this.height != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (this.width != 0) goto L19;
        L20:
            this.horizontalDimensionFixed = false;
            if (this.width == 0) goto L23;
        L26:
            if (this.height != 0) goto L28;
        L29:
            this.verticalDimensionFixed = false;
            if (this.height == 0) goto L32;
        L35:
            if (this.guidePercent == (-1.0f)) goto L37;
        L40:
            this.isGuideline = true;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            if (ZeusTransformUtils.instanceOf(this.widget, androidx.constraintlayout.core.widgets.Guideline.class) == true) goto L43;
            this.widget = new androidx.constraintlayout.core.widgets.Guideline();
        L43:
            ((androidx.constraintlayout.core.widgets.Guideline) ZeusTransformUtils.preCheckCast(this.widget, androidx.constraintlayout.core.widgets.Guideline.class, "com.obric.memorydata.plugin")).setOrientation(this.orientation);
            return;
        L37:
            if (this.guideBegin != (-1)) goto L40;
            if (this.guideEnd != (-1)) goto L40;
            return;
        L32:
            if (this.matchConstraintDefaultHeight != 1) goto L35;
            this.height = -2;
            this.constrainedHeight = true;
            goto L35
        L28:
            if (this.height != (-1)) goto L35;
        L23:
            if (this.matchConstraintDefaultWidth != 1) goto L26;
            this.width = -2;
            this.constrainedWidth = true;
            goto L26
        L19:
            if (this.width != (-1)) goto L26;
            goto L20
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

        public Measurer(ConstraintLayout r1, ConstraintLayout r2) {
            this.this$0 = r1;
            this.layout = r2;
        }

        private boolean isSimilarSpec(int r3, int r4, int r5) {
            if (r3 != r4) goto L5;
            return true;
        L5:
            int r0 = View.MeasureSpec.getMode(r3);
            View.MeasureSpec.getSize(r3);
            int r6 = View.MeasureSpec.getMode(r4);
            int r7 = View.MeasureSpec.getSize(r4);
            if (r6 == 1073741824) goto L8;
            return false;
        L8:
            if (r0 == Integer.MIN_VALUE) goto L10;
            if (r0 == 0) goto L10;
            return false;
        L10:
            if (r5 != r7) goto L15;
            return true;
        L15:
            return false;
        }

        public void captureLayoutInfo(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.paddingTop = r3;
            this.paddingBottom = r4;
            this.paddingWidth = r5;
            this.paddingHeight = r6;
            this.layoutWidthSpec = r1;
            this.layoutHeightSpec = r2;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r0 = this.layout.getChildCount();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L9;
            View r4 = this.layout.getChildAt(r2);
            if (ZeusTransformUtils.instanceOf(r4, Placeholder.class) == false) goto L8;
            ((Placeholder) ZeusTransformUtils.preCheckCast(r4, Placeholder.class, "com.obric.memorydata.plugin")).updatePostMeasure(this.layout);
        L8:
            r2 = r2 + 1;
            goto L4
        L9:
            int r3 = ConstraintLayout.access$100(this.layout).size();
            if (r3 <= 0) goto L13;
        L11:
            if (r1 >= r3) goto L18;
            ((ConstraintHelper) ZeusTransformUtils.preCheckCast(ConstraintLayout.access$100(this.layout).get(r1), ConstraintHelper.class, "com.obric.memorydata.plugin")).updatePostMeasure(this.layout);
            r1 = r1 + 1;
            goto L11
        L18:
            return;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
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
            ConstraintWidget.DimensionBehaviour r3 = r19.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r4 = r19.verticalBehavior;
            int r6 = r19.horizontalDimension;
            int r7 = r19.verticalDimension;
            int r8 = this.paddingTop + this.paddingBottom;
            int r9 = this.paddingWidth;
            View r10 = (View) ZeusTransformUtils.preCheckCast(r18.getCompanionWidget(), View.class, "com.obric.memorydata.plugin");
            int r11 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r3.ordinal()];
            if (r11 == 1) goto L49;
            if (r11 == 2) goto L47;
            if (r11 == 3) goto L46;
            if (r11 == 4) goto L20;
            int r12 = 0;
        L50:
            int r13 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour[r4.ordinal()];
            if (r13 == 1) goto L87;
            if (r13 != 2) goto L54;
            int r14 = this.layoutHeightSpec;
            int r15 = -2;
        L86:
            int r16 = ViewGroup.getChildMeasureSpec(r14, r8, r15);
        L88:
            ConstraintWidgetContainer r17 = (ConstraintWidgetContainer) ZeusTransformUtils.preCheckCast(r18.getParent(), ConstraintWidgetContainer.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L114;
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L114;
            if (r10.getMeasuredWidth() != r18.getWidth()) goto L114;
            if (r10.getMeasuredWidth() >= r17.getWidth()) goto L114;
            if (r10.getMeasuredHeight() != r18.getHeight()) goto L114;
            if (r10.getMeasuredHeight() >= r17.getHeight()) goto L114;
            if (r10.getBaseline() != r18.getBaselineDistance()) goto L114;
            if (r18.isMeasureRequested() == true) goto L114;
            if (isSimilarSpec(r18.getLastHorizontalMeasureSpec(), r12, r18.getWidth()) == true) goto L107;
        L109:
            boolean r20 = false;
        L110:
            if (r20 == false) goto L114;
            r19.measuredWidth = r18.getWidth();
            r19.measuredHeight = r18.getHeight();
            r19.measuredBaseline = r18.getBaselineDistance();
            return;
        L107:
            if (isSimilarSpec(r18.getLastVerticalMeasureSpec(), r16, r18.getHeight()) == false) goto L109;
            r20 = true;
        L114:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L116;
            boolean r21 = true;
        L118:
            if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L120;
            boolean r22 = true;
        L122:
            if (r4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L124;
        L127:
            boolean r5 = true;
        L129:
            if (r3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L131;
        L134:
            boolean r23 = true;
        L136:
            if (r21 == true) goto L138;
        L140:
            boolean r110 = false;
        L141:
            if (r22 == true) goto L143;
        L145:
            boolean r111 = false;
        L146:
            if (r10 != null) goto L148;
            return;
        L148:
            LayoutParams r112 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
            if (r19.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L161;
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L161;
            if (r21 == false) goto L161;
            if (r18.mMatchConstraintDefaultWidth != 0) goto L161;
            if (r22 == false) goto L161;
            if (r18.mMatchConstraintDefaultHeight != 0) goto L161;
            int r0 = -1;
            int r24 = 0;
            int r113 = 0;
            int r114 = 0;
        L200:
            if (r24 == r0) goto L202;
            boolean r25 = true;
        L204:
            if (r113 == r19.horizontalDimension) goto L206;
        L209:
            boolean r26 = true;
        L210:
            r19.measuredNeedsSolverPass = r26;
            if (r112.needsBaseline == false) goto L213;
            r25 = true;
        L213:
            if (r25 == true) goto L215;
        L219:
            r19.measuredWidth = r113;
            r19.measuredHeight = r114;
            r19.measuredHasBaseline = r25;
            r19.measuredBaseline = r24;
            return;
        L215:
            if (r24 == (-1)) goto L219;
            if (r18.getBaselineDistance() == r24) goto L219;
            r19.measuredNeedsSolverPass = true;
            goto L219
        L206:
            if (r114 != r19.verticalDimension) goto L209;
            r26 = false;
            goto L210
        L202:
            r25 = false;
        L161:
            if (ZeusTransformUtils.instanceOf(r10, VirtualLayout.class) == true) goto L163;
        L165:
            r10.measure(r12, r16);
        L166:
            r18.setLastMeasureSpec(r12, r16);
            int r27 = r10.getMeasuredWidth();
            int r28 = r10.getMeasuredHeight();
            r24 = r10.getBaseline();
            if (r18.mMatchConstraintMinWidth <= 0) goto L169;
            r113 = Math.max(r18.mMatchConstraintMinWidth, r27);
        L171:
            if (r18.mMatchConstraintMaxWidth <= 0) goto L174;
            r113 = Math.min(r18.mMatchConstraintMaxWidth, r113);
        L174:
            if (r18.mMatchConstraintMinHeight <= 0) goto L176;
            r114 = Math.max(r18.mMatchConstraintMinHeight, r28);
        L178:
            if (r18.mMatchConstraintMaxHeight <= 0) goto L181;
            r114 = Math.min(r18.mMatchConstraintMaxHeight, r114);
        L181:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L183;
        L189:
            if (r27 != r113) goto L194;
            if (r28 != r114) goto L194;
        L192:
            r0 = -1;
        L194:
            if (r27 == r113) goto L196;
            int r29 = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        L197:
            if (r28 == r114) goto L199;
            r16 = View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        L199:
            r10.measure(r29, r16);
            r18.setLastMeasureSpec(r29, r16);
            r113 = r10.getMeasuredWidth();
            r114 = r10.getMeasuredHeight();
            r24 = r10.getBaseline();
            goto L192
        L196:
            r29 = r12;
            goto L197
        L183:
            if (r110 == false) goto L186;
            if (r5 == false) goto L186;
            r113 = (int) ((r114 * r18.mDimensionRatio) + 0.5f);
        L186:
            if (r111 == false) goto L189;
            if (r23 == false) goto L189;
            r114 = (int) ((r113 / r18.mDimensionRatio) + 0.5f);
            goto L189
        L176:
            r114 = r28;
            goto L178
        L169:
            r113 = r27;
            goto L171
        L163:
            if (ZeusTransformUtils.instanceOf(r18, androidx.constraintlayout.core.widgets.VirtualLayout.class) == false) goto L165;
            ((VirtualLayout) ZeusTransformUtils.preCheckCast(r10, VirtualLayout.class, "com.obric.memorydata.plugin")).onMeasure((androidx.constraintlayout.core.widgets.VirtualLayout) ZeusTransformUtils.preCheckCast(r18, androidx.constraintlayout.core.widgets.VirtualLayout.class, "com.obric.memorydata.plugin"), r12, r16);
            goto L166
        L143:
            if (r18.mDimensionRatio <= 0.0f) goto L145;
            r111 = true;
            goto L146
        L138:
            if (r18.mDimensionRatio <= 0.0f) goto L140;
            r110 = true;
            goto L141
        L131:
            if (r3 == ConstraintWidget.DimensionBehaviour.FIXED) goto L134;
            r23 = false;
            goto L136
        L124:
            if (r4 == ConstraintWidget.DimensionBehaviour.FIXED) goto L127;
            r5 = false;
            goto L129
        L120:
            r22 = false;
            goto L122
        L116:
            r21 = false;
            goto L118
        L54:
            if (r13 != 3) goto L56;
            r14 = this.layoutHeightSpec;
            r8 = r8 + r18.getVerticalMargin();
            r15 = -1;
            goto L86
        L56:
            if (r13 == 4) goto L58;
            r16 = 0;
            goto L88
        L58:
            r16 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r8, -2);
            if (r18.mMatchConstraintDefaultHeight != 1) goto L61;
            boolean r30 = true;
        L63:
            if (r19.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L67;
            if (r19.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L88;
        L67:
            if (r10.getMeasuredWidth() != r18.getWidth()) goto L69;
            boolean r31 = true;
        L71:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L81;
            if (r30 == false) goto L81;
            if (r30 == false) goto L76;
            if (r31 == true) goto L81;
        L76:
            if (ZeusTransformUtils.instanceOf(r10, Placeholder.class) == true) goto L81;
            if (r18.isResolvedVertically() == true) goto L81;
            boolean r32 = false;
        L82:
            if (r32 == false) goto L88;
            r7 = r18.getHeight();
        L81:
            r32 = true;
            goto L82
        L69:
            r31 = false;
            goto L71
        L61:
            r30 = false;
        L87:
            r16 = View.MeasureSpec.makeMeasureSpec(r7, 1073741824);
            goto L88
        L20:
            r12 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r9, -2);
            if (r18.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r33 = true;
        L25:
            if (r19.measureStrategy == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (r19.measureStrategy != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L50;
        L29:
            if (r10.getMeasuredHeight() != r18.getHeight()) goto L31;
            boolean r115 = true;
        L33:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L43;
            if (r33 == false) goto L43;
            if (r33 == false) goto L38;
            if (r115 == true) goto L43;
        L38:
            if (ZeusTransformUtils.instanceOf(r10, Placeholder.class) == true) goto L43;
            if (r18.isResolvedHorizontally() == true) goto L43;
            boolean r34 = false;
        L44:
            if (r34 == false) goto L50;
            r6 = r18.getWidth();
        L43:
            r34 = true;
            goto L44
        L31:
            r115 = false;
            goto L33
        L23:
            r33 = false;
            goto L25
        L46:
            int r35 = this.layoutWidthSpec;
            r9 = r9 + r18.getHorizontalMargin();
            int r116 = -1;
        L48:
            r12 = ViewGroup.getChildMeasureSpec(r35, r9, r116);
            goto L50
        L47:
            r35 = this.layoutWidthSpec;
            r116 = -2;
        L49:
            r12 = View.MeasureSpec.makeMeasureSpec(r6, 1073741824);
            goto L50
        }
    }

    static {
    }

    public ConstraintLayout(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
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

    public ConstraintLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r5, r6);
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
        init(r6, 0, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
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
        init(r7, r5, 0);
    }

    public ConstraintLayout(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8, r5, r6);
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
        init(r8, r5, r6);
    }

    static /* synthetic */ int access$000(ConstraintLayout r0) {
        return r0.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout r0) {
        return r0.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int r1 = 0;
        int r0 = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT < 17) goto L5;
        r1 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
    L5:
        if (r1 > 0) goto L7;
        return r0;
    L7:
        return r1;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues != null) goto L6;
        sSharedValues = new SharedValues();
    L6:
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int r4) {
        if (r4 == 0) goto L4;
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r4), View.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L13;
        r0 = findViewById(r4);
        if (r0 == null) goto L13;
        if (r0 == this) goto L13;
        if (r0.getParent() != this) goto L13;
        onViewAdded(r0);
    L13:
        if (r0 == this) goto L15;
        if (r0 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).widget;
    L15:
        return this.mLayoutWidget;
    L4:
        return this.mLayoutWidget;
    }

    private void init(AttributeSet r8, int r9, int r10) {
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.memorydata.plugin");
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (r11 == null) goto L37;
        TypedArray r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes(r11, R.styleable.ConstraintLayout_Layout, r9, r10);
        int r13 = r12.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r13) goto L36;
        int r3 = r12.getIndex(r2);
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minWidth, "styleable", "ConstraintLayout_Layout_android_minWidth")) goto L10;
        this.mMinWidth = r12.getDimensionPixelOffset(r3, this.mMinWidth);
    L35:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_minHeight, "styleable", "ConstraintLayout_Layout_android_minHeight")) goto L13;
        this.mMinHeight = r12.getDimensionPixelOffset(r3, this.mMinHeight);
        goto L35
    L13:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxWidth, "styleable", "ConstraintLayout_Layout_android_maxWidth")) goto L16;
        this.mMaxWidth = r12.getDimensionPixelOffset(r3, this.mMaxWidth);
        goto L35
    L16:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_android_maxHeight, "styleable", "ConstraintLayout_Layout_android_maxHeight")) goto L19;
        this.mMaxHeight = r12.getDimensionPixelOffset(r3, this.mMaxHeight);
        goto L35
    L19:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layout_optimizationLevel, "styleable", "ConstraintLayout_Layout_layout_optimizationLevel")) goto L22;
        this.mOptimizationLevel = r12.getInt(r3, this.mOptimizationLevel);
        goto L35
    L22:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_layoutDescription, "styleable", "ConstraintLayout_Layout_layoutDescription")) goto L29;
        int r4 = r12.getResourceId(r3, 0);
        if (r4 == 0) goto L35;
        parseLayoutDescription(r4);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r3 != ZeusTransformUtils.mapRes(R.styleable.ConstraintLayout_Layout_constraintSet, "styleable", "ConstraintLayout_Layout_constraintSet")) goto L35;
        int r5 = r12.getResourceId(r3, 0);
        ConstraintSet r6 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r6;     // Catch: Resources.NotFoundException -> L33
        r6.load((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r5;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r12.recycle();
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
        boolean r6 = isInEditMode();
        int r7 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L10;
        ConstraintWidget r2 = getViewWidget(getChildAt(r1));
        if (r2 == null) goto L8;
        r2.reset();
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        if (r6 == false) goto L20;
        int r3 = 0;
    L12:
        if (r3 >= r7) goto L20;
        View r4 = getChildAt(r3);
        String r5 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getResourceName(r4.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r5, Integer.valueOf(r4.getId()));     // Catch: Resources.NotFoundException -> L54
        int r8 = r5.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r8 == (-1)) goto L17;
        r5 = r5.substring(r8 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r4.getId()).setDebugName(r5);     // Catch: Resources.NotFoundException -> L54
    L18:
        r3 = r3 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r9 = 0;
    L22:
        if (r9 >= r7) goto L29;
        View r10 = getChildAt(r9);
        if (r10.getId() != this.mConstraintSetId) goto L28;
        if (ZeusTransformUtils.instanceOf(r10, Constraints.class) == false) goto L28;
        this.mConstraintSet = ((Constraints) ZeusTransformUtils.preCheckCast(r10, Constraints.class, "com.obric.memorydata.plugin")).getConstraintSet();
    L28:
        r9 = r9 + 1;
    L29:
        ConstraintSet r11 = this.mConstraintSet;
        if (r11 == null) goto L32;
        r11.applyToInternal(this, true);
    L32:
        this.mLayoutWidget.removeAllChildren();
        int r12 = this.mConstraintHelpers.size();
        if (r12 <= 0) goto L37;
        int r13 = 0;
    L35:
        if (r13 >= r12) goto L37;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r13), ConstraintHelper.class, "com.obric.memorydata.plugin")).updatePreLayout(this);
        r13 = r13 + 1;
    L37:
        int r14 = 0;
    L38:
        if (r14 >= r7) goto L43;
        View r15 = getChildAt(r14);
        if (ZeusTransformUtils.instanceOf(r15, Placeholder.class) == false) goto L42;
        ((Placeholder) ZeusTransformUtils.preCheckCast(r15, Placeholder.class, "com.obric.memorydata.plugin")).updatePreLayout(this);
    L42:
        r14 = r14 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r16 = 0;
    L44:
        if (r16 >= r7) goto L46;
        View r17 = getChildAt(r16);
        this.mTempMapIdToWidget.put(r17.getId(), getViewWidget(r17));
        r16 = r16 + 1;
        goto L44
    L46:
        int r18 = 0;
    L47:
        if (r18 >= r7) goto L53;
        View r19 = getChildAt(r18);
        ConstraintWidget r20 = getViewWidget(r19);
        if (r20 == null) goto L52;
        LayoutParams r21 = (LayoutParams) ZeusTransformUtils.preCheckCast(r19.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        this.mLayoutWidget.add(r20);
        applyConstraintsFromLayoutParams(r6, r19, r20, r21, this.mTempMapIdToWidget);
    L52:
        r18 = r18 + 1;
        goto L47
    }

    private void setWidgetBaseline(ConstraintWidget r3, LayoutParams r4, SparseArray<ConstraintWidget> r5, int r6, ConstraintAnchor.Type r7) {
        View r2 = (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r6), View.class, "com.obric.memorydata.plugin");
        ConstraintWidget r8 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r5.get(r6), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L12;
        if (r2 != null) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2.getLayoutParams(), LayoutParams.class) == false) goto L14;
        r4.needsBaseline = true;
        if (r7 != ConstraintAnchor.Type.BASELINE) goto L10;
        LayoutParams r9 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r9.needsBaseline = true;
        r9.widget.setHasBaseline(true);
    L10:
        r3.getAnchor(ConstraintAnchor.Type.BASELINE).connect(r8.getAnchor(r7), r4.baselineMargin, r4.goneBaselineMargin, true);
        r3.setHasBaseline(true);
        r3.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r3.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        return;
    L14:
        return;
    }

    private boolean updateHierarchy() {
        int r0 = getChildCount();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (getChildAt(r2).isLayoutRequested() == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L8:
        if (r1 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r1;
    }

    public void applyConstraintsFromLayoutParams(boolean r19, View r20, ConstraintWidget r21, LayoutParams r22, SparseArray<ConstraintWidget> r23) {
        r22.validate();
        r22.helped = false;
        r21.setVisibility(r20.getVisibility());
        if (r22.isInPlaceholder == false) goto L5;
        r21.setInPlaceholder(true);
        r21.setVisibility(8);
    L5:
        r21.setCompanionWidget(r20);
        if (ZeusTransformUtils.instanceOf(r20, ConstraintHelper.class) == false) goto L10;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r20, ConstraintHelper.class, "com.obric.memorydata.plugin")).resolveRtl(r21, this.mLayoutWidget.isRtl());
    L10:
        if (r22.isGuideline == false) goto L21;
        androidx.constraintlayout.core.widgets.Guideline r0 = (androidx.constraintlayout.core.widgets.Guideline) ZeusTransformUtils.preCheckCast(r21, androidx.constraintlayout.core.widgets.Guideline.class, "com.obric.memorydata.plugin");
        int r2 = r22.resolvedGuideBegin;
        int r3 = r22.resolvedGuideEnd;
        float r4 = r22.resolvedGuidePercent;
        if (Build.VERSION.SDK_INT >= 17) goto L15;
        r2 = r22.guideBegin;
        r3 = r22.guideEnd;
        r4 = r22.guidePercent;
    L15:
        if (r4 == (-1.0f)) goto L17;
        r0.setGuidePercent(r4);
        return;
    L17:
        if (r2 == (-1)) goto L19;
        r0.setGuideBegin(r2);
        return;
    L19:
        if (r3 == (-1)) goto L141;
        r0.setGuideEnd(r3);
        return;
    L141:
        return;
    L21:
        int r1 = r22.resolvedLeftToLeft;
        int r5 = r22.resolvedLeftToRight;
        int r6 = r22.resolvedRightToLeft;
        int r7 = r22.resolvedRightToRight;
        int r8 = r22.resolveGoneLeftMargin;
        int r13 = r22.resolveGoneRightMargin;
        float r14 = r22.resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT >= 17) goto L41;
        r1 = r22.leftToLeft;
        int r9 = r22.leftToRight;
        int r10 = r22.rightToLeft;
        r7 = r22.rightToRight;
        int r11 = r22.goneLeftMargin;
        int r12 = r22.goneRightMargin;
        r14 = r22.horizontalBias;
        if (r1 != (-1)) goto L32;
        if (r9 != (-1)) goto L32;
        if (r22.startToStart == (-1)) goto L30;
        r1 = r22.startToStart;
        goto L32
    L30:
        if (r22.startToEnd == (-1)) goto L32;
        r9 = r22.startToEnd;
    L32:
        if (r10 != (-1)) goto L40;
        if (r7 != (-1)) goto L40;
        if (r22.endToStart == (-1)) goto L38;
        r10 = r22.endToStart;
        goto L40
    L38:
        if (r22.endToEnd == (-1)) goto L40;
        r7 = r22.endToEnd;
    L40:
        int r15 = r10;
        int r16 = r12;
        r8 = r11;
        r5 = r9;
    L42:
        float r17 = r14;
        int r18 = r7;
        if (r22.circleConstraint == (-1)) goto L47;
        ConstraintWidget r24 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r22.circleConstraint), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L105;
        r21.connectCircularConstraint(r24, r22.circleAngle, r22.circleRadius);
    L105:
        if (r19 == false) goto L112;
        if (r22.editorAbsoluteX == (-1)) goto L109;
    L110:
        r21.setOrigin(r22.editorAbsoluteX, r22.editorAbsoluteY);
        goto L112
    L109:
        if (r22.editorAbsoluteY != (-1)) goto L110;
    L112:
        if (r22.horizontalDimensionFixed == false) goto L114;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r21.setWidth(r22.width);
        if (r22.width != (-2)) goto L125;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L125:
        if (r22.verticalDimensionFixed == false) goto L127;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r21.setHeight(r22.height);
        if (r22.height != (-2)) goto L137;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L137:
        r21.setDimensionRatio(r22.dimensionRatio);
        r21.setHorizontalWeight(r22.horizontalWeight);
        r21.setVerticalWeight(r22.verticalWeight);
        r21.setHorizontalChainStyle(r22.horizontalChainStyle);
        r21.setVerticalChainStyle(r22.verticalChainStyle);
        r21.setWrapBehaviorInParent(r22.wrapBehaviorInParent);
        r21.setHorizontalMatchStyle(r22.matchConstraintDefaultWidth, r22.matchConstraintMinWidth, r22.matchConstraintMaxWidth, r22.matchConstraintPercentWidth);
        r21.setVerticalMatchStyle(r22.matchConstraintDefaultHeight, r22.matchConstraintMinHeight, r22.matchConstraintMaxHeight, r22.matchConstraintPercentHeight);
        return;
    L127:
        if (r22.height == (-1)) goto L129;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r21.setHeight(0);
        goto L137
    L129:
        if (r22.constrainedHeight == false) goto L131;
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L132:
        r21.setVerticalDimensionBehaviour(r25);
        ConstraintAnchor r26 = r21.getAnchor(ConstraintAnchor.Type.TOP);
        r26.mMargin = r22.topMargin;
        ConstraintAnchor r27 = r21.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r27.mMargin = r22.bottomMargin;
        goto L137
    L131:
        r25 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L132
    L114:
        if (r22.width == (-1)) goto L116;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r21.setWidth(0);
        goto L125
    L116:
        if (r22.constrainedWidth == false) goto L118;
        ConstraintWidget.DimensionBehaviour r28 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
    L119:
        r21.setHorizontalDimensionBehaviour(r28);
        ConstraintAnchor r29 = r21.getAnchor(ConstraintAnchor.Type.LEFT);
        r29.mMargin = r22.leftMargin;
        ConstraintAnchor r30 = r21.getAnchor(ConstraintAnchor.Type.RIGHT);
        r30.mMargin = r22.rightMargin;
        goto L125
    L118:
        r28 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        goto L119
    L47:
        if (r1 == (-1)) goto L52;
        ConstraintWidget r31 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r1), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L51;
        ConstraintAnchor.Type r32 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type r33 = ConstraintAnchor.Type.LEFT;
        float r34 = r17;
        int r35 = r22.leftMargin;
    L57:
        r21.immediateConnect(r32, r31, r33, r35, r8);
    L58:
        if (r15 == (-1)) goto L62;
        ConstraintWidget r36 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r15), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L68;
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type r38 = ConstraintAnchor.Type.LEFT;
    L66:
        r21.immediateConnect(r37, r36, r38, r22.rightMargin, r16);
    L68:
        if (r22.topToTop == (-1)) goto L73;
        ConstraintWidget r39 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r22.topToTop), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L79;
        ConstraintAnchor.Type r40 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor.Type r41 = ConstraintAnchor.Type.TOP;
    L77:
        r21.immediateConnect(r40, r39, r41, r22.topMargin, r22.goneTopMargin);
    L79:
        if (r22.bottomToTop == (-1)) goto L84;
        ConstraintWidget r42 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r22.bottomToTop), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r42 == null) goto L90;
        ConstraintAnchor.Type r43 = ConstraintAnchor.Type.BOTTOM;
        ConstraintAnchor.Type r44 = ConstraintAnchor.Type.TOP;
    L88:
        r21.immediateConnect(r43, r42, r44, r22.bottomMargin, r22.goneBottomMargin);
    L90:
        if (r22.baselineToBaseline == (-1)) goto L94;
        int r45 = r22.baselineToBaseline;
        ConstraintAnchor.Type r46 = ConstraintAnchor.Type.BASELINE;
    L92:
        setWidgetBaseline(r21, r22, r23, r45, r46);
    L100:
        if (r34 < 0.0f) goto L103;
        r21.setHorizontalBiasPercent(r34);
    L103:
        if (r22.verticalBias < 0.0f) goto L105;
        r21.setVerticalBiasPercent(r22.verticalBias);
        goto L105
    L94:
        if (r22.baselineToTop == (-1)) goto L97;
        r45 = r22.baselineToTop;
        r46 = ConstraintAnchor.Type.TOP;
        goto L92
    L97:
        if (r22.baselineToBottom == (-1)) goto L100;
        r45 = r22.baselineToBottom;
        r46 = ConstraintAnchor.Type.BOTTOM;
        goto L92
    L84:
        if (r22.bottomToBottom == (-1)) goto L90;
        r42 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r22.bottomToBottom), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r42 == null) goto L90;
        r43 = ConstraintAnchor.Type.BOTTOM;
        r44 = ConstraintAnchor.Type.BOTTOM;
        goto L88
    L73:
        if (r22.topToBottom == (-1)) goto L79;
        r39 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r22.topToBottom), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r39 == null) goto L79;
        r40 = ConstraintAnchor.Type.TOP;
        r41 = ConstraintAnchor.Type.BOTTOM;
        goto L77
    L62:
        if (r18 == (-1)) goto L68;
        r36 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r18), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r36 == null) goto L68;
        r37 = ConstraintAnchor.Type.RIGHT;
        r38 = ConstraintAnchor.Type.RIGHT;
        goto L66
    L51:
        r34 = r17;
        goto L58
    L52:
        r34 = r17;
        if (r5 == (-1)) goto L58;
        r31 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r23.get(r5), ConstraintWidget.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L58;
        r32 = ConstraintAnchor.Type.LEFT;
        r33 = ConstraintAnchor.Type.RIGHT;
        r35 = r22.leftMargin;
        goto L57
    L41:
        r16 = r13;
        r15 = r6;
        goto L42
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r22) {
        ArrayList<ConstraintHelper> r1 = this.mConstraintHelpers;
        if (r1 == null) goto L9;
        int r2 = r1.size();
        if (r2 <= 0) goto L9;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r4), ConstraintHelper.class, "com.obric.memorydata.plugin")).updatePreDraw(this);
        r4 = r4 + 1;
    L9:
        super.dispatchDraw(r22);
        if (isInEditMode() == false) goto L24;
        float r3 = getWidth();
        float r5 = getHeight();
        int r7 = getChildCount();
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L32;
        View r9 = getChildAt(r8);
        if (r9.getVisibility() == 8) goto L23;
        Object r10 = r9.getTag();
        if (r10 == null) goto L23;
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L23;
        String[] r11 = ((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")).split(",");
        if (r11.length != 4) goto L23;
        int r12 = Integer.parseInt(r11[0]);
        int r13 = Integer.parseInt(r11[1]);
        int r14 = Integer.parseInt(r11[2]);
        int r15 = (int) ((r12 / 1080.0f) * r3);
        int r16 = (int) ((r13 / 1920.0f) * r5);
        int r17 = (int) ((Integer.parseInt(r11[3]) / 1920.0f) * r5);
        Paint r18 = new Paint();
        r18.setColor(-65536);
        float r19 = r15;
        float r110 = r16;
        float r111 = r15 + ((int) ((r14 / 1080.0f) * r3));
        r22.drawLine(r19, r110, r111, r110, r18);
        float r20 = r16 + r17;
        r22.drawLine(r111, r110, r111, r20, r18);
        r22.drawLine(r111, r20, r19, r20, r18);
        r22.drawLine(r19, r20, r19, r110, r18);
        r18.setColor(-16711936);
        r22.drawLine(r19, r110, r111, r20, r18);
        r22.drawLine(r19, r20, r111, r110, r18);
    L23:
        r8 = r8 + 1;
        goto L12
    L32:
        return;
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mLayoutWidget.fillMetrics(r1);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public Object getDesignInformation(int r2, Object r3) {
        if (r2 == 0) goto L4;
        return null;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L13;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        HashMap<String, Integer> r5 = this.mDesignIds;
        if (r5 != null) goto L8;
        return null;
    L8:
        if (r5.containsKey(r4) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r4);
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
        StringBuilder r0 = new StringBuilder();
        if (this.mLayoutWidget.stringId != null) goto L9;
        int r1 = getId();
        if (r1 == (-1)) goto L7;
        this.mLayoutWidget.stringId = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r1);
        goto L9
    L7:
        this.mLayoutWidget.stringId = "parent";
    L9:
        if (this.mLayoutWidget.getDebugName() != null) goto L11;
        ConstraintWidgetContainer r2 = this.mLayoutWidget;
        r2.setDebugName(r2.stringId);
        Log.v(TAG, " setDebugName " + this.mLayoutWidget.getDebugName());
    L11:
        Iterator<ConstraintWidget> r3 = this.mLayoutWidget.getChildren().iterator();
    L13:
        if (r3.hasNext() == false) goto L24;
        ConstraintWidget r6 = (ConstraintWidget) ZeusTransformUtils.preCheckCast(r3.next(), ConstraintWidget.class, "com.obric.memorydata.plugin");
        View r7 = (View) ZeusTransformUtils.preCheckCast(r6.getCompanionWidget(), View.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L13;
        if (r6.stringId != null) goto L22;
        int r8 = r7.getId();
        if (r8 == (-1)) goto L22;
        r6.stringId = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(r8);
    L22:
        if (r6.getDebugName() != null) goto L13;
        r6.setDebugName(r6.stringId);
        Log.v(TAG, " setDebugName " + r6.getDebugName());
        goto L13
    L24:
        this.mLayoutWidget.getSceneString(r0);
        return r0.toString();
    }

    public View getViewById(int r2) {
        return (View) ZeusTransformUtils.preCheckCast(this.mChildrenByIds.get(r2), View.class, "com.obric.memorydata.plugin");
    }

    public final ConstraintWidget getViewWidget(View r3) {
        if (r3 == this) goto L4;
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        r3.setLayoutParams(generateLayoutParams(r3.getLayoutParams()));
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), LayoutParams.class) == true) goto L9;
        return null;
    L9:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).widget;
    L4:
        return this.mLayoutWidget;
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) goto L5;
        return false;
    L5:
        if ((((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().flags & 4194304) == 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (1 == getLayoutDirection()) goto L12;
        return false;
    L12:
        return true;
    L7:
        r0 = false;
        goto L8
    }

    public void loadLayoutDescription(int r6) {
        if (r6 != 0) goto L9;
    L6:
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r6);     // Catch: Resources.NotFoundException -> L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        int r12 = getChildCount();
        boolean r13 = isInEditMode();
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r12) goto L24;
        View r0 = getChildAt(r15);
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        ConstraintWidget r2 = r1.widget;
        if (r0.getVisibility() != 8) goto L16;
        if (r1.isGuideline == true) goto L16;
        if (r1.isHelper == true) goto L16;
        if (r1.isVirtualGroup == true) goto L16;
        if (r13 == true) goto L16;
    L23:
        r15 = r15 + 1;
    L16:
        if (r1.isInPlaceholder == true) goto L23;
        int r3 = r2.getX();
        int r4 = r2.getY();
        int r5 = r2.getWidth() + r3;
        int r6 = r2.getHeight() + r4;
        r0.layout(r3, r4, r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, Placeholder.class) == false) goto L23;
        View r16 = ((Placeholder) ZeusTransformUtils.preCheckCast(r0, Placeholder.class, "com.obric.memorydata.plugin")).getContent();
        if (r16 == null) goto L23;
        r16.setVisibility(0);
        r16.layout(r3, r4, r5, r6);
        goto L23
    L24:
        int r17 = this.mConstraintHelpers.size();
        if (r17 <= 0) goto L28;
    L26:
        if (r14 >= r17) goto L36;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(this.mConstraintHelpers.get(r14), ConstraintHelper.class, "com.obric.memorydata.plugin")).updatePostLayout(this);
        r14 = r14 + 1;
        goto L26
    L36:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r9, int r10) {
        if (this.mOnMeasureWidthMeasureSpec != r9) goto L6;
        int r0 = this.mOnMeasureHeightMeasureSpec;
    L6:
        if (this.mDirtyHierarchy == true) goto L13;
        int r1 = getChildCount();
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        if (getChildAt(r2).isLayoutRequested() == true) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        this.mDirtyHierarchy = true;
    L13:
        boolean r3 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = r9;
        this.mOnMeasureHeightMeasureSpec = r10;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L18;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L18;
        this.mLayoutWidget.updateHierarchy();
    L18:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r9, r10);
        resolveMeasuredDimension(r9, r10, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r6) {
        super.onViewAdded(r6);
        ConstraintWidget r0 = getViewWidget(r6);
        if (ZeusTransformUtils.instanceOf(r6, Guideline.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, androidx.constraintlayout.core.widgets.Guideline.class) == true) goto L8;
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        r1.widget = new androidx.constraintlayout.core.widgets.Guideline();
        r1.isGuideline = true;
        ((androidx.constraintlayout.core.widgets.Guideline) ZeusTransformUtils.preCheckCast(r1.widget, androidx.constraintlayout.core.widgets.Guideline.class, "com.obric.memorydata.plugin")).setOrientation(r1.orientation);
    L8:
        if (ZeusTransformUtils.instanceOf(r6, ConstraintHelper.class) == false) goto L12;
        ConstraintHelper r2 = (ConstraintHelper) ZeusTransformUtils.preCheckCast(r6, ConstraintHelper.class, "com.obric.memorydata.plugin");
        r2.validateParams();
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin")).isHelper = true;
        if (this.mConstraintHelpers.contains(r2) == true) goto L12;
        this.mConstraintHelpers.add(r2);
    L12:
        this.mChildrenByIds.put(r6.getId(), r6);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r3) {
        super.onViewRemoved(r3);
        this.mChildrenByIds.remove(r3.getId());
        ConstraintWidget r0 = getViewWidget(r3);
        this.mLayoutWidget.remove(r0);
        this.mConstraintHelpers.remove(r3);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int r5) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this, r5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
        int r0 = this.mMeasurer.paddingHeight;
        int r9 = resolveSizeAndState(r5 + this.mMeasurer.paddingWidth, r3, 0);
        int r10 = resolveSizeAndState(r6 + r0, r4, 0);
        int r11 = r9 & ViewCompat.MEASURED_SIZE_MASK;
        int r12 = r10 & ViewCompat.MEASURED_SIZE_MASK;
        int r13 = Math.min(this.mMaxWidth, r11);
        int r14 = Math.min(this.mMaxHeight, r12);
        if (r7 == false) goto L5;
        r13 = r13 | 16777216;
    L5:
        if (r8 == false) goto L7;
        r14 = r14 | 16777216;
    L7:
        setMeasuredDimension(r13, r14);
        this.mLastMeasureWidth = r13;
        this.mLastMeasureHeight = r14;
    }

    public void resolveSystem(ConstraintWidgetContainer r18, int r19, int r20, int r21) {
        int r7 = View.MeasureSpec.getMode(r20);
        int r0 = View.MeasureSpec.getSize(r20);
        int r8 = View.MeasureSpec.getMode(r21);
        int r1 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r2 = r16 + r13;
        int r4 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(r20, r21, r16, r13, r4, r2);
        if (Build.VERSION.SDK_INT < 17) goto L13;
        int r5 = Math.max(0, getPaddingStart());
        int r9 = Math.max(0, getPaddingEnd());
        if (r5 > 0) goto L10;
        if (r9 > 0) goto L10;
        r5 = Math.max(0, getPaddingLeft());
    L12:
        int r10 = r5;
    L14:
        int r11 = r0 - r4;
        int r12 = r1 - r2;
        setSelfDimensionBehaviour(r18, r7, r11, r8, r12);
        r18.measure(r19, r7, r11, r8, r12, this.mLastMeasureWidth, this.mLastMeasureHeight, r10, r16);
        return;
    L10:
        if (isRtl() == false) goto L12;
        r5 = r9;
        goto L12
    L13:
        r10 = Math.max(0, getPaddingLeft());
        goto L14
    }

    public void setConstraintSet(ConstraintSet r1) {
        this.mConstraintSet = r1;
    }

    public void setDesignInformation(int r3, Object r4, Object r5) {
        if (r3 == 0) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r4, String.class) == true) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        int r7 = r6.indexOf("/");
        if (r7 == (-1)) goto L13;
        r6 = r6.substring(r7 + 1);
    L13:
        int r8 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        this.mDesignIds.put(r6, Integer.valueOf(r8));
    }

    @Override // android.view.View
    public void setId(int r3) {
        this.mChildrenByIds.remove(getId());
        super.setId(r3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r2) {
        if (r2 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r2;
        requestLayout();
    }

    public void setMaxWidth(int r2) {
        if (r2 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r2;
        requestLayout();
    }

    public void setMinHeight(int r2) {
        if (r2 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r2;
        requestLayout();
    }

    public void setMinWidth(int r2) {
        if (r2 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r2;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r1) {
        this.mConstraintsChangedListener = r1;
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.setOnConstraintsChanged(r1);
        return;
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        this.mLayoutWidget.setOptimizationLevel(r1);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer r9, int r10, int r11, int r12, int r13) {
        int r0 = this.mMeasurer.paddingHeight;
        int r1 = this.mMeasurer.paddingWidth;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r4 = getChildCount();
        if (r10 == Integer.MIN_VALUE) goto L11;
        if (r10 == 0) goto L8;
        if (r10 == 1073741824) goto L7;
    L6:
        r11 = 0;
    L14:
        if (r12 == Integer.MIN_VALUE) goto L22;
        if (r12 == 0) goto L19;
        if (r12 == 1073741824) goto L18;
    L17:
        r13 = 0;
    L26:
        if (r11 == r9.getWidth()) goto L28;
    L29:
        r9.invalidateMeasures();
    L30:
        r9.setX(0);
        r9.setY(0);
        r9.setMaxWidth(this.mMaxWidth - r1);
        r9.setMaxHeight(this.mMaxHeight - r0);
        r9.setMinWidth(0);
        r9.setMinHeight(0);
        r9.setHorizontalDimensionBehaviour(r2);
        r9.setWidth(r11);
        r9.setVerticalDimensionBehaviour(r3);
        r9.setHeight(r13);
        r9.setMinWidth(this.mMinWidth - r1);
        r9.setMinHeight(this.mMinHeight - r0);
        return;
    L28:
        if (r13 == r9.getHeight()) goto L30;
    L18:
        r13 = Math.min(this.mMaxHeight - r0, r13);
        goto L26
    L19:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L17;
    L24:
        r13 = Math.max(0, this.mMinHeight);
        goto L26
    L22:
        r3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L26;
    L7:
        r11 = Math.min(this.mMaxWidth - r1, r11);
        goto L14
    L8:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L6;
    L13:
        r11 = Math.max(0, this.mMinWidth);
        goto L14
    L11:
        r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r4 != 0) goto L14;
        goto L13
    }

    public void setState(int r1, int r2, int r3) {
        ConstraintLayoutStates r0 = this.mConstraintLayoutSpec;
        if (r0 == null) goto L6;
        r0.updateConstraints(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
