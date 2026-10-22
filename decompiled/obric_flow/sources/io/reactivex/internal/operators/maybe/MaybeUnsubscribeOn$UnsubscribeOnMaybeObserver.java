package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.j;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements j, Disposable, Runnable {
    private static final long serialVersionUID = 3256698449646456986L;
    final j downstream;

    /* JADX INFO: renamed from: ds, reason: collision with root package name */
    Disposable f17677ds;
    final z scheduler;

    public MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver(j r5, z r10) {
        this.downstream = r5;
        this.scheduler = r10;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper r5 = DisposableHelper.DISPOSED;
        Disposable r10 = getAndSet(r5);
        if (r10 == r5) goto L6;
        this.f17677ds = r10;
        this.scheduler.c(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        this.downstream.onComplete();
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        this.downstream.onError(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        this.downstream.onSuccess(r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f17677ds.dispose();
    }
}
