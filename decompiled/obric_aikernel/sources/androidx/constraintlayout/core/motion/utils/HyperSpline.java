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

        public Cubic(double r10, double r11, double r12, double r13) {
            this.mA = r10;
            this.mB = r11;
            this.mC = r12;
            this.mD = r13;
        }

        public double eval(double r10) {
            return (((((this.mD * r10) + this.mC) * r10) + this.mB) * r10) + this.mA;
        }

        public double vel(double r10) {
            return ((((this.mD * 3.0d) * r10) + (this.mC * 2.0d)) * r10) + this.mB;
        }
    }

    public HyperSpline() {
    }

    public HyperSpline(double[][] r10) {
        setup(r10);
    }

    static Cubic[] calcNaturalCubic(int r22, double[] r23) {
        double[] r10 = new double[r22];
        double[] r11 = new double[r22];
        double[] r12 = new double[r22];
        int r13 = r22 - 1;
        int r14 = 0;
        r10[0] = 0.5d;
        int r15 = 1;
        int r16 = 1;
    L4:
        if (r16 >= r13) goto L6;
        r10[r16] = 1.0d / (4.0d - r10[r16 - 1]);
        r16 = r16 + 1;
        goto L4
    L6:
        int r17 = r13 - 1;
        r10[r13] = 1.0d / (2.0d - r10[r17]);
        r11[0] = ((r23[1] - r23[0]) * 3.0d) * r10[0];
    L7:
        if (r15 >= r13) goto L9;
        int r18 = r15 + 1;
        int r19 = r15 - 1;
        r11[r15] = (((r23[r18] - r23[r19]) * 3.0d) - r11[r19]) * r10[r15];
        r15 = r18;
        goto L7
    L9:
        r11[r13] = (((r23[r13] - r23[r17]) * 3.0d) - r11[r17]) * r10[r13];
        r12[r13] = r11[r13];
    L10:
        if (r17 < 0) goto L12;
        r12[r17] = r11[r17] - (r10[r17] * r12[r17 + 1]);
        r17 = r17 - 1;
        goto L10
    L12:
        Cubic[] r20 = new Cubic[r13];
    L13:
        if (r14 >= r13) goto L15;
        int r21 = r14 + 1;
        r20[r14] = new Cubic((float) r23[r14], r12[r14], (((r23[r21] - r23[r14]) * 3.0d) - (r12[r14] * 2.0d)) - r12[r21], (((r23[r14] - r23[r21]) * 2.0d) + r12[r14]) + r12[r21]);
        r14 = r21;
        goto L13
    L15:
        return r20;
    }

    public double approxLength(Cubic[] r15) {
        int r14 = r15.length;
        double[] r16 = new double[r15.length];
        double r10 = 0.0d;
        double r11 = 0.0d;
        double r12 = 0.0d;
    L3:
        int r13 = 0;
        if (r11 >= 1.0d) goto L14;
        double r17 = 0.0d;
    L7:
        if (r13 >= r15.length) goto L10;
        double r18 = r16[r13];
        double r19 = r15[r13].eval(r11);
        r16[r13] = r19;
        double r110 = r18 - r19;
        r17 = r17 + (r110 * r110);
        r13 = r13 + 1;
        goto L7
    L10:
        if (r11 <= 0.0d) goto L12;
        r12 = r12 + Math.sqrt(r17);
    L12:
        r11 = r11 + 0.1d;
    L14:
        if (r13 >= r15.length) goto L17;
        double r20 = r16[r13];
        double r111 = r15[r13].eval(1.0d);
        r16[r13] = r111;
        double r21 = r20 - r111;
        r10 = r10 + (r21 * r21);
        r13 = r13 + 1;
        goto L14
    L17:
        return r12 + Math.sqrt(r10);
    }

    public double getPos(double r10, int r11) {
        double r12 = r10 * this.mTotalLength;
        int r13 = 0;
    L3:
        double[] r14 = this.mCurveLength;
        if (r13 >= (r14.length - 1)) goto L9;
        if (r14[r13] >= r12) goto L9;
        r12 = r12 - r14[r13];
        r13 = r13 + 1;
    L9:
        return this.mCurve[r11][r13].eval(r12 / r14[r13]);
    }

    public void getPos(double r10, double[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r13 = 0;
        int r14 = 0;
    L3:
        double[] r15 = this.mCurveLength;
        if (r14 >= (r15.length - 1)) goto L9;
        if (r15[r14] >= r12) goto L9;
        r12 = r12 - r15[r14];
        r14 = r14 + 1;
    L9:
        if (r13 >= r11.length) goto L11;
        r11[r13] = this.mCurve[r13][r14].eval(r12 / this.mCurveLength[r14]);
        r13 = r13 + 1;
        goto L9
    }

    public void getPos(double r10, float[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r13 = 0;
        int r14 = 0;
    L3:
        double[] r15 = this.mCurveLength;
        if (r14 >= (r15.length - 1)) goto L9;
        if (r15[r14] >= r12) goto L9;
        r12 = r12 - r15[r14];
        r14 = r14 + 1;
    L9:
        if (r13 >= r11.length) goto L11;
        r11[r13] = (float) this.mCurve[r13][r14].eval(r12 / this.mCurveLength[r14]);
        r13 = r13 + 1;
        goto L9
    }

    public void getVelocity(double r10, double[] r11) {
        double r12 = r10 * this.mTotalLength;
        int r13 = 0;
        int r14 = 0;
    L3:
        double[] r15 = this.mCurveLength;
        if (r14 >= (r15.length - 1)) goto L9;
        if (r15[r14] >= r12) goto L9;
        r12 = r12 - r15[r14];
        r14 = r14 + 1;
    L9:
        if (r13 >= r11.length) goto L11;
        r11[r13] = this.mCurve[r13][r14].vel(r12 / this.mCurveLength[r14]);
        r13 = r13 + 1;
        goto L9
    }

    public void setup(double[][] r10) {
        int r11 = r10[0].length;
        this.mDimensionality = r11;
        int r12 = r10.length;
        this.mPoints = r12;
        this.mCtl = (double[][]) Array.newInstance(double.class, new int[]{r11, r12});
        this.mCurve = new Cubic[this.mDimensionality][];
        int r13 = 0;
    L4:
        if (r13 >= this.mDimensionality) goto L10;
        int r14 = 0;
    L7:
        if (r14 >= this.mPoints) goto L9;
        this.mCtl[r13][r14] = r10[r14][r13];
        r14 = r14 + 1;
        goto L7
    L9:
        r13 = r13 + 1;
        goto L4
    L10:
        int r15 = 0;
    L11:
        int r16 = this.mDimensionality;
        if (r15 >= r16) goto L14;
        Cubic[][] r17 = this.mCurve;
        double[][] r18 = this.mCtl;
        r17[r15] = calcNaturalCubic(r18[r15].length, r18[r15]);
        r15 = r15 + 1;
        goto L11
    L14:
        this.mCurveLength = new double[this.mPoints - 1];
        this.mTotalLength = 0.0d;
        Cubic[] r19 = new Cubic[r16];
        int r20 = 0;
    L16:
        if (r20 >= this.mCurveLength.length) goto L22;
        int r21 = 0;
    L19:
        if (r21 >= this.mDimensionality) goto L21;
        r19[r21] = this.mCurve[r21][r20];
        r21 = r21 + 1;
        goto L19
    L21:
        double r22 = this.mTotalLength;
        double[] r23 = this.mCurveLength;
        double r24 = approxLength(r19);
        r23[r20] = r24;
        this.mTotalLength = r22 + r24;
        r20 = r20 + 1;
        goto L16
    }
}
