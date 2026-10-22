package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends mt.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final st.a f17709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableRefCount$RefConnection f17711c;

    public a3(st.a r5) {
        TimeUnit r10 = TimeUnit.NANOSECONDS;
        this.f17709a = r5;
        this.f17710b = 1;
    }

    public final void d(ObservableRefCount$RefConnection r5) {
        monitor-enter(this);
        ObservableRefCount$RefConnection r10 = this.f17711c;     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        if (r10 != r5) goto L11;
        this.f17711c = null;     // Catch: Throwable -> L9
        Disposable r11 = r5.timer;     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        r11.dispose();     // Catch: Throwable -> L9
    L11:
        long r12 = r5.subscriberCount - 1;     // Catch: Throwable -> L9
        r5.subscriberCount = r12;     // Catch: Throwable -> L9
        if (r12 != 0) goto L19;
        Object r13 = this.f17709a;     // Catch: Throwable -> L9
        if ((r13 instanceof Disposable) == false) goto L17;
        ((Disposable) r13).dispose();     // Catch: Throwable -> L9
        goto L19
    L17:
        if ((r13 instanceof qt.c) == false) goto L19;
        ((qt.c) r13).a(r5.get());     // Catch: Throwable -> L9
    L19:
        monitor-exit(this);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void e(ObservableRefCount$RefConnection r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r5.subscriberCount == 0) goto L6;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L6:
        if (r5 != this.f17711c) goto L17;
        this.f17711c = null;     // Catch: Throwable -> L10
        Disposable r10 = r5.get();     // Catch: Throwable -> L10
        DisposableHelper.dispose(r5);     // Catch: Throwable -> L10
        Object r11 = this.f17709a;     // Catch: Throwable -> L10
        if ((r11 instanceof Disposable) == false) goto L13;
        ((Disposable) r11).dispose();     // Catch: Throwable -> L10
        goto L17
    L13:
        if ((r11 instanceof qt.c) == false) goto L17;
        if (r10 != null) goto L16;
        r5.disconnectedEarly = true;     // Catch: Throwable -> L10
        goto L17
    L16:
        ((qt.c) r11).a(r10);     // Catch: Throwable -> L10
        goto L17
    }

    @Override // mt.n
    public final void subscribeActual(mt.u r10) {
        monitor-enter(this);
        ObservableRefCount$RefConnection r5 = this.f17711c;     // Catch: Throwable -> L6
        if (r5 != null) goto L8;
        r5 = new ObservableRefCount$RefConnection(this);     // Catch: Throwable -> L6
        this.f17711c = r5;     // Catch: Throwable -> L6
    L8:
        long r11 = r5.subscriberCount;     // Catch: Throwable -> L6
        if (r11 != 0) goto L13;
        Disposable r12 = r5.timer;     // Catch: Throwable -> L6
        if (r12 == null) goto L13;
        r12.dispose();     // Catch: Throwable -> L6
    L13:
        long r13 = r11 + 1;     // Catch: Throwable -> L6
        r5.subscriberCount = r13;     // Catch: Throwable -> L6
        if (r5.connected == false) goto L16;
    L18:
        boolean r14 = false;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.f17709a.subscribe(new ObservableRefCount$RefCountObserver(r10, this, r5));
        if (r14 == false) goto L28;
        this.f17709a.d(r5);
        return;
    L28:
        return;
    L16:
        if (r13 != this.f17710b) goto L18;
        r14 = true;
        r5.connected = true;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
