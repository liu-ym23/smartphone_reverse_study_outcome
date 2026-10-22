package io.reactivex.processors;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.util.NotificationLite;
import org.a.c;
import org.a.d;

/* JADX INFO: loaded from: classes6.dex */
final class b<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<T> f17167b;
    boolean c;
    io.reactivex.internal.util.a<Object> d;
    volatile boolean e;

    b(a<T> r1) {
        this.f17167b = r1;
    }

    @Override // io.reactivex.g
    public void a(c<? super T> r3) {
        c<? super T> r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        this.f17167b.subscribe(r4);
    }

    void c() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.a<Object> r0 = this.d;     // Catch: Throwable -> L11
        if (r0 == null) goto L5;
        this.d = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        r0.a(this.f17167b);
        goto L2
    L5:
        this.c = false;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // org.a.c
    public void onComplete() {
        if (this.e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.e == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L10:
        this.e = true;     // Catch: Throwable -> L22
        if (this.c == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.d;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L22
        this.d = r0;     // Catch: Throwable -> L22
    L15:
        r0.a(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.c = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f17167b.onComplete();
    }

    @Override // org.a.c
    public void onError(Throwable r3) {
        if (this.e == false) goto L6;
        io.reactivex.d.a.a(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.e == true) goto L19;
        this.e = true;     // Catch: Throwable -> L25
        if (this.c == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.d;     // Catch: Throwable -> L25
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L25
        this.d = r0;     // Catch: Throwable -> L25
    L15:
        r0.b(NotificationLite.error(r3));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L18:
        this.c = true;     // Catch: Throwable -> L25
        r1 = false;
    L19:
        monitor-exit(this);     // Catch: Throwable -> L25
        if (r1 == false) goto L23;
        io.reactivex.d.a.a(r3);
        return;
    L23:
        this.f17167b.onError(r3);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // org.a.c
    public void onNext(T r3) {
        if (this.e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.e == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.c == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.d;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L22
        this.d = r0;     // Catch: Throwable -> L22
    L15:
        r0.a(NotificationLite.next(r3));     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.c = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f17167b.onNext(r3);
        c();
    }

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (this.e == true) goto L22;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.e == false) goto L9;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        goto L22
    L9:
        if (this.c == false) goto L16;
        io.reactivex.internal.util.a<Object> r0 = this.d;     // Catch: Throwable -> L19
        if (r0 != null) goto L13;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L19
        this.d = r0;     // Catch: Throwable -> L19
    L13:
        r0.a(NotificationLite.subscription(r4));     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L16:
        this.c = true;     // Catch: Throwable -> L19
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        r4.cancel();
        return;
    L24:
        this.f17167b.onSubscribe(r4);
        c();
    }
}
