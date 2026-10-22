package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableConcatMapEager<T, R> extends a<T, R> {
    final h<? super T, ? extends org.a.b<? extends R>> c;
    final int d;
    final int e;
    final ErrorMode f;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements io.reactivex.internal.subscribers.c<R>, j<T>, org.a.d {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors;
        final h<? super T, ? extends org.a.b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final AtomicLong requested;
        final io.reactivex.internal.queue.a<InnerQueuedSubscriber<R>> subscribers;
        org.a.d upstream;

        ConcatMapEagerDelayErrorSubscriber(org.a.c<? super R> r3, h<? super T, ? extends org.a.b<? extends R>> r4, int r5, int r6, ErrorMode r7) {
            org.a.c<? super R> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends org.a.b<? extends R>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r8;
            this.mapper = r9;
            this.maxConcurrency = r5;
            this.prefetch = r6;
            this.errorMode = r7;
            this.subscribers = new io.reactivex.internal.queue.a(Math.min(r6, r5));
            this.errors = new AtomicThrowable();
            this.requested = new AtomicLong();
        }

        @Override // org.a.d
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            InnerQueuedSubscriber<R> r0 = this.current;
            this.current = null;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            InnerQueuedSubscriber r1 = (InnerQueuedSubscriber) ZeusTransformUtils.preCheckCast(this.subscribers.poll(), InnerQueuedSubscriber.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L8;
            r1.cancel();
            goto L5
        }

        @Override // io.reactivex.internal.subscribers.c
        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            InnerQueuedSubscriber<R> r0 = this.current;
            org.a.c<? super R> r2 = this.downstream;
            ErrorMode r3 = this.errorMode;
            int r5 = 1;
        L6:
            long r6 = this.requested.get();
            if (r0 == null) goto L9;
            r0 = r0;
        L26:
            if (r0 == null) goto L73;
            f<R> r13 = r0.queue();
            if (r13 == null) goto L73;
            long r14 = 0;
        L30:
            int r17 = r5;
            if (r14 == r6) goto L56;
            if (this.cancelled == true) goto L34;
            if (r3 == ErrorMode.IMMEDIATE) goto L39;
        L42:
            boolean r1 = r0.isDone();
            R r10 = r13.poll();     // Catch: Throwable -> L53
            if (r10 != null) goto L46;
            boolean r11 = true;
        L47:
            if (r1 == false) goto L50;
            if (r11 == false) goto L50;
            this.current = null;
            this.upstream.request(1);
            r0 = null;
            boolean r4 = true;
        L57:
            if (r14 == r6) goto L59;
        L72:
            long r7 = 0;
        L75:
            if (r14 != r7) goto L77;
        L79:
            if (r4 == true) goto L80;
            r5 = addAndGet(-r17);
            if (r5 != 0) goto L6;
            return;
        L80:
            r5 = r17;
            goto L6
        L77:
            if (r6 == Long.MAX_VALUE) goto L79;
            this.requested.addAndGet(-r14);
            goto L79
        L59:
            if (this.cancelled == true) goto L60;
            if (r3 == ErrorMode.IMMEDIATE) goto L65;
        L68:
            boolean r8 = r0.isDone();
            boolean r12 = r13.isEmpty();
            if (r8 == false) goto L72;
            if (r12 == false) goto L72;
            this.current = null;
            this.upstream.request(1);
            r0 = null;
            r4 = true;
            goto L72
        L65:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L68;
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L60:
            cancelAll();
            return;
        L50:
            if (r11 == true) goto L56;
            r2.onNext(r10);
            r14 = r14 + 1;
            r0.requestOne();
            r5 = r17;
            goto L30
        L46:
            r11 = false;
        L53:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(th);
            return;
        L39:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L42;
            this.current = null;
            r0.cancel();
            cancelAll();
            r2.onError(this.errors.terminate());
            return;
        L34:
            cancelAll();
            return;
        L56:
            r4 = false;
        L73:
            r17 = r5;
            r4 = false;
            r7 = 0;
            r14 = 0;
            goto L75
        L9:
            if (r3 != ErrorMode.END) goto L11;
        L14:
            boolean r9 = this.done;
            r0 = (InnerQueuedSubscriber) ZeusTransformUtils.preCheckCast(this.subscribers.poll(), InnerQueuedSubscriber.class, "com.obric.memorydata.plugin");
            if (r9 == false) goto L22;
            if (r0 != null) goto L22;
            Throwable r15 = this.errors.terminate();
            if (r15 == null) goto L20;
            r2.onError(r15);
            return;
        L20:
            r2.onComplete();
            return;
        L22:
            if (r0 == null) goto L26;
            this.current = r0;
            goto L26
        L11:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L14;
            cancelAll();
            r2.onError(this.errors.terminate());
        }

        void drainAndCancel() {
            if (getAndIncrement() != 0) goto L6;
        L4:
            cancelAll();
            if (decrementAndGet() != 0) goto L4;
            return;
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerComplete(InnerQueuedSubscriber<R> r1) {
            r1.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerError(InnerQueuedSubscriber<R> r2, Throwable r3) {
            if (this.errors.addThrowable(r3) == false) goto L8;
            r2.setDone();
            if (this.errorMode == ErrorMode.END) goto L7;
            this.upstream.cancel();
        L7:
            drain();
            return;
        L8:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerNext(InnerQueuedSubscriber<R> r2, R r3) {
            if (r2.queue().offer(r3) == false) goto L5;
            drain();
            return;
        L5:
            r2.cancel();
            innerError(r2, new MissingBackpressureException());
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.errors.addThrowable(r2) == false) goto L5;
            this.done = true;
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r3) {
            org.a.b r4 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null Publisher"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            InnerQueuedSubscriber<R> r0 = new InnerQueuedSubscriber(this, this.prefetch);
            if (this.cancelled == false) goto L6;
            return;
        L6:
            this.subscribers.offer(r0);
            r4.subscribe(r0);
            if (this.cancelled == false) goto L15;
            r0.cancel();
            drainAndCancel();
            return;
        L15:
            return;
        L10:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
            onError(th);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L10;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            int r2 = this.maxConcurrency;
            if (r2 != Integer.MAX_VALUE) goto L7;
            long r0 = Long.MAX_VALUE;
        L8:
            r4.request(r0);
            return;
        L7:
            r0 = r2;
            goto L8
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
    public void a(org.a.c<? super R> r8) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new ConcatMapEagerDelayErrorSubscriber(r1, this.c, this.d, this.e, this.f));
    }
}
