package org.apache.commons.math3.ode.sampling;

import java.io.Externalizable;

/* JADX INFO: loaded from: classes6.dex */
public interface StepInterpolator extends Externalizable {
    StepInterpolator copy();

    double getCurrentTime();

    double[] getInterpolatedDerivatives();

    double[] getInterpolatedSecondaryDerivatives(int r1);

    double[] getInterpolatedSecondaryState(int r1);

    double[] getInterpolatedState();

    double getInterpolatedTime();

    double getPreviousTime();

    boolean isForward();

    void setInterpolatedTime(double r1);
}
