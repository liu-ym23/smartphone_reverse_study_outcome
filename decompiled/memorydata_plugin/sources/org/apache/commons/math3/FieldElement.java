package org.apache.commons.math3;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldElement<T> {
    T add(T r1);

    T divide(T r1);

    Field<T> getField();

    T multiply(int r1);

    T multiply(T r1);

    T negate();

    T subtract(T r1);
}
