package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int r4, int r5, KeyPosition r6, MotionPaths r7, MotionPaths r8) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (r7.mAnimateRelativeTo == Key.UNSET) goto L6;
        initPolar(r4, r5, r6, r7, r8);
        return;
    L6:
        int r0 = r6.mPositionType;
        if (r0 != 1) goto L9;
        initPath(r6, r7, r8);
        return;
    L9:
        if (r0 == 2) goto L12;
        initCartesian(r6, r7, r8);
        return;
    L12:
        initScreen(r4, r5, r6, r7, r8);
    }

    private boolean diff(float r3, float r4) {
        if (Float.isNaN(r3) == true) goto L13;
        if (Float.isNaN(r4) == true) goto L13;
        if (Math.abs(r3 - r4) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r3) == Float.isNaN(r4)) goto L16;
        return true;
    L16:
        return false;
    }

    private static final float xRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r1) - ((r5 - r3) * r0)) + r2;
    }

    private static final float yRotate(float r0, float r1, float r2, float r3, float r4, float r5) {
        return (((r4 - r2) * r0) + ((r5 - r3) * r1)) + r3;
    }

    public void applyParameters(ConstraintSet.Constraint r6) {
        this.mKeyFrameEasing = Easing.getInterpolator(r6.motion.mTransitionEasing);
        this.mPathMotionArc = r6.motion.mPathMotionArc;
        this.mAnimateRelativeTo = r6.motion.mAnimateRelativeTo;
        this.mPathRotate = r6.motion.mPathRotate;
        this.mDrawPath = r6.motion.mDrawPath;
        this.mAnimateCircleAngleTo = r6.motion.mAnimateCircleAngleTo;
        this.mProgress = r6.propertySet.mProgress;
        this.mRelativeAngle = r6.layout.circleAngle;
        Iterator<String> r0 = r6.mCustomConstraints.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        ConstraintAttribute r2 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r6.mCustomConstraints.get(r1), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (r2.isContinuous() == false) goto L4;
        this.attributes.put(r1, r2);
        goto L4
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths r1) {
        return Float.compare(this.position, r1.position);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(MotionPaths r3) {
        return compareTo2((MotionPaths) ZeusTransformUtils.preCheckCast(r3, MotionPaths.class, "com.obric.memorydata.plugin"));
    }

    public void configureRelativeTo(MotionController r3) {
        r3.getPos(this.mProgress);
    }

    void different(MotionPaths r6, boolean[] r7, String[] r8, boolean r9) {
        boolean r10 = diff(this.x, r6.x);
        boolean r0 = diff(this.y, r6.y);
        r7[0] = r7[0] | diff(this.position, r6.position);
        boolean r11 = (r10 | r0) | r9;
        r7[1] = r7[1] | r11;
        r7[2] = r11 | r7[2];
        r7[3] = r7[3] | diff(this.width, r6.width);
        boolean r12 = r7[4];
        r7[4] = diff(this.height, r6.height) | r12;
    }

    void fillStandard(double[] r7, int[] r8) {
        int r3 = 0;
        float[] r1 = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int r6 = 0;
    L4:
        if (r3 >= r8.length) goto L9;
        if (r8[r3] >= 6) goto L8;
        r7[r6] = r1[r8[r3]];
        r6 = r6 + 1;
    L8:
        r3 = r3 + 1;
        goto L4
    }

    void getBounds(int[] r6, double[] r7, float[] r8, int r9) {
        float r0 = this.width;
        float r5 = this.height;
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L13;
        float r2 = (float) r7[r1];
        int r3 = r6[r1];
        if (r3 != 3) goto L8;
        r0 = r2;
    L12:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r3 != 4) goto L12;
        r5 = r2;
        goto L12
    L13:
        r8[r9] = r0;
        r8[r9 + 1] = r5;
    }

    void getCenter(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r7 = 0;
    L4:
        if (r7 >= r18.length) goto L18;
        float r8 = (float) r19[r7];
        int r11 = r18[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(r16, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        r20[r21] = (r2 + (r4 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    void getCenter(double r19, int[] r21, double[] r22, float[] r23, double[] r24, float[] r25) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r8 = 0;
        float r9 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
    L4:
        if (r8 >= r21.length) goto L19;
        float r6 = (float) r22[r8];
        float r13 = (float) r24[r8];
        int r14 = r21[r8];
        if (r14 != 1) goto L8;
        r2 = r6;
        r9 = r13;
    L18:
        r8 = r8 + 1;
        goto L4
    L8:
        if (r14 != 2) goto L10;
        r3 = r6;
        r11 = r13;
        goto L18
    L10:
        if (r14 != 3) goto L12;
        r4 = r6;
        r10 = r13;
        goto L18
    L12:
        if (r14 != 4) goto L18;
        r5 = r6;
        r12 = r13;
        goto L18
    L19:
        float r15 = (r10 / 2.0f) + r9;
        float r16 = (r12 / 2.0f) + r11;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L22;
        float[] r7 = new float[2];
        float[] r17 = new float[2];
        r0.getCenter(r19, r7, r17);
        float r18 = r7[0];
        float r20 = r7[1];
        float r110 = r17[0];
        float r1 = r17[1];
        double r26 = r2;
        float r27 = r11;
        double r111 = r3;
        float r28 = (float) ((((double) r18) + (Math.sin(r111) * r26)) - ((double) (r4 / 2.0f)));
        float r29 = (float) ((((double) r20) - (r26 * Math.cos(r111))) - ((double) (r5 / 2.0f)));
        double r30 = r9;
        double r31 = r27;
        float r32 = (float) ((((double) r110) + (Math.sin(r111) * r30)) + (Math.cos(r111) * r31));
        r16 = (float) ((((double) r1) - (r30 * Math.cos(r111))) + (Math.sin(r111) * r31));
        r2 = r28;
        r3 = r29;
        r15 = r32;
        float r33 = 2.0f;
    L23:
        r23[0] = (r2 + (r4 / r33)) + 0.0f;
        r23[1] = (r3 + (r5 / r33)) + 0.0f;
        r25[0] = r15;
        r25[1] = r16;
        return;
    L22:
        r33 = 2.0f;
        goto L23
    }

    void getCenterVelocity(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r2 = this.x;
        float r3 = this.y;
        float r4 = this.width;
        float r5 = this.height;
        int r7 = 0;
    L4:
        if (r7 >= r18.length) goto L18;
        float r8 = (float) r19[r7];
        int r11 = r18[r7];
        if (r11 == 1) goto L16;
        if (r11 != 2) goto L9;
        r3 = r8;
    L17:
        r7 = r7 + 1;
        goto L4
    L9:
        if (r11 != 3) goto L11;
        r4 = r8;
        goto L17
    L11:
        if (r11 != 4) goto L17;
        r5 = r8;
        goto L17
    L16:
        r2 = r8;
        goto L17
    L18:
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L21;
        float[] r9 = new float[2];
        r0.getCenter(r16, r9, new float[2]);
        float r1 = r9[0];
        float r6 = r9[1];
        double r12 = r2;
        double r10 = r3;
        float r13 = (float) ((((double) r1) + (Math.sin(r10) * r12)) - ((double) (r4 / 2.0f)));
        r3 = (float) ((((double) r6) - (r12 * Math.cos(r10))) - ((double) (r5 / 2.0f)));
        r2 = r13;
    L21:
        r20[r21] = (r2 + (r4 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r3 + (r5 / 2.0f)) + 0.0f;
    }

    int getCustomData(String r5, double[] r6, int r7) {
        ConstraintAttribute r4 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.attributes.get(r5), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        int r8 = 0;
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.numberOfInterpolatedValues() != 1) goto L9;
        r6[r7] = r4.getValueToInterpolate();
        return 1;
    L9:
        int r0 = r4.numberOfInterpolatedValues();
        float[] r1 = new float[r0];
        r4.getValuesToInterpolate(r1);
    L10:
        if (r8 >= r0) goto L12;
        r6[r7] = r1[r8];
        r8 = r8 + 1;
        r7 = r7 + 1;
        goto L10
    L12:
        return r0;
    }

    int getCustomDataCount(String r2) {
        ConstraintAttribute r1 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.attributes.get(r2), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.numberOfInterpolatedValues();
    }

    void getRect(int[] r10, double[] r11, float[] r12, int r13) {
        float r0 = this.x;
        float r1 = this.y;
        float r2 = this.width;
        float r3 = this.height;
        int r4 = 0;
    L4:
        if (r4 >= r10.length) goto L19;
        float r5 = (float) r11[r4];
        int r6 = r10[r4];
        if (r6 != 1) goto L8;
        r0 = r5;
    L18:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 != 2) goto L10;
        r1 = r5;
        goto L18
    L10:
        if (r6 != 3) goto L12;
        r2 = r5;
        goto L18
    L12:
        if (r6 != 4) goto L18;
        r3 = r5;
        goto L18
    L19:
        MotionController r14 = this.mRelativeToController;
        if (r14 == null) goto L22;
        float r15 = r14.getCenterX();
        float r9 = this.mRelativeToController.getCenterY();
        double r7 = r0;
        double r8 = r1;
        float r16 = (float) ((((double) r15) + (Math.sin(r8) * r7)) - ((double) (r2 / 2.0f)));
        r1 = (float) ((((double) r9) - (r7 * Math.cos(r8))) - ((double) (r3 / 2.0f)));
        r0 = r16;
    L22:
        float r17 = r2 + r0;
        float r18 = r3 + r1;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int r19 = r13 + 1;
        r12[r13] = r0 + 0.0f;
        int r110 = r19 + 1;
        r12[r19] = r1 + 0.0f;
        int r20 = r110 + 1;
        r12[r110] = r17 + 0.0f;
        int r111 = r20 + 1;
        r12[r20] = r1 + 0.0f;
        int r21 = r111 + 1;
        r12[r111] = r17 + 0.0f;
        int r112 = r21 + 1;
        r12[r21] = r18 + 0.0f;
        r12[r112] = r0 + 0.0f;
        r12[r112 + 1] = r18 + 0.0f;
    }

    boolean hasCustomData(String r1) {
        return this.attributes.containsKey(r1);
    }

    void initCartesian(KeyPosition r18, MotionPaths r19, MotionPaths r20) {
        float r4 = r18.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r18.mDrawPath;
        if (Float.isNaN(r18.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r18.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r20.width;
        float r8 = r19.width;
        float r10 = r20.height;
        float r11 = r19.height;
        this.position = this.time;
        float r13 = r19.x;
        float r1 = r19.y;
        float r2 = r20.x + (r7 / 2.0f);
        float r3 = r2 - ((r8 / 2.0f) + r13);
        float r9 = (r20.y + (r10 / 2.0f)) - (r1 + (r11 / 2.0f));
        float r12 = (r7 - r8) * r5;
        float r14 = r12 / 2.0f;
        this.x = (int) ((r13 + (r3 * r4)) - r14);
        float r15 = (r10 - r11) * r6;
        float r16 = r15 / 2.0f;
        this.y = (int) ((r1 + (r9 * r4)) - r16);
        this.width = (int) (r8 + r12);
        this.height = (int) (r11 + r15);
        if (Float.isNaN(r18.mPercentX) == false) goto L13;
        float r17 = r4;
    L14:
        float r21 = 0.0f;
        if (Float.isNaN(r18.mAltPercentY) == false) goto L17;
        float r22 = 0.0f;
    L19:
        if (Float.isNaN(r18.mPercentY) == true) goto L23;
        r4 = r18.mPercentY;
    L23:
        if (Float.isNaN(r18.mAltPercentX) == true) goto L26;
        r21 = r18.mAltPercentX;
    L26:
        this.mMode = 0;
        this.x = (int) (((r19.x + (r17 * r3)) + (r21 * r9)) - r14);
        this.y = (int) (((r19.y + (r3 * r22)) + (r9 * r4)) - r16);
        this.mKeyFrameEasing = Easing.getInterpolator(r18.mTransitionEasing);
        this.mPathMotionArc = r18.mPathMotionArc;
        return;
    L17:
        r22 = r18.mAltPercentY;
        goto L19
    L13:
        r17 = r18.mPercentX;
        goto L14
    L9:
        r6 = r18.mPercentHeight;
        goto L10
    L5:
        r5 = r18.mPercentWidth;
        goto L7
    }

    void initPath(KeyPosition r17, MotionPaths r18, MotionPaths r19) {
        float r4 = r17.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r17.mDrawPath;
        if (Float.isNaN(r17.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r17.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r19.width - r18.width;
        float r8 = r19.height - r18.height;
        this.position = this.time;
        if (Float.isNaN(r17.mPercentX) == true) goto L14;
        r4 = r17.mPercentX;
    L14:
        float r9 = r18.x;
        float r10 = r18.width;
        float r13 = r18.y;
        float r14 = r18.height;
        float r2 = r19.x + (r19.width / 2.0f);
        float r3 = r2 - ((r10 / 2.0f) + r9);
        float r1 = (r19.y + (r19.height / 2.0f)) - ((r14 / 2.0f) + r13);
        float r11 = r3 * r4;
        float r12 = r7 * r5;
        float r15 = r12 / 2.0f;
        this.x = (int) ((r9 + r11) - r15);
        float r16 = r4 * r1;
        float r20 = r8 * r6;
        float r21 = r20 / 2.0f;
        this.y = (int) ((r13 + r16) - r21);
        this.width = (int) (r10 + r12);
        this.height = (int) (r14 + r20);
        if (Float.isNaN(r17.mPercentY) == false) goto L17;
        float r22 = 0.0f;
    L18:
        this.mMode = 1;
        float r23 = (int) ((r18.x + r11) - r15);
        this.x = r23;
        float r24 = (int) ((r18.y + r16) - r21);
        this.y = r24;
        this.x = r23 + ((-r1) * r22);
        this.y = r24 + (r3 * r22);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r17.mTransitionEasing);
        this.mPathMotionArc = r17.mPathMotionArc;
        return;
    L17:
        r22 = r17.mPercentY;
        goto L18
    L9:
        r6 = r17.mPercentHeight;
        goto L10
    L5:
        r5 = r17.mPercentWidth;
        goto L7
    }

    void initPolar(int r7, int r8, KeyPosition r9, MotionPaths r10, MotionPaths r11) {
        float r12 = r9.mFramePosition / 100.0f;
        this.time = r12;
        this.mDrawPath = r9.mDrawPath;
        this.mMode = r9.mPositionType;
        if (Float.isNaN(r9.mPercentWidth) == false) goto L5;
        float r13 = r12;
    L7:
        if (Float.isNaN(r9.mPercentHeight) == false) goto L9;
        float r0 = r12;
    L10:
        float r1 = r11.width;
        float r2 = r10.width;
        float r3 = r11.height;
        float r4 = r10.height;
        this.position = this.time;
        this.width = (int) (r2 + ((r1 - r2) * r13));
        this.height = (int) (r4 + ((r3 - r4) * r0));
        int r5 = r9.mPositionType;
        if (r5 == 1) goto L33;
        if (r5 == 2) goto L25;
        if (Float.isNaN(r9.mPercentX) == false) goto L17;
        float r14 = r12;
    L18:
        float r6 = r11.x;
        float r15 = r10.x;
        this.x = (r14 * (r6 - r15)) + r15;
        if (Float.isNaN(r9.mPercentY) == true) goto L22;
    L21:
        r12 = r9.mPercentY;
    L22:
        float r16 = r11.y;
        float r17 = r10.y;
        float r18 = (r12 * (r16 - r17)) + r17;
    L23:
        this.y = r18;
        this.mAnimateRelativeTo = r10.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r9.mTransitionEasing);
        this.mPathMotionArc = r9.mPathMotionArc;
        return;
    L17:
        r14 = r9.mPercentX;
        goto L18
    L25:
        if (Float.isNaN(r9.mPercentX) == false) goto L27;
        float r19 = r11.x;
        float r20 = r10.x;
        float r21 = ((r19 - r20) * r12) + r20;
    L28:
        this.x = r21;
        if (Float.isNaN(r9.mPercentY) == true) goto L22;
        r18 = r9.mPercentY;
        goto L23
    L27:
        r21 = Math.min(r0, r13) * r9.mPercentX;
        goto L28
    L33:
        if (Float.isNaN(r9.mPercentX) == false) goto L35;
        float r22 = r12;
    L36:
        float r23 = r11.x;
        float r24 = r10.x;
        this.x = (r22 * (r23 - r24)) + r24;
        if (Float.isNaN(r9.mPercentY) == false) goto L21;
    L35:
        r22 = r9.mPercentX;
        goto L36
    L9:
        r0 = r9.mPercentHeight;
        goto L10
    L5:
        r13 = r9.mPercentWidth;
        goto L7
    }

    void initScreen(int r18, int r19, KeyPosition r20, MotionPaths r21, MotionPaths r22) {
        float r4 = r20.mFramePosition / 100.0f;
        this.time = r4;
        this.mDrawPath = r20.mDrawPath;
        if (Float.isNaN(r20.mPercentWidth) == false) goto L5;
        float r5 = r4;
    L7:
        if (Float.isNaN(r20.mPercentHeight) == false) goto L9;
        float r6 = r4;
    L10:
        float r7 = r22.width;
        float r8 = r21.width;
        float r10 = r22.height;
        float r11 = r21.height;
        this.position = this.time;
        float r13 = r21.x;
        float r2 = r21.y;
        float r1 = r22.x + (r7 / 2.0f);
        float r3 = r22.y + (r10 / 2.0f);
        float r9 = (r7 - r8) * r5;
        this.x = (int) ((r13 + ((r1 - ((r8 / 2.0f) + r13)) * r4)) - (r9 / 2.0f));
        float r12 = (r10 - r11) * r6;
        this.y = (int) ((r2 + ((r3 - (r2 + (r11 / 2.0f))) * r4)) - (r12 / 2.0f));
        this.width = (int) (r8 + r9);
        this.height = (int) (r11 + r12);
        this.mMode = 2;
        if (Float.isNaN(r20.mPercentX) == true) goto L14;
        this.x = (int) (r20.mPercentX * ((int) (r18 - this.width)));
    L14:
        if (Float.isNaN(r20.mPercentY) == true) goto L16;
        this.y = (int) (r20.mPercentY * ((int) (r19 - this.height)));
    L16:
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r20.mTransitionEasing);
        this.mPathMotionArc = r20.mPathMotionArc;
        return;
    L9:
        r6 = r20.mPercentHeight;
        goto L10
    L5:
        r5 = r20.mPercentWidth;
        goto L7
    }

    void setBounds(float r1, float r2, float r3, float r4) {
        this.x = r1;
        this.y = r2;
        this.width = r3;
        this.height = r4;
    }

    void setDpDt(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        int r3 = 0;
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r6 = 0.0f;
        float r7 = 0.0f;
    L4:
        if (r3 >= r16.length) goto L19;
        float r8 = (float) r17[r3];
        double r10 = r18[r3];
        int r11 = r16[r3];
        if (r11 != 1) goto L8;
        r4 = r8;
    L18:
        r3 = r3 + 1;
        goto L4
    L8:
        if (r11 != 2) goto L10;
        r6 = r8;
        goto L18
    L10:
        if (r11 != 3) goto L12;
        r5 = r8;
        goto L18
    L12:
        if (r11 != 4) goto L18;
        r7 = r8;
        goto L18
    L19:
        float r9 = r4 - ((0.0f * r5) / 2.0f);
        float r12 = r6 - ((0.0f * r7) / 2.0f);
        r15[0] = ((r9 * (1.0f - r13)) + (((r5 * 1.0f) + r9) * r13)) + 0.0f;
        r15[1] = ((r12 * (1.0f - r14)) + (((r7 * 1.0f) + r12) * r14)) + 0.0f;
    }

    void setView(float r21, View r22, int[] r23, double[] r24, double[] r25, double[] r26, boolean r27) {
        float r4 = this.x;
        float r5 = this.y;
        float r6 = this.width;
        float r7 = this.height;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r10 = 0;
    L9:
        if (r10 >= r23.length) goto L11;
        this.mTempValue[r23[r10]] = r24[r10];
        this.mTempDelta[r23[r10]] = r25[r10];
        r10 = r10 + 1;
        goto L9
    L11:
        float r11 = Float.NaN;
        int r12 = 0;
        float r13 = 0.0f;
        float r14 = 0.0f;
        float r15 = 0.0f;
        float r16 = 0.0f;
    L12:
        double[] r2 = this.mTempValue;
        if (r12 >= r2.length) goto L43;
        double r17 = 0.0d;
        if (Double.isNaN(r2[r12]) == false) goto L20;
        if (r26 != null) goto L18;
    L19:
        float r28 = r11;
    L36:
        r11 = r28;
    L42:
        r12 = r12 + 1;
        goto L12
    L18:
        if (r26[r12] == 0.0d) goto L19;
    L20:
        if (r26 == null) goto L23;
        r17 = r26[r12];
    L23:
        if (Double.isNaN(this.mTempValue[r12]) == true) goto L26;
        r17 = this.mTempValue[r12] + r17;
    L26:
        r28 = r11;
        float r8 = (float) r17;
        float r9 = (float) this.mTempDelta[r12];
        if (r12 != 1) goto L29;
        r11 = r28;
        r4 = r8;
        r13 = r9;
        goto L42
    L29:
        if (r12 != 2) goto L31;
        r11 = r28;
        r5 = r8;
        r14 = r9;
        goto L42
    L31:
        if (r12 != 3) goto L33;
        r11 = r28;
        r6 = r8;
        r15 = r9;
        goto L42
    L33:
        if (r12 != 4) goto L35;
        r11 = r28;
        r7 = r8;
        r16 = r9;
        goto L42
    L35:
        if (r12 != 5) goto L36;
        r11 = r8;
        goto L42
    L43:
        float r29 = r11;
        MotionController r0 = this.mRelativeToController;
        if (r0 == null) goto L53;
        float[] r18 = new float[2];
        float[] r19 = new float[2];
        r0.getCenter(r21, r18, r19);
        float r110 = r18[0];
        float r20 = r18[1];
        float r111 = r19[0];
        float r1 = r19[1];
        double r3 = r4;
        double r30 = r5;
        float r31 = (float) ((((double) r110) + (Math.sin(r30) * r3)) - ((double) (r6 / 2.0f)));
        float r112 = r7;
        float r32 = (float) ((((double) r20) - (Math.cos(r30) * r3)) - ((double) (r7 / 2.0f)));
        double r113 = r13;
        double r114 = r14;
        float r33 = (float) ((((double) r111) + (Math.sin(r30) * r113)) + ((Math.cos(r30) * r3) * r114));
        float r34 = (float) ((((double) r1) - (r113 * Math.cos(r30))) + ((r3 * Math.sin(r30)) * r114));
        if (r25.length < 2) goto L48;
        boolean r35 = false;
        r25[0] = r33;
        boolean r115 = true;
        r25[1] = r34;
    L50:
        if (Float.isNaN(r29) == true) goto L52;
        r22.setRotation((float) (((double) r29) + Math.toDegrees(Math.atan2(r34, r33))));
    L52:
        r4 = r31;
        r5 = r32;
    L57:
        if (ZeusTransformUtils.instanceOf(r22, FloatLayout.class) == false) goto L60;
        ((FloatLayout) ZeusTransformUtils.preCheckCast(r22, FloatLayout.class, "com.obric.memorydata.plugin")).layout(r4, r5, r6 + r4, r5 + r112);
        return;
    L60:
        float r36 = r4 + 0.5f;
        int r37 = (int) r36;
        float r38 = r5 + 0.5f;
        int r39 = (int) r38;
        int r40 = (int) (r36 + r6);
        int r41 = (int) (r38 + r112);
        int r42 = r40 - r37;
        int r43 = r41 - r39;
        if (r42 == r22.getMeasuredWidth()) goto L63;
    L64:
        r35 = r115;
    L65:
        if (r35 == true) goto L67;
        if (r27 == true) goto L67;
    L68:
        r22.layout(r37, r39, r40, r41);
        return;
    L67:
        r22.measure(View.MeasureSpec.makeMeasureSpec(r42, 1073741824), View.MeasureSpec.makeMeasureSpec(r43, 1073741824));
        goto L68
    L63:
        if (r43 == r22.getMeasuredHeight()) goto L65;
    L48:
        r35 = false;
        r115 = true;
        goto L50
    L53:
        r112 = r7;
        r35 = false;
        r115 = true;
        if (Float.isNaN(r29) == true) goto L57;
        r22.setRotation((float) (((double) 0.0f) + (((double) r29) + Math.toDegrees(Math.atan2(r14 + (r16 / 2.0f), r13 + (r15 / 2.0f))))));
        goto L57
    L5:
        if (this.mTempValue.length > r23[r23.length - 1]) goto L7;
        int r44 = r23[r23.length - 1] + 1;
        this.mTempValue = new double[r44];
        this.mTempDelta = new double[r44];
        goto L7
    }

    public void setupRelative(MotionController r6, MotionPaths r7) {
        double r0 = ((this.x + (this.width / 2.0f)) - r7.x) - (r7.width / 2.0f);
        double r2 = ((this.y + (this.height / 2.0f)) - r7.y) - (r7.height / 2.0f);
        this.mRelativeToController = r6;
        this.x = (float) Math.hypot(r2, r0);
        if (Float.isNaN(this.mRelativeAngle) == false) goto L5;
        double r8 = Math.atan2(r2, r0) + 1.5707963267948966d;
    L6:
        this.y = (float) r8;
        return;
    L5:
        r8 = Math.toRadians(this.mRelativeAngle);
        goto L6
    }
}
