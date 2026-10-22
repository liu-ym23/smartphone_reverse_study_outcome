package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableMergeWithCompletable$MergeWithSubscriber<T> extends AtomicInteger implements xb.g<T>, tc.d {
    private static final long serialVersionUID = -4592979584110982903L;
    final tc.c<? super T> downstream;
    final AtomicThrowable error;
    volatile boolean mainDone;
    final AtomicReference<tc.d> mainSubscription;
    volatile boolean otherDone;
    final OtherObserver otherObserver;
    final AtomicLong requested;

    static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xb.b {
        private static final long serialVersionUID = -2935427570954647017L;
        final FlowableMergeWithCompletable$MergeWithSubscriber<?> parent;

        OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber<?> r10) {
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

    FlowableMergeWithCompletable$MergeWithSubscriber(tc.c<? super T> r10) {
        this.downstream = r10;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // tc.d
    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // tc.c
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        io.reactivex.internal.util.e.a(this.downstream, this, this.error);
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        SubscriptionHelper.cancel(this.mainSubscription);
        io.reactivex.internal.util.e.c(this.downstream, r10, this, this.error);
    }

    @Override // tc.c
    public void onNext(T r10) {
        io.reactivex.internal.util.e.e(this.downstream, r10, this, this.error);
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, r10);
    }

    void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        io.reactivex.internal.util.e.a(this.downstream, this, this.error);
        return;
    }

    void otherError(Throwable r10) {
        SubscriptionHelper.cancel(this.mainSubscription);
        io.reactivex.internal.util.e.c(this.downstream, r10, this, this.error);
    }

    @Override // tc.d
    public void request(long r10) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, r10);
    }
}
