package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableObserveOn extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16743b;

    static final class ObserveOnCompletableObserver extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final c downstream;
        Throwable error;
        final u scheduler;

        ObserveOnCompletableObserver(c r3, u r4) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.c
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.error = r1;
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable r0 = this.error;
            if (r0 == null) goto L5;
            this.error = null;
            this.downstream.onError(r0);
            return;
        L5:
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f16742a.a(new ObserveOnCompletableObserver(r4, this.f16743b));
    }
}
