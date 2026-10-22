package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class Synchronized$SynchronizedTable<R, C, V> extends Synchronized$SynchronizedObject implements l9 {
    public Synchronized$SynchronizedTable(l9 r5, Object r10) {
        super(r5, r10);
    }

    @Override // com.google.common.collect.l9
    public Set<k9> cellSet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedSet r10 = new Synchronized$SynchronizedSet(delegate().cellSet(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public void clear() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        delegate().clear();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Map<R, V> column(C r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedMap r11 = new Synchronized$SynchronizedMap(delegate().column(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Set<C> columnKeySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedSet r10 = new Synchronized$SynchronizedSet(delegate().columnKeySet(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Map<C, Map<R, V>> columnMap() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedMap r10 = new Synchronized$SynchronizedMap(new k7(delegate().columnMap(), new f7(new j9(this, 1))), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public boolean contains(Object r5, Object r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().contains(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public boolean containsColumn(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsColumn(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public boolean containsRow(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsRow(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public boolean containsValue(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsValue(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.l9
    public boolean equals(Object r5) {
        if (this != r5) goto L5;
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

    @Override // com.google.common.collect.l9
    public V get(Object r5, Object r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = (V) delegate().get(r5, r10);
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
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

    @Override // com.google.common.collect.l9
    public boolean isEmpty() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        boolean r10 = delegate().isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public V put(R r5, C r10, V r11) {
        Object r12 = this.mutex;
        monitor-enter(r12);
        V r13 = (V) delegate().put(r5, r10, r11);
        monitor-exit(r12);     // Catch: Throwable -> L7
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public void putAll(l9 r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().putAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public V remove(Object r5, Object r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        V r12 = (V) delegate().remove(r5, r10);
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Map<C, V> row(R r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        Synchronized$SynchronizedMap r11 = new Synchronized$SynchronizedMap(delegate().row(r5), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Set<R> rowKeySet() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedSet r10 = new Synchronized$SynchronizedSet(delegate().rowKeySet(), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Map<R, Map<C, V>> rowMap() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedMap r10 = new Synchronized$SynchronizedMap(new k7(delegate().rowMap(), new f7(new j9(this, 0))), this.mutex);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public int size() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        int r10 = delegate().size();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.l9
    public Collection<V> values() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Synchronized$SynchronizedCollection r10 = new Synchronized$SynchronizedCollection(delegate().values(), this.mutex, null);     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public l9 delegate() {
        return (l9) super.delegate();
    }
}
