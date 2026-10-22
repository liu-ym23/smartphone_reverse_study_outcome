package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeOnErrorNext<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super Throwable, ? extends o<? extends T>> f16855b;
    final boolean c;

    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final m<? super T> downstream;
        final h<? super Throwable, ? extends o<? extends T>> resumeFunction;

        static final class a<T> implements m<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final m<? super T> f16856a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<io.reactivex.disposables.b> f16857b;

            a(m<? super T> r3, AtomicReference<io.reactivex.disposables.b> r4) {
                this.f16856a = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
                this.f16857b = r4;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.f16856a.onComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.f16856a.onError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
                DisposableHelper.setOnce(this.f16857b, r4);
            }

            @Override // io.reactivex.m
            public void onSuccess(T r1) {
                this.f16856a.onSuccess(r1);
            }
        }

        OnErrorNextMaybeObserver(m<? super T> r3, h<? super Throwable, ? extends o<? extends T>> r4, boolean r5) {
            m<? super T> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends o<? extends T>> r7 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            this.downstream = r6;
            this.resumeFunction = r7;
            this.allowFatal = r5;
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
            this.downstream.onComplete();
        }

        @Override // io.reactivex.m
        public void onError(Throwable r5) {
            if (this.allowFatal == false) goto L5;
        L14:
            o r0 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.resumeFunction.apply(r5), "The resumeFunction returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            DisposableHelper.replace(this, null);
            r0.a(new a(this.downstream, this));
            return;
        L11:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, th}));
            return;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, Exception.class) == true) goto L14;
            this.downstream.onError(r5);
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
    public void b(m<? super T> r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new OnErrorNextMaybeObserver(r5, this.f16855b, this.c));
    }
}
