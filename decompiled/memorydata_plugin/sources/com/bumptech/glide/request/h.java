package com.bumptech.glide.request;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h implements RequestCoordinator, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RequestCoordinator f966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f967b;
    private volatile d c;
    private volatile d d;
    private RequestCoordinator.RequestState e;
    private RequestCoordinator.RequestState f;
    private boolean g;

    public h(Object r3, RequestCoordinator r4) {
        RequestCoordinator r5 = (RequestCoordinator) ZeusTransformUtils.wrapperContextForParams(r4, RequestCoordinator.class, "com.obric.memorydata.plugin");
        this.e = RequestCoordinator.RequestState.CLEARED;
        this.f = RequestCoordinator.RequestState.CLEARED;
        this.f967b = r3;
        this.f966a = r5;
    }

    private boolean i() {
        RequestCoordinator r0 = this.f966a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.b(this) == true) goto L8;
        return false;
    }

    private boolean j() {
        RequestCoordinator r0 = this.f966a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.d(this) == true) goto L8;
        return false;
    }

    private boolean k() {
        RequestCoordinator r0 = this.f966a;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.c(this) == true) goto L8;
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public void a() {
        Object r0 = this.f967b;
        monitor-enter(r0);
        this.g = true;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        this.g = false;     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L8:
        if (this.e == RequestCoordinator.RequestState.SUCCESS) goto L13;
        if (this.f == RequestCoordinator.RequestState.RUNNING) goto L13;
        this.f = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        this.d.a();     // Catch: Throwable -> L20
    L13:
        if (this.g == true) goto L15;
    L17:
        this.g = false;     // Catch: Throwable -> L23
        monitor-exit(r0);     // Catch: Throwable -> L23
        return;
    L15:
        if (this.e == RequestCoordinator.RequestState.RUNNING) goto L17;
        this.e = RequestCoordinator.RequestState.RUNNING;     // Catch: Throwable -> L20
        this.c.a();     // Catch: Throwable -> L20
    L23:
        th = move-exception;
        throw th;
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
        if (ZeusTransformUtils.instanceOf(r6, h.class) == false) goto L20;
        h r7 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.memorydata.plugin");
        if (this.c != null) goto L10;
        if (r7.c == null) goto L12;
        return false;
    L12:
        if (this.d != null) goto L17;
        if (r7.d != null) goto L23;
    L18:
        return true;
    L23:
        return false;
    L17:
        if (this.d.a(r7.d) == true) goto L18;
        return false;
    L10:
        if (this.c.a(r7.c) == true) goto L12;
        return false;
    L20:
        return false;
    }

    @Override // com.bumptech.glide.request.d
    public void b() {
        Object r0 = this.f967b;
        monitor-enter(r0);
        this.g = false;     // Catch: Throwable -> L8
        this.e = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L8
        this.f = RequestCoordinator.RequestState.CLEARED;     // Catch: Throwable -> L8
        this.d.b();     // Catch: Throwable -> L8
        this.c.b();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f967b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (i() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.c) == false) goto L9;
    L10:
        r2 = true;
        goto L12
    L9:
        if (this.e == RequestCoordinator.RequestState.SUCCESS) goto L11;
        goto L10
    }

    @Override // com.bumptech.glide.request.d
    public void c() {
        Object r0 = this.f967b;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f.isComplete() == true) goto L8;
        this.f = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.d.c();     // Catch: Throwable -> L12
    L8:
        if (this.e.isComplete() == true) goto L10;
        this.e = RequestCoordinator.RequestState.PAUSED;     // Catch: Throwable -> L12
        this.c.c();     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f967b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (k() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.c) == false) goto L11;
        if (g() == true) goto L11;
        r2 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.d
    public boolean d() {
        Object r0 = this.f967b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.RUNNING) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f967b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (j() == true) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r2;
    L7:
        if (r4.equals(this.c) == false) goto L11;
        if (this.e == RequestCoordinator.RequestState.PAUSED) goto L11;
        r2 = true;
        goto L12
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f967b;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.d) == false) goto L9;
        this.f = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        this.e = RequestCoordinator.RequestState.SUCCESS;     // Catch: Throwable -> L17
        RequestCoordinator r5 = this.f966a;     // Catch: Throwable -> L17
        if (r5 == null) goto L13;
        r5.e(this);     // Catch: Throwable -> L17
    L13:
        if (this.f.isComplete() == true) goto L15;
        this.d.b();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
    }

    @Override // com.bumptech.glide.request.d
    public boolean e() {
        Object r0 = this.f967b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.SUCCESS) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void f(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        Object r0 = this.f967b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r4.equals(this.c) == true) goto L9;
        this.f = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L9:
        this.e = RequestCoordinator.RequestState.FAILED;     // Catch: Throwable -> L14
        RequestCoordinator r5 = this.f966a;     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r5.f(this);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    @Override // com.bumptech.glide.request.d
    public boolean f() {
        Object r0 = this.f967b;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.e != RequestCoordinator.RequestState.CLEARED) goto L7;
        boolean r2 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.d
    public boolean g() {
        Object r0 = this.f967b;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.d.g() == false) goto L7;
    L10:
        boolean r2 = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        if (this.c.g() == true) goto L10;
        r2 = false;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.bumptech.glide.request.RequestCoordinator] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator h() {
        Object r0 = this.f967b;
        monitor-enter(r0);
        RequestCoordinator r1 = this.f966a;     // Catch: Throwable -> L9
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
