package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableSkipLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16996b;
    final TimeUnit c;
    final u d;
    final int e;
    final boolean f;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final t<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final u scheduler;
        final long time;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        SkipLastTimedObserver(t<? super T> r3, long r4, TimeUnit r6, u r7, int r8, boolean r9) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.time = r4;
            this.unit = r6;
            this.scheduler = r7;
            this.queue = new io.reactivex.internal.queue.a(r8);
            this.delayError = r9;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            t<? super T> r1 = this.downstream;
            io.reactivex.internal.queue.a<Object> r2 = this.queue;
            boolean r3 = this.delayError;
            TimeUnit r4 = this.unit;
            u r5 = this.scheduler;
            long r6 = this.time;
            int r9 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r10 = this.done;
            Long r11 = (Long) ZeusTransformUtils.preCheckCast(r2.a(), Long.class, "com.obric.memorydata.plugin");
            if (r11 != null) goto L13;
            boolean r12 = true;
        L14:
            long r13 = r5.b(r4);
            if (r12 == false) goto L17;
        L19:
            if (r10 == false) goto L34;
            if (r3 == false) goto L27;
            if (r12 == false) goto L34;
            Throwable r0 = this.error;
            if (r0 == null) goto L25;
            r1.onError(r0);
            return;
        L25:
            r1.onComplete();
            return;
        L27:
            Throwable r14 = this.error;
            if (r14 != null) goto L29;
            if (r12 == false) goto L34;
            r1.onComplete();
            return;
        L29:
            this.queue.clear();
            r1.onError(r14);
            return;
        L34:
            if (r12 == true) goto L35;
            r2.poll();
            r1.onNext(r2.poll());
            goto L7
        L35:
            r9 = addAndGet(-r9);
            if (r9 != 0) goto L7;
            return;
        L17:
            if (r11.longValue() <= (r13 - r6)) goto L19;
            r12 = true;
            goto L19
        L13:
            r12 = false;
            goto L14
        L8:
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.error = r1;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.t
        public void onNext(T r4) {
            this.queue.a(Long.valueOf(this.scheduler.b(this.unit)), r4);
            drain();
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
    public void a(t<? super T> r10) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r10, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new SkipLastTimedObserver(r1, this.f16996b, this.c, this.d, this.e, this.f));
    }
}
