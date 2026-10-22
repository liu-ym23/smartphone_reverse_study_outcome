package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u2 extends v2 implements ConcurrentMap {
    public u2() {
    }

    @Override // com.google.common.collect.v2, com.google.common.collect.z2
    public abstract ConcurrentMap delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object r5, Object r10) {
        return delegate().putIfAbsent(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object r5, Object r10) {
        return delegate().remove(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object r5, Object r10) {
        return delegate().replace(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object r5, Object r10, Object r11) {
        return delegate().replace(r5, r10, r11);
    }
}
