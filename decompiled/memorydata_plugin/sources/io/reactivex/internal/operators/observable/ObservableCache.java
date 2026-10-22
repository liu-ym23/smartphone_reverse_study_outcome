package io.reactivex.internal.operators.observable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.t;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class ObservableCache<T> extends io.reactivex.internal.operators.observable.a<T, T> implements t<T> {
    static final CacheDisposable[] e = null;
    static final CacheDisposable[] f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f16928b;
    final int c;
    final AtomicReference<CacheDisposable<T>[]> d;
    volatile long g;
    final a<T> h;
    a<T> i;
    int j;
    Throwable k;
    volatile boolean l;

    static final class CacheDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final t<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(t<? super T> r3, ObservableCache<T> r4) {
            this.downstream = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
            this.parent = r4;
            this.node = r4.h;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed == true) goto L6;
            this.disposed = true;
            this.parent.b(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T[] f16929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile a<T> f16930b;

        a(int r3) {
            this.f16929a = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r3], Object[].class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        e = new CacheDisposable[0];
        f = new CacheDisposable[0];
    }

    void a(CacheDisposable<T> r5) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
        if (r0 == f) goto L4;
        int r1 = r0.length;
        CacheDisposable<T>[] r2 = new CacheDisposable[r1 + 1];
        System.arraycopy(r0, 0, r2, 0, r1);
        r2[r1] = r5;
        if (this.d.compareAndSet(r0, r2) == false) goto L2;
        return;
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r4) {
        t r5 = (t) ZeusTransformUtils.wrapperContextForParams(r4, t.class, "com.obric.memorydata.plugin");
        CacheDisposable<T> r0 = new CacheDisposable(r5, this);
        r5.onSubscribe(r0);
        a(r0);
        if (this.f16928b.get() == false) goto L5;
    L7:
        c(r0);
        return;
    L5:
        if (this.f16928b.compareAndSet(false, true) == false) goto L7;
        this.f17034a.subscribe(this);
    }

    void b(CacheDisposable<T> r7) {
    L2:
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
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
        CacheDisposable<T>[] r3 = e;
    L18:
        if (this.d.compareAndSet(r0, r3) == false) goto L2;
        return;
    L16:
        CacheDisposable<T>[] r5 = new CacheDisposable[r1 - 1];
        System.arraycopy(r0, 0, r5, 0, r2);
        System.arraycopy(r0, r2 + 1, r5, r2, (r1 - r2) - 1);
        r3 = r5;
        goto L18
    L12:
        return;
    }

    void c(CacheDisposable<T> r13) {
        if (r13.getAndIncrement() == 0) goto L5;
        return;
    L5:
        long r0 = r13.index;
        int r2 = r13.offset;
        a<T> r3 = r13.node;
        t<? super T> r4 = r13.downstream;
        int r5 = this.c;
        int r7 = 1;
    L7:
        if (r13.disposed == true) goto L8;
        boolean r8 = this.l;
        if (this.g != r0) goto L13;
        boolean r10 = true;
    L14:
        if (r8 == false) goto L21;
        if (r10 == false) goto L21;
        r13.node = null;
        Throwable r12 = this.k;
        if (r12 == null) goto L19;
        r4.onError(r12);
        return;
    L19:
        r4.onComplete();
        return;
    L21:
        if (r10 == false) goto L22;
        r13.index = r0;
        r13.offset = r2;
        r13.node = r3;
        r7 = r13.addAndGet(-r7);
        if (r7 != 0) goto L7;
        return;
    L22:
        if (r2 != r5) goto L24;
        r3 = r3.f16930b;
        r2 = 0;
    L24:
        r4.onNext(r3.f16929a[r2]);
        r2 = r2 + 1;
        r0 = r0 + 1;
        goto L7
    L13:
        r10 = false;
        goto L14
    L8:
        r13.node = null;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        this.l = true;
        CacheDisposable<T>[] r0 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        c(r0[r2]);
        r2 = r2 + 1;
        goto L3
    }

    @Override // io.reactivex.t
    public void onError(Throwable r4) {
        this.k = r4;
        this.l = true;
        CacheDisposable<T>[] r5 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.getAndSet(f), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        c(r5[r1]);
        r1 = r1 + 1;
        goto L3
    }

    @Override // io.reactivex.t
    public void onNext(T r6) {
        int r0 = this.j;
        int r2 = 0;
        if (r0 != this.c) goto L5;
        a<T> r1 = new a(r0);
        r1.f16929a[0] = r6;
        this.j = 1;
        this.i.f16930b = r1;
        this.i = r1;
    L6:
        this.g++;
        CacheDisposable<T>[] r7 = (CacheDisposable[]) ZeusTransformUtils.preCheckCast(this.d.get(), CacheDisposable[].class, "com.obric.memorydata.plugin");
        int r3 = r7.length;
    L7:
        if (r2 >= r3) goto L9;
        c(r7[r2]);
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L5:
        this.i.f16929a[r0] = r6;
        this.j = r0 + 1;
        goto L6
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r2) {
        io.reactivex.disposables.b r1 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r2, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
    }
}
