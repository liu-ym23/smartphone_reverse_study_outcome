package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableTimer extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f16750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f16751b;
    final u c;

    static final class TimerDisposable extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;
        final c downstream;

        TimerDisposable(c r3) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onComplete();
        }

        void setFuture(b r3) {
            DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.a
    public void b(c r4) {
        c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
        TimerDisposable r0 = new TimerDisposable(r5);
        r5.onSubscribe(r0);
        r0.setFuture(this.c.a(r0, this.f16750a, this.f16751b));
    }
}
