package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableMerge extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b<? extends e> f16738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16739b;
    final boolean c;

    static final class CompletableMergeSubscriber extends AtomicInteger implements io.reactivex.disposables.b, j<e> {
        private static final long serialVersionUID = -2108443387387077490L;
        final boolean delayErrors;
        final c downstream;
        final AtomicThrowable error;
        final int maxConcurrency;
        final io.reactivex.disposables.a set;
        d upstream;

        final class MergeInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 251330541679988317L;
            final /* synthetic */ CompletableMergeSubscriber this$0;

            MergeInnerObserver(CompletableMergeSubscriber r1) {
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

        CompletableMergeSubscriber(c r3, int r4, boolean r5) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.maxConcurrency = r4;
            this.delayErrors = r5;
            this.set = new io.reactivex.disposables.a();
            this.error = new AtomicThrowable();
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            this.set.dispose();
        }

        void innerComplete(MergeInnerObserver r3) {
            this.set.delete(r3);
            if (decrementAndGet() != 0) goto L9;
            Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin");
            c r2 = this.downstream;
            if (r4 == null) goto L7;
            r2.onError(r4);
            return;
        L7:
            r2.onComplete();
            return;
        L9:
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L14;
            this.upstream.request(1);
            return;
        }

        void innerError(MergeInnerObserver r2, Throwable r3) {
            this.set.delete(r2);
            if (this.delayErrors == true) goto L10;
            this.upstream.cancel();
            this.set.dispose();
            if (this.error.addThrowable(r3) == true) goto L7;
        L17:
            io.reactivex.d.a.a(r3);
            return;
        L7:
            if (getAndSet(0) <= 0) goto L19;
        L13:
            this.downstream.onError(this.error.terminate());
            return;
        L19:
            return;
        L10:
            if (this.error.addThrowable(r3) == false) goto L17;
            if (decrementAndGet() == 0) goto L13;
            if (this.maxConcurrency == Integer.MAX_VALUE) goto L21;
            this.upstream.request(1);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // org.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) goto L5;
            return;
        L5:
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.error.get(), Throwable.class, "com.obric.memorydata.plugin")) == null) goto L7;
            this.downstream.onError(this.error.terminate());
            return;
        L7:
            this.downstream.onComplete();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.delayErrors == true) goto L10;
            this.set.dispose();
            if (this.error.addThrowable(r2) == true) goto L7;
        L14:
            io.reactivex.d.a.a(r2);
            return;
        L7:
            if (getAndSet(0) <= 0) goto L16;
        L13:
            this.downstream.onError(this.error.terminate());
            return;
        L16:
            return;
        L10:
            if (this.error.addThrowable(r2) == false) goto L14;
            if (decrementAndGet() == 0) goto L13;
        }

        public void onNext(e r3) {
            e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");
            getAndIncrement();
            MergeInnerObserver r0 = new MergeInnerObserver(this);
            this.set.a(r0);
            r4.a(r0);
        }

        @Override // org.a.c
        public /* synthetic */ void onNext(Object r3) {
            onNext((e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
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
    }

    @Override // io.reactivex.a
    public void b(c r4) {
        CompletableMergeSubscriber r0 = new CompletableMergeSubscriber((c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"), this.f16739b, this.c);
        this.f16738a.subscribe(r0);
    }
}
