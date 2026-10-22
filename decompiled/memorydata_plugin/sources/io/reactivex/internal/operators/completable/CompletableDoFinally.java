package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableDoFinally extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f16737b;

    static final class DoFinallyObserver extends AtomicInteger implements c, b {
        private static final long serialVersionUID = 4109457741734051389L;
        final c downstream;
        final io.reactivex.b.a onFinally;
        b upstream;

        DoFinallyObserver(c r3, io.reactivex.b.a r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.onFinally = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.c
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        void runFinally() {
            if (compareAndSet(0, 1) == false) goto L11;
            this.onFinally.a();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16736a.a(new DoFinallyObserver(r4, this.f16737b));
    }
}
