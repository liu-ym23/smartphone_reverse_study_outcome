package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import xb.g;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements j<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -2187421758664251153L;
    final j<? super T> downstream;
    final TakeUntilOtherMaybeObserver<U> other;

    static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<tc.d> implements g<U> {
        private static final long serialVersionUID = -1266041316834525931L;
        final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> parent;

        TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> r10) {
            this.parent = r10;
        }

        @Override // tc.c
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // tc.c
        public void onError(Throwable r10) {
            this.parent.otherError(r10);
        }

        @Override // tc.c
        public void onNext(Object r10) {
            SubscriptionHelper.cancel(this);
            this.parent.otherComplete();
        }

        @Override // xb.g, tc.c
        public void onSubscribe(tc.d r10) {
            SubscriptionHelper.setOnce(this, r10, Long.MAX_VALUE);
        }
    }

    MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(j<? super T> r10) {
        this.downstream = r10;
        this.other = new TakeUntilOtherMaybeObserver(this);
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // xb.j
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this, r10);
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r11 = DisposableHelper.DISPOSED;
        if (getAndSet(r11) == r11) goto L6;
        this.downstream.onSuccess(r10);
        return;
    }

    void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.downstream.onComplete();
        return;
    }

    void otherError(Throwable r10) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r10);
        return;
    L5:
        dc.a.n(r10);
    }
}
