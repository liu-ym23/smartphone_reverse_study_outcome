package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class CompletableTakeUntilCompletable$TakeUntilMainObserver extends AtomicReference<b> implements xb.b, b {
    private static final long serialVersionUID = 3533011714830024923L;
    final xb.b downstream;
    final AtomicBoolean once;
    final OtherObserver other;

    static final class OtherObserver extends AtomicReference<b> implements xb.b {
        private static final long serialVersionUID = 5176264485428790318L;
        final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

        OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver r10) {
            this.parent = r10;
        }

        @Override // xb.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.parent.innerError(r10);
        }

        @Override // xb.b
        public void onSubscribe(b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    CompletableTakeUntilCompletable$TakeUntilMainObserver(xb.b r10) {
        this.downstream = r10;
        this.other = new OtherObserver(this);
        this.once = new AtomicBoolean();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        return;
    }

    void innerComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    }

    void innerError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this);
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.once.get();
    }

    @Override // xb.b
    public void onComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
        return;
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.b
    public void onSubscribe(b r10) {
        DisposableHelper.setOnce(this, r10);
    }
}
