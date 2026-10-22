package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapCompletable<T> extends io.reactivex.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final o<T> f16838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends e> f16839b;

    static final class FlatMapCompletableObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -2177128922851101253L;
        final c downstream;
        final h<? super T, ? extends e> mapper;

        FlatMapCompletableObserver(c r3, h<? super T, ? extends e> r4) {
            c r5 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends e> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.c
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.c
        public void onError(Throwable r1) {
            this.downstream.onError(r1);
        }

        @Override // io.reactivex.c
        public void onSubscribe(io.reactivex.disposables.b r3) {
            DisposableHelper.replace(this, (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            e r4 = (e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.mapper.apply(r3), "The mapper returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
            if (isDisposed() == true) goto L12;
            r4.a(this);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            onError(th);
        }
    }

    @Override // io.reactivex.a
    public void b(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        FlatMapCompletableObserver r0 = new FlatMapCompletableObserver(r4, this.f16839b);
        r4.onSubscribe(r0);
        this.f16838a.a(r0);
    }
}
