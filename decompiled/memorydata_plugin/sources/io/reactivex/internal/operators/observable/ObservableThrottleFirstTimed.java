package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableThrottleFirstTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17004b;
    final TimeUnit c;
    final u d;

    static final class DebounceTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, t<T>, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final t<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;
        final u.c worker;

        DebounceTimedObserver(t<? super T> r3, long r4, TimeUnit r6, u.c r7) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.timeout = r4;
            this.unit = r6;
            this.worker = r7;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            if (this.done == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            this.done = true;
            this.downstream.onError(r2);
            this.worker.dispose();
        }

        @Override // io.reactivex.t
        public void onNext(T r4) {
            if (this.gate == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L12;
            this.gate = true;
            this.downstream.onNext(r4);
            io.reactivex.disposables.b r5 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L9;
            r5.dispose();
        L9:
            DisposableHelper.replace(this, this.worker.a(this, this.timeout, this.unit));
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r9) {
        t r10 = (t) ZeusTransformUtils.wrapperContextForParams(r9, t.class, "com.obric.memorydata.plugin");
        this.f17034a.subscribe(new DebounceTimedObserver(new io.reactivex.observers.b(r10), this.f17004b, this.c, this.d.a()));
    }
}
