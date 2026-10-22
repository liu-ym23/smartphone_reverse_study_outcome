package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 2;
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private HashMultimap() {
        this(12, 2);
    }

    private HashMultimap(int r1, int r2) {
        super(ar.a(r1));
        this.expectedValuesPerKey = 2;
        if (r2 < 0) goto L5;
        boolean r3 = true;
    L6:
        com.google.common.base.n.a(r3);
        this.expectedValuesPerKey = r2;
        return;
    L5:
        r3 = false;
        goto L6
    }

    private HashMultimap(am<? extends K, ? extends V> r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        super(ar.a(r4.keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(r4);
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap();
    }

    public static <K, V> HashMultimap<K, V> create(int r1, int r2) {
        return new HashMultimap(r1, r2);
    }

    public static <K, V> HashMultimap<K, V> create(am<? extends K, ? extends V> r2) {
        return new HashMultimap((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int r0 = av.a(r3);
        setMap(ar.a(12));
        av.a(this, r3, r0);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        av.a(this, r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsEntry(Object r1, Object r2) {
        return super.containsEntry(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsKey(Object r1) {
        return super.containsKey(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean containsValue(Object r1) {
        return super.containsValue(r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    Set<V> createCollection() {
        return ar.c(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* synthetic */ void forEach(BiConsumer r3) {
        super.forEach((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Set get(Object r1) {
        return super.get(r1);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ an keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean put(Object r1, Object r2) {
        return super.put(r1, r2);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(am r3) {
        return super.putAll((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* synthetic */ boolean putAll(Object r3, Iterable r4) {
        return super.putAll(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean remove(Object r1, Object r2) {
        return super.remove(r1, r2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
        return super.removeAll(r1);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public /* synthetic */ Set replaceValues(Object r3, Iterable r4) {
        return super.replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
