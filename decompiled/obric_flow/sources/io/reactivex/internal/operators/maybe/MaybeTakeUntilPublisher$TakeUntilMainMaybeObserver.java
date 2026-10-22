package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import mt.g;
import mt.j;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements j, Disposable {
    private static final long serialVersionUID = -2187421758664251153L;
    final j downstream;
    final TakeUntilOtherMaybeObserver<U> other;

    public static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<zu.d> implements g {
        private static final long serialVersionUID = -1266041316834525931L;
        final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> parent;

        public TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver<?, U> r5) {
            this.parent = r5;
        }

        @Override // zu.c
        public void onComplete() {
            this.parent.otherComplete();
        }

        @Override // zu.c
        public void onError(Throwable r5) {
            this.parent.otherError(r5);
        }

        @Override // zu.c
        public void onNext(Object r5) {
            SubscriptionHelper.cancel(this);
            this.parent.otherComplete();
        }

        @Override // zu.c
        public void onSubscribe(zu.d r5) {
            SubscriptionHelper.setOnce(this, r5, Long.MAX_VALUE);
        }
    }

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver(j r5) {
        this.downstream = r5;
        this.other = new TakeUntilOtherMaybeObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
        SubscriptionHelper.cancel(this.other);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // mt.j
    public void onComplete() {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r5 = DisposableHelper.DISPOSED;
        if (getAndSet(r5) == r5) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // mt.j
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }

    @Override // mt.j
    public void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this, r5);
    }

    @Override // mt.j
    public void onSuccess(T r5) {
        SubscriptionHelper.cancel(this.other);
        DisposableHelper r10 = DisposableHelper.DISPOSED;
        if (getAndSet(r10) == r10) goto L6;
        this.downstream.onSuccess(r5);
        return;
    }

    public void otherComplete() {
        if (DisposableHelper.dispose(this) == false) goto L6;
        this.downstream.onComplete();
        return;
    }

    public void otherError(Throwable r5) {
        if (DisposableHelper.dispose(this) == false) goto L5;
        this.downstream.onError(r5);
        return;
    L5:
        f.k(r5);
    }
}
