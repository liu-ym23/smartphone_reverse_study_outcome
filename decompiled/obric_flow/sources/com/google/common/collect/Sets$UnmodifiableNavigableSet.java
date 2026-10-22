package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
final class Sets$UnmodifiableNavigableSet<E> extends d3 implements NavigableSet<E>, Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Sets$UnmodifiableNavigableSet f8865a;
    private final NavigableSet<E> delegate;
    private final SortedSet<E> unmodifiableDelegate;

    public Sets$UnmodifiableNavigableSet(NavigableSet<E> r5) {
        r5.getClass();
        this.delegate = r5;
        this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r5);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r5) {
        return this.delegate.ceiling(r5);
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return p7.w0(this.delegate.descendingIterator());
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        Sets$UnmodifiableNavigableSet r5 = this.f8865a;
        if (r5 != null) goto L6;
        Sets$UnmodifiableNavigableSet r10 = new Sets$UnmodifiableNavigableSet(this.delegate.descendingSet());
        this.f8865a = r10;
        r10.f8865a = this;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.NavigableSet
    public E floor(E r5) {
        return this.delegate.floor(r5);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        this.delegate.forEach(r5);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r5, boolean r10) {
        return p7.x0(this.delegate.headSet(r5, r10));
    }

    @Override // java.util.NavigableSet
    public E higher(E r5) {
        return this.delegate.higher(r5);
    }

    @Override // java.util.NavigableSet
    public E lower(E r5) {
        return this.delegate.lower(r5);
    }

    @Override // java.util.Collection
    public Stream<E> parallelStream() {
        return this.delegate.parallelStream();
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r5) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public Stream<E> stream() {
        return this.delegate.stream();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E r5, boolean r10, E r11, boolean r12) {
        return p7.x0(this.delegate.subSet(r5, r10, r11, r12));
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r5, boolean r10) {
        return p7.x0(this.delegate.tailSet(r5, r10));
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.b3, com.google.common.collect.t2, com.google.common.collect.z2
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.d3, com.google.common.collect.b3, com.google.common.collect.z2
    public SortedSet<E> delegate() {
        return this.unmodifiableDelegate;
    }
}
