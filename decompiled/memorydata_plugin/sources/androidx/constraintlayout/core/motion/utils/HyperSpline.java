package androidx.constraintlayout.core.motion.utils;

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
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double r1, double r3, double r5, double r7) {
            this.mA = r1;
            this.mB = r3;
            this.mC = r5;
            this.mD = r7;
        }

        public double eval(double r5) {
            return (((((this.mD * r5) + this.mC) * r5) + this.mB) * r5) + this.mA;
        }

        public double vel(double r7) {
            return ((((this.mD * 3.0d) * r7) + (this.mC * 2.0d)) * r7) + this.mB;
        }
    }

    public HyperSpline() {
    }

    public HyperSpline(double[][] r1) {
        setup(r1);
    }

    static Cubic[] calcNaturalCubic(int r22, double[] r23) {
        double[] r1 = new double[r22];
        double[] r2 = new double[r22];
        double[] r3 = new double[r22];
        int r0 = r22 - 1;
        int r6 = 0;
        r1[0] = 0.5d;
        int r4 = 1;
        int r5 = 1;
    L4:
        if (r5 >= r0) goto L6;
        r1[r5] = 1.0d / (4.0d - r1[r5 - 1]);
        r5 = r5 + 1;
        goto L4
    L6:
        int r7 = r0 - 1;
        r1[r0] = 1.0d / (2.0d - r1[r7]);
        r2[0] = ((r23[1] - r23[0]) * 3.0d) * r1[0];
    L7:
        if (r4 >= r0) goto L9;
        int r8 = r4 + 1;
        int r9 = r4 - 1;
        r2[r4] = (((r23[r8] - r23[r9]) * 3.0d) - r2[r9]) * r1[r4];
        r4 = r8;
        goto L7
    L9:
        r2[r0] = (((r23[r0] - r23[r7]) * 3.0d) - r2[r7]) * r1[r0];
        r3[r0] = r2[r0];
    L10:
        if (r7 < 0) goto L12;
        r3[r7] = r2[r7] - (r1[r7] * r3[r7 + 1]);
        r7 = r7 - 1;
        goto L10
    L12:
        Cubic[] r10 = new Cubic[r0];
    L13:
        if (r6 >= r0) goto L15;
        int r11 = r6 + 1;
        r10[r6] = new Cubic((float) r23[r6], r3[r6], (((r23[r11] - r23[r6]) * 3.0d) - (r3[r6] * 2.0d)) - r3[r11], (((r23[r6] - r23[r11]) * 2.0d) + r3[r6]) + r3[r11]);
        r6 = r11;
        goto L13
    L15:
        return r10;
    }

    public double approxLength(Cubic[] r15) {
        int r14 = r15.length;
        double[] r16 = new double[r15.length];
        double r0 = 0.0d;
        double r2 = 0.0d;
        double r4 = 0.0d;
    L3:
        int r9 = 0;
        if (r2 >= 1.0d) goto L14;
        double r6 = 0.0d;
    L7:
        if (r9 >= r15.length) goto L10;
        double r10 = r16[r9];
        double r12 = r15[r9].eval(r2);
        r16[r9] = r12;
        double r11 = r10 - r12;
        r6 = r6 + (r11 * r11);
        r9 = r9 + 1;
        goto L7
    L10:
        if (r2 <= 0.0d) goto L12;
        r4 = r4 + Math.sqrt(r6);
    L12:
        r2 = r2 + 0.1d;
    L14:
        if (r9 >= r15.length) goto L17;
        double r3 = r16[r9];
        double r13 = r15[r9].eval(1.0d);
        r16[r9] = r13;
        double r5 = r3 - r13;
        r0 = r0 + (r5 * r5);
        r9 = r9 + 1;
        goto L14
    L17:
        return r4 + Math.sqrt(r0);
    }

    public double getPos(double r5, int r7) {
        double r6 = r5 * this.mTotalLength;
        int r0 = 0;
    L3:
        double[] r1 = this.mCurveLength;
        if (r0 >= (r1.length - 1)) goto L9;
        if (r1[r0] >= r6) goto L9;
        r6 = r6 - r1[r0];
        r0 = r0 + 1;
    L9:
        return this.mCurve[r7][r0].eval(r6 / r1[r0]);
    }

    public void getPos(double r6, double[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        if (r2[r1] >= r7) goto L9;
        r7 = r7 - r2[r1];
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = this.mCurve[r0][r1].eval(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public void getPos(double r6, float[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        if (r2[r1] >= r7) goto L9;
        r7 = r7 - r2[r1];
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = (float) this.mCurve[r0][r1].eval(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public void getVelocity(double r6, double[] r8) {
        double r7 = r6 * this.mTotalLength;
        int r0 = 0;
        int r1 = 0;
    L3:
        double[] r2 = this.mCurveLength;
        if (r1 >= (r2.length - 1)) goto L9;
        if (r2[r1] >= r7) goto L9;
        r7 = r7 - r2[r1];
        r1 = r1 + 1;
    L9:
        if (r0 >= r8.length) goto L11;
        r8[r0] = this.mCurve[r0][r1].vel(r7 / this.mCurveLength[r1]);
        r0 = r0 + 1;
        goto L9
    }

    public void setup(double[][] r8) {
        int r1 = r8[0].length;
        this.mDimensionality = r1;
        int r2 = r8.length;
        this.mPoints = r2;
        this.mCtl = (double[][]) Array.newInstance(double.class, new int[]{r1, r2});
        this.mCurve = new Cubic[this.mDimensionality][];
        int r3 = 0;
    L4:
        if (r3 >= this.mDimensionality) goto L10;
        int r4 = 0;
    L7:
        if (r4 >= this.mPoints) goto L9;
        this.mCtl[r3][r4] = r8[r4][r3];
        r4 = r4 + 1;
        goto L7
    L9:
        r3 = r3 + 1;
        goto L4
    L10:
        int r9 = 0;
    L11:
        int r5 = this.mDimensionality;
        if (r9 >= r5) goto L14;
        Cubic[][] r6 = this.mCurve;
        double[][] r7 = this.mCtl;
        r6[r9] = calcNaturalCubic(r7[r9].length, r7[r9]);
        r9 = r9 + 1;
        goto L11
    L14:
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] r10 = new Cubic[r5];
        int r11 = 0;
    L16:
        if (r11 >= this.mCurveLength.length) goto L22;
        int r12 = 0;
    L19:
        if (r12 >= this.mDimensionality) goto L21;
        r10[r12] = this.mCurve[r12][r11];
        r12 = r12 + 1;
        goto L19
    L21:
        double r13 = this.mTotalLength;
        double[] r14 = this.mCurveLength;
        double r15 = approxLength(r10);
        r14[r11] = r15;
        this.mTotalLength = r13 + r15;
        r11 = r11 + 1;
        goto L16
    }
}
