package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 implements mt.u, Disposable {
    public static final ObservablePublish$InnerDisposable[] e = null;
    public static final ObservablePublish$InnerDisposable[] f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f17922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f17923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f17924c;
    public final AtomicReference d;

    static {
        e = new ObservablePublish$InnerDisposable[0];
        f = new ObservablePublish$InnerDisposable[0];
    }

    public q2(AtomicReference r5) {
        this.d = new AtomicReference();
        this.f17923b = new AtomicReference(e);
        this.f17922a = r5;
        this.f17924c = new AtomicBoolean();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(ObservablePublish$InnerDisposable r10) {
    L2:
        AtomicReference r5 = this.f17923b;
        ObservablePublish$InnerDisposable[] r11 = (ObservablePublish$InnerDisposable[]) r5.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13].equals(r10) == true) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        ObservablePublish$InnerDisposable[] r14 = e;
    L19:
        if (r5.compareAndSet(r11, r14) == true) goto L20;
        if (r5.get() == r11) goto L19;
    L20:
        return;
    L17:
        ObservablePublish$InnerDisposable[] r15 = new ObservablePublish$InnerDisposable[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L19
    L13:
        return;
    L11:
        r13 = -1;
        goto L12
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AtomicReference r5 = this.f17923b;
        ObservablePublish$InnerDisposable[] r10 = f;
        if (((ObservablePublish$InnerDisposable[]) r5.getAndSet(r10)) == r10) goto L14;
    L4:
        AtomicReference r11 = this.f17922a;
        if (r11.compareAndSet(this, null) == true) goto L9;
        if (r11.get() == this) goto L4;
    L9:
        DisposableHelper.dispose(this.d);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f17923b.get() != f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // mt.u
    public final void onComplete() {
    L2:
        AtomicReference r5 = this.f17922a;
        if (r5.compareAndSet(this, null) == true) goto L7;
        if (r5.get() == this) goto L2;
    L7:
        ObservablePublish$InnerDisposable[] r10 = (ObservablePublish$InnerDisposable[]) this.f17923b.getAndSet(f);
        int r11 = r10.length;
        int r12 = 0;
    L8:
        if (r12 >= r11) goto L10;
        r10[r12].child.onComplete();
        r12 = r12 + 1;
        goto L8
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
    L2:
        AtomicReference r10 = this.f17922a;
        if (r10.compareAndSet(this, null) == true) goto L7;
        if (r10.get() == this) goto L2;
    L7:
        ObservablePublish$InnerDisposable[] r11 = (ObservablePublish$InnerDisposable[]) this.f17923b.getAndSet(f);
        if (r11.length == 0) goto L12;
        int r12 = r11.length;
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L18;
        r11[r13].child.onError(r5);
        r13 = r13 + 1;
        goto L10
    L18:
        return;
    L12:
        wn.f.k(r5);
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        ObservablePublish$InnerDisposable[] r10 = (ObservablePublish$InnerDisposable[]) this.f17923b.get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].child.onNext(r5);
        r12 = r12 + 1;
        goto L3
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        DisposableHelper.setOnce(this.d, r5);
    }
}
