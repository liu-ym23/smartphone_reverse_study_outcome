package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableFlatMapCompletable<T> extends a<T, T> {
    final h<? super T, ? extends e> c;
    final int d;
    final boolean e;

    static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements j<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final org.a.c<? super T> downstream;
        final AtomicThrowable errors;
        final h<? super T, ? extends e> mapper;
        final int maxConcurrency;
        final io.reactivex.disposables.a set;
        org.a.d upstream;

        final class InnerConsumer extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;
            final /* synthetic */ FlatMapCompletableMainSubscriber this$0;

            InnerConsumer(FlatMapCompletableMainSubscriber r1) {
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

            @Override // io.reactivex.c
            public void onComplete() {
                this.this$0.innerComplete(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable r2) {
                this.this$0.innerError(this, r2);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        FlatMapCompletableMainSubscriber(org.a.c<? super T> r3, h<? super T, ? extends e> r4, boolean r5, int r6) {
            org.a.c<? super T> r7 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends e> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.mapper = r8;
            this.delayErrors = r5;
            this.errors = new AtomicThrowable();
            this.set = new io.reactivex.disposables.a();
            this.maxConcurrency = r6;
            lazySet(1);
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.internal.a.f
        public void clear() {
        }

        void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerConsumer r2) {
            this.set.delete(r2);
            onComplete();
        }

        void innerError(FlatMapCompletableMainSubscriber<T>.InnerConsumer r2, Throwable r3) {
            this.set.delete(r2);
            onError(r3);
        }

        @Override // io.reactivex.internal.a.f
        public boolean isEmpty() {
            return true;
        }

        @Override // org.a.c
        public void onComplete() {
            if (decrementAndGet() != 0) goto L9;
            Throwable r0 = this.errors.terminate();
            org.a.c<? super T> r2 = this.downstream;
            if (r0 == null) goto L7;
            r2.onError(r0);
            return;
        L7:
            r2.onComplete();
            return;
        L9:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
            this.upstream.request(1);
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r3) {
            if (this.errors.addThrowable(r3) == true) goto L5;
            io.reactivex.d.a.a(r3);
            return;
        L5:
            if (this.delayErrors == true) goto L7;
            cancel();
            if (getAndSet(0) <= 0) goto L19;
        L14:
            Throwable r4 = this.errors.terminate();
            this.downstream.onError(r4);
            return;
        L19:
            return;
        L7:
            if (decrementAndGet() == 0) goto L14;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L17;
            this.upstream.request(1);
            return;
        }

        @Override // org.a.c
        public void onNext(T r3) {
            e r4 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            getAndIncrement();
            InnerConsumer r0 = new InnerConsumer(this);
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

        @Override // io.reactivex.internal.a.f
        public T poll() {
            return null;
        }

        @Override // org.a.d
        public void request(long r1) {
        }

        @Override // io.reactivex.internal.a.c
        public int requestFusion(int r1) {
            return r1 & 2;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r5) {
        org.a.c r6 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r5, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new FlatMapCompletableMainSubscriber(r6, this.c, this.e, this.d));
    }
}
