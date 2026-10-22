package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.g;
import io.reactivex.internal.a.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableMergeWithSingle<T> extends a<T, T> {
    final z<? extends T> c;

    static final class MergeWithObserver<T> extends AtomicInteger implements j<T>, org.a.d {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean cancelled;
        int consumed;
        final org.a.c<? super T> downstream;
        long emitted;
        final AtomicThrowable error;
        final int limit;
        volatile boolean mainDone;
        final AtomicReference<org.a.d> mainSubscription;
        final OtherObserver<T> otherObserver;
        volatile int otherState;
        final int prefetch;
        volatile e<T> queue;
        final AtomicLong requested;
        T singleItem;

        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements x<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(T r1) {
                this.parent.otherSuccess(r1);
            }
        }

        MergeWithObserver(org.a.c<? super T> r3) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.mainSubscription = new AtomicReference();
            this.otherObserver = new OtherObserver(this);
            this.error = new AtomicThrowable();
            this.requested = new AtomicLong();
            int r4 = g.a();
            this.prefetch = r4;
            this.limit = r4 - (r4 >> 2);
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() != 0) goto L6;
            this.queue = null;
            this.singleItem = null;
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            org.a.c<? super T> r1 = this.downstream;
            long r2 = this.emitted;
            int r4 = this.consumed;
            int r5 = this.limit;
            int r6 = 1;
            int r7 = 1;
        L3:
            long r8 = this.requested.get();
        L5:
            if (r2 == r8) goto L35;
            if (this.cancelled == true) goto L8;
            if (this.error.get() != null) goto L12;
            int r14 = this.otherState;
            if (r14 == r6) goto L16;
            boolean r9 = this.mainDone;
            e<T> r11 = this.queue;
            if (r11 == null) goto L20;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r12 = r11.poll();
        L21:
            if (r12 != null) goto L23;
            boolean r17 = true;
        L24:
            if (r9 == false) goto L29;
            if (r17 == false) goto L29;
            if (r14 != 2) goto L29;
            this.queue = null;
            r1.onComplete();
            return;
        L29:
            if (r17 == true) goto L35;
            r1.onNext(r12);
            r2 = r2 + 1;
            r4 = r4 + 1;
            if (r4 != r5) goto L34;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.mainSubscription.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r5);
            r4 = 0;
        L34:
            r6 = 1;
            goto L5
        L23:
            r17 = false;
            goto L24
        L20:
            r12 = null;
            goto L21
        L16:
            T r10 = this.singleItem;
            this.singleItem = null;
            this.otherState = 2;
            r1.onNext(r10);
            r2 = r2 + 1;
            goto L5
        L12:
            this.singleItem = null;
            this.queue = null;
            r1.onError(this.error.terminate());
            return;
        L8:
            this.singleItem = null;
            this.queue = null;
            return;
        L35:
            if (r2 == r8) goto L37;
        L57:
            this.emitted = r2;
            this.consumed = r4;
            r7 = addAndGet(-r7);
            if (r7 == 0) goto L59;
            r6 = 1;
            goto L3
        L59:
            return;
        L37:
            if (this.cancelled == true) goto L38;
            if (this.error.get() != null) goto L42;
            boolean r13 = this.mainDone;
            e<T> r15 = this.queue;
            if (r15 != null) goto L47;
        L50:
            boolean r16 = true;
        L51:
            if (r13 == false) goto L57;
            if (r16 == false) goto L57;
            if (this.otherState != 2) goto L57;
            this.queue = null;
            r1.onComplete();
            return;
        L47:
            if (r15.isEmpty() == true) goto L50;
            r16 = false;
            goto L51
        L42:
            this.singleItem = null;
            this.queue = null;
            r1.onError(this.error.terminate());
            return;
        L38:
            this.singleItem = null;
            this.queue = null;
        }

        e<T> getOrCreateQueue() {
            e<T> r0 = this.queue;
            if (r0 != null) goto L6;
            SpscArrayQueue r1 = new SpscArrayQueue(g.a());
            this.queue = r1;
            return r1;
        L6:
            return r0;
        }

        @Override // org.a.c
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            DisposableHelper.dispose(this.otherObserver);
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        @Override // org.a.c
        public void onNext(T r7) {
            if (compareAndSet(0, 1) == false) goto L20;
            long r2 = this.emitted;
            if (this.requested.get() == r2) goto L16;
            e<T> r4 = this.queue;
            if (r4 != null) goto L9;
        L12:
            this.emitted = r2 + 1;
            this.downstream.onNext(r7);
            int r8 = this.consumed + 1;
            if (r8 != this.limit) goto L15;
            this.consumed = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(this.mainSubscription.get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r8);
        L18:
            if (decrementAndGet() != 0) goto L23;
            return;
        L23:
            drainLoop();
            return;
        L15:
            this.consumed = r8;
            goto L18
        L9:
            if (r4.isEmpty() == true) goto L12;
            r4.offer(r7);
            goto L18
        L16:
            getOrCreateQueue().offer(r7);
            goto L18
        L20:
            getOrCreateQueue().offer(r7);
            if (getAndIncrement() == 0) goto L23;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            SubscriptionHelper.setOnce(this.mainSubscription, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin"), this.prefetch);
        }

        void otherError(Throwable r2) {
            if (this.error.addThrowable(r2) == false) goto L5;
            SubscriptionHelper.cancel(this.mainSubscription);
            drain();
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }

        void otherSuccess(T r7) {
            if (compareAndSet(0, 1) == false) goto L10;
            long r2 = this.emitted;
            if (this.requested.get() == r2) goto L7;
            this.emitted = r2 + 1;
            this.downstream.onNext(r7);
            this.otherState = 2;
        L13:
            drainLoop();
            return;
        L7:
            this.singleItem = r7;
            this.otherState = 1;
            if (decrementAndGet() != 0) goto L13;
            return;
        L10:
            this.singleItem = r7;
            this.otherState = 1;
            if (getAndIncrement() == 0) goto L13;
        }

        @Override // org.a.d
        public void request(long r2) {
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r3) {
        org.a.c r4 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        MergeWithObserver r0 = new MergeWithObserver(r4);
        r4.onSubscribe(r0);
        this.f16812b.a(r0);
        this.c.a(r0.otherObserver);
    }
}
