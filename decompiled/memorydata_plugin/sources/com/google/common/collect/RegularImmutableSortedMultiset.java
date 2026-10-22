package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = null;
    private static final long[] ZERO_CUMULATIVE_COUNTS = null;
    private final transient long[] cumulativeCounts;
    final transient RegularImmutableSortedSet<E> elementSet;
    private final transient int length;
    private final transient int offset;

    static {
        ZERO_CUMULATIVE_COUNTS = new long[]{0};
        NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> r1, long[] r2, int r3, int r4) {
        this.elementSet = r1;
        this.cumulativeCounts = r2;
        this.offset = r3;
        this.length = r4;
    }

    RegularImmutableSortedMultiset(Comparator<? super E> r3) {
        this.elementSet = ImmutableSortedSet.emptySet((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin"));
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int getCount(int r4) {
        long[] r0 = this.cumulativeCounts;
        int r3 = this.offset;
        return (int) (r0[(r3 + r4) + 1] - r0[r3 + r4]);
    }

    @Override // com.google.common.collect.an
    public int count(Object r2) {
        int r3 = this.elementSet.indexOf(r2);
        if (r3 >= 0) goto L7;
        return 0;
    L7:
        return getCount(r3);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public /* bridge */ /* synthetic */ ImmutableSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.an
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
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
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(0);
    }

    @Override // com.google.common.collect.an
    public void forEachEntry(ObjIntConsumer<? super E> r4) {
        ObjIntConsumer r5 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r4, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        int r0 = 0;
    L4:
        if (r0 >= this.length) goto L6;
        r5.accept(this.elementSet.asList().get(r0), getCount(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // com.google.common.collect.ImmutableMultiset
    an.a<E> getEntry(int r2) {
        return Multisets.a(this.elementSet.asList().get(r2), getCount(r2));
    }

    ImmutableSortedMultiset<E> getSubMultiset(int r4, int r5) {
        com.google.common.base.n.a(r4, r5, this.length);
        if (r4 == r5) goto L5;
        if (r4 != 0) goto L11;
        if (r5 != this.length) goto L11;
        return this;
    L11:
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(r4, r5), this.cumulativeCounts, this.offset + r4, r5 - r4);
    L5:
        return emptyMultiset(comparator());
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public ImmutableSortedMultiset<E> headMultiset(E r4, BoundType r5) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (com.google.common.base.n.a(r5) != BoundType.CLOSED) goto L5;
        boolean r6 = true;
    L7:
        return getSubMultiset(0, r0.headIndex(r4, r6));
    L5:
        r6 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az headMultiset(Object r1, BoundType r2) {
        return headMultiset(r1, r2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        if (this.offset <= 0) goto L5;
        return true;
    L5:
        if (this.length < (this.cumulativeCounts.length - 1)) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.google.common.collect.az
    public an.a<E> lastEntry() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return getEntry(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        long[] r0 = this.cumulativeCounts;
        int r1 = this.offset;
        return Ints.b(r0[this.length + r1] - r0[r1]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public ImmutableSortedMultiset<E> tailMultiset(E r3, BoundType r4) {
        RegularImmutableSortedSet<E> r0 = this.elementSet;
        if (com.google.common.base.n.a(r4) != BoundType.CLOSED) goto L5;
        boolean r5 = true;
    L7:
        return getSubMultiset(r0.tailIndex(r3, r5), this.length);
    L5:
        r5 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.az
    public /* bridge */ /* synthetic */ az tailMultiset(Object r1, BoundType r2) {
        return tailMultiset(r1, r2);
    }
}
