package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.a.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableConcat extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b<? extends e> f16729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16730b;

    static final class CompletableConcatSubscriber extends AtomicInteger implements io.reactivex.disposables.b, j<e> {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        int consumed;
        volatile boolean done;
        final c downstream;
        final ConcatInnerObserver inner;
        final int limit;
        final AtomicBoolean once;
        final int prefetch;
        f<e> queue;
        int sourceFused;
        d upstream;

        static final class ConcatInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c {
            private static final long serialVersionUID = -5454794857847146511L;
            final CompletableConcatSubscriber parent;

            ConcatInnerObserver(CompletableConcatSubscriber r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }

            @Override // io.reactivex.c
            public void onError(Throwable r1) {
                this.parent.innerError(r1);
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }
        }

        CompletableConcatSubscriber(c r3, int r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.prefetch = r4;
            this.inner = new ConcatInnerObserver(this);
            this.once = new AtomicBoolean();
            this.limit = r4 - (r4 >> 2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.inner);
        }

        void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (isDisposed() == true) goto L7;
            if (this.active == true) goto L28;
            boolean r0 = this.done;
            e r1 = (e) ZeusTransformUtils.preCheckCast(this.queue.poll(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
            if (r1 != null) goto L15;
            boolean r4 = true;
        L16:
            if (r0 == false) goto L22;
            if (r4 == false) goto L22;
            if (this.once.compareAndSet(false, true) == false) goto L36;
            this.downstream.onComplete();
            return;
        L36:
            return;
        L22:
            if (r4 == true) goto L28;
            this.active = true;
            r1.a(this.inner);
            request();
            goto L28
        L15:
            r4 = false;
        L24:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            innerError(th);
            return;
        L28:
            if (decrementAndGet() != 0) goto L6;
            return;
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        void innerError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            this.upstream.cancel();
            this.downstream.onError(r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.inner.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.c
        public void onError(Throwable r4) {
            if (this.once.compareAndSet(false, true) == false) goto L5;
            DisposableHelper.dispose(this.inner);
            this.downstream.onError(r4);
            return;
        L5:
            io.reactivex.d.a.a(r4);
        }

        public void onNext(e r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
            if (this.sourceFused == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r4) == true) goto L8;
            onError(new MissingBackpressureException());
        }

        @Override // org.a.c
        public /* synthetic */ void onNext(Object r3) {
            onNext((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r7) {
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
            if (SubscriptionHelper.validate(this.upstream, r8) == false) goto L24;
            this.upstream = r8;
            int r0 = this.prefetch;
            if (r0 != Integer.MAX_VALUE) goto L7;
            long r3 = Long.MAX_VALUE;
        L9:
            if (ZeusTransformUtils.instanceOf(r8, io.reactivex.internal.a.d.class) == false) goto L19;
            io.reactivex.internal.a.d r1 = (io.reactivex.internal.a.d) ZeusTransformUtils.preCheckCast(r8, io.reactivex.internal.a.d.class, "com.obric.memorydata.plugin");
            int r2 = r1.requestFusion(3);
            if (r2 != 1) goto L15;
            this.sourceFused = r2;
            this.queue = r1;
            this.done = true;
            this.downstream.onSubscribe(this);
            drain();
            return;
        L15:
            if (r2 != 2) goto L19;
            this.sourceFused = r2;
            this.queue = r1;
            this.downstream.onSubscribe(this);
            r8.request(r3);
            return;
        L19:
            if (this.prefetch != Integer.MAX_VALUE) goto L21;
            f<e> r4 = new io.reactivex.internal.queue.a(g.a());
        L22:
            this.queue = r4;
            this.downstream.onSubscribe(this);
            r8.request(r3);
            return;
        L21:
            r4 = new SpscArrayQueue(this.prefetch);
            goto L22
        L7:
            r3 = r0;
            goto L9
        }

        void request() {
            if (this.sourceFused == 1) goto L9;
            int r0 = this.consumed + 1;
            if (r0 != this.limit) goto L7;
            this.consumed = 0;
            this.upstream.request(r0);
            return;
        L7:
            this.consumed = r0;
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16729a.subscribe(new CompletableConcatSubscriber(r4, this.f16730b));
    }
}
