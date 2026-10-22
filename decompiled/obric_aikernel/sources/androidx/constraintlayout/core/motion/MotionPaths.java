package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names;
    HashMap<String, CustomVariable> customAttributes;
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
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f236x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f237y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    public MotionPaths(int r10, int r11, MotionKeyPosition r12, MotionPaths r13, MotionPaths r14) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (r13.mAnimateRelativeTo == (-1)) goto L6;
        initPolar(r10, r11, r12, r13, r14);
        return;
    L6:
        int r15 = r12.mPositionType;
        if (r15 != 1) goto L9;
        initPath(r12, r13, r14);
        return;
    L9:
        if (r15 == 2) goto L12;
        initCartesian(r12, r13, r14);
        return;
    L12:
        initScreen(r10, r11, r12, r13, r14);
    }

    private boolean diff(float r10, float r11) {
        if (Float.isNaN(r10) == true) goto L13;
        if (Float.isNaN(r11) == true) goto L13;
        if (Math.abs(r10 - r11) <= 1.0E-6f) goto L11;
        return true;
    L11:
        return false;
    L13:
        if (Float.isNaN(r10) == Float.isNaN(r11)) goto L16;
        return true;
    L16:
        return false;
    }

    private static final float xRotate(float r10, float r11, float r12, float r13, float r14, float r15) {
        return (((r14 - r12) * r11) - ((r15 - r13) * r10)) + r12;
    }

    private static final float yRotate(float r10, float r11, float r12, float r13, float r14, float r15) {
        return (((r14 - r12) * r10) + ((r15 - r13) * r11)) + r13;
    }

    public void applyParameters(MotionWidget r10) {
        this.mKeyFrameEasing = Easing.getInterpolator(r10.motion.mTransitionEasing);
        MotionWidget.Motion r11 = r10.motion;
        this.mPathMotionArc = r11.mPathMotionArc;
        this.mAnimateRelativeTo = r11.mAnimateRelativeTo;
        this.mPathRotate = r11.mPathRotate;
        this.mDrawPath = r11.mDrawPath;
        this.mAnimateCircleAngleTo = r11.mAnimateCircleAngleTo;
        this.mProgress = r10.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        Iterator<String> r12 = r10.getCustomAttributeNames().iterator();
    L4:
        if (r12.hasNext() == false) goto L10;
        String r13 = r12.next();
        CustomVariable r14 = r10.getCustomAttribute(r13);
        if (r14 == null) goto L4;
        if (r14.isContinuous() == false) goto L4;
        this.customAttributes.put(r13, r14);
        goto L4
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MotionPaths r10) {
        return Float.compare(this.position, r10.position);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MotionPaths r10) {
        return compareTo2(r10);
    }

    public void configureRelativeTo(Motion r10) {
        r10.getPos(this.mProgress);
    }

    void different(MotionPaths r10, boolean[] r11, String[] r12, boolean r13) {
        boolean r14 = diff(this.f236x, r10.f236x);
        boolean r15 = diff(this.f237y, r10.f237y);
        r11[0] = r11[0] | diff(this.position, r10.position);
        boolean r16 = (r14 | r15) | r13;
        r11[1] = r11[1] | r16;
        r11[2] = r16 | r11[2];
        r11[3] = r11[3] | diff(this.width, r10.width);
        boolean r17 = r11[4];
        r11[4] = diff(this.height, r10.height) | r17;
    }

    void fillStandard(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.position, this.f236x, this.f237y, this.width, this.height, this.mPathRotate};
        int r14 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        if (r11[r12] >= 6) goto L8;
        r10[r14] = r13[r11[r12]];
        r14 = r14 + 1;
    L8:
        r12 = r12 + 1;
        goto L4
    }

    void getBounds(int[] r10, double[] r11, float[] r12, int r13) {
        float r14 = this.width;
        float r15 = this.height;
        int r16 = 0;
    L4:
        if (r16 >= r10.length) goto L13;
        float r17 = (float) r11[r16];
        int r18 = r10[r16];
        if (r18 != 3) goto L8;
        r14 = r17;
    L12:
        r16 = r16 + 1;
        goto L4
    L8:
        if (r18 != 4) goto L12;
        r15 = r17;
        goto L12
    L13:
        r12[r13] = r14;
        r12[r13 + 1] = r15;
    }

    void getCenter(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r10 = this.f236x;
        float r11 = this.f237y;
        float r12 = this.width;
        float r13 = this.height;
        int r14 = 0;
    L4:
        if (r14 >= r18.length) goto L18;
        float r15 = (float) r19[r14];
        int r17 = r18[r14];
        if (r17 == 1) goto L16;
        if (r17 != 2) goto L9;
        r11 = r15;
    L17:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r17 != 3) goto L11;
        r12 = r15;
        goto L17
    L11:
        if (r17 != 4) goto L17;
        r13 = r15;
        goto L17
    L16:
        r10 = r15;
        goto L17
    L18:
        Motion r22 = this.mRelativeToController;
        if (r22 == null) goto L21;
        float[] r23 = new float[2];
        r22.getCenter(r16, r23, new float[2]);
        float r24 = r23[0];
        float r25 = r23[1];
        double r110 = r10;
        double r26 = r11;
        float r27 = (float) ((((double) r24) + (Math.sin(r26) * r110)) - ((double) (r12 / 2.0f)));
        r11 = (float) ((((double) r25) - (r110 * Math.cos(r26))) - ((double) (r13 / 2.0f)));
        r10 = r27;
    L21:
        r20[r21] = (r10 + (r12 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r11 + (r13 / 2.0f)) + 0.0f;
    }

    void getCenter(double r19, int[] r21, double[] r22, float[] r23, double[] r24, float[] r25) {
        float r10 = this.f236x;
        float r11 = this.f237y;
        float r12 = this.width;
        float r13 = this.height;
        int r14 = 0;
        float r15 = 0.0f;
        float r16 = 0.0f;
        float r17 = 0.0f;
        float r18 = 0.0f;
    L4:
        if (r14 >= r21.length) goto L19;
        float r20 = (float) r22[r14];
        float r110 = (float) r24[r14];
        int r111 = r21[r14];
        if (r111 != 1) goto L8;
        r10 = r20;
        r15 = r110;
    L18:
        r14 = r14 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r11 = r20;
        r17 = r110;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r12 = r20;
        r16 = r110;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r13 = r20;
        r18 = r110;
        goto L18
    L19:
        float r112 = (r16 / 2.0f) + r15;
        float r113 = (r18 / 2.0f) + r17;
        Motion r26 = this.mRelativeToController;
        if (r26 == null) goto L22;
        float[] r27 = new float[2];
        float[] r28 = new float[2];
        r26.getCenter(r19, r27, r28);
        float r29 = r27[0];
        float r30 = r27[1];
        float r114 = r28[0];
        float r31 = r28[1];
        double r32 = r10;
        float r33 = r17;
        double r115 = r11;
        float r34 = (float) ((((double) r29) + (Math.sin(r115) * r32)) - ((double) (r12 / 2.0f)));
        float r35 = (float) ((((double) r30) - (r32 * Math.cos(r115))) - ((double) (r13 / 2.0f)));
        double r36 = r15;
        double r37 = r33;
        float r38 = (float) ((((double) r114) + (Math.sin(r115) * r36)) + (Math.cos(r115) * r37));
        r113 = (float) ((((double) r31) - (r36 * Math.cos(r115))) + (Math.sin(r115) * r37));
        r10 = r34;
        r11 = r35;
        r112 = r38;
        float r39 = 2.0f;
    L23:
        r23[0] = (r10 + (r12 / r39)) + 0.0f;
        r23[1] = (r11 + (r13 / r39)) + 0.0f;
        r25[0] = r112;
        r25[1] = r113;
        return;
    L22:
        r39 = 2.0f;
        goto L23
    }

    void getCenterVelocity(double r16, int[] r18, double[] r19, float[] r20, int r21) {
        float r10 = this.f236x;
        float r11 = this.f237y;
        float r12 = this.width;
        float r13 = this.height;
        int r14 = 0;
    L4:
        if (r14 >= r18.length) goto L18;
        float r15 = (float) r19[r14];
        int r17 = r18[r14];
        if (r17 == 1) goto L16;
        if (r17 != 2) goto L9;
        r11 = r15;
    L17:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r17 != 3) goto L11;
        r12 = r15;
        goto L17
    L11:
        if (r17 != 4) goto L17;
        r13 = r15;
        goto L17
    L16:
        r10 = r15;
        goto L17
    L18:
        Motion r22 = this.mRelativeToController;
        if (r22 == null) goto L21;
        float[] r23 = new float[2];
        r22.getCenter(r16, r23, new float[2]);
        float r24 = r23[0];
        float r25 = r23[1];
        double r110 = r10;
        double r26 = r11;
        float r27 = (float) ((((double) r24) + (Math.sin(r26) * r110)) - ((double) (r12 / 2.0f)));
        r11 = (float) ((((double) r25) - (r110 * Math.cos(r26))) - ((double) (r13 / 2.0f)));
        r10 = r27;
    L21:
        r20[r21] = (r10 + (r12 / 2.0f)) + 0.0f;
        r20[r21 + 1] = (r11 + (r13 / 2.0f)) + 0.0f;
    }

    int getCustomData(String r10, double[] r11, int r12) {
        CustomVariable r13 = this.customAttributes.get(r10);
        int r14 = 0;
        if (r13 != null) goto L6;
        return 0;
    L6:
        if (r13.numberOfInterpolatedValues() != 1) goto L9;
        r11[r12] = r13.getValueToInterpolate();
        return 1;
    L9:
        int r15 = r13.numberOfInterpolatedValues();
        float[] r16 = new float[r15];
        r13.getValuesToInterpolate(r16);
    L10:
        if (r14 >= r15) goto L12;
        r11[r12] = r16[r14];
        r14 = r14 + 1;
        r12 = r12 + 1;
        goto L10
    L12:
        return r15;
    }

    int getCustomDataCount(String r10) {
        CustomVariable r11 = this.customAttributes.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.numberOfInterpolatedValues();
    }

    void getRect(int[] r10, double[] r11, float[] r12, int r13) {
        float r14 = this.f236x;
        float r15 = this.f237y;
        float r16 = this.width;
        float r17 = this.height;
        int r18 = 0;
    L4:
        if (r18 >= r10.length) goto L19;
        float r19 = (float) r11[r18];
        int r20 = r10[r18];
        if (r20 != 1) goto L8;
        r14 = r19;
    L18:
        r18 = r18 + 1;
        goto L4
    L8:
        if (r20 != 2) goto L10;
        r15 = r19;
        goto L18
    L10:
        if (r20 != 3) goto L12;
        r16 = r19;
        goto L18
    L12:
        if (r20 != 4) goto L18;
        r17 = r19;
        goto L18
    L19:
        Motion r110 = this.mRelativeToController;
        if (r110 == null) goto L22;
        float r111 = r110.getCenterX();
        float r21 = this.mRelativeToController.getCenterY();
        double r22 = r14;
        double r23 = r15;
        float r112 = (float) ((((double) r111) + (Math.sin(r23) * r22)) - ((double) (r16 / 2.0f)));
        r15 = (float) ((((double) r21) - (r22 * Math.cos(r23))) - ((double) (r17 / 2.0f)));
        r14 = r112;
    L22:
        float r24 = r16 + r14;
        float r25 = r17 + r15;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int r26 = r13 + 1;
        r12[r13] = r14 + 0.0f;
        int r113 = r26 + 1;
        r12[r26] = r15 + 0.0f;
        int r27 = r113 + 1;
        r12[r113] = r24 + 0.0f;
        int r114 = r27 + 1;
        r12[r27] = r15 + 0.0f;
        int r28 = r114 + 1;
        r12[r114] = r24 + 0.0f;
        int r115 = r28 + 1;
        r12[r28] = r25 + 0.0f;
        r12[r115] = r14 + 0.0f;
        r12[r115 + 1] = r25 + 0.0f;
    }

    boolean hasCustomData(String r10) {
        return this.customAttributes.containsKey(r10);
    }

    void initCartesian(MotionKeyPosition r18, MotionPaths r19, MotionPaths r20) {
        float r10 = r18.mFramePosition / 100.0f;
        this.time = r10;
        this.mDrawPath = r18.mDrawPath;
        if (Float.isNaN(r18.mPercentWidth) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r18.mPercentHeight) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r20.width;
        float r14 = r19.width;
        float r15 = r20.height;
        float r16 = r19.height;
        this.position = this.time;
        float r17 = r19.f236x;
        float r21 = r19.f237y;
        float r22 = r20.f236x + (r13 / 2.0f);
        float r23 = r22 - ((r14 / 2.0f) + r17);
        float r24 = (r20.f237y + (r15 / 2.0f)) - (r21 + (r16 / 2.0f));
        float r25 = (r13 - r14) * r11;
        float r26 = r25 / 2.0f;
        this.f236x = (int) ((r17 + (r23 * r10)) - r26);
        float r110 = (r15 - r16) * r12;
        float r27 = r110 / 2.0f;
        this.f237y = (int) ((r21 + (r24 * r10)) - r27);
        this.width = (int) (r14 + r25);
        this.height = (int) (r16 + r110);
        if (Float.isNaN(r18.mPercentX) == false) goto L13;
        float r28 = r10;
    L14:
        float r29 = 0.0f;
        if (Float.isNaN(r18.mAltPercentY) == false) goto L17;
        float r30 = 0.0f;
    L19:
        if (Float.isNaN(r18.mPercentY) == true) goto L23;
        r10 = r18.mPercentY;
    L23:
        if (Float.isNaN(r18.mAltPercentX) == true) goto L26;
        r29 = r18.mAltPercentX;
    L26:
        this.mMode = 0;
        this.f236x = (int) (((r19.f236x + (r28 * r23)) + (r29 * r24)) - r26);
        this.f237y = (int) (((r19.f237y + (r23 * r30)) + (r24 * r10)) - r27);
        this.mKeyFrameEasing = Easing.getInterpolator(r18.mTransitionEasing);
        this.mPathMotionArc = r18.mPathMotionArc;
        return;
    L17:
        r30 = r18.mAltPercentY;
        goto L19
    L13:
        r28 = r18.mPercentX;
        goto L14
    L9:
        r12 = r18.mPercentHeight;
        goto L10
    L5:
        r11 = r18.mPercentWidth;
        goto L7
    }

    void initPath(MotionKeyPosition r17, MotionPaths r18, MotionPaths r19) {
        float r10 = r17.mFramePosition / 100.0f;
        this.time = r10;
        this.mDrawPath = r17.mDrawPath;
        if (Float.isNaN(r17.mPercentWidth) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r17.mPercentHeight) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r19.width - r18.width;
        float r14 = r19.height - r18.height;
        this.position = this.time;
        if (Float.isNaN(r17.mPercentX) == true) goto L14;
        r10 = r17.mPercentX;
    L14:
        float r15 = r18.f236x;
        float r16 = r18.width;
        float r110 = r18.f237y;
        float r111 = r18.height;
        float r20 = r19.f236x + (r19.width / 2.0f);
        float r21 = r20 - ((r16 / 2.0f) + r15);
        float r22 = (r19.f237y + (r19.height / 2.0f)) - ((r111 / 2.0f) + r110);
        float r23 = r21 * r10;
        float r24 = r13 * r11;
        float r25 = r24 / 2.0f;
        this.f236x = (int) ((r15 + r23) - r25);
        float r26 = r10 * r22;
        float r27 = r14 * r12;
        float r28 = r27 / 2.0f;
        this.f237y = (int) ((r110 + r26) - r28);
        this.width = (int) (r16 + r24);
        this.height = (int) (r111 + r27);
        if (Float.isNaN(r17.mPercentY) == false) goto L17;
        float r29 = 0.0f;
    L18:
        this.mMode = 1;
        float r30 = (int) ((r18.f236x + r23) - r25);
        this.f236x = r30;
        float r31 = (int) ((r18.f237y + r26) - r28);
        this.f237y = r31;
        this.f236x = r30 + ((-r22) * r29);
        this.f237y = r31 + (r21 * r29);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r17.mTransitionEasing);
        this.mPathMotionArc = r17.mPathMotionArc;
        return;
    L17:
        r29 = r17.mPercentY;
        goto L18
    L9:
        r12 = r17.mPercentHeight;
        goto L10
    L5:
        r11 = r17.mPercentWidth;
        goto L7
    }

    void initPolar(int r10, int r11, MotionKeyPosition r12, MotionPaths r13, MotionPaths r14) {
        float r15 = r12.mFramePosition / 100.0f;
        this.time = r15;
        this.mDrawPath = r12.mDrawPath;
        this.mMode = r12.mPositionType;
        if (Float.isNaN(r12.mPercentWidth) == false) goto L5;
        float r16 = r15;
    L7:
        if (Float.isNaN(r12.mPercentHeight) == false) goto L9;
        float r17 = r15;
    L10:
        float r18 = r14.width;
        float r19 = r13.width;
        float r20 = r14.height;
        float r21 = r13.height;
        this.position = this.time;
        this.width = (int) (r19 + ((r18 - r19) * r16));
        this.height = (int) (r21 + ((r20 - r21) * r17));
        int r22 = r12.mPositionType;
        if (r22 == 1) goto L33;
        if (r22 == 2) goto L25;
        if (Float.isNaN(r12.mPercentX) == false) goto L17;
        float r23 = r15;
    L18:
        float r24 = r14.f236x;
        float r25 = r13.f236x;
        this.f236x = (r23 * (r24 - r25)) + r25;
        if (Float.isNaN(r12.mPercentY) == true) goto L22;
    L21:
        r15 = r12.mPercentY;
    L22:
        float r26 = r14.f237y;
        float r110 = r13.f237y;
        float r27 = (r15 * (r26 - r110)) + r110;
    L23:
        this.f237y = r27;
        this.mAnimateRelativeTo = r13.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r12.mTransitionEasing);
        this.mPathMotionArc = r12.mPathMotionArc;
        return;
    L17:
        r23 = r12.mPercentX;
        goto L18
    L25:
        if (Float.isNaN(r12.mPercentX) == false) goto L27;
        float r28 = r14.f236x;
        float r29 = r13.f236x;
        float r30 = ((r28 - r29) * r15) + r29;
    L28:
        this.f236x = r30;
        if (Float.isNaN(r12.mPercentY) == true) goto L22;
        r27 = r12.mPercentY;
        goto L23
    L27:
        r30 = Math.min(r17, r16) * r12.mPercentX;
        goto L28
    L33:
        if (Float.isNaN(r12.mPercentX) == false) goto L35;
        float r31 = r15;
    L36:
        float r32 = r14.f236x;
        float r33 = r13.f236x;
        this.f236x = (r31 * (r32 - r33)) + r33;
        if (Float.isNaN(r12.mPercentY) == false) goto L21;
    L35:
        r31 = r12.mPercentX;
        goto L36
    L9:
        r17 = r12.mPercentHeight;
        goto L10
    L5:
        r16 = r12.mPercentWidth;
        goto L7
    }

    void initScreen(int r18, int r19, MotionKeyPosition r20, MotionPaths r21, MotionPaths r22) {
        float r10 = r20.mFramePosition / 100.0f;
        this.time = r10;
        this.mDrawPath = r20.mDrawPath;
        if (Float.isNaN(r20.mPercentWidth) == false) goto L5;
        float r11 = r10;
    L7:
        if (Float.isNaN(r20.mPercentHeight) == false) goto L9;
        float r12 = r10;
    L10:
        float r13 = r22.width;
        float r14 = r21.width;
        float r15 = r22.height;
        float r16 = r21.height;
        this.position = this.time;
        float r17 = r21.f236x;
        float r23 = r21.f237y;
        float r24 = r22.f236x + (r13 / 2.0f);
        float r25 = r22.f237y + (r15 / 2.0f);
        float r26 = (r13 - r14) * r11;
        this.f236x = (int) ((r17 + ((r24 - ((r14 / 2.0f) + r17)) * r10)) - (r26 / 2.0f));
        float r110 = (r15 - r16) * r12;
        this.f237y = (int) ((r23 + ((r25 - (r23 + (r16 / 2.0f))) * r10)) - (r110 / 2.0f));
        this.width = (int) (r14 + r26);
        this.height = (int) (r16 + r110);
        this.mMode = 2;
        if (Float.isNaN(r20.mPercentX) == true) goto L14;
        this.f236x = (int) (r20.mPercentX * ((int) (r18 - this.width)));
    L14:
        if (Float.isNaN(r20.mPercentY) == true) goto L16;
        this.f237y = (int) (r20.mPercentY * ((int) (r19 - this.height)));
    L16:
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(r20.mTransitionEasing);
        this.mPathMotionArc = r20.mPathMotionArc;
        return;
    L9:
        r12 = r20.mPercentHeight;
        goto L10
    L5:
        r11 = r20.mPercentWidth;
        goto L7
    }

    void setBounds(float r10, float r11, float r12, float r13) {
        this.f236x = r10;
        this.f237y = r11;
        this.width = r12;
        this.height = r13;
    }

    void setDpDt(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        int r10 = 0;
        float r11 = 0.0f;
        float r12 = 0.0f;
        float r19 = 0.0f;
        float r20 = 0.0f;
    L4:
        if (r10 >= r16.length) goto L19;
        float r21 = (float) r17[r10];
        double r110 = r18[r10];
        int r111 = r16[r10];
        if (r111 != 1) goto L8;
        r11 = r21;
    L18:
        r10 = r10 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r19 = r21;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r12 = r21;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r20 = r21;
        goto L18
    L19:
        float r22 = r11 - ((0.0f * r12) / 2.0f);
        float r23 = r19 - ((0.0f * r20) / 2.0f);
        r15[0] = ((r22 * (1.0f - r13)) + (((r12 * 1.0f) + r22) * r13)) + 0.0f;
        r15[1] = ((r23 * (1.0f - r14)) + (((r20 * 1.0f) + r23) * r14)) + 0.0f;
    }

    void setView(float r21, MotionWidget r22, int[] r23, double[] r24, double[] r25, double[] r26) {
        float r10 = this.f236x;
        float r11 = this.f237y;
        float r12 = this.width;
        float r13 = this.height;
        if (r23.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r14 = 0;
    L9:
        if (r14 >= r23.length) goto L11;
        this.mTempValue[r23[r14]] = r24[r14];
        this.mTempDelta[r23[r14]] = r25[r14];
        r14 = r14 + 1;
        goto L9
    L11:
        float r15 = Float.NaN;
        int r16 = 0;
        float r17 = 0.0f;
        float r18 = 0.0f;
        float r19 = 0.0f;
        float r110 = 0.0f;
    L12:
        double[] r20 = this.mTempValue;
        if (r16 >= r20.length) goto L43;
        double r111 = 0.0d;
        if (Double.isNaN(r20[r16]) == false) goto L20;
        if (r26 != null) goto L18;
    L19:
        float r27 = r15;
    L36:
        r15 = r27;
    L42:
        r16 = r16 + 1;
        goto L12
    L18:
        if (r26[r16] == 0.0d) goto L19;
    L20:
        if (r26 == null) goto L23;
        r111 = r26[r16];
    L23:
        if (Double.isNaN(this.mTempValue[r16]) == true) goto L26;
        r111 = this.mTempValue[r16] + r111;
    L26:
        r27 = r15;
        float r28 = (float) r111;
        float r29 = (float) this.mTempDelta[r16];
        if (r16 != 1) goto L29;
        r15 = r27;
        r10 = r28;
        r17 = r29;
        goto L42
    L29:
        if (r16 != 2) goto L31;
        r15 = r27;
        r11 = r28;
        r18 = r29;
        goto L42
    L31:
        if (r16 != 3) goto L33;
        r15 = r27;
        r12 = r28;
        r19 = r29;
        goto L42
    L33:
        if (r16 != 4) goto L35;
        r15 = r27;
        r13 = r28;
        r110 = r29;
        goto L42
    L35:
        if (r16 != 5) goto L36;
        r15 = r28;
        goto L42
    L43:
        float r210 = r15;
        Motion r30 = this.mRelativeToController;
        if (r30 == null) goto L52;
        float[] r31 = new float[2];
        float[] r112 = new float[2];
        r30.getCenter(r21, r31, r112);
        float r113 = r31[0];
        float r32 = r31[1];
        float r114 = r112[0];
        float r33 = r112[1];
        double r34 = r10;
        double r35 = r11;
        float r36 = (float) ((((double) r113) + (Math.sin(r35) * r34)) - ((double) (r12 / 2.0f)));
        float r115 = r13;
        float r37 = (float) ((((double) r32) - (Math.cos(r35) * r34)) - ((double) (r13 / 2.0f)));
        double r116 = r17;
        double r117 = r18;
        float r38 = (float) ((((double) r114) + (Math.sin(r35) * r116)) + ((Math.cos(r35) * r34) * r117));
        float r39 = (float) ((((double) r33) - (r116 * Math.cos(r35))) + ((r34 * Math.sin(r35)) * r117));
        if (r25.length < 2) goto L49;
        r25[0] = r38;
        r25[1] = r39;
    L49:
        if (Float.isNaN(r210) == true) goto L51;
        r22.setRotationZ((float) (((double) r210) + Math.toDegrees(Math.atan2(r39, r38))));
    L51:
        r10 = r36;
        r11 = r37;
    L55:
        float r40 = r10 + 0.5f;
        float r41 = r11 + 0.5f;
        r22.layout((int) r40, (int) r41, (int) (r40 + r12), (int) (r41 + r115));
        return;
    L52:
        r115 = r13;
        if (Float.isNaN(r210) == true) goto L55;
        r22.setRotationZ((float) (((double) 0.0f) + (((double) r210) + Math.toDegrees(Math.atan2(r18 + (r110 / 2.0f), r17 + (r19 / 2.0f))))));
        goto L55
    L5:
        if (this.mTempValue.length > r23[r23.length - 1]) goto L7;
        int r42 = r23[r23.length - 1] + 1;
        this.mTempValue = new double[r42];
        this.mTempDelta = new double[r42];
        goto L7
    }

    public void setupRelative(Motion r10, MotionPaths r11) {
        double r12 = ((this.f236x + (this.width / 2.0f)) - r11.f236x) - (r11.width / 2.0f);
        double r13 = ((this.f237y + (this.height / 2.0f)) - r11.f237y) - (r11.height / 2.0f);
        this.mRelativeToController = r10;
        this.f236x = (float) Math.hypot(r13, r12);
        if (Float.isNaN(this.mRelativeAngle) == false) goto L5;
        double r14 = Math.atan2(r13, r12) + 1.5707963267948966d;
    L6:
        this.f237y = (float) r14;
        return;
    L5:
        r14 = Math.toRadians(this.mRelativeAngle);
        goto L6
    }
}
