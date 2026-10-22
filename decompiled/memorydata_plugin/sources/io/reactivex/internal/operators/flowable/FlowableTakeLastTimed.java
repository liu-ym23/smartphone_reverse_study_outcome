package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTakeLastTimed<T> extends a<T, T> {
    final long c;
    final long d;
    final TimeUnit e;
    final u f;
    final int g;
    final boolean h;

    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
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

        TakeLastTimedSubscriber(org.a.c<? super T> r3, long r4, long r6, TimeUnit r8, u r9, int r10, boolean r11) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.requested = new AtomicLong();
            this.downstream = r5;
            this.count = r4;
            this.time = r6;
            this.unit = r8;
            this.scheduler = r9;
            this.queue = new io.reactivex.internal.queue.a(r10);
            this.delayError = r11;
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

        boolean checkTerminated(boolean r3, org.a.c<? super T> r4, boolean r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r5 == false) goto L13;
            if (r3 == false) goto L20;
            Throwable r2 = this.error;
            if (r2 == null) goto L11;
            r6.onError(r2);
        L12:
            return true;
        L11:
            r6.onComplete();
            goto L12
        L20:
            return false;
        L13:
            Throwable r7 = this.error;
            if (r7 == null) goto L17;
            this.queue.clear();
            r6.onError(r7);
            return true;
        L17:
            if (r3 == false) goto L22;
            r6.onComplete();
            return true;
        L22:
            return false;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super T> r0 = this.downstream;
            io.reactivex.internal.queue.a<Object> r1 = this.queue;
            boolean r2 = this.delayError;
            int r4 = 1;
        L7:
            if (this.done == true) goto L9;
        L25:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L7;
            return;
        L9:
            if (checkTerminated(r1.isEmpty(), r0, r2) == true) goto L10;
            long r5 = this.requested.get();
            long r9 = 0;
        L13:
            if (r1.a() != null) goto L15;
            boolean r11 = true;
        L17:
            if (checkTerminated(r11, r0, r2) == true) goto L18;
            if (r5 == r9) goto L22;
            r1.poll();
            r0.onNext(r1.poll());
            r9 = r9 + 1;
            goto L13
        L22:
            if (r9 == 0) goto L25;
            io.reactivex.internal.util.b.c(this.requested, r9);
            goto L25
        L18:
            return;
        L15:
            r11 = false;
            goto L17
        }

        @Override // org.a.c
        public void onComplete() {
            trim(this.scheduler.b(this.unit), this.queue);
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r4) {
            if (this.delayError == false) goto L5;
            trim(this.scheduler.b(this.unit), this.queue);
        L5:
            this.error = r4;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r5) {
            io.reactivex.internal.queue.a<Object> r0 = this.queue;
            long r1 = this.scheduler.b(this.unit);
            r0.a(Long.valueOf(r1), r5);
            trim(r1, r0);
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

        void trim(long r10, io.reactivex.internal.queue.a<Object> r12) {
            long r0 = this.time;
            long r2 = this.count;
            if (r2 != Long.MAX_VALUE) goto L5;
            boolean r9 = true;
        L7:
            if (r12.isEmpty() == true) goto L14;
            if (((Long) ZeusTransformUtils.preCheckCast(r12.a(), Long.class, "com.obric.memorydata.plugin")).longValue() < (r10 - r0)) goto L13;
            if (r9 == true) goto L21;
            if ((r12.b() >> 1) > r2) goto L13;
            return;
        L21:
            return;
        L13:
            r12.poll();
            r12.poll();
            goto L7
        L14:
            return;
        L5:
            r9 = false;
            goto L7
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r12) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r12, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new TakeLastTimedSubscriber(r1, this.c, this.d, this.e, this.f, this.g, this.h));
    }
}
