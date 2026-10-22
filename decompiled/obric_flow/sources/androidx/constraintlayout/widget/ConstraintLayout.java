package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
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
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = null;

        static {
            int[] r5 = new int[ConstraintWidget.DimensionBehaviour.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = r5;
            r5[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
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
        public int baselineToBaseline;
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
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
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

        public static class Table {
            public static final int ANDROID_ORIENTATION = 1;
            public static final int LAYOUT_CONSTRAINED_HEIGHT = 28;
            public static final int LAYOUT_CONSTRAINED_WIDTH = 27;
            public static final int LAYOUT_CONSTRAINT_BASELINE_CREATOR = 43;
            public static final int LAYOUT_CONSTRAINT_BASELINE_TO_BASELINE_OF = 16;
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
            public static final int LAYOUT_CONSTRAINT_WIDTH_DEFAULT = 31;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MAX = 34;
            public static final int LAYOUT_CONSTRAINT_WIDTH_MIN = 33;
            public static final int LAYOUT_CONSTRAINT_WIDTH_PERCENT = 35;
            public static final int LAYOUT_EDITOR_ABSOLUTEX = 49;
            public static final int LAYOUT_EDITOR_ABSOLUTEY = 50;
            public static final int LAYOUT_GONE_MARGIN_BOTTOM = 24;
            public static final int LAYOUT_GONE_MARGIN_END = 26;
            public static final int LAYOUT_GONE_MARGIN_LEFT = 21;
            public static final int LAYOUT_GONE_MARGIN_RIGHT = 23;
            public static final int LAYOUT_GONE_MARGIN_START = 25;
            public static final int LAYOUT_GONE_MARGIN_TOP = 22;
            public static final int UNUSED = 0;
            public static final SparseIntArray map = null;

            static {
                SparseIntArray r5 = new SparseIntArray();
                map = r5;
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                r5.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                r5.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }

            private Table() {
            }
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            this.guideBegin = r10.guideBegin;
            this.guideEnd = r10.guideEnd;
            this.guidePercent = r10.guidePercent;
            this.leftToLeft = r10.leftToLeft;
            this.leftToRight = r10.leftToRight;
            this.rightToLeft = r10.rightToLeft;
            this.rightToRight = r10.rightToRight;
            this.topToTop = r10.topToTop;
            this.topToBottom = r10.topToBottom;
            this.bottomToTop = r10.bottomToTop;
            this.bottomToBottom = r10.bottomToBottom;
            this.baselineToBaseline = r10.baselineToBaseline;
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
            this.widget = r10.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget r5 = this.widget;
            if (r5 == null) goto L6;
            r5.reset();
            return;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public void resolveLayoutDirection(int r10) {
            int r5 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int r11 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(r10);
            boolean r12 = false;
            if (1 != getLayoutDirection()) goto L5;
            boolean r13 = true;
        L6:
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolveGoneLeftMargin = this.goneLeftMargin;
            this.resolveGoneRightMargin = this.goneRightMargin;
            float r14 = this.horizontalBias;
            this.resolvedHorizontalBias = r14;
            int r15 = this.guideBegin;
            this.resolvedGuideBegin = r15;
            int r16 = this.guideEnd;
            this.resolvedGuideEnd = r16;
            float r17 = this.guidePercent;
            this.resolvedGuidePercent = r17;
            if (r13 == false) goto L41;
            int r18 = this.startToEnd;
            if (r18 == (-1)) goto L12;
            this.resolvedRightToLeft = r18;
        L11:
            r12 = true;
        L15:
            int r19 = this.endToStart;
            if (r19 == (-1)) goto L18;
            this.resolvedLeftToRight = r19;
            r12 = true;
        L18:
            int r110 = this.endToEnd;
            if (r110 == (-1)) goto L21;
            this.resolvedLeftToLeft = r110;
            r12 = true;
        L21:
            int r111 = this.goneStartMargin;
            if (r111 == (-1)) goto L24;
            this.resolveGoneRightMargin = r111;
        L24:
            int r112 = this.goneEndMargin;
            if (r112 == (-1)) goto L28;
            this.resolveGoneLeftMargin = r112;
        L28:
            if (r12 == false) goto L31;
            this.resolvedHorizontalBias = 1.0f - r14;
        L31:
            if (this.isGuideline == false) goto L60;
            if (this.orientation != 1) goto L60;
            if (r17 == (-1.0f)) goto L37;
            this.resolvedGuidePercent = 1.0f - r17;
            this.resolvedGuideBegin = -1;
            this.resolvedGuideEnd = -1;
            goto L60
        L37:
            if (r15 == (-1)) goto L39;
            this.resolvedGuideEnd = r15;
            this.resolvedGuideBegin = -1;
            this.resolvedGuidePercent = -1.0f;
            goto L60
        L39:
            if (r16 == (-1)) goto L60;
            this.resolvedGuideBegin = r16;
            this.resolvedGuideEnd = -1;
            this.resolvedGuidePercent = -1.0f;
        L60:
            if (this.endToStart == (-1)) goto L62;
            return;
        L62:
            if (this.endToEnd == (-1)) goto L64;
            return;
        L64:
            if (this.startToStart == (-1)) goto L66;
            return;
        L66:
            if (this.startToEnd != (-1)) goto L95;
            int r113 = this.rightToLeft;
            if (r113 == (-1)) goto L73;
            this.resolvedRightToLeft = r113;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L79;
            if (r11 <= 0) goto L79;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r11;
        L79:
            int r114 = this.leftToLeft;
            if (r114 == (-1)) goto L85;
            this.resolvedLeftToLeft = r114;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L96;
            if (r5 <= 0) goto L97;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5;
            return;
        L97:
            return;
        L96:
            return;
        L85:
            int r115 = this.leftToRight;
            if (r115 == (-1)) goto L99;
            this.resolvedLeftToRight = r115;
            if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0) goto L100;
            if (r5 <= 0) goto L101;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5;
            return;
        L101:
            return;
        L100:
            return;
        L99:
            return;
        L73:
            int r116 = this.rightToRight;
            if (r116 == (-1)) goto L79;
            this.resolvedRightToRight = r116;
            if (((ViewGroup.MarginLayoutParams) this).rightMargin > 0) goto L79;
            if (r11 <= 0) goto L79;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r11;
            goto L79
        L95:
            return;
        L12:
            int r117 = this.startToStart;
            if (r117 == (-1)) goto L15;
            this.resolvedRightToRight = r117;
            goto L11
        L41:
            int r118 = this.startToEnd;
            if (r118 == (-1)) goto L44;
            this.resolvedLeftToRight = r118;
        L44:
            int r119 = this.startToStart;
            if (r119 == (-1)) goto L47;
            this.resolvedLeftToLeft = r119;
        L47:
            int r120 = this.endToStart;
            if (r120 == (-1)) goto L50;
            this.resolvedRightToLeft = r120;
        L50:
            int r121 = this.endToEnd;
            if (r121 == (-1)) goto L53;
            this.resolvedRightToRight = r121;
        L53:
            int r122 = this.goneStartMargin;
            if (r122 == (-1)) goto L56;
            this.resolveGoneLeftMargin = r122;
        L56:
            int r123 = this.goneEndMargin;
            if (r123 == (-1)) goto L60;
            this.resolveGoneRightMargin = r123;
            goto L60
        L5:
            r13 = false;
            goto L6
        }

        public void setWidgetDebugName(String r5) {
            this.widget.setDebugName(r5);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            int r5 = ((ViewGroup.MarginLayoutParams) this).width;
            if (r5 == (-2)) goto L5;
        L9:
            int r10 = ((ViewGroup.MarginLayoutParams) this).height;
            if (r10 != (-2)) goto L17;
            if (this.constrainedHeight == false) goto L17;
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight != 0) goto L17;
            this.matchConstraintDefaultHeight = 1;
        L17:
            if (r5 == 0) goto L19;
            if (r5 == (-1)) goto L19;
        L24:
            if (r10 == 0) goto L26;
            if (r10 == (-1)) goto L26;
        L32:
            if (this.guidePercent == (-1.0f)) goto L34;
        L37:
            this.isGuideline = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            if ((this.widget instanceof androidx.constraintlayout.solver.widgets.Guideline) == true) goto L40;
            this.widget = new androidx.constraintlayout.solver.widgets.Guideline();
        L40:
            ((androidx.constraintlayout.solver.widgets.Guideline) this.widget).setOrientation(this.orientation);
            return;
        L34:
            if (this.guideBegin != (-1)) goto L37;
            if (this.guideEnd != (-1)) goto L37;
            return;
        L26:
            this.verticalDimensionFixed = false;
            if (r10 != 0) goto L32;
            if (this.matchConstraintDefaultHeight != 1) goto L32;
            ((ViewGroup.MarginLayoutParams) this).height = -2;
            this.constrainedHeight = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L19:
            this.horizontalDimensionFixed = false;
            if (r5 != 0) goto L24;
            if (this.matchConstraintDefaultWidth != 1) goto L24;
            ((ViewGroup.MarginLayoutParams) this).width = -2;
            this.constrainedWidth = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            goto L24
        L5:
            if (this.constrainedWidth == false) goto L9;
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth != 0) goto L9;
            this.matchConstraintDefaultWidth = 1;
            goto L9
        }

        public LayoutParams(Context r11, AttributeSet r12) {
            super(r11, r12);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
            TypedArray r13 = r11.obtainStyledAttributes(r12, R.styleable.ConstraintLayout_Layout);
            int r14 = r13.getIndexCount();
            int r5 = 0;
        L3:
            if (r5 >= r14) goto L139;
            int r10 = r13.getIndex(r5);
            int r15 = Table.map.get(r10);
            switch(r15) {
                case 1: goto L137;
                case 2: goto L134;
                case 3: goto L133;
                case 4: goto L130;
                case 5: goto L129;
                case 6: goto L128;
                case 7: goto L127;
                case 8: goto L124;
                case 9: goto L121;
                case 10: goto L118;
                case 11: goto L115;
                case 12: goto L112;
                case 13: goto L109;
                case 14: goto L106;
                case 15: goto L103;
                case 16: goto L100;
                case 17: goto L97;
                case 18: goto L94;
                case 19: goto L91;
                case 20: goto L88;
                case 21: goto L87;
                case 22: goto L86;
                case 23: goto L85;
                case 24: goto L84;
                case 25: goto L83;
                case 26: goto L82;
                case 27: goto L81;
                case 28: goto L80;
                case 29: goto L79;
                case 30: goto L78;
                case 31: goto L75;
                case 32: goto L72;
                case 33: goto L146;
                case 34: goto L142;
                case 35: goto L61;
                case 36: goto L144;
                case 37: goto L150;
                case 38: goto L50;
                default: goto L6;
            };
        L6:
            switch(r15) {
                case 44: goto L15;
                case 45: goto L14;
                case 46: goto L13;
                case 47: goto L12;
                case 48: goto L11;
                case 49: goto L10;
                case 50: goto L9;
                case 51: goto L8;
                default: goto L138;
            };
        L8:
            this.constraintTag = r13.getString(r10);
            goto L138
        L9:
            this.editorAbsoluteY = r13.getDimensionPixelOffset(r10, this.editorAbsoluteY);
            goto L138
        L10:
            this.editorAbsoluteX = r13.getDimensionPixelOffset(r10, this.editorAbsoluteX);
            goto L138
        L11:
            this.verticalChainStyle = r13.getInt(r10, 0);
            goto L138
        L12:
            this.horizontalChainStyle = r13.getInt(r10, 0);
            goto L138
        L13:
            this.verticalWeight = r13.getFloat(r10, this.verticalWeight);
            goto L138
        L14:
            this.horizontalWeight = r13.getFloat(r10, this.horizontalWeight);
            goto L138
        L15:
            String r16 = r13.getString(r10);
            this.dimensionRatio = r16;
            this.dimensionRatioValue = Float.NaN;
            this.dimensionRatioSide = -1;
            if (r16 == null) goto L138;
            int r17 = r16.length();
            int r18 = this.dimensionRatio.indexOf(44);
            if (r18 > 0) goto L20;
        L28:
            int r19 = 0;
        L29:
            int r20 = this.dimensionRatio.indexOf(58);
            if (r20 >= 0) goto L32;
        L46:
            String r21 = this.dimensionRatio.substring(r19);
            if (r21.length() <= 0) goto L138;
            this.dimensionRatioValue = Float.parseFloat(r21);     // Catch: NumberFormatException -> L141
            goto L138
        L32:
            if (r20 >= (r17 - 1)) goto L46;
            String r22 = this.dimensionRatio.substring(r19, r20);
            String r23 = this.dimensionRatio.substring(r20 + 1);
            if (r22.length() <= 0) goto L138;
            if (r23.length() <= 0) goto L138;
            float r24 = Float.parseFloat(r22);     // Catch: NumberFormatException -> L141
            float r25 = Float.parseFloat(r23);     // Catch: NumberFormatException -> L141
            if (r24 <= 0.0f) goto L138;
            if (r25 <= 0.0f) goto L138;
            if (this.dimensionRatioSide != 1) goto L44;
            this.dimensionRatioValue = Math.abs(r25 / r24);     // Catch: NumberFormatException -> L141
            goto L138
        L44:
            this.dimensionRatioValue = Math.abs(r24 / r25);     // Catch: NumberFormatException -> L141
            goto L138
        L20:
            if (r18 >= (r17 - 1)) goto L28;
            String r26 = this.dimensionRatio.substring(0, r18);
            if (r26.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L25;
            this.dimensionRatioSide = 0;
        L27:
            r19 = r18 + 1;
            goto L29
        L25:
            if (r26.equalsIgnoreCase("H") == false) goto L27;
            this.dimensionRatioSide = 1;
        L138:
            r5 = r5 + 1;
            goto L3
        L50:
            this.matchConstraintPercentHeight = Math.max(0.0f, r13.getFloat(r10, this.matchConstraintPercentHeight));
            this.matchConstraintDefaultHeight = 2;
            goto L138
        L61:
            this.matchConstraintPercentWidth = Math.max(0.0f, r13.getFloat(r10, this.matchConstraintPercentWidth));
            this.matchConstraintDefaultWidth = 2;
            goto L138
        L72:
            int r27 = r13.getInt(r10, 0);
            this.matchConstraintDefaultHeight = r27;
            if (r27 != 1) goto L138;
            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
            goto L138
        L75:
            int r28 = r13.getInt(r10, 0);
            this.matchConstraintDefaultWidth = r28;
            if (r28 != 1) goto L138;
            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
            goto L138
        L78:
            this.verticalBias = r13.getFloat(r10, this.verticalBias);
            goto L138
        L79:
            this.horizontalBias = r13.getFloat(r10, this.horizontalBias);
            goto L138
        L80:
            this.constrainedHeight = r13.getBoolean(r10, this.constrainedHeight);
            goto L138
        L81:
            this.constrainedWidth = r13.getBoolean(r10, this.constrainedWidth);
            goto L138
        L82:
            this.goneEndMargin = r13.getDimensionPixelSize(r10, this.goneEndMargin);
            goto L138
        L83:
            this.goneStartMargin = r13.getDimensionPixelSize(r10, this.goneStartMargin);
            goto L138
        L84:
            this.goneBottomMargin = r13.getDimensionPixelSize(r10, this.goneBottomMargin);
            goto L138
        L85:
            this.goneRightMargin = r13.getDimensionPixelSize(r10, this.goneRightMargin);
            goto L138
        L86:
            this.goneTopMargin = r13.getDimensionPixelSize(r10, this.goneTopMargin);
            goto L138
        L87:
            this.goneLeftMargin = r13.getDimensionPixelSize(r10, this.goneLeftMargin);
            goto L138
        L88:
            int r29 = r13.getResourceId(r10, this.endToEnd);
            this.endToEnd = r29;
            if (r29 != (-1)) goto L138;
            this.endToEnd = r13.getInt(r10, -1);
            goto L138
        L91:
            int r30 = r13.getResourceId(r10, this.endToStart);
            this.endToStart = r30;
            if (r30 != (-1)) goto L138;
            this.endToStart = r13.getInt(r10, -1);
            goto L138
        L94:
            int r31 = r13.getResourceId(r10, this.startToStart);
            this.startToStart = r31;
            if (r31 != (-1)) goto L138;
            this.startToStart = r13.getInt(r10, -1);
            goto L138
        L97:
            int r32 = r13.getResourceId(r10, this.startToEnd);
            this.startToEnd = r32;
            if (r32 != (-1)) goto L138;
            this.startToEnd = r13.getInt(r10, -1);
            goto L138
        L100:
            int r33 = r13.getResourceId(r10, this.baselineToBaseline);
            this.baselineToBaseline = r33;
            if (r33 != (-1)) goto L138;
            this.baselineToBaseline = r13.getInt(r10, -1);
            goto L138
        L103:
            int r34 = r13.getResourceId(r10, this.bottomToBottom);
            this.bottomToBottom = r34;
            if (r34 != (-1)) goto L138;
            this.bottomToBottom = r13.getInt(r10, -1);
            goto L138
        L106:
            int r35 = r13.getResourceId(r10, this.bottomToTop);
            this.bottomToTop = r35;
            if (r35 != (-1)) goto L138;
            this.bottomToTop = r13.getInt(r10, -1);
            goto L138
        L109:
            int r36 = r13.getResourceId(r10, this.topToBottom);
            this.topToBottom = r36;
            if (r36 != (-1)) goto L138;
            this.topToBottom = r13.getInt(r10, -1);
            goto L138
        L112:
            int r37 = r13.getResourceId(r10, this.topToTop);
            this.topToTop = r37;
            if (r37 != (-1)) goto L138;
            this.topToTop = r13.getInt(r10, -1);
            goto L138
        L115:
            int r38 = r13.getResourceId(r10, this.rightToRight);
            this.rightToRight = r38;
            if (r38 != (-1)) goto L138;
            this.rightToRight = r13.getInt(r10, -1);
            goto L138
        L118:
            int r39 = r13.getResourceId(r10, this.rightToLeft);
            this.rightToLeft = r39;
            if (r39 != (-1)) goto L138;
            this.rightToLeft = r13.getInt(r10, -1);
            goto L138
        L121:
            int r40 = r13.getResourceId(r10, this.leftToRight);
            this.leftToRight = r40;
            if (r40 != (-1)) goto L138;
            this.leftToRight = r13.getInt(r10, -1);
            goto L138
        L124:
            int r41 = r13.getResourceId(r10, this.leftToLeft);
            this.leftToLeft = r41;
            if (r41 != (-1)) goto L138;
            this.leftToLeft = r13.getInt(r10, -1);
            goto L138
        L127:
            this.guidePercent = r13.getFloat(r10, this.guidePercent);
            goto L138
        L128:
            this.guideEnd = r13.getDimensionPixelOffset(r10, this.guideEnd);
            goto L138
        L129:
            this.guideBegin = r13.getDimensionPixelOffset(r10, this.guideBegin);
            goto L138
        L130:
            float r42 = r13.getFloat(r10, this.circleAngle) % 360.0f;
            this.circleAngle = r42;
            if (r42 >= 0.0f) goto L138;
            this.circleAngle = (360.0f - r42) % 360.0f;
            goto L138
        L133:
            this.circleRadius = r13.getDimensionPixelSize(r10, this.circleRadius);
            goto L138
        L134:
            int r43 = r13.getResourceId(r10, this.circleConstraint);
            this.circleConstraint = r43;
            if (r43 != (-1)) goto L138;
            this.circleConstraint = r13.getInt(r10, -1);
            goto L138
        L137:
            this.orientation = r13.getInt(r10, this.orientation);
            goto L138
        L142:
            this.matchConstraintMaxWidth = r13.getDimensionPixelSize(r10, this.matchConstraintMaxWidth);     // Catch: Exception -> L64
        L65:
            if (r13.getInt(r10, this.matchConstraintMaxWidth) != (-2)) goto L138;
            this.matchConstraintMaxWidth = -2;
            goto L138
        L144:
            this.matchConstraintMinHeight = r13.getDimensionPixelSize(r10, this.matchConstraintMinHeight);     // Catch: Exception -> L58
        L59:
            if (r13.getInt(r10, this.matchConstraintMinHeight) != (-2)) goto L138;
            this.matchConstraintMinHeight = -2;
            goto L138
        L146:
            this.matchConstraintMinWidth = r13.getDimensionPixelSize(r10, this.matchConstraintMinWidth);     // Catch: Exception -> L69
        L70:
            if (r13.getInt(r10, this.matchConstraintMinWidth) != (-2)) goto L138;
            this.matchConstraintMinWidth = -2;
            goto L138
        L150:
            this.matchConstraintMaxHeight = r13.getDimensionPixelSize(r10, this.matchConstraintMaxHeight);     // Catch: Exception -> L53
        L54:
            if (r13.getInt(r10, this.matchConstraintMaxHeight) != (-2)) goto L138;
            this.matchConstraintMaxHeight = -2;
            goto L138
        L139:
            r13.recycle();
            validate();
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneStartMargin = -1;
            this.goneEndMargin = -1;
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
            this.horizontalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.verticalDimensionFixed = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.needsBaseline = false;
            this.isGuideline = false;
            this.isHelper = false;
            this.isInPlaceholder = false;
            this.isVirtualGroup = false;
            this.resolvedLeftToLeft = -1;
            this.resolvedLeftToRight = -1;
            this.resolvedRightToLeft = -1;
            this.resolvedRightToRight = -1;
            this.resolveGoneLeftMargin = -1;
            this.resolveGoneRightMargin = -1;
            this.resolvedHorizontalBias = 0.5f;
            this.widget = new ConstraintWidget();
            this.helped = false;
        }
    }

    public class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;
        final /* synthetic */ ConstraintLayout this$0;

        public Measurer(ConstraintLayout r5, ConstraintLayout r10) {
            this.this$0 = r5;
            this.layout = r10;
        }

        private boolean isSimilarSpec(int r5, int r10, int r11) {
            if (r5 != r10) goto L5;
            return ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L5:
            int r12 = View.MeasureSpec.getMode(r5);
            View.MeasureSpec.getSize(r5);
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getSize(r10);
            if (r13 == 1073741824) goto L8;
            return false;
        L8:
            if (r12 == Integer.MIN_VALUE) goto L10;
            if (r12 == 0) goto L10;
            return false;
        L10:
            if (r11 != r14) goto L15;
            return ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L15:
            return false;
        }

        public void captureLayoutInfos(int r5, int r10, int r11, int r12, int r13, int r14) {
            this.paddingTop = r11;
            this.paddingBottom = r12;
            this.paddingWidth = r13;
            this.paddingHeight = r14;
            this.layoutWidthSpec = r5;
            this.layoutHeightSpec = r10;
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
        public final void didMeasures() {
            int r5 = this.layout.getChildCount();
            int r10 = 0;
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L8;
            View r12 = this.layout.getChildAt(r11);
            if ((r12 instanceof Placeholder) == false) goto L7;
            ((Placeholder) r12).updatePostMeasure(this.layout);
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            int r13 = ConstraintLayout.access$100(this.layout).size();
            if (r13 <= 0) goto L12;
        L10:
            if (r10 >= r13) goto L17;
            ((ConstraintHelper) ConstraintLayout.access$100(this.layout).get(r10)).updatePostMeasure(this.layout);
            r10 = r10 + 1;
            goto L10
        L17:
            return;
        }

        @Override // androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measurer
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
            ConstraintWidget.DimensionBehaviour r5 = r19.horizontalBehavior;
            ConstraintWidget.DimensionBehaviour r10 = r19.verticalBehavior;
            int r11 = r19.horizontalDimension;
            int r12 = r19.verticalDimension;
            int r13 = this.paddingTop + this.paddingBottom;
            int r14 = this.paddingWidth;
            View r15 = (View) r18.getCompanionWidget();
            int[] r16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            int r17 = r16[r5.ordinal()];
            if (r17 == 1) goto L44;
            if (r17 == 2) goto L43;
            if (r17 == 3) goto L42;
            if (r17 == 4) goto L20;
            int r20 = 0;
        L45:
            int r21 = r16[r10.ordinal()];
            if (r21 == 1) goto L77;
            if (r21 != 2) goto L49;
            int r22 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r13, -2);
        L78:
            ConstraintWidgetContainer r23 = (ConstraintWidgetContainer) r18.getParent();
            if (r23 != null) goto L81;
        L100:
            ConstraintWidget.DimensionBehaviour r24 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (r5 != r24) goto L103;
            boolean r25 = true;
        L104:
            if (r10 != r24) goto L106;
            boolean r26 = true;
        L107:
            ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (r10 != r110) goto L110;
        L113:
            boolean r27 = true;
        L114:
            if (r5 != r110) goto L116;
        L119:
            boolean r28 = true;
        L121:
            if (r25 == true) goto L123;
        L125:
            boolean r111 = false;
        L126:
            if (r26 == true) goto L128;
        L130:
            boolean r112 = false;
        L131:
            if (r15 != null) goto L133;
            return;
        L133:
            LayoutParams r113 = (LayoutParams) r15.getLayoutParams();
            int r114 = r19.measureStrategy;
            if (r114 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L146;
            if (r114 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L146;
            if (r25 == false) goto L146;
            if (r18.mMatchConstraintDefaultWidth != 0) goto L146;
            if (r26 == false) goto L146;
            if (r18.mMatchConstraintDefaultHeight != 0) goto L146;
            int r29 = -1;
            int r30 = 0;
            int r115 = 0;
            int r116 = 0;
        L185:
            if (r115 == r29) goto L187;
            boolean r31 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L189:
            if (r116 == r19.horizontalDimension) goto L191;
        L194:
            boolean r32 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L195:
            r19.measuredNeedsSolverPass = r32;
            if (r113.needsBaseline == false) goto L198;
            r31 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        L198:
            if (r31 == true) goto L200;
        L204:
            r19.measuredWidth = r116;
            r19.measuredHeight = r30;
            r19.measuredHasBaseline = r31;
            r19.measuredBaseline = r115;
            return;
        L200:
            if (r115 == (-1)) goto L204;
            if (r18.getBaselineDistance() == r115) goto L204;
            r19.measuredNeedsSolverPass = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            goto L204
        L191:
            if (r30 != r19.verticalDimension) goto L194;
            r32 = false;
            goto L195
        L187:
            r31 = false;
        L146:
            if ((r15 instanceof VirtualLayout) == true) goto L148;
        L150:
            r15.measure(r20, r22);
        L151:
            r18.setLastMeasureSpec(r20, r22);
            int r33 = r15.getMeasuredWidth();
            int r34 = r15.getMeasuredHeight();
            r115 = r15.getBaseline();
            int r117 = r18.mMatchConstraintMinWidth;
            if (r117 <= 0) goto L154;
            r116 = Math.max(r117, r33);
        L155:
            int r35 = r18.mMatchConstraintMaxWidth;
            if (r35 <= 0) goto L158;
            r116 = Math.min(r35, r116);
        L158:
            int r36 = r18.mMatchConstraintMinHeight;
            if (r36 <= 0) goto L161;
            r30 = Math.max(r36, r34);
        L162:
            int r37 = r18.mMatchConstraintMaxHeight;
            if (r37 <= 0) goto L166;
            r30 = Math.min(r37, r30);
        L166:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 1) == false) goto L168;
        L174:
            if (r33 != r116) goto L179;
            if (r34 != r30) goto L179;
        L177:
            r29 = -1;
        L179:
            if (r33 == r116) goto L181;
            int r38 = View.MeasureSpec.makeMeasureSpec(r116, BasicMeasure.EXACTLY);
        L182:
            if (r34 == r30) goto L184;
            r22 = View.MeasureSpec.makeMeasureSpec(r30, BasicMeasure.EXACTLY);
        L184:
            r15.measure(r38, r22);
            r18.setLastMeasureSpec(r38, r22);
            r116 = r15.getMeasuredWidth();
            r30 = r15.getMeasuredHeight();
            r115 = r15.getBaseline();
            goto L177
        L181:
            r38 = r20;
            goto L182
        L168:
            if (r111 == false) goto L171;
            if (r27 == false) goto L171;
            r116 = (int) ((r30 * r18.mDimensionRatio) + 0.5f);
        L171:
            if (r112 == false) goto L174;
            if (r28 == false) goto L174;
            r30 = (int) ((r116 / r18.mDimensionRatio) + 0.5f);
            goto L174
        L161:
            r30 = r34;
            goto L162
        L154:
            r116 = r33;
            goto L155
        L148:
            if ((r18 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) == false) goto L150;
            ((VirtualLayout) r15).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout) r18, r20, r22);
            goto L151
        L128:
            if (r18.mDimensionRatio <= 0.0f) goto L130;
            r112 = true;
            goto L131
        L123:
            if (r18.mDimensionRatio <= 0.0f) goto L125;
            r111 = true;
            goto L126
        L116:
            if (r5 == ConstraintWidget.DimensionBehaviour.FIXED) goto L119;
            r28 = false;
            goto L121
        L110:
            if (r10 == ConstraintWidget.DimensionBehaviour.FIXED) goto L113;
            r27 = false;
            goto L114
        L106:
            r26 = false;
            goto L107
        L103:
            r25 = false;
            goto L104
        L81:
            if (Optimizer.enabled(ConstraintLayout.access$000(this.this$0), 256) == false) goto L100;
            if (r15.getMeasuredWidth() != r18.getWidth()) goto L100;
            if (r15.getMeasuredWidth() >= r23.getWidth()) goto L100;
            if (r15.getMeasuredHeight() != r18.getHeight()) goto L100;
            if (r15.getMeasuredHeight() >= r23.getHeight()) goto L100;
            if (r15.getBaseline() != r18.getBaselineDistance()) goto L100;
            if (r18.isMeasureRequested() == true) goto L100;
            if (isSimilarSpec(r18.getLastHorizontalMeasureSpec(), r20, r18.getWidth()) == false) goto L100;
            if (isSimilarSpec(r18.getLastVerticalMeasureSpec(), r22, r18.getHeight()) == false) goto L100;
            r19.measuredWidth = r18.getWidth();
            r19.measuredHeight = r18.getHeight();
            r19.measuredBaseline = r18.getBaselineDistance();
            return;
        L49:
            if (r21 != 3) goto L51;
            r22 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r18.getVerticalMargin() + r13, -1);
            goto L78
        L51:
            if (r21 == 4) goto L53;
            r22 = 0;
            goto L78
        L53:
            r22 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, r13, -2);
            if (r18.mMatchConstraintDefaultHeight != 1) goto L56;
            boolean r39 = true;
        L57:
            int r40 = r19.measureStrategy;
            if (r40 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L62;
            if (r40 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L78;
        L62:
            if (r15.getMeasuredWidth() != r18.getWidth()) goto L64;
            boolean r41 = true;
        L66:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L74;
            if (r39 == false) goto L74;
            if (r39 == false) goto L71;
            if (r41 == true) goto L74;
        L71:
            if ((r15 instanceof Placeholder) == true) goto L74;
            if (r18.isResolvedVertically() == false) goto L78;
        L74:
            r22 = View.MeasureSpec.makeMeasureSpec(r18.getHeight(), BasicMeasure.EXACTLY);
            goto L78
        L64:
            r41 = false;
            goto L66
        L56:
            r39 = false;
            goto L57
        L77:
            r22 = View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY);
            goto L78
        L20:
            r20 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r14, -2);
            if (r18.mMatchConstraintDefaultWidth != 1) goto L23;
            boolean r42 = true;
        L24:
            int r118 = r19.measureStrategy;
            if (r118 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS) goto L29;
            if (r118 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L45;
        L29:
            if (r15.getMeasuredHeight() != r18.getHeight()) goto L31;
            boolean r119 = true;
        L33:
            if (r19.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) goto L41;
            if (r42 == false) goto L41;
            if (r42 == false) goto L38;
            if (r119 == true) goto L41;
        L38:
            if ((r15 instanceof Placeholder) == true) goto L41;
            if (r18.isResolvedHorizontally() == false) goto L45;
        L41:
            r20 = View.MeasureSpec.makeMeasureSpec(r18.getWidth(), BasicMeasure.EXACTLY);
            goto L45
        L31:
            r119 = false;
            goto L33
        L23:
            r42 = false;
            goto L24
        L42:
            r20 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r18.getHorizontalMargin() + r14, -1);
            goto L45
        L43:
            r20 = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, r14, -2);
            goto L45
        L44:
            r20 = View.MeasureSpec.makeMeasureSpec(r11, BasicMeasure.EXACTLY);
            goto L45
        }
    }

    public ConstraintLayout(@NonNull Context r5) {
        super(r5);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
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

    public static /* synthetic */ int access$000(ConstraintLayout r5) {
        return r5.mOptimizationLevel;
    }

    public static /* synthetic */ ArrayList access$100(ConstraintLayout r5) {
        return r5.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int r5 = Math.max(0, getPaddingLeft());
        int r10 = Math.max(0, getPaddingRight()) + r5;
        int r11 = Math.max(0, getPaddingStart());
        int r12 = Math.max(0, getPaddingEnd()) + r11;
        if (r12 > 0) goto L5;
        return r10;
    L5:
        return r12;
    }

    private final ConstraintWidget getTargetWidget(int r5) {
        if (r5 == 0) goto L4;
        View r10 = this.mChildrenByIds.get(r5);
        if (r10 != null) goto L13;
        r10 = findViewById(r5);
        if (r10 == null) goto L13;
        if (r10 == this) goto L13;
        if (r10.getParent() != this) goto L13;
        onViewAdded(r10);
    L13:
        if (r10 == this) goto L15;
        if (r10 != null) goto L19;
        return null;
    L19:
        return ((LayoutParams) r10.getLayoutParams()).widget;
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
        int r5 = 0;
    L5:
        if (r5 >= r14) goto L36;
        int r15 = r13.getIndex(r5);
        if (r15 != R.styleable.ConstraintLayout_Layout_android_minWidth) goto L10;
        this.mMinWidth = r13.getDimensionPixelOffset(r15, this.mMinWidth);
    L35:
        r5 = r5 + 1;
        goto L5
    L10:
        if (r15 != R.styleable.ConstraintLayout_Layout_android_minHeight) goto L13;
        this.mMinHeight = r13.getDimensionPixelOffset(r15, this.mMinHeight);
        goto L35
    L13:
        if (r15 != R.styleable.ConstraintLayout_Layout_android_maxWidth) goto L16;
        this.mMaxWidth = r13.getDimensionPixelOffset(r15, this.mMaxWidth);
        goto L35
    L16:
        if (r15 != R.styleable.ConstraintLayout_Layout_android_maxHeight) goto L19;
        this.mMaxHeight = r13.getDimensionPixelOffset(r15, this.mMaxHeight);
        goto L35
    L19:
        if (r15 != R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) goto L22;
        this.mOptimizationLevel = r13.getInt(r15, this.mOptimizationLevel);
        goto L35
    L22:
        if (r15 != R.styleable.ConstraintLayout_Layout_layoutDescription) goto L29;
        int r16 = r13.getResourceId(r15, 0);
        if (r16 == 0) goto L35;
        parseLayoutDescription(r16);     // Catch: Resources.NotFoundException -> L27
    L27:
        this.mConstraintLayoutSpec = null;
        goto L35
    L29:
        if (r15 != R.styleable.ConstraintLayout_Layout_constraintSet) goto L35;
        int r17 = r13.getResourceId(r15, 0);
        ConstraintSet r18 = new ConstraintSet();     // Catch: Resources.NotFoundException -> L33
        this.mConstraintSet = r18;     // Catch: Resources.NotFoundException -> L33
        r18.load(getContext(), r17);     // Catch: Resources.NotFoundException -> L33
    L34:
        this.mConstraintSetId = r17;
    L33:
        this.mConstraintSet = null;
        goto L34
    L36:
        r13.recycle();
    L37:
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
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
        int r5 = 0;
    L3:
        if (r5 >= r11) goto L10;
        ConstraintWidget r12 = getViewWidget(getChildAt(r5));
        if (r12 == null) goto L8;
        r12.reset();
    L8:
        r5 = r5 + 1;
        goto L3
    L10:
        if (r10 == false) goto L20;
        int r13 = 0;
    L12:
        if (r13 >= r11) goto L20;
        View r14 = getChildAt(r13);
        String r15 = getResources().getResourceName(r14.getId());     // Catch: Resources.NotFoundException -> L54
        setDesignInformation(0, r15, Integer.valueOf(r14.getId()));     // Catch: Resources.NotFoundException -> L54
        int r16 = r15.indexOf(47);     // Catch: Resources.NotFoundException -> L54
        if (r16 == (-1)) goto L17;
        r15 = r15.substring(r16 + 1);     // Catch: Resources.NotFoundException -> L54
    L17:
        getTargetWidget(r14.getId()).setDebugName(r15);     // Catch: Resources.NotFoundException -> L54
    L18:
        r13 = r13 + 1;
    L20:
        if (this.mConstraintSetId == (-1)) goto L29;
        int r17 = 0;
    L22:
        if (r17 >= r11) goto L29;
        View r18 = getChildAt(r17);
        if (r18.getId() != this.mConstraintSetId) goto L28;
        if ((r18 instanceof Constraints) == false) goto L28;
        this.mConstraintSet = ((Constraints) r18).getConstraintSet();
    L28:
        r17 = r17 + 1;
    L29:
        ConstraintSet r19 = this.mConstraintSet;
        if (r19 == null) goto L32;
        r19.applyToInternal(this, USE_CONSTRAINTS_HELPER);
    L32:
        this.mLayoutWidget.removeAllChildren();
        int r20 = this.mConstraintHelpers.size();
        if (r20 <= 0) goto L37;
        int r21 = 0;
    L35:
        if (r21 >= r20) goto L37;
        this.mConstraintHelpers.get(r21).updatePreLayout(this);
        r21 = r21 + 1;
    L37:
        int r22 = 0;
    L38:
        if (r22 >= r11) goto L43;
        View r23 = getChildAt(r22);
        if ((r23 instanceof Placeholder) == false) goto L42;
        ((Placeholder) r23).updatePreLayout(this);
    L42:
        r22 = r22 + 1;
        goto L38
    L43:
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        int r24 = 0;
    L44:
        if (r24 >= r11) goto L46;
        View r25 = getChildAt(r24);
        this.mTempMapIdToWidget.put(r25.getId(), getViewWidget(r25));
        r24 = r24 + 1;
        goto L44
    L46:
        int r26 = 0;
    L47:
        if (r26 >= r11) goto L53;
        View r27 = getChildAt(r26);
        ConstraintWidget r28 = getViewWidget(r27);
        if (r28 == null) goto L52;
        LayoutParams r29 = (LayoutParams) r27.getLayoutParams();
        this.mLayoutWidget.add(r28);
        applyConstraintsFromLayoutParams(r10, r27, r28, r29, this.mTempMapIdToWidget);
    L52:
        r26 = r26 + 1;
        goto L47
    }

    private boolean updateHierarchy() {
        int r5 = getChildCount();
        boolean r10 = false;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L8;
        if (getChildAt(r11).isLayoutRequested() == true) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        r10 = USE_CONSTRAINTS_HELPER;
    L8:
        if (r10 == false) goto L10;
        setChildrenConstraints();
    L10:
        return r10;
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r5, r10, r11);
    }

    public void applyConstraintsFromLayoutParams(boolean r19, View r20, ConstraintWidget r21, LayoutParams r22, SparseArray<ConstraintWidget> r23) {
        r22.validate();
        r22.helped = false;
        r21.setVisibility(r20.getVisibility());
        if (r22.isInPlaceholder == false) goto L5;
        r21.setInPlaceholder(USE_CONSTRAINTS_HELPER);
        r21.setVisibility(8);
    L5:
        r21.setCompanionWidget(r20);
        if ((r20 instanceof ConstraintHelper) == false) goto L9;
        ((ConstraintHelper) r20).resolveRtl(r21, this.mLayoutWidget.isRtl());
    L9:
        if (r22.isGuideline == false) goto L17;
        androidx.constraintlayout.solver.widgets.Guideline r5 = (androidx.constraintlayout.solver.widgets.Guideline) r21;
        int r10 = r22.resolvedGuideBegin;
        int r11 = r22.resolvedGuideEnd;
        float r12 = r22.resolvedGuidePercent;
        if (r12 == (-1.0f)) goto L13;
        r5.setGuidePercent(r12);
        return;
    L13:
        if (r10 == (-1)) goto L15;
        r5.setGuideBegin(r10);
        return;
    L15:
        if (r11 == (-1)) goto L110;
        r5.setGuideEnd(r11);
        return;
    L110:
        return;
    L17:
        int r13 = r22.resolvedLeftToLeft;
        int r14 = r22.resolvedLeftToRight;
        int r15 = r22.resolvedRightToLeft;
        int r16 = r22.resolvedRightToRight;
        int r17 = r22.resolveGoneLeftMargin;
        int r18 = r22.resolveGoneRightMargin;
        float r24 = r22.resolvedHorizontalBias;
        int r25 = r22.circleConstraint;
        if (r25 == (-1)) goto L22;
        ConstraintWidget r26 = r23.get(r25);
        if (r26 == null) goto L74;
        r21.connectCircularConstraint(r26, r22.circleAngle, r22.circleRadius);
    L74:
        if (r19 == false) goto L81;
        int r27 = r22.editorAbsoluteX;
        if (r27 == (-1)) goto L78;
    L79:
        r21.setOrigin(r27, r22.editorAbsoluteY);
        goto L81
    L78:
        if (r22.editorAbsoluteY != (-1)) goto L79;
    L81:
        if (r22.horizontalDimensionFixed == false) goto L83;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r21.setWidth(((ViewGroup.MarginLayoutParams) r22).width);
        if (((ViewGroup.MarginLayoutParams) r22).width != (-2)) goto L94;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L94:
        if (r22.verticalDimensionFixed == false) goto L96;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
        r21.setHeight(((ViewGroup.MarginLayoutParams) r22).height);
        if (((ViewGroup.MarginLayoutParams) r22).height != (-2)) goto L106;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
    L106:
        r21.setDimensionRatio(r22.dimensionRatio);
        r21.setHorizontalWeight(r22.horizontalWeight);
        r21.setVerticalWeight(r22.verticalWeight);
        r21.setHorizontalChainStyle(r22.horizontalChainStyle);
        r21.setVerticalChainStyle(r22.verticalChainStyle);
        r21.setHorizontalMatchStyle(r22.matchConstraintDefaultWidth, r22.matchConstraintMinWidth, r22.matchConstraintMaxWidth, r22.matchConstraintPercentWidth);
        r21.setVerticalMatchStyle(r22.matchConstraintDefaultHeight, r22.matchConstraintMinHeight, r22.matchConstraintMaxHeight, r22.matchConstraintPercentHeight);
        return;
    L96:
        if (((ViewGroup.MarginLayoutParams) r22).height == (-1)) goto L98;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r21.setHeight(0);
        goto L106
    L98:
        if (r22.constrainedHeight == false) goto L100;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L101:
        ConstraintAnchor r28 = r21.getAnchor(ConstraintAnchor.Type.TOP);
        r28.mMargin = ((ViewGroup.MarginLayoutParams) r22).topMargin;
        ConstraintAnchor r29 = r21.getAnchor(ConstraintAnchor.Type.BOTTOM);
        r29.mMargin = ((ViewGroup.MarginLayoutParams) r22).bottomMargin;
        goto L106
    L100:
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L101
    L83:
        if (((ViewGroup.MarginLayoutParams) r22).width == (-1)) goto L85;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
        r21.setWidth(0);
        goto L94
    L85:
        if (r22.constrainedWidth == false) goto L87;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
    L88:
        ConstraintAnchor r30 = r21.getAnchor(ConstraintAnchor.Type.LEFT);
        r30.mMargin = ((ViewGroup.MarginLayoutParams) r22).leftMargin;
        ConstraintAnchor r31 = r21.getAnchor(ConstraintAnchor.Type.RIGHT);
        r31.mMargin = ((ViewGroup.MarginLayoutParams) r22).rightMargin;
        goto L94
    L87:
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
        goto L88
    L22:
        if (r13 == (-1)) goto L27;
        ConstraintWidget r32 = r23.get(r13);
        if (r32 == null) goto L26;
        ConstraintAnchor.Type r33 = ConstraintAnchor.Type.LEFT;
        float r110 = r24;
        r21.immediateConnect(r33, r32, r33, ((ViewGroup.MarginLayoutParams) r22).leftMargin, r17);
    L32:
        if (r15 == (-1)) goto L36;
        ConstraintWidget r34 = r23.get(r15);
        if (r34 == null) goto L40;
        r21.immediateConnect(ConstraintAnchor.Type.RIGHT, r34, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) r22).rightMargin, r18);
    L40:
        int r35 = r22.topToTop;
        if (r35 == (-1)) goto L45;
        ConstraintWidget r36 = r23.get(r35);
        if (r36 == null) goto L50;
        ConstraintAnchor.Type r37 = ConstraintAnchor.Type.TOP;
        r21.immediateConnect(r37, r36, r37, ((ViewGroup.MarginLayoutParams) r22).topMargin, r22.goneTopMargin);
    L50:
        int r38 = r22.bottomToTop;
        if (r38 == (-1)) goto L55;
        ConstraintWidget r39 = r23.get(r38);
        if (r39 == null) goto L60;
        r21.immediateConnect(ConstraintAnchor.Type.BOTTOM, r39, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) r22).bottomMargin, r22.goneBottomMargin);
    L60:
        int r40 = r22.baselineToBaseline;
        if (r40 == (-1)) goto L68;
        View r41 = this.mChildrenByIds.get(r40);
        ConstraintWidget r42 = r23.get(r22.baselineToBaseline);
        if (r42 == null) goto L68;
        if (r41 == null) goto L68;
        if ((r41.getLayoutParams() instanceof LayoutParams) == false) goto L68;
        LayoutParams r43 = (LayoutParams) r41.getLayoutParams();
        r22.needsBaseline = USE_CONSTRAINTS_HELPER;
        r43.needsBaseline = USE_CONSTRAINTS_HELPER;
        ConstraintAnchor.Type r44 = ConstraintAnchor.Type.BASELINE;
        r21.getAnchor(r44).connect(r42.getAnchor(r44), 0, -1, USE_CONSTRAINTS_HELPER);
        r21.setHasBaseline(USE_CONSTRAINTS_HELPER);
        r43.widget.setHasBaseline(USE_CONSTRAINTS_HELPER);
        r21.getAnchor(ConstraintAnchor.Type.TOP).reset();
        r21.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
    L68:
        float r45 = r110;
        if (r45 < 0.0f) goto L71;
        r21.setHorizontalBiasPercent(r45);
    L71:
        float r46 = r22.verticalBias;
        if (r46 < 0.0f) goto L74;
        r21.setVerticalBiasPercent(r46);
        goto L74
    L55:
        int r47 = r22.bottomToBottom;
        if (r47 == (-1)) goto L60;
        ConstraintWidget r48 = r23.get(r47);
        if (r48 == null) goto L60;
        ConstraintAnchor.Type r49 = ConstraintAnchor.Type.BOTTOM;
        r21.immediateConnect(r49, r48, r49, ((ViewGroup.MarginLayoutParams) r22).bottomMargin, r22.goneBottomMargin);
        goto L60
    L45:
        int r50 = r22.topToBottom;
        if (r50 == (-1)) goto L50;
        ConstraintWidget r51 = r23.get(r50);
        if (r51 == null) goto L50;
        r21.immediateConnect(ConstraintAnchor.Type.TOP, r51, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) r22).topMargin, r22.goneTopMargin);
        goto L50
    L36:
        if (r16 == (-1)) goto L40;
        ConstraintWidget r52 = r23.get(r16);
        if (r52 == null) goto L40;
        ConstraintAnchor.Type r53 = ConstraintAnchor.Type.RIGHT;
        r21.immediateConnect(r53, r52, r53, ((ViewGroup.MarginLayoutParams) r22).rightMargin, r18);
        goto L40
    L26:
        r110 = r24;
        goto L32
    L27:
        r110 = r24;
        if (r14 == (-1)) goto L32;
        ConstraintWidget r54 = r23.get(r14);
        if (r54 == null) goto L32;
        r21.immediateConnect(ConstraintAnchor.Type.LEFT, r54, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) r22).leftMargin, r17);
        goto L32
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r19) {
        ArrayList<ConstraintHelper> r5 = this.mConstraintHelpers;
        if (r5 == null) goto L9;
        int r10 = r5.size();
        if (r10 <= 0) goto L9;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L9;
        this.mConstraintHelpers.get(r11).updatePreDraw(this);
        r11 = r11 + 1;
    L9:
        super.dispatchDraw(r19);
        if (isInEditMode() == false) goto L24;
        int r12 = getChildCount();
        float r13 = getWidth();
        float r14 = getHeight();
        int r15 = 0;
    L12:
        if (r15 >= r12) goto L32;
        View r16 = getChildAt(r15);
        if (r16.getVisibility() == 8) goto L23;
        Object r17 = r16.getTag();
        if (r17 == null) goto L23;
        if ((r17 instanceof String) == false) goto L23;
        String[] r18 = ((String) r17).split(",");
        if (r18.length != 4) goto L23;
        int r20 = Integer.parseInt(r18[0]);
        int r21 = Integer.parseInt(r18[1]);
        int r22 = Integer.parseInt(r18[2]);
        int r23 = (int) ((r20 / 1080.0f) * r13);
        int r24 = (int) ((r21 / 1920.0f) * r14);
        int r25 = (int) ((Integer.parseInt(r18[3]) / 1920.0f) * r14);
        Paint r110 = new Paint();
        r110.setColor(SupportMenu.CATEGORY_MASK);
        float r111 = r23;
        float r112 = r24;
        float r26 = r23 + ((int) ((r22 / 1080.0f) * r13));
        r19.drawLine(r111, r112, r26, r112, r110);
        float r27 = r24 + r25;
        r19.drawLine(r26, r112, r26, r27, r110);
        r19.drawLine(r26, r27, r111, r27, r110);
        r19.drawLine(r111, r27, r111, r112, r110);
        r110.setColor(-16711936);
        r19.drawLine(r111, r112, r26, r27, r110);
        r19.drawLine(r111, r27, r26, r112, r110);
    L23:
        r15 = r15 + 1;
        goto L12
    L32:
        return;
    }

    public void fillMetrics(Metrics r5) {
        this.mMetrics = r5;
        this.mLayoutWidget.fillMetrics(r5);
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
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public Object getDesignInformation(int r5, Object r10) {
        if (r5 == 0) goto L4;
        return null;
    L4:
        if ((r10 instanceof String) == false) goto L13;
        String r11 = (String) r10;
        HashMap<String, Integer> r12 = this.mDesignIds;
        if (r12 != null) goto L8;
        return null;
    L8:
        if (r12.containsKey(r11) == true) goto L10;
        return null;
    L10:
        return this.mDesignIds.get(r11);
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

    public View getViewById(int r5) {
        return this.mChildrenByIds.get(r5);
    }

    public final ConstraintWidget getViewWidget(View r5) {
        if (r5 == this) goto L4;
        if (r5 != null) goto L8;
        return null;
    L8:
        return ((LayoutParams) r5.getLayoutParams()).widget;
    L4:
        return this.mLayoutWidget;
    }

    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) goto L5;
    L7:
        return false;
    L5:
        if (1 != getLayoutDirection()) goto L7;
        return USE_CONSTRAINTS_HELPER;
    }

    public void loadLayoutDescription(int r5) {
        if (r5 != 0) goto L9;
        this.mConstraintLayoutSpec = null;
        return;
    L9:
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r5);     // Catch: Resources.NotFoundException -> L6
        return;
    L6:
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        boolean r16 = isInEditMode();
        int r17 = 0;
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L23;
        View r19 = getChildAt(r18);
        LayoutParams r5 = (LayoutParams) r19.getLayoutParams();
        ConstraintWidget r20 = r5.widget;
        if (r19.getVisibility() != 8) goto L15;
        if (r5.isGuideline == true) goto L15;
        if (r5.isHelper == true) goto L15;
        if (r5.isVirtualGroup == true) goto L15;
        if (r16 == true) goto L15;
    L22:
        r18 = r18 + 1;
    L15:
        if (r5.isInPlaceholder == true) goto L22;
        int r21 = r20.getX();
        int r22 = r20.getY();
        int r23 = r20.getWidth() + r21;
        int r24 = r20.getHeight() + r22;
        r19.layout(r21, r22, r23, r24);
        if ((r19 instanceof Placeholder) == false) goto L22;
        View r110 = ((Placeholder) r19).getContent();
        if (r110 == null) goto L22;
        r110.setVisibility(0);
        r110.layout(r21, r22, r23, r24);
        goto L22
    L23:
        int r25 = this.mConstraintHelpers.size();
        if (r25 <= 0) goto L27;
    L25:
        if (r17 >= r25) goto L35;
        this.mConstraintHelpers.get(r17).updatePostLayout(this);
        r17 = r17 + 1;
        goto L25
    L35:
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mDirtyHierarchy == true) goto L11;
        int r5 = getChildCount();
        int r12 = 0;
    L5:
        if (r12 >= r5) goto L11;
        if (getChildAt(r12).isLayoutRequested() == true) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    L11:
        if (this.mDirtyHierarchy == true) goto L29;
        int r13 = this.mOnMeasureWidthMeasureSpec;
        if (r13 == r10) goto L15;
    L18:
        if (r13 != r10) goto L29;
        if (View.MeasureSpec.getMode(r10) != 1073741824) goto L29;
        if (View.MeasureSpec.getMode(r11) != Integer.MIN_VALUE) goto L29;
        if (View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) != Integer.MIN_VALUE) goto L29;
        if (View.MeasureSpec.getSize(r11) < this.mLayoutWidget.getHeight()) goto L29;
        this.mOnMeasureWidthMeasureSpec = r10;
        this.mOnMeasureHeightMeasureSpec = r11;
        resolveMeasuredDimension(r10, r11, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
    L15:
        if (this.mOnMeasureHeightMeasureSpec != r11) goto L18;
        resolveMeasuredDimension(r10, r11, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        return;
    L29:
        this.mOnMeasureWidthMeasureSpec = r10;
        this.mOnMeasureHeightMeasureSpec = r11;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy == false) goto L34;
        this.mDirtyHierarchy = false;
        if (updateHierarchy() == false) goto L34;
        this.mLayoutWidget.updateHierarchy();
    L34:
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, r10, r11);
        resolveMeasuredDimension(r10, r11, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r5) {
        super.onViewAdded(r5);
        ConstraintWidget r10 = getViewWidget(r5);
        if ((r5 instanceof Guideline) == false) goto L8;
        if ((r10 instanceof androidx.constraintlayout.solver.widgets.Guideline) == true) goto L8;
        LayoutParams r11 = (LayoutParams) r5.getLayoutParams();
        androidx.constraintlayout.solver.widgets.Guideline r12 = new androidx.constraintlayout.solver.widgets.Guideline();
        r11.widget = r12;
        r11.isGuideline = USE_CONSTRAINTS_HELPER;
        r12.setOrientation(r11.orientation);
    L8:
        if ((r5 instanceof ConstraintHelper) == false) goto L12;
        ConstraintHelper r13 = (ConstraintHelper) r5;
        r13.validateParams();
        ((LayoutParams) r5.getLayoutParams()).isHelper = USE_CONSTRAINTS_HELPER;
        if (this.mConstraintHelpers.contains(r13) == true) goto L12;
        this.mConstraintHelpers.add(r13);
    L12:
        this.mChildrenByIds.put(r5.getId(), r5);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        this.mChildrenByIds.remove(r5.getId());
        ConstraintWidget r10 = getViewWidget(r5);
        this.mLayoutWidget.remove(r10);
        this.mConstraintHelpers.remove(r5);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    public void parseLayoutDescription(int r5) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r5) {
        super.removeView(r5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int r5, int r10, int r11, int r12, boolean r13, boolean r14) {
        Measurer r15 = this.mMeasurer;
        int r16 = r15.paddingHeight;
        int r17 = View.resolveSizeAndState(r11 + r15.paddingWidth, r5, 0);
        int r18 = View.resolveSizeAndState(r12 + r16, r10, 0);
        int r19 = r17 & ViewCompat.MEASURED_SIZE_MASK;
        int r20 = r18 & ViewCompat.MEASURED_SIZE_MASK;
        int r21 = Math.min(this.mMaxWidth, r19);
        int r22 = Math.min(this.mMaxHeight, r20);
        if (r13 == false) goto L5;
        r21 = r21 | 16777216;
    L5:
        if (r14 == false) goto L7;
        r22 = r22 | 16777216;
    L7:
        setMeasuredDimension(r21, r22);
        this.mLastMeasureWidth = r21;
        this.mLastMeasureHeight = r22;
    }

    public void resolveSystem(ConstraintWidgetContainer r18, int r19, int r20, int r21) {
        int r10 = View.MeasureSpec.getMode(r20);
        int r5 = View.MeasureSpec.getSize(r20);
        int r11 = View.MeasureSpec.getMode(r21);
        int r12 = View.MeasureSpec.getSize(r21);
        int r16 = Math.max(0, getPaddingTop());
        int r13 = Math.max(0, getPaddingBottom());
        int r14 = r16 + r13;
        int r15 = getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(r20, r21, r16, r13, r15, r14);
        int r17 = Math.max(0, getPaddingStart());
        int r22 = Math.max(0, getPaddingEnd());
        if (r17 > 0) goto L8;
        if (r22 > 0) goto L8;
        r22 = Math.max(0, getPaddingLeft());
    L11:
        int r110 = r5 - r15;
        int r111 = r12 - r14;
        setSelfDimensionBehaviour(r18, r10, r110, r11, r111);
        r18.measure(r19, r10, r110, r11, r111, this.mLastMeasureWidth, this.mLastMeasureHeight, r22, r16);
        return;
    L8:
        if (isRtl() == true) goto L11;
        r22 = r17;
        goto L11
    }

    public void setConstraintSet(ConstraintSet r5) {
        this.mConstraintSet = r5;
    }

    public void setDesignInformation(int r5, Object r10, Object r11) {
        if (r5 == 0) goto L4;
        return;
    L4:
        if ((r10 instanceof String) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof Integer) == true) goto L8;
        return;
    L8:
        if (this.mDesignIds != null) goto L10;
        this.mDesignIds = new HashMap();
    L10:
        String r12 = (String) r10;
        int r13 = r12.indexOf("/");
        if (r13 == (-1)) goto L13;
        r12 = r12.substring(r13 + 1);
    L13:
        Integer r14 = (Integer) r11;
        r14.intValue();
        this.mDesignIds.put(r12, r14);
    }

    @Override // android.view.View
    public void setId(int r5) {
        this.mChildrenByIds.remove(getId());
        super.setId(r5);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int r5) {
        if (r5 != this.mMaxHeight) goto L5;
        return;
    L5:
        this.mMaxHeight = r5;
        requestLayout();
    }

    public void setMaxWidth(int r5) {
        if (r5 != this.mMaxWidth) goto L5;
        return;
    L5:
        this.mMaxWidth = r5;
        requestLayout();
    }

    public void setMinHeight(int r5) {
        if (r5 != this.mMinHeight) goto L5;
        return;
    L5:
        this.mMinHeight = r5;
        requestLayout();
    }

    public void setMinWidth(int r5) {
        if (r5 != this.mMinWidth) goto L5;
        return;
    L5:
        this.mMinWidth = r5;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener r5) {
        this.mConstraintsChangedListener = r5;
        ConstraintLayoutStates r10 = this.mConstraintLayoutSpec;
        if (r10 == null) goto L6;
        r10.setOnConstraintsChanged(r5);
        return;
    }

    public void setOptimizationLevel(int r5) {
        this.mOptimizationLevel = r5;
        this.mLayoutWidget.setOptimizationLevel(r5);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer r10, int r11, int r12, int r13, int r14) {
        Measurer r5 = this.mMeasurer;
        int r15 = r5.paddingHeight;
        int r16 = r5.paddingWidth;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.FIXED;
        int r18 = getChildCount();
        if (r11 == Integer.MIN_VALUE) goto L12;
        if (r11 == 0) goto L9;
        if (r11 == 1073741824) goto L8;
        ConstraintWidget.DimensionBehaviour r19 = r17;
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
        r10.setMaxWidth(this.mMaxWidth - r16);
        r10.setMaxHeight(this.mMaxHeight - r15);
        r10.setMinWidth(0);
        r10.setMinHeight(0);
        r10.setHorizontalDimensionBehaviour(r19);
        r10.setWidth(r12);
        r10.setVerticalDimensionBehaviour(r17);
        r10.setHeight(r14);
        r10.setMinWidth(this.mMinWidth - r16);
        r10.setMinHeight(this.mMinHeight - r15);
        return;
    L29:
        if (r14 == r10.getHeight()) goto L31;
    L19:
        r14 = Math.min(this.mMaxHeight - r15, r14);
        goto L27
    L20:
        r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != 0) goto L18;
        r14 = Math.max(0, this.mMinHeight);
        goto L27
    L23:
        r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != 0) goto L27;
        r14 = Math.max(0, this.mMinHeight);
        goto L27
    L8:
        r12 = Math.min(this.mMaxWidth - r16, r12);
        r19 = r17;
        goto L15
    L9:
        r19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != 0) goto L7;
        r12 = Math.max(0, this.mMinWidth);
        goto L15
    L12:
        r19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != 0) goto L15;
        r12 = Math.max(0, this.mMinWidth);
        goto L15
    }

    public void setState(int r5, int r10, int r11) {
        ConstraintLayoutStates r12 = this.mConstraintLayoutSpec;
        if (r12 == null) goto L6;
        r12.updateConstraints(r5, r10, r11);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }

    public ConstraintLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
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
        init(r10, 0, 0);
    }

    public ConstraintLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
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
        init(r10, r11, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context r5, @Nullable AttributeSet r10, int r11, int r12) {
        super(r5, r10, r11, r12);
        this.mChildrenByIds = new SparseArray();
        this.mConstraintHelpers = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
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
        init(r10, r11, r12);
    }
}
