package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableDelay extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16735b;
    final TimeUnit c;
    final u d;
    final boolean e;

    static final class Delay extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 465972761105851022L;
        final long delay;
        final boolean delayError;
        final c downstream;
        Throwable error;
        final u scheduler;
        final TimeUnit unit;

        Delay(c r3, long r4, TimeUnit r6, u r7, boolean r8) {
            this.downstream = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            this.delay = r4;
            this.unit = r6;
            this.scheduler = r7;
            this.delayError = r8;
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
            DisposableHelper.replace(this, this.scheduler.a(this, this.delay, this.unit));
        }

        @Override // io.reactivex.c
        public void onError(Throwable r4) {
            this.error = r4;
            u r5 = this.scheduler;
            if (this.delayError == false) goto L5;
            long r0 = this.delay;
        L6:
            DisposableHelper.replace(this, r5.a(this, r0, this.unit));
            return;
        L5:
            r0 = 0;
            goto L6
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
            this.error = null;
            c r2 = this.downstream;
            if (r0 == null) goto L5;
            r2.onError(r0);
            return;
        L5:
            r2.onComplete();
        }
    }

    @Override // io.reactivex.a
    public void b(c r9) {
        c r1 = (c) ZeusTransformUtils.wrapperContextForParams(r9, c.class, "com.obric.memorydata.plugin");
        this.f16734a.a(new Delay(r1, this.f16735b, this.c, this.d, this.e));
    }
}
