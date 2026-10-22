package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableDebounceTimed<T> extends a<T, T> {
    final long c;
    final TimeUnit d;
    final u e;

    static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once;
        final DebounceTimedSubscriber<T> parent;
        final T value;

        DebounceEmitter(T r2, long r3, DebounceTimedSubscriber<T> r5) {
            this.once = new AtomicBoolean();
            this.value = r2;
            this.idx = r3;
            this.parent = r5;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        void emit() {
            if (this.once.compareAndSet(false, true) == false) goto L6;
            this.parent.emit(this.idx, this.value, this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }

        public void setResource(io.reactivex.disposables.b r3) {
            DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements j<T>, org.a.d {
        private static final long serialVersionUID = -9102637559663639004L;
        boolean done;
        final org.a.c<? super T> downstream;
        volatile long index;
        final long timeout;
        io.reactivex.disposables.b timer;
        final TimeUnit unit;
        org.a.d upstream;
        final u.c worker;

        DebounceTimedSubscriber(org.a.c<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
        }

        @Override // org.a.d
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        void emit(long r3, T r5, DebounceEmitter<T> r6) {
            if (r3 == this.index) goto L5;
            return;
        L5:
            if (get() == 0) goto L7;
            this.downstream.onNext(r5);
            io.reactivex.internal.util.b.c(this, 1);
            r6.dispose();
            return;
        L7:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        @Override // org.a.c
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            io.reactivex.disposables.b r0 = this.timer;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            DebounceEmitter r1 = (DebounceEmitter) ZeusTransformUtils.preCheckCast(r0, DebounceEmitter.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L11;
            r1.emit();
        L11:
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
            io.reactivex.disposables.b r0 = this.timer;
            if (r0 == null) goto L9;
            r0.dispose();
        L9:
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // org.a.c
        public void onNext(T r5) {
            if (this.done == false) goto L5;
            return;
        L5:
            long r0 = this.index + 1;
            this.index = r0;
            io.reactivex.disposables.b r2 = this.timer;
            if (r2 == null) goto L8;
            r2.dispose();
        L8:
            DebounceEmitter r3 = new DebounceEmitter(r5, r0, this);
            this.timer = r3;
            r3.setResource(this.worker.a(r3, this.timeout, this.unit));
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
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super T> r9) {
        org.a.c r10 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r9, org.a.c.class, "com.obric.memorydata.plugin");
        this.f16812b.a(new DebounceTimedSubscriber(new io.reactivex.subscribers.b(r10), this.c, this.d, this.e.a()));
    }
}
