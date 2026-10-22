package com.google.common.base;

import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
public interface g<F, T> extends Function<F, T> {
    @Override // java.util.function.Function
    T apply(F r1);

    boolean equals(Object r1);
}
