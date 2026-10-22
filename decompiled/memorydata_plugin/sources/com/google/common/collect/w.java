package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w<K, V> extends y<K, V> implements ConcurrentMap<K, V> {
    public w() {
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Map delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.ac
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K r1, V r2) {
        return delegate().putIfAbsent(r1, r2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r1, Object r2) {
        return delegate().remove(r1, r2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K r1, V r2) {
        return delegate().replace(r1, r2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K r1, V r2, V r3) {
        return delegate().replace(r1, r2, r3);
    }
}
