package io.reactivex.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import mt.u;
import wn.f;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements u, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f18180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f18181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18182c;
    public io.reactivex.internal.util.b d;
    public volatile boolean e;

    public d(u r5) {
        this.f18180a = r5;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f18181b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f18181b.isDisposed();
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.e == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.f18182c == false) goto L20;
        io.reactivex.internal.util.b r5 = this.d;     // Catch: Throwable -> L10
        if (r5 != null) goto L17;
        r5 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L10
        this.d = r5;     // Catch: Throwable -> L10
    L17:
        r5.a(NotificationLite.complete());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.e = true;     // Catch: Throwable -> L10
        this.f18182c = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f18180a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.e == false) goto L6;
        f.k(r5);
        return;
    L6:
        monitor-enter(this);
        boolean r10 = true;
        if (this.e == false) goto L11;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r10 == false) goto L25;
        f.k(r5);
        return;
    L25:
        this.f18180a.onError(r5);
        return;
    L11:
        if (this.f18182c == false) goto L20;
        this.e = true;     // Catch: Throwable -> L15
        io.reactivex.internal.util.b r11 = this.d;     // Catch: Throwable -> L15
        if (r11 != null) goto L17;
        r11 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L15
        this.d = r11;     // Catch: Throwable -> L15
    L17:
        r11.f18169a[0] = NotificationLite.error(r5);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
        this.e = true;     // Catch: Throwable -> L15
        this.f18182c = true;     // Catch: Throwable -> L15
        r10 = false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r10) {
        if (this.e == false) goto L5;
        return;
    L5:
        if (r10 != null) goto L8;
        this.f18181b.dispose();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L10:
        if (this.e == false) goto L16;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L16:
        if (this.f18182c == false) goto L23;
        io.reactivex.internal.util.b r5 = this.d;     // Catch: Throwable -> L13
        if (r5 != null) goto L20;
        r5 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L13
        this.d = r5;     // Catch: Throwable -> L13
    L20:
        r5.a(NotificationLite.next(r10));     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L23:
        this.f18182c = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.f18180a.onNext(r10);
    L26:
        monitor-enter(this);
        io.reactivex.internal.util.b r11 = this.d;     // Catch: Throwable -> L32
        if (r11 == null) goto L29;
        this.d = null;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        u r12 = this.f18180a;
        Object[] r13 = r11.f18169a;
    L37:
        if (r13 == null) goto L26;
        int r14 = 0;
    L40:
        if (r14 >= 4) goto L48;
        Object[] r15 = r13[r14];
        if (r15 == null) goto L48;
        if (NotificationLite.acceptFull(r15, r12) == true) goto L63;
        r14 = r14 + 1;
        goto L40
    L63:
        return;
    L48:
        r13 = r13[4];
        goto L37
    L29:
        this.f18182c = false;     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        if (DisposableHelper.validate(this.f18181b, r5) == false) goto L6;
        this.f18181b = r5;
        this.f18180a.onSubscribe(this);
        return;
    }
}
