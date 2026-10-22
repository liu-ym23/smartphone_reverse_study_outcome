package androidx.constraintlayout.motion.utils;

import ai.j0;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
public class MonotonicCurveFit extends CurveFit {
    private static final String TAG = "MonotonicCurveFit";
    private double[] mT;
    private double[][] mTangent;
    private double[][] mY;

    public MonotonicCurveFit(double[] r22, double[][] r23) {
        int r5 = r22.length;
        int r10 = r23[0].length;
        int r11 = r5 - 1;
        Class r12 = Double.TYPE;
        double[][] r13 = (double[][]) Array.newInstance(r12, new int[]{r11, r10});
        double[][] r14 = (double[][]) Array.newInstance(r12, new int[]{r5, r10});
        int r15 = 0;
    L3:
        if (r15 >= r10) goto L12;
        int r16 = 0;
    L5:
        if (r16 >= r11) goto L11;
        int r17 = r16 + 1;
        double r18 = r22[r17] - r22[r16];
        double[] r19 = r13[r16];
        double r110 = (r23[r17][r15] - r23[r16][r15]) / r18;
        r19[r15] = r110;
        if (r16 != 0) goto L9;
        r14[r16][r15] = r110;
    L10:
        r16 = r17;
        goto L5
    L9:
        r14[r16][r15] = (r13[r16 - 1][r15] + r110) * 0.5d;
        goto L10
    L11:
        r14[r11][r15] = r13[r5 - 2][r15];
        r15 = r15 + 1;
        goto L3
    L12:
        int r20 = 0;
    L13:
        if (r20 >= r11) goto L24;
        int r21 = 0;
    L15:
        if (r21 >= r10) goto L23;
        double r111 = r13[r20][r21];
        if (r111 != 0.0d) goto L19;
        r14[r20][r21] = 0.0d;
        r14[r20 + 1][r21] = 0.0d;
    L22:
        r21 = r21 + 1;
        goto L15
    L19:
        double r112 = r14[r20][r21] / r111;
        int r113 = r20 + 1;
        double r114 = r14[r113][r21] / r111;
        double r115 = Math.hypot(r112, r114);
        if (r115 <= 9.0d) goto L22;
        double r116 = 3.0d / r115;
        double[] r117 = r14[r20];
        double[] r118 = r13[r20];
        r117[r21] = (r112 * r116) * r118[r21];
        r14[r113][r21] = (r116 * r114) * r118[r21];
        goto L22
    L23:
        r20 = r20 + 1;
        goto L13
    L24:
        this.mT = r22;
        this.mY = r23;
        this.mTangent = r14;
    }

    private static double diff(double r12, double r14, double r16, double r18, double r20, double r22) {
        double r10 = r14 * r14;
        double r11 = r14 * 6.0d;
        double r5 = r11 * r18;
        double r13 = j0.B(r10, 6.0d, r16, r5 + (((-6.0d) * r10) * r18)) - (r11 * r16);
        double r15 = r12 * 3.0d;
        double r17 = (j0.B(r15, r20, r10, j0.B(r15, r22, r10, r13)) - (((2.0d * r12) * r22) * r14)) - (((4.0d * r12) * r20) * r14);
        return (r12 * r20) + r17;
    }

