package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.v;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeEqualSingle<T> extends v<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<? extends T> f16833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T> f16834b;
    final d<? super T, ? super T> c;

    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        final x<? super Boolean> downstream;
        final d<? super T, ? super T> isEqual;
        final EqualObserver<T> observer1;
        final EqualObserver<T> observer2;

        EqualCoordinator(x<? super Boolean> r3, d<? super T, ? super T> r4) {
            x<? super Boolean> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            d<? super T, ? super T> r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
            super(2);
            this.downstream = r5;
            this.isEqual = r6;
            this.observer1 = new EqualObserver(this);
            this.observer2 = new EqualObserver(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.observer1.dispose();
            this.observer2.dispose();
        }

        void done() {
            if (decrementAndGet() != 0) goto L21;
            Object r0 = this.observer1.value;
            Object r1 = this.observer2.value;
            if (r0 == null) goto L12;
            if (r1 == null) goto L12;
            boolean r2 = this.isEqual.a(r0, r1);     // Catch: Throwable -> L9
            x<? super Boolean> r3 = this.downstream;
        L17:
            r3.onSuccess(Boolean.valueOf(r2));
            return;
        L9:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        L12:
            r3 = this.downstream;
            if (r0 != null) goto L16;
            if (r1 != null) goto L16;
            r2 = true;
        L16:
            r2 = false;
            goto L17
        }

        void error(EqualObserver<T> r2, Throwable r3) {
            if (getAndSet(0) <= 0) goto L9;
            EqualObserver<T> r0 = this.observer1;
            if (r2 != r0) goto L7;
            this.observer2.dispose();
        L8:
            this.downstream.onError(r3);
            return;
        L7:
            r0.dispose();
            goto L8
        L9:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.observer1.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        void subscribe(o<? extends T> r3, o<? extends T> r4) {
            o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin");
            o r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            r5.a(this.observer1);
            r6.a(this.observer2);
        }
    }

    static final class EqualObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = -3031974433025990931L;
        final EqualCoordinator<T> parent;
        Object value;

        EqualObserver(EqualCoordinator<T> r1) {
            this.parent = r1;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.parent.done();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r2) {
            this.parent.error(this, r2);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.value = r1;
            this.parent.done();
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super Boolean> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        EqualCoordinator r0 = new EqualCoordinator(r4, this.c);
        r4.onSubscribe(r0);
        r0.subscribe(this.f16833a, this.f16834b);
    }
}
