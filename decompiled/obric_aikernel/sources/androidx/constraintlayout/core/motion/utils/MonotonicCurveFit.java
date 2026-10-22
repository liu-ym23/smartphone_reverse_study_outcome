package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private boolean mExtrapolate;
    double[] mSlopeTemp;
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] r22, double[][] r23) {
        this.mExtrapolate = true;
        int r10 = r22.length;
        int r11 = r23[0].length;
        this.mSlopeTemp = new double[r11];
        int r12 = r10 - 1;
        double[][] r13 = (double[][]) Array.newInstance(double.class, new int[]{r12, r11});
        double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{r10, r11});
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L12;
        int r16 = 0;
    L5:
        if (r16 >= r12) goto L11;
        int r17 = r16 + 1;
        r13[r16][r15] = (r23[r17][r15] - r23[r16][r15]) / (r22[r17] - r22[r16]);
        if (r16 != 0) goto L9;
        r14[r16][r15] = r13[r16][r15];
    L10:
        r16 = r17;
        goto L5
    L9:
        r14[r16][r15] = (r13[r16 - 1][r15] + r13[r16][r15]) * 0.5d;
        goto L10
    L11:
        r14[r12][r15] = r13[r10 - 2][r15];
        r15 = r15 + 1;
        goto L3
    L12:
        int r18 = 0;
    L13:
        if (r18 >= r12) goto L24;
        int r19 = 0;
    L15:
        if (r19 >= r11) goto L23;
        if (r13[r18][r19] != 0.0d) goto L19;
        r14[r18][r19] = 0.0d;
        r14[r18 + 1][r19] = 0.0d;
    L22:
        r19 = r19 + 1;
        goto L15
    L19:
        double r110 = r14[r18][r19] / r13[r18][r19];
        int r20 = r18 + 1;
        double r111 = r14[r20][r19] / r13[r18][r19];
        double r112 = Math.hypot(r110, r111);
        if (r112 <= 9.0d) goto L22;
        double r113 = 3.0d / r112;
        r14[r18][r19] = (r110 * r113) * r13[r18][r19];
        r14[r20][r19] = (r113 * r111) * r13[r18][r19];
        goto L22
    L23:
        r18 = r18 + 1;
        goto L13
    L24:
        this.mT = r22;
        this.mY = r23;
        this.mTangent = r14;
    }

    public static MonotonicCurveFit buildWave(String r10) {
        double[] r11 = new double[r10.length() / 2];
        int r12 = r10.indexOf(40) + 1;
        int r13 = r10.indexOf(44, r12);
        int r14 = 0;
    L4:
        if (r13 == (-1)) goto L6;
        r11[r14] = Double.parseDouble(r10.substring(r12, r13).trim());
        r12 = r13 + 1;
        r13 = r10.indexOf(44, r12);
        r14 = r14 + 1;
        goto L4
    L6:
        String r15 = r10.substring(r12, r10.indexOf(41, r12)).trim();
        r11[r14] = Double.parseDouble(r15);
        return buildWave(Arrays.copyOf(r11, r14 + 1));
    }

    private static MonotonicCurveFit buildWave(double[] r18) {
        int r10 = (r18.length * 3) - 2;
        int r11 = r18.length - 1;
        double r12 = 1.0d / ((double) r11);
        double[][] r13 = (double[][]) Array.newInstance(double.class, new int[]{r10, 1});
        double[] r14 = new double[r10];
        int r15 = 0;
    L4:
        if (r15 >= r18.length) goto L10;
        double r16 = r18[r15];
        int r17 = r15 + r11;
        r13[r17][0] = r16;
        double r19 = ((double) r15) * r12;
        r14[r17] = r19;
        if (r15 <= 0) goto L8;
        int r110 = (r11 * 2) + r15;
        r13[r110][0] = r16 + 1.0d;
        r14[r110] = r19 + 1.0d;
        int r111 = r15 - 1;
        r13[r111][0] = (r16 - 1.0d) - r12;
        r14[r111] = (r19 - 1.0d) - r12;
    L8:
        r15 = r15 + 1;
        goto L4
    L10:
        return new MonotonicCurveFit(r14, r13);
    }

    private static double diff(double r10, double r12, double r14, double r16, double r18, double r20) {
        double r11 = r12 * r12;
        double r13 = r12 * 6.0d;
        double r15 = (((((-6.0d) * r11) * r16) + (r13 * r16)) + ((6.0d * r11) * r14)) - (r13 * r14);
        double r17 = 3.0d * r10;
        return ((((r15 + ((r17 * r20) * r11)) + ((r17 * r18) * r11)) - (((2.0d * r10) * r20) * r12)) - (((4.0d * r10) * r18) * r12)) + (r10 * r18);
    }

    private static double interpolate(double r12, double r14, double r16, double r18, double r20, double r22) {
        double r10 = r14 * r14;
        double r11 = r10 * r14;
        double r13 = 3.0d * r10;
        double r15 = ((((((-2.0d) * r11) * r18) + (r13 * r18)) + ((r11 * 2.0d) * r16)) - (r13 * r16)) + r16;
        double r17 = r12 * r22;
        double r19 = r15 + (r17 * r11);
        double r110 = r12 * r20;
        return (((r19 + (r11 * r110)) - (r17 * r10)) - (((r12 * 2.0d) * r20) * r10)) + (r110 * r14);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r23, int r25) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        if (this.mExtrapolate == false) goto L13;
        if (r23 <= r10[0]) goto L7;
        int r13 = r11 - 1;
        if (r23 < r10[r13]) goto L21;
        return this.mY[r13][r25] + ((r23 - r10[r13]) * getSlope(r10[r13], r25));
    L21:
        if (r12 >= (r11 - 1)) goto L31;
        double[] r14 = this.mT;
        if (r23 == r14[r12]) goto L25;
        int r15 = r12 + 1;
        if (r23 < r14[r15]) goto L28;
        r12 = r15;
        goto L21
    L28:
        double r16 = r14[r15] - r14[r12];
        double r17 = (r23 - r14[r12]) / r16;
        double[][] r18 = this.mY;
        double r19 = r18[r12][r25];
        double r110 = r18[r15][r25];
        double[][] r20 = this.mTangent;
        return interpolate(r16, r17, r19, r110, r20[r12][r25], r20[r15][r25]);
    L25:
        return this.mY[r12][r25];
    L31:
        return 0.0d;
    L7:
        return this.mY[0][r25] + ((r23 - r10[0]) * getSlope(r10[0], r25));
    L13:
        if (r23 <= r10[0]) goto L15;
        int r21 = r11 - 1;
        if (r23 < r10[r21]) goto L21;
        return this.mY[r21][r25];
    L15:
        return this.mY[0][r25];
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r24, double[] r26) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r24 > r10[0]) goto L10;
        getSlope(r10[0], this.mSlopeTemp);
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r26[r14] = this.mY[0][r14] + ((r24 - this.mT[0]) * this.mSlopeTemp[r14]);
        r14 = r14 + 1;
        goto L7
    L9:
        return;
    L10:
        int r15 = r11 - 1;
        if (r24 < r10[r15]) goto L27;
        getSlope(r10[r15], this.mSlopeTemp);
    L13:
        if (r12 >= r13) goto L15;
        r26[r12] = this.mY[r15][r12] + ((r24 - this.mT[r15]) * this.mSlopeTemp[r12]);
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r16 = 0;
    L29:
        if (r16 >= (r11 - 1)) goto L42;
        if (r24 != this.mT[r16]) goto L35;
        int r17 = 0;
    L33:
        if (r17 >= r13) goto L35;
        r26[r17] = this.mY[r16][r17];
        r17 = r17 + 1;
    L35:
        double[] r18 = this.mT;
        int r19 = r16 + 1;
        if (r24 < r18[r19]) goto L37;
        r16 = r19;
        goto L29
    L37:
        double r20 = r18[r19] - r18[r16];
        double r21 = (r24 - r18[r16]) / r20;
    L38:
        if (r12 >= r13) goto L40;
        double[][] r22 = this.mY;
        double r110 = r22[r16][r12];
        double r111 = r22[r19][r12];
        double[][] r23 = this.mTangent;
        r26[r12] = interpolate(r20, r21, r110, r111, r23[r16][r12], r23[r19][r12]);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r10[0]) goto L22;
        int r25 = 0;
    L19:
        if (r25 >= r13) goto L21;
        r26[r25] = this.mY[0][r25];
        r25 = r25 + 1;
        goto L19
    L21:
        return;
    L22:
        int r27 = r11 - 1;
        if (r24 < r10[r27]) goto L27;
    L24:
        if (r12 >= r13) goto L26;
        r26[r12] = this.mY[r27][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r24, float[] r26) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.mY[0].length;
        if (this.mExtrapolate == false) goto L17;
        if (r24 > r10[0]) goto L10;
        getSlope(r10[0], this.mSlopeTemp);
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r26[r14] = (float) (this.mY[0][r14] + ((r24 - this.mT[0]) * this.mSlopeTemp[r14]));
        r14 = r14 + 1;
        goto L7
    L9:
        return;
    L10:
        int r15 = r11 - 1;
        if (r24 < r10[r15]) goto L27;
        getSlope(r10[r15], this.mSlopeTemp);
    L13:
        if (r12 >= r13) goto L15;
        r26[r12] = (float) (this.mY[r15][r12] + ((r24 - this.mT[r15]) * this.mSlopeTemp[r12]));
        r12 = r12 + 1;
        goto L13
    L15:
        return;
    L27:
        int r16 = 0;
    L29:
        if (r16 >= (r11 - 1)) goto L42;
        if (r24 != this.mT[r16]) goto L35;
        int r17 = 0;
    L33:
        if (r17 >= r13) goto L35;
        r26[r17] = (float) this.mY[r16][r17];
        r17 = r17 + 1;
    L35:
        double[] r18 = this.mT;
        int r19 = r16 + 1;
        if (r24 < r18[r19]) goto L37;
        r16 = r19;
        goto L29
    L37:
        double r20 = r18[r19] - r18[r16];
        double r21 = (r24 - r18[r16]) / r20;
    L38:
        if (r12 >= r13) goto L40;
        double[][] r22 = this.mY;
        double r110 = r22[r16][r12];
        double r111 = r22[r19][r12];
        double[][] r23 = this.mTangent;
        r26[r12] = (float) interpolate(r20, r21, r110, r111, r23[r16][r12], r23[r19][r12]);
        r12 = r12 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r24 > r10[0]) goto L22;
        int r25 = 0;
    L19:
        if (r25 >= r13) goto L21;
        r26[r25] = (float) this.mY[0][r25];
        r25 = r25 + 1;
        goto L19
    L21:
        return;
    L22:
        int r27 = r11 - 1;
        if (r24 < r10[r27]) goto L27;
    L24:
        if (r12 >= r13) goto L26;
        r26[r12] = (float) this.mY[r27][r12];
        r12 = r12 + 1;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r24, int r26) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        if (r24 >= r10[0]) goto L5;
        double r13 = r10[0];
    L10:
        if (r12 >= (r11 - 1)) goto L16;
        double[] r14 = this.mT;
        int r15 = r12 + 1;
        if (r13 <= r14[r15]) goto L13;
        r12 = r15;
        goto L10
    L13:
        double r16 = r14[r15] - r14[r12];
        double r17 = (r13 - r14[r12]) / r16;
        double[][] r18 = this.mY;
        double r19 = r18[r12][r26];
        double r110 = r18[r15][r26];
        double[][] r20 = this.mTangent;
        return diff(r16, r17, r19, r110, r20[r12][r26], r20[r15][r26]) / r16;
    L16:
        return 0.0d;
    L5:
        int r21 = r11 - 1;
        if (r24 < r10[r21]) goto L8;
        r13 = r10[r21];
        goto L10
    L8:
        r13 = r24;
        goto L10
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r26, double[] r28) {
        double[] r10 = this.mT;
        int r11 = r10.length;
        int r12 = 0;
        int r13 = this.mY[0].length;
        if (r26 > r10[0]) goto L5;
        double r14 = r10[0];
    L9:
        int r15 = 0;
    L11:
        if (r15 >= (r11 - 1)) goto L18;
        double[] r16 = this.mT;
        int r17 = r15 + 1;
        if (r14 <= r16[r17]) goto L14;
        r15 = r17;
        goto L11
    L14:
        double r18 = r16[r17] - r16[r15];
        double r19 = (r14 - r16[r15]) / r18;
    L15:
        if (r12 >= r13) goto L22;
        double[][] r20 = this.mY;
        double r110 = r20[r15][r12];
        double r111 = r20[r17][r12];
        double[][] r21 = this.mTangent;
        r28[r12] = diff(r18, r19, r110, r111, r21[r15][r12], r21[r17][r12]) / r18;
        r12 = r12 + 1;
        goto L15
    L22:
        return;
    L18:
        return;
    L5:
        int r22 = r11 - 1;
        if (r26 < r10[r22]) goto L8;
        r14 = r10[r22];
        goto L9
    L8:
        r14 = r26;
        goto L9
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }
}
