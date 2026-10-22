package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRepeatUntil<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final e f16977b;

    static final class RepeatUntilObserver<T> extends AtomicInteger implements t<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final t<? super T> downstream;
        final s<? extends T> source;
        final e stop;
        final SequentialDisposable upstream;

        RepeatUntilObserver(t<? super T> r3, e r4, SequentialDisposable r5, s<? extends T> r6) {
            t<? super T> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            s<? extends T> r9 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.upstream = r5;
            this.source = r9;
            this.stop = r8;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.stop.getAsBoolean() == false) goto L5;
            this.downstream.onComplete();
            return;
        L5:
            subscribeNext();
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
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
            this.upstream.replace(r4);
        }

        void subscribeNext() {
            if (getAndIncrement() != 0) goto L7;
            int r0 = 1;
        L5:
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L5;
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        SequentialDisposable r0 = new SequentialDisposable();
        r5.onSubscribe(r0);
        new RepeatUntilObserver(r5, this.f16977b, r0, this.f17034a).subscribeNext();
    }
}
