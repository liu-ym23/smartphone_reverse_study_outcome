package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.u;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeDelay<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f16821b;
    final TimeUnit c;
    final u d;

    static final class DelayMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final long delay;
        final m<? super T> downstream;
        Throwable error;
        final u scheduler;
        final TimeUnit unit;
        T value;

        DelayMaybeObserver(m<? super T> r3, long r4, TimeUnit r6, u r7) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.delay = r4;
            this.unit = r6;
            this.scheduler = r7;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            schedule();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.error = r1;
            schedule();
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.value = r1;
            schedule();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable r0 = this.error;
            if (r0 == null) goto L5;
            this.downstream.onError(r0);
            return;
        L5:
            T r1 = this.value;
            m<? super T> r2 = this.downstream;
            if (r1 == null) goto L8;
            r2.onSuccess(r1);
            return;
        L8:
            r2.onComplete();
        }

        void schedule() {
            DisposableHelper.replace(this, this.scheduler.a(this, this.delay, this.unit));
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r8) {
        m r1 = (m) ZeusTransformUtils.wrapperContextForParams(r8, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new DelayMaybeObserver(r1, this.f16821b, this.c, this.d));
    }
}
