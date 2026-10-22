package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class ClassicalRungeKuttaStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public ClassicalRungeKuttaStepInterpolator() {
    }

    ClassicalRungeKuttaStepInterpolator(ClassicalRungeKuttaStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r31, double r33) {
        double r5 = 1.0d - r31;
        double r9 = r31 * 2.0d;
        double r11 = 1.0d - r9;
        double r13 = r5 * r11;
        double r10 = r9 * r5;
        double r6 = (-r31) * r11;
        if (this.previousState != null) goto L5;
    L10:
        double r12 = r31 * 4.0d;
        double r16 = r33 / 6.0d;
        double r7 = -r12;
        double r24 = (((r7 + 5.0d) * r31) - 1.0d) * r16;
        double r14 = (((r12 - 2.0d) * r31) - 2.0d) * r16;
        double r17 = r16 * (((r7 - 1.0d) * r31) - 1.0d);
        int r1 = 0;
    L12:
        if (r1 >= this.interpolatedState.length) goto L17;
        double r2 = this.yDotK[0][r1];
        double r8 = this.yDotK[1][r1] + this.yDotK[2][r1];
        double r20 = this.yDotK[3][r1];
        this.interpolatedState[r1] = ((this.currentState[r1] + (r24 * r2)) + (r14 * r8)) + (r17 * r20);
        this.interpolatedDerivatives[r1] = ((r2 * r13) + (r8 * r10)) + (r20 * r6);
        r1 = r1 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r31 > 0.5d) goto L10;
        double r3 = (r31 * 4.0d) * r31;
        double r15 = (this.h * r31) / 6.0d;
        double r18 = ((6.0d - (9.0d * r31)) + r3) * r15;
        double r21 = ((6.0d * r31) - r3) * r15;
        double r19 = r15 * ((r31 * (-3.0d)) + r3);
        int r4 = 0;
    L8:
        if (r4 >= this.interpolatedState.length) goto L14;
        double r22 = this.yDotK[0][r4];
        double r23 = this.yDotK[1][r4] + this.yDotK[2][r4];
        double r25 = this.yDotK[3][r4];
        this.interpolatedState[r4] = ((this.previousState[r4] + (r18 * r22)) + (r21 * r23)) + (r19 * r25);
        this.interpolatedDerivatives[r4] = ((r22 * r13) + (r23 * r10)) + (r25 * r6);
        r4 = r4 + 1;
        goto L8
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new ClassicalRungeKuttaStepInterpolator(this);
    }
}
