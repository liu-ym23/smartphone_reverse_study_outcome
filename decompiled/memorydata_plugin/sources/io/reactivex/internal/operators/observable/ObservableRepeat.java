package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRepeat<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16976b;

    static final class RepeatObserver<T> extends AtomicInteger implements t<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final t<? super T> downstream;
        long remaining;
        final SequentialDisposable sd;
        final s<? extends T> source;

        RepeatObserver(t<? super T> r3, long r4, SequentialDisposable r6, s<? extends T> r7) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            s<? extends T> r8 = (s) ZeusTransformUtils.wrapperContextForParams(r7, s.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.sd = r6;
            this.source = r8;
            this.remaining = r4;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 == 0) goto L8;
            subscribeNext();
            return;
        L8:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            this.sd.replace(r4);
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.sd.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r8) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        SequentialDisposable r4 = new SequentialDisposable();
        r1.onSubscribe(r4);
        long r2 = this.f16976b;
        if (r2 == Long.MAX_VALUE) goto L5;
        long r3 = r2 - 1;
    L6:
        new RepeatObserver(r1, r3, r4, this.f17034a).subscribeNext();
        return;
    L5:
        r3 = Long.MAX_VALUE;
        goto L6
    }
}
