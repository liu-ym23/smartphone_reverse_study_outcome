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
        int r10 = r13.length;
        int r11 = r14[0].length;
        this.mSlopeTemp = new double[r11];
        this.mT = r13;
        this.mY = r14;
        if (r11 <= 2) goto L16;
        int r12 = 0;
        double r15 = 0.0d;
        double r16 = 0.0d;
    L6:
        if (r12 >= r13.length) goto L11;
        double r17 = r14[r12][0];
        double r18 = r14[r12][0];
        if (r12 <= 0) goto L10;
        Math.hypot(r17 - r15, r18 - r16);
    L10:
        r12 = r12 + 1;
        r15 = r17;
        r16 = r18;
        goto L6
    L11:
        this.mTotalLength = 0.0d;
        return;
    }

    private double getLength2D(double r21) {
        if (Double.isNaN(this.mTotalLength) == false) goto L5;
        return 0.0d;
    L5:
        double[] r10 = this.mT;
        int r11 = r10.length;
        if (r21 > r10[0]) goto L8;
        return 0.0d;
    L8:
        int r12 = r11 - 1;
        if (r21 >= r10[r12]) goto L11;
        double r13 = 0.0d;
        double r14 = 0.0d;
        double r15 = 0.0d;
        int r16 = 0;
    L13:
        if (r16 >= r12) goto L25;
        double[][] r17 = this.mY;
        double r18 = r17[r16][0];
        double r19 = r17[r16][1];
        if (r16 <= 0) goto L17;
        r13 = r13 + Math.hypot(r18 - r14, r19 - r15);
    L17:
        double[] r20 = this.mT;
        if (r21 == r20[r16]) goto L19;
        int r110 = r16 + 1;
        if (r21 < r20[r110]) goto L22;
        r16 = r110;
        r14 = r18;
        r15 = r19;
        goto L13
    L22:
        double r111 = (r21 - r20[r16]) / (r20[r110] - r20[r16]);
        double[][] r22 = this.mY;
        double r23 = r22[r16][0];
        double r24 = r22[r110][0];
        double r25 = 1.0d - r111;
        return r13 + Math.hypot(r19 - ((r22[r16][1] * r25) + (r22[r110][1] * r111)), r18 - ((r23 * r25) + (r24 * r111)));
    L19:
        return r13;
    L25:
        return 0.0d;
    L11:
        return this.mTotalLength;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r10, int r11) {
        double[] r12 = this.mT;
        int r13 = r12.length;
        int r14 = 0;
        if (this.mExtrapolate == false) goto L13;
        if (r10 <= r12[0]) goto L7;
        int r15 = r13 - 1;
        if (r10 < r12[r15]) goto L21;
        return this.mY[r15][r11] + ((r10 - r12[r15]) * getSlope(r12[r15], r11));
    L21:
        if (r14 >= (r13 - 1)) goto L31;
        double[] r16 = this.mT;
        if (r10 == r16[r14]) goto L25;
        int r17 = r14 + 1;
        if (r10 < r16[r17]) goto L28;
        r14 = r17;
        goto L21
    L28:
        double r18 = (r10 - r16[r14]) / (r16[r17] - r16[r14]);
        double[][] r19 = this.mY;
        return (r19[r14][r11] * (1.0d - r18)) + (r19[r17][r11] * r18);
    L25:
        return this.mY[r14][r11];
    L31:
        return 0.0d;
    L7:
        return this.mY[0][r11] + ((r10 - r12[0]) * getSlope(r12[0], r11));
    L13:
        if (r10 <= r12[0]) goto L15;
        int r20 = r13 - 1;
        if (r10 < r12[r20]) goto L21;
        return this.mY[r20][r11];
    L15:
        return this.mY[0][r11];
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, double[] r15) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        int r14 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r13 > r10[0]) goto L10;
        getSlope(r10[0], this.mSlopeTemp);
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r15[r16] = this.mY[0][r16] + ((r13 - this.mT[0]) * this.mSlopeTemp[r16]);
        r16 = r16 + 1;
        goto L7
    L9:
        return;
    L10:
        int r17 = r11 - 1;
        if (r13 < r10[r17]) goto L27;
        getSlope(r10[r17], this.mSlopeTemp);
    L13:
        if (r12 >= r14) goto L15;
        r15[r12] = this.mY[r17][r12] + ((r13 - this.mT[r17]) * this.mSlopeTemp[r12]);
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r18 = 0;
    L29:
        if (r18 >= (r11 - 1)) goto L42;
        if (r13 != this.mT[r18]) goto L35;
        int r19 = 0;
    L33:
        if (r19 >= r14) goto L35;
        r15[r19] = this.mY[r18][r19];
        r19 = r19 + 1;
    L35:
        double[] r20 = this.mT;
        int r21 = r18 + 1;
        if (r13 < r20[r21]) goto L37;
        r18 = r21;
        goto L29
    L37:
        double r110 = (r13 - r20[r18]) / (r20[r21] - r20[r18]);
    L38:
        if (r12 >= r14) goto L40;
        double[][] r22 = this.mY;
        r15[r12] = (r22[r18][r12] * (1.0d - r110)) + (r22[r21][r12] * r110);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r10[0]) goto L22;
        int r111 = 0;
    L19:
        if (r111 >= r14) goto L21;
        r15[r111] = this.mY[0][r111];
        r111 = r111 + 1;
        goto L19
    L21:
        return;
    L22:
        int r23 = r11 - 1;
        if (r13 < r10[r23]) goto L27;
    L24:
        if (r12 >= r14) goto L26;
        r15[r12] = this.mY[r23][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r13, float[] r15) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        int r14 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r13 > r10[0]) goto L10;
        getSlope(r10[0], this.mSlopeTemp);
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L9;
        r15[r16] = (float) (this.mY[0][r16] + ((r13 - this.mT[0]) * this.mSlopeTemp[r16]));
        r16 = r16 + 1;
        goto L7
    L9:
        return;
    L10:
        int r17 = r11 - 1;
        if (r13 < r10[r17]) goto L27;
        getSlope(r10[r17], this.mSlopeTemp);
    L13:
        if (r12 >= r14) goto L15;
        r15[r12] = (float) (this.mY[r17][r12] + ((r13 - this.mT[r17]) * this.mSlopeTemp[r12]));
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r18 = 0;
    L29:
        if (r18 >= (r11 - 1)) goto L42;
        if (r13 != this.mT[r18]) goto L35;
        int r19 = 0;
    L33:
        if (r19 >= r14) goto L35;
        r15[r19] = (float) this.mY[r18][r19];
        r19 = r19 + 1;
    L35:
        double[] r20 = this.mT;
        int r21 = r18 + 1;
        if (r13 < r20[r21]) goto L37;
        r18 = r21;
        goto L29
    L37:
        double r110 = (r13 - r20[r18]) / (r20[r21] - r20[r18]);
    L38:
        if (r12 >= r14) goto L40;
        double[][] r22 = this.mY;
        r15[r12] = (float) ((r22[r18][r12] * (1.0d - r110)) + (r22[r21][r12] * r110));
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r10[0]) goto L22;
        int r111 = 0;
    L19:
        if (r111 >= r14) goto L21;
        r15[r111] = (float) this.mY[0][r111];
        r111 = r111 + 1;
        goto L19
    L21:
        return;
    L22:
        int r23 = r11 - 1;
        if (r13 < r10[r23]) goto L27;
    L24:
        if (r12 >= r14) goto L26;
        r15[r12] = (float) this.mY[r23][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r10, int r11) {
        double[] r12 = this.mT;
        int r13 = r12.length;
        int r14 = 0;
        if (r10 >= r12[0]) goto L5;
        r10 = r12[0];
    L9:
        if (r14 >= (r13 - 1)) goto L15;
        double[] r15 = this.mT;
        int r16 = r14 + 1;
        if (r10 <= r15[r16]) goto L12;
        r14 = r16;
        goto L9
    L12:
        double r17 = r15[r16] - r15[r14];
        double r18 = r15[r14];
        double[][] r19 = this.mY;
        return (r19[r16][r11] - r19[r14][r11]) / r17;
    L15:
        return 0.0d;
    L5:
        int r20 = r13 - 1;
        if (r10 < r12[r20]) goto L9;
        r10 = r12[r20];
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r11, double[] r13) {
        double[] r10 = this.mT;
        int r12 = r10.length;
        int r14 = 0;
        int r15 = this.mY[0].length;
        if (r11 > r10[0]) goto L5;
        r11 = r10[0];
    L8:
        int r16 = 0;
    L10:
        if (r16 >= (r12 - 1)) goto L17;
        double[] r17 = this.mT;
        int r18 = r16 + 1;
        if (r11 <= r17[r18]) goto L13;
        r16 = r18;
        goto L10
    L13:
        double r19 = r17[r18] - r17[r16];
        double r20 = r17[r16];
    L14:
        if (r14 >= r15) goto L21;
        double[][] r21 = this.mY;
        r13[r14] = (r21[r18][r14] - r21[r16][r14]) / r19;
        r14 = r14 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        int r22 = r12 - 1;
        if (r11 < r10[r22]) goto L8;
        r11 = r10[r22];
        goto L8
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
