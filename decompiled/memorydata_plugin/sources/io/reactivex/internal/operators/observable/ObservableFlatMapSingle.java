package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import defpackage.$$Lambda$g$NFitCGeARaziAziawMJBYS968oA;
import io.reactivex.Observable;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.t;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableFlatMapSingle<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends z<? extends R>> f16948b;
    final boolean c;

    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active;
        volatile boolean cancelled;
        final boolean delayErrors;
        final t<? super R> downstream;
        final AtomicThrowable errors;
        final h<? super T, ? extends z<? extends R>> mapper;
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue;
        final io.reactivex.disposables.a set;
        io.reactivex.disposables.b upstream;

        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, x<R> {
            private static final long serialVersionUID = -502562646270949838L;
            final /* synthetic */ FlatMapSingleObserver this$0;

            InnerObserver(FlatMapSingleObserver r1) {
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

        FlatMapSingleObserver(t<? super R> r3, h<? super T, ? extends z<? extends R>> r4, boolean r5) {
            t<? super R> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.mapper = r7;
            this.delayErrors = r5;
            this.set = new io.reactivex.disposables.a();
            this.errors = new AtomicThrowable();
            this.active = new AtomicInteger(1);
            this.queue = new AtomicReference();
        }

        void clear() {
            io.reactivex.internal.queue.a r2 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.clear();
            return;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) goto L6;
            drainLoop();
            return;
        }

        void drainLoop() {
            t<? super R> r0 = this.downstream;
            AtomicInteger r1 = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> r2 = this.queue;
            int r4 = 1;
        L4:
            if (this.cancelled == true) goto L5;
            if (this.delayErrors == false) goto L10;
        L13:
            boolean r7 = false;
            if (r1.get() != 0) goto L16;
            boolean r5 = true;
        L17:
            io.reactivex.internal.queue.a r6 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(r2.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L20;
            $$Lambda$g$NFitCGeARaziAziawMJBYS968oA r8 = (Object) r6.poll();
        L21:
            if (r8 != null) goto L23;
            r7 = true;
        L23:
            if (r5 == false) goto L30;
            if (r7 == false) goto L30;
            Throwable r10 = this.errors.terminate();
            if (r10 == null) goto L28;
            r0.onError(r10);
            return;
        L28:
            r0.onComplete();
            return;
        L30:
            if (r7 == true) goto L31;
            r0.onNext(r8);
            goto L4
        L31:
            r4 = addAndGet(-r4);
            if (r4 != 0) goto L4;
            return;
        L20:
            r8 = null;
            goto L21
        L16:
            r5 = false;
            goto L17
        L10:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.errors.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L13;
            Throwable r3 = this.errors.terminate();
            clear();
            r0.onError(r3);
            return;
        L5:
            clear();
        }

        io.reactivex.internal.queue.a<R> getOrCreateQueue() {
        L2:
            io.reactivex.internal.queue.a<R> r0 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L4;
            io.reactivex.internal.queue.a<R> r1 = new io.reactivex.internal.queue.a(Observable.a());
            if (this.queue.compareAndSet(null, r1) == false) goto L2;
            return r1;
        L4:
            return r0;
        }

        void innerError(FlatMapSingleObserver<T, R>.InnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            if (this.errors.addThrowable(r3) == true) goto L5;
            io.reactivex.d.a.a(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            this.upstream.dispose();
            this.set.dispose();
        L7:
            this.active.decrementAndGet();
            drain();
        }

        void innerSuccess(FlatMapSingleObserver<T, R>.InnerObserver r3, R r4) {
            this.set.delete(r3);
            if (get() != 0) goto L22;
            boolean r5 = false;
            if (compareAndSet(0, 1) == false) goto L22;
            this.downstream.onNext(r4);
            if (this.active.decrementAndGet() != 0) goto L9;
            r5 = true;
        L9:
            io.reactivex.internal.queue.a r6 = (io.reactivex.internal.queue.a) ZeusTransformUtils.preCheckCast(this.queue.get(), io.reactivex.internal.queue.a.class, "com.obric.memorydata.plugin");
            if (r5 == false) goto L20;
            if (r6 != null) goto L13;
        L14:
            Throwable r7 = this.errors.terminate();
            t<? super R> r2 = this.downstream;
            if (r7 == null) goto L17;
            r2.onError(r7);
            return;
        L17:
            r2.onComplete();
            return;
        L13:
            if (r6.isEmpty() == true) goto L14;
        L20:
            if (decrementAndGet() != 0) goto L29;
            return;
        L29:
            drainLoop();
            return;
        L22:
            io.reactivex.internal.queue.a<R> r8 = getOrCreateQueue();
            monitor-enter(r8);
            r8.offer(r4);     // Catch: Throwable -> L31
            monitor-exit(r8);     // Catch: Throwable -> L31
            this.active.decrementAndGet();
            if (getAndIncrement() == 0) goto L29;
            return;
        L31:
            th = move-exception;
            throw th;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.t
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

        @Override // io.reactivex.t
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
            this.upstream.dispose();
            onError(th);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super R> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new FlatMapSingleObserver(r5, this.f16948b, this.c));
    }
}
