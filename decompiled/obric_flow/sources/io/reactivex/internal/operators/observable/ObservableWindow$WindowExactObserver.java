package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements mt.u, Disposable, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final mt.u downstream;
    long size;
    Disposable upstream;
    io.reactivex.subjects.i window;

    public ObservableWindow$WindowExactObserver(mt.u r5, long r10, int r11) {
        this.downstream = r5;
        this.count = r10;
        this.capacityHint = r11;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.cancelled = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // mt.u
    public void onComplete() {
        io.reactivex.subjects.i r5 = this.window;
        if (r5 == null) goto L5;
        this.window = null;
        r5.onComplete();
    L5:
        this.downstream.onComplete();
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        io.reactivex.subjects.i r10 = this.window;
        if (r10 == null) goto L5;
        this.window = null;
        r10.onError(r5);
    L5:
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r10) {
        io.reactivex.subjects.i r5 = this.window;
        if (r5 == null) goto L5;
    L7:
        if (r5 == null) goto L14;
        r5.onNext(r10);
        long r11 = this.size + 1;
        this.size = r11;
        if (r11 < this.count) goto L15;
        this.size = 0;
        this.window = null;
        r5.onComplete();
        if (this.cancelled == false) goto L16;
        this.upstream.dispose();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        if (this.cancelled == true) goto L7;
        io.reactivex.subjects.i r12 = new io.reactivex.subjects.i(this, this.capacityHint);
        this.window = r12;
        this.downstream.onNext(r12);
        r5 = r12;
        goto L7
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cancelled == false) goto L6;
        this.upstream.dispose();
        return;
    }
}
