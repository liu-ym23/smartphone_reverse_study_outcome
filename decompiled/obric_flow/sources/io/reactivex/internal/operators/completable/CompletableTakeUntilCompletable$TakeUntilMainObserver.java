package io.reactivex.internal.operators.completable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mt.b;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class CompletableTakeUntilCompletable$TakeUntilMainObserver extends AtomicReference<Disposable> implements b, Disposable {
    private static final long serialVersionUID = 3533011714830024923L;
    final b downstream;
    final AtomicBoolean once;
    final OtherObserver other;

    public static final class OtherObserver extends AtomicReference<Disposable> implements b {
        private static final long serialVersionUID = 5176264485428790318L;
        final CompletableTakeUntilCompletable$TakeUntilMainObserver parent;

        public OtherObserver(CompletableTakeUntilCompletable$TakeUntilMainObserver r5) {
            this.parent = r5;
        }

        @Override // mt.b
        public void onComplete() {
            this.parent.innerComplete();
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.parent.innerError(r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public CompletableTakeUntilCompletable$TakeUntilMainObserver(b r5) {
        this.downstream = r5;
        this.other = new OtherObserver(this);
        this.once = new AtomicBoolean();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        DisposableHelper.dispose(this.other);
        return;
    }

    public void innerComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
        return;
    }

    public void innerError(Throwable r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this);
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.once.get();
    }

    @Override // mt.b
    public void onComplete() {
        if (this.once.compareAndSet(false, true) == false) goto L6;
        DisposableHelper.dispose(this.other);
        this.downstream.onComplete();
        return;
    }

    @Override // mt.b
    public void onError(Throwable r5) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        DisposableHelper.dispose(this.other);
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // mt.b
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }
}
