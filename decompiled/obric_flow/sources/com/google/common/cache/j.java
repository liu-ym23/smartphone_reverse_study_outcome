package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.z2;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends z2 implements c {
    public j() {
    }

    @Override // com.google.common.cache.c
    public ConcurrentMap<Object, Object> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.z2
    public abstract c delegate();

    @Override // com.google.common.cache.c
    public Object get(Object r5, Callable<Object> r10) throws ExecutionException {
        return delegate().get(r5, r10);
    }

    @Override // com.google.common.cache.c
    public ImmutableMap<Object, Object> getAllPresent(Iterable<? extends Object> r5) {
        return delegate().getAllPresent(r5);
    }

    @Override // com.google.common.cache.c
    public Object getIfPresent(Object r5) {
        return delegate().getIfPresent(r5);
    }

    @Override // com.google.common.cache.c
    public void invalidate(Object r5) {
        delegate().invalidate(r5);
    }

    @Override // com.google.common.cache.c
    public void invalidateAll(Iterable<? extends Object> r5) {
        delegate().invalidateAll(r5);
    }

    @Override // com.google.common.cache.c
    public void put(Object r5, Object r10) {
        delegate().put(r5, r10);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<Object, Object> r5) {
        delegate().putAll(r5);
    }

    @Override // com.google.common.cache.c
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.c
    public i stats() {
        return delegate().stats();
    }

    @Override // com.google.common.cache.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
