package com.google.common.collect;

import java.util.ListIterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(ImmutableCollection<E> r5, ImmutableList<? extends E> r10) {
        this.delegate = r5;
        this.delegateList = r10;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] r5, int r10) {
        return this.delegateList.copyIntoArray(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // com.google.common.collect.ImmutableList, java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        this.delegateList.forEach(r5);
    }

    @Override // java.util.List
    public E get(int r5) {
        return this.delegateList.get(r5);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int r5) {
        return listIterator(r5);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ha listIterator(int r5) {
        return this.delegateList.listIterator(r5);
    }

    public RegularImmutableAsList(ImmutableCollection<E> r5, Object[] r10) {
        this(r5, ImmutableList.asImmutableList(r10));
    }
}
