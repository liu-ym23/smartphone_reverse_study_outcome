package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableConcatArray extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e[] f16731a;

    static final class ConcatInnerObserver extends AtomicInteger implements c {
        private static final long serialVersionUID = -7965400327305809232L;
        final c downstream;
        int index;
        final SequentialDisposable sd;
        final e[] sources;

        ConcatInnerObserver(c r3, e[] r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.sources = r4;
            this.sd = new SequentialDisposable();
        }

        void next() {
            if (this.sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            e[] r0 = this.sources;
        L10:
            if (this.sd.isDisposed() == true) goto L11;
            int r1 = this.index;
            this.index = r1 + 1;
            if (r1 == r0.length) goto L14;
            r0[r1].a(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L14:
            this.downstream.onComplete();
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
        ConcatInnerObserver r0 = new ConcatInnerObserver(r4, this.f16731a);
        r4.onSubscribe(r0.sd);
        r0.next();
    }
}
