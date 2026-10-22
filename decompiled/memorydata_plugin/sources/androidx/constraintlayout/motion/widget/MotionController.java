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
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    MotionController(View r5) {
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
        this.mPathMotionArc = Key.UNSET;
        this.mTransformPivotTarget = Key.UNSET;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = Key.UNSET;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(r5);
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

    private static Interpolator getInterpolator(Context r2, int r3, String r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 == (-2)) goto L30;
        if (r3 == (-1)) goto L27;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L24;
        if (r3 == 2) goto L22;
        if (r3 == 4) goto L20;
        if (r3 == 5) goto L18;
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
        final Easing r7 = Easing.getInterpolator(r4);
        return new AnonymousClass1(r7);
    L30:
        return AnimationUtils.loadInterpolator(r6, r5);
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

    private void insertKey(MotionPaths r4) {
        int r0 = Collections.binarySearch(this.mMotionPaths, r4);
        if (r0 != 0) goto L5;
        Log.e(TAG, " KeyPath position \"" + r4.position + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r0) - 1, r4);
    }

    private void readView(MotionPaths r4) {
        r4.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key r1) {
        this.mKeyList.add(r1);
    }

    void addKeys(ArrayList<Key> r1) {
        this.mKeyList.addAll(r1);
    }

    void buildBounds(float[] r18, int r19) {
        float r2 = 1.0f / (r19 - 1);
        HashMap<String, ViewSpline> r4 = this.mAttributesMap;
        if (r4 == null) goto L6;
        SplineSet r5 = (SplineSet) ZeusTransformUtils.preCheckCast(r4.get("translationX"), SplineSet.class, "com.obric.memorydata.plugin");
    L6:
        HashMap<String, ViewSpline> r6 = this.mAttributesMap;
        if (r6 == null) goto L10;
        SplineSet r7 = (SplineSet) ZeusTransformUtils.preCheckCast(r6.get("translationY"), SplineSet.class, "com.obric.memorydata.plugin");
    L10:
        HashMap<String, ViewOscillator> r8 = this.mCycleMap;
        if (r8 == null) goto L14;
        ViewOscillator r9 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r8.get("translationX"), ViewOscillator.class, "com.obric.memorydata.plugin");
    L14:
        HashMap<String, ViewOscillator> r10 = this.mCycleMap;
        if (r10 == null) goto L18;
        ViewOscillator r11 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r10.get("translationY"), ViewOscillator.class, "com.obric.memorydata.plugin");
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

    int buildKeyFrames(float[] r11, int[] r12) {
        if (r11 == null) goto L16;
        double[] r1 = this.mSpline[0].getTimePoints();
        if (r12 == null) goto L10;
        Iterator<MotionPaths> r2 = this.mMotionPaths.iterator();
        int r3 = 0;
    L8:
        if (r2.hasNext() == false) goto L10;
        r12[r3] = ((MotionPaths) ZeusTransformUtils.preCheckCast(r2.next(), MotionPaths.class, "com.obric.memorydata.plugin")).mMode;
        r3 = r3 + 1;
    L10:
        int r13 = 0;
        int r9 = 0;
    L12:
        if (r13 >= r1.length) goto L15;
        this.mSpline[0].getPos(r1[r13], this.mInterpolateData);
        this.mStartMotionPath.getCenter(r1[r13], this.mInterpolateVariables, this.mInterpolateData, r11, r9);
        r9 = r9 + 2;
        r13 = r13 + 1;
        goto L12
    L15:
        return r9 / 2;
    L16:
        return 0;
    }

    void buildPath(float[] r22, int r23) {
        MotionController r0 = this;
        float r9 = 1.0f;
        float r10 = 1.0f / (r23 - 1);
        HashMap<String, ViewSpline> r1 = r0.mAttributesMap;
        ViewOscillator r3 = null;
        if (r1 != null) goto L5;
        SplineSet r12 = null;
    L6:
        HashMap<String, ViewSpline> r2 = r0.mAttributesMap;
        if (r2 != null) goto L9;
        SplineSet r13 = null;
    L10:
        HashMap<String, ViewOscillator> r4 = r0.mCycleMap;
        if (r4 != null) goto L13;
        ViewOscillator r14 = null;
    L14:
        HashMap<String, ViewOscillator> r5 = r0.mCycleMap;
        if (r5 == null) goto L18;
        r3 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r5.get("translationY"), ViewOscillator.class, "com.obric.memorydata.plugin");
    L18:
        ViewOscillator r15 = r3;
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
        r14 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r4.get("translationX"), ViewOscillator.class, "com.obric.memorydata.plugin");
        goto L14
    L9:
        r13 = (SplineSet) ZeusTransformUtils.preCheckCast(r2.get("translationY"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L10
    L5:
        r12 = (SplineSet) ZeusTransformUtils.preCheckCast(r1.get("translationX"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L6
    }

    void buildRect(float r4, float[] r5, int r6) {
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

    void endTrigger(boolean r5) {
        if ("button".equals(Debug.getName(this.mView)) == true) goto L5;
        return;
    L5:
        if (this.mKeyTriggers == null) goto L18;
        int r0 = 0;
    L7:
        KeyTrigger[] r1 = this.mKeyTriggers;
        if (r0 >= r1.length) goto L19;
        KeyTrigger r2 = r1[r0];
        if (r5 == false) goto L12;
        float r3 = -100.0f;
    L13:
        r2.conditionallyFire(r3, this.mView);
        r0 = r0 + 1;
        goto L7
    L12:
        r3 = 100.0f;
        goto L13
    L19:
        return;
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

    MotionPaths getKeyFrame(int r2) {
        return (MotionPaths) ZeusTransformUtils.preCheckCast(this.mMotionPaths.get(r2), MotionPaths.class, "com.obric.memorydata.plugin");
    }

    public int getKeyFrameInfo(int r19, int[] r20) {
        float[] r2 = new float[2];
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Key r15 = (Key) ZeusTransformUtils.preCheckCast(r10.next(), Key.class, "com.obric.memorydata.plugin");
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
        if (ZeusTransformUtils.instanceOf(r15, KeyPosition.class) == false) goto L13;
        KeyPosition r4 = (KeyPosition) ZeusTransformUtils.preCheckCast(r15, KeyPosition.class, "com.obric.memorydata.plugin");
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
        Iterator<Key> r0 = this.mKeyList.iterator();
        int r2 = 0;
        int r10 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        Key r3 = (Key) ZeusTransformUtils.preCheckCast(r0.next(), Key.class, "com.obric.memorydata.plugin");
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

    KeyPositionBase getPositionKeyframe(int r12, int r13, float r14, float r15) {
        RectF r7 = new RectF();
        r7.left = this.mStartMotionPath.x;
        r7.top = this.mStartMotionPath.y;
        r7.right = r7.left + this.mStartMotionPath.width;
        r7.bottom = r7.top + this.mStartMotionPath.height;
        RectF r8 = new RectF();
        r8.left = this.mEndMotionPath.x;
        r8.top = this.mEndMotionPath.y;
        r8.right = r8.left + this.mEndMotionPath.width;
        r8.bottom = r8.top + this.mEndMotionPath.height;
        Iterator<Key> r11 = this.mKeyList.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        Key r10 = (Key) ZeusTransformUtils.preCheckCast(r11.next(), Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, KeyPositionBase.class) == false) goto L4;
        if (((KeyPositionBase) ZeusTransformUtils.preCheckCast(r10, KeyPositionBase.class, "com.obric.memorydata.plugin")).intersects(r12, r13, r7, r8, r14, r15) == false) goto L4;
        return (KeyPositionBase) ZeusTransformUtils.preCheckCast(r10, KeyPositionBase.class, "com.obric.memorydata.plugin");
    L11:
        return null;
    }

    void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r1 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, ViewSpline> r2 = this.mAttributesMap;
        ViewOscillator r4 = null;
        if (r2 != null) goto L5;
        SplineSet r3 = null;
    L6:
        HashMap<String, ViewSpline> r6 = this.mAttributesMap;
        if (r6 != null) goto L9;
        SplineSet r7 = null;
    L10:
        HashMap<String, ViewSpline> r8 = this.mAttributesMap;
        if (r8 != null) goto L13;
        SplineSet r9 = null;
    L14:
        HashMap<String, ViewSpline> r10 = this.mAttributesMap;
        if (r10 != null) goto L17;
        SplineSet r11 = null;
    L18:
        HashMap<String, ViewSpline> r12 = this.mAttributesMap;
        if (r12 != null) goto L21;
        SplineSet r13 = null;
    L22:
        HashMap<String, ViewOscillator> r14 = this.mCycleMap;
        if (r14 != null) goto L25;
        ViewOscillator r5 = null;
    L26:
        HashMap<String, ViewOscillator> r15 = this.mCycleMap;
        if (r15 != null) goto L29;
        ViewOscillator r16 = null;
    L30:
        HashMap<String, ViewOscillator> r17 = this.mCycleMap;
        if (r17 != null) goto L33;
        ViewOscillator r18 = null;
    L34:
        HashMap<String, ViewOscillator> r110 = this.mCycleMap;
        if (r110 != null) goto L37;
        ViewOscillator r111 = null;
    L38:
        HashMap<String, ViewOscillator> r112 = this.mCycleMap;
        if (r112 == null) goto L42;
        r4 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r112.get("scaleY"), ViewOscillator.class, "com.obric.memorydata.plugin");
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
        ViewOscillator r116 = r4;
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
        r111 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r110.get("scaleX"), ViewOscillator.class, "com.obric.memorydata.plugin");
        goto L38
    L33:
        r18 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r17.get(Key.ROTATION), ViewOscillator.class, "com.obric.memorydata.plugin");
        goto L34
    L29:
        r16 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r15.get("translationY"), ViewOscillator.class, "com.obric.memorydata.plugin");
        goto L30
    L25:
        r5 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r14.get("translationX"), ViewOscillator.class, "com.obric.memorydata.plugin");
        goto L26
    L21:
        r13 = (SplineSet) ZeusTransformUtils.preCheckCast(r12.get("scaleY"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L22
    L17:
        r11 = (SplineSet) ZeusTransformUtils.preCheckCast(r10.get("scaleX"), SplineSet.class, "com.obric.memorydata.plugin");
        goto L18
    L13:
        r9 = (SplineSet) ZeusTransformUtils.preCheckCast(r8.get(Key.ROTATION), SplineSet.class, "com.obric.memorydata.plugin");
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

    public View getView() {
        return this.mView;
    }

    boolean interpolate(View r21, float r22, long r23, KeyCache r25) {
        float r2 = getAdjustedPosition(r22, null);
        if (this.mQuantizeMotionSteps == Key.UNSET) goto L15;
        float r3 = 1.0f / this.mQuantizeMotionSteps;
        float r4 = ((float) Math.floor(r2 / r3)) * r3;
        float r5 = (r2 % r3) / r3;
        if (Float.isNaN(this.mQuantizeMotionPhase) == true) goto L7;
        r5 = (r5 + this.mQuantizeMotionPhase) % 1.0f;
    L7:
        Interpolator r6 = this.mQuantizeMotionInterpolator;
        if (r6 == null) goto L11;
        float r7 = r6.getInterpolation(r5);
    L14:
        r2 = (r7 * r3) + r4;
        goto L15
    L11:
        if (r5 <= 0.5d) goto L13;
        r7 = 1.0f;
        goto L14
    L13:
        r7 = 0.0f;
    L15:
        float r14 = r2;
        HashMap<String, ViewSpline> r8 = this.mAttributesMap;
        if (r8 == null) goto L21;
        Iterator<ViewSpline> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((ViewSpline) ZeusTransformUtils.preCheckCast(r9.next(), ViewSpline.class, "com.obric.memorydata.plugin")).setProperty(r21, r14);
    L21:
        HashMap<String, ViewTimeCycle> r10 = this.mTimeCycleAttributesMap;
        if (r10 == null) goto L31;
        Iterator<ViewTimeCycle> r11 = r10.values().iterator();
        ViewTimeCycle.PathRotate r12 = null;
        boolean r13 = false;
    L25:
        if (r11.hasNext() == false) goto L30;
        ViewTimeCycle r1 = (ViewTimeCycle) ZeusTransformUtils.preCheckCast(r11.next(), ViewTimeCycle.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, ViewTimeCycle.PathRotate.class) == true) goto L28;
        r13 = r13 | r1.setProperty(r21, r14, r23, r25);
        goto L25
    L28:
        r12 = (ViewTimeCycle.PathRotate) ZeusTransformUtils.preCheckCast(r1, ViewTimeCycle.PathRotate.class, "com.obric.memorydata.plugin");
        goto L25
    L30:
        boolean r16 = r13;
        ViewTimeCycle.PathRotate r15 = r12;
    L32:
        CurveFit[] r17 = this.mSpline;
        if (r17 == null) goto L93;
        double r18 = r14;
        r17[0].getPos(r18, this.mInterpolateData);
        this.mSpline[0].getSlope(r18, this.mInterpolateVelocity);
        CurveFit r19 = this.mArcSpline;
        if (r19 == null) goto L40;
        double[] r20 = this.mInterpolateData;
        if (r20.length <= 0) goto L40;
        r19.getPos(r18, r20);
        this.mArcSpline.getSlope(r18, this.mInterpolateVelocity);
    L40:
        if (this.mNoMovement == true) goto L44;
        this.mStartMotionPath.setView(r14, r21, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null, this.mForceMeasure);
        this.mForceMeasure = false;
    L44:
        if (this.mTransformPivotTarget != Key.UNSET) goto L46;
    L55:
        HashMap<String, ViewSpline> r24 = this.mAttributesMap;
        if (r24 == null) goto L67;
        Iterator<ViewSpline> r26 = r24.values().iterator();
    L59:
        if (r26.hasNext() == false) goto L67;
        SplineSet r27 = (SplineSet) ZeusTransformUtils.preCheckCast(r26.next(), SplineSet.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, ViewSpline.PathRotate.class) == false) goto L59;
        if (this.mInterpolateVelocity.length <= 1) goto L59;
        ViewSpline.PathRotate r28 = (ViewSpline.PathRotate) ZeusTransformUtils.preCheckCast(r27, ViewSpline.PathRotate.class, "com.obric.memorydata.plugin");
        double[] r29 = this.mInterpolateVelocity;
        r28.setPathRotate(r21, r14, r29[0], r29[1]);
    L67:
        char r110 = 1;
        if (r15 == null) goto L70;
        double[] r30 = this.mInterpolateVelocity;
        r16 = r16 | r15.setPathRotate(r21, r25, r14, r23, r30[0], r30[1]);
    L70:
        int r31 = 1;
    L71:
        CurveFit[] r32 = this.mSpline;
        if (r31 >= r32.length) goto L75;
        r32[r31].getPos(r18, this.mValuesBuff);
        CustomSupport.setInterpolatedValue((ConstraintAttribute) ZeusTransformUtils.preCheckCast(this.mStartMotionPath.attributes.get(this.mAttributeNames[r31 - 1]), ConstraintAttribute.class, "com.obric.memorydata.plugin"), r21, this.mValuesBuff);
        r31 = r31 + 1;
        goto L71
    L75:
        if (this.mStartPoint.mVisibilityMode == 0) goto L77;
    L86:
        int r33 = 0;
    L88:
        if (this.mKeyTriggers == null) goto L101;
        int r34 = r33;
    L90:
        KeyTrigger[] r35 = this.mKeyTriggers;
        if (r34 >= r35.length) goto L101;
        r35[r34].conditionallyFire(r14, r21);
        r34 = r34 + 1;
    L101:
        HashMap<String, ViewOscillator> r36 = this.mCycleMap;
        if (r36 == null) goto L110;
        Iterator<ViewOscillator> r37 = r36.values().iterator();
    L105:
        if (r37.hasNext() == false) goto L110;
        ViewOscillator r38 = (ViewOscillator) ZeusTransformUtils.preCheckCast(r37.next(), ViewOscillator.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r38, ViewOscillator.PathRotateSet.class) == true) goto L108;
        r38.setProperty(r21, r14);
        goto L105
    L108:
        ViewOscillator.PathRotateSet r39 = (ViewOscillator.PathRotateSet) ZeusTransformUtils.preCheckCast(r38, ViewOscillator.PathRotateSet.class, "com.obric.memorydata.plugin");
        double[] r40 = this.mInterpolateVelocity;
        r39.setPathRotate(r21, r14, r40[r33], r40[r110]);
    L110:
        return r16;
    L77:
        if (r14 > 0.0f) goto L81;
        MotionConstrainedPoint r41 = this.mStartPoint;
    L79:
        r21.setVisibility(r41.visibility);
        goto L86
    L81:
        if (r14 < 1.0f) goto L84;
        r41 = this.mEndPoint;
        goto L79
    L84:
        if (this.mEndPoint.visibility == this.mStartPoint.visibility) goto L86;
        r33 = 0;
        r21.setVisibility(0);
        goto L88
    L46:
        if (this.mTransformPivotView != null) goto L48;
        this.mTransformPivotView = ((View) ZeusTransformUtils.preCheckCast(r21.getParent(), View.class, "com.obric.memorydata.plugin")).findViewById(this.mTransformPivotTarget);
    L48:
        View r42 = this.mTransformPivotView;
        if (r42 == null) goto L55;
        float r43 = (r42.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
        float r44 = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
        if ((r21.getRight() - r21.getLeft()) <= 0) goto L55;
        if ((r21.getBottom() - r21.getTop()) <= 0) goto L55;
        float r45 = r44 - r21.getLeft();
        float r46 = r43 - r21.getTop();
        r21.setPivotX(r45);
        r21.setPivotY(r46);
        goto L55
    L93:
        r110 = 1;
        r33 = 0;
        float r47 = this.mStartMotionPath.x + ((this.mEndMotionPath.x - this.mStartMotionPath.x) * r14);
        float r48 = this.mStartMotionPath.y + ((this.mEndMotionPath.y - this.mStartMotionPath.y) * r14);
        float r49 = this.mStartMotionPath.width + ((this.mEndMotionPath.width - this.mStartMotionPath.width) * r14);
        float r50 = r47 + 0.5f;
        int r51 = (int) r50;
        float r52 = r48 + 0.5f;
        int r53 = (int) r52;
        int r54 = (int) (r50 + r49);
        int r55 = (int) (r52 + (this.mStartMotionPath.height + ((this.mEndMotionPath.height - this.mStartMotionPath.height) * r14)));
        int r56 = r54 - r51;
        int r57 = r55 - r53;
        if (this.mEndMotionPath.width == this.mStartMotionPath.width) goto L96;
    L99:
        r21.measure(View.MeasureSpec.makeMeasureSpec(r56, 1073741824), View.MeasureSpec.makeMeasureSpec(r57, 1073741824));
        this.mForceMeasure = false;
    L100:
        r21.layout(r51, r53, r54, r55);
        goto L101
    L96:
        if (this.mEndMotionPath.height != this.mStartMotionPath.height) goto L99;
        if (this.mForceMeasure == false) goto L100;
    L31:
        r15 = null;
        r16 = false;
        goto L32
    }

    String name() {
        return ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View r9, KeyPositionBase r10, float r11, float r12, String[] r13, float[] r14) {
        RectF r2 = new RectF();
        r2.left = this.mStartMotionPath.x;
        r2.top = this.mStartMotionPath.y;
        r2.right = r2.left + this.mStartMotionPath.width;
        r2.bottom = r2.top + this.mStartMotionPath.height;
        RectF r3 = new RectF();
        r3.left = this.mEndMotionPath.x;
        r3.top = this.mEndMotionPath.y;
        r3.right = r3.left + this.mEndMotionPath.width;
        r3.bottom = r3.top + this.mEndMotionPath.height;
        r10.positionAttributes(r9, r2, r3, r11, r12, r13, r14);
    }

    public void remeasure() {
        this.mForceMeasure = true;
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

    void setBothStates(View r6) {
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

    void setEndState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
        r8 = this.mTempRect;
    L5:
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        this.mEndMotionPath.applyParameters(r9.getParameters(this.mId));
        this.mEndPoint.setState(r8, r9, r6, this.mId);
    }

    public void setPathMotionArc(int r1) {
        this.mPathMotionArc = r1;
    }

    void setStartCurrentState(View r6) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(r6.getX(), r6.getY(), r6.getWidth(), r6.getHeight());
        this.mStartPoint.setState(r6);
    }

    void setStartState(Rect r8, ConstraintSet r9, int r10, int r11) {
        int r6 = r9.mRotate;
        if (r6 == 0) goto L5;
        rotate(r8, this.mTempRect, r6, r10, r11);
    L5:
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(r8.left, r8.top, r8.width(), r8.height());
        ConstraintSet.Constraint r12 = r9.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r12);
        this.mMotionStagger = r12.motion.mMotionStagger;
        this.mStartPoint.setState(r8, r9, r6, this.mId);
        this.mTransformPivotTarget = r12.transform.transformPivotTarget;
        this.mQuantizeMotionSteps = r12.motion.mQuantizeMotionSteps;
        this.mQuantizeMotionPhase = r12.motion.mQuantizeMotionPhase;
        this.mQuantizeMotionInterpolator = getInterpolator((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mView.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r12.motion.mQuantizeInterpolatorType, r12.motion.mQuantizeInterpolatorString, r12.motion.mQuantizeInterpolatorID);
    }

    public void setStartState(ViewState r5, View r6, int r7, int r8, int r9) {
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

    public void setView(View r3) {
        this.mView = r3;
        this.mId = r3.getId();
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r4, ConstraintLayout.LayoutParams.class) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ConstraintLayout.LayoutParams.class, "com.obric.memorydata.plugin")).getConstraintTag();
        return;
    }

    public void setup(int r20, int r21, float r22, long r23) {
        new HashSet();
        HashSet<String> r2 = new HashSet();
        HashSet<String> r3 = new HashSet();
        HashSet<String> r4 = new HashSet();
        HashMap<String, Integer> r5 = new HashMap();
        if (this.mPathMotionArc == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
    L5:
        this.mStartPoint.different(this.mEndPoint, r3);
        ArrayList<Key> r6 = this.mKeyList;
        if (r6 == null) goto L27;
        Iterator<Key> r7 = r6.iterator();
        ArrayList r9 = null;
    L9:
        if (r7.hasNext() == false) goto L29;
        Key r10 = (Key) ZeusTransformUtils.preCheckCast(r7.next(), Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, KeyPosition.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r10, KeyCycle.class) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, KeyTimeCycle.class) == true) goto L20;
        if (ZeusTransformUtils.instanceOf(r10, KeyTrigger.class) == true) goto L23;
        r10.setInterpolation(r5);
        r10.getAttributeNames(r3);
        goto L9
    L23:
        if (r9 != null) goto L25;
        r9 = new ArrayList();
    L25:
        r9.add((KeyTrigger) ZeusTransformUtils.preCheckCast(r10, KeyTrigger.class, "com.obric.memorydata.plugin"));
        goto L9
    L20:
        r10.getAttributeNames(r2);
        goto L9
    L17:
        r10.getAttributeNames(r4);
        goto L9
    L12:
        KeyPosition r11 = (KeyPosition) ZeusTransformUtils.preCheckCast(r10, KeyPosition.class, "com.obric.memorydata.plugin");
        insertKey(new MotionPaths(r20, r21, r11, this.mStartMotionPath, this.mEndMotionPath));
        if (r11.mCurveFit == Key.UNSET) goto L9;
        this.mCurveFitType = r11.mCurveFit;
    L29:
        if (r9 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) ZeusTransformUtils.preCheckCast(r9.toArray(new KeyTrigger[0]), KeyTrigger[].class, "com.obric.memorydata.plugin");
    L31:
        char r12 = 1;
        if (r3.isEmpty() == true) goto L75;
        this.mAttributesMap = new HashMap();
        Iterator<String> r8 = r3.iterator();
    L35:
        if (r8.hasNext() == false) goto L54;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r13.startsWith("CUSTOM,") == false) goto L49;
        SparseArray r14 = new SparseArray();
        String r15 = r13.split(",")[r12];
        Iterator<Key> r16 = this.mKeyList.iterator();
    L40:
        if (r16.hasNext() == false) goto L48;
        Key r17 = (Key) ZeusTransformUtils.preCheckCast(r16.next(), Key.class, "com.obric.memorydata.plugin");
        if (r17.mCustomConstraints == null) goto L40;
        Iterator<String> r18 = r8;
        ConstraintAttribute r19 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r17.mCustomConstraints.get(r15), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L47;
        r14.append(r17.mFramePosition, r19);
    L47:
        r8 = r18;
        goto L40
    L48:
        Iterator<String> r110 = r8;
        ViewSpline r24 = ViewSpline.makeCustomSpline(r13, r14);
    L50:
        if (r24 == null) goto L53;
        r24.setType(r13);
        this.mAttributesMap.put(r13, r24);
    L53:
        r8 = r110;
        r12 = 1;
        goto L35
    L49:
        r110 = r8;
        r24 = ViewSpline.makeSpline(r13);
        goto L50
    L54:
        ArrayList<Key> r25 = this.mKeyList;
        if (r25 == null) goto L62;
        Iterator<Key> r26 = r25.iterator();
    L58:
        if (r26.hasNext() == false) goto L62;
        Key r27 = (Key) ZeusTransformUtils.preCheckCast(r26.next(), Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r27, KeyAttributes.class) == false) goto L58;
        r27.addValues(this.mAttributesMap);
    L62:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r28 = this.mAttributesMap.keySet().iterator();
    L64:
        if (r28.hasNext() == false) goto L75;
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.containsKey(r29) == false) goto L70;
        Integer r111 = (Integer) ZeusTransformUtils.preCheckCast(r5.get(r29), Integer.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L70;
        int r112 = r111.intValue();
    L71:
        SplineSet r30 = (SplineSet) ZeusTransformUtils.preCheckCast(this.mAttributesMap.get(r29), SplineSet.class, "com.obric.memorydata.plugin");
        if (r30 == null) goto L64;
        r30.setup(r112);
    L70:
        r112 = 0;
    L75:
        if (r2.isEmpty() == false) goto L77;
    L117:
        int r31 = 2;
        int r32 = this.mMotionPaths.size() + 2;
        MotionPaths[] r33 = new MotionPaths[r32];
        r33[0] = this.mStartMotionPath;
        r33[r32 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L120;
    L122:
        Iterator<MotionPaths> r34 = this.mMotionPaths.iterator();
        int r35 = 1;
    L124:
        if (r34.hasNext() == false) goto L126;
        r33[r35] = (MotionPaths) ZeusTransformUtils.preCheckCast(r34.next(), MotionPaths.class, "com.obric.memorydata.plugin");
        r35 = r35 + 1;
        goto L124
    L126:
        HashSet r36 = new HashSet();
        Iterator<String> r113 = this.mEndMotionPath.attributes.keySet().iterator();
    L128:
        if (r113.hasNext() == false) goto L134;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mStartMotionPath.attributes.containsKey(r114) == false) goto L128;
        if (r3.contains("CUSTOM," + r114) == true) goto L128;
        r36.add(r114);
        goto L128
    L134:
        String[] r37 = (String[]) ZeusTransformUtils.preCheckCast(r36.toArray(new String[0]), String[].class, "com.obric.memorydata.plugin");
        this.mAttributeNames = r37;
        this.mAttributeInterpolatorCount = new int[r37.length];
        int r38 = 0;
    L135:
        String[] r39 = this.mAttributeNames;
        if (r38 >= r39.length) goto L147;
        String r40 = r39[r38];
        this.mAttributeInterpolatorCount[r38] = 0;
        int r115 = 0;
    L138:
        if (r115 >= r32) goto L145;
        if (r33[r115].attributes.containsKey(r40) == false) goto L144;
        ConstraintAttribute r116 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r33[r115].attributes.get(r40), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L144;
        int[] r41 = this.mAttributeInterpolatorCount;
        r41[r38] = r41[r38] + r116.numberOfInterpolatedValues();
    L144:
        r115 = r115 + 1;
    L145:
        r38 = r38 + 1;
        goto L135
    L147:
        if (r33[0].mPathMotionArc == Key.UNSET) goto L149;
        boolean r42 = true;
    L150:
        int r43 = 18 + this.mAttributeNames.length;
        boolean[] r44 = new boolean[r43];
        int r117 = 1;
    L151:
        if (r117 >= r32) goto L153;
        r33[r117].different(r33[r117 - 1], r44, this.mAttributeNames, r42);
        r117 = r117 + 1;
        goto L151
    L153:
        int r45 = 1;
        int r118 = 0;
    L154:
        if (r45 >= r43) goto L159;
        if (r44[r45] == false) goto L158;
        r118 = r118 + 1;
    L158:
        r45 = r45 + 1;
        goto L154
    L159:
        this.mInterpolateVariables = new int[r118];
        int r46 = Math.max(2, r118);
        this.mInterpolateData = new double[r46];
        this.mInterpolateVelocity = new double[r46];
        int r47 = 1;
        int r119 = 0;
    L160:
        if (r47 >= r43) goto L165;
        if (r44[r47] == false) goto L164;
        this.mInterpolateVariables[r119] = r47;
        r119 = r119 + 1;
    L164:
        r47 = r47 + 1;
        goto L160
    L165:
        double[][] r48 = (double[][]) Array.newInstance(double.class, new int[]{r32, this.mInterpolateVariables.length});
        double[] r49 = new double[r32];
        int r50 = 0;
    L166:
        if (r50 >= r32) goto L168;
        r33[r50].fillStandard(r48[r50], this.mInterpolateVariables);
        r49[r50] = r33[r50].time;
        r50 = r50 + 1;
        goto L166
    L168:
        int r51 = 0;
    L169:
        int[] r120 = this.mInterpolateVariables;
        if (r51 >= r120.length) goto L177;
        if (r120[r51] >= MotionPaths.names.length) goto L176;
        String r121 = MotionPaths.names[this.mInterpolateVariables[r51]] + " [";
        int r122 = 0;
    L174:
        if (r122 >= r32) goto L176;
        r121 = r121 + r48[r122][r51];
        r122 = r122 + 1;
    L176:
        r51 = r51 + 1;
        goto L169
    L177:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r52 = 0;
    L178:
        String[] r123 = this.mAttributeNames;
        if (r52 >= r123.length) goto L191;
        String r124 = r123[r52];
        int r125 = 0;
        int r126 = 0;
        double[] r127 = null;
        double[][] r128 = null;
    L181:
        if (r125 >= r32) goto L190;
        if (r33[r125].hasCustomData(r124) == false) goto L189;
        if (r128 != null) goto L186;
        r127 = new double[r32];
        int[] r129 = new int[r31];
        r129[1] = r33[r125].getCustomDataCount(r124);
        r129[0] = r32;
        double[][] r130 = (double[][]) Array.newInstance(double.class, r129);
        int r131 = 0;
        r128 = r130;
    L187:
        r127[r126] = r33[r125].time;
        r33[r125].getCustomData(r124, r128[r126], r131);
        r126 = r126 + 1;
        goto L189
    L186:
        r131 = 0;
    L189:
        r125 = r125 + 1;
        r4 = r4;
        r31 = 2;
        goto L181
    L190:
        r52 = r52 + 1;
        this.mSpline[r52] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r127, r126), (double[][]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r128, r126), double[][].class, "com.obric.memorydata.plugin"));
        r4 = r4;
        r31 = 2;
        goto L178
    L191:
        HashSet<String> r132 = r4;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r49, r48);
        if (r33[0].mPathMotionArc == Key.UNSET) goto L197;
        int[] r53 = new int[r32];
        double[] r54 = new double[r32];
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r32, 2});
        int r133 = 0;
    L194:
        if (r133 >= r32) goto L196;
        r53[r133] = r33[r133].mPathMotionArc;
        r54[r133] = r33[r133].time;
        r1[r133][0] = r33[r133].x;
        r1[r133][1] = r33[r133].y;
        r133 = r133 + 1;
        goto L194
    L196:
        this.mArcSpline = CurveFit.getArc(r53, r54, r1);
    L197:
        float r55 = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L221;
        Iterator<String> r56 = r132.iterator();
    L201:
        if (r56.hasNext() == false) goto L211;
        String r57 = (String) ZeusTransformUtils.preCheckCast(r56.next(), String.class, "com.obric.memorydata.plugin");
        ViewOscillator r58 = ViewOscillator.makeSpline(r57);
        if (r58 == null) goto L201;
        if (r58.variesByPath() == true) goto L208;
    L210:
        r58.setType(r57);
        this.mCycleMap.put(r57, r58);
        goto L201
    L208:
        if (Float.isNaN(r55) == false) goto L210;
        r55 = getPreCycleDistance();
        goto L210
    L211:
        Iterator<Key> r59 = this.mKeyList.iterator();
    L213:
        if (r59.hasNext() == false) goto L217;
        Key r60 = (Key) ZeusTransformUtils.preCheckCast(r59.next(), Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r60, KeyCycle.class) == false) goto L213;
        ((KeyCycle) ZeusTransformUtils.preCheckCast(r60, KeyCycle.class, "com.obric.memorydata.plugin")).addCycleValues(this.mCycleMap);
        goto L213
    L217:
        Iterator<ViewOscillator> r0 = this.mCycleMap.values().iterator();
    L219:
        if (r0.hasNext() == false) goto L318;
        ((ViewOscillator) ZeusTransformUtils.preCheckCast(r0.next(), ViewOscillator.class, "com.obric.memorydata.plugin")).setup(r55);
        goto L219
    L318:
        return;
    L221:
        return;
    L149:
        r42 = false;
        goto L150
    L120:
        if (this.mCurveFitType != (-1)) goto L122;
        this.mCurveFitType = 0;
        goto L122
    L77:
        if (this.mTimeCycleAttributesMap != null) goto L79;
        this.mTimeCycleAttributesMap = new HashMap();
    L79:
        Iterator<String> r61 = r2.iterator();
    L81:
        if (r61.hasNext() == false) goto L101;
        String r62 = (String) ZeusTransformUtils.preCheckCast(r61.next(), String.class, "com.obric.memorydata.plugin");
        if (this.mTimeCycleAttributesMap.containsKey(r62) == true) goto L81;
        if (r62.startsWith("CUSTOM,") == false) goto L97;
        SparseArray r63 = new SparseArray();
        String r134 = r62.split(",")[1];
        Iterator<Key> r135 = this.mKeyList.iterator();
    L89:
        if (r135.hasNext() == false) goto L96;
        Key r136 = (Key) ZeusTransformUtils.preCheckCast(r135.next(), Key.class, "com.obric.memorydata.plugin");
        if (r136.mCustomConstraints == null) goto L89;
        ConstraintAttribute r137 = (ConstraintAttribute) ZeusTransformUtils.preCheckCast(r136.mCustomConstraints.get(r134), ConstraintAttribute.class, "com.obric.memorydata.plugin");
        if (r137 == null) goto L89;
        r63.append(r136.mFramePosition, r137);
        goto L89
    L96:
        ViewTimeCycle r64 = ViewTimeCycle.makeCustomSpline(r62, r63);
    L98:
        if (r64 == null) goto L81;
        r64.setType(r62);
        this.mTimeCycleAttributesMap.put(r62, r64);
        goto L81
    L97:
        r64 = ViewTimeCycle.makeSpline(r62, r23);
        goto L98
    L101:
        ArrayList<Key> r65 = this.mKeyList;
        if (r65 == null) goto L109;
        Iterator<Key> r66 = r65.iterator();
    L105:
        if (r66.hasNext() == false) goto L109;
        Key r67 = (Key) ZeusTransformUtils.preCheckCast(r66.next(), Key.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r67, KeyTimeCycle.class) == false) goto L105;
        ((KeyTimeCycle) ZeusTransformUtils.preCheckCast(r67, KeyTimeCycle.class, "com.obric.memorydata.plugin")).addTimeValues(this.mTimeCycleAttributesMap);
    L109:
        Iterator<String> r68 = this.mTimeCycleAttributesMap.keySet().iterator();
    L111:
        if (r68.hasNext() == false) goto L117;
        String r69 = (String) ZeusTransformUtils.preCheckCast(r68.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.containsKey(r69) == false) goto L115;
        int r70 = ((Integer) ZeusTransformUtils.preCheckCast(r5.get(r69), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L116:
        ((ViewTimeCycle) ZeusTransformUtils.preCheckCast(this.mTimeCycleAttributesMap.get(r69), ViewTimeCycle.class, "com.obric.memorydata.plugin")).setup(r70);
        goto L111
    L115:
        r70 = 0;
        goto L116
    L27:
        r9 = null;
        goto L29
    }

    public void setupRelative(MotionController r3) {
        this.mStartMotionPath.setupRelative(r3, r3.mStartMotionPath);
        this.mEndMotionPath.setupRelative(r3, r3.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}
