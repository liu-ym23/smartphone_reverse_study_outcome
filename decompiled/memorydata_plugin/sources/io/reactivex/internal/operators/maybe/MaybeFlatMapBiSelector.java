package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.c;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends o<? extends U>> f16835b;
    final c<? super T, ? super U, ? extends R> c;

    static final class FlatMapBiMainObserver<T, U, R> implements io.reactivex.disposables.b, m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h<? super T, ? extends o<? extends U>> f16836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final InnerObserver<T, U, R> f16837b;

        static final class InnerObserver<T, U, R> extends AtomicReference<io.reactivex.disposables.b> implements m<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final m<? super R> downstream;
            final c<? super T, ? super U, ? extends R> resultSelector;
            T value;

            InnerObserver(m<? super R> r3, c<? super T, ? super U, ? extends R> r4) {
                m<? super R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
                c<? super T, ? super U, ? extends R> r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin");
                this.downstream = r5;
                this.resultSelector = r6;
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
            public void onSuccess(U r3) {
                T r0 = this.value;
                this.value = null;
                Object r4 = io.reactivex.internal.functions.a.a(this.resultSelector.apply(r0, r3), "The resultSelector returned a null value");     // Catch: Throwable -> L6
                this.downstream.onSuccess(r4);
                return;
            L6:
                th = move-exception;
                io.reactivex.exceptions.a.a(th);
                this.downstream.onError(th);
            }
        }

        FlatMapBiMainObserver(m<? super R> r3, h<? super T, ? extends o<? extends U>> r4, c<? super T, ? super U, ? extends R> r5) {
            m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends o<? extends U>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.f16837b = new InnerObserver(r6, (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin"));
            this.f16836a = r7;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.f16837b);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(this.f16837b.get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.f16837b.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.f16837b.downstream.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.setOnce(this.f16837b, r4) == false) goto L6;
            this.f16837b.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r4) {
            o r0 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16836a.apply(r4), "The mapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (DisposableHelper.replace(this.f16837b, null) == false) goto L12;
            this.f16837b.value = r4;
            r0.a(this.f16837b);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.f16837b.downstream.onError(th);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super R> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new FlatMapBiMainObserver(r5, this.f16835b, this.c));
    }
}
