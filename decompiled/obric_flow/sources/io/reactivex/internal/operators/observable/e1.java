package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 extends mt.n implements rt.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e1 f17766a = null;

    static {
        f17766a = new e1();
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return null;
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r5) {
        EmptyDisposable.complete(r5);
    }
}
