package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f16832b;

    static final class DoFinallyObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final m<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.disposables.b upstream;

        DoFinallyObserver(m<? super T> r3, io.reactivex.b.a r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            this.downstream.onSuccess(r2);
            runFinally();
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

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new DoFinallyObserver(r4, this.f16832b));
    }
}
