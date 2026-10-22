package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class FlowableUnsubscribeOn$UnsubscribeSubscriber<T> extends AtomicBoolean implements xb.g<T>, tc.d {
    private static final long serialVersionUID = 1015244841293359600L;
    final tc.c<? super T> downstream;
    final xb.p scheduler;
    tc.d upstream;

    final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowableUnsubscribeOn$UnsubscribeSubscriber f9510c;

        a(FlowableUnsubscribeOn$UnsubscribeSubscriber r10) {
            this.f9510c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9510c.upstream.cancel();
        }
    }

    FlowableUnsubscribeOn$UnsubscribeSubscriber(tc.c<? super T> r10, xb.p r11) {
        this.downstream = r10;
        this.scheduler = r11;
    }

    @Override // tc.d
    public void cancel() {
        if (compareAndSet(false, true) == false) goto L6;
        this.scheduler.c(new a(this));
        return;
    }

    @Override // tc.c
    public void onComplete() {
        if (get() == true) goto L6;
        this.downstream.onComplete();
        return;
    }

    @Override // tc.c
    public void onError(Throwable r10) {
        if (get() == false) goto L6;
        dc.a.n(r10);
        return;
    L6:
        this.downstream.onError(r10);
    }

    @Override // tc.c
    public void onNext(T r10) {
        if (get() == true) goto L6;
        this.downstream.onNext(r10);
        return;
    }

    @Override // xb.g, tc.c
    public void onSubscribe(tc.d r10) {
        if (SubscriptionHelper.validate(this.upstream, r10) == false) goto L6;
        this.upstream = r10;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // tc.d
    public void request(long r10) {
        this.upstream.request(r10);
    }
}
