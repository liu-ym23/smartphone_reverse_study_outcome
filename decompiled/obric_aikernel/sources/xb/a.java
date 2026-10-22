package xb;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements c {
    public a() {
    }

    private static NullPointerException c(Throwable r10) {
        NullPointerException r11 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r11.initCause(r10);
        return r11;
    }

    @Override // xb.c
    public final void a(b r10) {
        io.reactivex.internal.functions.a.d(r10, "s is null");
        b r11 = dc.a.r(this, r10);     // Catch: Throwable -> L5 NullPointerException -> L8
        io.reactivex.internal.functions.a.d(r11, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        b(r11);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        throw c(th);
    }

    protected abstract void b(b r10);
}
