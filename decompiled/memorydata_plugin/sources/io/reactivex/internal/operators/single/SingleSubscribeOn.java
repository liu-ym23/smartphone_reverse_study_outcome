package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.u;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleSubscribeOn<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T> f17084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f17085b;

    static final class SubscribeOnObserver<T> extends AtomicReference<b> implements b, x<T>, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final x<? super T> downstream;
        final z<? extends T> source;
        final SequentialDisposable task;

        SubscribeOnObserver(x<? super T> r3, z<? extends T> r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            z<? extends T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.source = r6;
            this.task = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
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
            DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        SubscribeOnObserver r0 = new SubscribeOnObserver(r4, this.f17084a);
        r4.onSubscribe(r0);
        b r2 = this.f17085b.a(r0);
        r0.task.replace(r2);
    }
}
