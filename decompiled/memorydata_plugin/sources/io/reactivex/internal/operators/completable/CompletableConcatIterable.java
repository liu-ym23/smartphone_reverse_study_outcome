package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableConcatIterable extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable<? extends e> f16732a;

    static final class ConcatInnerObserver extends AtomicInteger implements c {
        private static final long serialVersionUID = -7965400327305809232L;
        final c downstream;
        final SequentialDisposable sd;
        final Iterator<? extends e> sources;

        ConcatInnerObserver(c r3, Iterator<? extends e> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            Iterator<? extends e> r6 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r4, Iterator.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.sources = r6;
            this.sd = new SequentialDisposable();
        }

        void next() {
            if (this.sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            Iterator<? extends e> r0 = this.sources;
        L10:
            if (this.sd.isDisposed() == true) goto L11;
            if (r0.hasNext() == false) goto L14;
            ((e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(r0.next(), "The CompletableSource returned is null"), e.class, "com.obric.memorydata.plugin")).a(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L20:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        L14:
            this.downstream.onComplete();
            return;
        L23:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        }

        @Override // io.reactivex.c
        public void onComplete() {
            next();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            this.sd.replace(r4);
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        ConcatInnerObserver r0 = new ConcatInnerObserver(r4, (Iterator) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16732a.iterator(), "The iterator returned is null"), Iterator.class, "com.obric.memorydata.plugin"));
        r4.onSubscribe(r0.sd);
        r0.next();
        return;
    L6:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r4);
    }
}
