package com.google.common.collect;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
final class ImmutableSortedAsList<E> extends RegularImmutableAsList<E> implements t8 {
    public ImmutableSortedAsList(ImmutableSortedSet<E> r5, ImmutableList<E> r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.t8
    public Comparator<? super E> comparator() {
        return delegateCollection().comparator();
    }

    @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object r5) {
        if (indexOf(r5) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    public /* bridge */ /* synthetic */ ImmutableCollection delegateCollection() {
        return delegateCollection();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object r5) {
        int r10 = delegateCollection().indexOf(r5);
        if (r10 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (get(r10).equals(r5) == false) goto L7;
        return r10;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object r5) {
        return indexOf(r5);
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        int r5 = size();
        ImmutableList<? extends E> r10 = delegateList();
        Objects.requireNonNull(r10);
        return p7.N(r5, 1301, new w1(r10, 5), comparator());
    }

    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<E> subListUnchecked(int r5, int r10) {
        return new RegularImmutableSortedSet(super.subListUnchecked(r5, r10), comparator()).asList();
    }

    @Override // com.google.common.collect.RegularImmutableAsList, com.google.common.collect.ImmutableAsList
    public ImmutableSortedSet<E> delegateCollection() {
        return (ImmutableSortedSet) super.delegateCollection();
    }
}
