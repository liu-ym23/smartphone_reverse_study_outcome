package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.Observable;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import io.reactivex.t;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableUsing<T, D> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends D> f17016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h<? super D, ? extends s<? extends T>> f17017b;
    final g<? super D> c;
    final boolean d;

    static final class UsingObserver<T, D> extends AtomicBoolean implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = 5904473792286235046L;
        final g<? super D> disposer;
        final t<? super T> downstream;
        final boolean eager;
        final D resource;
        io.reactivex.disposables.b upstream;

        UsingObserver(t<? super T> r3, D r4, g<? super D> r5, boolean r6) {
            t<? super T> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            g<? super D> r8 = (g) ZeusTransformUtils.wrapperContextForParams(r5, g.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.resource = r4;
            this.disposer = r8;
            this.eager = r6;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        void disposeAfter() {
            if (compareAndSet(false, true) == false) goto L11;
            this.disposer.accept(this.resource);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            io.reactivex.d.a.a(th);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            if (this.eager == true) goto L5;
            this.downstream.onComplete();
            this.upstream.dispose();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L14;
        L11:
            this.upstream.dispose();
            this.downstream.onComplete();
            return;
        L14:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.t
        public void onError(Throwable r6) {
            if (this.eager == true) goto L5;
            this.downstream.onError(r6);
            this.upstream.dispose();
            disposeAfter();
            return;
        L5:
            if (compareAndSet(false, true) == true) goto L13;
        L10:
            this.upstream.dispose();
            this.downstream.onError(r6);
            return;
        L13:
            this.disposer.accept(this.resource);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            r6 = new CompositeException(new Throwable[]{r6, th});
            goto L10
        }

        @Override // io.reactivex.t
        public void onNext(T r1) {
            this.downstream.onNext(r1);
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.upstream, r4) == false) goto L6;
            this.upstream = r4;
            this.downstream.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        D r0 = this.f17016a.call();     // Catch: Throwable -> L15
        ((s) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.f17017b.apply(r0), "The sourceSupplier returned a null ObservableSource"), s.class, "com.obric.memorydata.plugin")).subscribe(new UsingObserver(r6, r0, this.c, this.d));
        return;
    L7:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.c.accept(r0);     // Catch: Throwable -> L12
        EmptyDisposable.error(th, r6);
        return;
    L12:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(new CompositeException(new Throwable[]{th, th}), r6);
        return;
    L15:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        EmptyDisposable.error(th, r6);
    }
}
