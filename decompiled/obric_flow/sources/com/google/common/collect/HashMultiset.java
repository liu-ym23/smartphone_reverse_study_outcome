package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class HashMultiset<E> extends AbstractMapBasedMultiset<E> {
    private static final long serialVersionUID = 0;

    private HashMultiset() {
        super(new HashMap());
    }

    public static <E> HashMultiset<E> create() {
        return new HashMultiset();
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        int r10 = r5.readInt();
        setBackingMap(new HashMap());
        p7.f0(this, r5, r10);
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        p7.A0(this, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int add(Object r5, int r10) {
        return super.add(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object r5) {
        return super.contains(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int count(Object r5) {
        return super.count(r5);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int remove(Object r5, int r10) {
        return super.remove(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultiset, com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int setCount(Object r5, int r10) {
        return super.setCount(r5, r10);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultiset, java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    public static <E> HashMultiset<E> create(int r5) {
        return new HashMultiset(p7.X(r5));
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ boolean setCount(Object r5, int r10, int r11) {
        return super.setCount(r5, r10, r11);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> r5) {
        if ((r5 instanceof z7) == false) goto L5;
        int r10 = ((z7) r5).elementSet().size();
    L6:
        HashMultiset<E> r11 = create(r10);
        p7.i(r11, r5);
        return r11;
    L5:
        r10 = 11;
        goto L6
    }
}
