package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class LutherStepInterpolator extends RungeKuttaStepInterpolator {
    private static final double Q = 0.0d;
    private static final long serialVersionUID = 20140416;

    static {
        Q = FastMath.sqrt(21.0d);
    }

    public LutherStepInterpolator() {
    }

    LutherStepInterpolator(LutherStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r58, double r60) {
        double r1 = 21.0d * r58;
        double r3 = (((((((-47.0d) + r1) * r58) + 36.0d) * r58) - 10.8d) * r58) + 1.0d;
        double r7 = 112.0d * r58;
        double r9 = ((((((-202.66666666666666d) + r7) * r58) + 106.66666666666667d) * r58) - 13.866666666666667d) * r58;
        double r11 = (-567.0d) * r58;
        double r15 = ((((((r11 / 5.0d) + 194.4d) * r58) - 97.2d) * r58) + 12.96d) * r58;
        double r17 = Q;
        double r21 = ((((r17 * 343.0d) + 833.0d) / 150.0d) + (((((-637.0d) - (r17 * 357.0d)) / 30.0d) + (((((r17 * 287.0d) + 392.0d) / 15.0d) + ((((-49.0d) - (r17 * 49.0d)) * r58) / 5.0d)) * r58)) * r58)) * r58;
        double r25 = r58 * (((833.0d - (r17 * 343.0d)) / 150.0d) + (((((r17 * 357.0d) - 637.0d) / 30.0d) + ((((392.0d - (r17 * 287.0d)) / 15.0d) + ((((r17 * 49.0d) - 49.0d) * r58) / 5.0d)) * r58)) * r58));
        double r29 = ((((3.0d * r58) - 3.0d) * r58) + 0.6d) * r58;
        if (this.previousState != null) goto L5;
    L10:
        double r2 = (r58 * ((r58 * ((r58 * ((((-21.0d) * r58) / 5.0d) + 7.55d)) - 4.45d)) + 0.95d)) - 0.05d;
        double r8 = (((r58 * ((r58 * ((((-112.0d) * r58) / 5.0d) + 28.266666666666666d)) - 7.288888888888889d)) - 0.35555555555555557d) * r58) - 0.35555555555555557d;
        double r10 = (((r58 * (((567.0d * r58) / 25.0d) - 25.92d)) + 6.48d) * r58) * r58;
        double r12 = (((((((1029.0d * r17) + 2254.0d) / 900.0d) + (((((-1372.0d) - (847.0d * r17)) / 300.0d) + ((((r17 * 49.0d) + 49.0d) * r58) / 25.0d)) * r58)) * r58) - 0.2722222222222222d) * r58) - 0.2722222222222222d;
        double r13 = ((((((2254.0d - (1029.0d * r17)) / 900.0d) + (r58 * ((((847.0d * r17) - 1372.0d) / 300.0d) + ((r58 * (49.0d - (r17 * 49.0d))) / 25.0d)))) * r58) - 0.2722222222222222d) * r58) - 0.2722222222222222d;
        double r16 = (((r58 * (((-0.75d) * r58) + 0.25d)) - 0.05d) * r58) - 0.05d;
        int r5 = 0;
    L12:
        if (r5 >= this.interpolatedState.length) goto L17;
        double r18 = this.yDotK[0][r5];
        double r23 = this.yDotK[1][r5];
        double r27 = this.yDotK[2][r5];
        double r31 = this.yDotK[3][r5];
        double r33 = this.yDotK[4][r5];
        double r35 = this.yDotK[5][r5];
        double r37 = this.yDotK[6][r5];
        double r39 = r3;
        double r24 = r23 * 0.0d;
        this.interpolatedState[r5] = this.currentState[r5] + ((((((((r2 * r18) + r24) + (r8 * r27)) + (r10 * r31)) + (r12 * r33)) + (r13 * r35)) + (r16 * r37)) * r60);
        this.interpolatedDerivatives[r5] = ((((((r18 * r39) + r24) + (r9 * r27)) + (r15 * r31)) + (r33 * r21)) + (r35 * r25)) + (r37 * r29);
        r5 = r5 + 1;
        r3 = r39;
        goto L12
    L17:
        return;
    L5:
        if (r58 > 0.5d) goto L10;
        double r4 = (((((((r1 / 5.0d) - 11.75d) * r58) + 12.0d) * r58) - 5.4d) * r58) + 1.0d;
        double r14 = ((((((r7 / 5.0d) - 50.666666666666664d) * r58) + 35.55555555555556d) * r58) - 6.933333333333334d) * r58;
        double r19 = ((((((r11 / 25.0d) + 48.6d) * r58) - 32.4d) * r58) + 6.48d) * r58;
        double r110 = ((((r17 * 343.0d) + 833.0d) / 300.0d) + (((((-637.0d) - (r17 * 357.0d)) / 90.0d) + (((((r17 * 287.0d) + 392.0d) / 60.0d) + ((((-49.0d) - (r17 * 49.0d)) * r58) / 25.0d)) * r58)) * r58)) * r58;
        double r111 = r58 * (((833.0d - (343.0d * r17)) / 300.0d) + (r58 * ((((357.0d * r17) - 637.0d) / 90.0d) + (r58 * (((392.0d - (287.0d * r17)) / 60.0d) + ((((r17 * 49.0d) - 49.0d) * r58) / 25.0d))))));
        double r112 = r58 * ((r58 * ((0.75d * r58) - 1.0d)) + 0.3d);
        int r6 = 0;
    L8:
        if (r6 >= this.interpolatedState.length) goto L14;
        double r28 = this.yDotK[0][r6];
        double r32 = this.yDotK[1][r6];
        double r34 = this.yDotK[2][r6];
        double r36 = this.yDotK[3][r6];
        double r38 = this.yDotK[4][r6];
        double r310 = this.yDotK[5][r6];
        double r42 = this.yDotK[6][r6];
        double r47 = r15;
        double r51 = r9;
        double r311 = r32 * 0.0d;
        this.interpolatedState[r6] = this.previousState[r6] + ((this.h * r58) * (((((((r4 * r28) + r311) + (r14 * r34)) + (r19 * r36)) + (r110 * r38)) + (r111 * r310)) + (r112 * r42)));
        this.interpolatedDerivatives[r6] = ((((((r28 * r3) + r311) + (r51 * r34)) + (r47 * r36)) + (r38 * r21)) + (r310 * r25)) + (r42 * r29);
        r6 = r6 + 1;
        r15 = r47;
        r9 = r51;
        goto L8
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new LutherStepInterpolator(this);
    }
}
