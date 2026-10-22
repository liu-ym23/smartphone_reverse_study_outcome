package androidx.constraintlayout.motion.widget;

import ai.j0;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.2831855f;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[][] mValues;
    protected int mWaveShape;

    public static class AlphaSet extends TimeCycleSplineSet {
        public AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setAlpha(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties;

        public CustomSet(String r5, SparseArray<ConstraintAttribute> r10) {
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = r5.split(",")[1];
            this.mConstraintAttributeList = r10;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setPoint(int r5, float r10, float r11, int r12, float r13) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r5 = this.mTempValues;
            float r10 = r5[r5.length - 2];
            float r11 = r5[r5.length - 1];
            long r12 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r13 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r13;
            if (Float.isNaN(r13) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r14 = (float) ((((r12 * 1.0E-9d) * ((double) r10)) + ((double) this.last_cycle)) % 1.0d);
            this.last_cycle = r14;
            this.last_time = r19;
            float r15 = calcWave(r14);
            this.mContinue = false;
            int r16 = 0;
        L8:
            float[] r20 = this.mCache;
            if (r16 >= r20.length) goto L15;
            boolean r22 = this.mContinue;
            float r23 = this.mTempValues[r16];
            if (r23 == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.mContinue = r22 | r110;
            r20[r16] = (r23 * r15) + r11;
            r16 = r16 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r17, this.mCache);
            if (r10 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public void setup(int r15) {
            int r5 = this.mConstraintAttributeList.size();
            int r10 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] r11 = new double[r5];
            int r12 = r10 + 2;
            this.mTempValues = new float[r12];
            this.mCache = new float[r10];
            double[][] r13 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r12});
            int r14 = 0;
        L3:
            if (r14 >= r5) goto L9;
            int r16 = this.mConstraintAttributeList.keyAt(r14);
            ConstraintAttribute r17 = this.mConstraintAttributeList.valueAt(r14);
            float[] r18 = this.mWaveProperties.valueAt(r14);
            r11[r14] = ((double) r16) * 0.01d;
            r17.getValuesToInterpolate(this.mTempValues);
            int r19 = 0;
        L5:
            float[] r20 = this.mTempValues;
            if (r19 >= r20.length) goto L8;
            r13[r14][r19] = r20[r19];
            r19 = r19 + 1;
            goto L5
        L8:
            double[] r21 = r13[r14];
            r21[r10] = r18[0];
            r21[r10 + 1] = r18[1];
            r14 = r14 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r15, r11, r13);
        }

        public void setPoint(int r5, ConstraintAttribute r10, float r11, int r12, float r13) {
            this.mConstraintAttributeList.append(r5, r10);
            this.mWaveProperties.append(r5, new float[]{r11, r13});
            this.mWaveShape = Math.max(this.mWaveShape, r12);
        }
    }

    public static class ElevationSet extends TimeCycleSplineSet {
        public ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setElevation(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class PathRotate extends TimeCycleSplineSet {
        public PathRotate() {
        }

        public boolean setPathRotate(View r10, KeyCache r11, float r12, long r13, double r14, double r15) {
            r10.setRotation(get(r12, r13, r10, r11) + ((float) Math.toDegrees(Math.atan2(r15, r14))));
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r5, float r10, long r11, KeyCache r12) {
            return this.mContinue;
        }
    }

    public static class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod;

        public ProgressSet() {
            this.mNoMethod = false;
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r14) {
            if ((r10 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r10).setProgress(get(r11, r12, r10, r14));
        L23:
            return this.mContinue;
        L6:
            if (this.mNoMethod == false) goto L24;
            return false;
        L24:
            Method r5 = r10.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r5 == null) goto L23;
            r5.invoke(r10, new Object[]{Float.valueOf(get(r11, r12, r10, r14))});     // Catch: InvocationTargetException -> L16 IllegalAccessException -> L18
        L18:
            e = move-exception;
            Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e);
        L16:
            e = move-exception;
            Log.e(TimeCycleSplineSet.TAG, "unable to setProgress", e);
        L11:
            this.mNoMethod = true;
            r5 = null;
            goto L12
        }
    }

    public static class RotationSet extends TimeCycleSplineSet {
        public RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotation(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class RotationXset extends TimeCycleSplineSet {
        public RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotationX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class RotationYset extends TimeCycleSplineSet {
        public RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setRotationY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class ScaleXset extends TimeCycleSplineSet {
        public ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setScaleX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class ScaleYset extends TimeCycleSplineSet {
        public ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setScaleY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class Sort {
        private Sort() {
        }

        public static void doubleQuickSort(int[] r10, float[][] r11, int r12, int r13) {
            int[] r5 = new int[r10.length + 10];
            r5[0] = r13;
            r5[1] = r12;
            int r14 = 2;
        L3:
            if (r14 <= 0) goto L8;
            int r15 = r5[r14 - 1];
            int r16 = r14 - 2;
            int r17 = r5[r16];
            if (r15 < r17) goto L6;
            r14 = r16;
            goto L3
        L6:
            int r18 = partition(r10, r11, r15, r17);
            r5[r16] = r18 - 1;
            r5[r14 - 1] = r15;
            int r19 = r14 + 1;
            r5[r14] = r17;
            r14 = r14 + 2;
            r5[r19] = r18 + 1;
            goto L3
        }

        private static int partition(int[] r5, float[][] r10, int r11, int r12) {
            int r13 = r5[r12];
            int r14 = r11;
        L3:
            if (r11 >= r12) goto L8;
            if (r5[r11] > r13) goto L7;
            swap(r5, r10, r14, r11);
            r14 = r14 + 1;
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            swap(r5, r10, r14, r12);
            return r14;
        }

        private static void swap(int[] r5, float[][] r10, int r11, int r12) {
            int r13 = r5[r11];
            r5[r11] = r5[r12];
            r5[r12] = r13;
            float[] r14 = r10[r11];
            r10[r11] = r10[r12];
            r10[r12] = r14;
        }
    }

    public static class TranslationXset extends TimeCycleSplineSet {
        public TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setTranslationX(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class TranslationYset extends TimeCycleSplineSet {
        public TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setTranslationY(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public static class TranslationZset extends TimeCycleSplineSet {
        public TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.TimeCycleSplineSet
        public boolean setProperty(View r10, float r11, long r12, KeyCache r13) {
            r10.setTranslationZ(get(r11, r12, r10, r13));
            return this.mContinue;
        }
    }

    public TimeCycleSplineSet() {
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        this.mValues = (float[][]) Array.newInstance(Float.TYPE, new int[]{10, 3});
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    public static TimeCycleSplineSet makeCustomSpline(String r5, SparseArray<ConstraintAttribute> r10) {
        return new CustomSet(r5, r10);
    }

    public static TimeCycleSplineSet makeSpline(String r5, long r10) {
        r5.getClass();
        byte r11 = -1;
        switch(r5.hashCode()) {
            case -1249320806: goto L50;
            case -1249320805: goto L46;
            case -1225497657: goto L42;
            case -1225497656: goto L38;
            case -1225497655: goto L34;
            case -1001078227: goto L30;
            case -908189618: goto L26;
            case -908189617: goto L22;
            case -40300674: goto L18;
            case -4379043: goto L14;
            case 37232917: goto L10;
            case 92909918: goto L6;
            default: goto L53;
        };
    L53:
        switch(r11) {
            case 0: goto L67;
            case 1: goto L66;
            case 2: goto L65;
            case 3: goto L64;
            case 4: goto L63;
            case 5: goto L62;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            default: goto L54;
        };
    L54:
        return null;
    L56:
        TimeCycleSplineSet r12 = new AlphaSet();
    L68:
        r12.setStartTime(r10);
        return r12;
    L57:
        r12 = new PathRotate();
        goto L68
    L58:
        r12 = new ElevationSet();
        goto L68
    L59:
        r12 = new RotationSet();
        goto L68
    L60:
        r12 = new ScaleYset();
        goto L68
    L61:
        r12 = new ScaleXset();
        goto L68
    L62:
        r12 = new ProgressSet();
        goto L68
    L63:
        r12 = new TranslationZset();
        goto L68
    L64:
        r12 = new TranslationYset();
        goto L68
    L65:
        r12 = new TranslationXset();
        goto L68
    L66:
        r12 = new RotationYset();
        goto L68
    L67:
        r12 = new RotationXset();
        goto L68
    L6:
        if (r5.equals("alpha") == false) goto L53;
        r11 = 11;
        goto L53
    L10:
        if (r5.equals("transitionPathRotate") == false) goto L53;
        r11 = 10;
        goto L53
    L14:
        if (r5.equals("elevation") == false) goto L53;
        r11 = 9;
        goto L53
    L18:
        if (r5.equals("rotation") == false) goto L53;
        r11 = 8;
        goto L53
    L22:
        if (r5.equals("scaleY") == false) goto L53;
        r11 = 7;
        goto L53
    L26:
        if (r5.equals("scaleX") == false) goto L53;
        r11 = 6;
        goto L53
    L30:
        if (r5.equals(NotificationCompat.CATEGORY_PROGRESS) == false) goto L53;
        r11 = 5;
        goto L53
    L34:
        if (r5.equals("translationZ") == false) goto L53;
        r11 = 4;
        goto L53
    L38:
        if (r5.equals("translationY") == false) goto L53;
        r11 = 3;
        goto L53
    L42:
        if (r5.equals("translationX") == false) goto L53;
        r11 = 2;
        goto L53
    L46:
        if (r5.equals("rotationY") == false) goto L53;
        r11 = 1;
        goto L53
    L50:
        if (r5.equals("rotationX") == false) goto L53;
        r11 = 0;
        goto L53
    }

    public float calcWave(float r5) {
        switch(this.mWaveShape) {
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        float r10 = 1.0f - Math.abs(((r5 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r10 * r10);
    L5:
        return (float) Math.sin(r5 * VAL_2PI);
    L9:
        return (float) Math.cos(r5 * VAL_2PI);
    L11:
        return 1.0f - (((r5 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r5 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r5);
    L17:
        return Math.signum(r5 * VAL_2PI);
    }

    public float get(float r19, long r20, View r22, KeyCache r23) {
        this.mCurveFit.getPos(r19, this.mCache);
        float[] r5 = this.mCache;
        float r10 = r5[1];
        if (r10 != 0.0f) goto L7;
        this.mContinue = false;
        return r5[2];
    L7:
        if (Float.isNaN(this.last_cycle) == false) goto L11;
        float r11 = r23.getFloatValue(r22, this.mType, 0);
        this.last_cycle = r11;
        if (Float.isNaN(r11) == false) goto L11;
        this.last_cycle = 0.0f;
    L11:
        float r12 = (float) (((((r20 - this.last_time) * 1.0E-9d) * ((double) r10)) + ((double) this.last_cycle)) % 1.0d);
        this.last_cycle = r12;
        r23.setFloatValue(r22, this.mType, 0, r12);
        this.last_time = r20;
        float r13 = this.mCache[0];
        float r14 = (calcWave(this.last_cycle) * r13) + this.mCache[2];
        if (r13 != 0.0f) goto L16;
        if (r10 != 0.0f) goto L16;
        boolean r15 = false;
    L17:
        this.mContinue = r15;
        return r14;
    L16:
        r15 = true;
        goto L17
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int r5, float r10, float r11, int r12, float r13) {
        int[] r14 = this.mTimePoints;
        int r15 = this.count;
        r14[r15] = r5;
        float[] r16 = this.mValues[r15];
        r16[0] = r10;
        r16[1] = r11;
        r16[2] = r13;
        this.mWaveShape = Math.max(this.mWaveShape, r12);
        this.count++;
    }

    public abstract boolean setProperty(View r5, float r10, long r11, KeyCache r12);

    public void setStartTime(long r5) {
        this.last_time = r5;
    }

    public void setType(String r5) {
        this.mType = r5;
    }

    public void setup(int r12) {
        int r5 = this.count;
        if (r5 != 0) goto L6;
        Log.e(TAG, "Error no points added to " + this.mType);
        return;
    L6:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r5 - 1);
        int r10 = 1;
        int r11 = 0;
    L7:
        int[] r13 = this.mTimePoints;
        if (r10 >= r13.length) goto L13;
        if (r13[r10] == r13[r10 - 1]) goto L12;
        r11 = r11 + 1;
    L12:
        r10 = r10 + 1;
        goto L7
    L13:
        if (r11 != 0) goto L15;
        r11 = 1;
    L15:
        double[] r14 = new double[r11];
        double[][] r15 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r11, 3});
        int r16 = 0;
        int r17 = 0;
    L17:
        if (r16 >= this.count) goto L24;
        if (r16 <= 0) goto L22;
        int[] r18 = this.mTimePoints;
        if (r18[r16] != r18[r16 - 1]) goto L22;
    L23:
        r16 = r16 + 1;
    L22:
        r14[r17] = ((double) this.mTimePoints[r16]) * 0.01d;
        double[] r19 = r15[r17];
        float[] r20 = this.mValues[r16];
        r19[0] = r20[0];
        r19[1] = r20[1];
        r19[2] = r20[2];
        r17 = r17 + 1;
        goto L23
    L24:
        this.mCurveFit = CurveFit.get(r12, r14, r15);
    }

    public String toString() {
        String r5 = this.mType;
        DecimalFormat r10 = new DecimalFormat("##.##");
        int r11 = 0;
    L4:
        if (r11 >= this.count) goto L6;
        StringBuilder r12 = j0.w(r5, "[");
        r12.append(this.mTimePoints[r11]);
        r12.append(" , ");
        r12.append(r10.format(this.mValues[r11]));
        r12.append("] ");
        r5 = r12.toString();
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }
}
