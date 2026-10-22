package org.apache.commons.math3.ode;

import org.apache.commons.math3.util.IntegerSequence;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractIntegrator {
    private IntegerSequence.Incrementor evaluations;
    private transient ExpandableStatefulODE expandable;

    public void computeDerivatives(double r2, double[] r4, double[] r5) {
        this.evaluations.increment();
        this.expandable.computeDerivatives(r2, r4, r5);
    }
}
