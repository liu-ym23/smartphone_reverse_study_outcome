package io.reactivex.internal.operators.flowable;

import com.lynx.tasm.behavior.v0;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
abstract class FlowableCreate$BaseEmitter<T> extends AtomicLong implements mt.f, zu.d {
    private static final long serialVersionUID = 7326289992464377023L;
    final zu.c downstream;
    final SequentialDisposable serial;

    public FlowableCreate$BaseEmitter(zu.c r5) {
        this.downstream = r5;
        this.serial = new SequentialDisposable();
    }

    @Override // zu.d
    public final void cancel() {
        this.serial.dispose();
        onUnsubscribed();
    }

    public void complete() {
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

    public boolean error(Throwable r5) {
        if (r5 != null) goto L5;
        r5 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L5:
        if (isCancelled() == false) goto L14;
        return false;
    L14:
        this.downstream.onError(r5);     // Catch: Throwable -> L11
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

    @Override // mt.d
    public void onComplete() {
        complete();
    }

    @Override // mt.d
    public final void onError(Throwable r5) {
        if (tryOnError(r5) == true) goto L6;
        wn.f.k(r5);
        return;
    }

    @Override // mt.d
    public abstract /* synthetic */ void onNext(Object r5);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // zu.d
    public final void request(long r5) {
        if (SubscriptionHelper.validate(r5) == false) goto L6;
        v0.r(this, r5);
        onRequested();
        return;
    }

    public final long requested() {
        return get();
    }

    public final mt.f serialize() {
        return new FlowableCreate$SerializedEmitter(this);
    }

    public final void setCancellable(pt.f r5) {
        setDisposable(new CancellableDisposable(r5));
    }

    public final void setDisposable(Disposable r5) {
        this.serial.update(r5);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public String toString() {
        return androidx.room.jarjarred.org.antlr.runtime.a.q(getClass().getSimpleName(), "{", super.toString(), "}");
    }

    public boolean tryOnError(Throwable r5) {
        return error(r5);
    }
}
