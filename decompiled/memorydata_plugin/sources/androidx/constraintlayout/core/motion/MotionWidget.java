package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    private static final int INTERNAL_MATCH_CONSTRAINT = -3;
    private static final int INTERNAL_MATCH_PARENT = -1;
    private static final int INTERNAL_WRAP_CONTENT = -2;
    private static final int INTERNAL_WRAP_CONTENT_CONSTRAINED = -4;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;
    private float mProgress;
    float mTransitionPathRotate;
    Motion motion;
    PropertySet propertySet;
    WidgetFrame widgetFrame;

    public static class Motion {
        private static final int INTERPOLATOR_REFERENCE_ID = -2;
        private static final int INTERPOLATOR_UNDEFINED = -3;
        private static final int SPLINE_STRING = -1;
        public int mAnimateCircleAngleTo;
        public int mAnimateRelativeTo;
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

        public Motion() {
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
    }

    public static class PropertySet {
        public float alpha;
        public float mProgress;
        public int mVisibilityMode;
        public int visibility;

        public PropertySet() {
            this.visibility = 4;
            this.mVisibilityMode = 0;
            this.alpha = 1.0f;
            this.mProgress = Float.NaN;
        }
    }

    public MotionWidget() {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
    }

    public MotionWidget(WidgetFrame r2) {
        this.widgetFrame = new WidgetFrame();
        this.motion = new Motion();
        this.propertySet = new PropertySet();
        this.widgetFrame = r2;
    }

    public MotionWidget findViewById(int r1) {
        return null;
    }

    public float getAlpha() {
        return this.propertySet.alpha;
    }

    public int getBottom() {
        return this.widgetFrame.bottom;
    }

    public CustomVariable getCustomAttribute(String r1) {
        return this.widgetFrame.getCustomAttribute(r1);
    }

    public Set<String> getCustomAttributeNames() {
        return this.widgetFrame.getCustomAttributeNames();
    }

    public int getHeight() {
        return this.widgetFrame.bottom - this.widgetFrame.top;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r2) {
        int r1 = TypedValues.AttributesType.getId(r2);
        if (r1 == (-1)) goto L6;
        return r1;
    L6:
        return TypedValues.MotionType.getId(r2);
    }

    public int getLeft() {
        return this.widgetFrame.left;
    }

    public String getName() {
        return this.widgetFrame.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.widgetFrame.pivotX;
    }

    public float getPivotY() {
        return this.widgetFrame.pivotY;
    }

    public int getRight() {
        return this.widgetFrame.right;
    }

    public float getRotationX() {
        return this.widgetFrame.rotationX;
    }

    public float getRotationY() {
        return this.widgetFrame.rotationY;
    }

    public float getRotationZ() {
        return this.widgetFrame.rotationZ;
    }

    public float getScaleX() {
        return this.widgetFrame.scaleX;
    }

    public float getScaleY() {
        return this.widgetFrame.scaleY;
    }

    public int getTop() {
        return this.widgetFrame.top;
    }

    public float getTranslationX() {
        return this.widgetFrame.translationX;
    }

    public float getTranslationY() {
        return this.widgetFrame.translationY;
    }

    public float getTranslationZ() {
        return this.widgetFrame.translationZ;
    }

    public float getValueAttributes(int r1) {
        switch(r1) {
            case 303: goto L30;
            case 304: goto L28;
            case 305: goto L26;
            case 306: goto L24;
            case 307: goto L3;
            case 308: goto L22;
            case 309: goto L20;
            case 310: goto L18;
            case 311: goto L16;
            case 312: goto L14;
            case 313: goto L12;
            case 314: goto L10;
            case 315: goto L8;
            case 316: goto L6;
            default: goto L3;
        };
    L3:
        return Float.NaN;
    L6:
        return this.mTransitionPathRotate;
    L8:
        return this.mProgress;
    L10:
        return this.widgetFrame.pivotY;
    L12:
        return this.widgetFrame.pivotX;
    L14:
        return this.widgetFrame.scaleY;
    L16:
        return this.widgetFrame.scaleX;
    L18:
        return this.widgetFrame.rotationZ;
    L20:
        return this.widgetFrame.rotationY;
    L22:
        return this.widgetFrame.rotationX;
    L24:
        return this.widgetFrame.translationZ;
    L26:
        return this.widgetFrame.translationY;
    L28:
        return this.widgetFrame.translationX;
    L30:
        return this.widgetFrame.alpha;
    }

    public int getVisibility() {
        return this.propertySet.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.widgetFrame;
    }

    public int getWidth() {
        return this.widgetFrame.right - this.widgetFrame.left;
    }

    public int getX() {
        return this.widgetFrame.left;
    }

    public int getY() {
        return this.widgetFrame.top;
    }

    public void layout(int r1, int r2, int r3, int r4) {
        setBounds(r1, r2, r3, r4);
    }

    public void setBounds(int r5, int r6, int r7, int r8) {
        if (this.widgetFrame != null) goto L5;
        this.widgetFrame = new WidgetFrame((ConstraintWidget) ZeusTransformUtils.preCheckCast(null, ConstraintWidget.class, "com.obric.memorydata.plugin"));
    L5:
        this.widgetFrame.top = r6;
        this.widgetFrame.left = r5;
        this.widgetFrame.right = r7;
        this.widgetFrame.bottom = r8;
    }

    public void setCustomAttribute(String r1, int r2, float r3) {
        this.widgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, int r3) {
        this.widgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, String r3) {
        this.widgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setCustomAttribute(String r1, int r2, boolean r3) {
        this.widgetFrame.setCustomAttribute(r1, r2, r3);
    }

    public void setInterpolatedValue(CustomAttribute r2, float[] r3) {
        this.widgetFrame.setCustomAttribute(r2.mName, 901, r3[0]);
    }

    public void setPivotX(float r1) {
        this.widgetFrame.pivotX = r1;
    }

    public void setPivotY(float r1) {
        this.widgetFrame.pivotY = r1;
    }

    public void setRotationX(float r1) {
        this.widgetFrame.rotationX = r1;
    }

    public void setRotationY(float r1) {
        this.widgetFrame.rotationY = r1;
    }

    public void setRotationZ(float r1) {
        this.widgetFrame.rotationZ = r1;
    }

    public void setScaleX(float r1) {
        this.widgetFrame.scaleX = r1;
    }

    public void setScaleY(float r1) {
        this.widgetFrame.scaleY = r1;
    }

    public void setTranslationX(float r1) {
        this.widgetFrame.translationX = r1;
    }

    public void setTranslationY(float r1) {
        this.widgetFrame.translationY = r1;
    }

    public void setTranslationZ(float r1) {
        this.widgetFrame.translationZ = r1;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r2, float r3) {
        if (setValueAttributes(r2, r3) == false) goto L7;
        return true;
    L7:
        return setValueMotion(r2, r3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, int r2) {
        return setValueAttributes(r1, r2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, String r2) {
        return setValueMotion(r1, r2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public boolean setValueAttributes(int r1, float r2) {
        switch(r1) {
            case 303: goto L17;
            case 304: goto L16;
            case 305: goto L15;
            case 306: goto L14;
            case 307: goto L3;
            case 308: goto L13;
            case 309: goto L12;
            case 310: goto L11;
            case 311: goto L10;
            case 312: goto L9;
            case 313: goto L8;
            case 314: goto L7;
            case 315: goto L6;
            case 316: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.mTransitionPathRotate = r2;
        return true;
    L6:
        this.mProgress = r2;
        return true;
    L7:
        this.widgetFrame.pivotY = r2;
        return true;
    L8:
        this.widgetFrame.pivotX = r2;
        return true;
    L9:
        this.widgetFrame.scaleY = r2;
        return true;
    L10:
        this.widgetFrame.scaleX = r2;
        return true;
    L11:
        this.widgetFrame.rotationZ = r2;
        return true;
    L12:
        this.widgetFrame.rotationY = r2;
        return true;
    L13:
        this.widgetFrame.rotationX = r2;
        return true;
    L14:
        this.widgetFrame.translationZ = r2;
        return true;
    L15:
        this.widgetFrame.translationY = r2;
        return true;
    L16:
        this.widgetFrame.translationX = r2;
        return true;
    L17:
        this.widgetFrame.alpha = r2;
        return true;
    }

    public boolean setValueMotion(int r1, float r2) {
        switch(r1) {
            case 600: goto L7;
            case 601: goto L6;
            case 602: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.motion.mQuantizeMotionPhase = r2;
        return true;
    L6:
        this.motion.mPathRotate = r2;
        return true;
    L7:
        this.motion.mMotionStagger = r2;
        return true;
    }

    public boolean setValueMotion(int r1, int r2) {
        switch(r1) {
            case 605: goto L12;
            case 606: goto L11;
            case 607: goto L10;
            case 608: goto L9;
            case 609: goto L8;
            case 610: goto L7;
            case 611: goto L6;
            case 612: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        this.motion.mQuantizeInterpolatorID = r2;
        return true;
    L6:
        this.motion.mQuantizeInterpolatorType = r2;
        return true;
    L7:
        this.motion.mQuantizeMotionSteps = r2;
        return true;
    L8:
        this.motion.mPolarRelativeTo = r2;
        return true;
    L9:
        this.motion.mDrawPath = r2;
        return true;
    L10:
        this.motion.mPathMotionArc = r2;
        return true;
    L11:
        this.motion.mAnimateCircleAngleTo = r2;
        return true;
    L12:
        this.motion.mAnimateRelativeTo = r2;
        return true;
    }

    public boolean setValueMotion(int r2, String r3) {
        if (r2 != 603) goto L5;
        this.motion.mTransitionEasing = r3;
        return true;
    L5:
        if (r2 == 604) goto L8;
        return false;
    L8:
        this.motion.mQuantizeInterpolatorString = r3;
        return true;
    }

    public void setVisibility(int r1) {
        this.propertySet.visibility = r1;
    }

    public String toString() {
        return this.widgetFrame.left + ", " + this.widgetFrame.top + ", " + this.widgetFrame.right + ", " + this.widgetFrame.bottom;
    }
}
