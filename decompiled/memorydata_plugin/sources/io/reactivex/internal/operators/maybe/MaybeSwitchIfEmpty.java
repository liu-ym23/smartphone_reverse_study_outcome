package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeSwitchIfEmpty<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? extends T> f16861b;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2223459372976438024L;
        final m<? super T> downstream;
        final o<? extends T> other;

        static final class a<T> implements m<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final m<? super T> f16862a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<io.reactivex.disposables.b> f16863b;

            a(m<? super T> r3, AtomicReference<io.reactivex.disposables.b> r4) {
                this.f16862a = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
                this.f16863b = r4;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.f16862a.onComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.f16862a.onError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
                DisposableHelper.setOnce(this.f16863b, r4);
            }

            @Override // io.reactivex.m
            public void onSuccess(T r1) {
                this.f16862a.onSuccess(r1);
            }
        }

        SwitchIfEmptyMaybeObserver(m<? super T> r3, o<? extends T> r4) {
            m<? super T> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            o<? extends T> r6 = (o) ZeusTransformUtils.wrapperContextForParams(r4, o.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.other = r6;
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
            io.reactivex.disposables.b r0 = (io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (r0 != DisposableHelper.DISPOSED) goto L5;
            return;
        L5:
            if (compareAndSet(r0, null) == false) goto L9;
            this.other.a(new a(this.downstream, this));
            return;
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            if (DisposableHelper.setOnce(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r1) {
            this.downstream.onSuccess(r1);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new SwitchIfEmptyMaybeObserver(r4, this.f16861b));
    }
}
