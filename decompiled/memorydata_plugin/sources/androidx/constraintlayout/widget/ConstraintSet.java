package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.tom_roush.pdfbox.pdmodel.a.d.d;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import org.apache.logging.log4j.message.ParameterizedMessage;
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

            void add(int r4, float r5) {
                int r0 = this.mCountFloat;
                int[] r1 = this.mTypeFloat;
                if (r0 < r1.length) goto L5;
                this.mTypeFloat = Arrays.copyOf(r1, r1.length * 2);
                float[] r2 = this.mValueFloat;
                this.mValueFloat = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeFloat;
                int r6 = this.mCountFloat;
                r3[r6] = r4;
                float[] r7 = this.mValueFloat;
                this.mCountFloat = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, int r5) {
                int r0 = this.mCountInt;
                int[] r1 = this.mTypeInt;
                if (r0 < r1.length) goto L5;
                this.mTypeInt = Arrays.copyOf(r1, r1.length * 2);
                int[] r2 = this.mValueInt;
                this.mValueInt = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeInt;
                int r6 = this.mCountInt;
                r3[r6] = r4;
                int[] r7 = this.mValueInt;
                this.mCountInt = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, String r5) {
                int r0 = this.mCountString;
                int[] r1 = this.mTypeString;
                if (r0 < r1.length) goto L5;
                this.mTypeString = Arrays.copyOf(r1, r1.length * 2);
                String[] r2 = this.mValueString;
                this.mValueString = (String[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r2, r2.length * 2), String[].class, "com.obric.memorydata.plugin");
            L5:
                int[] r3 = this.mTypeString;
                int r6 = this.mCountString;
                r3[r6] = r4;
                String[] r7 = this.mValueString;
                this.mCountString = r6 + 1;
                r7[r6] = r5;
            }

            void add(int r4, boolean r5) {
                int r0 = this.mCountBoolean;
                int[] r1 = this.mTypeBoolean;
                if (r0 < r1.length) goto L5;
                this.mTypeBoolean = Arrays.copyOf(r1, r1.length * 2);
                boolean[] r2 = this.mValueBoolean;
                this.mValueBoolean = Arrays.copyOf(r2, r2.length * 2);
            L5:
                int[] r3 = this.mTypeBoolean;
                int r6 = this.mCountBoolean;
                r3[r6] = r4;
                boolean[] r7 = this.mValueBoolean;
                this.mCountBoolean = r6 + 1;
                r7[r6] = r5;
            }

            void applyDelta(Constraint r5) {
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                ConstraintSet.access$300(r5, this.mTypeInt[r1], this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                ConstraintSet.access$400(r5, this.mTypeFloat[r2], this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L15;
                ConstraintSet.access$500(r5, this.mTypeString[r3], this.mValueString[r3]);
                r3 = r3 + 1;
            L15:
                if (r0 >= this.mCountBoolean) goto L17;
                ConstraintSet.access$600(r5, this.mTypeBoolean[r0], this.mValueBoolean[r0]);
                r0 = r0 + 1;
                goto L15
            }

            void printDelta(String r6) {
                Log.v(r6, "int");
                int r0 = 0;
                int r1 = 0;
            L4:
                if (r1 >= this.mCountInt) goto L6;
                Log.v(r6, this.mTypeInt[r1] + " = " + this.mValueInt[r1]);
                r1 = r1 + 1;
                goto L4
            L6:
                Log.v(r6, TypedValues.Custom.S_FLOAT);
                int r2 = 0;
            L8:
                if (r2 >= this.mCountFloat) goto L10;
                Log.v(r6, this.mTypeFloat[r2] + " = " + this.mValueFloat[r2]);
                r2 = r2 + 1;
                goto L8
            L10:
                Log.v(r6, "strings");
                int r3 = 0;
            L12:
                if (r3 >= this.mCountString) goto L14;
                Log.v(r6, this.mTypeString[r3] + " = " + this.mValueString[r3]);
                r3 = r3 + 1;
                goto L12
            L14:
                Log.v(r6, TypedValues.Custom.S_BOOLEAN);
            L16:
                if (r0 >= this.mCountBoolean) goto L18;
                Log.v(r6, this.mTypeBoolean[r0] + " = " + this.mValueBoolean[r0]);
                r0 = r0 + 1;
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

        static /* synthetic */ void access$000(Constraint r0, int r1, ConstraintLayout.LayoutParams r2) {
            r0.fillFrom(r1, r2);
        }

        static /* synthetic */ void access$1000(Constraint r0, String r1, int r2) {
            r0.setColorValue(r1, r2);
        }

        static /* synthetic */ void access$1100(Constraint r0, String r1, float r2) {
            r0.setFloatValue(r1, r2);
        }

        static /* synthetic */ void access$1200(Constraint r0, String r1, String r2) {
            r0.setStringValue(r1, r2);
        }

        static /* synthetic */ void access$700(Constraint r0, ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            r0.fillFromConstraints(r1, r2, r3);
        }

        static /* synthetic */ void access$800(Constraint r0, int r1, Constraints.LayoutParams r2) {
            r0.fillFromConstraints(r1, r2);
        }

        static /* synthetic */ void access$900(Constraint r0, String r1, int r2) {
            r0.setIntValue(r1, r2);
        }

        private void fillFrom(int r2, ConstraintLayout.LayoutParams r3) {
            this.mViewId = r2;
            Layout r4 = this.layout;
            r4.leftToLeft = r3.leftToLeft;
            Layout r5 = this.layout;
            r5.leftToRight = r3.leftToRight;
            Layout r6 = this.layout;
            r6.rightToLeft = r3.rightToLeft;
            Layout r7 = this.layout;
            r7.rightToRight = r3.rightToRight;
            Layout r8 = this.layout;
            r8.topToTop = r3.topToTop;
            Layout r9 = this.layout;
            r9.topToBottom = r3.topToBottom;
            Layout r10 = this.layout;
            r10.bottomToTop = r3.bottomToTop;
            Layout r11 = this.layout;
            r11.bottomToBottom = r3.bottomToBottom;
            Layout r12 = this.layout;
            r12.baselineToBaseline = r3.baselineToBaseline;
            Layout r13 = this.layout;
            r13.baselineToTop = r3.baselineToTop;
            Layout r14 = this.layout;
            r14.baselineToBottom = r3.baselineToBottom;
            Layout r15 = this.layout;
            r15.startToEnd = r3.startToEnd;
            Layout r16 = this.layout;
            r16.startToStart = r3.startToStart;
            Layout r17 = this.layout;
            r17.endToStart = r3.endToStart;
            Layout r18 = this.layout;
            r18.endToEnd = r3.endToEnd;
            Layout r19 = this.layout;
            r19.horizontalBias = r3.horizontalBias;
            Layout r20 = this.layout;
            r20.verticalBias = r3.verticalBias;
            Layout r21 = this.layout;
            r21.dimensionRatio = r3.dimensionRatio;
            Layout r22 = this.layout;
            r22.circleConstraint = r3.circleConstraint;
            Layout r23 = this.layout;
            r23.circleRadius = r3.circleRadius;
            Layout r24 = this.layout;
            r24.circleAngle = r3.circleAngle;
            Layout r25 = this.layout;
            r25.editorAbsoluteX = r3.editorAbsoluteX;
            Layout r26 = this.layout;
            r26.editorAbsoluteY = r3.editorAbsoluteY;
            Layout r27 = this.layout;
            r27.orientation = r3.orientation;
            Layout r28 = this.layout;
            r28.guidePercent = r3.guidePercent;
            Layout r29 = this.layout;
            r29.guideBegin = r3.guideBegin;
            Layout r30 = this.layout;
            r30.guideEnd = r3.guideEnd;
            Layout r31 = this.layout;
            r31.mWidth = r3.width;
            Layout r32 = this.layout;
            r32.mHeight = r3.height;
            Layout r33 = this.layout;
            r33.leftMargin = r3.leftMargin;
            Layout r34 = this.layout;
            r34.rightMargin = r3.rightMargin;
            Layout r35 = this.layout;
            r35.topMargin = r3.topMargin;
            Layout r36 = this.layout;
            r36.bottomMargin = r3.bottomMargin;
            Layout r37 = this.layout;
            r37.baselineMargin = r3.baselineMargin;
            Layout r38 = this.layout;
            r38.verticalWeight = r3.verticalWeight;
            Layout r39 = this.layout;
            r39.horizontalWeight = r3.horizontalWeight;
            Layout r40 = this.layout;
            r40.verticalChainStyle = r3.verticalChainStyle;
            Layout r41 = this.layout;
            r41.horizontalChainStyle = r3.horizontalChainStyle;
            Layout r42 = this.layout;
            r42.constrainedWidth = r3.constrainedWidth;
            Layout r43 = this.layout;
            r43.constrainedHeight = r3.constrainedHeight;
            Layout r44 = this.layout;
            r44.widthDefault = r3.matchConstraintDefaultWidth;
            Layout r45 = this.layout;
            r45.heightDefault = r3.matchConstraintDefaultHeight;
            Layout r46 = this.layout;
            r46.widthMax = r3.matchConstraintMaxWidth;
            Layout r47 = this.layout;
            r47.heightMax = r3.matchConstraintMaxHeight;
            Layout r48 = this.layout;
            r48.widthMin = r3.matchConstraintMinWidth;
            Layout r49 = this.layout;
            r49.heightMin = r3.matchConstraintMinHeight;
            Layout r50 = this.layout;
            r50.widthPercent = r3.matchConstraintPercentWidth;
            Layout r51 = this.layout;
            r51.heightPercent = r3.matchConstraintPercentHeight;
            Layout r52 = this.layout;
            r52.mConstraintTag = r3.constraintTag;
            Layout r53 = this.layout;
            r53.goneTopMargin = r3.goneTopMargin;
            Layout r54 = this.layout;
            r54.goneBottomMargin = r3.goneBottomMargin;
            Layout r55 = this.layout;
            r55.goneLeftMargin = r3.goneLeftMargin;
            Layout r56 = this.layout;
            r56.goneRightMargin = r3.goneRightMargin;
            Layout r57 = this.layout;
            r57.goneStartMargin = r3.goneStartMargin;
            Layout r58 = this.layout;
            r58.goneEndMargin = r3.goneEndMargin;
            Layout r59 = this.layout;
            r59.goneBaselineMargin = r3.goneBaselineMargin;
            Layout r60 = this.layout;
            r60.mWrapBehavior = r3.wrapBehaviorInParent;
            if (Build.VERSION.SDK_INT < 17) goto L6;
            Layout r61 = this.layout;
            r61.endMargin = r3.getMarginEnd();
            Layout r1 = this.layout;
            r1.startMargin = r3.getMarginStart();
            return;
        }

        private void fillFromConstraints(int r2, Constraints.LayoutParams r3) {
            fillFrom(r2, r3);
            PropertySet r4 = this.propertySet;
            r4.alpha = r3.alpha;
            Transform r5 = this.transform;
            r5.rotation = r3.rotation;
            Transform r6 = this.transform;
            r6.rotationX = r3.rotationX;
            Transform r7 = this.transform;
            r7.rotationY = r3.rotationY;
            Transform r8 = this.transform;
            r8.scaleX = r3.scaleX;
            Transform r9 = this.transform;
            r9.scaleY = r3.scaleY;
            Transform r10 = this.transform;
            r10.transformPivotX = r3.transformPivotX;
            Transform r11 = this.transform;
            r11.transformPivotY = r3.transformPivotY;
            Transform r12 = this.transform;
            r12.translationX = r3.translationX;
            Transform r13 = this.transform;
            r13.translationY = r3.translationY;
            Transform r14 = this.transform;
            r14.translationZ = r3.translationZ;
            Transform r15 = this.transform;
            r15.elevation = r3.elevation;
            Transform r1 = this.transform;
            r1.applyElevation = r3.applyElevation;
        }

        private void fillFromConstraints(ConstraintHelper r1, int r2, Constraints.LayoutParams r3) {
            fillFromConstraints(r2, r3);
            if (ZeusTransformUtils.instanceOf(r1, Barrier.class) == false) goto L6;
            this.layout.mHelperType = 1;
            Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r1, Barrier.class, "com.obric.memorydata.plugin");
            Layout r5 = this.layout;
            r5.mBarrierDirection = r4.getType();
            Layout r6 = this.layout;
            r6.mReferenceIds = r4.getReferencedIds();
            Layout r0 = this.layout;
            r0.mBarrierMargin = r4.getMargin();
            return;
        }

        private ConstraintAttribute get(String r2, ConstraintAttribute.AttributeType r3) {
            if (this.mCustomConstraints.containsKey(r2) == false) goto L9;
            ConstraintAttribute r1 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.mCustomConstraints.get(r2), ConstraintAttribute.class, "com.obric.memorydata.plugin");
            if (r1.getType() != r3) goto L8;
            return r1;
        L8:
            throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
        L9:
            ConstraintAttribute r0 = new ConstraintAttribute(r2, r3);
            this.mCustomConstraints.put(r2, r0);
            return r0;
        }

        private void setColorValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(r3);
        }

        private void setFloatValue(String r2, float r3) {
            get(r2, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(r3);
        }

        private void setIntValue(String r2, int r3) {
            get(r2, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(r3);
        }

        private void setStringValue(String r2, String r3) {
            get(r2, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(r3);
        }

        public void applyDelta(Constraint r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L6;
            r0.applyDelta(r1);
            return;
        }

        public void applyTo(ConstraintLayout.LayoutParams r3) {
            r3.leftToLeft = this.layout.leftToLeft;
            r3.leftToRight = this.layout.leftToRight;
            r3.rightToLeft = this.layout.rightToLeft;
            r3.rightToRight = this.layout.rightToRight;
            r3.topToTop = this.layout.topToTop;
            r3.topToBottom = this.layout.topToBottom;
            r3.bottomToTop = this.layout.bottomToTop;
            r3.bottomToBottom = this.layout.bottomToBottom;
            r3.baselineToBaseline = this.layout.baselineToBaseline;
            r3.baselineToTop = this.layout.baselineToTop;
            r3.baselineToBottom = this.layout.baselineToBottom;
            r3.startToEnd = this.layout.startToEnd;
            r3.startToStart = this.layout.startToStart;
            r3.endToStart = this.layout.endToStart;
            r3.endToEnd = this.layout.endToEnd;
            r3.leftMargin = this.layout.leftMargin;
            r3.rightMargin = this.layout.rightMargin;
            r3.topMargin = this.layout.topMargin;
            r3.bottomMargin = this.layout.bottomMargin;
            r3.goneStartMargin = this.layout.goneStartMargin;
            r3.goneEndMargin = this.layout.goneEndMargin;
            r3.goneTopMargin = this.layout.goneTopMargin;
            r3.goneBottomMargin = this.layout.goneBottomMargin;
            r3.horizontalBias = this.layout.horizontalBias;
            r3.verticalBias = this.layout.verticalBias;
            r3.circleConstraint = this.layout.circleConstraint;
            r3.circleRadius = this.layout.circleRadius;
            r3.circleAngle = this.layout.circleAngle;
            r3.dimensionRatio = this.layout.dimensionRatio;
            r3.editorAbsoluteX = this.layout.editorAbsoluteX;
            r3.editorAbsoluteY = this.layout.editorAbsoluteY;
            r3.verticalWeight = this.layout.verticalWeight;
            r3.horizontalWeight = this.layout.horizontalWeight;
            r3.verticalChainStyle = this.layout.verticalChainStyle;
            r3.horizontalChainStyle = this.layout.horizontalChainStyle;
            r3.constrainedWidth = this.layout.constrainedWidth;
            r3.constrainedHeight = this.layout.constrainedHeight;
            r3.matchConstraintDefaultWidth = this.layout.widthDefault;
            r3.matchConstraintDefaultHeight = this.layout.heightDefault;
            r3.matchConstraintMaxWidth = this.layout.widthMax;
            r3.matchConstraintMaxHeight = this.layout.heightMax;
            r3.matchConstraintMinWidth = this.layout.widthMin;
            r3.matchConstraintMinHeight = this.layout.heightMin;
            r3.matchConstraintPercentWidth = this.layout.widthPercent;
            r3.matchConstraintPercentHeight = this.layout.heightPercent;
            r3.orientation = this.layout.orientation;
            r3.guidePercent = this.layout.guidePercent;
            r3.guideBegin = this.layout.guideBegin;
            r3.guideEnd = this.layout.guideEnd;
            r3.width = this.layout.mWidth;
            r3.height = this.layout.mHeight;
            if (this.layout.mConstraintTag == null) goto L5;
            r3.constraintTag = this.layout.mConstraintTag;
        L5:
            r3.wrapBehaviorInParent = this.layout.mWrapBehavior;
            if (Build.VERSION.SDK_INT < 17) goto L8;
            r3.setMarginStart(this.layout.startMargin);
            r3.setMarginEnd(this.layout.endMargin);
        L8:
            r3.validate();
        }

        public Constraint clone() {
            Constraint r0 = new Constraint();
            r0.layout.copyFrom(this.layout);
            r0.motion.copyFrom(this.motion);
            r0.propertySet.copyFrom(this.propertySet);
            r0.transform.copyFrom(this.transform);
            r0.mViewId = this.mViewId;
            r0.mDelta = this.mDelta;
            return r0;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m38clone() {
            return clone();
        }

        public void printDelta(String r1) {
            Delta r0 = this.mDelta;
            if (r0 == null) goto L5;
            r0.printDelta(r1);
            return;
        L5:
            Log.v(r1, "DELTA IS NULL");
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
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toLeftOf, "styleable", "Layout_layout_constraintLeft_toLeftOf"), 24);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_toRightOf, "styleable", "Layout_layout_constraintLeft_toRightOf"), 25);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toLeftOf, "styleable", "Layout_layout_constraintRight_toLeftOf"), 28);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_toRightOf, "styleable", "Layout_layout_constraintRight_toRightOf"), 29);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toTopOf, "styleable", "Layout_layout_constraintTop_toTopOf"), 35);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_toBottomOf, "styleable", "Layout_layout_constraintTop_toBottomOf"), 34);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toTopOf, "styleable", "Layout_layout_constraintBottom_toTopOf"), 4);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_toBottomOf, "styleable", "Layout_layout_constraintBottom_toBottomOf"), 3);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, "styleable", "Layout_layout_constraintBaseline_toBaselineOf"), 1);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteX, "styleable", "Layout_layout_editor_absoluteX"), 6);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_editor_absoluteY, "styleable", "Layout_layout_editor_absoluteY"), 7);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_begin, "styleable", "Layout_layout_constraintGuide_begin"), 17);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_end, "styleable", "Layout_layout_constraintGuide_end"), 18);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintGuide_percent, "styleable", "Layout_layout_constraintGuide_percent"), 19);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_guidelineUseRtl, "styleable", "Layout_guidelineUseRtl"), 90);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_orientation, "styleable", "Layout_android_orientation"), 26);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toEndOf, "styleable", "Layout_layout_constraintStart_toEndOf"), 31);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintStart_toStartOf, "styleable", "Layout_layout_constraintStart_toStartOf"), 32);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toStartOf, "styleable", "Layout_layout_constraintEnd_toStartOf"), 10);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintEnd_toEndOf, "styleable", "Layout_layout_constraintEnd_toEndOf"), 9);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginLeft, "styleable", "Layout_layout_goneMarginLeft"), 13);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginTop, "styleable", "Layout_layout_goneMarginTop"), 16);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginRight, "styleable", "Layout_layout_goneMarginRight"), 14);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginBottom, "styleable", "Layout_layout_goneMarginBottom"), 11);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginStart, "styleable", "Layout_layout_goneMarginStart"), 15);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_goneMarginEnd, "styleable", "Layout_layout_goneMarginEnd"), 12);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_weight, "styleable", "Layout_layout_constraintVertical_weight"), 38);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_weight, "styleable", "Layout_layout_constraintHorizontal_weight"), 37);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_chainStyle, "styleable", "Layout_layout_constraintHorizontal_chainStyle"), 39);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_chainStyle, "styleable", "Layout_layout_constraintVertical_chainStyle"), 40);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHorizontal_bias, "styleable", "Layout_layout_constraintHorizontal_bias"), 20);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintVertical_bias, "styleable", "Layout_layout_constraintVertical_bias"), 36);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintDimensionRatio, "styleable", "Layout_layout_constraintDimensionRatio"), 5);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintLeft_creator, "styleable", "Layout_layout_constraintLeft_creator"), UNUSED);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintTop_creator, "styleable", "Layout_layout_constraintTop_creator"), UNUSED);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintRight_creator, "styleable", "Layout_layout_constraintRight_creator"), UNUSED);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBottom_creator, "styleable", "Layout_layout_constraintBottom_creator"), UNUSED);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintBaseline_creator, "styleable", "Layout_layout_constraintBaseline_creator"), UNUSED);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginLeft, "styleable", "Layout_android_layout_marginLeft"), 23);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginRight, "styleable", "Layout_android_layout_marginRight"), 27);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginStart, "styleable", "Layout_android_layout_marginStart"), 30);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginEnd, "styleable", "Layout_android_layout_marginEnd"), 8);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginTop, "styleable", "Layout_android_layout_marginTop"), 33);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_marginBottom, "styleable", "Layout_android_layout_marginBottom"), 2);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_width, "styleable", "Layout_android_layout_width"), 22);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_android_layout_height, "styleable", "Layout_android_layout_height"), 21);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth, "styleable", "Layout_layout_constraintWidth"), 41);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight, "styleable", "Layout_layout_constraintHeight"), 42);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedWidth, "styleable", "Layout_layout_constrainedWidth"), 41);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constrainedHeight, "styleable", "Layout_layout_constrainedHeight"), 42);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_wrapBehaviorInParent, "styleable", "Layout_layout_wrapBehaviorInParent"), 76);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircle, "styleable", "Layout_layout_constraintCircle"), 61);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleRadius, "styleable", "Layout_layout_constraintCircleRadius"), 62);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintCircleAngle, "styleable", "Layout_layout_constraintCircleAngle"), 63);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintWidth_percent, "styleable", "Layout_layout_constraintWidth_percent"), 69);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_layout_constraintHeight_percent, "styleable", "Layout_layout_constraintHeight_percent"), 70);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_chainUseRtl, "styleable", "Layout_chainUseRtl"), 71);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierDirection, "styleable", "Layout_barrierDirection"), BARRIER_DIRECTION);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierMargin, "styleable", "Layout_barrierMargin"), BARRIER_MARGIN);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_constraint_referenced_ids, "styleable", "Layout_constraint_referenced_ids"), 74);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Layout_barrierAllowsGoneWidgets, "styleable", "Layout_barrierAllowsGoneWidgets"), 75);
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

        public void copyFrom(Layout r3) {
            this.mIsGuideline = r3.mIsGuideline;
            this.mWidth = r3.mWidth;
            this.mApply = r3.mApply;
            this.mHeight = r3.mHeight;
            this.guideBegin = r3.guideBegin;
            this.guideEnd = r3.guideEnd;
            this.guidePercent = r3.guidePercent;
            this.guidelineUseRtl = r3.guidelineUseRtl;
            this.leftToLeft = r3.leftToLeft;
            this.leftToRight = r3.leftToRight;
            this.rightToLeft = r3.rightToLeft;
            this.rightToRight = r3.rightToRight;
            this.topToTop = r3.topToTop;
            this.topToBottom = r3.topToBottom;
            this.bottomToTop = r3.bottomToTop;
            this.bottomToBottom = r3.bottomToBottom;
            this.baselineToBaseline = r3.baselineToBaseline;
            this.baselineToTop = r3.baselineToTop;
            this.baselineToBottom = r3.baselineToBottom;
            this.startToEnd = r3.startToEnd;
            this.startToStart = r3.startToStart;
            this.endToStart = r3.endToStart;
            this.endToEnd = r3.endToEnd;
            this.horizontalBias = r3.horizontalBias;
            this.verticalBias = r3.verticalBias;
            this.dimensionRatio = r3.dimensionRatio;
            this.circleConstraint = r3.circleConstraint;
            this.circleRadius = r3.circleRadius;
            this.circleAngle = r3.circleAngle;
            this.editorAbsoluteX = r3.editorAbsoluteX;
            this.editorAbsoluteY = r3.editorAbsoluteY;
            this.orientation = r3.orientation;
            this.leftMargin = r3.leftMargin;
            this.rightMargin = r3.rightMargin;
            this.topMargin = r3.topMargin;
            this.bottomMargin = r3.bottomMargin;
            this.endMargin = r3.endMargin;
            this.startMargin = r3.startMargin;
            this.baselineMargin = r3.baselineMargin;
            this.goneLeftMargin = r3.goneLeftMargin;
            this.goneTopMargin = r3.goneTopMargin;
            this.goneRightMargin = r3.goneRightMargin;
            this.goneBottomMargin = r3.goneBottomMargin;
            this.goneEndMargin = r3.goneEndMargin;
            this.goneStartMargin = r3.goneStartMargin;
            this.goneBaselineMargin = r3.goneBaselineMargin;
            this.verticalWeight = r3.verticalWeight;
            this.horizontalWeight = r3.horizontalWeight;
            this.horizontalChainStyle = r3.horizontalChainStyle;
            this.verticalChainStyle = r3.verticalChainStyle;
            this.widthDefault = r3.widthDefault;
            this.heightDefault = r3.heightDefault;
            this.widthMax = r3.widthMax;
            this.heightMax = r3.heightMax;
            this.widthMin = r3.widthMin;
            this.heightMin = r3.heightMin;
            this.widthPercent = r3.widthPercent;
            this.heightPercent = r3.heightPercent;
            this.mBarrierDirection = r3.mBarrierDirection;
            this.mBarrierMargin = r3.mBarrierMargin;
            this.mHelperType = r3.mHelperType;
            this.mConstraintTag = r3.mConstraintTag;
            int[] r0 = r3.mReferenceIds;
            if (r0 != null) goto L5;
        L7:
            this.mReferenceIds = null;
        L8:
            this.mReferenceIdString = r3.mReferenceIdString;
            this.constrainedWidth = r3.constrainedWidth;
            this.constrainedHeight = r3.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = r3.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = r3.mWrapBehavior;
            return;
        L5:
            if (r3.mReferenceIdString != null) goto L7;
            this.mReferenceIds = Arrays.copyOf(r0, r0.length);
            goto L8
        }

        public void dump(MotionScene r11, StringBuilder r12) {
            Field[] r0 = getClass().getDeclaredFields();
            r12.append("\n");
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L28;
            Field r2 = r0[r1];
            String r3 = r2.getName();
            if (Modifier.isStatic(r2.getModifiers()) == true) goto L27;
            Object r4 = r2.get(this);     // Catch: IllegalAccessException -> L25
            Class<?> r5 = r2.getType();     // Catch: IllegalAccessException -> L25
            if (r5 != Integer.TYPE) goto L20;
            Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L25
            if (r6.intValue() == (-1)) goto L27;
            Object r7 = r11.lookUpConstraintName(r6.intValue());     // Catch: IllegalAccessException -> L25
            r12.append("    ");     // Catch: IllegalAccessException -> L25
            r12.append(r3);     // Catch: IllegalAccessException -> L25
            r12.append(" = \"");     // Catch: IllegalAccessException -> L25
            if (r7 != null) goto L16;
            Object r8 = r6;
        L17:
            r12.append(r8);     // Catch: IllegalAccessException -> L25
        L18:
            r12.append("\"\n");     // Catch: IllegalAccessException -> L25
            goto L27
        L16:
            r8 = r7;
            goto L17
        L20:
            if (r5 != Float.TYPE) goto L27;
            Float r9 = (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin");     // Catch: IllegalAccessException -> L25
            if (r9.floatValue() == (-1.0f)) goto L27;
            r12.append("    ");     // Catch: IllegalAccessException -> L25
            r12.append(r3);     // Catch: IllegalAccessException -> L25
            r12.append(" = \"");     // Catch: IllegalAccessException -> L25
            r12.append(r9);     // Catch: IllegalAccessException -> L25
        L25:
            e = move-exception;
            e.printStackTrace();
        L27:
            r1 = r1 + 1;
            goto L4
        }

        void fillFromAttributeList(Context r9, AttributeSet r10) {
            TypedArray r11 = ((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Layout);
            this.mApply = true;
            int r0 = r11.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L84;
            int r3 = r11.getIndex(r2);
            int r4 = mapToConstant.get(r3);
            switch(r4) {
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
            switch(r4) {
                case 61: goto L36;
                case 62: goto L35;
                case 63: goto L34;
                default: goto L8;
            };
        L34:
            this.circleAngle = r11.getFloat(r3, this.circleAngle);
        L83:
            r2 = r2 + 1;
            goto L3
        L35:
            this.circleRadius = r11.getDimensionPixelSize(r3, this.circleRadius);
            goto L83
        L36:
            this.circleConstraint = ConstraintSet.access$100(r11, r3, this.circleConstraint);
            goto L83
        L8:
            switch(r4) {
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
            StringBuilder r5 = new StringBuilder();
            String r6 = "Unknown attribute 0x";
        L10:
            Log.w(ConstraintSet.TAG, r5.append(r6).append(Integer.toHexString(r3)).append("   ").append(mapToConstant.get(r3)).toString());
            goto L83
        L11:
            r5 = new StringBuilder();
            r6 = "unused attribute 0x";
            goto L10
        L12:
            this.guidelineUseRtl = r11.getBoolean(r3, this.guidelineUseRtl);
            goto L83
        L13:
            this.mConstraintTag = r11.getString(r3);
            goto L83
        L14:
            this.constrainedHeight = r11.getBoolean(r3, this.constrainedHeight);
            goto L83
        L15:
            this.constrainedWidth = r11.getBoolean(r3, this.constrainedWidth);
            goto L83
        L16:
            this.widthMin = r11.getDimensionPixelSize(r3, this.widthMin);
            goto L83
        L17:
            this.heightMin = r11.getDimensionPixelSize(r3, this.heightMin);
            goto L83
        L18:
            this.widthMax = r11.getDimensionPixelSize(r3, this.widthMax);
            goto L83
        L19:
            this.heightMax = r11.getDimensionPixelSize(r3, this.heightMax);
            goto L83
        L20:
            this.heightDefault = r11.getInt(r3, this.heightDefault);
            goto L83
        L21:
            this.widthDefault = r11.getInt(r3, this.widthDefault);
            goto L83
        L22:
            this.baselineMargin = r11.getDimensionPixelSize(r3, this.baselineMargin);
            goto L83
        L23:
            this.goneBaselineMargin = r11.getDimensionPixelSize(r3, this.goneBaselineMargin);
            goto L83
        L24:
            this.baselineToBottom = ConstraintSet.access$100(r11, r3, this.baselineToBottom);
            goto L83
        L25:
            this.baselineToTop = ConstraintSet.access$100(r11, r3, this.baselineToTop);
            goto L83
        L26:
            this.mWrapBehavior = r11.getInt(r3, this.mWrapBehavior);
            goto L83
        L27:
            this.mBarrierAllowsGoneWidgets = r11.getBoolean(r3, this.mBarrierAllowsGoneWidgets);
            goto L83
        L28:
            this.mReferenceIdString = r11.getString(r3);
            goto L83
        L29:
            this.mBarrierMargin = r11.getDimensionPixelSize(r3, this.mBarrierMargin);
            goto L83
        L30:
            this.mBarrierDirection = r11.getInt(r3, this.mBarrierDirection);
            goto L83
        L31:
            Log.e(ConstraintSet.TAG, "CURRENTLY UNSUPPORTED");
            goto L83
        L32:
            this.heightPercent = r11.getFloat(r3, 1.0f);
            goto L83
        L33:
            this.widthPercent = r11.getFloat(r3, 1.0f);
            goto L83
        L37:
            ConstraintSet.parseDimensionConstraints(this, r11, r3, 1);
            goto L83
        L38:
            ConstraintSet.parseDimensionConstraints(this, r11, r3, 0);
            goto L83
        L39:
            this.verticalChainStyle = r11.getInt(r3, this.verticalChainStyle);
            goto L83
        L40:
            this.horizontalChainStyle = r11.getInt(r3, this.horizontalChainStyle);
            goto L83
        L41:
            this.verticalWeight = r11.getFloat(r3, this.verticalWeight);
            goto L83
        L42:
            this.horizontalWeight = r11.getFloat(r3, this.horizontalWeight);
            goto L83
        L43:
            this.verticalBias = r11.getFloat(r3, this.verticalBias);
            goto L83
        L44:
            this.topToTop = ConstraintSet.access$100(r11, r3, this.topToTop);
            goto L83
        L45:
            this.topToBottom = ConstraintSet.access$100(r11, r3, this.topToBottom);
            goto L83
        L46:
            this.topMargin = r11.getDimensionPixelSize(r3, this.topMargin);
            goto L83
        L47:
            this.startToStart = ConstraintSet.access$100(r11, r3, this.startToStart);
            goto L83
        L48:
            this.startToEnd = ConstraintSet.access$100(r11, r3, this.startToEnd);
            goto L83
        L52:
            this.rightToRight = ConstraintSet.access$100(r11, r3, this.rightToRight);
            goto L83
        L53:
            this.rightToLeft = ConstraintSet.access$100(r11, r3, this.rightToLeft);
            goto L83
        L54:
            this.rightMargin = r11.getDimensionPixelSize(r3, this.rightMargin);
            goto L83
        L55:
            this.orientation = r11.getInt(r3, this.orientation);
            goto L83
        L56:
            this.leftToRight = ConstraintSet.access$100(r11, r3, this.leftToRight);
            goto L83
        L57:
            this.leftToLeft = ConstraintSet.access$100(r11, r3, this.leftToLeft);
            goto L83
        L58:
            this.leftMargin = r11.getDimensionPixelSize(r3, this.leftMargin);
            goto L83
        L59:
            this.mWidth = r11.getLayoutDimension(r3, this.mWidth);
            goto L83
        L60:
            this.mHeight = r11.getLayoutDimension(r3, this.mHeight);
            goto L83
        L61:
            this.horizontalBias = r11.getFloat(r3, this.horizontalBias);
            goto L83
        L62:
            this.guidePercent = r11.getFloat(r3, this.guidePercent);
            goto L83
        L63:
            this.guideEnd = r11.getDimensionPixelOffset(r3, this.guideEnd);
            goto L83
        L64:
            this.guideBegin = r11.getDimensionPixelOffset(r3, this.guideBegin);
            goto L83
        L65:
            this.goneTopMargin = r11.getDimensionPixelSize(r3, this.goneTopMargin);
            goto L83
        L66:
            this.goneStartMargin = r11.getDimensionPixelSize(r3, this.goneStartMargin);
            goto L83
        L67:
            this.goneRightMargin = r11.getDimensionPixelSize(r3, this.goneRightMargin);
            goto L83
        L68:
            this.goneLeftMargin = r11.getDimensionPixelSize(r3, this.goneLeftMargin);
            goto L83
        L69:
            this.goneEndMargin = r11.getDimensionPixelSize(r3, this.goneEndMargin);
            goto L83
        L70:
            this.goneBottomMargin = r11.getDimensionPixelSize(r3, this.goneBottomMargin);
            goto L83
        L71:
            this.endToStart = ConstraintSet.access$100(r11, r3, this.endToStart);
            goto L83
        L72:
            this.endToEnd = ConstraintSet.access$100(r11, r3, this.endToEnd);
            goto L83
        L76:
            this.editorAbsoluteY = r11.getDimensionPixelOffset(r3, this.editorAbsoluteY);
            goto L83
        L77:
            this.editorAbsoluteX = r11.getDimensionPixelOffset(r3, this.editorAbsoluteX);
            goto L83
        L78:
            this.dimensionRatio = r11.getString(r3);
            goto L83
        L79:
            this.bottomToTop = ConstraintSet.access$100(r11, r3, this.bottomToTop);
            goto L83
        L80:
            this.bottomToBottom = ConstraintSet.access$100(r11, r3, this.bottomToBottom);
            goto L83
        L81:
            this.bottomMargin = r11.getDimensionPixelSize(r3, this.bottomMargin);
            goto L83
        L82:
            this.baselineToBaseline = ConstraintSet.access$100(r11, r3, this.baselineToBaseline);
            goto L83
        L50:
            if (Build.VERSION.SDK_INT < 17) goto L83;
            this.startMargin = r11.getDimensionPixelSize(r3, this.startMargin);
            goto L83
        L74:
            if (Build.VERSION.SDK_INT < 17) goto L83;
            this.endMargin = r11.getDimensionPixelSize(r3, this.endMargin);
            goto L83
        L84:
            r11.recycle();
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
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionPathRotate, "styleable", "Motion_motionPathRotate"), 1);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_pathMotionArc, "styleable", "Motion_pathMotionArc"), 2);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_transitionEasing, "styleable", "Motion_transitionEasing"), 3);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_drawPath, "styleable", "Motion_drawPath"), 4);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateRelativeTo, "styleable", "Motion_animateRelativeTo"), 5);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_animateCircleAngleTo, "styleable", "Motion_animateCircleAngleTo"), 6);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_motionStagger, "styleable", "Motion_motionStagger"), 7);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionSteps, "styleable", "Motion_quantizeMotionSteps"), 8);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionPhase, "styleable", "Motion_quantizeMotionPhase"), 9);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Motion_quantizeMotionInterpolator, "styleable", "Motion_quantizeMotionInterpolator"), 10);
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

        public void copyFrom(Motion r2) {
            this.mApply = r2.mApply;
            this.mAnimateRelativeTo = r2.mAnimateRelativeTo;
            this.mTransitionEasing = r2.mTransitionEasing;
            this.mPathMotionArc = r2.mPathMotionArc;
            this.mDrawPath = r2.mDrawPath;
            this.mPathRotate = r2.mPathRotate;
            this.mMotionStagger = r2.mMotionStagger;
            this.mPolarRelativeTo = r2.mPolarRelativeTo;
        }

        void fillFromAttributeList(Context r10, AttributeSet r11) {
            TypedArray r12 = ((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Motion);
            this.mApply = true;
            int r0 = r12.getIndexCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L33;
            int r3 = r12.getIndex(r2);
            switch(mapToConstant.get(r3)) {
                case 1: goto L31;
                case 2: goto L30;
                case 3: goto L26;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L7;
                default: goto L32;
            };
        L7:
            TypedValue r4 = r12.peekValue(r3);
            if (r4.type != 1) goto L13;
            int r5 = r12.getResourceId(r3, -1);
            this.mQuantizeInterpolatorID = r5;
            if (r5 == (-1)) goto L32;
        L11:
            this.mQuantizeInterpolatorType = -2;
            goto L32
        L13:
            if (r4.type != 3) goto L18;
            String r6 = r12.getString(r3);
            this.mQuantizeInterpolatorString = r6;
            if (r6.indexOf("/") <= 0) goto L17;
            this.mQuantizeInterpolatorID = r12.getResourceId(r3, -1);
            goto L11
        L17:
            this.mQuantizeInterpolatorType = -1;
            goto L32
        L18:
            this.mQuantizeInterpolatorType = r12.getInteger(r3, this.mQuantizeInterpolatorID);
            goto L32
        L19:
            this.mQuantizeMotionPhase = r12.getFloat(r3, this.mQuantizeMotionPhase);
            goto L32
        L20:
            this.mQuantizeMotionSteps = r12.getInteger(r3, this.mQuantizeMotionSteps);
            goto L32
        L21:
            this.mMotionStagger = r12.getFloat(r3, this.mMotionStagger);
            goto L32
        L22:
            this.mAnimateCircleAngleTo = r12.getInteger(r3, this.mAnimateCircleAngleTo);
            goto L32
        L23:
            this.mAnimateRelativeTo = ConstraintSet.access$100(r12, r3, this.mAnimateRelativeTo);
            goto L32
        L24:
            this.mDrawPath = r12.getInt(r3, 0);
            goto L32
        L30:
            this.mPathMotionArc = r12.getInt(r3, this.mPathMotionArc);
            goto L32
        L31:
            this.mPathRotate = r12.getFloat(r3, this.mPathRotate);
            goto L32
        L26:
            if (r12.peekValue(r3).type != 3) goto L28;
            String r7 = r12.getString(r3);
        L29:
            this.mTransitionEasing = r7;
            goto L32
        L28:
            r7 = Easing.NAMED_EASING[r12.getInteger(r3, 0)];
        L32:
            r2 = r2 + 1;
            goto L3
        L33:
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

        public void copyFrom(PropertySet r2) {
            this.mApply = r2.mApply;
            this.visibility = r2.visibility;
            this.alpha = r2.alpha;
            this.mProgress = r2.mProgress;
            this.mVisibilityMode = r2.mVisibilityMode;
        }

        void fillFromAttributeList(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.PropertySet);
            this.mApply = true;
            int r9 = r8.getIndexCount();
            int r0 = 0;
        L3:
            if (r0 >= r9) goto L17;
            int r1 = r8.getIndex(r0);
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_alpha, "styleable", "PropertySet_android_alpha")) goto L8;
            this.alpha = r8.getFloat(r1, this.alpha);
        L16:
            r0 = r0 + 1;
            goto L3
        L8:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_android_visibility, "styleable", "PropertySet_android_visibility")) goto L11;
            this.visibility = r8.getInt(r1, this.visibility);
            this.visibility = ConstraintSet.access$200()[this.visibility];
            goto L16
        L11:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_visibilityMode, "styleable", "PropertySet_visibilityMode")) goto L14;
            this.mVisibilityMode = r8.getInt(r1, this.mVisibilityMode);
            goto L16
        L14:
            if (r1 != ZeusTransformUtils.mapRes(R.styleable.PropertySet_motionProgress, "styleable", "PropertySet_motionProgress")) goto L16;
            this.mProgress = r8.getFloat(r1, this.mProgress);
            goto L16
        L17:
            r8.recycle();
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
            SparseIntArray r0 = new SparseIntArray();
            mapToConstant = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotation, "styleable", "Transform_android_rotation"), 1);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationX, "styleable", "Transform_android_rotationX"), 2);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_rotationY, "styleable", "Transform_android_rotationY"), 3);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleX, "styleable", "Transform_android_scaleX"), 4);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_scaleY, "styleable", "Transform_android_scaleY"), 5);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotX, "styleable", "Transform_android_transformPivotX"), 6);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_transformPivotY, "styleable", "Transform_android_transformPivotY"), 7);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationX, "styleable", "Transform_android_translationX"), 8);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationY, "styleable", "Transform_android_translationY"), 9);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_translationZ, "styleable", "Transform_android_translationZ"), 10);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_android_elevation, "styleable", "Transform_android_elevation"), 11);
            mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Transform_transformPivotTarget, "styleable", "Transform_transformPivotTarget"), 12);
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

        public void copyFrom(Transform r2) {
            this.mApply = r2.mApply;
            this.rotation = r2.rotation;
            this.rotationX = r2.rotationX;
            this.rotationY = r2.rotationY;
            this.scaleX = r2.scaleX;
            this.scaleY = r2.scaleY;
            this.transformPivotX = r2.transformPivotX;
            this.transformPivotY = r2.transformPivotY;
            this.transformPivotTarget = r2.transformPivotTarget;
            this.translationX = r2.translationX;
            this.translationY = r2.translationY;
            this.translationZ = r2.translationZ;
            this.applyElevation = r2.applyElevation;
            this.elevation = r2.elevation;
        }

        void fillFromAttributeList(Context r6, AttributeSet r7) {
            TypedArray r8 = ((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.Transform);
            this.mApply = true;
            int r0 = r8.getIndexCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L24;
            int r2 = r8.getIndex(r1);
            switch(mapToConstant.get(r2)) {
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
            this.transformPivotTarget = ConstraintSet.access$100(r8, r2, this.transformPivotTarget);
            goto L23
        L14:
            this.translationY = r8.getDimension(r2, this.translationY);
            goto L23
        L15:
            this.translationX = r8.getDimension(r2, this.translationX);
            goto L23
        L16:
            this.transformPivotY = r8.getDimension(r2, this.transformPivotY);
            goto L23
        L17:
            this.transformPivotX = r8.getDimension(r2, this.transformPivotX);
            goto L23
        L18:
            this.scaleY = r8.getFloat(r2, this.scaleY);
            goto L23
        L19:
            this.scaleX = r8.getFloat(r2, this.scaleX);
            goto L23
        L20:
            this.rotationY = r8.getFloat(r2, this.rotationY);
            goto L23
        L21:
            this.rotationX = r8.getFloat(r2, this.rotationX);
            goto L23
        L22:
            this.rotation = r8.getFloat(r2, this.rotation);
            goto L23
        L9:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.applyElevation = true;
            this.elevation = r8.getDimension(r2, this.elevation);
            goto L23
        L12:
            if (Build.VERSION.SDK_INT < 21) goto L23;
            this.translationZ = r8.getDimension(r2, this.translationZ);
        L23:
            r1 = r1 + 1;
            goto L3
        L24:
            r8.recycle();
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

        WriteJsonEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
            this.this$0 = r1;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r2;
            this.layout = r3;
            this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.flags = r4;
        }

        private void writeDimension(String r4, int r5, int r6, float r7, int r8, int r9, boolean r10) {
            if (r5 == 0) goto L5;
            Writer r3 = this.writer;
            if (r5 != (-2)) goto L30;
            StringBuilder r11 = new StringBuilder().append(SPACE).append(r4);
            String r12 = ": 'wrap'\n";
        L29:
            r3.write(r11.append(r12).toString());
            return;
        L30:
            if (r5 != (-1)) goto L32;
            r11 = new StringBuilder().append(SPACE).append(r4);
            r12 = ": 'parent'\n";
            goto L29
        L32:
            r11 = new StringBuilder().append(SPACE).append(r4).append(": ").append(r5);
            r12 = ",\n";
            goto L29
        L5:
            if (r9 != (-1)) goto L17;
            if (r8 != (-1)) goto L17;
            if (r6 == 1) goto L15;
            if (r6 != 2) goto L35;
            Writer r13 = this.writer;
            StringBuilder r14 = new StringBuilder().append(SPACE).append(r4).append(": '").append(r7);
            String r15 = "%',\n";
        L12:
            StringBuilder r16 = r14.append(r15);
        L13:
            r13.write(r16.toString());
            return;
        L35:
            return;
        L15:
            r13 = this.writer;
            r14 = new StringBuilder().append(SPACE).append(r4);
            r15 = ": '???????????',\n";
        L17:
            if (r6 == 0) goto L24;
            if (r6 == 1) goto L23;
            if (r6 != 2) goto L34;
            r13 = this.writer;
            StringBuilder r17 = new StringBuilder().append(SPACE).append(r4).append(": {'").append(r7);
            String r18 = "'% ,";
        L22:
            r16 = r17.append(r18).append(r8).append(", ").append(r9).append("}\n");
            goto L13
        L34:
            return;
        L23:
            r13 = this.writer;
            r17 = new StringBuilder().append(SPACE).append(r4);
            r18 = ": {'wrap' ,";
            goto L22
        L24:
            this.writer.write(SPACE + r4 + ": {'spread' ," + r8 + ", " + r9 + "}\n");
        }

        private void writeGuideline(int r1, int r2, int r3, float r4) {
        }

        String getName(int r4) {
            if (this.idMap.containsKey(Integer.valueOf(r4)) == false) goto L7;
            StringBuilder r3 = new StringBuilder().append("'").append((String) ZeusTransformUtils.preCheckCast(this.idMap.get(Integer.valueOf(r4)), String.class, "com.obric.memorydata.plugin"));
        L6:
            return r3.append("'").toString();
        L7:
            if (r4 != 0) goto L10;
            return "'parent'";
        L10:
            String r0 = lookup(r4);
            this.idMap.put(Integer.valueOf(r4), r0);
            r3 = new StringBuilder().append("'").append(r0);
            goto L6
        }

        String lookup(int r4) {
            if (r4 != (-1)) goto L5;
            StringBuilder r5 = new StringBuilder().append("unknown");     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            return r5.append(r0).toString();
        L5:
            return ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getResourceEntryName(r4);
        L8:
            StringBuilder r6 = new StringBuilder().append("unknown");
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            return r6.append(r1).toString();
        }

        void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("       circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(":[");
            this.writer.write(getName(r4));
            this.writer.write(" , ");
            this.writer.write(r5);
            if (r6 == 0) goto L8;
            this.writer.write(" , " + r6);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n'ConstraintSet':{\n");
            Iterator r8 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r8.hasNext() == false) goto L9;
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r8.next(), Integer.class, "com.obric.memorydata.plugin");
            Constraint r1 = (Constraint) ZeusTransformUtils.preCheckCast(ConstraintSet.access$1300(this.this$0).get(r0), Constraint.class, "com.obric.memorydata.plugin");
            this.writer.write(getName(r0.intValue()) + ":{\n");
            Layout r10 = r1.layout;
            writeDimension("height", r10.mHeight, r10.heightDefault, r10.heightPercent, r10.heightMin, r10.heightMax, r10.constrainedHeight);
            writeDimension("width", r10.mWidth, r10.widthDefault, r10.widthPercent, r10.widthMin, r10.widthMax, r10.constrainedWidth);
            writeConstraint("'left'", r10.leftToLeft, "'left'", r10.leftMargin, r10.goneLeftMargin);
            writeConstraint("'left'", r10.leftToRight, "'right'", r10.leftMargin, r10.goneLeftMargin);
            writeConstraint("'right'", r10.rightToLeft, "'left'", r10.rightMargin, r10.goneRightMargin);
            writeConstraint("'right'", r10.rightToRight, "'right'", r10.rightMargin, r10.goneRightMargin);
            writeConstraint("'baseline'", r10.baselineToBaseline, "'baseline'", -1, r10.goneBaselineMargin);
            writeConstraint("'baseline'", r10.baselineToTop, "'top'", -1, r10.goneBaselineMargin);
            writeConstraint("'baseline'", r10.baselineToBottom, "'bottom'", -1, r10.goneBaselineMargin);
            writeConstraint("'top'", r10.topToBottom, "'bottom'", r10.topMargin, r10.goneTopMargin);
            writeConstraint("'top'", r10.topToTop, "'top'", r10.topMargin, r10.goneTopMargin);
            writeConstraint("'bottom'", r10.bottomToBottom, "'bottom'", r10.bottomMargin, r10.goneBottomMargin);
            writeConstraint("'bottom'", r10.bottomToTop, "'top'", r10.bottomMargin, r10.goneBottomMargin);
            writeConstraint("'start'", r10.startToStart, "'start'", r10.startMargin, r10.goneStartMargin);
            writeConstraint("'start'", r10.startToEnd, "'end'", r10.startMargin, r10.goneStartMargin);
            writeConstraint("'end'", r10.endToStart, "'start'", r10.endMargin, r10.goneEndMargin);
            writeConstraint("'end'", r10.endToEnd, "'end'", r10.endMargin, r10.goneEndMargin);
            writeVariable("'horizontalBias'", r10.horizontalBias, 0.5f);
            writeVariable("'verticalBias'", r10.verticalBias, 0.5f);
            writeCircle(r10.circleConstraint, r10.circleAngle, r10.circleRadius);
            writeGuideline(r10.orientation, r10.guideBegin, r10.guideEnd, r10.guidePercent);
            writeVariable("'dimensionRatio'", r10.dimensionRatio);
            writeVariable("'barrierMargin'", r10.mBarrierMargin);
            writeVariable("'type'", r10.mHelperType);
            writeVariable("'ReferenceId'", r10.mReferenceIdString);
            writeVariable("'mBarrierAllowsGoneWidgets'", r10.mBarrierAllowsGoneWidgets, true);
            writeVariable("'WrapBehavior'", r10.mWrapBehavior);
            writeVariable("'verticalWeight'", r10.verticalWeight);
            writeVariable("'horizontalWeight'", r10.horizontalWeight);
            writeVariable("'horizontalChainStyle'", r10.horizontalChainStyle);
            writeVariable("'verticalChainStyle'", r10.verticalChainStyle);
            writeVariable("'barrierDirection'", r10.mBarrierDirection);
            if (r10.mReferenceIds == null) goto L8;
            writeVariable("'ReferenceIds'", r10.mReferenceIds);
        L8:
            this.writer.write("}\n");
            goto L4
        L9:
            this.writer.write("}\n");
        }

        void writeVariable(String r4, float r5) {
            if (r5 != (-1.0f)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        void writeVariable(String r4, int r5) {
            if (r5 != 0) goto L4;
            return;
        L4:
            if (r5 == (-1)) goto L9;
            this.writer.write(SPACE + r4);
            this.writer.write(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            this.writer.write(", " + r5);
            this.writer.write("\n");
            return;
        }

        void writeVariable(String r4, String r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            this.writer.write(", " + r5);
            this.writer.write("\n");
        }

        void writeVariable(String r4, boolean r5) {
            if (r5 == true) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(": " + r5);
            this.writer.write(",\n");
        }

        void writeVariable(String r3, boolean r4, boolean r5) {
            if (r4 != r5) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r3);
            this.writer.write(": " + r4);
            this.writer.write(",\n");
        }

        void writeVariable(String r4, int[] r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(": ");
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(r5[r6])).toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
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

        WriteXmlEngine(ConstraintSet r1, Writer r2, ConstraintLayout r3, int r4) {
            this.this$0 = r1;
            this.unknownCount = 0;
            this.LEFT = "'left'";
            this.RIGHT = "'right'";
            this.BASELINE = "'baseline'";
            this.BOTTOM = "'bottom'";
            this.TOP = "'top'";
            this.START = "'start'";
            this.END = "'end'";
            this.idMap = new HashMap();
            this.writer = r2;
            this.layout = r3;
            this.context = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.flags = r4;
        }

        private void writeBaseDimension(String r2, int r3, int r4) {
            if (r3 != r4) goto L4;
            return;
        L4:
            if (r3 != (-2)) goto L7;
            Writer r1 = this.writer;
            StringBuilder r5 = new StringBuilder().append(SPACE).append(r2);
            String r6 = "=\"wrap_content\"";
        L6:
            r1.write(r5.append(r6).toString());
            return;
        L7:
            r1 = this.writer;
            if (r3 != (-1)) goto L10;
            r5 = new StringBuilder().append(SPACE).append(r2);
            r6 = "=\"match_parent\"";
            goto L6
        L10:
            r5 = new StringBuilder().append(SPACE).append(r2).append("=\"").append(r3);
            r6 = "dp\"";
            goto L6
        }

        private void writeBoolen(String r2, boolean r3, boolean r4) {
            if (r3 == r4) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeDimension(String r2, int r3, int r4) {
            if (r3 == r4) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r3 + "dp\"");
            return;
        }

        private void writeEnum(String r2, int r3, String[] r4, int r5) {
            if (r3 == r5) goto L5;
            this.writer.write(SPACE + r2 + "=\"" + r4[r3] + "\"");
            return;
        }

        String getName(int r4) {
            if (this.idMap.containsKey(Integer.valueOf(r4)) == false) goto L7;
            StringBuilder r3 = new StringBuilder().append("@+id/").append((String) ZeusTransformUtils.preCheckCast(this.idMap.get(Integer.valueOf(r4)), String.class, "com.obric.memorydata.plugin"));
        L6:
            return r3.append("").toString();
        L7:
            if (r4 != 0) goto L10;
            return ConstraintSet.KEY_PERCENT_PARENT;
        L10:
            String r0 = lookup(r4);
            this.idMap.put(Integer.valueOf(r4), r0);
            r3 = new StringBuilder().append("@+id/").append(r0);
            goto L6
        }

        String lookup(int r4) {
            if (r4 != (-1)) goto L5;
            StringBuilder r5 = new StringBuilder().append("unknown");     // Catch: Exception -> L8
            int r0 = this.unknownCount + 1;     // Catch: Exception -> L8
            this.unknownCount = r0;     // Catch: Exception -> L8
            return r5.append(r0).toString();
        L5:
            return ZeusTransformUtils.getResources(this.context, "com.obric.memorydata.plugin").getResourceEntryName(r4);
        L8:
            StringBuilder r6 = new StringBuilder().append("unknown");
            int r1 = this.unknownCount + 1;
            this.unknownCount = r1;
            return r6.append(r1).toString();
        }

        void writeCircle(int r3, float r4, int r5) {
            if (r3 != (-1)) goto L5;
            return;
        L5:
            this.writer.write("circle");
            this.writer.write(":[");
            this.writer.write(getName(r3));
            this.writer.write(", " + r4);
            this.writer.write(r5 + "]");
        }

        void writeConstraint(String r3, int r4, String r5, int r6, int r7) {
            if (r4 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write(":[");
            this.writer.write(getName(r4));
            this.writer.write(" , ");
            this.writer.write(r5);
            if (r6 == 0) goto L8;
            this.writer.write(" , " + r6);
        L8:
            this.writer.write("],\n");
        }

        void writeLayout() {
            this.writer.write("\n<ConstraintSet>\n");
            Iterator r0 = ConstraintSet.access$1300(this.this$0).keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
            Constraint r2 = (Constraint) ZeusTransformUtils.preCheckCast(ConstraintSet.access$1300(this.this$0).get(r1), Constraint.class, "com.obric.memorydata.plugin");
            String r3 = getName(r1.intValue());
            this.writer.write("  <Constraint");
            this.writer.write("\n       android:id=\"" + r3 + "\"");
            Layout r4 = r2.layout;
            writeBaseDimension("android:layout_width", r4.mWidth, -5);
            writeBaseDimension("android:layout_height", r4.mHeight, -5);
            writeVariable("app:layout_constraintGuide_begin", r4.guideBegin, -1.0f);
            writeVariable("app:layout_constraintGuide_end", r4.guideEnd, -1.0f);
            writeVariable("app:layout_constraintGuide_percent", r4.guidePercent, -1.0f);
            writeVariable("app:layout_constraintHorizontal_bias", r4.horizontalBias, 0.5f);
            writeVariable("app:layout_constraintVertical_bias", r4.verticalBias, 0.5f);
            writeVariable("app:layout_constraintDimensionRatio", r4.dimensionRatio, null);
            writeXmlConstraint("app:layout_constraintCircle", r4.circleConstraint);
            writeVariable("app:layout_constraintCircleRadius", r4.circleRadius, 0.0f);
            writeVariable("app:layout_constraintCircleAngle", r4.circleAngle, 0.0f);
            writeVariable("android:orientation", r4.orientation, -1.0f);
            writeVariable("app:layout_constraintVertical_weight", r4.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r4.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r4.horizontalChainStyle, 0.0f);
            writeVariable("app:layout_constraintVertical_chainStyle", r4.verticalChainStyle, 0.0f);
            writeVariable("app:barrierDirection", r4.mBarrierDirection, -1.0f);
            writeVariable("app:barrierMargin", r4.mBarrierMargin, 0.0f);
            writeDimension("app:layout_marginLeft", r4.leftMargin, 0);
            writeDimension("app:layout_goneMarginLeft", r4.goneLeftMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginRight", r4.rightMargin, 0);
            writeDimension("app:layout_goneMarginRight", r4.goneRightMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginStart", r4.startMargin, 0);
            writeDimension("app:layout_goneMarginStart", r4.goneStartMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginEnd", r4.endMargin, 0);
            writeDimension("app:layout_goneMarginEnd", r4.goneEndMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginTop", r4.topMargin, 0);
            writeDimension("app:layout_goneMarginTop", r4.goneTopMargin, Integer.MIN_VALUE);
            writeDimension("app:layout_marginBottom", r4.bottomMargin, 0);
            writeDimension("app:layout_goneMarginBottom", r4.goneBottomMargin, Integer.MIN_VALUE);
            writeDimension("app:goneBaselineMargin", r4.goneBaselineMargin, Integer.MIN_VALUE);
            writeDimension("app:baselineMargin", r4.baselineMargin, 0);
            writeBoolen("app:layout_constrainedWidth", r4.constrainedWidth, false);
            writeBoolen("app:layout_constrainedHeight", r4.constrainedHeight, false);
            writeBoolen("app:barrierAllowsGoneWidgets", r4.mBarrierAllowsGoneWidgets, true);
            writeVariable("app:layout_wrapBehaviorInParent", r4.mWrapBehavior, 0.0f);
            writeXmlConstraint("app:baselineToBaseline", r4.baselineToBaseline);
            writeXmlConstraint("app:baselineToBottom", r4.baselineToBottom);
            writeXmlConstraint("app:baselineToTop", r4.baselineToTop);
            writeXmlConstraint("app:layout_constraintBottom_toBottomOf", r4.bottomToBottom);
            writeXmlConstraint("app:layout_constraintBottom_toTopOf", r4.bottomToTop);
            writeXmlConstraint("app:layout_constraintEnd_toEndOf", r4.endToEnd);
            writeXmlConstraint("app:layout_constraintEnd_toStartOf", r4.endToStart);
            writeXmlConstraint("app:layout_constraintLeft_toLeftOf", r4.leftToLeft);
            writeXmlConstraint("app:layout_constraintLeft_toRightOf", r4.leftToRight);
            writeXmlConstraint("app:layout_constraintRight_toLeftOf", r4.rightToLeft);
            writeXmlConstraint("app:layout_constraintRight_toRightOf", r4.rightToRight);
            writeXmlConstraint("app:layout_constraintStart_toEndOf", r4.startToEnd);
            writeXmlConstraint("app:layout_constraintStart_toStartOf", r4.startToStart);
            writeXmlConstraint("app:layout_constraintTop_toBottomOf", r4.topToBottom);
            writeXmlConstraint("app:layout_constraintTop_toTopOf", r4.topToTop);
            String[] r5 = {"spread", "wrap", "percent"};
            writeEnum("app:layout_constraintHeight_default", r4.heightDefault, r5, 0);
            writeVariable("app:layout_constraintHeight_percent", r4.heightPercent, 1.0f);
            writeDimension("app:layout_constraintHeight_min", r4.heightMin, 0);
            writeDimension("app:layout_constraintHeight_max", r4.heightMax, 0);
            writeBoolen("android:layout_constrainedHeight", r4.constrainedHeight, false);
            writeEnum("app:layout_constraintWidth_default", r4.widthDefault, r5, 0);
            writeVariable("app:layout_constraintWidth_percent", r4.widthPercent, 1.0f);
            writeDimension("app:layout_constraintWidth_min", r4.widthMin, 0);
            writeDimension("app:layout_constraintWidth_max", r4.widthMax, 0);
            writeBoolen("android:layout_constrainedWidth", r4.constrainedWidth, false);
            writeVariable("app:layout_constraintVertical_weight", r4.verticalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_weight", r4.horizontalWeight, -1.0f);
            writeVariable("app:layout_constraintHorizontal_chainStyle", r4.horizontalChainStyle);
            writeVariable("app:layout_constraintVertical_chainStyle", r4.verticalChainStyle);
            writeEnum("app:barrierDirection", r4.mBarrierDirection, new String[]{"left", "right", "top", "bottom", CommonConsts.APM_INNER_EVENT_COST_START, "end"}, -1);
            writeVariable("app:layout_constraintTag", r4.mConstraintTag, null);
            if (r4.mReferenceIds == null) goto L8;
            writeVariable("'ReferenceIds'", r4.mReferenceIds);
        L8:
            this.writer.write(" />\n");
            goto L4
        L9:
            this.writer.write("</ConstraintSet>\n");
        }

        void writeVariable(String r3, float r4, float r5) {
            if (r4 != r5) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
        }

        void writeVariable(String r3, int r4) {
            if (r4 != 0) goto L4;
            return;
        L4:
            if (r4 == (-1)) goto L9;
            this.writer.write(SPACE + r3 + "=\"" + r4 + "\"\n");
            return;
        }

        void writeVariable(String r3, String r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            this.writer.write(r3);
            this.writer.write(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            this.writer.write(", " + r4);
            this.writer.write("\n");
        }

        void writeVariable(String r3, String r4, String r5) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.equals(r5) == true) goto L9;
            this.writer.write(SPACE + r3);
            this.writer.write("=\"" + r4 + "\"");
            return;
        }

        void writeVariable(String r4, int[] r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            this.writer.write(SPACE + r4);
            this.writer.write(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            int r6 = 0;
        L6:
            if (r6 >= r5.length) goto L12;
            Writer r0 = this.writer;
            StringBuilder r1 = new StringBuilder();
            if (r6 != 0) goto L10;
            String r2 = "[";
        L11:
            r0.write(r1.append(r2).append(getName(r5[r6])).toString());
            r6 = r6 + 1;
            goto L6
        L10:
            r2 = ", ";
            goto L11
        L12:
            this.writer.write("],\n");
        }

        void writeXmlConstraint(String r4, int r5) {
            if (r5 != (-1)) goto L5;
            return;
        L5:
            this.writer.write(SPACE + r4);
            this.writer.write("=\"" + getName(r5) + "\"");
        }
    }

    static {
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        mapToConstant = new SparseIntArray();
        overrideMapToConstant = new SparseIntArray();
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toLeftOf, "styleable", "Constraint_layout_constraintLeft_toLeftOf"), 25);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_toRightOf, "styleable", "Constraint_layout_constraintLeft_toRightOf"), 26);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toLeftOf, "styleable", "Constraint_layout_constraintRight_toLeftOf"), 29);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_toRightOf, "styleable", "Constraint_layout_constraintRight_toRightOf"), 30);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toTopOf, "styleable", "Constraint_layout_constraintTop_toTopOf"), 36);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_toBottomOf, "styleable", "Constraint_layout_constraintTop_toBottomOf"), 35);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toTopOf, "styleable", "Constraint_layout_constraintBottom_toTopOf"), 4);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_toBottomOf, "styleable", "Constraint_layout_constraintBottom_toBottomOf"), 3);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, "styleable", "Constraint_layout_constraintBaseline_toBaselineOf"), 1);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toTopOf, "styleable", "Constraint_layout_constraintBaseline_toTopOf"), BASELINE_TO_TOP);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, "styleable", "Constraint_layout_constraintBaseline_toBottomOf"), BASELINE_TO_BOTTOM);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteX, "styleable", "Constraint_layout_editor_absoluteX"), 6);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_editor_absoluteY, "styleable", "Constraint_layout_editor_absoluteY"), 7);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_begin, "styleable", "Constraint_layout_constraintGuide_begin"), 17);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_end, "styleable", "Constraint_layout_constraintGuide_end"), 18);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintGuide_percent, "styleable", "Constraint_layout_constraintGuide_percent"), 19);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_guidelineUseRtl, "styleable", "Constraint_guidelineUseRtl"), 99);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_orientation, "styleable", "Constraint_android_orientation"), 27);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toEndOf, "styleable", "Constraint_layout_constraintStart_toEndOf"), 32);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintStart_toStartOf, "styleable", "Constraint_layout_constraintStart_toStartOf"), 33);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toStartOf, "styleable", "Constraint_layout_constraintEnd_toStartOf"), 10);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintEnd_toEndOf, "styleable", "Constraint_layout_constraintEnd_toEndOf"), 9);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginLeft, "styleable", "Constraint_layout_goneMarginLeft"), 13);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginTop, "styleable", "Constraint_layout_goneMarginTop"), 16);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginRight, "styleable", "Constraint_layout_goneMarginRight"), 14);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginBottom, "styleable", "Constraint_layout_goneMarginBottom"), 11);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginStart, "styleable", "Constraint_layout_goneMarginStart"), 15);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_goneMarginEnd, "styleable", "Constraint_layout_goneMarginEnd"), 12);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_weight, "styleable", "Constraint_layout_constraintVertical_weight"), 40);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_weight, "styleable", "Constraint_layout_constraintHorizontal_weight"), 39);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, "styleable", "Constraint_layout_constraintHorizontal_chainStyle"), 41);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_chainStyle, "styleable", "Constraint_layout_constraintVertical_chainStyle"), 42);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHorizontal_bias, "styleable", "Constraint_layout_constraintHorizontal_bias"), 20);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintVertical_bias, "styleable", "Constraint_layout_constraintVertical_bias"), 37);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintDimensionRatio, "styleable", "Constraint_layout_constraintDimensionRatio"), 5);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintLeft_creator, "styleable", "Constraint_layout_constraintLeft_creator"), 87);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTop_creator, "styleable", "Constraint_layout_constraintTop_creator"), 87);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintRight_creator, "styleable", "Constraint_layout_constraintRight_creator"), 87);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBottom_creator, "styleable", "Constraint_layout_constraintBottom_creator"), 87);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintBaseline_creator, "styleable", "Constraint_layout_constraintBaseline_creator"), 87);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginLeft, "styleable", "Constraint_android_layout_marginLeft"), 24);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginRight, "styleable", "Constraint_android_layout_marginRight"), 28);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart"), 31);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd"), 8);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginTop, "styleable", "Constraint_android_layout_marginTop"), 34);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginBottom, "styleable", "Constraint_android_layout_marginBottom"), 2);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_width, "styleable", "Constraint_android_layout_width"), 23);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_height, "styleable", "Constraint_android_layout_height"), 21);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth, "styleable", "Constraint_layout_constraintWidth"), LAYOUT_CONSTRAINT_WIDTH);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight, "styleable", "Constraint_layout_constraintHeight"), LAYOUT_CONSTRAINT_HEIGHT);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_visibility, "styleable", "Constraint_android_visibility"), 22);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_alpha, "styleable", "Constraint_android_alpha"), 43);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_elevation, "styleable", "Constraint_android_elevation"), 44);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationX, "styleable", "Constraint_android_rotationX"), 45);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotationY, "styleable", "Constraint_android_rotationY"), 46);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_rotation, "styleable", "Constraint_android_rotation"), 60);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleX, "styleable", "Constraint_android_scaleX"), 47);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_scaleY, "styleable", "Constraint_android_scaleY"), 48);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotX, "styleable", "Constraint_android_transformPivotX"), 49);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_transformPivotY, "styleable", "Constraint_android_transformPivotY"), 50);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationX, "styleable", "Constraint_android_translationX"), 51);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationY, "styleable", "Constraint_android_translationY"), 52);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_translationZ, "styleable", "Constraint_android_translationZ"), 53);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_default, "styleable", "Constraint_layout_constraintWidth_default"), 54);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_default, "styleable", "Constraint_layout_constraintHeight_default"), 55);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_max, "styleable", "Constraint_layout_constraintWidth_max"), 56);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_max, "styleable", "Constraint_layout_constraintHeight_max"), 57);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_min, "styleable", "Constraint_layout_constraintWidth_min"), 58);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_min, "styleable", "Constraint_layout_constraintHeight_min"), 59);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircle, "styleable", "Constraint_layout_constraintCircle"), 61);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleRadius, "styleable", "Constraint_layout_constraintCircleRadius"), 62);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintCircleAngle, "styleable", "Constraint_layout_constraintCircleAngle"), 63);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_animateRelativeTo, "styleable", "Constraint_animateRelativeTo"), 64);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionEasing, "styleable", "Constraint_transitionEasing"), 65);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_drawPath, "styleable", "Constraint_drawPath"), 66);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transitionPathRotate, "styleable", "Constraint_transitionPathRotate"), 67);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionStagger, "styleable", "Constraint_motionStagger"), 79);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id"), 38);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_motionProgress, "styleable", "Constraint_motionProgress"), 68);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintWidth_percent, "styleable", "Constraint_layout_constraintWidth_percent"), 69);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintHeight_percent, "styleable", "Constraint_layout_constraintHeight_percent"), 70);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_wrapBehaviorInParent, "styleable", "Constraint_layout_wrapBehaviorInParent"), LAYOUT_WRAP_BEHAVIOR);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_chainUseRtl, "styleable", "Constraint_chainUseRtl"), 71);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierDirection, "styleable", "Constraint_barrierDirection"), BARRIER_DIRECTION);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierMargin, "styleable", "Constraint_barrierMargin"), BARRIER_MARGIN);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_constraint_referenced_ids, "styleable", "Constraint_constraint_referenced_ids"), 74);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_barrierAllowsGoneWidgets, "styleable", "Constraint_barrierAllowsGoneWidgets"), 75);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_pathMotionArc, "styleable", "Constraint_pathMotionArc"), 76);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constraintTag, "styleable", "Constraint_layout_constraintTag"), 77);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_visibilityMode, "styleable", "Constraint_visibilityMode"), 78);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedWidth, "styleable", "Constraint_layout_constrainedWidth"), 80);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_layout_constrainedHeight, "styleable", "Constraint_layout_constrainedHeight"), 81);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_polarRelativeTo, "styleable", "Constraint_polarRelativeTo"), 82);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_transformPivotTarget, "styleable", "Constraint_transformPivotTarget"), 83);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionSteps, "styleable", "Constraint_quantizeMotionSteps"), 84);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionPhase, "styleable", "Constraint_quantizeMotionPhase"), 85);
        mapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.Constraint_quantizeMotionInterpolator, "styleable", "Constraint_quantizeMotionInterpolator"), 86);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 6);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_editor_absoluteY, "styleable", "ConstraintOverride_layout_editor_absoluteY"), 7);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_orientation, "styleable", "ConstraintOverride_android_orientation"), 27);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginLeft, "styleable", "ConstraintOverride_layout_goneMarginLeft"), 13);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginTop, "styleable", "ConstraintOverride_layout_goneMarginTop"), 16);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginRight, "styleable", "ConstraintOverride_layout_goneMarginRight"), 14);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginBottom, "styleable", "ConstraintOverride_layout_goneMarginBottom"), 11);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginStart, "styleable", "ConstraintOverride_layout_goneMarginStart"), 15);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_goneMarginEnd, "styleable", "ConstraintOverride_layout_goneMarginEnd"), 12);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_weight, "styleable", "ConstraintOverride_layout_constraintVertical_weight"), 40);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, "styleable", "ConstraintOverride_layout_constraintHorizontal_weight"), 39);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, "styleable", "ConstraintOverride_layout_constraintHorizontal_chainStyle"), 41);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, "styleable", "ConstraintOverride_layout_constraintVertical_chainStyle"), 42);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, "styleable", "ConstraintOverride_layout_constraintHorizontal_bias"), 20);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintVertical_bias, "styleable", "ConstraintOverride_layout_constraintVertical_bias"), 37);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, "styleable", "ConstraintOverride_layout_constraintDimensionRatio"), 5);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintLeft_creator, "styleable", "ConstraintOverride_layout_constraintLeft_creator"), 87);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTop_creator, "styleable", "ConstraintOverride_layout_constraintTop_creator"), 87);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintRight_creator, "styleable", "ConstraintOverride_layout_constraintRight_creator"), 87);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBottom_creator, "styleable", "ConstraintOverride_layout_constraintBottom_creator"), 87);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, "styleable", "ConstraintOverride_layout_constraintBaseline_creator"), 87);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginLeft, "styleable", "ConstraintOverride_android_layout_marginLeft"), 24);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginRight, "styleable", "ConstraintOverride_android_layout_marginRight"), 28);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginStart, "styleable", "ConstraintOverride_android_layout_marginStart"), 31);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginEnd, "styleable", "ConstraintOverride_android_layout_marginEnd"), 8);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginTop, "styleable", "ConstraintOverride_android_layout_marginTop"), 34);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_marginBottom, "styleable", "ConstraintOverride_android_layout_marginBottom"), 2);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_width, "styleable", "ConstraintOverride_android_layout_width"), 23);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_layout_height, "styleable", "ConstraintOverride_android_layout_height"), 21);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth, "styleable", "ConstraintOverride_layout_constraintWidth"), LAYOUT_CONSTRAINT_WIDTH);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight, "styleable", "ConstraintOverride_layout_constraintHeight"), LAYOUT_CONSTRAINT_HEIGHT);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_visibility, "styleable", "ConstraintOverride_android_visibility"), 22);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_alpha, "styleable", "ConstraintOverride_android_alpha"), 43);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_elevation, "styleable", "ConstraintOverride_android_elevation"), 44);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationX, "styleable", "ConstraintOverride_android_rotationX"), 45);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotationY, "styleable", "ConstraintOverride_android_rotationY"), 46);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_rotation, "styleable", "ConstraintOverride_android_rotation"), 60);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleX, "styleable", "ConstraintOverride_android_scaleX"), 47);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_scaleY, "styleable", "ConstraintOverride_android_scaleY"), 48);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotX, "styleable", "ConstraintOverride_android_transformPivotX"), 49);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_transformPivotY, "styleable", "ConstraintOverride_android_transformPivotY"), 50);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationX, "styleable", "ConstraintOverride_android_translationX"), 51);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationY, "styleable", "ConstraintOverride_android_translationY"), 52);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_translationZ, "styleable", "ConstraintOverride_android_translationZ"), 53);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_default, "styleable", "ConstraintOverride_layout_constraintWidth_default"), 54);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_default, "styleable", "ConstraintOverride_layout_constraintHeight_default"), 55);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_max, "styleable", "ConstraintOverride_layout_constraintWidth_max"), 56);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_max, "styleable", "ConstraintOverride_layout_constraintHeight_max"), 57);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_min, "styleable", "ConstraintOverride_layout_constraintWidth_min"), 58);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_min, "styleable", "ConstraintOverride_layout_constraintHeight_min"), 59);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleRadius, "styleable", "ConstraintOverride_layout_constraintCircleRadius"), 62);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintCircleAngle, "styleable", "ConstraintOverride_layout_constraintCircleAngle"), 63);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_animateRelativeTo, "styleable", "ConstraintOverride_animateRelativeTo"), 64);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionEasing, "styleable", "ConstraintOverride_transitionEasing"), 65);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_drawPath, "styleable", "ConstraintOverride_drawPath"), 66);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transitionPathRotate, "styleable", "ConstraintOverride_transitionPathRotate"), 67);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionStagger, "styleable", "ConstraintOverride_motionStagger"), 79);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_android_id, "styleable", "ConstraintOverride_android_id"), 38);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionTarget, "styleable", "ConstraintOverride_motionTarget"), MOTION_TARGET);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_motionProgress, "styleable", "ConstraintOverride_motionProgress"), 68);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintWidth_percent, "styleable", "ConstraintOverride_layout_constraintWidth_percent"), 69);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintHeight_percent, "styleable", "ConstraintOverride_layout_constraintHeight_percent"), 70);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_chainUseRtl, "styleable", "ConstraintOverride_chainUseRtl"), 71);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierDirection, "styleable", "ConstraintOverride_barrierDirection"), BARRIER_DIRECTION);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierMargin, "styleable", "ConstraintOverride_barrierMargin"), BARRIER_MARGIN);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_constraint_referenced_ids, "styleable", "ConstraintOverride_constraint_referenced_ids"), 74);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, "styleable", "ConstraintOverride_barrierAllowsGoneWidgets"), 75);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_pathMotionArc, "styleable", "ConstraintOverride_pathMotionArc"), 76);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constraintTag, "styleable", "ConstraintOverride_layout_constraintTag"), 77);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_visibilityMode, "styleable", "ConstraintOverride_visibilityMode"), 78);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedWidth, "styleable", "ConstraintOverride_layout_constrainedWidth"), 80);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_constrainedHeight, "styleable", "ConstraintOverride_layout_constrainedHeight"), 81);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_polarRelativeTo, "styleable", "ConstraintOverride_polarRelativeTo"), 82);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_transformPivotTarget, "styleable", "ConstraintOverride_transformPivotTarget"), 83);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionSteps, "styleable", "ConstraintOverride_quantizeMotionSteps"), 84);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionPhase, "styleable", "ConstraintOverride_quantizeMotionPhase"), 85);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_quantizeMotionInterpolator, "styleable", "ConstraintOverride_quantizeMotionInterpolator"), 86);
        overrideMapToConstant.append(ZeusTransformUtils.mapRes(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, "styleable", "ConstraintOverride_layout_wrapBehaviorInParent"), LAYOUT_WRAP_BEHAVIOR);
    }

    public ConstraintSet() {
        this.derivedState = "";
        this.mRotate = 0;
        this.mSavedAttributes = new HashMap();
        this.mForceId = true;
        this.mConstraints = new HashMap();
    }

    static /* synthetic */ int access$100(TypedArray r0, int r1, int r2) {
        return lookupID(r0, r1, r2);
    }

    static /* synthetic */ HashMap access$1300(ConstraintSet r0) {
        return r0.mConstraints;
    }

    static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    static /* synthetic */ void access$300(Constraint r0, int r1, int r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$400(Constraint r0, int r1, float r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$500(Constraint r0, int r1, String r2) {
        setDeltaValue(r0, r1, r2);
    }

    static /* synthetic */ void access$600(Constraint r0, int r1, boolean r2) {
        setDeltaValue(r0, r1, r2);
    }

    private void addAttributes(ConstraintAttribute.AttributeType r5, String... r6) {
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L17;
        if (this.mSavedAttributes.containsKey(r6[r0]) == false) goto L15;
        ConstraintAttribute r1 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.mSavedAttributes.get(r6[r0]), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        if (r1.getType() == r5) goto L16;
        throw new IllegalArgumentException("ConstraintAttribute is already a " + r1.getType().name());
    L16:
        r0 = r0 + 1;
        goto L4
    L15:
        this.mSavedAttributes.put(r6[r0], new ConstraintAttribute(r6[r0], r5));
        goto L16
    }

    public static Constraint buildDelta(Context r2, XmlPullParser r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r5 = Xml.asAttributeSet((XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin"));
        Constraint r0 = new Constraint();
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.ConstraintOverride);
        populateOverride(r4, r0, r6);
        r6.recycle();
        return r0;
    }

    private int[] convertReferenceString(View r10, String r11) {
        String[] r9 = r11.split(",");
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        int[] r1 = new int[r9.length];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r9.length) goto L23;
        String r5 = r9[r3].trim();
        int r6 = R.id.class.getField(r5).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r6 != 0) goto L11;
        r6 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin"), r5, OaidModel.KEY_ID, r12.getPackageName(), "com.obric.memorydata.plugin");
    L11:
        if (r6 != 0) goto L21;
        if (r10.isInEditMode() == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r10.getParent(), ConstraintLayout.class) == false) goto L21;
        Object r7 = ((ConstraintLayout) ZeusTransformUtils.preCheckCast(r10.getParent(), ConstraintLayout.class, "com.obric.memorydata.plugin")).getDesignInformation(0, r5);
        if (r7 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L21;
        r6 = ((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue();
    L21:
        r1[r4] = r6;
        r3 = r3 + 1;
        r4 = r4 + 1;
    L8:
        r6 = 0;
        goto L9
    L23:
        if (r4 != r9.length) goto L25;
        return r1;
    L25:
        return Arrays.copyOf(r1, r4);
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
        int r0 = r17[r10];
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

    private Constraint fillFromAttributeList(Context r3, AttributeSet r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        Constraint r0 = new Constraint();
        if (r5 == false) goto L5;
        int[] r1 = R.styleable.ConstraintOverride;
    L6:
        TypedArray r8 = r6.obtainStyledAttributes(r7, r1);
        populateConstraint(r6, r0, r8, r5);
        r8.recycle();
        return r0;
    L5:
        r1 = R.styleable.Constraint;
        goto L6
    }

    private Constraint get(int r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L6;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L6:
        return (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r4)), Constraint.class, "com.obric.memorydata.plugin");
    }

    static String getDebugName(int r6) {
        Field[] r0 = ConstraintSet.class.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L20;
        Field r3 = r0[r2];
        if (r3.getName().contains("_") == false) goto L19;
        if (r3.getType() != Integer.TYPE) goto L19;
        if (Modifier.isStatic(r3.getModifiers()) == false) goto L19;
        if (Modifier.isFinal(r3.getModifiers()) == false) goto L19;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L14:
        if (r3.getInt(null) != r6) goto L19;
        return r3.getName();
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return "UNKNOWN";
    }

    static String getLine(Context r2, int r3, XmlPullParser r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r4, XmlPullParser.class, "com.obric.memorydata.plugin");
        return ".(" + Debug.getName(r5, r3) + ".xml:" + r6.getLineNumber() + ") \"" + r6.getName() + "\"";
    }

    private static int lookupID(TypedArray r1, int r2, int r3) {
        int r4 = r1.getResourceId(r2, r3);
        if (r4 == (-1)) goto L5;
        return r4;
    L5:
        return r1.getInt(r2, -1);
    }

    static void parseDimensionConstraints(Object r4, TypedArray r5, int r6, int r7) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = r5.peekValue(r6).type;
        if (r0 == 3) goto L39;
        int r2 = -2;
        boolean r3 = false;
        if (r0 == 5) goto L18;
        int r8 = r5.getInt(r6, 0);
        if (r8 != (-4)) goto L11;
        r3 = true;
    L20:
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L26;
        ConstraintLayout.LayoutParams r9 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L24;
        r9.width = r2;
        r9.constrainedWidth = r3;
        return;
    L24:
        r9.height = r2;
        r9.constrainedHeight = r3;
        return;
    L26:
        if (ZeusTransformUtils.instanceOf(r4, Layout.class) == false) goto L32;
        Layout r10 = (Layout) ZeusTransformUtils.preCheckCast(r4, Layout.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L30;
        r10.mWidth = r2;
        r10.constrainedWidth = r3;
        return;
    L30:
        r10.mHeight = r2;
        r10.constrainedHeight = r3;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r4, Constraint.Delta.class) == false) goto L45;
        Constraint.Delta r11 = (Constraint.Delta) ZeusTransformUtils.preCheckCast(r4, Constraint.Delta.class, "com.obric.memorydata.plugin");
        if (r7 != 0) goto L36;
        r11.add(23, r2);
        int r12 = 80;
    L37:
        r11.add(r12, r3);
        return;
    L36:
        r11.add(21, r2);
        r12 = 81;
        goto L37
    L45:
        return;
    L11:
        if (r8 == (-3)) goto L15;
        if (r8 != (-2)) goto L14;
    L16:
        r2 = r8;
        goto L20
    L14:
        if (r8 == (-1)) goto L16;
    L15:
        r2 = 0;
        goto L20
    L18:
        r2 = r5.getDimensionPixelSize(r6, 0);
        goto L20
    L39:
        parseDimensionConstraintsString(r4, r5.getString(r6), r7);
    }

    static void parseDimensionConstraintsString(Object r6, String r7, int r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        int r0 = r7.indexOf(61);
        int r1 = r7.length();
        if (r0 > 0) goto L7;
        return;
    L7:
        if (r0 >= (r1 - 1)) goto L73;
        String r2 = r7.substring(0, r0);
        String r9 = r7.substring(r0 + 1);
        if (r9.length() <= 0) goto L74;
        String r3 = r2.trim();
        String r10 = r9.trim();
        if (KEY_RATIO.equalsIgnoreCase(r3) == false) goto L72;
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L20;
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        if (r8 != 0) goto L17;
        r11.width = 0;
    L18:
        parseDimensionRatioString(r11, r10);
        return;
    L17:
        r11.height = 0;
        goto L18
    L20:
        if (ZeusTransformUtils.instanceOf(r6, Layout.class) == false) goto L23;
        ((Layout) ZeusTransformUtils.preCheckCast(r6, Layout.class, "com.obric.memorydata.plugin")).dimensionRatio = r10;
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r6, Constraint.Delta.class) == false) goto L77;
        ((Constraint.Delta) ZeusTransformUtils.preCheckCast(r6, Constraint.Delta.class, "com.obric.memorydata.plugin")).add(5, r10);
        return;
    L77:
        return;
    L72:
        if (KEY_WEIGHT.equalsIgnoreCase(r3) == false) goto L48;
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L71
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L34;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L32;
        r13.width = 0;     // Catch: NumberFormatException -> L71
        r13.horizontalWeight = r12;     // Catch: NumberFormatException -> L71
        return;
    L32:
        r13.height = 0;     // Catch: NumberFormatException -> L71
        r13.verticalWeight = r12;     // Catch: NumberFormatException -> L71
        return;
    L34:
        if (ZeusTransformUtils.instanceOf(r6, Layout.class) == false) goto L40;
        Layout r14 = (Layout) ZeusTransformUtils.preCheckCast(r6, Layout.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L38;
        r14.mWidth = 0;     // Catch: NumberFormatException -> L71
        r14.horizontalWeight = r12;     // Catch: NumberFormatException -> L71
        return;
    L38:
        r14.mHeight = 0;     // Catch: NumberFormatException -> L71
        r14.verticalWeight = r12;     // Catch: NumberFormatException -> L71
        return;
    L40:
        if (ZeusTransformUtils.instanceOf(r6, Constraint.Delta.class) == false) goto L83;
        Constraint.Delta r15 = (Constraint.Delta) ZeusTransformUtils.preCheckCast(r6, Constraint.Delta.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L45;
        r15.add(23, 0);     // Catch: NumberFormatException -> L71
        int r16 = 39;
    L44:
        r15.add(r16, r12);     // Catch: NumberFormatException -> L71
        return;
    L45:
        r15.add(21, 0);     // Catch: NumberFormatException -> L71
        r16 = 40;
        goto L44
    L83:
        return;
    L48:
        if (KEY_PERCENT_PARENT.equalsIgnoreCase(r3) == true) goto L50;
        return;
    L50:
        float r17 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r10)));     // Catch: NumberFormatException -> L71
        if (ZeusTransformUtils.instanceOf(r6, ConstraintLayout.LayoutParams.class) == false) goto L57;
        ConstraintLayout.LayoutParams r18 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L55;
        r18.width = 0;     // Catch: NumberFormatException -> L71
        r18.matchConstraintPercentWidth = r17;     // Catch: NumberFormatException -> L71
        r18.matchConstraintDefaultWidth = 2;     // Catch: NumberFormatException -> L71
        return;
    L55:
        r18.height = 0;     // Catch: NumberFormatException -> L71
        r18.matchConstraintPercentHeight = r17;     // Catch: NumberFormatException -> L71
        r18.matchConstraintDefaultHeight = 2;     // Catch: NumberFormatException -> L71
        return;
    L57:
        if (ZeusTransformUtils.instanceOf(r6, Layout.class) == false) goto L63;
        Layout r19 = (Layout) ZeusTransformUtils.preCheckCast(r6, Layout.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L61;
        r19.mWidth = 0;     // Catch: NumberFormatException -> L71
        r19.widthPercent = r17;     // Catch: NumberFormatException -> L71
        r19.widthDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L61:
        r19.mHeight = 0;     // Catch: NumberFormatException -> L71
        r19.heightPercent = r17;     // Catch: NumberFormatException -> L71
        r19.heightDefault = 2;     // Catch: NumberFormatException -> L71
        return;
    L63:
        if (ZeusTransformUtils.instanceOf(r6, Constraint.Delta.class) == false) goto L90;
        Constraint.Delta r20 = (Constraint.Delta) ZeusTransformUtils.preCheckCast(r6, Constraint.Delta.class, "com.obric.memorydata.plugin");     // Catch: NumberFormatException -> L71
        if (r8 != 0) goto L68;
        r20.add(23, 0);     // Catch: NumberFormatException -> L71
        int r21 = 54;
    L67:
        r20.add(r21, 2);     // Catch: NumberFormatException -> L71
        return;
    L68:
        r20.add(21, 0);     // Catch: NumberFormatException -> L71
        r21 = 55;
        goto L67
    L90:
        return;
    L92:
        return;
    L74:
        return;
    }

    static void parseDimensionRatioString(ConstraintLayout.LayoutParams r8, String r9) {
        float r0 = Float.NaN;
        int r1 = -1;
        if (r9 == null) goto L34;
        int r2 = r9.length();
        int r3 = r9.indexOf(44);
        int r4 = 0;
        if (r3 > 0) goto L7;
    L15:
        int r5 = r9.indexOf(58);
        if (r5 >= 0) goto L18;
    L31:
        String r6 = r9.substring(r4);
        if (r6.length() <= 0) goto L34;
        r0 = Float.parseFloat(r6);     // Catch: NumberFormatException -> L36
    L37:
        goto L34
    L18:
        if (r5 >= (r2 - 1)) goto L31;
        String r7 = r9.substring(r4, r5);
        String r10 = r9.substring(r5 + 1);
        if (r7.length() <= 0) goto L34;
        if (r10.length() <= 0) goto L34;
        float r11 = Float.parseFloat(r7);     // Catch: NumberFormatException -> L36
        float r12 = Float.parseFloat(r10);     // Catch: NumberFormatException -> L36
        if (r11 <= 0.0f) goto L37;
        if (r12 <= 0.0f) goto L37;
        if (r1 != 1) goto L29;
        r0 = Math.abs(r12 / r11);     // Catch: NumberFormatException -> L36
        goto L37
    L29:
        r0 = Math.abs(r11 / r12);     // Catch: NumberFormatException -> L36
        goto L37
    L7:
        if (r3 >= (r2 - 1)) goto L15;
        String r13 = r9.substring(0, r3);
        if (r13.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L12;
        r1 = 0;
    L14:
        r4 = r3 + 1;
        goto L15
    L12:
        if (r13.equalsIgnoreCase(i.n) == false) goto L14;
        r1 = 1;
    L34:
        r8.dimensionRatio = r9;
        r8.dimensionRatioValue = r0;
        r8.dimensionRatioSide = r1;
    }

    private void populateConstraint(Context r10, Constraint r11, TypedArray r12, boolean r13) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r13 == false) goto L6;
        populateOverride(r9, r11, r12);
        return;
    L6:
        int r14 = r12.getIndexCount();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L138;
        int r0 = r12.getIndex(r15);
        if (r0 == ZeusTransformUtils.mapRes(R.styleable.Constraint_android_id, "styleable", "Constraint_android_id")) goto L16;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginStart, "styleable", "Constraint_android_layout_marginStart") == r0) goto L16;
        if (ZeusTransformUtils.mapRes(R.styleable.Constraint_android_layout_marginEnd, "styleable", "Constraint_android_layout_marginEnd") == r0) goto L16;
        r11.motion.mApply = true;
        r11.layout.mApply = true;
        r11.propertySet.mApply = true;
        r11.transform.mApply = true;
    L16:
        switch(mapToConstant.get(r0)) {
            case 1: goto L135;
            case 2: goto L134;
            case 3: goto L133;
            case 4: goto L132;
            case 5: goto L131;
            case 6: goto L130;
            case 7: goto L129;
            case 8: goto L127;
            case 9: goto L125;
            case 10: goto L124;
            case 11: goto L123;
            case 12: goto L122;
            case 13: goto L121;
            case 14: goto L120;
            case 15: goto L119;
            case 16: goto L118;
            case 17: goto L117;
            case 18: goto L116;
            case 19: goto L115;
            case 20: goto L114;
            case 21: goto L113;
            case 22: goto L112;
            case 23: goto L111;
            case 24: goto L110;
            case 25: goto L109;
            case 26: goto L108;
            case 27: goto L107;
            case 28: goto L106;
            case 29: goto L105;
            case 30: goto L104;
            case 31: goto L102;
            case 32: goto L100;
            case 33: goto L99;
            case 34: goto L98;
            case 35: goto L97;
            case 36: goto L96;
            case 37: goto L95;
            case 38: goto L94;
            case 39: goto L93;
            case 40: goto L92;
            case 41: goto L91;
            case 42: goto L90;
            case 43: goto L89;
            case 44: goto L87;
            case 45: goto L85;
            case 46: goto L84;
            case 47: goto L83;
            case 48: goto L82;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L79;
            case 52: goto L78;
            case 53: goto L76;
            case 54: goto L74;
            case 55: goto L73;
            case 56: goto L72;
            case 57: goto L71;
            case 58: goto L70;
            case 59: goto L69;
            case 60: goto L68;
            case 61: goto L67;
            case 62: goto L66;
            case 63: goto L65;
            case 64: goto L64;
            case 65: goto L60;
            case 66: goto L58;
            case 67: goto L57;
            case 68: goto L56;
            case 69: goto L55;
            case 70: goto L54;
            case 71: goto L53;
            case 72: goto L52;
            case 73: goto L51;
            case 74: goto L50;
            case 75: goto L49;
            case 76: goto L48;
            case 77: goto L47;
            case 78: goto L46;
            case 79: goto L45;
            case 80: goto L44;
            case 81: goto L43;
            case 82: goto L42;
            case 83: goto L41;
            case 84: goto L40;
            case 85: goto L39;
            case 86: goto L27;
            case 87: goto L25;
            case 88: goto L17;
            case 89: goto L17;
            case 90: goto L17;
            case 91: goto L24;
            case 92: goto L23;
            case 93: goto L22;
            case 94: goto L21;
            case 95: goto L20;
            case 96: goto L19;
            case 97: goto L18;
            default: goto L17;
        };
    L17:
        StringBuilder r1 = new StringBuilder();
        String r3 = "Unknown attribute 0x";
    L26:
        Log.w(TAG, r1.append(r3).append(Integer.toHexString(r0)).append("   ").append(mapToConstant.get(r0)).toString());
    L136:
        r15 = r15 + 1;
        goto L7
    L18:
        r11.layout.mWrapBehavior = r12.getInt(r0, r11.layout.mWrapBehavior);
        goto L136
    L19:
        parseDimensionConstraints(r11.layout, r12, r0, 1);
        goto L136
    L20:
        parseDimensionConstraints(r11.layout, r12, r0, 0);
        goto L136
    L21:
        r11.layout.goneBaselineMargin = r12.getDimensionPixelSize(r0, r11.layout.goneBaselineMargin);
        goto L136
    L22:
        r11.layout.baselineMargin = r12.getDimensionPixelSize(r0, r11.layout.baselineMargin);
        goto L136
    L23:
        r11.layout.baselineToBottom = lookupID(r12, r0, r11.layout.baselineToBottom);
        goto L136
    L24:
        r11.layout.baselineToTop = lookupID(r12, r0, r11.layout.baselineToTop);
        goto L136
    L25:
        r1 = new StringBuilder();
        r3 = "unused attribute 0x";
        goto L26
    L27:
        TypedValue r2 = r12.peekValue(r0);
        if (r2.type != 1) goto L33;
        r11.motion.mQuantizeInterpolatorID = r12.getResourceId(r0, -1);
        if (r11.motion.mQuantizeInterpolatorID == (-1)) goto L136;
    L31:
        r11.motion.mQuantizeInterpolatorType = -2;
        goto L136
    L33:
        if (r2.type != 3) goto L38;
        r11.motion.mQuantizeInterpolatorString = r12.getString(r0);
        if (r11.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L37;
        r11.motion.mQuantizeInterpolatorID = r12.getResourceId(r0, -1);
        goto L31
    L37:
        r11.motion.mQuantizeInterpolatorType = -1;
        goto L136
    L38:
        r11.motion.mQuantizeInterpolatorType = r12.getInteger(r0, r11.motion.mQuantizeInterpolatorID);
        goto L136
    L39:
        r11.motion.mQuantizeMotionPhase = r12.getFloat(r0, r11.motion.mQuantizeMotionPhase);
        goto L136
    L40:
        r11.motion.mQuantizeMotionSteps = r12.getInteger(r0, r11.motion.mQuantizeMotionSteps);
        goto L136
    L41:
        r11.transform.transformPivotTarget = lookupID(r12, r0, r11.transform.transformPivotTarget);
        goto L136
    L42:
        r11.motion.mAnimateCircleAngleTo = r12.getInteger(r0, r11.motion.mAnimateCircleAngleTo);
        goto L136
    L43:
        r11.layout.constrainedHeight = r12.getBoolean(r0, r11.layout.constrainedHeight);
        goto L136
    L44:
        r11.layout.constrainedWidth = r12.getBoolean(r0, r11.layout.constrainedWidth);
        goto L136
    L45:
        r11.motion.mMotionStagger = r12.getFloat(r0, r11.motion.mMotionStagger);
        goto L136
    L46:
        r11.propertySet.mVisibilityMode = r12.getInt(r0, r11.propertySet.mVisibilityMode);
        goto L136
    L47:
        r11.layout.mConstraintTag = r12.getString(r0);
        goto L136
    L48:
        r11.motion.mPathMotionArc = r12.getInt(r0, r11.motion.mPathMotionArc);
        goto L136
    L49:
        r11.layout.mBarrierAllowsGoneWidgets = r12.getBoolean(r0, r11.layout.mBarrierAllowsGoneWidgets);
        goto L136
    L50:
        r11.layout.mReferenceIdString = r12.getString(r0);
        goto L136
    L51:
        r11.layout.mBarrierMargin = r12.getDimensionPixelSize(r0, r11.layout.mBarrierMargin);
        goto L136
    L52:
        r11.layout.mBarrierDirection = r12.getInt(r0, r11.layout.mBarrierDirection);
        goto L136
    L53:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L136
    L54:
        r11.layout.heightPercent = r12.getFloat(r0, 1.0f);
        goto L136
    L55:
        r11.layout.widthPercent = r12.getFloat(r0, 1.0f);
        goto L136
    L56:
        r11.propertySet.mProgress = r12.getFloat(r0, r11.propertySet.mProgress);
        goto L136
    L57:
        r11.motion.mPathRotate = r12.getFloat(r0, r11.motion.mPathRotate);
        goto L136
    L58:
        r11.motion.mDrawPath = r12.getInt(r0, 0);
        goto L136
    L64:
        r11.motion.mAnimateRelativeTo = lookupID(r12, r0, r11.motion.mAnimateRelativeTo);
        goto L136
    L65:
        r11.layout.circleAngle = r12.getFloat(r0, r11.layout.circleAngle);
        goto L136
    L66:
        r11.layout.circleRadius = r12.getDimensionPixelSize(r0, r11.layout.circleRadius);
        goto L136
    L67:
        r11.layout.circleConstraint = lookupID(r12, r0, r11.layout.circleConstraint);
        goto L136
    L68:
        r11.transform.rotation = r12.getFloat(r0, r11.transform.rotation);
        goto L136
    L69:
        r11.layout.heightMin = r12.getDimensionPixelSize(r0, r11.layout.heightMin);
        goto L136
    L70:
        r11.layout.widthMin = r12.getDimensionPixelSize(r0, r11.layout.widthMin);
        goto L136
    L71:
        r11.layout.heightMax = r12.getDimensionPixelSize(r0, r11.layout.heightMax);
        goto L136
    L72:
        r11.layout.widthMax = r12.getDimensionPixelSize(r0, r11.layout.widthMax);
        goto L136
    L73:
        r11.layout.heightDefault = r12.getInt(r0, r11.layout.heightDefault);
        goto L136
    L74:
        r11.layout.widthDefault = r12.getInt(r0, r11.layout.widthDefault);
        goto L136
    L78:
        r11.transform.translationY = r12.getDimension(r0, r11.transform.translationY);
        goto L136
    L79:
        r11.transform.translationX = r12.getDimension(r0, r11.transform.translationX);
        goto L136
    L80:
        r11.transform.transformPivotY = r12.getDimension(r0, r11.transform.transformPivotY);
        goto L136
    L81:
        r11.transform.transformPivotX = r12.getDimension(r0, r11.transform.transformPivotX);
        goto L136
    L82:
        r11.transform.scaleY = r12.getFloat(r0, r11.transform.scaleY);
        goto L136
    L83:
        r11.transform.scaleX = r12.getFloat(r0, r11.transform.scaleX);
        goto L136
    L84:
        r11.transform.rotationY = r12.getFloat(r0, r11.transform.rotationY);
        goto L136
    L85:
        r11.transform.rotationX = r12.getFloat(r0, r11.transform.rotationX);
        goto L136
    L89:
        r11.propertySet.alpha = r12.getFloat(r0, r11.propertySet.alpha);
        goto L136
    L90:
        r11.layout.verticalChainStyle = r12.getInt(r0, r11.layout.verticalChainStyle);
        goto L136
    L91:
        r11.layout.horizontalChainStyle = r12.getInt(r0, r11.layout.horizontalChainStyle);
        goto L136
    L92:
        r11.layout.verticalWeight = r12.getFloat(r0, r11.layout.verticalWeight);
        goto L136
    L93:
        r11.layout.horizontalWeight = r12.getFloat(r0, r11.layout.horizontalWeight);
        goto L136
    L94:
        r11.mViewId = r12.getResourceId(r0, r11.mViewId);
        goto L136
    L95:
        r11.layout.verticalBias = r12.getFloat(r0, r11.layout.verticalBias);
        goto L136
    L96:
        r11.layout.topToTop = lookupID(r12, r0, r11.layout.topToTop);
        goto L136
    L97:
        r11.layout.topToBottom = lookupID(r12, r0, r11.layout.topToBottom);
        goto L136
    L98:
        r11.layout.topMargin = r12.getDimensionPixelSize(r0, r11.layout.topMargin);
        goto L136
    L99:
        r11.layout.startToStart = lookupID(r12, r0, r11.layout.startToStart);
        goto L136
    L100:
        r11.layout.startToEnd = lookupID(r12, r0, r11.layout.startToEnd);
        goto L136
    L104:
        r11.layout.rightToRight = lookupID(r12, r0, r11.layout.rightToRight);
        goto L136
    L105:
        r11.layout.rightToLeft = lookupID(r12, r0, r11.layout.rightToLeft);
        goto L136
    L106:
        r11.layout.rightMargin = r12.getDimensionPixelSize(r0, r11.layout.rightMargin);
        goto L136
    L107:
        r11.layout.orientation = r12.getInt(r0, r11.layout.orientation);
        goto L136
    L108:
        r11.layout.leftToRight = lookupID(r12, r0, r11.layout.leftToRight);
        goto L136
    L109:
        r11.layout.leftToLeft = lookupID(r12, r0, r11.layout.leftToLeft);
        goto L136
    L110:
        r11.layout.leftMargin = r12.getDimensionPixelSize(r0, r11.layout.leftMargin);
        goto L136
    L111:
        r11.layout.mWidth = r12.getLayoutDimension(r0, r11.layout.mWidth);
        goto L136
    L112:
        r11.propertySet.visibility = r12.getInt(r0, r11.propertySet.visibility);
        r11.propertySet.visibility = VISIBILITY_FLAGS[r11.propertySet.visibility];
        goto L136
    L113:
        r11.layout.mHeight = r12.getLayoutDimension(r0, r11.layout.mHeight);
        goto L136
    L114:
        r11.layout.horizontalBias = r12.getFloat(r0, r11.layout.horizontalBias);
        goto L136
    L115:
        r11.layout.guidePercent = r12.getFloat(r0, r11.layout.guidePercent);
        goto L136
    L116:
        r11.layout.guideEnd = r12.getDimensionPixelOffset(r0, r11.layout.guideEnd);
        goto L136
    L117:
        r11.layout.guideBegin = r12.getDimensionPixelOffset(r0, r11.layout.guideBegin);
        goto L136
    L118:
        r11.layout.goneTopMargin = r12.getDimensionPixelSize(r0, r11.layout.goneTopMargin);
        goto L136
    L119:
        r11.layout.goneStartMargin = r12.getDimensionPixelSize(r0, r11.layout.goneStartMargin);
        goto L136
    L120:
        r11.layout.goneRightMargin = r12.getDimensionPixelSize(r0, r11.layout.goneRightMargin);
        goto L136
    L121:
        r11.layout.goneLeftMargin = r12.getDimensionPixelSize(r0, r11.layout.goneLeftMargin);
        goto L136
    L122:
        r11.layout.goneEndMargin = r12.getDimensionPixelSize(r0, r11.layout.goneEndMargin);
        goto L136
    L123:
        r11.layout.goneBottomMargin = r12.getDimensionPixelSize(r0, r11.layout.goneBottomMargin);
        goto L136
    L124:
        r11.layout.endToStart = lookupID(r12, r0, r11.layout.endToStart);
        goto L136
    L125:
        r11.layout.endToEnd = lookupID(r12, r0, r11.layout.endToEnd);
        goto L136
    L129:
        r11.layout.editorAbsoluteY = r12.getDimensionPixelOffset(r0, r11.layout.editorAbsoluteY);
        goto L136
    L130:
        r11.layout.editorAbsoluteX = r12.getDimensionPixelOffset(r0, r11.layout.editorAbsoluteX);
        goto L136
    L131:
        r11.layout.dimensionRatio = r12.getString(r0);
        goto L136
    L132:
        r11.layout.bottomToTop = lookupID(r12, r0, r11.layout.bottomToTop);
        goto L136
    L133:
        r11.layout.bottomToBottom = lookupID(r12, r0, r11.layout.bottomToBottom);
        goto L136
    L134:
        r11.layout.bottomMargin = r12.getDimensionPixelSize(r0, r11.layout.bottomMargin);
        goto L136
    L135:
        r11.layout.baselineToBaseline = lookupID(r12, r0, r11.layout.baselineToBaseline);
        goto L136
    L60:
        if (r12.peekValue(r0).type != 3) goto L62;
        Motion r4 = r11.motion;
        String r5 = r12.getString(r0);
    L63:
        r4.mTransitionEasing = r5;
        goto L136
    L62:
        r4 = r11.motion;
        r5 = Easing.NAMED_EASING[r12.getInteger(r0, 0)];
        goto L63
    L76:
        if (Build.VERSION.SDK_INT < 21) goto L136;
        r11.transform.translationZ = r12.getDimension(r0, r11.transform.translationZ);
        goto L136
    L87:
        if (Build.VERSION.SDK_INT < 21) goto L136;
        r11.transform.applyElevation = true;
        r11.transform.elevation = r12.getDimension(r0, r11.transform.elevation);
        goto L136
    L102:
        if (Build.VERSION.SDK_INT < 17) goto L136;
        r11.layout.startMargin = r12.getDimensionPixelSize(r0, r11.layout.startMargin);
        goto L136
    L127:
        if (Build.VERSION.SDK_INT < 17) goto L136;
        r11.layout.endMargin = r12.getDimensionPixelSize(r0, r11.layout.endMargin);
        goto L136
    L138:
        if (r11.layout.mReferenceIdString == null) goto L243;
        r11.layout.mReferenceIds = null;
        return;
    }

    private static void populateOverride(Context r13, Constraint r14, TypedArray r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        int r17 = r15.getIndexCount();
        Constraint.Delta r0 = new Constraint.Delta();
        r14.mDelta = r0;
        r14.motion.mApply = false;
        r14.layout.mApply = false;
        r14.propertySet.mApply = false;
        r14.transform.mApply = false;
        int r1 = 0;
    L3:
        if (r1 >= r17) goto L133;
        int r3 = r15.getIndex(r1);
        float r5 = 1.0f;
        int r9 = 17;
        switch(overrideMapToConstant.get(r3)) {
            case 2: goto L129;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L127;
            case 6: goto L125;
            case 7: goto L124;
            case 8: goto L122;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L120;
            case 12: goto L119;
            case 13: goto L118;
            case 14: goto L117;
            case 15: goto L116;
            case 16: goto L115;
            case 17: goto L113;
            case 18: goto L112;
            case 19: goto L109;
            case 20: goto L108;
            case 21: goto L107;
            case 22: goto L106;
            case 23: goto L105;
            case 24: goto L104;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L102;
            case 28: goto L101;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L99;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L97;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L96;
            case 38: goto L95;
            case 39: goto L94;
            case 40: goto L93;
            case 41: goto L92;
            case 42: goto L91;
            case 43: goto L90;
            case 44: goto L88;
            case 45: goto L86;
            case 46: goto L85;
            case 47: goto L84;
            case 48: goto L83;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L79;
            case 52: goto L78;
            case 53: goto L76;
            case 54: goto L74;
            case 55: goto L73;
            case 56: goto L72;
            case 57: goto L71;
            case 58: goto L70;
            case 59: goto L69;
            case 60: goto L68;
            case 61: goto L6;
            case 62: goto L67;
            case 63: goto L66;
            case 64: goto L64;
            case 65: goto L60;
            case 66: goto L58;
            case 67: goto L57;
            case 68: goto L56;
            case 69: goto L55;
            case 70: goto L54;
            case 71: goto L53;
            case 72: goto L52;
            case 73: goto L51;
            case 74: goto L50;
            case 75: goto L48;
            case 76: goto L47;
            case 77: goto L46;
            case 78: goto L45;
            case 79: goto L44;
            case 80: goto L43;
            case 81: goto L42;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
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
        StringBuilder r4 = new StringBuilder();
        String r6 = "Unknown attribute 0x";
    L7:
        Log.w(TAG, r4.append(r6).append(Integer.toHexString(r3)).append("   ").append(mapToConstant.get(r3)).toString());
    L132:
        r1 = r1 + 1;
        goto L3
    L8:
        int r7 = 99;
        boolean r8 = r14.layout.guidelineUseRtl;
    L49:
        r0.add(r7, r15.getBoolean(r3, r8));
        goto L132
    L18:
        int r10 = LAYOUT_WRAP_BEHAVIOR;
        int r11 = r14.layout.mWrapBehavior;
    L103:
        int r12 = r15.getInt(r3, r11);
    L131:
        r0.add(r10, r12);
        goto L132
    L19:
        parseDimensionConstraints(r0, r15, r3, 1);
        goto L132
    L20:
        parseDimensionConstraints(r0, r15, r3, 0);
        goto L132
    L21:
        r10 = GONE_BASELINE_MARGIN;
        int r18 = r14.layout.goneBaselineMargin;
    L130:
        r12 = r15.getDimensionPixelSize(r3, r18);
        goto L131
    L22:
        r10 = BASELINE_MARGIN;
        r18 = r14.layout.baselineMargin;
        goto L130
    L23:
        r4 = new StringBuilder();
        r6 = "unused attribute 0x";
        goto L7
    L24:
        TypedValue r19 = r15.peekValue(r3);
        r9 = 88;
        if (r19.type != 1) goto L30;
        r14.motion.mQuantizeInterpolatorID = r15.getResourceId(r3, -1);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_ID, r14.motion.mQuantizeInterpolatorID);
        if (r14.motion.mQuantizeInterpolatorID == (-1)) goto L132;
    L28:
        r14.motion.mQuantizeInterpolatorType = -2;
    L36:
        int r20 = r14.motion.mQuantizeInterpolatorType;
    L114:
        r0.add(r9, r20);
        goto L132
    L30:
        if (r19.type != 3) goto L35;
        r14.motion.mQuantizeInterpolatorString = r15.getString(r3);
        r0.add(90, r14.motion.mQuantizeInterpolatorString);
        if (r14.motion.mQuantizeInterpolatorString.indexOf("/") <= 0) goto L34;
        r14.motion.mQuantizeInterpolatorID = r15.getResourceId(r3, -1);
        r0.add(QUANTIZE_MOTION_INTERPOLATOR_ID, r14.motion.mQuantizeInterpolatorID);
        goto L28
    L34:
        r14.motion.mQuantizeInterpolatorType = -1;
        goto L36
    L35:
        r14.motion.mQuantizeInterpolatorType = r15.getInteger(r3, r14.motion.mQuantizeInterpolatorID);
        goto L36
    L37:
        int r21 = 85;
        r5 = r14.motion.mQuantizeMotionPhase;
    L110:
        float r22 = r15.getFloat(r3, r5);
    L111:
        r0.add(r21, r22);
        goto L132
    L38:
        r10 = 84;
        int r23 = r14.motion.mQuantizeMotionSteps;
    L41:
        r12 = r15.getInteger(r3, r23);
        goto L131
    L39:
        r10 = 83;
        int r24 = r14.transform.transformPivotTarget;
    L65:
        r12 = lookupID(r15, r3, r24);
        goto L131
    L40:
        r10 = 82;
        r23 = r14.motion.mAnimateCircleAngleTo;
        goto L41
    L42:
        r7 = 81;
        r8 = r14.layout.constrainedHeight;
        goto L49
    L43:
        r7 = 80;
        r8 = r14.layout.constrainedWidth;
        goto L49
    L44:
        r21 = 79;
        r5 = r14.motion.mMotionStagger;
        goto L110
    L45:
        r10 = 78;
        r11 = r14.propertySet.mVisibilityMode;
        goto L103
    L46:
        int r25 = 77;
    L128:
        r0.add(r25, r15.getString(r3));
        goto L132
    L47:
        r10 = 76;
        r11 = r14.motion.mPathMotionArc;
        goto L103
    L48:
        r7 = 75;
        r8 = r14.layout.mBarrierAllowsGoneWidgets;
        goto L49
    L50:
        r25 = 74;
        goto L128
    L51:
        r10 = BARRIER_MARGIN;
        r18 = r14.layout.mBarrierMargin;
        goto L130
    L52:
        r10 = BARRIER_DIRECTION;
        r11 = r14.layout.mBarrierDirection;
        goto L103
    L53:
        Log.e(TAG, "CURRENTLY UNSUPPORTED");
        goto L132
    L54:
        r21 = 70;
        goto L110
    L55:
        r21 = 69;
        goto L110
    L56:
        r21 = 68;
        r5 = r14.propertySet.mProgress;
        goto L110
    L57:
        r21 = 67;
        r5 = r14.motion.mPathRotate;
        goto L110
    L58:
        r10 = 66;
        r12 = r15.getInt(r3, 0);
        goto L131
    L64:
        r10 = 64;
        r24 = r14.motion.mAnimateRelativeTo;
        goto L65
    L66:
        r21 = 63;
        r5 = r14.layout.circleAngle;
        goto L110
    L67:
        r10 = 62;
        r18 = r14.layout.circleRadius;
        goto L130
    L68:
        r21 = 60;
        r5 = r14.transform.rotation;
        goto L110
    L69:
        r10 = 59;
        r18 = r14.layout.heightMin;
        goto L130
    L70:
        r10 = 58;
        r18 = r14.layout.widthMin;
        goto L130
    L71:
        r10 = 57;
        r18 = r14.layout.heightMax;
        goto L130
    L72:
        r10 = 56;
        r18 = r14.layout.widthMax;
        goto L130
    L73:
        r10 = 55;
        r11 = r14.layout.heightDefault;
        goto L103
    L74:
        r10 = 54;
        r11 = r14.layout.widthDefault;
        goto L103
    L78:
        r21 = 52;
        float r26 = r14.transform.translationY;
    L82:
        r22 = r15.getDimension(r3, r26);
        goto L111
    L79:
        r21 = 51;
        r26 = r14.transform.translationX;
        goto L82
    L80:
        r21 = 50;
        r26 = r14.transform.transformPivotY;
        goto L82
    L81:
        r21 = 49;
        r26 = r14.transform.transformPivotX;
        goto L82
    L83:
        r21 = 48;
        r5 = r14.transform.scaleY;
        goto L110
    L84:
        r21 = 47;
        r5 = r14.transform.scaleX;
        goto L110
    L85:
        r21 = 46;
        r5 = r14.transform.rotationY;
        goto L110
    L86:
        r21 = 45;
        r5 = r14.transform.rotationX;
        goto L110
    L90:
        r21 = 43;
        r5 = r14.propertySet.alpha;
        goto L110
    L91:
        r10 = 42;
        r11 = r14.layout.verticalChainStyle;
        goto L103
    L92:
        r10 = 41;
        r11 = r14.layout.horizontalChainStyle;
        goto L103
    L93:
        r21 = 40;
        r5 = r14.layout.verticalWeight;
        goto L110
    L94:
        r21 = 39;
        r5 = r14.layout.horizontalWeight;
        goto L110
    L95:
        r14.mViewId = r15.getResourceId(r3, r14.mViewId);
        r0.add(38, r14.mViewId);
        goto L132
    L96:
        r21 = 37;
        r5 = r14.layout.verticalBias;
        goto L110
    L97:
        r10 = 34;
        r18 = r14.layout.topMargin;
        goto L130
    L101:
        r10 = 28;
        r18 = r14.layout.rightMargin;
        goto L130
    L102:
        r10 = 27;
        r11 = r14.layout.orientation;
        goto L103
    L104:
        r10 = 24;
        r18 = r14.layout.leftMargin;
        goto L130
    L105:
        r10 = 23;
        r12 = r15.getLayoutDimension(r3, r14.layout.mWidth);
        goto L131
    L106:
        r10 = 22;
        r12 = VISIBILITY_FLAGS[r15.getInt(r3, r14.propertySet.visibility)];
        goto L131
    L107:
        r0.add(21, r15.getLayoutDimension(r3, r14.layout.mHeight));
        goto L132
    L108:
        r21 = 20;
        r5 = r14.layout.horizontalBias;
        goto L110
    L109:
        r21 = 19;
        r5 = r14.layout.guidePercent;
        goto L110
    L112:
        r10 = 18;
        int r27 = r14.layout.guideEnd;
    L126:
        r12 = r15.getDimensionPixelOffset(r3, r27);
        goto L131
    L113:
        r20 = r15.getDimensionPixelOffset(r3, r14.layout.guideBegin);
        goto L114
    L115:
        r10 = 16;
        r18 = r14.layout.goneTopMargin;
        goto L130
    L116:
        r10 = 15;
        r18 = r14.layout.goneStartMargin;
        goto L130
    L117:
        r10 = 14;
        r18 = r14.layout.goneRightMargin;
        goto L130
    L118:
        r10 = 13;
        r18 = r14.layout.goneLeftMargin;
        goto L130
    L119:
        r10 = 12;
        r18 = r14.layout.goneEndMargin;
        goto L130
    L120:
        r10 = 11;
        r18 = r14.layout.goneBottomMargin;
        goto L130
    L124:
        r10 = 7;
        r27 = r14.layout.editorAbsoluteY;
        goto L126
    L125:
        r10 = 6;
        r27 = r14.layout.editorAbsoluteX;
        goto L126
    L127:
        r25 = 5;
        goto L128
    L129:
        r10 = 2;
        r18 = r14.layout.bottomMargin;
        goto L130
    L10:
        if (MotionLayout.IS_IN_EDIT_MODE == false) goto L15;
        r14.mViewId = r15.getResourceId(r3, r14.mViewId);
        if (r14.mViewId != (-1)) goto L132;
    L16:
        r14.mTargetString = r15.getString(r3);
        goto L132
    L15:
        if (r15.peekValue(r3).type == 3) goto L16;
        r14.mViewId = r15.getResourceId(r3, r14.mViewId);
        goto L132
    L60:
        if (r15.peekValue(r3).type != 3) goto L62;
        String r28 = r15.getString(r3);
    L63:
        r0.add(65, r28);
        goto L132
    L62:
        r28 = Easing.NAMED_EASING[r15.getInteger(r3, 0)];
        goto L63
    L76:
        if (Build.VERSION.SDK_INT < 21) goto L132;
        r21 = 53;
        r26 = r14.transform.translationZ;
        goto L82
    L88:
        if (Build.VERSION.SDK_INT < 21) goto L132;
        r21 = 44;
        r0.add(44, true);
        r26 = r14.transform.elevation;
        goto L82
    L99:
        if (Build.VERSION.SDK_INT < 17) goto L132;
        r10 = 31;
        r18 = r14.layout.startMargin;
        goto L130
    L122:
        if (Build.VERSION.SDK_INT < 17) goto L132;
        r10 = 8;
        r18 = r14.layout.endMargin;
        goto L130
    }

    private static void setDeltaValue(Constraint r1, int r2, float r3) {
        if (r2 != 19) goto L5;
        r1.layout.guidePercent = r3;
        return;
    L5:
        if (r2 != 20) goto L7;
        r1.layout.horizontalBias = r3;
        return;
    L7:
        if (r2 != 37) goto L9;
        r1.layout.verticalBias = r3;
        return;
    L9:
        if (r2 != 60) goto L11;
        r1.transform.rotation = r3;
        return;
    L11:
        if (r2 != 63) goto L13;
        r1.layout.circleAngle = r3;
        return;
    L13:
        if (r2 != 79) goto L15;
        r1.motion.mMotionStagger = r3;
        return;
    L15:
        if (r2 != 85) goto L17;
        r1.motion.mQuantizeMotionPhase = r3;
        return;
    L17:
        if (r2 != 87) goto L19;
        return;
    L19:
        if (r2 != 39) goto L21;
        r1.layout.horizontalWeight = r3;
        return;
    L21:
        if (r2 == 40) goto L40;
        switch(r2) {
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
        switch(r2) {
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
        r1.layout.heightPercent = r3;
        return;
    L26:
        r1.layout.widthPercent = r3;
        return;
    L27:
        r1.propertySet.mProgress = r3;
        return;
    L28:
        r1.motion.mPathRotate = r3;
        return;
    L29:
        r1.transform.translationZ = r3;
        return;
    L30:
        r1.transform.translationY = r3;
        return;
    L31:
        r1.transform.translationX = r3;
        return;
    L32:
        r1.transform.transformPivotY = r3;
        return;
    L33:
        r1.transform.transformPivotX = r3;
        return;
    L34:
        r1.transform.scaleY = r3;
        return;
    L35:
        r1.transform.scaleX = r3;
        return;
    L36:
        r1.transform.rotationY = r3;
        return;
    L37:
        r1.transform.rotationX = r3;
        return;
    L38:
        r1.transform.elevation = r3;
        r1.transform.applyElevation = true;
        return;
    L39:
        r1.propertySet.alpha = r3;
        return;
    L40:
        r1.layout.verticalWeight = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, int r3) {
        if (r2 != 6) goto L5;
        r1.layout.editorAbsoluteX = r3;
        return;
    L5:
        if (r2 != 7) goto L7;
        r1.layout.editorAbsoluteY = r3;
        return;
    L7:
        if (r2 != 8) goto L9;
        r1.layout.endMargin = r3;
        return;
    L9:
        if (r2 != 27) goto L11;
        r1.layout.orientation = r3;
        return;
    L11:
        if (r2 != 28) goto L13;
        r1.layout.rightMargin = r3;
        return;
    L13:
        if (r2 != 41) goto L15;
        r1.layout.horizontalChainStyle = r3;
        return;
    L15:
        if (r2 != 42) goto L17;
        r1.layout.verticalChainStyle = r3;
        return;
    L17:
        if (r2 != 61) goto L19;
        r1.layout.circleConstraint = r3;
        return;
    L19:
        if (r2 != 62) goto L21;
        r1.layout.circleRadius = r3;
        return;
    L21:
        if (r2 != BARRIER_DIRECTION) goto L23;
        r1.layout.mBarrierDirection = r3;
        return;
    L23:
        if (r2 == BARRIER_MARGIN) goto L64;
        switch(r2) {
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
        switch(r2) {
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            default: goto L26;
        };
    L26:
        switch(r2) {
            case 54: goto L40;
            case 55: goto L39;
            case 56: goto L38;
            case 57: goto L37;
            case 58: goto L36;
            case 59: goto L35;
            default: goto L27;
        };
    L27:
        switch(r2) {
            case 82: goto L34;
            case 83: goto L33;
            case 84: goto L32;
            default: goto L28;
        };
    L28:
        switch(r2) {
            case 87: goto L76;
            case 88: goto L31;
            case 89: goto L30;
            default: goto L29;
        };
    L29:
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L30:
        r1.motion.mQuantizeInterpolatorID = r3;
        return;
    L31:
        r1.motion.mQuantizeInterpolatorType = r3;
        return;
    L76:
        return;
    L32:
        r1.motion.mQuantizeMotionSteps = r3;
        return;
    L33:
        r1.transform.transformPivotTarget = r3;
        return;
    L34:
        r1.motion.mAnimateCircleAngleTo = r3;
        return;
    L35:
        r1.layout.heightMin = r3;
        return;
    L36:
        r1.layout.widthMin = r3;
        return;
    L37:
        r1.layout.heightMax = r3;
        return;
    L38:
        r1.layout.widthMax = r3;
        return;
    L39:
        r1.layout.heightDefault = r3;
        return;
    L40:
        r1.layout.widthDefault = r3;
        return;
    L41:
        r1.layout.leftMargin = r3;
        return;
    L42:
        r1.layout.mWidth = r3;
        return;
    L43:
        r1.propertySet.visibility = r3;
        return;
    L44:
        r1.layout.mHeight = r3;
        return;
    L45:
        r1.layout.mWrapBehavior = r3;
        return;
    L46:
        r1.layout.goneBaselineMargin = r3;
        return;
    L47:
        r1.layout.baselineMargin = r3;
        return;
    L48:
        r1.propertySet.mVisibilityMode = r3;
        return;
    L49:
        r1.motion.mPathMotionArc = r3;
        return;
    L50:
        r1.motion.mDrawPath = r3;
        return;
    L51:
        r1.motion.mAnimateRelativeTo = r3;
        return;
    L52:
        r1.mViewId = r3;
        return;
    L53:
        r1.layout.topMargin = r3;
        return;
    L54:
        r1.layout.startMargin = r3;
        return;
    L55:
        r1.layout.guideEnd = r3;
        return;
    L56:
        r1.layout.guideBegin = r3;
        return;
    L57:
        r1.layout.goneTopMargin = r3;
        return;
    L58:
        r1.layout.goneStartMargin = r3;
        return;
    L59:
        r1.layout.goneRightMargin = r3;
        return;
    L60:
        r1.layout.goneLeftMargin = r3;
        return;
    L61:
        r1.layout.goneEndMargin = r3;
        return;
    L62:
        r1.layout.goneBottomMargin = r3;
        return;
    L63:
        r1.layout.bottomMargin = r3;
        return;
    L64:
        r1.layout.mBarrierMargin = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, String r3) {
        if (r2 != 5) goto L5;
        r1.layout.dimensionRatio = r3;
        return;
    L5:
        if (r2 != 65) goto L7;
        r1.motion.mTransitionEasing = r3;
        return;
    L7:
        if (r2 != 74) goto L9;
        r1.layout.mReferenceIdString = r3;
        r1.layout.mReferenceIds = null;
        return;
    L9:
        if (r2 != 77) goto L11;
        r1.layout.mConstraintTag = r3;
        return;
    L11:
        if (r2 != 87) goto L13;
        return;
    L13:
        if (r2 == 90) goto L15;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L15:
        r1.motion.mQuantizeInterpolatorString = r3;
    }

    private static void setDeltaValue(Constraint r1, int r2, boolean r3) {
        if (r2 != 44) goto L5;
        r1.transform.applyElevation = r3;
        return;
    L5:
        if (r2 != 75) goto L7;
        r1.layout.mBarrierAllowsGoneWidgets = r3;
        return;
    L7:
        if (r2 != 87) goto L9;
        return;
    L9:
        if (r2 != 80) goto L11;
        r1.layout.constrainedWidth = r3;
        return;
    L11:
        if (r2 == 81) goto L13;
        Log.w(TAG, "Unknown attribute 0x");
        return;
    L13:
        r1.layout.constrainedHeight = r3;
    }

    private String sideToString(int r1) {
        switch(r1) {
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

    private static String[] splitString(String r6) {
        char[] r7 = r6.toCharArray();
        ArrayList r0 = new ArrayList();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r1 >= r7.length) goto L13;
        if (r7[r1] != ',') goto L10;
        if (r3 == true) goto L10;
        r0.add(new String(r7, r2, r1 - r2));
        r2 = r1 + 1;
    L12:
        r1 = r1 + 1;
    L10:
        if (r7[r1] != '\"') goto L12;
        r3 = !r3;
        goto L12
    L13:
        r0.add(new String(r7, r2, r7.length - r2));
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.memorydata.plugin");
    }

    public void addColorAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, r2);
    }

    public void addFloatAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, r2);
    }

    public void addIntAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, r2);
    }

    public void addStringAttributes(String... r2) {
        addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, r2);
    }

    public void addToHorizontalChain(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 1;
    L6:
        connect(r9, 1, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 2;
    L10:
        connect(r9, 2, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 2, r9, 1, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 1, r9, 2, 0);
        return;
    L16:
        return;
    L9:
        r5 = 1;
        goto L10
    L5:
        r4 = 2;
        goto L6
    }

    public void addToHorizontalChainRTL(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 6;
    L6:
        connect(r9, 6, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 7;
    L10:
        connect(r9, 7, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 7, r9, 6, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 6, r9, 7, 0);
        return;
    L16:
        return;
    L9:
        r5 = 6;
        goto L10
    L5:
        r4 = 7;
        goto L6
    }

    public void addToVerticalChain(int r9, int r10, int r11) {
        if (r10 != 0) goto L5;
        int r4 = 3;
    L6:
        connect(r9, 3, r10, r4, 0);
        if (r11 != 0) goto L9;
        int r5 = 4;
    L10:
        connect(r9, 4, r11, r5, 0);
        if (r10 == 0) goto L13;
        connect(r10, 4, r9, 3, 0);
    L13:
        if (r11 == 0) goto L16;
        connect(r11, 3, r9, 4, 0);
        return;
    L16:
        return;
    L9:
        r5 = 3;
        goto L10
    L5:
        r4 = 4;
        goto L6
    }

    public void applyCustomAttributes(ConstraintLayout r7) {
        int r0 = r7.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L21;
        View r2 = r7.getChildAt(r1);
        int r3 = r2.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == true) goto L8;
        Log.w(TAG, "id unknown " + Debug.getName(r2));
    L20:
        r1 = r1 + 1;
        goto L3
    L8:
        if (this.mForceId == false) goto L15;
        if (r3 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L20;
        Constraint r4 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r3)), Constraint.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        ConstraintAttribute.setAttributes(r2, r4.mCustomConstraints);
        goto L20
    }

    public void applyDeltaFrom(ConstraintSet r7) {
        Iterator<Constraint> r8 = r7.mConstraints.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L18;
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(r8.next(), Constraint.class, "com.obric.memorydata.plugin");
        if (r0.mDelta == null) goto L4;
        if (r0.mTargetString != null) goto L9;
        Constraint r1 = getConstraint(r0.mViewId);
        r0.mDelta.applyDelta(r1);
        goto L4
    L9:
        Iterator<Integer> r2 = this.mConstraints.keySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L4;
        Constraint r3 = getConstraint(((Integer) ZeusTransformUtils.preCheckCast(r2.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r3.layout.mConstraintTag == null) goto L11;
        if (r0.mTargetString.matches(r3.layout.mConstraintTag) == false) goto L11;
        r0.mDelta.applyDelta(r3);
        r3.mCustomConstraints.putAll((HashMap) ZeusTransformUtils.preCheckCast(r0.mCustomConstraints.clone(), HashMap.class, "com.obric.memorydata.plugin"));
        goto L11
    }

    public void applyTo(ConstraintLayout r2) {
        applyToInternal(r2, true);
        r2.setConstraintSet(null);
        r2.requestLayout();
    }

    public void applyToHelper(ConstraintHelper r4, ConstraintWidget r5, ConstraintLayout.LayoutParams r6, SparseArray<ConstraintWidget> r7) {
        int r0 = r4.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r0)) == false) goto L10;
        Constraint r3 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r0)), Constraint.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, HelperWidget.class) == false) goto L12;
        r4.loadParameters(r3, (HelperWidget) ZeusTransformUtils.preCheckCast(r5, HelperWidget.class, "com.obric.memorydata.plugin"), r6, r7);
        return;
    L12:
        return;
    }

    void applyToInternal(ConstraintLayout r13, boolean r14) {
        int r0 = r13.getChildCount();
        HashSet r1 = new HashSet(this.mConstraints.keySet());
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r0) goto L59;
        View r6 = r13.getChildAt(r3);
        int r7 = r6.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(r7)) == true) goto L9;
        Log.w(TAG, "id unknown " + Debug.getName(r6));
    L58:
        r3 = r3 + 1;
        goto L4
    L9:
        if (this.mForceId == false) goto L14;
        if (r7 != (-1)) goto L14;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L14:
        if (r7 == (-1)) goto L58;
        if (this.mConstraints.containsKey(Integer.valueOf(r7)) == false) goto L57;
        r1.remove(Integer.valueOf(r7));
        Constraint r8 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r7)), Constraint.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L58;
        if (ZeusTransformUtils.instanceOf(r6, Barrier.class) == false) goto L29;
        r8.layout.mHelperType = 1;
        Barrier r4 = (Barrier) ZeusTransformUtils.preCheckCast(r6, Barrier.class, "com.obric.memorydata.plugin");
        r4.setId(r7);
        r4.setType(r8.layout.mBarrierDirection);
        r4.setMargin(r8.layout.mBarrierMargin);
        r4.setAllowsGoneWidget(r8.layout.mBarrierAllowsGoneWidgets);
        if (r8.layout.mReferenceIds == null) goto L27;
        r4.setReferencedIds(r8.layout.mReferenceIds);
        goto L29
    L27:
        if (r8.layout.mReferenceIdString == null) goto L29;
        r8.layout.mReferenceIds = convertReferenceString(r4, r8.layout.mReferenceIdString);
        r4.setReferencedIds(r8.layout.mReferenceIds);
    L29:
        ConstraintLayout.LayoutParams r5 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r5.validate();
        r8.applyTo(r5);
        if (r14 == false) goto L32;
        ConstraintAttribute.setAttributes(r6, r8.mCustomConstraints);
    L32:
        r6.setLayoutParams(r5);
        if (r8.propertySet.mVisibilityMode != 0) goto L36;
        r6.setVisibility(r8.propertySet.visibility);
    L36:
        if (Build.VERSION.SDK_INT < 17) goto L58;
        r6.setAlpha(r8.propertySet.alpha);
        r6.setRotation(r8.transform.rotation);
        r6.setRotationX(r8.transform.rotationX);
        r6.setRotationY(r8.transform.rotationY);
        r6.setScaleX(r8.transform.scaleX);
        r6.setScaleY(r8.transform.scaleY);
        if (r8.transform.transformPivotTarget == (-1)) goto L47;
        View r9 = ((View) ZeusTransformUtils.preCheckCast(r6.getParent(), View.class, "com.obric.memorydata.plugin")).findViewById(r8.transform.transformPivotTarget);
        if (r9 == null) goto L52;
        float r10 = (r9.getTop() + r9.getBottom()) / 2.0f;
        float r11 = (r9.getLeft() + r9.getRight()) / 2.0f;
        if ((r6.getRight() - r6.getLeft()) <= 0) goto L52;
        if ((r6.getBottom() - r6.getTop()) <= 0) goto L52;
        float r12 = r11 - r6.getLeft();
        float r15 = r10 - r6.getTop();
        r6.setPivotX(r12);
        r6.setPivotY(r15);
    L52:
        r6.setTranslationX(r8.transform.translationX);
        r6.setTranslationY(r8.transform.translationY);
        if (Build.VERSION.SDK_INT < 21) goto L58;
        r6.setTranslationZ(r8.transform.translationZ);
        if (r8.transform.applyElevation == false) goto L58;
        r6.setElevation(r8.transform.elevation);
        goto L58
    L47:
        if (Float.isNaN(r8.transform.transformPivotX) == true) goto L50;
        r6.setPivotX(r8.transform.transformPivotX);
    L50:
        if (Float.isNaN(r8.transform.transformPivotY) == true) goto L52;
        r6.setPivotY(r8.transform.transformPivotY);
        goto L52
    L57:
        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + r7);
        goto L58
    L59:
        Iterator r16 = r1.iterator();
    L61:
        if (r16.hasNext() == false) goto L77;
        Integer r17 = (Integer) ZeusTransformUtils.preCheckCast(r16.next(), Integer.class, "com.obric.memorydata.plugin");
        Constraint r18 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(r17), Constraint.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L61;
        if (r18.layout.mHelperType != 1) goto L75;
        Barrier r19 = new Barrier((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r19.setId(r17.intValue());
        if (r18.layout.mReferenceIds == null) goto L71;
        r19.setReferencedIds(r18.layout.mReferenceIds);
    L73:
        r19.setType(r18.layout.mBarrierDirection);
        r19.setMargin(r18.layout.mBarrierMargin);
        ConstraintLayout.LayoutParams r20 = r13.generateDefaultLayoutParams();
        r19.validateParams();
        r18.applyTo(r20);
        r13.addView(r19, r20);
        goto L75
    L71:
        if (r18.layout.mReferenceIdString == null) goto L73;
        r18.layout.mReferenceIds = convertReferenceString(r19, r18.layout.mReferenceIdString);
        r19.setReferencedIds(r18.layout.mReferenceIds);
    L75:
        if (r18.layout.mIsGuideline == false) goto L61;
        Guideline r21 = new Guideline((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r21.setId(r17.intValue());
        ConstraintLayout.LayoutParams r22 = r13.generateDefaultLayoutParams();
        r18.applyTo(r22);
        r13.addView(r21, r22);
    L77:
        if (r2 >= r0) goto L82;
        View r110 = r13.getChildAt(r2);
        if (ZeusTransformUtils.instanceOf(r110, ConstraintHelper.class) == false) goto L81;
        ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r110, ConstraintHelper.class, "com.obric.memorydata.plugin")).applyLayoutFeaturesInConstraintSet(r13);
    L81:
        r2 = r2 + 1;
        goto L77
    }

    public void applyToLayoutParams(int r3, ConstraintLayout.LayoutParams r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L8;
        Constraint r2 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r3)), Constraint.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        r2.applyTo(r4);
        return;
    L9:
        return;
    }

    public void applyToWithoutCustom(ConstraintLayout r2) {
        applyToInternal(r2, false);
        r2.setConstraintSet(null);
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
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L38;
    L24:
        r0.layout.horizontalBias = r17;
        return;
    L38:
        return;
    L12:
        if (r12 == 2) goto L25;
        if (r12 != 6) goto L17;
    L22:
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L24;
        return;
    L17:
        if (r12 == 7) goto L22;
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        Constraint r1 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L28;
        r1.layout.verticalBias = r17;
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
        int r2 = 0;
        int r3 = 1;
        int r4 = 0;
        int r5 = 0;
        int r6 = 2;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 2;
        r4 = 0;
        r6 = 1;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerHorizontally(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 1, r11, r12, r13);
        connect(r10, 2, r14, r15, r16);
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
    }

    public void centerHorizontallyRtl(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r2 = 0;
        int r3 = 6;
        int r4 = 0;
        int r5 = 0;
        int r6 = 7;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 7;
        r4 = 0;
        r6 = 6;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerHorizontallyRtl(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 6, r11, r12, r13);
        connect(r10, 7, r14, r15, r16);
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.layout.horizontalBias = r17;
        return;
    }

    public void centerVertically(int r10, int r11) {
        if (r11 != 0) goto L4;
        int r2 = 0;
        int r3 = 3;
        int r4 = 0;
        int r5 = 0;
        int r6 = 4;
        int r7 = 0;
        float r8 = 0.5f;
    L5:
        center(r10, r2, r3, r4, r5, r6, r7, r8);
        return;
    L4:
        r3 = 4;
        r4 = 0;
        r6 = 3;
        r7 = 0;
        r8 = 0.5f;
        r2 = r11;
        r5 = r11;
        goto L5
    }

    public void centerVertically(int r10, int r11, int r12, int r13, int r14, int r15, int r16, float r17) {
        connect(r10, 3, r11, r12, r13);
        connect(r10, 4, r14, r15, r16);
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.layout.verticalBias = r17;
        return;
    }

    public void clear(int r1) {
        this.mConstraints.remove(Integer.valueOf(r1));
    }

    public void clear(int r3, int r4) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == false) goto L20;
        Constraint r2 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r3)), Constraint.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
        return;
    L8:
        switch(r4) {
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
        r2.layout.circleAngle = -1.0f;
        r2.layout.circleRadius = -1;
        r2.layout.circleConstraint = -1;
        return;
    L12:
        r2.layout.endToStart = -1;
        r2.layout.endToEnd = -1;
        r2.layout.endMargin = 0;
        r2.layout.goneEndMargin = Integer.MIN_VALUE;
        return;
    L13:
        r2.layout.startToEnd = -1;
        r2.layout.startToStart = -1;
        r2.layout.startMargin = 0;
        r2.layout.goneStartMargin = Integer.MIN_VALUE;
        return;
    L14:
        r2.layout.baselineToBaseline = -1;
        r2.layout.baselineToTop = -1;
        r2.layout.baselineToBottom = -1;
        r2.layout.baselineMargin = 0;
        r2.layout.goneBaselineMargin = Integer.MIN_VALUE;
        return;
    L15:
        r2.layout.bottomToTop = -1;
        r2.layout.bottomToBottom = -1;
        r2.layout.bottomMargin = 0;
        r2.layout.goneBottomMargin = Integer.MIN_VALUE;
        return;
    L16:
        r2.layout.topToBottom = -1;
        r2.layout.topToTop = -1;
        r2.layout.topMargin = 0;
        r2.layout.goneTopMargin = Integer.MIN_VALUE;
        return;
    L17:
        r2.layout.rightToRight = -1;
        r2.layout.rightToLeft = -1;
        r2.layout.rightMargin = -1;
        r2.layout.goneRightMargin = Integer.MIN_VALUE;
        return;
    L18:
        r2.layout.leftToRight = -1;
        r2.layout.leftToLeft = -1;
        r2.layout.leftMargin = -1;
        r2.layout.goneLeftMargin = Integer.MIN_VALUE;
        return;
    L10:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void clone(Context r3, int r4) {
        clone((ConstraintLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")), r4, null, "com.obric.memorydata.plugin"), ConstraintLayout.class, "com.obric.memorydata.plugin"));
    }

    public void clone(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L33;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r6 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r4)), Constraint.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L32;
        r6.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, r2);
        Constraint.access$000(r6, r4, r3);
        r6.propertySet.visibility = r2.getVisibility();
        if (Build.VERSION.SDK_INT < 17) goto L30;
        r6.propertySet.alpha = r2.getAlpha();
        r6.transform.rotation = r2.getRotation();
        r6.transform.rotationX = r2.getRotationX();
        r6.transform.rotationY = r2.getRotationY();
        r6.transform.scaleX = r2.getScaleX();
        r6.transform.scaleY = r2.getScaleY();
        float r5 = r2.getPivotX();
        float r7 = r2.getPivotY();
        if (r5 == 0.0d) goto L22;
    L23:
        r6.transform.transformPivotX = r5;
        r6.transform.transformPivotY = r7;
    L24:
        r6.transform.translationX = r2.getTranslationX();
        r6.transform.translationY = r2.getTranslationY();
        if (Build.VERSION.SDK_INT < 21) goto L30;
        r6.transform.translationZ = r2.getTranslationZ();
        if (r6.transform.applyElevation == false) goto L30;
        r6.transform.elevation = r2.getElevation();
        goto L30
    L22:
        if (r7 == 0.0d) goto L24;
    L30:
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L32;
        Barrier r8 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.memorydata.plugin");
        r6.layout.mBarrierAllowsGoneWidgets = r8.getAllowsGoneWidget();
        r6.layout.mReferenceIds = r8.getReferencedIds();
        r6.layout.mBarrierDirection = r8.getType();
        r6.layout.mBarrierMargin = r8.getMargin();
    L32:
        r1 = r1 + 1;
        goto L3
    }

    public void clone(ConstraintSet r6) {
        this.mConstraints.clear();
        Iterator<Integer> r0 = r6.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
        Constraint r2 = (Constraint) ZeusTransformUtils.preCheckCast(r6.mConstraints.get(r1), Constraint.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        this.mConstraints.put(r1, r2.clone());
        goto L4
    }

    public void clone(Constraints r10) {
        int r0 = r10.getChildCount();
        this.mConstraints.clear();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L22;
        View r2 = r10.getChildAt(r1);
        Constraints.LayoutParams r3 = (Constraints.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), Constraints.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r6 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r4)), Constraint.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L20;
        Constraint.access$700(r6, (ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.memorydata.plugin"), r4, r3);
    L20:
        Constraint.access$800(r6, r4, r3);
    L21:
        r1 = r1 + 1;
        goto L3
    }

    public void connect(int r10, int r11, int r12, int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r14 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
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
        r14.layout.endToEnd = r12;
        r14.layout.endToStart = -1;
        return;
    L14:
        if (r13 != 6) goto L17;
        r14.layout.endToStart = r12;
        r14.layout.endToEnd = -1;
        return;
    L17:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L18:
        if (r13 != 6) goto L20;
        r14.layout.startToStart = r12;
        r14.layout.startToEnd = -1;
        return;
    L20:
        if (r13 != 7) goto L23;
        r14.layout.startToEnd = r12;
        r14.layout.startToStart = -1;
        return;
    L23:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L34:
        if (r13 != 4) goto L36;
        r14.layout.bottomToBottom = r12;
        r14.layout.bottomToTop = -1;
    L42:
        r14.layout.baselineToBaseline = -1;
        r14.layout.baselineToTop = -1;
        r14.layout.baselineToBottom = -1;
        return;
    L36:
        if (r13 != 3) goto L39;
        r14.layout.bottomToTop = r12;
        r14.layout.bottomToBottom = -1;
        goto L42
    L39:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L40:
        if (r13 != 3) goto L43;
        r14.layout.topToTop = r12;
        r14.layout.topToBottom = -1;
        goto L42
    L43:
        if (r13 != 4) goto L46;
        r14.layout.topToBottom = r12;
        r14.layout.topToTop = -1;
        goto L42
    L46:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L47:
        if (r13 != 1) goto L49;
        r14.layout.rightToLeft = r12;
        r14.layout.rightToRight = -1;
        return;
    L49:
        if (r13 != 2) goto L52;
        r14.layout.rightToRight = r12;
        r14.layout.rightToLeft = -1;
        return;
    L52:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L53:
        if (r13 != 1) goto L55;
        r14.layout.leftToLeft = r12;
        r14.layout.leftToRight = -1;
        return;
    L55:
        if (r13 != 2) goto L59;
        r14.layout.leftToRight = r12;
        r14.layout.leftToLeft = -1;
        return;
    L59:
        throw new IllegalArgumentException("left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L25:
        if (r13 != 5) goto L28;
        r14.layout.baselineToBaseline = r12;
    L27:
        r14.layout.bottomToBottom = -1;
        r14.layout.bottomToTop = -1;
        r14.layout.topToTop = -1;
        r14.layout.topToBottom = -1;
        return;
    L28:
        if (r13 != 3) goto L30;
        r14.layout.baselineToTop = r12;
        goto L27
    L30:
        if (r13 != 4) goto L33;
        r14.layout.baselineToBottom = r12;
        goto L27
    L33:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void connect(int r10, int r11, int r12, int r13, int r14) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == true) goto L5;
        this.mConstraints.put(Integer.valueOf(r10), new Constraint());
    L5:
        Constraint r15 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
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
        r15.layout.endToEnd = r12;
        r15.layout.endToStart = -1;
    L16:
        r15.layout.endMargin = r14;
        return;
    L14:
        if (r13 != 6) goto L18;
        r15.layout.endToStart = r12;
        r15.layout.endToEnd = -1;
        goto L16
    L18:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L19:
        if (r13 != 6) goto L21;
        r15.layout.startToStart = r12;
        r15.layout.startToEnd = -1;
    L23:
        r15.layout.startMargin = r14;
        return;
    L21:
        if (r13 != 7) goto L25;
        r15.layout.startToEnd = r12;
        r15.layout.startToStart = -1;
        goto L23
    L25:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L36:
        if (r13 != 4) goto L39;
        r15.layout.bottomToBottom = r12;
        r15.layout.bottomToTop = -1;
    L38:
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
        r15.layout.bottomMargin = r14;
        return;
    L39:
        if (r13 != 3) goto L43;
        r15.layout.bottomToTop = r12;
        r15.layout.bottomToBottom = -1;
        goto L38
    L43:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L44:
        if (r13 != 3) goto L47;
        r15.layout.topToTop = r12;
        r15.layout.topToBottom = -1;
    L46:
        r15.layout.baselineToBaseline = -1;
        r15.layout.baselineToTop = -1;
        r15.layout.baselineToBottom = -1;
        r15.layout.topMargin = r14;
        return;
    L47:
        if (r13 != 4) goto L51;
        r15.layout.topToBottom = r12;
        r15.layout.topToTop = -1;
        goto L46
    L51:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L52:
        if (r13 != 1) goto L54;
        r15.layout.rightToLeft = r12;
        r15.layout.rightToRight = -1;
    L56:
        r15.layout.rightMargin = r14;
        return;
    L54:
        if (r13 != 2) goto L58;
        r15.layout.rightToRight = r12;
        r15.layout.rightToLeft = -1;
        goto L56
    L58:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    L59:
        if (r13 != 1) goto L61;
        r15.layout.leftToLeft = r12;
        r15.layout.leftToRight = -1;
    L63:
        r15.layout.leftMargin = r14;
        return;
    L61:
        if (r13 != 2) goto L66;
        r15.layout.leftToRight = r12;
        r15.layout.leftToLeft = -1;
        goto L63
    L66:
        throw new IllegalArgumentException("Left to " + sideToString(r13) + " undefined");
    L11:
        throw new IllegalArgumentException(sideToString(r11) + " to " + sideToString(r13) + " unknown");
    L27:
        if (r13 != 5) goto L30;
        r15.layout.baselineToBaseline = r12;
    L29:
        r15.layout.bottomToBottom = -1;
        r15.layout.bottomToTop = -1;
        r15.layout.topToTop = -1;
        r15.layout.topToBottom = -1;
        return;
    L30:
        if (r13 != 3) goto L32;
        r15.layout.baselineToTop = r12;
        goto L29
    L32:
        if (r13 != 4) goto L35;
        r15.layout.baselineToBottom = r12;
        goto L29
    L35:
        throw new IllegalArgumentException("right to " + sideToString(r13) + " undefined");
    }

    public void constrainCircle(int r1, int r2, int r3, float r4) {
        Constraint r0 = get(r1);
        r0.layout.circleConstraint = r2;
        r0.layout.circleRadius = r3;
        r0.layout.circleAngle = r4;
    }

    public void constrainDefaultHeight(int r1, int r2) {
        get(r1).layout.heightDefault = r2;
    }

    public void constrainDefaultWidth(int r1, int r2) {
        get(r1).layout.widthDefault = r2;
    }

    public void constrainHeight(int r1, int r2) {
        get(r1).layout.mHeight = r2;
    }

    public void constrainMaxHeight(int r1, int r2) {
        get(r1).layout.heightMax = r2;
    }

    public void constrainMaxWidth(int r1, int r2) {
        get(r1).layout.widthMax = r2;
    }

    public void constrainMinHeight(int r1, int r2) {
        get(r1).layout.heightMin = r2;
    }

    public void constrainMinWidth(int r1, int r2) {
        get(r1).layout.widthMin = r2;
    }

    public void constrainPercentHeight(int r1, float r2) {
        get(r1).layout.heightPercent = r2;
    }

    public void constrainPercentWidth(int r1, float r2) {
        get(r1).layout.widthPercent = r2;
    }

    public void constrainWidth(int r1, int r2) {
        get(r1).layout.mWidth = r2;
    }

    public void constrainedHeight(int r1, boolean r2) {
        get(r1).layout.constrainedHeight = r2;
    }

    public void constrainedWidth(int r1, boolean r2) {
        get(r1).layout.constrainedWidth = r2;
    }

    public void create(int r2, int r3) {
        Constraint r1 = get(r2);
        r1.layout.mIsGuideline = true;
        r1.layout.orientation = r3;
    }

    public void createBarrier(int r2, int r3, int r4, int... r5) {
        Constraint r1 = get(r2);
        r1.layout.mHelperType = 1;
        r1.layout.mBarrierDirection = r3;
        r1.layout.mBarrierMargin = r4;
        r1.layout.mIsGuideline = false;
        r1.layout.mReferenceIds = r5;
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
        int r0 = r17[r10];
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

    public void dump(MotionScene r8, int... r9) {
        Set<Integer> r0 = this.mConstraints.keySet();
        int r2 = 0;
        if (r9.length == 0) goto L7;
        HashSet r1 = new HashSet();
        int r3 = r9.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L8;
        r1.add(Integer.valueOf(r9[r4]));
        r4 = r4 + 1;
    L8:
        System.out.println(r1.size() + " constraints");
        StringBuilder r10 = new StringBuilder();
        Integer[] r5 = (Integer[]) ZeusTransformUtils.preCheckCast(r1.toArray(new Integer[0]), Integer[].class, "com.obric.memorydata.plugin");
        int r6 = r5.length;
    L9:
        if (r2 >= r6) goto L15;
        Integer r7 = r5[r2];
        Constraint r11 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(r7), Constraint.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L14;
        r10.append("<Constraint id=");
        r10.append(r7);
        r10.append(" \n");
        r11.layout.dump(r8, r10);
        r10.append("/>\n");
    L14:
        r2 = r2 + 1;
        goto L9
    L15:
        System.out.println(r10.toString());
        return;
    L7:
        r1 = new HashSet(r0);
        goto L8
    }

    public boolean getApplyElevation(int r1) {
        return get(r1).transform.applyElevation;
    }

    public Constraint getConstraint(int r3) {
        if (this.mConstraints.containsKey(Integer.valueOf(r3)) == true) goto L5;
        return null;
    L5:
        return (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r3)), Constraint.class, "com.obric.memorydata.plugin");
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int r1) {
        return get(r1).layout.mHeight;
    }

    public int[] getKnownIds() {
        int r0 = 0;
        Integer[] r4 = (Integer[]) ZeusTransformUtils.preCheckCast(this.mConstraints.keySet().toArray(new Integer[0]), Integer[].class, "com.obric.memorydata.plugin");
        int r1 = r4.length;
        int[] r2 = new int[r1];
    L3:
        if (r0 >= r1) goto L5;
        r2[r0] = r4[r0].intValue();
        r0 = r0 + 1;
        goto L3
    L5:
        return r2;
    }

    public Constraint getParameters(int r1) {
        return get(r1);
    }

    public int[] getReferencedIds(int r1) {
        Constraint r0 = get(r1);
        if (r0.layout.mReferenceIds != null) goto L7;
        return new int[0];
    L7:
        return Arrays.copyOf(r0.layout.mReferenceIds, r0.layout.mReferenceIds.length);
    }

    public int getVisibility(int r1) {
        return get(r1).propertySet.visibility;
    }

    public int getVisibilityMode(int r1) {
        return get(r1).propertySet.mVisibilityMode;
    }

    public int getWidth(int r1) {
        return get(r1).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        XmlResourceParser r8 = ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getXml(r6);
        int r0 = r8.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L5:
        if (r0 == 1) goto L30;
        if (r0 != 0) goto L8;
        r8.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L15:
        r0 = r8.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
    L8:
        if (r0 != 2) goto L15;
        String r1 = r8.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        Constraint r2 = fillFromAttributeList(r7, Xml.asAttributeSet(r8), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        if (r1.equalsIgnoreCase("Guideline") == false) goto L13;
        r2.layout.mIsGuideline = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
    L13:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L17 XmlPullParserException -> L19
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
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        XmlPullParser r13 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.memorydata.plugin");
        int r0 = r13.getEventType();     // Catch: IOException -> L97 XmlPullParserException -> L99
        Constraint r2 = null;
    L5:
        if (r0 == 1) goto L122;
        if (r0 == 0) goto L94;
        byte r4 = -1;
        if (r0 == 2) goto L33;
        if (r0 != 3) goto L95;
        String r1 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r1.hashCode()) {
            case -2075718416: goto L24;
            case -190376483: goto L21;
            case 426575017: goto L18;
            case 2146106725: goto L15;
            default: goto L26;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L26:
        if (r4 == 0) goto L32;
        if (r4 == 1) goto L31;
        if (r4 == 2) goto L31;
        if (r4 != 3) goto L95;
    L31:
        this.mConstraints.put(Integer.valueOf(r2.mViewId), r2);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r2 = null;
        goto L95
    L32:
        return;
    L15:
        if (r1.equals("constraintset") == false) goto L26;
        r4 = 0;
        goto L26
    L18:
        if (r1.equals("constraintoverride") == false) goto L26;
        r4 = 2;
        goto L26
    L21:
        if (r1.equals("constraint") == false) goto L26;
        r4 = 1;
        goto L26
    L24:
        if (r1.equals("guideline") == false) goto L26;
        r4 = 3;
    L95:
        r0 = r13.next();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L5
    L33:
        String r3 = r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        switch(r3.hashCode()) {
            case -2025855158: goto L64;
            case -1984451626: goto L61;
            case -1962203927: goto L58;
            case -1269513683: goto L55;
            case -1238332596: goto L52;
            case -71750448: goto L49;
            case 366511058: goto L46;
            case 1331510167: goto L43;
            case 1791837707: goto L40;
            case 1803088381: goto L37;
            default: goto L67;
        };     // Catch: IOException -> L97 XmlPullParserException -> L99
    L67:
        switch(r4) {
            case 0: goto L92;
            case 1: goto L91;
            case 2: goto L90;
            case 3: goto L89;
            case 4: goto L85;
            case 5: goto L81;
            case 6: goto L77;
            case 7: goto L73;
            case 8: goto L69;
            case 9: goto L69;
            default: goto L95;
        };
    L69:
        if (r2 == null) goto L72;
        ConstraintAttribute.parse(r12, r13, r2.mCustomConstraints);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L72:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L73:
        if (r2 == null) goto L76;
        r2.motion.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L76:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L77:
        if (r2 == null) goto L80;
        r2.layout.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L80:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L81:
        if (r2 == null) goto L84;
        r2.transform.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L84:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L85:
        if (r2 == null) goto L88;
        r2.propertySet.fillFromAttributeList(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L88:
        throw new RuntimeException(ERROR_MESSAGE + r13.getLineNumber());     // Catch: IOException -> L97 XmlPullParserException -> L99
    L89:
        Constraint r5 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.layout.mHelperType = 1;     // Catch: IOException -> L97 XmlPullParserException -> L99
    L93:
        r2 = r5;
        goto L95
    L90:
        r5 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.layout.mIsGuideline = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        r5.layout.mApply = true;     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L91:
        r5 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), true);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L92:
        r5 = fillFromAttributeList(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L93
    L37:
        if (r3.equals("Constraint") == false) goto L67;
        r4 = 0;
        goto L67
    L40:
        if (r3.equals(ViewTransition.CUSTOM_ATTRIBUTE) == false) goto L67;
        r4 = 8;
        goto L67
    L43:
        if (r3.equals("Barrier") == false) goto L67;
        r4 = 3;
        goto L67
    L46:
        if (r3.equals(ViewTransition.CUSTOM_METHOD) == false) goto L67;
        r4 = 9;
        goto L67
    L49:
        if (r3.equals("Guideline") == false) goto L67;
        r4 = 2;
        goto L67
    L52:
        if (r3.equals("Transform") == false) goto L67;
        r4 = 5;
        goto L67
    L55:
        if (r3.equals("PropertySet") == false) goto L67;
        r4 = 4;
        goto L67
    L58:
        if (r3.equals(ViewTransition.CONSTRAINT_OVERRIDE) == false) goto L67;
        r4 = 1;
        goto L67
    L61:
        if (r3.equals(TypedValues.MotionType.NAME) == false) goto L67;
        r4 = 7;
        goto L67
    L64:
        if (r3.equals(d.h) == false) goto L67;
        r4 = 6;
        goto L67
    L94:
        r13.getName();     // Catch: IOException -> L97 XmlPullParserException -> L99
        goto L95
    L122:
        return;
    L97:
        e = move-exception;
        e.printStackTrace();
        return;
    L99:
        e = move-exception;
        e.printStackTrace();
    }

    public void parseColorAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1000(r5, r1[0], Color.parseColor(r1[1]));
        goto L9
    }

    public void parseFloatAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1100(r5, r1[0], Float.parseFloat(r1[1]));
        goto L9
    }

    public void parseIntAttributes(Constraint r5, String r6) {
        String[] r4 = r6.split(",");
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L10;
        String[] r1 = r4[r0].split("=");
        if (r1.length == 2) goto L8;
        Log.w(TAG, " Unable to parse " + r4[r0]);
    L9:
        r0 = r0 + 1;
        goto L4
    L8:
        Constraint.access$1100(r5, r1[0], Integer.decode(r1[1]).intValue());
        goto L9
    }

    public void parseStringAttributes(Constraint r5, String r6) {
        String[] r4 = splitString(r6);
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        String[] r1 = r4[r0].split("=");
        Log.w(TAG, " Unable to parse " + r4[r0]);
        Constraint.access$1200(r5, r1[0], r1[1]);
        r0 = r0 + 1;
        goto L4
    }

    public void readFallback(ConstraintLayout r12) {
        int r0 = r12.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L43;
        View r2 = r12.getChildAt(r1);
        ConstraintLayout.LayoutParams r3 = (ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        int r4 = r2.getId();
        if (this.mForceId == false) goto L12;
        if (r4 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (this.mConstraints.containsKey(Integer.valueOf(r4)) == true) goto L14;
        this.mConstraints.put(Integer.valueOf(r4), new Constraint());
    L14:
        Constraint r6 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r4)), Constraint.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L42;
        if (r6.layout.mApply == true) goto L26;
        Constraint.access$000(r6, r4, r3);
        if (ZeusTransformUtils.instanceOf(r2, ConstraintHelper.class) == false) goto L24;
        r6.layout.mReferenceIds = ((ConstraintHelper) ZeusTransformUtils.preCheckCast(r2, ConstraintHelper.class, "com.obric.memorydata.plugin")).getReferencedIds();
        if (ZeusTransformUtils.instanceOf(r2, Barrier.class) == false) goto L24;
        Barrier r5 = (Barrier) ZeusTransformUtils.preCheckCast(r2, Barrier.class, "com.obric.memorydata.plugin");
        r6.layout.mBarrierAllowsGoneWidgets = r5.getAllowsGoneWidget();
        r6.layout.mBarrierDirection = r5.getType();
        r6.layout.mBarrierMargin = r5.getMargin();
    L24:
        r6.layout.mApply = true;
    L26:
        if (r6.propertySet.mApply == true) goto L29;
        r6.propertySet.visibility = r2.getVisibility();
        r6.propertySet.alpha = r2.getAlpha();
        r6.propertySet.mApply = true;
    L29:
        if (Build.VERSION.SDK_INT < 17) goto L42;
        if (r6.transform.mApply == true) goto L42;
        r6.transform.mApply = true;
        r6.transform.rotation = r2.getRotation();
        r6.transform.rotationX = r2.getRotationX();
        r6.transform.rotationY = r2.getRotationY();
        r6.transform.scaleX = r2.getScaleX();
        r6.transform.scaleY = r2.getScaleY();
        float r7 = r2.getPivotX();
        float r8 = r2.getPivotY();
        if (r7 == 0.0d) goto L35;
    L36:
        r6.transform.transformPivotX = r7;
        r6.transform.transformPivotY = r8;
    L37:
        r6.transform.translationX = r2.getTranslationX();
        r6.transform.translationY = r2.getTranslationY();
        if (Build.VERSION.SDK_INT < 21) goto L42;
        r6.transform.translationZ = r2.getTranslationZ();
        if (r6.transform.applyElevation == false) goto L42;
        r6.transform.elevation = r2.getElevation();
        goto L42
    L35:
        if (r8 == 0.0d) goto L37;
    L42:
        r1 = r1 + 1;
        goto L3
    }

    public void readFallback(ConstraintSet r10) {
        Iterator<Integer> r0 = r10.mConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L29;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin");
        int r2 = r1.intValue();
        Constraint r3 = (Constraint) ZeusTransformUtils.preCheckCast(r10.mConstraints.get(r1), Constraint.class, "com.obric.memorydata.plugin");
        if (this.mConstraints.containsKey(Integer.valueOf(r2)) == true) goto L8;
        this.mConstraints.put(Integer.valueOf(r2), new Constraint());
    L8:
        Constraint r4 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r2)), Constraint.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        if (r4.layout.mApply == true) goto L15;
        r4.layout.copyFrom(r3.layout);
    L15:
        if (r4.propertySet.mApply == true) goto L18;
        r4.propertySet.copyFrom(r3.propertySet);
    L18:
        if (r4.transform.mApply == true) goto L21;
        r4.transform.copyFrom(r3.transform);
    L21:
        if (r4.motion.mApply == true) goto L23;
        r4.motion.copyFrom(r3.motion);
    L23:
        Iterator<String> r5 = r3.mCustomConstraints.keySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L4;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.mCustomConstraints.containsKey(r6) == true) goto L25;
        r4.mCustomConstraints.put(r6, (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r3.mCustomConstraints.get(r6), ConstraintAttribute.class, "com.obric.memorydata.plugin"));
        goto L25
    }

    public void removeAttribute(String r1) {
        this.mSavedAttributes.remove(r1);
    }

    public void removeFromHorizontalChain(int r13) {
        if (this.mConstraints.containsKey(Integer.valueOf(r13)) == false) goto L39;
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r13)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.layout.leftToRight;
        int r8 = r0.layout.rightToLeft;
        if (r1 != (-1)) goto L26;
        if (r8 != (-1)) goto L26;
        int r5 = r0.layout.startToEnd;
        int r3 = r0.layout.endToStart;
        if (r5 != (-1)) goto L14;
        if (r3 != (-1)) goto L14;
    L25:
        clear(r13, 6);
        int r2 = 7;
    L37:
        clear(r13, r2);
        return;
    L14:
        if (r5 == (-1)) goto L18;
        if (r3 == (-1)) goto L18;
        int r6 = 7;
        connect(r5, 7, r3, 6, 0);
        int r4 = 6;
        int r7 = 0;
        int r9 = r1;
    L17:
        connect(r3, r4, r9, r6, r7);
    L18:
        if (r3 == (-1)) goto L25;
        if (r0.layout.rightToRight == (-1)) goto L23;
        r4 = 7;
        r9 = r0.layout.rightToRight;
        r6 = 7;
        r7 = 0;
        r3 = r1;
        goto L17
    L23:
        if (r0.layout.leftToLeft == (-1)) goto L25;
        connect(r3, 6, r0.layout.leftToLeft, 6, 0);
    L26:
        if (r1 == (-1)) goto L30;
        if (r8 == (-1)) goto L30;
        int r10 = 0;
        ConstraintSet r11 = this;
        r11.connect(r1, 2, r8, 1, 0);
        int r12 = 1;
        int r14 = 2;
        int r15 = r8;
        int r16 = r1;
    L32:
        r11.connect(r15, r12, r16, r14, r10);
    L36:
        clear(r13, 1);
        r2 = 2;
    L30:
        if (r0.layout.rightToRight == (-1)) goto L34;
        r12 = 2;
        r16 = r0.layout.rightToRight;
        r14 = 2;
        r10 = 0;
        r11 = this;
        r15 = r1;
        goto L32
    L34:
        if (r0.layout.leftToLeft == (-1)) goto L36;
        connect(r8, 1, r0.layout.leftToLeft, 1, 0);
        goto L36
    }

    public void removeFromVerticalChain(int r10) {
        if (this.mConstraints.containsKey(Integer.valueOf(r10)) == false) goto L20;
        Constraint r0 = (Constraint) ZeusTransformUtils.preCheckCast(this.mConstraints.get(Integer.valueOf(r10)), Constraint.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return;
    L7:
        int r1 = r0.layout.topToBottom;
        int r8 = r0.layout.bottomToTop;
        if (r1 != (-1)) goto L10;
        if (r8 == (-1)) goto L20;
    L10:
        if (r1 == (-1)) goto L14;
        if (r8 == (-1)) goto L14;
        int r7 = 0;
        ConstraintSet r2 = this;
        r2.connect(r1, 4, r8, 3, 0);
        int r4 = 3;
        int r6 = 4;
        int r3 = r8;
        int r5 = r1;
    L16:
        r2.connect(r3, r4, r5, r6, r7);
    L14:
        if (r0.layout.bottomToBottom == (-1)) goto L18;
        r4 = 4;
        r5 = r0.layout.bottomToBottom;
        r6 = 4;
        r7 = 0;
        r2 = this;
        r3 = r1;
        goto L16
    L18:
        if (r0.layout.topToTop == (-1)) goto L20;
        connect(r8, 3, r0.layout.topToTop, 3, 0);
    L20:
        clear(r10, 3);
        clear(r10, 4);
    }

    public void setAlpha(int r1, float r2) {
        get(r1).propertySet.alpha = r2;
    }

    public void setApplyElevation(int r3, boolean r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.applyElevation = r4;
        return;
    }

    public void setBarrierType(int r1, int r2) {
        get(r1).layout.mHelperType = r2;
    }

    public void setColorValue(int r1, String r2, int r3) {
        Constraint.access$1000(get(r1), r2, r3);
    }

    public void setDimensionRatio(int r1, String r2) {
        get(r1).layout.dimensionRatio = r2;
    }

    public void setEditorAbsoluteX(int r1, int r2) {
        get(r1).layout.editorAbsoluteX = r2;
    }

    public void setEditorAbsoluteY(int r1, int r2) {
        get(r1).layout.editorAbsoluteY = r2;
    }

    public void setElevation(int r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.elevation = r4;
        get(r3).transform.applyElevation = true;
        return;
    }

    public void setFloatValue(int r1, String r2, float r3) {
        Constraint.access$1100(get(r1), r2, r3);
    }

    public void setForceId(boolean r1) {
        this.mForceId = r1;
    }

    public void setGoneMargin(int r1, int r2, int r3) {
        Constraint r0 = get(r1);
        switch(r2) {
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
        r0.layout.goneEndMargin = r3;
        return;
    L7:
        r0.layout.goneStartMargin = r3;
        return;
    L8:
        r0.layout.goneBaselineMargin = r3;
        return;
    L9:
        r0.layout.goneBottomMargin = r3;
        return;
    L10:
        r0.layout.goneTopMargin = r3;
        return;
    L11:
        r0.layout.goneRightMargin = r3;
        return;
    L12:
        r0.layout.goneLeftMargin = r3;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setGuidelineBegin(int r2, int r3) {
        get(r2).layout.guideBegin = r3;
        get(r2).layout.guideEnd = -1;
        get(r2).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int r2, int r3) {
        get(r2).layout.guideEnd = r3;
        get(r2).layout.guideBegin = -1;
        get(r2).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int r2, float r3) {
        get(r2).layout.guidePercent = r3;
        get(r2).layout.guideEnd = -1;
        get(r2).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int r1, float r2) {
        get(r1).layout.horizontalBias = r2;
    }

    public void setHorizontalChainStyle(int r1, int r2) {
        get(r1).layout.horizontalChainStyle = r2;
    }

    public void setHorizontalWeight(int r1, float r2) {
        get(r1).layout.horizontalWeight = r2;
    }

    public void setIntValue(int r1, String r2, int r3) {
        Constraint.access$900(get(r1), r2, r3);
    }

    public void setLayoutWrapBehavior(int r2, int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        if (r3 > 3) goto L8;
        get(r2).layout.mWrapBehavior = r3;
        return;
    }

    public void setMargin(int r1, int r2, int r3) {
        Constraint r0 = get(r1);
        switch(r2) {
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
        r0.layout.endMargin = r3;
        return;
    L7:
        r0.layout.startMargin = r3;
        return;
    L8:
        r0.layout.baselineMargin = r3;
        return;
    L9:
        r0.layout.bottomMargin = r3;
        return;
    L10:
        r0.layout.topMargin = r3;
        return;
    L11:
        r0.layout.rightMargin = r3;
        return;
    L12:
        r0.layout.leftMargin = r3;
        return;
    L5:
        throw new IllegalArgumentException("unknown constraint");
    }

    public void setReferencedIds(int r1, int... r2) {
        get(r1).layout.mReferenceIds = r2;
    }

    public void setRotation(int r1, float r2) {
        get(r1).transform.rotation = r2;
    }

    public void setRotationX(int r1, float r2) {
        get(r1).transform.rotationX = r2;
    }

    public void setRotationY(int r1, float r2) {
        get(r1).transform.rotationY = r2;
    }

    public void setScaleX(int r1, float r2) {
        get(r1).transform.scaleX = r2;
    }

    public void setScaleY(int r1, float r2) {
        get(r1).transform.scaleY = r2;
    }

    public void setStringValue(int r1, String r2, String r3) {
        Constraint.access$1200(get(r1), r2, r3);
    }

    public void setTransformPivot(int r1, float r2, float r3) {
        Constraint r0 = get(r1);
        r0.transform.transformPivotY = r3;
        r0.transform.transformPivotX = r2;
    }

    public void setTransformPivotX(int r1, float r2) {
        get(r1).transform.transformPivotX = r2;
    }

    public void setTransformPivotY(int r1, float r2) {
        get(r1).transform.transformPivotY = r2;
    }

    public void setTranslation(int r1, float r2, float r3) {
        Constraint r0 = get(r1);
        r0.transform.translationX = r2;
        r0.transform.translationY = r3;
    }

    public void setTranslationX(int r1, float r2) {
        get(r1).transform.translationX = r2;
    }

    public void setTranslationY(int r1, float r2) {
        get(r1).transform.translationY = r2;
    }

    public void setTranslationZ(int r3, float r4) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        get(r3).transform.translationZ = r4;
        return;
    }

    public void setValidateOnParse(boolean r1) {
        this.mValidate = r1;
    }

    public void setVerticalBias(int r1, float r2) {
        get(r1).layout.verticalBias = r2;
    }

    public void setVerticalChainStyle(int r1, int r2) {
        get(r1).layout.verticalChainStyle = r2;
    }

    public void setVerticalWeight(int r1, float r2) {
        get(r1).layout.verticalWeight = r2;
    }

    public void setVisibility(int r1, int r2) {
        get(r1).propertySet.visibility = r2;
    }

    public void setVisibilityMode(int r1, int r2) {
        get(r1).propertySet.mVisibilityMode = r2;
    }

    public void writeState(Writer r4, ConstraintLayout r5, int r6) {
        r4.write("\n---------------------------------------------\n");
        if ((r6 & 1) != 1) goto L5;
        new WriteXmlEngine(this, r4, r5, r6).writeLayout();
    L6:
        r4.write("\n---------------------------------------------\n");
        return;
    L5:
        new WriteJsonEngine(this, r4, r5, r6).writeLayout();
        goto L6
    }
}
