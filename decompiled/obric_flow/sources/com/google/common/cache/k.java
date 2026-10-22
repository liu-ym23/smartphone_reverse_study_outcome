package com.google.common.cache;

import com.google.common.collect.ImmutableMap;

/* JADX INFO: loaded from: classes2.dex */
public interface k extends c, com.google.common.base.q {
    @Override // java.util.function.Function
    Object apply(Object r5);

    Object get(Object r5);

    ImmutableMap getAll(Iterable r5);

    Object getUnchecked(Object r5);

    void refresh(Object r5);
}
