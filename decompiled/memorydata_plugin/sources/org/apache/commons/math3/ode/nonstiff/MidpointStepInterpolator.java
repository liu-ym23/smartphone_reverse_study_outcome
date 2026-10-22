package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class MidpointStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public MidpointStepInterpolator() {
    }

    MidpointStepInterpolator(MidpointStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r22, double r24) {
        double r1 = 2.0d * r22;
        double r5 = 1.0d - r1;
        char r8 = 1;
        char r9 = 0;
        if (this.previousState != null) goto L5;
    L10:
        double r7 = r24 * r22;
        double r3 = (r22 + 1.0d) * r24;
        int r10 = 0;
    L12:
        if (r10 >= this.interpolatedState.length) goto L17;
        double r12 = this.yDotK[0][r10];
        double r15 = this.yDotK[1][r10];
        this.interpolatedState[r10] = (this.currentState[r10] + (r7 * r12)) - (r3 * r15);
        this.interpolatedDerivatives[r10] = (r12 * r5) + (r15 * r1);
        r10 = r10 + 1;
        goto L12
    L17:
        return;
    L5:
        if (r22 > 0.5d) goto L10;
        double r4 = r22 * r24;
        double r11 = (r22 * r22) * this.h;
        int r13 = 0;
    L8:
        if (r13 >= this.interpolatedState.length) goto L14;
        double r14 = this.yDotK[r9][r13];
        double r16 = this.yDotK[r8][r13];
        this.interpolatedState[r13] = (this.previousState[r13] + (r4 * r14)) + (r11 * r16);
        this.interpolatedDerivatives[r13] = (r14 * r5) + (r16 * r1);
        r13 = r13 + 1;
        r8 = 1;
        r9 = 0;
        goto L8
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new MidpointStepInterpolator(this);
    }
}
