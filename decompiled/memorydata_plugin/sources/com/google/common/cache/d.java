package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<K, V> extends ac implements b<K, V> {
    public d() {
    }

    @Override // com.google.common.cache.b
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.b
    public void cleanUp() {
        delegate().cleanUp();
    }

    @Override // com.google.common.collect.ac
    public abstract b<K, V> delegate();

    @Override // com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.cache.b
    public V get(K r3, Callable<? extends V> r4) {
        Callable<? extends V> r5 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
        return delegate().get(r3, r5);
    }

    @Override // com.google.common.cache.b
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> r3) {
        Iterable<? extends Object> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        return delegate().getAllPresent(r4);
    }

    @Override // com.google.common.cache.b
    public V getIfPresent(Object r1) {
        return delegate().getIfPresent(r1);
    }

    @Override // com.google.common.cache.b
    public void invalidate(Object r1) {
        delegate().invalidate(r1);
    }

    @Override // com.google.common.cache.b
    public void invalidateAll() {
        delegate().invalidateAll();
    }

    @Override // com.google.common.cache.b
    public void invalidateAll(Iterable<? extends Object> r3) {
        Iterable<? extends Object> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        delegate().invalidateAll(r4);
    }

    @Override // com.google.common.cache.b
    public void put(K r1, V r2) {
        delegate().put(r1, r2);
    }

    @Override // com.google.common.cache.b
    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        delegate().putAll(r4);
    }

    @Override // com.google.common.cache.b
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.b
    public c stats() {
        return delegate().stats();
    }
}
