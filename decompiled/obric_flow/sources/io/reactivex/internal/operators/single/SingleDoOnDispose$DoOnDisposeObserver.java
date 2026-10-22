package io.reactivex.internal.operators.single;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.b0;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<pt.a> implements b0, Disposable {
    private static final long serialVersionUID = -8583764624474935784L;
    final b0 downstream;
    Disposable upstream;

    public SingleDoOnDispose$DoOnDisposeObserver(b0 r5, pt.a r10) {
        this.downstream = r5;
        lazySet(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        pt.a r5 = getAndSet(null);
        if (r5 == null) goto L12;
        r5.run();     // Catch: Throwable -> L6
    L8:
        this.upstream.dispose();
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
        goto L8
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.b0, mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.b0, mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.b0, mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }
}
