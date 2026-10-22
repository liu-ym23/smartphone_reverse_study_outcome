package com.google.common.collect;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet.CachingAsList<E> {
    public IndexedImmutableSet() {
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        return asList().copyIntoArray(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public ImmutableList<E> createAsList() {
        return new AnonymousClass1(this);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        r5.getClass();
        int r10 = size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5.accept(get(r11));
        r11 = r11 + 1;
        goto L3
    }

    public abstract E get(int r5);

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return p7.N(size(), 1297, new w1(this, 3), null);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return asList().iterator();
    }
}
