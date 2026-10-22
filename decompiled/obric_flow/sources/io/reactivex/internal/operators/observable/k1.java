package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 extends mt.n implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f17838a;

    public k1(Callable r5) {
        this.f17838a = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Object r5 = this.f17838a.call();
        io.reactivex.internal.functions.e.d(r5, "The callable returned a null value");
        return r5;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        DeferredScalarDisposable r10 = new DeferredScalarDisposable(r5);
        r5.onSubscribe(r10);
        if (r10.isDisposed() == false) goto L14;
        return;
    L14:
        Object r11 = this.f17838a.call();     // Catch: Throwable -> L8
        io.reactivex.internal.functions.e.d(r11, "Callable returned null");     // Catch: Throwable -> L8
        r10.complete(r11);
        return;
    L8:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        if (r10.isDisposed() == true) goto L12;
        r5.onError(th);
        return;
    L12:
        wn.f.k(th);
    }
}
