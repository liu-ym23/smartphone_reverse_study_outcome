package org.apache.commons.math3.ode;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ContinuousOutputModel implements Serializable {
    private static final long serialVersionUID = -1417964919405031606L;
    private double finalTime;
    private boolean forward;
    private int index;
    private double initialTime;
    private List<StepInterpolator> steps;

    public ContinuousOutputModel() {
        this.steps = new ArrayList();
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
    }

    private int locatePoint(double r6, StepInterpolator r8) {
        StepInterpolator r9 = (StepInterpolator) ZeusTransformUtils.wrapperContextForParams(r8, StepInterpolator.class, "com.obric.memorydata.plugin");
        boolean r5 = this.forward;
        double r3 = r9.getPreviousTime();
        if (r5 == false) goto L12;
        if (r6 >= r3) goto L8;
        return -1;
    L8:
        if (r6 <= r9.getCurrentTime()) goto L10;
        return 1;
    L10:
        return 0;
    L12:
        if (r6 <= r3) goto L15;
        return -1;
    L15:
        if (r6 >= r9.getCurrentTime()) goto L17;
        return 1;
    L17:
        return 0;
    }

    public void append(ContinuousOutputModel r13) {
        if (r13.steps.size() != 0) goto L6;
        return;
    L6:
        if (this.steps.size() != 0) goto L9;
        this.initialTime = r13.initialTime;
        this.forward = r13.forward;
    L14:
        Iterator<StepInterpolator> r14 = r13.steps.iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        this.steps.add(((StepInterpolator) ZeusTransformUtils.preCheckCast(r14.next(), StepInterpolator.class, "com.obric.memorydata.plugin")).copy());
        goto L16
    L18:
        int r15 = this.steps.size() - 1;
        this.index = r15;
        this.finalTime = ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(r15), StepInterpolator.class, "com.obric.memorydata.plugin")).getCurrentTime();
        return;
    L9:
        if (getInterpolatedState().length != r13.getInterpolatedState().length) goto L25;
        if ((this.forward ^ r13.forward) == true) goto L23;
        StepInterpolator r0 = (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin");
        double r4 = r0.getCurrentTime();
        double r6 = r4 - r0.getPreviousTime();
        double r8 = r13.getInitialTime() - r4;
        if (FastMath.abs(r8) <= (FastMath.abs(r6) * 0.001d)) goto L14;
        throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, new Object[]{Double.valueOf(FastMath.abs(r8))});
    L23:
        throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
    L25:
        throw new DimensionMismatchException(r13.getInterpolatedState().length, getInterpolatedState().length);
    }

    public double getFinalTime() {
        return this.finalTime;
    }

    public double getInitialTime() {
        return this.initialTime;
    }

    public double[] getInterpolatedDerivatives() {
        return ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).getInterpolatedDerivatives();
    }

    public double[] getInterpolatedSecondaryDerivatives(int r3) {
        return ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).getInterpolatedSecondaryDerivatives(r3);
    }

    public double[] getInterpolatedSecondaryState(int r3) {
        return ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).getInterpolatedSecondaryState(r3);
    }

    public double[] getInterpolatedState() {
        return ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).getInterpolatedState();
    }

    public double getInterpolatedTime() {
        return ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).getInterpolatedTime();
    }

    public void handleStep(StepInterpolator r3, boolean r4) {
        StepInterpolator r5 = (StepInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, StepInterpolator.class, "com.obric.memorydata.plugin");
        if (this.steps.size() != 0) goto L5;
        this.initialTime = r5.getPreviousTime();
        this.forward = r5.isForward();
    L5:
        this.steps.add(r5.copy());
        if (r4 == false) goto L9;
        this.finalTime = r5.getCurrentTime();
        this.index = this.steps.size() - 1;
        return;
    }

    public void init(double r1, double[] r3, double r4) {
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }

    public void setInterpolatedTime(double r29) {
        int r4 = 0;
        StepInterpolator r3 = (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(0), StepInterpolator.class, "com.obric.memorydata.plugin");
        double r9 = 0.5d;
        double r7 = (r3.getPreviousTime() + r3.getCurrentTime()) * 0.5d;
        int r5 = this.steps.size() - 1;
        StepInterpolator r11 = (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(r5), StepInterpolator.class, "com.obric.memorydata.plugin");
        double r12 = (r11.getPreviousTime() + r11.getCurrentTime()) * 0.5d;
        if (locatePoint(r29, r3) > 0) goto L7;
        this.index = 0;
        r3.setInterpolatedTime(r29);
        return;
    L7:
        if (locatePoint(r29, r11) < 0) goto L11;
        this.index = r5;
        r11.setInterpolatedTime(r29);
        return;
    L11:
        if ((r5 - r4) <= 5) goto L31;
        StepInterpolator r6 = (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin");
        int r13 = locatePoint(r29, r6);
        if (r13 >= 0) goto L15;
        r5 = this.index;
        r12 = (r6.getPreviousTime() + r6.getCurrentTime()) * r9;
    L17:
        int r8 = (r4 + r5) / 2;
        StepInterpolator r14 = (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(r8), StepInterpolator.class, "com.obric.memorydata.plugin");
        double r15 = (r14.getPreviousTime() + r14.getCurrentTime()) * r9;
        double r16 = r15 - r7;
        if (FastMath.abs(r16) < 1.0E-6d) goto L23;
        double r18 = r12 - r15;
        if (FastMath.abs(r18) < 1.0E-6d) goto L23;
        double r20 = r12 - r7;
        double r22 = r29 - r12;
        double r17 = r29 - r15;
        double r24 = r29 - r7;
        r8 = (int) FastMath.rint((((((r17 * r24) * r16) * ((double) r5)) - (((r24 * r22) * r20) * ((double) r8))) + (((r22 * r17) * r18) * ((double) r4))) / ((r18 * r16) * r20));
    L23:
        this.index = r8;
        int r10 = FastMath.max(r4 + 1, ((r4 * 9) + r5) / 10);
        int r19 = FastMath.min(r5 - 1, ((r5 * 9) + r4) / 10);
        int r110 = this.index;
        if (r110 >= r10) goto L26;
        this.index = r10;
    L28:
        r9 = 0.5d;
        goto L11
    L26:
        if (r110 <= r19) goto L28;
        this.index = r19;
        goto L28
    L15:
        if (r13 <= 0) goto L29;
        r4 = this.index;
        r7 = (r6.getPreviousTime() + r6.getCurrentTime()) * r9;
        goto L17
    L29:
        r6.setInterpolatedTime(r29);
        return;
    L31:
        this.index = r4;
    L32:
        int r21 = this.index;
        if (r21 > r5) goto L37;
        if (locatePoint(r29, (StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(r21), StepInterpolator.class, "com.obric.memorydata.plugin")) <= 0) goto L37;
        this.index++;
    L37:
        ((StepInterpolator) ZeusTransformUtils.preCheckCast(this.steps.get(this.index), StepInterpolator.class, "com.obric.memorydata.plugin")).setInterpolatedTime(r29);
    }
}
