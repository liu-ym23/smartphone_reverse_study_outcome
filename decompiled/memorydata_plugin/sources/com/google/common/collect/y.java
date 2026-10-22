package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y<K, V> extends ac implements Map<K, V> {
    public y() {
    }

    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object r1) {
        return delegate().containsKey(r1);
    }

    public boolean containsValue(Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ac
    public abstract Map<K, V> delegate();

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Map
    public V get(Object r1) {
        return delegate().get(r1);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public V put(K r1, V r2) {
        return delegate().put(r1, r2);
    }

    public void putAll(Map<? extends K, ? extends V> r3) {
        Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        delegate().putAll(r4);
    }

    public V remove(Object r1) {
        return delegate().remove(r1);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterators.h(entrySet().iterator());
    }

    public boolean standardContainsKey(Object r1) {
        return Maps.d(this, r1);
    }

    public boolean standardContainsValue(Object r1) {
        return Maps.e(this, r1);
    }

    public boolean standardEquals(Object r1) {
        return Maps.f(this, r1);
    }

    public int standardHashCode() {
        return Sets.a(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<? extends K, ? extends V> r3) {
        Maps.a(this, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
    }

    public V standardRemove(Object r4) {
        Iterator<Map.Entry<K, V>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (com.google.common.base.k.a(r0.getKey(), r4) == false) goto L4;
        V r5 = (V) r0.getValue();
        r3.remove();
        return r5;
    L9:
        return null;
    }

    public String standardToString() {
        return Maps.a(this);
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
