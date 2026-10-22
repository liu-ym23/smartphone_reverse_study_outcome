package androidx.constraintlayout.widget;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = null;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId;
    private HashMap<String, ConstraintAttribute> mSavedAttributes;
    private boolean mValidate;

    public static class Constraint {
        public final Layout layout;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        public Constraint() {
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        public static /* synthetic */ void access$000(Constraint r5, int r10, ConstraintLayout.LayoutParams r11) {
            r5.fillFrom(r10, r11);
        }

        public static /* synthetic */ void access$300(Constraint r5, ConstraintHelper r10, int r11, Constraints.LayoutParams r12) {
            r5.fillFromConstraints(r10, r11, r12);
        }

        public static /* synthetic */ void access$400(Constraint r5, int r10, Constraints.LayoutParams r11) {
            r5.fillFromConstraints(r10, r11);
        }

        public static /* synthetic */ void access$500(Constraint r5, String r10, int r11) {
            r5.setIntValue(r10, r11);
        }

        public static /* synthetic */ void access$600(Constraint r5, String r10, int r11) {
            r5.setColorValue(r10, r11);
        }

        public static /* synthetic */ void access$700(Constraint r5, String r10, float r11) {
            r5.setFloatValue(r10, r11);
        }

        public static /* synthetic */ void access$800(Constraint r5, String r10, String r11) {
            r5.setStringValue(r10, r11);
        }

        private void fillFrom(int r5, ConstraintLayout.LayoutParams r10) {
            this.mViewId = r5;
            Layout r11 = this.layout;
            r11.leftToLeft = r10.leftToLeft;
            r11.leftToRight = r10.leftToRight;
            r11.rightToLeft = r10.rightToLeft;
            r11.rightToRight = r10.rightToRight;
            r11.topToTop = r10.topToTop;
            r11.topToBottom = r10.topToBottom;
            r11.bottomToTop = r10.bottomToTop;
            r11.bottomToBottom = r10.bottomToBottom;
            r11.baselineToBaseline = r10.baselineToBaseline;
            r11.startToEnd = r10.startToEnd;
            r11.startToStart = r10.startToStart;
            r11.endToStart = r10.endToStart;
            r11.endToEnd = r10.endToEnd;
            r11.horizontalBias = r10.horizontalBias;
            r11.verticalBias = r10.verticalBias;
            r11.dimensionRatio = r10.dimensionRatio;
            r11.circleConstraint = r10.circleConstraint;
            r11.circleRadius = r10.circleRadius;
            r11.circleAngle = r10.circleAngle;
            r11.editorAbsoluteX = r10.editorAbsoluteX;
            r11.editorAbsoluteY = r10.editorAbsoluteY;
            r11.orientation = r10.orientation;
            r11.guidePercent = r10.guidePercent;
            r11.guideBegin = r10.guideBegin;
            r11.guideEnd = r10.guideEnd;
            r11.mWidth = ((ViewGroup.MarginLayoutParams) r10).width;
            r11.mHeight = ((ViewGroup.MarginLayoutParams) r10).height;
            r11.leftMargin = ((ViewGroup.MarginLayoutParams) r10).leftMargin;
            r11.rightMargin = ((ViewGroup.MarginLayoutParams) r10).rightMargin;
            r11.topMargin = ((ViewGroup.MarginLayoutParams) r10).topMargin;
            r11.bottomMargin = ((ViewGroup.MarginLayoutParams) r10).bottomMargin;
            r11.verticalWeight = r10.verticalWeight;
            r11.horizontalWeight = r10.horizontalWeight;
            r11.verticalChainStyle = r10.verticalChainStyle;
            r11.horizontalChainStyle = r10.horizontalChainStyle;
            r11.constrainedWidth = r10.constrainedWidth;
            r11.constrainedHeight = r10.constrainedHeight;
            r11.widthDefault = r10.matchConstraintDefaultWidth;
            r11.heightDefault = r10.matchConstraintDefaultHeight;
            r11.widthMax = r10.matchConstraintMaxWidth;
            r11.heightMax = r10.matchConstraintMaxHeight;
            r11.widthMin = r10.matchConstraintMinWidth;
            r11.heightMin = r10.matchConstraintMinHeight;
            r11.widthPercent = r10.matchConstraintPercentWidth;
            r11.heightPercent = r10.matchConstraintPercentHeight;
            r11.mConstraintTag = r10.constraintTag;
            r11.goneTopMargin = r10.goneTopMargin;
            r11.goneBottomMargin = r10.goneBottomMargin;
            r11.goneLeftMargin = r10.goneLeftMargin;
            r11.goneRightMargin = r10.goneRightMargin;
            r11.goneStartMargin = r10.goneStartMargin;
            r11.goneEndMargin = r10.goneEndMargin;
            r11.endMargin = r10.getMarginEnd();
            Layout r12 = this.layout;
            r12.startMargin = r10.getMarginStart();
        }

        private void fillFromConstraints(ConstraintHelper r5, int r10, Constraints.LayoutParams r11) {
            fillFromConstraints(r10, r11);
            if ((r5 instanceof Barrier) == false) goto L6;
            Layout r12 = this.layout;
            r12.mHelperType = 1;
            Barrier r13 = (Barrier) r5;
            r12.mBarrierDirection = r13.getType();
            Layout r14 = this.layout;
            r14.mReferenceIds = r13.getReferencedIds();
            Layout r15 = this.layout;
            r15.mBarrierMargin = r13.getMargin();
            return;
        }

        private ConstraintAttribute get(String r5, ConstraintAttribute.AttributeType r10) {
            if (this.mCustomConstraints.containsKey(r5) == false) goto L9;
            ConstraintAttribute r11 = this.mCustomConstraints.get(r5);
            if (r11.getType() != r10) goto L8;
            return r11;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r11.getType().name());
        L9:
            ConstraintAttribute r12 = new ConstraintAttribute(r5, r10);
            this.mCustomConstraints.put(r5, r12);
            return r12;
        }

        private void setColorValue(String r5, int r10) {
            get(r5, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r10);
        }

        private void setFloatValue(String r5, float r10) {
            get(r5, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r10);
        }

        private void setIntValue(String r5, int r10) {
            get(r5, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r10);
        }

        private void setStringValue(String r5, String r10) {
            get(r5, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r10);
        }

        public void applyTo(ConstraintLayout.LayoutParams r5) {
            Layout r10 = this.layout;
            r5.leftToLeft = r10.leftToLeft;
            r5.leftToRight = r10.leftToRight;
            r5.rightToLeft = r10.rightToLeft;
            r5.rightToRight = r10.rightToRight;
            r5.topToTop = r10.topToTop;
            r5.topToBottom = r10.topToBottom;
            r5.bottomToTop = r10.bottomToTop;
            r5.bottomToBottom = r10.bottomToBottom;
            r5.baselineToBaseline = r10.baselineToBaseline;
            r5.startToEnd = r10.startToEnd;
            r5.startToStart = r10.startToStart;
            r5.endToStart = r10.endToStart;
            r5.endToEnd = r10.endToEnd;
            ((ViewGroup.MarginLayoutParams) r5).leftMargin = r10.leftMargin;
            ((ViewGroup.MarginLayoutParams) r5).rightMargin = r10.rightMargin;
            ((ViewGroup.MarginLayoutParams) r5).topMargin = r10.topMargin;
            ((ViewGroup.MarginLayoutParams) r5).bottomMargin = r10.bottomMargin;
            r5.goneStartMargin = r10.goneStartMargin;
            r5.goneEndMargin = r10.goneEndMargin;
            r5.goneTopMargin = r10.goneTopMargin;
            r5.goneBottomMargin = r10.goneBottomMargin;
            r5.horizontalBias = r10.horizontalBias;
            r5.verticalBias = r10.verticalBias;
            r5.circleConstraint = r10.circleConstraint;
            r5.circleRadius = r10.circleRadius;
            r5.circleAngle = r10.circleAngle;
            r5.dimensionRatio = r10.dimensionRatio;
            r5.editorAbsoluteX = r10.editorAbsoluteX;
            r5.editorAbsoluteY = r10.editorAbsoluteY;
            r5.verticalWeight = r10.verticalWeight;
            r5.horizontalWeight = r10.horizontalWeight;
            r5.verticalChainStyle = r10.verticalChainStyle;
            r5.horizontalChainStyle = r10.horizontalChainStyle;
            r5.constrainedWidth = r10.constrainedWidth;
            r5.constrainedHeight = r10.constrainedHeight;
            r5.matchConstraintDefaultWidth = r10.widthDefault;
            r5.matchConstraintDefaultHeight = r10.heightDefault;
            r5.matchConstraintMaxWidth = r10.widthMax;
            r5.matchConstraintMaxHeight = r10.heightMax;
            r5.matchConstraintMinWidth = r10.widthMin;
            r5.matchConstraintMinHeight = r10.heightMin;
            r5.matchConstraintPercentWidth = r10.widthPercent;
            r5.matchConstraintPercentHeight = r10.heightPercent;
            r5.orientation = r10.orientation;
            r5.guidePercent = r10.guidePercent;
            r5.guideBegin = r10.guideBegin;
            r5.guideEnd = r10.guideEnd;
            ((ViewGroup.MarginLayoutParams) r5).width = r10.mWidth;
            ((ViewGroup.MarginLayoutParams) r5).height = r10.mHeight;
            String r11 = r10.mConstraintTag;
            if (r11 == null) goto L5;
            r5.constraintTag = r11;
        L5:
            r5.setMarginStart(r10.startMargin);
            r5.setMarginEnd(this.layout.endMargin);
            r5.validate();
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m46clone() throws CloneNotSupportedException {
            return clone();
        }

        public Constraint clone() {
            Constraint r5 = new Constraint();
            r5.layout.copyFrom(this.layout);
            r5.motion.copyFrom(this.motion);
            r5.propertySet.copyFrom(this.propertySet);
            r5.transform.copyFrom(this.transform);
            r5.mViewId = this.mViewId;
            return r5;
        }

        private void fillFromConstraints(int r5, Constraints.LayoutParams r10) {
            fillFrom(r5, r10);
            PropertySet r11 = this.propertySet;
            r11.alpha = r10.alpha;
            Transform r12 = this.transform;
            r12.rotation = r10.rotation;
            r12.rotationX = r10.rotationX;
            r12.rotationY = r10.rotationY;
            r12.scaleX = r10.scaleX;
            r12.scaleY = r10.scaleY;
            r12.transformPivotX = r10.transformPivotX;
            r12.transformPivotY = r10.transformPivotY;
            r12.translationX = r10.translationX;
            r12.translationY = r10.translationY;
            r12.translationZ = r10.translationZ;
            r12.elevation = r10.elevation;
            r12.applyElevation = r10.applyElevation;
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LEFT_MARGIN = 23;
        private static final int LEFT_TO_LEFT = 24;
        private static final int LEFT_TO_RIGHT = 25;
        private static final int ORIENTATION = 26;
        private static final int RIGHT_MARGIN = 27;
        private static final int RIGHT_TO_LEFT = 28;
        private static final int RIGHT_TO_RIGHT = 29;
        private static final int START_MARGIN = 30;
        private static final int START_TO_END = 31;
        private static final int START_TO_START = 32;
        private static final int TOP_MARGIN = 33;
        private static final int TOP_TO_BOTTOM = 34;
        private static final int TOP_TO_TOP = 35;
        public static final int UNSET = -1;
        private static final int UNUSED = 76;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineToBaseline;
        public int bottomMargin;
        public int bottomToBottom;
        public int bottomToTop;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String dimensionRatio;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endMargin;
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
        public int heightDefault;
        public int heightMax;
        public int heightMin;
        public float heightPercent;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;
        public int leftMargin;
        public int leftToLeft;
        public int leftToRight;
        public boolean mApply;
        public boolean mBarrierAllowsGoneWidgets;
        public int mBarrierDirection;
        public int mBarrierMargin;
        public String mConstraintTag;
        public int mHeight;
        public int mHelperType;
        public boolean mIsGuideline;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int orientation;
        public int rightMargin;
        public int rightToLeft;
        public int rightToRight;
        public int startMargin;
        public int startToEnd;
        public int startToStart;
        public int topMargin;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int widthDefault;
        public int widthMax;
        public int widthMin;
        public float widthPercent;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mapToConstant = r5;
            r5.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            mapToConstant.append(R.styleable.Layout_android_orientation, 26);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
            mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
            mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
            mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
            mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
            mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public Layout() {
            this.mIsGuideline = false;
            this.mApply = false;
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
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = 0.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.leftMargin = -1;
            this.rightMargin = -1;
            this.topMargin = -1;
            this.bottomMargin = -1;
            this.endMargin = -1;
            this.startMargin = -1;
            this.goneLeftMargin = -1;
            this.goneTopMargin = -1;
            this.goneRightMargin = -1;
            this.goneBottomMargin = -1;
            this.goneEndMargin = -1;
            this.goneStartMargin = -1;
            this.verticalWeight = -1.0f;
            this.horizontalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = -1;
            this.heightMax = -1;
            this.widthMin = -1;
            this.heightMin = -1;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
        }

        public void copyFrom(Layout r5) {
            this.mIsGuideline = r5.mIsGuideline;
            this.mWidth = r5.mWidth;
            this.mApply = r5.mApply;
            this.mHeight = r5.mHeight;
            this.guideBegin = r5.guideBegin;
            this.guideEnd = r5.guideEnd;
            this.guidePercent = r5.guidePercent;
            this.leftToLeft = r5.leftToLeft;
            this.leftToRight = r5.leftToRight;
            this.rightToLeft = r5.rightToLeft;
            this.rightToRight = r5.rightToRight;
            this.topToTop = r5.topToTop;
            this.topToBottom = r5.topToBottom;
            this.bottomToTop = r5.bottomToTop;
            this.bottomToBottom = r5.bottomToBottom;
            this.baselineToBaseline = r5.baselineToBaseline;
            this.startToEnd = r5.startToEnd;
            this.startToStart = r5.startToStart;
            this.endToStart = r5.endToStart;
            this.endToEnd = r5.endToEnd;
            this.horizontalBias = r5.horizontalBias;
            this.verticalBias = r5.verticalBias;
            this.dimensionRatio = r5.dimensionRatio;
            this.circleConstraint = r5.circleConstraint;
            this.circleRadius = r5.circleRadius;
            this.circleAngle = r5.circleAngle;
            this.editorAbsoluteX = r5.editorAbsoluteX;
            this.editorAbsoluteY = r5.editorAbsoluteY;
            this.orientation = r5.orientation;
            this.leftMargin = r5.leftMargin;
            this.rightMargin = r5.rightMargin;
            this.topMargin = r5.topMargin;
            this.bottomMargin = r5.bottomMargin;
            this.endMargin = r5.endMargin;
            this.startMargin = r5.startMargin;
            this.goneLeftMargin = r5.goneLeftMargin;
            this.goneTopMargin = r5.goneTopMargin;
            this.goneRightMargin = r5.goneRightMargin;
            this.goneBottomMargin = r5.goneBottomMargin;
            this.goneEndMargin = r5.goneEndMargin;
            this.goneStartMargin = r5.goneStartMargin;
            this.verticalWeight = r5.verticalWeight;
            this.horizontalWeight = r5.horizontalWeight;
            this.horizontalChainStyle = r5.horizontalChainStyle;
            this.verticalChainStyle = r5.verticalChainStyle;
            this.widthDefault = r5.widthDefault;
            this.heightDefault = r5.heightDefault;
            this.widthMax = r5.widthMax;
            this.heightMax = r5.heightMax;
            this.widthMin = r5.widthMin;
            this.heightMin = r5.heightMin;
            this.widthPercent = r5.widthPercent;
            this.heightPercent = r5.heightPercent;
            this.mBarrierDirection = r5.mBarrierDirection;
            this.mBarrierMargin = r5.mBarrierMargin;
            this.mHelperType = r5.mHelperType;
            this.mConstraintTag = r5.mConstraintTag;
            int[] r10 = r5.mReferenceIds;
            if (r10 == null) goto L5;
            this.mReferenceIds = Arrays.copyOf(r10, r10.length);
        L6:
            this.mReferenceIdString = r5.mReferenceIdString;
            this.constrainedWidth = r5.constrainedWidth;
            this.constrainedHeight = r5.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = r5.mBarrierAllowsGoneWidgets;
            return;
        L5:
            this.mReferenceIds = null;
            goto L6
        }

        public void dump(MotionScene r10, StringBuilder r11) {
            Field[] r5 = getClass().getDeclaredFields();
            r11.append("\n");
            int r12 = 0;
        L4:
            if (r12 >= r5.length) goto L28;
            Field r13 = r5[r12];
            String r14 = r13.getName();
            if (Modifier.isStatic(r13.getModifiers()) == true) goto L27;
            Object r15 = r13.get(this);     // Catch: IllegalAccessException -> L18
            Class<?> r16 = r13.getType();     // Catch: IllegalAccessException -> L18
            if (r16 != Integer.TYPE) goto L21;
            Integer r17 = (Integer) r15;     // Catch: IllegalAccessException -> L18
            if (r17.intValue() == (-1)) goto L27;
            Object r18 = r10.lookUpConstraintName(r17.intValue());     // Catch: IllegalAccessException -> L18
            r11.append("    ");     // Catch: IllegalAccessException -> L18
            r11.append(r14);     // Catch: IllegalAccessException -> L18
            r11.append(" = \"");     // Catch: IllegalAccessException -> L18
            if (r18 != null) goto L16;
            Object r19 = r17;
        L17:
            r11.append(r19);     // Catch: IllegalAccessException -> L18
            r11.append("\"\n");     // Catch: IllegalAccessException -> L18
            goto L27
        L16:
            r19 = r18;
            goto L17
        L21:
            if (r16 != Float.TYPE) goto L27;
            Float r20 = (Float) r15;     // Catch: IllegalAccessException -> L18
            if (r20.floatValue() == (-1.0f)) goto L27;
            r11.append("    ");     // Catch: IllegalAccessException -> L18
            r11.append(r14);     // Catch: IllegalAccessException -> L18
            r11.append(" = \"");     // Catch: IllegalAccessException -> L18
            r11.append(r20);     // Catch: IllegalAccessException -> L18
            r11.append("\"\n");     // Catch: IllegalAccessException -> L18
        L18:
            e = move-exception;
            e.printStackTrace();
        L27:
            r12 = r12 + 1;
            goto L4
        }

        public void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Layout);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r5 = 0;
        L3:
            if (r5 >= r13) goto L75;
            int r14 = r12.getIndex(r5);
            int r15 = mapToConstant.get(r14);
            if (r15 != 80) goto L7;
            this.constrainedWidth = r12.getBoolean(r14, this.constrainedWidth);
        L74:
            r5 = r5 + 1;
            goto L3
        L7:
            if (r15 == 81) goto L72;
            switch(r15) {
                case 1: goto L71;
                case 2: goto L70;
                case 3: goto L69;
                case 4: goto L68;
                case 5: goto L67;
                case 6: goto L66;
                case 7: goto L65;
                case 8: goto L64;
                case 9: goto L63;
                case 10: goto L62;
                case 11: goto L61;
                case 12: goto L60;
                case 13: goto L59;
                case 14: goto L58;
                case 15: goto L57;
                case 16: goto L56;
                case 17: goto L55;
                case 18: goto L54;
                case 19: goto L53;
                case 20: goto L52;
                case 21: goto L51;
                case 22: goto L50;
                case 23: goto L49;
                case 24: goto L48;
                case 25: goto L47;
                case 26: goto L46;
                case 27: goto L45;
                case 28: goto L44;
                case 29: goto L43;
                case 30: goto L42;
                case 31: goto L41;
                case 32: goto L40;
                case 33: goto L39;
                case 34: goto L38;
                case 35: goto L37;
                case 36: goto L36;
                case 37: goto L35;
                case 38: goto L34;
                case 39: goto L33;
                case 40: goto L32;
                default: goto L9;
            };
        L9:
            switch(r15) {
                case 54: goto L31;
                case 55: goto L30;
                case 56: goto L29;
                case 57: goto L28;
                case 58: goto L27;
                case 59: goto L26;
                default: goto L10;
            };
        L10:
            switch(r15) {
                case 61: goto L25;
                case 62: goto L24;
                case 63: goto L23;
                default: goto L12;
            };
        L23:
            this.circleAngle = r12.getFloat(r14, this.circleAngle);
            goto L74
        L24:
            this.circleRadius = r12.getDimensionPixelSize(r14, this.circleRadius);
            goto L74
        L25:
            this.circleConstraint = ConstraintSet.access$100(r12, r14, this.circleConstraint);
            goto L74
        L12:
            switch(r15) {
                case 69: goto L22;
                case 70: goto L21;
                case 71: goto L20;
                case 72: goto L19;
                case 73: goto L18;
                case 74: goto L17;
                case 75: goto L16;
                case 76: goto L15;
                case 77: goto L14;
                default: goto L13;
            };
        L13:
            Log.w(ConstraintSet.TAG, "Unknown attribute 0x" + Integer.toHexString(r14) + "   " + mapToConstant.get(r14));
            goto L74
        L14:
            this.mConstraintTag = r12.getString(r14);
            goto L74
        L15:
            Log.w(ConstraintSet.TAG, "unused attribute 0x" + Integer.toHexString(r14) + "   " + mapToConstant.get(r14));
            goto L74
        L16:
            this.mBarrierAllowsGoneWidgets = r12.getBoolean(r14, this.mBarrierAllowsGoneWidgets);
            goto L74
        L17:
            this.mReferenceIdString = r12.getString(r14);
            goto L74
        L18:
            this.mBarrierMargin = r12.getDimensionPixelSize(r14, this.mBarrierMargin);
            goto L74
        L19:
            this.mBarrierDirection = r12.getInt(r14, this.mBarrierDirection);
            goto L74
        L20:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L74
        L21:
            this.heightPercent = r12.getFloat(r14, 1.0f);
            goto L74
        L22:
            this.widthPercent = r12.getFloat(r14, 1.0f);
            goto L74
        L26:
            this.heightMin = r12.getDimensionPixelSize(r14, this.heightMin);
            goto L74
        L27:
            this.widthMin = r12.getDimensionPixelSize(r14, this.widthMin);
            goto L74
        L28:
            this.heightMax = r12.getDimensionPixelSize(r14, this.heightMax);
            goto L74
        L29:
            this.widthMax = r12.getDimensionPixelSize(r14, this.widthMax);
            goto L74
        L30:
            this.heightDefault = r12.getInt(r14, this.heightDefault);
            goto L74
        L31:
            this.widthDefault = r12.getInt(r14, this.widthDefault);
            goto L74
        L32:
            this.verticalChainStyle = r12.getInt(r14, this.verticalChainStyle);
            goto L74
        L33:
            this.horizontalChainStyle = r12.getInt(r14, this.horizontalChainStyle);
            goto L74
        L34:
            this.verticalWeight = r12.getFloat(r14, this.verticalWeight);
            goto L74
        L35:
            this.horizontalWeight = r12.getFloat(r14, this.horizontalWeight);
            goto L74
        L36:
            this.verticalBias = r12.getFloat(r14, this.verticalBias);
            goto L74
        L37:
            this.topToTop = ConstraintSet.access$100(r12, r14, this.topToTop);
            goto L74
        L38:
            this.topToBottom = ConstraintSet.access$100(r12, r14, this.topToBottom);
            goto L74
        L39:
            this.topMargin = r12.getDimensionPixelSize(r14, this.topMargin);
            goto L74
        L40:
            this.startToStart = ConstraintSet.access$100(r12, r14, this.startToStart);
            goto L74
        L41:
            this.startToEnd = ConstraintSet.access$100(r12, r14, this.startToEnd);
            goto L74
        L42:
            this.startMargin = r12.getDimensionPixelSize(r14, this.startMargin);
            goto L74
        L43:
            this.rightToRight = ConstraintSet.access$100(r12, r14, this.rightToRight);
            goto L74
        L44:
            this.rightToLeft = ConstraintSet.access$100(r12, r14, this.rightToLeft);
            goto L74
        L45:
            this.rightMargin = r12.getDimensionPixelSize(r14, this.rightMargin);
            goto L74
        L46:
            this.orientation = r12.getInt(r14, this.orientation);
            goto L74
        L47:
            this.leftToRight = ConstraintSet.access$100(r12, r14, this.leftToRight);
            goto L74
        L48:
            this.leftToLeft = ConstraintSet.access$100(r12, r14, this.leftToLeft);
            goto L74
        L49:
            this.leftMargin = r12.getDimensionPixelSize(r14, this.leftMargin);
            goto L74
        L50:
            this.mWidth = r12.getLayoutDimension(r14, this.mWidth);
            goto L74
        L51:
            this.mHeight = r12.getLayoutDimension(r14, this.mHeight);
            goto L74
        L52:
            this.horizontalBias = r12.getFloat(r14, this.horizontalBias);
            goto L74
        L53:
            this.guidePercent = r12.getFloat(r14, this.guidePercent);
            goto L74
        L54:
            this.guideEnd = r12.getDimensionPixelOffset(r14, this.guideEnd);
            goto L74
        L55:
            this.guideBegin = r12.getDimensionPixelOffset(r14, this.guideBegin);
            goto L74
        L56:
            this.goneTopMargin = r12.getDimensionPixelSize(r14, this.goneTopMargin);
            goto L74
        L57:
            this.goneStartMargin = r12.getDimensionPixelSize(r14, this.goneStartMargin);
            goto L74
        L58:
            this.goneRightMargin = r12.getDimensionPixelSize(r14, this.goneRightMargin);
            goto L74
        L59:
            this.goneLeftMargin = r12.getDimensionPixelSize(r14, this.goneLeftMargin);
            goto L74
        L60:
            this.goneEndMargin = r12.getDimensionPixelSize(r14, this.goneEndMargin);
            goto L74
        L61:
            this.goneBottomMargin = r12.getDimensionPixelSize(r14, this.goneBottomMargin);
            goto L74
        L62:
            this.endToStart = ConstraintSet.access$100(r12, r14, this.endToStart);
            goto L74
        L63:
            this.endToEnd = ConstraintSet.access$100(r12, r14, this.endToEnd);
            goto L74
        L64:
            this.endMargin = r12.getDimensionPixelSize(r14, this.endMargin);
            goto L74
        L65:
            this.editorAbsoluteY = r12.getDimensionPixelOffset(r14, this.editorAbsoluteY);
            goto L74
        L66:
            this.editorAbsoluteX = r12.getDimensionPixelOffset(r14, this.editorAbsoluteX);
            goto L74
        L67:
            this.dimensionRatio = r12.getString(r14);
            goto L74
        L68:
            this.bottomToTop = ConstraintSet.access$100(r12, r14, this.bottomToTop);
            goto L74
        L69:
            this.bottomToBottom = ConstraintSet.access$100(r12, r14, this.bottomToBottom);
            goto L74
        L70:
            this.bottomMargin = r12.getDimensionPixelSize(r14, this.bottomMargin);
            goto L74
        L71:
            this.baselineToBaseline = ConstraintSet.access$100(r12, r14, this.baselineToBaseline);
            goto L74
        L72:
            this.constrainedHeight = r12.getBoolean(r14, this.constrainedHeight);
            goto L74
        L75:
            r12.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 6;
        private static final int PATH_MOTION_ARC = 2;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public String mTransitionEasing;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mapToConstant = r5;
            r5.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animate_relativeTo, 5);
            mapToConstant.append(R.styleable.Motion_motionStagger, 6);
        }

        public Motion() {
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPathRotate = Float.NaN;
        }

        public void copyFrom(Motion r5) {
            this.mApply = r5.mApply;
            this.mAnimateRelativeTo = r5.mAnimateRelativeTo;
            this.mTransitionEasing = r5.mTransitionEasing;
            this.mPathMotionArc = r5.mPathMotionArc;
            this.mDrawPath = r5.mDrawPath;
            this.mPathRotate = r5.mPathRotate;
            this.mMotionStagger = r5.mMotionStagger;
        }

        public void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Motion);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r5 = 0;
        L3:
            if (r5 >= r13) goto L17;
            int r14 = r12.getIndex(r5);
            switch(mapToConstant.get(r14)) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L11;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L16;
            };
        L7:
            this.mMotionStagger = r12.getFloat(r14, this.mMotionStagger);
            goto L16
        L8:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r12, r14, this.mAnimateRelativeTo);
            goto L16
        L9:
            this.mDrawPath = r12.getInt(r14, 0);
            goto L16
        L14:
            this.mPathMotionArc = r12.getInt(r14, this.mPathMotionArc);
            goto L16
        L15:
            this.mPathRotate = r12.getFloat(r14, this.mPathRotate);
            goto L16
        L11:
            if (r12.peekValue(r14).type != 3) goto L13;
            this.mTransitionEasing = r12.getString(r14);
            goto L16
        L13:
            this.mTransitionEasing = Easing.NAMED_EASING[r12.getInteger(r14, 0)];
        L16:
            r5 = r5 + 1;
            goto L3
        L17:
            r12.recycle();
        }
    }

    public static class PropertySet {
        public float alpha;
        public boolean mApply;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            this.mApply = false;
            this.visibility = 0;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }

        public void copyFrom(PropertySet r5) {
            this.mApply = r5.mApply;
            this.visibility = r5.visibility;
            this.alpha = r5.alpha;
            this.mProgress = r5.mProgress;
            this.mVisibilityMode = r5.mVisibilityMode;
        }

        public void fillFromAttributeList(Context r5, AttributeSet r10) {
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.PropertySet);
            this.mApply = true;
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L17;
            int r14 = r11.getIndex(r13);
            if (r14 != R.styleable.PropertySet_android_alpha) goto L8;
            this.alpha = r11.getFloat(r14, this.alpha);
        L16:
            r13 = r13 + 1;
            goto L3
        L8:
            if (r14 != R.styleable.PropertySet_android_visibility) goto L11;
            this.visibility = r11.getInt(r14, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L16
        L11:
            if (r14 != R.styleable.PropertySet_visibilityMode) goto L14;
            this.mVisibilityMode = r11.getInt(r14, this.mVisibilityMode);
            goto L16
        L14:
            if (r14 != R.styleable.PropertySet_motionProgress) goto L16;
            this.mProgress = r11.getFloat(r14, this.mProgress);
            goto L16
        L17:
            r11.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_X = 6;
        private static final int TRANSFORM_PIVOT_Y = 7;
        private static final int TRANSLATION_X = 8;
        private static final int TRANSLATION_Y = 9;
        private static final int TRANSLATION_Z = 10;
        private static SparseIntArray mapToConstant;
        public boolean applyElevation;
        public float elevation;
        public boolean mApply;
        public float rotation;
        public float rotationX;
        public float rotationY;
        public float scaleX;
        public float scaleY;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray r5 = new SparseIntArray();
            mapToConstant = r5;
            r5.append(R.styleable.Transform_android_rotation, 1);
            mapToConstant.append(R.styleable.Transform_android_rotationX, 2);
            mapToConstant.append(R.styleable.Transform_android_rotationY, 3);
            mapToConstant.append(R.styleable.Transform_android_scaleX, 4);
            mapToConstant.append(R.styleable.Transform_android_scaleY, 5);
            mapToConstant.append(R.styleable.Transform_android_transformPivotX, 6);
            mapToConstant.append(R.styleable.Transform_android_transformPivotY, 7);
            mapToConstant.append(R.styleable.Transform_android_translationX, 8);
            mapToConstant.append(R.styleable.Transform_android_translationY, 9);
            mapToConstant.append(R.styleable.Transform_android_translationZ, 10);
            mapToConstant.append(R.styleable.Transform_android_elevation, 11);
        }

        public Transform() {
            this.mApply = false;
            this.rotation = 0.0f;
            this.rotationX = 0.0f;
            this.rotationY = 0.0f;
            this.scaleX = 1.0f;
            this.scaleY = 1.0f;
            this.transformPivotX = Float.NaN;
            this.transformPivotY = Float.NaN;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
        }

        public void copyFrom(Transform r5) {
            this.mApply = r5.mApply;
            this.rotation = r5.rotation;
            this.rotationX = r5.rotationX;
            this.rotationY = r5.rotationY;
            this.scaleX = r5.scaleX;
            this.scaleY = r5.scaleY;
            this.transformPivotX = r5.transformPivotX;
            this.transformPivotY = r5.transformPivotY;
            this.translationX = r5.translationX;
            this.translationY = r5.translationY;
            this.translationZ = r5.translationZ;
            this.applyElevation = r5.applyElevation;
            this.elevation = r5.elevation;
        }

        public void fillFromAttributeList(Context r5, AttributeSet r10) {
            TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.Transform);
            this.mApply = true;
            int r12 = r11.getIndexCount();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L19;
            int r14 = r11.getIndex(r13);
            switch(mapToConstant.get(r14)) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L18;
            };
        L7:
            this.applyElevation = true;
            this.elevation = r11.getDimension(r14, this.elevation);
            goto L18
        L8:
            this.translationZ = r11.getDimension(r14, this.translationZ);
            goto L18
        L9:
            this.translationY = r11.getDimension(r14, this.translationY);
            goto L18
        L10:
            this.translationX = r11.getDimension(r14, this.translationX);
            goto L18
        L11:
            this.transformPivotY = r11.getDimension(r14, this.transformPivotY);
            goto L18
        L12:
            this.transformPivotX = r11.getDimension(r14, this.transformPivotX);
            goto L18
        L13:
            this.scaleY = r11.getFloat(r14, this.scaleY);
            goto L18
        L14:
            this.scaleX = r11.getFloat(r14, this.scaleX);
            goto L18
        L15:
            this.rotationY = r11.getFloat(r14, this.rotationY);
            goto L18
        L16:
            this.rotationX = r11.getFloat(r14, this.rotationX);
            goto L18
        L17:
            this.rotation = r11.getFloat(r14, this.rotation);
        L18:
            r13 = r13 + 1;
            goto L3
        L19:
            r11.recycle();
        }
    }

    static {
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        SparseIntArray r5 = new SparseIntArray();
        mapToConstant = r5;
        r5.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public ConstraintSet() {
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    public static /* synthetic */ int access$100(TypedArray r5, int r10, int r11) {
        return lookupID(r5, r10, r11);
    }

    public static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    private void addAttributes(ConstraintAttribute.AttributeType r5, String... r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L14;
        if (this.mSavedAttributes.containsKey(r10[r11]) == false) goto L12;
        ConstraintAttribute r12 = this.mSavedAttributes.get(r10[r11]);
        if (r12.getType() == r5) goto L13;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r12.getType().name());
    L13:
        r11 = r11 + 1;
        goto L4
    L12:
        this.mSavedAttributes.put(r10[r11], new ConstraintAttribute(r10[r11], r5));
        goto L13
    }

    private int[] convertReferenceString(View r10, String r11) {
        String[] r12 = r11.split(",");
        Context r13 = r10.getContext();
        int[] r5 = new int[r12.length];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r12.length) goto L23;
        String r16 = r12[r14].trim();
        int r17 = R.id.class.getField(r16).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r17 != 0) goto L11;
        r17 = r13.getResources().getIdentifier(r16, "id", r13.getPackageName());
    L11:
        if (r17 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if ((r10.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r18 = ((ConstraintLayout) r10.getParent()).getDesignInformation(0, r16);
        if (r18 == null) goto L21;
        if ((r18 instanceof Integer) == false) goto L21;
        r17 = ((Integer) r18).intValue();
    L21:
        r5[r15] = r17;
        r14 = r14 + 1;
        r15 = r15 + 1;
    L8:
        r17 = 0;
        goto L9
    L23:
        if (r15 != r12.length) goto L25;
        return r5;
    L25:
        return Arrays.copyOf(r5, r15);
    }

    private Constraint fillFromAttributeList(Context r5, AttributeSet r10) {
        Constraint r11 = new Constraint();
        TypedArray r12 = r5.obtainStyledAttributes(r10, R.styleable.Constraint);
        populateConstraint(r5, r11, r12);
        r12.recycle();
        return r11;
    }

    private Constraint get(int r5) {
        if (this.mConstraints.containsKey(Integer.valueOf(r5)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r5), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(r5));
    }

    private static int lookupID(TypedArray r5, int r10, int r11) {
        int r12 = r5.getResourceId(r10, r11);
        if (r12 == (-1)) goto L5;
        return r12;
    L5:
        return r5.getInt(r10, -1);
    }

    private void populateConstraint(Context r10, Constraint r11, TypedArray r12) {
        int r13 = r12.getIndexCount();
        int r5 = 0;
    L3:
        if (r5 >= r13) goto L100;
        int r14 = r12.getIndex(r5);
        if (r14 == R.styleable.Constraint_android_id) goto L12;
        if (R.styleable.Constraint_android_layout_marginStart == r14) goto L12;
        if (R.styleable.Constraint_android_layout_marginEnd == r14) goto L12;
        r11.motion.mApply = true;
        r11.layout.mApply = true;
        r11.propertySet.mApply = true;
        r11.transform.mApply = true;
    L12:
        switch(mapToConstant.get(r14)) {
            case 1: goto L98;
            case 2: goto L97;
            case 3: goto L96;
            case 4: goto L95;
            case 5: goto L94;
            case 6: goto L93;
            case 7: goto L92;
            case 8: goto L91;
            case 9: goto L90;
            case 10: goto L89;
            case 11: goto L88;
            case 12: goto L87;
            case 13: goto L86;
            case 14: goto L85;
            case 15: goto L84;
            case 16: goto L83;
            case 17: goto L82;
            case 18: goto L81;
            case 19: goto L80;
            case 20: goto L79;
            case 21: goto L78;
            case 22: goto L77;
            case 23: goto L76;
            case 24: goto L75;
            case 25: goto L74;
            case 26: goto L73;
            case 27: goto L72;
            case 28: goto L71;
            case 29: goto L70;
            case 30: goto L69;
            case 31: goto L68;
            case 32: goto L67;
            case 33: goto L66;
            case 34: goto L65;
            case 35: goto L64;
            case 36: goto L63;
            case 37: goto L62;
            case 38: goto L61;
            case 39: goto L60;
            case 40: goto L59;
            case 41: goto L58;
            case 42: goto L57;
            case 43: goto L56;
            case 44: goto L55;
            case 45: goto L54;
            case 46: goto L53;
            case 47: goto L52;
            case 48: goto L51;
            case 49: goto L50;
            case 50: goto L49;
            case 51: goto L48;
            case 52: goto L47;
            case 53: goto L46;
            case 54: goto L45;
            case 55: goto L44;
            case 56: goto L43;
            case 57: goto L42;
            case 58: goto L41;
            case 59: goto L40;
            case 60: goto L39;
            case 61: goto L38;
            case 62: goto L37;
            case 63: goto L36;
            case 64: goto L35;
            case 65: goto L32;
            case 66: goto L30;
            case 67: goto L29;
            case 68: goto L28;
            case 69: goto L27;
            case 70: goto L26;
            case 71: goto L25;
            case 72: goto L24;
            case 73: goto L23;
            case 74: goto L22;
            case 75: goto L21;
            case 76: goto L20;
            case 77: goto L19;
            case 78: goto L18;
            case 79: goto L17;
            case 80: goto L16;
            case 81: goto L15;
            case 82: goto L14;
            default: goto L13;
        };
    L13:
        Log.w(TAG, "Unknown attribute 0x" + Integer.toHexString(r14) + "   " + mapToConstant.get(r14));
    L99:
        r5 = r5 + 1;
        goto L3
    L14:
        Log.w(TAG, "unused attribute 0x" + Integer.toHexString(r14) + "   " + mapToConstant.get(r14));
        goto L99
    L15:
        Layout r15 = r11.layout;
        r15.constrainedHeight = r12.getBoolean(r14, r15.constrainedHeight);
        goto L99
    L16:
        Layout r16 = r11.layout;
        r16.constrainedWidth = r12.getBoolean(r14, r16.constrainedWidth);
        goto L99
    L17:
        Motion r17 = r11.motion;
        r17.mMotionStagger = r12.getFloat(r14, r17.mMotionStagger);
        goto L99
    L18:
        PropertySet r18 = r11.propertySet;
        r18.mVisibilityMode = r12.getInt(r14, r18.mVisibilityMode);
        goto L99
    L19:
        r11.layout.mConstraintTag = r12.getString(r14);
        goto L99
    L20:
        Motion r19 = r11.motion;
        r19.mPathMotionArc = r12.getInt(r14, r19.mPathMotionArc);
        goto L99
    L21:
        Layout r20 = r11.layout;
        r20.mBarrierAllowsGoneWidgets = r12.getBoolean(r14, r20.mBarrierAllowsGoneWidgets);
        goto L99
    L22:
        r11.layout.mReferenceIdString = r12.getString(r14);
        goto L99
    L23:
        Layout r21 = r11.layout;
        r21.mBarrierMargin = r12.getDimensionPixelSize(r14, r21.mBarrierMargin);
        goto L99
    L24:
        Layout r22 = r11.layout;
        r22.mBarrierDirection = r12.getInt(r14, r22.mBarrierDirection);
        goto L99
    L25:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L99
    L26:
        r11.layout.heightPercent = r12.getFloat(r14, 1.0f);
        goto L99
    L27:
        r11.layout.widthPercent = r12.getFloat(r14, 1.0f);
        goto L99
    L28:
        PropertySet r23 = r11.propertySet;
        r23.mProgress = r12.getFloat(r14, r23.mProgress);
        goto L99
    L29:
        Motion r24 = r11.motion;
        r24.mPathRotate = r12.getFloat(r14, r24.mPathRotate);
        goto L99
    L30:
        r11.motion.mDrawPath = r12.getInt(r14, 0);
        goto L99
    L35:
        Motion r25 = r11.motion;
        r25.mAnimateRelativeTo = lookupID(r12, r14, r25.mAnimateRelativeTo);
        goto L99
    L36:
        Layout r26 = r11.layout;
        r26.circleAngle = r12.getFloat(r14, r26.circleAngle);
        goto L99
    L37:
        Layout r27 = r11.layout;
        r27.circleRadius = r12.getDimensionPixelSize(r14, r27.circleRadius);
        goto L99
    L38:
        Layout r28 = r11.layout;
        r28.circleConstraint = lookupID(r12, r14, r28.circleConstraint);
        goto L99
    L39:
        Transform r29 = r11.transform;
        r29.rotation = r12.getFloat(r14, r29.rotation);
        goto L99
    L40:
        Layout r30 = r11.layout;
        r30.heightMin = r12.getDimensionPixelSize(r14, r30.heightMin);
        goto L99
    L41:
        Layout r31 = r11.layout;
        r31.widthMin = r12.getDimensionPixelSize(r14, r31.widthMin);
        goto L99
    L42:
        Layout r32 = r11.layout;
        r32.heightMax = r12.getDimensionPixelSize(r14, r32.heightMax);
        goto L99
    L43:
        Layout r33 = r11.layout;
        r33.widthMax = r12.getDimensionPixelSize(r14, r33.widthMax);
        goto L99
    L44:
        Layout r34 = r11.layout;
        r34.heightDefault = r12.getInt(r14, r34.heightDefault);
        goto L99
    L45:
        Layout r35 = r11.layout;
        r35.widthDefault = r12.getInt(r14, r35.widthDefault);
        goto L99
    L46:
        Transform r36 = r11.transform;
        r36.translationZ = r12.getDimension(r14, r36.translationZ);
        goto L99
    L47:
        Transform r37 = r11.transform;
        r37.translationY = r12.getDimension(r14, r37.translationY);
        goto L99
    L48:
        Transform r38 = r11.transform;
        r38.translationX = r12.getDimension(r14, r38.translationX);
        goto L99
    L49:
        Transform r39 = r11.transform;
        r39.transformPivotY = r12.getDimension(r14, r39.transformPivotY);
        goto L99
    L50:
        Transform r40 = r11.transform;
        r40.transformPivotX = r12.getDimension(r14, r40.transformPivotX);
        goto L99
    L51:
        Transform r41 = r11.transform;
        r41.scaleY = r12.getFloat(r14, r41.scaleY);
        goto L99
    L52:
        Transform r42 = r11.transform;
        r42.scaleX = r12.getFloat(r14, r42.scaleX);
        goto L99
    L53:
        Transform r43 = r11.transform;
        r43.rotationY = r12.getFloat(r14, r43.rotationY);
        goto L99
    L54:
        Transform r44 = r11.transform;
        r44.rotationX = r12.getFloat(r14, r44.rotationX);
        goto L99
    L55:
        Transform r45 = r11.transform;
        r45.applyElevation = true;
        r45.elevation = r12.getDimension(r14, r45.elevation);
        goto L99
    L56:
        PropertySet r46 = r11.propertySet;
        r46.alpha = r12.getFloat(r14, r46.alpha);
        goto L99
    L57:
        Layout r47 = r11.layout;
        r47.verticalChainStyle = r12.getInt(r14, r47.verticalChainStyle);
        goto L99
    L58:
        Layout r48 = r11.layout;
        r48.horizontalChainStyle = r12.getInt(r14, r48.horizontalChainStyle);
        goto L99
    L59:
        Layout r49 = r11.layout;
        r49.verticalWeight = r12.getFloat(r14, r49.verticalWeight);
        goto L99
    L60:
        Layout r50 = r11.layout;
        r50.horizontalWeight = r12.getFloat(r14, r50.horizontalWeight);
        goto L99
    L61:
        r11.mViewId = r12.getResourceId(r14, r11.mViewId);
        goto L99
    L62:
        Layout r51 = r11.layout;
        r51.verticalBias = r12.getFloat(r14, r51.verticalBias);
        goto L99
    L63:
        Layout r52 = r11.layout;
        r52.topToTop = lookupID(r12, r14, r52.topToTop);
        goto L99
    L64:
        Layout r53 = r11.layout;
        r53.topToBottom = lookupID(r12, r14, r53.topToBottom);
        goto L99
    L65:
        Layout r54 = r11.layout;
        r54.topMargin = r12.getDimensionPixelSize(r14, r54.topMargin);
        goto L99
    L66:
        Layout r55 = r11.layout;
        r55.startToStart = lookupID(r12, r14, r55.startToStart);
        goto L99
    L67:
        Layout r56 = r11.layout;
        r56.startToEnd = lookupID(r12, r14, r56.startToEnd);
        goto L99
    L68:
        Layout r57 = r11.layout;
        r57.startMargin = r12.getDimensionPixelSize(r14, r57.startMargin);
        goto L99
    L69:
        Layout r58 = r11.layout;
        r58.rightToRight = lookupID(r12, r14, r58.rightToRight);
        goto L99
    L70:
        Layout r59 = r11.layout;
        r59.rightToLeft = lookupID(r12, r14, r59.rightToLeft);
        goto L99
    L71:
        Layout r60 = r11.layout;
        r60.rightMargin = r12.getDimensionPixelSize(r14, r60.rightMargin);
        goto L99
    L72:
        Layout r61 = r11.layout;
        r61.orientation = r12.getInt(r14, r61.orientation);
        goto L99
    L73:
        Layout r62 = r11.layout;
        r62.leftToRight = lookupID(r12, r14, r62.leftToRight);
        goto L99
    L74:
        Layout r63 = r11.layout;
        r63.leftToLeft = lookupID(r12, r14, r63.leftToLeft);
        goto L99
    L75:
        Layout r64 = r11.layout;
        r64.leftMargin = r12.getDimensionPixelSize(r14, r64.leftMargin);
        goto L99
    L76:
        Layout r65 = r11.layout;
        r65.mWidth = r12.getLayoutDimension(r14, r65.mWidth);
        goto L99
    L77:
        PropertySet r66 = r11.propertySet;
        r66.visibility = r12.getInt(r14, r66.visibility);
        PropertySet r67 = r11.propertySet;
        r67.visibility = VISIBILITY_FLAGS[r67.visibility];
        goto L99
    L78:
        Layout r68 = r11.layout;
        r68.mHeight = r12.getLayoutDimension(r14, r68.mHeight);
        goto L99
    L79:
        Layout r69 = r11.layout;
        r69.horizontalBias = r12.getFloat(r14, r69.horizontalBias);
        goto L99
    L80:
        Layout r70 = r11.layout;
        r70.guidePercent = r12.getFloat(r14, r70.guidePercent);
        goto L99
    L81:
        Layout r71 = r11.layout;
        r71.guideEnd = r12.getDimensionPixelOffset(r14, r71.guideEnd);
        goto L99
    L82:
        Layout r72 = r11.layout;
        r72.guideBegin = r12.getDimensionPixelOffset(r14, r72.guideBegin);
        goto L99
    L83:
        Layout r73 = r11.layout;
        r73.goneTopMargin = r12.getDimensionPixelSize(r14, r73.goneTopMargin);
        goto L99
    L84:
        Layout r74 = r11.layout;
        r74.goneStartMargin = r12.getDimensionPixelSize(r14, r74.goneStartMargin);
        goto L99
    L85:
        Layout r75 = r11.layout;
        r75.goneRightMargin = r12.getDimensionPixelSize(r14, r75.goneRightMargin);
        goto L99
    L86:
        Layout r76 = r11.layout;
        r76.goneLeftMargin = r12.getDimensionPixelSize(r14, r76.goneLeftMargin);
        goto L99
    L87:
        Layout r77 = r11.layout;
        r77.goneEndMargin = r12.getDimensionPixelSize(r14, r77.goneEndMargin);
        goto L99
    L88:
        Layout r78 = r11.layout;
        r78.goneBottomMargin = r12.getDimensionPixelSize(r14, r78.goneBottomMargin);
        goto L99
    L89:
        Layout r79 = r11.layout;
        r79.endToStart = lookupID(r12, r14, r79.endToStart);
        goto L99
    L90:
        Layout r80 = r11.layout;
        r80.endToEnd = lookupID(r12, r14, r80.endToEnd);
        goto L99
    L91:
        Layout r81 = r11.layout;
        r81.endMargin = r12.getDimensionPixelSize(r14, r81.endMargin);
        goto L99
    L92:
        Layout r82 = r11.layout;
        r82.editorAbsoluteY = r12.getDimensionPixelOffset(r14, r82.editorAbsoluteY);
        goto L99
    L93:
        Layout r83 = r11.layout;
        r83.editorAbsoluteX = r12.getDimensionPixelOffset(r14, r83.editorAbsoluteX);
        goto L99
    L94:
        r11.layout.dimensionRatio = r12.getString(r14);
        goto L99
    L95:
        Layout r84 = r11.layout;
        r84.bottomToTop = lookupID(r12, r14, r84.bottomToTop);
        goto L99
    L96:
        Layout r85 = r11.layout;
        r85.bottomToBottom = lookupID(r12, r14, r85.bottomToBottom);
        goto L99
    L97:
        Layout r86 = r11.layout;
        r86.bottomMargin = r12.getDimensionPixelSize(r14, r86.bottomMargin);
        goto L99
    L98:
        Layout r87 = r11.layout;
        r87.baselineToBaseline = lookupID(r12, r14, r87.baselineToBaseline);
        goto L99
    L32:
        if (r12.peekValue(r14).type != 3) goto L34;
        r11.motion.mTransitionEasing = r12.getString(r14);
        goto L99
    L34:
        r11.motion.mTransitionEasing = Easing.NAMED_EASING[r12.getInteger(r14, 0)];
        goto L99
    }

    private String sideToString(int r5) {
        switch(r5) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L3;
        };
    L3:
        return "undefined";
    L5:
        return "end";
    L7:
        return "start";
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return OpenPageMethod.ALIGN_LEFT;
    }

    private static String[] splitString(String r10) {
        char[] r11 = r10.toCharArray();
        ArrayList r5 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
        boolean r14 = false;
    L4:
        if (r12 >= r11.length) goto L13;
        char r15 = r11[r12];
        if (r15 != ',') goto L10;
        if (r14 == true) goto L10;
        r5.add(new String(r11, r13, r12 - r13));
        r13 = r12 + 1;
    L12:
        r12 = r12 + 1;
    L10:
        if (r15 != '\"') goto L12;
        r14 = !r14;
        goto L12
    L13:
        r5.add(new String(r11, r13, r11.length - r13));
        return (String[]) r5.toArray(new String[r5.size()]);
    }

    public void addColorAttributes(String... r5) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r5);
    }

    public void addFloatAttributes(String... r5) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r5);
    }

    public void addIntAttributes(String... r5) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r5);
    }

    public void addStringAttributes(String... r5) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r5);
    }

    public void addToHorizontalChain(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r5 = 1;
    L6:
        connect(r10, 1, r11, r5, 0);
        if (r12 != 0) goto L9;
        int r13 = 2;
    L10:
        connect(r10, 2, r12, r13, 0);
        if (r11 == 0) goto L13;
        connect(r11, 2, r10, 1, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 1, r10, 2, 0);
        return;
    L16:
        return;
    L9:
        r13 = 1;
        goto L10
    L5:
        r5 = 2;
        goto L6
    }

    public void addToHorizontalChainRTL(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r5 = 6;
    L6:
        connect(r10, 6, r11, r5, 0);
        if (r12 != 0) goto L9;
        int r13 = 7;
    L10:
        connect(r10, 7, r12, r13, 0);
        if (r11 == 0) goto L13;
        connect(r11, 7, r10, 6, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 6, r10, 7, 0);
        return;
    L16:
        return;
    L9:
        r13 = 6;
        goto L10
    L5:
        r5 = 7;
        goto L6
    }

    public void addToVerticalChain(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r5 = 3;
    L6:
        connect(r10, 3, r11, r5, 0);
        if (r12 != 0) goto L9;
        int r13 = 4;
    L10:
        connect(r10, 4, r12, r13, 0);
        if (r11 == 0) goto L13;
        connect(r11, 4, r10, 3, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 3, r10, 4, 0);
        return;
    L16:
        return;
    L9:
        r13 = 3;
        goto L10
    L5:
        r5 = 4;
        goto L6
    }

    public void applyCustomAttributes(ConstraintLayout r10) {
        int r5 = r10.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L18;
        View r12 = r10.getChildAt(r11);
        int r13 = r12.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == true) goto L8;
        Log.v(TAG, "id unknown " + Debug.getName(r12));
    L17:
        r11 = r11 + 1;
        goto L3
    L8:
        if (this.mForceId == false) goto L15;
        if (r13 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == false) goto L17;
        ConstraintAttribute.setAttributes(r12, this.mConstraints.get(Integer.valueOf(r13)).mCustomConstraints);
        goto L17
    }

    public void applyTo(ConstraintLayout r5) {
        applyToInternal(r5, true);
        r5.setConstraintSet(null);
        r5.requestLayout();
    }

    public void applyToHelper(ConstraintHelper r5, ConstraintWidget r10, ConstraintLayout.LayoutParams r11, SparseArray<ConstraintWidget> r12) {
        int r13 = r5.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == false) goto L8;
        Constraint r14 = this.mConstraints.get(Integer.valueOf(r13));
        if ((r10 instanceof HelperWidget) == false) goto L9;
        r5.loadParameters(r14, (HelperWidget) r10, r11, r12);
        return;
    L9:
        return;
    }

    public void applyToInternal(ConstraintLayout r11, boolean r12) {
        int r5 = r11.getChildCount();
        HashSet r10 = new HashSet(this.mConstraints.keySet());
        int r13 = 0;
    L4:
        if (r13 >= r5) goto L48;
        View r14 = r11.getChildAt(r13);
        int r15 = r14.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r15)) == true) goto L9;
        Log.w(TAG, "id unknown " + Debug.getName(r14));
    L47:
        r13 = r13 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r15 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r15 == (-1)) goto L47;
        if (this.mConstraints.containsKey(Integer.valueOf(r15)) == false) goto L46;
        r10.remove(Integer.valueOf(r15));
        Constraint r16 = this.mConstraints.get(Integer.valueOf(r15));
        if ((r14 instanceof Barrier) == false) goto L21;
        r16.layout.mHelperType = 1;
    L21:
        int r17 = r16.layout.mHelperType;
        if (r17 == (-1)) goto L31;
        if (r17 != 1) goto L31;
        Barrier r18 = (Barrier) r14;
        r18.setId(r15);
        r18.setType(r16.layout.mBarrierDirection);
        r18.setMargin(r16.layout.mBarrierMargin);
        r18.setAllowsGoneWidget(r16.layout.mBarrierAllowsGoneWidgets);
        Layout r19 = r16.layout;
        int[] r20 = r19.mReferenceIds;
        if (r20 == null) goto L28;
        r18.setReferencedIds(r20);
        goto L31
    L28:
        String r21 = r19.mReferenceIdString;
        if (r21 == null) goto L31;
        r19.mReferenceIds = convertReferenceString(r18, r21);
        r18.setReferencedIds(r16.layout.mReferenceIds);
    L31:
        ConstraintLayout.LayoutParams r22 = (ConstraintLayout.LayoutParams) r14.getLayoutParams();
        r22.validate();
        r16.applyTo(r22);
        if (r12 == false) goto L34;
        ConstraintAttribute.setAttributes(r14, r16.mCustomConstraints);
    L34:
        r14.setLayoutParams(r22);
        PropertySet r23 = r16.propertySet;
        if (r23.mVisibilityMode != 0) goto L37;
        r14.setVisibility(r23.visibility);
    L37:
        r14.setAlpha(r16.propertySet.alpha);
        r14.setRotation(r16.transform.rotation);
        r14.setRotationX(r16.transform.rotationX);
        r14.setRotationY(r16.transform.rotationY);
        r14.setScaleX(r16.transform.scaleX);
        r14.setScaleY(r16.transform.scaleY);
        if (Float.isNaN(r16.transform.transformPivotX) == true) goto L41;
        r14.setPivotX(r16.transform.transformPivotX);
    L41:
        if (Float.isNaN(r16.transform.transformPivotY) == true) goto L43;
        r14.setPivotY(r16.transform.transformPivotY);
    L43:
        r14.setTranslationX(r16.transform.translationX);
        r14.setTranslationY(r16.transform.translationY);
        r14.setTranslationZ(r16.transform.translationZ);
        Transform r24 = r16.transform;
        if (r24.applyElevation == false) goto L47;
        r14.setElevation(r24.elevation);
        goto L47
    L46:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r15);
        goto L47
    L48:
        Iterator r110 = r10.iterator();
    L50:
        if (r110.hasNext() == false) goto L65;
        Integer r25 = (Integer) r110.next();
        Constraint r26 = this.mConstraints.get(r25);
        int r27 = r26.layout.mHelperType;
        if (r27 == (-1)) goto L63;
        if (r27 != 1) goto L63;
        Barrier r28 = new Barrier(r11.getContext());
        r28.setId(r25.intValue());
        Layout r29 = r26.layout;
        int[] r30 = r29.mReferenceIds;
        if (r30 == null) goto L58;
        r28.setReferencedIds(r30);
    L61:
        r28.setType(r26.layout.mBarrierDirection);
        r28.setMargin(r26.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r31 = r11.generateDefaultLayoutParams();
        r28.validateParams();
        r26.applyTo(r31);
        r11.addView(r28, r31);
        goto L63
    L58:
        String r32 = r29.mReferenceIdString;
        if (r32 == null) goto L61;
        r29.mReferenceIds = convertReferenceString(r28, r32);
        r28.setReferencedIds(r26.layout.mReferenceIds);
    L63:
        if (r26.layout.mIsGuideline == false) goto L50;
        View r33 = new Guideline(r11.getContext());
        r33.setId(r25.intValue());
        ConstraintLayout.LayoutParams r34 = r11.generateDefaultLayoutParams();
        r26.applyTo(r34);
        r11.addView(r33, r34);
        goto L50
    }

    public void applyToLayoutParams(int r5, ConstraintLayout.LayoutParams r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r5)) == false) goto L6;
        this.mConstraints.get(Integer.valueOf(r5)).applyTo(r10);
        return;
    }

    public void applyToWithoutCustom(ConstraintLayout r5) {
        applyToInternal(r5, false);
        r5.setConstraintSet(null);
    }

    public void center(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        if (r13 < 0) goto L28;
        if (r16 < 0) goto L26;
        if (r17 <= 0.0f) goto L24;
        if (r17 > 1.0f) goto L24;
        if (r12 != 1) goto L12;
    L21:
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.horizontalBias = r17;
        return;
    L12:
        if (r12 == 2) goto L21;
        if (r12 != 6) goto L17;
    L20:
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.horizontalBias = r17;
        return;
    L17:
        if (r12 == 7) goto L20;
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.verticalBias = r17;
        return;
    L24:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L26:
        throw new IllegalArgumentException("margin must be > 0");
    L28:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.horizontalBias = r17;
    }

    public void centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.horizontalBias = r17;
    }

    public void centerVertically(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        this.mConstraints.get(Integer.valueOf(r10)).layout.verticalBias = r17;
    }

    public void clear(int r5) {
        this.mConstraints.remove(Integer.valueOf(r5));
    }

    public void clone(Context r5, int r10) {
        clone((ConstraintLayout) LayoutInflater.from(r5).inflate(r10, null));
    }

    public void connect(int r10, int r11, int r12, int r13, int r14) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r10));
        switch(r11) {
            case 1: goto L49;
            case 2: goto L42;
            case 3: goto L35;
            case 4: goto L28;
            case 5: goto L24;
            case 6: goto L16;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        StringBuilder r16 = new StringBuilder();
        r16.append(sideToString(r11));
        r16.append(" to ");
        throw new IllegalArgumentException(j0.q(r16, sideToString(r13), " unknown"));
    L9:
        if (r13 != 7) goto L11;
        Layout r17 = r15.layout;
        r17.endToEnd = r12;
        r17.endToStart = -1;
    L13:
        r15.layout.endMargin = r14;
        return;
    L11:
        if (r13 != 6) goto L15;
        Layout r18 = r15.layout;
        r18.endToStart = r12;
        r18.endToEnd = -1;
        goto L13
    L15:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L16:
        if (r13 != 6) goto L18;
        Layout r19 = r15.layout;
        r19.startToStart = r12;
        r19.startToEnd = -1;
    L20:
        r15.layout.startMargin = r14;
        return;
    L18:
        if (r13 != 7) goto L22;
        Layout r20 = r15.layout;
        r20.startToEnd = r12;
        r20.startToStart = -1;
        goto L20
    L22:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L28:
        if (r13 != 4) goto L30;
        Layout r21 = r15.layout;
        r21.bottomToBottom = r12;
        r21.bottomToTop = -1;
        r21.baselineToBaseline = -1;
    L32:
        r15.layout.bottomMargin = r14;
        return;
    L30:
        if (r13 != 3) goto L34;
        Layout r22 = r15.layout;
        r22.bottomToTop = r12;
        r22.bottomToBottom = -1;
        r22.baselineToBaseline = -1;
        goto L32
    L34:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L35:
        if (r13 != 3) goto L37;
        Layout r23 = r15.layout;
        r23.topToTop = r12;
        r23.topToBottom = -1;
        r23.baselineToBaseline = -1;
    L39:
        r15.layout.topMargin = r14;
        return;
    L37:
        if (r13 != 4) goto L41;
        Layout r24 = r15.layout;
        r24.topToBottom = r12;
        r24.topToTop = -1;
        r24.baselineToBaseline = -1;
        goto L39
    L41:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L42:
        if (r13 != 1) goto L44;
        Layout r25 = r15.layout;
        r25.rightToLeft = r12;
        r25.rightToRight = -1;
    L46:
        r15.layout.rightMargin = r14;
        return;
    L44:
        if (r13 != 2) goto L48;
        Layout r26 = r15.layout;
        r26.rightToRight = r12;
        r26.rightToLeft = -1;
        goto L46
    L48:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L49:
        if (r13 != 1) goto L51;
        Layout r27 = r15.layout;
        r27.leftToLeft = r12;
        r27.leftToRight = -1;
    L53:
        r15.layout.leftMargin = r14;
        return;
    L51:
        if (r13 != 2) goto L56;
        Layout r28 = r15.layout;
        r28.leftToRight = r12;
        r28.leftToLeft = -1;
        goto L53
    L56:
        throw new IllegalArgumentException(j0.q(new StringBuilder("Left to "), sideToString(r13), " undefined"));
    L24:
        if (r13 != 5) goto L27;
        Layout r29 = r15.layout;
        r29.baselineToBaseline = r12;
        r29.bottomToBottom = -1;
        r29.bottomToTop = -1;
        r29.topToTop = -1;
        r29.topToBottom = -1;
        return;
    L27:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    }

    public void constrainCircle(int r5, int r10, int r11, float r12) {
        Layout r13 = get(r5).layout;
        r13.circleConstraint = r10;
        r13.circleRadius = r11;
        r13.circleAngle = r12;
    }

    public void constrainDefaultHeight(int r5, int r10) {
        get(r5).layout.heightDefault = r10;
    }

    public void constrainDefaultWidth(int r5, int r10) {
        get(r5).layout.widthDefault = r10;
    }

    public void constrainHeight(int r5, int r10) {
        get(r5).layout.mHeight = r10;
    }

    public void constrainMaxHeight(int r5, int r10) {
        get(r5).layout.heightMax = r10;
    }

    public void constrainMaxWidth(int r5, int r10) {
        get(r5).layout.widthMax = r10;
    }

    public void constrainMinHeight(int r5, int r10) {
        get(r5).layout.heightMin = r10;
    }

    public void constrainMinWidth(int r5, int r10) {
        get(r5).layout.widthMin = r10;
    }

    public void constrainPercentHeight(int r5, float r10) {
        get(r5).layout.heightPercent = r10;
    }

    public void constrainPercentWidth(int r5, float r10) {
        get(r5).layout.widthPercent = r10;
    }

    public void constrainWidth(int r5, int r10) {
        get(r5).layout.mWidth = r10;
    }

    public void constrainedHeight(int r5, boolean r10) {
        get(r5).layout.constrainedHeight = r10;
    }

    public void constrainedWidth(int r5, boolean r10) {
        get(r5).layout.constrainedWidth = r10;
    }

    public void create(int r5, int r10) {
        Layout r11 = get(r5).layout;
        r11.mIsGuideline = true;
        r11.orientation = r10;
    }

    public void createBarrier(int r5, int r10, int r11, int... r12) {
        Layout r13 = get(r5).layout;
        r13.mHelperType = 1;
        r13.mBarrierDirection = r10;
        r13.mBarrierMargin = r11;
        r13.mIsGuideline = false;
        r13.mReferenceIds = r12;
    }

    public void createHorizontalChain(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 1, 2);
    }

    public void createHorizontalChainRtl(int r11, int r12, int r13, int r14, int[] r15, float[] r16, int r17) {
        createHorizontalChain(r11, r12, r13, r14, r15, r16, r17, 6, 7);
    }

    public void createVerticalChain(int r13, int r14, int r15, int r16, int[] r17, float[] r18, int r19) {
        if (r17.length < 2) goto L23;
        if (r18 == null) goto L11;
        if (r18.length == r17.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r18 == null) goto L13;
        get(r17[0]).layout.verticalWeight = r18[0];
    L13:
        get(r17[0]).layout.verticalChainStyle = r19;
        connect(r17[0], 3, r13, r14, 0);
        int r10 = 1;
    L15:
        if (r10 >= r17.length) goto L20;
        int r11 = r10 - 1;
        connect(r17[r10], 3, r17[r11], 4, 0);
        connect(r17[r11], 4, r17[r10], 3, 0);
        if (r18 == null) goto L19;
        get(r17[r10]).layout.verticalWeight = r18[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(r17[r17.length - 1], 4, r15, r16, 0);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene r10, int... r11) {
        Set<Integer> r5 = this.mConstraints.keySet();
        int r12 = 0;
        if (r11.length == 0) goto L7;
        HashSet r13 = new HashSet();
        int r14 = r11.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L8;
        r13.add(Integer.valueOf(r11[r15]));
        r15 = r15 + 1;
    L8:
        System.out.println(r13.size() + " constraints");
        StringBuilder r16 = new StringBuilder();
        Integer[] r17 = (Integer[]) r13.toArray(new Integer[0]);
        int r18 = r17.length;
    L9:
        if (r12 >= r18) goto L11;
        Integer r19 = r17[r12];
        Constraint r20 = this.mConstraints.get(r19);
        r16.append("<Constraint id=");
        r16.append(r19);
        r16.append(" \n");
        r20.layout.dump(r10, r16);
        r16.append("/>\n");
        r12 = r12 + 1;
        goto L9
    L11:
        System.out.println(r16.toString());
        return;
    L7:
        r13 = new HashSet(r5);
        goto L8
    }

    public boolean getApplyElevation(int r5) {
        return get(r5).transform.applyElevation;
    }

    public Constraint getConstraint(int r5) {
        if (this.mConstraints.containsKey(Integer.valueOf(r5)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(r5));
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int r5) {
        return get(r5).layout.mHeight;
    }

    public int[] getKnownIds() {
        int r5 = 0;
        Integer[] r10 = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int r11 = r10.length;
        int[] r12 = new int[r11];
    L3:
        if (r5 >= r11) goto L5;
        r12[r5] = r10[r5].intValue();
        r5 = r5 + 1;
        goto L3
    L5:
        return r12;
    }

    public Constraint getParameters(int r5) {
        return get(r5);
    }

    public int[] getReferencedIds(int r5) {
        int[] r10 = get(r5).layout.mReferenceIds;
        if (r10 != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r10, r10.length);
    }

    public int getVisibility(int r5) {
        return get(r5).propertySet.visibility;
    }

    public int getVisibilityMode(int r5) {
        return get(r5).propertySet.mVisibilityMode;
    }

    public int getWidth(int r5) {
        return get(r5).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context r5, int r10) {
        XmlResourceParser r11 = r5.getResources().getXml(r10);
        int r12 = r11.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L5:
        if (r12 == 1) goto L32;
        if (r12 != 0) goto L8;
        r11.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L19:
        r12 = r11.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L8:
        if (r12 != 2) goto L19;
        String r13 = r11.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        Constraint r14 = fillFromAttributeList(r5, Xml.asAttributeSet(r11));     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r13.equalsIgnoreCase("Guideline") == false) goto L17;
        r14.layout.mIsGuideline = true;     // Catch: IOException -> L13 XmlPullParserException -> L15
    L17:
        this.mConstraints.put(Integer.valueOf(r14.mViewId), r14);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L19
    L32:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public void parseColorAttributes(Constraint r5, String r10) {
        String[] r11 = r10.split(",");
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L10;
        String[] r13 = r11[r12].split("=");
        if (r13.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r11[r12]);
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        Constraint.access$600(r5, r13[0], Color.parseColor(r13[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint r5, String r10) {
        String[] r11 = r10.split(",");
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L10;
        String[] r13 = r11[r12].split("=");
        if (r13.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r11[r12]);
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        Constraint.access$700(r5, r13[0], Float.parseFloat(r13[1]));
        goto L9
    }

    public void parseIntAttributes(Constraint r5, String r10) {
        String[] r11 = r10.split(",");
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L10;
        String[] r13 = r11[r12].split("=");
        if (r13.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r11[r12]);
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        Constraint.access$700(r5, r13[0], Integer.decode(r13[1]).intValue());
        goto L9
    }

    public void parseStringAttributes(Constraint r5, String r10) {
        String[] r11 = splitString(r10);
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L6;
        String[] r13 = r11[r12].split("=");
        Log.w(TAG, " Unable to parse " + r11[r12]);
        Constraint.access$800(r5, r13[0], r13[1]);
        r12 = r12 + 1;
        goto L4
    }

    public void readFallback(ConstraintSet r10) {
        Iterator<Integer> r5 = r10.mConstraints.keySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L26;
        Integer r11 = r5.next();
        r11.intValue();
        Constraint r12 = r10.mConstraints.get(r11);
        if (this.mConstraints.containsKey(r11) == true) goto L8;
        this.mConstraints.put(r11, new Constraint());
    L8:
        Constraint r13 = this.mConstraints.get(r11);
        Layout r14 = r13.layout;
        if (r14.mApply == true) goto L11;
        r14.copyFrom(r12.layout);
    L11:
        PropertySet r15 = r13.propertySet;
        if (r15.mApply == true) goto L14;
        r15.copyFrom(r12.propertySet);
    L14:
        Transform r16 = r13.transform;
        if (r16.mApply == true) goto L17;
        r16.copyFrom(r12.transform);
    L17:
        Motion r17 = r13.motion;
        if (r17.mApply == true) goto L20;
        r17.copyFrom(r12.motion);
    L20:
        Iterator<String> r18 = r12.mCustomConstraints.keySet().iterator();
    L22:
        if (r18.hasNext() == false) goto L4;
        String r19 = r18.next();
        if (r13.mCustomConstraints.containsKey(r19) == true) goto L22;
        r13.mCustomConstraints.put(r19, r12.mCustomConstraints.get(r19));
        goto L22
    }

    public void removeAttribute(String r5) {
        this.mSavedAttributes.remove(r5);
    }

    public void removeFromHorizontalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L36;
        Layout r5 = this.mConstraints.get(Integer.valueOf(r10)).layout;
        int r11 = r5.leftToRight;
        int r12 = r5.rightToLeft;
        if (r11 != (-1)) goto L23;
        if (r12 != (-1)) goto L23;
        int r13 = r5.startToEnd;
        int r14 = r5.endToStart;
        if (r13 != (-1)) goto L11;
        if (r14 != (-1)) goto L11;
    L22:
        clear(r10, 6);
        clear(r10, 7);
        return;
    L11:
        if (r13 == (-1)) goto L14;
        if (r14 == (-1)) goto L14;
        connect(r13, 7, r14, 6, 0);
        connect(r14, 6, r11, 7, 0);
    L14:
        if (r11 != (-1)) goto L16;
        if (r14 == (-1)) goto L22;
    L16:
        int r15 = r5.rightToRight;
        if (r15 == (-1)) goto L19;
        connect(r11, 7, r15, 7, 0);
        goto L22
    L19:
        int r16 = r5.leftToLeft;
        if (r16 == (-1)) goto L22;
        connect(r14, 6, r16, 6, 0);
    L23:
        if (r11 == (-1)) goto L26;
        if (r12 == (-1)) goto L26;
        connect(r11, 2, r12, 1, 0);
        connect(r12, 1, r11, 2, 0);
    L34:
        clear(r10, 1);
        clear(r10, 2);
        return;
    L26:
        if (r11 != (-1)) goto L28;
        if (r12 == (-1)) goto L34;
    L28:
        int r17 = r5.rightToRight;
        if (r17 == (-1)) goto L31;
        connect(r11, 2, r17, 2, 0);
        goto L34
    L31:
        int r18 = r5.leftToLeft;
        if (r18 == (-1)) goto L34;
        connect(r12, 1, r18, 1, 0);
        goto L34
    }

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L18;
        Layout r5 = this.mConstraints.get(Integer.valueOf(r10)).layout;
        int r11 = r5.topToBottom;
        int r12 = r5.bottomToTop;
        if (r11 != (-1)) goto L7;
        if (r12 == (-1)) goto L18;
    L7:
        if (r11 == (-1)) goto L10;
        if (r12 == (-1)) goto L10;
        connect(r11, 4, r12, 3, 0);
        connect(r12, 3, r11, 4, 0);
    L10:
        if (r11 != (-1)) goto L12;
        if (r12 == (-1)) goto L18;
    L12:
        int r13 = r5.bottomToBottom;
        if (r13 == (-1)) goto L15;
        connect(r11, 4, r13, 4, 0);
        goto L18
    L15:
        int r14 = r5.topToTop;
        if (r14 == (-1)) goto L18;
        connect(r12, 3, r14, 3, 0);
    L18:
        clear(r10, 3);
        clear(r10, 4);
    }

    public void setAlpha(int r5, float r10) {
        get(r5).propertySet.alpha = r10;
    }

    public void setApplyElevation(int r5, boolean r10) {
        get(r5).transform.applyElevation = r10;
    }

    public void setBarrierType(int r5, int r10) {
        get(r5).layout.mHelperType = r10;
    }

    public void setColorValue(int r5, String r10, int r11) {
        Constraint.access$600(get(r5), r10, r11);
    }

    public void setDimensionRatio(int r5, String r10) {
        get(r5).layout.dimensionRatio = r10;
    }

    public void setEditorAbsoluteX(int r5, int r10) {
        get(r5).layout.editorAbsoluteX = r10;
    }

    public void setEditorAbsoluteY(int r5, int r10) {
        get(r5).layout.editorAbsoluteY = r10;
    }

    public void setElevation(int r5, float r10) {
        get(r5).transform.elevation = r10;
        get(r5).transform.applyElevation = true;
    }

    public void setFloatValue(int r5, String r10, float r11) {
        Constraint.access$700(get(r5), r10, r11);
    }

    public void setForceId(boolean r5) {
        this.mForceId = r5;
    }

    public void setGoneMargin(int r5, int r10, int r11) {
        Constraint r12 = get(r5);
        switch(r10) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r12.layout.goneEndMargin = r11;
        return;
    L7:
        r12.layout.goneStartMargin = r11;
        return;
    L10:
        r12.layout.goneBottomMargin = r11;
        return;
    L11:
        r12.layout.goneTopMargin = r11;
        return;
    L12:
        r12.layout.goneRightMargin = r11;
        return;
    L13:
        r12.layout.goneLeftMargin = r11;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    L9:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public void setGuidelineBegin(int r5, int r10) {
        get(r5).layout.guideBegin = r10;
        get(r5).layout.guideEnd = -1;
        get(r5).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int r5, int r10) {
        get(r5).layout.guideEnd = r10;
        get(r5).layout.guideBegin = -1;
        get(r5).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int r5, float r10) {
        get(r5).layout.guidePercent = r10;
        get(r5).layout.guideEnd = -1;
        get(r5).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int r5, float r10) {
        get(r5).layout.horizontalBias = r10;
    }

    public void setHorizontalChainStyle(int r5, int r10) {
        get(r5).layout.horizontalChainStyle = r10;
    }

    public void setHorizontalWeight(int r5, float r10) {
        get(r5).layout.horizontalWeight = r10;
    }

    public void setIntValue(int r5, String r10, int r11) {
        Constraint.access$500(get(r5), r10, r11);
    }

    public void setMargin(int r5, int r10, int r11) {
        Constraint r12 = get(r5);
        switch(r10) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r12.layout.endMargin = r11;
        return;
    L7:
        r12.layout.startMargin = r11;
        return;
    L10:
        r12.layout.bottomMargin = r11;
        return;
    L11:
        r12.layout.topMargin = r11;
        return;
    L12:
        r12.layout.rightMargin = r11;
        return;
    L13:
        r12.layout.leftMargin = r11;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    L9:
        throw new IllegalArgumentException("baseline does not support margins");
    }

    public void setReferencedIds(int r5, int... r10) {
        get(r5).layout.mReferenceIds = r10;
    }

    public void setRotation(int r5, float r10) {
        get(r5).transform.rotation = r10;
    }

    public void setRotationX(int r5, float r10) {
        get(r5).transform.rotationX = r10;
    }

    public void setRotationY(int r5, float r10) {
        get(r5).transform.rotationY = r10;
    }

    public void setScaleX(int r5, float r10) {
        get(r5).transform.scaleX = r10;
    }

    public void setScaleY(int r5, float r10) {
        get(r5).transform.scaleY = r10;
    }

    public void setStringValue(int r5, String r10, String r11) {
        Constraint.access$800(get(r5), r10, r11);
    }

    public void setTransformPivot(int r5, float r10, float r11) {
        Transform r12 = get(r5).transform;
        r12.transformPivotY = r11;
        r12.transformPivotX = r10;
    }

    public void setTransformPivotX(int r5, float r10) {
        get(r5).transform.transformPivotX = r10;
    }

    public void setTransformPivotY(int r5, float r10) {
        get(r5).transform.transformPivotY = r10;
    }

    public void setTranslation(int r5, float r10, float r11) {
        Transform r12 = get(r5).transform;
        r12.translationX = r10;
        r12.translationY = r11;
    }

    public void setTranslationX(int r5, float r10) {
        get(r5).transform.translationX = r10;
    }

    public void setTranslationY(int r5, float r10) {
        get(r5).transform.translationY = r10;
    }

    public void setTranslationZ(int r5, float r10) {
        get(r5).transform.translationZ = r10;
    }

    public void setValidateOnParse(boolean r5) {
        this.mValidate = r5;
    }

    public void setVerticalBias(int r5, float r10) {
        get(r5).layout.verticalBias = r10;
    }

    public void setVerticalChainStyle(int r5, int r10) {
        get(r5).layout.verticalChainStyle = r10;
    }

    public void setVerticalWeight(int r5, float r10) {
        get(r5).layout.verticalWeight = r10;
    }

    public void setVisibility(int r5, int r10) {
        get(r5).propertySet.visibility = r10;
    }

    public void setVisibilityMode(int r5, int r10) {
        get(r5).propertySet.mVisibilityMode = r10;
    }

    private void createHorizontalChain(int r13, int r14, int r15, int r16, int[] r17, float[] r18, int r19, int r20, int r21) {
        if (r17.length < 2) goto L23;
        if (r18 == null) goto L11;
        if (r18.length == r17.length) goto L11;
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    L11:
        if (r18 == null) goto L13;
        get(r17[0]).layout.horizontalWeight = r18[0];
    L13:
        get(r17[0]).layout.horizontalChainStyle = r19;
        connect(r17[0], r20, r13, r14, -1);
        int r10 = 1;
    L15:
        if (r10 >= r17.length) goto L20;
        int r11 = r10 - 1;
        connect(r17[r10], r20, r17[r11], r21, -1);
        connect(r17[r11], r21, r17[r10], r20, -1);
        if (r18 == null) goto L19;
        get(r17[r10]).layout.horizontalWeight = r18[r10];
    L19:
        r10 = r10 + 1;
        goto L15
    L20:
        connect(r17[r17.length - 1], r21, r15, r16, -1);
        return;
    L23:
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void clear(int r5, int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r5)) == false) goto L16;
        Constraint r11 = this.mConstraints.get(Integer.valueOf(r5));
        switch(r10) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        Layout r12 = r11.layout;
        r12.endToStart = -1;
        r12.endToEnd = -1;
        r12.endMargin = -1;
        r12.goneEndMargin = -1;
        return;
    L9:
        Layout r13 = r11.layout;
        r13.startToEnd = -1;
        r13.startToStart = -1;
        r13.startMargin = -1;
        r13.goneStartMargin = -1;
        return;
    L10:
        r11.layout.baselineToBaseline = -1;
        return;
    L11:
        Layout r14 = r11.layout;
        r14.bottomToTop = -1;
        r14.bottomToBottom = -1;
        r14.bottomMargin = -1;
        r14.goneBottomMargin = -1;
        return;
    L12:
        Layout r15 = r11.layout;
        r15.topToBottom = -1;
        r15.topToTop = -1;
        r15.topMargin = -1;
        r15.goneTopMargin = -1;
        return;
    L13:
        Layout r16 = r11.layout;
        r16.rightToRight = -1;
        r16.rightToLeft = -1;
        r16.rightMargin = -1;
        r16.goneRightMargin = -1;
        return;
    L14:
        Layout r17 = r11.layout;
        r17.leftToRight = -1;
        r17.leftToLeft = -1;
        r17.leftMargin = -1;
        r17.goneLeftMargin = -1;
        return;
    L7:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void clone(ConstraintSet r5) {
        this.mConstraints.clear();
        Iterator<Integer> r10 = r5.mConstraints.keySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Integer r11 = r10.next();
        this.mConstraints.put(r11, r5.mConstraints.get(r11).clone());
        goto L4
    }

    public void centerHorizontally(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 1, 0, 0, 2, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 2, 0, r11, 1, 0, 0.5f);
    }

    public void centerHorizontallyRtl(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 6, 0, 0, 7, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 7, 0, r11, 6, 0, 0.5f);
    }

    public void centerVertically(int r10, int r11) {
        if (r11 != 0) goto L4;
        center(r10, 0, 3, 0, 0, 4, 0, 0.5f);
        return;
    L4:
        center(r10, r11, 4, 0, r11, 3, 0, 0.5f);
    }

    public void clone(ConstraintLayout r11) {
        int r5 = r11.getChildCount();
        this.mConstraints.clear();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L26;
        View r12 = r11.getChildAt(r10);
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getId();
        if (this.mForceId == false) goto L12;
        if (r14 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r14), new Constraint());
    L14:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r14));
        r15.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r12);
        Constraint.access$000(r15, r14, r13);
        r15.propertySet.visibility = r12.getVisibility();
        r15.propertySet.alpha = r12.getAlpha();
        r15.transform.rotation = r12.getRotation();
        r15.transform.rotationX = r12.getRotationX();
        r15.transform.rotationY = r12.getRotationY();
        r15.transform.scaleX = r12.getScaleX();
        r15.transform.scaleY = r12.getScaleY();
        float r16 = r12.getPivotX();
        float r17 = r12.getPivotY();
        if (r16 == 0.0d) goto L17;
    L18:
        Transform r18 = r15.transform;
        r18.transformPivotX = r16;
        r18.transformPivotY = r17;
    L19:
        r15.transform.translationX = r12.getTranslationX();
        r15.transform.translationY = r12.getTranslationY();
        r15.transform.translationZ = r12.getTranslationZ();
        Transform r19 = r15.transform;
        if (r19.applyElevation == false) goto L23;
        r19.elevation = r12.getElevation();
    L23:
        if ((r12 instanceof Barrier) == false) goto L25;
        Barrier r20 = (Barrier) r12;
        r15.layout.mBarrierAllowsGoneWidgets = r20.allowsGoneWidget();
        r15.layout.mReferenceIds = r20.getReferencedIds();
        r15.layout.mBarrierDirection = r20.getType();
        r15.layout.mBarrierMargin = r20.getMargin();
    L25:
        r10 = r10 + 1;
        goto L3
    L17:
        if (r17 == 0.0d) goto L19;
    }

    public void load(Context r10, XmlPullParser r11) {
        int r5 = r11.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r12 = null;
    L5:
        if (r5 == 1) goto L103;
        if (r5 == 0) goto L75;
        byte r13 = 3;
        if (r5 == 2) goto L21;
        if (r5 != 3) goto L76;
        String r14 = r11.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (TAG.equals(r14) == true) goto L13;
        if (r14.equalsIgnoreCase("Constraint") == false) goto L76;
        this.mConstraints.put(Integer.valueOf(r12.mViewId), r12);     // Catch: IOException -> L17 XmlPullParserException -> L19
        r12 = null;
        goto L76
    L13:
        return;
    L76:
        r5 = r11.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L5
    L21:
        String r15 = r11.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        switch(r15.hashCode()) {
            case -2025855158: goto L46;
            case -1984451626: goto L43;
            case -1269513683: goto L40;
            case -1238332596: goto L37;
            case -71750448: goto L34;
            case 1331510167: goto L31;
            case 1791837707: goto L28;
            case 1803088381: goto L25;
            default: goto L48;
        };     // Catch: IOException -> L17 XmlPullParserException -> L19
    L48:
        r13 = -1;
    L50:
        switch(r13) {
            case 0: goto L74;
            case 1: goto L73;
            case 2: goto L72;
            case 3: goto L68;
            case 4: goto L64;
            case 5: goto L60;
            case 6: goto L56;
            case 7: goto L52;
            default: goto L76;
        };
    L52:
        if (r12 == null) goto L55;
        ConstraintAttribute.parse(r10, r11, r12.mCustomConstraints);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L55:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L56:
        if (r12 == null) goto L59;
        r12.motion.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L59:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L60:
        if (r12 == null) goto L63;
        r12.layout.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L63:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L64:
        if (r12 == null) goto L67;
        r12.transform.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L67:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L68:
        if (r12 == null) goto L71;
        r12.propertySet.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L71:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L72:
        r12 = fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        r12.layout.mHelperType = 1;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L73:
        r12 = fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        Layout r16 = r12.layout;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r16.mIsGuideline = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r16.mApply = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L74:
        r12 = fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L25:
        if (r15.equals("Constraint") == false) goto L48;
        r13 = 0;
        goto L50
    L28:
        if (r15.equals("CustomAttribute") == false) goto L48;
        r13 = 7;
        goto L50
    L31:
        if (r15.equals("Barrier") == false) goto L48;
        r13 = 2;
        goto L50
    L34:
        if (r15.equals("Guideline") == false) goto L48;
        r13 = 1;
        goto L50
    L37:
        if (r15.equals("Transform") == false) goto L48;
        r13 = 4;
        goto L50
    L40:
        if (r15.equals("PropertySet") == false) goto L48;
    L43:
        if (r15.equals("Motion") == false) goto L48;
        r13 = 6;
        goto L50
    L46:
        if (r15.equals("Layout") == false) goto L48;
        r13 = 5;
        goto L50
    L75:
        r11.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L76
    L103:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void readFallback(ConstraintLayout r11) {
        int r5 = r11.getChildCount();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L36;
        View r12 = r11.getChildAt(r10);
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getId();
        if (this.mForceId == false) goto L12;
        if (r14 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r14), new Constraint());
    L14:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r14));
        if (r15.layout.mApply == true) goto L22;
        Constraint.access$000(r15, r14, r13);
        if ((r12 instanceof ConstraintHelper) == false) goto L21;
        r15.layout.mReferenceIds = ((ConstraintHelper) r12).getReferencedIds();
        if ((r12 instanceof Barrier) == false) goto L21;
        Barrier r16 = (Barrier) r12;
        r15.layout.mBarrierAllowsGoneWidgets = r16.allowsGoneWidget();
        r15.layout.mBarrierDirection = r16.getType();
        r15.layout.mBarrierMargin = r16.getMargin();
    L21:
        r15.layout.mApply = true;
    L22:
        PropertySet r17 = r15.propertySet;
        if (r17.mApply == true) goto L25;
        r17.visibility = r12.getVisibility();
        r15.propertySet.alpha = r12.getAlpha();
        r15.propertySet.mApply = true;
    L25:
        Transform r18 = r15.transform;
        if (r18.mApply == true) goto L35;
        r18.mApply = true;
        r18.rotation = r12.getRotation();
        r15.transform.rotationX = r12.getRotationX();
        r15.transform.rotationY = r12.getRotationY();
        r15.transform.scaleX = r12.getScaleX();
        r15.transform.scaleY = r12.getScaleY();
        float r19 = r12.getPivotX();
        float r20 = r12.getPivotY();
        if (r19 == 0.0d) goto L30;
    L31:
        Transform r21 = r15.transform;
        r21.transformPivotX = r19;
        r21.transformPivotY = r20;
    L32:
        r15.transform.translationX = r12.getTranslationX();
        r15.transform.translationY = r12.getTranslationY();
        r15.transform.translationZ = r12.getTranslationZ();
        Transform r22 = r15.transform;
        if (r22.applyElevation == false) goto L35;
        r22.elevation = r12.getElevation();
        goto L35
    L30:
        if (r20 == 0.0d) goto L32;
    L35:
        r10 = r10 + 1;
        goto L3
    }

    public void clone(Constraints r10) {
        int r5 = r10.getChildCount();
        this.mConstraints.clear();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L18;
        View r12 = r10.getChildAt(r11);
        Constraints.LayoutParams r13 = (Constraints.LayoutParams) r12.getLayoutParams();
        int r14 = r12.getId();
        if (this.mForceId == false) goto L12;
        if (r14 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r14), new Constraint());
    L14:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r14));
        if ((r12 instanceof ConstraintHelper) == false) goto L17;
        Constraint.access$300(r15, (ConstraintHelper) r12, r14, r13);
    L17:
        Constraint.access$400(r15, r14, r13);
        r11 = r11 + 1;
        goto L3
    }

    public void connect(int r10, int r11, int r12, int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r14 = this.mConstraints.get(Integer.valueOf(r10));
        switch(r11) {
            case 1: goto L44;
            case 2: goto L38;
            case 3: goto L32;
            case 4: goto L26;
            case 5: goto L22;
            case 6: goto L15;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        StringBuilder r15 = new StringBuilder();
        r15.append(sideToString(r11));
        r15.append(" to ");
        throw new IllegalArgumentException(j0.q(r15, sideToString(r13), " unknown"));
    L9:
        if (r13 != 7) goto L11;
        Layout r16 = r14.layout;
        r16.endToEnd = r12;
        r16.endToStart = -1;
        return;
    L11:
        if (r13 != 6) goto L14;
        Layout r17 = r14.layout;
        r17.endToStart = r12;
        r17.endToEnd = -1;
        return;
    L14:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L15:
        if (r13 != 6) goto L17;
        Layout r18 = r14.layout;
        r18.startToStart = r12;
        r18.startToEnd = -1;
        return;
    L17:
        if (r13 != 7) goto L20;
        Layout r19 = r14.layout;
        r19.startToEnd = r12;
        r19.startToStart = -1;
        return;
    L20:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L26:
        if (r13 != 4) goto L28;
        Layout r20 = r14.layout;
        r20.bottomToBottom = r12;
        r20.bottomToTop = -1;
        r20.baselineToBaseline = -1;
        return;
    L28:
        if (r13 != 3) goto L31;
        Layout r21 = r14.layout;
        r21.bottomToTop = r12;
        r21.bottomToBottom = -1;
        r21.baselineToBaseline = -1;
        return;
    L31:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L32:
        if (r13 != 3) goto L34;
        Layout r22 = r14.layout;
        r22.topToTop = r12;
        r22.topToBottom = -1;
        r22.baselineToBaseline = -1;
        return;
    L34:
        if (r13 != 4) goto L37;
        Layout r23 = r14.layout;
        r23.topToBottom = r12;
        r23.topToTop = -1;
        r23.baselineToBaseline = -1;
        return;
    L37:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L38:
        if (r13 != 1) goto L40;
        Layout r24 = r14.layout;
        r24.rightToLeft = r12;
        r24.rightToRight = -1;
        return;
    L40:
        if (r13 != 2) goto L43;
        Layout r25 = r14.layout;
        r25.rightToRight = r12;
        r25.rightToLeft = -1;
        return;
    L43:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    L44:
        if (r13 != 1) goto L46;
        Layout r26 = r14.layout;
        r26.leftToLeft = r12;
        r26.leftToRight = -1;
        return;
    L46:
        if (r13 != 2) goto L50;
        Layout r27 = r14.layout;
        r27.leftToRight = r12;
        r27.leftToLeft = -1;
        return;
    L50:
        throw new IllegalArgumentException(j0.q(new StringBuilder("left to "), sideToString(r13), " undefined"));
    L22:
        if (r13 != 5) goto L25;
        Layout r28 = r14.layout;
        r28.baselineToBaseline = r12;
        r28.bottomToBottom = -1;
        r28.bottomToTop = -1;
        r28.topToTop = -1;
        r28.topToBottom = -1;
        return;
    L25:
        throw new IllegalArgumentException(j0.q(new StringBuilder("right to "), sideToString(r13), " undefined"));
    }
}
