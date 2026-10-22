package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xb.p;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableDelay$Delay extends AtomicReference<b> implements xb.b, Runnable, b {
    private static final long serialVersionUID = 465972761105851022L;
    final long delay;
    final boolean delayError;
    final xb.b downstream;
    Throwable error;
    final p scheduler;
    final TimeUnit unit;

    CompletableDelay$Delay(xb.b r10, long r11, TimeUnit r12, p r13, boolean r14) {
        this.downstream = r10;
        this.delay = r11;
        this.unit = r12;
        this.scheduler = r13;
        this.delayError = r14;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.d(this, this.delay, this.unit));
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        this.error = r10;
        p r11 = this.scheduler;
        if (this.delayError == false) goto L5;
        long r12 = this.delay;
    L6:
        DisposableHelper.replace(this, r11.d(this, r12, this.unit));
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable r10 = this.error;
        this.error = null;
        xb.b r11 = this.downstream;
        if (r10 == null) goto L5;
        r11.onError(r10);
        return;
    L5:
        r11.onComplete();
    }
}
