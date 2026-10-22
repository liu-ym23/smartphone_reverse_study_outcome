package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeSwitchIfEmptySingle<T> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T> f16864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final z<? extends T> f16865b;

    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4603919676453758899L;
        final x<? super T> downstream;
        final z<? extends T> other;

        static final class a<T> implements x<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final x<? super T> f16866a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<io.reactivex.disposables.b> f16867b;

            a(x<? super T> r3, AtomicReference<io.reactivex.disposables.b> r4) {
                this.f16866a = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
                this.f16867b = r4;
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.f16866a.onError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(io.reactivex.disposables.b r3) {
                io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
                DisposableHelper.setOnce(this.f16867b, r4);
            }

            @Override // io.reactivex.x
            public void onSuccess(T r1) {
                this.f16866a.onSuccess(r1);
            }
        }

        SwitchIfEmptyMaybeObserver(x<? super T> r3, z<? extends T> r4) {
            x<? super T> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            z<? extends T> r6 = (z) ZeusTransformUtils.wrapperContextForParams(r4, z.class, "com.obric.memorydata.plugin");
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

    @Override // io.reactivex.v
    public void b(x<? super T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f16864a.a(new SwitchIfEmptyMaybeObserver(r4, this.f16865b));
    }
}
