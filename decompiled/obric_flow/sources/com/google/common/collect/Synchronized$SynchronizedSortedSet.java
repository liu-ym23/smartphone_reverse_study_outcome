package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedSortedSet<E> extends Synchronized$SynchronizedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedSet(SortedSet<E> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Comparator<? super E> r10 = delegate().comparator();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.SortedSet
    public E first() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().first();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedSet<E> headSet(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSortedSet r11 = new Synchronized$SynchronizedSortedSet(delegate().headSet(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.SortedSet
    public E last() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().last();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedSet<E> subSet(E r5, E r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        Synchronized$SynchronizedSortedSet r12 = new Synchronized$SynchronizedSortedSet(delegate().subSet(r5, r10), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public SortedSet<E> tailSet(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSortedSet r11 = new Synchronized$SynchronizedSortedSet(delegate().tailSet(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Set delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSet, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public SortedSet<E> delegate() {
        return (SortedSet) super.delegate();
    }
}
