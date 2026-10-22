package io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xb.b;

/* JADX INFO: loaded from: classes2.dex */
public final class CompletableSubject extends xb.a implements b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final CompletableDisposable[] f9706i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final CompletableDisposable[] f9707j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<CompletableDisposable[]> f9708c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicBoolean f9709g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Throwable f9710h;

    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -7650903191002190468L;
        final b downstream;

        CompletableDisposable(b r10, CompletableSubject r11) {
            this.downstream = r10;
            lazySet(r11);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            CompletableSubject r10 = getAndSet(null);
            if (r10 == null) goto L6;
            r10.e(this);
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
        f9706i = new CompletableDisposable[0];
        f9707j = new CompletableDisposable[0];
    }

    CompletableSubject() {
        this.f9709g = new AtomicBoolean();
        this.f9708c = new AtomicReference(f9706i);
    }

    @Override // xb.a
    protected void b(b r10) {
        CompletableDisposable r11 = new CompletableDisposable(r10, this);
        r10.onSubscribe(r11);
        if (d(r11) == true) goto L5;
        Throwable r12 = this.f9710h;
        if (r12 == null) goto L10;
        r10.onError(r12);
        return;
    L10:
        r10.onComplete();
        return;
    L5:
        if (r11.isDisposed() == false) goto L12;
        e(r11);
        return;
    }

    boolean d(CompletableDisposable r10) {
    L2:
        CompletableDisposable[] r11 = this.f9708c.get();
        if (r11 == f9707j) goto L4;
        int r12 = r11.length;
        CompletableDisposable[] r13 = new CompletableDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (this.f9708c.compareAndSet(r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    void e(CompletableDisposable r10) {
    L2:
        CompletableDisposable[] r11 = this.f9708c.get();
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
        CompletableDisposable[] r15 = f9706i;
    L18:
        if (this.f9708c.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        CompletableDisposable[] r16 = new CompletableDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    @Override // xb.b
    public void onComplete() {
        int r10 = 0;
        if (this.f9709g.compareAndSet(false, true) == false) goto L7;
        CompletableDisposable[] r11 = this.f9708c.getAndSet(f9707j);
        int r12 = r11.length;
    L5:
        if (r10 >= r12) goto L9;
        r11[r10].downstream.onComplete();
        r10 = r10 + 1;
        goto L5
    L9:
        return;
    }

    @Override // xb.b
    public void onError(Throwable r10) {
        io.reactivex.internal.functions.a.d(r10, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        int r11 = 0;
        if (this.f9709g.compareAndSet(false, true) == false) goto L7;
        this.f9710h = r10;
        CompletableDisposable[] r12 = this.f9708c.getAndSet(f9707j);
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

    @Override // xb.b
    public void onSubscribe(io.reactivex.disposables.b r10) {
        if (this.f9708c.get() != f9707j) goto L6;
        r10.dispose();
        return;
    }
}
