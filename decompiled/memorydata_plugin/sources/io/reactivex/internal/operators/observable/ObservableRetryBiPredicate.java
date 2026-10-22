package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRetryBiPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final d<? super Integer, ? super Throwable> f16981b;

    static final class RetryBiObserver<T> extends AtomicInteger implements t<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final t<? super T> downstream;
        final d<? super Integer, ? super Throwable> predicate;
        int retries;
        final s<? extends T> source;
        final SequentialDisposable upstream;

        RetryBiObserver(t<? super T> r3, d<? super Integer, ? super Throwable> r4, SequentialDisposable r5, s<? extends T> r6) {
            t<? super T> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            d<? super Integer, ? super Throwable> r8 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            s<? extends T> r9 = (s) ZeusTransformUtils.wrapperContextForParams(r6, s.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.upstream = r5;
            this.source = r9;
            this.predicate = r8;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r6) {
            d<? super Integer, ? super Throwable> r1 = this.predicate;     // Catch: Throwable -> L9
            int r2 = this.retries + 1;     // Catch: Throwable -> L9
            this.retries = r2;     // Catch: Throwable -> L9
            if (r1.a(Integer.valueOf(r2), r6) == true) goto L7;
            this.downstream.onError(r6);
            return;
        L7:
            subscribeNext();
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r6, th}));
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
            if (getAndIncrement() != 0) goto L10;
            int r0 = 1;
        L6:
            if (this.upstream.isDisposed() == true) goto L7;
            this.source.subscribe(this);
            r0 = addAndGet(-r0);
            if (r0 != 0) goto L6;
            return;
        L7:
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        SequentialDisposable r0 = new SequentialDisposable();
        r5.onSubscribe(r0);
        new RetryBiObserver(r5, this.f16981b, r0, this.f17034a).subscribeNext();
    }
}
