package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T, R> extends io.reactivex.internal.operators.maybe.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends R> f16883b;

    static final class a<T, R> implements io.reactivex.disposables.b, m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final m<? super R> f16884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h<? super T, ? extends R> f16885b;
        io.reactivex.disposables.b c;

        a(m<? super R> r3, h<? super T, ? extends R> r4) {
            m<? super R> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends R> r6 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.f16884a = r5;
            this.f16885b = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            io.reactivex.disposables.b r0 = this.c;
            this.c = DisposableHelper.DISPOSED;
            r0.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.c.isDisposed();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.f16884a.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r1) {
            this.f16884a.onError(r1);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.c, r4) == false) goto L6;
            this.c = r4;
            this.f16884a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r2) {
            Object r3 = io.reactivex.internal.functions.a.a(this.f16885b.apply(r2), "The mapper returned a null item");     // Catch: Throwable -> L5
            this.f16884a.onSuccess(r3);
            return;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.f16884a.onError(th);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super R> r3) {
        m r4 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new a(r4, this.f16883b));
    }
}
