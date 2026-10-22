package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 2;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 3;
    public static final String TAG = "MotionPaths";
    static String[] names;
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    float f435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    float f436y;

    static {
        names = new String[]{"position", "x", "y", "width", "height", "pathRotate"};
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float r5, float r10) {
        if (Float.isNaN(r5) == true) goto L12;
        if (Float.isNaN(r10) == true) goto L12;
        if (Math.abs(r5 - r10) > 1.0E-6f) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (Float.isNaN(r5) != Float.isNaN(r10)) goto L14;
        return false;
    L14:
        return true;
    }

    private static final float xRotate(float r5, float r10, float r11, float r12, float r13, float r14) {
        return (((r13 - r11) * r10) - ((r14 - r12) * r5)) + r11;
    }

    private static final float yRotate(float r5, float r10, float r11, float r12, float r13, float r14) {
        float r15 = (r14 - r12) * r10;
        return (r15 + ((r13 - r11) * r5)) + r12;
    }

    public void applyParameters(ConstraintSet.Constraint r10) {
        this.mKeyFrameEasing = Easing.getInterpolator(r10.motion.mTransitionEasing);
        ConstraintSet.Motion r5 = r10.motion;
        this.mPathMotionArc = r5.mPathMotionArc;
        this.mPathRotate = r5.mPathRotate;
        this.mDrawPath = r5.mDrawPath;
        this.mProgress = r10.propertySet.mProgress;
        Iterator<String> r11 = r10.mCustomConstraints.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        String r12 = r11.next();
        ConstraintAttribute r13 = r10.mCustomConstraints.get(r12);
        if (r13.getType() == ConstraintAttribute.AttributeType.STRING_TYPE) goto L4;
        this.attributes.put(r12, r13);
        goto L4
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull MotionPaths r5) {
        return compareTo2(r5);
    }

    public void different(MotionPaths r5, boolean[] r10, String[] r11, boolean r12) {
        r10[0] = r10[0] | diff(this.position, r5.position);
        r10[1] = r10[1] | (diff(this.f435x, r5.f435x) | r12);
        boolean r13 = r10[2];
        r10[2] = (r12 | diff(this.f436y, r5.f436y)) | r13;
        r10[3] = r10[3] | diff(this.width, r5.width);
        boolean r14 = r10[4];
        r10[4] = diff(this.height, r5.height) | r14;
    }

    public void fillStandard(double[] r10, int[] r11) {
        int r12 = 0;
        float[] r13 = {this.position, this.f435x, this.f436y, this.width, this.height, this.mPathRotate};
        int r14 = 0;
    L4:
        if (r12 >= r11.length) goto L9;
        int r5 = r11[r12];
        if (r5 >= 6) goto L8;
        r10[r14] = r13[r5];
        r14 = r14 + 1;
    L8:
        r12 = r12 + 1;
        goto L4
    }

    public void getBounds(int[] r10, double[] r11, float[] r12, int r13) {
        float r5 = this.width;
        float r14 = this.height;
        int r15 = 0;
    L4:
        if (r15 >= r10.length) goto L13;
        float r16 = (float) r11[r15];
        int r17 = r10[r15];
        if (r17 != 3) goto L8;
        r5 = r16;
    L12:
        r15 = r15 + 1;
        goto L4
    L8:
        if (r17 != 4) goto L12;
        r14 = r16;
        goto L12
    L13:
        r12[r13] = r5;
        r12[r13 + 1] = r14;
    }

    public void getCenter(int[] r10, double[] r11, float[] r12, int r13) {
        float r5 = this.f435x;
        float r14 = this.f436y;
        float r15 = this.width;
        float r16 = this.height;
        int r17 = 0;
    L4:
        if (r17 >= r10.length) goto L19;
        float r18 = (float) r11[r17];
        int r19 = r10[r17];
        if (r19 != 1) goto L8;
        r5 = r18;
    L18:
        r17 = r17 + 1;
        goto L4
    L8:
        if (r19 != 2) goto L10;
        r14 = r18;
        goto L18
    L10:
        if (r19 != 3) goto L12;
        r15 = r18;
        goto L18
    L12:
        if (r19 != 4) goto L18;
        r16 = r18;
        goto L18
    L19:
        r12[r13] = ((r15 / 2.0f) + r5) + 0.0f;
        r12[r13 + 1] = ((r16 / 2.0f) + r14) + 0.0f;
    }

    public int getCustomData(String r5, double[] r10, int r11) {
        ConstraintAttribute r12 = this.attributes.get(r5);
        if (r12.noOfInterpValues() != 1) goto L6;
        r10[r11] = r12.getValueToInterpolate();
        return 1;
    L6:
        int r13 = r12.noOfInterpValues();
        float[] r14 = new float[r13];
        r12.getValuesToInterpolate(r14);
        int r15 = 0;
    L7:
        if (r15 >= r13) goto L9;
        r10[r11] = r14[r15];
        r15 = r15 + 1;
        r11 = r11 + 1;
        goto L7
    L9:
        return r13;
    }

    public int getCustomDataCount(String r5) {
        return this.attributes.get(r5).noOfInterpValues();
    }

    public void getRect(int[] r10, double[] r11, float[] r12, int r13) {
        float r5 = this.f435x;
        float r14 = this.f436y;
        float r15 = this.width;
        float r16 = this.height;
        int r17 = 0;
    L4:
        if (r17 >= r10.length) goto L19;
        float r18 = (float) r11[r17];
        int r19 = r10[r17];
        if (r19 != 1) goto L8;
        r5 = r18;
    L18:
        r17 = r17 + 1;
        goto L4
    L8:
        if (r19 != 2) goto L10;
        r14 = r18;
        goto L18
    L10:
        if (r19 != 3) goto L12;
        r15 = r18;
        goto L18
    L12:
        if (r19 != 4) goto L18;
        r16 = r18;
        goto L18
    L19:
        float r20 = r15 + r5;
        float r21 = r16 + r14;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        float r22 = r5 + 0.0f;
        float r23 = r14 + 0.0f;
        float r24 = r20 + 0.0f;
        float r25 = r21 + 0.0f;
        r12[r13] = r22;
        r12[r13 + 1] = r23;
        int r26 = r13 + 3;
        r12[r13 + 2] = r24;
        int r27 = r13 + 4;
        r12[r26] = r14 + 0.0f;
        r12[r27] = r20 + 0.0f;
        int r28 = r13 + 6;
        r12[r13 + 5] = r25;
        int r110 = r13 + 7;
        r12[r28] = r5 + 0.0f;
        r12[r110] = r21 + 0.0f;
    }

    public boolean hasCustomData(String r5) {
        return this.attributes.containsKey(r5);
    }

    public void initCartesian(KeyPosition r18, MotionPaths r19, MotionPaths r20) {
        float r5 = r18.mFramePosition / 100.0f;
        this.time = r5;
        this.mDrawPath = r18.mDrawPath;
        if (Float.isNaN(r18.mPercentWidth) == false) goto L5;
        float r10 = r5;
    L7:
        if (Float.isNaN(r18.mPercentHeight) == false) goto L9;
        float r11 = r5;
    L10:
        float r12 = r20.width;
        float r13 = r19.width;
        float r14 = r12 - r13;
        float r15 = r20.height;
        float r16 = r19.height;
        float r17 = r15 - r16;
        this.position = this.time;
        float r110 = r19.f435x;
        float r21 = r19.f436y;
        float r22 = (r12 / 2.0f) + r20.f435x;
        float r23 = r22 - ((r13 / 2.0f) + r110);
        float r111 = ((r15 / 2.0f) + r20.f436y) - ((r16 / 2.0f) + r21);
        float r24 = r14 * r10;
        float r25 = r24 / 2.0f;
        this.f435x = (int) (((r23 * r5) + r110) - r25);
        float r26 = (r111 * r5) + r21;
        float r112 = r17 * r11;
        float r27 = r112 / 2.0f;
        this.f436y = (int) (r26 - r27);
        this.width = (int) (r13 + r24);
        this.height = (int) (r16 + r112);
        if (Float.isNaN(r18.mPercentX) == false) goto L13;
        float r28 = r5;
    L14:
        float r29 = 0.0f;
        if (Float.isNaN(r18.mAltPercentY) == false) goto L17;
        float r30 = 0.0f;
    L19:
        if (Float.isNaN(r18.mPercentY) == true) goto L23;
        r5 = r18.mPercentY;
    L23:
        if (Float.isNaN(r18.mAltPercentX) == true) goto L26;
        r29 = r18.mAltPercentX;
    L26:
        this.mMode = 2;
        float r31 = r29 * r111;
        this.f435x = (int) ((r31 + ((r28 * r23) + r19.f435x)) - r25);
        float r113 = r111 * r5;
        this.f436y = (int) ((r113 + ((r23 * r30) + r19.f436y)) - r27);
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
        r11 = r18.mPercentHeight;
        goto L10
    L5:
        r10 = r18.mPercentWidth;
        goto L7
    }

    public void initPath(KeyPosition r17, MotionPaths r18, MotionPaths r19) {
        float r5 = r17.mFramePosition / 100.0f;
        this.time = r5;
        this.mDrawPath = r17.mDrawPath;
        if (Float.isNaN(r17.mPercentWidth) == false) goto L5;
        float r10 = r5;
    L7:
        if (Float.isNaN(r17.mPercentHeight) == false) goto L9;
        float r11 = r5;
    L10:
        float r12 = r19.width - r18.width;
        float r13 = r19.height - r18.height;
        this.position = this.time;
        if (Float.isNaN(r17.mPercentX) == true) goto L14;
        r5 = r17.mPercentX;
    L14:
        float r14 = r18.f435x;
        float r15 = r18.width;
        float r16 = r18.f436y;
        float r110 = r18.height;
        float r20 = (r19.width / 2.0f) + r19.f435x;
        float r21 = r20 - ((r15 / 2.0f) + r14);
        float r22 = ((r19.height / 2.0f) + r19.f436y) - ((r110 / 2.0f) + r16);
        float r23 = r21 * r5;
        float r24 = r12 * r10;
        float r25 = r24 / 2.0f;
        this.f435x = (int) ((r14 + r23) - r25);
        float r26 = r5 * r22;
        float r27 = r13 * r11;
        float r28 = r27 / 2.0f;
        this.f436y = (int) ((r16 + r26) - r28);
        this.width = (int) (r15 + r24);
        this.height = (int) (r110 + r27);
        if (Float.isNaN(r17.mPercentY) == false) goto L17;
        float r29 = 0.0f;
    L18:
        this.mMode = 1;
        float r30 = (int) ((r18.f435x + r23) - r25);
        float r31 = (int) ((r18.f436y + r26) - r28);
        this.f435x = r30 + ((-r22) * r29);
        this.f436y = r31 + (r21 * r29);
        this.mKeyFrameEasing = Easing.getInterpolator(r17.mTransitionEasing);
        this.mPathMotionArc = r17.mPathMotionArc;
        return;
    L17:
        r29 = r17.mPercentY;
        goto L18
    L9:
        r11 = r17.mPercentHeight;
        goto L10
    L5:
        r10 = r17.mPercentWidth;
        goto L7
    }

    public void initScreen(int r18, int r19, KeyPosition r20, MotionPaths r21, MotionPaths r22) {
        float r5 = r20.mFramePosition / 100.0f;
        this.time = r5;
        this.mDrawPath = r20.mDrawPath;
        if (Float.isNaN(r20.mPercentWidth) == false) goto L5;
        float r10 = r5;
    L7:
        if (Float.isNaN(r20.mPercentHeight) == false) goto L9;
        float r11 = r5;
    L10:
        float r12 = r22.width;
        float r13 = r21.width;
        float r14 = r12 - r13;
        float r15 = r22.height;
        float r16 = r21.height;
        float r17 = r15 - r16;
        this.position = this.time;
        float r110 = r21.f435x;
        float r23 = r21.f436y;
        float r24 = (r12 / 2.0f) + r22.f435x;
        float r111 = (r15 / 2.0f) + r22.f436y;
        float r25 = r14 * r10;
        this.f435x = (int) ((((r24 - ((r13 / 2.0f) + r110)) * r5) + r110) - (r25 / 2.0f));
        float r112 = r17 * r11;
        this.f436y = (int) ((((r111 - ((r16 / 2.0f) + r23)) * r5) + r23) - (r112 / 2.0f));
        this.width = (int) (r13 + r25);
        this.height = (int) (r16 + r112);
        this.mMode = 3;
        if (Float.isNaN(r20.mPercentX) == true) goto L14;
        this.f435x = (int) (r20.mPercentX * ((int) (r18 - this.width)));
    L14:
        if (Float.isNaN(r20.mPercentY) == true) goto L16;
        this.f436y = (int) (r20.mPercentY * ((int) (r19 - this.height)));
    L16:
        this.mKeyFrameEasing = Easing.getInterpolator(r20.mTransitionEasing);
        this.mPathMotionArc = r20.mPathMotionArc;
        return;
    L9:
        r11 = r20.mPercentHeight;
        goto L10
    L5:
        r10 = r20.mPercentWidth;
        goto L7
    }

    public void setBounds(float r5, float r10, float r11, float r12) {
        this.f435x = r5;
        this.f436y = r10;
        this.width = r11;
        this.height = r12;
    }

    public void setDpDt(float r13, float r14, float[] r15, int[] r16, double[] r17, double[] r18) {
        float r5 = 0.0f;
        float r10 = 0.0f;
        float r11 = 0.0f;
        float r12 = 0.0f;
        int r19 = 0;
    L4:
        if (r19 >= r16.length) goto L19;
        float r20 = (float) r17[r19];
        double r110 = r18[r19];
        int r111 = r16[r19];
        if (r111 != 1) goto L8;
        r5 = r20;
    L18:
        r19 = r19 + 1;
        goto L4
    L8:
        if (r111 != 2) goto L10;
        r11 = r20;
        goto L18
    L10:
        if (r111 != 3) goto L12;
        r10 = r20;
        goto L18
    L12:
        if (r111 != 4) goto L18;
        r12 = r20;
        goto L18
    L19:
        float r21 = r5 - ((0.0f * r10) / 2.0f);
        float r22 = r11 - ((0.0f * r12) / 2.0f);
        r15[0] = ((((r10 * 1.0f) + r21) * r13) + ((1.0f - r13) * r21)) + 0.0f;
        r15[1] = ((((r12 * 1.0f) + r22) * r14) + ((1.0f - r14) * r22)) + 0.0f;
    }

    public void setView(View r20, int[] r21, double[] r22, double[] r23, double[] r24) {
        float r5 = this.f435x;
        float r10 = this.f436y;
        float r11 = this.width;
        float r12 = this.height;
        if (r21.length != 0) goto L5;
    L7:
        Arrays.fill(this.mTempValue, Double.NaN);
        int r13 = 0;
        int r14 = 0;
    L9:
        if (r14 >= r21.length) goto L11;
        double[] r15 = this.mTempValue;
        int r16 = r21[r14];
        r15[r16] = r22[r14];
        this.mTempDelta[r16] = r23[r14];
        r14 = r14 + 1;
        goto L9
    L11:
        float r17 = Float.NaN;
        float r18 = 0.0f;
        float r19 = 0.0f;
        float r110 = 0.0f;
        float r111 = 0.0f;
    L12:
        double[] r112 = this.mTempValue;
        if (r13 >= r112.length) goto L43;
        boolean r25 = Double.isNaN(r112[r13]);
        double r113 = 0.0d;
        if (r25 == false) goto L20;
        if (r24 != null) goto L18;
    L19:
        float r26 = r17;
    L36:
        r17 = r26;
    L42:
        r13 = r13 + 1;
        goto L12
    L18:
        if (r24[r13] == 0.0d) goto L19;
    L20:
        if (r24 == null) goto L23;
        r113 = r24[r13];
    L23:
        if (Double.isNaN(this.mTempValue[r13]) == false) goto L25;
    L24:
        r26 = r17;
        float r27 = (float) r113;
        float r28 = (float) this.mTempDelta[r13];
        if (r13 != 1) goto L29;
        r17 = r26;
        r5 = r27;
        r18 = r28;
        goto L42
    L29:
        if (r13 != 2) goto L31;
        r17 = r26;
        r10 = r27;
        r110 = r28;
        goto L42
    L31:
        if (r13 != 3) goto L33;
        r17 = r26;
        r11 = r27;
        r19 = r28;
        goto L42
    L33:
        if (r13 != 4) goto L35;
        r17 = r26;
        r12 = r27;
        r111 = r28;
        goto L42
    L35:
        if (r13 != 5) goto L36;
        r17 = r27;
        goto L42
    L25:
        r113 = this.mTempValue[r13] + r113;
        goto L24
    L43:
        float r29 = r17;
        if (Float.isNaN(r29) == false) goto L49;
        if (Float.isNaN(Float.NaN) == true) goto L53;
        r20.setRotation(Float.NaN);
    L53:
        float r30 = r5 + 0.5f;
        int r31 = (int) r30;
        float r32 = r10 + 0.5f;
        int r33 = (int) r32;
        int r34 = (int) (r30 + r11);
        int r35 = (int) (r32 + r12);
        int r36 = r34 - r31;
        int r37 = r35 - r33;
        if (r36 == r20.getMeasuredWidth()) goto L56;
    L57:
        r20.measure(View.MeasureSpec.makeMeasureSpec(r36, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r37, BasicMeasure.EXACTLY));
    L58:
        r20.layout(r31, r33, r34, r35);
        return;
    L56:
        if (r37 == r20.getMeasuredHeight()) goto L58;
    L49:
        if (Float.isNaN(Float.NaN) == false) goto L51;
        float r38 = 0.0f;
    L52:
        r20.setRotation((float) ((Math.toDegrees(Math.atan2((r111 / 2.0f) + r110, (r19 / 2.0f) + r18)) + ((double) r29)) + ((double) r38)));
        goto L53
    L51:
        r38 = Float.NaN;
        goto L52
    L5:
        if (this.mTempValue.length > r21[r21.length - 1]) goto L7;
        int r39 = r21[r21.length - 1] + 1;
        this.mTempValue = new double[r39];
        this.mTempDelta = new double[r39];
        goto L7
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull MotionPaths r5) {
        return Float.compare(this.position, r5.position);
    }

    public MotionPaths(int r5, int r10, KeyPosition r11, MotionPaths r12, MotionPaths r13) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.attributes = new LinkedHashMap();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        int r14 = r11.mPositionType;
        if (r14 != 1) goto L5;
        initPath(r11, r12, r13);
        return;
    L5:
        if (r14 == 2) goto L8;
        initCartesian(r11, r12, r13);
        return;
    L8:
        initScreen(r5, r10, r11, r12, r13);
    }
}
