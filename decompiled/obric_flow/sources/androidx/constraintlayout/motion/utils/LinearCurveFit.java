package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength;
    private double[][] mY;

    public LinearCurveFit(double[] r11, double[][] r12) {
        this.mTotalLength = Double.NaN;
        int r5 = r11.length;
        int r10 = r12[0].length;
        this.mT = r11;
        this.mY = r12;
        if (r10 <= 2) goto L16;
        int r13 = 0;
        double r14 = 0.0d;
    L5:
        double r15 = r14;
        if (r13 >= r11.length) goto L11;
        double r16 = r12[r13][0];
        if (r13 <= 0) goto L10;
        Math.hypot(r16 - r14, r16 - r15);
    L10:
        r13 = r13 + 1;
        r14 = r16;
        goto L5
    L11:
        this.mTotalLength = 0.0d;
        return;
    }

    private double getLength2D(double r21) {
        if (Double.isNaN(this.mTotalLength) == false) goto L5;
        return 0.0d;
    L5:
        double[] r5 = this.mT;
        int r10 = r5.length;
        if (r21 > r5[0]) goto L8;
        return 0.0d;
    L8:
        int r11 = r10 - 1;
        if (r21 >= r5[r11]) goto L11;
        double r12 = 0.0d;
        double r13 = 0.0d;
        double r14 = 0.0d;
        int r15 = 0;
    L13:
        if (r15 >= r11) goto L25;
        double[] r16 = this.mY[r15];
        double r17 = r16[0];
        double r18 = r16[1];
        if (r15 <= 0) goto L17;
        r12 = r12 + Math.hypot(r17 - r13, r18 - r14);
    L17:
        double[] r19 = this.mT;
        double r110 = r19[r15];
        if (r21 == r110) goto L19;
        int r111 = r15 + 1;
        double r112 = r19[r111];
        if (r21 < r112) goto L22;
        r15 = r111;
        r13 = r17;
        r14 = r18;
        goto L13
    L22:
        double r20 = (r21 - r110) / (r112 - r110);
        double[][] r22 = this.mY;
        double[] r23 = r22[r15];
        double r24 = r23[0];
        double[] r25 = r22[r111];
        double r26 = r25[0];
        double r113 = r23[1];
        double r114 = 1.0d - r20;
        return Math.hypot(r18 - ((r25[1] * r20) + (r113 * r114)), r17 - ((r26 * r20) + (r24 * r114))) + r12;
    L19:
        return r12;
    L25:
        return 0.0d;
    L11:
        return this.mTotalLength;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r13, double[] r15) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = this.mY[0].length;
        if (r13 > r5[0]) goto L8;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L7;
        r15[r14] = this.mY[0][r14];
        r14 = r14 + 1;
        goto L5
    L7:
        return;
    L8:
        int r16 = r10 - 1;
        if (r13 < r5[r16]) goto L13;
    L10:
        if (r11 >= r12) goto L12;
        r15[r11] = this.mY[r16][r11];
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L13:
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L27;
        if (r13 != this.mT[r17]) goto L20;
        int r18 = 0;
    L18:
        if (r18 >= r12) goto L20;
        r15[r18] = this.mY[r17][r18];
        r18 = r18 + 1;
    L20:
        double[] r19 = this.mT;
        int r20 = r17 + 1;
        double r21 = r19[r20];
        if (r13 < r21) goto L22;
        r17 = r20;
        goto L14
    L22:
        double r22 = r19[r17];
        double r110 = (r13 - r22) / (r21 - r22);
    L23:
        if (r11 >= r12) goto L25;
        double[][] r23 = this.mY;
        double r24 = r23[r17][r11];
        r15[r11] = (r23[r20][r11] * r110) + ((1.0d - r110) * r24);
        r11 = r11 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r11, double[] r13) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r12 = 0;
        int r14 = this.mY[0].length;
        double r15 = r5[0];
        if (r11 > r15) goto L5;
    L4:
        r11 = r15;
    L8:
        int r16 = 0;
    L10:
        if (r16 >= (r10 - 1)) goto L17;
        double[] r17 = this.mT;
        int r18 = r16 + 1;
        double r19 = r17[r18];
        if (r11 <= r19) goto L13;
        r16 = r18;
        goto L10
    L13:
        double r20 = r19 - r17[r16];
    L14:
        if (r12 >= r14) goto L21;
        double[][] r110 = this.mY;
        r13[r12] = (r110[r18][r12] - r110[r16][r12]) / r20;
        r12 = r12 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        r15 = r5[r10 - 1];
        if (r11 < r15) goto L8;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mT;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r10, int r11) {
        double[] r5 = this.mT;
        int r12 = r5.length;
        int r13 = 0;
        double r14 = r5[0];
        if (r10 >= r14) goto L5;
    L4:
        r10 = r14;
    L9:
        if (r13 >= (r12 - 1)) goto L15;
        double[] r15 = this.mT;
        int r16 = r13 + 1;
        double r17 = r15[r16];
        if (r10 <= r17) goto L12;
        r13 = r16;
        goto L9
    L12:
        double r18 = r17 - r15[r13];
        double[][] r19 = this.mY;
        return (r19[r16][r11] - r19[r13][r11]) / r18;
    L15:
        return 0.0d;
    L5:
        r14 = r5[r12 - 1];
        if (r10 < r14) goto L9;
        goto L4
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r13, float[] r15) {
        double[] r5 = this.mT;
        int r10 = r5.length;
        int r11 = 0;
        int r12 = this.mY[0].length;
        if (r13 > r5[0]) goto L8;
        int r14 = 0;
    L5:
        if (r14 >= r12) goto L7;
        r15[r14] = (float) this.mY[0][r14];
        r14 = r14 + 1;
        goto L5
    L7:
        return;
    L8:
        int r16 = r10 - 1;
        if (r13 < r5[r16]) goto L13;
    L10:
        if (r11 >= r12) goto L12;
        r15[r11] = (float) this.mY[r16][r11];
        r11 = r11 + 1;
        goto L10
    L12:
        return;
    L13:
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L27;
        if (r13 != this.mT[r17]) goto L20;
        int r18 = 0;
    L18:
        if (r18 >= r12) goto L20;
        r15[r18] = (float) this.mY[r17][r18];
        r18 = r18 + 1;
    L20:
        double[] r19 = this.mT;
        int r20 = r17 + 1;
        double r21 = r19[r20];
        if (r13 < r21) goto L22;
        r17 = r20;
        goto L14
    L22:
        double r22 = r19[r17];
        double r110 = (r13 - r22) / (r21 - r22);
    L23:
        if (r11 >= r12) goto L25;
        double[][] r23 = this.mY;
        double r24 = r23[r17][r11];
        r15[r11] = (float) ((r23[r20][r11] * r110) + ((1.0d - r110) * r24));
        r11 = r11 + 1;
        goto L23
    L25:
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r10, int r11) {
        double[] r5 = this.mT;
        int r12 = r5.length;
        int r13 = 0;
        if (r10 <= r5[0]) goto L5;
        int r14 = r12 - 1;
        if (r10 >= r5[r14]) goto L9;
    L10:
        if (r13 >= r14) goto L20;
        double[] r15 = this.mT;
        double r16 = r15[r13];
        if (r10 == r16) goto L14;
        int r17 = r13 + 1;
        double r18 = r15[r17];
        if (r10 < r18) goto L17;
        r13 = r17;
        goto L10
    L17:
        double r19 = (r10 - r16) / (r18 - r16);
        double[][] r20 = this.mY;
        double r21 = r20[r13][r11];
        return (r20[r17][r11] * r19) + ((1.0d - r19) * r21);
    L14:
        return this.mY[r13][r11];
    L20:
        return 0.0d;
    L9:
        return this.mY[r14][r11];
    L5:
        return this.mY[0][r11];
    }
}
