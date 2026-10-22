package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import mt.b;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableDoFinally$DoFinallyObserver extends AtomicInteger implements b, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final b downstream;
    final pt.a onFinally;
    Disposable upstream;

    public CompletableDoFinally$DoFinallyObserver(b r5, pt.a r10) {
        this.downstream = r5;
        this.onFinally = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
        runFinally();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // mt.b
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
        runFinally();
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    public void runFinally() {
        if (compareAndSet(0, 1) == false) goto L11;
        this.onFinally.run();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        com.lynx.jsbridge.a.t(th);
        f.k(th);
        return;
    }
}
