package org.apache.commons.math3.ode.nonstiff;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
class DormandPrince54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double A70 = 0.09114583333333333d;
    private static final double A72 = 0.44923629829290207d;
    private static final double A73 = 0.6510416666666666d;
    private static final double A74 = -0.322376179245283d;
    private static final double A75 = 0.13095238095238096d;
    private static final double D0 = -1.1270175653862835d;
    private static final double D2 = 2.675424484351598d;
    private static final double D3 = -5.685526961588504d;
    private static final double D4 = 3.5219323679207912d;
    private static final double D5 = -1.7672812570757455d;
    private static final double D6 = 2.382468931778144d;
    private static final long serialVersionUID = 20111120;
    private double[] v1;
    private double[] v2;
    private double[] v3;
    private double[] v4;
    private boolean vectorsInitialized;

    public DormandPrince54StepInterpolator() {
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    DormandPrince54StepInterpolator(DormandPrince54StepInterpolator r4) {
        super(r4);
        double[] r1 = r4.v1;
        if (r1 != null) goto L5;
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        boolean r5 = false;
    L6:
        this.vectorsInitialized = r5;
        return;
    L5:
        this.v1 = (double[]) ZeusTransformUtils.preCheckCast(r1.clone(), double[].class, "com.obric.memorydata.plugin");
        this.v2 = (double[]) ZeusTransformUtils.preCheckCast(r4.v2.clone(), double[].class, "com.obric.memorydata.plugin");
        this.v3 = (double[]) ZeusTransformUtils.preCheckCast(r4.v3.clone(), double[].class, "com.obric.memorydata.plugin");
        this.v4 = (double[]) ZeusTransformUtils.preCheckCast(r4.v4.clone(), double[].class, "com.obric.memorydata.plugin");
        r5 = r4.vectorsInitialized;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r24, double r26) {
        char r2 = 0;
        if (this.vectorsInitialized == false) goto L5;
    L12:
        double r3 = 1.0d - r24;
        double r7 = r24 * 2.0d;
        double r9 = 1.0d - r7;
        double r5 = (2.0d - (r24 * 3.0d)) * r24;
        double r8 = r7 * (((r7 - 3.0d) * r24) + 1.0d);
        if (this.previousState != null) goto L15;
    L20:
        int r4 = 0;
    L22:
        if (r4 >= this.interpolatedState.length) goto L28;
        this.interpolatedState[r4] = this.currentState[r4] - ((this.v1[r4] - ((this.v2[r4] + ((this.v3[r4] + (this.v4[r4] * r3)) * r24)) * r24)) * r26);
        this.interpolatedDerivatives[r4] = ((this.v1[r4] + (r9 * this.v2[r4])) + (this.v3[r4] * r5)) + (this.v4[r4] * r8);
        r4 = r4 + 1;
        goto L22
    L28:
        return;
    L15:
        if (r24 > 0.5d) goto L20;
        int r6 = 0;
    L18:
        if (r6 >= this.interpolatedState.length) goto L24;
        double r17 = r8;
        double r19 = r5;
        double r21 = r9;
        this.interpolatedState[r6] = this.previousState[r6] + ((this.h * r24) * (this.v1[r6] + ((this.v2[r6] + ((this.v3[r6] + (this.v4[r6] * r3)) * r24)) * r3)));
        this.interpolatedDerivatives[r6] = ((this.v1[r6] + (r21 * this.v2[r6])) + (this.v3[r6] * r19)) + (this.v4[r6] * r17);
        r6 = r6 + 1;
        r8 = r17;
        r5 = r19;
        r9 = r21;
        goto L18
    L24:
        return;
    L5:
        if (this.v1 != null) goto L7;
        this.v1 = new double[this.interpolatedState.length];
        this.v2 = new double[this.interpolatedState.length];
        this.v3 = new double[this.interpolatedState.length];
        this.v4 = new double[this.interpolatedState.length];
    L7:
        int r1 = 0;
    L9:
        if (r1 >= this.interpolatedState.length) goto L11;
        double r10 = this.yDotK[r2][r1];
        double r11 = this.yDotK[2][r1];
        double r12 = this.yDotK[3][r1];
        double r13 = this.yDotK[4][r1];
        double r14 = this.yDotK[5][r1];
        double r15 = this.yDotK[6][r1];
        double[] r16 = this.v1;
        r16[r1] = ((((A70 * r10) + (A72 * r11)) + (A73 * r12)) + (A74 * r13)) + (A75 * r14);
        double[] r18 = this.v2;
        r18[r1] = r10 - r16[r1];
        this.v3[r1] = (r16[r1] - r18[r1]) - r15;
        this.v4[r1] = (((((r10 * D0) + (r11 * D2)) + (r12 * D3)) + (r13 * D4)) + (r14 * D5)) + (r15 * D6);
        r1 = r1 + 1;
        r2 = 0;
        goto L9
    L11:
        this.vectorsInitialized = true;
        goto L12
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new DormandPrince54StepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaStepInterpolator
    public void reinitialize(AbstractIntegrator r1, double[] r2, double[][] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        super.reinitialize(r1, r2, r3, r4, r5, r6);
        this.v1 = null;
        this.v2 = null;
        this.v3 = null;
        this.v4 = null;
        this.vectorsInitialized = false;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void storeTime(double r1) {
        super.storeTime(r1);
        this.vectorsInitialized = false;
    }
}
