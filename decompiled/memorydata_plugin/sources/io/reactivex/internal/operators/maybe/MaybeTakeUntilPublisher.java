package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeTakeUntilPublisher<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.a.b<U> f16869b;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2187421758664251153L;
        final m<? super T> downstream;
        final TakeUntilOtherMaybeObserver<U> other;

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<d> implements j<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> r1) {
                this.parent = r1;
            }

            @Override // org.a.c
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // org.a.c
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // org.a.c
            public void onNext(Object r1) {
                SubscriptionHelper.cancel(this);
                this.parent.otherComplete();
            }

            @Override // io.reactivex.j, org.a.c
            public void onSubscribe(d r3) {
                SubscriptionHelper.setOnce(this, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin"), Long.MAX_VALUE);
            }
        }

        TakeUntilMainMaybeObserver(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.other = new TakeUntilOtherMaybeObserver(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            SubscriptionHelper.cancel(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.m
        public void onError(Throwable r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L5;
            this.downstream.onError(r3);
            return;
        L5:
            io.reactivex.d.a.a(r3);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            SubscriptionHelper.cancel(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onSuccess(r3);
            return;
        }

        void otherComplete() {
            if (DisposableHelper.dispose(this) == false) goto L6;
            this.downstream.onComplete();
            return;
        }

        void otherError(Throwable r2) {
            if (DisposableHelper.dispose(this) == false) goto L5;
            this.downstream.onError(r2);
            return;
        L5:
            io.reactivex.d.a.a(r2);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        TakeUntilMainMaybeObserver r0 = new TakeUntilMainMaybeObserver(r4);
        r4.onSubscribe(r0);
        this.f16869b.subscribe(r0.other);
        this.f16882a.a(r0);
    }
}
