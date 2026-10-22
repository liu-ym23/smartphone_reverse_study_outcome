package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.state.WidgetFrame;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[] mValues;

    private static class CoreSpline extends SplineSet {
        long start;
        String type;

        public CoreSpline(String r10, long r11) {
            this.type = r10;
            this.start = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues r10, float r11) {
            r10.setValue(r10.getId(this.type), get(r11));
        }
    }

    public static class CustomSet extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String r10, KeyFrameArray.CustomArray r11) {
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r10, float r11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int r10, CustomAttribute r11) {
            this.mConstraintAttributeList.append(r10, r11);
        }

        public void setProperty(WidgetFrame r10, float r11) {
            this.mCurveFit.getPos(r11, this.mTempValues);
            r10.setCustomValue(this.mConstraintAttributeList.valueAt(0), this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int r12) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r13 = new double[r10];
            this.mTempValues = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r11});
            int r15 = 0;
        L3:
            if (r15 >= r10) goto L9;
            int r16 = this.mConstraintAttributeList.keyAt(r15);
            CustomAttribute r17 = this.mConstraintAttributeList.valueAt(r15);
            r13[r15] = ((double) r16) * 0.01d;
            r17.getValuesToInterpolate(this.mTempValues);
            int r18 = 0;
        L5:
            float[] r19 = this.mTempValues;
            if (r18 >= r19.length) goto L8;
            r14[r15][r18] = r19[r18];
            r18 = r18 + 1;
            goto L5
        L8:
            r15 = r15 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r13, r14);
        }
    }

    public static class CustomSpline extends SplineSet {
        String mAttributeName;
        KeyFrameArray.CustomVar mConstraintAttributeList;
        float[] mTempValues;

        public CustomSpline(String r10, KeyFrameArray.CustomVar r11) {
            this.mAttributeName = r10.split(",")[1];
            this.mConstraintAttributeList = r11;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setPoint(int r10, float r11) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int r10, CustomVariable r11) {
            this.mConstraintAttributeList.append(r10, r11);
        }

        public void setProperty(MotionWidget r10, float r11) {
            this.mCurveFit.getPos(r11, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(r10, this.mTempValues);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setProperty(TypedValues r10, float r11) {
            setProperty((MotionWidget) r10, r11);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void setup(int r12) {
            int r10 = this.mConstraintAttributeList.size();
            int r11 = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] r13 = new double[r10];
            this.mTempValues = new float[r11];
            double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r11});
            int r15 = 0;
        L3:
            if (r15 >= r10) goto L9;
            int r16 = this.mConstraintAttributeList.keyAt(r15);
            CustomVariable r17 = this.mConstraintAttributeList.valueAt(r15);
            r13[r15] = ((double) r16) * 0.01d;
            r17.getValuesToInterpolate(this.mTempValues);
            int r18 = 0;
        L5:
            float[] r19 = this.mTempValues;
            if (r18 >= r19.length) goto L8;
            r14[r15][r18] = r19[r18];
            r18 = r18 + 1;
            goto L5
        L8:
            r15 = r15 + 1;
            goto L3
        L9:
            this.mCurveFit = CurveFit.get(r12, r13, r14);
        }
    }

    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] r10, float[] r11, int r12, int r13) {
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

        private static int partition(int[] r10, float[] r11, int r12, int r13) {
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

        private static void swap(int[] r10, float[] r11, int r12, int r13) {
            int r14 = r10[r12];
            r10[r12] = r10[r13];
            r10[r13] = r14;
            float r15 = r11[r12];
            r11[r12] = r11[r13];
            r11[r13] = r15;
        }
    }

    public SplineSet() {
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public static SplineSet makeCustomSpline(String r10, KeyFrameArray.CustomArray r11) {
        return new CustomSet(r10, r11);
    }

    public static SplineSet makeCustomSplineSet(String r10, KeyFrameArray.CustomVar r11) {
        return new CustomSpline(r10, r11);
    }

    public static SplineSet makeSpline(String r10, long r11) {
        return new CoreSpline(r10, r11);
    }

    public float get(float r10) {
        return (float) this.mCurveFit.getPos(r10, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float r10) {
        return (float) this.mCurveFit.getSlope(r10, 0);
    }

    public void setPoint(int r10, float r11) {
        int[] r12 = this.mTimePoints;
        if (r12.length >= (this.count + 1)) goto L5;
        this.mTimePoints = Arrays.copyOf(r12, r12.length * 2);
        float[] r13 = this.mValues;
        this.mValues = Arrays.copyOf(r13, r13.length * 2);
    L5:
        int[] r14 = this.mTimePoints;
        int r15 = this.count;
        r14[r15] = r10;
        this.mValues[r15] = r11;
        this.count = r15 + 1;
    }

    public void setProperty(TypedValues r10, float r11) {
        r10.setValue(TypedValues.AttributesType.getId(this.mType), get(r11));
    }

    public void setType(String r10) {
        this.mType = r10;
    }

    public void setup(int r10) {
        int r11 = this.count;
        if (r11 != 0) goto L5;
        return;
    L5:
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, r11 - 1);
        int r12 = 1;
        int r13 = 1;
    L7:
        if (r12 >= this.count) goto L12;
        int[] r14 = this.mTimePoints;
        if (r14[r12 - 1] == r14[r12]) goto L11;
        r13 = r13 + 1;
    L11:
        r12 = r12 + 1;
        goto L7
    L12:
        double[] r15 = new double[r13];
        double[][] r16 = (double[][]) Array.newInstance(double.class, new int[]{r13, 1});
        int r17 = 0;
        int r18 = 0;
    L14:
        if (r17 >= this.count) goto L21;
        if (r17 <= 0) goto L19;
        int[] r19 = this.mTimePoints;
        if (r19[r17] != r19[r17 - 1]) goto L19;
    L20:
        r17 = r17 + 1;
    L19:
        r15[r18] = ((double) this.mTimePoints[r17]) * 0.01d;
        r16[r18][0] = this.mValues[r17];
        r18 = r18 + 1;
        goto L20
    L21:
        this.mCurveFit = CurveFit.get(r10, r15, r16);
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
