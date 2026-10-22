package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class aa<K, V> extends ac implements am<K, V> {
    public aa() {
    }

    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    public void clear() {
        delegate().clear();
    }

    @Override // com.google.common.collect.am
    public boolean containsEntry(Object r1, Object r2) {
        return delegate().containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.am
    public boolean containsKey(Object r1) {
        return delegate().containsKey(r1);
    }

    @Override // com.google.common.collect.am
    public boolean containsValue(Object r1) {
        return delegate().containsValue(r1);
    }

    @Override // com.google.common.collect.ac
    public abstract am<K, V> delegate();

    @Override // com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    @Override // com.google.common.collect.am
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    public Collection<V> get(K r1) {
        return delegate().get(r1);
    }

    @Override // com.google.common.collect.am
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.am
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public an<K> keys() {
        return delegate().keys();
    }

    public boolean put(K r1, V r2) {
        return delegate().put(r1, r2);
    }

    public boolean putAll(am<? extends K, ? extends V> r3) {
        am<? extends K, ? extends V> r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        return delegate().putAll(r4);
    }

    public boolean putAll(K r3, Iterable<? extends V> r4) {
        Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        return delegate().putAll(r3, r5);
    }

    public boolean remove(Object r1, Object r2) {
        return delegate().remove(r1, r2);
    }

    public Collection<V> removeAll(Object r1) {
        return delegate().removeAll(r1);
    }

    public Collection<V> replaceValues(K r3, Iterable<? extends V> r4) {
        Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        return delegate().replaceValues(r3, r5);
    }

    @Override // com.google.common.collect.am
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
