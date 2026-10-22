package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements xb.f<T>, tc.d {
    private static final long serialVersionUID = 7326289992464377023L;
    final tc.c<? super T> downstream;
    final SequentialDisposable serial;

    FlowableCreate$BaseEmitter(tc.c<? super T> r10) {
        this.downstream = r10;
        this.serial = new SequentialDisposable();
    }

    @Override // tc.d
    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    protected void complete() {
        if (isCancelled() == false) goto L11;
        return;
    L11:
        this.downstream.onComplete();     // Catch: Throwable -> L8
        this.serial.dispose();
        return;
    L8:
        th = move-exception;
        this.serial.dispose();
        throw th;
    }

    protected boolean error(Throwable r10) {
        if (r10 != null) goto L5;
        r10 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L5:
        if (isCancelled() == false) goto L14;
        return false;
    L14:
        this.downstream.onError(r10);     // Catch: Throwable -> L11
        this.serial.dispose();
        return true;
    L11:
        th = move-exception;
        this.serial.dispose();
        throw th;
    }

    public final boolean isCancelled() {
        return this.serial.isDisposed();
    }

    @Override // xb.d
    public void onComplete() {
        complete();
    }

    @Override // xb.d
    public final void onError(Throwable r10) {
        if (tryOnError(r10) == true) goto L6;
        dc.a.n(r10);
        return;
    }

    @Override // xb.d
    public abstract /* synthetic */ void onNext(T r10);

    void onRequested() {
    }

    void onUnsubscribed() {
    }

    @Override // tc.d
    public final void request(long r10) {
        if (SubscriptionHelper.validate(r10) == false) goto L6;
        io.reactivex.internal.util.b.a(this, r10);
        onRequested();
        return;
    }

    public final long requested() {
        return get();
    }

    public final xb.f<T> serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(zb.f r10) {
        setDisposable(new CancellableDisposable(r10));
    }

    public final void setDisposable(io.reactivex.disposables.b r10) {
        this.serial.update(r10);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
    }

    public boolean tryOnError(Throwable r10) {
        return error(r10);
    }
}
