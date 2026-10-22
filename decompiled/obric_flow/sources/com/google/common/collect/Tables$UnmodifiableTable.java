package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Tables$UnmodifiableTable<R, C, V> extends e3 implements Serializable {
    private static final long serialVersionUID = 0;
    final l9 delegate;

    public Tables$UnmodifiableTable(l9 r5) {
        r5.getClass();
        this.delegate = r5;
    }

    @Override // com.google.common.collect.l9
    public Set<k9> cellSet() {
        return Collections.unmodifiableSet(delegate().cellSet());
    }

    @Override // com.google.common.collect.l9
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public Map<R, V> column(C r5) {
        return Collections.unmodifiableMap(delegate().column(r5));
    }

    @Override // com.google.common.collect.l9
    public Set<C> columnKeySet() {
        return Collections.unmodifiableSet(delegate().columnKeySet());
    }

    @Override // com.google.common.collect.l9
    public Map<C, Map<R, V>> columnMap() {
        j8 r5 = p7.f9120a;
        return Collections.unmodifiableMap(new k7(delegate().columnMap(), new f7(r5)));
    }

    @Override // com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.l9
    public V put(R r5, C r10, V r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public void putAll(l9 r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public V remove(Object r5, Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.l9
    public Map<C, V> row(R r5) {
        return Collections.unmodifiableMap(delegate().row(r5));
    }

    public Set<R> rowKeySet() {
        return Collections.unmodifiableSet(delegate().rowKeySet());
    }

    public Map<R, Map<C, V>> rowMap() {
        j8 r5 = p7.f9120a;
        return Collections.unmodifiableMap(new k7(delegate().rowMap(), new f7(r5)));
    }

    @Override // com.google.common.collect.l9
    public Collection<V> values() {
        return Collections.unmodifiableCollection(delegate().values());
    }

    @Override // com.google.common.collect.e3, com.google.common.collect.z2
    public l9 delegate() {
        return this.delegate;
    }
}
