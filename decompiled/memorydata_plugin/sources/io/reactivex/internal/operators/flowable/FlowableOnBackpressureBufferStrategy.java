package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends a<T, T> {
    final long c;
    final io.reactivex.b.a d;
    final BackpressureOverflowStrategy e;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16780a = null;

        static {
            int[] r0 = new int[BackpressureOverflowStrategy.values().length];
            f16780a = r0;
            r0[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f16780a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 3240706908776709697L;
        final long bufferSize;
        volatile boolean cancelled;
        final Deque<T> deque;
        volatile boolean done;
        final org.a.c<? super T> downstream;
        Throwable error;
        final io.reactivex.b.a onOverflow;
        final AtomicLong requested;
        final BackpressureOverflowStrategy strategy;
        org.a.d upstream;

        OnBackpressureBufferStrategySubscriber(org.a.c<? super T> r3, io.reactivex.b.a r4, BackpressureOverflowStrategy r5, long r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r8 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.onOverflow = r8;
            this.strategy = r5;
            this.bufferSize = r6;
            this.requested = new AtomicLong();
            this.deque = new ArrayDeque();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L6;
            clear(this.deque);
            return;
        }

        void clear(Deque<T> r2) {
            Deque r1 = (Deque) ZeusTransformUtils.wrapperContextForParams(r2, Deque.class, "com.obric.memorydata.plugin");
            monitor-enter(r1);
            r1.clear();     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Deque<T> r0 = this.deque;
            org.a.c<? super T> r1 = this.downstream;
            int r3 = 1;
        L6:
            long r4 = this.requested.get();
            long r8 = 0;
        L8:
            if (r8 == r4) goto L34;
            if (this.cancelled == true) goto L11;
            boolean r11 = this.done;
            monitor-enter(r0);
            T r12 = r0.poll();     // Catch: Throwable -> L31
            monitor-exit(r0);     // Catch: Throwable -> L31
            if (r12 != null) goto L19;
            boolean r13 = true;
        L20:
            if (r11 == false) goto L28;
            Throwable r14 = this.error;
            if (r14 != null) goto L23;
            if (r13 == false) goto L28;
            r1.onComplete();
            return;
        L23:
            clear(r0);
            r1.onError(r14);
            return;
        L28:
            if (r13 == true) goto L34;
            r1.onNext(r12);
            r8 = r8 + 1;
            goto L8
        L19:
            r13 = false;
        L31:
            th = move-exception;
            throw th;
        L11:
            clear(r0);
            return;
        L34:
            if (r8 != r4) goto L55;
            if (this.cancelled == true) goto L37;
            boolean r5 = this.done;
            monitor-enter(r0);
            boolean r6 = r0.isEmpty();     // Catch: Throwable -> L51
            monitor-exit(r0);     // Catch: Throwable -> L51
            if (r5 == false) goto L55;
            Throwable r7 = this.error;
            if (r7 != null) goto L46;
            if (r6 == false) goto L55;
            r1.onComplete();
            return;
        L46:
            clear(r0);
            r1.onError(r7);
            return;
        L51:
            th = move-exception;
            throw th;
        L37:
            clear(r0);
            return;
        L55:
            if (r8 == 0) goto L57;
            io.reactivex.internal.util.b.c(this.requested, r8);
        L57:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L6;
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r7) {
            if (this.done == false) goto L5;
            return;
        L5:
            Deque<T> r0 = this.deque;
            monitor-enter(r0);
            boolean r2 = false;
            boolean r3 = true;
            if (r0.size() != this.bufferSize) goto L17;
            int r1 = AnonymousClass1.f16780a[this.strategy.ordinal()];     // Catch: Throwable -> L31
            if (r1 != 1) goto L12;
            r0.pollLast();     // Catch: Throwable -> L31
        L16:
            r0.offer(r7);     // Catch: Throwable -> L31
            r3 = false;
            r2 = true;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L31
            if (r2 == false) goto L26;
            io.reactivex.b.a r8 = this.onOverflow;
            if (r8 == null) goto L38;
            r8.a();     // Catch: Throwable -> L24
            return;
        L24:
            MissingBackpressureException th = th;
            io.reactivex.exceptions.a.a(th);
            this.upstream.cancel();
        L28:
            onError(th);
            return;
        L38:
            return;
        L26:
            if (r3 == false) goto L29;
            this.upstream.cancel();
            th = new MissingBackpressureException();
            goto L28
        L29:
            drain();
            return;
        L12:
            if (r1 != 2) goto L18;
            r0.poll();     // Catch: Throwable -> L31
            goto L16
        L17:
            r0.offer(r7);     // Catch: Throwable -> L31
            r3 = false;
        L31:
            th = move-exception;
            throw th;
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
    public void a(org.a.c<? super T> r8) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r8, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new OnBackpressureBufferStrategySubscriber(r1, this.d, this.e, this.c));
    }
}
