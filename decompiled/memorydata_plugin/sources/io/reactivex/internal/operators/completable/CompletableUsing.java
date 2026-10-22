package io.reactivex.internal.operators.completable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.a;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.c;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class CompletableUsing<R> extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<R> f16752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super R, ? extends e> f16753b;
    final g<? super R> c;
    final boolean d;

    static final class UsingObserver<R> extends AtomicReference<Object> implements c, b {
        private static final long serialVersionUID = -674404550052917487L;
        final g<? super R> disposer;
        final c downstream;
        final boolean eager;
        b upstream;

        UsingObserver(c r3, R r4, g<? super R> r5, boolean r6) {
            c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
            g<? super R> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
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

        @Override // io.reactivex.c
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

        @Override // io.reactivex.c
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

        @Override // io.reactivex.c
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.a
    public void b(c r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        R r0 = this.f16752a.call();     // Catch: Throwable -> L22
        ((e) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f16753b.apply(r0), "The completableFunction returned a null CompletableSource"), e.class, "com.obric.memorydata.plugin")).a(new UsingObserver(r6, r0, this.c, this.d));
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
