package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public final class Sets {

    static final class UnmodifiableNavigableSet<E> extends ag<E> implements Serializable, NavigableSet<E> {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        UnmodifiableNavigableSet(NavigableSet<E> r4) {
            NavigableSet r5 = (NavigableSet) ZeusTransformUtils.wrapperContextForParams(r4, NavigableSet.class, "com.obric.memorydata.plugin");
            this.delegate = (NavigableSet) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), NavigableSet.class, "com.obric.memorydata.plugin");
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(r5);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E r1) {
            return this.delegate.ceiling(r1);
        }

        @Override // com.google.common.collect.ag, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ag, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ag, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Set delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ag, com.google.common.collect.ae, com.google.common.collect.v, com.google.common.collect.ac
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.a(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> r0 = this.descendingSet;
            if (r0 != null) goto L6;
            UnmodifiableNavigableSet<E> r1 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.descendingSet = r1;
            r1.descendingSet = this;
            return r1;
        L6:
            return r0;
        }

        @Override // java.util.NavigableSet
        public E floor(E r1) {
            return this.delegate.floor(r1);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r3) {
            Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            this.delegate.forEach(r4);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E r1, boolean r2) {
            return Sets.a(this.delegate.headSet(r1, r2));
        }

        @Override // java.util.NavigableSet
        public E higher(E r1) {
            return this.delegate.higher(r1);
        }

        @Override // java.util.NavigableSet
        public E lower(E r1) {
            return this.delegate.lower(r1);
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> r2) {
            Predicate r1 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r2, Predicate.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.delegate.stream();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E r1, boolean r2, E r3, boolean r4) {
            return Sets.a(this.delegate.subSet(r1, r2, r3, r4));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E r1, boolean r2) {
            return Sets.a(this.delegate.tailSet(r1, r2));
        }
    }

    private static final class a<E> extends v<List<E>> implements Set<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final transient ImmutableList<ImmutableSet<E>> f4586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient l<E> f4587b;

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean contains(Object r7) {
            if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L5;
            return false;
        L5:
            List r8 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
            if (r8.size() == this.f4586a.size()) goto L8;
            return false;
        L8:
            Iterator<E> r9 = r8.iterator();
            int r0 = 0;
        L10:
            if (r9.hasNext() == false) goto L15;
            if (((ImmutableSet) ZeusTransformUtils.preCheckCast(this.f4586a.get(r0), ImmutableSet.class, "com.obric.memorydata.plugin")).contains(r9.next()) == false) goto L13;
            r0 = r0 + 1;
            goto L10
        L13:
            return false;
        L15:
            return true;
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.v, com.google.common.collect.ac
        public Collection<List<E>> delegate() {
            return this.f4587b;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L7;
            a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
            return this.f4586a.equals(r4.f4586a);
        L7:
            return super.equals(r3);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int r1 = 1;
            int r0 = size() - 1;
            int r2 = 0;
        L4:
            if (r2 >= this.f4586a.size()) goto L6;
            r0 = ~(~(r0 * 31));
            r2 = r2 + 1;
            goto L4
        L6:
            bj<ImmutableSet<E>> r3 = this.f4586a.iterator();
        L8:
            if (r3.hasNext() == false) goto L11;
            Set r4 = (Set) ZeusTransformUtils.preCheckCast(r3.next(), Set.class, "com.obric.memorydata.plugin");
            r1 = ~(~((r1 * 31) + ((size() / r4.size()) * r4.hashCode())));
            goto L8
        L11:
            return ~(~(r1 + r0));
        }
    }

    static abstract class b<E> extends AbstractSet<E> {
        b() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r3) {
            return Sets.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r3) {
            return super.retainAll((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        }
    }

    static int a(Set<?> r3) {
        Iterator r4 = ((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        Object r2 = r4.next();
        if (r2 == null) goto L8;
        int r5 = r2.hashCode();
    L9:
        r1 = ~(~(r1 + r5));
        goto L4
    L8:
        r5 = 0;
        goto L9
    L10:
        return r1;
    }

    public static <E> HashSet<E> a() {
        return new HashSet();
    }

    public static <E> HashSet<E> a(int r1) {
        return new HashSet(Maps.b(r1));
    }

    public static <E> NavigableSet<E> a(NavigableSet<E> r2) {
        NavigableSet<E> r3 = (NavigableSet) ZeusTransformUtils.wrapperContextForParams(r2, NavigableSet.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ImmutableCollection.class) == false) goto L5;
    L9:
        return r3;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UnmodifiableNavigableSet.class) == true) goto L9;
        return new UnmodifiableNavigableSet(r3);
    }

    static boolean a(Set<?> r4, Object r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (r6 != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Set.class) == false) goto L15;
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
        if (r6.size() != r7.size()) goto L14;
        if (r6.containsAll(r7) == false) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    static boolean a(Set<?> r2, Collection<?> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, an.class) == false) goto L6;
        r5 = ((an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.memorydata.plugin")).elementSet();
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Set.class) == false) goto L12;
        if (r5.size() <= r4.size()) goto L12;
        return Iterators.a(r4.iterator(), r5);
    L12:
        return a(r4, r5.iterator());
    }

    static boolean a(Set<?> r2, Iterator<?> r3) {
        Set r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r4.remove(r5.next());
        goto L4
    L6:
        return r0;
    }

    public static <E> LinkedHashSet<E> b() {
        return new LinkedHashSet();
    }

    public static <E> LinkedHashSet<E> b(int r1) {
        return new LinkedHashSet(Maps.b(r1));
    }

    public static <E> Set<E> c() {
        return Collections.newSetFromMap(Maps.e());
    }
}
