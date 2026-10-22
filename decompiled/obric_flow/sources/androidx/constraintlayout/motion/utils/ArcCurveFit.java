package androidx.constraintlayout.motion.utils;

import ai.j0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ArcCurveFit extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    public static class Arc {
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

        public Arc(int r21, double r22, double r24, double r26, double r28, double r30, double r32) {
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
            double r5 = r30 - r26;
            double r10 = r32 - r28;
            if (this.linear == false) goto L11;
        L33:
            this.linear = true;
            this.mX1 = r26;
            this.mX2 = r30;
            this.mY1 = r28;
            this.mY2 = r32;
            double r11 = Math.hypot(r10, r5);
            this.mArcDistance = r11;
            this.mArcVelocity = r11 * this.mOneOverDeltaTime;
            double r12 = this.mTime2;
            double r13 = this.mTime1;
            this.mEllipseCenterX = r5 / (r12 - r13);
            this.mEllipseCenterY = r10 / (r12 - r13);
            return;
        L11:
            if (Math.abs(r5) < EPSILON) goto L33;
            if (Math.abs(r10) < EPSILON) goto L33;
            this.mLut = new double[101];
            boolean r16 = this.mVertical;
            if (r16 == false) goto L18;
            int r17 = -1;
        L19:
            this.mEllipseA = r5 * ((double) r17);
            if (r16 == true) goto L23;
            r15 = -1;
        L23:
            this.mEllipseB = r10 * ((double) r15);
            if (r16 == false) goto L26;
            double r18 = r30;
        L27:
            this.mEllipseCenterX = r18;
            if (r16 == false) goto L30;
            double r19 = r28;
        L31:
            this.mEllipseCenterY = r19;
            buildTable(r26, r28, r30, r32);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
            return;
        L30:
            r19 = r32;
            goto L31
        L26:
            r18 = r26;
            goto L27
        L18:
            r17 = 1;
            goto L19
        }

        private void buildTable(double r21, double r23, double r25, double r27) {
            double r5 = r25 - r21;
            double r10 = r23 - r27;
            int r11 = 0;
            double r12 = 0.0d;
            double r13 = 0.0d;
            double r14 = 0.0d;
        L3:
            double[] r15 = ourPercent;
            if (r11 >= r15.length) goto L10;
            double r24 = r12;
            double r16 = Math.toRadians((((double) r11) * 90.0d) / ((double) (r15.length - 1)));
            double r17 = Math.sin(r16) * r5;
            double r18 = Math.cos(r16) * r10;
            if (r11 <= 0) goto L8;
            double r19 = Math.hypot(r17 - r13, r18 - r14) + r24;
            ourPercent[r11] = r19;
        L9:
            r11 = r11 + 1;
            r14 = r18;
            r12 = r19;
            r13 = r17;
            goto L3
        L8:
            r19 = r24;
            goto L9
        L10:
            double r110 = r12;
            this.mArcDistance = r110;
            int r20 = 0;
        L11:
            double[] r22 = ourPercent;
            if (r20 >= r22.length) goto L14;
            r22[r20] = r22[r20] / r110;
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
            this.mLut[r26] = r30 / (ourPercent.length - 1);
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
            double[] r111 = ourPercent;
            double r112 = r111[r32];
            this.mLut[r26] = (((r29 - r112) / (r111[r31 - 1] - r112)) + ((double) r32)) / ((double) (r111.length - 1));
            goto L24
        }

        public double getDX() {
            double r5 = this.mEllipseA * this.mTmpCosAngle;
            double r10 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r11 = this.mArcVelocity / Math.hypot(r5, r10);
            if (this.mVertical == false) goto L6;
            r5 = -r5;
        L6:
            return r5 * r11;
        }

        public double getDY() {
            double r5 = this.mEllipseA * this.mTmpCosAngle;
            double r10 = (-this.mEllipseB) * this.mTmpSinAngle;
            double r11 = this.mArcVelocity / Math.hypot(r5, r10);
            if (this.mVertical == false) goto L6;
            return (-r10) * r11;
        L6:
            return r10 * r11;
        }

        public double getLinearDX(double r5) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double r5) {
            return this.mEllipseCenterY;
        }

        public double getLinearX(double r11) {
            double r10 = (r11 - this.mTime1) * this.mOneOverDeltaTime;
            double r12 = this.mX1;
            return j0.a(this.mX2, r12, r10, r12);
        }

        public double getLinearY(double r11) {
            double r10 = (r11 - this.mTime1) * this.mOneOverDeltaTime;
            double r12 = this.mY1;
            return j0.a(this.mY2, r12, r10, r12);
        }

        public double getX() {
            double r5 = this.mEllipseCenterX;
            return (this.mEllipseA * this.mTmpSinAngle) + r5;
        }

        public double getY() {
            double r5 = this.mEllipseCenterY;
            return (this.mEllipseB * this.mTmpCosAngle) + r5;
        }

        public double lookup(double r12) {
            if (r12 > 0.0d) goto L6;
            return 0.0d;
        L6:
            if (r12 < 1.0d) goto L8;
            return 1.0d;
        L8:
            double[] r11 = this.mLut;
            double r13 = r12 * ((double) (r11.length - 1));
            int r5 = (int) r13;
            double r10 = r13 - ((double) r5);
            double r14 = r11[r5];
            return j0.a(r11[r5 + 1], r14, r10, r14);
        }

        public void setPoint(double r5) {
            if (this.mVertical == false) goto L5;
            double r10 = this.mTime2 - r5;
        L6:
            double r11 = lookup(r10 * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(r11);
            this.mTmpCosAngle = Math.cos(r11);
            return;
        L5:
            r10 = r5 - this.mTime1;
            goto L6
        }
    }

    public ArcCurveFit(int[] r25, double[] r26, double[][] r27) {
        this.mTime = r26;
        this.mArcs = new Arc[r26.length - 1];
        int r5 = 0;
        int r10 = 1;
        int r11 = 1;
    L3:
        Arc[] r12 = this.mArcs;
        if (r5 >= r12.length) goto L19;
        int r13 = r25[r5];
        if (r13 == 0) goto L17;
        if (r13 != 1) goto L9;
    L16:
        r10 = 1;
    L14:
        r11 = r10;
    L18:
        double r14 = r26[r5];
        int r23 = r5 + 1;
        double r15 = r26[r23];
        double[] r16 = r27[r5];
        double r17 = r16[0];
        double r18 = r16[1];
        double[] r19 = r27[r23];
        r12[r5] = new Arc(r11, r14, r15, r17, r18, r19[0], r19[1]);
        r5 = r23;
        goto L3
    L9:
        if (r13 == 2) goto L15;
        if (r13 != 3) goto L18;
        if (r10 != 1) goto L16;
    L15:
        r10 = 2;
        goto L14
    L17:
        r11 = 3;
        goto L18
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r10, double[] r11) {
        Arc[] r5 = this.mArcs;
        double r12 = r5[0].mTime1;
        if (r10 >= r12) goto L6;
        r10 = r12;
    L6:
        if (r10 <= r5[r5.length - 1].mTime2) goto L8;
        r10 = r5[r5.length - 1].mTime2;
    L8:
        int r13 = 0;
    L9:
        Arc[] r14 = this.mArcs;
        if (r13 >= r14.length) goto L20;
        Arc r15 = r14[r13];
        if (r10 <= r15.mTime2) goto L14;
        r13 = r13 + 1;
        goto L9
    L14:
        if (r15.linear == false) goto L17;
        r11[0] = r15.getLinearX(r10);
        r11[1] = this.mArcs[r13].getLinearY(r10);
        return;
    L17:
        r15.setPoint(r10);
        r11[0] = this.mArcs[r13].getX();
        r11[1] = this.mArcs[r13].getY();
        return;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double r10, double[] r11) {
        Arc[] r5 = this.mArcs;
        double r12 = r5[0].mTime1;
        if (r10 >= r12) goto L6;
        r10 = r12;
    L8:
        int r13 = 0;
    L9:
        Arc[] r14 = this.mArcs;
        if (r13 >= r14.length) goto L20;
        Arc r15 = r14[r13];
        if (r10 <= r15.mTime2) goto L14;
        r13 = r13 + 1;
        goto L9
    L14:
        if (r15.linear == false) goto L17;
        r11[0] = r15.getLinearDX(r10);
        r11[1] = this.mArcs[r13].getLinearDY(r10);
        return;
    L17:
        r15.setPoint(r10);
        r11[0] = this.mArcs[r13].getDX();
        r11[1] = this.mArcs[r13].getDY();
        return;
    L20:
        return;
    L6:
        if (r10 <= r5[r5.length - 1].mTime2) goto L8;
        r10 = r5[r5.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double r10, float[] r11) {
        Arc[] r5 = this.mArcs;
        double r12 = r5[0].mTime1;
        if (r10 >= r12) goto L6;
        r10 = r12;
    L8:
        int r13 = 0;
    L9:
        Arc[] r14 = this.mArcs;
        if (r13 >= r14.length) goto L20;
        Arc r15 = r14[r13];
        if (r10 <= r15.mTime2) goto L14;
        r13 = r13 + 1;
        goto L9
    L14:
        if (r15.linear == false) goto L17;
        r11[0] = (float) r15.getLinearX(r10);
        r11[1] = (float) this.mArcs[r13].getLinearY(r10);
        return;
    L17:
        r15.setPoint(r10);
        r11[0] = (float) this.mArcs[r13].getX();
        r11[1] = (float) this.mArcs[r13].getY();
        return;
    L20:
        return;
    L6:
        if (r10 <= r5[r5.length - 1].mTime2) goto L8;
        r10 = r5[r5.length - 1].mTime2;
        goto L8
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double r10, int r11) {
        Arc[] r5 = this.mArcs;
        int r12 = 0;
        double r13 = r5[0].mTime1;
        if (r10 >= r13) goto L6;
        r10 = r13;
    L6:
        if (r10 <= r5[r5.length - 1].mTime2) goto L8;
        r10 = r5[r5.length - 1].mTime2;
    L8:
        Arc[] r14 = this.mArcs;
        if (r12 >= r14.length) goto L26;
        Arc r15 = r14[r12];
        if (r10 <= r15.mTime2) goto L13;
        r12 = r12 + 1;
        goto L8
    L13:
        if (r15.linear == false) goto L19;
        if (r11 != 0) goto L18;
        return r15.getLinearDX(r10);
    L18:
        return r15.getLinearDY(r10);
    L19:
        r15.setPoint(r10);
        if (r11 != 0) goto L24;
        return this.mArcs[r12].getDX();
    L24:
        return this.mArcs[r12].getDY();
    L26:
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double r10, int r11) {
        Arc[] r5 = this.mArcs;
        int r12 = 0;
        double r13 = r5[0].mTime1;
        if (r10 >= r13) goto L6;
        r10 = r13;
    L8:
        Arc[] r14 = this.mArcs;
        if (r12 >= r14.length) goto L26;
        Arc r15 = r14[r12];
        if (r10 <= r15.mTime2) goto L13;
        r12 = r12 + 1;
        goto L8
    L13:
        if (r15.linear == false) goto L19;
        if (r11 != 0) goto L18;
        return r15.getLinearX(r10);
    L18:
        return r15.getLinearY(r10);
    L19:
        r15.setPoint(r10);
        if (r11 != 0) goto L24;
        return this.mArcs[r12].getX();
    L24:
        return this.mArcs[r12].getY();
    L26:
        return Double.NaN;
    L6:
        if (r10 <= r5[r5.length - 1].mTime2) goto L8;
        r10 = r5[r5.length - 1].mTime2;
        goto L8
    }
}
