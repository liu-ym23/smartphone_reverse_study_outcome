package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleDoOnDispose<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f17065b;

    static final class DoOnDisposeObserver<T> extends AtomicReference<io.reactivex.b.a> implements b, x<T> {
        private static final long serialVersionUID = -8583764624474935784L;
        final x<? super T> downstream;
        b upstream;

        DoOnDisposeObserver(x<? super T> r3, io.reactivex.b.a r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            io.reactivex.b.a r6 = (io.reactivex.b.a) ZeusTransformUtils.wrapperContextForParams(r4, io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            lazySet(r6);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.b.a r0 = (io.reactivex.b.a) ZeusTransformUtils.preCheckCast(getAndSet(null), io.reactivex.b.a.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L12;
            r0.a();     // Catch: Throwable -> L6
        L8:
            this.upstream.dispose();
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            goto L8
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
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
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17064a.a(new DoOnDisposeObserver(r4, this.f17065b));
    }
}
