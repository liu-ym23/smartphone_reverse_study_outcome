package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b implements RequestCoordinator, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RequestCoordinator f963b;
    private volatile d c;
    private volatile d d;
    private RequestCoordinator.RequestState e;
    private RequestCoordinator.RequestState f;

    public b(Object r3, RequestCoordinator r4) {
        RequestCoordinator r5 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r4, RequestCoordinator.class, "com.obric.memorydata.plugin");
        this.e = RequestCoordinator.RequestState.CLEARED;
        this.f = RequestCoordinator.RequestState.CLEARED;
        this.f962a = r3;
        this.f963b = r5;
    }

    private boolean g(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (this.e == RequestCoordinator.RequestState.FAILED) goto L7;
        return r4.equals(this.c);
    L7:
        if (r4.equals(this.d) == true) goto L9;
    L13:
        return false;
    L9:
        if (this.f != RequestCoordinator.RequestState.SUCCESS) goto L11;
    L12:
        return true;
    L11:
        if (this.f != RequestCoordinator.RequestState.FAILED) goto L13;
        goto L12
    }

    private boolean i() {
        RequestCoordinator r0 = this.f963b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.b(this) == true) goto L8;
        return false;
    }

    private boolean j() {
        RequestCoordinator r0 = this.f963b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean k() {
        RequestCoordinator r0 = this.f963b;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.e == RequestCoordinator.RequestState.RUNNING) goto L7;
        this.e = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L9
        this.c.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void a(d r3, d r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = r6;
    }

    @Override // com.bumptech.glide.request.d
    public boolean a(d r5) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L10;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.memorydata.plugin");
        if (this.c.a(r7.c) == true) goto L7;
        return false;
    L7:
        if (this.d.a(r7.d) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.f962a;
        monitor-enter(r0);
        this.e = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L9
        this.c.b();     // Catch: Throwable -> L9
        if (this.f == RequestCoordinator.RequestState.CLEARED) goto L7;
        this.f = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L9
        this.d.b();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r5 = this.f962a;
        monitor-enter(r5);
        boolean r2 = i();     // Catch: Throwable -> L7
        monitor-exit(r5);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.RUNNING) goto L8;
        this.e = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.c.c();     // Catch: Throwable -> L12
    L8:
        if (this.f != RequestCoordinator.RequestState.RUNNING) goto L10;
        this.f = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.d.c();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f962a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (k() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (g(r4) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.RUNNING) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.f == RequestCoordinator.RequestState.RUNNING) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f962a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (j() == true) goto L7;
    L9:
        boolean r2 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L7:
        if (r4.equals(this.c) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f962a;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.c) == false) goto L8;
        this.e = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
    L10:
        RequestCoordinator r5 = this.f963b;     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        r5.e(this);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        if (r4.equals(this.d) == false) goto L10;
        this.f = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L15
        goto L10
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.SUCCESS) goto L7;
    L10:
        boolean r3 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r3;
    L7:
        if (this.f == RequestCoordinator.RequestState.SUCCESS) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f962a;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.d) == true) goto L11;
        this.e = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        if (this.f == RequestCoordinator.RequestState.RUNNING) goto L9;
        this.f = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L16
        this.d.a();     // Catch: Throwable -> L16
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        this.f = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L16
        RequestCoordinator r5 = this.f963b;     // Catch: Throwable -> L16
        if (r5 == null) goto L14;
        r5.f(this);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.e == RequestCoordinator.RequestState.CLEARED) goto L7;
    L9:
        boolean r3 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r3;
    L7:
        if (this.f != RequestCoordinator.RequestState.CLEARED) goto L9;
        r3 = true;
        goto L10
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.d
    public boolean g() {
        Object r0 = this.f962a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.c.g() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.d.g() == true) goto L10;
        r2 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.RequestCoordinator] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator h() {
        Object r0 = this.f962a;
        monitor-enter(r0);
        RequestCoordinator r1 = this.f963b;     // Catch: Throwable -> L9
        ?? r2 = this;
        if (r1 == null) goto L7;
        r2 = r1.h();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }
}
