package io.reactivex.internal.operators.maybe;

import java.util.concurrent.atomic.AtomicReference;
import xb.h;
import xb.j;
import xb.k;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeCache<T> extends h<T> implements j<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final CacheDisposable[] f9525j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final CacheDisposable[] f9526k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<k<T>> f9527c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<CacheDisposable<T>[]> f9528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    T f9529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Throwable f9530i;

    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5791853038359966195L;
        final j<? super T> downstream;

        CacheDisposable(j<? super T> r10, MaybeCache<T> r11) {
            super(r11);
            this.downstream = r10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeCache<T> r10 = getAndSet(null);
            if (r10 == null) goto L6;
            r10.d(this);
            return;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f9525j = new CacheDisposable[0];
        f9526k = new CacheDisposable[0];
    }

    @Override // xb.h
    protected void b(j<? super T> r10) {
        CacheDisposable<T> r11 = new CacheDisposable(r10, this);
        r10.onSubscribe(r11);
        if (c(r11) == false) goto L13;
        if (r11.isDisposed() == false) goto L8;
        d(r11);
        return;
    L8:
        k<T> r12 = this.f9527c.getAndSet(null);
        if (r12 == null) goto L22;
        r12.a(this);
        return;
    L22:
        return;
    L13:
        if (r11.isDisposed() == true) goto L23;
        Throwable r13 = this.f9530i;
        if (r13 == null) goto L17;
        r10.onError(r13);
        return;
    L17:
        T r14 = this.f9529h;
        if (r14 == null) goto L20;
        r10.onSuccess(r14);
        return;
    L20:
        r10.onComplete();
        return;
    }

    boolean c(CacheDisposable<T> r10) {
    L2:
        CacheDisposable<T>[] r11 = this.f9528g.get();
        if (r11 == f9526k) goto L4;
        int r12 = r11.length;
        CacheDisposable<T>[] r13 = new CacheDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.f9528g.compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void d(CacheDisposable<T> r10) {
    L2:
        CacheDisposable<T>[] r11 = this.f9528g.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = -1;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (r11[r14] == r10) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        r13 = r14;
    L11:
        if (r13 < 0) goto L12;
        if (r12 != 1) goto L16;
        CacheDisposable<T>[] r15 = f9525j;
    L18:
        if (this.f9528g.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        CacheDisposable<T>[] r16 = new CacheDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    @Override // xb.j
    public void onComplete() {
        CacheDisposable<T>[] r10 = this.f9528g.getAndSet(f9526k);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        CacheDisposable<T> r13 = r10[r12];
        if (r13.isDisposed() == true) goto L7;
        r13.downstream.onComplete();
    L7:
        r12 = r12 + 1;
        goto L3
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        this.f9530i = r10;
        CacheDisposable<T>[] r11 = this.f9528g.getAndSet(f9526k);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        CacheDisposable<T> r14 = r11[r13];
        if (r14.isDisposed() == true) goto L7;
        r14.downstream.onError(r10);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // xb.j
    public void onSubscribe(io.reactivex.disposables.b r10) {
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        this.f9529h = r10;
        CacheDisposable<T>[] r11 = this.f9528g.getAndSet(f9526k);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        CacheDisposable<T> r14 = r11[r13];
        if (r14.isDisposed() == true) goto L7;
        r14.downstream.onSuccess(r10);
    L7:
        r13 = r13 + 1;
        goto L3
    }
}
