package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public interface b<K, V> {
    ConcurrentMap<K, V> asMap();

    void cleanUp();

    V get(K r1, Callable<? extends V> r2);

    ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> r1);

    V getIfPresent(Object r1);

    void invalidate(Object r1);

    void invalidateAll();

    void invalidateAll(Iterable<? extends Object> r1);

    void put(K r1, V r2);

    void putAll(Map<? extends K, ? extends V> r1);

    long size();

    c stats();
}
