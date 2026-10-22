package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$MapMultimap<K, V> extends g0 implements s8, Serializable {
    private static final long serialVersionUID = 7845222491160860175L;
    final Map<K, V> map;

    public Multimaps$MapMultimap(Map<K, V> r5) {
        r5.getClass();
        this.map = r5;
    }

    @Override // com.google.common.collect.q7
    public void clear() {
        this.map.clear();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean containsEntry(Object r5, Object r10) {
        return this.map.entrySet().contains(new ImmutableEntry(r5, r10));
    }

    @Override // com.google.common.collect.q7
    public boolean containsKey(Object r5) {
        return this.map.containsKey(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean containsValue(Object r5) {
        return this.map.containsValue(r5);
    }

    @Override // com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return new f9(this);
    }

    public Collection<Map.Entry<K, V>> createEntries() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.g0
    public Set<K> createKeySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.g0
    public z7 createKeys() {
        return new v7(this);
    }

    @Override // com.google.common.collect.g0
    public Collection<V> createValues() {
        return this.map.values();
    }

    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.g0
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return this.map.entrySet().iterator();
    }

    @Override // com.google.common.collect.q7
    public void forEach(BiConsumer r5) {
        r5.getClass();
        entries().forEach(new l5(r5, 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override // com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean putAll(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean remove(Object r5, Object r10) {
        return this.map.entrySet().remove(new ImmutableEntry(r5, r10));
    }

    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.q7
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.q7
    public Set<Map.Entry<K, V>> entries() {
        return this.map.entrySet();
    }

    @Override // com.google.common.collect.q7
    public Set<V> get(K r5) {
        return new x7(this, r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean putAll(q7 r5) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q7
    public Set<V> removeAll(Object r5) {
        HashSet r10 = new HashSet(2);
        if (this.map.containsKey(r5) == true) goto L5;
        return r10;
    L5:
        r10.add(this.map.remove(r5));
        return r10;
    }

    @Override // com.google.common.collect.q7
    public Set<V> replaceValues(K r5, Iterable<? extends V> r10) {
        throw new UnsupportedOperationException();
    }
}
