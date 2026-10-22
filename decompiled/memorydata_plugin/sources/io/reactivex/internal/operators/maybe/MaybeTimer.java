package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeTimer extends k<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f16872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f16873b;
    final u c;

    static final class TimerDisposable extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;
        final m<? super Long> downstream;

        TimerDisposable(m<? super Long> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Runnable
        public void run() {
            this.downstream.onSuccess(0L);
        }

        void setFuture(io.reactivex.disposables.b r3) {
            DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super Long> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        TimerDisposable r0 = new TimerDisposable(r5);
        r5.onSubscribe(r0);
        r0.setFuture(this.c.a(r0, this.f16872a, this.f16873b));
    }
}
