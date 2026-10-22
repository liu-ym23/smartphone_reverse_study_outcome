package io.reactivex.internal.operators.single;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.v;
import io.reactivex.x;
import io.reactivex.z;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class SingleUsing<T, U> extends v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<U> f17096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super U, ? extends z<? extends T>> f17097b;
    final g<? super U> c;
    final boolean d;

    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements b, x<T> {
        private static final long serialVersionUID = -5331524057054083935L;
        final g<? super U> disposer;
        final x<? super T> downstream;
        final boolean eager;
        b upstream;

        UsingSingleObserver(x<? super T> r3, U r4, boolean r5, g<? super U> r6) {
            x<? super T> r7 = (x) ZeusTransformUtils.wrapperContextForParams(r3, x.class, "com.obric.memorydata.plugin");
            g<? super U> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r6, g.class, "com.obric.memorydata.plugin");
            super(r4);
            this.downstream = r7;
            this.eager = r5;
            this.disposer = r8;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            disposeAfter();
        }

        void disposeAfter() {
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

        @Override // io.reactivex.x
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
            disposeAfter();
            return;
        }

        @Override // io.reactivex.x
        public void onSubscribe(b r3) {
            b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.x
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
            disposeAfter();
            return;
        }
    }

    @Override // io.reactivex.v
    public void b(x<? super T> r7) {
        x r8 = (x) ZeusTransformUtils.wrapperContextForParams(r7, x.class, "com.obric.memorydata.plugin");
        U r0 = this.f17096a.call();     // Catch: Throwable -> L21
        ((z) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f17097b.apply(r0), "The singleFunction returned a null SingleSource"), z.class, "com.obric.memorydata.plugin")).a(new UsingSingleObserver(r8, r0, this.d, this.c));
        return;
    L7:
        th = th;
        io.reactivex.exceptions.a.a(th);
        if (this.d == true) goto L30;
    L14:
        EmptyDisposable.error(th, r8);
        if (this.d == true) goto L32;
        this.c.accept(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        io.reactivex.d.a.a(th);
        return;
    L32:
        return;
    L30:
        this.c.accept(r0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        th = new CompositeException(new Throwable[]{th, th});
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r8);
    }
}
