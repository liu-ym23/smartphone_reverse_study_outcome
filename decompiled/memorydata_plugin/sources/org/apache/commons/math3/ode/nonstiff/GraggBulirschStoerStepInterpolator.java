package org.apache.commons.math3.ode.nonstiff;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
class GraggBulirschStoerStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = 20110928;
    private int currentDegree;
    private double[] errfac;
    private double[][] polynomials;
    private double[] y0Dot;
    private double[] y1;
    private double[] y1Dot;
    private double[][] yMidDots;

    public GraggBulirschStoerStepInterpolator() {
        this.y0Dot = null;
        this.y1 = null;
        this.y1Dot = null;
        this.yMidDots = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        resetTables(-1);
    }

    GraggBulirschStoerStepInterpolator(GraggBulirschStoerStepInterpolator r6) {
        super(r6);
        int r1 = this.currentState.length;
        this.y0Dot = null;
        this.y1 = null;
        this.y1Dot = null;
        this.yMidDots = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        if (r6.polynomials != null) goto L6;
        this.polynomials = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        int r7 = -1;
    L5:
        this.currentDegree = r7;
        return;
    L6:
        resetTables(r6.currentDegree);
        int r2 = 0;
    L7:
        double[][] r3 = this.polynomials;
        if (r2 >= r3.length) goto L10;
        r3[r2] = new double[r1];
        System.arraycopy(r6.polynomials[r2], 0, r3[r2], 0, r1);
        r2 = r2 + 1;
        goto L7
    L10:
        r7 = r6.currentDegree;
        goto L5
    }

    GraggBulirschStoerStepInterpolator(double[] r1, double[] r2, double[] r3, double[] r4, double[][] r5, boolean r6, EquationsMapper r7, EquationsMapper[] r8) {
        super(r1, r6, r7, r8);
        this.y0Dot = r2;
        this.y1 = r3;
        this.y1Dot = r4;
        this.yMidDots = r5;
        resetTables(r5.length + 4);
    }

    private void resetTables(int r12) {
        if (r12 >= 0) goto L5;
        this.polynomials = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        this.errfac = null;
        this.currentDegree = -1;
        return;
    L5:
        int r1 = r12 + 1;
        double[][] r2 = new double[r1][];
        double[][] r3 = this.polynomials;
        if (r3 == null) goto L10;
        System.arraycopy(r3, 0, r2, 0, r3.length);
        int r4 = this.polynomials.length;
    L8:
        if (r4 >= r1) goto L13;
        r2[r4] = new double[this.currentState.length];
        r4 = r4 + 1;
    L13:
        this.polynomials = r2;
        if (r12 > 4) goto L16;
        this.errfac = null;
    L23:
        this.currentDegree = 0;
        return;
    L16:
        this.errfac = new double[r12 - 4];
        int r13 = 0;
    L17:
        double[] r0 = this.errfac;
        if (r13 >= r0.length) goto L23;
        int r5 = r13 + 5;
        r0[r13] = 1.0d / ((double) (r5 * r5));
        int r6 = r13 + 1;
        double r7 = FastMath.sqrt(((double) r6) / ((double) r5)) * 0.5d;
        int r8 = 0;
    L20:
        if (r8 > r13) goto L22;
        double[] r9 = this.errfac;
        r8 = r8 + 1;
        r9[r13] = r9[r13] * (r7 / ((double) r8));
        goto L20
    L22:
        r13 = r6;
        goto L17
    L10:
        int r10 = 0;
    L11:
        if (r10 >= r1) goto L13;
        r2[r10] = new double[this.currentState.length];
        r10 = r10 + 1;
        goto L11
    }

    public void computeCoefficients(int r30, double r31) {
        double[][] r2 = this.polynomials;
        if (r2 != null) goto L5;
    L6:
        resetTables(r30 + 4);
    L7:
        this.currentDegree = r30 + 4;
        char r3 = 0;
        int r4 = 0;
    L9:
        if (r4 >= this.currentState.length) goto L23;
        double r5 = this.y0Dot[r4] * r31;
        double r6 = this.y1Dot[r4] * r31;
        double r8 = this.y1[r4] - this.currentState[r4];
        double r10 = r8 - r6;
        double r12 = r5 - r8;
        this.polynomials[r3][r4] = this.currentState[r4];
        double[][] r14 = this.polynomials;
        r14[1][r4] = r8;
        r14[2][r4] = r10;
        r14[3][r4] = r12;
        if (r30 < 0) goto L12;
        double r18 = ((this.currentState[r4] + this.y1[r4]) * 0.5d) + ((r10 + r12) * 0.125d);
        double[][] r15 = this.polynomials;
        double[] r23 = r15[4];
        double[][] r16 = this.yMidDots;
        r23[r4] = (r16[r3][r4] - r18) * 16.0d;
        if (r30 <= 0) goto L22;
        r15[5][r4] = (r16[1][r4] - (r8 + ((r10 - r12) * 0.25d))) * 16.0d;
        if (r30 <= 1) goto L22;
        r15[6][r4] = ((r16[2][r4] - (r6 - r5)) + r15[4][r4]) * 16.0d;
        if (r30 <= 2) goto L22;
        r15[7][r4] = ((r16[3][r4] - ((r12 - r10) * 6.0d)) + (r15[5][r4] * 3.0d)) * 16.0d;
        int r7 = 4;
    L20:
        if (r7 > r30) goto L22;
        double r9 = (((double) r7) * 0.5d) * ((double) (r7 - 1));
        double[][] r11 = this.polynomials;
        r11[r7 + 4][r4] = ((this.yMidDots[r7][r4] + (r9 * r11[r7 + 2][r4])) - ((((2.0d * r9) * ((double) (r7 - 2))) * ((double) (r7 - 3))) * r11[r7][r4])) * 16.0d;
        r7 = r7 + 1;
    L22:
        r4 = r4 + 1;
        r3 = 0;
        goto L9
    L12:
        return;
    L23:
        return;
    L5:
        if (r2.length > (r30 + 4)) goto L7;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double r35, double r37) {
        int r1 = this.currentState.length;
        double r4 = 1.0d - r35;
        double r6 = r35 - 0.5d;
        double r8 = r35 * r4;
        double r10 = r8 * r8;
        double r9 = (r8 * 2.0d) * (1.0d - (r35 * 2.0d));
        double r14 = 1.0d / this.h;
        double r16 = 3.0d * r35;
        double r12 = ((2.0d - r16) * r35) / this.h;
        double r17 = (((r16 - 4.0d) * r35) + 1.0d) / this.h;
        char r2 = 0;
        int r3 = 0;
    L3:
        double r18 = 0.0d;
        int r21 = r1;
        if (r3 >= r1) goto L15;
        double[][] r5 = this.polynomials;
        double r22 = r5[r2][r3];
        double r24 = r5[1][r3];
        double r26 = r5[2][r3];
        double r28 = r5[3][r3];
        this.interpolatedState[r3] = r22 + ((r24 + (((r26 * r35) + (r28 * r4)) * r4)) * r35);
        this.interpolatedDerivatives[r3] = ((r24 * r14) + (r26 * r12)) + (r28 * r17);
        int r7 = this.currentDegree;
        if (r7 <= 3) goto L12;
        double r23 = this.polynomials[r7][r3];
        int r11 = r7 - 1;
    L9:
        if (r11 <= 3) goto L11;
        double r25 = r4;
        double r13 = 1.0d / ((double) (r11 - 3));
        r18 = ((r18 * r6) + r23) * r13;
        r23 = this.polynomials[r11][r3] + ((r23 * r13) * r6);
        r11 = r11 - 1;
        r4 = r25;
        goto L9
    L11:
        double r27 = r4;
        double[] r15 = this.interpolatedState;
        r15[r3] = r15[r3] + (r10 * r23);
        double[] r19 = this.interpolatedDerivatives;
        r19[r3] = r19[r3] + (((r18 * r10) + (r23 * r9)) / this.h);
    L13:
        r3 = r3 + 1;
        r6 = r6;
        r1 = r21;
        r4 = r27;
        r2 = 0;
        goto L3
    L12:
        r27 = r4;
        goto L13
    L15:
        if (this.h != 0.0d) goto L22;
        System.arraycopy(this.yMidDots[1], 0, this.interpolatedDerivatives, 0, r21);
        return;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new GraggBulirschStoerStepInterpolator(this);
    }

    public double estimateError(double[] r9) {
        double r2 = 0.0d;
        if (this.currentDegree < 5) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r9.length) goto L9;
        double r4 = this.polynomials[this.currentDegree][r0] / r9[r0];
        r2 = r2 + (r4 * r4);
        r0 = r0 + 1;
        goto L6
    L9:
        return FastMath.sqrt(r2 / ((double) r9.length)) * this.errfac[this.currentDegree - 5];
    L11:
        return 0.0d;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput r10) {
        ObjectInput r11 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r10, ObjectInput.class, "com.obric.memorydata.plugin");
        double r0 = readBaseExternal(r11);
        if (this.currentState != null) goto L5;
        int r2 = -1;
    L6:
        int r3 = r11.readInt();
        resetTables(r3);
        this.currentDegree = r3;
        int r4 = 0;
    L8:
        if (r4 > this.currentDegree) goto L13;
        int r5 = 0;
    L10:
        if (r5 >= r2) goto L12;
        this.polynomials[r4][r5] = r11.readDouble();
        r5 = r5 + 1;
        goto L10
    L12:
        r4 = r4 + 1;
        goto L8
    L13:
        setInterpolatedTime(r0);
        return;
    L5:
        r2 = this.currentState.length;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput r7) {
        ObjectOutput r8 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r7, ObjectOutput.class, "com.obric.memorydata.plugin");
        if (this.currentState != null) goto L5;
        int r0 = -1;
    L6:
        writeBaseExternal(r8);
        r8.writeInt(this.currentDegree);
        int r2 = 0;
    L8:
        if (r2 > this.currentDegree) goto L13;
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L12;
        r8.writeDouble(this.polynomials[r2][r3]);
        r3 = r3 + 1;
        goto L10
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return;
    L5:
        r0 = this.currentState.length;
        goto L6
    }
}
