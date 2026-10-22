package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16854b;

    static final class ObserveOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T>, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> downstream;
        Throwable error;
        final u scheduler;
        T value;

        ObserveOnMaybeObserver(m<? super T> r3, u r4) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
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
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.error = r1;
            DisposableHelper.replace(this, this.scheduler.a(this));
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
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable r0 = this.error;
            if (r0 == null) goto L5;
            this.error = null;
            this.downstream.onError(r0);
            return;
        L5:
            T r1 = this.value;
            if (r1 == null) goto L8;
            this.value = null;
            this.downstream.onSuccess(r1);
            return;
        L8:
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new ObserveOnMaybeObserver(r4, this.f16854b));
    }
}
