package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedMultiset<E> extends Synchronized$SynchronizedCollection<E> implements z7 {
    private static final long serialVersionUID = 0;
    transient Set<E> elementSet;
    transient Set<y7> entrySet;

    public Synchronized$SynchronizedMultiset(z7 r5, Object r10) {
        super(r5, r10, null);
    }

    @Override // com.google.common.collect.z7
    public int add(E r5, int r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        int r12 = delegate().add(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        int r11 = delegate().count(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.z7
    public Set<E> elementSet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.elementSet != null) goto L9;
        this.elementSet = p7.c(delegate().elementSet(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<E> r10 = this.elementSet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // com.google.common.collect.z7
    public Set<y7> entrySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.entrySet != null) goto L9;
        this.entrySet = p7.c(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L7
    L9:
        Set<y7> r10 = this.entrySet;     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    }

    @Override // java.util.Collection, com.google.common.collect.z7
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

    @Override // com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer r5) {
        super.forEachEntry(r5);
    }

    @Override // java.util.Collection, com.google.common.collect.z7
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

    @Override // com.google.common.collect.z7
    public int remove(Object r5, int r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        int r12 = delegate().remove(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.z7
    public int setCount(E r5, int r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        int r12 = delegate().setCount(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public z7 delegate() {
        return (z7) super.delegate();
    }

    @Override // com.google.common.collect.z7
    public boolean setCount(E r5, int r10, int r11) {
        Object r12 = this.mutex;
        monitor-enter(r12);
        boolean r13 = delegate().setCount(r5, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }
}
