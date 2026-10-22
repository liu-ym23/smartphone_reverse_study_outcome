package com.google.common.collect;

import com.bytedance.crash.dumper.ProcInfo;
import com.google.common.base.Predicates;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Collection<E> f4695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.google.common.base.o<? super E> f4696b;

        a(Collection<E> r3, com.google.common.base.o<? super E> r4) {
            Collection<E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            com.google.common.base.o<? super E> r6 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.o.class, "com.obric.memorydata.plugin");
            this.f4695a = r5;
            this.f4696b = r6;
        }

        private /* synthetic */ void a(Consumer r3, Object r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            if (this.f4696b.test(r4) == false) goto L6;
            r5.accept(r4);
            return;
        }

        private static /* synthetic */ boolean a(Collection r2, Object r3) {
            return !((Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin")).contains(r3);
        }

        private /* synthetic */ boolean a(Predicate r3, Object r4) {
            Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            if (this.f4696b.apply(r4) == true) goto L5;
        L7:
            return false;
        L5:
            if (r5.test(r4) == false) goto L7;
            return true;
        }

        /* JADX INFO: renamed from: lambda$I9CFCzogSYb-b629P1noKXlVF4Y, reason: not valid java name */
        public static /* synthetic */ boolean m138lambda$I9CFCzogSYbb629P1noKXlVF4Y(Collection r0, Object r1) {
            return a(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$mdBNX3cSaaw-UkxW1RigpY-ccp8, reason: not valid java name */
        public static /* synthetic */ boolean m139lambda$mdBNX3cSaawUkxW1RigpYccp8(a r0, Predicate r1, Object r2) {
            return r0.a(r1, r2);
        }

        public static /* synthetic */ void lambda$pMDNzwiLHCj0P736QNKD2yF9Fnc(a r0, Consumer r1, Object r2) {
            r0.a(r1, r2);
        }

        a<E> a(com.google.common.base.o<? super E> r3) {
            com.google.common.base.o r4 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
            return new a(this.f4695a, Predicates.a(this.f4696b, r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E r2) {
            com.google.common.base.n.a(this.f4696b.apply(r2));
            return this.f4695a.add(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> r4) {
            Collection<? extends E> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
            Iterator<E> r0 = r5.iterator();
        L4:
            if (r0.hasNext() == false) goto L7;
            E r1 = r0.next();
            com.google.common.base.n.a(this.f4696b.apply(r1));
            goto L4
        L7:
            return this.f4695a.addAll(r5);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            aj.a(this.f4695a, this.f4696b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object r2) {
            if (q.a(this.f4695a, r2) == true) goto L5;
            return false;
        L5:
            return this.f4696b.apply(r2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> r3) {
            return q.a(this, (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            this.f4695a.forEach(new $$Lambda$q$a$pMDNzwiLHCj0P736QNKD2yF9Fnc(this, r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !aj.c(this.f4695a, this.f4696b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.b(this.f4695a.iterator(), this.f4696b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object r2) {
            if (contains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f4695a.remove(r2) == false) goto L7;
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> r3) {
            final Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4);
            return removeIf(new $$Lambda$Fb0KmdJJU5UGx2bm9gCsE5q550(r4));
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> r3) {
            final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            return this.f4695a.removeIf(new $$Lambda$q$a$mdBNX3cSaawUkxW1RigpYccp8(this, r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> r3) {
            final Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
            return removeIf(new $$Lambda$q$a$I9CFCzogSYbb629P1noKXlVF4Y(r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> r0 = this.f4695a.iterator();
            int r1 = 0;
        L4:
            if (r0.hasNext() == false) goto L8;
            E r2 = r0.next();
            if (this.f4696b.apply(r2) == false) goto L4;
            r1 = r1 + 1;
            goto L4
        L8:
            return r1;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return p.a(this.f4695a.spliterator(), this.f4696b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.a(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] r1) {
            return (T[]) Lists.a(iterator()).toArray(r1);
        }
    }

    static String a(Collection<?> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = a(r5.size()).append('[');
        Iterator r1 = r5.iterator();
        boolean r2 = true;
    L4:
        if (r1.hasNext() == false) goto L13;
        Object r3 = r1.next();
        if (r2 == true) goto L8;
        r0.append(", ");
    L8:
        r2 = false;
        if (r3 == r5) goto L10;
        r0.append(r3);
        goto L4
    L10:
        r0.append("(this Collection)");
        goto L4
    L13:
        return r0.append(']').toString();
    }

    static StringBuilder a(int r5) {
        o.a(r5, "size");
        return new StringBuilder((int) Math.min(((long) r5) * 8, ProcInfo.GB));
    }

    public static <E> Collection<E> a(Collection<E> r3, com.google.common.base.o<? super E> r4) {
        Collection r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.o<? super E> r6 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L7;
        return ((a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin")).a(r6);
    L7:
        return new a((Collection) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Collection.class, "com.obric.memorydata.plugin"), (com.google.common.base.o) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.o.class, "com.obric.memorydata.plugin"));
    }

    static boolean a(Collection<?> r2, Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return r4.contains(r3);
    L5:
        return false;
    }

    static boolean a(Collection<?> r2, Collection<?> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r4.contains(r5.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    static boolean b(Collection<?> r2, Object r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        return r4.remove(r3);
    L5:
        return false;
    }
}
