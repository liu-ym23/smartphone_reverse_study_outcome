package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class t implements com.bumptech.glide.load.data.d.a<Object>, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a f811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<?> f812b;
    private int c;
    private int d;
    private com.bumptech.glide.load.c e;
    private List<com.bumptech.glide.load.a.o<File, ?>> f;
    private int g;
    private volatile com.bumptech.glide.load.a.o.a<?> h;
    private File i;
    private u j;

    t(f<?> r3, e.a r4) {
        e.a r5 = (e.a) ZeusTransformUtils.wrapperContextForParams(r4, e.a.class, "com.obric.memorydata.plugin");
        this.d = -1;
        this.f812b = r3;
        this.f811a = r5;
    }

    private boolean c() {
        if (this.g >= this.f.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Exception r4) {
        this.f811a.a(this.j, r4, this.h.c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object r7) {
        this.f811a.a(this.e, r7, this.h.c, DataSource.RESOURCE_DISK_CACHE, this.j);
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        com.bumptech.glide.util.pool.a.a("ResourceCacheGenerator.startNext");
        List<com.bumptech.glide.load.c> r0 = this.f812b.o();     // Catch: Throwable -> L45
        boolean r2 = false;
        if (r0.isEmpty() == false) goto L8;
        com.bumptech.glide.util.pool.a.a();
        return false;
    L8:
        List<Class<?>> r1 = this.f812b.l();     // Catch: Throwable -> L45
        if (r1.isEmpty() == false) goto L18;
        if (File.class.equals(this.f812b.j()) == false) goto L15;
        com.bumptech.glide.util.pool.a.a();
        return false;
    L15:
        throw new IllegalStateException("Failed to find any load path from " + this.f812b.k() + " to " + this.f812b.j());     // Catch: Throwable -> L45
    L18:
        if (this.f != null) goto L20;
    L34:
        int r3 = this.d + 1;     // Catch: Throwable -> L45
        this.d = r3;     // Catch: Throwable -> L45
        if (r3 < r1.size()) goto L41;
        int r4 = this.c + 1;     // Catch: Throwable -> L45
        this.c = r4;     // Catch: Throwable -> L45
        if (r4 >= r0.size()) goto L38;
        this.d = 0;     // Catch: Throwable -> L45
        goto L41
    L38:
        com.bumptech.glide.util.pool.a.a();
        return false;
    L41:
        com.bumptech.glide.load.c r5 = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(r0.get(this.c), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        Class r12 = (Class) ZeusTransformUtils.preCheckCast(r1.get(this.d), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        this.j = new u(this.f812b.i(), r5, this.f812b.f(), this.f812b.g(), this.f812b.h(), this.f812b.c(r12), r12, this.f812b.e());     // Catch: Throwable -> L45
        File r6 = this.f812b.b().a(this.j);     // Catch: Throwable -> L45
        this.i = r6;     // Catch: Throwable -> L45
        if (r6 == null) goto L18;
        this.e = r5;     // Catch: Throwable -> L45
        this.f = this.f812b.a(r6);     // Catch: Throwable -> L45
        this.g = 0;     // Catch: Throwable -> L45
        goto L18
    L20:
        if (c() == false) goto L34;
        this.h = null;     // Catch: Throwable -> L45
    L23:
        if (r2 == true) goto L32;
        if (c() == false) goto L32;
        List<com.bumptech.glide.load.a.o<File, ?>> r7 = this.f;     // Catch: Throwable -> L45
        int r8 = this.g;     // Catch: Throwable -> L45
        this.g = r8 + 1;     // Catch: Throwable -> L45
        this.h = ((com.bumptech.glide.load.a.o) ZeusTransformUtils.preCheckCast(r7.get(r8), com.bumptech.glide.load.a.o.class, "com.obric.memorydata.plugin")).a(this.i, this.f812b.g(), this.f812b.h(), this.f812b.e());     // Catch: Throwable -> L45
        if (this.h == null) goto L23;
        if (this.f812b.a(this.h.c.a()) == false) goto L23;
        this.h.c.a(this.f812b.d(), this);     // Catch: Throwable -> L45
        r2 = true;
    L32:
        com.bumptech.glide.util.pool.a.a();
        return r2;
    L45:
        th = move-exception;
        com.bumptech.glide.util.pool.a.a();
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.e
    public void b() {
        com.bumptech.glide.load.a.o.a<?> r0 = this.h;
        if (r0 == null) goto L6;
        r0.c.c();
        return;
    }
}
