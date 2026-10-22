package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class ObservableTakeUntil$TakeUntilMainObserver<T, U> extends AtomicInteger implements mt.u, Disposable {
    private static final long serialVersionUID = 1418547743690811973L;
    final mt.u downstream;
    final AtomicThrowable error;
    final ObservableTakeUntil$TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
    final AtomicReference<Disposable> upstream;

    public final class OtherObserver extends AtomicReference<Disposable> implements mt.u {
        private static final long serialVersionUID = -8693423678067375039L;
        final /* synthetic */ ObservableTakeUntil$TakeUntilMainObserver this$0;

        public OtherObserver(ObservableTakeUntil$TakeUntilMainObserver r5) {
            this.this$0 = r5;
        }

        @Override // mt.u
        public void onComplete() {
            this.this$0.otherComplete();
        }

        @Override // mt.u
        public void onError(Throwable r5) {
            this.this$0.otherError(r5);
        }

        @Override // mt.u
        public void onNext(U r5) {
            DisposableHelper.dispose(this);
            this.this$0.otherComplete();
        }

        @Override // mt.u
        public void onSubscribe(Disposable r5) {
            DisposableHelper.setOnce(this, r5);
        }
    }

    public ObservableTakeUntil$TakeUntilMainObserver(mt.u r5) {
        this.downstream = r5;
        this.upstream = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // mt.u
    public void onComplete() {
        DisposableHelper.dispose(this.otherObserver);
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
    }

    @Override // mt.u
    public void onError(Throwable r5) {
        DisposableHelper.dispose(this.otherObserver);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onNext(T r5) {
        com.lynx.tasm.behavior.ui.utils.p.y(this.downstream, r5, this, this.error);
    }

    @Override // mt.u
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.upstream, r5);
    }

    public void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        com.lynx.tasm.behavior.ui.utils.p.u(this.downstream, this, this.error);
    }

    public void otherError(Throwable r5) {
        DisposableHelper.dispose(this.upstream);
        com.lynx.tasm.behavior.ui.utils.p.w(this.downstream, r5, this, this.error);
    }
}
