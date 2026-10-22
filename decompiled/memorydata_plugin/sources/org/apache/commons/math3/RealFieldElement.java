package org.apache.commons.math3;

/* JADX INFO: loaded from: classes6.dex */
public interface RealFieldElement<T> extends FieldElement<T> {
    T abs();

    T acos();

    T add(double r1);

    T asin();

    T atan2(T r1);

    T cos();

    double getReal();

    T linearCombination(double r1, T r3, double r4, T r6);

    T linearCombination(double r1, T r3, double r4, T r6, double r7, T r9);

    T linearCombination(double r1, T r3, double r4, T r6, double r7, T r9, double r10, T r12);

    T linearCombination(T r1, T r2, T r3, T r4);

    T linearCombination(T r1, T r2, T r3, T r4, T r5, T r6);

    T linearCombination(T r1, T r2, T r3, T r4, T r5, T r6, T r7, T r8);

    T multiply(double r1);

    T reciprocal();

    T sin();

    T sqrt();

    T subtract(double r1);
}
