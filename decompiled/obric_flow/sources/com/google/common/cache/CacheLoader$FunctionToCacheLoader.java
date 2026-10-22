package com.google.common.cache;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class CacheLoader$FunctionToCacheLoader<K, V> extends h implements Serializable {
    private static final long serialVersionUID = 0;
    private final com.google.common.base.q computingFunction;

    public CacheLoader$FunctionToCacheLoader(com.google.common.base.q r5) {
        r5.getClass();
        this.computingFunction = r5;
    }

    @Override // com.google.common.cache.h
    public V load(K r5) {
        com.google.common.base.q r10 = this.computingFunction;
        r5.getClass();
        return (V) r10.apply(r5);
    }
}
