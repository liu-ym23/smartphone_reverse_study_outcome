package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap();
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int r10 = r5.readInt();
        setMap(new HashMap());
        p7.e0(this, r5, r10);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        p7.z0(this, r5);
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
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

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean equals(Object r5) {
        return super.equals(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ void forEach(BiConsumer r5) {
        super.forEach(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ List get(Object r5) {
        return super.get(r5);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ z7 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
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

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ List removeAll(Object r5) {
        return super.removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ List replaceValues(Object r5, Iterable r10) {
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

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> r5 = backingMap().values().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((ArrayList) r5.next()).trimToSize();
        goto L4
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public ArrayListMultimap(int r5, int r10) {
        int r11 = h8.f9015a;
        super(p7.X(r5));
        p7.q(r10, "expectedValuesPerKey");
        this.expectedValuesPerKey = r10;
    }

    public static <K, V> ArrayListMultimap<K, V> create(int r5, int r10) {
        return new ArrayListMultimap(r5, r10);
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public List<V> createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.g0, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ boolean putAll(Object r5, Iterable r10) {
        return super.putAll(r5, r10);
    }

    public static <K, V> ArrayListMultimap<K, V> create(q7 r5) {
        int r10 = r5.keySet().size();
        if ((r5 instanceof ArrayListMultimap) == false) goto L5;
        int r11 = ((ArrayListMultimap) r5).expectedValuesPerKey;
    L6:
        ArrayListMultimap<K, V> r12 = new ArrayListMultimap(r10, r11);
        r12.putAll(r5);
        return r12;
    L5:
        r11 = 3;
        goto L6
    }
}
