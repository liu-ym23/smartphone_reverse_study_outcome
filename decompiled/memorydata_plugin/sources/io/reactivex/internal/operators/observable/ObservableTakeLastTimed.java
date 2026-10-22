package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTakeLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17002b;
    final long c;
    final TimeUnit d;
    final u e;
    final int f;
    final boolean g;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final t<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final u scheduler;
        final long time;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        TakeLastTimedObserver(t<? super T> r3, long r4, long r6, TimeUnit r8, u r9, int r10, boolean r11) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.count = r4;
            this.time = r6;
            this.unit = r8;
            this.scheduler = r9;
            this.queue = new io.reactivex.internal.queue.a(r10);
            this.delayError = r11;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true) == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            t<? super T> r2 = this.downstream;
            io.reactivex.internal.queue.a<Object> r3 = this.queue;
            boolean r4 = this.delayError;
            long r5 = this.scheduler.b(this.unit) - this.time;
        L7:
            if (this.cancelled == true) goto L8;
            if (r4 == true) goto L15;
            Throwable r7 = this.error;
            if (r7 == null) goto L15;
            r3.clear();
            r2.onError(r7);
            return;
        L15:
            Object r8 = r3.poll();
            if (r8 != null) goto L18;
            boolean r9 = true;
        L19:
            if (r9 == true) goto L20;
            Object r10 = r3.poll();
            if (((Long) ZeusTransformUtils.preCheckCast(r8, Long.class, "com.obric.memorydata.plugin")).longValue() < r5) goto L7;
            r2.onNext(r10);
            goto L7
        L20:
            Throwable r11 = this.error;
            if (r11 == null) goto L23;
            r2.onError(r11);
            return;
        L23:
            r2.onComplete();
            return;
        L18:
            r9 = false;
            goto L19
        L8:
            r3.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.error = r1;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r13) {
            io.reactivex.internal.queue.a<Object> r0 = this.queue;
            long r1 = this.scheduler.b(this.unit);
            long r3 = this.time;
            long r5 = this.count;
            if (r5 != Long.MAX_VALUE) goto L5;
            boolean r12 = true;
        L6:
            r0.a(Long.valueOf(r1), r13);
        L8:
            if (r0.isEmpty() == true) goto L15;
            if (((Long) ZeusTransformUtils.preCheckCast(r0.a(), Long.class, "com.obric.memorydata.plugin")).longValue() <= (r1 - r3)) goto L14;
            if (r12 == true) goto L21;
            if ((r0.b() >> 1) > r5) goto L14;
            return;
        L21:
            return;
        L14:
            r0.poll();
            r0.poll();
            goto L8
        L15:
            return;
        L5:
            r12 = false;
            goto L6
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
    public void a(t<? super T> r12) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r12, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new TakeLastTimedObserver(r1, this.f17002b, this.c, this.d, this.e, this.f, this.g));
    }
}
