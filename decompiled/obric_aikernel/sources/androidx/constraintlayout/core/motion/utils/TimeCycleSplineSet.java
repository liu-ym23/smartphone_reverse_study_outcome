package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class TimeCycleSplineSet {
    protected static final int CURVE_OFFSET = 2;
    protected static final int CURVE_PERIOD = 1;
    protected static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    protected static float VAL_2PI = 6.2831855f;
    protected int count;
    protected float last_cycle;
    protected long last_time;
    protected float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    protected String mType;
    protected float[][] mValues;
    protected int mWaveShape;

    public static class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties;

        public CustomSet(String r10, KeyFrameArray.CustomArray r11) {
            this.mWaveProperties = new KeyFrameArray.FloatArray();
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r10, float r11, float r12, int r13, float r14) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int r10, CustomAttribute r11, float r12, int r13, float r14) {
            this.mConstraintAttributeList.append(r10, r11);
            this.mWaveProperties.append(r10, new float[]{r12, r14});
            this.mWaveShape = Math.max(this.mWaveShape, r13);
        }

        public boolean setProperty(MotionWidget r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r10 = this.mTempValues;
            float r11 = r10[r10.length - 2];
            float r12 = r10[r10.length - 1];
            long r13 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r14 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r14;
            if (Float.isNaN(r14) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r15 = (float) ((((double) this.last_cycle) + ((r13 * 1.0E-9d) * ((double) r11))) % 1.0d);
            this.last_cycle = r15;
            this.last_time = r19;
            float r16 = calcWave(r15);
            this.mContinue = false;
            int r20 = 0;
        L8:
            float[] r22 = this.mCache;
            if (r20 >= r22.length) goto L15;
            boolean r23 = this.mContinue;
            float[] r24 = this.mTempValues;
            if (r24[r20] == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.mContinue = r23 | r110;
            r22[r20] = (r24[r20] * r16) + r12;
            r20 = r20 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            r17.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), this.mCache);
            if (r11 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int r15) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r12 = new double[r10];
            int r13 = r11 + 2;
            this.mTempValues = new float[r13];
            this.mCache = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r13});
            int r16 = 0;
        L3:
            if (r16 >= r10) goto L9;
            int r17 = this.mConstraintAttributeList.keyAt(r16);
            CustomAttribute r18 = this.mConstraintAttributeList.valueAt(r16);
            float[] r19 = this.mWaveProperties.valueAt(r16);
            r12[r16] = ((double) r17) * 0.01d;
            r18.getValuesToInterpolate(this.mTempValues);
            int r20 = 0;
        L5:
            float[] r21 = this.mTempValues;
            if (r20 >= r21.length) goto L8;
            r14[r16][r20] = r21[r20];
            r20 = r20 + 1;
            goto L5
        L8:
            r14[r16][r11] = r19[0];
            r14[r16][r11 + 1] = r19[1];
            r16 = r16 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r15, r12, r14);
        }
    }

    public static class CustomVarSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;
        KeyFrameArray.FloatArray mWaveProperties;

        public CustomVarSet(String r10, KeyFrameArray.CustomVar r11) {
            this.mWaveProperties = new KeyFrameArray.FloatArray();
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int r10, float r11, float r12, int r13, float r14) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public void setPoint(int r10, CustomVariable r11, float r12, int r13, float r14) {
            this.mConstraintAttributeList.append(r10, r11);
            this.mWaveProperties.append(r10, new float[]{r12, r14});
            this.mWaveShape = Math.max(this.mWaveShape, r13);
        }

        public boolean setProperty(MotionWidget r17, float r18, long r19, KeyCache r21) {
            this.mCurveFit.getPos(r18, this.mTempValues);
            float[] r10 = this.mTempValues;
            float r11 = r10[r10.length - 2];
            float r12 = r10[r10.length - 1];
            long r13 = r19 - this.last_time;
            if (Float.isNaN(this.last_cycle) == false) goto L7;
            float r14 = r21.getFloatValue(r17, this.mAttributeName, 0);
            this.last_cycle = r14;
            if (Float.isNaN(r14) == false) goto L7;
            this.last_cycle = 0.0f;
        L7:
            float r15 = (float) ((((double) this.last_cycle) + ((r13 * 1.0E-9d) * ((double) r11))) % 1.0d);
            this.last_cycle = r15;
            this.last_time = r19;
            float r16 = calcWave(r15);
            this.mContinue = false;
            int r20 = 0;
        L8:
            float[] r22 = this.mCache;
            if (r20 >= r22.length) goto L15;
            boolean r23 = this.mContinue;
            float[] r24 = this.mTempValues;
            if (r24[r20] == 0.0d) goto L13;
            boolean r110 = true;
        L14:
            this.mContinue = r23 | r110;
            r22[r20] = (r24[r20] * r16) + r12;
            r20 = r20 + 1;
            goto L8
        L13:
            r110 = false;
            goto L14
        L15:
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r17, this.mCache);
            if (r11 == 0.0f) goto L19;
            this.mContinue = true;
        L19:
            return this.mContinue;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int r15) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r12 = new double[r10];
            int r13 = r11 + 2;
            this.mTempValues = new float[r13];
            this.mCache = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r13});
            int r16 = 0;
        L3:
            if (r16 >= r10) goto L9;
            int r17 = this.mConstraintAttributeList.keyAt(r16);
            CustomVariable r18 = this.mConstraintAttributeList.valueAt(r16);
            float[] r19 = this.mWaveProperties.valueAt(r16);
            r12[r16] = ((double) r17) * 0.01d;
            r18.getValuesToInterpolate(this.mTempValues);
            int r20 = 0;
        L5:
            float[] r21 = this.mTempValues;
            if (r20 >= r21.length) goto L8;
            r14[r16][r20] = r21[r20];
            r20 = r20 + 1;
            goto L5
        L8:
            r14[r16][r11] = r19[0];
            r14[r16][r11 + 1] = r19[1];
            r16 = r16 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r15, r12, r14);
        }
    }

    protected static class Sort {
        protected Sort() {
        }

        static void doubleQuickSort(int[] r10, float[][] r11, int r12, int r13) {
            int[] r14 = new int[r10.length + 10];
            r14[0] = r13;
            r14[1] = r12;
            int r15 = 2;
        L3:
            if (r15 <= 0) goto L7;
            int r16 = r15 - 1;
            int r17 = r14[r16];
            r15 = r16 - 1;
            int r18 = r14[r15];
            if (r17 >= r18) goto L3;
            int r19 = partition(r10, r11, r17, r18);
            int r20 = r15 + 1;
            r14[r15] = r19 - 1;
            int r21 = r20 + 1;
            r14[r20] = r17;
            int r22 = r21 + 1;
            r14[r21] = r18;
            r15 = r22 + 1;
            r14[r22] = r19 + 1;
            goto L3
        }

        private static int partition(int[] r10, float[][] r11, int r12, int r13) {
            int r14 = r10[r13];
            int r15 = r12;
        L3:
            if (r12 >= r13) goto L8;
            if (r10[r12] > r14) goto L7;
            swap(r10, r11, r15, r12);
            r15 = r15 + 1;
        L7:
            r12 = r12 + 1;
            goto L3
        L8:
            swap(r10, r11, r15, r13);
            return r15;
        }

        private static void swap(int[] r10, float[][] r11, int r12, int r13) {
            int r14 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r14;
            float[] r15 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r15;
        }
    }

    static {
    }

    public TimeCycleSplineSet() {
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        this.mValues = (float[][]) Array.newInstance(float.class, new int[]{10, 3});
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = Float.NaN;
    }

    protected float calcWave(float r10) {
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
        float r11 = 1.0f - Math.abs(((r10 * 4.0f) % 4.0f) - 2.0f);
        return 1.0f - (r11 * r11);
    L5:
        return (float) Math.sin(r10 * VAL_2PI);
    L9:
        return (float) Math.cos(r10 * VAL_2PI);
    L11:
        return 1.0f - (((r10 * 2.0f) + 1.0f) % 2.0f);
    L13:
        return (((r10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
    L15:
        return 1.0f - Math.abs(r10);
    L17:
        return Math.signum(r10 * VAL_2PI);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int r10, float r11, float r12, int r13, float r14) {
        int[] r15 = this.mTimePoints;
        int r16 = this.count;
        r15[r16] = r10;
        float[][] r17 = this.mValues;
        r17[r16][0] = r11;
        r17[r16][1] = r12;
        r17[r16][2] = r14;
        this.mWaveShape = Math.max(this.mWaveShape, r13);
        this.count++;
    }

    protected void setStartTime(long r10) {
        this.last_time = r10;
    }

    public void setType(String r10) {
        this.mType = r10;
    }

    public void setup(int r12) {
        int r10 = this.count;
        if (r10 != 0) goto L6;
        System.err.println("Error no points added to " + this.mType);
        return;
    L6:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r10 - 1);
        int r11 = 1;
        int r13 = 0;
    L7:
        int[] r14 = this.mTimePoints;
        if (r11 >= r14.length) goto L13;
        if (r14[r11] == r14[r11 - 1]) goto L12;
        r13 = r13 + 1;
    L12:
        r11 = r11 + 1;
        goto L7
    L13:
        if (r13 != 0) goto L15;
        r13 = 1;
    L15:
        double[] r15 = new double[r13];
        double[][] r16 = (double[][]) Array.newInstance(double.class, new int[]{r13, 3});
        int r17 = 0;
        int r18 = 0;
    L17:
        if (r17 >= this.count) goto L24;
        if (r17 <= 0) goto L22;
        int[] r19 = this.mTimePoints;
        if (r19[r17] != r19[r17 - 1]) goto L22;
    L23:
        r17 = r17 + 1;
    L22:
        r15[r18] = ((double) this.mTimePoints[r17]) * 0.01d;
        double[] r20 = r16[r18];
        float[][] r21 = this.mValues;
        r20[0] = r21[r17][0];
        r16[r18][1] = r21[r17][1];
        r16[r18][2] = r21[r17][2];
        r18 = r18 + 1;
        goto L23
    L24:
        this.mCurveFit = CurveFit.get(r12, r15, r16);
    }

    public String toString() {
        String r10 = this.mType;
        DecimalFormat r11 = new DecimalFormat("##.##");
        int r12 = 0;
    L4:
        if (r12 >= this.count) goto L6;
        r10 = r10 + "[" + this.mTimePoints[r12] + " , " + r11.format(this.mValues[r12]) + "] ";
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }
}
