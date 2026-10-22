package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private int mCurveFitType;
    private HashMap<String, ViewOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    boolean mForceMeasure;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    Rect mTempRect;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    MotionController(View r10) {
        this.mTempRect = new Rect();
        this.mForceMeasure = false;
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
        int r11 = Key.UNSET;
        this.mPathMotionArc = r11;
        this.mTransformPivotTarget = r11;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = r11;
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

    private static Interpolator getInterpolator(Context r10, int r11, String r12, int r13) {
        if (r11 == (-2)) goto L30;
        if (r11 == (-1)) goto L27;
        if (r11 == 0) goto L26;
        if (r11 == 1) goto L24;
        if (r11 == 2) goto L22;
        if (r11 == 4) goto L20;
        if (r11 == 5) goto L18;
        return null;
    L18:
        return new OvershootInterpolator();
    L20:
        return new BounceInterpolator();
    L22:
        return new DecelerateInterpolator();
    L24:
        return new AccelerateInterpolator();
    L26:
        return new AccelerateDecelerateInterpolator();
    L27:
        final Easing r14 = Easing.getInterpolator(r12);
        return new AnonymousClass1(r14);
    L30:
        return AnimationUtils.loadInterpolator(r10, r13);
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
        int r11 = Collections.binarySearch(this.mMotionPaths, r10);
        if (r11 != 0) goto L5;
        Log.e(TAG, " KeyPath position \"" + r10.position + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r11) - 1, r10);
    }

    private void readView(MotionPaths r10) {
        r10.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key r10) {
        this.mKeyList.add(r10);
    }

    void addKeys(ArrayList<Key> r10) {
        this.mKeyList.addAll(r10);
    }

    void buildBounds(float[] r18, int r19) {
        float r10 = 1.0f / (r19 - 1);
        HashMap<String, ViewSpline> r11 = this.mAttributesMap;
        if (r11 == null) goto L6;
        ViewSpline r12 = r11.get("translationX");
    L6:
        HashMap<String, ViewSpline> r13 = this.mAttributesMap;
        if (r13 == null) goto L10;
        ViewSpline r14 = r13.get("translationY");
    L10:
        HashMap<String, ViewOscillator> r15 = this.mCycleMap;
        if (r15 == null) goto L14;
        ViewOscillator r16 = r15.get("translationX");
    L14:
        HashMap<String, ViewOscillator> r17 = this.mCycleMap;
        if (r17 == null) goto L18;
        ViewOscillator r20 = r17.get("translationY");
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

    int buildKeyFrames(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r10 = this.mSpline[0].getTimePoints();
        if (r12 == null) goto L10;
        Iterator<MotionPaths> r13 = this.mMotionPaths.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L10;
        r12[r14] = r13.next().mMode;
        r14 = r14 + 1;
    L10:
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r15 >= r10.length) goto L15;
        this.mSpline[0].getPos(r10[r15], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r10[r15], this.mInterpolateVariables, this.mInterpolateData, r11, r16);
        r16 = r16 + 2;
        r15 = r15 + 1;
        goto L12
    L15:
        return r16 / 2;
    L16:
        return 0;
    }

    void buildPath(float[] r21, int r22) {
        float r10 = 1.0f;
        float r11 = 1.0f / (r22 - 1);
        HashMap<String, ViewSpline> r12 = this.mAttributesMap;
        ViewOscillator r13 = null;
        if (r12 != null) goto L5;
        ViewSpline r14 = null;
    L6:
        HashMap<String, ViewSpline> r15 = this.mAttributesMap;
        if (r15 != null) goto L9;
        ViewSpline r16 = null;
    L10:
        HashMap<String, ViewOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L13;
        ViewOscillator r18 = null;
    L14:
        HashMap<String, ViewOscillator> r19 = this.mCycleMap;
        if (r19 == null) goto L18;
        r13 = r19.get("translationY");
    L18:
        ViewOscillator r110 = r13;
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

    void buildRect(float r10, float[] r11, int r12) {
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
        if ("button".equals(Debug.getName(this.mView)) == true) goto L5;
        return;
    L5:
        if (this.mKeyTriggers == null) goto L18;
        int r11 = 0;
    L7:
        KeyTrigger[] r12 = this.mKeyTriggers;
        if (r11 >= r12.length) goto L19;
        KeyTrigger r13 = r12[r11];
        if (r10 == false) goto L12;
        float r14 = -100.0f;
    L13:
        r13.conditionallyFire(r14, this.mView);
        r11 = r11 + 1;
        goto L7
    L12:
        r14 = 100.0f;
        goto L13
    L19:
        return;
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    int getAttributeValues(String r10, float[] r11, int r12) {
        ViewSpline r13 = this.mAttributesMap.get(r10);
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
        float r21 = r111.f259x;
        MotionPaths r112 = this.mStartMotionPath;
        float r22 = r21 - r112.f259x;
        float r23 = r111.f260y - r112.f260y;
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
        return this.mEndMotionPath.f259x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f260y;
    }

    MotionPaths getKeyFrame(int r10) {
        return this.mMotionPaths.get(r10);
    }

    public int getKeyFrameInfo(int r18, int[] r19) {
        float[] r10 = new float[2];
        Iterator<Key> r11 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L14;
        Key r14 = r11.next();
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
        if ((r14 instanceof KeyPosition) == false) goto L13;
        KeyPosition r112 = (KeyPosition) r14;
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
        float r14 = r13.f259x;
        MotionPaths r15 = this.mStartMotionPath;
        float r16 = r15.f259x;
        float r17 = r14 - r16;
        float r18 = r13.f260y;
        float r19 = r15.f260y;
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
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        Key r15 = r10.next();
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

    KeyPositionBase getPositionKeyframe(int r11, int r12, float r13, float r14) {
        RectF r10 = new RectF();
        MotionPaths r15 = this.mStartMotionPath;
        float r16 = r15.f259x;
        r10.left = r16;
        float r17 = r15.f260y;
        r10.top = r17;
        r10.right = r16 + r15.width;
        r10.bottom = r17 + r15.height;
        RectF r18 = new RectF();
        MotionPaths r19 = this.mEndMotionPath;
        float r20 = r19.f259x;
        r18.left = r20;
        float r21 = r19.f260y;
        r18.top = r21;
        r18.right = r20 + r19.width;
        r18.bottom = r21 + r19.height;
        Iterator<Key> r110 = this.mKeyList.iterator();
    L4:
        if (r110.hasNext() == false) goto L10;
        Key r22 = r110.next();
        if ((r22 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r23 = (KeyPositionBase) r22;
        if (r23.intersects(r11, r12, r10, r18, r13, r14) == false) goto L4;
        return r23;
    L10:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r10 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, ViewSpline> r11 = this.mAttributesMap;
        ViewOscillator r12 = null;
        if (r11 != null) goto L5;
        ViewSpline r13 = null;
    L6:
        HashMap<String, ViewSpline> r14 = this.mAttributesMap;
        if (r14 != null) goto L9;
        ViewSpline r15 = null;
    L10:
        HashMap<String, ViewSpline> r16 = this.mAttributesMap;
        if (r16 != null) goto L13;
        ViewSpline r17 = null;
    L14:
        HashMap<String, ViewSpline> r18 = this.mAttributesMap;
        if (r18 != null) goto L17;
        ViewSpline r25 = null;
    L18:
        HashMap<String, ViewSpline> r110 = this.mAttributesMap;
        if (r110 != null) goto L21;
        ViewSpline r111 = null;
    L22:
        HashMap<String, ViewOscillator> r112 = this.mCycleMap;
        if (r112 != null) goto L25;
        ViewOscillator r26 = null;
    L26:
        HashMap<String, ViewOscillator> r113 = this.mCycleMap;
        if (r113 != null) goto L29;
        ViewOscillator r27 = null;
    L30:
        HashMap<String, ViewOscillator> r114 = this.mCycleMap;
        if (r114 != null) goto L33;
        ViewOscillator r28 = null;
    L34:
        HashMap<String, ViewOscillator> r115 = this.mCycleMap;
        if (r115 != null) goto L37;
        ViewOscillator r116 = null;
    L38:
        HashMap<String, ViewOscillator> r117 = this.mCycleMap;
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
        float r122 = r121.f259x;
        MotionPaths r34 = this.mStartMotionPath;
        float r123 = r122 - r34.f259x;
        ViewOscillator r124 = r12;
        float r125 = r121.f260y - r34.f260y;
        ViewOscillator r126 = r116;
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
        r28 = r114.get(Key.ROTATION);
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
        r17 = r16.get(Key.ROTATION);
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
        return this.mStartMotionPath.f259x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f260y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    boolean interpolate(View r21, float r22, long r23, KeyCache r25) {
        float r10 = getAdjustedPosition(r22, null);
        int r11 = this.mQuantizeMotionSteps;
        if (r11 == Key.UNSET) goto L15;
        float r12 = 1.0f / r11;
        float r13 = ((float) Math.floor(r10 / r12)) * r12;
        float r14 = (r10 % r12) / r12;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r14 = (r14 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        Interpolator r15 = this.mQuantizeMotionInterpolator;
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
        HashMap<String, ViewSpline> r18 = this.mAttributesMap;
        if (r18 == null) goto L21;
        Iterator<ViewSpline> r19 = r18.values().iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        r19.next().setProperty(r21, r17);
    L21:
        HashMap<String, ViewTimeCycle> r20 = this.mTimeCycleAttributesMap;
        if (r20 == null) goto L31;
        Iterator<ViewTimeCycle> r24 = r20.values().iterator();
        ViewTimeCycle.PathRotate r26 = null;
        boolean r27 = false;
    L25:
        if (r24.hasNext() == false) goto L30;
        ViewTimeCycle r28 = r24.next();
        if ((r28 instanceof ViewTimeCycle.PathRotate) == true) goto L28;
        r27 = r27 | r28.setProperty(r21, r17, r23, r25);
        goto L25
    L28:
        r26 = (ViewTimeCycle.PathRotate) r28;
        goto L25
    L30:
        boolean r110 = r27;
        ViewTimeCycle.PathRotate r29 = r26;
    L32:
        CurveFit[] r30 = this.mSpline;
        int r111 = 1;
        if (r30 == null) goto L89;
        double r31 = r17;
        r30[0].getPos(r31, this.mInterpolateData);
        this.mSpline[0].getSlope(r31, this.mInterpolateVelocity);
        CurveFit r32 = this.mArcSpline;
        if (r32 == null) goto L40;
        double[] r33 = this.mInterpolateData;
        if (r33.length <= 0) goto L40;
        r32.getPos(r31, r33);
        this.mArcSpline.getSlope(r31, this.mInterpolateVelocity);
    L40:
        if (this.mNoMovement == true) goto L44;
        this.mStartMotionPath.setView(r17, r21, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
        this.mForceMeasure = false;
    L44:
        if (this.mTransformPivotTarget != Key.UNSET) goto L46;
    L55:
        HashMap<String, ViewSpline> r34 = this.mAttributesMap;
        if (r34 == null) goto L65;
        Iterator<ViewSpline> r35 = r34.values().iterator();
    L59:
        if (r35.hasNext() == false) goto L65;
        ViewSpline r36 = r35.next();
        if ((r36 instanceof ViewSpline.PathRotate) == false) goto L59;
        double[] r37 = this.mInterpolateVelocity;
        if (r37.length <= 1) goto L59;
        ((ViewSpline.PathRotate) r36).setPathRotate(r21, r17, r37[0], r37[1]);
    L65:
        if (r29 == null) goto L68;
        double[] r38 = this.mInterpolateVelocity;
        r110 = r110 | r29.setPathRotate(r21, r25, r17, r23, r38[0], r38[1]);
    L68:
        int r112 = r111;
    L69:
        CurveFit[] r39 = this.mSpline;
        if (r112 >= r39.length) goto L72;
        r39[r112].getPos(r31, this.mValuesBuff);
        CustomSupport.setInterpolatedValue(this.mStartMotionPath.attributes.get(this.mAttributeNames[r112 - 1]), r21, this.mValuesBuff);
        r112 = r112 + 1;
        goto L69
    L72:
        MotionConstrainedPoint r40 = this.mStartPoint;
        if (r40.mVisibilityMode != 0) goto L84;
        if (r17 > 0.0f) goto L78;
    L76:
        r21.setVisibility(r40.visibility);
        goto L84
    L78:
        if (r17 < 1.0f) goto L81;
        r40 = this.mEndPoint;
        goto L76
    L81:
        if (this.mEndPoint.visibility == r40.visibility) goto L84;
        r21.setVisibility(0);
    L84:
        if (this.mKeyTriggers == null) goto L97;
        int r41 = 0;
    L86:
        KeyTrigger[] r42 = this.mKeyTriggers;
        if (r41 >= r42.length) goto L97;
        r42[r41].conditionallyFire(r17, r21);
        r41 = r41 + 1;
    L97:
        HashMap<String, ViewOscillator> r43 = this.mCycleMap;
        if (r43 == null) goto L106;
        Iterator<ViewOscillator> r44 = r43.values().iterator();
    L101:
        if (r44.hasNext() == false) goto L106;
        ViewOscillator r45 = r44.next();
        if ((r45 instanceof ViewOscillator.PathRotateSet) == true) goto L104;
        r45.setProperty(r21, r17);
        goto L101
    L104:
        double[] r46 = this.mInterpolateVelocity;
        ((ViewOscillator.PathRotateSet) r45).setPathRotate(r21, r17, r46[0], r46[r111]);
    L106:
        return r110;
    L46:
        if (this.mTransformPivotView != null) goto L48;
        this.mTransformPivotView = ((View) r21.getParent()).findViewById(this.mTransformPivotTarget);
    L48:
        View r47 = this.mTransformPivotView;
        if (r47 == null) goto L55;
        float r48 = (r47.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r49 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r50 = r49 - r21.getLeft();
        float r51 = r48 - r21.getTop();
        r21.setPivotX(r50);
        r21.setPivotY(r51);
        goto L55
    L89:
        r111 = 1;
        MotionPaths r52 = this.mStartMotionPath;
        float r53 = r52.f259x;
        MotionPaths r54 = this.mEndMotionPath;
        float r55 = r53 + ((r54.f259x - r53) * r17);
        float r56 = r52.f260y;
        float r57 = r56 + ((r54.f260y - r56) * r17);
        float r58 = r52.width;
        float r59 = r54.width;
        float r60 = r52.height;
        float r61 = r54.height;
        float r62 = r55 + 0.5f;
        int r113 = (int) r62;
        float r63 = r57 + 0.5f;
        int r64 = (int) r63;
        int r65 = (int) (r62 + (((r59 - r58) * r17) + r58));
        int r66 = (int) (r63 + (((r61 - r60) * r17) + r60));
        int r67 = r65 - r113;
        int r68 = r66 - r64;
        if (r59 == r58) goto L92;
    L95:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r67, 1073741824), View.MeasureSpec.makeMeasureSpec(r68, 1073741824));
        this.mForceMeasure = false;
    L96:
        r21.layout(r113, r64, r65, r66);
        goto L97
    L92:
        if (r61 != r60) goto L95;
        if (this.mForceMeasure == false) goto L96;
    L31:
        r29 = null;
        r110 = false;
        goto L32
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View r10, KeyPositionBase r11, float r12, float r13, String[] r14, float[] r15) {
        RectF r16 = new RectF();
        MotionPaths r17 = this.mStartMotionPath;
        float r18 = r17.f259x;
        r16.left = r18;
        float r19 = r17.f260y;
        r16.top = r19;
        r16.right = r18 + r17.width;
        r16.bottom = r19 + r17.height;
        RectF r20 = new RectF();
        MotionPaths r21 = this.mEndMotionPath;
        float r22 = r21.f259x;
        r20.left = r22;
        float r23 = r21.f260y;
        r20.top = r23;
        r20.right = r22 + r21.width;
        r20.bottom = r23 + r21.height;
        r11.positionAttributes(r10, r16, r20, r12, r13, r14, r15);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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

    void setBothStates(View r10) {
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

    void setEndState(Rect r10, ConstraintSet r11, int r12, int r13) {
        int r14 = r11.mRotate;
        if (r14 == 0) goto L5;
        rotate(r10, this.mTempRect, r14, r12, r13);
        r10 = this.mTempRect;
    L5:
        MotionPaths r15 = this.mEndMotionPath;
        r15.time = 1.0f;
        r15.position = 1.0f;
        readView(r15);
        this.mEndMotionPath.setBounds(r10.left, r10.top, r10.width(), r10.height());
        this.mEndMotionPath.applyParameters(r11.getParameters(this.mId));
        this.mEndPoint.setState(r10, r11, r14, this.mId);
    }

    public void setPathMotionArc(int r10) {
        this.mPathMotionArc = r10;
    }

    void setStartCurrentState(View r10) {
        MotionPaths r11 = this.mStartMotionPath;
        r11.time = 0.0f;
        r11.position = 0.0f;
        r11.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mStartPoint.setState(r10);
    }

    void setStartState(Rect r10, ConstraintSet r11, int r12, int r13) {
        int r14 = r11.mRotate;
        if (r14 == 0) goto L5;
        rotate(r10, this.mTempRect, r14, r12, r13);
    L5:
        MotionPaths r15 = this.mStartMotionPath;
        r15.time = 0.0f;
        r15.position = 0.0f;
        readView(r15);
        this.mStartMotionPath.setBounds(r10.left, r10.top, r10.width(), r10.height());
        ConstraintSet.Constraint r16 = r11.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r16);
        this.mMotionStagger = r16.motion.mMotionStagger;
        this.mStartPoint.setState(r10, r11, r14, this.mId);
        this.mTransformPivotTarget = r16.transform.transformPivotTarget;
        ConstraintSet.Motion r17 = r16.motion;
        this.mQuantizeMotionSteps = r17.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = r17.mQuantizeMotionPhase;
        Context r18 = this.mView.getContext();
        ConstraintSet.Motion r19 = r16.motion;
        this.mQuantizeMotionInterpolator = getInterpolator(r18, r19.mQuantizeInterpolatorType, r19.mQuantizeInterpolatorString, r19.mQuantizeInterpolatorID);
    }

    public void setStartState(ViewState r10, View r11, int r12, int r13, int r14) {
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

    public void setView(View r10) {
        this.mView = r10;
        this.mId = r10.getId();
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r11).getConstraintTag();
        return;
    }

    public void setup(int r18, int r19, float r20, long r21) {
        new HashSet();
        HashSet<String> r10 = new HashSet();
        HashSet<String> r11 = new HashSet();
        HashSet<String> r12 = new HashSet();
        HashMap<String, Integer> r13 = new HashMap();
        int r14 = this.mPathMotionArc;
        if (r14 == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = r14;
    L5:
        this.mStartPoint.different(this.mEndPoint, r11);
        ArrayList<Key> r15 = this.mKeyList;
        if (r15 == null) goto L27;
        Iterator<Key> r16 = r15.iterator();
        ArrayList r17 = null;
    L9:
        if (r16.hasNext() == false) goto L28;
        Key r22 = r16.next();
        if ((r22 instanceof KeyPosition) == true) goto L12;
        if ((r22 instanceof KeyCycle) == true) goto L17;
        if ((r22 instanceof KeyTimeCycle) == true) goto L20;
        if ((r22 instanceof KeyTrigger) == true) goto L23;
        r22.setInterpolation(r13);
        r22.getAttributeNames(r11);
        goto L9
    L23:
        if (r17 != null) goto L25;
        r17 = new ArrayList();
    L25:
        r17.add((KeyTrigger) r22);
        goto L9
    L20:
        r22.getAttributeNames(r10);
        goto L9
    L17:
        r22.getAttributeNames(r12);
        goto L9
    L12:
        KeyPosition r23 = (KeyPosition) r22;
        insertKey(new MotionPaths(r18, r19, r23, this.mStartMotionPath, this.mEndMotionPath));
        int r24 = r23.mCurveFit;
        if (r24 == Key.UNSET) goto L9;
        this.mCurveFitType = r24;
    L28:
        int r25 = 0;
        if (r17 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) r17.toArray(new KeyTrigger[0]);
    L31:
        char r110 = 1;
        if (r11.isEmpty() == true) goto L74;
        this.mAttributesMap = new HashMap();
        Iterator<String> r26 = r11.iterator();
    L35:
        if (r26.hasNext() == false) goto L53;
        String r111 = r26.next();
        if (r111.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r112 = new SparseArray();
        String r113 = r111.split(",")[r110];
        Iterator<Key> r114 = this.mKeyList.iterator();
    L40:
        if (r114.hasNext() == false) goto L47;
        Key r27 = r114.next();
        HashMap<String, ConstraintAttribute> r115 = r27.mCustomConstraints;
        if (r115 == null) goto L40;
        ConstraintAttribute r116 = r115.get(r113);
        if (r116 == null) goto L40;
        r112.append(r27.mFramePosition, r116);
        goto L40
    L47:
        ViewSpline r28 = ViewSpline.makeCustomSpline(r111, r112);
    L49:
        if (r28 == null) goto L52;
        r28.setType(r111);
        this.mAttributesMap.put(r111, r28);
    L52:
        r110 = 1;
        goto L35
    L48:
        r28 = ViewSpline.makeSpline(r111);
        goto L49
    L53:
        ArrayList<Key> r29 = this.mKeyList;
        if (r29 == null) goto L61;
        Iterator<Key> r30 = r29.iterator();
    L57:
        if (r30.hasNext() == false) goto L61;
        Key r31 = r30.next();
        if ((r31 instanceof KeyAttributes) == false) goto L57;
        r31.addValues(this.mAttributesMap);
    L61:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r32 = this.mAttributesMap.keySet().iterator();
    L63:
        if (r32.hasNext() == false) goto L74;
        String r33 = r32.next();
        if (r13.containsKey(r33) == false) goto L69;
        Integer r117 = r13.get(r33);
        if (r117 == null) goto L69;
        int r118 = r117.intValue();
    L70:
        ViewSpline r34 = this.mAttributesMap.get(r33);
        if (r34 == null) goto L63;
        r34.setup(r118);
    L69:
        r118 = 0;
    L74:
        if (r10.isEmpty() == false) goto L76;
    L116:
        int r35 = 2;
        int r36 = this.mMotionPaths.size() + 2;
        MotionPaths[] r37 = new MotionPaths[r36];
        r37[0] = this.mStartMotionPath;
        r37[r36 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L119;
    L121:
        Iterator<MotionPaths> r38 = this.mMotionPaths.iterator();
        int r39 = 1;
    L123:
        if (r38.hasNext() == false) goto L125;
        r37[r39] = r38.next();
        r39 = r39 + 1;
        goto L123
    L125:
        HashSet r40 = new HashSet();
        Iterator<String> r119 = this.mEndMotionPath.attributes.keySet().iterator();
    L127:
        if (r119.hasNext() == false) goto L133;
        String r120 = r119.next();
        if (this.mStartMotionPath.attributes.containsKey(r120) == false) goto L127;
        if (r11.contains("CUSTOM," + r120) == true) goto L127;
        r40.add(r120);
        goto L127
    L133:
        String[] r41 = (String[]) r40.toArray(new String[0]);
        this.mAttributeNames = r41;
        this.mAttributeInterpolatorCount = new int[r41.length];
        int r42 = 0;
    L134:
        String[] r43 = this.mAttributeNames;
        if (r42 >= r43.length) goto L146;
        String r44 = r43[r42];
        this.mAttributeInterpolatorCount[r42] = 0;
        int r121 = 0;
    L137:
        if (r121 >= r36) goto L144;
        if (r37[r121].attributes.containsKey(r44) == false) goto L143;
        ConstraintAttribute r122 = r37[r121].attributes.get(r44);
        if (r122 == null) goto L143;
        int[] r45 = this.mAttributeInterpolatorCount;
        r45[r42] = r45[r42] + r122.numberOfInterpolatedValues();
    L143:
        r121 = r121 + 1;
    L144:
        r42 = r42 + 1;
        goto L134
    L146:
        if (r37[0].mPathMotionArc == Key.UNSET) goto L148;
        boolean r46 = true;
    L149:
        int r47 = 18 + r43.length;
        boolean[] r48 = new boolean[r47];
        int r123 = 1;
    L150:
        if (r123 >= r36) goto L152;
        r37[r123].different(r37[r123 - 1], r48, this.mAttributeNames, r46);
        r123 = r123 + 1;
        goto L150
    L152:
        int r124 = 0;
        int r49 = 1;
    L153:
        if (r49 >= r47) goto L158;
        if (r48[r49] == false) goto L157;
        r124 = r124 + 1;
    L157:
        r49 = r49 + 1;
        goto L153
    L158:
        this.mInterpolateVariables = new int[r124];
        int r50 = Math.max(2, r124);
        this.mInterpolateData = new double[r50];
        this.mInterpolateVelocity = new double[r50];
        int r125 = 0;
        int r51 = 1;
    L159:
        if (r51 >= r47) goto L164;
        if (r48[r51] == false) goto L163;
        this.mInterpolateVariables[r125] = r51;
        r125 = r125 + 1;
    L163:
        r51 = r51 + 1;
        goto L159
    L164:
        double[][] r52 = (double[][]) Array.newInstance(double.class, new int[]{r36, this.mInterpolateVariables.length});
        double[] r53 = new double[r36];
        int r54 = 0;
    L165:
        if (r54 >= r36) goto L167;
        r37[r54].fillStandard(r52[r54], this.mInterpolateVariables);
        r53[r54] = r37[r54].time;
        r54 = r54 + 1;
        goto L165
    L167:
        int r55 = 0;
    L168:
        int[] r126 = this.mInterpolateVariables;
        if (r55 >= r126.length) goto L176;
        if (r126[r55] >= MotionPaths.names.length) goto L175;
        String r127 = MotionPaths.names[this.mInterpolateVariables[r55]] + " [";
        int r128 = 0;
    L173:
        if (r128 >= r36) goto L175;
        r127 = r127 + r52[r128][r55];
        r128 = r128 + 1;
    L175:
        r55 = r55 + 1;
        goto L168
    L176:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r56 = 0;
    L177:
        String[] r129 = this.mAttributeNames;
        if (r56 >= r129.length) goto L188;
        String r130 = r129[r56];
        int r131 = r25;
        int r132 = r131;
        double[] r133 = null;
        double[][] r134 = null;
    L180:
        if (r131 >= r36) goto L187;
        if (r37[r131].hasCustomData(r130) == false) goto L186;
        if (r134 != null) goto L185;
        r133 = new double[r36];
        int[] r135 = new int[r35];
        r135[1] = r37[r131].getCustomDataCount(r130);
        r135[r25] = r36;
        r134 = (double[][]) Array.newInstance(double.class, r135);
    L185:
        r133[r132] = r37[r131].time;
        r37[r131].getCustomData(r130, r134[r132], 0);
        r132 = r132 + 1;
    L186:
        r131 = r131 + 1;
        r35 = 2;
        r25 = 0;
        goto L180
    L187:
        r56 = r56 + 1;
        this.mSpline[r56] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r133, r132), (double[][]) Arrays.copyOf(r134, r132));
        r35 = 2;
        r25 = 0;
        goto L177
    L188:
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r53, r52);
        if (r37[0].mPathMotionArc == Key.UNSET) goto L194;
        int[] r57 = new int[r36];
        double[] r58 = new double[r36];
        double[][] r59 = (double[][]) Array.newInstance(double.class, new int[]{r36, 2});
        int r136 = 0;
    L191:
        if (r136 >= r36) goto L193;
        r57[r136] = r37[r136].mPathMotionArc;
        r58[r136] = r37[r136].time;
        r59[r136][0] = r37[r136].f259x;
        r59[r136][1] = r37[r136].f260y;
        r136 = r136 + 1;
        goto L191
    L193:
        this.mArcSpline = CurveFit.getArc(r57, r58, r59);
    L194:
        float r60 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L218;
        Iterator<String> r61 = r12.iterator();
    L198:
        if (r61.hasNext() == false) goto L208;
        String r62 = r61.next();
        ViewOscillator r63 = ViewOscillator.makeSpline(r62);
        if (r63 == null) goto L198;
        if (r63.variesByPath() == true) goto L205;
    L207:
        r63.setType(r62);
        this.mCycleMap.put(r62, r63);
        goto L198
    L205:
        if (Float.isNaN(r60) == false) goto L207;
        r60 = getPreCycleDistance();
        goto L207
    L208:
        Iterator<Key> r64 = this.mKeyList.iterator();
    L210:
        if (r64.hasNext() == false) goto L214;
        Key r65 = r64.next();
        if ((r65 instanceof KeyCycle) == false) goto L210;
        ((KeyCycle) r65).addCycleValues(this.mCycleMap);
        goto L210
    L214:
        Iterator<ViewOscillator> r66 = this.mCycleMap.values().iterator();
    L216:
        if (r66.hasNext() == false) goto L316;
        r66.next().setup(r60);
        goto L216
    L316:
        return;
    L218:
        return;
    L148:
        r46 = false;
        goto L149
    L119:
        if (this.mCurveFitType != (-1)) goto L121;
        this.mCurveFitType = 0;
        goto L121
    L76:
        if (this.mTimeCycleAttributesMap != null) goto L78;
        this.mTimeCycleAttributesMap = new HashMap();
    L78:
        Iterator<String> r67 = r10.iterator();
    L80:
        if (r67.hasNext() == false) goto L100;
        String r68 = r67.next();
        if (this.mTimeCycleAttributesMap.containsKey(r68) == true) goto L80;
        if (r68.startsWith("CUSTOM,") == false) goto L96;
        SparseArray r69 = new SparseArray();
        String r137 = r68.split(",")[1];
        Iterator<Key> r138 = this.mKeyList.iterator();
    L88:
        if (r138.hasNext() == false) goto L95;
        Key r139 = r138.next();
        HashMap<String, ConstraintAttribute> r140 = r139.mCustomConstraints;
        if (r140 == null) goto L88;
        ConstraintAttribute r141 = r140.get(r137);
        if (r141 == null) goto L88;
        r69.append(r139.mFramePosition, r141);
        goto L88
    L95:
        ViewTimeCycle r70 = ViewTimeCycle.makeCustomSpline(r68, r69);
    L97:
        if (r70 == null) goto L80;
        r70.setType(r68);
        this.mTimeCycleAttributesMap.put(r68, r70);
        goto L80
    L96:
        r70 = ViewTimeCycle.makeSpline(r68, r21);
        goto L97
    L100:
        ArrayList<Key> r71 = this.mKeyList;
        if (r71 == null) goto L108;
        Iterator<Key> r72 = r71.iterator();
    L104:
        if (r72.hasNext() == false) goto L108;
        Key r73 = r72.next();
        if ((r73 instanceof KeyTimeCycle) == false) goto L104;
        ((KeyTimeCycle) r73).addTimeValues(this.mTimeCycleAttributesMap);
    L108:
        Iterator<String> r74 = this.mTimeCycleAttributesMap.keySet().iterator();
    L110:
        if (r74.hasNext() == false) goto L116;
        String r75 = r74.next();
        if (r13.containsKey(r75) == false) goto L114;
        int r76 = r13.get(r75).intValue();
    L115:
        this.mTimeCycleAttributesMap.get(r75).setup(r76);
        goto L110
    L114:
        r76 = 0;
        goto L115
    L27:
        r17 = null;
        goto L28
    }

    public void setupRelative(MotionController r10) {
        this.mStartMotionPath.setupRelative(r10, r10.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r10, r10.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f259x + " y: " + this.mStartMotionPath.f260y + " end: x: " + this.mEndMotionPath.f259x + " y: " + this.mEndMotionPath.f260y;
    }
}
