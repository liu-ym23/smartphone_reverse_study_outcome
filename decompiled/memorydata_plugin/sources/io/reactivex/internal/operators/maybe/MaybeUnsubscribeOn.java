package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16876b;

    static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final m<? super T> downstream;
        io.reactivex.disposables.b ds;
        final u scheduler;

        UnsubscribeOnMaybeObserver(m<? super T> r3, u r4) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L6;
            this.ds = r0;
            this.scheduler.a(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new UnsubscribeOnMaybeObserver(r4, this.f16876b));
    }
}
