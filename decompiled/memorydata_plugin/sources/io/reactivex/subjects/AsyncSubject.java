package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class AsyncSubject<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final AsyncDisposable[] f17168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final AsyncDisposable[] f17169b = null;
    final AtomicReference<AsyncDisposable<T>[]> c;
    Throwable d;
    T e;

    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(t<? super T> r3, AsyncSubject<T> r4) {
            super((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"));
            this.parent = r4;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            if (super.tryDispose() == false) goto L6;
            this.parent.b(this);
            return;
        }

        void onComplete() {
            if (isDisposed() == true) goto L6;
            this.downstream.onComplete();
            return;
        }

        void onError(Throwable r2) {
            if (isDisposed() == false) goto L5;
            io.reactivex.d.a.a(r2);
            return;
        L5:
            this.downstream.onError(r2);
        }
    }

    static {
        f17168a = new AsyncDisposable[0];
        f17169b = new AsyncDisposable[0];
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        AsyncDisposable<T> r0 = new AsyncDisposable(r4, this);
        r4.onSubscribe(r0);
        if (a(r0) == true) goto L5;
        Throwable r1 = this.d;
        if (r1 == null) goto L10;
        r4.onError(r1);
        return;
    L10:
        T r2 = this.e;
        if (r2 == null) goto L13;
        r0.complete(r2);
        return;
    L13:
        r0.onComplete();
        return;
    L5:
        if (r0.isDisposed() == false) goto L15;
        b(r0);
        return;
    }

    boolean a(AsyncDisposable<T> r5) {
    L2:
        AsyncDisposable<T>[] r0 = (AsyncDisposable[]) ZeusTransformUtils.preCheckCast(this.c.get(), AsyncDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f17169b) goto L4;
        int r1 = r0.length;
        AsyncDisposable<T>[] r3 = new AsyncDisposable[r1 + 1];
        System.arraycopy(r0, 0, r3, 0, r1);
        r3[r1] = r5;
        if (this.c.compareAndSet(r0, r3) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void b(AsyncDisposable<T> r7) {
    L2:
        AsyncDisposable<T>[] r0 = (AsyncDisposable[]) ZeusTransformUtils.preCheckCast(this.c.get(), AsyncDisposable[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        if (r1 == 0) goto L4;
        int r2 = -1;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L11;
        if (r0[r4] == r7) goto L9;
        r4 = r4 + 1;
        goto L6
    L9:
        r2 = r4;
    L11:
        if (r2 < 0) goto L12;
        if (r1 != 1) goto L16;
        AsyncDisposable<T>[] r3 = f17168a;
    L18:
        if (this.c.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        AsyncDisposable<T>[] r5 = new AsyncDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        AsyncDisposable<T>[] r0 = this.c.get();
        AsyncDisposable<T>[] r1 = f17169b;
        if (r0 != r1) goto L5;
        return;
    L5:
        T r2 = this.e;
        AsyncDisposable[] r4 = (AsyncDisposable[]) ZeusTransformUtils.preCheckCast(this.c.getAndSet(r1), AsyncDisposable[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
        if (r2 != null) goto L10;
        int r5 = r4.length;
    L8:
        if (r3 >= r5) goto L13;
        r4[r3].onComplete();
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L10:
        int r6 = r4.length;
    L11:
        if (r3 >= r6) goto L16;
        r4[r3].complete(r2);
        r3 = r3 + 1;
        goto L11
    }

    @Override // io.reactivex.t
    public void onError(Throwable r4) {
        io.reactivex.internal.functions.a.a(r4, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AsyncDisposable<T>[] r0 = this.c.get();
        AsyncDisposable<T>[] r1 = f17169b;
        if (r0 != r1) goto L6;
        io.reactivex.d.a.a(r4);
        return;
    L6:
        this.e = null;
        this.d = r4;
        AsyncDisposable[] r3 = (AsyncDisposable[]) ZeusTransformUtils.preCheckCast(this.c.getAndSet(r1), AsyncDisposable[].class, "com.obric.memorydata.plugin");
        int r2 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r2) goto L9;
        r3[r5].onError(r4);
        r5 = r5 + 1;
        goto L7
    }

    @Override // io.reactivex.t
    public void onNext(T r3) {
        io.reactivex.internal.functions.a.a(r3, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.c.get() != f17169b) goto L5;
        return;
    L5:
        this.e = r3;
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (this.c.get() != f17169b) goto L6;
        r4.dispose();
        return;
    }
}
