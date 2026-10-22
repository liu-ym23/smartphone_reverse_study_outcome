package org.apache.commons.math3.linear;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public interface FieldVector<T extends FieldElement<T>> {
    T dotProduct(FieldVector<T> r1);

    int getDimension();

    T getEntry(int r1);

    Field<T> getField();

    FieldVector<T> mapAddToSelf(T r1);

    FieldVector<T> mapDivideToSelf(T r1);

    FieldVector<T> mapInvToSelf();

    FieldVector<T> mapMultiply(T r1);

    FieldVector<T> mapMultiplyToSelf(T r1);

    FieldVector<T> mapSubtractToSelf(T r1);

    void setEntry(int r1, T r2);

    T[] toArray();
}
