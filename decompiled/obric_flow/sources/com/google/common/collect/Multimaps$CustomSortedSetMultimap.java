package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class Multimaps$CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;
    transient com.google.common.base.e0 factory;
    transient Comparator<? super V> valueComparator;

    public Multimaps$CustomSortedSetMultimap(Map<K, Collection<V>> r5, com.google.common.base.e0 r10) {
        super(r5);
        r10.getClass();
        this.factory = r10;
        this.valueComparator = ((SortedSet) r10.get()).comparator();
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        com.google.common.base.e0 r10 = (com.google.common.base.e0) r5.readObject();
        this.factory = r10;
        this.valueComparator = ((SortedSet) r10.get()).comparator();
        setMap((Map) r5.readObject());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.factory);
        r5.writeObject(backingMap());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.x8
    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Set createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createCollection() {
        return (SortedSet) this.factory.get();
    }
}
