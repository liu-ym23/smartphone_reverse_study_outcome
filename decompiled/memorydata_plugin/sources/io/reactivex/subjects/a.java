package io.reactivex.subjects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
final class a<T> extends b<T> implements io.reactivex.internal.util.a.InterfaceC0877a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b<T> f17182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f17183b;
    io.reactivex.internal.util.a<Object> c;
    volatile boolean d;

    a(b<T> r1) {
        this.f17182a = r1;
    }

    @Override // io.reactivex.Observable
    public void a(t<? super T> r3) {
        t<? super T> r4 = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17182a.subscribe(r4);
    }

    void b() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.a<Object> r0 = this.c;     // Catch: Throwable -> L11
        if (r0 == null) goto L5;
        this.c = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.a(this);
        goto L2
    L5:
        this.f17183b = false;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.d == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.d == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L10:
        this.d = true;     // Catch: Throwable -> L22
        if (this.f17183b == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.c;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L22
        this.c = r0;     // Catch: Throwable -> L22
    L15:
        r0.a(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.f17183b = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f17182a.onComplete();
    }

    @Override // io.reactivex.t
    public void onError(Throwable r3) {
        if (this.d == false) goto L6;
        io.reactivex.d.a.a(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.d == true) goto L19;
        this.d = true;     // Catch: Throwable -> L25
        if (this.f17183b == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.c;     // Catch: Throwable -> L25
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L25
        this.c = r0;     // Catch: Throwable -> L25
    L15:
        r0.b(NotificationLite.error(r3));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L18:
        this.f17183b = true;     // Catch: Throwable -> L25
        r1 = false;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L25
        if (r1 == false) goto L23;
        io.reactivex.d.a.a(r3);
        return;
    L23:
        this.f17182a.onError(r3);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.t
    public void onNext(T r3) {
        if (this.d == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.d == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.f17183b == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.c;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L22
        this.c = r0;     // Catch: Throwable -> L22
    L15:
        r0.a(NotificationLite.next(r3));     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.f17183b = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f17182a.onNext(r3);
        b();
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (this.d == true) goto L22;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.d == false) goto L9;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        goto L22
    L9:
        if (this.f17183b == false) goto L16;
        io.reactivex.internal.util.a<Object> r0 = this.c;     // Catch: Throwable -> L19
        if (r0 != null) goto L13;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L19
        this.c = r0;     // Catch: Throwable -> L19
    L13:
        r0.a(NotificationLite.disposable(r4));     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L16:
        this.f17183b = true;     // Catch: Throwable -> L19
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        r4.dispose();
        return;
    L24:
        this.f17182a.onSubscribe(r4);
        b();
    }

    @Override // io.reactivex.internal.util.a.InterfaceC0877a, io.reactivex.b.j
    public boolean test(Object r1) {
        return NotificationLite.acceptFull(r1, this.f17182a);
    }
}
