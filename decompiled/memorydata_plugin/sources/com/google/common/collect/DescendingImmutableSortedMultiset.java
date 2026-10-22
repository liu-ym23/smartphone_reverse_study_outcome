package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> forward;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> r1) {
        this.forward = r1;
    }

    @Override // com.google.common.collect.an
    public int count(Object r1) {
        return this.forward.count(r1);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az descendingMultiset() {
        return descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.az
    public an.a<E> firstEntry() {
        return this.forward.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    an.a<E> getEntry(int r2) {
        return (an.a) ZeusTransformUtils.preCheckCast(this.forward.entrySet().asList().reverse().get(r2), an.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public ImmutableSortedMultiset<E> headMultiset(E r1, BoundType r2) {
        return this.forward.tailMultiset(r1, r2).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.forward.isPartialView();
    }

    @Override // com.google.common.collect.az
    public an.a<E> lastEntry() {
        return this.forward.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public ImmutableSortedMultiset<E> tailMultiset(E r1, BoundType r2) {
        return this.forward.headMultiset(r1, r2).descendingMultiset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }
}
