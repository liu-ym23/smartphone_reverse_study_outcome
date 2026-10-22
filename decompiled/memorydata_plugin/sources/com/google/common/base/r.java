package com.google.common.base;

import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
public interface r<T> extends Supplier<T> {
    @Override // java.util.function.Supplier
    T get();
}
