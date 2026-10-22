package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableObserveOn<T> extends a<T, T> {
    final u c;
    final boolean d;
    final int e;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        f<T> queue;
        final AtomicLong requested;
        int sourceMode;
        org.a.d upstream;
        final u.c worker;

        BaseObserveOnSubscriber(u.c r1, boolean r2, int r3) {
            this.worker = r1;
            this.delayError = r2;
            this.prefetch = r3;
            this.requested = new AtomicLong();
            this.limit = r3 - (r3 >> 2);
        }

        @Override // org.a.d
        public final void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (this.outputFused == false) goto L8;
            return;
        L8:
            if (getAndIncrement() != 0) goto L12;
            this.queue.clear();
            return;
        }

        final boolean checkTerminated(boolean r3, boolean r4, org.a.c<?> r5) {
            org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayError == false) goto L15;
            if (r4 == false) goto L24;
            this.cancelled = true;
            Throwable r7 = this.error;
            if (r7 != null) goto L18;
        L21:
            r6.onComplete();
        L13:
            this.worker.dispose();
            return true;
        L18:
            r6.onError(r7);
            goto L13
        L24:
            return false;
        L15:
            r7 = this.error;
            if (r7 == null) goto L19;
            this.cancelled = true;
            clear();
            goto L18
        L19:
            if (r4 == false) goto L25;
            this.cancelled = true;
            goto L21
        L25:
            return false;
        }

        @Override // io.reactivex.internal.a.f
        public final void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.a.f
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // org.a.c
        public final void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            trySchedule();
            return;
        }

        @Override // org.a.c
        public final void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.error = r2;
            this.done = true;
            trySchedule();
        }

        @Override // org.a.c
        public final void onNext(T r3) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode != 2) goto L10;
            trySchedule();
            return;
        L10:
            if (this.queue.offer(r3) == true) goto L12;
            this.upstream.cancel();
            this.error = new MissingBackpressureException("Queue is full?!");
            this.done = true;
        L12:
            trySchedule();
        }

        @Override // org.a.d
        public final void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            trySchedule();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public final int requestFusion(int r2) {
            if ((r2 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused == false) goto L6;
            runBackfused();
            return;
        L6:
            if (this.sourceMode != 1) goto L8;
            runSync();
            return;
        L8:
            runAsync();
        }

        abstract void runAsync();

        abstract void runBackfused();

        abstract void runSync();

        final void trySchedule() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            this.worker.a(this);
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final io.reactivex.internal.a.a<? super T> downstream;

        ObserveOnConditionalSubscriber(io.reactivex.internal.a.a<? super T> r3, u.c r4, boolean r5, int r6) {
            io.reactivex.internal.a.a<? super T> r7 = (io.reactivex.internal.a.a) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin");
            super(r4, r5, r6);
            this.downstream = r7;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
            this.upstream = r5;
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = 1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = 2;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.queue.poll();
            if (r0 != null) goto L5;
        L10:
            return r0;
        L5:
            if (this.sourceMode == 1) goto L10;
            long r1 = this.consumed + 1;
            if (r1 != this.limit) goto L9;
            this.consumed = 0;
            this.upstream.request(r1);
            goto L10
        L9:
            this.consumed = r1;
            goto L10
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            io.reactivex.internal.a.a<? super T> r0 = this.downstream;
            f<T> r1 = this.queue;
            long r2 = this.produced;
            long r4 = this.consumed;
            int r7 = 1;
        L3:
            long r8 = this.requested.get();
        L5:
            if (r2 == r8) goto L25;
            boolean r11 = this.done;
            T r12 = r1.poll();     // Catch: Throwable -> L22
            if (r12 != null) goto L10;
            boolean r13 = true;
        L12:
            if (checkTerminated(r11, r13, r0) == true) goto L13;
            if (r13 == true) goto L25;
            if (r0.tryOnNext(r12) == false) goto L19;
            r2 = r2 + 1;
        L19:
            r4 = r4 + 1;
            if (r4 != this.limit) goto L5;
            this.upstream.request(r4);
            r4 = 0;
            goto L5
        L13:
            return;
        L10:
            r13 = false;
        L22:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.cancel();
            r1.clear();
            r0.onError(th);
            this.worker.dispose();
            return;
        L25:
            if (r2 == r8) goto L27;
        L29:
            int r9 = get();
            if (r7 == r9) goto L31;
            r7 = r9;
            goto L3
        L31:
            this.produced = r2;
            this.consumed = r4;
            r7 = addAndGet(-r7);
            if (r7 != 0) goto L3;
            return;
        L27:
            if (checkTerminated(this.done, r1.isEmpty(), r0) == false) goto L29;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int r1 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            boolean r2 = this.done;
            this.downstream.onNext(null);
            if (r2 == true) goto L8;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L8:
            this.cancelled = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L11;
            this.downstream.onError(r0);
        L12:
            this.worker.dispose();
            return;
        L11:
            this.downstream.onComplete();
            goto L12
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            io.reactivex.internal.a.a<? super T> r0 = this.downstream;
            f<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L20;
            T r8 = r1.poll();     // Catch: Throwable -> L17
            if (this.cancelled == true) goto L9;
            if (r8 == null) goto L11;
            if (r0.tryOnNext(r8) == false) goto L5;
            r2 = r2 + 1;
        L11:
            this.cancelled = true;
            r0.onComplete();
        L12:
            this.worker.dispose();
            return;
        L9:
            return;
        L17:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.cancel();
            r0.onError(th);
            goto L12
        L20:
            if (this.cancelled == true) goto L21;
            if (r1.isEmpty() == true) goto L11;
            int r7 = get();
            if (r5 == r7) goto L27;
            r5 = r7;
            goto L3
        L27:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements j<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final org.a.c<? super T> downstream;

        ObserveOnSubscriber(org.a.c<? super T> r3, u.c r4, boolean r5, int r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(r4, r5, r6);
            this.downstream = r7;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r4) {
            org.a.d r5 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r4, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r5) == false) goto L16;
            this.upstream = r5;
            if (ZeusTransformUtils.instanceOf(r5, io.reactivex.internal.a.d.class) == false) goto L14;
            io.reactivex.internal.a.d r0 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r5, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r1 = r0.requestFusion(7);
            if (r1 != 1) goto L11;
            this.sourceMode = 1;
            this.queue = r0;
            this.done = true;
            this.downstream.onSubscribe(this);
            return;
        L11:
            if (r1 != 2) goto L14;
            this.sourceMode = 2;
            this.queue = r0;
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            this.downstream.onSubscribe(this);
            r5.request(this.prefetch);
            return;
        }

        @Override // io.reactivex.internal.a.f
        public T poll() {
            T r0 = this.queue.poll();
            if (r0 != null) goto L5;
        L10:
            return r0;
        L5:
            if (this.sourceMode == 1) goto L10;
            long r1 = this.produced + 1;
            if (r1 != this.limit) goto L9;
            this.produced = 0;
            this.upstream.request(r1);
            goto L10
        L9:
            this.produced = r1;
            goto L10
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runAsync() {
            org.a.c<? super T> r0 = this.downstream;
            f<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L25;
            boolean r9 = this.done;
            T r10 = r1.poll();     // Catch: Throwable -> L22
            if (r10 != null) goto L10;
            boolean r11 = true;
        L12:
            if (checkTerminated(r9, r11, r0) == true) goto L13;
            if (r11 == true) goto L25;
            r0.onNext(r10);
            r2 = r2 + 1;
            if (r2 != this.limit) goto L5;
            if (r6 == Long.MAX_VALUE) goto L21;
            r6 = this.requested.addAndGet(-r2);
        L21:
            this.upstream.request(r2);
            r2 = 0;
            goto L5
        L13:
            return;
        L10:
            r11 = false;
        L22:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.cancel();
            r1.clear();
            r0.onError(th);
            this.worker.dispose();
            return;
        L25:
            if (r2 == r6) goto L27;
        L29:
            int r7 = get();
            if (r5 == r7) goto L31;
            r5 = r7;
            goto L3
        L31:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        L27:
            if (checkTerminated(this.done, r1.isEmpty(), r0) == false) goto L29;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runBackfused() {
            int r1 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            boolean r2 = this.done;
            this.downstream.onNext(null);
            if (r2 == true) goto L8;
            r1 = addAndGet(-r1);
            if (r1 != 0) goto L4;
            return;
        L8:
            this.cancelled = true;
            Throwable r0 = this.error;
            if (r0 == null) goto L11;
            this.downstream.onError(r0);
        L12:
            this.worker.dispose();
            return;
        L11:
            this.downstream.onComplete();
            goto L12
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void runSync() {
            org.a.c<? super T> r0 = this.downstream;
            f<T> r1 = this.queue;
            long r2 = this.produced;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
        L5:
            if (r2 == r6) goto L18;
            T r8 = r1.poll();     // Catch: Throwable -> L15
            if (this.cancelled == true) goto L9;
            if (r8 == null) goto L11;
            r0.onNext(r8);
            r2 = r2 + 1;
        L11:
            this.cancelled = true;
            r0.onComplete();
        L12:
            this.worker.dispose();
            return;
        L9:
            return;
        L15:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.cancelled = true;
            this.upstream.cancel();
            r0.onError(th);
            goto L12
        L18:
            if (this.cancelled == true) goto L19;
            if (r1.isEmpty() == true) goto L11;
            int r7 = get();
            if (r5 == r7) goto L25;
            r5 = r7;
            goto L3
        L25:
            this.produced = r2;
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r6) {
        org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r6, org.a.c.class, "com.obric.memorydata.plugin");
        u.c r0 = this.c.a();
        if (ZeusTransformUtils.instanceOf(r7, io.reactivex.internal.a.a.class) == false) goto L5;
        this.f16812b.a(new ObserveOnConditionalSubscriber((io.reactivex.internal.a.a) ZeusTransformUtils.preCheckCast(r7, io.reactivex.internal.a.a.class, "com.obric.memorydata.plugin"), r0, this.d, this.e));
        return;
    L5:
        this.f16812b.a(new ObserveOnSubscriber(r7, r0, this.d, this.e));
    }
}
