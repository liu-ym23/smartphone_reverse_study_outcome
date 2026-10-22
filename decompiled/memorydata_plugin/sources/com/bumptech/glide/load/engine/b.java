package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class b implements com.bumptech.glide.load.data.d.a<Object>, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f<?> f739b;
    private final e.a c;
    private int d;
    private com.bumptech.glide.load.c e;
    private List<com.bumptech.glide.load.a.o<File, ?>> f;
    private int g;
    private volatile com.bumptech.glide.load.a.o.a<?> h;
    private File i;

    b(f<?> r3, e.a r4) {
        e.a r5 = (e.a) ZeusTransformUtils.wrapperContextForParams(r4, e.a.class, "com.obric.memorydata.plugin");
        this(r3.o(), r3, r5);
    }

    b(List<com.bumptech.glide.load.c> r3, f<?> r4, e.a r5) {
        List<com.bumptech.glide.load.c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        e.a r7 = (e.a) ZeusTransformUtils.wrapperContextForParams(r5, e.a.class, "com.obric.memorydata.plugin");
        this.d = -1;
        this.f738a = r6;
        this.f739b = r4;
        this.c = r7;
    }

    private boolean c() {
        if (this.g >= this.f.size()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Exception r4) {
        this.c.a(this.e, r4, this.h.c, DataSource.DATA_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object r7) {
        this.c.a(this.e, r7, this.h.c, DataSource.DATA_DISK_CACHE, this.e);
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        com.bumptech.glide.util.pool.a.a("DataCacheGenerator.startNext");
    L32:
    L29:
        th = move-exception;
        com.bumptech.glide.util.pool.a.a();
        throw th;
    L4:
        boolean r2 = false;
        if (this.f != null) goto L7;
    L21:
        int r0 = this.d + 1;     // Catch: Throwable -> L29
        this.d = r0;     // Catch: Throwable -> L29
        if (r0 >= this.f738a.size()) goto L23;
        com.bumptech.glide.load.c r1 = (com.bumptech.glide.load.c) ZeusTransformUtils.preCheckCast(this.f738a.get(this.d), com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        File r3 = this.f739b.b().a(new c(r1, this.f739b.f()));     // Catch: Throwable -> L29
        this.i = r3;     // Catch: Throwable -> L29
        if (r3 == null) goto L32;
        this.e = r1;     // Catch: Throwable -> L29
        this.f = this.f739b.a(r3);     // Catch: Throwable -> L29
        this.g = 0;     // Catch: Throwable -> L29
        goto L32
    L23:
        com.bumptech.glide.util.pool.a.a();
        return false;
    L7:
        if (c() == false) goto L21;
        this.h = null;     // Catch: Throwable -> L29
    L10:
        if (r2 == true) goto L19;
        if (c() == false) goto L19;
        List<com.bumptech.glide.load.a.o<File, ?>> r4 = this.f;     // Catch: Throwable -> L29
        int r5 = this.g;     // Catch: Throwable -> L29
        this.g = r5 + 1;     // Catch: Throwable -> L29
        this.h = ((com.bumptech.glide.load.a.o) ZeusTransformUtils.preCheckCast(r4.get(r5), com.bumptech.glide.load.a.o.class, "com.obric.memorydata.plugin")).a(this.i, this.f739b.g(), this.f739b.h(), this.f739b.e());     // Catch: Throwable -> L29
        if (this.h == null) goto L10;
        if (this.f739b.a(this.h.c.a()) == false) goto L10;
        this.h.c.a(this.f739b.d(), this);     // Catch: Throwable -> L29
        r2 = true;
    L19:
        com.bumptech.glide.util.pool.a.a();
        return r2;
    }

    @Override // com.bumptech.glide.load.engine.e
    public void b() {
        com.bumptech.glide.load.a.o.a<?> r0 = this.h;
        if (r0 == null) goto L6;
        r0.c.c();
        return;
    }
}
