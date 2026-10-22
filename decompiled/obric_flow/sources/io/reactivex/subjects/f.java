package io.reactivex.subjects;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.NotificationLite;
import mt.u;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends h implements io.reactivex.internal.util.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public io.reactivex.internal.util.b f18199c;
    public volatile boolean d;

    public f(d r5) {
        this.f18197a = r5;
    }

    public final void d() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.b r5 = this.f18199c;     // Catch: Throwable -> L8
        if (r5 == null) goto L5;
        this.f18199c = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        r5.b(this);
        goto L2
    L5:
        this.f18198b = false;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onComplete() {
        if (this.d == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.d == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L12:
        this.d = true;     // Catch: Throwable -> L10
        if (this.f18198b == false) goto L20;
        io.reactivex.internal.util.b r5 = this.f18199c;     // Catch: Throwable -> L10
        if (r5 != null) goto L17;
        r5 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L10
        this.f18199c = r5;     // Catch: Throwable -> L10
    L17:
        r5.a(NotificationLite.complete());     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.f18198b = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f18197a.onComplete();
    }

    @Override // mt.u
    public final void onError(Throwable r5) {
        if (this.d == false) goto L6;
        wn.f.k(r5);
        return;
    L6:
        monitor-enter(this);
        boolean r10 = true;
        if (this.d == true) goto L21;
        this.d = true;     // Catch: Throwable -> L15
        if (this.f18198b == false) goto L20;
        io.reactivex.internal.util.b r11 = this.f18199c;     // Catch: Throwable -> L15
        if (r11 != null) goto L17;
        r11 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L15
        this.f18199c = r11;     // Catch: Throwable -> L15
    L17:
        r11.f18169a[0] = NotificationLite.error(r5);     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L20:
        this.f18198b = true;     // Catch: Throwable -> L15
        r10 = false;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r10 == false) goto L25;
        wn.f.k(r5);
        return;
    L25:
        this.f18197a.onError(r5);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // mt.u
    public final void onNext(Object r5) {
        if (this.d == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.d == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L13:
        if (this.f18198b == false) goto L20;
        io.reactivex.internal.util.b r10 = this.f18199c;     // Catch: Throwable -> L10
        if (r10 != null) goto L17;
        r10 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L10
        this.f18199c = r10;     // Catch: Throwable -> L10
    L17:
        r10.a(NotificationLite.next(r5));     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L20:
        this.f18198b = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        this.f18197a.onNext(r5);
        d();
    }

    @Override // mt.u
    public final void onSubscribe(Disposable r5) {
        boolean r10 = true;
        if (this.d == true) goto L23;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.d == false) goto L9;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L23
    L9:
        if (this.f18198b == false) goto L18;
        io.reactivex.internal.util.b r11 = this.f18199c;     // Catch: Throwable -> L13
        if (r11 != null) goto L15;
        r11 = new io.reactivex.internal.util.b();     // Catch: Throwable -> L13
        this.f18199c = r11;     // Catch: Throwable -> L13
    L15:
        r11.a(NotificationLite.disposable(r5));     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L18:
        this.f18198b = true;     // Catch: Throwable -> L13
        r10 = false;
    L23:
        if (r10 == false) goto L25;
        r5.dispose();
        return;
    L25:
        this.f18197a.onSubscribe(r5);
        d();
    }

    @Override // mt.n
    public final void subscribeActual(u r5) {
        this.f18197a.subscribe(r5);
    }

    @Override // pt.p
    public final boolean test(Object r5) {
        return NotificationLite.acceptFull(r5, this.f18197a);
    }
}
