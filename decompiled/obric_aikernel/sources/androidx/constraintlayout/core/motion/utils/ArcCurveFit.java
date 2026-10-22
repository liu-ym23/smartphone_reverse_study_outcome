package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private boolean mExtrapolate;
    private final double[] mTime;

    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] ourPercent;
        boolean linear;
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        static {
            ourPercent = new double[91];
        }

        Arc(int r21, double r22, double r24, double r26, double r28, double r30, double r32) {
            boolean r14 = false;
            this.linear = false;
            int r15 = 1;
            if (r21 != 1) goto L5;
            r14 = true;
        L5:
            this.mVertical = r14;
            this.mTime1 = r22;
            this.mTime2 = r24;
            this.mOneOverDeltaTime = 1.0d / (r24 - r22);
            if (3 != r21) goto L8;
            this.linear = true;
        L8:
            double r10 = r30 - r26;
            double r11 = r32 - r28;
            if (this.linear == false) goto L11;
        L33:
            this.linear = true;
            this.mX1 = r26;
            this.mX2 = r30;
            this.mY1 = r28;
            this.mY2 = r32;
            double r12 = Math.hypot(r11, r10);
            this.mArcDistance = r12;
            this.mArcVelocity = r12 * this.mOneOverDeltaTime;
            double r13 = this.mTime2;
            double r16 = this.mTime1;
            this.mEllipseCenterX = r10 / (r13 - r16);
            this.mEllipseCenterY = r11 / (r13 - r16);
            return;
        L11:
            if (Math.abs(r10) < EPSILON) goto L33;
            if (Math.abs(r11) < EPSILON) goto L33;
            this.mLut = new double[101];
            boolean r17 = this.mVertical;
            if (r17 == false) goto L18;
            int r18 = -1;
        L19:
            this.mEllipseA = r10 * ((double) r18);
            if (r17 == true) goto L23;
            r15 = -1;
        L23:
            this.mEllipseB = r11 * ((double) r15);
            if (r17 == false) goto L26;
            double r19 = r30;
        L27:
            this.mEllipseCenterX = r19;
            if (r17 == false) goto L30;
            double r20 = r28;
        L31:
            this.mEllipseCenterY = r20;
            buildTable(r26, r28, r30, r32);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        L30:
            r20 = r32;
            goto L31
        L26:
            r19 = r26;
            goto L27
        L18:
            r18 = 1;
            goto L19
        }

        private void buildTable(double r21, double r23, double r25, double r27) {
            double r10 = r25 - r21;
            double r11 = r23 - r27;
            int r12 = 0;
            double r13 = 0.0d;
            double r14 = 0.0d;
            double r15 = 0.0d;
        L3:
            double[] r16 = ourPercent;
            if (r12 >= r16.length) goto L10;
            double r24 = r13;
            double r17 = Math.toRadians((((double) r12) * 90.0d) / ((double) (r16.length - 1)));
            double r18 = Math.sin(r17) * r10;
            double r19 = Math.cos(r17) * r11;
            if (r12 <= 0) goto L8;
            double r110 = Math.hypot(r18 - r14, r19 - r15) + r24;
            ourPercent[r12] = r110;
        L9:
            r12 = r12 + 1;
            r15 = r19;
            r13 = r110;
            r14 = r18;
            goto L3
        L8:
            r110 = r24;
            goto L9
        L10:
            double r111 = r13;
            this.mArcDistance = r111;
            int r20 = 0;
        L11:
            double[] r22 = ourPercent;
            if (r20 >= r22.length) goto L14;
            r22[r20] = r22[r20] / r111;
            r20 = r20 + 1;
            goto L11
        L14:
            int r26 = 0;
        L15:
            double[] r28 = this.mLut;
            if (r26 >= r28.length) goto L25;
            double r29 = ((double) r26) / ((double) (r28.length - 1));
            int r30 = Arrays.binarySearch(ourPercent, r29);
            if (r30 < 0) goto L21;
            this.mLut[r26] = ((double) r30) / ((double) (ourPercent.length - 1));
        L24:
            r26 = r26 + 1;
            goto L15
        L21:
            if (r30 != (-1)) goto L23;
            this.mLut[r26] = 0.0d;
            goto L24
        L23:
            int r31 = -r30;
            int r32 = r31 - 2;
            double[] r112 = ourPercent;
            this.mLut[r26] = (((double) r32) + ((r29 - r112[r32]) / (r112[r31 - 1] - r112[r32]))) / ((double) (r112.length - 1));
            goto L24
        }

        double getDX() {
            double r10 = this.mEllipseA * this.mTmpCosAngle;
            double r11 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r12 = this.mArcVelocity / Math.hypot(r10, r11);
            if (this.mVertical == false) goto L6;
            r10 = -r10;
        L6:
            return r10 * r12;
        }

        double getDY() {
            double r10 = this.mEllipseA * this.mTmpCosAngle;
            double r11 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r12 = this.mArcVelocity / Math.hypot(r10, r11);
            if (this.mVertical == false) goto L6;
            return (-r11) * r12;
        L6:
            return r11 * r12;
        }

        public double getLinearDX(double r10) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double r10) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double r10) {
            double r11 = (r10 - this.mTime1) * this.mOneOverDeltaTime;
            double r12 = this.mX1;
            return r12 + (r11 * (this.mX2 - r12));
        }

        public double getLinearY(double r10) {
            double r11 = (r10 - this.mTime1) * this.mOneOverDeltaTime;
            double r12 = this.mY1;
            return r12 + (r11 * (this.mY2 - r12));
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double lookup(double r10) {
            if (r10 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r10 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r11 = this.mLut;
            double r12 = r10 * ((double) (r11.length - 1));
            int r13 = (int) r12;
            return r11[r13] + ((r12 - ((double) r13)) * (r11[r13 + 1] - r11[r13]));
        }

        void setPoint(double r10) {
            if (this.mVertical == false) goto L5;
            double r11 = this.mTime2 - r10;
        L6:
            double r12 = lookup(r11 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(r12);
            this.mTmpCosAngle = Math.cos(r12);
            return;
        L5:
            r11 = r10 - this.mTime1;
            goto L6
        }
    }

    public ArcCurveFit(int[] r25, double[] r26, double[][] r27) {
        this.mExtrapolate = true;
        this.mTime = r26;
        this.mArcs = new Arc[r26.length - 1];
        int r10 = 1;
        int r11 = 1;
        int r12 = 0;
    L3:
        Arc[] r13 = this.mArcs;
        if (r12 >= r13.length) goto L17;
        int r14 = r25[r12];
        if (r14 == 0) goto L15;
        if (r14 == 1) goto L13;
        if (r14 == 2) goto L12;
        if (r14 != 3) goto L16;
        if (r10 != 1) goto L13;
    L16:
        int r23 = r12 + 1;
        r13[r12] = new Arc(r11, r26[r12], r26[r23], r27[r12][0], r27[r12][1], r27[r23][0], r27[r23][1]);
        r12 = r23;
    L12:
        r10 = 2;
    L14:
        r11 = r10;
    L13:
        r10 = 1;
        goto L14
    L15:
        r11 = 3;
        goto L16
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double r10, int r11) {
        int r12 = 0;
        if (this.mExtrapolate == false) goto L25;
        Arc[] r13 = this.mArcs;
        if (r10 >= r13[0].mTime1) goto L20;
        double r14 = r13[0].mTime1;
        double r15 = r10 - r13[0].mTime1;
        if (r13[0].linear == false) goto L13;
        if (r11 != 0) goto L12;
        double r16 = r13[0].getLinearX(r14);
        double r17 = this.mArcs[0].getLinearDX(r14);
    L11:
        return r16 + (r15 * r17);
    L12:
        r16 = r13[0].getLinearY(r14);
        r17 = this.mArcs[0].getLinearDY(r14);
        goto L11
    L13:
        r13[0].setPoint(r14);
        if (r11 != 0) goto L18;
        double r18 = this.mArcs[0].getX();
        double r19 = this.mArcs[0].getDX();
    L17:
        return r18 + (r15 * r19);
    L18:
        r18 = this.mArcs[0].getY();
        r19 = this.mArcs[0].getDY();
        goto L17
    L20:
        if (r10 <= r13[r13.length - 1].mTime2) goto L31;
        double r20 = r13[r13.length - 1].mTime2;
        r15 = r10 - r20;
        int r21 = r13.length - 1;
        if (r11 != 0) goto L24;
        r16 = r13[r21].getLinearX(r20);
        r17 = this.mArcs[r21].getLinearDX(r20);
        goto L11
    L24:
        r16 = r13[r21].getLinearY(r20);
        r17 = this.mArcs[r21].getLinearDY(r20);
    L31:
        Arc[] r22 = this.mArcs;
        if (r12 >= r22.length) goto L49;
        if (r10 <= r22[r12].mTime2) goto L36;
        r12 = r12 + 1;
        goto L31
    L36:
        if (r22[r12].linear == false) goto L42;
        if (r11 != 0) goto L41;
        return r22[r12].getLinearX(r10);
    L41:
        return r22[r12].getLinearY(r10);
    L42:
        r22[r12].setPoint(r10);
        Arc[] r23 = this.mArcs;
        if (r11 != 0) goto L47;
        return r23[r12].getX();
    L47:
        return r23[r12].getY();
    L49:
        return Double.NaN;
    L25:
        Arc[] r24 = this.mArcs;
        if (r10 >= r24[0].mTime1) goto L29;
        r10 = r24[0].mTime1;
        goto L31
    L29:
        if (r10 <= r24[r24.length - 1].mTime2) goto L31;
        r10 = r24[r24.length - 1].mTime2;
        goto L31
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, double[] r13) {
        if (this.mExtrapolate == false) goto L18;
        Arc[] r10 = this.mArcs;
        if (r11 >= r10[0].mTime1) goto L12;
        double r12 = r10[0].mTime1;
        double r14 = r11 - r10[0].mTime1;
        if (r10[0].linear == false) goto L9;
        r13[0] = r10[0].getLinearX(r12) + (this.mArcs[0].getLinearDX(r12) * r14);
        r13[1] = this.mArcs[0].getLinearY(r12) + (r14 * this.mArcs[0].getLinearDY(r12));
        return;
    L9:
        r10[0].setPoint(r12);
        r13[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * r14);
        r13[1] = this.mArcs[0].getY() + (r14 * this.mArcs[0].getDY());
        return;
    L12:
        if (r11 <= r10[r10.length - 1].mTime2) goto L24;
        double r15 = r10[r10.length - 1].mTime2;
        double r16 = r11 - r15;
        int r17 = r10.length - 1;
        if (r10[r17].linear == false) goto L16;
        r13[0] = r10[r17].getLinearX(r15) + (this.mArcs[r17].getLinearDX(r15) * r16);
        r13[1] = this.mArcs[r17].getLinearY(r15) + (r16 * this.mArcs[r17].getLinearDY(r15));
        return;
    L16:
        r10[r17].setPoint(r11);
        r13[0] = this.mArcs[r17].getX() + (this.mArcs[r17].getDX() * r16);
        r13[1] = this.mArcs[r17].getY() + (r16 * this.mArcs[r17].getDY());
        return;
    L24:
        int r18 = 0;
    L25:
        Arc[] r19 = this.mArcs;
        if (r18 >= r19.length) goto L36;
        if (r11 <= r19[r18].mTime2) goto L30;
        r18 = r18 + 1;
        goto L25
    L30:
        if (r19[r18].linear == false) goto L33;
        r13[0] = r19[r18].getLinearX(r11);
        r13[1] = this.mArcs[r18].getLinearY(r11);
        return;
    L33:
        r19[r18].setPoint(r11);
        r13[0] = this.mArcs[r18].getX();
        r13[1] = this.mArcs[r18].getY();
        return;
    L36:
        return;
    L18:
        Arc[] r20 = this.mArcs;
        if (r11 >= r20[0].mTime1) goto L22;
        r11 = r20[0].mTime1;
    L22:
        if (r11 <= r20[r20.length - 1].mTime2) goto L24;
        r11 = r20[r20.length - 1].mTime2;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double r11, float[] r13) {
        if (this.mExtrapolate == false) goto L18;
        Arc[] r10 = this.mArcs;
        if (r11 >= r10[0].mTime1) goto L12;
        double r12 = r10[0].mTime1;
        double r14 = r11 - r10[0].mTime1;
        if (r10[0].linear == false) goto L9;
        r13[0] = (float) (r10[0].getLinearX(r12) + (this.mArcs[0].getLinearDX(r12) * r14));
        r13[1] = (float) (this.mArcs[0].getLinearY(r12) + (r14 * this.mArcs[0].getLinearDY(r12)));
        return;
    L9:
        r10[0].setPoint(r12);
        r13[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * r14));
        r13[1] = (float) (this.mArcs[0].getY() + (r14 * this.mArcs[0].getDY()));
        return;
    L12:
        if (r11 <= r10[r10.length - 1].mTime2) goto L24;
        double r15 = r10[r10.length - 1].mTime2;
        double r16 = r11 - r15;
        int r17 = r10.length - 1;
        if (r10[r17].linear == false) goto L16;
        r13[0] = (float) (r10[r17].getLinearX(r15) + (this.mArcs[r17].getLinearDX(r15) * r16));
        r13[1] = (float) (this.mArcs[r17].getLinearY(r15) + (r16 * this.mArcs[r17].getLinearDY(r15)));
        return;
    L16:
        r10[r17].setPoint(r11);
        r13[0] = (float) this.mArcs[r17].getX();
        r13[1] = (float) this.mArcs[r17].getY();
        return;
    L24:
        int r18 = 0;
    L25:
        Arc[] r19 = this.mArcs;
        if (r18 >= r19.length) goto L36;
        if (r11 <= r19[r18].mTime2) goto L30;
        r18 = r18 + 1;
        goto L25
    L30:
        if (r19[r18].linear == false) goto L33;
        r13[0] = (float) r19[r18].getLinearX(r11);
        r13[1] = (float) this.mArcs[r18].getLinearY(r11);
        return;
    L33:
        r19[r18].setPoint(r11);
        r13[0] = (float) this.mArcs[r18].getX();
        r13[1] = (float) this.mArcs[r18].getY();
        return;
    L36:
        return;
    L18:
        Arc[] r20 = this.mArcs;
        if (r11 >= r20[0].mTime1) goto L22;
        r11 = r20[0].mTime1;
        goto L24
    L22:
        if (r11 <= r20[r20.length - 1].mTime2) goto L24;
        r11 = r20[r20.length - 1].mTime2;
        goto L24
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double r10, int r11) {
        Arc[] r12 = this.mArcs;
        int r13 = 0;
        if (r10 >= r12[0].mTime1) goto L6;
        r10 = r12[0].mTime1;
    L6:
        if (r10 <= r12[r12.length - 1].mTime2) goto L8;
        r10 = r12[r12.length - 1].mTime2;
    L8:
        Arc[] r14 = this.mArcs;
        if (r13 >= r14.length) goto L26;
        if (r10 <= r14[r13].mTime2) goto L13;
        r13 = r13 + 1;
        goto L8
    L13:
        if (r14[r13].linear == false) goto L19;
        if (r11 != 0) goto L18;
        return r14[r13].getLinearDX(r10);
    L18:
        return r14[r13].getLinearDY(r10);
    L19:
        r14[r13].setPoint(r10);
        Arc[] r15 = this.mArcs;
        if (r11 != 0) goto L24;
        return r15[r13].getDX();
    L24:
        return r15[r13].getDY();
    L26:
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double r10, double[] r11) {
        Arc[] r12 = this.mArcs;
        if (r10 >= r12[0].mTime1) goto L6;
        r10 = r12[0].mTime1;
    L8:
        int r13 = 0;
    L9:
        Arc[] r14 = this.mArcs;
        if (r13 >= r14.length) goto L20;
        if (r10 <= r14[r13].mTime2) goto L14;
        r13 = r13 + 1;
        goto L9
    L14:
        if (r14[r13].linear == false) goto L17;
        r11[0] = r14[r13].getLinearDX(r10);
        r11[1] = this.mArcs[r13].getLinearDY(r10);
        return;
    L17:
        r14[r13].setPoint(r10);
        r11[0] = this.mArcs[r13].getDX();
        r11[1] = this.mArcs[r13].getDY();
        return;
    L20:
        return;
    L6:
        if (r10 <= r12[r12.length - 1].mTime2) goto L8;
        r10 = r12[r12.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }
}
