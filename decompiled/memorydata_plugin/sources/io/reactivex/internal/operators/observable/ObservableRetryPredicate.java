package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.j;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableRetryPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final j<? super Throwable> f16982b;
    final long c;

    static final class RepeatObserver<T> extends AtomicInteger implements t<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final t<? super T> downstream;
        final j<? super Throwable> predicate;
        long remaining;
        final s<? extends T> source;
        final SequentialDisposable upstream;

        RepeatObserver(t<? super T> r3, long r4, j<? super Throwable> r6, SequentialDisposable r7, s<? extends T> r8) {
            t<? super T> r5 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            j<? super Throwable> r9 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.memorydata.plugin");
            s<? extends T> r10 = (s) ZeusTransformUtils.wrapperContextForParams(r8, s.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.upstream = r7;
            this.source = r10;
            this.predicate = r9;
            this.remaining = r4;
        }

        @Override // io.reactivex.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r5) {
            long r0 = this.remaining;
            if (r0 == Long.MAX_VALUE) goto L6;
            this.remaining = r0 - 1;
        L6:
            if (r0 != 0) goto L17;
            this.downstream.onError(r5);
            return;
        L17:
            if (this.predicate.test(r5) == true) goto L12;
            this.downstream.onError(r5);
            return;
        L12:
            subscribeNext();
            return;
        L14:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
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
    public void a(t<? super T> r8) {
        t r1 = (t) ZeusTransformUtils.wrapperContextForParams(r8, t.class, "com.obric.memorydata.plugin");
        SequentialDisposable r5 = new SequentialDisposable();
        r1.onSubscribe(r5);
        new RepeatObserver(r1, this.c, this.f16982b, r5, this.f17034a).subscribeNext();
    }
}
