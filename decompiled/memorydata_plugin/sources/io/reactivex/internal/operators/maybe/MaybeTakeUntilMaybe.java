package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeTakeUntilMaybe<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<U> f16868b;

    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2187421758664251153L;
        final m<? super T> downstream;
        final TakeUntilOtherMaybeObserver<U> other;

        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<io.reactivex.disposables.b> implements m<U> {
            private static final long serialVersionUID = -1266041316834525931L;
            final TakeUntilMainMaybeObserver<?, U> parent;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver<?, U> r1) {
                this.parent = r1;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.parent.otherError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
            }

            @Override // io.reactivex.m
            public void onSuccess(Object r1) {
                this.parent.otherComplete();
            }
        }

        TakeUntilMainMaybeObserver(m<? super T> r3) {
            this.downstream = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            this.other = new TakeUntilOtherMaybeObserver(this);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            if (getAndSet(DisposableHelper.DISPOSED) == DisposableHelper.DISPOSED) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.m
        public void onError(Throwable r3) {
            DisposableHelper.dispose(this.other);
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
            DisposableHelper.dispose(this.other);
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
        this.f16868b.a(r0.other);
        this.f16882a.a(r0);
    }
}
