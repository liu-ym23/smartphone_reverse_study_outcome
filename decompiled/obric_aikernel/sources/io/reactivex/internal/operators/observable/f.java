package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class f<T> implements xb.o<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final ObservablePublish$InnerDisposable[] f9560i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final ObservablePublish$InnerDisposable[] f9561j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<f<T>> f9562c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<ObservablePublish$InnerDisposable<T>[]> f9563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f9564h;

    static {
        f9560i = new ObservablePublish$InnerDisposable[0];
        f9561j = new ObservablePublish$InnerDisposable[0];
    }

    void a(ObservablePublish$InnerDisposable<T> r10) {
    L2:
        ObservablePublish$InnerDisposable<T>[] r11 = this.f9563g.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = -1;
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L11;
        if (r11[r14].equals(r10) == true) goto L9;
        r14 = r14 + 1;
        goto L6
    L9:
        r13 = r14;
    L11:
        if (r13 < 0) goto L12;
        if (r12 != 1) goto L16;
        ObservablePublish$InnerDisposable<T>[] r15 = f9560i;
    L18:
        if (this.f9563g.compareAndSet(r11, r15) == false) goto L2;
        return;
    L16:
        ObservablePublish$InnerDisposable<T>[] r16 = new ObservablePublish$InnerDisposable[r12 - 1];
        System.arraycopy(r11, 0, r16, 0, r13);
        System.arraycopy(r11, r13 + 1, r16, r13, (r12 - r13) - 1);
        r15 = r16;
        goto L18
    L12:
        return;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        AtomicReference<ObservablePublish$InnerDisposable<T>[]> r10 = this.f9563g;
        ObservablePublish$InnerDisposable<T>[] r11 = f9561j;
        if (r10.getAndSet(r11) == r11) goto L6;
        this.f9562c.compareAndSet(this, null);
        DisposableHelper.dispose(this.f9564h);
        return;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        if (this.f9563g.get() != f9561j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // xb.o
    public void onComplete() {
        this.f9562c.compareAndSet(this, null);
        ObservablePublish$InnerDisposable<T>[] r10 = this.f9563g.getAndSet(f9561j);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10[r12].child.onComplete();
        r12 = r12 + 1;
        goto L3
    }

    @Override // xb.o
    public void onError(Throwable r10) {
        this.f9562c.compareAndSet(this, null);
        ObservablePublish$InnerDisposable<T>[] r11 = this.f9563g.getAndSet(f9561j);
        if (r11.length == 0) goto L7;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L10;
        r11[r13].child.onError(r10);
        r13 = r13 + 1;
        goto L5
    L10:
        return;
    L7:
        dc.a.n(r10);
    }

    @Override // xb.o
    public void onNext(T r10) {
        ObservablePublish$InnerDisposable<T>[] r11 = this.f9563g.get();
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11[r13].child.onNext(r10);
        r13 = r13 + 1;
        goto L3
    }

    @Override // xb.o
    public void onSubscribe(io.reactivex.disposables.b r10) {
        DisposableHelper.setOnce(this.f9564h, r10);
    }
}
