package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscribers.StrictSubscriber;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g<T> implements org.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f16713a = 0;

    static {
        f16713a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
    }

    public g() {
    }

    public static int a() {
        return f16713a;
    }

    public final <R> g<R> a(io.reactivex.b.h<? super T, ? extends R> r3) {
        io.reactivex.b.h r4 = (io.reactivex.b.h) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.b.h.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "mapper is null");
        return io.reactivex.d.a.a(new io.reactivex.internal.operators.flowable.b(this, r4));
    }

    public final void a(j<? super T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "s is null");
        org.a.c<? super T> r5 = io.reactivex.d.a.a(this, r4);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.a(r5, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        a(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        NullPointerException r6 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
        r6.initCause(th);
        throw r6;
    }

    public abstract void a(org.a.c<? super T> r1);

    @Override // org.a.b
    public final void subscribe(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L5;
        a((j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.memorydata.plugin"));
        return;
    L5:
        io.reactivex.internal.functions.a.a(r4, "s is null");
        a(new StrictSubscriber(r4));
    }
}
