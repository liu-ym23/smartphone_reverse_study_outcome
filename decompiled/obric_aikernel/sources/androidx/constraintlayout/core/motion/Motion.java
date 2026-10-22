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

    public Motion(MotionWidget r10) {
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
        setView(r10);
    }

    private float getAdjustedPosition(float r11, float[] r12) {
        float r10 = 0.0f;
        float r13 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        Easing r14 = this.mStartMotionPath.mKeyFrameEasing;
        float r15 = Float.NaN;
        Iterator<MotionPaths> r16 = this.mMotionPaths.iterator();
    L17:
        if (r16.hasNext() == false) goto L26;
        MotionPaths r17 = r16.next();
        Easing r18 = r17.mKeyFrameEasing;
        if (r18 == null) goto L17;
        float r19 = r17.time;
        if (r19 < r11) goto L22;
        if (Float.isNaN(r15) == false) goto L17;
        r15 = r17.time;
        goto L17
    L22:
        r14 = r18;
        r10 = r19;
        goto L17
    L26:
        if (r14 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r15) == true) goto L31;
        r13 = r15;
    L31:
        float r20 = r13 - r10;
        double r110 = (r11 - r10) / r20;
        float r21 = r10 + (((float) r14.get(r110)) * r20);
        if (r12 == null) goto L35;
        r12[0] = (float) r14.getDiff(r110);
    L35:
        return r21;
    L5:
        float r22 = this.mStaggerScale;
        if (r22 == 1.0d) goto L15;
        float r23 = this.mStaggerOffset;
        if (r11 >= r23) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r23) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = Math.min((r11 - r23) * r22, 1.0f);
        goto L15
    }

    private static DifferentialInterpolator getInterpolator(int r10, String r11, int r12) {
        if (r10 == (-1)) goto L6;
        return null;
    L6:
        final Easing r13 = Easing.getInterpolator(r11);
        return new AnonymousClass1(r13);
    }

    private float getPreCycleDistance() {
        float[] r10 = new float[2];
        float r11 = 1.0f / 99;
        double r13 = 0.0d;
        double r15 = 0.0d;
        float r12 = 0.0f;
        int r14 = 0;
    L4:
        if (r14 >= 100) goto L28;
        float r16 = r14 * r11;
        double r17 = r16;
        Easing r18 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r19 = this.mMotionPaths.iterator();
        float r110 = Float.NaN;
        float r111 = 0.0f;
    L7:
        if (r19.hasNext() == false) goto L17;
        MotionPaths r20 = r19.next();
        Easing r112 = r20.mKeyFrameEasing;
        if (r112 == null) goto L7;
        float r113 = r20.time;
        if (r113 >= r16) goto L14;
        r18 = r112;
        r111 = r113;
        goto L7
    L14:
        if (Float.isNaN(r110) == false) goto L7;
        r110 = r20.time;
        goto L7
    L17:
        if (r18 != null) goto L19;
    L22:
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        float r114 = r12;
        int r115 = r14;
        this.mStartMotionPath.getCenter(r17, this.mInterpolateVariables, this.mInterpolateData, r10, 0);
        if (r115 <= 0) goto L25;
        char r21 = 0;
        float r22 = (float) (((double) r114) + Math.hypot(r15 - ((double) r10[1]), r13 - ((double) r10[0])));
    L26:
        r13 = r10[r21];
        r14 = r115 + 1;
        r12 = r22;
        r15 = r10[1];
        goto L4
    L25:
        r21 = 0;
        r22 = r114;
        goto L26
    L19:
        if (Float.isNaN(r110) == false) goto L21;
        r110 = 1.0f;
    L21:
        float r116 = r110 - r111;
        r17 = (((float) r18.get((r16 - r111) / r116)) * r116) + r111;
        goto L22
    L28:
        return r12;
    }

    private void insertKey(MotionPaths r10) {
        Iterator<MotionPaths> r11 = this.mMotionPaths.iterator();
        MotionPaths r12 = null;
    L4:
        if (r11.hasNext() == false) goto L8;
        MotionPaths r13 = r11.next();
        if (r10.position != r13.position) goto L4;
        r12 = r13;
        goto L4
    L8:
        if (r12 == null) goto L10;
        this.mMotionPaths.remove(r12);
    L10:
        int r14 = Collections.binarySearch(this.mMotionPaths, r10);
        if (r14 != 0) goto L13;
        Utils.loge(TAG, " KeyPath position \"" + r10.position + "\" outside of range");
    L13:
        this.mMotionPaths.add((-r14) - 1, r10);
    }

    private void readView(MotionPaths r10) {
        r10.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey r10) {
        this.mKeyList.add(r10);
    }

    void addKeys(ArrayList<MotionKey> r10) {
        this.mKeyList.addAll(r10);
    }

    void buildBounds(float[] r18, int r19) {
        float r10 = 1.0f / (r19 - 1);
        HashMap<String, SplineSet> r11 = this.mAttributesMap;
        if (r11 == null) goto L6;
        SplineSet r12 = r11.get("translationX");
    L6:
        HashMap<String, SplineSet> r13 = this.mAttributesMap;
        if (r13 == null) goto L10;
        SplineSet r14 = r13.get("translationY");
    L10:
        HashMap<String, KeyCycleOscillator> r15 = this.mCycleMap;
        if (r15 == null) goto L14;
        KeyCycleOscillator r16 = r15.get("translationX");
    L14:
        HashMap<String, KeyCycleOscillator> r17 = this.mCycleMap;
        if (r17 == null) goto L18;
        KeyCycleOscillator r20 = r17.get("translationY");
    L18:
        int r21 = 0;
    L19:
        if (r21 >= r19) goto L52;
        float r22 = r21 * r10;
        float r23 = this.mStaggerScale;
        float r24 = 0.0f;
        if (r23 == 1.0f) goto L30;
        float r25 = this.mStaggerOffset;
        if (r22 >= r25) goto L26;
        r22 = 0.0f;
    L26:
        if (r22 <= r25) goto L30;
        if (r22 >= 1.0d) goto L30;
        r22 = Math.min((r22 - r25) * r23, 1.0f);
    L30:
        double r26 = r22;
        Easing r110 = this.mStartMotionPath.mKeyFrameEasing;
        float r111 = Float.NaN;
        Iterator<MotionPaths> r112 = this.mMotionPaths.iterator();
    L32:
        if (r112.hasNext() == false) goto L41;
        MotionPaths r113 = r112.next();
        Easing r114 = r113.mKeyFrameEasing;
        if (r114 == null) goto L32;
        float r115 = r113.time;
        if (r115 < r22) goto L37;
        if (Float.isNaN(r111) == false) goto L32;
        r111 = r113.time;
        goto L32
    L37:
        r110 = r114;
        r24 = r115;
        goto L32
    L41:
        if (r110 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r26, this.mInterpolateData);
        CurveFit r27 = this.mArcSpline;
        if (r27 == null) goto L51;
        double[] r28 = this.mInterpolateData;
        if (r28.length <= 0) goto L51;
        r27.getPos(r26, r28);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r18, r21 * 2);
        r21 = r21 + 1;
        goto L19
    L43:
        if (Float.isNaN(r111) == false) goto L45;
        r111 = 1.0f;
    L45:
        float r116 = r111 - r24;
        r26 = (((float) r110.get((r22 - r24) / r116)) * r116) + r24;
        goto L46
    }

    int buildKeyBounds(float[] r10, int[] r11) {
        if (r10 == null) goto L16;
        double[] r12 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r13 = this.mMotionPaths.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L10;
        r11[r14] = r13.next().mMode;
        r14 = r14 + 1;
    L10:
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r15 >= r12.length) goto L15;
        this.mSpline[0].getPos(r12[r15], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r10, r16);
        r16 = r16 + 2;
        r15 = r15 + 1;
        goto L12
    L15:
        return r16 / 2;
    L16:
        return 0;
    }

    public int buildKeyFrames(float[] r10, int[] r11, int[] r12) {
        if (r10 == null) goto L21;
        double[] r13 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r14 = this.mMotionPaths.iterator();
        int r15 = 0;
    L8:
        if (r14.hasNext() == false) goto L10;
        r11[r15] = r14.next().mMode;
        r15 = r15 + 1;
    L10:
        if (r12 == null) goto L15;
        Iterator<MotionPaths> r16 = this.mMotionPaths.iterator();
        int r17 = 0;
    L13:
        if (r16.hasNext() == false) goto L15;
        r12[r17] = (int) (r16.next().position * 100.0f);
        r17 = r17 + 1;
    L15:
        int r18 = 0;
        int r19 = 0;
    L17:
        if (r18 >= r13.length) goto L20;
        this.mSpline[0].getPos(r13[r18], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r13[r18], this.mInterpolateVariables, this.mInterpolateData, r10, r19);
        r19 = r19 + 2;
        r18 = r18 + 1;
        goto L17
    L20:
        return r19 / 2;
    L21:
        return 0;
    }

    public void buildPath(float[] r21, int r22) {
        float r10 = 1.0f;
        float r11 = 1.0f / (r22 - 1);
        HashMap<String, SplineSet> r12 = this.mAttributesMap;
        KeyCycleOscillator r13 = null;
        if (r12 != null) goto L5;
        SplineSet r14 = null;
    L6:
        HashMap<String, SplineSet> r15 = this.mAttributesMap;
        if (r15 != null) goto L9;
        SplineSet r16 = null;
    L10:
        HashMap<String, KeyCycleOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L13;
        KeyCycleOscillator r18 = null;
    L14:
        HashMap<String, KeyCycleOscillator> r19 = this.mCycleMap;
        if (r19 == null) goto L18;
        r13 = r19.get("translationY");
    L18:
        KeyCycleOscillator r110 = r13;
        int r20 = 0;
    L19:
        if (r20 >= r22) goto L64;
        float r23 = r20 * r11;
        float r24 = this.mStaggerScale;
        if (r24 == r10) goto L30;
        float r25 = this.mStaggerOffset;
        if (r23 >= r25) goto L26;
        r23 = 0.0f;
    L26:
        if (r23 <= r25) goto L30;
        if (r23 >= 1.0d) goto L30;
        r23 = Math.min((r23 - r25) * r24, r10);
    L30:
        float r26 = r23;
        double r27 = r26;
        Easing r28 = this.mStartMotionPath.mKeyFrameEasing;
        float r29 = Float.NaN;
        Iterator<MotionPaths> r30 = this.mMotionPaths.iterator();
        float r111 = 0.0f;
    L32:
        if (r30.hasNext() == false) goto L42;
        MotionPaths r31 = r30.next();
        Easing r112 = r31.mKeyFrameEasing;
        double r113 = r27;
        if (r112 == null) goto L41;
        float r32 = r31.time;
        if (r32 >= r26) goto L39;
        r111 = r32;
        r28 = r112;
        goto L41
    L39:
        if (Float.isNaN(r29) == false) goto L41;
        r29 = r31.time;
    L41:
        r27 = r113;
        goto L32
    L42:
        double r114 = r27;
        if (r28 != null) goto L45;
        double r33 = r114;
    L49:
        this.mSpline[0].getPos(r33, this.mInterpolateData);
        CurveFit r34 = this.mArcSpline;
        if (r34 == null) goto L54;
        double[] r35 = this.mInterpolateData;
        if (r35.length <= 0) goto L54;
        r34.getPos(r33, r35);
    L54:
        int r115 = r20 * 2;
        int r116 = r20;
        this.mStartMotionPath.getCenter(r33, this.mInterpolateVariables, this.mInterpolateData, r21, r115);
        if (r18 == null) goto L57;
        r21[r115] = r21[r115] + r18.get(r26);
    L59:
        if (r110 == null) goto L61;
        int r117 = r115 + 1;
        r21[r117] = r21[r117] + r110.get(r26);
    L63:
        r20 = r116 + 1;
        r10 = 1.0f;
        goto L19
    L61:
        if (r16 == null) goto L63;
        int r118 = r115 + 1;
        r21[r118] = r21[r118] + r16.get(r26);
        goto L63
    L57:
        if (r14 == null) goto L59;
        r21[r115] = r21[r115] + r14.get(r26);
        goto L59
    L45:
        if (Float.isNaN(r29) == false) goto L47;
        r29 = 1.0f;
    L47:
        float r36 = r29 - r111;
        r33 = (((float) r28.get((r26 - r111) / r36)) * r36) + r111;
        goto L49
    L64:
        return;
    L13:
        r18 = r17.get("translationX");
        goto L14
    L9:
        r16 = r15.get("translationY");
        goto L10
    L5:
        r14 = r12.get("translationX");
        goto L6
    }

    public void buildRect(float r10, float[] r11, int r12) {
        this.mSpline[0].getPos(getAdjustedPosition(r10, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r11, r12);
    }

    void buildRectangles(float[] r10, int r11) {
        float r12 = 1.0f / (r11 - 1);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r13 * r12, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r10, r13 * 8);
        r13 = r13 + 1;
        goto L3
    }

    void endTrigger(boolean r10) {
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String r10, float[] r11, int r12) {
        SplineSet r13 = this.mAttributesMap.get(r10);
        if (r13 != null) goto L6;
        return -1;
    L6:
        int r14 = 0;
    L8:
        if (r14 >= r11.length) goto L11;
        r11[r14] = r13.get(r14 / (r11.length - 1));
        r14 = r14 + 1;
        goto L8
    L11:
        return r11.length;
    }

    public void getCenter(double r10, float[] r12, float[] r13) {
        double[] r11 = new double[4];
        double[] r14 = new double[4];
        this.mSpline[0].getPos(r10, r11);
        this.mSpline[0].getSlope(r10, r14);
        Arrays.fill(r13, 0.0f);
        this.mStartMotionPath.getCenter(r10, this.mInterpolateVariables, r11, r12, r14, r13);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    void getDpDt(float r12, float r13, float r14, float[] r15) {
        float r16 = getAdjustedPosition(r12, this.mVelocity);
        CurveFit[] r10 = this.mSpline;
        int r11 = 0;
        if (r10 == null) goto L16;
        double r17 = r16;
        r10[0].getSlope(r17, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        float r18 = this.mVelocity[0];
    L5:
        double[] r19 = this.mInterpolateVelocity;
        if (r11 >= r19.length) goto L8;
        r19[r11] = r19[r11] * ((double) r18);
        r11 = r11 + 1;
        goto L5
    L8:
        CurveFit r110 = this.mArcSpline;
        if (r110 == null) goto L14;
        double[] r20 = this.mInterpolateData;
        if (r20.length <= 0) goto L19;
        r110.getPos(r17, r20);
        this.mArcSpline.getSlope(r17, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, r19, this.mInterpolateData);
        return;
    L16:
        MotionPaths r111 = this.mEndMotionPath;
        float r21 = r111.f236x;
        MotionPaths r112 = this.mStartMotionPath;
        float r22 = r21 - r112.f236x;
        float r23 = r111.f237y - r112.f237y;
        float r24 = (r111.width - r112.width) + r22;
        float r113 = (r111.height - r112.height) + r23;
        r15[0] = (r22 * (1.0f - r13)) + (r24 * r13);
        r15[1] = (r23 * (1.0f - r14)) + (r113 * r14);
    }

    public int getDrawPath() {
        int r10 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r11 = this.mMotionPaths.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10 = Math.max(r10, r11.next().mDrawPath);
        goto L4
    L7:
        return Math.max(r10, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f236x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f237y;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String r10) {
        return 0;
    }

    public MotionPaths getKeyFrame(int r10) {
        return this.mMotionPaths.get(r10);
    }

    public int getKeyFrameInfo(int r18, int[] r19) {
        float[] r10 = new float[2];
        Iterator<MotionKey> r11 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L14;
        MotionKey r14 = r11.next();
        int r15 = r14.mType;
        if (r15 == r18) goto L10;
        if (r18 == (-1)) goto L4;
    L10:
        r19[r13] = 0;
        int r16 = r13 + 1;
        r19[r16] = r15;
        int r17 = r16 + 1;
        int r20 = r14.mFramePosition;
        r19[r17] = r20;
        double r21 = r20 / 100.0f;
        this.mSpline[0].getPos(r21, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r21, this.mInterpolateVariables, this.mInterpolateData, r10, 0);
        int r110 = r17 + 1;
        r19[r110] = Float.floatToIntBits(r10[0]);
        int r111 = r110 + 1;
        r19[r111] = Float.floatToIntBits(r10[1]);
        if ((r14 instanceof MotionKeyPosition) == false) goto L13;
        MotionKeyPosition r112 = (MotionKeyPosition) r14;
        int r113 = r111 + 1;
        r19[r113] = r112.mPositionType;
        int r114 = r113 + 1;
        r19[r114] = Float.floatToIntBits(r112.mPercentX);
        r111 = r114 + 1;
        r19[r111] = Float.floatToIntBits(r112.mPercentY);
    L13:
        int r115 = r111 + 1;
        r19[r13] = r115 - r13;
        r12 = r12 + 1;
        r13 = r115;
        goto L4
    L14:
        return r12;
    }

    float getKeyFrameParameter(int r10, float r11, float r12) {
        MotionPaths r13 = this.mEndMotionPath;
        float r14 = r13.f236x;
        MotionPaths r15 = this.mStartMotionPath;
        float r16 = r15.f236x;
        float r17 = r14 - r16;
        float r18 = r13.f237y;
        float r19 = r15.f237y;
        float r20 = r18 - r19;
        float r21 = r16 + (r15.width / 2.0f);
        float r22 = r19 + (r15.height / 2.0f);
        float r23 = (float) Math.hypot(r17, r20);
        if (r23 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r110 = r11 - r21;
        float r111 = r12 - r22;
        if (((float) Math.hypot(r110, r111)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r24 = (r110 * r17) + (r111 * r20);
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L25;
        if (r10 == 5) goto L23;
        return 0.0f;
    L23:
        return r111 / r20;
    L25:
        return r110 / r20;
    L27:
        return r111 / r17;
    L29:
        return r110 / r17;
    L31:
        return (float) Math.sqrt((r23 * r23) - (r24 * r24));
    L33:
        return r24 / r23;
    }

    public int getKeyFramePositions(int[] r13, float[] r14) {
        Iterator<MotionKey> r10 = this.mKeyList.iterator();
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        MotionKey r15 = r10.next();
        int r16 = r15.mFramePosition;
        r13[r11] = (r15.mType * 1000) + r16;
        double r17 = r16 / 100.0f;
        this.mSpline[0].getPos(r17, this.mInterpolateData);
        this.mStartMotionPath.getCenter(r17, this.mInterpolateVariables, this.mInterpolateData, r14, r12);
        r12 = r12 + 2;
        r11 = r11 + 1;
        goto L4
    L6:
        return r11;
    }

    double[] getPos(double r10) {
        this.mSpline[0].getPos(r10, this.mInterpolateData);
        CurveFit r11 = this.mArcSpline;
        if (r11 == null) goto L8;
        double[] r12 = this.mInterpolateData;
        if (r12.length <= 0) goto L8;
        r11.getPos(r10, r12);
    L8:
        return this.mInterpolateData;
    }

    MotionKeyPosition getPositionKeyframe(int r11, int r12, float r13, float r14) {
        FloatRect r10 = new FloatRect();
        MotionPaths r15 = this.mStartMotionPath;
        float r16 = r15.f236x;
        r10.left = r16;
        float r17 = r15.f237y;
        r10.top = r17;
        r10.right = r16 + r15.width;
        r10.bottom = r17 + r15.height;
        FloatRect r18 = new FloatRect();
        MotionPaths r19 = this.mEndMotionPath;
        float r20 = r19.f236x;
        r18.left = r20;
        float r21 = r19.f237y;
        r18.top = r21;
        r18.right = r20 + r19.width;
        r18.bottom = r21 + r19.height;
        Iterator<MotionKey> r110 = this.mKeyList.iterator();
    L4:
        if (r110.hasNext() == false) goto L10;
        MotionKey r22 = r110.next();
        if ((r22 instanceof MotionKeyPosition) == false) goto L4;
        MotionKeyPosition r23 = (MotionKeyPosition) r22;
        if (r23.intersects(r11, r12, r10, r18, r13, r14) == false) goto L4;
        return r23;
    L10:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r10 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, SplineSet> r11 = this.mAttributesMap;
        KeyCycleOscillator r12 = null;
        if (r11 != null) goto L5;
        SplineSet r13 = null;
    L6:
        HashMap<String, SplineSet> r14 = this.mAttributesMap;
        if (r14 != null) goto L9;
        SplineSet r15 = null;
    L10:
        HashMap<String, SplineSet> r16 = this.mAttributesMap;
        if (r16 != null) goto L13;
        SplineSet r17 = null;
    L14:
        HashMap<String, SplineSet> r18 = this.mAttributesMap;
        if (r18 != null) goto L17;
        SplineSet r25 = null;
    L18:
        HashMap<String, SplineSet> r110 = this.mAttributesMap;
        if (r110 != null) goto L21;
        SplineSet r111 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r112 = this.mCycleMap;
        if (r112 != null) goto L25;
        KeyCycleOscillator r26 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r113 = this.mCycleMap;
        if (r113 != null) goto L29;
        KeyCycleOscillator r27 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r114 = this.mCycleMap;
        if (r114 != null) goto L33;
        KeyCycleOscillator r28 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r115 = this.mCycleMap;
        if (r115 != null) goto L37;
        KeyCycleOscillator r116 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r117 = this.mCycleMap;
        if (r117 == null) goto L42;
        r12 = r117.get("scaleY");
    L42:
        VelocityMatrix r118 = new VelocityMatrix();
        r118.clear();
        r118.setRotationVelocity(r17, r10);
        r118.setTranslationVelocity(r13, r15, r10);
        r118.setScaleVelocity(r25, r111, r10);
        r118.setRotationVelocity(r28, r10);
        r118.setTranslationVelocity(r26, r27, r10);
        r118.setScaleVelocity(r116, r12, r10);
        CurveFit r119 = this.mArcSpline;
        if (r119 == null) goto L49;
        double[] r29 = this.mInterpolateData;
        if (r29.length <= 0) goto L47;
        double r30 = r10;
        r119.getPos(r30, r29);
        this.mArcSpline.getSlope(r30, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L49:
        int r120 = 0;
        if (this.mSpline == null) goto L57;
        double r31 = getAdjustedPosition(r10, this.mVelocity);
        this.mSpline[0].getSlope(r31, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r31, this.mInterpolateData);
        float r32 = this.mVelocity[0];
    L52:
        double[] r33 = this.mInterpolateVelocity;
        if (r120 >= r33.length) goto L55;
        r33[r120] = r33[r120] * ((double) r32);
        r120 = r120 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, r33, this.mInterpolateData);
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L57:
        MotionPaths r121 = this.mEndMotionPath;
        float r122 = r121.f236x;
        MotionPaths r34 = this.mStartMotionPath;
        float r123 = r122 - r34.f236x;
        KeyCycleOscillator r124 = r12;
        float r125 = r121.f237y - r34.f237y;
        KeyCycleOscillator r126 = r116;
        float r35 = (r121.width - r34.width) + r123;
        float r127 = (r121.height - r34.height) + r125;
        r24[0] = (r123 * (1.0f - r22)) + (r35 * r22);
        r24[1] = (r125 * (1.0f - r23)) + (r127 * r23);
        r118.clear();
        r118.setRotationVelocity(r17, r10);
        r118.setTranslationVelocity(r13, r15, r10);
        r118.setScaleVelocity(r25, r111, r10);
        r118.setRotationVelocity(r28, r10);
        r118.setTranslationVelocity(r26, r27, r10);
        r118.setScaleVelocity(r126, r124, r10);
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L37:
        r116 = r115.get("scaleX");
        goto L38
    L33:
        r28 = r114.get("rotationZ");
        goto L34
    L29:
        r27 = r113.get("translationY");
        goto L30
    L25:
        r26 = r112.get("translationX");
        goto L26
    L21:
        r111 = r110.get("scaleY");
        goto L22
    L17:
        r25 = r18.get("scaleX");
        goto L18
    L13:
        r17 = r16.get("rotationZ");
        goto L14
    L9:
        r15 = r14.get("translationY");
        goto L10
    L5:
        r13 = r11.get("translationX");
        goto L6
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.f236x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f237y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget r18, float r19, long r20, KeyCache r22) {
        float r10 = getAdjustedPosition(r19, null);
        int r11 = this.mQuantizeMotionSteps;
        if (r11 == (-1)) goto L15;
        float r12 = 1.0f / r11;
        float r13 = ((float) Math.floor(r10 / r12)) * r12;
        float r14 = (r10 % r12) / r12;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r14 = (r14 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        DifferentialInterpolator r15 = this.mQuantizeMotionInterpolator;
        if (r15 == null) goto L11;
        float r16 = r15.getInterpolation(r14);
    L14:
        r10 = (r16 * r12) + r13;
        goto L15
    L11:
        if (r14 <= 0.5d) goto L13;
        r16 = 1.0f;
        goto L14
    L13:
        r16 = 0.0f;
    L15:
        float r17 = r10;
        HashMap<String, SplineSet> r21 = this.mAttributesMap;
        if (r21 == null) goto L21;
        Iterator<SplineSet> r23 = r21.values().iterator();
    L19:
        if (r23.hasNext() == false) goto L21;
        r23.next().setProperty(r18, r17);
    L21:
        CurveFit[] r24 = this.mSpline;
        if (r24 == null) goto L66;
        double r25 = r17;
        r24[0].getPos(r25, this.mInterpolateData);
        this.mSpline[0].getSlope(r25, this.mInterpolateVelocity);
        CurveFit r26 = this.mArcSpline;
        if (r26 == null) goto L29;
        double[] r27 = this.mInterpolateData;
        if (r27.length <= 0) goto L29;
        r26.getPos(r25, r27);
        this.mArcSpline.getSlope(r25, this.mInterpolateVelocity);
    L29:
        if (this.mNoMovement == true) goto L33;
        this.mStartMotionPath.setView(r17, r18, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
    L33:
        if (this.mTransformPivotTarget != (-1)) goto L35;
    L44:
        int r28 = 1;
    L45:
        CurveFit[] r29 = this.mSpline;
        if (r28 >= r29.length) goto L48;
        r29[r28].getPos(r25, this.mValuesBuff);
        this.mStartMotionPath.customAttributes.get(this.mAttributeNames[r28 - 1]).setInterpolatedValue(r18, this.mValuesBuff);
        r28 = r28 + 1;
        goto L45
    L48:
        MotionConstrainedPoint r30 = this.mStartPoint;
        if (r30.mVisibilityMode != 0) goto L61;
        if (r17 > 0.0f) goto L55;
    L52:
        int r31 = r30.visibility;
    L53:
        r18.setVisibility(r31);
        goto L61
    L55:
        if (r17 < 1.0f) goto L58;
        r30 = this.mEndPoint;
        goto L52
    L58:
        if (this.mEndPoint.visibility == r30.visibility) goto L61;
        r31 = 4;
    L61:
        if (this.mKeyTriggers == null) goto L67;
        int r32 = 0;
    L63:
        MotionKeyTrigger[] r33 = this.mKeyTriggers;
        if (r32 >= r33.length) goto L67;
        r33[r32].conditionallyFire(r17, r18);
        r32 = r32 + 1;
    L67:
        HashMap<String, KeyCycleOscillator> r34 = this.mCycleMap;
        if (r34 == null) goto L76;
        Iterator<KeyCycleOscillator> r35 = r34.values().iterator();
    L71:
        if (r35.hasNext() == false) goto L87;
        KeyCycleOscillator r36 = r35.next();
        if ((r36 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L74;
        r36.setProperty(r18, r17);
        goto L71
    L74:
        double[] r37 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r36).setPathRotate(r18, r17, r37[0], r37[1]);
        goto L71
    L87:
        return false;
    L76:
        return false;
    L35:
        if (this.mTransformPivotView != null) goto L37;
        this.mTransformPivotView = r18.getParent().findViewById(this.mTransformPivotTarget);
    L37:
        MotionWidget r38 = this.mTransformPivotView;
        if (r38 == null) goto L44;
        float r39 = (r38.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r40 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r18.getRight() - r18.getLeft()) <= 0) goto L44;
        if ((r18.getBottom() - r18.getTop()) <= 0) goto L44;
        float r41 = r40 - r18.getLeft();
        float r42 = r39 - r18.getTop();
        r18.setPivotX(r41);
        r18.setPivotY(r42);
        goto L44
    L66:
        MotionPaths r43 = this.mStartMotionPath;
        float r44 = r43.f236x;
        MotionPaths r45 = this.mEndMotionPath;
        float r46 = r44 + ((r45.f236x - r44) * r17);
        float r47 = r43.f237y;
        float r48 = r47 + ((r45.f237y - r47) * r17);
        float r49 = r43.width;
        float r50 = r49 + ((r45.width - r49) * r17);
        float r51 = r43.height;
        float r52 = r46 + 0.5f;
        float r53 = r48 + 0.5f;
        r18.layout((int) r52, (int) r53, (int) (r52 + r50), (int) (r53 + (r51 + ((r45.height - r51) * r17))));
        goto L67
    }

    String name() {
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget r10, MotionKeyPosition r11, float r12, float r13, String[] r14, float[] r15) {
        FloatRect r16 = new FloatRect();
        MotionPaths r17 = this.mStartMotionPath;
        float r18 = r17.f236x;
        r16.left = r18;
        float r19 = r17.f237y;
        r16.top = r19;
        r16.right = r18 + r17.width;
        r16.bottom = r19 + r17.height;
        FloatRect r20 = new FloatRect();
        MotionPaths r21 = this.mEndMotionPath;
        float r22 = r21.f236x;
        r20.left = r22;
        float r23 = r21.f237y;
        r20.top = r23;
        r20.right = r22 + r21.width;
        r20.bottom = r23 + r21.height;
        r11.positionAttributes(r10, r16, r20, r12, r13, r14, r15);
    }

    void rotate(Rect r10, Rect r11, int r12, int r13, int r14) {
        if (r12 == 1) goto L14;
        if (r12 != 2) goto L6;
        int r15 = r10.left + r10.right;
        int r16 = r10.top;
        int r17 = r10.bottom;
    L13:
        r11.left = r13 - (((r16 + r17) + r10.width()) / 2);
        r11.top = (r15 - r10.height()) / 2;
    L16:
        r11.right = r11.left + r10.width();
        r11.bottom = r11.top + r10.height();
        return;
    L6:
        if (r12 != 3) goto L8;
        int r18 = r10.left + r10.right;
        int r19 = ((r10.height() / 2) + r10.top) - (r18 / 2);
    L15:
        r11.left = r19;
        r11.top = r14 - ((r18 + r10.height()) / 2);
        goto L16
    L8:
        if (r12 != 4) goto L18;
        r15 = r10.left + r10.right;
        r16 = r10.bottom;
        r17 = r10.top;
        goto L13
    L18:
        return;
    L14:
        r18 = r10.left + r10.right;
        r19 = ((r10.top + r10.bottom) - r10.width()) / 2;
        goto L15
    }

    void setBothStates(MotionWidget r10) {
        MotionPaths r11 = this.mStartMotionPath;
        r11.time = 0.0f;
        r11.position = 0.0f;
        this.mNoMovement = true;
        r11.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mEndMotionPath.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mStartPoint.setState(r10);
        this.mEndPoint.setState(r10);
    }

    public void setDrawPath(int r10) {
        this.mStartMotionPath.mDrawPath = r10;
    }

    public void setEnd(MotionWidget r10) {
        MotionPaths r11 = this.mEndMotionPath;
        r11.time = 1.0f;
        r11.position = 1.0f;
        readView(r11);
        this.mEndMotionPath.setBounds(r10.getLeft(), r10.getTop(), r10.getWidth(), r10.getHeight());
        this.mEndMotionPath.applyParameters(r10);
        this.mEndPoint.setState(r10);
    }

    public void setPathMotionArc(int r10) {
        this.mPathMotionArc = r10;
    }

    public void setStart(MotionWidget r10) {
        MotionPaths r11 = this.mStartMotionPath;
        r11.time = 0.0f;
        r11.position = 0.0f;
        r11.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mStartMotionPath.applyParameters(r10);
        this.mStartPoint.setState(r10);
    }

    public void setStartState(ViewState r10, MotionWidget r11, int r12, int r13, int r14) {
        MotionPaths r15 = this.mStartMotionPath;
        r15.time = 0.0f;
        r15.position = 0.0f;
        Rect r16 = new Rect();
        if (r12 == 1) goto L7;
        if (r12 != 2) goto L9;
        int r17 = r10.left + r10.right;
        r16.left = r14 - (((r10.top + r10.bottom) + r10.width()) / 2);
        int r18 = (r17 - r10.height()) / 2;
    L8:
        r16.top = r18;
        r16.right = r16.left + r10.width();
        r16.bottom = r16.top + r10.height();
    L9:
        this.mStartMotionPath.setBounds(r16.left, r16.top, r16.width(), r16.height());
        this.mStartPoint.setState(r16, r11, r12, r10.rotation);
        return;
    L7:
        int r19 = r10.left + r10.right;
        r16.left = ((r10.top + r10.bottom) - r10.width()) / 2;
        r18 = r13 - ((r19 + r10.height()) / 2);
        goto L8
    }

    public void setTransformPivotTarget(int r10) {
        this.mTransformPivotTarget = r10;
        this.mTransformPivotView = null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, float r11) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, int r11) {
        if (r10 != 509) goto L5;
        setPathMotionArc(r11);
        return true;
    L5:
        if (r10 == 704) goto L8;
        return false;
    L8:
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, String r11) {
        if (705 != r10) goto L5;
        System.out.println("TYPE_INTERPOLATOR  " + r11);
        this.mQuantizeMotionInterpolator = getInterpolator(-1, r11, 0);
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int r10, boolean r11) {
        return false;
    }

    public void setView(MotionWidget r10) {
        this.mView = r10;
    }

    public void setup(int r21, int r22, float r23, long r24) {
        Class<double> r10 = double.class;
        new HashSet();
        HashSet<String> r11 = new HashSet();
        HashSet<String> r12 = new HashSet();
        HashSet<String> r13 = new HashSet();
        HashMap<String, Integer> r14 = new HashMap();
        int r15 = this.mPathMotionArc;
        if (r15 == (-1)) goto L5;
        this.mStartMotionPath.mPathMotionArc = r15;
    L5:
        this.mStartPoint.different(this.mEndPoint, r12);
        ArrayList<MotionKey> r16 = this.mKeyList;
        if (r16 == null) goto L27;
        Iterator<MotionKey> r17 = r16.iterator();
        ArrayList r18 = null;
    L9:
        if (r17.hasNext() == false) goto L29;
        MotionKey r19 = r17.next();
        if ((r19 instanceof MotionKeyPosition) == true) goto L12;
        if ((r19 instanceof MotionKeyCycle) == true) goto L17;
        if ((r19 instanceof MotionKeyTimeCycle) == true) goto L20;
        if ((r19 instanceof MotionKeyTrigger) == true) goto L23;
        r19.setInterpolation(r14);
        r19.getAttributeNames(r12);
        goto L9
    L23:
        if (r18 != null) goto L25;
        r18 = new ArrayList();
    L25:
        r18.add((MotionKeyTrigger) r19);
        goto L9
    L20:
        r19.getAttributeNames(r11);
        goto L9
    L17:
        r19.getAttributeNames(r13);
        goto L9
    L12:
        MotionKeyPosition r110 = (MotionKeyPosition) r19;
        insertKey(new MotionPaths(r21, r22, r110, this.mStartMotionPath, this.mEndMotionPath));
        int r111 = r110.mCurveFit;
        if (r111 == (-1)) goto L9;
        this.mCurveFitType = r111;
    L29:
        if (r18 == null) goto L31;
        this.mKeyTriggers = (MotionKeyTrigger[]) r18.toArray(new MotionKeyTrigger[0]);
    L31:
        char r112 = 1;
        if (r12.isEmpty() == true) goto L74;
        this.mAttributesMap = new HashMap();
        Iterator<String> r113 = r12.iterator();
    L35:
        if (r113.hasNext() == false) goto L53;
        String r114 = r113.next();
        if (r114.startsWith("CUSTOM,") == false) goto L48;
        KeyFrameArray.CustomVar r115 = new KeyFrameArray.CustomVar();
        String r20 = r114.split(",")[r112];
        Iterator<MotionKey> r116 = this.mKeyList.iterator();
    L40:
        if (r116.hasNext() == false) goto L47;
        MotionKey r25 = r116.next();
        Iterator<String> r117 = r113;
        HashMap<String, CustomVariable> r118 = r25.mCustom;
        if (r118 == null) goto L43;
        CustomVariable r119 = r118.get(r20);
        if (r119 == null) goto L43;
        r115.append(r25.mFramePosition, r119);
    L43:
        r113 = r117;
        goto L40
    L47:
        Iterator<String> r120 = r113;
        SplineSet r26 = SplineSet.makeCustomSplineSet(r114, r115);
    L49:
        if (r26 == null) goto L52;
        r26.setType(r114);
        this.mAttributesMap.put(r114, r26);
    L52:
        r113 = r120;
        r112 = 1;
        goto L35
    L48:
        r120 = r113;
        r26 = SplineSet.makeSpline(r114, r24);
        goto L49
    L53:
        ArrayList<MotionKey> r27 = this.mKeyList;
        if (r27 == null) goto L61;
        Iterator<MotionKey> r28 = r27.iterator();
    L57:
        if (r28.hasNext() == false) goto L61;
        MotionKey r29 = r28.next();
        if ((r29 instanceof MotionKeyAttributes) == false) goto L57;
        r29.addValues(this.mAttributesMap);
    L61:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r30 = this.mAttributesMap.keySet().iterator();
    L63:
        if (r30.hasNext() == false) goto L74;
        String r31 = r30.next();
        if (r14.containsKey(r31) == false) goto L69;
        Integer r121 = r14.get(r31);
        if (r121 == null) goto L69;
        int r122 = r121.intValue();
    L70:
        SplineSet r32 = this.mAttributesMap.get(r31);
        if (r32 == null) goto L63;
        r32.setup(r122);
    L69:
        r122 = 0;
    L74:
        if (r11.isEmpty() == false) goto L76;
    L116:
        int r33 = 2;
        int r34 = this.mMotionPaths.size() + 2;
        MotionPaths[] r35 = new MotionPaths[r34];
        r35[0] = this.mStartMotionPath;
        r35[r34 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L119;
    L121:
        Iterator<MotionPaths> r36 = this.mMotionPaths.iterator();
        int r37 = 1;
    L123:
        if (r36.hasNext() == false) goto L125;
        r35[r37] = r36.next();
        r37 = r37 + 1;
        goto L123
    L125:
        HashSet r38 = new HashSet();
        Iterator<String> r39 = this.mEndMotionPath.customAttributes.keySet().iterator();
    L127:
        if (r39.hasNext() == false) goto L133;
        String r123 = r39.next();
        if (this.mStartMotionPath.customAttributes.containsKey(r123) == false) goto L127;
        if (r12.contains("CUSTOM," + r123) == true) goto L127;
        r38.add(r123);
        goto L127
    L133:
        String[] r40 = (String[]) r38.toArray(new String[0]);
        this.mAttributeNames = r40;
        this.mAttributeInterpolatorCount = new int[r40.length];
        int r41 = 0;
    L134:
        String[] r42 = this.mAttributeNames;
        if (r41 >= r42.length) goto L146;
        String r43 = r42[r41];
        this.mAttributeInterpolatorCount[r41] = 0;
        int r44 = 0;
    L137:
        if (r44 >= r34) goto L144;
        if (r35[r44].customAttributes.containsKey(r43) == false) goto L143;
        CustomVariable r124 = r35[r44].customAttributes.get(r43);
        if (r124 == null) goto L143;
        int[] r45 = this.mAttributeInterpolatorCount;
        r45[r41] = r45[r41] + r124.numberOfInterpolatedValues();
    L143:
        r44 = r44 + 1;
    L144:
        r41 = r41 + 1;
        goto L134
    L146:
        if (r35[0].mPathMotionArc == (-1)) goto L148;
        boolean r46 = true;
    L149:
        int r47 = 18 + r42.length;
        boolean[] r48 = new boolean[r47];
        int r49 = 1;
    L150:
        if (r49 >= r34) goto L152;
        r35[r49].different(r35[r49 - 1], r48, this.mAttributeNames, r46);
        r49 = r49 + 1;
        goto L150
    L152:
        int r50 = 1;
        int r51 = 0;
    L153:
        if (r50 >= r47) goto L158;
        if (r48[r50] == false) goto L157;
        r51 = r51 + 1;
    L157:
        r50 = r50 + 1;
        goto L153
    L158:
        this.mInterpolateVariables = new int[r51];
        int r52 = Math.max(2, r51);
        this.mInterpolateData = new double[r52];
        this.mInterpolateVelocity = new double[r52];
        int r53 = 1;
        int r54 = 0;
    L159:
        if (r53 >= r47) goto L164;
        if (r48[r53] == false) goto L163;
        this.mInterpolateVariables[r54] = r53;
        r54 = r54 + 1;
    L163:
        r53 = r53 + 1;
        goto L159
    L164:
        double[][] r55 = (double[][]) Array.newInstance(r10, new int[]{r34, this.mInterpolateVariables.length});
        double[] r56 = new double[r34];
        int r57 = 0;
    L165:
        if (r57 >= r34) goto L167;
        r35[r57].fillStandard(r55[r57], this.mInterpolateVariables);
        r56[r57] = r35[r57].time;
        r57 = r57 + 1;
        goto L165
    L167:
        int r58 = 0;
    L168:
        int[] r59 = this.mInterpolateVariables;
        if (r58 >= r59.length) goto L176;
        if (r59[r58] >= MotionPaths.names.length) goto L175;
        String r125 = MotionPaths.names[this.mInterpolateVariables[r58]] + " [";
        int r60 = 0;
    L173:
        if (r60 >= r34) goto L175;
        r125 = r125 + r55[r60][r58];
        r60 = r60 + 1;
    L175:
        r58 = r58 + 1;
        goto L168
    L176:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r61 = 0;
    L177:
        String[] r62 = this.mAttributeNames;
        if (r61 >= r62.length) goto L190;
        String r63 = r62[r61];
        int r126 = 0;
        int r127 = 0;
        double[] r128 = null;
        double[][] r129 = null;
    L180:
        if (r126 >= r34) goto L189;
        if (r35[r126].hasCustomData(r63) == false) goto L188;
        if (r129 != null) goto L185;
        r128 = new double[r34];
        int[] r130 = new int[r33];
        r130[1] = r35[r126].getCustomDataCount(r63);
        int r131 = 0;
        r130[0] = r34;
        r129 = (double[][]) Array.newInstance(r10, r130);
    L186:
        r128[r127] = r35[r126].time;
        r35[r126].getCustomData(r63, r129[r127], r131);
        r127 = r127 + 1;
        goto L188
    L185:
        r131 = 0;
    L188:
        r126 = r126 + 1;
        r10 = r10;
        r33 = 2;
        goto L180
    L189:
        r61 = r61 + 1;
        this.mSpline[r61] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r128, r127), (double[][]) Arrays.copyOf(r129, r127));
        r10 = r10;
        r33 = 2;
        goto L177
    L190:
        Class<double> r132 = r10;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r56, r55);
        if (r35[0].mPathMotionArc == (-1)) goto L196;
        int[] r64 = new int[r34];
        double[] r65 = new double[r34];
        double[][] r66 = (double[][]) Array.newInstance(r132, new int[]{r34, 2});
        int r133 = 0;
    L193:
        if (r133 >= r34) goto L195;
        r64[r133] = r35[r133].mPathMotionArc;
        r65[r133] = r35[r133].time;
        r66[r133][0] = r35[r133].f236x;
        r66[r133][1] = r35[r133].f237y;
        r133 = r133 + 1;
        goto L193
    L195:
        this.mArcSpline = CurveFit.getArc(r64, r65, r66);
    L196:
        float r67 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L220;
        Iterator<String> r68 = r13.iterator();
    L200:
        if (r68.hasNext() == false) goto L210;
        String r69 = r68.next();
        KeyCycleOscillator r70 = KeyCycleOscillator.makeWidgetCycle(r69);
        if (r70 == null) goto L200;
        if (r70.variesByPath() == true) goto L207;
    L209:
        r70.setType(r69);
        this.mCycleMap.put(r69, r70);
        goto L200
    L207:
        if (Float.isNaN(r67) == false) goto L209;
        r67 = getPreCycleDistance();
        goto L209
    L210:
        Iterator<MotionKey> r71 = this.mKeyList.iterator();
    L212:
        if (r71.hasNext() == false) goto L216;
        MotionKey r72 = r71.next();
        if ((r72 instanceof MotionKeyCycle) == false) goto L212;
        ((MotionKeyCycle) r72).addCycleValues(this.mCycleMap);
        goto L212
    L216:
        Iterator<KeyCycleOscillator> r73 = this.mCycleMap.values().iterator();
    L218:
        if (r73.hasNext() == false) goto L318;
        r73.next().setup(r67);
        goto L218
    L318:
        return;
    L220:
        return;
    L148:
        r46 = false;
        goto L149
    L119:
        if (this.mCurveFitType != MotionKey.UNSET) goto L121;
        this.mCurveFitType = 0;
        goto L121
    L76:
        if (this.mTimeCycleAttributesMap != null) goto L78;
        this.mTimeCycleAttributesMap = new HashMap();
    L78:
        Iterator<String> r74 = r11.iterator();
    L80:
        if (r74.hasNext() == false) goto L100;
        String r75 = r74.next();
        if (this.mTimeCycleAttributesMap.containsKey(r75) == true) goto L80;
        if (r75.startsWith("CUSTOM,") == false) goto L96;
        KeyFrameArray.CustomVar r76 = new KeyFrameArray.CustomVar();
        String r134 = r75.split(",")[1];
        Iterator<MotionKey> r135 = this.mKeyList.iterator();
    L88:
        if (r135.hasNext() == false) goto L95;
        MotionKey r136 = r135.next();
        HashMap<String, CustomVariable> r137 = r136.mCustom;
        if (r137 == null) goto L88;
        CustomVariable r138 = r137.get(r134);
        if (r138 == null) goto L88;
        r76.append(r136.mFramePosition, r138);
        goto L88
    L95:
        SplineSet r77 = SplineSet.makeCustomSplineSet(r75, r76);
    L97:
        if (r77 == null) goto L80;
        r77.setType(r75);
        goto L80
    L96:
        r77 = SplineSet.makeSpline(r75, r24);
        goto L97
    L100:
        ArrayList<MotionKey> r78 = this.mKeyList;
        if (r78 == null) goto L108;
        Iterator<MotionKey> r79 = r78.iterator();
    L104:
        if (r79.hasNext() == false) goto L108;
        MotionKey r80 = r79.next();
        if ((r80 instanceof MotionKeyTimeCycle) == false) goto L104;
        ((MotionKeyTimeCycle) r80).addTimeValues(this.mTimeCycleAttributesMap);
    L108:
        Iterator<String> r81 = this.mTimeCycleAttributesMap.keySet().iterator();
    L110:
        if (r81.hasNext() == false) goto L116;
        String r82 = r81.next();
        if (r14.containsKey(r82) == false) goto L114;
        int r83 = r14.get(r82).intValue();
    L115:
        this.mTimeCycleAttributesMap.get(r82).setup(r83);
        goto L110
    L114:
        r83 = 0;
        goto L115
    L27:
        r18 = null;
        goto L29
    }

    public void setupRelative(Motion r10) {
        this.mStartMotionPath.setupRelative(r10, r10.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r10, r10.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f236x + " y: " + this.mStartMotionPath.f237y + " end: x: " + this.mEndMotionPath.f236x + " y: " + this.mEndMotionPath.f237y;
    }
}
