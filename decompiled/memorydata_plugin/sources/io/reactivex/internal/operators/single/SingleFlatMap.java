package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleFlatMap<T, R> extends v<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final z<? extends T> f17066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends z<? extends R>> f17067b;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<b> implements b, x<T> {
        private static final long serialVersionUID = 3258103020495908596L;
        final x<? super R> downstream;
        final h<? super T, ? extends z<? extends R>> mapper;

        static final class a<R> implements x<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final AtomicReference<b> f17068a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final x<? super R> f17069b;

            a(AtomicReference<b> r3, x<? super R> r4) {
                x<? super R> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
                this.f17068a = r3;
                this.f17069b = r5;
            }

            @Override // io.reactivex.x
            public void onError(Throwable r1) {
                this.f17069b.onError(r1);
            }

            @Override // io.reactivex.x
            public void onSubscribe(b r3) {
                b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
                DisposableHelper.replace(this.f17068a, r4);
            }

            @Override // io.reactivex.x
            public void onSuccess(R r1) {
                this.f17069b.onSuccess(r1);
            }
        }

        SingleFlatMapCallback(x<? super R> r3, h<? super T, ? extends z<? extends R>> r4) {
            x<? super R> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends z<? extends R>> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r5;
            this.mapper = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
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
            if (DisposableHelper.setOnce(this, (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin")) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
        public void onSuccess(T r3) {
            z r4 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The single returned by the mapper is null"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.a(new a(this, this.downstream));
            return;
        L12:
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super R> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f17066a.a(new SingleFlatMapCallback(r4, this.f17067b));
    }
}
