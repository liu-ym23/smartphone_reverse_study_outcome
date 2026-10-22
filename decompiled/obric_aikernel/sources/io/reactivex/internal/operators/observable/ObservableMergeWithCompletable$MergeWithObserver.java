package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableMergeWithCompletable$MergeWithObserver<T> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4592979584110982903L;
    final xb.o<? super T> downstream;
    final AtomicThrowable error;
    final AtomicReference<io.reactivex.disposables.b> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final OtherObserver otherObserver;

    static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.b {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithCompletable$MergeWithObserver<?> parent;

        OtherObserver(ObservableMergeWithCompletable$MergeWithObserver<?> r10) {
            this.parent = r10;
        }

        @Override // xb.b
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // xb.b
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // xb.b
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    ObservableMergeWithCompletable$MergeWithObserver(xb.o<? super T> r10) {
        this.downstream = r10;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // xb.o
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
        return;
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.mainDisposable);
        io.reactivex.internal.util.e.d(this.downstream, r10, this, this.error);
    }

    @Override // xb.o
    public void onNext(T r10) {
        io.reactivex.internal.util.e.f(this.downstream, r10, this, this.error);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.mainDisposable, r10);
    }

    void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
        return;
    }

    void otherError(Throwable r10) {
        DisposableHelper.dispose(this.mainDisposable);
        io.reactivex.internal.util.e.d(this.downstream, r10, this, this.error);
    }
}
