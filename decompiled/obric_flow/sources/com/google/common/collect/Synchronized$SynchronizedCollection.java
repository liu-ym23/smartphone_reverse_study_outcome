package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
class Synchronized$SynchronizedCollection<E> extends Synchronized$SynchronizedObject implements Collection<E> {
    private static final long serialVersionUID = 0;

    public Synchronized$SynchronizedCollection(Collection r5, Object r10, h9 r11) {
        super(r5, r10);
    }

    @Override // java.util.Collection
    public boolean add(E r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().add(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().addAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
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

    public boolean contains(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().contains(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean containsAll(Collection<?> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().containsAll(r5);     // Catch: Throwable -> L7
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        delegate().forEach(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
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

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    public Stream<E> parallelStream() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Stream<E> r10 = delegate().parallelStream();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean remove(Object r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean removeAll(Collection<?> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().removeAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().removeIf(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean retainAll(Collection<?> r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        boolean r11 = delegate().retainAll(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
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

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Spliterator<E> r10 = delegate().spliterator();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public Stream<E> stream() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Stream<E> r10 = delegate().stream();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public Object[] toArray() {
        Object r5 = this.mutex;
        monitor-enter(r5);
        Object[] r10 = delegate().toArray();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.google.common.collect.Synchronized$SynchronizedObject
    public Collection<E> delegate() {
        return (Collection) super.delegate();
    }

    public <T> T[] toArray(T[] r5) {
        Object r10 = this.mutex;
        monitor-enter(r10);
        T[] r11 = (T[]) delegate().toArray(r5);
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
