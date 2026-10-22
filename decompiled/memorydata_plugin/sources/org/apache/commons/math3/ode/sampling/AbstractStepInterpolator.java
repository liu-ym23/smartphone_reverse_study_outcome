package org.apache.commons.math3.ode.sampling;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.EquationsMapper;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractStepInterpolator implements StepInterpolator {
    protected double[] currentState;
    private boolean dirtyState;
    private boolean finalized;
    private boolean forward;
    private double globalCurrentTime;
    private double globalPreviousTime;
    protected double h;
    protected double[] interpolatedDerivatives;
    protected double[] interpolatedPrimaryDerivatives;
    protected double[] interpolatedPrimaryState;
    protected double[][] interpolatedSecondaryDerivatives;
    protected double[][] interpolatedSecondaryState;
    protected double[] interpolatedState;
    protected double interpolatedTime;
    private EquationsMapper primaryMapper;
    private EquationsMapper[] secondaryMappers;
    private double softCurrentTime;
    private double softPreviousTime;

    public AbstractStepInterpolator() {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = null;
        this.finalized = false;
        this.forward = true;
        this.dirtyState = true;
        this.primaryMapper = null;
        this.secondaryMappers = null;
        allocateInterpolatedArrays(-1);
    }

    public AbstractStepInterpolator(AbstractStepInterpolator r7) {
        this.globalPreviousTime = r7.globalPreviousTime;
        this.globalCurrentTime = r7.globalCurrentTime;
        this.softPreviousTime = r7.softPreviousTime;
        this.softCurrentTime = r7.softCurrentTime;
        this.h = r7.h;
        this.interpolatedTime = r7.interpolatedTime;
        double[] r1 = r7.currentState;
        EquationsMapper[] r2 = null;
        if (r1 != null) goto L5;
        this.currentState = null;
        this.primaryMapper = null;
        this.secondaryMappers = null;
        allocateInterpolatedArrays(-1);
    L9:
        this.finalized = r7.finalized;
        this.forward = r7.forward;
        this.dirtyState = r7.dirtyState;
        this.primaryMapper = r7.primaryMapper;
        EquationsMapper[] r8 = r7.secondaryMappers;
        if (r8 == null) goto L13;
        r2 = (EquationsMapper[]) ZeusTransformUtils.preCheckCast(r8.clone(), EquationsMapper[].class, "com.obric.memorydata.plugin");
    L13:
        this.secondaryMappers = r2;
        return;
    L5:
        this.currentState = (double[]) ZeusTransformUtils.preCheckCast(r1.clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedState = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedState.clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedDerivatives = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedDerivatives.clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedPrimaryState = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedPrimaryState.clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedPrimaryDerivatives = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedPrimaryDerivatives.clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedSecondaryState = new double[r7.interpolatedSecondaryState.length][];
        this.interpolatedSecondaryDerivatives = new double[r7.interpolatedSecondaryDerivatives.length][];
        int r3 = 0;
    L6:
        double[][] r4 = this.interpolatedSecondaryState;
        if (r3 >= r4.length) goto L9;
        r4[r3] = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedSecondaryState[r3].clone(), double[].class, "com.obric.memorydata.plugin");
        this.interpolatedSecondaryDerivatives[r3] = (double[]) ZeusTransformUtils.preCheckCast(r7.interpolatedSecondaryDerivatives[r3].clone(), double[].class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L6
    }

    public AbstractStepInterpolator(double[] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = r3;
        this.finalized = false;
        this.forward = r4;
        this.dirtyState = true;
        this.primaryMapper = r5;
        if (r6 != null) goto L5;
        EquationsMapper[] r7 = null;
    L6:
        this.secondaryMappers = r7;
        allocateInterpolatedArrays(r3.length);
        return;
    L5:
        r7 = (EquationsMapper[]) ZeusTransformUtils.preCheckCast(r6.clone(), EquationsMapper[].class, "com.obric.memorydata.plugin");
        goto L6
    }

    private void allocateInterpolatedArrays(int r5) {
        if (r5 >= 0) goto L5;
        this.interpolatedState = null;
        this.interpolatedDerivatives = null;
        this.interpolatedPrimaryState = null;
        this.interpolatedPrimaryDerivatives = null;
        this.interpolatedSecondaryState = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        this.interpolatedSecondaryDerivatives = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        return;
    L5:
        this.interpolatedState = new double[r5];
        this.interpolatedDerivatives = new double[r5];
        this.interpolatedPrimaryState = new double[this.primaryMapper.getDimension()];
        this.interpolatedPrimaryDerivatives = new double[this.primaryMapper.getDimension()];
        EquationsMapper[] r6 = this.secondaryMappers;
        if (r6 != null) goto L8;
        this.interpolatedSecondaryState = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        this.interpolatedSecondaryDerivatives = (double[][]) ZeusTransformUtils.preCheckCast(null, double[][].class, "com.obric.memorydata.plugin");
        return;
    L8:
        this.interpolatedSecondaryState = new double[r6.length][];
        this.interpolatedSecondaryDerivatives = new double[r6.length][];
        int r7 = 0;
    L9:
        EquationsMapper[] r0 = this.secondaryMappers;
        if (r7 >= r0.length) goto L15;
        this.interpolatedSecondaryState[r7] = new double[r0[r7].getDimension()];
        this.interpolatedSecondaryDerivatives[r7] = new double[this.secondaryMappers[r7].getDimension()];
        r7 = r7 + 1;
        goto L9
    }

    private void evaluateCompleteInterpolatedState() {
        if (this.dirtyState == false) goto L10;
        double r0 = this.globalCurrentTime - this.interpolatedTime;
        double r2 = this.h;
        double r4 = 0.0d;
        if (r2 == 0.0d) goto L8;
        r4 = (r2 - r0) / r2;
    L8:
        computeInterpolatedStateAndDerivatives(r4, r0);
        this.dirtyState = false;
        return;
    }

    public abstract void computeInterpolatedStateAndDerivatives(double r1, double r3);

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public StepInterpolator copy() {
        finalizeStep();
        return doCopy();
    }

    public abstract StepInterpolator doCopy();

    public void doFinalize() {
    }

    public final void finalizeStep() {
        if (this.finalized == true) goto L6;
        doFinalize();
        this.finalized = true;
        return;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getCurrentTime() {
        return this.softCurrentTime;
    }

    public double getGlobalCurrentTime() {
        return this.globalCurrentTime;
    }

    public double getGlobalPreviousTime() {
        return this.globalPreviousTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedDerivatives() {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedDerivatives, this.interpolatedPrimaryDerivatives);
        return this.interpolatedPrimaryDerivatives;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryDerivatives(int r4) {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[r4].extractEquationData(this.interpolatedDerivatives, this.interpolatedSecondaryDerivatives[r4]);
        return this.interpolatedSecondaryDerivatives[r4];
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryState(int r4) {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[r4].extractEquationData(this.interpolatedState, this.interpolatedSecondaryState[r4]);
        return this.interpolatedSecondaryState[r4];
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedState() {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedState, this.interpolatedPrimaryState);
        return this.interpolatedPrimaryState;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getInterpolatedTime() {
        return this.interpolatedTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getPreviousTime() {
        return this.softPreviousTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public boolean isForward() {
        return this.forward;
    }

    public double readBaseExternal(ObjectInput r8) {
        ObjectInput r9 = (ObjectInput) ZeusTransformUtils.wrapperContextForParams(r8, ObjectInput.class, "com.obric.memorydata.plugin");
        int r0 = r9.readInt();
        this.globalPreviousTime = r9.readDouble();
        this.globalCurrentTime = r9.readDouble();
        this.softPreviousTime = r9.readDouble();
        this.softCurrentTime = r9.readDouble();
        this.h = r9.readDouble();
        this.forward = r9.readBoolean();
        this.primaryMapper = (EquationsMapper) ZeusTransformUtils.preCheckCast(r9.readObject(), EquationsMapper.class, "com.obric.memorydata.plugin");
        this.secondaryMappers = new EquationsMapper[r9.read()];
        int r2 = 0;
        int r3 = 0;
    L3:
        EquationsMapper[] r4 = this.secondaryMappers;
        if (r3 >= r4.length) goto L6;
        r4[r3] = (EquationsMapper) ZeusTransformUtils.preCheckCast(r9.readObject(), EquationsMapper.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L6:
        this.dirtyState = true;
        if (r0 >= 0) goto L9;
        this.currentState = null;
    L13:
        this.interpolatedTime = Double.NaN;
        allocateInterpolatedArrays(r0);
        this.finalized = true;
        return r9.readDouble();
    L9:
        this.currentState = new double[r0];
    L10:
        double[] r5 = this.currentState;
        if (r2 >= r5.length) goto L13;
        r5[r2] = r9.readDouble();
        r2 = r2 + 1;
        goto L10
    }

    @Override // java.io.Externalizable
    public abstract void readExternal(ObjectInput r1);

    public void reinitialize(double[] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = r3;
        this.finalized = false;
        this.forward = r4;
        this.dirtyState = true;
        this.primaryMapper = r5;
        this.secondaryMappers = (EquationsMapper[]) ZeusTransformUtils.preCheckCast(r6.clone(), EquationsMapper[].class, "com.obric.memorydata.plugin");
        allocateInterpolatedArrays(r3.length);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public void setInterpolatedTime(double r1) {
        this.interpolatedTime = r1;
        this.dirtyState = true;
    }

    public void setSoftCurrentTime(double r1) {
        this.softCurrentTime = r1;
    }

    public void setSoftPreviousTime(double r1) {
        this.softPreviousTime = r1;
    }

    public void shift() {
        double r0 = this.globalCurrentTime;
        this.globalPreviousTime = r0;
        this.softPreviousTime = r0;
        this.softCurrentTime = r0;
    }

    public void storeTime(double r3) {
        this.globalCurrentTime = r3;
        this.softCurrentTime = r3;
        this.h = r3 - this.globalPreviousTime;
        setInterpolatedTime(r3);
        this.finalized = false;
    }

    public void writeBaseExternal(ObjectOutput r6) {
        ObjectOutput r7 = (ObjectOutput) ZeusTransformUtils.wrapperContextForParams(r6, ObjectOutput.class, "com.obric.memorydata.plugin");
        double[] r0 = this.currentState;
        if (r0 != null) goto L5;
        int r1 = -1;
    L6:
        r7.writeInt(r1);
        r7.writeDouble(this.globalPreviousTime);
        r7.writeDouble(this.globalCurrentTime);
        r7.writeDouble(this.softPreviousTime);
        r7.writeDouble(this.softCurrentTime);
        r7.writeDouble(this.h);
        r7.writeBoolean(this.forward);
        r7.writeObject(this.primaryMapper);
        r7.write(this.secondaryMappers.length);
        EquationsMapper[] r2 = this.secondaryMappers;
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r5 >= r3) goto L10;
        r7.writeObject(r2[r5]);
        r5 = r5 + 1;
        goto L7
    L10:
        if (this.currentState == null) goto L14;
    L11:
        double[] r8 = this.currentState;
        if (r4 >= r8.length) goto L14;
        r7.writeDouble(r8[r4]);
        r4 = r4 + 1;
    L14:
        r7.writeDouble(this.interpolatedTime);
        finalizeStep();     // Catch: MaxCountExceededException -> L17
        return;
    L17:
        e = move-exception;
        IOException r9 = new IOException(e.getLocalizedMessage());
        r9.initCause(e);
        throw r9;
    L5:
        r1 = r0.length;
        goto L6
    }

    @Override // java.io.Externalizable
    public abstract void writeExternal(ObjectOutput r1);
}
