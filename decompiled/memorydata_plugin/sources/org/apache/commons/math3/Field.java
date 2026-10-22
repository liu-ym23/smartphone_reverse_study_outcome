package org.apache.commons.math3;

/* JADX INFO: loaded from: classes6.dex */
public interface Field<T> {
    T getOne();

    Class<? extends FieldElement<T>> getRuntimeClass();

    T getZero();
}
