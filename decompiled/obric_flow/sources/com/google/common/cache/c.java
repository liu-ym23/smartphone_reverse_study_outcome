package com.google.common.cache;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public interface c {
    ConcurrentMap asMap();

    void cleanUp();

    Object get(Object r5, Callable r10);

    ImmutableMap getAllPresent(Iterable r5);

    Object getIfPresent(Object r5);

    void invalidate(Object r5);

    void invalidateAll();

    void invalidateAll(Iterable r5);

    void put(Object r5, Object r10);

    void putAll(Map r5);

    long size();

    i stats();
}
