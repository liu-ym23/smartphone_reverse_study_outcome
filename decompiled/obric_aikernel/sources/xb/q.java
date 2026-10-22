package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q<T> implements s<T> {
    public q() {
    }

    @Override // xb.s
    public final void a(r<? super T> r10) {
        io.reactivex.internal.functions.a.d(r10, "subscriber is null");
        r<? super T> r11 = dc.a.u(this, r10);
        io.reactivex.internal.functions.a.d(r11, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        b(r11);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        NullPointerException r12 = new NullPointerException("subscribeActual failed");
        r12.initCause(th);
        throw r12;
    }

    protected abstract void b(r<? super T> r10);
}
