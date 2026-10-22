package org.apache.commons.collections4.collection;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class SynchronizedCollection<E> implements Serializable, Collection<E> {
    private static final long serialVersionUID = 2412805092710877986L;
    private final Collection<E> collection;
    protected final Object lock;

    public SynchronizedCollection(Collection<E> r3) {
        Collection<E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r4, "Collection must not be null.");
        this.collection = r4;
        this.lock = this;
    }

    public SynchronizedCollection(Collection<E> r3, Object r4) {
        Collection<E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r5, "Collection must not be null.");
        Objects.requireNonNull(r4, "Lock must not be null.");
        this.collection = r5;
        this.lock = r4;
    }

    public static <T> SynchronizedCollection<T> synchronizedCollection(Collection<T> r2) {
        return new SynchronizedCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.Collection
    public boolean add(E r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = decorated().add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> r3) {
        Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r2 = decorated().addAll(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public void clear() {
        Object r0 = this.lock;
        monitor-enter(r0);
        decorated().clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean contains(Object r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = decorated().contains(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r2 = decorated().containsAll(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public Collection<E> decorated() {
        return this.collection;
    }

    public boolean equals(Object r3) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = true;
        if (r3 != this) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return true;
    L10:
        if (r3 != this) goto L12;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L12:
        if (decorated().equals(r3) == true) goto L15;
        r1 = false;
    L8:
        th = move-exception;
        throw th;
    }

    public int hashCode() {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().hashCode();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = decorated().isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return decorated().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = decorated().remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r2 = decorated().removeAll(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> r3) {
        Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r2 = decorated().removeIf(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> r3) {
        Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r2 = decorated().retainAll(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public int size() {
        Object r0 = this.lock;
        monitor-enter(r0);
        int r1 = decorated().size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object r0 = this.lock;
        monitor-enter(r0);
        Object[] r1 = decorated().toArray();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        T[] r1 = (T[]) decorated().toArray(r2);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        Object r0 = this.lock;
        monitor-enter(r0);
        String r1 = decorated().toString();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
