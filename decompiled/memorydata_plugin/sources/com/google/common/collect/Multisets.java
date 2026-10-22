package com.google.common.collect;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Multisets {

    static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E r1, int r2) {
            this.element = r1;
            this.count = r2;
            o.a(r2, CommonConsts.COUNT_TYPE);
        }

        @Override // com.google.common.collect.an.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.an.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    static class UnmodifiableMultiset<E> extends ab<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final an<? extends E> delegate;
        transient Set<E> elementSet;
        transient Set<an.a<E>> entrySet;

        UnmodifiableMultiset(an<? extends E> r3) {
            this.delegate = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public int add(E r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Queue
        public boolean add(E r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection
        public boolean addAll(Collection<? extends E> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
        public an<E> delegate() {
            return this.delegate;
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.v, com.google.common.collect.ac
        public /* bridge */ /* synthetic */ Collection delegate() {
            return delegate();
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public Set<E> elementSet() {
            Set<E> r0 = this.elementSet;
            if (r0 != null) goto L6;
            Set<E> r1 = createElementSet();
            this.elementSet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public Set<an.a<E>> entrySet() {
            Set<an.a<E>> r0 = this.entrySet;
            if (r0 != null) goto L6;
            Set<an.a<E>> r1 = Collections.unmodifiableSet(this.delegate.entrySet());
            this.entrySet = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.a(this.delegate.iterator());
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public int remove(Object r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean remove(Object r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.v, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r2) {
            Collection r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public int setCount(E r1, int r2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ab, com.google.common.collect.an
        public boolean setCount(E r1, int r2, int r3) {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class a<E> implements an.a<E> {
        a() {
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, an.a.class) == false) goto L10;
            an.a r5 = (an.a) ZeusTransformUtils.preCheckCast(r4, an.a.class, "com.obric.memorydata.plugin");
            if (getCount() == r5.getCount()) goto L7;
            return false;
        L7:
            if (com.google.common.base.k.a(getElement(), r5.getElement()) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            E r0 = getElement();
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return getCount() ^ r1;
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        @Override // com.google.common.collect.an.a
        public String toString() {
            String r0 = String.valueOf(getElement());
            int r2 = getCount();
            if (r2 != 1) goto L6;
            return r0;
        L6:
            return r0 + " x " + r2;
        }
    }

    static abstract class b<E> extends Sets.b<E> {
        b() {
        }

        abstract an<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return a().contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> r3) {
            Collection<?> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return a().containsAll(r4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            if (a().remove(r2, Integer.MAX_VALUE) <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    static abstract class c<E> extends Sets.b<an.a<E>> {
        c() {
        }

        abstract an<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, an.a.class) == false) goto L11;
            an.a r5 = (an.a) ZeusTransformUtils.preCheckCast(r4, an.a.class, "com.obric.memorydata.plugin");
            if (r5.getCount() > 0) goto L8;
            return false;
        L8:
            if (a().count(r5.getElement()) != r5.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, an.a.class) == false) goto L8;
            an.a r5 = (an.a) ZeusTransformUtils.preCheckCast(r4, an.a.class, "com.obric.memorydata.plugin");
            Object r0 = r5.getElement();
            int r6 = r5.getCount();
            if (r6 == 0) goto L8;
            return a().setCount(r0, r6, 0);
        L8:
            return false;
        }
    }

    static final class d<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final an<E> f4572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterator<an.a<E>> f4573b;
        private an.a<E> c;
        private int d;
        private int e;
        private boolean f;

        d(an<E> r3, Iterator<an.a<E>> r4) {
            an<E> r5 = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
            Iterator<an.a<E>> r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
            this.f4572a = r5;
            this.f4573b = r6;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.d <= 0) goto L5;
        L8:
            return true;
        L5:
            if (this.f4573b.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext() == false) goto L10;
            if (this.d != 0) goto L7;
            an.a<E> r0 = (an.a) ZeusTransformUtils.preCheckCast(this.f4573b.next(), an.a.class, "com.obric.memorydata.plugin");
            this.c = r0;
            int r1 = r0.getCount();
            this.d = r1;
            this.e = r1;
        L7:
            this.d--;
            this.f = true;
            return (E) ((an.a) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.c), an.a.class, "com.obric.memorydata.plugin")).getElement();
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            o.a(this.f);
            if (this.e != 1) goto L5;
            this.f4573b.remove();
        L6:
            this.e--;
            this.f = false;
            return;
        L5:
            this.f4572a.remove(((an.a) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.c), an.a.class, "com.obric.memorydata.plugin")).getElement());
            goto L6
        }
    }

    static <E> int a(an<E> r2, E r3, int r4) {
        an r5 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        o.a(r4, CommonConsts.COUNT_TYPE);
        int r0 = r5.count(r3);
        int r6 = r4 - r0;
        if (r6 <= 0) goto L5;
        r5.add(r3, r6);
    L7:
        return r0;
    L5:
        if (r6 >= 0) goto L7;
        r5.remove(r3, -r6);
        goto L7
    }

    static int a(Iterable<?> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, an.class) == true) goto L5;
        return 11;
    L5:
        return ((an) ZeusTransformUtils.preCheckCast(r3, an.class, "com.obric.memorydata.plugin")).elementSet().size();
    }

    public static <E> an.a<E> a(E r1, int r2) {
        return new ImmutableEntry(r1, r2);
    }

    public static <E> an<E> a(an<? extends E> r3) {
        an<E> r4 = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, UnmodifiableMultiset.class) == false) goto L5;
    L9:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, ImmutableMultiset.class) == true) goto L9;
        return new UnmodifiableMultiset((an) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), an.class, "com.obric.memorydata.plugin"));
    }

    public static <E> az<E> a(az<E> r3) {
        return new UnmodifiableSortedMultiset((az) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((az) ZeusTransformUtils.wrapperContextForParams(r3, az.class, "com.obric.memorydata.plugin")), az.class, "com.obric.memorydata.plugin"));
    }

    static <E> Iterator<E> a(Iterator<an.a<E>> r2) {
        final Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }

    private static /* synthetic */ Spliterator a(an.a r2) {
        an.a r3 = (an.a) ZeusTransformUtils.wrapperContextForParams(r2, an.a.class, "com.obric.memorydata.plugin");
        return Collections.nCopies(r3.getCount(), r3.getElement()).spliterator();
    }

    private static <E> boolean a(an<E> r2, an<? extends E> r3) {
        final an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        an r5 = (an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        Objects.requireNonNull(r4);
        r5.forEachEntry(new $$Lambda$P2fm4Jw_oeCY6WmlNaSiq9_iXc0(r4));
        return true;
    }

    static boolean a(an<?> r5, Object r6) {
        an r7 = (an) ZeusTransformUtils.wrapperContextForParams(r5, an.class, "com.obric.memorydata.plugin");
        if (r6 != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, an.class) == false) goto L19;
        an r8 = (an) ZeusTransformUtils.preCheckCast(r6, an.class, "com.obric.memorydata.plugin");
        if (r7.size() != r8.size()) goto L19;
        if (r7.entrySet().size() != r8.entrySet().size()) goto L19;
        Iterator r9 = r8.entrySet().iterator();
    L14:
        if (r9.hasNext() == false) goto L18;
        an.a r2 = (an.a) ZeusTransformUtils.preCheckCast(r9.next(), an.a.class, "com.obric.memorydata.plugin");
        if (r7.count(r2.getElement()) == r2.getCount()) goto L14;
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    static <E> boolean a(an<E> r2, E r3, int r4, int r5) {
        an r6 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        o.a(r4, "oldCount");
        o.a(r5, "newCount");
        if (r6.count(r3) != r4) goto L6;
        r6.setCount(r3, r5);
        return true;
    L6:
        return false;
    }

    static <E> boolean a(an<E> r2, Collection<? extends E> r3) {
        an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, an.class) == false) goto L7;
        return a(r4, b(r5));
    L7:
        if (r5.isEmpty() == false) goto L11;
        return false;
    L11:
        return Iterators.a(r4, r5.iterator());
    }

    static <T> an<T> b(Iterable<T> r2) {
        return (an) ZeusTransformUtils.preCheckCast((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), an.class, "com.obric.memorydata.plugin");
    }

    static <E> Iterator<E> b(an<E> r2) {
        an r3 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        return new d(r3, r3.entrySet().iterator());
    }

    static boolean b(an<?> r2, Collection<?> r3) {
        an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, an.class) == false) goto L6;
        r5 = ((an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.memorydata.plugin")).elementSet();
    L6:
        return r4.elementSet().removeAll(r5);
    }

    static <E> Spliterator<E> c(an<E> r5) {
        an r6 = (an) ZeusTransformUtils.wrapperContextForParams(r5, an.class, "com.obric.memorydata.plugin");
        Spliterator<an.a<E>> r0 = r6.entrySet().spliterator();
        return p.a(r0, $$Lambda$Multisets$tUke7OfSitSrIKrkG1ybzvuOP94.INSTANCE, (r0.characteristics() & 1296) | 64, r6.size());
    }

    static boolean c(an<?> r2, Collection<?> r3) {
        an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        Collection<?> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        if (ZeusTransformUtils.instanceOf(r5, an.class) == false) goto L6;
        r5 = ((an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.memorydata.plugin")).elementSet();
    L6:
        return r4.elementSet().retainAll(r5);
    }

    static int d(an<?> r6) {
        Iterator r7 = ((an) ZeusTransformUtils.wrapperContextForParams(r6, an.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        long r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L7;
        r2 = r2 + ((long) ((an.a) ZeusTransformUtils.preCheckCast(r7.next(), an.a.class, "com.obric.memorydata.plugin")).getCount());
        goto L4
    L7:
        return Ints.b(r2);
    }

    public static /* synthetic */ Spliterator lambda$tUke7OfSitSrIKrkG1ybzvuOP94(an.a r0) {
        return a(r0);
    }
}
