package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public final class aj {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.aj$1, reason: invalid class name */
    class AnonymousClass1<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f4656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.o f4657b;

        AnonymousClass1(Iterable r3, com.google.common.base.o r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            com.google.common.base.o r6 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.o.class, "com.obric.memorydata.plugin");
            this.f4656a = r5;
            this.f4657b = r6;
        }

        private static /* synthetic */ void a(com.google.common.base.o r2, Consumer r3, Object r4) {
            com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r2, com.google.common.base.o.class, "com.obric.memorydata.plugin");
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            if (r5.test(r4) == false) goto L6;
            r6.accept(r4);
            return;
        }

        /* JADX INFO: renamed from: lambda$mRfA6Y-i4Xv_GsEK_E-IhnEJ8P8, reason: not valid java name */
        public static /* synthetic */ void m130lambda$mRfA6Yi4Xv_GsEK_EIhnEJ8P8(com.google.common.base.o r0, Consumer r1, Object r2) {
            a(r0, r1, r2);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            Iterable r0 = this.f4656a;
            final com.google.common.base.o r2 = this.f4657b;
            r0.forEach(new $$Lambda$aj$1$mRfA6Yi4Xv_GsEK_EIhnEJ8P8(r2, r4));
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.b(this.f4656a.iterator(), this.f4657b);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return p.a(this.f4656a.spliterator(), this.f4657b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.collect.aj$2, reason: invalid class name */
    class AnonymousClass2<T> extends u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f4658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.g f4659b;

        AnonymousClass2(Iterable r3, com.google.common.base.g r4) {
            Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            com.google.common.base.g r6 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.g.class, "com.obric.memorydata.plugin");
            this.f4658a = r5;
            this.f4659b = r6;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static /* synthetic */ void a(Consumer r2, com.google.common.base.g r3, Object r4) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin")).apply(r4));
        }

        public static /* synthetic */ void lambda$h3peQr3_Uf7pfBWTgvQxw2_Uf7o(Consumer r0, com.google.common.base.g r1, Object r2) {
            a(r0, r1, r2);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super T> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            Iterable r0 = this.f4658a;
            final com.google.common.base.g r2 = this.f4659b;
            r0.forEach(new $$Lambda$aj$2$h3peQr3_Uf7pfBWTgvQxw2_Uf7o(r4, r2));
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.a(this.f4658a.iterator(), this.f4659b);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return p.a(this.f4658a.spliterator(), this.f4659b);
        }
    }

    public static <T> Iterable<T> a(Iterable<T> r2, final int r3) {
        final Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        com.google.common.base.n.a(r0, "number to skip cannot be negative");
        return new AnonymousClass3(r4, r3);
    L5:
        r0 = false;
        goto L6
    }

    public static <F, T> Iterable<T> a(Iterable<F> r2, com.google.common.base.g<? super F, ? extends T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.g r5 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new AnonymousClass2(r4, r5);
    }

    public static <T> Iterable<T> a(Iterable<? extends T> r2, Iterable<? extends T> r3) {
        return u.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static <T> T a(Iterable<? extends T> r2, T r3) {
        return (T) Iterators.b(((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator(), r3);
    }

    private static <T> T a(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        return (T) r3.get(r3.size() - 1);
    }

    public static String a(Iterable<?> r2) {
        return Iterators.c(((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    public static <T> boolean a(Iterable<T> r2, com.google.common.base.o<? super T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L7;
        return ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).removeIf(r5);
    L7:
        return Iterators.a(r4.iterator(), r5);
    }

    public static <T> boolean a(Collection<T> r2, Iterable<? extends T> r3) {
        Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r2, Collection.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == false) goto L7;
        return r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin"));
    L7:
        return Iterators.a(r4, ((Iterable) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    static <T> T[] a(Iterable<? extends T> r2, T[] r3) {
        return (T[]) f((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).toArray(r3);
    }

    public static <T> Iterable<T> b(Iterable<T> r2, com.google.common.base.o<? super T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new AnonymousClass1(r4, r5);
    }

    public static <T> T b(Iterable<T> r2) {
        return (T) Iterators.d(((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator());
    }

    public static <T> boolean c(Iterable<T> r2, com.google.common.base.o<? super T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.o r5 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        return Iterators.c(r4.iterator(), r5);
    }

    static Object[] c(Iterable<?> r2) {
        return f((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin")).toArray();
    }

    public static <T> T d(Iterable<T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, List.class) == false) goto L11;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == true) goto L9;
        return (T) a(r4);
    L9:
        throw new NoSuchElementException();
    L11:
        return (T) Iterators.f(r3.iterator());
    }

    public static boolean e(Iterable<?> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L7;
        return ((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L7:
        return !r3.iterator().hasNext();
    }

    private static <E> Collection<E> f(Iterable<E> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == false) goto L6;
        return (Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin");
    L6:
        return Lists.a(r3.iterator());
    }
}
