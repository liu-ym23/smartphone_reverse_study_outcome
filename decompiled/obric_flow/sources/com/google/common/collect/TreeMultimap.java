package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public class TreeMultimap<K, V> extends AbstractSortedKeySortedSetMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Comparator f8871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient Comparator f8872i;

    public TreeMultimap(Comparator<? super K> r5, Comparator<? super V> r10) {
        super(new TreeMap(r5));
        this.f8871h = r5;
        this.f8872i = r10;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap(g8.natural(), g8.natural());
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        Comparator r10 = (Comparator) r5.readObject();
        r10.getClass();
        this.f8871h = r10;
        Comparator r11 = (Comparator) r5.readObject();
        r11.getClass();
        this.f8872i = r11;
        setMap(new TreeMap(this.f8871h));
        p7.e0(this, r5, r5.readInt());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(keyComparator());
        r5.writeObject(valueComparator());
        p7.z0(this, r5);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Map asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r5, Object r10) {
        return super.containsEntry(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsKey(Object r5) {
        return super.containsKey(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean containsValue(Object r5) {
        return super.containsValue(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0
    public Map<K, Collection<V>> createAsMap() {
        return createMaybeNavigableAsMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ void forEach(BiConsumer r5) {
        super.forEach(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.f8871h;
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ z7 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean put(Object r5, Object r10) {
        return super.put(r5, r10);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(q7 r5) {
        return super.putAll(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean remove(Object r5, Object r10) {
        return super.remove(r5, r10);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ SortedSet removeAll(Object r5) {
        return super.removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ SortedSet replaceValues(Object r5, Iterable r10) {
        return super.replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.g0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.x8
    public Comparator<? super V> valueComparator() {
        return this.f8872i;
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> r5, Comparator<? super V> r10) {
        r5.getClass();
        r10.getClass();
        return new TreeMultimap(r5, r10);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ SortedMap asMap() {
        return asMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Set createCollection() {
        return createCollection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ SortedSet keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(Object r5, Iterable r10) {
        return super.putAll(r5, r10);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createCollection() {
        return new TreeSet(this.f8872i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ SortedSet get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.AbstractSortedKeySortedSetMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K r5) {
        if (r5 != 0) goto L5;
        keyComparator().compare(r5, r5);
    L5:
        return super.createCollection(r5);
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public NavigableSet<V> get(K r5) {
        return (NavigableSet) super.get(r5);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(q7 r5) {
        TreeMultimap<K, V> r10 = new TreeMultimap(g8.natural(), g8.natural());
        r10.putAll(r5);
        return r10;
    }
}
