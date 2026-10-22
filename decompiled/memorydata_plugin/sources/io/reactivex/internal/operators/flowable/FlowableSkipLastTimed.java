package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableSkipLastTimed<T> extends a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;
    final int f;
    final boolean g;

    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final u scheduler;
        final long time;
        final TimeUnit unit;
        org.a.d upstream;

        SkipLastTimedSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u r7, int r8, boolean r9) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.downstream = r5;
            this.time = r4;
            this.unit = r6;
            this.scheduler = r7;
            this.queue = new io.reactivex.internal.queue.a(r8);
            this.delayError = r9;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<? super T> r5, boolean r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r3 == false) goto L21;
            if (r6 == false) goto L14;
            if (r4 == false) goto L23;
            Throwable r2 = this.error;
            if (r2 == null) goto L12;
            r7.onError(r2);
        L13:
            return true;
        L12:
            r7.onComplete();
            goto L13
        L23:
            return false;
        L14:
            Throwable r8 = this.error;
            if (r8 == null) goto L18;
            this.queue.clear();
            r7.onError(r8);
            return true;
        L18:
            if (r4 == false) goto L24;
            r7.onComplete();
            return true;
        L24:
            return false;
        L21:
            return false;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super T> r1 = this.downstream;
            io.reactivex.internal.queue.a<Object> r2 = this.queue;
            boolean r3 = this.delayError;
            TimeUnit r4 = this.unit;
            u r5 = this.scheduler;
            long r6 = this.time;
            int r9 = 1;
        L6:
            long r10 = this.requested.get();
            long r14 = 0;
        L8:
            if (r14 == r10) goto L25;
            boolean r8 = this.done;
            long r17 = r10;
            Long r11 = (Long) ZeusTransformUtils.preCheckCast(r2.a(), Long.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L12;
            boolean r12 = true;
        L13:
            long r13 = r5.b(r4);
            if (r12 == true) goto L19;
            if (r11.longValue() <= (r13 - r6)) goto L19;
            r12 = true;
        L19:
            if (checkTerminated(r8, r12, r1, r3) == true) goto L20;
            if (r12 == true) goto L25;
            r2.poll();
            r1.onNext(r2.poll());
            r14 = r14 + 1;
            r10 = r17;
            goto L8
        L20:
            return;
        L12:
            r12 = false;
        L25:
            if (r14 == 0) goto L27;
            io.reactivex.internal.util.b.c(this.requested, r14);
        L27:
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L6;
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
        public void onNext(T r4) {
            long r0 = this.scheduler.b(this.unit);
            this.queue.a(Long.valueOf(r0), r4);
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
    public void a(org.a.c<? super T> r10) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r10, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new SkipLastTimedSubscriber(r1, this.c, this.d, this.e, this.f, this.g));
    }
}
