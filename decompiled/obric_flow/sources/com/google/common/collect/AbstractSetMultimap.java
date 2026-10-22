package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements s8 {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> r5) {
        super(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public Map<K, Collection<V>> asMap() {
        return (Map<K, Collection<V>>) super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract Set<V> createCollection();

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createUnmodifiableEmptyCollection() {
        return createUnmodifiableEmptyCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return entries();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public boolean equals(Object r5) {
        return super.equals(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public boolean put(K r5, V r10) {
        return super.put(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r5) {
        return Collections.unmodifiableSet((Set) r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K r5, Collection<V> r10) {
        return new y(this, r5, (Set) r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<V> get(K r5) {
        return (Set) super.get(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<V> removeAll(Object r5) {
        return (Set) super.removeAll(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public Set<V> replaceValues(K r5, Iterable<? extends V> r10) {
        return (Set) super.replaceValues(r5, r10);
    }
}
