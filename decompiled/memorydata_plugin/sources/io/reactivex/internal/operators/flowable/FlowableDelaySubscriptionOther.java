package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends g<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T> f16771b;
    final org.a.b<U> c;

    static final class MainSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = 2259811067697317255L;
        final org.a.c<? super T> downstream;
        final org.a.b<? extends T> main;
        final MainSubscriber<T>.OtherSubscriber other;
        final AtomicReference<org.a.d> upstream;

        final class OtherSubscriber extends AtomicReference<org.a.d> implements j<Object> {
            private static final long serialVersionUID = -3892798459447644106L;
            final /* synthetic */ MainSubscriber this$0;

            OtherSubscriber(MainSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // org.a.c
            public void onComplete() {
                if (((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")) == SubscriptionHelper.CANCELLED) goto L6;
                this.this$0.next();
                return;
            }

            @Override // org.a.c
            public void onError(Throwable r4) {
                if (((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")) == SubscriptionHelper.CANCELLED) goto L5;
                this.this$0.downstream.onError(r4);
                return;
            L5:
                io.reactivex.d.a.a(r4);
            }

            @Override // org.a.c
            public void onNext(Object r3) {
                org.a.d r4 = (org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin");
                if (r4 == SubscriptionHelper.CANCELLED) goto L6;
                lazySet(SubscriptionHelper.CANCELLED);
                r4.cancel();
                this.this$0.next();
                return;
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(org.a.d r3) {
                org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
                if (SubscriptionHelper.setOnce(this, r4) == false) goto L6;
                r4.request(Long.MAX_VALUE);
                return;
            }
        }

        MainSubscriber(org.a.c<? super T> r3, org.a.b<? extends T> r4) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<? extends T> r6 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.a.b.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.main = r6;
            this.other = new OtherSubscriber(this);
            this.upstream = new AtomicReference();
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.other);
            SubscriptionHelper.cancel(this.upstream);
        }

        void next() {
            this.main.subscribe(this);
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            SubscriptionHelper.deferredSetOnce(this.upstream, this, r4);
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            SubscriptionHelper.deferredRequest(this.upstream, this, r2);
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        MainSubscriber r0 = new MainSubscriber(r4, this.f16771b);
        r4.onSubscribe(r0);
        this.c.subscribe(r0.other);
    }
}
