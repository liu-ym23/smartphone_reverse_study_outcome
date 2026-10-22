package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayListMultimap<K, V> extends ArrayListMultimapGwtSerializationDependencies<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    private ArrayListMultimap(int r1, int r2) {
        super(ar.a(r1));
        o.a(r2, "expectedValuesPerKey");
        this.expectedValuesPerKey = r2;
    }

    private ArrayListMultimap(am<? extends K, ? extends V> r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.memorydata.plugin");
        int r1 = r6.keySet().size();
        if (ZeusTransformUtils.instanceOf(r6, ArrayListMultimap.class) == false) goto L5;
        int r0 = ((ArrayListMultimap) ZeusTransformUtils.preCheckCast(r6, ArrayListMultimap.class, "com.obric.memorydata.plugin")).expectedValuesPerKey;
    L6:
        this(r1, r0);
        putAll(r6);
        return;
    L5:
        r0 = 3;
        goto L6
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap();
    }

    public static <K, V> ArrayListMultimap<K, V> create(int r1, int r2) {
        return new ArrayListMultimap(r1, r2);
    }

    public static <K, V> ArrayListMultimap<K, V> create(am<? extends K, ? extends V> r2) {
        return new ArrayListMultimap((am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin"));
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        this.expectedValuesPerKey = 3;
        int r0 = av.a(r3);
        setMap(Maps.c());
        av.a(this, r3, r0);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        av.a(this, r1);
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.c, com.google.common.collect.am
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

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* bridge */ /* synthetic */ Collection createCollection() {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
    List<V> createCollection() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ boolean equals(Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am
    public /* synthetic */ void forEach(BiConsumer r3) {
        super.forEach((BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ List get(Object r1) {
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
    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
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

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ List removeAll(Object r1) {
        return super.removeAll(r1);
    }

    @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    public /* synthetic */ List replaceValues(Object r3, Iterable r4) {
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

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> r3 = backingMap().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ArrayList) ZeusTransformUtils.preCheckCast((Collection) ZeusTransformUtils.preCheckCast(r3.next(), Collection.class, "com.obric.memorydata.plugin"), ArrayList.class, "com.obric.memorydata.plugin")).trimToSize();
        goto L4
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.c, com.google.common.collect.am
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
