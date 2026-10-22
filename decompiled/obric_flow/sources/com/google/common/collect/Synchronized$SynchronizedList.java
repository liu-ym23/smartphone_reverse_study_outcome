package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedList<E> extends Synchronized$SynchronizedCollection<E> implements List<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedList(List<E> r5, Object r10) {
        super(r5, r10, null);
    }

    @Override // java.util.List
    public void add(int r5, E r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        delegate().add(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public boolean addAll(int r5, Collection<? extends E> r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        boolean r12 = delegate().addAll(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // java.util.Collection, java.util.List
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

    @Override // java.util.List
    public E get(int r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().get(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.util.List
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

    @Override // java.util.List
    public int indexOf(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        int r11 = delegate().indexOf(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public int lastIndexOf(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        int r11 = delegate().lastIndexOf(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    public E remove(int r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        E r11 = delegate().remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<E> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().replaceAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public E set(int r5, E r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        E r12 = delegate().set(r5, r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().sort(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.List
    public List<E> subList(int r5, int r10) {
        Object r11 = this.mutex;
        monitor-enter(r11);
        List<E> r12 = p7.Q(delegate().subList(r5, r10), this.mutex);     // Catch: Throwable -> L7
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

    @Override // java.util.List
    public ListIterator<E> listIterator(int r5) {
        return delegate().listIterator(r5);
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedCollection, com.google.common.collect.Synchronized$SynchronizedObject
    public List<E> delegate() {
        return (List) super.delegate();
    }
}
