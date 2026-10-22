package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleObserveOn<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f17081b;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<b> implements b, x<T>, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;
        final x<? super T> downstream;
        Throwable error;
        final u scheduler;
        T value;

        ObserveOnSingleObserver(x<? super T> r3, u r4) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.error = r1;
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            this.value = r1;
            DisposableHelper.replace(this, this.scheduler.a(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable r0 = this.error;
            if (r0 == null) goto L5;
            this.downstream.onError(r0);
            return;
        L5:
            this.downstream.onSuccess(this.value);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17080a.a(new ObserveOnSingleObserver(r4, this.f17081b));
    }
}
