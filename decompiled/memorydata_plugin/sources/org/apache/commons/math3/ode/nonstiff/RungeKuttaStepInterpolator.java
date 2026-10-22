package org.apache.commons.math3.ode.nonstiff;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
abstract class RungeKuttaStepInterpolator extends AbstractStepInterpolator {
    protected AbstractIntegrator integrator;
    protected double[] previousState;
    protected double[][] yDotK;

    public RungeKuttaStepInterpolator() {
        this.previousState = null;
        this.yDotK = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        this.integrator = null;
    }

    RungeKuttaStepInterpolator(RungeKuttaStepInterpolator r7) {
        super(r7);
        if (r7.currentState == null) goto L8;
        this.previousState = (double[]) ZeusTransformUtils.preCheckCast(r7.previousState.clone(), double[].class, "com.obric.memorydata.plugin");
        this.yDotK = new double[r7.yDotK.length][];
        int r1 = 0;
    L5:
        double[][] r4 = r7.yDotK;
        if (r1 >= r4.length) goto L9;
        this.yDotK[r1] = (double[]) ZeusTransformUtils.preCheckCast(r4[r1].clone(), double[].class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
    L9:
        this.integrator = null;
        return;
    L8:
        this.previousState = null;
        this.yDotK = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        goto L9
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput r12) {
        ObjectInput r13 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r12, ObjectInput.class, "com.obric.memorydata.plugin");
        double r2 = readBaseExternal(r13);
        if (this.currentState != null) goto L5;
        int r0 = -1;
    L7:
        if (r0 >= 0) goto L9;
        this.previousState = null;
    L12:
        int r6 = r13.readInt();
        if (r6 >= 0) goto L15;
        double[][] r1 = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
    L16:
        this.yDotK = r1;
        int r3 = 0;
    L17:
        if (r3 >= r6) goto L26;
        double[][] r7 = this.yDotK;
        if (r0 >= 0) goto L21;
        double[] r8 = null;
    L22:
        r7[r3] = r8;
        int r9 = 0;
    L23:
        if (r9 >= r0) goto L25;
        this.yDotK[r3][r9] = r13.readDouble();
        r9 = r9 + 1;
        goto L23
    L25:
        r3 = r3 + 1;
        goto L17
    L21:
        r8 = new double[r0];
        goto L22
    L26:
        this.integrator = null;
        if (this.currentState == null) goto L29;
        setInterpolatedTime(r2);
        return;
    L29:
        this.interpolatedTime = r2;
        return;
    L15:
        r1 = new double[r6][];
        goto L16
    L9:
        this.previousState = new double[r0];
        int r10 = 0;
    L10:
        if (r10 >= r0) goto L12;
        this.previousState[r10] = r13.readDouble();
        r10 = r10 + 1;
        goto L10
    L5:
        r0 = this.currentState.length;
        goto L7
    }

    public void reinitialize(AbstractIntegrator r1, double[] r2, double[][] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        reinitialize(r2, r4, r5, r6);
        this.previousState = null;
        this.yDotK = r3;
        this.integrator = r1;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void shift() {
        this.previousState = (double[]) ZeusTransformUtils.preCheckCast(this.currentState.clone(), double[].class, "com.obric.memorydata.plugin");
        super.shift();
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput r8) {
        ObjectOutput r9 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r8, ObjectOutput.class, "com.obric.memorydata.plugin");
        writeBaseExternal(r9);
        int r1 = -1;
        if (this.currentState != null) goto L5;
        int r0 = -1;
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r9.writeDouble(this.previousState[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        double[][] r4 = this.yDotK;
        if (r4 == null) goto L13;
        r1 = r4.length;
    L13:
        r9.writeInt(r1);
        int r5 = 0;
    L14:
        if (r5 >= r1) goto L19;
        int r6 = 0;
    L16:
        if (r6 >= r0) goto L18;
        r9.writeDouble(this.yDotK[r5][r6]);
        r6 = r6 + 1;
        goto L16
    L18:
        r5 = r5 + 1;
        goto L14
    L19:
        return;
    L5:
        r0 = this.currentState.length;
        goto L6
    }
}
