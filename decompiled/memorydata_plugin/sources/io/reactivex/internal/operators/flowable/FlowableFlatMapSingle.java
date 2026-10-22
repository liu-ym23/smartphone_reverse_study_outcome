package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.b.h;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFlatMapSingle<T, R> extends a<T, R> {
    final h<? super T, ? extends z<? extends R>> c;
    final boolean d;
    final int e;

    static final class FlatMapSingleSubscriber<T, R> extends AtomicInteger implements j<T>, org.a.d {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final org.a.c<? super R> downstream;
        final AtomicThrowable errors;
        final h<? super T, ? extends z<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue;
        final AtomicLong requested;
        final io.reactivex.disposables.a set;
        org.a.d upstream;

        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, x<R> {
            private static final long serialVersionUID = -502562646270949838L;
            final /* synthetic */ FlatMapSingleSubscriber this$0;

            InnerObserver(FlatMapSingleSubscriber r1) {
                this.this$0 = r1;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.x
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.x
            public void onSuccess(R r2) {
                this.this$0.innerSuccess(this, r2);
            }
        }

        FlatMapSingleSubscriber(org.a.c<? super R> r3, h<? super T, ? extends z<? extends R>> r4, boolean r5, int r6) {
            org.a.c<? super R> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.delayErrors = r5;
            this.maxConcurrency = r6;
            this.requested = new AtomicLong();
            this.set = new io.reactivex.disposables.a();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference();
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        void clear() {
            io.reactivex.internal.queue.a r2 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.clear();
            return;
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            org.a.c<? super R> r1 = this.downstream;
            AtomicInteger r2 = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> r3 = this.queue;
            int r5 = 1;
        L3:
            long r6 = this.requested.get();
            long r10 = 0;
        L5:
            if (r10 == r6) goto L37;
            if (this.cancelled == true) goto L8;
            if (this.delayErrors == true) goto L17;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L17;
        L14:
            Throwable r4 = this.errors.terminate();
            clear();
            r1.onError(r4);
            return;
        L17:
            if (r2.get() != 0) goto L19;
            boolean r7 = true;
        L20:
            io.reactivex.internal.queue.a r13 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(r3.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r13 == null) goto L23;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r14 = (Object) r13.poll();
        L24:
            if (r14 != null) goto L26;
            boolean r15 = true;
        L27:
            if (r7 == false) goto L34;
            if (r15 == false) goto L34;
            Throwable r0 = this.errors.terminate();
            if (r0 == null) goto L32;
            r1.onError(r0);
            return;
        L32:
            r1.onComplete();
            return;
        L34:
            if (r15 == true) goto L37;
            r1.onNext(r14);
            r10 = r10 + 1;
            goto L5
        L26:
            r15 = false;
            goto L27
        L23:
            r14 = null;
            goto L24
        L19:
            r7 = false;
            goto L20
        L8:
            clear();
            return;
        L37:
            if (r10 != r6) goto L66;
            if (this.cancelled == true) goto L40;
            if (this.delayErrors == true) goto L48;
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) != null) goto L14;
        L48:
            if (r2.get() != 0) goto L50;
            boolean r8 = true;
        L51:
            io.reactivex.internal.queue.a r9 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(r3.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r9 != null) goto L54;
        L57:
            boolean r16 = true;
        L58:
            if (r8 == false) goto L66;
            if (r16 == false) goto L66;
            Throwable r11 = this.errors.terminate();
            if (r11 == null) goto L63;
            r1.onError(r11);
            return;
        L63:
            r1.onComplete();
            return;
        L54:
            if (r9.isEmpty() == true) goto L57;
            r16 = false;
            goto L58
        L50:
            r8 = false;
            goto L51
        L40:
            clear();
            return;
        L66:
            if (r10 == 0) goto L70;
            io.reactivex.internal.util.b.c(this.requested, r10);
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L70;
            this.upstream.request(r10);
        L70:
            r5 = addAndGet(-r5);
            if (r5 != 0) goto L3;
        }

        io.reactivex.internal.queue.a<R> getOrCreateQueue() {
        L2:
            io.reactivex.internal.queue.a<R> r0 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L4;
            io.reactivex.internal.queue.a<R> r1 = new io.reactivex.internal.queue.a(g.a());
            if (this.queue.compareAndSet(null, r1) == false) goto L2;
            return r1;
        L4:
            return r0;
        }

        void innerError(FlatMapSingleSubscriber<T, R>.InnerObserver r3, Throwable r4) {
            this.set.delete(r3);
            if (this.errors.addThrowable(r4) == true) goto L5;
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (this.delayErrors == true) goto L8;
            this.upstream.cancel();
            this.set.dispose();
        L10:
            this.active.decrementAndGet();
            drain();
            return;
        L8:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L10;
            this.upstream.request(1);
            goto L10
        }

        void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerObserver r5, R r6) {
            this.set.delete(r5);
            if (get() != 0) goto L34;
            boolean r7 = false;
            if (compareAndSet(0, 1) == false) goto L34;
            if (this.active.decrementAndGet() != 0) goto L10;
            r7 = true;
        L10:
            if (this.requested.get() == 0) goto L24;
            this.downstream.onNext(r6);
            io.reactivex.internal.queue.a r8 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r7 == false) goto L21;
            if (r8 != null) goto L15;
        L16:
            Throwable r9 = this.errors.terminate();
            org.a.c<? super R> r4 = this.downstream;
            if (r9 == null) goto L19;
            r4.onError(r9);
            return;
        L19:
            r4.onComplete();
            return;
        L15:
            if (r8.isEmpty() == true) goto L16;
        L21:
            io.reactivex.internal.util.b.c(this.requested, 1);
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L29;
            this.upstream.request(1);
        L29:
            if (decrementAndGet() != 0) goto L41;
            return;
        L41:
            drainLoop();
            return;
        L24:
            io.reactivex.internal.queue.a<R> r10 = getOrCreateQueue();
            monitor-enter(r10);
            r10.offer(r6);     // Catch: Throwable -> L31
            monitor-exit(r10);     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L34:
            io.reactivex.internal.queue.a<R> r11 = getOrCreateQueue();
            monitor-enter(r11);
            r11.offer(r6);     // Catch: Throwable -> L43
            monitor-exit(r11);     // Catch: Throwable -> L43
            this.active.decrementAndGet();
            if (getAndIncrement() == 0) goto L41;
            return;
        L43:
            th = move-exception;
            throw th;
        }

        @Override // org.a.c
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            this.active.decrementAndGet();
            if (this.errors.addThrowable(r2) == true) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            this.set.dispose();
        L7:
            drain();
        }

        @Override // org.a.c
        public void onNext(T r3) {
            z r4 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            this.active.getAndIncrement();
            InnerObserver r0 = new InnerObserver(this);
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.set.a(r0) == false) goto L15;
            r4.a(r0);
            return;
        L15:
            return;
        L9:
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
    public void a(org.a.c<? super R> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new FlatMapSingleSubscriber(r6, this.c, this.d, this.e));
    }
}
