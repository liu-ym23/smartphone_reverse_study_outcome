package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleDoOnDispose$DoOnDisposeObserver<T> extends AtomicReference<zb.a> implements r<T>, b {
    private static final long serialVersionUID = -8583764624474935784L;
    final r<? super T> downstream;
    b upstream;

    SingleDoOnDispose$DoOnDisposeObserver(r<? super T> r10, zb.a r11) {
        this.downstream = r10;
        lazySet(r11);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        zb.a r10 = getAndSet(null);
        if (r10 == null) goto L12;
        r10.run();     // Catch: Throwable -> L6
    L8:
        this.upstream.dispose();
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        goto L8
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        this.downstream.onSuccess(r10);
    }
}
