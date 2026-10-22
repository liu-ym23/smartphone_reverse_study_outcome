package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
final class FlowableMergeWithCompletable$MergeWithSubscriber<T> extends AtomicInteger implements mt.g, zu.d {
    private static final long serialVersionUID = -4592979584110982903L;
    final zu.c downstream;
    final AtomicThrowable error;
    volatile boolean mainDone;
    final AtomicReference<zu.d> mainSubscription;
    volatile boolean otherDone;
    final OtherObserver otherObserver;
    final AtomicLong requested;

    public static final class OtherObserver extends AtomicReference<Disposable> implements mt.b {
        private static final long serialVersionUID = -2935427570954647017L;
        final FlowableMergeWithCompletable$MergeWithSubscriber<?> parent;

        public OtherObserver(FlowableMergeWithCompletable$MergeWithSubscriber<?> r5) {
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

    public FlowableMergeWithCompletable$MergeWithSubscriber(zu.c r5) {
        this.downstream = r5;
        this.mainSubscription = new AtomicReference();
        this.otherObserver = new OtherObserver(this);
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
    }

    @Override // zu.d
    public void cancel() {
        SubscriptionHelper.cancel(this.mainSubscription);
        DisposableHelper.dispose(this.otherObserver);
    }

    @Override // zu.c
    public void onComplete() {
        this.mainDone = true;
        if (this.otherDone == false) goto L6;
        com.lynx.tasm.behavior.ui.utils.p.v(this.downstream, this, this.error);
        return;
    }

    @Override // zu.c
    public void onError(Throwable r5) {
        SubscriptionHelper.cancel(this.mainSubscription);
        com.lynx.tasm.behavior.ui.utils.p.x(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onNext(T r5) {
        com.lynx.tasm.behavior.ui.utils.p.z(this.downstream, r5, this, this.error);
    }

    @Override // zu.c
    public void onSubscribe(zu.d r5) {
        SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, r5);
    }

    public void otherComplete() {
        this.otherDone = true;
        if (this.mainDone == false) goto L6;
        com.lynx.tasm.behavior.ui.utils.p.v(this.downstream, this, this.error);
        return;
    }

    public void otherError(Throwable r5) {
        SubscriptionHelper.cancel(this.mainSubscription);
        com.lynx.tasm.behavior.ui.utils.p.x(this.downstream, r5, this, this.error);
    }

    @Override // zu.d
    public void request(long r5) {
        SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, r5);
    }
}
