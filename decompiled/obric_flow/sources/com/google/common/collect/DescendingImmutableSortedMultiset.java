package com.google.common.collect;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    public final transient ImmutableSortedMultiset f;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> r5) {
        this.f = r5;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public int count(Object r5) {
        return this.f.count(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public y7 firstEntry() {
        return this.f.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public y7 getEntry(int r5) {
        return this.f.entrySet().asList().reverse().get(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 headMultiset(Object r5, BoundType r10) {
        return headMultiset(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public y7 lastEntry() {
        return this.f.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 tailMultiset(Object r5, BoundType r10) {
        return tailMultiset(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public ImmutableSortedMultiset<E> headMultiset(E r5, BoundType r10) {
        return this.f.tailMultiset(r5, r10).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public ImmutableSortedMultiset<E> tailMultiset(E r5, BoundType r10) {
        return this.f.headMultiset(r5, r10).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public ImmutableSortedSet<E> elementSet() {
        return this.f.elementSet().descendingSet();
    }
}
