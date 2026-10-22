package org.apache.commons.math3.linear;

/* JADX INFO: loaded from: classes6.dex */
public interface RealMatrix extends AnyMatrix {
    void copySubMatrix(int r1, int r2, int r3, int r4, double[][] r5);

    double[][] getData();

    double getEntry(int r1, int r2);

    RealMatrix multiply(RealMatrix r1);

    RealVector operate(RealVector r1);

    RealMatrix power(int r1);

    void setEntry(int r1, int r2, double r3);

    RealMatrix transpose();

    double walkInOptimizedOrder(RealMatrixChangingVisitor r1);
}
