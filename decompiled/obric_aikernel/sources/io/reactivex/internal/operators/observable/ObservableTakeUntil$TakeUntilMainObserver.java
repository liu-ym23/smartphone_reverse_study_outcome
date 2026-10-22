package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class ObservableTakeUntil$TakeUntilMainObserver<T, U> extends AtomicInteger implements xb.o<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = 1418547743690811973L;
    final xb.o<? super T> downstream;
    final AtomicThrowable error;
    final ObservableTakeUntil$TakeUntilMainObserver<T, U>.OtherObserver otherObserver;
    final AtomicReference<io.reactivex.disposables.b> upstream;

    final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.o<U> {
        private static final long serialVersionUID = -8693423678067375039L;
        final /* synthetic */ ObservableTakeUntil$TakeUntilMainObserver this$0;

        OtherObserver(ObservableTakeUntil$TakeUntilMainObserver r10) {
            this.this$0 = r10;
        }

        @Override // xb.o
        public void onComplete() {
            this.this$0.otherComplete();
        }

        @Override // xb.o
        public void onError(Throwable r10) {
            this.this$0.otherError(r10);
        }

        @Override // xb.o
        public void onNext(U r10) {
            DisposableHelper.dispose(this);
            this.this$0.otherComplete();
        }

        @Override // xb.o
        public void onSubscribe(io.reactivex.disposables.b r10) {
            DisposableHelper.setOnce(this, r10);
        }
    }

    ObservableTakeUntil$TakeUntilMainObserver(xb.o<? super T> r10) {
        this.downstream = r10;
        this.upstream = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.upstream.get());
    }

    @Override // xb.o
    public void onComplete() {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        DisposableHelper.dispose(this.otherObserver);
        io.reactivex.internal.util.e.d(this.downstream, r10, this, this.error);
    }

    @Override // xb.o
    public void onNext(T r10) {
        io.reactivex.internal.util.e.f(this.downstream, r10, this, this.error);
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.upstream, r10);
    }

    void otherComplete() {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.e.b(this.downstream, this, this.error);
    }

    void otherError(Throwable r10) {
        DisposableHelper.dispose(this.upstream);
        io.reactivex.internal.util.e.d(this.downstream, r10, this, this.error);
    }
}
