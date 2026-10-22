package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
final class UnmodifiableSortedMultiset<E> extends Multisets$UnmodifiableMultiset<E> implements v8 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient UnmodifiableSortedMultiset f8877a;

    public UnmodifiableSortedMultiset(v8 r5) {
        super(r5);
    }

    @Override // com.google.common.collect.v8, com.google.common.collect.t8
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset
    public /* bridge */ /* synthetic */ Set createElementSet() {
        return createElementSet();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.y2, com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ z7 delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.v8
    public v8 descendingMultiset() {
        UnmodifiableSortedMultiset r5 = this.f8877a;
        if (r5 != null) goto L6;
        UnmodifiableSortedMultiset r10 = new UnmodifiableSortedMultiset(delegate().descendingMultiset());
        r10.f8877a = this;
        this.f8877a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.v8
    public y7 firstEntry() {
        return delegate().firstEntry();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // com.google.common.collect.v8
    public v8 headMultiset(E r5, BoundType r10) {
        v8 r11 = delegate().headMultiset(r5, r10);
        r11.getClass();
        return new UnmodifiableSortedMultiset(r11);
    }

    @Override // com.google.common.collect.v8
    public y7 lastEntry() {
        return delegate().lastEntry();
    }

    @Override // com.google.common.collect.v8
    public y7 pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.v8
    public y7 pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    @Override // com.google.common.collect.v8
    public v8 subMultiset(E r5, BoundType r10, E r11, BoundType r12) {
        v8 r13 = delegate().subMultiset(r5, r10, r11, r12);
        r13.getClass();
        return new UnmodifiableSortedMultiset(r13);
    }

    @Override // com.google.common.collect.v8
    public v8 tailMultiset(E r5, BoundType r10) {
        v8 r11 = delegate().tailMultiset(r5, r10);
        r11.getClass();
        return new UnmodifiableSortedMultiset(r11);
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset
    public NavigableSet<E> createElementSet() {
        return p7.x0(delegate().elementSet());
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.z7
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }

    @Override // com.google.common.collect.Multisets$UnmodifiableMultiset, com.google.common.collect.y2, com.google.common.collect.t2, com.google.common.collect.z2
    public v8 delegate() {
        return (v8) super.delegate();
    }
}
