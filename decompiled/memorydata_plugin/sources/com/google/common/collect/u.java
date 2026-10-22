package com.google.common.collect;

import com.google.common.base.Optional;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Optional<Iterable<E>> f4703a;

    public u() {
        this.f4703a = Optional.absent();
    }

    u(Iterable<E> r3) {
        this.f4703a = Optional.of((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
    }

    public static <E> u<E> a(Iterable<E> r3) {
        final Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, u.class) == false) goto L6;
        return (u) ZeusTransformUtils.preCheckCast(r4, u.class, "com.obric.memorydata.plugin");
    L6:
        return new AnonymousClass1(r4, r4);
    }

    public static <T> u<T> a(Iterable<? extends T> r2, Iterable<? extends T> r3) {
        return a(new Iterable[]{(Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin")});
    }

    private static <T> u<T> a(final Iterable<? extends T>... r3) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        com.google.common.base.n.a(r3[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return new AnonymousClass2(r3);
    }

    private Iterable<E> b() {
        return (Iterable) ZeusTransformUtils.preCheckCast(this.f4703a.or(this), Iterable.class, "com.obric.memorydata.plugin");
    }

    public final ImmutableSet<E> a() {
        return ImmutableSet.copyOf(b());
    }

    public final u<E> a(com.google.common.base.o<? super E> r3) {
        com.google.common.base.o r4 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.o.class, "com.obric.memorydata.plugin");
        return a(aj.b(b(), r4));
    }

    public String toString() {
        return aj.a(b());
    }
}
