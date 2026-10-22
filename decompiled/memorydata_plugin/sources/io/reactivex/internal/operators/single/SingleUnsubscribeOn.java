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
public final class SingleUnsubscribeOn<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f17095b;

    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<b> implements b, x<T>, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final x<? super T> downstream;
        b ds;
        final u scheduler;

        UnsubscribeOnSingleObserver(x<? super T> r3, u r4) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            this.scheduler = r4;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            b r0 = (b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L6;
            this.ds = r0;
            this.scheduler.a(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((b) ZeusTransformUtils.preCheckCast(get(), b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.ds.dispose();
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17094a.a(new UnsubscribeOnSingleObserver(r4, this.f17095b));
    }
}
