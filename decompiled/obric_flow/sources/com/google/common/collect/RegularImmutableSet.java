package com.google.common.collect;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSet<E> extends ImmutableSet.CachingAsList<E> {
    static final RegularImmutableSet<Object> EMPTY = null;
    public static final Object[] f = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object[] f8861c;
    public final transient int d;
    public final transient int e;
    final transient Object[] table;

    static {
        Object[] r5 = new Object[0];
        f = r5;
        EMPTY = new RegularImmutableSet(r5, 0, r5, 0);
    }

    public RegularImmutableSet(Object[] r5, int r10, Object[] r11, int r12) {
        this.f8861c = r5;
        this.d = r10;
        this.table = r11;
        this.e = r12;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        Object[] r10 = this.table;
        if (r5 != null) goto L5;
    L16:
        return false;
    L5:
        if (r10.length == 0) goto L16;
        int r11 = p7.o0(r5);
    L8:
        int r12 = r11 & this.e;
        Object r13 = r10[r12];
        if (r13 == null) goto L10;
        if (r13.equals(r5) == true) goto L13;
        r11 = r12 + 1;
        goto L8
    L13:
        return true;
    L10:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        Object[] r11 = this.f8861c;
        System.arraycopy(r11, 0, r5, r10, r11.length);
        return r10 + r11.length;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList
    public ImmutableList<E> createAsList() {
        if (this.table.length != 0) goto L6;
        return ImmutableList.of();
    L6:
        return new RegularImmutableAsList(this, this.f8861c);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.d;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.f8861c;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f8861c.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8861c.length;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f8861c, 1297);
    }

    @Override // com.google.common.collect.ImmutableSet.CachingAsList, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public ga iterator() {
        Object[] r5 = this.f8861c;
        return p7.E(r5.length, 0, r5);
    }
}
