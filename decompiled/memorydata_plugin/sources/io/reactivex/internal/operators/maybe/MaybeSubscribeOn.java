package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u f16858b;

    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 8571289934935992137L;
        final m<? super T> downstream;
        final SequentialDisposable task;

        SubscribeOnMaybeObserver(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.task = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
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
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    static final class a<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m<? super T> f16859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o<T> f16860b;

        a(m<? super T> r3, o<T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            o<T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.f16859a = r5;
            this.f16860b = r6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16860b.a(this.f16859a);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        SubscribeOnMaybeObserver r0 = new SubscribeOnMaybeObserver(r5);
        r5.onSubscribe(r0);
        r0.task.replace(this.f16858b.a(new a(r0, this.f16882a)));
    }
}
