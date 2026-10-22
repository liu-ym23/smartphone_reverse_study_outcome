package io.reactivex.subjects;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xb.q;
import xb.r;

/* JADX INFO: loaded from: classes2.dex */
public final class SingleSubject<T> extends q<T> implements r<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final SingleDisposable[] f9717j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final SingleDisposable[] f9718k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<SingleDisposable<T>[]> f9719c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicBoolean f9720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    T f9721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Throwable f9722i;

    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        final r<? super T> downstream;

        SingleDisposable(r<? super T> r10, SingleSubject<T> r11) {
            this.downstream = r10;
            lazySet(r11);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SingleSubject<T> r10 = getAndSet(null);
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
        f9717j = new SingleDisposable[0];
        f9718k = new SingleDisposable[0];
    }

    SingleSubject() {
        this.f9720g = new AtomicBoolean();
        this.f9719c = new AtomicReference(f9717j);
    }

    @Override // xb.q
    protected void b(r<? super T> r10) {
        SingleDisposable<T> r11 = new SingleDisposable(r10, this);
        r10.onSubscribe(r11);
        if (c(r11) == true) goto L5;
        Throwable r12 = this.f9722i;
        if (r12 == null) goto L10;
        r10.onError(r12);
        return;
    L10:
        r10.onSuccess(this.f9721h);
        return;
    L5:
        if (r11.isDisposed() == false) goto L12;
        d(r11);
        return;
    }

    boolean c(SingleDisposable<T> r10) {
    L2:
        SingleDisposable<T>[] r11 = this.f9719c.get();
        if (r11 == f9718k) goto L4;
        int r12 = r11.length;
        SingleDisposable<T>[] r13 = new SingleDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.f9719c.compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void d(SingleDisposable<T> r10) {
    L2:
        SingleDisposable<T>[] r11 = this.f9719c.get();
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
        SingleDisposable<T>[] r15 = f9717j;
    L18:
        if (this.f9719c.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        SingleDisposable<T>[] r16 = new SingleDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    @Override // xb.r
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r11 = 0;
        if (this.f9720g.compareAndSet(false, true) == false) goto L7;
        this.f9722i = r10;
        SingleDisposable<T>[] r12 = this.f9719c.getAndSet(f9718k);
        int r13 = r12.length;
    L5:
        if (r11 >= r13) goto L10;
        r12[r11].downstream.onError(r10);
        r11 = r11 + 1;
        goto L5
    L10:
        return;
    L7:
        dc.a.n(r10);
    }

    @Override // xb.r
    public void onSubscribe(b r10) {
        if (this.f9719c.get() != f9718k) goto L6;
        r10.dispose();
        return;
    }

    @Override // xb.r
    public void onSuccess(T r10) {
        io.reactivex.internal.functions.a.d(r10, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r11 = 0;
        if (this.f9720g.compareAndSet(false, true) == false) goto L7;
        this.f9721h = r10;
        SingleDisposable<T>[] r12 = this.f9719c.getAndSet(f9718k);
        int r13 = r12.length;
    L5:
        if (r11 >= r13) goto L9;
        r12[r11].downstream.onSuccess(r10);
        r11 = r11 + 1;
        goto L5
    L9:
        return;
    }
}
