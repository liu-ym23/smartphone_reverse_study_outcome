package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private int mPathMotionArc;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    public MotionController(View r5) {
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
        setView(r5);
    }

    private float getAdjustedPosition(float r11, float[] r12) {
        float r5 = 0.0f;
        float r10 = 1.0f;
        if (r12 == null) goto L5;
        r12[0] = 1.0f;
    L15:
        Easing r13 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r14 = this.mMotionPaths.iterator();
        float r15 = Float.NaN;
    L17:
        if (r14.hasNext() == false) goto L26;
        MotionPaths r16 = r14.next();
        Easing r17 = r16.mKeyFrameEasing;
        if (r17 == null) goto L17;
        float r18 = r16.time;
        if (r18 < r11) goto L22;
        if (Float.isNaN(r15) == false) goto L17;
        r15 = r16.time;
        goto L17
    L22:
        r13 = r17;
        r5 = r18;
        goto L17
    L26:
        if (r13 != null) goto L28;
        return r11;
    L28:
        if (Float.isNaN(r15) == true) goto L31;
        r10 = r15;
    L31:
        float r19 = r10 - r5;
        double r110 = (r11 - r5) / r19;
        float r20 = r5 + (((float) r13.get(r110)) * r19);
        if (r12 == null) goto L35;
        r12[0] = (float) r13.getDiff(r110);
    L35:
        return r20;
    L5:
        float r21 = this.mStaggerScale;
        if (r21 == 1.0d) goto L15;
        float r22 = this.mStaggerOffset;
        if (r11 >= r22) goto L11;
        r11 = 0.0f;
    L11:
        if (r11 <= r22) goto L15;
        if (r11 >= 1.0d) goto L15;
        r11 = (r11 - r22) * r21;
        goto L15
    }

    private float getPreCycleDistance() {
        float[] r5 = new float[2];
        float r10 = 1.0f / 99;
        double r11 = 0.0d;
        double r12 = 0.0d;
        int r13 = 0;
        float r14 = 0.0f;
    L4:
        if (r13 >= 100) goto L27;
        float r15 = r13 * r10;
        double r16 = r15;
        Easing r17 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r18 = this.mMotionPaths.iterator();
        float r19 = Float.NaN;
        float r110 = 0.0f;
    L7:
        if (r18.hasNext() == false) goto L17;
        MotionPaths r20 = r18.next();
        Easing r21 = r20.mKeyFrameEasing;
        float r111 = r10;
        if (r21 == null) goto L16;
        float r22 = r20.time;
        if (r22 >= r15) goto L14;
        r110 = r22;
        r17 = r21;
        goto L16
    L14:
        if (Float.isNaN(r19) == false) goto L16;
        r19 = r20.time;
    L16:
        r10 = r111;
        goto L7
    L17:
        float r112 = r10;
        if (r17 != null) goto L20;
    L23:
        this.mSpline[0].getPos(r16, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r5, 0);
        if (r13 <= 0) goto L26;
        r14 = (float) (Math.hypot(r12 - ((double) r5[1]), r11 - ((double) r5[0])) + ((double) r14));
    L26:
        r11 = r5[0];
        r12 = r5[1];
        r13 = r13 + 1;
        r10 = r112;
        goto L4
    L20:
        if (Float.isNaN(r19) == false) goto L22;
        r19 = 1.0f;
    L22:
        float r113 = r19 - r110;
        r16 = (((float) r17.get((r15 - r110) / r113)) * r113) + r110;
        goto L23
    L27:
        return r14;
    }

    private void insertKey(MotionPaths r5) {
        int r10 = Collections.binarySearch(this.mMotionPaths, r5);
        if (r10 != 0) goto L5;
        Log.e(TAG, " KeyPath positon \"" + r5.position + "\" outside of range");
    L5:
        this.mMotionPaths.add((-r10) - 1, r5);
    }

    private void readView(MotionPaths r5) {
        r5.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key r5) {
        this.mKeyList.add(r5);
    }

    public void addKeys(ArrayList<Key> r5) {
        this.mKeyList.addAll(r5);
    }

    public void buildBounds(float[] r18, int r19) {
        float r5 = 1.0f / (r19 - 1);
        HashMap<String, SplineSet> r10 = this.mAttributesMap;
        if (r10 == null) goto L6;
        SplineSet r11 = r10.get("translationX");
    L6:
        HashMap<String, SplineSet> r12 = this.mAttributesMap;
        if (r12 == null) goto L10;
        SplineSet r13 = r12.get("translationY");
    L10:
        HashMap<String, KeyCycleOscillator> r14 = this.mCycleMap;
        if (r14 == null) goto L14;
        KeyCycleOscillator r15 = r14.get("translationX");
    L14:
        HashMap<String, KeyCycleOscillator> r16 = this.mCycleMap;
        if (r16 == null) goto L18;
        KeyCycleOscillator r17 = r16.get("translationY");
    L18:
        int r20 = 0;
    L19:
        if (r20 >= r19) goto L52;
        float r21 = r20 * r5;
        float r22 = this.mStaggerScale;
        float r23 = 0.0f;
        if (r22 == 1.0f) goto L30;
        float r24 = this.mStaggerOffset;
        if (r21 >= r24) goto L26;
        r21 = 0.0f;
    L26:
        if (r21 <= r24) goto L30;
        if (r21 >= 1.0d) goto L30;
        r21 = (r21 - r24) * r22;
    L30:
        double r25 = r21;
        Easing r110 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r111 = this.mMotionPaths.iterator();
        float r112 = Float.NaN;
    L32:
        if (r111.hasNext() == false) goto L41;
        MotionPaths r113 = r111.next();
        Easing r114 = r113.mKeyFrameEasing;
        if (r114 == null) goto L32;
        float r115 = r113.time;
        if (r115 < r21) goto L37;
        if (Float.isNaN(r112) == false) goto L32;
        r112 = r113.time;
        goto L32
    L37:
        r110 = r114;
        r23 = r115;
        goto L32
    L41:
        if (r110 != null) goto L43;
    L46:
        this.mSpline[0].getPos(r25, this.mInterpolateData);
        CurveFit r26 = this.mArcSpline;
        if (r26 == null) goto L51;
        double[] r27 = this.mInterpolateData;
        if (r27.length <= 0) goto L51;
        r26.getPos(r25, r27);
    L51:
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r18, r20 * 2);
        r20 = r20 + 1;
        goto L19
    L43:
        if (Float.isNaN(r112) == false) goto L45;
        r112 = 1.0f;
    L45:
        float r116 = r112 - r23;
        r25 = (((float) r110.get((r21 - r23) / r116)) * r116) + r23;
        goto L46
    }

    public int buildKeyBounds(float[] r10, int[] r11) {
        if (r10 == null) goto L16;
        double[] r5 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r12 = this.mMotionPaths.iterator();
        int r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L10;
        r11[r13] = r12.next().mMode;
        r13 = r13 + 1;
    L10:
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r14 >= r5.length) goto L15;
        this.mSpline[0].getPos(r5[r14], this.mInterpolateData);
        this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, r10, r15);
        r15 = r15 + 2;
        r14 = r14 + 1;
        goto L12
    L15:
        return r15 / 2;
    L16:
        return 0;
    }

    public int buildKeyFrames(float[] r10, int[] r11) {
        if (r10 == null) goto L16;
        double[] r5 = this.mSpline[0].getTimePoints();
        if (r11 == null) goto L10;
        Iterator<MotionPaths> r12 = this.mMotionPaths.iterator();
        int r13 = 0;
    L8:
        if (r12.hasNext() == false) goto L10;
        r11[r13] = r12.next().mMode;
        r13 = r13 + 1;
    L10:
        int r14 = 0;
        int r15 = 0;
    L12:
        if (r14 >= r5.length) goto L15;
        this.mSpline[0].getPos(r5[r14], this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r10, r15);
        r15 = r15 + 2;
        r14 = r14 + 1;
        goto L12
    L15:
        return r15 / 2;
    L16:
        return 0;
    }

    public void buildPath(float[] r21, int r22) {
        int r5 = r22;
        float r10 = 1.0f;
        float r11 = 1.0f / (r5 - 1);
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
        int r110 = 0;
    L19:
        if (r110 >= r5) goto L62;
        float r111 = r110 * r11;
        float r112 = this.mStaggerScale;
        if (r112 == r10) goto L30;
        float r113 = this.mStaggerOffset;
        if (r111 >= r113) goto L26;
        r111 = 0.0f;
    L26:
        if (r111 <= r113) goto L30;
        if (r111 >= 1.0d) goto L30;
        r111 = (r111 - r113) * r112;
    L30:
        double r114 = r111;
        Easing r115 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> r116 = this.mMotionPaths.iterator();
        float r117 = Float.NaN;
        float r118 = 0.0f;
    L32:
        if (r116.hasNext() == false) goto L42;
        MotionPaths r20 = r116.next();
        Easing r23 = r20.mKeyFrameEasing;
        if (r23 == null) goto L32;
        float r24 = r20.time;
        if (r24 >= r111) goto L39;
        r118 = r24;
        r115 = r23;
        goto L32
    L39:
        if (Float.isNaN(r117) == false) goto L32;
        r117 = r20.time;
        goto L32
    L42:
        if (r115 != null) goto L44;
    L47:
        this.mSpline[0].getPos(r114, this.mInterpolateData);
        CurveFit r25 = this.mArcSpline;
        if (r25 == null) goto L52;
        double[] r26 = this.mInterpolateData;
        if (r26.length <= 0) goto L52;
        r25.getPos(r114, r26);
    L52:
        int r119 = r110 * 2;
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r21, r119);
        if (r18 == null) goto L55;
        r21[r119] = r18.get(r111) + r21[r119];
    L57:
        if (r13 == null) goto L59;
        int r120 = r119 + 1;
        r21[r120] = r13.get(r111) + r21[r120];
    L61:
        r110 = r110 + 1;
        r5 = r22;
        r10 = 1.0f;
        goto L19
    L59:
        if (r16 == null) goto L61;
        int r121 = r119 + 1;
        r21[r121] = r16.get(r111) + r21[r121];
        goto L61
    L55:
        if (r14 == null) goto L57;
        r21[r119] = r14.get(r111) + r21[r119];
        goto L57
    L44:
        if (Float.isNaN(r117) == false) goto L46;
        r117 = 1.0f;
    L46:
        float r122 = r117 - r118;
        r114 = (((float) r115.get((r111 - r118) / r122)) * r122) + r118;
        goto L47
    L62:
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

    public void buildRect(float r5, float[] r10, int r11) {
        this.mSpline[0].getPos(getAdjustedPosition(r5, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r10, r11);
    }

    public void buildRectangles(float[] r10, int r11) {
        float r5 = 1.0f / (r11 - 1);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mSpline[0].getPos(getAdjustedPosition(r12 * r5, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, r10, r12 * 8);
        r12 = r12 + 1;
        goto L3
    }

    public int getAttributeValues(String r5, float[] r10, int r11) {
        SplineSet r12 = this.mAttributesMap.get(r5);
        if (r12 != null) goto L6;
        return -1;
    L6:
        int r13 = 0;
    L8:
        if (r13 >= r10.length) goto L11;
        r10[r13] = r12.get(r13 / (r10.length - 1));
        r13 = r13 + 1;
        goto L8
    L11:
        return r10.length;
    }

    public void getDpDt(float r12, float r13, float r14, float[] r15) {
        float r16 = getAdjustedPosition(r12, this.mVelocity);
        CurveFit[] r5 = this.mSpline;
        int r10 = 0;
        if (r5 == null) goto L16;
        double r11 = r16;
        r5[0].getSlope(r11, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r11, this.mInterpolateData);
        float r17 = this.mVelocity[0];
    L5:
        double[] r18 = this.mInterpolateVelocity;
        if (r10 >= r18.length) goto L8;
        r18[r10] = r18[r10] * ((double) r17);
        r10 = r10 + 1;
        goto L5
    L8:
        CurveFit r19 = this.mArcSpline;
        if (r19 == null) goto L14;
        double[] r20 = this.mInterpolateData;
        if (r20.length <= 0) goto L19;
        r19.getPos(r11, r20);
        this.mArcSpline.getSlope(r11, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        return;
    L19:
        return;
    L14:
        this.mStartMotionPath.setDpDt(r13, r14, r15, this.mInterpolateVariables, r18, this.mInterpolateData);
        return;
    L16:
        MotionPaths r110 = this.mEndMotionPath;
        float r21 = r110.f435x;
        MotionPaths r111 = this.mStartMotionPath;
        float r22 = r21 - r111.f435x;
        float r23 = r110.f436y - r111.f436y;
        float r24 = r110.width - r111.width;
        float r112 = (r110.height - r111.height) + r23;
        r15[0] = ((r24 + r22) * r13) + ((1.0f - r13) * r22);
        r15[1] = (r112 * r14) + ((1.0f - r14) * r23);
    }

    public int getDrawPath() {
        int r5 = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> r10 = this.mMotionPaths.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        r5 = Math.max(r5, r10.next().mDrawPath);
        goto L4
    L7:
        return Math.max(r5, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalX() {
        return this.mEndMotionPath.f435x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f436y;
    }

    public MotionPaths getKeyFrame(int r5) {
        return this.mMotionPaths.get(r5);
    }

    public int getKeyFrameInfo(int r11, int[] r12) {
        float[] r5 = new float[2];
        Iterator<Key> r10 = this.mKeyList.iterator();
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r10.hasNext() == false) goto L14;
        Key r15 = r10.next();
        int r16 = r15.mType;
        if (r16 == r11) goto L10;
        if (r11 == (-1)) goto L4;
    L10:
        r12[r14] = 0;
        r12[r14 + 1] = r16;
        int r17 = r15.mFramePosition;
        r12[r14 + 2] = r17;
        this.mSpline[0].getPos(r17 / 100.0f, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r5, 0);
        r12[r14 + 3] = Float.floatToIntBits(r5[0]);
        int r18 = r14 + 4;
        r12[r18] = Float.floatToIntBits(r5[1]);
        if ((r15 instanceof KeyPosition) == false) goto L13;
        KeyPosition r19 = (KeyPosition) r15;
        r12[r14 + 5] = r19.mPositionType;
        r12[r14 + 6] = Float.floatToIntBits(r19.mPercentX);
        r18 = r14 + 7;
        r12[r18] = Float.floatToIntBits(r19.mPercentY);
    L13:
        int r20 = r18 + 1;
        r12[r14] = r20 - r14;
        r13 = r13 + 1;
        r14 = r20;
        goto L4
    L14:
        return r13;
    }

    public float getKeyFrameParameter(int r10, float r11, float r12) {
        MotionPaths r5 = this.mEndMotionPath;
        float r13 = r5.f435x;
        MotionPaths r14 = this.mStartMotionPath;
        float r15 = r14.f435x;
        float r16 = r13 - r15;
        float r17 = r5.f436y;
        float r18 = r14.f436y;
        float r19 = r17 - r18;
        float r20 = (r14.width / 2.0f) + r15;
        float r21 = (r14.height / 2.0f) + r18;
        float r22 = (float) Math.hypot(r16, r19);
        if (r22 >= 1.0E-7d) goto L6;
        return Float.NaN;
    L6:
        float r110 = r11 - r20;
        float r111 = r12 - r21;
        if (((float) Math.hypot(r110, r111)) != 0.0f) goto L9;
        return 0.0f;
    L9:
        float r23 = (r111 * r19) + (r110 * r16);
        if (r10 == 0) goto L33;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L29;
        if (r10 == 3) goto L27;
        if (r10 == 4) goto L25;
        if (r10 == 5) goto L23;
        return 0.0f;
    L23:
        return r111 / r19;
    L25:
        return r110 / r19;
    L27:
        return r111 / r16;
    L29:
        return r110 / r16;
    L31:
        return (float) Math.sqrt((r22 * r22) - (r23 * r23));
    L33:
        return r23 / r22;
    }

    public KeyPositionBase getPositionKeyframe(int r11, int r12, float r13, float r14) {
        RectF r10 = new RectF();
        MotionPaths r5 = this.mStartMotionPath;
        float r15 = r5.f435x;
        r10.left = r15;
        float r16 = r5.f436y;
        r10.top = r16;
        r10.right = r15 + r5.width;
        r10.bottom = r16 + r5.height;
        RectF r17 = new RectF();
        MotionPaths r18 = this.mEndMotionPath;
        float r19 = r18.f435x;
        r17.left = r19;
        float r20 = r18.f436y;
        r17.top = r20;
        r17.right = r19 + r18.width;
        r17.bottom = r20 + r18.height;
        Iterator<Key> r110 = this.mKeyList.iterator();
    L4:
        if (r110.hasNext() == false) goto L10;
        Key r21 = r110.next();
        if ((r21 instanceof KeyPositionBase) == false) goto L4;
        KeyPositionBase r22 = (KeyPositionBase) r21;
        if (r22.intersects(r11, r12, r10, r17, r13, r14) == false) goto L4;
        return r22;
    L10:
        return null;
    }

    public void getPostLayoutDvDp(float r19, int r20, int r21, float r22, float r23, float[] r24) {
        float r5 = getAdjustedPosition(r19, this.mVelocity);
        HashMap<String, SplineSet> r10 = this.mAttributesMap;
        KeyCycleOscillator r11 = null;
        if (r10 != null) goto L5;
        SplineSet r12 = null;
    L6:
        HashMap<String, SplineSet> r13 = this.mAttributesMap;
        if (r13 != null) goto L9;
        SplineSet r14 = null;
    L10:
        HashMap<String, SplineSet> r15 = this.mAttributesMap;
        if (r15 != null) goto L13;
        SplineSet r16 = null;
    L14:
        HashMap<String, SplineSet> r17 = this.mAttributesMap;
        if (r17 != null) goto L17;
        SplineSet r18 = null;
    L18:
        HashMap<String, SplineSet> r110 = this.mAttributesMap;
        if (r110 != null) goto L21;
        SplineSet r111 = null;
    L22:
        HashMap<String, KeyCycleOscillator> r112 = this.mCycleMap;
        if (r112 != null) goto L25;
        KeyCycleOscillator r25 = null;
    L26:
        HashMap<String, KeyCycleOscillator> r113 = this.mCycleMap;
        if (r113 != null) goto L29;
        KeyCycleOscillator r26 = null;
    L30:
        HashMap<String, KeyCycleOscillator> r114 = this.mCycleMap;
        if (r114 != null) goto L33;
        KeyCycleOscillator r27 = null;
    L34:
        HashMap<String, KeyCycleOscillator> r115 = this.mCycleMap;
        if (r115 != null) goto L37;
        KeyCycleOscillator r116 = null;
    L38:
        HashMap<String, KeyCycleOscillator> r117 = this.mCycleMap;
        if (r117 == null) goto L42;
        r11 = r117.get("scaleY");
    L42:
        VelocityMatrix r118 = new VelocityMatrix();
        r118.clear();
        r118.setRotationVelocity(r16, r5);
        r118.setTranslationVelocity(r12, r14, r5);
        r118.setScaleVelocity(r18, r111, r5);
        r118.setRotationVelocity(r27, r5);
        r118.setTranslationVelocity(r25, r26, r5);
        r118.setScaleVelocity(r116, r11, r5);
        CurveFit r119 = this.mArcSpline;
        if (r119 == null) goto L49;
        double[] r28 = this.mInterpolateData;
        if (r28.length <= 0) goto L47;
        double r29 = r5;
        r119.getPos(r29, r28);
        this.mArcSpline.getSlope(r29, this.mInterpolateVelocity);
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
    L47:
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L49:
        int r120 = 0;
        if (this.mSpline == null) goto L57;
        double r30 = getAdjustedPosition(r5, this.mVelocity);
        this.mSpline[0].getSlope(r30, this.mInterpolateVelocity);
        this.mSpline[0].getPos(r30, this.mInterpolateData);
        float r31 = this.mVelocity[0];
    L52:
        double[] r32 = this.mInterpolateVelocity;
        if (r120 >= r32.length) goto L55;
        r32[r120] = r32[r120] * ((double) r31);
        r120 = r120 + 1;
        goto L52
    L55:
        this.mStartMotionPath.setDpDt(r22, r23, r24, this.mInterpolateVariables, r32, this.mInterpolateData);
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L57:
        MotionPaths r121 = this.mEndMotionPath;
        float r122 = r121.f435x;
        MotionPaths r33 = this.mStartMotionPath;
        float r123 = r122 - r33.f435x;
        KeyCycleOscillator r124 = r11;
        float r125 = r121.f436y - r33.f436y;
        KeyCycleOscillator r126 = r116;
        float r34 = r121.width - r33.width;
        float r127 = (r121.height - r33.height) + r125;
        r24[0] = ((r34 + r123) * r22) + ((1.0f - r22) * r123);
        r24[1] = (r127 * r23) + ((1.0f - r23) * r125);
        r118.clear();
        r118.setRotationVelocity(r16, r5);
        r118.setTranslationVelocity(r12, r14, r5);
        r118.setScaleVelocity(r18, r111, r5);
        r118.setRotationVelocity(r27, r5);
        r118.setTranslationVelocity(r25, r26, r5);
        r118.setScaleVelocity(r126, r124, r5);
        r118.applyTransform(r22, r23, r20, r21, r24);
        return;
    L37:
        r116 = r115.get("scaleX");
        goto L38
    L33:
        r27 = r114.get("rotation");
        goto L34
    L29:
        r26 = r113.get("translationY");
        goto L30
    L25:
        r25 = r112.get("translationX");
        goto L26
    L21:
        r111 = r110.get("scaleY");
        goto L22
    L17:
        r18 = r17.get("scaleX");
        goto L18
    L13:
        r16 = r15.get("rotation");
        goto L14
    L9:
        r14 = r13.get("translationY");
        goto L10
    L5:
        r12 = r10.get("translationX");
        goto L6
    }

    public float getStartX() {
        return this.mStartMotionPath.f435x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f436y;
    }

    public int getkeyFramePositions(int[] r10, float[] r11) {
        Iterator<Key> r5 = this.mKeyList.iterator();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r5.hasNext() == false) goto L6;
        Key r14 = r5.next();
        int r15 = r14.mFramePosition;
        r10[r12] = (r14.mType * 1000) + r15;
        this.mSpline[0].getPos(r15 / 100.0f, this.mInterpolateData);
        this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, r11, r13);
        r13 = r13 + 2;
        r12 = r12 + 1;
        goto L4
    L6:
        return r12;
    }

    public boolean interpolate(View r23, float r24, long r25, KeyCache r27) {
        float r12 = getAdjustedPosition(r24, null);
        HashMap<String, SplineSet> r5 = this.mAttributesMap;
        if (r5 == null) goto L8;
        Iterator<SplineSet> r10 = r5.values().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        r10.next().setProperty(r23, r12);
    L8:
        HashMap<String, TimeCycleSplineSet> r11 = this.mTimeCycleAttributesMap;
        if (r11 == null) goto L18;
        Iterator<TimeCycleSplineSet> r13 = r11.values().iterator();
        TimeCycleSplineSet.PathRotate r14 = null;
        boolean r15 = false;
    L12:
        if (r13.hasNext() == false) goto L17;
        TimeCycleSplineSet r16 = r13.next();
        if ((r16 instanceof TimeCycleSplineSet.PathRotate) == true) goto L15;
        r15 = r15 | r16.setProperty(r23, r12, r25, r27);
        goto L12
    L15:
        r14 = (TimeCycleSplineSet.PathRotate) r16;
        goto L12
    L17:
        boolean r17 = r15;
    L19:
        CurveFit[] r18 = this.mSpline;
        if (r18 == null) goto L58;
        double r19 = r12;
        r18[0].getPos(r19, this.mInterpolateData);
        this.mSpline[0].getSlope(r19, this.mInterpolateVelocity);
        CurveFit r20 = this.mArcSpline;
        if (r20 == null) goto L26;
        double[] r21 = this.mInterpolateData;
        if (r21.length <= 0) goto L26;
        r20.getPos(r19, r21);
        this.mArcSpline.getSlope(r19, this.mInterpolateVelocity);
    L26:
        this.mStartMotionPath.setView(r23, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
        HashMap<String, SplineSet> r22 = this.mAttributesMap;
        if (r22 == null) goto L34;
        Iterator<SplineSet> r110 = r22.values().iterator();
    L30:
        if (r110.hasNext() == false) goto L34;
        SplineSet r26 = r110.next();
        if ((r26 instanceof SplineSet.PathRotate) == false) goto L30;
        double[] r28 = this.mInterpolateVelocity;
        ((SplineSet.PathRotate) r26).setPathRotate(r23, r12, r28[0], r28[1]);
    L34:
        if (r14 == null) goto L37;
        double[] r29 = this.mInterpolateVelocity;
        r17 = r17 | r14.setPathRotate(r23, r27, r12, r25, r29[0], r29[1]);
    L37:
        int r30 = 1;
    L38:
        CurveFit[] r31 = this.mSpline;
        if (r30 >= r31.length) goto L41;
        r31[r30].getPos(r19, this.mValuesBuff);
        this.mStartMotionPath.attributes.get(this.mAttributeNames[r30 - 1]).setInterpolatedValue(r23, this.mValuesBuff);
        r30 = r30 + 1;
        goto L38
    L41:
        MotionConstrainedPoint r32 = this.mStartPoint;
        if (r32.mVisibilityMode != 0) goto L53;
        if (r12 > 0.0f) goto L47;
        r23.setVisibility(r32.visibility);
        goto L53
    L47:
        if (r12 < 1.0f) goto L50;
        r23.setVisibility(this.mEndPoint.visibility);
        goto L53
    L50:
        if (this.mEndPoint.visibility == r32.visibility) goto L53;
        r23.setVisibility(0);
    L53:
        if (this.mKeyTriggers == null) goto L64;
        int r33 = 0;
    L55:
        KeyTrigger[] r34 = this.mKeyTriggers;
        if (r33 >= r34.length) goto L64;
        r34[r33].conditionallyFire(r12, r23);
        r33 = r33 + 1;
    L64:
        HashMap<String, KeyCycleOscillator> r35 = this.mCycleMap;
        if (r35 == null) goto L73;
        Iterator<KeyCycleOscillator> r36 = r35.values().iterator();
    L68:
        if (r36.hasNext() == false) goto L73;
        KeyCycleOscillator r37 = r36.next();
        if ((r37 instanceof KeyCycleOscillator.PathRotateSet) == true) goto L71;
        r37.setProperty(r23, r12);
        goto L68
    L71:
        double[] r38 = this.mInterpolateVelocity;
        ((KeyCycleOscillator.PathRotateSet) r37).setPathRotate(r23, r12, r38[0], r38[1]);
    L73:
        return r17;
    L58:
        MotionPaths r39 = this.mStartMotionPath;
        float r40 = r39.f435x;
        MotionPaths r41 = this.mEndMotionPath;
        float r42 = j0.b(r41.f435x, r40, r12, r40);
        float r43 = r39.f436y;
        float r44 = j0.b(r41.f436y, r43, r12, r43);
        float r45 = r39.width;
        float r46 = r41.width;
        float r47 = j0.b(r46, r45, r12, r45);
        float r48 = r39.height;
        float r49 = r41.height;
        float r50 = r42 + 0.5f;
        int r111 = (int) r50;
        float r51 = r44 + 0.5f;
        int r52 = (int) r51;
        int r53 = (int) (r50 + r47);
        int r54 = (int) (r51 + j0.b(r49, r48, r12, r48));
        int r55 = r53 - r111;
        int r56 = r54 - r52;
        if (r46 == r45) goto L61;
    L62:
        r23.measure(View.MeasureSpec.makeMeasureSpec(r55, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(r56, BasicMeasure.EXACTLY));
    L63:
        r23.layout(r111, r52, r53, r54);
        goto L64
    L61:
        if (r49 == r48) goto L63;
    L18:
        r14 = null;
        r17 = false;
        goto L19
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View r10, KeyPositionBase r11, float r12, float r13, String[] r14, float[] r15) {
        RectF r5 = new RectF();
        MotionPaths r16 = this.mStartMotionPath;
        float r17 = r16.f435x;
        r5.left = r17;
        float r18 = r16.f436y;
        r5.top = r18;
        r5.right = r17 + r16.width;
        r5.bottom = r18 + r16.height;
        RectF r19 = new RectF();
        MotionPaths r20 = this.mEndMotionPath;
        float r21 = r20.f435x;
        r19.left = r21;
        float r22 = r20.f436y;
        r19.top = r22;
        r19.right = r21 + r20.width;
        r19.bottom = r22 + r20.height;
        r11.positionAttributes(r10, r5, r19, r12, r13, r14, r15);
    }

    public void setDrawPath(int r5) {
        this.mStartMotionPath.mDrawPath = r5;
    }

    public void setEndState(ConstraintWidget r10, ConstraintSet r11) {
        MotionPaths r5 = this.mEndMotionPath;
        r5.time = 1.0f;
        r5.position = 1.0f;
        readView(r5);
        this.mEndMotionPath.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mEndMotionPath.applyParameters(r11.getParameters(this.mId));
        this.mEndPoint.setState(r10, r11, this.mId);
    }

    public void setPathMotionArc(int r5) {
        this.mPathMotionArc = r5;
    }

    public void setStartCurrentState(View r10) {
        MotionPaths r5 = this.mStartMotionPath;
        r5.time = 0.0f;
        r5.position = 0.0f;
        r5.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        this.mStartPoint.setState(r10);
    }

    public void setStartState(ConstraintWidget r10, ConstraintSet r11) {
        MotionPaths r5 = this.mStartMotionPath;
        r5.time = 0.0f;
        r5.position = 0.0f;
        readView(r5);
        this.mStartMotionPath.setBounds(r10.getX(), r10.getY(), r10.getWidth(), r10.getHeight());
        ConstraintSet.Constraint r12 = r11.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(r12);
        this.mMotionStagger = r12.motion.mMotionStagger;
        this.mStartPoint.setState(r10, r11, this.mId);
    }

    public void setView(View r5) {
        this.mView = r5;
        this.mId = r5.getId();
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L6;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams) r10).getConstraintTag();
        return;
    }

    public void setup(int r18, int r19, float r20, long r21) {
        new HashSet();
        HashSet<String> r5 = new HashSet();
        HashSet<String> r10 = new HashSet();
        HashSet<String> r11 = new HashSet();
        HashMap<String, Integer> r12 = new HashMap();
        int r13 = this.mPathMotionArc;
        if (r13 == Key.UNSET) goto L5;
        this.mStartMotionPath.mPathMotionArc = r13;
    L5:
        this.mStartPoint.different(this.mEndPoint, r10);
        ArrayList<Key> r14 = this.mKeyList;
        if (r14 == null) goto L27;
        Iterator<Key> r15 = r14.iterator();
        ArrayList r16 = null;
    L9:
        if (r15.hasNext() == false) goto L29;
        Key r17 = r15.next();
        if ((r17 instanceof KeyPosition) == true) goto L12;
        if ((r17 instanceof KeyCycle) == true) goto L17;
        if ((r17 instanceof KeyTimeCycle) == true) goto L20;
        if ((r17 instanceof KeyTrigger) == true) goto L23;
        r17.setInterpolation(r12);
        r17.getAttributeNames(r10);
        goto L9
    L23:
        if (r16 != null) goto L25;
        r16 = new ArrayList();
    L25:
        r16.add((KeyTrigger) r17);
        goto L9
    L20:
        r17.getAttributeNames(r5);
        goto L9
    L17:
        r17.getAttributeNames(r11);
        goto L9
    L12:
        KeyPosition r22 = (KeyPosition) r17;
        insertKey(new MotionPaths(r18, r19, r22, this.mStartMotionPath, this.mEndMotionPath));
        int r23 = r22.mCurveFit;
        if (r23 == Key.UNSET) goto L9;
        this.mCurveFitType = r23;
    L29:
        if (r16 == null) goto L31;
        this.mKeyTriggers = (KeyTrigger[]) r16.toArray(new KeyTrigger[0]);
    L31:
        char r110 = 1;
        if (r10.isEmpty() == true) goto L69;
        this.mAttributesMap = new HashMap();
        Iterator<String> r24 = r10.iterator();
    L35:
        if (r24.hasNext() == false) goto L52;
        String r111 = r24.next();
        if (r111.startsWith("CUSTOM,") == false) goto L48;
        SparseArray r112 = new SparseArray();
        String r113 = r111.split(",")[1];
        Iterator<Key> r114 = this.mKeyList.iterator();
    L40:
        if (r114.hasNext() == false) goto L47;
        Key r115 = r114.next();
        HashMap<String, ConstraintAttribute> r25 = r115.mCustomConstraints;
        if (r25 == null) goto L40;
        ConstraintAttribute r26 = r25.get(r113);
        if (r26 == null) goto L40;
        r112.append(r115.mFramePosition, r26);
        goto L40
    L47:
        SplineSet r27 = SplineSet.makeCustomSpline(r111, r112);
    L49:
        if (r27 == null) goto L35;
        r27.setType(r111);
        this.mAttributesMap.put(r111, r27);
        goto L35
    L48:
        r27 = SplineSet.makeSpline(r111);
        goto L49
    L52:
        ArrayList<Key> r28 = this.mKeyList;
        if (r28 == null) goto L60;
        Iterator<Key> r29 = r28.iterator();
    L56:
        if (r29.hasNext() == false) goto L60;
        Key r30 = r29.next();
        if ((r30 instanceof KeyAttributes) == false) goto L56;
        r30.addValues(this.mAttributesMap);
    L60:
        this.mStartPoint.addValues(this.mAttributesMap, 0);
        this.mEndPoint.addValues(this.mAttributesMap, 100);
        Iterator<String> r31 = this.mAttributesMap.keySet().iterator();
    L62:
        if (r31.hasNext() == false) goto L69;
        String r32 = r31.next();
        if (r12.containsKey(r32) == false) goto L66;
        int r116 = r12.get(r32).intValue();
    L67:
        this.mAttributesMap.get(r32).setup(r116);
        goto L62
    L66:
        r116 = 0;
    L69:
        if (r5.isEmpty() == false) goto L71;
    L111:
        int r33 = this.mMotionPaths.size();
        int r34 = r33 + 2;
        MotionPaths[] r35 = new MotionPaths[r34];
        r35[0] = this.mStartMotionPath;
        r35[r33 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0) goto L114;
    L116:
        Iterator<MotionPaths> r36 = this.mMotionPaths.iterator();
        int r37 = 1;
    L118:
        if (r36.hasNext() == false) goto L120;
        r35[r37] = r36.next();
        r37 = r37 + 1;
        goto L118
    L120:
        HashSet r38 = new HashSet();
        Iterator<String> r39 = this.mEndMotionPath.attributes.keySet().iterator();
    L122:
        if (r39.hasNext() == false) goto L128;
        String r40 = r39.next();
        if (this.mStartMotionPath.attributes.containsKey(r40) == false) goto L122;
        if (r10.contains("CUSTOM," + r40) == true) goto L122;
        r38.add(r40);
        goto L122
    L128:
        String[] r41 = (String[]) r38.toArray(new String[0]);
        this.mAttributeNames = r41;
        this.mAttributeInterpCount = new int[r41.length];
        int r42 = 0;
    L129:
        String[] r43 = this.mAttributeNames;
        if (r42 >= r43.length) goto L139;
        String r44 = r43[r42];
        this.mAttributeInterpCount[r42] = 0;
        int r45 = 0;
    L132:
        if (r45 >= r34) goto L137;
        if (r35[r45].attributes.containsKey(r44) == true) goto L135;
        r45 = r45 + 1;
        goto L132
    L135:
        int[] r46 = this.mAttributeInterpCount;
        r46[r42] = r35[r45].attributes.get(r44).noOfInterpValues() + r46[r42];
    L137:
        r42 = r42 + 1;
        goto L129
    L139:
        if (r35[0].mPathMotionArc == Key.UNSET) goto L141;
        boolean r47 = true;
    L142:
        int r48 = 18 + r43.length;
        boolean[] r49 = new boolean[r48];
        int r50 = 1;
    L143:
        if (r50 >= r34) goto L145;
        r35[r50].different(r35[r50 - 1], r49, this.mAttributeNames, r47);
        r50 = r50 + 1;
        goto L143
    L145:
        int r51 = 0;
        int r52 = 1;
    L146:
        if (r52 >= r48) goto L151;
        if (r49[r52] == false) goto L150;
        r51 = r51 + 1;
    L150:
        r52 = r52 + 1;
        goto L146
    L151:
        int[] r53 = new int[r51];
        this.mInterpolateVariables = r53;
        this.mInterpolateData = new double[r53.length];
        this.mInterpolateVelocity = new double[r53.length];
        int r54 = 0;
        int r55 = 1;
    L152:
        if (r55 >= r48) goto L157;
        if (r49[r55] == false) goto L156;
        this.mInterpolateVariables[r54] = r55;
        r54 = r54 + 1;
    L156:
        r55 = r55 + 1;
        goto L152
    L157:
        int r56 = 2;
        double[][] r57 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r34, this.mInterpolateVariables.length});
        double[] r58 = new double[r34];
        int r59 = 0;
    L158:
        if (r59 >= r34) goto L160;
        r35[r59].fillStandard(r57[r59], this.mInterpolateVariables);
        r58[r59] = r35[r59].time;
        r59 = r59 + 1;
        goto L158
    L160:
        int r60 = 0;
    L161:
        int[] r61 = this.mInterpolateVariables;
        if (r60 >= r61.length) goto L169;
        if (r61[r60] >= MotionPaths.names.length) goto L168;
        String r62 = j0.q(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[r60]], " [");
        int r117 = 0;
    L166:
        if (r117 >= r34) goto L168;
        StringBuilder r63 = j0.u(r62);
        r63.append(r57[r117][r60]);
        r62 = r63.toString();
        r117 = r117 + 1;
    L168:
        r60 = r60 + 1;
        goto L161
    L169:
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int r64 = 0;
    L170:
        String[] r65 = this.mAttributeNames;
        if (r64 >= r65.length) goto L182;
        String r66 = r65[r64];
        int r118 = 0;
        int r119 = 0;
        double[] r120 = null;
        double[][] r121 = null;
    L173:
        if (r118 >= r34) goto L181;
        if (r35[r118].hasCustomData(r66) == false) goto L180;
        if (r121 != null) goto L178;
        r120 = new double[r34];
        int[] r122 = new int[r56];
        r122[r110] = r35[r118].getCustomDataCount(r66);
        r122[0] = r34;
        r121 = (double[][]) Array.newInstance(Double.TYPE, r122);
    L178:
        MotionPaths r123 = r35[r118];
        r120[r119] = r123.time;
        r123.getCustomData(r66, r121[r119], 0);
        r119 = r119 + 1;
    L180:
        r118 = r118 + 1;
        r11 = r11;
        r56 = 2;
        r110 = 1;
        goto L173
    L181:
        r64 = r64 + 1;
        this.mSpline[r64] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(r120, r119), (double[][]) Arrays.copyOf(r121, r119));
        r11 = r11;
        r56 = 2;
        r110 = 1;
        goto L170
    L182:
        HashSet<String> r124 = r11;
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, r58, r57);
        if (r35[0].mPathMotionArc == Key.UNSET) goto L188;
        int[] r67 = new int[r34];
        double[] r68 = new double[r34];
        double[][] r69 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r34, 2});
        int r70 = 0;
    L185:
        if (r70 >= r34) goto L187;
        MotionPaths r71 = r35[r70];
        r67[r70] = r71.mPathMotionArc;
        r68[r70] = r71.time;
        double[] r72 = r69[r70];
        r72[0] = r71.f435x;
        r72[1] = r71.f436y;
        r70 = r70 + 1;
        goto L185
    L187:
        this.mArcSpline = CurveFit.getArc(r67, r68, r69);
    L188:
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) goto L212;
        Iterator<String> r73 = r124.iterator();
        float r74 = Float.NaN;
    L192:
        if (r73.hasNext() == false) goto L202;
        String r75 = r73.next();
        KeyCycleOscillator r76 = KeyCycleOscillator.makeSpline(r75);
        if (r76 == null) goto L192;
        if (r76.variesByPath() == true) goto L199;
    L201:
        r76.setType(r75);
        this.mCycleMap.put(r75, r76);
        goto L192
    L199:
        if (Float.isNaN(r74) == false) goto L201;
        r74 = getPreCycleDistance();
        goto L201
    L202:
        Iterator<Key> r77 = this.mKeyList.iterator();
    L204:
        if (r77.hasNext() == false) goto L208;
        Key r78 = r77.next();
        if ((r78 instanceof KeyCycle) == false) goto L204;
        ((KeyCycle) r78).addCycleValues(this.mCycleMap);
        goto L204
    L208:
        Iterator<KeyCycleOscillator> r79 = this.mCycleMap.values().iterator();
    L210:
        if (r79.hasNext() == false) goto L311;
        r79.next().setup(r74);
        goto L210
    L311:
        return;
    L212:
        return;
    L141:
        r47 = false;
        goto L142
    L114:
        if (this.mCurveFitType != (-1)) goto L116;
        this.mCurveFitType = 0;
        goto L116
    L71:
        if (this.mTimeCycleAttributesMap != null) goto L73;
        this.mTimeCycleAttributesMap = new HashMap();
    L73:
        Iterator<String> r80 = r5.iterator();
    L75:
        if (r80.hasNext() == false) goto L95;
        String r81 = r80.next();
        if (this.mTimeCycleAttributesMap.containsKey(r81) == true) goto L75;
        if (r81.startsWith("CUSTOM,") == false) goto L91;
        SparseArray r82 = new SparseArray();
        String r125 = r81.split(",")[1];
        Iterator<Key> r126 = this.mKeyList.iterator();
    L83:
        if (r126.hasNext() == false) goto L90;
        Key r127 = r126.next();
        HashMap<String, ConstraintAttribute> r128 = r127.mCustomConstraints;
        if (r128 == null) goto L83;
        ConstraintAttribute r129 = r128.get(r125);
        if (r129 == null) goto L83;
        r82.append(r127.mFramePosition, r129);
        goto L83
    L90:
        TimeCycleSplineSet r83 = TimeCycleSplineSet.makeCustomSpline(r81, r82);
    L92:
        if (r83 == null) goto L75;
        r83.setType(r81);
        this.mTimeCycleAttributesMap.put(r81, r83);
        goto L75
    L91:
        r83 = TimeCycleSplineSet.makeSpline(r81, r21);
        goto L92
    L95:
        ArrayList<Key> r84 = this.mKeyList;
        if (r84 == null) goto L103;
        Iterator<Key> r85 = r84.iterator();
    L99:
        if (r85.hasNext() == false) goto L103;
        Key r86 = r85.next();
        if ((r86 instanceof KeyTimeCycle) == false) goto L99;
        ((KeyTimeCycle) r86).addTimeValues(this.mTimeCycleAttributesMap);
    L103:
        Iterator<String> r87 = this.mTimeCycleAttributesMap.keySet().iterator();
    L105:
        if (r87.hasNext() == false) goto L111;
        String r88 = r87.next();
        if (r12.containsKey(r88) == false) goto L109;
        int r89 = r12.get(r88).intValue();
    L110:
        this.mTimeCycleAttributesMap.get(r88).setup(r89);
        goto L105
    L109:
        r89 = 0;
        goto L110
    L27:
        r16 = null;
        goto L29
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f435x + " y: " + this.mStartMotionPath.f436y + " end: x: " + this.mEndMotionPath.f435x + " y: " + this.mEndMotionPath.f436y;
    }
}
