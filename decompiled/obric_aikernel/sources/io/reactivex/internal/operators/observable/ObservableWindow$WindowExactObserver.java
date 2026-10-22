package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableWindow$WindowExactObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b, Runnable {
    private static final long serialVersionUID = -7481782523886138128L;
    volatile boolean cancelled;
    final int capacityHint;
    final long count;
    final xb.o<? super Observable<T>> downstream;
    long size;
    io.reactivex.disposables.b upstream;
    UnicastSubject<T> window;

    ObservableWindow$WindowExactObserver(xb.o<? super Observable<T>> r10, long r11, int r12) {
        this.downstream = r10;
        this.count = r11;
        this.capacityHint = r12;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.cancelled = true;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // xb.o
    public void onComplete() {
        UnicastSubject<T> r10 = this.window;
        if (r10 == null) goto L5;
        this.window = null;
        r10.onComplete();
    L5:
        this.downstream.onComplete();
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        UnicastSubject<T> r11 = this.window;
        if (r11 == null) goto L5;
        this.window = null;
        r11.onError(r10);
    L5:
        this.downstream.onError(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        UnicastSubject<T> r11 = this.window;
        if (r11 == null) goto L5;
    L7:
        if (r11 == null) goto L14;
        r11.onNext(r10);
        long r12 = this.size + 1;
        this.size = r12;
        if (r12 < this.count) goto L15;
        this.size = 0;
        this.window = null;
        r11.onComplete();
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
        r11 = UnicastSubject.i(this.capacityHint, this);
        this.window = r11;
        this.downstream.onNext(r11);
        goto L7
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (DisposableHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
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
