package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements e {
    public a() {
    }

    private static NullPointerException a(Throwable r2) {
        NullPointerException r0 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r0.initCause(r2);
        return r0;
    }

    @Override // io.reactivex.e
    public final void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "observer is null");
        c r5 = io.reactivex.d.a.a(this, r4);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.a(r5, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        b(r5);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        throw a(th);
    }

    public abstract void b(c r1);
}
