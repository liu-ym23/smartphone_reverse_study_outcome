package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class HighamHall54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public HighamHall54StepInterpolator() {
    }

    HighamHall54StepInterpolator(HighamHall54StepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r56, double r58) {
        double r1 = (((r56 * (16.0d - (10.0d * r56))) - 7.5d) * r56) + 1.0d;
        double r5 = ((((67.5d * r56) - 91.125d) * r56) + 28.6875d) * r56;
        double r7 = ((r56 * (152.0d - (120.0d * r56))) - 44.0d) * r56;
        double r9 = ((((62.5d * r56) - 78.125d) * r56) + 23.4375d) * r56;
        double r11 = 5.0d * r56;
        double r15 = (r11 / 8.0d) * ((r56 * 2.0d) - 1.0d);
        if (this.previousState != null) goto L5;
    L10:
        double r13 = r56 * r56;
        double r3 = this.h * ((r56 * ((((r56 * ((((-5.0d) * r56) / 2.0d) + 5.333333333333333d)) - 3.75d) * r56) + 1.0d)) - 0.08333333333333333d);
        double r16 = r9;
        double r10 = this.h * (((((((135.0d * r56) / 8.0d) - 30.375d) * r56) + 14.34375d) * r13) - 0.84375d);
        double r8 = this.h * (((((((-30.0d) * r56) + 50.666666666666664d) * r56) - 22.0d) * r13) + 1.3333333333333333d);
        double r6 = this.h * (((((((125.0d * r56) / 8.0d) - 26.041666666666668d) * r56) + 11.71875d) * r13) - 1.3020833333333333d);
        double r2 = this.h * ((r13 * ((r11 / 12.0d) - 0.3125d)) - 0.10416666666666667d);
        int r12 = 0;
    L12:
        if (r12 >= this.interpolatedState.length) goto L17;
        double r14 = this.yDotK[0][r12];
        double r22 = this.yDotK[2][r12];
        double r24 = this.yDotK[3][r12];
        double r26 = this.yDotK[4][r12];
        double r29 = this.yDotK[5][r12];
        double r34 = r16;
        this.interpolatedState[r12] = ((((this.currentState[r12] + (r3 * r14)) + (r10 * r22)) + (r8 * r24)) + (r6 * r26)) + (r2 * r29);
        this.interpolatedDerivatives[r12] = ((((r14 * r1) + (r5 * r22)) + (r7 * r24)) + (r34 * r26)) + (r15 * r29);
        r12 = r12 + 1;
        r16 = r34;
        goto L12
    L17:
        return;
    L5:
        if (r56 > 0.5d) goto L10;
        double r17 = this.h * r56;
        double r18 = ((((r56 * (5.333333333333333d - (2.5d * r56))) - 3.75d) * r56) + 1.0d) * r17;
        double r4 = ((((((r56 * 135.0d) / 8.0d) - 30.375d) * r56) + 14.34375d) * r56) * r17;
        double r32 = ((((((-30.0d) * r56) + 50.666666666666664d) * r56) - 22.0d) * r56) * r17;
        double r27 = ((((((125.0d * r56) / 8.0d) - 26.041666666666668d) * r56) + 11.71875d) * r56) * r17;
        double r19 = r17 * (((r11 / 12.0d) - 0.3125d) * r56);
        int r110 = 0;
    L8:
        if (r110 >= this.interpolatedState.length) goto L14;
        double r23 = this.yDotK[0][r110];
        double r25 = this.yDotK[2][r110];
        double r28 = this.yDotK[3][r110];
        double r30 = this.yDotK[4][r110];
        double r35 = this.yDotK[5][r110];
        this.interpolatedState[r110] = ((((this.previousState[r110] + (r18 * r23)) + (r4 * r25)) + (r32 * r28)) + (r27 * r30)) + (r19 * r35);
        this.interpolatedDerivatives[r110] = ((((r23 * r1) + (r25 * r5)) + (r28 * r7)) + (r30 * r9)) + (r15 * r35);
        r110 = r110 + 1;
        goto L8
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new HighamHall54StepInterpolator(this);
    }
}
