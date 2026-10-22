package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
final class UnmodifiableSortedMultiset<E> extends Multisets.UnmodifiableMultiset<E> implements az<E> {
    private static final long serialVersionUID = 0;
    private transient UnmodifiableSortedMultiset<E> descendingMultiset;

    UnmodifiableSortedMultiset(az<E> r3) {
        super((az) ZeusTransformUtils.wrapperContextForParams(r3, az.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.az, com.google.common.collect.ax
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    NavigableSet<E> createElementSet() {
        return Sets.a(delegate().elementSet());
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset
    /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ an delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public az<E> delegate() {
        return (az) ZeusTransformUtils.preCheckCast(super.delegate(), az.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.az
    public az<E> descendingMultiset() {
        UnmodifiableSortedMultiset<E> r0 = this.descendingMultiset;
        if (r0 != null) goto L6;
        UnmodifiableSortedMultiset<E> r1 = new UnmodifiableSortedMultiset(delegate().descendingMultiset());
        r1.descendingMultiset = this;
        this.descendingMultiset = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.an
    public NavigableSet<E> elementSet() {
        return (NavigableSet) ZeusTransformUtils.preCheckCast(super.elementSet(), NavigableSet.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multisets.UnmodifiableMultiset, com.google.common.collect.ab, com.google.common.collect.an
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.az
    public an.a<E> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.az
    public az<E> headMultiset(E r1, BoundType r2) {
        return Multisets.a(delegate().headMultiset(r1, r2));
    }

    @Override // com.google.common.collect.az
    public an.a<E> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.az
    public an.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.az
    public an.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.az
    public az<E> subMultiset(E r1, BoundType r2, E r3, BoundType r4) {
        return Multisets.a(delegate().subMultiset(r1, r2, r3, r4));
    }

    @Override // com.google.common.collect.az
    public az<E> tailMultiset(E r1, BoundType r2) {
        return Multisets.a(delegate().tailMultiset(r1, r2));
    }
}
