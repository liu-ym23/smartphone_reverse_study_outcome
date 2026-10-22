package com.google.common.collect;

import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedQueue<E> extends Synchronized$SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedQueue(Queue<E> r5, Object r10) {
        super(r5, r10, null);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Queue
    public E element() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().element();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public boolean offer(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().offer(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E peek() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().peek();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E poll() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().poll();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Queue
    public E remove() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().remove();     // Catch: Throwable -> L7
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
    public Queue<E> delegate() {
        return (Queue) super.delegate();
    }
}
