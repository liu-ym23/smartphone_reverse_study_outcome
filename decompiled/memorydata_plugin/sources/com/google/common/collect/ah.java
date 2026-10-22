package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah<R, C, V> extends ac implements be<R, C, V> {
    public ah() {
    }

    public Set<be.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(C r1) {
        return delegate().column(r1);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // com.google.common.collect.be
    public boolean contains(Object r1, Object r2) {
        return delegate().contains(r1, r2);
    }

    @Override // com.google.common.collect.be
    public boolean containsColumn(Object r1) {
        return delegate().containsColumn(r1);
    }

    @Override // com.google.common.collect.be
    public boolean containsRow(Object r1) {
        return delegate().containsRow(r1);
    }

    @Override // com.google.common.collect.be
    public boolean containsValue(Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // com.google.common.collect.ac
    public abstract be<R, C, V> delegate();

    @Override // com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.be
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // com.google.common.collect.be
    public V get(Object r1, Object r2) {
        return delegate().get(r1, r2);
    }

    @Override // com.google.common.collect.be
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.be
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public V put(R r1, C r2, V r3) {
        return delegate().put(r1, r2, r3);
    }

    public void putAll(be<? extends R, ? extends C, ? extends V> r3) {
        be<? extends R, ? extends C, ? extends V> r4 = (be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin");
        delegate().putAll(r4);
    }

    public V remove(Object r1, Object r2) {
        return delegate().remove(r1, r2);
    }

    public Map<C, V> row(R r1) {
        return delegate().row(r1);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // com.google.common.collect.be
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
