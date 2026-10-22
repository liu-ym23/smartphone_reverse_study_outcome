package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedSortedSetMultimap<K, V> extends Synchronized$SynchronizedSetMultimap<K, V> implements x8 {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSortedSetMultimap(x8 r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ q7 delegate() {
        return delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Collection replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.x8
    public Comparator<? super V> valueComparator() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Comparator<? super V> r10 = delegate().valueComparator();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ s8 delegate() {
        return delegate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set get(Object r5) {
        return get(r5);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set removeAll(Object r5) {
        return removeAll(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public /* bridge */ /* synthetic */ Set replaceValues(Object r5, Iterable r10) {
        return replaceValues(r5, r10);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public SortedSet<V> get(K r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedSortedSet r11 = new Synchronized$SynchronizedSortedSet(delegate().get(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public SortedSet<V> removeAll(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        SortedSet<V> r11 = delegate().removeAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.q7
    public SortedSet<V> replaceValues(K r5, Iterable<? extends V> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        SortedSet<V> r12 = delegate().replaceValues(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedSetMultimap, com.google.common.collect.Synchronized$SynchronizedMultimap, com.google.common.collect.Synchronized$SynchronizedObject
    public x8 delegate() {
        return (x8) super.delegate();
    }
}
