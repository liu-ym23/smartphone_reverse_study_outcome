package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    private static final long serialVersionUID = 0;

    private HashMultiset() {
        super(new HashMap());
    }

    private HashMultiset(int r1) {
        super(Maps.a(r1));
    }

    public static <E> HashMultiset<E> create() {
        return new HashMultiset();
    }

    public static <E> HashMultiset<E> create(int r1) {
        return new HashMultiset(r1);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        HashMultiset<E> r0 = create(Multisets.a(r3));
        aj.a(r0, r3);
        return r0;
    }

    private void readObject(ObjectInputStream r3) {
        r3.defaultReadObject();
        int r0 = av.a(r3);
        setBackingMap(Maps.c());
        av.a(this, r3, r0);
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        av.a(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ int add(Object r1, int r2) {
        return super.add(r1, r2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean contains(Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ int count(Object r1) {
        return super.count(r1);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.an
    public /* synthetic */ void forEachEntry(ObjIntConsumer r3) {
        super.forEachEntry((ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r3, ObjIntConsumer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ int remove(Object r1, int r2) {
        return super.remove(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ int setCount(Object r1, int r2) {
        return super.setCount(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean setCount(Object r1, int r2, int r3) {
        return super.setCount(r1, r2, r3);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }
}
