package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleTimer extends v<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f17090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f17091b;
    final u c;

    static final class TimerDisposable extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;
        final x<? super Long> downstream;

        TimerDisposable(x<? super Long> r3) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
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
            this.downstream.onSuccess(0L);
        }

        void setFuture(b r3) {
            DisposableHelper.replace(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super Long> r4) {
        x r5 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
        TimerDisposable r0 = new TimerDisposable(r5);
        r5.onSubscribe(r0);
        r0.setFuture(this.c.a(r0, this.f17090a, this.f17091b));
    }
}
