package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public interface z extends Predicate {
    boolean apply(Object r5);

    boolean equals(Object r5);

    @Override // java.util.function.Predicate
    default boolean test(Object r5) {
        return apply(r5);
    }
}
