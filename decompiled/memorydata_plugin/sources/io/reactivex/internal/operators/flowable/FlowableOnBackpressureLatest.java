package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnBackpressureLatest<T> extends a<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        final AtomicReference<T> current;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        Throwable error;
        final AtomicLong requested;
        org.a.d upstream;

        BackpressureLatestSubscriber(org.a.c<? super T> r3) {
            org.a.c<? super T> r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.current = new AtomicReference();
            this.downstream = r4;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.current.lazySet(null);
            return;
        L9:
            return;
        }

        boolean checkTerminated(boolean r4, boolean r5, org.a.c<?> r6, AtomicReference<T> r7) {
            org.a.c r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            r7.lazySet(null);
            return true;
        L6:
            if (r4 == false) goto L14;
            Throwable r3 = this.error;
            if (r3 == null) goto L11;
            r7.lazySet(null);
            r8.onError(r3);
            return true;
        L11:
            if (r5 == false) goto L16;
            r8.onComplete();
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super T> r0 = this.downstream;
            AtomicLong r1 = this.requested;
            AtomicReference<T> r2 = this.current;
            int r4 = 1;
        L6:
            long r7 = 0;
        L7:
            boolean r10 = false;
            if (r7 == r1.get()) goto L20;
            boolean r9 = this.done;
            T r11 = r2.getAndSet(null);
            if (r11 != null) goto L12;
            boolean r12 = true;
        L14:
            if (checkTerminated(r9, r12, r0, r2) == true) goto L15;
            if (r12 == true) goto L20;
            r0.onNext(r11);
            r7 = r7 + 1;
            goto L7
        L15:
            return;
        L12:
            r12 = false;
        L20:
            if (r7 != r1.get()) goto L28;
            boolean r13 = this.done;
            if (r2.get() != null) goto L25;
            r10 = true;
        L25:
            if (checkTerminated(r13, r10, r0, r2) == false) goto L28;
            return;
        L28:
            if (r7 == 0) goto L30;
            io.reactivex.internal.util.b.c(r1, r7);
        L30:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L6;
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r2) {
            this.current.lazySet(r2);
            drain();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            r4.request(Long.MAX_VALUE);
            return;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new BackpressureLatestSubscriber(r4));
    }
}
