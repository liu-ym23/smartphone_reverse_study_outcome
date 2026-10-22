package io.reactivex.internal.operators.maybe;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class MaybeUsing<T, D> extends k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends D> f16877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super D, ? extends o<? extends T>> f16878b;
    final g<? super D> c;
    final boolean d;

    static final class UsingObserver<T, D> extends AtomicReference<Object> implements io.reactivex.disposables.b, m<T> {
        private static final long serialVersionUID = -674404550052917487L;
        final g<? super D> disposer;
        final m<? super T> downstream;
        final boolean eager;
        io.reactivex.disposables.b upstream;

        UsingObserver(m<? super T> r3, D r4, g<? super D> r5, boolean r6) {
            m<? super T> r7 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.memorydata.plugin");
            g<? super D> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r7;
            this.disposer = r8;
            this.eager = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeResourceAfter();
        }

        void disposeResourceAfter() {
            Object r0 = getAndSet(this);
            if (r0 == this) goto L11;
            this.disposer.accept(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 == this) goto L17;
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        L17:
            return;
        L11:
            this.downstream.onComplete();
            if (this.eager == true) goto L18;
            disposeResourceAfter();
            return;
        }

        @Override // io.reactivex.m
        public void onError(Throwable r5) {
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 != this) goto L15;
            return;
        L15:
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r5 = new CompositeException(new Throwable[]{r5, th});
        L11:
            this.downstream.onError(r5);
            if (this.eager == true) goto L17;
            disposeResourceAfter();
            return;
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
            this.upstream = DisposableHelper.DISPOSED;
            if (this.eager == false) goto L11;
            Object r0 = getAndSet(this);
            if (r0 == this) goto L17;
            this.disposer.accept(r0);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
            return;
        L17:
            return;
        L11:
            this.downstream.onSuccess(r3);
            if (this.eager == true) goto L18;
            disposeResourceAfter();
            return;
        }
    }

    @Override // io.reactivex.k
    public void b(m<? super T> r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin");
        D r0 = this.f16877a.call();     // Catch: Throwable -> L22
        ((o) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16878b.apply(r0), "The sourceSupplier returned a null MaybeSource"), o.class, "com.obric.memorydata.plugin")).a(new UsingObserver(r6, r0, this.c, this.d));
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        if (this.d == true) goto L31;
    L15:
        EmptyDisposable.error(th, r6);
        if (this.d == true) goto L33;
        this.c.accept(r0);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        return;
    L33:
        return;
    L31:
        this.c.accept(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(new CompositeException(new Throwable[]{th, th}), r6);
        return;
    L22:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r6);
    }
}
