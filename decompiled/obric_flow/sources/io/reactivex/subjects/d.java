package io.reactivex.subjects;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PublishSubject$PublishDisposable[] f18194c = null;
    public static final PublishSubject$PublishDisposable[] d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f18195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f18196b;

    static {
        f18194c = new PublishSubject$PublishDisposable[0];
        d = new PublishSubject$PublishDisposable[0];
    }

    public d() {
        this.f18195a = new AtomicReference(d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(PublishSubject$PublishDisposable r10) {
    L2:
        AtomicReference r5 = this.f18195a;
        PublishSubject$PublishDisposable[] r11 = (PublishSubject$PublishDisposable[]) r5.get();
        if (r11 == f18194c) goto L26;
        PublishSubject$PublishDisposable[] r12 = d;
        if (r11 == r12) goto L36;
        int r13 = r11.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L13;
        if (r11[r14] == r10) goto L14;
        r14 = r14 + 1;
    L14:
        if (r14 < 0) goto L15;
        if (r13 == 1) goto L21;
        r12 = new PublishSubject$PublishDisposable[r13 - 1];
        System.arraycopy(r11, 0, r12, 0, r14);
        System.arraycopy(r11, r14 + 1, r12, r14, (r13 - r14) - 1);
    L21:
        if (r5.compareAndSet(r11, r12) == true) goto L22;
        if (r5.get() == r11) goto L21;
    L22:
        return;
    L15:
        return;
    L13:
        r14 = -1;
        goto L14
    L36:
        return;
    }

    @Override // mt.u
    public final void onComplete() {
        AtomicReference r5 = this.f18195a;
        Object r10 = r5.get();
        Object r11 = f18194c;
        if (r10 != r11) goto L5;
        return;
    L5:
        PublishSubject$PublishDisposable[] r12 = (PublishSubject$PublishDisposable[]) r5.getAndSet(r11);
        int r13 = r12.length;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L8;
        r12[r14].onComplete();
        r14 = r14 + 1;
        goto L6
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        io.reactivex.internal.functions.e.d(r5, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference r10 = this.f18195a;
        Object r11 = r10.get();
        Object r12 = f18194c;
        if (r11 != r12) goto L6;
        wn.f.k(r5);
        return;
    L6:
        this.f18196b = r5;
        PublishSubject$PublishDisposable[] r13 = (PublishSubject$PublishDisposable[]) r10.getAndSet(r12);
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        r13[r15].onError(r5);
        r15 = r15 + 1;
        goto L7
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        io.reactivex.internal.functions.e.d(r5, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishSubject$PublishDisposable[] r10 = (PublishSubject$PublishDisposable[]) this.f18195a.get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].onNext(r5);
        r12 = r12 + 1;
        goto L3
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (this.f18195a.get() != f18194c) goto L6;
        r5.dispose();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mt.n
    public final void subscribeActual(u r10) {
        PublishSubject$PublishDisposable r5 = new PublishSubject$PublishDisposable(r10, this);
        r10.onSubscribe(r5);
    L3:
        AtomicReference r11 = this.f18195a;
        PublishSubject$PublishDisposable[] r12 = (PublishSubject$PublishDisposable[]) r11.get();
        if (r12 == f18194c) goto L5;
        int r13 = r12.length;
        PublishSubject$PublishDisposable[] r14 = new PublishSubject$PublishDisposable[r13 + 1];
        System.arraycopy(r12, 0, r14, 0, r13);
        r14[r13] = r5;
    L11:
        if (r11.compareAndSet(r12, r14) == true) goto L13;
        if (r11.get() == r12) goto L11;
    L13:
        if (r5.isDisposed() == false) goto L25;
        d(r5);
        return;
    L25:
        return;
    L5:
        Throwable r15 = this.f18196b;
        if (r15 == null) goto L8;
        r10.onError(r15);
        return;
    L8:
        r10.onComplete();
    }
}
