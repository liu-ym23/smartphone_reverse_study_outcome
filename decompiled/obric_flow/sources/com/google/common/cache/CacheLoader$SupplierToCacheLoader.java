package com.google.common.cache;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class CacheLoader$SupplierToCacheLoader<V> extends h implements Serializable {
    private static final long serialVersionUID = 0;
    private final com.google.common.base.e0 computingSupplier;

    public CacheLoader$SupplierToCacheLoader(com.google.common.base.e0 r5) {
        r5.getClass();
        this.computingSupplier = r5;
    }

    @Override // com.google.common.cache.h
    public V load(Object r5) {
        r5.getClass();
        return (V) this.computingSupplier.get();
    }
}
