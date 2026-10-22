package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.t;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f16924b;
    final int c;
    final Callable<U> d;

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements io.reactivex.disposables.b, t<T> {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers;
        final int count;
        final t<? super U> downstream;
        long index;
        final int skip;
        io.reactivex.disposables.b upstream;

        BufferSkipObserver(t<? super U> r3, int r4, int r5, Callable<U> r6) {
            t<? super U> r7 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            Callable<U> r8 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
            this.downstream = r7;
            this.count = r4;
            this.skip = r5;
            this.bufferSupplier = r8;
            this.buffers = new ArrayDeque();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
        L3:
            if (this.buffers.isEmpty() == true) goto L5;
            this.downstream.onNext(this.buffers.poll());
            goto L3
        L5:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.buffers.clear();
            this.downstream.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r6) {
            long r0 = this.index;
            this.index = 1 + r0;
            if ((r0 % ((long) this.skip)) == 0) goto L16;
        L9:
            Iterator<U> r1 = this.buffers.iterator();
        L11:
            if (r1.hasNext() == false) goto L15;
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(r1.next(), Collection.class, "com.obric.memorydata.plugin");
            r2.add(r6);
            if (this.count > r2.size()) goto L11;
            r1.remove();
            this.downstream.onNext(r2);
            goto L11
        L15:
            return;
        L16:
            Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
            this.buffers.offer((U) r3);
        L6:
            th = move-exception;
            this.buffers.clear();
            this.upstream.dispose();
            this.downstream.onError(th);
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

    static final class a<T, U extends Collection<? super T>> implements io.reactivex.disposables.b, t<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final t<? super U> f16925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f16926b;
        final Callable<U> c;
        U d;
        int e;
        io.reactivex.disposables.b f;

        a(t<? super U> r3, int r4, Callable<U> r5) {
            t<? super U> r6 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            Callable<U> r7 = (Callable) ZeusTransformUtils.wrapperContextForParams(r5, Callable.class, "com.obric.memorydata.plugin");
            this.f16925a = r6;
            this.f16926b = r4;
            this.c = r7;
        }

        boolean a() {
            this.d = (U) ZeusTransformUtils.preCheckCast(io.reactivex.internal.functions.a.a(this.c.call(), "Empty buffer supplied"), Collection.class, "com.obric.memorydata.plugin");
            return true;
        L5:
            th = move-exception;
            io.reactivex.exceptions.a.a(th);
            this.d = null;
            io.reactivex.disposables.b r1 = this.f;
            if (r1 != null) goto L9;
            EmptyDisposable.error(th, this.f16925a);
            return false;
        L9:
            r1.dispose();
            this.f16925a.onError(th);
            return false;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f.isDisposed();
        }

        @Override // io.reactivex.t
        public void onComplete() {
            U r0 = this.d;
            if (r0 == null) goto L9;
            this.d = null;
            if (r0.isEmpty() == true) goto L7;
            this.f16925a.onNext(r0);
        L7:
            this.f16925a.onComplete();
            return;
        }

        @Override // io.reactivex.t
        public void onError(Throwable r2) {
            this.d = null;
            this.f16925a.onError(r2);
        }

        @Override // io.reactivex.t
        public void onNext(T r3) {
            U r0 = this.d;
            if (r0 == null) goto L8;
            r0.add(r3);
            int r4 = this.e + 1;
            this.e = r4;
            if (r4 < this.f16926b) goto L9;
            this.f16925a.onNext(r0);
            this.e = 0;
            a();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.t
        public void onSubscribe(io.reactivex.disposables.b r3) {
            io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
            if (DisposableHelper.validate(this.f, r4) == false) goto L6;
            this.f = r4;
            this.f16925a.onSubscribe(this);
            return;
        }
    }

    @Override // io.reactivex.Observable
    public void a(t<? super U> r5) {
        t r6 = (t) ZeusTransformUtils.wrapperContextForParams(r5, t.class, "com.obric.memorydata.plugin");
        if (this.c != this.f16924b) goto L7;
        a r0 = new a(r6, this.f16924b, this.d);
        if (r0.a() == false) goto L9;
        this.f17034a.subscribe(r0);
        return;
    L9:
        return;
    L7:
        this.f17034a.subscribe(new BufferSkipObserver(r6, this.f16924b, this.c, this.d));
    }
}
