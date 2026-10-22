package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class Iterators {

    private static final enum EmptyModifiableIterator extends Enum<EmptyModifiableIterator> implements Iterator<Object> {
        private static final /* synthetic */ EmptyModifiableIterator[] $VALUES = null;
        public static final EmptyModifiableIterator INSTANCE = null;

        private static /* synthetic */ EmptyModifiableIterator[] $values() {
            return new EmptyModifiableIterator[]{INSTANCE};
        }

        static {
            INSTANCE = new EmptyModifiableIterator("INSTANCE", 0);
            $VALUES = $values();
        }

        private EmptyModifiableIterator(String r1, int r2) {
            super(r1, r2);
        }

        public static EmptyModifiableIterator valueOf(String r2) {
            return (EmptyModifiableIterator) ZeusTransformUtils.preCheckCast(Enum.valueOf(EmptyModifiableIterator.class, r2), EmptyModifiableIterator.class, "com.obric.memorydata.plugin");
        }

        public static EmptyModifiableIterator[] values() {
            return (EmptyModifiableIterator[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EmptyModifiableIterator[].class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            o.a(false);
        }
    }

    private static final class a<T> extends com.google.common.collect.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final bk<Object> f4486a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T[] f4487b;
        private final int c;

        static {
            f4486a = new a(new Object[0], 0, 0, 0);
        }

        a(T[] r1, int r2, int r3, int r4) {
            super(r3, r4);
            this.f4487b = r1;
            this.c = r2;
        }

        @Override // com.google.common.collect.a
        public T a(int r2) {
            return this.f4487b[this.c + r2];
        }
    }

    private static class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator<? extends T> f4488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Iterator<? extends T> f4489b;
        private Iterator<? extends Iterator<? extends T>> c;
        private Deque<Iterator<? extends Iterator<? extends T>>> d;

        b(Iterator<? extends Iterator<? extends T>> r3) {
            Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
            this.f4489b = Iterators.a();
            this.c = (Iterator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r4), Iterator.class, "com.obric.memorydata.plugin");
        }

        private Iterator<? extends Iterator<? extends T>> a() {
        L2:
            Iterator<? extends Iterator<? extends T>> r0 = this.c;
            if (r0 != null) goto L5;
        L9:
            Deque<Iterator<? extends Iterator<? extends T>>> r1 = this.d;
            if (r1 == null) goto L14;
            if (r1.isEmpty() == true) goto L19;
            this.c = (Iterator) ZeusTransformUtils.preCheckCast(this.d.removeFirst(), Iterator.class, "com.obric.memorydata.plugin");
            goto L2
        L19:
            return null;
        L14:
            return null;
        L5:
            if (r0.hasNext() == false) goto L9;
            return this.c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
        L4:
            if (((Iterator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(this.f4489b), Iterator.class, "com.obric.memorydata.plugin")).hasNext() == true) goto L20;
            Iterator<? extends Iterator<? extends T>> r1 = a();
            this.c = r1;
            if (r1 == null) goto L7;
            Iterator<? extends T> r2 = (Iterator) ZeusTransformUtils.preCheckCast(r1.next(), Iterator.class, "com.obric.memorydata.plugin");
            this.f4489b = r2;
            if (ZeusTransformUtils.instanceOf(r2, b.class) == false) goto L4;
            b r3 = (b) ZeusTransformUtils.preCheckCast(this.f4489b, b.class, "com.obric.memorydata.plugin");
            this.f4489b = r3.f4489b;
            if (this.d != null) goto L14;
            this.d = new ArrayDeque();
        L14:
            this.d.addFirst(this.c);
            if (r3.d != null) goto L17;
        L19:
            this.c = r3.c;
        L17:
            if (r3.d.isEmpty() == true) goto L19;
            this.d.addFirst((Iterator) ZeusTransformUtils.preCheckCast(r3.d.removeLast(), Iterator.class, "com.obric.memorydata.plugin"));
            goto L17
        L7:
            return false;
        L20:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            Iterator<? extends T> r0 = this.f4489b;
            this.f4488a = r0;
            return r0.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> r0 = this.f4488a;
            if (r0 == null) goto L7;
            r0.remove();
            this.f4488a = null;
            return;
        L7:
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    private static class c<T> extends bj<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Queue<aq<T>> f4490a;

        public c(Iterable<? extends Iterator<? extends T>> r4, Comparator<? super T> r5) {
            Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
            final Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
            this.f4490a = new PriorityQueue(2, new $$Lambda$Iterators$c$xexcRz6kgvjEWCQHiQawZoPQEIE(r7));
            Iterator<T> r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L8;
            Iterator r9 = (Iterator) ZeusTransformUtils.preCheckCast(r8.next(), Iterator.class, "com.obric.memorydata.plugin");
            if (r9.hasNext() == false) goto L4;
            this.f4490a.add(Iterators.i(r9));
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static /* synthetic */ int a(Comparator r2, aq r3, aq r4) {
            Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
            aq r6 = (aq) ZeusTransformUtils.wrapperContextForParams(r3, aq.class, "com.obric.memorydata.plugin");
            aq r7 = (aq) ZeusTransformUtils.wrapperContextForParams(r4, aq.class, "com.obric.memorydata.plugin");
            return r5.compare(r6.a(), r7.a());
        }

        public static /* synthetic */ int lambda$xexcRz6kgvjEWCQHiQawZoPQEIE(Comparator r0, aq r1, aq r2) {
            return a(r0, r1, r2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f4490a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            aq<T> r0 = (aq) ZeusTransformUtils.preCheckCast(this.f4490a.remove(), aq.class, "com.obric.memorydata.plugin");
            T r1 = r0.next();
            if (r0.hasNext() == false) goto L5;
            this.f4490a.add(r0);
        L5:
            return r1;
        }
    }

    private static class d<E> implements aq<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<? extends E> f4491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4492b;
        private E c;

        public d(Iterator<? extends E> r3) {
            this.f4491a = (Iterator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin")), Iterator.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.aq
        public E a() {
            if (this.f4492b == true) goto L6;
            this.c = this.f4491a.next();
            this.f4492b = true;
        L6:
            return (E) ao.a(this.c);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4492b == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f4491a.hasNext() == true) goto L8;
            return false;
        }

        @Override // com.google.common.collect.aq, java.util.Iterator
        public E next() {
            if (this.f4492b == false) goto L5;
            E r0 = (E) ao.a(this.c);
            this.f4492b = false;
            this.c = null;
            return r0;
        L5:
            return this.f4491a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.n.b(!this.f4492b, "Can't remove after you've peeked at next");
            this.f4491a.remove();
        }
    }

    public static int a(Iterator<?> r3, int r4) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        int r0 = 0;
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        com.google.common.base.n.a(r1, "numberToAdvance must be nonnegative");
    L7:
        if (r0 >= r4) goto L11;
        if (r5.hasNext() == false) goto L11;
        r5.next();
        r0 = r0 + 1;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    static <T> bj<T> a() {
        return b();
    }

    public static <T> bj<T> a(Iterable<? extends Iterator<? extends T>> r2, Comparator<? super T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4, "iterators");
        com.google.common.base.n.a(r5, "comparator");
        return new c(r4, r5);
    }

    public static <T> bj<T> a(final T r1) {
        return new AnonymousClass4(r1);
    }

    public static <T> bj<T> a(Iterator<? extends T> r2) {
        final Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
        if (ZeusTransformUtils.instanceOf(r3, bj.class) == false) goto L7;
        return (bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin");
    L7:
        return new AnonymousClass1(r3);
    }

    @SafeVarargs
    public static <T> bj<T> a(T... r2) {
        return a(r2, 0, r2.length, 0);
    }

    static <T> bk<T> a(T[] r2, int r3, int r4, int r5) {
        if (r4 < 0) goto L4;
        boolean r0 = true;
    L5:
        com.google.common.base.n.a(r0);
        com.google.common.base.n.a(r3, r3 + r4, r2.length);
        com.google.common.base.n.b(r5, r4);
        if (r4 != 0) goto L10;
        return b();
    L10:
        return new a(r2, r3, r4, r5);
    L4:
        r0 = false;
        goto L5
    }

    public static <F, T> Iterator<T> a(Iterator<F> r2, com.google.common.base.g<? super F, ? extends T> r3) {
        final Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        final com.google.common.base.g r5 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        return new AnonymousClass3(r4, r5);
    }

    public static <T> boolean a(Collection<T> r2, Iterator<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 | r4.add(r5.next());
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean a(Iterator<T> r2, com.google.common.base.o<? super T> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r5.apply(r4.next()) == false) goto L4;
        r4.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean a(Iterator<?> r2, Object r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
    L5:
        if (r4.hasNext() == false) goto L14;
        if (r4.next() != null) goto L5;
        return true;
    L14:
        return false;
    L10:
        if (r4.hasNext() == false) goto L22;
        if (r3.equals(r4.next()) == false) goto L10;
        return true;
    L22:
        return false;
    }

    public static boolean a(Iterator<?> r2, Collection<?> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r5.contains(r4.next()) == false) goto L4;
        r4.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static boolean a(Iterator<?> r3, Iterator<?> r4) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        Iterator r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
    L4:
        if (r5.hasNext() == false) goto L12;
        if (r6.hasNext() == false) goto L7;
        if (com.google.common.base.k.a(r5.next(), r6.next()) == true) goto L4;
        return false;
    L7:
        return false;
    L12:
        return !r6.hasNext();
    }

    public static int b(Iterator<?> r4) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        long r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L7;
        r5.next();
        r0 = r0 + 1;
        goto L4
    L7:
        return Ints.b(r0);
    }

    public static <T> bj<T> b(Iterator<T> r2, com.google.common.base.o<? super T> r3) {
        final Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        final com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new AnonymousClass2(r4, r5);
    }

    static <T> bk<T> b() {
        return (bk<T>) a.f4486a;
    }

    public static <T> T b(Iterator<? extends T> r2, T r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r4.hasNext() == true) goto L5;
        return r3;
    L5:
        return (T) r4.next();
    }

    public static boolean b(Iterator<?> r2, Collection<?> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        boolean r0 = false;
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r5.contains(r4.next()) == true) goto L4;
        r4.remove();
        r0 = true;
        goto L4
    L8:
        return r0;
    }

    public static String c(Iterator<?> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append('[');
        boolean r1 = true;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (r1 == true) goto L7;
        r0.append(", ");
    L7:
        r1 = false;
        r0.append(r4.next());
        goto L4
    L9:
        return r0.append(']').toString();
    }

    static <T> Iterator<T> c() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> boolean c(Iterator<T> r2, com.google.common.base.o<? super T> r3) {
        if (d((Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin"), (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin")) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> int d(Iterator<T> r2, com.google.common.base.o<? super T> r3) {
        Iterator r4 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5, "predicate");
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (r5.apply(r4.next()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public static <T> T d(Iterator<T> r4) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
        T r0 = (T) r5.next();
        if (r5.hasNext() == true) goto L5;
        return r0;
    L5:
        StringBuilder r1 = new StringBuilder().append("expected one element but was: <").append(r0);
        int r2 = 0;
    L7:
        if (r2 >= 4) goto L12;
        if (r5.hasNext() == false) goto L12;
        r1.append(", ").append(r5.next());
        r2 = r2 + 1;
    L12:
        if (r5.hasNext() == false) goto L14;
        r1.append(", ...");
    L14:
        r1.append(Typography.greater);
        throw new IllegalArgumentException(r1.toString());
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> r2) {
        return new b((Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin"));
    }

    public static <T> T f(Iterator<T> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
    L3:
        T r0 = (T) r3.next();
        if (r3.hasNext() == true) goto L3;
        return r0;
    }

    static <T> T g(Iterator<T> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (r3.hasNext() == false) goto L6;
        T r0 = (T) r3.next();
        r3.remove();
        return r0;
    L6:
        return null;
    }

    static void h(Iterator<?> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r3);
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next();
        r3.remove();
        goto L4
    }

    public static <T> aq<T> i(Iterator<? extends T> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        return (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.memorydata.plugin");
    L7:
        return new d(r3);
    }

    static <T> ListIterator<T> j(Iterator<T> r2) {
        return (ListIterator) ZeusTransformUtils.preCheckCast((Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin"), ListIterator.class, "com.obric.memorydata.plugin");
    }
}
