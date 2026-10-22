package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
public interface o<T> extends Predicate<T> {
    boolean apply(T r1);

    boolean equals(Object r1);

    @Override // java.util.function.Predicate
    default boolean test(T r1) {
        return apply(r1);
    }
}
