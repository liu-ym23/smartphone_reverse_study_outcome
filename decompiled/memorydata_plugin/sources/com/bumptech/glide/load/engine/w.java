package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class w implements e, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f<?> f816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a f817b;
    private volatile int c;
    private volatile b d;
    private volatile Object e;
    private volatile com.bumptech.glide.load.a.o.a<?> f;
    private volatile c g;

    w(f<?> r3, e.a r4) {
        e.a r5 = (e.a) ZeusTransformUtils.wrapperContextForParams(r4, e.a.class, "com.obric.memorydata.plugin");
        this.f816a = r3;
        this.f817b = r5;
    }

    private boolean a(Object r13) {
        long r1 = com.bumptech.glide.util.f.a();
        boolean r3 = true;
        com.bumptech.glide.load.data.e<T> r5 = this.f816a.a(r13);     // Catch: Throwable -> L20
        Object r6 = r5.a();     // Catch: Throwable -> L20
        com.bumptech.glide.load.a<X> r7 = this.f816a.b(r6);     // Catch: Throwable -> L20
        d r8 = new d(r7, r6, this.f816a.e());     // Catch: Throwable -> L20
        c r9 = new c(this.f.f622a, this.f816a.f());     // Catch: Throwable -> L20
        com.bumptech.glide.load.engine.a.a r10 = this.f816a.b();     // Catch: Throwable -> L20
        r10.a(r9, r8);     // Catch: Throwable -> L20
        if (Log.isLoggable("SourceGenerator", 2) == false) goto L8;
        Log.v("SourceGenerator", "Finished encoding source to cache, key: " + r9 + ", data: " + r13 + ", encoder: " + r7 + ", duration: " + com.bumptech.glide.util.f.a(r1));     // Catch: Throwable -> L20
    L8:
        if (r10.a(r9) == null) goto L14;
        this.g = r9;     // Catch: Throwable -> L20
        this.d = new b(Collections.singletonList(this.f.f622a), this.f816a, this);     // Catch: Throwable -> L20
        this.f.c.b();
        return true;
    L14:
        if (Log.isLoggable("SourceGenerator", 3) == false) goto L25;
        Log.d("SourceGenerator", "Attempt to write: " + this.g + ", data: " + r13 + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");     // Catch: Throwable -> L20
    L25:
        this.f817b.a(this.f.f622a, r5.a(), this.f.c, this.f.c.d(), this.f.f622a);     // Catch: Throwable -> L18
        return false;
    L18:
        th = th;
    L22:
        if (r3 == true) goto L24;
        this.f.c.b();
    L24:
        throw th;
    L20:
        th = th;
        r3 = false;
        goto L22
    }

    private void b(final com.bumptech.glide.load.a.o.a<?> r4) {
        this.f.c.a(this.f816a.d(), new AnonymousClass1(this, r4));
    }

    private boolean d() {
        if (this.c >= this.f816a.n().size()) goto L5;
        return true;
    L5:
        return false;
    }

    void a(com.bumptech.glide.load.a.o.a<?> r3, Exception r4) {
        this.f817b.a(this.g, r4, r3.c, r3.c.d());
    }

    void a(com.bumptech.glide.load.a.o.a<?> r7, Object r8) {
        h r0 = this.f816a.c();
        if (r8 != null) goto L5;
    L7:
        this.f817b.a(r7.f622a, r8, r7.c, r7.c.d(), this.g);
        return;
    L5:
        if (r0.a(r7.c.d()) == false) goto L7;
        this.e = r8;
        this.f817b.c();
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c r2, Exception r3, com.bumptech.glide.load.data.d<?> r4, DataSource r5) {
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.data.d<?> r7 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        this.f817b.a(r6, r3, r7, this.f.c.d());
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void a(com.bumptech.glide.load.c r8, Object r9, com.bumptech.glide.load.data.d<?> r10, DataSource r11, com.bumptech.glide.load.c r12) {
        com.bumptech.glide.load.c r6 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.data.d<?> r4 = (com.bumptech.glide.load.data.d) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r13 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        this.f817b.a(r6, r9, r4, this.f.c.d(), r6);
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        if (this.e == null) goto L13;
        Object r0 = this.e;
        this.e = null;
        if (a(r0) == true) goto L13;
        return true;
    L8:
        e = move-exception;
        if (Log.isLoggable("SourceGenerator", 3) == false) goto L13;
        Log.d("SourceGenerator", "Failed to properly rewind or write data to cache", e);
    L13:
        if (this.d != null) goto L15;
    L17:
        this.d = null;
        this.f = null;
        boolean r1 = false;
    L18:
        if (r1 == true) goto L28;
        if (d() == false) goto L28;
        List<com.bumptech.glide.load.a.o.a<?>> r2 = this.f816a.n();
        int r3 = this.c;
        this.c = r3 + 1;
        this.f = (com.bumptech.glide.load.a.o.a) ZeusTransformUtils.preCheckCast(r2.get(r3), com.bumptech.glide.load.a.o.a.class, "com.obric.memorydata.plugin");
        if (this.f == null) goto L18;
        if (this.f816a.c().a(this.f.c.d()) == true) goto L27;
        if (this.f816a.a(this.f.c.a()) == false) goto L18;
    L27:
        b(this.f);
        r1 = true;
    L28:
        return r1;
    L15:
        if (this.d.a() == false) goto L17;
        return true;
    }

    boolean a(com.bumptech.glide.load.a.o.a<?> r1) {
        com.bumptech.glide.load.a.o.a<?> r0 = this.f;
        if (r0 == null) goto L6;
        if (r0 != r1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.bumptech.glide.load.engine.e
    public void b() {
        com.bumptech.glide.load.a.o.a<?> r0 = this.f;
        if (r0 == null) goto L6;
        r0.c.c();
        return;
    }

    @Override // com.bumptech.glide.load.engine.e.a
    public void c() {
        throw new UnsupportedOperationException();
    }
}
