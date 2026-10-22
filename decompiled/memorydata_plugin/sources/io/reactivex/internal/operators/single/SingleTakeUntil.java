package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleTakeUntil<T, U> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<T> f17086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b<U> f17087b;

    static final class TakeUntilMainObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, x<T> {
        private static final long serialVersionUID = -622603812305745221L;
        final x<? super T> downstream;
        final TakeUntilOtherSubscriber other;

        TakeUntilMainObserver(x<? super T> r3) {
            this.downstream = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            this.other = new TakeUntilOtherSubscriber(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.other.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onError(Throwable r4) {
            this.other.dispose();
            if (((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) != DisposableHelper.DISPOSED) goto L5;
        L8:
            io.reactivex.d.a.a(r4);
            return;
        L5:
            if (((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == DisposableHelper.DISPOSED) goto L8;
            this.downstream.onError(r4);
        }

        @Override // io.reactivex.x
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.x
        public void onSuccess(T r4) {
            this.other.dispose();
            if (((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onSuccess(r4);
            return;
        }

        void otherError(Throwable r4) {
            if (((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == DisposableHelper.DISPOSED) goto L10;
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(getAndSet(DisposableHelper.DISPOSED), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 == DisposableHelper.DISPOSED) goto L10;
            if (r0 == null) goto L8;
            r0.dispose();
        L8:
            this.downstream.onError(r4);
            return;
        L10:
            io.reactivex.d.a.a(r4);
        }
    }

    static final class TakeUntilOtherSubscriber extends AtomicReference<d> implements j<Object> {
        private static final long serialVersionUID = 5170026210238877381L;
        final TakeUntilMainObserver<?> parent;

        TakeUntilOtherSubscriber(TakeUntilMainObserver<?> r1) {
            this.parent = r1;
        }

        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.a.c
        public void onComplete() {
            if (get() == SubscriptionHelper.CANCELLED) goto L6;
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.otherError(new CancellationException());
            return;
        }

        @Override // org.a.c
        public void onError(Throwable r1) {
            this.parent.otherError(r1);
        }

        @Override // org.a.c
        public void onNext(Object r1) {
            if (SubscriptionHelper.cancel(this) == false) goto L6;
            this.parent.otherError(new CancellationException());
            return;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d r3) {
            SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        TakeUntilMainObserver r0 = new TakeUntilMainObserver(r4);
        r4.onSubscribe(r0);
        this.f17087b.subscribe(r0.other);
        this.f17086a.a(r0);
    }
}
