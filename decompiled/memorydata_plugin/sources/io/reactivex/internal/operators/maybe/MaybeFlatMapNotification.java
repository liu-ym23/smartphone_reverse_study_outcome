package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeFlatMapNotification<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super T, ? extends o<? extends R>> f16841b;
    final h<? super Throwable, ? extends o<? extends R>> c;
    final Callable<? extends o<? extends R>> d;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = 4375739915521278546L;
        final m<? super R> downstream;
        final Callable<? extends o<? extends R>> onCompleteSupplier;
        final h<? super Throwable, ? extends o<? extends R>> onErrorMapper;
        final h<? super T, ? extends o<? extends R>> onSuccessMapper;
        io.reactivex.disposables.b upstream;

        final class a implements m<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FlatMapMaybeObserver f16842a;

            a(FlatMapMaybeObserver r1) {
                this.f16842a = r1;
            }

            @Override // io.reactivex.m
            public void onComplete() {
                this.f16842a.downstream.onComplete();
            }

            @Override // io.reactivex.m
            public void onError(Throwable r1) {
                this.f16842a.downstream.onError(r1);
            }

            @Override // io.reactivex.m
            public void onSubscribe(io.reactivex.disposables.b r3) {
                io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
                DisposableHelper.setOnce(this.f16842a, r4);
            }

            @Override // io.reactivex.m
            public void onSuccess(R r1) {
                this.f16842a.downstream.onSuccess(r1);
            }
        }

        FlatMapMaybeObserver(m<? super R> r3, h<? super T, ? extends o<? extends R>> r4, h<? super Throwable, ? extends o<? extends R>> r5, Callable<? extends o<? extends R>> r6) {
            m<? super R> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            h<? super T, ? extends o<? extends R>> r8 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
            h<? super Throwable, ? extends o<? extends R>> r9 = (h) ZeusTransformUtils.wrapperContextForParams(r5, h.class, "com.obric.memorydata.plugin");
            Callable<? extends o<? extends R>> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.onSuccessMapper = r8;
            this.onErrorMapper = r9;
            this.onCompleteSupplier = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed((io.reactivex.disposables.b) ZeusTransformUtils.preCheckCast(get(), io.reactivex.disposables.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.reactivex.m
        public void onComplete() {
            o r0 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
            r0.a(new a(this));
            return;
        L5:
            e = move-exception;
            io.reactivex.exceptions.a.a(e);
            this.downstream.onError(e);
        }

        @Override // io.reactivex.m
        public void onError(Throwable r5) {
            ((o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.onErrorMapper.apply(r5), "The onErrorMapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin")).a(new a(this));
            return;
        L5:
            e = move-exception;
            io.reactivex.exceptions.a.a(e);
            this.downstream.onError(new CompositeException(new Throwable[]{r5, e}));
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.m
        public void onSuccess(T r3) {
            o r4 = (o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.onSuccessMapper.apply(r3), "The onSuccessMapper returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
            r4.a(new a(this));
            return;
        L5:
            e = move-exception;
            io.reactivex.exceptions.a.a(e);
            this.downstream.onError(e);
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super R> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        this.f16882a.a(new FlatMapMaybeObserver(r6, this.f16841b, this.c, this.d));
    }
}
