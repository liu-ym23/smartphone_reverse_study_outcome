package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSubscribeOn<T> extends a<T, T> {
    final u c;
    final boolean d;

    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = 8094547886072529208L;
        final org.a.c<? super T> downstream;
        final boolean nonScheduledRequests;
        final AtomicLong requested;
        org.a.b<T> source;
        final AtomicReference<org.a.d> upstream;
        final u.c worker;

        static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final org.a.d f16795a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final long f16796b;

            a(org.a.d r3, long r4) {
                this.f16795a = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
                this.f16796b = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16795a.request(this.f16796b);
            }
        }

        SubscribeOnSubscriber(org.a.c<? super T> r3, u.c r4, org.a.b<T> r5, boolean r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            org.a.b<T> r8 = (org.a.b) ZeusTransformUtils.wrapperContextForParams(r5, org.a.b.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.worker = r4;
            this.source = r8;
            this.upstream = new AtomicReference();
            this.requested = new AtomicLong();
            this.nonScheduledRequests = !r6;
        }

        @Override // org.a.d
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r6) {
            org.a.d r7 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r6, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.setOnce(this.upstream, r7) == false) goto L8;
            long r3 = this.requested.getAndSet(0);
            if (r3 == 0) goto L9;
            requestUpstream(r3, r7);
            return;
        L9:
            return;
        }

        @Override // org.a.d
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == false) goto L13;
            org.a.d r0 = (org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L7;
            requestUpstream(r5, r0);
            return;
        L7:
            io.reactivex.internal.util.b.a(this.requested, r5);
            org.a.d r6 = (org.a.d) ZeusTransformUtils.preCheckCast(this.upstream.get(), org.a.d.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L15;
            long r2 = this.requested.getAndSet(0);
            if (r2 == 0) goto L16;
            requestUpstream(r2, r6);
            return;
        L16:
            return;
        L15:
            return;
        }

        void requestUpstream(long r3, org.a.d r5) {
            org.a.d r6 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r5, org.a.d.class, "com.obric.memorydata.plugin");
            if (this.nonScheduledRequests == false) goto L5;
        L8:
            r6.request(r3);
            return;
        L5:
            if (Thread.currentThread() == get()) goto L8;
            this.worker.a(new a(r6, r3));
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            org.a.b<T> r0 = this.source;
            this.source = null;
            r0.subscribe(this);
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        u.c r0 = this.c.a();
        SubscribeOnSubscriber r1 = new SubscribeOnSubscriber(r5, r0, this.f16812b, this.d);
        r5.onSubscribe(r1);
        r0.a(r1);
    }
}
