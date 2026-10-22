package org.apache.commons.math3.linear;

import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldMatrix<T extends FieldElement<T>> extends AnyMatrix {
    T getEntry(int r1, int r2);

    FieldMatrix<T> multiply(FieldMatrix<T> r1);

    FieldMatrix<T> power(int r1);

    void setEntry(int r1, int r2, T r3);

    T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r1);
}
