package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class EulerStepInterpolator extends RungeKuttaStepInterpolator {
    private static final long serialVersionUID = 20111120;

    public EulerStepInterpolator() {
    }

    EulerStepInterpolator(EulerStepInterpolator r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r9, double r11) {
        if (this.previousState != null) goto L5;
    L11:
        int r10 = 0;
    L13:
        if (r10 >= this.interpolatedState.length) goto L15;
        this.interpolatedState[r10] = this.currentState[r10] - (this.yDotK[0][r10] * r11);
        r10 = r10 + 1;
        goto L13
    L15:
        System.arraycopy(this.yDotK[0], 0, this.interpolatedDerivatives, 0, this.interpolatedDerivatives.length);
        return;
    L5:
        if (r9 > 0.5d) goto L11;
        int r12 = 0;
    L8:
        if (r12 >= this.interpolatedState.length) goto L10;
        this.interpolatedState[r12] = this.previousState[r12] + ((this.h * r9) * this.yDotK[0][r12]);
        r12 = r12 + 1;
        goto L8
    L10:
        System.arraycopy(this.yDotK[0], 0, this.interpolatedDerivatives, 0, this.interpolatedDerivatives.length);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new EulerStepInterpolator(this);
    }
}
