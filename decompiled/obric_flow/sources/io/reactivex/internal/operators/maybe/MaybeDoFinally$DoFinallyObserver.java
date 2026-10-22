package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import mt.j;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeDoFinally$DoFinallyObserver<T> extends AtomicInteger implements j, Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final j downstream;
    final pt.a onFinally;
    Disposable upstream;

    public MaybeDoFinally$DoFinallyObserver(j r5, pt.a r10) {
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

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
        runFinally();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
        runFinally();
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
        runFinally();
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
