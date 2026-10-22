package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathUnsupportedOperationException;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultIterativeLinearSolverEvent extends IterativeLinearSolverEvent {
    private static final long serialVersionUID = 20120129;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RealVector f17879b;
    private final RealVector r;
    private final double rnorm;
    private final RealVector x;

    public DefaultIterativeLinearSolverEvent(Object r1, int r2, RealVector r3, RealVector r4, double r5) {
        super(r1, r2);
        this.x = r3;
        this.f17879b = r4;
        this.r = null;
        this.rnorm = r5;
    }

    public DefaultIterativeLinearSolverEvent(Object r1, int r2, RealVector r3, RealVector r4, RealVector r5, double r6) {
        super(r1, r2);
        this.x = r3;
        this.f17879b = r4;
        this.r = r5;
        this.rnorm = r6;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public double getNormOfResidual() {
        return this.rnorm;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getResidual() {
        RealVector r0 = this.r;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new MathUnsupportedOperationException();
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getRightHandSideVector() {
        return this.f17879b;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getSolution() {
        return this.x;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public boolean providesResidual() {
        if (this.r == null) goto L5;
        return true;
    L5:
        return false;
    }
}
