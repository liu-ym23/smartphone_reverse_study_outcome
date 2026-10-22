package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableUnsubscribeOn$UnsubscribeObserver<T> extends AtomicBoolean implements mt.u, Disposable {
    private static final long serialVersionUID = 1015244841293359600L;
    final mt.u downstream;
    final mt.z scheduler;
    Disposable upstream;

    public ObservableUnsubscribeOn$UnsubscribeObserver(mt.u r5, mt.z r10) {
        this.downstream = r5;
        this.scheduler = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (compareAndSet(false, true) == false) goto L6;
        this.scheduler.c(new k4(this, 0));
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return get();
    }

    @Override // mt.u
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        if (get() == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.downstream.onError(r5);
    }

    @Override // mt.u
    public void onNext(T r5) {
        if (get() == true) goto L6;
        this.downstream.onNext(r5);
        return;
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.upstream, r5) == false) goto L6;
        this.upstream = r5;
        this.downstream.onSubscribe(this);
        return;
    }
}
