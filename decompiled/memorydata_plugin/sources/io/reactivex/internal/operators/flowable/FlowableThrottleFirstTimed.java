package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableThrottleFirstTimed<T> extends a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -9102637559663639004L;
        boolean done;
        final org.a.c<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final SequentialDisposable timer;
        final TimeUnit unit;
        org.a.d upstream;
        final u.c worker;

        DebounceTimedSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            org.a.c<? super T> r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.timer = new SequentialDisposable();
            this.downstream = r5;
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onError(Throwable r2) {
            if (this.done == false) goto L6;
            io.reactivex.d.a.a(r2);
            return;
        L6:
            this.done = true;
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onNext(T r6) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.gate == true) goto L15;
            this.gate = true;
            if (get() == 0) goto L13;
            this.downstream.onNext(r6);
            io.reactivex.internal.util.b.c(this, 1);
            io.reactivex.disposables.b r7 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.timer.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L12;
            r7.dispose();
        L12:
            this.timer.replace(this.worker.a(this, this.timeout, this.unit));
            return;
        L13:
            this.done = true;
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            return;
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
            io.reactivex.internal.util.b.a(this, r2);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r9) {
        org.a.c r10 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new DebounceTimedSubscriber(new io.reactivex.subscribers.b(r10), this.c, this.d, this.e.a()));
    }
}
