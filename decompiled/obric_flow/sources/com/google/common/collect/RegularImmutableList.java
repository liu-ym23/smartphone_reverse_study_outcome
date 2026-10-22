package com.google.common.collect;

import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = null;
    final transient Object[] array;

    static {
        EMPTY = new RegularImmutableList(new Object[0]);
    }

    public RegularImmutableList(Object[] r5) {
        this.array = r5;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        Object[] r11 = this.array;
        System.arraycopy(r11, 0, r5, r10, r11.length);
        return r10 + this.array.length;
    }

    @Override // java.util.List
    public E get(int r5) {
        return (E) this.array[r5];
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.array.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r5) {
        return listIterator(r5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.array.length;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.array, 1296);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ha listIterator(int r5) {
        Object[] r10 = this.array;
        return p7.E(r10.length, r5, r10);
    }
}
