package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private boolean mExtrapolate;
    double[] mSlopeTemp;
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] r13, double[][] r14) {
        this.mTotalLength = Double.NaN;
        this.mExtrapolate = true;
        int r0 = r13.length;
        int r1 = r14[0].length;
        this.mSlopeTemp = new double[r1];
        this.mT = r13;
        this.mY = r14;
        if (r1 <= 2) goto L16;
        int r3 = 0;
        double r4 = 0.0d;
        double r6 = 0.0d;
    L6:
        if (r3 >= r13.length) goto L11;
        double r8 = r14[r3][0];
        double r10 = r14[r3][0];
        if (r3 <= 0) goto L10;
        Math.hypot(r8 - r4, r10 - r6);
    L10:
        r3 = r3 + 1;
        r4 = r8;
        r6 = r10;
        goto L6
    L11:
        this.mTotalLength = 0.0d;
        return;
    }

    private double getLength2D(double r21) {
        if (Double.isNaN(this.mTotalLength) == false) goto L5;
        return 0.0d;
    L5:
        double[] r1 = this.mT;
        int r4 = r1.length;
        if (r21 > r1[0]) goto L8;
        return 0.0d;
    L8:
        int r5 = r4 - 1;
        if (r21 >= r1[r5]) goto L11;
        double r7 = 0.0d;
        double r9 = 0.0d;
        double r11 = 0.0d;
        int r2 = 0;
    L13:
        if (r2 >= r5) goto L25;
        double[][] r13 = this.mY;
        double r14 = r13[r2][0];
        double r16 = r13[r2][1];
        if (r2 <= 0) goto L17;
        r7 = r7 + Math.hypot(r14 - r9, r16 - r11);
    L17:
        double[] r10 = this.mT;
        if (r21 == r10[r2]) goto L19;
        int r12 = r2 + 1;
        if (r21 < r10[r12]) goto L22;
        r2 = r12;
        r9 = r14;
        r11 = r16;
        goto L13
    L22:
        double r15 = (r21 - r10[r2]) / (r10[r12] - r10[r2]);
        double[][] r0 = this.mY;
        double r3 = r0[r2][0];
        double r6 = r0[r12][0];
        double r17 = 1.0d - r15;
        return r7 + Math.hypot(r16 - ((r0[r2][1] * r17) + (r0[r12][1] * r15)), r14 - ((r3 * r17) + (r6 * r15)));
    L19:
        return r7;
    L25:
        return 0.0d;
    L11:
        return this.mTotalLength;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r9, int r11) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        if (this.mExtrapolate == false) goto L13;
        if (r9 <= r0[0]) goto L7;
        int r2 = r1 - 1;
        if (r9 < r0[r2]) goto L21;
        return this.mY[r2][r11] + ((r9 - r0[r2]) * getSlope(r0[r2], r11));
    L21:
        if (r3 >= (r1 - 1)) goto L31;
        double[] r4 = this.mT;
        if (r9 == r4[r3]) goto L25;
        int r5 = r3 + 1;
        if (r9 < r4[r5]) goto L28;
        r3 = r5;
        goto L21
    L28:
        double r10 = (r9 - r4[r3]) / (r4[r5] - r4[r3]);
        double[][] r8 = this.mY;
        return (r8[r3][r11] * (1.0d - r10)) + (r8[r5][r11] * r10);
    L25:
        return this.mY[r3][r11];
    L31:
        return 0.0d;
    L7:
        return this.mY[0][r11] + ((r9 - r0[0]) * getSlope(r0[0], r11));
    L13:
        if (r9 <= r0[0]) goto L15;
        int r6 = r1 - 1;
        if (r9 < r0[r6]) goto L21;
        return this.mY[r6][r11];
    L15:
        return this.mY[0][r11];
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, double[] r15) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r13 > r0[0]) goto L10;
        getSlope(r0[0], this.mSlopeTemp);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r15[r4] = this.mY[0][r4] + ((r13 - this.mT[0]) * this.mSlopeTemp[r4]);
        r4 = r4 + 1;
        goto L7
    L9:
        return;
    L10:
        int r5 = r1 - 1;
        if (r13 < r0[r5]) goto L27;
        getSlope(r0[r5], this.mSlopeTemp);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = this.mY[r5][r3] + ((r13 - this.mT[r5]) * this.mSlopeTemp[r3]);
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r6 = 0;
    L29:
        if (r6 >= (r1 - 1)) goto L42;
        if (r13 != this.mT[r6]) goto L35;
        int r7 = 0;
    L33:
        if (r7 >= r2) goto L35;
        r15[r7] = this.mY[r6][r7];
        r7 = r7 + 1;
    L35:
        double[] r8 = this.mT;
        int r9 = r6 + 1;
        if (r13 < r8[r9]) goto L37;
        r6 = r9;
        goto L29
    L37:
        double r14 = (r13 - r8[r6]) / (r8[r9] - r8[r6]);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r10 = this.mY;
        r15[r3] = (r10[r6][r3] * (1.0d - r14)) + (r10[r9][r3] * r14);
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r2) goto L21;
        r15[r16] = this.mY[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r11 = r1 - 1;
        if (r13 < r0[r11]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = this.mY[r11][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, float[] r15) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r13 > r0[0]) goto L10;
        getSlope(r0[0], this.mSlopeTemp);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r15[r4] = (float) (this.mY[0][r4] + ((r13 - this.mT[0]) * this.mSlopeTemp[r4]));
        r4 = r4 + 1;
        goto L7
    L9:
        return;
    L10:
        int r5 = r1 - 1;
        if (r13 < r0[r5]) goto L27;
        getSlope(r0[r5], this.mSlopeTemp);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = (float) (this.mY[r5][r3] + ((r13 - this.mT[r5]) * this.mSlopeTemp[r3]));
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r6 = 0;
    L29:
        if (r6 >= (r1 - 1)) goto L42;
        if (r13 != this.mT[r6]) goto L35;
        int r7 = 0;
    L33:
        if (r7 >= r2) goto L35;
        r15[r7] = (float) this.mY[r6][r7];
        r7 = r7 + 1;
    L35:
        double[] r8 = this.mT;
        int r9 = r6 + 1;
        if (r13 < r8[r9]) goto L37;
        r6 = r9;
        goto L29
    L37:
        double r14 = (r13 - r8[r6]) / (r8[r9] - r8[r6]);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r10 = this.mY;
        r15[r3] = (float) ((r10[r6][r3] * (1.0d - r14)) + (r10[r9][r3] * r14));
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r2) goto L21;
        r15[r16] = (float) this.mY[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r11 = r1 - 1;
        if (r13 < r0[r11]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = (float) this.mY[r11][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r7, int r9) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r2 = 0;
        if (r7 >= r0[0]) goto L5;
        r7 = r0[0];
    L9:
        if (r2 >= (r1 - 1)) goto L15;
        double[] r3 = this.mT;
        int r4 = r2 + 1;
        if (r7 <= r3[r4]) goto L12;
        r2 = r4;
        goto L9
    L12:
        double r8 = r3[r4] - r3[r2];
        double r5 = r3[r2];
        double[][] r6 = this.mY;
        return (r6[r4][r9] - r6[r2][r9]) / r8;
    L15:
        return 0.0d;
    L5:
        int r10 = r1 - 1;
        if (r7 < r0[r10]) goto L9;
        r7 = r0[r10];
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r11, double[] r13) {
        double[] r0 = this.mT;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.mY[0].length;
        if (r11 > r0[0]) goto L5;
        r11 = r0[0];
    L8:
        int r4 = 0;
    L10:
        if (r4 >= (r1 - 1)) goto L17;
        double[] r5 = this.mT;
        int r6 = r4 + 1;
        if (r11 <= r5[r6]) goto L13;
        r4 = r6;
        goto L10
    L13:
        double r12 = r5[r6] - r5[r4];
        double r7 = r5[r4];
    L14:
        if (r3 >= r2) goto L21;
        double[][] r8 = this.mY;
        r13[r3] = (r8[r6][r3] - r8[r4][r3]) / r12;
        r3 = r3 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        int r9 = r1 - 1;
        if (r11 < r0[r9]) goto L8;
        r11 = r0[r9];
        goto L8
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
