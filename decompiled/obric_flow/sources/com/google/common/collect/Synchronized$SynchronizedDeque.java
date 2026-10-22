package com.google.common.collect;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: loaded from: classes2.dex */
final class Synchronized$SynchronizedDeque<E> extends Synchronized$SynchronizedQueue<E> implements Deque<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedDeque(Deque<E> r5, Object r10) {
        super(r5, r10);
    }

    @Override // java.util.Deque
    public void addFirst(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().addFirst(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public void addLast(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().addLast(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedQueue, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Iterator<E> r10 = delegate().descendingIterator();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E getFirst() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().getFirst();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E getLast() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().getLast();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public boolean offerFirst(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().offerFirst(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public boolean offerLast(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().offerLast(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().peekFirst();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E peekLast() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().peekLast();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
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

    @Override // java.util.Deque
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

    @Override // java.util.Deque
    public E pop() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().pop();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public void push(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().push(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E removeFirst() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().removeFirst();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().removeFirstOccurrence(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public E removeLast() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        E r10 = delegate().removeLast();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().removeLastOccurrence(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedQueue, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedQueue, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Queue delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedQueue, com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public Deque<E> delegate() {
        return (Deque) super.delegate();
    }
}
