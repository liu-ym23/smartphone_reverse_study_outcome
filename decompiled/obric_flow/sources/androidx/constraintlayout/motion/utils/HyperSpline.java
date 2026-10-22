package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double r5, double r10, double r11, double r12) {
            this.mA = r5;
            this.mB = r10;
            this.mC = r11;
            this.mD = r12;
        }

        public double eval(double r5) {
            return (((((this.mD * r5) + this.mC) * r5) + this.mB) * r5) + this.mA;
        }

        public double vel(double r10) {
            double r5 = (this.mD * 0.3333333333333333d) * r10;
            return (((this.mC * 0.5d) + r5) * r10) + this.mB;
        }
    }

    public HyperSpline(double[][] r5) {
        setup(r5);
    }

    public static Cubic[] calcNaturalCubic(int r23, double[] r24) {
        double[] r5 = new double[r23];
        double[] r10 = new double[r23];
        double[] r11 = new double[r23];
        int r12 = r23 - 1;
        int r13 = 0;
        r5[0] = 0.5d;
        int r14 = 1;
        int r15 = 1;
    L4:
        if (r15 >= r12) goto L6;
        r5[r15] = 1.0d / (4.0d - r5[r15 - 1]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = r23 - 2;
        r5[r12] = 1.0d / (2.0d - r5[r16]);
        r10[0] = ((r24[1] - r24[0]) * 3.0d) * r5[0];
    L7:
        if (r14 >= r12) goto L9;
        int r17 = r14 + 1;
        int r18 = r14 - 1;
        r10[r14] = (((r24[r17] - r24[r18]) * 3.0d) - r10[r18]) * r5[r14];
        r14 = r17;
        goto L7
    L9:
        double r19 = (((r24[r12] - r24[r16]) * 3.0d) - r10[r16]) * r5[r12];
        r10[r12] = r19;
        r11[r12] = r19;
    L10:
        if (r16 < 0) goto L12;
        r11[r16] = r10[r16] - (r5[r16] * r11[r16 + 1]);
        r16 = r16 - 1;
        goto L10
    L12:
        Cubic[] r20 = new Cubic[r12];
    L13:
        if (r13 >= r12) goto L15;
        double r21 = r24[r13];
        double r110 = r11[r13];
        int r22 = r13 + 1;
        double r111 = r24[r22];
        double r25 = r11[r22];
        r20[r13] = new Cubic((float) r21, r110, (((r111 - r21) * 3.0d) - (r110 * 2.0d)) - r25, (((r21 - r111) * 2.0d) + r110) + r25);
        r13 = r22;
        goto L13
    L15:
        return r20;
    }

    public double approxLength(Cubic[] r15) {
        int r14 = r15.length;
        double[] r16 = new double[r15.length];
        double r5 = 0.0d;
        double r10 = 0.0d;
        double r11 = 0.0d;
    L3:
        int r12 = 0;
        if (r10 >= 1.0d) goto L14;
        double r13 = 0.0d;
    L7:
        if (r12 >= r15.length) goto L10;
        double r17 = r16[r12];
        double r18 = r15[r12].eval(r10);
        r16[r12] = r18;
        double r19 = r17 - r18;
        r13 = r13 + (r19 * r19);
        r12 = r12 + 1;
        goto L7
    L10:
        if (r10 <= 0.0d) goto L12;
        r11 = r11 + Math.sqrt(r13);
    L12:
        r10 = r10 + 0.1d;
    L14:
        if (r12 >= r15.length) goto L17;
        double r20 = r16[r12];
        double r110 = r15[r12].eval(1.0d);
        r16[r12] = r110;
        double r21 = r20 - r110;
        r5 = r5 + (r21 * r21);
        r12 = r12 + 1;
        goto L14
    L17:
        return Math.sqrt(r5) + r11;
    }

    public void getPos(double r10, double[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r5 = 0;
        int r13 = 0;
    L3:
        double[] r14 = this.mCurveLength;
        if (r13 >= (r14.length - 1)) goto L9;
        double r15 = r14[r13];
        if (r15 >= r12) goto L9;
        r12 = r12 - r15;
        r13 = r13 + 1;
    L9:
        if (r5 >= r11.length) goto L11;
        r11[r5] = this.mCurve[r5][r13].eval(r12 / this.mCurveLength[r13]);
        r5 = r5 + 1;
        goto L9
    }

    public void getVelocity(double r10, double[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r5 = 0;
        int r13 = 0;
    L3:
        double[] r14 = this.mCurveLength;
        if (r13 >= (r14.length - 1)) goto L9;
        double r15 = r14[r13];
        if (r15 >= r12) goto L9;
        r12 = r12 - r15;
        r13 = r13 + 1;
    L9:
        if (r5 >= r11.length) goto L11;
        r11[r5] = this.mCurve[r5][r13].vel(r12 / this.mCurveLength[r13]);
        r5 = r5 + 1;
        goto L9
    }

    public void setup(double[][] r10) {
        int r5 = r10[0].length;
        this.mDimensionality = r5;
        int r11 = r10.length;
        this.mPoints = r11;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, new int[]{r5, r11});
        this.mCurve = new Cubic[this.mDimensionality][];
        int r12 = 0;
    L4:
        if (r12 >= this.mDimensionality) goto L10;
        int r13 = 0;
    L7:
        if (r13 >= this.mPoints) goto L9;
        this.mCtl[r12][r13] = r10[r13][r12];
        r13 = r13 + 1;
        goto L7
    L9:
        r12 = r12 + 1;
        goto L4
    L10:
        int r14 = 0;
    L11:
        int r15 = this.mDimensionality;
        if (r14 >= r15) goto L14;
        Cubic[][] r16 = this.mCurve;
        double[] r17 = this.mCtl[r14];
        r16[r14] = calcNaturalCubic(r17.length, r17);
        r14 = r14 + 1;
        goto L11
    L14:
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] r18 = new Cubic[r15];
        int r19 = 0;
    L16:
        if (r19 >= this.mCurveLength.length) goto L22;
        int r20 = 0;
    L19:
        if (r20 >= this.mDimensionality) goto L21;
        r18[r20] = this.mCurve[r20][r19];
        r20 = r20 + 1;
        goto L19
    L21:
        double r21 = this.mTotalLength;
        double[] r22 = this.mCurveLength;
        double r23 = approxLength(r18);
        r22[r19] = r23;
        this.mTotalLength = r21 + r23;
        r19 = r19 + 1;
        goto L16
    }

    public HyperSpline() {
    }

    public void getPos(double r10, float[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r5 = 0;
        int r13 = 0;
    L3:
        double[] r14 = this.mCurveLength;
        if (r13 >= (r14.length - 1)) goto L9;
        double r15 = r14[r13];
        if (r15 >= r12) goto L9;
        r12 = r12 - r15;
        r13 = r13 + 1;
    L9:
        if (r5 >= r11.length) goto L11;
        r11[r5] = (float) this.mCurve[r5][r13].eval(r12 / this.mCurveLength[r13]);
        r5 = r5 + 1;
        goto L9
    }

    public double getPos(double r10, int r11) {
        double r12 = r10 * this.mTotalLength;
        int r5 = 0;
    L3:
        double[] r13 = this.mCurveLength;
        if (r5 >= (r13.length - 1)) goto L9;
        double r14 = r13[r5];
        if (r14 >= r12) goto L9;
        r12 = r12 - r14;
        r5 = r5 + 1;
    L9:
        return this.mCurve[r11][r5].eval(r12 / r13[r5]);
    }
}
