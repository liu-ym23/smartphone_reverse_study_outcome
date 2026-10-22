package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class ImmutableEntry<K, V> extends d0 implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    public ImmutableEntry(K r5, V r10) {
        this.key = r5;
        this.value = r10;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.d0, java.util.Map.Entry
    public final V setValue(V r5) {
        throw new UnsupportedOperationException();
    }
}
