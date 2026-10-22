package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import mt.z;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableDelay$Delay extends AtomicReference<Disposable> implements b, Runnable, Disposable {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final b downstream;
    Throwable error;
    final z scheduler;
    final TimeUnit unit;

    public CompletableDelay$Delay(b r5, long r10, TimeUnit r11, z r12, boolean r13) {
        this.downstream = r5;
        this.delay = r10;
        this.unit = r11;
        this.scheduler = r12;
        this.delayError = r13;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        this.error = r5;
        z r10 = this.scheduler;
        if (this.delayError == false) goto L5;
        long r11 = this.delay;
    L6:
        DisposableHelper.replace(this, r10.d(this, r11, this.unit));
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        if (DisposableHelper.setOnce(this, r5) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r5 = this.error;
        this.error = null;
        if (r5 == null) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        this.downstream.onComplete();
    }
}
