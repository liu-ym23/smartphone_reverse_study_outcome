package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RealLinearOperator {
    public RealLinearOperator() {
    }

    public abstract int getColumnDimension();

    public abstract int getRowDimension();

    public boolean isTransposable() {
        return false;
    }

    public abstract RealVector operate(RealVector r1);

    public RealVector operateTranspose(RealVector r1) {
        throw new UnsupportedOperationException();
    }
}
