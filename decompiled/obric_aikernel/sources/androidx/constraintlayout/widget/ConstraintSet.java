package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_CIRCLE_ANGLE_TO = 82;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_MARGIN = 93;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BASELINE_TO_BOTTOM = 92;
    private static final int BASELINE_TO_TOP = 91;
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
    public static final int CIRCLE_REFERENCE = 8;
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
    private static final int GONE_BASELINE_MARGIN = 94;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDELINE_USE_RTL = 99;
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
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 4;
    private static final String KEY_PERCENT_PARENT = "parent";
    private static final String KEY_RATIO = "ratio";
    private static final String KEY_WEIGHT = "weight";
    private static final int LAYOUT_CONSTRAINT_HEIGHT = 96;
    private static final int LAYOUT_CONSTRAINT_WIDTH = 95;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    private static final int LAYOUT_WRAP_BEHAVIOR = 97;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int MOTION_TARGET = 98;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    private static final int QUANTIZE_MOTION_INTERPOLATOR = 86;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_ID = 89;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_STR = 90;
    private static final int QUANTIZE_MOTION_INTERPOLATOR_TYPE = 88;
    private static final int QUANTIZE_MOTION_PHASE = 85;
    private static final int QUANTIZE_MOTION_STEPS = 84;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
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
    private static final int TRANSFORM_PIVOT_TARGET = 83;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 87;
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
    private static SparseIntArray overrideMapToConstant;
    public String derivedState;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId;
    public String mIdString;
    public int mRotate;
    private HashMap<String, ConstraintAttribute> mSavedAttributes;
    private boolean mValidate;

    public static class Constraint {
        public final Layout layout;
        public HashMap<String, ConstraintAttribute> mCustomConstraints;
        Delta mDelta;
        String mTargetString;
        int mViewId;
        public final Motion motion;
        public final PropertySet propertySet;
        public final Transform transform;

        static class Delta {
            private static final int INITIAL_BOOLEAN = 4;
            private static final int INITIAL_FLOAT = 10;
            private static final int INITIAL_INT = 10;
            private static final int INITIAL_STRING = 5;
            int mCountBoolean;
            int mCountFloat;
            int mCountInt;
            int mCountString;
            int[] mTypeBoolean;
            int[] mTypeFloat;
            int[] mTypeInt;
            int[] mTypeString;
            boolean[] mValueBoolean;
            float[] mValueFloat;
            int[] mValueInt;
            String[] mValueString;

            Delta() {
                this.mTypeInt = new int[10];
                this.mValueInt = new int[10];
                this.mCountInt = 0;
                this.mTypeFloat = new int[10];
                this.mValueFloat = new float[10];
                this.mCountFloat = 0;
                this.mTypeString = new int[5];
                this.mValueString = new String[5];
                this.mCountString = 0;
                this.mTypeBoolean = new int[4];
                this.mValueBoolean = new boolean[4];
                this.mCountBoolean = 0;
            }

            void add(int r10, float r11) {
                int r12 = this.mCountFloat;
                int[] r13 = this.mTypeFloat;
                if (r12 < r13.length) goto L5;
                this.mTypeFloat = Arrays.copyOf(r13, r13.length * 2);
                float[] r14 = this.mValueFloat;
                this.mValueFloat = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.mTypeFloat;
                int r16 = this.mCountFloat;
                r15[r16] = r10;
                float[] r17 = this.mValueFloat;
                this.mCountFloat = r16 + 1;
                r17[r16] = r11;
            }

            void add(int r10, int r11) {
                int r12 = this.mCountInt;
                int[] r13 = this.mTypeInt;
                if (r12 < r13.length) goto L5;
                this.mTypeInt = Arrays.copyOf(r13, r13.length * 2);
                int[] r14 = this.mValueInt;
                this.mValueInt = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.mTypeInt;
                int r16 = this.mCountInt;
                r15[r16] = r10;
                int[] r17 = this.mValueInt;
                this.mCountInt = r16 + 1;
                r17[r16] = r11;
            }

            void add(int r10, String r11) {
                int r12 = this.mCountString;
                int[] r13 = this.mTypeString;
                if (r12 < r13.length) goto L5;
                this.mTypeString = Arrays.copyOf(r13, r13.length * 2);
                String[] r14 = this.mValueString;
                this.mValueString = (String[]) Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.mTypeString;
                int r16 = this.mCountString;
                r15[r16] = r10;
                String[] r17 = this.mValueString;
                this.mCountString = r16 + 1;
                r17[r16] = r11;
            }

            void add(int r10, boolean r11) {
                int r12 = this.mCountBoolean;
                int[] r13 = this.mTypeBoolean;
                if (r12 < r13.length) goto L5;
                this.mTypeBoolean = Arrays.copyOf(r13, r13.length * 2);
                boolean[] r14 = this.mValueBoolean;
                this.mValueBoolean = Arrays.copyOf(r14, r14.length * 2);
            L5:
                int[] r15 = this.mTypeBoolean;
                int r16 = this.mCountBoolean;
                r15[r16] = r10;
                boolean[] r17 = this.mValueBoolean;
                this.mCountBoolean = r16 + 1;
                r17[r16] = r11;
            }

            void applyDelta(Constraint r10) {
                int r11 = 0;
                int r12 = 0;
            L4:
                if (r12 >= this.mCountInt) goto L6;
                ConstraintSet.access$300(r10, this.mTypeInt[r12], this.mValueInt[r12]);
                r12 = r12 + 1;
                goto L4
            L6:
                int r13 = 0;
            L8:
                if (r13 >= this.mCountFloat) goto L10;
                ConstraintSet.access$400(r10, this.mTypeFloat[r13], this.mValueFloat[r13]);
                r13 = r13 + 1;
                goto L8
            L10:
                int r14 = 0;
            L12:
                if (r14 >= this.mCountString) goto L15;
                ConstraintSet.access$500(r10, this.mTypeString[r14], this.mValueString[r14]);
                r14 = r14 + 1;
            L15:
                if (r11 >= this.mCountBoolean) goto L17;
                ConstraintSet.access$600(r10, this.mTypeBoolean[r11], this.mValueBoolean[r11]);
                r11 = r11 + 1;
                goto L15
            }

            @SuppressLint({"LogConditional"})
            void printDelta(String r10) {
                Log.v(r10, "int");
                int r11 = 0;
                int r12 = 0;
            L4:
                if (r12 >= this.mCountInt) goto L6;
                Log.v(r10, this.mTypeInt[r12] + " = " + this.mValueInt[r12]);
                r12 = r12 + 1;
                goto L4
            L6:
                Log.v(r10, TypedValues.Custom.S_FLOAT);
                int r13 = 0;
            L8:
                if (r13 >= this.mCountFloat) goto L10;
                Log.v(r10, this.mTypeFloat[r13] + " = " + this.mValueFloat[r13]);
                r13 = r13 + 1;
                goto L8
            L10:
                Log.v(r10, "strings");
                int r14 = 0;
            L12:
                if (r14 >= this.mCountString) goto L14;
                Log.v(r10, this.mTypeString[r14] + " = " + this.mValueString[r14]);
                r14 = r14 + 1;
                goto L12
            L14:
                Log.v(r10, TypedValues.Custom.S_BOOLEAN);
            L16:
                if (r11 >= this.mCountBoolean) goto L18;
                Log.v(r10, this.mTypeBoolean[r11] + " = " + this.mValueBoolean[r11]);
                r11 = r11 + 1;
                goto L16
            }
        }

        public Constraint() {
            this.propertySet = new PropertySet();
            this.motion = new Motion();
            this.layout = new Layout();
            this.transform = new Transform();
            this.mCustomConstraints = new HashMap();
        }

        static /* synthetic */ void access$000(Constraint r10, int r11, ConstraintLayout.LayoutParams r12) {
            r10.fillFrom(r11, r12);
        }

        static /* synthetic */ void access$1000(Constraint r10, String r11, int r12) {
            r10.setColorValue(r11, r12);
        }

        static /* synthetic */ void access$1100(Constraint r10, String r11, float r12) {
            r10.setFloatValue(r11, r12);
        }

        static /* synthetic */ void access$1200(Constraint r10, String r11, String r12) {
            r10.setStringValue(r11, r12);
        }

        static /* synthetic */ void access$700(Constraint r10, ConstraintHelper r11, int r12, Constraints.LayoutParams r13) {
            r10.fillFromConstraints(r11, r12, r13);
        }

        static /* synthetic */ void access$800(Constraint r10, int r11, Constraints.LayoutParams r12) {
            r10.fillFromConstraints(r11, r12);
        }

        static /* synthetic */ void access$900(Constraint r10, String r11, int r12) {
            r10.setIntValue(r11, r12);
        }

        private void fillFrom(int r10, ConstraintLayout.LayoutParams r11) {
            this.mViewId = r10;
            Layout r12 = this.layout;
            r12.leftToLeft = r11.leftToLeft;
            r12.leftToRight = r11.leftToRight;
            r12.rightToLeft = r11.rightToLeft;
            r12.rightToRight = r11.rightToRight;
            r12.topToTop = r11.topToTop;
            r12.topToBottom = r11.topToBottom;
            r12.bottomToTop = r11.bottomToTop;
            r12.bottomToBottom = r11.bottomToBottom;
            r12.baselineToBaseline = r11.baselineToBaseline;
            r12.baselineToTop = r11.baselineToTop;
            r12.baselineToBottom = r11.baselineToBottom;
            r12.startToEnd = r11.startToEnd;
            r12.startToStart = r11.startToStart;
            r12.endToStart = r11.endToStart;
            r12.endToEnd = r11.endToEnd;
            r12.horizontalBias = r11.horizontalBias;
            r12.verticalBias = r11.verticalBias;
            r12.dimensionRatio = r11.dimensionRatio;
            r12.circleConstraint = r11.circleConstraint;
            r12.circleRadius = r11.circleRadius;
            r12.circleAngle = r11.circleAngle;
            r12.editorAbsoluteX = r11.editorAbsoluteX;
            r12.editorAbsoluteY = r11.editorAbsoluteY;
            r12.orientation = r11.orientation;
            r12.guidePercent = r11.guidePercent;
            r12.guideBegin = r11.guideBegin;
            r12.guideEnd = r11.guideEnd;
            r12.mWidth = ((ViewGroup.MarginLayoutParams) r11).width;
            r12.mHeight = ((ViewGroup.MarginLayoutParams) r11).height;
            r12.leftMargin = ((ViewGroup.MarginLayoutParams) r11).leftMargin;
            r12.rightMargin = ((ViewGroup.MarginLayoutParams) r11).rightMargin;
            r12.topMargin = ((ViewGroup.MarginLayoutParams) r11).topMargin;
            r12.bottomMargin = ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
            r12.baselineMargin = r11.baselineMargin;
            r12.verticalWeight = r11.verticalWeight;
            r12.horizontalWeight = r11.horizontalWeight;
            r12.verticalChainStyle = r11.verticalChainStyle;
            r12.horizontalChainStyle = r11.horizontalChainStyle;
            r12.constrainedWidth = r11.constrainedWidth;
            r12.constrainedHeight = r11.constrainedHeight;
            r12.widthDefault = r11.matchConstraintDefaultWidth;
            r12.heightDefault = r11.matchConstraintDefaultHeight;
            r12.widthMax = r11.matchConstraintMaxWidth;
            r12.heightMax = r11.matchConstraintMaxHeight;
            r12.widthMin = r11.matchConstraintMinWidth;
            r12.heightMin = r11.matchConstraintMinHeight;
            r12.widthPercent = r11.matchConstraintPercentWidth;
            r12.heightPercent = r11.matchConstraintPercentHeight;
            r12.mConstraintTag = r11.constraintTag;
            r12.goneTopMargin = r11.goneTopMargin;
            r12.goneBottomMargin = r11.goneBottomMargin;
            r12.goneLeftMargin = r11.goneLeftMargin;
            r12.goneRightMargin = r11.goneRightMargin;
            r12.goneStartMargin = r11.goneStartMargin;
            r12.goneEndMargin = r11.goneEndMargin;
            r12.goneBaselineMargin = r11.goneBaselineMargin;
            r12.mWrapBehavior = r11.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT < 17) goto L6;
            r12.endMargin = r11.getMarginEnd();
            Layout r13 = this.layout;
            r13.startMargin = r11.getMarginStart();
            return;
        }

        private void fillFromConstraints(int r10, Constraints.LayoutParams r11) {
            fillFrom(r10, r11);
            PropertySet r12 = this.propertySet;
            r12.alpha = r11.alpha;
            Transform r13 = this.transform;
            r13.rotation = r11.rotation;
            r13.rotationX = r11.rotationX;
            r13.rotationY = r11.rotationY;
            r13.scaleX = r11.scaleX;
            r13.scaleY = r11.scaleY;
            r13.transformPivotX = r11.transformPivotX;
            r13.transformPivotY = r11.transformPivotY;
            r13.translationX = r11.translationX;
            r13.translationY = r11.translationY;
            r13.translationZ = r11.translationZ;
            r13.elevation = r11.elevation;
            r13.applyElevation = r11.applyElevation;
        }

        private void fillFromConstraints(ConstraintHelper r10, int r11, Constraints.LayoutParams r12) {
            fillFromConstraints(r11, r12);
            if ((r10 instanceof Barrier) == false) goto L6;
            Layout r13 = this.layout;
            r13.mHelperType = 1;
            Barrier r14 = (Barrier) r10;
            r13.mBarrierDirection = r14.getType();
            Layout r15 = this.layout;
            r15.mReferenceIds = r14.getReferencedIds();
            Layout r16 = this.layout;
            r16.mBarrierMargin = r14.getMargin();
            return;
        }

        private ConstraintAttribute get(String r10, ConstraintAttribute.AttributeType r11) {
            if (this.mCustomConstraints.containsKey(r10) == false) goto L9;
            ConstraintAttribute r12 = this.mCustomConstraints.get(r10);
            if (r12.getType() != r11) goto L8;
            return r12;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r12.getType().name());
        L9:
            ConstraintAttribute r13 = new ConstraintAttribute(r10, r11);
            this.mCustomConstraints.put(r10, r13);
            return r13;
        }

        private void setColorValue(String r10, int r11) {
            get(r10, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r11);
        }

        private void setFloatValue(String r10, float r11) {
            get(r10, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r11);
        }

        private void setIntValue(String r10, int r11) {
            get(r10, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r11);
        }

        private void setStringValue(String r10, String r11) {
            get(r10, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r11);
        }

        public void applyDelta(Constraint r10) {
            Delta r11 = this.mDelta;
            if (r11 == null) goto L6;
            r11.applyDelta(r10);
            return;
        }

        public void applyTo(ConstraintLayout.LayoutParams r10) {
            Layout r11 = this.layout;
            r10.leftToLeft = r11.leftToLeft;
            r10.leftToRight = r11.leftToRight;
            r10.rightToLeft = r11.rightToLeft;
            r10.rightToRight = r11.rightToRight;
            r10.topToTop = r11.topToTop;
            r10.topToBottom = r11.topToBottom;
            r10.bottomToTop = r11.bottomToTop;
            r10.bottomToBottom = r11.bottomToBottom;
            r10.baselineToBaseline = r11.baselineToBaseline;
            r10.baselineToTop = r11.baselineToTop;
            r10.baselineToBottom = r11.baselineToBottom;
            r10.startToEnd = r11.startToEnd;
            r10.startToStart = r11.startToStart;
            r10.endToStart = r11.endToStart;
            r10.endToEnd = r11.endToEnd;
            ((ViewGroup.MarginLayoutParams) r10).leftMargin = r11.leftMargin;
            ((ViewGroup.MarginLayoutParams) r10).rightMargin = r11.rightMargin;
            ((ViewGroup.MarginLayoutParams) r10).topMargin = r11.topMargin;
            ((ViewGroup.MarginLayoutParams) r10).bottomMargin = r11.bottomMargin;
            r10.goneStartMargin = r11.goneStartMargin;
            r10.goneEndMargin = r11.goneEndMargin;
            r10.goneTopMargin = r11.goneTopMargin;
            r10.goneBottomMargin = r11.goneBottomMargin;
            r10.horizontalBias = r11.horizontalBias;
            r10.verticalBias = r11.verticalBias;
            r10.circleConstraint = r11.circleConstraint;
            r10.circleRadius = r11.circleRadius;
            r10.circleAngle = r11.circleAngle;
            r10.dimensionRatio = r11.dimensionRatio;
            r10.editorAbsoluteX = r11.editorAbsoluteX;
            r10.editorAbsoluteY = r11.editorAbsoluteY;
            r10.verticalWeight = r11.verticalWeight;
            r10.horizontalWeight = r11.horizontalWeight;
            r10.verticalChainStyle = r11.verticalChainStyle;
            r10.horizontalChainStyle = r11.horizontalChainStyle;
            r10.constrainedWidth = r11.constrainedWidth;
            r10.constrainedHeight = r11.constrainedHeight;
            r10.matchConstraintDefaultWidth = r11.widthDefault;
            r10.matchConstraintDefaultHeight = r11.heightDefault;
            r10.matchConstraintMaxWidth = r11.widthMax;
            r10.matchConstraintMaxHeight = r11.heightMax;
            r10.matchConstraintMinWidth = r11.widthMin;
            r10.matchConstraintMinHeight = r11.heightMin;
            r10.matchConstraintPercentWidth = r11.widthPercent;
            r10.matchConstraintPercentHeight = r11.heightPercent;
            r10.orientation = r11.orientation;
            r10.guidePercent = r11.guidePercent;
            r10.guideBegin = r11.guideBegin;
            r10.guideEnd = r11.guideEnd;
            ((ViewGroup.MarginLayoutParams) r10).width = r11.mWidth;
            ((ViewGroup.MarginLayoutParams) r10).height = r11.mHeight;
            String r12 = r11.mConstraintTag;
            if (r12 == null) goto L5;
            r10.constraintTag = r12;
        L5:
            r10.wrapBehaviorInParent = r11.mWrapBehavior;
            if (Build.VERSION.SDK_INT < 17) goto L8;
            r10.setMarginStart(r11.startMargin);
            r10.setMarginEnd(this.layout.endMargin);
        L8:
            r10.validate();
        }

        public Constraint clone() {
            Constraint r10 = new Constraint();
            r10.layout.copyFrom(this.layout);
            r10.motion.copyFrom(this.motion);
            r10.propertySet.copyFrom(this.propertySet);
            r10.transform.copyFrom(this.transform);
            r10.mViewId = this.mViewId;
            r10.mDelta = this.mDelta;
            return r10;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m5clone() {
            return clone();
        }

        public void printDelta(String r10) {
            Delta r11 = this.mDelta;
            if (r11 == null) goto L5;
            r11.printDelta(r10);
            return;
        L5:
            Log.v(r10, "DELTA IS NULL");
        }
    }

    public static class Layout {
        private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
        private static final int BARRIER_DIRECTION = 72;
        private static final int BARRIER_MARGIN = 73;
        private static final int BASELINE_MARGIN = 80;
        private static final int BASELINE_TO_BASELINE = 1;
        private static final int BASELINE_TO_BOTTOM = 78;
        private static final int BASELINE_TO_TOP = 77;
        private static final int BOTTOM_MARGIN = 2;
        private static final int BOTTOM_TO_BOTTOM = 3;
        private static final int BOTTOM_TO_TOP = 4;
        private static final int CHAIN_USE_RTL = 71;
        private static final int CIRCLE = 61;
        private static final int CIRCLE_ANGLE = 63;
        private static final int CIRCLE_RADIUS = 62;
        private static final int CONSTRAINED_HEIGHT = 88;
        private static final int CONSTRAINED_WIDTH = 87;
        private static final int CONSTRAINT_REFERENCED_IDS = 74;
        private static final int CONSTRAINT_TAG = 89;
        private static final int DIMENSION_RATIO = 5;
        private static final int EDITOR_ABSOLUTE_X = 6;
        private static final int EDITOR_ABSOLUTE_Y = 7;
        private static final int END_MARGIN = 8;
        private static final int END_TO_END = 9;
        private static final int END_TO_START = 10;
        private static final int GONE_BASELINE_MARGIN = 79;
        private static final int GONE_BOTTOM_MARGIN = 11;
        private static final int GONE_END_MARGIN = 12;
        private static final int GONE_LEFT_MARGIN = 13;
        private static final int GONE_RIGHT_MARGIN = 14;
        private static final int GONE_START_MARGIN = 15;
        private static final int GONE_TOP_MARGIN = 16;
        private static final int GUIDE_BEGIN = 17;
        private static final int GUIDE_END = 18;
        private static final int GUIDE_PERCENT = 19;
        private static final int GUIDE_USE_RTL = 90;
        private static final int HEIGHT_DEFAULT = 82;
        private static final int HEIGHT_MAX = 83;
        private static final int HEIGHT_MIN = 85;
        private static final int HEIGHT_PERCENT = 70;
        private static final int HORIZONTAL_BIAS = 20;
        private static final int HORIZONTAL_STYLE = 39;
        private static final int HORIZONTAL_WEIGHT = 37;
        private static final int LAYOUT_CONSTRAINT_HEIGHT = 42;
        private static final int LAYOUT_CONSTRAINT_WIDTH = 41;
        private static final int LAYOUT_HEIGHT = 21;
        private static final int LAYOUT_WIDTH = 22;
        private static final int LAYOUT_WRAP_BEHAVIOR = 76;
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
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;
        private static final int UNUSED = 91;
        private static final int VERTICAL_BIAS = 36;
        private static final int VERTICAL_STYLE = 40;
        private static final int VERTICAL_WEIGHT = 38;
        private static final int WIDTH_DEFAULT = 81;
        private static final int WIDTH_MAX = 84;
        private static final int WIDTH_MIN = 86;
        private static final int WIDTH_PERCENT = 69;
        private static SparseIntArray mapToConstant;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
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
        public boolean mOverride;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public int mWrapBehavior;
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
            SparseIntArray r10 = new SparseIntArray();
            mapToConstant = r10;
            r10.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
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
            mapToConstant.append(R.styleable.Layout_guidelineUseRtl, 90);
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
            mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
            mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
            mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
            mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
            mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
            mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
            mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
            mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
            mapToConstant.append(R.styleable.Layout_layout_constraintWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constraintHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_constrainedWidth, 41);
            mapToConstant.append(R.styleable.Layout_layout_constrainedHeight, 42);
            mapToConstant.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
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
            this.mOverride = false;
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
            this.leftMargin = 0;
            this.rightMargin = 0;
            this.topMargin = 0;
            this.bottomMargin = 0;
            this.endMargin = 0;
            this.startMargin = 0;
            this.baselineMargin = 0;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.verticalWeight = -1.0f;
            this.horizontalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.widthDefault = 0;
            this.heightDefault = 0;
            this.widthMax = 0;
            this.heightMax = 0;
            this.widthMin = 0;
            this.heightMin = 0;
            this.widthPercent = 1.0f;
            this.heightPercent = 1.0f;
            this.mBarrierDirection = -1;
            this.mBarrierMargin = 0;
            this.mHelperType = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.mBarrierAllowsGoneWidgets = true;
            this.mWrapBehavior = 0;
        }

        public void copyFrom(Layout r10) {
            this.mIsGuideline = r10.mIsGuideline;
            this.mWidth = r10.mWidth;
            this.mApply = r10.mApply;
            this.mHeight = r10.mHeight;
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
            this.startToEnd = r10.startToEnd;
            this.startToStart = r10.startToStart;
            this.endToStart = r10.endToStart;
            this.endToEnd = r10.endToEnd;
            this.horizontalBias = r10.horizontalBias;
            this.verticalBias = r10.verticalBias;
            this.dimensionRatio = r10.dimensionRatio;
            this.circleConstraint = r10.circleConstraint;
            this.circleRadius = r10.circleRadius;
            this.circleAngle = r10.circleAngle;
            this.editorAbsoluteX = r10.editorAbsoluteX;
            this.editorAbsoluteY = r10.editorAbsoluteY;
            this.orientation = r10.orientation;
            this.leftMargin = r10.leftMargin;
            this.rightMargin = r10.rightMargin;
            this.topMargin = r10.topMargin;
            this.bottomMargin = r10.bottomMargin;
            this.endMargin = r10.endMargin;
            this.startMargin = r10.startMargin;
            this.baselineMargin = r10.baselineMargin;
            this.goneLeftMargin = r10.goneLeftMargin;
            this.goneTopMargin = r10.goneTopMargin;
            this.goneRightMargin = r10.goneRightMargin;
            this.goneBottomMargin = r10.goneBottomMargin;
            this.goneEndMargin = r10.goneEndMargin;
            this.goneStartMargin = r10.goneStartMargin;
            this.goneBaselineMargin = r10.goneBaselineMargin;
            this.verticalWeight = r10.verticalWeight;
            this.horizontalWeight = r10.horizontalWeight;
            this.horizontalChainStyle = r10.horizontalChainStyle;
            this.verticalChainStyle = r10.verticalChainStyle;
            this.widthDefault = r10.widthDefault;
            this.heightDefault = r10.heightDefault;
            this.widthMax = r10.widthMax;
            this.heightMax = r10.heightMax;
            this.widthMin = r10.widthMin;
            this.heightMin = r10.heightMin;
            this.widthPercent = r10.widthPercent;
            this.heightPercent = r10.heightPercent;
            this.mBarrierDirection = r10.mBarrierDirection;
            this.mBarrierMargin = r10.mBarrierMargin;
            this.mHelperType = r10.mHelperType;
            this.mConstraintTag = r10.mConstraintTag;
            int[] r11 = r10.mReferenceIds;
            if (r11 != null) goto L5;
        L7:
            this.mReferenceIds = null;
        L8:
            this.mReferenceIdString = r10.mReferenceIdString;
            this.constrainedWidth = r10.constrainedWidth;
            this.constrainedHeight = r10.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = r10.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = r10.mWrapBehavior;
            return;
        L5:
            if (r10.mReferenceIdString != null) goto L7;
            this.mReferenceIds = Arrays.copyOf(r11, r11.length);
            goto L8
        }

        public void dump(MotionScene r10, StringBuilder r11) {
            Field[] r12 = getClass().getDeclaredFields();
            r11.append("\n");
            int r13 = 0;
        L4:
            if (r13 >= r12.length) goto L28;
            Field r14 = r12[r13];
            String r15 = r14.getName();
            if (Modifier.isStatic(r14.getModifiers()) == true) goto L27;
            Object r16 = r14.get(this);     // Catch: IllegalAccessException -> L25
            Class<?> r17 = r14.getType();     // Catch: IllegalAccessException -> L25
            if (r17 != Integer.TYPE) goto L20;
            Integer r18 = (Integer) r16;     // Catch: IllegalAccessException -> L25
            if (r18.intValue() == (-1)) goto L27;
            Object r19 = r10.lookUpConstraintName(r18.intValue());     // Catch: IllegalAccessException -> L25
            r11.append("    ");     // Catch: IllegalAccessException -> L25
            r11.append(r15);     // Catch: IllegalAccessException -> L25
            r11.append(" = \"");     // Catch: IllegalAccessException -> L25
            if (r19 != null) goto L16;
            Object r20 = r18;
        L17:
            r11.append(r20);     // Catch: IllegalAccessException -> L25
        L18:
            r11.append("\"\n");     // Catch: IllegalAccessException -> L25
            goto L27
        L16:
            r20 = r19;
            goto L17
        L20:
            if (r17 != Float.TYPE) goto L27;
            Float r21 = (Float) r16;     // Catch: IllegalAccessException -> L25
            if (r21.floatValue() == (-1.0f)) goto L27;
            r11.append("    ");     // Catch: IllegalAccessException -> L25
            r11.append(r15);     // Catch: IllegalAccessException -> L25
            r11.append(" = \"");     // Catch: IllegalAccessException -> L25
            r11.append(r21);     // Catch: IllegalAccessException -> L25
        L25:
            e = move-exception;
            e.printStackTrace();
        L27:
            r13 = r13 + 1;
            goto L4
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Layout);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L84;
            int r15 = r12.getIndex(r14);
            int r16 = mapToConstant.get(r15);
            switch(r16) {
                case 1: goto L82;
                case 2: goto L81;
                case 3: goto L80;
                case 4: goto L79;
                case 5: goto L78;
                case 6: goto L77;
                case 7: goto L76;
                case 8: goto L74;
                case 9: goto L72;
                case 10: goto L71;
                case 11: goto L70;
                case 12: goto L69;
                case 13: goto L68;
                case 14: goto L67;
                case 15: goto L66;
                case 16: goto L65;
                case 17: goto L64;
                case 18: goto L63;
                case 19: goto L62;
                case 20: goto L61;
                case 21: goto L60;
                case 22: goto L59;
                case 23: goto L58;
                case 24: goto L57;
                case 25: goto L56;
                case 26: goto L55;
                case 27: goto L54;
                case 28: goto L53;
                case 29: goto L52;
                case 30: goto L50;
                case 31: goto L48;
                case 32: goto L47;
                case 33: goto L46;
                case 34: goto L45;
                case 35: goto L44;
                case 36: goto L43;
                case 37: goto L42;
                case 38: goto L41;
                case 39: goto L40;
                case 40: goto L39;
                case 41: goto L38;
                case 42: goto L37;
                default: goto L6;
            };
        L6:
            switch(r16) {
                case 61: goto L36;
                case 62: goto L35;
                case 63: goto L34;
                default: goto L8;
            };
        L34:
            this.circleAngle = r12.getFloat(r15, this.circleAngle);
        L83:
            r14 = r14 + 1;
            goto L3
        L35:
            this.circleRadius = r12.getDimensionPixelSize(r15, this.circleRadius);
            goto L83
        L36:
            this.circleConstraint = ConstraintSet.access$100(r12, r15, this.circleConstraint);
            goto L83
        L8:
            switch(r16) {
                case 69: goto L33;
                case 70: goto L32;
                case 71: goto L31;
                case 72: goto L30;
                case 73: goto L29;
                case 74: goto L28;
                case 75: goto L27;
                case 76: goto L26;
                case 77: goto L25;
                case 78: goto L24;
                case 79: goto L23;
                case 80: goto L22;
                case 81: goto L21;
                case 82: goto L20;
                case 83: goto L19;
                case 84: goto L18;
                case 85: goto L17;
                case 86: goto L16;
                case 87: goto L15;
                case 88: goto L14;
                case 89: goto L13;
                case 90: goto L12;
                case 91: goto L11;
                default: goto L9;
            };
        L9:
            StringBuilder r17 = new StringBuilder();
            String r18 = "Unknown attribute 0x";
        L10:
            r17.append(r18);
            r17.append(Integer.toHexString(r15));
            r17.append("   ");
            r17.append(mapToConstant.get(r15));
            Log.w(ConstraintSet.TAG, r17.toString());
            goto L83
        L11:
            r17 = new StringBuilder();
            r18 = "unused attribute 0x";
            goto L10
        L12:
            this.guidelineUseRtl = r12.getBoolean(r15, this.guidelineUseRtl);
            goto L83
        L13:
            this.mConstraintTag = r12.getString(r15);
            goto L83
        L14:
            this.constrainedHeight = r12.getBoolean(r15, this.constrainedHeight);
            goto L83
        L15:
            this.constrainedWidth = r12.getBoolean(r15, this.constrainedWidth);
            goto L83
        L16:
            this.widthMin = r12.getDimensionPixelSize(r15, this.widthMin);
            goto L83
        L17:
            this.heightMin = r12.getDimensionPixelSize(r15, this.heightMin);
            goto L83
        L18:
            this.widthMax = r12.getDimensionPixelSize(r15, this.widthMax);
            goto L83
        L19:
            this.heightMax = r12.getDimensionPixelSize(r15, this.heightMax);
            goto L83
        L20:
            this.heightDefault = r12.getInt(r15, this.heightDefault);
            goto L83
        L21:
            this.widthDefault = r12.getInt(r15, this.widthDefault);
            goto L83
        L22:
            this.baselineMargin = r12.getDimensionPixelSize(r15, this.baselineMargin);
            goto L83
        L23:
            this.goneBaselineMargin = r12.getDimensionPixelSize(r15, this.goneBaselineMargin);
            goto L83
        L24:
            this.baselineToBottom = ConstraintSet.access$100(r12, r15, this.baselineToBottom);
            goto L83
        L25:
            this.baselineToTop = ConstraintSet.access$100(r12, r15, this.baselineToTop);
            goto L83
        L26:
            this.mWrapBehavior = r12.getInt(r15, this.mWrapBehavior);
            goto L83
        L27:
            this.mBarrierAllowsGoneWidgets = r12.getBoolean(r15, this.mBarrierAllowsGoneWidgets);
            goto L83
        L28:
            this.mReferenceIdString = r12.getString(r15);
            goto L83
        L29:
            this.mBarrierMargin = r12.getDimensionPixelSize(r15, this.mBarrierMargin);
            goto L83
        L30:
            this.mBarrierDirection = r12.getInt(r15, this.mBarrierDirection);
            goto L83
        L31:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L83
        L32:
            this.heightPercent = r12.getFloat(r15, 1.0f);
            goto L83
        L33:
            this.widthPercent = r12.getFloat(r15, 1.0f);
            goto L83
        L37:
            ConstraintSet.parseDimensionConstraints(this, r12, r15, 1);
            goto L83
        L38:
            ConstraintSet.parseDimensionConstraints(this, r12, r15, 0);
            goto L83
        L39:
            this.verticalChainStyle = r12.getInt(r15, this.verticalChainStyle);
            goto L83
        L40:
            this.horizontalChainStyle = r12.getInt(r15, this.horizontalChainStyle);
            goto L83
        L41:
            this.verticalWeight = r12.getFloat(r15, this.verticalWeight);
            goto L83
        L42:
            this.horizontalWeight = r12.getFloat(r15, this.horizontalWeight);
            goto L83
        L43:
            this.verticalBias = r12.getFloat(r15, this.verticalBias);
            goto L83
        L44:
            this.topToTop = ConstraintSet.access$100(r12, r15, this.topToTop);
            goto L83
        L45:
            this.topToBottom = ConstraintSet.access$100(r12, r15, this.topToBottom);
            goto L83
        L46:
            this.topMargin = r12.getDimensionPixelSize(r15, this.topMargin);
            goto L83
        L47:
            this.startToStart = ConstraintSet.access$100(r12, r15, this.startToStart);
            goto L83
        L48:
            this.startToEnd = ConstraintSet.access$100(r12, r15, this.startToEnd);
            goto L83
        L52:
            this.rightToRight = ConstraintSet.access$100(r12, r15, this.rightToRight);
            goto L83
        L53:
            this.rightToLeft = ConstraintSet.access$100(r12, r15, this.rightToLeft);
            goto L83
        L54:
            this.rightMargin = r12.getDimensionPixelSize(r15, this.rightMargin);
            goto L83
        L55:
            this.orientation = r12.getInt(r15, this.orientation);
            goto L83
        L56:
            this.leftToRight = ConstraintSet.access$100(r12, r15, this.leftToRight);
            goto L83
        L57:
            this.leftToLeft = ConstraintSet.access$100(r12, r15, this.leftToLeft);
            goto L83
        L58:
            this.leftMargin = r12.getDimensionPixelSize(r15, this.leftMargin);
            goto L83
        L59:
            this.mWidth = r12.getLayoutDimension(r15, this.mWidth);
            goto L83
        L60:
            this.mHeight = r12.getLayoutDimension(r15, this.mHeight);
            goto L83
        L61:
            this.horizontalBias = r12.getFloat(r15, this.horizontalBias);
            goto L83
        L62:
            this.guidePercent = r12.getFloat(r15, this.guidePercent);
            goto L83
        L63:
            this.guideEnd = r12.getDimensionPixelOffset(r15, this.guideEnd);
            goto L83
        L64:
            this.guideBegin = r12.getDimensionPixelOffset(r15, this.guideBegin);
            goto L83
        L65:
            this.goneTopMargin = r12.getDimensionPixelSize(r15, this.goneTopMargin);
            goto L83
        L66:
            this.goneStartMargin = r12.getDimensionPixelSize(r15, this.goneStartMargin);
            goto L83
        L67:
            this.goneRightMargin = r12.getDimensionPixelSize(r15, this.goneRightMargin);
            goto L83
        L68:
            this.goneLeftMargin = r12.getDimensionPixelSize(r15, this.goneLeftMargin);
            goto L83
        L69:
            this.goneEndMargin = r12.getDimensionPixelSize(r15, this.goneEndMargin);
            goto L83
        L70:
            this.goneBottomMargin = r12.getDimensionPixelSize(r15, this.goneBottomMargin);
            goto L83
        L71:
            this.endToStart = ConstraintSet.access$100(r12, r15, this.endToStart);
            goto L83
        L72:
            this.endToEnd = ConstraintSet.access$100(r12, r15, this.endToEnd);
            goto L83
        L76:
            this.editorAbsoluteY = r12.getDimensionPixelOffset(r15, this.editorAbsoluteY);
            goto L83
        L77:
            this.editorAbsoluteX = r12.getDimensionPixelOffset(r15, this.editorAbsoluteX);
            goto L83
        L78:
            this.dimensionRatio = r12.getString(r15);
            goto L83
        L79:
            this.bottomToTop = ConstraintSet.access$100(r12, r15, this.bottomToTop);
            goto L83
        L80:
            this.bottomToBottom = ConstraintSet.access$100(r12, r15, this.bottomToBottom);
            goto L83
        L81:
            this.bottomMargin = r12.getDimensionPixelSize(r15, this.bottomMargin);
            goto L83
        L82:
            this.baselineToBaseline = ConstraintSet.access$100(r12, r15, this.baselineToBaseline);
            goto L83
        L50:
            if (Build.VERSION.SDK_INT < 17) goto L83;
            this.startMargin = r12.getDimensionPixelSize(r15, this.startMargin);
            goto L83
        L74:
            if (Build.VERSION.SDK_INT < 17) goto L83;
            this.endMargin = r12.getDimensionPixelSize(r15, this.endMargin);
            goto L83
        L84:
            r12.recycle();
        }
    }

    public static class Motion {
        private static final int ANIMATE_CIRCLE_ANGLE_TO = 6;
        private static final int ANIMATE_RELATIVE_TO = 5;
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int MOTION_DRAW_PATH = 4;
        private static final int MOTION_STAGGER = 7;
        private static final int PATH_MOTION_ARC = 2;
        private static final int QUANTIZE_MOTION_INTERPOLATOR = 10;
        private static final int QUANTIZE_MOTION_PHASE = 9;
        private static final int QUANTIZE_MOTION_STEPS = 8;
        private static final int SPLINE_STRING = -1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 1;
        private static SparseIntArray mapToConstant;
        public int mAnimateCircleAngleTo;
        public int mAnimateRelativeTo;
        public boolean mApply;
        public int mDrawPath;
        public float mMotionStagger;
        public int mPathMotionArc;
        public float mPathRotate;
        public int mPolarRelativeTo;
        public int mQuantizeInterpolatorID;
        public String mQuantizeInterpolatorString;
        public int mQuantizeInterpolatorType;
        public float mQuantizeMotionPhase;
        public int mQuantizeMotionSteps;
        public String mTransitionEasing;

        static {
            SparseIntArray r10 = new SparseIntArray();
            mapToConstant = r10;
            r10.append(R.styleable.Motion_motionPathRotate, 1);
            mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
            mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
            mapToConstant.append(R.styleable.Motion_drawPath, 4);
            mapToConstant.append(R.styleable.Motion_animateRelativeTo, 5);
            mapToConstant.append(R.styleable.Motion_animateCircleAngleTo, 6);
            mapToConstant.append(R.styleable.Motion_motionStagger, 7);
            mapToConstant.append(R.styleable.Motion_quantizeMotionSteps, 8);
            mapToConstant.append(R.styleable.Motion_quantizeMotionPhase, 9);
            mapToConstant.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public Motion() {
            this.mApply = false;
            this.mAnimateRelativeTo = -1;
            this.mAnimateCircleAngleTo = 0;
            this.mTransitionEasing = null;
            this.mPathMotionArc = -1;
            this.mDrawPath = 0;
            this.mMotionStagger = Float.NaN;
            this.mPolarRelativeTo = -1;
            this.mPathRotate = Float.NaN;
            this.mQuantizeMotionPhase = Float.NaN;
            this.mQuantizeMotionSteps = -1;
            this.mQuantizeInterpolatorString = null;
            this.mQuantizeInterpolatorType = -3;
            this.mQuantizeInterpolatorID = -1;
        }

        public void copyFrom(Motion r10) {
            this.mApply = r10.mApply;
            this.mAnimateRelativeTo = r10.mAnimateRelativeTo;
            this.mTransitionEasing = r10.mTransitionEasing;
            this.mPathMotionArc = r10.mPathMotionArc;
            this.mDrawPath = r10.mDrawPath;
            this.mPathRotate = r10.mPathRotate;
            this.mMotionStagger = r10.mMotionStagger;
            this.mPolarRelativeTo = r10.mPolarRelativeTo;
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Motion);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L32;
            int r15 = r12.getIndex(r14);
            switch(mapToConstant.get(r15)) {
                case 1: goto L30;
                case 2: goto L29;
                case 3: goto L25;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L7;
                default: goto L31;
            };
        L7:
            int r16 = r12.peekValue(r15).type;
            if (r16 != 1) goto L12;
            int r17 = r12.getResourceId(r15, -1);
            this.mQuantizeInterpolatorID = r17;
            if (r17 == (-1)) goto L31;
        L11:
            this.mQuantizeInterpolatorType = -2;
            goto L31
        L12:
            if (r16 != 3) goto L17;
            String r18 = r12.getString(r15);
            this.mQuantizeInterpolatorString = r18;
            if (r18.indexOf("/") <= 0) goto L16;
            this.mQuantizeInterpolatorID = r12.getResourceId(r15, -1);
            goto L11
        L16:
            this.mQuantizeInterpolatorType = -1;
            goto L31
        L17:
            this.mQuantizeInterpolatorType = r12.getInteger(r15, this.mQuantizeInterpolatorID);
            goto L31
        L18:
            this.mQuantizeMotionPhase = r12.getFloat(r15, this.mQuantizeMotionPhase);
            goto L31
        L19:
            this.mQuantizeMotionSteps = r12.getInteger(r15, this.mQuantizeMotionSteps);
            goto L31
        L20:
            this.mMotionStagger = r12.getFloat(r15, this.mMotionStagger);
            goto L31
        L21:
            this.mAnimateCircleAngleTo = r12.getInteger(r15, this.mAnimateCircleAngleTo);
            goto L31
        L22:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r12, r15, this.mAnimateRelativeTo);
            goto L31
        L23:
            this.mDrawPath = r12.getInt(r15, 0);
            goto L31
        L29:
            this.mPathMotionArc = r12.getInt(r15, this.mPathMotionArc);
            goto L31
        L30:
            this.mPathRotate = r12.getFloat(r15, this.mPathRotate);
            goto L31
        L25:
            if (r12.peekValue(r15).type != 3) goto L27;
            String r19 = r12.getString(r15);
        L28:
            this.mTransitionEasing = r19;
            goto L31
        L27:
            r19 = Easing.NAMED_EASING[r12.getInteger(r15, 0)];
        L31:
            r14 = r14 + 1;
            goto L3
        L32:
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

        public void copyFrom(PropertySet r10) {
            this.mApply = r10.mApply;
            this.visibility = r10.visibility;
            this.alpha = r10.alpha;
            this.mProgress = r10.mProgress;
            this.mVisibilityMode = r10.mVisibilityMode;
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.PropertySet);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L17;
            int r15 = r12.getIndex(r14);
            if (r15 != R.styleable.PropertySet_android_alpha) goto L8;
            this.alpha = r12.getFloat(r15, this.alpha);
        L16:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R.styleable.PropertySet_android_visibility) goto L11;
            this.visibility = r12.getInt(r15, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L16
        L11:
            if (r15 != R.styleable.PropertySet_visibilityMode) goto L14;
            this.mVisibilityMode = r12.getInt(r15, this.mVisibilityMode);
            goto L16
        L14:
            if (r15 != R.styleable.PropertySet_motionProgress) goto L16;
            this.mProgress = r12.getFloat(r15, this.mProgress);
            goto L16
        L17:
            r12.recycle();
        }
    }

    public static class Transform {
        private static final int ELEVATION = 11;
        private static final int ROTATION = 1;
        private static final int ROTATION_X = 2;
        private static final int ROTATION_Y = 3;
        private static final int SCALE_X = 4;
        private static final int SCALE_Y = 5;
        private static final int TRANSFORM_PIVOT_TARGET = 12;
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
        public int transformPivotTarget;
        public float transformPivotX;
        public float transformPivotY;
        public float translationX;
        public float translationY;
        public float translationZ;

        static {
            SparseIntArray r10 = new SparseIntArray();
            mapToConstant = r10;
            r10.append(R.styleable.Transform_android_rotation, 1);
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
            mapToConstant.append(R.styleable.Transform_transformPivotTarget, 12);
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
            this.transformPivotTarget = -1;
            this.translationX = 0.0f;
            this.translationY = 0.0f;
            this.translationZ = 0.0f;
            this.applyElevation = false;
            this.elevation = 0.0f;
        }

        public void copyFrom(Transform r10) {
            this.mApply = r10.mApply;
            this.rotation = r10.rotation;
            this.rotationX = r10.rotationX;
            this.rotationY = r10.rotationY;
            this.scaleX = r10.scaleX;
            this.scaleY = r10.scaleY;
            this.transformPivotX = r10.transformPivotX;
            this.transformPivotY = r10.transformPivotY;
            this.transformPivotTarget = r10.transformPivotTarget;
            this.translationX = r10.translationX;
            this.translationY = r10.translationY;
            this.translationZ = r10.translationZ;
            this.applyElevation = r10.applyElevation;
            this.elevation = r10.elevation;
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.Transform);
            this.mApply = true;
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L24;
            int r15 = r12.getIndex(r14);
            switch(mapToConstant.get(r15)) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L12;
                case 11: goto L9;
                case 12: goto L7;
                default: goto L23;
            };
        L7:
            this.transformPivotTarget = ConstraintSet.access$100(r12, r15, this.transformPivotTarget);
            goto L23
        L14:
            this.translationY = r12.getDimension(r15, this.translationY);
            goto L23
        L15:
            this.translationX = r12.getDimension(r15, this.translationX);
            goto L23
        L16:
            this.transformPivotY = r12.getDimension(r15, this.transformPivotY);
            goto L23
        L17:
            this.transformPivotX = r12.getDimension(r15, this.transformPivotX);
            goto L23
        L18:
            this.scaleY = r12.getFloat(r15, this.scaleY);
            goto L23
        L19:
            this.scaleX = r12.getFloat(r15, this.scaleX);
            goto L23
        L20:
            this.rotationY = r12.getFloat(r15, this.rotationY);
            goto L23
        L21:
            this.rotationX = r12.getFloat(r15, this.rotationX);
            goto L23
        L22:
            this.rotation = r12.getFloat(r15, this.rotation);
            goto L23
        L9:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.applyElevation = true;
            this.elevation = r12.getDimension(r15, this.elevation);
            goto L23
        L12:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.translationZ = r12.getDimension(r15, this.translationZ);
        L23:
            r14 = r14 + 1;
            goto L3
        L24:
            r12.recycle();
        }
    }

    class WriteJsonEngine {
        private static final String SPACE = "       ";
        final String BASELINE;
        final String BOTTOM;
        final String END;
        final String LEFT;
        final String RIGHT;
        final String START;
        final String TOP;
        Context context;
        int flags;
        HashMap<Integer, String> idMap;
        ConstraintLayout layout;
        final /* synthetic */ ConstraintSet this$0;
        int unknownCount;
        Writer writer;

        WriteJsonEngine(ConstraintSet r10, Writer r11, ConstraintLayout r12, int r13) {
            this.this$0 = r10;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r11;
            this.layout = r12;
            this.context = r12.getContext();
            this.flags = r13;
        }

        private void writeDimension(String r10, int r11, int r12, float r13, int r14, int r15, boolean r16) {
            if (r11 == 0) goto L5;
            Writer r17 = this.writer;
            if (r11 != (-2)) goto L31;
            StringBuilder r18 = new StringBuilder();
            r18.append(SPACE);
            r18.append(r10);
            String r19 = ": 'wrap'\n";
        L29:
            r18.append(r19);
            String r20 = r18.toString();
        L30:
            r17.write(r20);
            return;
        L31:
            if (r11 != (-1)) goto L33;
            r18 = new StringBuilder();
            r18.append(SPACE);
            r18.append(r10);
            r19 = ": 'parent'\n";
            goto L29
        L33:
            r20 = SPACE + r10 + ": " + r11 + ",\n";
            goto L30
        L5:
            if (r15 != (-1)) goto L17;
            if (r14 != (-1)) goto L17;
            if (r12 == 1) goto L15;
            if (r12 != 2) goto L36;
            Writer r21 = this.writer;
            StringBuilder r22 = new StringBuilder();
            r22.append(SPACE);
            r22.append(r10);
            r22.append(": '");
            r22.append(r13);
            String r23 = "%',\n";
        L12:
            r22.append(r23);
        L13:
            r21.write(r22.toString());
            return;
        L36:
            return;
        L15:
            r21 = this.writer;
            r22 = new StringBuilder();
            r22.append(SPACE);
            r22.append(r10);
            r23 = ": '???????????',\n";
        L17:
            if (r12 == 0) goto L24;
            if (r12 == 1) goto L23;
            if (r12 != 2) goto L35;
            r21 = this.writer;
            r22 = new StringBuilder();
            r22.append(SPACE);
            r22.append(r10);
            r22.append(": {'");
            r22.append(r13);
            String r24 = "'% ,";
        L22:
            r22.append(r24);
            r22.append(r14);
            r22.append(", ");
            r22.append(r15);
            r22.append("}\n");
            goto L13
        L35:
            return;
        L23:
            r21 = this.writer;
            r22 = new StringBuilder();
            r22.append(SPACE);
            r22.append(r10);
            r24 = ": {'wrap' ,";
            goto L22
        L24:
            this.writer.write(SPACE + r10 + ": {'spread' ," + r14 + ", " + r15 + "}\n");
        }

        private void writeGuideline(int r10, int r11, int r12, float r13) {
        }

        String getName(int r10) {
            if (this.idMap.containsKey(Integer.valueOf(r10)) == true) goto L5;
            if (r10 != 0) goto L9;
            return "'parent'";
        L9:
            String r11 = lookup(r10);
            this.idMap.put(Integer.valueOf(r10), r11);
            return "'" + r11 + "'";
        L5:
            return "'" + this.idMap.get(Integer.valueOf(r10)) + "'";
        }

        String lookup(int r10) {
            if (r10 != (-1)) goto L5;
            StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L8
            r11.append("unknown");     // Catch: Exception -> L8
            int r12 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r12;     // Catch: Exception -> L8
            r11.append(r12);     // Catch: Exception -> L8
            return r11.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r10);
        L8:
            StringBuilder r13 = new StringBuilder();
            r13.append("unknown");
            int r14 = this.unknownCount + 1;
            this.unknownCount = r14;
            r13.append(r14);
            return r13.toString();
        }

        void writeCircle(int r10, float r11, int r12) {
            if (r10 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(r10));
            this.writer.write(", " + r11);
            this.writer.write(r12 + "]");
        }

        void writeConstraint(String r10, int r11, String r12, int r13, int r14) {
            if (r11 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write(":[");
            this.writer.write(getName(r11));
            this.writer.write(" , ");
            this.writer.write(r12);
            if (r13 == 0) goto L8;
            this.writer.write(" , " + r13);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n'ConstraintSet':{\n");
            Iterator r10 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Integer r11 = (Integer) r10.next();
            Constraint r12 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r11);
            String r13 = getName(r11.intValue());
            this.writer.write(r13 + ":{\n");
            Layout r14 = r12.layout;
            writeDimension("height", r14.mHeight, r14.heightDefault, r14.heightPercent, r14.heightMin, r14.heightMax, r14.constrainedHeight);
            writeDimension("width", r14.mWidth, r14.widthDefault, r14.widthPercent, r14.widthMin, r14.widthMax, r14.constrainedWidth);
            writeConstraint("'left'", r14.leftToLeft, "'left'", r14.leftMargin, r14.goneLeftMargin);
            writeConstraint("'left'", r14.leftToRight, "'right'", r14.leftMargin, r14.goneLeftMargin);
            writeConstraint("'right'", r14.rightToLeft, "'left'", r14.rightMargin, r14.goneRightMargin);
            writeConstraint("'right'", r14.rightToRight, "'right'", r14.rightMargin, r14.goneRightMargin);
            writeConstraint("'baseline'", r14.baselineToBaseline, "'baseline'", -1, r14.goneBaselineMargin);
            writeConstraint("'baseline'", r14.baselineToTop, "'top'", -1, r14.goneBaselineMargin);
            writeConstraint("'baseline'", r14.baselineToBottom, "'bottom'", -1, r14.goneBaselineMargin);
            writeConstraint("'top'", r14.topToBottom, "'bottom'", r14.topMargin, r14.goneTopMargin);
            writeConstraint("'top'", r14.topToTop, "'top'", r14.topMargin, r14.goneTopMargin);
            writeConstraint("'bottom'", r14.bottomToBottom, "'bottom'", r14.bottomMargin, r14.goneBottomMargin);
            writeConstraint("'bottom'", r14.bottomToTop, "'top'", r14.bottomMargin, r14.goneBottomMargin);
            writeConstraint("'start'", r14.startToStart, "'start'", r14.startMargin, r14.goneStartMargin);
            writeConstraint("'start'", r14.startToEnd, "'end'", r14.startMargin, r14.goneStartMargin);
            writeConstraint("'end'", r14.endToStart, "'start'", r14.endMargin, r14.goneEndMargin);
            writeConstraint("'end'", r14.endToEnd, "'end'", r14.endMargin, r14.goneEndMargin);
            writeVariable("'horizontalBias'", r14.horizontalBias, 0.5f);
            writeVariable("'verticalBias'", r14.verticalBias, 0.5f);
            writeCircle(r14.circleConstraint, r14.circleAngle, r14.circleRadius);
            writeGuideline(r14.orientation, r14.guideBegin, r14.guideEnd, r14.guidePercent);
            writeVariable("'dimensionRatio'", r14.dimensionRatio);
            writeVariable("'barrierMargin'", r14.mBarrierMargin);
            writeVariable("'type'", r14.mHelperType);
            writeVariable("'ReferenceId'", r14.mReferenceIdString);
            writeVariable("'mBarrierAllowsGoneWidgets'", r14.mBarrierAllowsGoneWidgets, true);
            writeVariable("'WrapBehavior'", r14.mWrapBehavior);
            writeVariable("'verticalWeight'", r14.verticalWeight);
            writeVariable("'horizontalWeight'", r14.horizontalWeight);
            writeVariable("'horizontalChainStyle'", r14.horizontalChainStyle);
            writeVariable("'verticalChainStyle'", r14.verticalChainStyle);
            writeVariable("'barrierDirection'", r14.mBarrierDirection);
            int[] r15 = r14.mReferenceIds;
            if (r15 == null) goto L8;
            writeVariable("'ReferenceIds'", r15);
        L8:
            this.writer.write("}\n");
            goto L4
        L9:
            this.writer.write("}\n");
        }

        void writeVariable(String r10, float r11) {
            if (r11 != (-1.0f)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write(": " + r11);
            this.writer.write(",\n");
        }

        void writeVariable(String r10, float r11, float r12) {
            if (r11 != r12) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write(": " + r11);
            this.writer.write(",\n");
        }

        void writeVariable(String r10, int r11) {
            if (r11 != 0) goto L4;
            return;
        L4:
            if (r11 == (-1)) goto L9;
            this.writer.write(SPACE + r10);
            this.writer.write(":");
            this.writer.write(", " + r11);
            this.writer.write("\n");
            return;
        }

        void writeVariable(String r10, String r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r10);
            this.writer.write(":");
            this.writer.write(", " + r11);
            this.writer.write("\n");
        }

        void writeVariable(String r10, boolean r11) {
            if (r11 == true) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r10);
            this.writer.write(": " + r11);
            this.writer.write(",\n");
        }

        void writeVariable(String r10, boolean r11, boolean r12) {
            if (r11 != r12) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r10);
            this.writer.write(": " + r11);
            this.writer.write(",\n");
        }

        void writeVariable(String r10, int[] r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r10);
            this.writer.write(": ");
            int r12 = 0;
        L6:
            if (r12 >= r11.length) goto L12;
            Writer r13 = this.writer;
            StringBuilder r14 = new StringBuilder();
            if (r12 != 0) goto L10;
            String r15 = "[";
        L11:
            r14.append(r15);
            r14.append(getName(r11[r12]));
            r13.write(r14.toString());
            r12 = r12 + 1;
            goto L6
        L10:
            r15 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }
    }

    class WriteXmlEngine {
        private static final String SPACE = "\n       ";
        final String BASELINE;
        final String BOTTOM;
        final String END;
        final String LEFT;
        final String RIGHT;
        final String START;
        final String TOP;
        Context context;
        int flags;
        HashMap<Integer, String> idMap;
        ConstraintLayout layout;
        final /* synthetic */ ConstraintSet this$0;
        int unknownCount;
        Writer writer;

        WriteXmlEngine(ConstraintSet r10, Writer r11, ConstraintLayout r12, int r13) {
            this.this$0 = r10;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r11;
            this.layout = r12;
            this.context = r12.getContext();
            this.flags = r13;
        }

        private void writeBaseDimension(String r10, int r11, int r12) {
            if (r11 != r12) goto L4;
            return;
        L4:
            if (r11 != (-2)) goto L8;
            Writer r13 = this.writer;
            StringBuilder r14 = new StringBuilder();
            r14.append(SPACE);
            r14.append(r10);
            String r15 = "=\"wrap_content\"";
        L6:
            r14.append(r15);
            String r16 = r14.toString();
        L7:
            r13.write(r16);
            return;
        L8:
            r13 = this.writer;
            if (r11 != (-1)) goto L11;
            r14 = new StringBuilder();
            r14.append(SPACE);
            r14.append(r10);
            r15 = "=\"match_parent\"";
            goto L6
        L11:
            r16 = SPACE + r10 + "=\"" + r11 + "dp\"";
            goto L7
        }

        private void writeBoolen(String r10, boolean r11, boolean r12) {
            if (r11 == r12) goto L5;
            this.writer.write(SPACE + r10 + "=\"" + r11 + "dp\"");
            return;
        }

        private void writeDimension(String r10, int r11, int r12) {
            if (r11 == r12) goto L5;
            this.writer.write(SPACE + r10 + "=\"" + r11 + "dp\"");
            return;
        }

        private void writeEnum(String r10, int r11, String[] r12, int r13) {
            if (r11 == r13) goto L5;
            this.writer.write(SPACE + r10 + "=\"" + r12[r11] + "\"");
            return;
        }

        String getName(int r10) {
            if (this.idMap.containsKey(Integer.valueOf(r10)) == true) goto L5;
            if (r10 != 0) goto L9;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L9:
            String r11 = lookup(r10);
            this.idMap.put(Integer.valueOf(r10), r11);
            return "@+id/" + r11 + "";
        L5:
            return "@+id/" + this.idMap.get(Integer.valueOf(r10)) + "";
        }

        String lookup(int r10) {
            if (r10 != (-1)) goto L5;
            StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L8
            r11.append("unknown");     // Catch: Exception -> L8
            int r12 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r12;     // Catch: Exception -> L8
            r11.append(r12);     // Catch: Exception -> L8
            return r11.toString();
        L5:
            return this.context.getResources().getResourceEntryName(r10);
        L8:
            StringBuilder r13 = new StringBuilder();
            r13.append("unknown");
            int r14 = this.unknownCount + 1;
            this.unknownCount = r14;
            r13.append(r14);
            return r13.toString();
        }

        void writeCircle(int r10, float r11, int r12) {
            if (r10 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(r10));
            this.writer.write(", " + r11);
            this.writer.write(r12 + "]");
        }

        void writeConstraint(String r10, int r11, String r12, int r13, int r14) {
            if (r11 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write(":[");
            this.writer.write(getName(r11));
            this.writer.write(" , ");
            this.writer.write(r12);
            if (r13 == 0) goto L8;
            this.writer.write(" , " + r13);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n<ConstraintSet>\n");
            Iterator r10 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Integer r11 = (Integer) r10.next();
            Constraint r12 = (Constraint) ConstraintSet.access$1300(this.this$0).get(r11);
            String r13 = getName(r11.intValue());
            this.writer.write("  <Constraint");
            this.writer.write("\n       android:id=\"" + r13 + "\"");
            Layout r14 = r12.layout;
            writeBaseDimension("android:layout_width", r14.mWidth, -5);
            writeBaseDimension("android:layout_height", r14.mHeight, -5);
            writeVariable("app:layout_constraintGuide_begin", (float) r14.guideBegin, -1.0f);
            writeVariable("app:layout_constraintGuide_end", r14.guideEnd, -1.0f);
            writeVariable("app:layout_constraintGuide_percent", r14.guidePercent, -1.0f);
            writeVariable("app:layout_constraintHorizontal_bias", r14.horizontalBias, 0.5f);
            writeVariable("app:layout_constraintVertical_bias", r14.verticalBias, 0.5f);
            writeVariable("app:layout_constraintDimensionRatio", r14.dimensionRatio, null);
            writeXmlConstraint("app:layout_constraintCircle", r14.circleConstraint);
            writeVariable("app:layout_constraintCircleRadius", r14.circleRadius, 0.0f);
            writeVariable("app:layout_constraintCircleAngle", r14.circleAngle, 0.0f);
            writeVariable("android:orientation", r14.orientation, -1.0f);
            writeVariable("app:layout_constraintVertical_weight", r14.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r14.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r14.horizontalChainStyle, 0.0f);
            writeVariable("app:layout_constraintVertical_chainStyle", r14.verticalChainStyle, 0.0f);
            writeVariable("app:barrierDirection", r14.mBarrierDirection, -1.0f);
            writeVariable("app:barrierMargin", r14.mBarrierMargin, 0.0f);
            writeDimension("app:layout_marginLeft", r14.leftMargin, 0);
            writeDimension("app:layout_goneMarginLeft", r14.goneLeftMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginRight", r14.rightMargin, 0);
            writeDimension("app:layout_goneMarginRight", r14.goneRightMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginStart", r14.startMargin, 0);
            writeDimension("app:layout_goneMarginStart", r14.goneStartMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginEnd", r14.endMargin, 0);
            writeDimension("app:layout_goneMarginEnd", r14.goneEndMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginTop", r14.topMargin, 0);
            writeDimension("app:layout_goneMarginTop", r14.goneTopMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginBottom", r14.bottomMargin, 0);
            writeDimension("app:layout_goneMarginBottom", r14.goneBottomMargin, Integer.MIN_VALUE);
            writeDimension("app:goneBaselineMargin", r14.goneBaselineMargin, Integer.MIN_VALUE);
            writeDimension("app:baselineMargin", r14.baselineMargin, 0);
            writeBoolen("app:layout_constrainedWidth", r14.constrainedWidth, false);
            writeBoolen("app:layout_constrainedHeight", r14.constrainedHeight, false);
            writeBoolen("app:barrierAllowsGoneWidgets", r14.mBarrierAllowsGoneWidgets, true);
            writeVariable("app:layout_wrapBehaviorInParent", r14.mWrapBehavior, 0.0f);
            writeXmlConstraint("app:baselineToBaseline", r14.baselineToBaseline);
            writeXmlConstraint("app:baselineToBottom", r14.baselineToBottom);
            writeXmlConstraint("app:baselineToTop", r14.baselineToTop);
            writeXmlConstraint("app:layout_constraintBottom_toBottomOf", r14.bottomToBottom);
            writeXmlConstraint("app:layout_constraintBottom_toTopOf", r14.bottomToTop);
            writeXmlConstraint("app:layout_constraintEnd_toEndOf", r14.endToEnd);
            writeXmlConstraint("app:layout_constraintEnd_toStartOf", r14.endToStart);
            writeXmlConstraint("app:layout_constraintLeft_toLeftOf", r14.leftToLeft);
            writeXmlConstraint("app:layout_constraintLeft_toRightOf", r14.leftToRight);
            writeXmlConstraint("app:layout_constraintRight_toLeftOf", r14.rightToLeft);
            writeXmlConstraint("app:layout_constraintRight_toRightOf", r14.rightToRight);
            writeXmlConstraint("app:layout_constraintStart_toEndOf", r14.startToEnd);
            writeXmlConstraint("app:layout_constraintStart_toStartOf", r14.startToStart);
            writeXmlConstraint("app:layout_constraintTop_toBottomOf", r14.topToBottom);
            writeXmlConstraint("app:layout_constraintTop_toTopOf", r14.topToTop);
            String[] r15 = {"spread", "wrap", "percent"};
            writeEnum("app:layout_constraintHeight_default", r14.heightDefault, r15, 0);
            writeVariable("app:layout_constraintHeight_percent", r14.heightPercent, 1.0f);
            writeDimension("app:layout_constraintHeight_min", r14.heightMin, 0);
            writeDimension("app:layout_constraintHeight_max", r14.heightMax, 0);
            writeBoolen("android:layout_constrainedHeight", r14.constrainedHeight, false);
            writeEnum("app:layout_constraintWidth_default", r14.widthDefault, r15, 0);
            writeVariable("app:layout_constraintWidth_percent", r14.widthPercent, 1.0f);
            writeDimension("app:layout_constraintWidth_min", r14.widthMin, 0);
            writeDimension("app:layout_constraintWidth_max", r14.widthMax, 0);
            writeBoolen("android:layout_constrainedWidth", r14.constrainedWidth, false);
            writeVariable("app:layout_constraintVertical_weight", r14.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r14.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r14.horizontalChainStyle);
            writeVariable("app:layout_constraintVertical_chainStyle", r14.verticalChainStyle);
            writeEnum("app:barrierDirection", r14.mBarrierDirection, new String[]{"left", "right", "top", "bottom", CommonConsts.APM_INNER_EVENT_COST_START, "end"}, -1);
            writeVariable("app:layout_constraintTag", r14.mConstraintTag, null);
            int[] r16 = r14.mReferenceIds;
            if (r16 == null) goto L8;
            writeVariable("'ReferenceIds'", r16);
        L8:
            this.writer.write(" />\n");
            goto L4
        L9:
            this.writer.write("</ConstraintSet>\n");
        }

        void writeVariable(String r10, float r11, float r12) {
            if (r11 != r12) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write("=\"" + r11 + "\"");
        }

        void writeVariable(String r10, int r11) {
            if (r11 != 0) goto L4;
            return;
        L4:
            if (r11 == (-1)) goto L9;
            this.writer.write(SPACE + r10 + "=\"" + r11 + "\"\n");
            return;
        }

        void writeVariable(String r10, String r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            this.writer.write(r10);
            this.writer.write(":");
            this.writer.write(", " + r11);
            this.writer.write("\n");
        }

        void writeVariable(String r10, String r11, String r12) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (r11.equals(r12) == true) goto L9;
            this.writer.write(SPACE + r10);
            this.writer.write("=\"" + r11 + "\"");
            return;
        }

        void writeVariable(String r10, int[] r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r10);
            this.writer.write(":");
            int r12 = 0;
        L6:
            if (r12 >= r11.length) goto L12;
            Writer r13 = this.writer;
            StringBuilder r14 = new StringBuilder();
            if (r12 != 0) goto L10;
            String r15 = "[";
        L11:
            r14.append(r15);
            r14.append(getName(r11[r12]));
            r13.write(r14.toString());
            r12 = r12 + 1;
            goto L6
        L10:
            r15 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }

        void writeXmlConstraint(String r10, int r11) {
            if (r11 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r10);
            this.writer.write("=\"" + getName(r11) + "\"");
        }
    }

    static {
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        mapToConstant = new SparseIntArray();
        overrideMapToConstant = new SparseIntArray();
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_guidelineUseRtl, 99);
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
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth, 95);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight, 96);
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
        mapToConstant.append(R.styleable.Constraint_animateRelativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
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
        mapToConstant.append(R.styleable.Constraint_polarRelativeTo, 82);
        mapToConstant.append(R.styleable.Constraint_transformPivotTarget, 83);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        mapToConstant.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray r10 = overrideMapToConstant;
        int r11 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        r10.append(r11, 6);
        overrideMapToConstant.append(r11, 7);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_orientation, 27);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_visibility, 22);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_alpha, 43);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_elevation, 44);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_rotation, 60);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationX, 51);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationY, 52);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_drawPath, 66);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionStagger, 79);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_android_id, 38);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionTarget, 98);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_motionProgress, 68);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        overrideMapToConstant.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public ConstraintSet() {
        this.derivedState = "";
        this.mRotate = 0;
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    static /* synthetic */ int access$100(TypedArray r10, int r11, int r12) {
        return lookupID(r10, r11, r12);
    }

    static /* synthetic */ HashMap access$1300(ConstraintSet r10) {
        return r10.mConstraints;
    }

    static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    static /* synthetic */ void access$300(Constraint r10, int r11, int r12) {
        setDeltaValue(r10, r11, r12);
    }

    static /* synthetic */ void access$400(Constraint r10, int r11, float r12) {
        setDeltaValue(r10, r11, r12);
    }

    static /* synthetic */ void access$500(Constraint r10, int r11, String r12) {
        setDeltaValue(r10, r11, r12);
    }

    static /* synthetic */ void access$600(Constraint r10, int r11, boolean r12) {
        setDeltaValue(r10, r11, r12);
    }

    private void addAttributes(ConstraintAttribute.AttributeType r10, String... r11) {
        int r12 = 0;
    L4:
        if (r12 >= r11.length) goto L17;
        if (this.mSavedAttributes.containsKey(r11[r12]) == false) goto L15;
        ConstraintAttribute r13 = this.mSavedAttributes.get(r11[r12]);
        if (r13 == null) goto L16;
        if (r13.getType() == r10) goto L16;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r13.getType().name());
    L16:
        r12 = r12 + 1;
        goto L4
    L15:
        this.mSavedAttributes.put(r11[r12], new ConstraintAttribute(r11[r12], r10));
        goto L16
    }

    public static Constraint buildDelta(Context r10, XmlPullParser r11) {
        AttributeSet r12 = Xml.asAttributeSet(r11);
        Constraint r13 = new Constraint();
        TypedArray r14 = r10.obtainStyledAttributes(r12, R.styleable.ConstraintOverride);
        populateOverride(r10, r13, r14);
        r14.recycle();
        return r13;
    }

    private int[] convertReferenceString(View r10, String r11) {
        String[] r12 = r11.split(",");
        Context r13 = r10.getContext();
        int[] r14 = new int[r12.length];
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r12.length) goto L23;
        String r17 = r12[r15].trim();
        int r18 = R.id.class.getField(r17).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r18 != 0) goto L11;
        r18 = r13.getResources().getIdentifier(r17, OaidModel.KEY_ID, r13.getPackageName());
    L11:
        if (r18 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if ((r10.getParent() instanceof ConstraintLayout) == false) goto L21;
        Object r19 = ((ConstraintLayout) r10.getParent()).getDesignInformation(0, r17);
        if (r19 == null) goto L21;
        if ((r19 instanceof Integer) == false) goto L21;
        r18 = ((Integer) r19).intValue();
    L21:
        r14[r16] = r18;
        r15 = r15 + 1;
        r16 = r16 + 1;
    L8:
        r18 = 0;
        goto L9
    L23:
        if (r16 != r12.length) goto L25;
        return r14;
    L25:
        return Arrays.copyOf(r14, r16);
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
        int r11 = r17[r10];
        int r12 = r10 - 1;
        connect(r17[r10], r20, r17[r12], r21, -1);
        connect(r17[r12], r21, r17[r10], r20, -1);
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

    private Constraint fillFromAttributeList(Context r10, AttributeSet r11, boolean r12) {
        Constraint r13 = new Constraint();
        if (r12 == false) goto L5;
        int[] r14 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r15 = r10.obtainStyledAttributes(r11, r14);
        populateConstraint(r10, r13, r15, r12);
        r15.recycle();
        return r13;
    L5:
        r14 = R.styleable.Constraint;
        goto L6
    }

    private Constraint get(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L6:
        return this.mConstraints.get(Integer.valueOf(r10));
    }

    static String getDebugName(int r10) {
        Field[] r11 = ConstraintSet.class.getDeclaredFields();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L20;
        Field r14 = r11[r13];
        if (r14.getName().contains("_") == false) goto L19;
        if (r14.getType() != Integer.TYPE) goto L19;
        if (Modifier.isStatic(r14.getModifiers()) == false) goto L19;
        if (Modifier.isFinal(r14.getModifiers()) == false) goto L19;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L14:
        if (r14.getInt(null) != r10) goto L19;
        return r14.getName();
    L19:
        r13 = r13 + 1;
        goto L3
    L20:
        return "UNKNOWN";
    }

    static String getLine(Context r10, int r11, XmlPullParser r12) {
        return ".(" + Debug.getName(r10, r11) + ".xml:" + r12.getLineNumber() + ") \"" + r12.getName() + "\"";
    }

    private static int lookupID(TypedArray r10, int r11, int r12) {
        int r13 = r10.getResourceId(r11, r12);
        if (r13 == (-1)) goto L5;
        return r13;
    L5:
        return r10.getInt(r11, -1);
    }

    static void parseDimensionConstraints(Object r10, TypedArray r11, int r12, int r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r14 = r11.peekValue(r12).type;
        if (r14 == 3) goto L39;
        int r15 = -2;
        boolean r16 = false;
        if (r14 == 5) goto L18;
        int r17 = r11.getInt(r12, 0);
        if (r17 != (-4)) goto L11;
        r16 = true;
    L20:
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L26;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) r10;
        if (r13 != 0) goto L24;
        ((ViewGroup.MarginLayoutParams) r18).width = r15;
        r18.constrainedWidth = r16;
        return;
    L24:
        ((ViewGroup.MarginLayoutParams) r18).height = r15;
        r18.constrainedHeight = r16;
        return;
    L26:
        if ((r10 instanceof Layout) == false) goto L32;
        Layout r19 = (Layout) r10;
        if (r13 != 0) goto L30;
        r19.mWidth = r15;
        r19.constrainedWidth = r16;
        return;
    L30:
        r19.mHeight = r15;
        r19.constrainedHeight = r16;
        return;
    L32:
        if ((r10 instanceof Constraint.Delta) == false) goto L45;
        Constraint.Delta r20 = (Constraint.Delta) r10;
        if (r13 != 0) goto L36;
        r20.add(23, r15);
        int r21 = 80;
    L37:
        r20.add(r21, r16);
        return;
    L36:
        r20.add(21, r15);
        r21 = 81;
        goto L37
    L45:
        return;
    L11:
        if (r17 == (-3)) goto L15;
        if (r17 != (-2)) goto L14;
    L16:
        r15 = r17;
        goto L20
    L14:
        if (r17 == (-1)) goto L16;
    L15:
        r15 = 0;
        goto L20
    L18:
        r15 = r11.getDimensionPixelSize(r12, 0);
        goto L20
    L39:
        parseDimensionConstraintsString(r10, r11.getString(r12), r13);
    }

    static void parseDimensionConstraintsString(Object r10, String r11, int r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        int r13 = r11.indexOf(61);
        int r14 = r11.length();
        if (r13 > 0) goto L7;
        return;
    L7:
        if (r13 >= (r14 - 1)) goto L73;
        String r15 = r11.substring(0, r13);
        String r16 = r11.substring(r13 + 1);
        if (r16.length() <= 0) goto L74;
        String r17 = r15.trim();
        String r18 = r16.trim();
        if (KEY_RATIO.equalsIgnoreCase(r17) == false) goto L72;
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L20;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r10;
        if (r12 != 0) goto L17;
        ((ViewGroup.MarginLayoutParams) r19).width = 0;
    L18:
        parseDimensionRatioString(r19, r18);
        return;
    L17:
        ((ViewGroup.MarginLayoutParams) r19).height = 0;
        goto L18
    L20:
        if ((r10 instanceof Layout) == false) goto L23;
        ((Layout) r10).dimensionRatio = r18;
        return;
    L23:
        if ((r10 instanceof Constraint.Delta) == false) goto L77;
        ((Constraint.Delta) r10).add(5, r18);
        return;
    L77:
        return;
    L72:
        if (KEY_WEIGHT.equalsIgnoreCase(r17) == false) goto L48;
        float r20 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L71
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L34;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L32;
        ((ViewGroup.MarginLayoutParams) r21).width = 0;     // Catch: NumberFormatException -> L71
        r21.horizontalWeight = r20;     // Catch: NumberFormatException -> L71
        return;
    L32:
        ((ViewGroup.MarginLayoutParams) r21).height = 0;     // Catch: NumberFormatException -> L71
        r21.verticalWeight = r20;     // Catch: NumberFormatException -> L71
        return;
    L34:
        if ((r10 instanceof Layout) == false) goto L40;
        Layout r22 = (Layout) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L38;
        r22.mWidth = 0;     // Catch: NumberFormatException -> L71
        r22.horizontalWeight = r20;     // Catch: NumberFormatException -> L71
        return;
    L38:
        r22.mHeight = 0;     // Catch: NumberFormatException -> L71
        r22.verticalWeight = r20;     // Catch: NumberFormatException -> L71
        return;
    L40:
        if ((r10 instanceof Constraint.Delta) == false) goto L83;
        Constraint.Delta r23 = (Constraint.Delta) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L45;
        r23.add(23, 0);     // Catch: NumberFormatException -> L71
        int r24 = 39;
    L44:
        r23.add(r24, r20);     // Catch: NumberFormatException -> L71
        return;
    L45:
        r23.add(21, 0);     // Catch: NumberFormatException -> L71
        r24 = 40;
        goto L44
    L83:
        return;
    L48:
        if (KEY_PERCENT_PARENT.equalsIgnoreCase(r17) == true) goto L50;
        return;
    L50:
        float r25 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r18)));     // Catch: NumberFormatException -> L71
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L57;
        ConstraintLayout.LayoutParams r26 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L55;
        ((ViewGroup.MarginLayoutParams) r26).width = 0;     // Catch: NumberFormatException -> L71
        r26.matchConstraintPercentWidth = r25;     // Catch: NumberFormatException -> L71
        r26.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L71
        return;
    L55:
        ((ViewGroup.MarginLayoutParams) r26).height = 0;     // Catch: NumberFormatException -> L71
        r26.matchConstraintPercentHeight = r25;     // Catch: NumberFormatException -> L71
        r26.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L71
        return;
    L57:
        if ((r10 instanceof Layout) == false) goto L63;
        Layout r27 = (Layout) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L61;
        r27.mWidth = 0;     // Catch: NumberFormatException -> L71
        r27.widthPercent = r25;     // Catch: NumberFormatException -> L71
        r27.widthDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L61:
        r27.mHeight = 0;     // Catch: NumberFormatException -> L71
        r27.heightPercent = r25;     // Catch: NumberFormatException -> L71
        r27.heightDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L63:
        if ((r10 instanceof Constraint.Delta) == false) goto L90;
        Constraint.Delta r28 = (Constraint.Delta) r10;     // Catch: NumberFormatException -> L71
        if (r12 != 0) goto L68;
        r28.add(23, 0);     // Catch: NumberFormatException -> L71
        int r29 = 54;
    L67:
        r28.add(r29, 2);     // Catch: NumberFormatException -> L71
        return;
    L68:
        r28.add(21, 0);     // Catch: NumberFormatException -> L71
        r29 = 55;
        goto L67
    L90:
        return;
    L92:
        return;
    L74:
        return;
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams r10, String r11) {
        float r12 = Float.NaN;
        int r13 = -1;
        if (r11 == null) goto L34;
        int r14 = r11.length();
        int r15 = r11.indexOf(44);
        int r16 = 0;
        if (r15 > 0) goto L7;
    L15:
        int r17 = r11.indexOf(58);
        if (r17 >= 0) goto L18;
    L31:
        String r18 = r11.substring(r16);
        if (r18.length() <= 0) goto L34;
        r12 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r17 >= (r14 - 1)) goto L31;
        String r19 = r11.substring(r16, r17);
        String r20 = r11.substring(r17 + 1);
        if (r19.length() <= 0) goto L34;
        if (r20.length() <= 0) goto L34;
        float r21 = Float.parseFloat(r19);     // Catch: NumberFormatException -> L36
        float r22 = Float.parseFloat(r20);     // Catch: NumberFormatException -> L36
        if (r21 <= 0.0f) goto L37;
        if (r22 <= 0.0f) goto L37;
        if (r13 != 1) goto L29;
        r12 = Math.abs(r22 / r21);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r12 = Math.abs(r21 / r22);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r15 >= (r14 - 1)) goto L15;
        String r23 = r11.substring(0, r15);
        if (r23.equalsIgnoreCase("W") == false) goto L12;
        r13 = 0;
    L14:
        r16 = r15 + 1;
        goto L15
    L12:
        if (r23.equalsIgnoreCase("H") == false) goto L14;
        r13 = 1;
    L34:
        r10.dimensionRatio = r11;
        r10.dimensionRatioValue = r12;
        r10.dimensionRatioSide = r13;
    }

    private void populateConstraint(Context r10, Constraint r11, TypedArray r12, boolean r13) {
        if (r13 == false) goto L5;
        populateOverride(r10, r11, r12);
        return;
    L5:
        int r14 = r12.getIndexCount();
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L135;
        int r16 = r12.getIndex(r15);
        if (r16 == R.styleable.Constraint_android_id) goto L15;
        if (R.styleable.Constraint_android_layout_marginStart == r16) goto L15;
        if (R.styleable.Constraint_android_layout_marginEnd == r16) goto L15;
        r11.motion.mApply = true;
        r11.layout.mApply = true;
        r11.propertySet.mApply = true;
        r11.transform.mApply = true;
    L15:
        switch(mapToConstant.get(r16)) {
            case 1: goto L133;
            case 2: goto L132;
            case 3: goto L131;
            case 4: goto L130;
            case 5: goto L129;
            case 6: goto L128;
            case 7: goto L127;
            case 8: goto L125;
            case 9: goto L123;
            case 10: goto L122;
            case 11: goto L121;
            case 12: goto L120;
            case 13: goto L119;
            case 14: goto L118;
            case 15: goto L117;
            case 16: goto L116;
            case 17: goto L115;
            case 18: goto L114;
            case 19: goto L113;
            case 20: goto L112;
            case 21: goto L111;
            case 22: goto L110;
            case 23: goto L109;
            case 24: goto L108;
            case 25: goto L107;
            case 26: goto L106;
            case 27: goto L105;
            case 28: goto L104;
            case 29: goto L103;
            case 30: goto L102;
            case 31: goto L100;
            case 32: goto L98;
            case 33: goto L97;
            case 34: goto L96;
            case 35: goto L95;
            case 36: goto L94;
            case 37: goto L93;
            case 38: goto L92;
            case 39: goto L91;
            case 40: goto L90;
            case 41: goto L89;
            case 42: goto L88;
            case 43: goto L87;
            case 44: goto L85;
            case 45: goto L83;
            case 46: goto L82;
            case 47: goto L81;
            case 48: goto L80;
            case 49: goto L79;
            case 50: goto L78;
            case 51: goto L77;
            case 52: goto L76;
            case 53: goto L74;
            case 54: goto L72;
            case 55: goto L71;
            case 56: goto L70;
            case 57: goto L69;
            case 58: goto L68;
            case 59: goto L67;
            case 60: goto L66;
            case 61: goto L65;
            case 62: goto L64;
            case 63: goto L63;
            case 64: goto L62;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L55;
            case 68: goto L54;
            case 69: goto L53;
            case 70: goto L52;
            case 71: goto L51;
            case 72: goto L50;
            case 73: goto L49;
            case 74: goto L48;
            case 75: goto L47;
            case 76: goto L46;
            case 77: goto L45;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L42;
            case 81: goto L41;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
            case 86: goto L26;
            case 87: goto L24;
            case 88: goto L16;
            case 89: goto L16;
            case 90: goto L16;
            case 91: goto L23;
            case 92: goto L22;
            case 93: goto L21;
            case 94: goto L20;
            case 95: goto L19;
            case 96: goto L18;
            case 97: goto L17;
            default: goto L16;
        };
    L16:
        StringBuilder r17 = new StringBuilder();
        String r18 = "Unknown attribute 0x";
    L25:
        r17.append(r18);
        r17.append(Integer.toHexString(r16));
        r17.append("   ");
        r17.append(mapToConstant.get(r16));
        Log.w(TAG, r17.toString());
    L134:
        r15 = r15 + 1;
        goto L6
    L17:
        Layout r19 = r11.layout;
        r19.mWrapBehavior = r12.getInt(r16, r19.mWrapBehavior);
        goto L134
    L18:
        parseDimensionConstraints(r11.layout, r12, r16, 1);
        goto L134
    L19:
        parseDimensionConstraints(r11.layout, r12, r16, 0);
        goto L134
    L20:
        Layout r20 = r11.layout;
        r20.goneBaselineMargin = r12.getDimensionPixelSize(r16, r20.goneBaselineMargin);
        goto L134
    L21:
        Layout r21 = r11.layout;
        r21.baselineMargin = r12.getDimensionPixelSize(r16, r21.baselineMargin);
        goto L134
    L22:
        Layout r22 = r11.layout;
        r22.baselineToBottom = lookupID(r12, r16, r22.baselineToBottom);
        goto L134
    L23:
        Layout r23 = r11.layout;
        r23.baselineToTop = lookupID(r12, r16, r23.baselineToTop);
        goto L134
    L24:
        r17 = new StringBuilder();
        r18 = "unused attribute 0x";
        goto L25
    L26:
        int r24 = r12.peekValue(r16).type;
        if (r24 != 1) goto L31;
        r11.motion.mQuantizeInterpolatorID = r12.getResourceId(r16, -1);
        Motion r25 = r11.motion;
        if (r25.mQuantizeInterpolatorID == (-1)) goto L134;
    L30:
        r25.mQuantizeInterpolatorType = -2;
        goto L134
    L31:
        if (r24 != 3) goto L36;
        r11.motion.mQuantizeInterpolatorString = r12.getString(r16);
        if (r11.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L35;
        r11.motion.mQuantizeInterpolatorID = r12.getResourceId(r16, -1);
        r25 = r11.motion;
        goto L30
    L35:
        r11.motion.mQuantizeInterpolatorType = -1;
        goto L134
    L36:
        Motion r26 = r11.motion;
        r26.mQuantizeInterpolatorType = r12.getInteger(r16, r26.mQuantizeInterpolatorID);
        goto L134
    L37:
        Motion r27 = r11.motion;
        r27.mQuantizeMotionPhase = r12.getFloat(r16, r27.mQuantizeMotionPhase);
        goto L134
    L38:
        Motion r28 = r11.motion;
        r28.mQuantizeMotionSteps = r12.getInteger(r16, r28.mQuantizeMotionSteps);
        goto L134
    L39:
        Transform r29 = r11.transform;
        r29.transformPivotTarget = lookupID(r12, r16, r29.transformPivotTarget);
        goto L134
    L40:
        Motion r30 = r11.motion;
        r30.mAnimateCircleAngleTo = r12.getInteger(r16, r30.mAnimateCircleAngleTo);
        goto L134
    L41:
        Layout r31 = r11.layout;
        r31.constrainedHeight = r12.getBoolean(r16, r31.constrainedHeight);
        goto L134
    L42:
        Layout r32 = r11.layout;
        r32.constrainedWidth = r12.getBoolean(r16, r32.constrainedWidth);
        goto L134
    L43:
        Motion r33 = r11.motion;
        r33.mMotionStagger = r12.getFloat(r16, r33.mMotionStagger);
        goto L134
    L44:
        PropertySet r34 = r11.propertySet;
        r34.mVisibilityMode = r12.getInt(r16, r34.mVisibilityMode);
        goto L134
    L45:
        r11.layout.mConstraintTag = r12.getString(r16);
        goto L134
    L46:
        Motion r35 = r11.motion;
        r35.mPathMotionArc = r12.getInt(r16, r35.mPathMotionArc);
        goto L134
    L47:
        Layout r36 = r11.layout;
        r36.mBarrierAllowsGoneWidgets = r12.getBoolean(r16, r36.mBarrierAllowsGoneWidgets);
        goto L134
    L48:
        r11.layout.mReferenceIdString = r12.getString(r16);
        goto L134
    L49:
        Layout r37 = r11.layout;
        r37.mBarrierMargin = r12.getDimensionPixelSize(r16, r37.mBarrierMargin);
        goto L134
    L50:
        Layout r38 = r11.layout;
        r38.mBarrierDirection = r12.getInt(r16, r38.mBarrierDirection);
        goto L134
    L51:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L134
    L52:
        r11.layout.heightPercent = r12.getFloat(r16, 1.0f);
        goto L134
    L53:
        r11.layout.widthPercent = r12.getFloat(r16, 1.0f);
        goto L134
    L54:
        PropertySet r39 = r11.propertySet;
        r39.mProgress = r12.getFloat(r16, r39.mProgress);
        goto L134
    L55:
        Motion r40 = r11.motion;
        r40.mPathRotate = r12.getFloat(r16, r40.mPathRotate);
        goto L134
    L56:
        r11.motion.mDrawPath = r12.getInt(r16, 0);
        goto L134
    L62:
        Motion r41 = r11.motion;
        r41.mAnimateRelativeTo = lookupID(r12, r16, r41.mAnimateRelativeTo);
        goto L134
    L63:
        Layout r42 = r11.layout;
        r42.circleAngle = r12.getFloat(r16, r42.circleAngle);
        goto L134
    L64:
        Layout r43 = r11.layout;
        r43.circleRadius = r12.getDimensionPixelSize(r16, r43.circleRadius);
        goto L134
    L65:
        Layout r44 = r11.layout;
        r44.circleConstraint = lookupID(r12, r16, r44.circleConstraint);
        goto L134
    L66:
        Transform r45 = r11.transform;
        r45.rotation = r12.getFloat(r16, r45.rotation);
        goto L134
    L67:
        Layout r46 = r11.layout;
        r46.heightMin = r12.getDimensionPixelSize(r16, r46.heightMin);
        goto L134
    L68:
        Layout r47 = r11.layout;
        r47.widthMin = r12.getDimensionPixelSize(r16, r47.widthMin);
        goto L134
    L69:
        Layout r48 = r11.layout;
        r48.heightMax = r12.getDimensionPixelSize(r16, r48.heightMax);
        goto L134
    L70:
        Layout r49 = r11.layout;
        r49.widthMax = r12.getDimensionPixelSize(r16, r49.widthMax);
        goto L134
    L71:
        Layout r50 = r11.layout;
        r50.heightDefault = r12.getInt(r16, r50.heightDefault);
        goto L134
    L72:
        Layout r51 = r11.layout;
        r51.widthDefault = r12.getInt(r16, r51.widthDefault);
        goto L134
    L76:
        Transform r52 = r11.transform;
        r52.translationY = r12.getDimension(r16, r52.translationY);
        goto L134
    L77:
        Transform r53 = r11.transform;
        r53.translationX = r12.getDimension(r16, r53.translationX);
        goto L134
    L78:
        Transform r54 = r11.transform;
        r54.transformPivotY = r12.getDimension(r16, r54.transformPivotY);
        goto L134
    L79:
        Transform r55 = r11.transform;
        r55.transformPivotX = r12.getDimension(r16, r55.transformPivotX);
        goto L134
    L80:
        Transform r56 = r11.transform;
        r56.scaleY = r12.getFloat(r16, r56.scaleY);
        goto L134
    L81:
        Transform r57 = r11.transform;
        r57.scaleX = r12.getFloat(r16, r57.scaleX);
        goto L134
    L82:
        Transform r58 = r11.transform;
        r58.rotationY = r12.getFloat(r16, r58.rotationY);
        goto L134
    L83:
        Transform r59 = r11.transform;
        r59.rotationX = r12.getFloat(r16, r59.rotationX);
        goto L134
    L87:
        PropertySet r60 = r11.propertySet;
        r60.alpha = r12.getFloat(r16, r60.alpha);
        goto L134
    L88:
        Layout r61 = r11.layout;
        r61.verticalChainStyle = r12.getInt(r16, r61.verticalChainStyle);
        goto L134
    L89:
        Layout r62 = r11.layout;
        r62.horizontalChainStyle = r12.getInt(r16, r62.horizontalChainStyle);
        goto L134
    L90:
        Layout r63 = r11.layout;
        r63.verticalWeight = r12.getFloat(r16, r63.verticalWeight);
        goto L134
    L91:
        Layout r64 = r11.layout;
        r64.horizontalWeight = r12.getFloat(r16, r64.horizontalWeight);
        goto L134
    L92:
        r11.mViewId = r12.getResourceId(r16, r11.mViewId);
        goto L134
    L93:
        Layout r65 = r11.layout;
        r65.verticalBias = r12.getFloat(r16, r65.verticalBias);
        goto L134
    L94:
        Layout r66 = r11.layout;
        r66.topToTop = lookupID(r12, r16, r66.topToTop);
        goto L134
    L95:
        Layout r67 = r11.layout;
        r67.topToBottom = lookupID(r12, r16, r67.topToBottom);
        goto L134
    L96:
        Layout r68 = r11.layout;
        r68.topMargin = r12.getDimensionPixelSize(r16, r68.topMargin);
        goto L134
    L97:
        Layout r69 = r11.layout;
        r69.startToStart = lookupID(r12, r16, r69.startToStart);
        goto L134
    L98:
        Layout r70 = r11.layout;
        r70.startToEnd = lookupID(r12, r16, r70.startToEnd);
        goto L134
    L102:
        Layout r71 = r11.layout;
        r71.rightToRight = lookupID(r12, r16, r71.rightToRight);
        goto L134
    L103:
        Layout r72 = r11.layout;
        r72.rightToLeft = lookupID(r12, r16, r72.rightToLeft);
        goto L134
    L104:
        Layout r73 = r11.layout;
        r73.rightMargin = r12.getDimensionPixelSize(r16, r73.rightMargin);
        goto L134
    L105:
        Layout r74 = r11.layout;
        r74.orientation = r12.getInt(r16, r74.orientation);
        goto L134
    L106:
        Layout r75 = r11.layout;
        r75.leftToRight = lookupID(r12, r16, r75.leftToRight);
        goto L134
    L107:
        Layout r76 = r11.layout;
        r76.leftToLeft = lookupID(r12, r16, r76.leftToLeft);
        goto L134
    L108:
        Layout r77 = r11.layout;
        r77.leftMargin = r12.getDimensionPixelSize(r16, r77.leftMargin);
        goto L134
    L109:
        Layout r78 = r11.layout;
        r78.mWidth = r12.getLayoutDimension(r16, r78.mWidth);
        goto L134
    L110:
        PropertySet r79 = r11.propertySet;
        r79.visibility = r12.getInt(r16, r79.visibility);
        PropertySet r80 = r11.propertySet;
        r80.visibility = VISIBILITY_FLAGS[r80.visibility];
        goto L134
    L111:
        Layout r81 = r11.layout;
        r81.mHeight = r12.getLayoutDimension(r16, r81.mHeight);
        goto L134
    L112:
        Layout r82 = r11.layout;
        r82.horizontalBias = r12.getFloat(r16, r82.horizontalBias);
        goto L134
    L113:
        Layout r83 = r11.layout;
        r83.guidePercent = r12.getFloat(r16, r83.guidePercent);
        goto L134
    L114:
        Layout r84 = r11.layout;
        r84.guideEnd = r12.getDimensionPixelOffset(r16, r84.guideEnd);
        goto L134
    L115:
        Layout r85 = r11.layout;
        r85.guideBegin = r12.getDimensionPixelOffset(r16, r85.guideBegin);
        goto L134
    L116:
        Layout r86 = r11.layout;
        r86.goneTopMargin = r12.getDimensionPixelSize(r16, r86.goneTopMargin);
        goto L134
    L117:
        Layout r87 = r11.layout;
        r87.goneStartMargin = r12.getDimensionPixelSize(r16, r87.goneStartMargin);
        goto L134
    L118:
        Layout r88 = r11.layout;
        r88.goneRightMargin = r12.getDimensionPixelSize(r16, r88.goneRightMargin);
        goto L134
    L119:
        Layout r89 = r11.layout;
        r89.goneLeftMargin = r12.getDimensionPixelSize(r16, r89.goneLeftMargin);
        goto L134
    L120:
        Layout r90 = r11.layout;
        r90.goneEndMargin = r12.getDimensionPixelSize(r16, r90.goneEndMargin);
        goto L134
    L121:
        Layout r91 = r11.layout;
        r91.goneBottomMargin = r12.getDimensionPixelSize(r16, r91.goneBottomMargin);
        goto L134
    L122:
        Layout r92 = r11.layout;
        r92.endToStart = lookupID(r12, r16, r92.endToStart);
        goto L134
    L123:
        Layout r93 = r11.layout;
        r93.endToEnd = lookupID(r12, r16, r93.endToEnd);
        goto L134
    L127:
        Layout r94 = r11.layout;
        r94.editorAbsoluteY = r12.getDimensionPixelOffset(r16, r94.editorAbsoluteY);
        goto L134
    L128:
        Layout r95 = r11.layout;
        r95.editorAbsoluteX = r12.getDimensionPixelOffset(r16, r95.editorAbsoluteX);
        goto L134
    L129:
        r11.layout.dimensionRatio = r12.getString(r16);
        goto L134
    L130:
        Layout r96 = r11.layout;
        r96.bottomToTop = lookupID(r12, r16, r96.bottomToTop);
        goto L134
    L131:
        Layout r97 = r11.layout;
        r97.bottomToBottom = lookupID(r12, r16, r97.bottomToBottom);
        goto L134
    L132:
        Layout r98 = r11.layout;
        r98.bottomMargin = r12.getDimensionPixelSize(r16, r98.bottomMargin);
        goto L134
    L133:
        Layout r99 = r11.layout;
        r99.baselineToBaseline = lookupID(r12, r16, r99.baselineToBaseline);
        goto L134
    L58:
        if (r12.peekValue(r16).type != 3) goto L60;
        Motion r100 = r11.motion;
        String r101 = r12.getString(r16);
    L61:
        r100.mTransitionEasing = r101;
        goto L134
    L60:
        r100 = r11.motion;
        r101 = Easing.NAMED_EASING[r12.getInteger(r16, 0)];
        goto L61
    L74:
        if (Build.VERSION.SDK_INT < 21) goto L134;
        Transform r102 = r11.transform;
        r102.translationZ = r12.getDimension(r16, r102.translationZ);
        goto L134
    L85:
        if (Build.VERSION.SDK_INT < 21) goto L134;
        Transform r103 = r11.transform;
        r103.applyElevation = true;
        r103.elevation = r12.getDimension(r16, r103.elevation);
        goto L134
    L100:
        if (Build.VERSION.SDK_INT < 17) goto L134;
        Layout r104 = r11.layout;
        r104.startMargin = r12.getDimensionPixelSize(r16, r104.startMargin);
        goto L134
    L125:
        if (Build.VERSION.SDK_INT < 17) goto L134;
        Layout r105 = r11.layout;
        r105.endMargin = r12.getDimensionPixelSize(r16, r105.endMargin);
        goto L134
    L135:
        Layout r106 = r11.layout;
        if (r106.mReferenceIdString == null) goto L241;
        r106.mReferenceIds = null;
        return;
    }

    private static void populateOverride(Context r13, Constraint r14, TypedArray r15) {
        int r16 = r15.getIndexCount();
        Constraint.Delta r10 = new Constraint.Delta();
        r14.mDelta = r10;
        r14.motion.mApply = false;
        r14.layout.mApply = false;
        r14.propertySet.mApply = false;
        r14.transform.mApply = false;
        int r11 = 0;
    L3:
        if (r11 >= r16) goto L131;
        int r12 = r15.getIndex(r11);
        float r17 = 1.0f;
        int r18 = 21;
        switch(overrideMapToConstant.get(r12)) {
            case 2: goto L127;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L125;
            case 6: goto L123;
            case 7: goto L122;
            case 8: goto L120;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L118;
            case 12: goto L117;
            case 13: goto L116;
            case 14: goto L115;
            case 15: goto L114;
            case 16: goto L113;
            case 17: goto L112;
            case 18: goto L111;
            case 19: goto L108;
            case 20: goto L107;
            case 21: goto L105;
            case 22: goto L104;
            case 23: goto L103;
            case 24: goto L102;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L100;
            case 28: goto L99;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L97;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L95;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L94;
            case 38: goto L93;
            case 39: goto L92;
            case 40: goto L91;
            case 41: goto L90;
            case 42: goto L89;
            case 43: goto L88;
            case 44: goto L86;
            case 45: goto L84;
            case 46: goto L83;
            case 47: goto L82;
            case 48: goto L81;
            case 49: goto L79;
            case 50: goto L78;
            case 51: goto L77;
            case 52: goto L76;
            case 53: goto L74;
            case 54: goto L72;
            case 55: goto L71;
            case 56: goto L70;
            case 57: goto L69;
            case 58: goto L68;
            case 59: goto L67;
            case 60: goto L66;
            case 61: goto L6;
            case 62: goto L65;
            case 63: goto L64;
            case 64: goto L62;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L55;
            case 68: goto L54;
            case 69: goto L53;
            case 70: goto L52;
            case 71: goto L51;
            case 72: goto L50;
            case 73: goto L49;
            case 74: goto L48;
            case 75: goto L46;
            case 76: goto L45;
            case 77: goto L44;
            case 78: goto L43;
            case 79: goto L42;
            case 80: goto L41;
            case 81: goto L40;
            case 82: goto L38;
            case 83: goto L37;
            case 84: goto L36;
            case 85: goto L35;
            case 86: goto L24;
            case 87: goto L23;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            case 98: goto L10;
            case 99: goto L8;
            default: goto L6;
        };
    L6:
        StringBuilder r19 = new StringBuilder();
        String r20 = "Unknown attribute 0x";
    L7:
        r19.append(r20);
        r19.append(Integer.toHexString(r12));
        r19.append("   ");
        r19.append(mapToConstant.get(r12));
        Log.w(TAG, r19.toString());
    L130:
        r11 = r11 + 1;
        goto L3
    L8:
        int r21 = 99;
        boolean r22 = r14.layout.guidelineUseRtl;
    L47:
        r10.add(r21, r15.getBoolean(r12, r22));
        goto L130
    L18:
        int r23 = 97;
        int r24 = r14.layout.mWrapBehavior;
    L101:
        int r25 = r15.getInt(r12, r24);
    L129:
        r10.add(r23, r25);
        goto L130
    L19:
        parseDimensionConstraints(r10, r15, r12, 1);
        goto L130
    L20:
        parseDimensionConstraints(r10, r15, r12, 0);
        goto L130
    L21:
        r23 = 94;
        int r26 = r14.layout.goneBaselineMargin;
    L128:
        r25 = r15.getDimensionPixelSize(r12, r26);
        goto L129
    L22:
        r23 = 93;
        r26 = r14.layout.baselineMargin;
        goto L128
    L23:
        r19 = new StringBuilder();
        r20 = "unused attribute 0x";
        goto L7
    L24:
        int r27 = r15.peekValue(r12).type;
        r18 = 88;
        if (r27 != 1) goto L29;
        r14.motion.mQuantizeInterpolatorID = r15.getResourceId(r12, -1);
        r10.add(89, r14.motion.mQuantizeInterpolatorID);
        Motion r28 = r14.motion;
        if (r28.mQuantizeInterpolatorID == (-1)) goto L130;
    L28:
        r28.mQuantizeInterpolatorType = -2;
        r10.add(88, -2);
        goto L130
    L29:
        if (r27 != 3) goto L34;
        r14.motion.mQuantizeInterpolatorString = r15.getString(r12);
        r10.add(90, r14.motion.mQuantizeInterpolatorString);
        if (r14.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L33;
        r14.motion.mQuantizeInterpolatorID = r15.getResourceId(r12, -1);
        r10.add(89, r14.motion.mQuantizeInterpolatorID);
        r28 = r14.motion;
        goto L28
    L33:
        r14.motion.mQuantizeInterpolatorType = -1;
        r10.add(88, -1);
        goto L130
    L34:
        Motion r29 = r14.motion;
        r29.mQuantizeInterpolatorType = r15.getInteger(r12, r29.mQuantizeInterpolatorID);
        int r30 = r14.motion.mQuantizeInterpolatorType;
    L106:
        r10.add(r18, r30);
        goto L130
    L35:
        int r31 = 85;
        r17 = r14.motion.mQuantizeMotionPhase;
    L109:
        float r32 = r15.getFloat(r12, r17);
    L110:
        r10.add(r31, r32);
        goto L130
    L36:
        r23 = 84;
        int r33 = r14.motion.mQuantizeMotionSteps;
    L39:
        r25 = r15.getInteger(r12, r33);
        goto L129
    L37:
        r23 = 83;
        int r34 = r14.transform.transformPivotTarget;
    L63:
        r25 = lookupID(r15, r12, r34);
        goto L129
    L38:
        r23 = 82;
        r33 = r14.motion.mAnimateCircleAngleTo;
        goto L39
    L40:
        r21 = 81;
        r22 = r14.layout.constrainedHeight;
        goto L47
    L41:
        r21 = 80;
        r22 = r14.layout.constrainedWidth;
        goto L47
    L42:
        r31 = 79;
        r17 = r14.motion.mMotionStagger;
        goto L109
    L43:
        r23 = 78;
        r24 = r14.propertySet.mVisibilityMode;
        goto L101
    L44:
        int r35 = 77;
    L126:
        r10.add(r35, r15.getString(r12));
        goto L130
    L45:
        r23 = 76;
        r24 = r14.motion.mPathMotionArc;
        goto L101
    L46:
        r21 = 75;
        r22 = r14.layout.mBarrierAllowsGoneWidgets;
        goto L47
    L48:
        r35 = 74;
        goto L126
    L49:
        r23 = 73;
        r26 = r14.layout.mBarrierMargin;
        goto L128
    L50:
        r23 = 72;
        r24 = r14.layout.mBarrierDirection;
        goto L101
    L51:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L130
    L52:
        r31 = 70;
        goto L109
    L53:
        r31 = 69;
        goto L109
    L54:
        r31 = 68;
        r17 = r14.propertySet.mProgress;
        goto L109
    L55:
        r31 = 67;
        r17 = r14.motion.mPathRotate;
        goto L109
    L56:
        r23 = 66;
        r25 = r15.getInt(r12, 0);
        goto L129
    L62:
        r23 = 64;
        r34 = r14.motion.mAnimateRelativeTo;
        goto L63
    L64:
        r31 = 63;
        r17 = r14.layout.circleAngle;
        goto L109
    L65:
        r23 = 62;
        r26 = r14.layout.circleRadius;
        goto L128
    L66:
        r31 = 60;
        r17 = r14.transform.rotation;
        goto L109
    L67:
        r23 = 59;
        r26 = r14.layout.heightMin;
        goto L128
    L68:
        r23 = 58;
        r26 = r14.layout.widthMin;
        goto L128
    L69:
        r23 = 57;
        r26 = r14.layout.heightMax;
        goto L128
    L70:
        r23 = 56;
        r26 = r14.layout.widthMax;
        goto L128
    L71:
        r23 = 55;
        r24 = r14.layout.heightDefault;
        goto L101
    L72:
        r23 = 54;
        r24 = r14.layout.widthDefault;
        goto L101
    L76:
        r31 = 52;
        float r36 = r14.transform.translationY;
    L80:
        r32 = r15.getDimension(r12, r36);
        goto L110
    L77:
        r31 = 51;
        r36 = r14.transform.translationX;
        goto L80
    L78:
        r31 = 50;
        r36 = r14.transform.transformPivotY;
        goto L80
    L79:
        r31 = 49;
        r36 = r14.transform.transformPivotX;
        goto L80
    L81:
        r31 = 48;
        r17 = r14.transform.scaleY;
        goto L109
    L82:
        r31 = 47;
        r17 = r14.transform.scaleX;
        goto L109
    L83:
        r31 = 46;
        r17 = r14.transform.rotationY;
        goto L109
    L84:
        r31 = 45;
        r17 = r14.transform.rotationX;
        goto L109
    L88:
        r31 = 43;
        r17 = r14.propertySet.alpha;
        goto L109
    L89:
        r23 = 42;
        r24 = r14.layout.verticalChainStyle;
        goto L101
    L90:
        r23 = 41;
        r24 = r14.layout.horizontalChainStyle;
        goto L101
    L91:
        r31 = 40;
        r17 = r14.layout.verticalWeight;
        goto L109
    L92:
        r31 = 39;
        r17 = r14.layout.horizontalWeight;
        goto L109
    L93:
        r25 = r15.getResourceId(r12, r14.mViewId);
        r14.mViewId = r25;
        r23 = 38;
        goto L129
    L94:
        r31 = 37;
        r17 = r14.layout.verticalBias;
        goto L109
    L95:
        r23 = 34;
        r26 = r14.layout.topMargin;
        goto L128
    L99:
        r23 = 28;
        r26 = r14.layout.rightMargin;
        goto L128
    L100:
        r23 = 27;
        r24 = r14.layout.orientation;
        goto L101
    L102:
        r23 = 24;
        r26 = r14.layout.leftMargin;
        goto L128
    L103:
        r23 = 23;
        r25 = r15.getLayoutDimension(r12, r14.layout.mWidth);
        goto L129
    L104:
        r23 = 22;
        r25 = VISIBILITY_FLAGS[r15.getInt(r12, r14.propertySet.visibility)];
        goto L129
    L105:
        r30 = r15.getLayoutDimension(r12, r14.layout.mHeight);
        goto L106
    L107:
        r31 = 20;
        r17 = r14.layout.horizontalBias;
        goto L109
    L108:
        r31 = 19;
        r17 = r14.layout.guidePercent;
        goto L109
    L111:
        r23 = 18;
        int r37 = r14.layout.guideEnd;
    L124:
        r25 = r15.getDimensionPixelOffset(r12, r37);
        goto L129
    L112:
        r10.add(17, r15.getDimensionPixelOffset(r12, r14.layout.guideBegin));
        goto L130
    L113:
        r23 = 16;
        r26 = r14.layout.goneTopMargin;
        goto L128
    L114:
        r23 = 15;
        r26 = r14.layout.goneStartMargin;
        goto L128
    L115:
        r23 = 14;
        r26 = r14.layout.goneRightMargin;
        goto L128
    L116:
        r23 = 13;
        r26 = r14.layout.goneLeftMargin;
        goto L128
    L117:
        r23 = 12;
        r26 = r14.layout.goneEndMargin;
        goto L128
    L118:
        r23 = 11;
        r26 = r14.layout.goneBottomMargin;
        goto L128
    L122:
        r23 = 7;
        r37 = r14.layout.editorAbsoluteY;
        goto L124
    L123:
        r23 = 6;
        r37 = r14.layout.editorAbsoluteX;
        goto L124
    L125:
        r35 = 5;
        goto L126
    L127:
        r23 = 2;
        r26 = r14.layout.bottomMargin;
        goto L128
    L10:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        int r38 = r15.getResourceId(r12, r14.mViewId);
        r14.mViewId = r38;
        if (r38 != (-1)) goto L130;
    L16:
        r14.mTargetString = r15.getString(r12);
        goto L130
    L15:
        if (r15.peekValue(r12).type == 3) goto L16;
        r14.mViewId = r15.getResourceId(r12, r14.mViewId);
        goto L130
    L58:
        if (r15.peekValue(r12).type != 3) goto L60;
        String r39 = r15.getString(r12);
    L61:
        r10.add(65, r39);
        goto L130
    L60:
        r39 = Easing.NAMED_EASING[r15.getInteger(r12, 0)];
        goto L61
    L74:
        if (Build.VERSION.SDK_INT < 21) goto L130;
        r31 = 53;
        r36 = r14.transform.translationZ;
        goto L80
    L86:
        if (Build.VERSION.SDK_INT < 21) goto L130;
        r31 = 44;
        r10.add(44, true);
        r36 = r14.transform.elevation;
        goto L80
    L97:
        if (Build.VERSION.SDK_INT < 17) goto L130;
        r23 = 31;
        r26 = r14.layout.startMargin;
        goto L128
    L120:
        if (Build.VERSION.SDK_INT < 17) goto L130;
        r23 = 8;
        r26 = r14.layout.endMargin;
        goto L128
    }

    private static void setDeltaValue(Constraint r10, int r11, float r12) {
        if (r11 != 19) goto L5;
        r10.layout.guidePercent = r12;
        return;
    L5:
        if (r11 != 20) goto L7;
        r10.layout.horizontalBias = r12;
        return;
    L7:
        if (r11 != 37) goto L9;
        r10.layout.verticalBias = r12;
        return;
    L9:
        if (r11 != 60) goto L11;
        r10.transform.rotation = r12;
        return;
    L11:
        if (r11 != 63) goto L13;
        r10.layout.circleAngle = r12;
        return;
    L13:
        if (r11 != 79) goto L15;
        r10.motion.mMotionStagger = r12;
        return;
    L15:
        if (r11 != 85) goto L17;
        r10.motion.mQuantizeMotionPhase = r12;
        return;
    L17:
        if (r11 != 87) goto L19;
        return;
    L19:
        if (r11 != 39) goto L21;
        r10.layout.horizontalWeight = r12;
        return;
    L21:
        if (r11 == 40) goto L40;
        switch(r11) {
            case 43: goto L39;
            case 44: goto L38;
            case 45: goto L37;
            case 46: goto L36;
            case 47: goto L35;
            case 48: goto L34;
            case 49: goto L33;
            case 50: goto L32;
            case 51: goto L31;
            case 52: goto L30;
            case 53: goto L29;
            default: goto L23;
        };
    L23:
        switch(r11) {
            case 67: goto L28;
            case 68: goto L27;
            case 69: goto L26;
            case 70: goto L25;
            default: goto L24;
        };
    L24:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L25:
        r10.layout.heightPercent = r12;
        return;
    L26:
        r10.layout.widthPercent = r12;
        return;
    L27:
        r10.propertySet.mProgress = r12;
        return;
    L28:
        r10.motion.mPathRotate = r12;
        return;
    L29:
        r10.transform.translationZ = r12;
        return;
    L30:
        r10.transform.translationY = r12;
        return;
    L31:
        r10.transform.translationX = r12;
        return;
    L32:
        r10.transform.transformPivotY = r12;
        return;
    L33:
        r10.transform.transformPivotX = r12;
        return;
    L34:
        r10.transform.scaleY = r12;
        return;
    L35:
        r10.transform.scaleX = r12;
        return;
    L36:
        r10.transform.rotationY = r12;
        return;
    L37:
        r10.transform.rotationX = r12;
        return;
    L38:
        Transform r13 = r10.transform;
        r13.elevation = r12;
        r13.applyElevation = true;
        return;
    L39:
        r10.propertySet.alpha = r12;
        return;
    L40:
        r10.layout.verticalWeight = r12;
    }

    private static void setDeltaValue(Constraint r10, int r11, int r12) {
        if (r11 != 6) goto L5;
        r10.layout.editorAbsoluteX = r12;
        return;
    L5:
        if (r11 != 7) goto L7;
        r10.layout.editorAbsoluteY = r12;
        return;
    L7:
        if (r11 != 8) goto L9;
        r10.layout.endMargin = r12;
        return;
    L9:
        if (r11 != 27) goto L11;
        r10.layout.orientation = r12;
        return;
    L11:
        if (r11 != 28) goto L13;
        r10.layout.rightMargin = r12;
        return;
    L13:
        if (r11 != 41) goto L15;
        r10.layout.horizontalChainStyle = r12;
        return;
    L15:
        if (r11 != 42) goto L17;
        r10.layout.verticalChainStyle = r12;
        return;
    L17:
        if (r11 != 61) goto L19;
        r10.layout.circleConstraint = r12;
        return;
    L19:
        if (r11 != 62) goto L21;
        r10.layout.circleRadius = r12;
        return;
    L21:
        if (r11 != 72) goto L23;
        r10.layout.mBarrierDirection = r12;
        return;
    L23:
        if (r11 == 73) goto L64;
        switch(r11) {
            case 2: goto L63;
            case 11: goto L62;
            case 12: goto L61;
            case 13: goto L60;
            case 14: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            case 31: goto L54;
            case 34: goto L53;
            case 38: goto L52;
            case 64: goto L51;
            case 66: goto L50;
            case 76: goto L49;
            case 78: goto L48;
            case 93: goto L47;
            case 94: goto L46;
            case 97: goto L45;
            default: goto L25;
        };
    L25:
        switch(r11) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r11) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r11) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r11) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L30:
        r10.motion.mQuantizeInterpolatorID = r12;
        return;
    L31:
        r10.motion.mQuantizeInterpolatorType = r12;
        return;
    L76:
        return;
    L32:
        r10.motion.mQuantizeMotionSteps = r12;
        return;
    L33:
        r10.transform.transformPivotTarget = r12;
        return;
    L34:
        r10.motion.mAnimateCircleAngleTo = r12;
        return;
    L35:
        r10.layout.heightMin = r12;
        return;
    L36:
        r10.layout.widthMin = r12;
        return;
    L37:
        r10.layout.heightMax = r12;
        return;
    L38:
        r10.layout.widthMax = r12;
        return;
    L39:
        r10.layout.heightDefault = r12;
        return;
    L40:
        r10.layout.widthDefault = r12;
        return;
    L41:
        r10.layout.leftMargin = r12;
        return;
    L42:
        r10.layout.mWidth = r12;
        return;
    L43:
        r10.propertySet.visibility = r12;
        return;
    L44:
        r10.layout.mHeight = r12;
        return;
    L45:
        r10.layout.mWrapBehavior = r12;
        return;
    L46:
        r10.layout.goneBaselineMargin = r12;
        return;
    L47:
        r10.layout.baselineMargin = r12;
        return;
    L48:
        r10.propertySet.mVisibilityMode = r12;
        return;
    L49:
        r10.motion.mPathMotionArc = r12;
        return;
    L50:
        r10.motion.mDrawPath = r12;
        return;
    L51:
        r10.motion.mAnimateRelativeTo = r12;
        return;
    L52:
        r10.mViewId = r12;
        return;
    L53:
        r10.layout.topMargin = r12;
        return;
    L54:
        r10.layout.startMargin = r12;
        return;
    L55:
        r10.layout.guideEnd = r12;
        return;
    L56:
        r10.layout.guideBegin = r12;
        return;
    L57:
        r10.layout.goneTopMargin = r12;
        return;
    L58:
        r10.layout.goneStartMargin = r12;
        return;
    L59:
        r10.layout.goneRightMargin = r12;
        return;
    L60:
        r10.layout.goneLeftMargin = r12;
        return;
    L61:
        r10.layout.goneEndMargin = r12;
        return;
    L62:
        r10.layout.goneBottomMargin = r12;
        return;
    L63:
        r10.layout.bottomMargin = r12;
        return;
    L64:
        r10.layout.mBarrierMargin = r12;
    }

    private static void setDeltaValue(Constraint r10, int r11, String r12) {
        if (r11 != 5) goto L5;
        r10.layout.dimensionRatio = r12;
        return;
    L5:
        if (r11 != 65) goto L7;
        r10.motion.mTransitionEasing = r12;
        return;
    L7:
        if (r11 != 74) goto L9;
        Layout r13 = r10.layout;
        r13.mReferenceIdString = r12;
        r13.mReferenceIds = null;
        return;
    L9:
        if (r11 != 77) goto L11;
        r10.layout.mConstraintTag = r12;
        return;
    L11:
        if (r11 != 87) goto L13;
        return;
    L13:
        if (r11 == 90) goto L15;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L15:
        r10.motion.mQuantizeInterpolatorString = r12;
    }

    private static void setDeltaValue(Constraint r10, int r11, boolean r12) {
        if (r11 != 44) goto L5;
        r10.transform.applyElevation = r12;
        return;
    L5:
        if (r11 != 75) goto L7;
        r10.layout.mBarrierAllowsGoneWidgets = r12;
        return;
    L7:
        if (r11 != 87) goto L9;
        return;
    L9:
        if (r11 != 80) goto L11;
        r10.layout.constrainedWidth = r12;
        return;
    L11:
        if (r11 == 81) goto L13;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L13:
        r10.layout.constrainedHeight = r12;
    }

    private String sideToString(int r10) {
        switch(r10) {
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
        return CommonConsts.APM_INNER_EVENT_COST_START;
    L9:
        return "baseline";
    L11:
        return "bottom";
    L13:
        return "top";
    L15:
        return "right";
    L17:
        return "left";
    }

    private static String[] splitString(String r10) {
        char[] r11 = r10.toCharArray();
        ArrayList r12 = new ArrayList();
        int r13 = 0;
        int r14 = 0;
        boolean r15 = false;
    L4:
        if (r13 >= r11.length) goto L13;
        if (r11[r13] != ',') goto L10;
        if (r15 == true) goto L10;
        r12.add(new String(r11, r14, r13 - r14));
        r14 = r13 + 1;
    L12:
        r13 = r13 + 1;
    L10:
        if (r11[r13] != '\"') goto L12;
        r15 = !r15;
        goto L12
    L13:
        r12.add(new String(r11, r14, r11.length - r14));
        return (String[]) r12.toArray(new String[r12.size()]);
    }

    public void addColorAttributes(String... r10) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r10);
    }

    public void addFloatAttributes(String... r10) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r10);
    }

    public void addIntAttributes(String... r10) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r10);
    }

    public void addStringAttributes(String... r10) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r10);
    }

    public void addToHorizontalChain(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r13 = 1;
    L6:
        connect(r10, 1, r11, r13, 0);
        if (r12 != 0) goto L9;
        int r14 = 2;
    L10:
        connect(r10, 2, r12, r14, 0);
        if (r11 == 0) goto L13;
        connect(r11, 2, r10, 1, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 1, r10, 2, 0);
        return;
    L16:
        return;
    L9:
        r14 = 1;
        goto L10
    L5:
        r13 = 2;
        goto L6
    }

    public void addToHorizontalChainRTL(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r13 = 6;
    L6:
        connect(r10, 6, r11, r13, 0);
        if (r12 != 0) goto L9;
        int r14 = 7;
    L10:
        connect(r10, 7, r12, r14, 0);
        if (r11 == 0) goto L13;
        connect(r11, 7, r10, 6, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 6, r10, 7, 0);
        return;
    L16:
        return;
    L9:
        r14 = 6;
        goto L10
    L5:
        r13 = 7;
        goto L6
    }

    public void addToVerticalChain(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        int r13 = 3;
    L6:
        connect(r10, 3, r11, r13, 0);
        if (r12 != 0) goto L9;
        int r14 = 4;
    L10:
        connect(r10, 4, r12, r14, 0);
        if (r11 == 0) goto L13;
        connect(r11, 4, r10, 3, 0);
    L13:
        if (r12 == 0) goto L16;
        connect(r12, 3, r10, 4, 0);
        return;
    L16:
        return;
    L9:
        r14 = 3;
        goto L10
    L5:
        r13 = 4;
        goto L6
    }

    public void applyCustomAttributes(ConstraintLayout r10) {
        int r11 = r10.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L21;
        View r13 = r10.getChildAt(r12);
        int r14 = r13.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == true) goto L8;
        Log.w(TAG, "id unknown " + Debug.getName(r13));
    L20:
        r12 = r12 + 1;
        goto L3
    L8:
        if (this.mForceId == false) goto L15;
        if (r14 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == false) goto L20;
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r14));
        if (r15 == null) goto L20;
        ConstraintAttribute.setAttributes(r13, r15.mCustomConstraints);
        goto L20
    }

    public void applyDeltaFrom(ConstraintSet r10) {
        Iterator<Constraint> r11 = r10.mConstraints.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Constraint r12 = r11.next();
        if (r12.mDelta == null) goto L4;
        if (r12.mTargetString != null) goto L9;
        Constraint r13 = getConstraint(r12.mViewId);
        r12.mDelta.applyDelta(r13);
        goto L4
    L9:
        Iterator<Integer> r14 = this.mConstraints.keySet().iterator();
    L11:
        if (r14.hasNext() == false) goto L4;
        Constraint r15 = getConstraint(r14.next().intValue());
        String r16 = r15.layout.mConstraintTag;
        if (r16 == null) goto L11;
        if (r12.mTargetString.matches(r16) == false) goto L11;
        r12.mDelta.applyDelta(r15);
        r15.mCustomConstraints.putAll((HashMap) r12.mCustomConstraints.clone());
        goto L11
    }

    public void applyTo(ConstraintLayout r10) {
        applyToInternal(r10, true);
        r10.setConstraintSet(null);
        r10.requestLayout();
    }

    public void applyToHelper(ConstraintHelper r10, ConstraintWidget r11, ConstraintLayout.LayoutParams r12, SparseArray<ConstraintWidget> r13) {
        int r14 = r10.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r14)) == false) goto L10;
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r14));
        if (r15 != null) goto L7;
        return;
    L7:
        if ((r11 instanceof HelperWidget) == false) goto L12;
        r10.loadParameters(r15, (HelperWidget) r11, r12, r13);
        return;
    L12:
        return;
    }

    void applyToInternal(ConstraintLayout r12, boolean r13) {
        int r10 = r12.getChildCount();
        HashSet r11 = new HashSet(this.mConstraints.keySet());
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r10) goto L59;
        View r16 = r12.getChildAt(r15);
        int r17 = r16.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r17)) == true) goto L9;
        Log.w(TAG, "id unknown " + Debug.getName(r16));
    L58:
        r15 = r15 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r17 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r17 == (-1)) goto L58;
        if (this.mConstraints.containsKey(Integer.valueOf(r17)) == false) goto L57;
        r11.remove(Integer.valueOf(r17));
        Constraint r18 = this.mConstraints.get(Integer.valueOf(r17));
        if (r18 == null) goto L58;
        if ((r16 instanceof Barrier) == false) goto L29;
        r18.layout.mHelperType = 1;
        Barrier r19 = (Barrier) r16;
        r19.setId(r17);
        r19.setType(r18.layout.mBarrierDirection);
        r19.setMargin(r18.layout.mBarrierMargin);
        r19.setAllowsGoneWidget(r18.layout.mBarrierAllowsGoneWidgets);
        Layout r20 = r18.layout;
        int[] r21 = r20.mReferenceIds;
        if (r21 == null) goto L26;
        r19.setReferencedIds(r21);
        goto L29
    L26:
        String r22 = r20.mReferenceIdString;
        if (r22 == null) goto L29;
        r20.mReferenceIds = convertReferenceString(r19, r22);
        r19.setReferencedIds(r18.layout.mReferenceIds);
    L29:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r16.getLayoutParams();
        r23.validate();
        r18.applyTo(r23);
        if (r13 == false) goto L32;
        ConstraintAttribute.setAttributes(r16, r18.mCustomConstraints);
    L32:
        r16.setLayoutParams(r23);
        PropertySet r24 = r18.propertySet;
        if (r24.mVisibilityMode != 0) goto L35;
        r16.setVisibility(r24.visibility);
    L35:
        int r25 = Build.VERSION.SDK_INT;
        if (r25 < 17) goto L58;
        r16.setAlpha(r18.propertySet.alpha);
        r16.setRotation(r18.transform.rotation);
        r16.setRotationX(r18.transform.rotationX);
        r16.setRotationY(r18.transform.rotationY);
        r16.setScaleX(r18.transform.scaleX);
        r16.setScaleY(r18.transform.scaleY);
        Transform r26 = r18.transform;
        if (r26.transformPivotTarget == (-1)) goto L47;
        View r27 = ((View) r16.getParent()).findViewById(r18.transform.transformPivotTarget);
        if (r27 == null) goto L52;
        float r28 = (r27.getTop() + r27.getBottom()) / 2.0f;
        float r29 = (r27.getLeft() + r27.getRight()) / 2.0f;
        if ((r16.getRight() - r16.getLeft()) <= 0) goto L52;
        if ((r16.getBottom() - r16.getTop()) <= 0) goto L52;
        float r30 = r29 - r16.getLeft();
        float r31 = r28 - r16.getTop();
        r16.setPivotX(r30);
        r16.setPivotY(r31);
    L52:
        r16.setTranslationX(r18.transform.translationX);
        r16.setTranslationY(r18.transform.translationY);
        if (r25 < 21) goto L58;
        r16.setTranslationZ(r18.transform.translationZ);
        Transform r32 = r18.transform;
        if (r32.applyElevation == false) goto L58;
        r16.setElevation(r32.elevation);
        goto L58
    L47:
        if (Float.isNaN(r26.transformPivotX) == true) goto L50;
        r16.setPivotX(r18.transform.transformPivotX);
    L50:
        if (Float.isNaN(r18.transform.transformPivotY) == true) goto L52;
        r16.setPivotY(r18.transform.transformPivotY);
        goto L52
    L57:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r17);
        goto L58
    L59:
        Iterator r110 = r11.iterator();
    L61:
        if (r110.hasNext() == false) goto L77;
        Integer r33 = (Integer) r110.next();
        Constraint r34 = this.mConstraints.get(r33);
        if (r34 == null) goto L61;
        if (r34.layout.mHelperType != 1) goto L75;
        Barrier r35 = new Barrier(r12.getContext());
        r35.setId(r33.intValue());
        Layout r36 = r34.layout;
        int[] r37 = r36.mReferenceIds;
        if (r37 == null) goto L70;
        r35.setReferencedIds(r37);
    L73:
        r35.setType(r34.layout.mBarrierDirection);
        r35.setMargin(r34.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r38 = r12.generateDefaultLayoutParams();
        r35.validateParams();
        r34.applyTo(r38);
        r12.addView(r35, r38);
        goto L75
    L70:
        String r39 = r36.mReferenceIdString;
        if (r39 == null) goto L73;
        r36.mReferenceIds = convertReferenceString(r35, r39);
        r35.setReferencedIds(r34.layout.mReferenceIds);
    L75:
        if (r34.layout.mIsGuideline == false) goto L61;
        View r40 = new Guideline(r12.getContext());
        r40.setId(r33.intValue());
        ConstraintLayout.LayoutParams r41 = r12.generateDefaultLayoutParams();
        r34.applyTo(r41);
        r12.addView(r40, r41);
    L77:
        if (r14 >= r10) goto L82;
        View r111 = r12.getChildAt(r14);
        if ((r111 instanceof ConstraintHelper) == false) goto L81;
        ((ConstraintHelper) r111).applyLayoutFeaturesInConstraintSet(r12);
    L81:
        r14 = r14 + 1;
        goto L77
    }

    public void applyToLayoutParams(int r10, ConstraintLayout.LayoutParams r11) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L8;
        Constraint r12 = this.mConstraints.get(Integer.valueOf(r10));
        if (r12 == null) goto L9;
        r12.applyTo(r11);
        return;
    L9:
        return;
    }

    public void applyToWithoutCustom(ConstraintLayout r10) {
        applyToInternal(r10, false);
        r10.setConstraintSet(null);
    }

    public void center(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        if (r13 < 0) goto L34;
        if (r16 < 0) goto L32;
        if (r17 <= 0.0f) goto L30;
        if (r17 > 1.0f) goto L30;
        if (r12 != 1) goto L12;
    L25:
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        Constraint r18 = this.mConstraints.get(Integer.valueOf(r10));
        if (r18 == null) goto L38;
    L24:
        r18.layout.horizontalBias = r17;
        return;
    L38:
        return;
    L12:
        if (r12 == 2) goto L25;
        if (r12 != 6) goto L17;
    L22:
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        r18 = this.mConstraints.get(Integer.valueOf(r10));
        if (r18 != null) goto L24;
        return;
    L17:
        if (r12 == 7) goto L22;
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        Constraint r19 = this.mConstraints.get(Integer.valueOf(r10));
        if (r19 == null) goto L28;
        r19.layout.verticalBias = r17;
        return;
    L28:
        return;
    L30:
        throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
    L32:
        throw new IllegalArgumentException("margin must be > 0");
    L34:
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r12 = 0;
        int r13 = 1;
        int r14 = 0;
        int r15 = 0;
        int r16 = 2;
        int r17 = 0;
        float r18 = 0.5f;
    L5:
        center(r10, r12, r13, r14, r15, r16, r17, r18);
        return;
    L4:
        r13 = 2;
        r14 = 0;
        r16 = 1;
        r17 = 0;
        r18 = 0.5f;
        r12 = r11;
        r15 = r11;
        goto L5
    }

    public void centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        Constraint r18 = this.mConstraints.get(Integer.valueOf(r10));
        if (r18 == null) goto L6;
        r18.layout.horizontalBias = r17;
        return;
    }

    public void centerHorizontallyRtl(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r12 = 0;
        int r13 = 6;
        int r14 = 0;
        int r15 = 0;
        int r16 = 7;
        int r17 = 0;
        float r18 = 0.5f;
    L5:
        center(r10, r12, r13, r14, r15, r16, r17, r18);
        return;
    L4:
        r13 = 7;
        r14 = 0;
        r16 = 6;
        r17 = 0;
        r18 = 0.5f;
        r12 = r11;
        r15 = r11;
        goto L5
    }

    public void centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        Constraint r18 = this.mConstraints.get(Integer.valueOf(r10));
        if (r18 == null) goto L6;
        r18.layout.horizontalBias = r17;
        return;
    }

    public void centerVertically(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r12 = 0;
        int r13 = 3;
        int r14 = 0;
        int r15 = 0;
        int r16 = 4;
        int r17 = 0;
        float r18 = 0.5f;
    L5:
        center(r10, r12, r13, r14, r15, r16, r17, r18);
        return;
    L4:
        r13 = 4;
        r14 = 0;
        r16 = 3;
        r17 = 0;
        r18 = 0.5f;
        r12 = r11;
        r15 = r11;
        goto L5
    }

    public void centerVertically(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        Constraint r18 = this.mConstraints.get(Integer.valueOf(r10));
        if (r18 == null) goto L6;
        r18.layout.verticalBias = r17;
        return;
    }

    public void clear(int r10) {
        this.mConstraints.remove(Integer.valueOf(r10));
    }

    public void clear(int r10, int r11) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L20;
        Constraint r12 = this.mConstraints.get(Integer.valueOf(r10));
        if (r12 != null) goto L8;
        return;
    L8:
        switch(r11) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        Layout r13 = r12.layout;
        r13.circleAngle = -1.0f;
        r13.circleRadius = -1;
        r13.circleConstraint = -1;
        return;
    L12:
        Layout r14 = r12.layout;
        r14.endToStart = -1;
        r14.endToEnd = -1;
        r14.endMargin = 0;
        r14.goneEndMargin = Integer.MIN_VALUE;
        return;
    L13:
        Layout r15 = r12.layout;
        r15.startToEnd = -1;
        r15.startToStart = -1;
        r15.startMargin = 0;
        r15.goneStartMargin = Integer.MIN_VALUE;
        return;
    L14:
        Layout r16 = r12.layout;
        r16.baselineToBaseline = -1;
        r16.baselineToTop = -1;
        r16.baselineToBottom = -1;
        r16.baselineMargin = 0;
        r16.goneBaselineMargin = Integer.MIN_VALUE;
        return;
    L15:
        Layout r17 = r12.layout;
        r17.bottomToTop = -1;
        r17.bottomToBottom = -1;
        r17.bottomMargin = 0;
        r17.goneBottomMargin = Integer.MIN_VALUE;
        return;
    L16:
        Layout r18 = r12.layout;
        r18.topToBottom = -1;
        r18.topToTop = -1;
        r18.topMargin = 0;
        r18.goneTopMargin = Integer.MIN_VALUE;
        return;
    L17:
        Layout r19 = r12.layout;
        r19.rightToRight = -1;
        r19.rightToLeft = -1;
        r19.rightMargin = -1;
        r19.goneRightMargin = Integer.MIN_VALUE;
        return;
    L18:
        Layout r20 = r12.layout;
        r20.leftToRight = -1;
        r20.leftToLeft = -1;
        r20.leftMargin = -1;
        r20.goneLeftMargin = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void clone(Context r10, int r11) {
        clone((ConstraintLayout) LayoutInflater.from(r10).inflate(r11, null));
    }

    public void clone(ConstraintLayout r12) {
        int r10 = r12.getChildCount();
        this.mConstraints.clear();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L33;
        View r13 = r12.getChildAt(r11);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.mForceId == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r15), new Constraint());
    L14:
        Constraint r16 = this.mConstraints.get(Integer.valueOf(r15));
        if (r16 == null) goto L32;
        r16.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r13);
        Constraint.access$000(r16, r15, r14);
        r16.propertySet.visibility = r13.getVisibility();
        int r17 = Build.VERSION.SDK_INT;
        if (r17 < 17) goto L30;
        r16.propertySet.alpha = r13.getAlpha();
        r16.transform.rotation = r13.getRotation();
        r16.transform.rotationX = r13.getRotationX();
        r16.transform.rotationY = r13.getRotationY();
        r16.transform.scaleX = r13.getScaleX();
        r16.transform.scaleY = r13.getScaleY();
        float r18 = r13.getPivotX();
        float r19 = r13.getPivotY();
        if (r18 == 0.0d) goto L22;
    L23:
        Transform r20 = r16.transform;
        r20.transformPivotX = r18;
        r20.transformPivotY = r19;
    L24:
        r16.transform.translationX = r13.getTranslationX();
        r16.transform.translationY = r13.getTranslationY();
        if (r17 < 21) goto L30;
        r16.transform.translationZ = r13.getTranslationZ();
        Transform r21 = r16.transform;
        if (r21.applyElevation == false) goto L30;
        r21.elevation = r13.getElevation();
        goto L30
    L22:
        if (r19 == 0.0d) goto L24;
    L30:
        if ((r13 instanceof Barrier) == false) goto L32;
        Barrier r22 = (Barrier) r13;
        r16.layout.mBarrierAllowsGoneWidgets = r22.getAllowsGoneWidget();
        r16.layout.mReferenceIds = r22.getReferencedIds();
        r16.layout.mBarrierDirection = r22.getType();
        r16.layout.mBarrierMargin = r22.getMargin();
    L32:
        r11 = r11 + 1;
        goto L3
    }

    public void clone(ConstraintSet r10) {
        this.mConstraints.clear();
        Iterator<Integer> r11 = r10.mConstraints.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Integer r12 = r11.next();
        Constraint r13 = r10.mConstraints.get(r12);
        if (r13 == null) goto L4;
        this.mConstraints.put(r12, r13.clone());
        goto L4
    }

    public void clone(Constraints r10) {
        int r11 = r10.getChildCount();
        this.mConstraints.clear();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L22;
        View r13 = r10.getChildAt(r12);
        Constraints.LayoutParams r14 = (Constraints.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.mForceId == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r15), new Constraint());
    L14:
        Constraint r16 = this.mConstraints.get(Integer.valueOf(r15));
        if (r16 == null) goto L21;
        if ((r13 instanceof ConstraintHelper) == false) goto L20;
        Constraint.access$700(r16, (ConstraintHelper) r13, r15, r14);
    L20:
        Constraint.access$800(r16, r15, r14);
    L21:
        r12 = r12 + 1;
        goto L3
    }

    public void connect(int r10, int r11, int r12, int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r14 = this.mConstraints.get(Integer.valueOf(r10));
        if (r14 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L53;
            case 2: goto L47;
            case 3: goto L40;
            case 4: goto L34;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        Layout r15 = r14.layout;
        r15.endToEnd = r12;
        r15.endToStart = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        Layout r16 = r14.layout;
        r16.endToStart = r12;
        r16.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        Layout r17 = r14.layout;
        r17.startToStart = r12;
        r17.startToEnd = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        Layout r18 = r14.layout;
        r18.startToEnd = r12;
        r18.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L34:
        if (r13 != 4) goto L36;
        Layout r19 = r14.layout;
        r19.bottomToBottom = r12;
        r19.bottomToTop = -1;
    L42:
        r19.baselineToBaseline = -1;
        r19.baselineToTop = -1;
        r19.baselineToBottom = -1;
        return;
    L36:
        if (r13 != 3) goto L39;
        r19 = r14.layout;
        r19.bottomToTop = r12;
        r19.bottomToBottom = -1;
        goto L42
    L39:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L40:
        if (r13 != 3) goto L43;
        r19 = r14.layout;
        r19.topToTop = r12;
        r19.topToBottom = -1;
        goto L42
    L43:
        if (r13 != 4) goto L46;
        r19 = r14.layout;
        r19.topToBottom = r12;
        r19.topToTop = -1;
        goto L42
    L46:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L47:
        if (r13 != 1) goto L49;
        Layout r20 = r14.layout;
        r20.rightToLeft = r12;
        r20.rightToRight = -1;
        return;
    L49:
        if (r13 != 2) goto L52;
        Layout r21 = r14.layout;
        r21.rightToRight = r12;
        r21.rightToLeft = -1;
        return;
    L52:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L53:
        if (r13 != 1) goto L55;
        Layout r22 = r14.layout;
        r22.leftToLeft = r12;
        r22.leftToRight = -1;
        return;
    L55:
        if (r13 != 2) goto L59;
        Layout r23 = r14.layout;
        r23.leftToRight = r12;
        r23.leftToLeft = -1;
        return;
    L59:
        throw new IllegalArgumentException("left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L28;
        Layout r24 = r14.layout;
        r24.baselineToBaseline = r12;
    L27:
        r24.bottomToBottom = -1;
        r24.bottomToTop = -1;
        r24.topToTop = -1;
        r24.topToBottom = -1;
        return;
    L28:
        if (r13 != 3) goto L30;
        r24 = r14.layout;
        r24.baselineToTop = r12;
        goto L27
    L30:
        if (r13 != 4) goto L33;
        r24 = r14.layout;
        r24.baselineToBottom = r12;
        goto L27
    L33:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void connect(int r10, int r11, int r12, int r13, int r14) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r10));
        if (r15 != null) goto L9;
        return;
    L9:
        switch(r11) {
            case 1: goto L59;
            case 2: goto L52;
            case 3: goto L44;
            case 4: goto L36;
            case 5: goto L27;
            case 6: goto L19;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        if (r13 != 7) goto L14;
        Layout r16 = r15.layout;
        r16.endToEnd = r12;
        r16.endToStart = -1;
    L16:
        r15.layout.endMargin = r14;
        return;
    L14:
        if (r13 != 6) goto L18;
        Layout r17 = r15.layout;
        r17.endToStart = r12;
        r17.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L19:
        if (r13 != 6) goto L21;
        Layout r18 = r15.layout;
        r18.startToStart = r12;
        r18.startToEnd = -1;
    L23:
        r15.layout.startMargin = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        Layout r19 = r15.layout;
        r19.startToEnd = r12;
        r19.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L36:
        if (r13 != 4) goto L39;
        Layout r20 = r15.layout;
        r20.bottomToBottom = r12;
        r20.bottomToTop = -1;
    L38:
        r20.baselineToBaseline = -1;
        r20.baselineToTop = -1;
        r20.baselineToBottom = -1;
        r15.layout.bottomMargin = r14;
        return;
    L39:
        if (r13 != 3) goto L43;
        r20 = r15.layout;
        r20.bottomToTop = r12;
        r20.bottomToBottom = -1;
        goto L38
    L43:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L44:
        if (r13 != 3) goto L47;
        Layout r21 = r15.layout;
        r21.topToTop = r12;
        r21.topToBottom = -1;
    L46:
        r21.baselineToBaseline = -1;
        r21.baselineToTop = -1;
        r21.baselineToBottom = -1;
        r15.layout.topMargin = r14;
        return;
    L47:
        if (r13 != 4) goto L51;
        r21 = r15.layout;
        r21.topToBottom = r12;
        r21.topToTop = -1;
        goto L46
    L51:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L52:
        if (r13 != 1) goto L54;
        Layout r22 = r15.layout;
        r22.rightToLeft = r12;
        r22.rightToRight = -1;
    L56:
        r15.layout.rightMargin = r14;
        return;
    L54:
        if (r13 != 2) goto L58;
        Layout r23 = r15.layout;
        r23.rightToRight = r12;
        r23.rightToLeft = -1;
        goto L56
    L58:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L59:
        if (r13 != 1) goto L61;
        Layout r24 = r15.layout;
        r24.leftToLeft = r12;
        r24.leftToRight = -1;
    L63:
        r15.layout.leftMargin = r14;
        return;
    L61:
        if (r13 != 2) goto L66;
        Layout r25 = r15.layout;
        r25.leftToRight = r12;
        r25.leftToLeft = -1;
        goto L63
    L66:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L27:
        if (r13 != 5) goto L30;
        Layout r26 = r15.layout;
        r26.baselineToBaseline = r12;
    L29:
        r26.bottomToBottom = -1;
        r26.bottomToTop = -1;
        r26.topToTop = -1;
        r26.topToBottom = -1;
        return;
    L30:
        if (r13 != 3) goto L32;
        r26 = r15.layout;
        r26.baselineToTop = r12;
        goto L29
    L32:
        if (r13 != 4) goto L35;
        r26 = r15.layout;
        r26.baselineToBottom = r12;
        goto L29
    L35:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void constrainCircle(int r10, int r11, int r12, float r13) {
        Layout r14 = get(r10).layout;
        r14.circleConstraint = r11;
        r14.circleRadius = r12;
        r14.circleAngle = r13;
    }

    public void constrainDefaultHeight(int r10, int r11) {
        get(r10).layout.heightDefault = r11;
    }

    public void constrainDefaultWidth(int r10, int r11) {
        get(r10).layout.widthDefault = r11;
    }

    public void constrainHeight(int r10, int r11) {
        get(r10).layout.mHeight = r11;
    }

    public void constrainMaxHeight(int r10, int r11) {
        get(r10).layout.heightMax = r11;
    }

    public void constrainMaxWidth(int r10, int r11) {
        get(r10).layout.widthMax = r11;
    }

    public void constrainMinHeight(int r10, int r11) {
        get(r10).layout.heightMin = r11;
    }

    public void constrainMinWidth(int r10, int r11) {
        get(r10).layout.widthMin = r11;
    }

    public void constrainPercentHeight(int r10, float r11) {
        get(r10).layout.heightPercent = r11;
    }

    public void constrainPercentWidth(int r10, float r11) {
        get(r10).layout.widthPercent = r11;
    }

    public void constrainWidth(int r10, int r11) {
        get(r10).layout.mWidth = r11;
    }

    public void constrainedHeight(int r10, boolean r11) {
        get(r10).layout.constrainedHeight = r11;
    }

    public void constrainedWidth(int r10, boolean r11) {
        get(r10).layout.constrainedWidth = r11;
    }

    public void create(int r10, int r11) {
        Layout r12 = get(r10).layout;
        r12.mIsGuideline = true;
        r12.orientation = r11;
    }

    public void createBarrier(int r10, int r11, int r12, int... r13) {
        Layout r14 = get(r10).layout;
        r14.mHelperType = 1;
        r14.mBarrierDirection = r11;
        r14.mBarrierMargin = r12;
        r14.mIsGuideline = false;
        r14.mReferenceIds = r13;
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
        int r11 = r17[r10];
        int r12 = r10 - 1;
        connect(r17[r10], 3, r17[r12], 4, 0);
        connect(r17[r12], 4, r17[r10], 3, 0);
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
        Set<Integer> r12 = this.mConstraints.keySet();
        int r13 = 0;
        if (r11.length == 0) goto L7;
        HashSet r14 = new HashSet();
        int r15 = r11.length;
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L8;
        r14.add(Integer.valueOf(r11[r16]));
        r16 = r16 + 1;
    L8:
        System.out.println(r14.size() + " constraints");
        StringBuilder r17 = new StringBuilder();
        Integer[] r18 = (Integer[]) r14.toArray(new Integer[0]);
        int r19 = r18.length;
    L9:
        if (r13 >= r19) goto L15;
        Integer r20 = r18[r13];
        Constraint r21 = this.mConstraints.get(r20);
        if (r21 == null) goto L14;
        r17.append("<Constraint id=");
        r17.append(r20);
        r17.append(" \n");
        r21.layout.dump(r10, r17);
        r17.append("/>\n");
    L14:
        r13 = r13 + 1;
        goto L9
    L15:
        System.out.println(r17.toString());
        return;
    L7:
        r14 = new HashSet(r12);
        goto L8
    }

    public boolean getApplyElevation(int r10) {
        return get(r10).transform.applyElevation;
    }

    public Constraint getConstraint(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        return null;
    L5:
        return this.mConstraints.get(Integer.valueOf(r10));
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int r10) {
        return get(r10).layout.mHeight;
    }

    public int[] getKnownIds() {
        int r10 = 0;
        Integer[] r11 = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int r12 = r11.length;
        int[] r13 = new int[r12];
    L3:
        if (r10 >= r12) goto L5;
        r13[r10] = r11[r10].intValue();
        r10 = r10 + 1;
        goto L3
    L5:
        return r13;
    }

    public Constraint getParameters(int r10) {
        return get(r10);
    }

    public int[] getReferencedIds(int r10) {
        int[] r11 = get(r10).layout.mReferenceIds;
        if (r11 != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r11, r11.length);
    }

    public int getVisibility(int r10) {
        return get(r10).propertySet.visibility;
    }

    public int getVisibilityMode(int r10) {
        return get(r10).propertySet.mVisibilityMode;
    }

    public int getWidth(int r10) {
        return get(r10).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r13 == 1) goto L30;
        if (r13 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r13 = r12.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r13 != 2) goto L15;
        String r14 = r12.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r15 = fillFromAttributeList(r10, Xml.asAttributeSet(r12), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r14.equalsIgnoreCase("Guideline") == false) goto L13;
        r15.layout.mIsGuideline = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
    L13:
        this.mConstraints.put(Integer.valueOf(r15.mViewId), r15);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L15
    L30:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
    }

    public void load(Context r10, XmlPullParser r11) {
        int r12 = r11.getEventType();     // Catch: IOException -> L96 XmlPullParserException -> L98
        Constraint r13 = null;
    L4:
        if (r12 == 1) goto L121;
        if (r12 == 0) goto L93;
        byte r14 = -1;
        if (r12 == 2) goto L32;
        if (r12 != 3) goto L94;
        String r15 = r11.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L96 XmlPullParserException -> L98
        switch(r15.hashCode()) {
            case -2075718416: goto L23;
            case -190376483: goto L20;
            case 426575017: goto L17;
            case 2146106725: goto L14;
            default: goto L25;
        };     // Catch: IOException -> L96 XmlPullParserException -> L98
    L25:
        if (r14 == 0) goto L31;
        if (r14 == 1) goto L30;
        if (r14 == 2) goto L30;
        if (r14 != 3) goto L94;
    L30:
        this.mConstraints.put(Integer.valueOf(r13.mViewId), r13);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r13 = null;
        goto L94
    L31:
        return;
    L14:
        if (r15.equals("constraintset") == false) goto L25;
        r14 = 0;
        goto L25
    L17:
        if (r15.equals("constraintoverride") == false) goto L25;
        r14 = 2;
        goto L25
    L20:
        if (r15.equals("constraint") == false) goto L25;
        r14 = 1;
        goto L25
    L23:
        if (r15.equals("guideline") == false) goto L25;
        r14 = 3;
    L94:
        r12 = r11.next();     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L4
    L32:
        String r16 = r11.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
        switch(r16.hashCode()) {
            case -2025855158: goto L63;
            case -1984451626: goto L60;
            case -1962203927: goto L57;
            case -1269513683: goto L54;
            case -1238332596: goto L51;
            case -71750448: goto L48;
            case 366511058: goto L45;
            case 1331510167: goto L42;
            case 1791837707: goto L39;
            case 1803088381: goto L36;
            default: goto L66;
        };     // Catch: IOException -> L96 XmlPullParserException -> L98
    L66:
        switch(r14) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L84;
            case 5: goto L80;
            case 6: goto L76;
            case 7: goto L72;
            case 8: goto L68;
            case 9: goto L68;
            default: goto L94;
        };
    L68:
        if (r13 == null) goto L71;
        ConstraintAttribute.parse(r10, r11, r13.mCustomConstraints);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L71:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L72:
        if (r13 == null) goto L75;
        r13.motion.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L75:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L76:
        if (r13 == null) goto L79;
        r13.layout.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L79:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L80:
        if (r13 == null) goto L83;
        r13.transform.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L83:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L84:
        if (r13 == null) goto L87;
        r13.propertySet.fillFromAttributeList(r10, Xml.asAttributeSet(r11));     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L87:
        throw new RuntimeException(ERROR_MESSAGE + r11.getLineNumber());     // Catch: IOException -> L96 XmlPullParserException -> L98
    L88:
        Constraint r17 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        r17.layout.mHelperType = 1;     // Catch: IOException -> L96 XmlPullParserException -> L98
    L92:
        r13 = r17;
        goto L94
    L89:
        r17 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        Layout r18 = r17.layout;     // Catch: IOException -> L96 XmlPullParserException -> L98
        r18.mIsGuideline = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        r18.mApply = true;     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L90:
        r17 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), true);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L91:
        r17 = fillFromAttributeList(r10, Xml.asAttributeSet(r11), false);     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L92
    L36:
        if (r16.equals("Constraint") == false) goto L66;
        r14 = 0;
        goto L66
    L39:
        if (r16.equals(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L66;
        r14 = 8;
        goto L66
    L42:
        if (r16.equals("Barrier") == false) goto L66;
        r14 = 3;
        goto L66
    L45:
        if (r16.equals(ViewTransition.CUSTOM_METHOD) == false) goto L66;
        r14 = 9;
        goto L66
    L48:
        if (r16.equals("Guideline") == false) goto L66;
        r14 = 2;
        goto L66
    L51:
        if (r16.equals("Transform") == false) goto L66;
        r14 = 5;
        goto L66
    L54:
        if (r16.equals("PropertySet") == false) goto L66;
        r14 = 4;
        goto L66
    L57:
        if (r16.equals(ViewTransition.CONSTRAINT_OVERRIDE) == false) goto L66;
        r14 = 1;
        goto L66
    L60:
        if (r16.equals(TypedValues.MotionType.NAME) == false) goto L66;
        r14 = 7;
        goto L66
    L63:
        if (r16.equals("Layout") == false) goto L66;
        r14 = 6;
        goto L66
    L93:
        r11.getName();     // Catch: IOException -> L96 XmlPullParserException -> L98
        goto L94
    L121:
        return;
    L96:
        e = move-exception;
        e.printStackTrace();
        return;
    L98:
        e = move-exception;
        e.printStackTrace();
    }

    public void parseColorAttributes(Constraint r10, String r11) {
        String[] r12 = r11.split(",");
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L10;
        String[] r14 = r12[r13].split("=");
        if (r14.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r12[r13]);
    L9:
        r13 = r13 + 1;
        goto L4
    L8:
        Constraint.access$1000(r10, r14[0], Color.parseColor(r14[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint r10, String r11) {
        String[] r12 = r11.split(",");
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L10;
        String[] r14 = r12[r13].split("=");
        if (r14.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r12[r13]);
    L9:
        r13 = r13 + 1;
        goto L4
    L8:
        Constraint.access$1100(r10, r14[0], Float.parseFloat(r14[1]));
        goto L9
    }

    public void parseIntAttributes(Constraint r10, String r11) {
        String[] r12 = r11.split(",");
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L10;
        String[] r14 = r12[r13].split("=");
        if (r14.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r12[r13]);
    L9:
        r13 = r13 + 1;
        goto L4
    L8:
        Constraint.access$1100(r10, r14[0], Integer.decode(r14[1]).intValue());
        goto L9
    }

    public void parseStringAttributes(Constraint r10, String r11) {
        String[] r12 = splitString(r11);
        int r13 = 0;
    L4:
        if (r13 >= r12.length) goto L6;
        String[] r14 = r12[r13].split("=");
        Log.w(TAG, " Unable to parse " + r12[r13]);
        Constraint.access$1200(r10, r14[0], r14[1]);
        r13 = r13 + 1;
        goto L4
    }

    public void readFallback(ConstraintLayout r12) {
        int r10 = r12.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L43;
        View r13 = r12.getChildAt(r11);
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (this.mForceId == false) goto L12;
        if (r15 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r15)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r15), new Constraint());
    L14:
        Constraint r16 = this.mConstraints.get(Integer.valueOf(r15));
        if (r16 == null) goto L42;
        if (r16.layout.mApply == true) goto L25;
        Constraint.access$000(r16, r15, r14);
        if ((r13 instanceof ConstraintHelper) == false) goto L24;
        r16.layout.mReferenceIds = ((ConstraintHelper) r13).getReferencedIds();
        if ((r13 instanceof Barrier) == false) goto L24;
        Barrier r17 = (Barrier) r13;
        r16.layout.mBarrierAllowsGoneWidgets = r17.getAllowsGoneWidget();
        r16.layout.mBarrierDirection = r17.getType();
        r16.layout.mBarrierMargin = r17.getMargin();
    L24:
        r16.layout.mApply = true;
    L25:
        PropertySet r18 = r16.propertySet;
        if (r18.mApply == true) goto L28;
        r18.visibility = r13.getVisibility();
        r16.propertySet.alpha = r13.getAlpha();
        r16.propertySet.mApply = true;
    L28:
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 17) goto L42;
        Transform r20 = r16.transform;
        if (r20.mApply == true) goto L42;
        r20.mApply = true;
        r20.rotation = r13.getRotation();
        r16.transform.rotationX = r13.getRotationX();
        r16.transform.rotationY = r13.getRotationY();
        r16.transform.scaleX = r13.getScaleX();
        r16.transform.scaleY = r13.getScaleY();
        float r21 = r13.getPivotX();
        float r22 = r13.getPivotY();
        if (r21 == 0.0d) goto L35;
    L36:
        Transform r23 = r16.transform;
        r23.transformPivotX = r21;
        r23.transformPivotY = r22;
    L37:
        r16.transform.translationX = r13.getTranslationX();
        r16.transform.translationY = r13.getTranslationY();
        if (r19 < 21) goto L42;
        r16.transform.translationZ = r13.getTranslationZ();
        Transform r24 = r16.transform;
        if (r24.applyElevation == false) goto L42;
        r24.elevation = r13.getElevation();
        goto L42
    L35:
        if (r22 == 0.0d) goto L37;
    L42:
        r11 = r11 + 1;
        goto L3
    }

    public void readFallback(ConstraintSet r10) {
        Iterator<Integer> r11 = r10.mConstraints.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L29;
        Integer r12 = r11.next();
        int r13 = r12.intValue();
        Constraint r14 = r10.mConstraints.get(r12);
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == true) goto L8;
        this.mConstraints.put(Integer.valueOf(r13), new Constraint());
    L8:
        Constraint r15 = this.mConstraints.get(Integer.valueOf(r13));
        if (r15 == null) goto L4;
        Layout r16 = r15.layout;
        if (r16.mApply == true) goto L14;
        r16.copyFrom(r14.layout);
    L14:
        PropertySet r17 = r15.propertySet;
        if (r17.mApply == true) goto L17;
        r17.copyFrom(r14.propertySet);
    L17:
        Transform r18 = r15.transform;
        if (r18.mApply == true) goto L20;
        r18.copyFrom(r14.transform);
    L20:
        Motion r19 = r15.motion;
        if (r19.mApply == true) goto L23;
        r19.copyFrom(r14.motion);
    L23:
        Iterator<String> r20 = r14.mCustomConstraints.keySet().iterator();
    L25:
        if (r20.hasNext() == false) goto L4;
        String r21 = r20.next();
        if (r15.mCustomConstraints.containsKey(r21) == true) goto L25;
        r15.mCustomConstraints.put(r21, r14.mCustomConstraints.get(r21));
        goto L25
    }

    public void removeAttribute(String r10) {
        this.mSavedAttributes.remove(r10);
    }

    public void removeFromHorizontalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L39;
        Constraint r11 = this.mConstraints.get(Integer.valueOf(r10));
        if (r11 != null) goto L7;
        return;
    L7:
        Layout r12 = r11.layout;
        int r13 = r12.leftToRight;
        int r14 = r12.rightToLeft;
        if (r13 != (-1)) goto L26;
        if (r14 != (-1)) goto L26;
        int r15 = r12.startToEnd;
        int r16 = r12.endToStart;
        if (r15 != (-1)) goto L14;
        if (r16 != (-1)) goto L14;
    L25:
        clear(r10, 6);
        int r17 = 7;
    L37:
        clear(r10, r17);
        return;
    L14:
        if (r15 == (-1)) goto L18;
        if (r16 == (-1)) goto L18;
        int r18 = 0;
        ConstraintSet r19 = this;
        r19.connect(r15, 7, r16, 6, 0);
        int r20 = 6;
        int r21 = 7;
        int r22 = r16;
        int r23 = r13;
    L17:
        r19.connect(r22, r20, r23, r21, r18);
    L18:
        if (r16 == (-1)) goto L25;
        r23 = r12.rightToRight;
        if (r23 == (-1)) goto L22;
        r20 = 7;
        r21 = 7;
        r18 = 0;
        r19 = this;
        r22 = r13;
        goto L17
    L22:
        r23 = r12.leftToLeft;
        if (r23 == (-1)) goto L25;
        r20 = 6;
        r21 = 6;
        r18 = 0;
        r19 = this;
        r22 = r16;
    L26:
        if (r13 == (-1)) goto L29;
        if (r14 == (-1)) goto L29;
        int r24 = 0;
        ConstraintSet r25 = this;
        r25.connect(r13, 2, r14, 1, 0);
        int r26 = 1;
        int r27 = 2;
        int r28 = r14;
        int r29 = r13;
    L32:
        r25.connect(r28, r26, r29, r27, r24);
    L36:
        clear(r10, 1);
        r17 = 2;
    L29:
        r29 = r12.rightToRight;
        if (r29 == (-1)) goto L33;
        r26 = 2;
        r27 = 2;
        r24 = 0;
        r25 = this;
        r28 = r13;
        goto L32
    L33:
        r29 = r12.leftToLeft;
        if (r29 == (-1)) goto L36;
        r26 = 1;
        r27 = 1;
        r24 = 0;
        r25 = this;
        r28 = r14;
        goto L32
    }

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L20;
        Constraint r11 = this.mConstraints.get(Integer.valueOf(r10));
        if (r11 != null) goto L7;
        return;
    L7:
        Layout r12 = r11.layout;
        int r13 = r12.topToBottom;
        int r14 = r12.bottomToTop;
        if (r13 != (-1)) goto L10;
        if (r14 == (-1)) goto L20;
    L10:
        if (r13 == (-1)) goto L13;
        if (r14 == (-1)) goto L13;
        int r15 = 0;
        ConstraintSet r16 = this;
        r16.connect(r13, 4, r14, 3, 0);
        int r17 = 3;
        int r18 = 4;
        int r19 = r14;
        int r20 = r13;
    L16:
        r16.connect(r19, r17, r20, r18, r15);
    L13:
        r20 = r12.bottomToBottom;
        if (r20 == (-1)) goto L17;
        r17 = 4;
        r18 = 4;
        r15 = 0;
        r16 = this;
        r19 = r13;
        goto L16
    L17:
        r20 = r12.topToTop;
        if (r20 == (-1)) goto L20;
        r17 = 3;
        r18 = 3;
        r15 = 0;
        r16 = this;
        r19 = r14;
    L20:
        clear(r10, 3);
        clear(r10, 4);
    }

    public void setAlpha(int r10, float r11) {
        get(r10).propertySet.alpha = r11;
    }

    public void setApplyElevation(int r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r10).transform.applyElevation = r11;
        return;
    }

    public void setBarrierType(int r10, int r11) {
        get(r10).layout.mHelperType = r11;
    }

    public void setColorValue(int r10, String r11, int r12) {
        Constraint.access$1000(get(r10), r11, r12);
    }

    public void setDimensionRatio(int r10, String r11) {
        get(r10).layout.dimensionRatio = r11;
    }

    public void setEditorAbsoluteX(int r10, int r11) {
        get(r10).layout.editorAbsoluteX = r11;
    }

    public void setEditorAbsoluteY(int r10, int r11) {
        get(r10).layout.editorAbsoluteY = r11;
    }

    public void setElevation(int r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r10).transform.elevation = r11;
        get(r10).transform.applyElevation = true;
        return;
    }

    public void setFloatValue(int r10, String r11, float r12) {
        Constraint.access$1100(get(r10), r11, r12);
    }

    public void setForceId(boolean r10) {
        this.mForceId = r10;
    }

    public void setGoneMargin(int r10, int r11, int r12) {
        Constraint r13 = get(r10);
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r13.layout.goneEndMargin = r12;
        return;
    L7:
        r13.layout.goneStartMargin = r12;
        return;
    L8:
        r13.layout.goneBaselineMargin = r12;
        return;
    L9:
        r13.layout.goneBottomMargin = r12;
        return;
    L10:
        r13.layout.goneTopMargin = r12;
        return;
    L11:
        r13.layout.goneRightMargin = r12;
        return;
    L12:
        r13.layout.goneLeftMargin = r12;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setGuidelineBegin(int r10, int r11) {
        get(r10).layout.guideBegin = r11;
        get(r10).layout.guideEnd = -1;
        get(r10).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int r10, int r11) {
        get(r10).layout.guideEnd = r11;
        get(r10).layout.guideBegin = -1;
        get(r10).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int r10, float r11) {
        get(r10).layout.guidePercent = r11;
        get(r10).layout.guideEnd = -1;
        get(r10).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int r10, float r11) {
        get(r10).layout.horizontalBias = r11;
    }

    public void setHorizontalChainStyle(int r10, int r11) {
        get(r10).layout.horizontalChainStyle = r11;
    }

    public void setHorizontalWeight(int r10, float r11) {
        get(r10).layout.horizontalWeight = r11;
    }

    public void setIntValue(int r10, String r11, int r12) {
        Constraint.access$900(get(r10), r11, r12);
    }

    public void setLayoutWrapBehavior(int r10, int r11) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        if (r11 > 3) goto L8;
        get(r10).layout.mWrapBehavior = r11;
        return;
    }

    public void setMargin(int r10, int r11, int r12) {
        Constraint r13 = get(r10);
        switch(r11) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r13.layout.endMargin = r12;
        return;
    L7:
        r13.layout.startMargin = r12;
        return;
    L8:
        r13.layout.baselineMargin = r12;
        return;
    L9:
        r13.layout.bottomMargin = r12;
        return;
    L10:
        r13.layout.topMargin = r12;
        return;
    L11:
        r13.layout.rightMargin = r12;
        return;
    L12:
        r13.layout.leftMargin = r12;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setReferencedIds(int r10, int... r11) {
        get(r10).layout.mReferenceIds = r11;
    }

    public void setRotation(int r10, float r11) {
        get(r10).transform.rotation = r11;
    }

    public void setRotationX(int r10, float r11) {
        get(r10).transform.rotationX = r11;
    }

    public void setRotationY(int r10, float r11) {
        get(r10).transform.rotationY = r11;
    }

    public void setScaleX(int r10, float r11) {
        get(r10).transform.scaleX = r11;
    }

    public void setScaleY(int r10, float r11) {
        get(r10).transform.scaleY = r11;
    }

    public void setStringValue(int r10, String r11, String r12) {
        Constraint.access$1200(get(r10), r11, r12);
    }

    public void setTransformPivot(int r10, float r11, float r12) {
        Transform r13 = get(r10).transform;
        r13.transformPivotY = r12;
        r13.transformPivotX = r11;
    }

    public void setTransformPivotX(int r10, float r11) {
        get(r10).transform.transformPivotX = r11;
    }

    public void setTransformPivotY(int r10, float r11) {
        get(r10).transform.transformPivotY = r11;
    }

    public void setTranslation(int r10, float r11, float r12) {
        Transform r13 = get(r10).transform;
        r13.translationX = r11;
        r13.translationY = r12;
    }

    public void setTranslationX(int r10, float r11) {
        get(r10).transform.translationX = r11;
    }

    public void setTranslationY(int r10, float r11) {
        get(r10).transform.translationY = r11;
    }

    public void setTranslationZ(int r10, float r11) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r10).transform.translationZ = r11;
        return;
    }

    public void setValidateOnParse(boolean r10) {
        this.mValidate = r10;
    }

    public void setVerticalBias(int r10, float r11) {
        get(r10).layout.verticalBias = r11;
    }

    public void setVerticalChainStyle(int r10, int r11) {
        get(r10).layout.verticalChainStyle = r11;
    }

    public void setVerticalWeight(int r10, float r11) {
        get(r10).layout.verticalWeight = r11;
    }

    public void setVisibility(int r10, int r11) {
        get(r10).propertySet.visibility = r11;
    }

    public void setVisibilityMode(int r10, int r11) {
        get(r10).propertySet.mVisibilityMode = r11;
    }

    public void writeState(Writer r10, ConstraintLayout r11, int r12) {
        r10.write("\n---------------------------------------------\n");
        if ((r12 & 1) != 1) goto L5;
        new WriteXmlEngine(this, r10, r11, r12).writeLayout();
    L6:
        r10.write("\n---------------------------------------------\n");
        return;
    L5:
        new WriteJsonEngine(this, r10, r11, r12).writeLayout();
        goto L6
    }
}
