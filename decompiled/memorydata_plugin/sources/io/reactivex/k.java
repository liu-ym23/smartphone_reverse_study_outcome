package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class k<T> implements o<T> {
    public k() {
    }

    @Override // io.reactivex.o
    public final void a(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "observer is null");
        m<? super T> r5 = io.reactivex.d.a.a(this, r4);
        io.reactivex.internal.functions.a.a(r5, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        b(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        NullPointerException r6 = new NullPointerException("subscribeActual failed");
        r6.initCause(th);
        throw r6;
    }

    public abstract void b(m<? super T> r1);
}
