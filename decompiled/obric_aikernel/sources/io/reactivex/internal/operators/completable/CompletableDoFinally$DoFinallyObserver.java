package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableDoFinally$DoFinallyObserver extends AtomicInteger implements b, io.reactivex.disposables.b {
    private static final long serialVersionUID = 4109457741734051389L;
    final b downstream;
    final zb.a onFinally;
    io.reactivex.disposables.b upstream;

    CompletableDoFinally$DoFinallyObserver(b r10, zb.a r11) {
        this.downstream = r10;
        this.onFinally = r11;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // xb.b
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
    }

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        dc.a.n(th);
        return;
    }
}
