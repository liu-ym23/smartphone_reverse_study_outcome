package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableTimer extends g<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16801b;
    final long c;
    final TimeUnit d;

    static final class TimerSubscriber extends AtomicReference<io.reactivex.disposables.b> implements Runnable, org.a.d {
        private static final long serialVersionUID = -2809475196591179431L;
        final org.a.c<? super Long> downstream;
        volatile boolean requested;

        TimerSubscriber(org.a.c<? super Long> r3) {
            this.downstream = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r3, org.a.c.class, "com.obric.memorydata.plugin");
        }

        @Override // org.a.d
        public void cancel() {
            DisposableHelper.dispose(this);
        }

        @Override // org.a.d
        public void request(long r1) {
            if (SubscriptionHelper.validate(r1) == false) goto L6;
            this.requested = true;
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (this.requested == false) goto L7;
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        L7:
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onError(new MissingBackpressureException("Can't deliver value due to lack of requests"));
        }

        public void setResource(io.reactivex.disposables.b r3) {
            DisposableHelper.trySet(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.g
    public void a(org.a.c<? super Long> r4) {
        org.a.c r5 = (org.a.c) ZeusTransformUtils.wrapperContextForParams(r4, org.a.c.class, "com.obric.memorydata.plugin");
        TimerSubscriber r0 = new TimerSubscriber(r5);
        r5.onSubscribe(r0);
        r0.setResource(this.f16801b.a(r0, this.c, this.d));
    }
}
