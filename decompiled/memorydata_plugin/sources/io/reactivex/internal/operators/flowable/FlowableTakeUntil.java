package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTakeUntil<T, U> extends a<T, T> {
    final org.a.b<? extends U> c;

    static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -4945480365982832967L;
        final org.a.c<? super T> downstream;
        final AtomicThrowable error;
        final TakeUntilMainSubscriber<T>.OtherSubscriber other;
        final AtomicLong requested;
        final AtomicReference<org.a.d> upstream;

        final class OtherSubscriber extends AtomicReference<org.a.d> implements j<Object> {
            private static final long serialVersionUID = -3592821756711087922L;
            final /* synthetic */ TakeUntilMainSubscriber this$0;

            OtherSubscriber(TakeUntilMainSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // org.a.c
            public void onComplete() {
                SubscriptionHelper.cancel(this.this$0.upstream);
                org.a.c<? super T> r0 = this.this$0.downstream;
                TakeUntilMainSubscriber r2 = this.this$0;
                e.a(r0, r2, r2.error);
            }

            @Override // org.a.c
            public void onError(Throwable r3) {
                SubscriptionHelper.cancel(this.this$0.upstream);
                org.a.c<? super T> r0 = this.this$0.downstream;
                TakeUntilMainSubscriber r2 = this.this$0;
                e.a(r0, r3, r2, r2.error);
            }

            @Override // org.a.c
            public void onNext(Object r1) {
                SubscriptionHelper.cancel(this);
                onComplete();
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(org.a.d r3) {
                SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
            }
        }

        TakeUntilMainSubscriber(org.a.c<? super T> r3) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.upstream = new AtomicReference();
            this.other = new OtherSubscriber(this);
            this.error = new AtomicThrowable();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // org.a.c
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            e.a(this.downstream, this, this.error);
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            e.a(this.downstream, r3, this, this.error);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, r2);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        TakeUntilMainSubscriber r0 = new TakeUntilMainSubscriber(r4);
        r4.onSubscribe(r0);
        this.c.subscribe(r0.other);
        this.f16812b.a(r0);
    }
}