    private static double interpolate(double r16, double r18, double r20, double r22, double r24, double r26) {
        double r10 = r18 * r18;
        double r11 = r10 * r18;
        double r12 = r10 * 3.0d;
        double r5 = r12 * r22;
        double r13 = (j0.B(r11, 2.0d, r20, r5 + (((-2.0d) * r11) * r22)) - (r12 * r20)) + r20;
        double r14 = r16 * r26;
        double r15 = (r14 * r11) + r13;
        double r17 = r16 * r24;
        double r19 = (((r11 * r17) + r15) - (r14 * r10)) - (((r16 * 2.0d) * r24) * r10);
        return (r17 * r18) + r19;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r24, double[] r26) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = this.mY[0].length;
        if (r24 > r5[0]) goto L8;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r26[r13] = this.mY[0][r13];
        r13 = r13 + 1;
        goto L5
    L7:
        return;
    L8:
        int r14 = r10 - 1;
        if (r24 < r5[r14]) goto L13;
    L10:
        if (r11 >= r12) goto L12;
        r26[r11] = this.mY[r14][r11];
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L13:
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L27;
        if (r24 != this.mT[r15]) goto L20;
        int r16 = 0;
    L18:
        if (r16 >= r12) goto L20;
        r26[r16] = this.mY[r15][r16];
        r16 = r16 + 1;
    L20:
        double[] r17 = this.mT;
        int r18 = r15 + 1;
        double r19 = r17[r18];
        if (r24 < r19) goto L22;
        r15 = r18;
        goto L14
    L22:
        double r20 = r17[r15];
        double r21 = r19 - r20;
        double r22 = (r24 - r20) / r21;
    L23:
        if (r11 >= r12) goto L25;
        double[][] r23 = this.mY;
        double r110 = r23[r15][r11];
        double r111 = r23[r18][r11];
        double[][] r25 = this.mTangent;
        r26[r11] = interpolate(r21, r22, r110, r111, r25[r15][r11], r25[r18][r11]);
        r11 = r11 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r26, double[] r28) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = this.mY[0].length;
        double r13 = r5[0];
        if (r26 <= r13) goto L9;
        r13 = r5[r10 - 1];
        if (r26 >= r13) goto L9;
        r13 = r26;
    L9:
        int r14 = 0;
    L11:
        if (r14 >= (r10 - 1)) goto L18;
        double[] r15 = this.mT;
        int r16 = r14 + 1;
        double r17 = r15[r16];
        if (r13 <= r17) goto L14;
        r14 = r16;
        goto L11
    L14:
        double r18 = r15[r14];
        double r19 = r17 - r18;
        double r20 = (r13 - r18) / r19;
    L15:
        if (r11 >= r12) goto L22;
        double[][] r21 = this.mY;
        double r110 = r21[r14][r11];
        double r111 = r21[r16][r11];
        double[][] r22 = this.mTangent;
        r28[r11] = diff(r19, r20, r110, r111, r22[r14][r11], r22[r16][r11]) / r19;
        r11 = r11 + 1;
        goto L15
    L22:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r22, int r24) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        double r12 = r5[0];
        if (r22 < r12) goto L10;
        r12 = r5[r10 - 1];
        if (r22 >= r12) goto L10;
        r12 = r22;
    L10:
        if (r11 >= (r10 - 1)) goto L16;
        double[] r13 = this.mT;
        int r14 = r11 + 1;
        double r15 = r13[r14];
        if (r12 <= r15) goto L13;
        r11 = r14;
        goto L10
    L13:
        double r16 = r13[r11];
        double r17 = r15 - r16;
        double r18 = (r12 - r16) / r17;
        double[][] r19 = this.mY;
        double r110 = r19[r11][r24];
        double r111 = r19[r14][r24];
        double[][] r20 = this.mTangent;
        return diff(r17, r18, r110, r111, r20[r11][r24], r20[r14][r24]) / r17;
    L16:
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r24, float[] r26) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = this.mY[0].length;
        if (r24 > r5[0]) goto L8;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r26[r13] = (float) this.mY[0][r13];
        r13 = r13 + 1;
        goto L5
    L7:
        return;
    L8:
        int r14 = r10 - 1;
        if (r24 < r5[r14]) goto L13;
    L10:
        if (r11 >= r12) goto L12;
        r26[r11] = (float) this.mY[r14][r11];
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L13:
        int r15 = 0;
    L14:
        if (r15 >= r14) goto L27;
        if (r24 != this.mT[r15]) goto L20;
        int r16 = 0;
    L18:
        if (r16 >= r12) goto L20;
        r26[r16] = (float) this.mY[r15][r16];
        r16 = r16 + 1;
    L20:
        double[] r17 = this.mT;
        int r18 = r15 + 1;
        double r19 = r17[r18];
        if (r24 < r19) goto L22;
        r15 = r18;
        goto L14
    L22:
        double r20 = r17[r15];
        double r21 = r19 - r20;
        double r22 = (r24 - r20) / r21;
    L23:
        if (r11 >= r12) goto L25;
        double[][] r23 = this.mY;
        double r110 = r23[r15][r11];
        double r111 = r23[r18][r11];
        double[][] r25 = this.mTangent;
        r26[r11] = (float) interpolate(r21, r22, r110, r111, r25[r15][r11], r25[r18][r11]);
        r11 = r11 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r22, int r24) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        if (r22 <= r5[0]) goto L5;
        int r12 = r10 - 1;
        if (r22 >= r5[r12]) goto L9;
    L10:
        if (r11 >= r12) goto L20;
        double[] r13 = this.mT;
        double r14 = r13[r11];
        if (r22 == r14) goto L14;
        int r15 = r11 + 1;
        double r16 = r13[r15];
        if (r22 < r16) goto L17;
        r11 = r15;
        goto L10
    L17:
        double r17 = r16 - r14;
        double r18 = (r22 - r14) / r17;
        double[][] r19 = this.mY;
        double r110 = r19[r11][r24];
        double r111 = r19[r15][r24];
        double[][] r20 = this.mTangent;
        return interpolate(r17, r18, r110, r111, r20[r11][r24], r20[r15][r24]);
    L14:
        return this.mY[r11][r24];
    L20:
        return 0.0d;
    L9:
        return this.mY[r12][r24];
    L5:
        return this.mY[0][r24];
    }
}
