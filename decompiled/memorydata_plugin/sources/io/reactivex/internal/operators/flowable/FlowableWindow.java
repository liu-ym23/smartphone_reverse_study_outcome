package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableWindow<T> extends a<T, g<T>> {
    final long c;
    final long d;
    final int e;

    static final class WindowExactSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -2365647875069161133L;
        final int bufferSize;
        final org.a.c<? super g<T>> downstream;
        long index;
        final AtomicBoolean once;
        final long size;
        org.a.d upstream;
        UnicastProcessor<T> window;

        WindowExactSubscriber(org.a.c<? super g<T>> r3, long r4, int r6) {
            org.a.c<? super g<T>> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(1);
            this.downstream = r5;
            this.size = r4;
            this.once = new AtomicBoolean();
            this.bufferSize = r6;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // org.a.c
        public void onNext(T r8) {
            long r0 = this.index;
            UnicastProcessor<T> r2 = this.window;
            if (r0 != 0) goto L5;
            getAndIncrement();
            r2 = UnicastProcessor.a(this.bufferSize, this);
            this.window = r2;
            this.downstream.onNext(r2);
        L5:
            long r1 = r0 + 1;
            r2.onNext(r8);
            if (r1 != this.size) goto L8;
            this.index = 0;
            this.window = null;
            r2.onComplete();
            return;
        L8:
            this.index = r1;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r3) {
            if (SubscriptionHelper.validate(r3) == false) goto L6;
            long r4 = io.reactivex.internal.util.b.b(this.size, r3);
            this.upstream.request(r4);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = 2428527070996323976L;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final org.a.c<? super g<T>> downstream;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final io.reactivex.internal.queue.a<UnicastProcessor<T>> queue;
        final AtomicLong requested;
        final long size;
        final long skip;
        org.a.d upstream;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(org.a.c<? super g<T>> r3, long r4, long r6, int r8) {
            org.a.c<? super g<T>> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(1);
            this.downstream = r5;
            this.size = r4;
            this.skip = r6;
            this.queue = new io.reactivex.internal.queue.a(r8);
            this.windows = new ArrayDeque();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = r8;
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<?> r5, io.reactivex.internal.queue.a<?> r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            r6.clear();
            return true;
        L6:
            if (r3 == false) goto L14;
            Throwable r2 = this.error;
            if (r2 == null) goto L11;
            r6.clear();
            r7.onError(r2);
            return true;
        L11:
            if (r4 == false) goto L16;
            r7.onComplete();
            return true;
        L16:
            return false;
        L14:
            return false;
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) goto L5;
            return;
        L5:
            org.a.c<? super g<T>> r0 = this.downstream;
            io.reactivex.internal.queue.a<UnicastProcessor<T>> r1 = this.queue;
            int r3 = 1;
        L6:
            long r4 = this.requested.get();
            long r8 = 0;
        L8:
            if (r8 == r4) goto L19;
            boolean r11 = this.done;
            UnicastProcessor r12 = (UnicastProcessor) ZeusTransformUtils.preCheckCast(r1.poll(), UnicastProcessor.class, "com.obric.memorydata.plugin");
            if (r12 != null) goto L12;
            boolean r13 = true;
        L14:
            if (checkTerminated(r11, r13, r0, r1) == true) goto L15;
            if (r13 == true) goto L19;
            r0.onNext(r12);
            r8 = r8 + 1;
            goto L8
        L15:
            return;
        L12:
            r13 = false;
        L19:
            if (r8 != r4) goto L24;
            if (checkTerminated(this.done, r1.isEmpty(), r0, r1) == false) goto L24;
            return;
        L24:
            if (r8 != 0) goto L26;
        L28:
            r3 = this.wip.addAndGet(-r3);
            if (r3 != 0) goto L6;
            return;
        L26:
            if (r4 == Long.MAX_VALUE) goto L28;
            this.requested.addAndGet(-r8);
            goto L28
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            Iterator<UnicastProcessor<T>> r0 = this.windows.iterator();
        L7:
            if (r0.hasNext() == false) goto L9;
            ((org.a.a) ZeusTransformUtils.preCheckCast(r0.next(), org.a.a.class, "com.obric.memorydata.plugin")).onComplete();
            goto L7
        L9:
            this.windows.clear();
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r5) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r5);
            return;
        L6:
            Iterator<UnicastProcessor<T>> r0 = this.windows.iterator();
        L8:
            if (r0.hasNext() == false) goto L10;
            ((org.a.a) ZeusTransformUtils.preCheckCast(r0.next(), org.a.a.class, "com.obric.memorydata.plugin")).onError(r5);
            goto L8
        L10:
            this.windows.clear();
            this.error = r5;
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onNext(T r11) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index;
            if (r0 == 0) goto L8;
        L10:
            long r1 = r0 + 1;
            Iterator<UnicastProcessor<T>> r6 = this.windows.iterator();
        L12:
            if (r6.hasNext() == false) goto L14;
            ((org.a.a) ZeusTransformUtils.preCheckCast(r6.next(), org.a.a.class, "com.obric.memorydata.plugin")).onNext(r11);
            goto L12
        L14:
            long r7 = this.produced + 1;
            if (r7 != this.size) goto L19;
            this.produced = r7 - this.skip;
            org.a.a r12 = (org.a.a) ZeusTransformUtils.preCheckCast(this.windows.poll(), org.a.a.class, "com.obric.memorydata.plugin");
            if (r12 == null) goto L21;
            r12.onComplete();
        L21:
            if (r1 != this.skip) goto L23;
            this.index = 0;
            return;
        L23:
            this.index = r1;
            return;
        L19:
            this.produced = r7;
            goto L21
        L8:
            if (this.cancelled == true) goto L10;
            getAndIncrement();
            UnicastProcessor<T> r4 = UnicastProcessor.a(this.bufferSize, this);
            this.windows.offer(r4);
            this.queue.offer(r4);
            drain();
            goto L10
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r5) {
            if (SubscriptionHelper.validate(r5) == false) goto L12;
            io.reactivex.internal.util.b.a(this.requested, r5);
            if (this.firstRequest.get() == false) goto L7;
        L9:
            long r6 = io.reactivex.internal.util.b.b(this.skip, r5);
        L10:
            this.upstream.request(r6);
            drain();
            return;
        L7:
            if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
            long r7 = io.reactivex.internal.util.b.b(this.skip, r5 - 1);
            r6 = io.reactivex.internal.util.b.a(this.size, r7);
            goto L10
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    static final class WindowSkipSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -8792836352386833856L;
        final int bufferSize;
        final org.a.c<? super g<T>> downstream;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        final long size;
        final long skip;
        org.a.d upstream;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(org.a.c<? super g<T>> r3, long r4, long r6, int r8) {
            org.a.c<? super g<T>> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            super(1);
            this.downstream = r5;
            this.size = r4;
            this.skip = r6;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = r8;
        }

        @Override // org.a.d
        public void cancel() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            run();
            return;
        }

        @Override // org.a.c
        public void onComplete() {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onComplete();
        L5:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            UnicastProcessor<T> r0 = this.window;
            if (r0 == null) goto L5;
            this.window = null;
            r0.onError(r3);
        L5:
            this.downstream.onError(r3);
        }

        @Override // org.a.c
        public void onNext(T r8) {
            long r0 = this.index;
            UnicastProcessor<T> r2 = this.window;
            if (r0 != 0) goto L5;
            getAndIncrement();
            r2 = UnicastProcessor.a(this.bufferSize, this);
            this.window = r2;
            this.downstream.onNext(r2);
        L5:
            long r1 = r0 + 1;
            if (r2 == null) goto L9;
            r2.onNext(r8);
        L9:
            if (r1 != this.size) goto L12;
            this.window = null;
            r2.onComplete();
        L12:
            if (r1 != this.skip) goto L14;
            this.index = 0;
            return;
        L14:
            this.index = r1;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            org.a.d r4 = (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // org.a.d
        public void request(long r7) {
            if (SubscriptionHelper.validate(r7) == true) goto L5;
            return;
        L5:
            if (this.firstRequest.get() == false) goto L7;
        L9:
            long r8 = io.reactivex.internal.util.b.b(this.skip, r7);
        L10:
            this.upstream.request(r8);
            return;
        L7:
            if (this.firstRequest.compareAndSet(false, true) == false) goto L9;
            r8 = io.reactivex.internal.util.b.a(io.reactivex.internal.util.b.b(this.size, r7), io.reactivex.internal.util.b.b(this.skip - this.size, r7 - 1));
            goto L10
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() != 0) goto L6;
            this.upstream.cancel();
            return;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super g<T>> r9) {
        org.a.c r1 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        long r2 = this.d;
        long r4 = this.c;
        if (r2 != r4) goto L6;
        this.f16812b.a(new WindowExactSubscriber(r1, this.c, this.e));
        return;
    L6:
        if (r2 <= r4) goto L8;
        g<T> r10 = this.f16812b;
        j<? super T> r7 = new WindowSkipSubscriber(r1, this.c, this.d, this.e);
    L9:
        r10.a(r7);
        return;
    L8:
        r10 = this.f16812b;
        r7 = new WindowOverlapSubscriber(r1, this.c, this.d, this.e);
        goto L9
    }
}
