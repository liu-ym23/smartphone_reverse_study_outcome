package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<MotionKey> mKeyList;
    private MotionKeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private DifferentialInterpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private MotionWidget mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    MotionWidget mView;

    public Motion(MotionWidget r4) {
        this.mTempRect = new Rect();
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mStaggerOffset = 0.0f;
        this.mStaggerScale = 1.0f;
        this.MAX_DIMENSION = 4;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        this.mPathMotionArc = -1;
        this.mTransformPivotTarget = -1;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = -1;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(r4);
    }

    private float getAdjustedPosition(float r12, float[] r13) {
        float r0 = 0.0f;
        float r2 = 1.0f;
        if (r13 == null) goto L5;
        r13[0] = 1.0f;
    L15:
        Easing r3 = this.mStartMotionPath.mKeyFrameEasing;
        float r4 = Float.NaN;
        Iterator<MotionPaths> r11 = this.mMotionPaths.iterator();
    L17:
        if (r11.hasNext() == false) goto L26;
        MotionPaths r5 = (MotionPaths) ZeusTransformUtils.preCheckCast(r11.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        if (r5.mKeyFrameEasing == null) goto L17;
        if (r5.time < r12) goto L22;
        if (Float.isNaN(r4) == false) goto L17;
        r4 = r5.time;
        goto L17
    L22:
        r3 = r5.mKeyFrameEasing;
        r0 = r5.time;
        goto L17
    L26:
        if (r3 != null) goto L28;
        return r12;
    L28:
        if (Float.isNaN(r4) == true) goto L31;
        r2 = r4;
    L31:
        float r6 = r2 - r0;
        double r14 = (r12 - r0) / r6;
        float r1 = r0 + (((float) r3.get(r14)) * r6);
        if (r13 == null) goto L35;
        r13[0] = (float) r3.getDiff(r14);
    L35:
        return r1;
    L5:
        float r7 = this.mStaggerScale;
        if (r7 == 1.0d) goto L15;
        float r8 = this.mStaggerOffset;
        if (r12 >= r8) goto L11;
        r12 = 0.0f;
    L11:
        if (r12 <= r8) goto L15;
        if (r12 >= 1.0d) goto L15;
        r12 = Math.min((r12 - r8) * r7, 1.0f);
        goto L15
    }

    private static DifferentialInterpolator getInterpolator(int r0, String r1, int r2) {
        if (r0 == (-1)) goto L6;
        return null;
    L6:
        final Easing r3 = Easing.getInterpolator(r1);
        return new AnonymousClass1(r3);
    }

    private float getPreCycleDistance() {
        float[] r1 = new float[2];
        float r10 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        float r7 = 0.0f;
        int r8 = 0;
    L4:
        if (r8 >= 100) goto L28;
        float r2 = r8 * r10;
        double r3 = r2;
        Easing r5 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r6 = this.mMotionPaths.iterator();
        float r17 = Float.NaN;
        float r18 = 0.0f;
    L7:
        if (r6.hasNext() == false) goto L17;
        MotionPaths r9 = (MotionPaths) ZeusTransformUtils.preCheckCast(r6.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        if (r9.mKeyFrameEasing == null) goto L7;
        if (r9.time >= r2) goto L14;
        r5 = r9.mKeyFrameEasing;
        r18 = r9.time;
        goto L7
    L14:
        if (Float.isNaN(r17) == false) goto L7;
        r17 = r9.time;
        goto L7
    L17:
        if (r5 != null) goto L19;
    L22:
        this.mSpline[0].getPos(r3, this.mInterpolateData);
        float r11 = r7;
        int r12 = r8;
        this.mStartMotionPath.getCenter(r3, this.mInterpolateVariables, this.mInterpolateData, r1, 0);
        if (r12 <= 0) goto L25;
        char r14 = 0;
        float r4 = (float) (((double) r11) + Math.hypot(r15 - ((double) r1[1]), r13 - ((double) r1[0])));
    L26:
        r13 = r1[r14];
        r8 = r12 + 1;
        r7 = r4;
        r15 = r1[1];
        goto L4
    L25:
        r14 = 0;
        r4 = r11;
        goto L26
    L19:
        if (Float.isNaN(r17) == false) goto L21;
        r17 = 1.0f;
    L21:
        float r19 = r17 - r18;
        r3 = (((float) r5.get((r2 - r18) / r19)) * r19) + r18;
        goto L22
    L28:
        return r7;
    }

    private void insertKey(MotionPaths r6) {
        Iterator<MotionPaths> r0 = this.mMotionPaths.iterator();
        MotionPaths r1 = null;
    L4:
        if (r0.hasNext() == false) goto L8;
        MotionPaths r2 = (MotionPaths) ZeusTransformUtils.preCheckCast(r0.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        if (r6.position != r2.position) goto L4;
        r1 = r2;
        goto L4
    L8:
        if (r1 == null) goto L10;
        this.mMotionPaths.remove(r1);
    L10:
        int r3 = Collections.binarySearch(this.mMotionPaths, r6);
        if (r3 != 0) goto L13;
        Utils.loge(TAG, " KeyPath position \"" + r6.position + "\" outside of range");
    L13:
        this.mMotionPaths.add((-r3) - 1, r6);
    }

    private void readView(MotionPaths r4) {
        r4.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey r1) {
        this.mKeyList.add(r1);
    }

    void addKeys(ArrayList<MotionKey> r1) {
        this.mKeyList.addAll(r1);
    }

    void buildBounds(float[] r18, int r19) {
        float r2 = 1.0f / (r19 - 1);
        HashMap<String, SplineSet> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        SplineSet r5 = (SplineSet) ZeusTransformUtils.preCheckCast(r4.get("translationX"), SplineSet.class, "com.obric.memorydata.plugin");
    L6:
        HashMap<String, SplineSet> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        SplineSet r7 = (SplineSet) ZeusTransformUtils.preCheckCast(r6.get("translationY"), SplineSet.class, "com.obric.memorydata.plugin");
    L10:
        HashMap<String, KeyCycleOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        KeyCycleOscillator r9 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r8.get("translationX"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
    L14:
        HashMap<String, KeyCycleOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        KeyCycleOscillator r11 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r10.get("translationY"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
    L18:
        int r12 = 0;
    L19:
        if (r12 >= r19) goto L52;
        float r13 = r12 * r2;
        float r14 = this.mStaggerScale;
        float r15 = 0.0f;
        if (r14 == 1.0f) goto L30;
        float r16 = this.mStaggerOffset;
        if (r13 >= r16) goto L26;
        r13 = 0.0f;
    L26:
        if (r13 <= r16) goto L30;
        if (r13 >= 1.0d) goto L30;
        r13 = Math.min((r13 - r16) * r14, 1.0f);
    L30:
        double r17 = r13;
        Easing r110 = this.mStartMotionPath.mKeyFrameEasing;
        float r111 = Float.NaN;
        Iterator<MotionPaths> r112 = this.mMotionPaths.iterator();
    L32:
        if (r112.hasNext() == false) goto L41;
        MotionPaths r113 = (MotionPaths) ZeusTransformUtils.preCheckCast(r112.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        if (r113.mKeyFrameEasing == null) goto L32;
        if (r113.time < r13) goto L37;
        if (Float.isNaN(r111) == false) goto L32;
        r111 = r113.time;
        goto L32
    L37:
        r110 = r113.mKeyFrameEasing;
        r15 = r113.time;
        goto L32
    L41:
        if (r110 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L51;
        double[] r114 = this.mInterpolateData;
        if (r114.length <= 0) goto L51;
        r20.getPos(r17, r114);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r18, r12 * 2);
        r12 = r12 + 1;
        goto L19
    L43:
        if (Float.isNaN(r111) == false) goto L45;
        r111 = 1.0f;
    L45:
        float r115 = r111 - r15;
        r17 = (((float) r110.get((r13 - r15) / r115)) * r115) + r15;
        goto L46
    }

    int buildKeyBounds(float[] r8, int[] r9) {
        if (r8 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r9 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r9[r3] = ((MotionPaths) ZeusTransformUtils.preCheckCast(r2.next(), MotionPaths.class, "com.obric.memorydata.plugin")).mMode;
        r3 = r3 + 1;
    L10:
        int r10 = 0;
        int r4 = 0;
    L12:
        if (r10 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r10], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r8, r4);
        r4 = r4 + 2;
        r10 = r10 + 1;
        goto L12
    L15:
        return r4 / 2;
    L16:
        return 0;
    }

    public int buildKeyFrames(float[] r10, int[] r11, int[] r12) {
        if (r10 == null) goto L21;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r3 = this.mMotionPaths.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L10;
        r11[r4] = ((MotionPaths) ZeusTransformUtils.preCheckCast(r3.next(), MotionPaths.class, "com.obric.memorydata.plugin")).mMode;
        r4 = r4 + 1;
    L10:
        if (r12 == null) goto L15;
        Iterator<MotionPaths> r13 = this.mMotionPaths.iterator();
        int r5 = 0;
    L13:
        if (r13.hasNext() == false) goto L15;
        r12[r5] = (int) (((MotionPaths) ZeusTransformUtils.preCheckCast(r13.next(), MotionPaths.class, "com.obric.memorydata.plugin")).position * 100.0f);
        r5 = r5 + 1;
    L15:
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r14 >= r1.length) goto L20;
        this.mSpline[0].getPos(r1[r14], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r14], this.mInterpolateVariables, this.mInterpolateData, r10, r15);
        r15 = r15 + 2;
        r14 = r14 + 1;
        goto L17
    L20:
        return r15 / 2;
    L21:
        return 0;
    }

    public void buildPath(float[] r22, int r23) {
        Motion r0 = this;
        float r9 = 1.0f;
        float r10 = 1.0f / (r23 - 1);
        HashMap<String, SplineSet> r1 = r0.mAttributesMap;
        KeyCycleOscillator r3 = null;
        if (r1 != null) goto L5;
        SplineSet r12 = null;
    L6:
        HashMap<String, SplineSet> r2 = r0.mAttributesMap;
        if (r2 != null) goto L9;
        SplineSet r13 = null;
    L10:
        HashMap<String, KeyCycleOscillator> r4 = r0.mCycleMap;
        if (r4 != null) goto L13;
        KeyCycleOscillator r14 = null;
    L14:
        HashMap<String, KeyCycleOscillator> r5 = r0.mCycleMap;
        if (r5 == null) goto L18;
        r3 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r5.get("translationY"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
    L18:
        KeyCycleOscillator r15 = r3;
        int r7 = 0;
    L19:
        if (r7 >= r23) goto L64;
        float r6 = r7 * r10;
        float r8 = r0.mStaggerScale;
        if (r8 == r9) goto L30;
        float r11 = r0.mStaggerOffset;
        if (r6 >= r11) goto L26;
        r6 = 0.0f;
    L26:
        if (r6 <= r11) goto L30;
        if (r6 >= 1.0d) goto L30;
        r6 = Math.min((r6 - r11) * r8, r9);
    L30:
        float r16 = r6;
        double r17 = r16;
        Easing r18 = r0.mStartMotionPath.mKeyFrameEasing;
        float r19 = Float.NaN;
        Iterator<MotionPaths> r20 = r0.mMotionPaths.iterator();
        float r110 = 0.0f;
    L32:
        if (r20.hasNext() == false) goto L42;
        double r111 = r17;
        MotionPaths r21 = (MotionPaths) ZeusTransformUtils.preCheckCast(r20.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        if (r21.mKeyFrameEasing == null) goto L41;
        if (r21.time >= r16) goto L39;
        Easing r24 = r21.mKeyFrameEasing;
        r110 = r21.time;
        r18 = r24;
        goto L41
    L39:
        if (Float.isNaN(r19) == false) goto L41;
        r19 = r21.time;
    L41:
        r17 = r111;
        goto L32
    L42:
        double r112 = r17;
        if (r18 != null) goto L45;
        double r25 = r112;
    L49:
        r0.mSpline[0].getPos(r25, r0.mInterpolateData);
        CurveFit r26 = r0.mArcSpline;
        if (r26 == null) goto L54;
        double[] r27 = r0.mInterpolateData;
        if (r27.length <= 0) goto L54;
        r26.getPos(r25, r27);
    L54:
        int r28 = r7 * 2;
        int r113 = r7;
        r0.mStartMotionPath.getCenter(r25, r0.mInterpolateVariables, r0.mInterpolateData, r22, r28);
        if (r14 == null) goto L57;
        r22[r28] = r22[r28] + r14.get(r16);
    L59:
        if (r15 == null) goto L61;
        int r29 = r28 + 1;
        r22[r29] = r22[r29] + r15.get(r16);
    L63:
        r7 = r113 + 1;
        r9 = 1.0f;
        r0 = this;
        goto L19
    L61:
        if (r13 == null) goto L63;
        int r30 = r28 + 1;
        r22[r30] = r22[r30] + r13.get(r16);
        goto L63
    L57:
        if (r12 == null) goto L59;
        r22[r28] = r22[r28] + r12.get(r16);
        goto L59
    L45:
        if (Float.isNaN(r19) == false) goto L47;
        r19 = 1.0f;
    L47:
        float r31 = r19 - r110;
        r25 = (((float) r18.get((r16 - r110) / r31)) * r31) + r110;
        goto L49
    L64:
        return;
    L13:
        r14 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r4.get("translationX"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r13 = (SplineSet) ZeusTransformUtils.preCheckCast(r2.get("translationY"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r12 = (SplineSet) ZeusTransformUtils.preCheckCast(r1.get("translationX"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public void buildRect(float r4, float[] r5, int r6) {
        this.mSpline[0].getPos(getAdjustedPosition(r4, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r5, r6);
    }

    void buildRectangles(float[] r8, int r9) {
        float r1 = 1.0f / (r9 - 1);
        int r2 = 0;
    L3:
        if (r2 >= r9) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r2 * r1, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r8, r2 * 8);
        r2 = r2 + 1;
        goto L3
    }

    void endTrigger(boolean r1) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String r1, float[] r2, int r3) {
        SplineSet r0 = (SplineSet) ZeusTransformUtils.preCheckCast(this.mAttributesMap.get(r1), SplineSet.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return -1;
    L6:
        int r4 = 0;
    L8:
        if (r4 >= r2.length) goto L11;
        r2[r4] = r0.get(r4 / (r2.length - 1));
        r4 = r4 + 1;
        goto L8
    L11:
        return r2.length;
    }

    public void getCenter(double r10, float[] r12, float[] r13) {
        double[] r5 = new double[4];
        double[] r7 = new double[4];
        this.mSpline[0].getPos(r10, r5);
        this.mSpline[0].getSlope(r10, r7);
        Arrays.fill(r13, 0.0f);
        this.mStartMotionPath.getCenter(r10, this.mInterpolateVariables, r5, r12, r7, r13);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    void getDpDt(float r12, float r13, float r14, float[] r15) {
        float r16 = getAdjustedPosition(r12, this.mVelocity);
        CurveFit[] r0 = this.mSpline;
        int r1 = 0;
        if (r0 == null) goto L16;
        double r2 = r16;
        r0[0].getSlope(r2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r2, this.mInterpolateData);
        float r17 = this.mVelocity[0];
    L5:
        double[] r9 = this.mInterpolateVelocity;
        if (r1 >= r9.length) goto L8;
        r9[r1] = r9[r1] * ((double) r17);
        r1 = r1 + 1;
        goto L5
    L8:
        CurveFit r18 = this.mArcSpline;
        if (r18 == null) goto L14;
        double[] r3 = this.mInterpolateData;
        if (r3.length <= 0) goto L19;
        r18.getPos(r2, r3);
        this.mArcSpline.getSlope(r2, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, r9, this.mInterpolateData);
        return;
    L16:
        float r19 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r5 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r19;
        float r6 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r4;
        r15[0] = (r19 * (1.0f - r13)) + (r5 * r13);
        r15[1] = (r4 * (1.0f - r14)) + (r6 * r14);
    }

    public int getDrawPath() {
        int r0 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r1 = this.mMotionPaths.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0 = Math.max(r0, ((MotionPaths) ZeusTransformUtils.preCheckCast(r1.next(), MotionPaths.class, "com.obric.memorydata.plugin")).mDrawPath);
        goto L4
    L7:
        return Math.max(r0, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.y;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r1) {
        return 0;
    }

    public MotionPaths getKeyFrame(int r2) {
        return (MotionPaths) ZeusTransformUtils.preCheckCast(this.mMotionPaths.get(r2), MotionPaths.class, "com.obric.memorydata.plugin");
    }

    public int getKeyFrameInfo(int r19, int[] r20) {
        float[] r2 = new float[2];
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        MotionKey r15 = (MotionKey) ZeusTransformUtils.preCheckCast(r10.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (r15.mType == r19) goto L10;
        if (r19 == (-1)) goto L4;
    L10:
        r20[r13] = 0;
        int r3 = r13 + 1;
        r20[r3] = r15.mType;
        int r17 = r3 + 1;
        r20[r17] = r15.mFramePosition;
        double r5 = r15.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r5, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r5, this.mInterpolateVariables, this.mInterpolateData, r2, 0);
        int r18 = r17 + 1;
        r20[r18] = Float.floatToIntBits(r2[0]);
        int r110 = r18 + 1;
        r20[r110] = Float.floatToIntBits(r2[1]);
        if (ZeusTransformUtils.instanceOf(r15, MotionKeyPosition.class) == false) goto L13;
        MotionKeyPosition r4 = (MotionKeyPosition) ZeusTransformUtils.preCheckCast(r15, MotionKeyPosition.class, "com.obric.memorydata.plugin");
        int r111 = r110 + 1;
        r20[r111] = r4.mPositionType;
        int r112 = r111 + 1;
        r20[r112] = Float.floatToIntBits(r4.mPercentX);
        r110 = r112 + 1;
        r20[r110] = Float.floatToIntBits(r4.mPercentY);
    L13:
        int r113 = r110 + 1;
        r20[r13] = r113 - r13;
        r12 = r12 + 1;
        r13 = r113;
        goto L4
    L14:
        return r12;
    }

    float getKeyFrameParameter(int r9, float r10, float r11) {
        float r0 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r1 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float r2 = this.mStartMotionPath.x + (this.mStartMotionPath.width / 2.0f);
        float r3 = this.mStartMotionPath.y + (this.mStartMotionPath.height / 2.0f);
        float r8 = (float) Math.hypot(r0, r1);
        if (r8 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r12 = r10 - r2;
        float r13 = r11 - r3;
        if (((float) Math.hypot(r12, r13)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r4 = (r12 * r0) + (r13 * r1);
        if (r9 == 0) goto L33;
        if (r9 == 1) goto L31;
        if (r9 == 2) goto L29;
        if (r9 == 3) goto L27;
        if (r9 == 4) goto L25;
        if (r9 == 5) goto L23;
        return 0.0f;
    L23:
        return r13 / r1;
    L25:
        return r12 / r1;
    L27:
        return r13 / r0;
    L29:
        return r12 / r0;
    L31:
        return (float) Math.sqrt((r8 * r8) - (r4 * r4));
    L33:
        return r4 / r8;
    }

    public int getKeyFramePositions(int[] r13, float[] r14) {
        Iterator<MotionKey> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        MotionKey r3 = (MotionKey) ZeusTransformUtils.preCheckCast(r0.next(), MotionKey.class, "com.obric.memorydata.plugin");
        int r11 = r2 + 1;
        r13[r2] = r3.mFramePosition + (r3.mType * 1000);
        double r4 = r3.mFramePosition / 100.0f;
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r4, this.mInterpolateVariables, this.mInterpolateData, r14, r10);
        r10 = r10 + 2;
        r2 = r11;
        goto L4
    L6:
        return r2;
    }

    double[] getPos(double r4) {
        this.mSpline[0].getPos(r4, this.mInterpolateData);
        CurveFit r0 = this.mArcSpline;
        if (r0 == null) goto L8;
        double[] r1 = this.mInterpolateData;
        if (r1.length <= 0) goto L8;
        r0.getPos(r4, r1);
    L8:
        return this.mInterpolateData;
    }

    MotionKeyPosition getPositionKeyframe(int r12, int r13, float r14, float r15) {
        FloatRect r7 = new FloatRect();
        r7.left = this.mStartMotionPath.x;
        r7.top = this.mStartMotionPath.y;
        r7.right = r7.left + this.mStartMotionPath.width;
        r7.bottom = r7.top + this.mStartMotionPath.height;
        FloatRect r8 = new FloatRect();
        r8.left = this.mEndMotionPath.x;
        r8.top = this.mEndMotionPath.y;
        r8.right = r8.left + this.mEndMotionPath.width;
        r8.bottom = r8.top + this.mEndMotionPath.height;
        Iterator<MotionKey> r11 = this.mKeyList.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        MotionKey r10 = (MotionKey) ZeusTransformUtils.preCheckCast(r11.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, MotionKeyPosition.class) == false) goto L4;
        if (((MotionKeyPosition) ZeusTransformUtils.preCheckCast(r10, MotionKeyPosition.class, "com.obric.memorydata.plugin")).intersects(r12, r13, r7, r8, r14, r15) == false) goto L4;
        return (MotionKeyPosition) ZeusTransformUtils.preCheckCast(r10, MotionKeyPosition.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, SplineSet> r2 = this.mAttributesMap;
        KeyCycleOscillator r4 = null;
        if (r2 != null) goto L5;
        SplineSet r3 = null;
    L6:
        HashMap<String, SplineSet> r6 = this.mAttributesMap;
        if (r6 != null) goto L9;
        SplineSet r7 = null;
    L10:
        HashMap<String, SplineSet> r8 = this.mAttributesMap;
        if (r8 != null) goto L13;
        SplineSet r9 = null;
    L14:
        HashMap<String, SplineSet> r10 = this.mAttributesMap;
        if (r10 != null) goto L17;
        SplineSet r11 = null;
    L18:
        HashMap<String, SplineSet> r12 = this.mAttributesMap;
        if (r12 != null) goto L21;
        SplineSet r13 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r14 = this.mCycleMap;
        if (r14 != null) goto L25;
        KeyCycleOscillator r5 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        KeyCycleOscillator r16 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        KeyCycleOscillator r18 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        KeyCycleOscillator r111 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r112 = this.mCycleMap;
        if (r112 == null) goto L42;
        r4 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r112.get("scaleY"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
    L42:
        VelocityMatrix r113 = new VelocityMatrix();
        r113.clear();
        r113.setRotationVelocity(r9, r1);
        r113.setTranslationVelocity(r3, r7, r1);
        r113.setScaleVelocity(r11, r13, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r5, r16, r1);
        r113.setScaleVelocity(r111, r4, r1);
        CurveFit r25 = this.mArcSpline;
        if (r25 == null) goto L49;
        double[] r26 = this.mInterpolateData;
        if (r26.length <= 0) goto L47;
        double r27 = r1;
        r25.getPos(r27, r26);
        this.mArcSpline.getSlope(r27, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L49:
        int r114 = 0;
        if (this.mSpline == null) goto L57;
        double r28 = getAdjustedPosition(r1, this.mVelocity);
        this.mSpline[0].getSlope(r28, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r28, this.mInterpolateData);
        float r29 = this.mVelocity[0];
    L52:
        double[] r30 = this.mInterpolateVelocity;
        if (r114 >= r30.length) goto L55;
        r30[r114] = r30[r114] * ((double) r29);
        r114 = r114 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, r30, this.mInterpolateData);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L57:
        float r31 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float r115 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        KeyCycleOscillator r116 = r4;
        float r117 = (this.mEndMotionPath.width - this.mStartMotionPath.width) + r31;
        float r32 = (this.mEndMotionPath.height - this.mStartMotionPath.height) + r115;
        r24[0] = (r31 * (1.0f - r22)) + (r117 * r22);
        r24[1] = (r115 * (1.0f - r23)) + (r32 * r23);
        r113.clear();
        r113.setRotationVelocity(r9, r1);
        r113.setTranslationVelocity(r3, r7, r1);
        r113.setScaleVelocity(r11, r13, r1);
        r113.setRotationVelocity(r18, r1);
        r113.setTranslationVelocity(r5, r16, r1);
        r113.setScaleVelocity(r111, r116, r1);
        r113.applyTransform(r22, r23, r20, r21, r24);
        return;
    L37:
        r111 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r110.get("scaleX"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        goto L38
    L33:
        r18 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r17.get("rotationZ"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        goto L34
    L29:
        r16 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r15.get("translationY"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        goto L30
    L25:
        r5 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r14.get("translationX"), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        goto L26
    L21:
        r13 = (SplineSet) ZeusTransformUtils.preCheckCast(r12.get("scaleY"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L22
    L17:
        r11 = (SplineSet) ZeusTransformUtils.preCheckCast(r10.get("scaleX"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L18
    L13:
        r9 = (SplineSet) ZeusTransformUtils.preCheckCast(r8.get("rotationZ"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r7 = (SplineSet) ZeusTransformUtils.preCheckCast(r6.get("translationY"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r3 = (SplineSet) ZeusTransformUtils.preCheckCast(r2.get("translationX"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.x;
    }

    public float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget r19, float r20, long r21, KeyCache r23) {
        float r1 = getAdjustedPosition(r20, null);
        int r2 = this.mQuantizeMotionSteps;
        if (r2 == (-1)) goto L15;
        float r3 = 1.0f / r2;
        float r4 = ((float) Math.floor(r1 / r3)) * r3;
        float r5 = (r1 % r3) / r3;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r5 = (r5 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        DifferentialInterpolator r6 = this.mQuantizeMotionInterpolator;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r1 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r12 = r1;
        HashMap<String, SplineSet> r8 = this.mAttributesMap;
        if (r8 == null) goto L21;
        Iterator<SplineSet> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((SplineSet) ZeusTransformUtils.preCheckCast(r9.next(), SplineSet.class, "com.obric.memorydata.plugin")).setProperty(r19, r12);
    L21:
        CurveFit[] r10 = this.mSpline;
        if (r10 == null) goto L67;
        double r11 = r12;
        r10[0].getPos(r11, this.mInterpolateData);
        this.mSpline[0].getSlope(r11, this.mInterpolateVelocity);
        CurveFit r13 = this.mArcSpline;
        if (r13 == null) goto L29;
        double[] r14 = this.mInterpolateData;
        if (r14.length <= 0) goto L29;
        r13.getPos(r11, r14);
        this.mArcSpline.getSlope(r11, this.mInterpolateVelocity);
    L29:
        if (this.mNoMovement == true) goto L33;
        this.mStartMotionPath.setView(r12, r19, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
    L33:
        if (this.mTransformPivotTarget != (-1)) goto L35;
    L44:
        int r15 = 1;
    L45:
        CurveFit[] r16 = this.mSpline;
        if (r15 >= r16.length) goto L49;
        r16[r15].getPos(r11, this.mValuesBuff);
        ((CustomVariable) ZeusTransformUtils.preCheckCast(this.mStartMotionPath.customAttributes.get(this.mAttributeNames[r15 - 1]), CustomVariable.class, "com.obric.memorydata.plugin")).setInterpolatedValue(r19, this.mValuesBuff);
        r15 = r15 + 1;
        goto L45
    L49:
        if (this.mStartPoint.mVisibilityMode != 0) goto L62;
        if (r12 > 0.0f) goto L56;
        MotionConstrainedPoint r17 = this.mStartPoint;
    L53:
        int r18 = r17.visibility;
    L54:
        r19.setVisibility(r18);
        goto L62
    L56:
        if (r12 < 1.0f) goto L59;
        r17 = this.mEndPoint;
        goto L53
    L59:
        if (this.mEndPoint.visibility == this.mStartPoint.visibility) goto L62;
        r18 = 4;
    L62:
        if (this.mKeyTriggers == null) goto L68;
        int r22 = 0;
    L64:
        MotionKeyTrigger[] r24 = this.mKeyTriggers;
        if (r22 >= r24.length) goto L68;
        r24[r22].conditionallyFire(r12, r19);
        r22 = r22 + 1;
    L68:
        HashMap<String, KeyCycleOscillator> r25 = this.mCycleMap;
        if (r25 == null) goto L77;
        Iterator<KeyCycleOscillator> r26 = r25.values().iterator();
    L72:
        if (r26.hasNext() == false) goto L88;
        KeyCycleOscillator r27 = (KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r26.next(), KeyCycleOscillator.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, KeyCycleOscillator.PathRotateSet.class) == true) goto L75;
        r27.setProperty(r19, r12);
        goto L72
    L75:
        KeyCycleOscillator.PathRotateSet r28 = (KeyCycleOscillator.PathRotateSet) ZeusTransformUtils.preCheckCast(r27, KeyCycleOscillator.PathRotateSet.class, "com.obric.memorydata.plugin");
        double[] r29 = this.mInterpolateVelocity;
        r28.setPathRotate(r19, r12, r29[0], r29[1]);
        goto L72
    L88:
        return false;
    L77:
        return false;
    L35:
        if (this.mTransformPivotView != null) goto L37;
        this.mTransformPivotView = r19.getParent().findViewById(this.mTransformPivotTarget);
    L37:
        MotionWidget r30 = this.mTransformPivotView;
        if (r30 == null) goto L44;
        float r31 = (r30.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r32 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r19.getRight() - r19.getLeft()) <= 0) goto L44;
        if ((r19.getBottom() - r19.getTop()) <= 0) goto L44;
        float r33 = r32 - r19.getLeft();
        float r34 = r31 - r19.getTop();
        r19.setPivotX(r33);
        r19.setPivotY(r34);
        goto L44
    L67:
        float r35 = this.mStartMotionPath.x + ((this.mEndMotionPath.x - this.mStartMotionPath.x) * r12);
        float r36 = this.mStartMotionPath.y + ((this.mEndMotionPath.y - this.mStartMotionPath.y) * r12);
        float r37 = r35 + 0.5f;
        float r38 = r36 + 0.5f;
        r19.layout((int) r37, (int) r38, (int) (r37 + (this.mStartMotionPath.width + ((this.mEndMotionPath.width - this.mStartMotionPath.width) * r12))), (int) (r38 + (this.mStartMotionPath.height + ((this.mEndMotionPath.height - this.mStartMotionPath.height) * r12))));
        goto L68
    }

    String name() {
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget r9, MotionKeyPosition r10, float r11, float r12, String[] r13, float[] r14) {
        FloatRect r2 = new FloatRect();
        r2.left = this.mStartMotionPath.x;
        r2.top = this.mStartMotionPath.y;
        r2.right = r2.left + this.mStartMotionPath.width;
        r2.bottom = r2.top + this.mStartMotionPath.height;
        FloatRect r3 = new FloatRect();
        r3.left = this.mEndMotionPath.x;
        r3.top = this.mEndMotionPath.y;
        r3.right = r3.left + this.mEndMotionPath.width;
        r3.bottom = r3.top + this.mEndMotionPath.height;
        r10.positionAttributes(r9, r2, r3, r11, r12, r13, r14);
    }

    void rotate(Rect r2, Rect r3, int r4, int r5, int r6) {
        if (r4 == 1) goto L14;
        if (r4 != 2) goto L6;
        int r1 = r2.left + r2.right;
        int r7 = r2.top;
        int r8 = r2.bottom;
    L13:
        r3.left = r5 - (((r7 + r8) + r2.width()) / 2);
        r3.top = (r1 - r2.height()) / 2;
    L16:
        r3.right = r3.left + r2.width();
        r3.bottom = r3.top + r2.height();
        return;
    L6:
        if (r4 != 3) goto L8;
        int r9 = r2.left + r2.right;
        int r10 = r2.top;
        int r11 = r2.bottom;
        int r12 = ((r2.height() / 2) + r2.top) - (r9 / 2);
    L15:
        r3.left = r12;
        r3.top = r6 - ((r9 + r2.height()) / 2);
        goto L16
    L8:
        if (r4 != 4) goto L18;
        r1 = r2.left + r2.right;
        r7 = r2.bottom;
        r8 = r2.top;
        goto L13
    L18:
        return;
    L14:
        r9 = r2.left + r2.right;
        r12 = ((r2.top + r2.bottom) - r2.width()) / 2;
        goto L15
    }

    void setBothStates(MotionWidget r6) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
        this.mEndPoint.setState(r6);
    }

    public void setDrawPath(int r1) {
        this.mStartMotionPath.mDrawPath = r1;
    }

    public void setEnd(MotionWidget r6) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(r6.getLeft(), r6.getTop(), r6.getWidth(), r6.getHeight());
        this.mEndMotionPath.applyParameters(r6);
        this.mEndPoint.setState(r6);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    public void setStart(MotionWidget r6) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartMotionPath.applyParameters(r6);
        this.mStartPoint.setState(r6);
    }

    public void setStartState(ViewState r5, MotionWidget r6, int r7, int r8, int r9) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        Rect r0 = new Rect();
        if (r7 == 1) goto L7;
        if (r7 != 2) goto L9;
        int r10 = r5.left + r5.right;
        r0.left = r9 - (((r5.top + r5.bottom) + r5.width()) / 2);
        int r11 = (r10 - r5.height()) / 2;
    L8:
        r0.top = r11;
        r0.right = r0.left + r5.width();
        r0.bottom = r0.top + r5.height();
    L9:
        this.mStartMotionPath.setBounds(r0.left, r0.top, r0.width(), r0.height());
        this.mStartPoint.setState(r0, r6, r7, r5.rotation);
        return;
    L7:
        int r12 = r5.left + r5.right;
        r0.left = ((r5.top + r5.bottom) - r5.width()) / 2;
        r11 = r8 - ((r12 + r5.height()) / 2);
        goto L8
    }

    public void setTransformPivotTarget(int r1) {
        this.mTransformPivotTarget = r1;
        this.mTransformPivotView = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, float r2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r3, int r4) {
        if (r3 != 509) goto L5;
        setPathMotionArc(r4);
        return true;
    L5:
        if (r3 == 704) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r4, String r5) {
        if (705 != r4) goto L5;
        System.out.println("TYPE_INTERPOLATOR  " + r5);
        this.mQuantizeMotionInterpolator = getInterpolator(-1, r5, 0);
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r1, boolean r2) {
        return false;
    }

    public void setView(MotionWidget r1) {
        this.mView = r1;
    }

    public void setup(int r24, int r25, float r26, long r27) {
        new HashSet();
        HashSet<String> r5 = new HashSet();
        HashSet<String> r6 = new HashSet();
        HashSet<String> r7 = new HashSet();
        HashMap<String, Integer> r8 = new HashMap();
        int r9 = this.mPathMotionArc;
        if (r9 == (-1)) goto L5;
        this.mStartMotionPath.mPathMotionArc = r9;
    L5:
        this.mStartPoint.different(this.mEndPoint, r6);
        ArrayList<MotionKey> r10 = this.mKeyList;
        if (r10 == null) goto L28;
        Iterator<MotionKey> r11 = r10.iterator();
        ArrayList r13 = null;
    L9:
        if (r11.hasNext() == false) goto L30;
        MotionKey r14 = (MotionKey) ZeusTransformUtils.preCheckCast(r11.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, MotionKeyPosition.class) == false) goto L16;
        MotionKeyPosition r15 = (MotionKeyPosition) ZeusTransformUtils.preCheckCast(r14, MotionKeyPosition.class, "com.obric.memorydata.plugin");
        insertKey(new MotionPaths(r24, r25, r15, this.mStartMotionPath, this.mEndMotionPath));
        if (r15.mCurveFit == (-1)) goto L9;
        this.mCurveFitType = r15.mCurveFit;
        goto L9
    L16:
        if (ZeusTransformUtils.instanceOf(r14, MotionKeyCycle.class) == false) goto L19;
        r14.getAttributeNames(r7);
        goto L9
    L19:
        if (ZeusTransformUtils.instanceOf(r14, MotionKeyTimeCycle.class) == false) goto L22;
        r14.getAttributeNames(r5);
        goto L9
    L22:
        if (ZeusTransformUtils.instanceOf(r14, MotionKeyTrigger.class) == false) goto L26;
        if (r13 != null) goto L25;
        r13 = new ArrayList();
    L25:
        r13.add((MotionKeyTrigger) ZeusTransformUtils.preCheckCast(r14, MotionKeyTrigger.class, "com.obric.memorydata.plugin"));
        goto L9
    L26:
        r14.setInterpolation(r8);
        r14.getAttributeNames(r6);
    L30:
        if (r13 == null) goto L32;
        this.mKeyTriggers = (MotionKeyTrigger[]) ZeusTransformUtils.preCheckCast(r13.toArray(new MotionKeyTrigger[0]), MotionKeyTrigger[].class, "com.obric.memorydata.plugin");
    L32:
        char r16 = 1;
        if (r6.isEmpty() == true) goto L75;
        this.mAttributesMap = new HashMap();
        Iterator<String> r12 = r6.iterator();
    L36:
        if (r12.hasNext() == false) goto L55;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (r17.startsWith("CUSTOM,") == false) goto L50;
        KeyFrameArray.CustomVar r18 = new KeyFrameArray.CustomVar();
        String r19 = r17.split(",")[r16];
        Iterator<MotionKey> r110 = this.mKeyList.iterator();
    L41:
        if (r110.hasNext() == false) goto L49;
        r7 = r7;
        r110 = r110;
        MotionKey r20 = (MotionKey) ZeusTransformUtils.preCheckCast(r110.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (r20.mCustom == null) goto L41;
        String r111 = r19;
        CustomVariable r112 = (CustomVariable) ZeusTransformUtils.preCheckCast(r20.mCustom.get(r19), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r112 == null) goto L48;
        r18.append(r20.mFramePosition, r112);
    L48:
        r19 = r111;
        goto L41
    L49:
        HashSet<String> r113 = r7;
        SplineSet r21 = SplineSet.makeCustomSplineSet(r17, r18);
    L51:
        if (r21 == null) goto L54;
        r21.setType(r17);
        this.mAttributesMap.put(r17, r21);
    L54:
        r12 = r12;
        r7 = r113;
        r16 = 1;
        goto L36
    L50:
        r113 = r7;
        r21 = SplineSet.makeSpline(r17, r27);
        goto L51
    L55:
        HashSet<String> r114 = r7;
        ArrayList<MotionKey> r22 = this.mKeyList;
        if (r22 == null) goto L63;
        Iterator<MotionKey> r23 = r22.iterator();
    L59:
        if (r23.hasNext() == false) goto L63;
        MotionKey r28 = (MotionKey) ZeusTransformUtils.preCheckCast(r23.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r28, MotionKeyAttributes.class) == false) goto L59;
        r28.addValues(this.mAttributesMap);
    L63:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r29 = this.mAttributesMap.keySet().iterator();
    L65:
        if (r29.hasNext() == false) goto L77;
        String r30 = (String) ZeusTransformUtils.preCheckCast(r29.next(), String.class, "com.obric.memorydata.plugin");
        if (r8.containsKey(r30) == false) goto L71;
        Integer r115 = (Integer) ZeusTransformUtils.preCheckCast(r8.get(r30), Integer.class, "com.obric.memorydata.plugin");
        if (r115 == null) goto L71;
        int r116 = r115.intValue();
    L72:
        SplineSet r31 = (SplineSet) ZeusTransformUtils.preCheckCast(this.mAttributesMap.get(r30), SplineSet.class, "com.obric.memorydata.plugin");
        if (r31 == null) goto L65;
        r31.setup(r116);
    L71:
        r116 = 0;
    L77:
        if (r5.isEmpty() == false) goto L79;
    L121:
        int r2 = 2;
        int r1 = this.mMotionPaths.size() + 2;
        MotionPaths[] r32 = new MotionPaths[r1];
        r32[0] = this.mStartMotionPath;
        r32[r1 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L124;
    L126:
        Iterator<MotionPaths> r33 = this.mMotionPaths.iterator();
        int r34 = 1;
    L128:
        if (r33.hasNext() == false) goto L130;
        r32[r34] = (MotionPaths) ZeusTransformUtils.preCheckCast(r33.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        r34 = r34 + 1;
        goto L128
    L130:
        HashSet r35 = new HashSet();
        Iterator<String> r36 = this.mEndMotionPath.customAttributes.keySet().iterator();
    L132:
        if (r36.hasNext() == false) goto L138;
        String r117 = (String) ZeusTransformUtils.preCheckCast(r36.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mStartMotionPath.customAttributes.containsKey(r117) == false) goto L132;
        if (r6.contains("CUSTOM," + r117) == true) goto L132;
        r35.add(r117);
        goto L132
    L138:
        String[] r37 = (String[]) ZeusTransformUtils.preCheckCast(r35.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        this.mAttributeNames = r37;
        this.mAttributeInterpolatorCount = new int[r37.length];
        int r38 = 0;
    L139:
        String[] r39 = this.mAttributeNames;
        if (r38 >= r39.length) goto L151;
        String r40 = r39[r38];
        this.mAttributeInterpolatorCount[r38] = 0;
        int r41 = 0;
    L142:
        if (r41 >= r1) goto L149;
        if (r32[r41].customAttributes.containsKey(r40) == false) goto L148;
        CustomVariable r118 = (CustomVariable) ZeusTransformUtils.preCheckCast(r32[r41].customAttributes.get(r40), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r118 == null) goto L148;
        int[] r42 = this.mAttributeInterpolatorCount;
        r42[r38] = r42[r38] + r118.numberOfInterpolatedValues();
    L148:
        r41 = r41 + 1;
    L149:
        r38 = r38 + 1;
        goto L139
    L151:
        if (r32[0].mPathMotionArc == (-1)) goto L153;
        boolean r43 = true;
    L154:
        int r44 = 18 + this.mAttributeNames.length;
        boolean[] r45 = new boolean[r44];
        int r46 = 1;
    L155:
        if (r46 >= r1) goto L157;
        r32[r46].different(r32[r46 - 1], r45, this.mAttributeNames, r43);
        r46 = r46 + 1;
        goto L155
    L157:
        int r47 = 0;
        int r48 = 1;
    L158:
        if (r48 >= r44) goto L163;
        if (r45[r48] == false) goto L162;
        r47 = r47 + 1;
    L162:
        r48 = r48 + 1;
        goto L158
    L163:
        this.mInterpolateVariables = new int[r47];
        int r49 = Math.max(2, r47);
        this.mInterpolateData = new double[r49];
        this.mInterpolateVelocity = new double[r49];
        int r50 = 0;
        int r51 = 1;
    L164:
        if (r51 >= r44) goto L169;
        if (r45[r51] == false) goto L168;
        this.mInterpolateVariables[r50] = r51;
        r50 = r50 + 1;
    L168:
        r51 = r51 + 1;
        goto L164
    L169:
        double[][] r52 = (double[][]) Array.newInstance(double.class, new int[]{r1, this.mInterpolateVariables.length});
        double[] r53 = new double[r1];
        int r54 = 0;
    L170:
        if (r54 >= r1) goto L172;
        r32[r54].fillStandard(r52[r54], this.mInterpolateVariables);
        r53[r54] = r32[r54].time;
        r54 = r54 + 1;
        goto L170
    L172:
        int r55 = 0;
    L173:
        int[] r56 = this.mInterpolateVariables;
        if (r55 >= r56.length) goto L181;
        if (r56[r55] >= MotionPaths.names.length) goto L180;
        String r119 = MotionPaths.names[this.mInterpolateVariables[r55]] + " [";
        int r57 = 0;
    L178:
        if (r57 >= r1) goto L180;
        r119 = r119 + r52[r57][r55];
        r57 = r57 + 1;
    L180:
        r55 = r55 + 1;
        goto L173
    L181:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r58 = 0;
    L183:
        if (r58 >= this.mAttributeNames.length) goto L195;
        double[][] r120 = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        String r121 = this.mAttributeNames[r58];
        double[] r122 = null;
        double[][] r123 = r120;
        int r124 = 0;
        int r125 = 0;
    L185:
        if (r124 >= r1) goto L194;
        if (r32[r124].hasCustomData(r121) == false) goto L193;
        if (r123 != null) goto L190;
        int[] r126 = new int[r2];
        r126[1] = r32[r124].getCustomDataCount(r121);
        r126[0] = r1;
        double[][] r127 = (double[][]) Array.newInstance(double.class, r126);
        r122 = new double[r1];
        int r59 = 0;
        r123 = r127;
    L191:
        r122[r125] = r32[r124].time;
        r32[r124].getCustomData(r121, r123[r125], r59);
        r125 = r125 + 1;
        goto L193
    L190:
        r59 = 0;
    L193:
        r124 = r124 + 1;
        r1 = r1;
        r2 = 2;
        goto L185
    L194:
        r58 = r58 + 1;
        this.mSpline[r58] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r122, r125), (double[][]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r123, r125), double[][].class, "com.obric.memorydata.plugin"));
        r1 = r1;
        r2 = 2;
        goto L183
    L195:
        int r210 = r1;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r53, r52);
        if (r32[0].mPathMotionArc == (-1)) goto L201;
        int[] r3 = new int[r210];
        double[] r60 = new double[r210];
        double[][] r4 = (double[][]) Array.newInstance(double.class, new int[]{r210, 2});
        int r128 = 0;
    L198:
        if (r128 >= r210) goto L200;
        r3[r128] = r32[r128].mPathMotionArc;
        r60[r128] = r32[r128].time;
        r4[r128][0] = r32[r128].x;
        r4[r128][1] = r32[r128].y;
        r128 = r128 + 1;
        goto L198
    L200:
        this.mArcSpline = CurveFit.getArc(r3, r60, r4);
    L201:
        float r61 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L225;
        Iterator<String> r62 = r114.iterator();
    L205:
        if (r62.hasNext() == false) goto L215;
        String r63 = (String) ZeusTransformUtils.preCheckCast(r62.next(), String.class, "com.obric.memorydata.plugin");
        KeyCycleOscillator r64 = KeyCycleOscillator.makeWidgetCycle(r63);
        if (r64 == null) goto L205;
        if (r64.variesByPath() == true) goto L212;
    L214:
        r64.setType(r63);
        this.mCycleMap.put(r63, r64);
        goto L205
    L212:
        if (Float.isNaN(r61) == false) goto L214;
        r61 = getPreCycleDistance();
        goto L214
    L215:
        Iterator<MotionKey> r65 = this.mKeyList.iterator();
    L217:
        if (r65.hasNext() == false) goto L221;
        MotionKey r66 = (MotionKey) ZeusTransformUtils.preCheckCast(r65.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r66, MotionKeyCycle.class) == false) goto L217;
        ((MotionKeyCycle) ZeusTransformUtils.preCheckCast(r66, MotionKeyCycle.class, "com.obric.memorydata.plugin")).addCycleValues(this.mCycleMap);
        goto L217
    L221:
        Iterator<KeyCycleOscillator> r0 = this.mCycleMap.values().iterator();
    L223:
        if (r0.hasNext() == false) goto L312;
        ((KeyCycleOscillator) ZeusTransformUtils.preCheckCast(r0.next(), KeyCycleOscillator.class, "com.obric.memorydata.plugin")).setup(r61);
        goto L223
    L312:
        return;
    L225:
        return;
    L153:
        r43 = false;
        goto L154
    L124:
        if (this.mCurveFitType != MotionKey.UNSET) goto L126;
        this.mCurveFitType = 0;
        goto L126
    L79:
        if (this.mTimeCycleAttributesMap != null) goto L81;
        this.mTimeCycleAttributesMap = new HashMap();
    L81:
        Iterator<String> r67 = r5.iterator();
    L83:
        if (r67.hasNext() == false) goto L105;
        String r68 = (String) ZeusTransformUtils.preCheckCast(r67.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mTimeCycleAttributesMap.containsKey(r68) == true) goto L83;
        if (r68.startsWith("CUSTOM,") == false) goto L100;
        KeyFrameArray.CustomVar r69 = new KeyFrameArray.CustomVar();
        String r129 = r68.split(",")[1];
        Iterator<MotionKey> r130 = this.mKeyList.iterator();
    L91:
        if (r130.hasNext() == false) goto L99;
        r67 = r67;
        MotionKey r70 = (MotionKey) ZeusTransformUtils.preCheckCast(r130.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (r70.mCustom == null) goto L91;
        String r131 = r129;
        CustomVariable r132 = (CustomVariable) ZeusTransformUtils.preCheckCast(r70.mCustom.get(r129), CustomVariable.class, "com.obric.memorydata.plugin");
        if (r132 == null) goto L98;
        r69.append(r70.mFramePosition, r132);
    L98:
        r129 = r131;
        goto L91
    L99:
        Iterator<String> r211 = r67;
        SplineSet r71 = SplineSet.makeCustomSplineSet(r68, r69);
    L101:
        if (r71 == null) goto L104;
        r71.setType(r68);
    L104:
        r67 = r211;
        goto L83
    L100:
        r211 = r67;
        r71 = SplineSet.makeSpline(r68, r27);
        goto L101
    L105:
        ArrayList<MotionKey> r72 = this.mKeyList;
        if (r72 == null) goto L113;
        Iterator<MotionKey> r73 = r72.iterator();
    L109:
        if (r73.hasNext() == false) goto L113;
        MotionKey r74 = (MotionKey) ZeusTransformUtils.preCheckCast(r73.next(), MotionKey.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r74, MotionKeyTimeCycle.class) == false) goto L109;
        ((MotionKeyTimeCycle) ZeusTransformUtils.preCheckCast(r74, MotionKeyTimeCycle.class, "com.obric.memorydata.plugin")).addTimeValues(this.mTimeCycleAttributesMap);
    L113:
        Iterator<String> r75 = this.mTimeCycleAttributesMap.keySet().iterator();
    L115:
        if (r75.hasNext() == false) goto L121;
        String r76 = (String) ZeusTransformUtils.preCheckCast(r75.next(), String.class, "com.obric.memorydata.plugin");
        if (r8.containsKey(r76) == false) goto L119;
        int r77 = ((Integer) ZeusTransformUtils.preCheckCast(r8.get(r76), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L120:
        ((TimeCycleSplineSet) ZeusTransformUtils.preCheckCast(this.mTimeCycleAttributesMap.get(r76), TimeCycleSplineSet.class, "com.obric.memorydata.plugin")).setup(r77);
        goto L115
    L119:
        r77 = 0;
        goto L120
    L75:
        r114 = r7;
        goto L77
    L28:
        r13 = null;
        goto L30
    }

    public void setupRelative(Motion r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
