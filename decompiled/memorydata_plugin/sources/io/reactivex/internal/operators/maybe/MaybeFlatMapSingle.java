package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapSingle<T, R> extends v<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T> f16843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends z<? extends R>> f16844b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4827726964688405508L;
        final x<? super R> downstream;
        final h<? super T, ? extends z<? extends R>> mapper;

        FlatMapMaybeObserver(x<? super R> r3, h<? super T, ? extends z<? extends R>> r4) {
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
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.downstream.onError(new NoSuchElementException());
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
        public void onSuccess(T r3) {
            z r4 = (z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null SingleSource"), z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.a(new a(this, this.downstream));
            return;
        L12:
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            onError(th);
        }
    }

    static final class a<R> implements x<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f16845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final x<? super R> f16846b;

        a(AtomicReference<io.reactivex.disposables.b> r3, x<? super R> r4) {
            x<? super R> r5 = (x) ZeusTransformUtils.wrapperContextForParams(r4, x.class, "com.obric.memorydata.plugin");
            this.f16845a = r3;
            this.f16846b = r5;
        }

        @Override // io.reactivex.x
        public void onError(Throwable r1) {
            this.f16846b.onError(r1);
        }

        @Override // io.reactivex.x
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            DisposableHelper.replace(this.f16845a, r4);
        }

        @Override // io.reactivex.x
        public void onSuccess(R r1) {
            this.f16846b.onSuccess(r1);
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super R> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
        this.f16843a.a(new FlatMapMaybeObserver(r4, this.f16844b));
    }
}
