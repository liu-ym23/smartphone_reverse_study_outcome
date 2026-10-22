package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long[] f8862i = null;
    final transient RegularImmutableSortedSet<E> elementSet;
    public final transient long[] f;
    public final transient int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int f8863h;

    static {
        f8862i = new long[]{0};
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(g8.natural());
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> r5) {
        this.elementSet = ImmutableSortedSet.emptySet(r5);
        this.f = f8862i;
        this.g = 0;
        this.f8863h = 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public int count(Object r5) {
        int r10 = this.elementSet.indexOf(r5);
        if (r10 >= 0) goto L7;
        return 0;
    L7:
        return d(r10);
    }

    public final int d(int r5) {
        int r10 = this.g;
        long[] r11 = this.f;
        return (int) (r11[(r10 + r5) + 1] - r11[r10 + r5]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public y7 firstEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public void forEachEntry(ObjIntConsumer<? super E> r5) {
        com.google.common.base.b0.m(r5);
        int r10 = 0;
    L4:
        if (r10 >= this.f8863h) goto L6;
        r5.accept(this.elementSet.asList().get(r10), d(r10));
        r10 = r10 + 1;
        goto L4
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public y7 getEntry(int r5) {
        E r10 = this.elementSet.asList().get(r5);
        return p7.K(d(r5), r10);
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int r5, int r10) {
        int r11 = this.f8863h;
        com.google.common.base.b0.p(r5, r10, r11);
        if (r5 == r10) goto L5;
        if (r5 != 0) goto L9;
        if (r10 != r11) goto L9;
        return this;
    L9:
        long[] r12 = this.f;
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(r5, r10), r12, this.g + r5, r10 - r5);
    L5:
        return ImmutableSortedMultiset.emptyMultiset(comparator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 headMultiset(Object r5, BoundType r10) {
        return headMultiset(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        if (this.g > 0) goto L9;
        int r5 = this.f.length - 1;
        if (this.f8863h < r5) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public y7 lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(this.f8863h - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int r5 = this.f8863h;
        int r10 = this.g;
        long[] r11 = this.f;
        return dn.a.U(r11[r5 + r10] - r11[r10]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public /* bridge */ /* synthetic */ v8 tailMultiset(Object r5, BoundType r10) {
        return tailMultiset(r5, r10);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public ImmutableSortedMultiset<E> headMultiset(E r5, BoundType r10) {
        RegularImmutableSortedSet<E> r11 = this.elementSet;
        r10.getClass();
        if (r10 != BoundType.CLOSED) goto L5;
        boolean r12 = true;
    L7:
        return getSubMultiset(0, r11.headIndex(r5, r12));
    L5:
        r12 = false;
        goto L7
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.v8
    public ImmutableSortedMultiset<E> tailMultiset(E r5, BoundType r10) {
        RegularImmutableSortedSet<E> r11 = this.elementSet;
        r10.getClass();
        if (r10 != BoundType.CLOSED) goto L5;
        boolean r12 = true;
    L7:
        return getSubMultiset(r11.tailIndex(r5, r12), this.f8863h);
    L5:
        r12 = false;
        goto L7
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
        return this.elementSet;
    }

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> r5, long[] r10, int r11, int r12) {
        this.elementSet = r5;
        this.f = r10;
        this.g = r11;
        this.f8863h = r12;
    }
}
