package io.reactivex;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Observable<T> implements s<T> {
    public Observable() {
    }

    public static int a() {
        return g.a();
    }

    public abstract void a(t<? super T> r1);

    @Override // io.reactivex.s
    public final void subscribe(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        io.reactivex.internal.functions.a.a(r4, "observer is null");
        t<? super T> r5 = io.reactivex.d.a.a(this, r4);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.a(r5, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
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
}
