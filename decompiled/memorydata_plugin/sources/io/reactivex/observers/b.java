package io.reactivex.observers;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.t;

/* JADX INFO: loaded from: classes6.dex */
public final class b<T> implements io.reactivex.disposables.b, t<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final t<? super T> f17157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f17158b;
    io.reactivex.disposables.b c;
    boolean d;
    io.reactivex.internal.util.a<Object> e;
    volatile boolean f;

    public b(t<? super T> r3) {
        this((t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin"), false);
    }

    public b(t<? super T> r3, boolean r4) {
        this.f17157a = (t) ZeusTransformUtils.wrapperContextForParams(r3, t.class, "com.obric.memorydata.plugin");
        this.f17158b = r4;
    }

    void a() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.a<Object> r0 = this.e;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        this.e = null;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r0.a(this.f17157a) == false) goto L2;
        return;
    L5:
        this.d = false;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.c.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // io.reactivex.t
    public void onComplete() {
        if (this.f == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.f == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.d == false) goto L18;
        io.reactivex.internal.util.a<Object> r0 = this.e;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L22
        this.e = r0;     // Catch: Throwable -> L22
    L15:
        r0.a(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.f = true;     // Catch: Throwable -> L22
        this.d = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f17157a.onComplete();
    }

    @Override // io.reactivex.t
    public void onError(Throwable r3) {
        if (this.f == false) goto L6;
        io.reactivex.d.a.a(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.f == false) goto L11;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r1 == false) goto L26;
        io.reactivex.d.a.a(r3);
        return;
    L26:
        this.f17157a.onError(r3);
        return;
    L11:
        if (this.d == false) goto L21;
        this.f = true;     // Catch: Throwable -> L28
        io.reactivex.internal.util.a<Object> r0 = this.e;     // Catch: Throwable -> L28
        if (r0 != null) goto L15;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L28
        this.e = r0;     // Catch: Throwable -> L28
    L15:
        Object r4 = NotificationLite.error(r3);     // Catch: Throwable -> L28
        if (this.f17158b == false) goto L18;
        r0.a(r4);     // Catch: Throwable -> L28
    L19:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L18:
        r0.b(r4);     // Catch: Throwable -> L28
        goto L19
    L21:
        this.f = true;     // Catch: Throwable -> L28
        this.d = true;     // Catch: Throwable -> L28
        r1 = false;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.t
    public void onNext(T r3) {
        if (this.f == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        this.c.dispose();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L10:
        if (this.f == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L14:
        if (this.d == false) goto L21;
        io.reactivex.internal.util.a<Object> r0 = this.e;     // Catch: Throwable -> L25
        if (r0 != null) goto L18;
        r0 = new io.reactivex.internal.util.a(4);     // Catch: Throwable -> L25
        this.e = r0;     // Catch: Throwable -> L25
    L18:
        r0.a(NotificationLite.next(r3));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L21:
        this.d = true;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        this.f17157a.onNext(r3);
        a();
    }

    @Override // io.reactivex.t
    public void onSubscribe(io.reactivex.disposables.b r3) {
        io.reactivex.disposables.b r4 = (io.reactivex.disposables.b) ZeusTransformUtils.wrapperContextForParams(r3, io.reactivex.disposables.b.class, "com.obric.memorydata.plugin");
        if (DisposableHelper.validate(this.c, r4) == false) goto L6;
        this.c = r4;
        this.f17157a.onSubscribe(this);
        return;
    }
}
