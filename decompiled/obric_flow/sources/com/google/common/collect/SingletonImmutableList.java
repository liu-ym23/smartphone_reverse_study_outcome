package com.google.common.collect;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    public SingletonImmutableList(E r5) {
        r5.getClass();
        this.element = r5;
    }

    @Override // java.util.List
    public E get(int r5) {
        com.google.common.base.b0.l(r5, 1);
        return this.element;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ List subList(int r5, int r10) {
        return subList(r5, r10);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String r5 = this.element.toString();
        StringBuilder r10 = new StringBuilder(androidx.room.jarjarred.org.antlr.runtime.a.g(2, r5));
        r10.append('[');
        r10.append(r5);
        r10.append(']');
        return r10.toString();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        return new f5(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int r5, int r10) {
        com.google.common.base.b0.p(r5, r10, 1);
        if (r5 == r10) goto L5;
        return this;
    L5:
        return ImmutableList.of();
    }
}
