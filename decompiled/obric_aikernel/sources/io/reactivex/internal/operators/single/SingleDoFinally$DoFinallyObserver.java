package io.reactivex.internal.operators.single;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
final class SingleDoFinally$DoFinallyObserver<T> extends AtomicInteger implements r<T>, b {
    private static final long serialVersionUID = 4109457741734051389L;
    final r<? super T> downstream;
    final zb.a onFinally;
    b upstream;

    SingleDoFinally$DoFinallyObserver(r<? super T> r10, zb.a r11) {
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

    @Override // xb.r
    public void onError(Throwable r10) {
        this.downstream.onError(r10);
        runFinally();
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
        runFinally();
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
