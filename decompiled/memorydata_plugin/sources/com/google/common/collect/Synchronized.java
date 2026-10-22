package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
final class Synchronized {

    /* JADX INFO: renamed from: com.google.common.collect.Synchronized$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        transient Collection<Collection<V>> asMapValues;

        SynchronizedAsMap(Map<K, Collection<V>> r3, Object r4) {
            super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public boolean containsValue(Object r1) {
            return values().contains(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapEntrySet != null) goto L7;
            this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, Collection<V>>> r4 = this.asMapEntrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Object get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<V> get(Object r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(super.get(r4), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r5 != null) goto L7;
            Collection<V> r3 = null;
        L8:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        L7:
            r3 = Synchronized.a(r5, this.mutex);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Collection<Collection<V>> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMapValues != null) goto L7;
            this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Collection<V>> r4 = this.asMapValues;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }
    }

    private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> r3, Object r4) {
            super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Maps.a(delegate(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = q.a(delegate(), r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Sets.a(delegate(), r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            final Iterator r1 = super.iterator();
            return new AnonymousClass1(this, r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = Maps.b(delegate(), r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = Iterators.a(delegate().iterator(), r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r3) {
            Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = Iterators.b(delegate().iterator(), r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Object[] r1 = ap.a(delegate());     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            T[] r1 = (T[]) ap.a(delegate(), r2);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> r3, Object r4) {
            super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            final Iterator r1 = super.iterator();
            return new AnonymousClass1(this, r1);
        }
    }

    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements k<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        private transient k<V, K> inverse;
        private transient Set<V> valueSet;

        private SynchronizedBiMap(k<K, V> r3, Object r4, k<V, K> r5) {
            k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin");
            k<V, K> r7 = (k) ZeusTransformUtils.wrapperContextForParams(r5, k.class, "com.obric.memorydata.plugin");
            super(r6, r4);
            this.inverse = r7;
        }

        /* synthetic */ SynchronizedBiMap(k r2, Object r3, k r4, AnonymousClass1 r5) {
            this((k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.memorydata.plugin"), r3, (k) ZeusTransformUtils.wrapperContextForParams(r4, k.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        k<K, V> delegate() {
            return (k) ZeusTransformUtils.preCheckCast(super.delegate(), k.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.k
        public V forcePut(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().forcePut(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.k
        public k<V, K> inverse() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.inverse != null) goto L7;
            this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);     // Catch: Throwable -> L10
        L7:
            k<V, K> r4 = this.inverse;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return values();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.valueSet != null) goto L7;
            this.valueSet = Synchronized.a(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<V> r3 = this.valueSet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }
    }

    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(Collection<E> r3, Object r4) {
            super((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"), r4);
        }

        /* synthetic */ SynchronizedCollection(Collection r2, Object r3, AnonymousClass1 r4) {
            this((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), r3);
        }

        @Override // java.util.Collection
        public boolean add(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().add(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> r3) {
            Collection<? extends E> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().addAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean contains(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().contains(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().containsAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Collection<E> delegate() {
            return (Collection) ZeusTransformUtils.preCheckCast(super.delegate(), Collection.class, "com.obric.memorydata.plugin");
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r3) {
            Consumer<? super T> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().forEach(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Stream<E> r1 = delegate().parallelStream();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean removeAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().removeAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> r3) {
            Predicate<? super E> r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().removeIf(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean retainAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().retainAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Spliterator<E> r1 = delegate().spliterator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Stream<E> r1 = delegate().stream();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Object[] toArray() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Object[] r1 = delegate().toArray();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public <T> T[] toArray(T[] r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            T[] r1 = (T[]) delegate().toArray(r2);
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque<E> r3, Object r4) {
            super((Deque) ZeusTransformUtils.wrapperContextForParams(r3, Deque.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.Deque
        public void addFirst(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().addFirst(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void addLast(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().addLast(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Deque<E> delegate() {
            return (Deque) ZeusTransformUtils.preCheckCast(super.delegate(), Deque.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Queue delegate() {
            return delegate();
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Iterator<E> r1 = delegate().descendingIterator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().getFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E getLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().getLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offerFirst(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean offerLast(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offerLast(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peekFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E peekLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peekLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pollLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E pop() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pop();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public void push(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().push(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().removeFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().removeFirstOccurrence(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public E removeLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().removeLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().removeLastOccurrence(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry<K, V> r3, Object r4) {
            super((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map.Entry<K, V> delegate() {
            return (Map.Entry) ZeusTransformUtils.preCheckCast(super.delegate(), Map.Entry.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().getKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().getValue();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map.Entry
        public V setValue(V r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().setValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> r3, Object r4) {
            super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, null);
        }

        @Override // java.util.List
        public void add(int r2, E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().add(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public boolean addAll(int r3, Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().addAll(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        List<E> delegate() {
            return (List) ZeusTransformUtils.preCheckCast(super.delegate(), List.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E get(int r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().get(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int indexOf(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().indexOf(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public int lastIndexOf(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().lastIndexOf(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int r1) {
            return delegate().listIterator(r1);
        }

        @Override // java.util.List
        public E remove(int r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> r3) {
            UnaryOperator<E> r4 = (UnaryOperator) ZeusTransformUtils.wrapperContextForParams(r3, UnaryOperator.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().replaceAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public E set(int r2, E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().set(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> r3) {
            Comparator<? super E> r4 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().sort(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.List
        public List<E> subList(int r3, int r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<E> r2 = Synchronized.a(delegate().subList(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ak<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ak<K, V> r3, Object r4) {
            super((ak) ZeusTransformUtils.wrapperContextForParams(r3, ak.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        ak<K, V> delegate() {
            return (ak) ZeusTransformUtils.preCheckCast(super.delegate(), ak.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r2 = Synchronized.a(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public List<V> replaceValues(K r3, Iterable<? extends V> r4) {
            Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            List<V> r2 = delegate().replaceValues(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;
        transient Set<K> keySet;
        transient Collection<V> values;

        SynchronizedMap(Map<K, V> r3, Object r4) {
            super((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.Map
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V compute(K r3, BiFunction<? super K, ? super V, ? extends V> r4) {
            BiFunction<? super K, ? super V, ? extends V> r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r2 = delegate().compute(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V computeIfAbsent(K r3, Function<? super K, ? extends V> r4) {
            Function<? super K, ? extends V> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r2 = delegate().computeIfAbsent(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V computeIfPresent(K r3, BiFunction<? super K, ? super V, ? extends V> r4) {
            BiFunction<? super K, ? super V, ? extends V> r5 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r4, BiFunction.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r2 = delegate().computeIfPresent(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean containsKey(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public boolean containsValue(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        Map<K, V> delegate() {
            return (Map) ZeusTransformUtils.preCheckCast(super.delegate(), Map.class, "com.obric.memorydata.plugin");
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.a(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Map
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> r3) {
            BiConsumer<? super K, ? super V> r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().forEach(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public V get(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().get(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V getOrDefault(Object r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().getOrDefault(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = Synchronized.a(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r3 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Map
        public V merge(K r3, V r4, BiFunction<? super V, ? super V, ? extends V> r5) {
            BiFunction<? super V, ? super V, ? extends V> r6 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r5, BiFunction.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r2 = delegate().merge(r3, r4, r6);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V put(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> r3) {
            Map<? extends K, ? extends V> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().putAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V putIfAbsent(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().putIfAbsent(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V remove(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().remove(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean remove(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public V replace(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().replace(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public boolean replace(K r2, V r3, V r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().replace(r2, r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> r3) {
            BiFunction<? super K, ? super V, ? extends V> r4 = (BiFunction) ZeusTransformUtils.wrapperContextForParams(r3, BiFunction.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().replaceAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Map
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.values != null) goto L7;
            this.values = Synchronized.b(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<V> r3 = this.values;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }
    }

    private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements am<K, V> {
        private static final long serialVersionUID = 0;
        transient Map<K, Collection<V>> asMap;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient an<K> keys;
        transient Collection<V> valuesCollection;

        SynchronizedMultimap(am<K, V> r3, Object r4) {
            super((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.am
        public Map<K, Collection<V>> asMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.asMap != null) goto L7;
            this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Map<K, Collection<V>> r4 = this.asMap;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r4;
        }

        @Override // com.google.common.collect.am
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean containsEntry(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsEntry(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean containsKey(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean containsValue(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        am<K, V> delegate() {
            return (am) ZeusTransformUtils.preCheckCast(super.delegate(), am.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.am
        public Collection<Map.Entry<K, V>> entries() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entries != null) goto L7;
            this.entries = Synchronized.a(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<Map.Entry<K, V>> r3 = this.entries;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.am
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public void forEach(BiConsumer<? super K, ? super V> r3) {
            BiConsumer<? super K, ? super V> r4 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r3, BiConsumer.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().forEach(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r2 = Synchronized.a(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public Set<K> keySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keySet != null) goto L7;
            this.keySet = Synchronized.b(delegate().keySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<K> r3 = this.keySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.am
        public an<K> keys() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.keys != null) goto L7;
            this.keys = Synchronized.a(delegate().keys(), this.mutex);     // Catch: Throwable -> L10
        L7:
            an<K> r3 = this.keys;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.am
        public boolean put(K r2, V r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().put(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean putAll(am<? extends K, ? extends V> r3) {
            am<? extends K, ? extends V> r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().putAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean putAll(K r3, Iterable<? extends V> r4) {
            Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r2 = delegate().putAll(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public boolean remove(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public Collection<V> replaceValues(K r3, Iterable<? extends V> r4) {
            Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r2 = delegate().replaceValues(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.am
        public Collection<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.valuesCollection != null) goto L7;
            this.valuesCollection = Synchronized.b(delegate().values(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Collection<V> r3 = this.valuesCollection;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }
    }

    private static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements an<E> {
        private static final long serialVersionUID = 0;
        transient Set<E> elementSet;
        transient Set<an.a<E>> entrySet;

        SynchronizedMultiset(an<E> r3, Object r4) {
            super((an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin"), r4, null);
        }

        @Override // com.google.common.collect.an
        public int add(E r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().add(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.an
        public int count(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().count(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        an<E> delegate() {
            return (an) ZeusTransformUtils.preCheckCast(super.delegate(), an.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.an
        public Set<E> elementSet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.elementSet != null) goto L7;
            this.elementSet = Synchronized.b(delegate().elementSet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<E> r3 = this.elementSet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // com.google.common.collect.an
        public Set<an.a<E>> entrySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.b(delegate().entrySet(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<an.a<E>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        @Override // java.util.Collection, com.google.common.collect.an
        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, com.google.common.collect.an
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.an
        public int remove(Object r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.an
        public int setCount(E r2, int r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().setCount(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.an
        public boolean setCount(E r2, int r3, int r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().setCount(r2, r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<K> descendingKeySet;
        transient NavigableMap<K, V> descendingMap;
        transient NavigableSet<K> navigableKeySet;

        SynchronizedNavigableMap(NavigableMap<K, V> r3, Object r4) {
            super((NavigableMap) ZeusTransformUtils.wrapperContextForParams(r3, NavigableMap.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().ceilingEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().ceilingKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        NavigableMap<K, V> delegate() {
            return (NavigableMap) ZeusTransformUtils.preCheckCast(super.delegate(), NavigableMap.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ SortedMap delegate() {
            return delegate();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<K> r1 = this.descendingKeySet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<K> r2 = Synchronized.a(delegate().descendingKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingKeySet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r1 = this.descendingMap;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableMap<K, V> r2 = Synchronized.a(delegate().descendingMap(), this.mutex);     // Catch: Throwable -> L11
            this.descendingMap = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().firstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().floorEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K floorKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().floorKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.a(delegate().headMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K r2) {
            return headMap(r2, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().higherEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K higherKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().higherKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().lastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().lowerEntry(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().lowerKey(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<K> r1 = this.navigableKeySet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<K> r2 = Synchronized.a(delegate().navigableKeySet(), this.mutex);     // Catch: Throwable -> L11
            this.navigableKeySet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().pollFirstEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map.Entry<K, V> r2 = Synchronized.a(delegate().pollLastEntry(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K r3, boolean r4, K r5, boolean r6) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.a(delegate().subMap(r3, r4, r5, r6), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K r3, K r4) {
            return subMap(r3, true, r4, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableMap<K, V> r2 = Synchronized.a(delegate().tailMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K r2) {
            return tailMap(r2, true);
        }
    }

    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<E> descendingSet;

        SynchronizedNavigableSet(NavigableSet<E> r3, Object r4) {
            super((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r3, NavigableSet.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().ceiling(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        NavigableSet<E> delegate() {
            return (NavigableSet) ZeusTransformUtils.preCheckCast(super.delegate(), NavigableSet.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ SortedSet delegate() {
            return delegate();
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r1 = this.descendingSet;     // Catch: Throwable -> L11
            if (r1 != null) goto L9;
            NavigableSet<E> r2 = Synchronized.a(delegate().descendingSet(), this.mutex);     // Catch: Throwable -> L11
            this.descendingSet = r2;     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r2;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E floor(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().floor(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.a(delegate().headSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E r2) {
            return headSet(r2, false);
        }

        @Override // java.util.NavigableSet
        public E higher(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().higher(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E lower(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().lower(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollFirst();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().pollLast();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r3, boolean r4, E r5, boolean r6) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.a(delegate().subSet(r3, r4, r5, r6), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E r3, E r4) {
            return subSet(r3, true, r4, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r3, boolean r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            NavigableSet<E> r2 = Synchronized.a(delegate().tailSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E r2) {
            return tailSet(r2, true);
        }
    }

    static class SynchronizedObject implements Serializable {
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object r1, Object r2) {
            this.delegate = com.google.common.base.n.a(r1);
            if (r2 != null) goto L5;
            r2 = this;
        L5:
            this.mutex = r2;
        }

        private void writeObject(ObjectOutputStream r1) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            r1.defaultWriteObject();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        Object delegate() {
            return this.delegate;
        }

        public String toString() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            String r1 = this.delegate.toString();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> r3, Object r4) {
            super((Queue) ZeusTransformUtils.wrapperContextForParams(r3, Queue.class, "com.obric.memorydata.plugin"), r4, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Queue<E> delegate() {
            return (Queue) ZeusTransformUtils.preCheckCast(super.delegate(), Queue.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Queue
        public E element() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().element();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public boolean offer(E r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().offer(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E peek() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().peek();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E poll() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().poll();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Queue
        public E remove() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().remove();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> r3, Object r4) {
            super((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> r3, Object r4) {
            super((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), r4, null);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        Set<E> delegate() {
            return (Set) ZeusTransformUtils.preCheckCast(super.delegate(), Set.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r2) {
            if (r2 != this) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements aw<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;

        SynchronizedSetMultimap(aw<K, V> r3, Object r4) {
            super((aw) ZeusTransformUtils.wrapperContextForParams(r3, aw.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        aw<K, V> delegate() {
            return (aw) ZeusTransformUtils.preCheckCast(super.delegate(), aw.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am
        public /* bridge */ /* synthetic */ Collection entries() {
            return entries();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am
        public Set<Map.Entry<K, V>> entries() {
            Object r0 = this.mutex;
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.entrySet != null) goto L7;
            this.entrySet = Synchronized.a(delegate().entries(), this.mutex);     // Catch: Throwable -> L10
        L7:
            Set<Map.Entry<K, V>> r3 = this.entrySet;     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r2 = Synchronized.a(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public Set<V> replaceValues(K r3, Iterable<? extends V> r4) {
            Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<V> r2 = delegate().replaceValues(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap<K, V> r3, Object r4) {
            super((SortedMap) ZeusTransformUtils.wrapperContextForParams(r3, SortedMap.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super K> r1 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Map delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, com.google.common.collect.Synchronized.SynchronizedObject
        SortedMap<K, V> delegate() {
            return (SortedMap) ZeusTransformUtils.preCheckCast(super.delegate(), SortedMap.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().firstKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> headMap(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.a(delegate().headMap(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            K r1 = delegate().lastKey();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> subMap(K r3, K r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.a(delegate().subMap(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedMap<K, V> tailMap(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedMap<K, V> r2 = Synchronized.a(delegate().tailMap(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> r3, Object r4) {
            super((SortedSet) ZeusTransformUtils.wrapperContextForParams(r3, SortedSet.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super E> r1 = delegate().comparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection, com.google.common.collect.Synchronized.SynchronizedObject
        SortedSet<E> delegate() {
            return (SortedSet) ZeusTransformUtils.preCheckCast(super.delegate(), SortedSet.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.SortedSet
        public E first() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().first();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> headSet(E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.a(delegate().headSet(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // java.util.SortedSet
        public E last() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            E r1 = delegate().last();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> subSet(E r3, E r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.a(delegate().subSet(r3, r4), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        public SortedSet<E> tailSet(E r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<E> r2 = Synchronized.a(delegate().tailSet(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements bc<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(bc<K, V> r3, Object r4) {
            super((bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ am delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ aw delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        bc<K, V> delegate() {
            return (bc) ZeusTransformUtils.preCheckCast(super.delegate(), bc.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection get(Object r1) {
            return get(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Set get(Object r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> get(K r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r2 = Synchronized.a(delegate().get(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* bridge */ /* synthetic */ Set removeAll(Object r1) {
            return removeAll(r1);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> removeAll(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r1 = delegate().removeAll(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public /* synthetic */ Set replaceValues(Object r3, Iterable r4) {
            return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.am, com.google.common.collect.ak
        public SortedSet<V> replaceValues(K r3, Iterable<? extends V> r4) {
            Iterable<? extends V> r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            SortedSet<V> r2 = delegate().replaceValues(r3, r5);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.bc
        public Comparator<? super V> valueComparator() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Comparator<? super V> r1 = delegate().valueComparator();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }
    }

    private static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements be<R, C, V> {
        SynchronizedTable(be<R, C, V> r3, Object r4) {
            super((be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin"), r4);
        }

        @Override // com.google.common.collect.be
        public Set<be.a<R, C, V>> cellSet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<be.a<R, C, V>> r2 = Synchronized.a(delegate().cellSet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public void clear() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Map<R, V> column(C r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map<R, V> r2 = Synchronized.a(delegate().column(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Set<C> columnKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<C> r2 = Synchronized.a(delegate().columnKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Map<C, Map<R, V>> columnMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map<C, Map<R, V>> r3 = Synchronized.a(Maps.a(delegate().columnMap(), new AnonymousClass2(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public boolean contains(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().contains(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public boolean containsColumn(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsColumn(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public boolean containsRow(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsRow(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public boolean containsValue(Object r2) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().containsValue(r2);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        be<R, C, V> delegate() {
            return (be) ZeusTransformUtils.preCheckCast(super.delegate(), be.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedObject
        /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.be
        public boolean equals(Object r2) {
            if (this != r2) goto L5;
            return true;
        L5:
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().equals(r2);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public V get(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().get(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public int hashCode() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().hashCode();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public boolean isEmpty() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            boolean r1 = delegate().isEmpty();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public V put(R r2, C r3, V r4) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().put(r2, r3, r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public void putAll(be<? extends R, ? extends C, ? extends V> r3) {
            be<? extends R, ? extends C, ? extends V> r4 = (be) ZeusTransformUtils.wrapperContextForParams(r3, be.class, "com.obric.memorydata.plugin");
            Object r0 = this.mutex;
            monitor-enter(r0);
            delegate().putAll(r4);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public V remove(Object r2, Object r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            V r1 = delegate().remove(r2, r3);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Map<C, V> row(R r3) {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map<C, V> r2 = Synchronized.a(delegate().row(r3), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Set<R> rowKeySet() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Set<R> r2 = Synchronized.a(delegate().rowKeySet(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Map<R, Map<C, V>> rowMap() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Map<R, Map<C, V>> r3 = Synchronized.a(Maps.a(delegate().rowMap(), new AnonymousClass1(this)), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r3;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public int size() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            int r1 = delegate().size();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.common.collect.be
        public Collection<V> values() {
            Object r0 = this.mutex;
            monitor-enter(r0);
            Collection<V> r2 = Synchronized.b(delegate().values(), this.mutex);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r2;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static <E> an<E> a(an<E> r2, Object r3) {
        an<E> r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SynchronizedMultiset.class) == false) goto L5;
    L9:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ImmutableMultiset.class) == true) goto L9;
        return new SynchronizedMultiset(r4, r3);
    }

    static /* synthetic */ Collection a(Collection r2, Object r3) {
        return d((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ List a(List r2, Object r3) {
        return b((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ Map.Entry a(Map.Entry r2, Object r3) {
        return b((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin"), r3);
    }

    static <K, V> Map<K, V> a(Map<K, V> r2, Object r3) {
        return new SynchronizedMap((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin"), r3);
    }

    static <K, V> NavigableMap<K, V> a(NavigableMap<K, V> r2, Object r3) {
        return new SynchronizedNavigableMap((NavigableMap) ZeusTransformUtils.wrapperContextForParams(r2, NavigableMap.class, "com.obric.memorydata.plugin"), r3);
    }

    static <E> NavigableSet<E> a(NavigableSet<E> r2, Object r3) {
        return new SynchronizedNavigableSet((NavigableSet) ZeusTransformUtils.wrapperContextForParams(r2, NavigableSet.class, "com.obric.memorydata.plugin"), r3);
    }

    static <E> Set<E> a(Set<E> r2, Object r3) {
        return new SynchronizedSet((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), r3);
    }

    static <K, V> SortedMap<K, V> a(SortedMap<K, V> r2, Object r3) {
        return new SynchronizedSortedMap((SortedMap) ZeusTransformUtils.wrapperContextForParams(r2, SortedMap.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ SortedSet a(SortedSet r2, Object r3) {
        return b((SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin"), r3);
    }

    static /* synthetic */ Collection b(Collection r2, Object r3) {
        return c((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), r3);
    }

    private static <E> List<E> b(List<E> r2, Object r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RandomAccess.class) == false) goto L6;
        return new SynchronizedRandomAccessList(r4, r3);
    L6:
        return new SynchronizedList(r4, r3);
    }

    private static <K, V> Map.Entry<K, V> b(Map.Entry<K, V> r2, Object r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return new SynchronizedEntry(r4, r3);
    }

    static /* synthetic */ Set b(Set r2, Object r3) {
        return c((Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin"), r3);
    }

    private static <E> SortedSet<E> b(SortedSet<E> r2, Object r3) {
        return new SynchronizedSortedSet((SortedSet) ZeusTransformUtils.wrapperContextForParams(r2, SortedSet.class, "com.obric.memorydata.plugin"), r3);
    }

    private static <E> Collection<E> c(Collection<E> r2, Object r3) {
        return new SynchronizedCollection((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin"), r3, null);
    }

    private static <E> Set<E> c(Set<E> r2, Object r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SortedSet.class) == false) goto L7;
        return b((SortedSet) ZeusTransformUtils.preCheckCast(r4, SortedSet.class, "com.obric.memorydata.plugin"), r3);
    L7:
        return a(r4, r3);
    }

    private static <E> Collection<E> d(Collection<E> r2, Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SortedSet.class) == false) goto L7;
        return b((SortedSet) ZeusTransformUtils.preCheckCast(r4, SortedSet.class, "com.obric.memorydata.plugin"), r3);
    L7:
        if (ZeusTransformUtils.instanceOf(r4, Set.class) == false) goto L11;
        return a((Set) ZeusTransformUtils.preCheckCast(r4, Set.class, "com.obric.memorydata.plugin"), r3);
    L11:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == false) goto L15;
        return b((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), r3);
    L15:
        return c(r4, r3);
    }
}
