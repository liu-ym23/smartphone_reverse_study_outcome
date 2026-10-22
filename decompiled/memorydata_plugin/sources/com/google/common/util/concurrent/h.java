package com.google.common.util.concurrent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends j {
    public static l<Void> a() {
        return k.f4864a;
    }

    public static <I, O> l<O> a(l<I> r2, com.google.common.base.g<? super I, ? extends O> r3, Executor r4) {
        return c.a((l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.memorydata.plugin"), (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin"));
    }

    public static <V> l<V> a(V r1) {
        if (r1 != null) goto L6;
        return (l<V>) k.f4864a;
    L6:
        return new k(r1);
    }

    public static <V> l<V> a(Throwable r1) {
        com.google.common.base.n.a(r1);
        return new k.a(r1);
    }

    public static <V> V a(Future<V> r2) {
        Future r3 = (Future) ZeusTransformUtils.wrapperContextForParams(r2, Future.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.b(r3.isDone(), "Future was expected to be done: %s", r3);
        return (V) x.a(r3);
    }
}
