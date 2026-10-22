package io.reactivex.subjects;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xb.h;
import xb.j;

/* JADX INFO: loaded from: classes2.dex */
public final class MaybeSubject<T> extends h<T> implements j<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final MaybeDisposable[] f9711j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final MaybeDisposable[] f9712k = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<MaybeDisposable<T>[]> f9713c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicBoolean f9714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    T f9715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Throwable f9716i;

    static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        final j<? super T> downstream;

        MaybeDisposable(j<? super T> r10, MaybeSubject<T> r11) {
            this.downstream = r10;
            lazySet(r11);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            MaybeSubject<T> r10 = getAndSet(null);
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
        f9711j = new MaybeDisposable[0];
        f9712k = new MaybeDisposable[0];
    }

    MaybeSubject() {
        this.f9714g = new AtomicBoolean();
        this.f9713c = new AtomicReference(f9711j);
    }

    @Override // xb.h
    protected void b(j<? super T> r10) {
        MaybeDisposable<T> r11 = new MaybeDisposable(r10, this);
        r10.onSubscribe(r11);
        if (c(r11) == true) goto L5;
        Throwable r12 = this.f9716i;
        if (r12 == null) goto L10;
        r10.onError(r12);
        return;
    L10:
        T r13 = this.f9715h;
        if (r13 != null) goto L13;
        r10.onComplete();
        return;
    L13:
        r10.onSuccess(r13);
        return;
    L5:
        if (r11.isDisposed() == false) goto L15;
        d(r11);
        return;
    }

    boolean c(MaybeDisposable<T> r10) {
    L2:
        MaybeDisposable<T>[] r11 = this.f9713c.get();
        if (r11 == f9712k) goto L4;
        int r12 = r11.length;
        MaybeDisposable<T>[] r13 = new MaybeDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.f9713c.compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void d(MaybeDisposable<T> r10) {
    L2:
        MaybeDisposable<T>[] r11 = this.f9713c.get();
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
        MaybeDisposable<T>[] r15 = f9711j;
    L18:
        if (this.f9713c.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        MaybeDisposable<T>[] r16 = new MaybeDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    @Override // xb.j
    public void onComplete() {
        int r10 = 0;
        if (this.f9714g.compareAndSet(false, true) == false) goto L7;
        MaybeDisposable<T>[] r11 = this.f9713c.getAndSet(f9712k);
        int r12 = r11.length;
    L5:
        if (r10 >= r12) goto L9;
        r11[r10].downstream.onComplete();
        r10 = r10 + 1;
        goto L5
    L9:
        return;
    }

    @Override // xb.j
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r11 = 0;
        if (this.f9714g.compareAndSet(false, true) == false) goto L7;
        this.f9716i = r10;
        MaybeDisposable<T>[] r12 = this.f9713c.getAndSet(f9712k);
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

    @Override // xb.j
    public void onSubscribe(b r10) {
        if (this.f9713c.get() != f9712k) goto L6;
        r10.dispose();
        return;
    }

    @Override // xb.j
    public void onSuccess(T r10) {
        io.reactivex.internal.functions.a.d(r10, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r11 = 0;
        if (this.f9714g.compareAndSet(false, true) == false) goto L7;
        this.f9715h = r10;
        MaybeDisposable<T>[] r12 = this.f9713c.getAndSet(f9712k);
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
