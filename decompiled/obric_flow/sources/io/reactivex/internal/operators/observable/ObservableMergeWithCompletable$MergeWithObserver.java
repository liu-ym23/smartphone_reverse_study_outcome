package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableMergeWithCompletable$MergeWithObserver<T> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = -4592979584110982903L;
    final mt.u downstream;
    final AtomicThrowable error;
    final AtomicReference<Disposable> mainDisposable;
    volatile boolean mainDone;
    volatile boolean otherDone;
    final OtherObserver otherObserver;

    public static final class OtherObserver extends AtomicReference<Disposable> implements mt.b {
        private static final long serialVersionUID = -2935427570954647017L;
        final ObservableMergeWithCompletable$MergeWithObserver<?> parent;

        public OtherObserver(ObservableMergeWithCompletable$MergeWithObserver<?> r5) {
            this.parent = r5;
        }

        @Override // mt.b
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // mt.b
        public void onError(Throwable r5) {
            this.parent.otherError(r5);
        }

        @Override // mt.b
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public ObservableMergeWithCompletable$MergeWithObserver(mt.u r5) {
        this.downstream = r5;
        this.mainDisposable = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.mainDisposable);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.mainDisposable.get());
    }

    @Override // mt.u
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
        return;
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.mainDisposable);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onNext(T r5) {
        com.lynx.tasm.behavior.ui.utils.p.y(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.mainDisposable, r5);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
        return;
    }

    public void otherError(Throwable r5) {
        DisposableHelper.dispose(this.mainDisposable);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }
}
