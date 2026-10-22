package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.j;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableCombineLatest<T, R> extends g<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<? extends T>[] f16763b;
    final Iterable<? extends org.a.b<? extends T>> c;
    final h<? super Object[], ? extends R> d;
    final int e;
    final boolean f;

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        volatile boolean cancelled;
        final h<? super Object[], ? extends R> combiner;
        int completedSources;
        final boolean delayErrors;
        volatile boolean done;
        final org.a.c<? super R> downstream;
        final AtomicReference<Throwable> error;
        final Object[] latest;
        int nonEmptySources;
        boolean outputFused;
        final io.reactivex.internal.queue.a<Object> queue;
        final AtomicLong requested;
        final CombineLatestInnerSubscriber<T>[] subscribers;

        CombineLatestCoordinator(org.a.c<? super R> r3, h<? super Object[], ? extends R> r4, int r5, int r6, boolean r7) {
            org.a.c<? super R> r8 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super Object[], ? extends R> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r8;
            this.combiner = r9;
            CombineLatestInnerSubscriber<T>[] r10 = new CombineLatestInnerSubscriber[r5];
            int r11 = 0;
        L3:
            if (r11 >= r5) goto L5;
            r10[r11] = new CombineLatestInnerSubscriber(this, r11, r6);
            r11 = r11 + 1;
            goto L3
        L5:
            this.subscribers = r10;
            this.latest = new Object[r5];
            this.queue = new io.reactivex.internal.queue.a(r6);
            this.requested = new AtomicLong();
            this.error = new AtomicReference();
            this.delayErrors = r7;
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            cancelAll();
        }

        void cancelAll() {
            CombineLatestInnerSubscriber<T>[] r3 = this.subscribers;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r3[r1].cancel();
            r1 = r1 + 1;
            goto L3
        }

        boolean checkTerminated(boolean r3, boolean r4, org.a.c<?> r5, io.reactivex.internal.queue.a<?> r6) {
            org.a.c r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
            if (this.cancelled == false) goto L6;
            cancelAll();
            r6.clear();
            return true;
        L6:
            if (r3 == true) goto L8;
            return false;
        L8:
            if (this.delayErrors == false) goto L17;
            if (r4 == false) goto L28;
            cancelAll();
            Throwable r2 = ExceptionHelper.a(this.error);
            if (r2 != null) goto L13;
        L15:
            r7.onComplete();
        L16:
            return true;
        L13:
            if (r2 == ExceptionHelper.f17150a) goto L15;
            r7.onError(r2);
            goto L16
        L28:
            return false;
        L17:
            Throwable r8 = ExceptionHelper.a(this.error);
            if (r8 != null) goto L20;
        L23:
            if (r4 == false) goto L29;
            cancelAll();
            r7.onComplete();
            return true;
        L29:
            return false;
        L20:
            if (r8 == ExceptionHelper.f17150a) goto L23;
            cancelAll();
            r6.clear();
            r7.onError(r8);
            return true;
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
            this.queue.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.outputFused == false) goto L8;
            drainOutput();
            return;
        L8:
            drainAsync();
        }

        void drainAsync() {
            org.a.c<? super R> r0 = this.downstream;
            io.reactivex.internal.queue.a<?> r1 = this.queue;
            int r3 = 1;
        L3:
            long r4 = this.requested.get();
            long r8 = 0;
        L5:
            if (r8 == r4) goto L21;
            boolean r11 = this.done;
            Object r12 = r1.poll();
            if (r12 != null) goto L9;
            boolean r13 = true;
        L11:
            if (checkTerminated(r11, r13, r0, r1) == true) goto L12;
            if (r13 == true) goto L21;
            r0.onNext((Object) io.reactivex.internal.functions.a.a(this.combiner.apply((Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r1.poll(), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin")), "The combiner returned a null value"));
            ((CombineLatestInnerSubscriber) ZeusTransformUtils.preCheckCast(r12, CombineLatestInnerSubscriber.class, "com.obric.memorydata.plugin")).requestOne();
            r8 = r8 + 1;
        L18:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            cancelAll();
            ExceptionHelper.a(this.error, th);
            r0.onError(ExceptionHelper.a(this.error));
            return;
        L12:
            return;
        L9:
            r13 = false;
        L21:
            if (r8 != r4) goto L26;
            if (checkTerminated(this.done, r1.isEmpty(), r0, r1) == false) goto L26;
            return;
        L26:
            if (r8 != 0) goto L28;
        L30:
            r3 = addAndGet(-r3);
            if (r3 != 0) goto L3;
            return;
        L28:
            if (r4 == Long.MAX_VALUE) goto L30;
            this.requested.addAndGet(-r8);
            goto L30
        }

        void drainOutput() {
            org.a.c<? super R> r0 = this.downstream;
            io.reactivex.internal.queue.a<Object> r1 = this.queue;
            int r2 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            Throwable r3 = (Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L9;
            boolean r4 = this.done;
            boolean r5 = r1.isEmpty();
            if (r5 == true) goto L14;
            r0.onNext(null);
        L14:
            if (r4 == false) goto L18;
            if (r5 == false) goto L18;
            r0.onComplete();
            return;
        L18:
            r2 = addAndGet(-r2);
            if (r2 != 0) goto L4;
            return;
        L9:
            r1.clear();
            r0.onError(r3);
            return;
        L5:
            r1.clear();
        }

        void innerComplete(int r3) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L14
            if (r0[r3] == null) goto L7;
            int r4 = this.completedSources + 1;     // Catch: Throwable -> L14
            if (r4 == r0.length) goto L7;
            this.completedSources = r4;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L7:
            this.done = true;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            drain();
            return;
        L14:
            th = move-exception;
            throw th;
        }

        void innerError(int r2, Throwable r3) {
            if (ExceptionHelper.a(this.error, r3) == true) goto L5;
            io.reactivex.d.a.a(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            cancelAll();
            this.done = true;
            drain();
            return;
        L7:
            innerComplete(r2);
        }

        void innerValue(int r4, T r5) {
            monitor-enter(this);
            Object[] r0 = this.latest;     // Catch: Throwable -> L15
            int r1 = this.nonEmptySources;     // Catch: Throwable -> L15
            if (r0[r4] != null) goto L6;
            r1 = r1 + 1;     // Catch: Throwable -> L15
            this.nonEmptySources = r1;     // Catch: Throwable -> L15
        L6:
            r0[r4] = r5;     // Catch: Throwable -> L15
            if (r0.length != r1) goto L9;
            this.queue.a(this.subscribers[r4], r0.clone());     // Catch: Throwable -> L15
            boolean r6 = false;
        L10:
            monitor-exit(this);     // Catch: Throwable -> L15
            if (r6 == false) goto L13;
            this.subscribers[r4].requestOne();
            return;
        L13:
            drain();
            return;
        L9:
            r6 = true;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.a.f
        public R poll() {
            Object r0 = this.queue.poll();
            if (r0 != null) goto L6;
            return null;
        L6:
            Object[] r1 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(this.queue.poll(), Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
            R r4 = (R) io.reactivex.internal.functions.a.a(this.combiner.apply(r1), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) ZeusTransformUtils.preCheckCast(r0, CombineLatestInnerSubscriber.class, "com.obric.memorydata.plugin")).requestOne();
            return r4;
        }

        @Override // org.a.d
        public void request(long r2) {
            if (SubscriptionHelper.validate(r2) == false) goto L6;
            io.reactivex.internal.util.b.a(this.requested, r2);
            drain();
            return;
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r3) {
            boolean r1 = false;
            if ((r3 & 4) == 0) goto L5;
            return 0;
        L5:
            int r4 = r3 & 2;
            if (r4 == 0) goto L8;
            r1 = true;
        L8:
            this.outputFused = r1;
            return r4;
        }

        void subscribe(org.a.b<? extends T>[] r5, int r6) {
            CombineLatestInnerSubscriber<T>[] r0 = this.subscribers;
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L10;
            if (this.done == true) goto L14;
            if (this.cancelled == true) goto L15;
            r5[r1].subscribe(r0[r1]);
            r1 = r1 + 1;
            goto L3
        L15:
            return;
        L14:
            return;
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<org.a.d> implements j<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        final int index;
        final int limit;
        final CombineLatestCoordinator<T, ?> parent;
        final int prefetch;
        int produced;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> r1, int r2, int r3) {
            this.parent = r1;
            this.index = r2;
            this.prefetch = r3;
            this.limit = r3 - (r3 >> 2);
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.parent.innerError(this.index, r2);
        }

        @Override // org.a.c
        public void onNext(T r2) {
            this.parent.innerValue(this.index, r2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d r3) {
            SubscriptionHelper.setOnce(this, (org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin"), this.prefetch);
        }

        public void requestOne() {
            int r0 = this.produced + 1;
            if (r0 != this.limit) goto L5;
            this.produced = 0;
            ((org.a.d) ZeusTransformUtils.preCheckCast(get(), org.a.d.class, "com.obric.memorydata.plugin")).request(r0);
            return;
        L5:
            this.produced = r0;
        }
    }

    final class a implements h<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowableCombineLatest f16764a;

        a(FlowableCombineLatest r1) {
            this.f16764a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.b.h
        public R apply(T r3) {
            return this.f16764a.d.apply(new Object[]{r3});
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super R> r10) {
        org.a.c r11 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r10, org.a.c.class, "com.obric.memorydata.plugin");
        org.a.b<? extends T>[] r0 = this.f16763b;
        if (r0 != null) goto L24;
        r0 = new org.a.b[8];
        Iterator r3 = (Iterator) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.iterator(), "The iterator returned is null"), Iterator.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        int r4 = 0;
    L39:
        if (r3.hasNext() == false) goto L25;
        org.a.b<? extends T> r5 = (org.a.b) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r3.next(), "The publisher returned by the iterator is null"), org.a.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r4 != r0.length) goto L14;
        org.a.b<? extends T>[] r6 = new org.a.b[(r4 >> 2) + r4];
        System.arraycopy(r0, 0, r6, 0, r4);
        r0 = r6;
    L14:
        r0[r4] = r5;
        r4 = r4 + 1;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r11);
        return;
    L25:
        int r1 = r4;
        if (r1 != 0) goto L30;
        EmptySubscription.complete(r11);
        return;
    L30:
        if (r1 != 1) goto L33;
        r0[0].subscribe(new b.C0873b(r11, new a(this)));
        return;
    L33:
        CombineLatestCoordinator r8 = new CombineLatestCoordinator(r11, this.d, r1, this.e, this.f);
        r11.onSubscribe(r8);
        r8.subscribe(r0, r1);
        return;
    L18:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r11);
        return;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptySubscription.error(th, r11);
        return;
    L24:
        r4 = r0.length;
        goto L25
    }
}
