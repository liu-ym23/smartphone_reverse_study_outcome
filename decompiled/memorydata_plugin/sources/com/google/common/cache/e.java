package com.google.common.cache;

import com.google.common.collect.ImmutableMap;

/* JADX INFO: loaded from: classes2.dex */
public interface e<K, V> extends com.google.common.base.g<K, V>, b<K, V> {
    @Override // com.google.common.base.g, java.util.function.Function
    @Deprecated
    V apply(K r1);

    V get(K r1);

    ImmutableMap<K, V> getAll(Iterable<? extends K> r1);

    V getUnchecked(K r1);

    void refresh(K r1);
}
