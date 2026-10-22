package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedSet<E> extends Synchronized$SynchronizedCollection<E> implements Set<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedSet(Set<E> r5, Object r10) {
        super(r5, r10, null);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L5;
        return true;
    L5:
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().equals(r5);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        int r10 = delegate().hashCode();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public Set<E> delegate() {
        return (Set) super.delegate();
    }
}
