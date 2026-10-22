package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableTimer extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final u f17012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f17013b;
    final TimeUnit c;

    static final class TimerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final t<? super Long> downstream;

        TimerObserver(t<? super Long> r3) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed() == true) goto L6;
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
            return;
        }

        public void setResource(io.reactivex.disposables.b r3) {
            DisposableHelper.trySet(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super Long> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        TimerObserver r0 = new TimerObserver(r5);
        r5.onSubscribe(r0);
        r0.setResource(this.f17012a.a(r0, this.f17013b, this.c));
    }
}
