package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableSubscribeOn extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f16746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16747b;

    static final class SubscribeOnObserver extends AtomicReference<b> implements c, b, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;
        final c downstream;
        final e source;
        final SequentialDisposable task;

        SubscribeOnObserver(c r3, e r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin"));
        }

        @Override // java.lang.Runnable
        public void run() {
            this.source.a(this);
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        SubscribeOnObserver r0 = new SubscribeOnObserver(r4, this.f16746a);
        r4.onSubscribe(r0);
        b r2 = this.f16747b.a(r0);
        r0.task.replace(r2);
    }
}
