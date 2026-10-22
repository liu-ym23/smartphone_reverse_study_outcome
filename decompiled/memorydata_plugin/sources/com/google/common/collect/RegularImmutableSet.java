package com.google.common.collect;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSet<E> extends ImmutableSet.CachingAsList<E> {
    static final RegularImmutableSet<Object> EMPTY = null;
    private static final Object[] EMPTY_ARRAY = null;
    private final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    final transient Object[] table;

    static {
        Object[] r1 = new Object[0];
        EMPTY_ARRAY = r1;
        EMPTY = new RegularImmutableSet(r1, 0, r1, 0);
    }

    RegularImmutableSet(Object[] r1, int r2, Object[] r3, int r4) {
        this.elements = r1;
        this.hashCode = r2;
        this.table = r3;
        this.mask = r4;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        Object[] r0 = this.table;
        if (r5 != null) goto L5;
    L16:
        return false;
    L5:
        if (r0.length == 0) goto L16;
        int r2 = ai.a(r5);
    L8:
        int r3 = r2 & this.mask;
        Object r4 = r0[r3];
        if (r4 == null) goto L10;
        if (r4.equals(r5) == true) goto L13;
        r2 = r3 + 1;
        goto L8
    L13:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        Object[] r0 = this.elements;
        System.arraycopy(r0, 0, r4, r5, r0.length);
        return r5 + this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    ImmutableList<E> createAsList() {
        if (this.table.length != 0) goto L6;
        return ImmutableList.of();
    L6:
        return new RegularImmutableAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] internalArray() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public bj<E> iterator() {
        return Iterators.a(this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.elements, 1297);
    }
}
