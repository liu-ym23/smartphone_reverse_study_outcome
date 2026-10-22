package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleDoFinally<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f17063b;

    static final class DoFinallyObserver<T> extends AtomicInteger implements b, x<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final x<? super T> downstream;
        final io.reactivex.b.a onFinally;
        b upstream;

        DoFinallyObserver(x<? super T> r3, io.reactivex.b.a r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.x
        public void onError(Throwable r2) {
            this.downstream.onError(r2);
            runFinally();
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
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

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17062a.a(new DoFinallyObserver(r4, this.f17063b));
    }
}
