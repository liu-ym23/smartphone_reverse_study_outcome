package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedNavigableSet<E> extends Synchronized$SynchronizedSortedSet<E> implements NavigableSet<E> {
    private static final long serialVersionUID = 0;
    transient NavigableSet<E> descendingSet;

    public Synchronized$SynchronizedNavigableSet(NavigableSet<E> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().ceiling(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        NavigableSet<E> r10 = this.descendingSet;     // Catch: Throwable -> L9
        if (r10 != null) goto L11;
        Synchronized$SynchronizedNavigableSet r11 = new Synchronized$SynchronizedNavigableSet(delegate().descendingSet(), this.mutex);     // Catch: Throwable -> L9
        this.descendingSet = r11;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r11;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return r10;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public E floor(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().floor(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(E r5, boolean r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedNavigableSet r12 = new Synchronized$SynchronizedNavigableSet(delegate().headSet(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public E higher(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().higher(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public E lower(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().lower(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public E pollFirst() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().pollFirst();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public E pollLast() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().pollLast();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(E r5, boolean r10, E r11, boolean r12) {
        Object r13 = this.mutex;
        monitor-enter(r13);
        Synchronized$SynchronizedNavigableSet r14 = new Synchronized$SynchronizedNavigableSet(delegate().subSet(r5, r10, r11, r12), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return r14;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(E r5, boolean r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedNavigableSet r12 = new Synchronized$SynchronizedNavigableSet(delegate().tailSet(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ SortedSet delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public NavigableSet<E> delegate() {
        return (NavigableSet) super.delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> headSet(E r5) {
        return headSet(r5, false);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> subSet(E r5, E r10) {
        return subSet(r5, true, r10, false);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
    public SortedSet<E> tailSet(E r5) {
        return tailSet(r5, true);
    }
}
