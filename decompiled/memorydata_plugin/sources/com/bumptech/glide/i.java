package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.k;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.manager.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class i implements ComponentCallbacks2, k {
    private static final com.bumptech.glide.request.f d = null;
    private static final com.bumptech.glide.request.f e = null;
    private static final com.bumptech.glide.request.f f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f562b;
    final com.bumptech.glide.manager.j c;
    private final p g;
    private final o h;
    private final r i;
    private final Runnable j;
    private final com.bumptech.glide.manager.b k;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.e<Object>> l;
    private com.bumptech.glide.request.f m;
    private boolean n;
    private boolean o;

    private static class a extends com.bumptech.glide.request.a.b<View, Object> {
        a(View r1) {
            super(r1);
        }

        @Override // com.bumptech.glide.request.a.b
        public void a(Drawable r1) {
        }

        @Override // com.bumptech.glide.request.a.e
        public void a(Object r1, com.bumptech.glide.request.b.b<? super Object> r2) {
            com.bumptech.glide.request.b.b r0 = (com.bumptech.glide.request.b.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.request.b.b.class, "com.obric.memorydata.plugin");
        }

        @Override // com.bumptech.glide.request.a.e
        public void b(Drawable r1) {
        }
    }

    private class b implements com.bumptech.glide.manager.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final p f565b;

        b(i r1, p r2) {
            this.f564a = r1;
            this.f565b = r2;
        }

        @Override // com.bumptech.glide.manager.b.a
        public void a(boolean r1) {
            if (r1 == false) goto L11;
            i r2 = this.f564a;
            monitor-enter(r2);
            this.f565b.e();     // Catch: Throwable -> L8
            monitor-exit(r2);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    static {
        d = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.f.b(Bitmap.class).c(), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");
        e = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.f.b(GifDrawable.class).c(), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");
        f = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(com.bumptech.glide.request.f.b(com.bumptech.glide.load.engine.h.c).a(Priority.LOW), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).b(true), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");
    }

    public i(c r10, com.bumptech.glide.manager.j r11, o r12, Context r13) {
        com.bumptech.glide.manager.j r4 = (com.bumptech.glide.manager.j) ZeusTransformUtils.wrapperContextForParams(r11, com.bumptech.glide.manager.j.class, "com.obric.memorydata.plugin");
        o r5 = (o) ZeusTransformUtils.wrapperContextForParams(r12, o.class, "com.obric.memorydata.plugin");
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.memorydata.plugin");
        this(r10, r4, r5, new p(), r10.c(), r8);
    }

    i(c r3, com.bumptech.glide.manager.j r4, o r5, p r6, com.bumptech.glide.manager.c r7, Context r8) {
        com.bumptech.glide.manager.j r9 = (com.bumptech.glide.manager.j) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.manager.j.class, "com.obric.memorydata.plugin");
        o r10 = (o) ZeusTransformUtils.wrapperContextForParams(r5, o.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.manager.c r11 = (com.bumptech.glide.manager.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.manager.c.class, "com.obric.memorydata.plugin");
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        this.i = new r();
        Runnable r0 = new AnonymousClass1(this);
        this.j = r0;
        this.f561a = r3;
        this.c = r9;
        this.h = r10;
        this.g = r6;
        this.f562b = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        com.bumptech.glide.manager.b r13 = r11.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r12.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new b(this, r6));
        this.k = r13;
        r3.a(this);
        if (com.bumptech.glide.util.k.c() == false) goto L5;
        com.bumptech.glide.util.k.a(r0);
    L6:
        r9.addListener(r13);
        this.l = new CopyOnWriteArrayList(((e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")).a());
        a(((e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")).b());
        return;
    L5:
        r9.addListener(this);
        goto L6
    }

    private void c(com.bumptech.glide.request.a.e<?> r3) {
        com.bumptech.glide.request.a.e<?> r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        boolean r0 = b(r4);
        com.bumptech.glide.request.d r1 = r4.b();
        if (r0 == false) goto L5;
        return;
    L5:
        if (this.f561a.a(r4) == true) goto L10;
        if (r1 == null) goto L11;
        r4.a(null);
        r1.b();
        return;
    L11:
        return;
    }

    private synchronized void k() {
        monitor-enter(this);
        Iterator<com.bumptech.glide.request.a.e<?>> r0 = this.i.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        a((com.bumptech.glide.request.a.e) ZeusTransformUtils.preCheckCast(r0.next(), com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L10
        goto L5
    L7:
        this.i.b();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public <ResourceType> h<ResourceType> a(Class<ResourceType> r4) {
        return new h(this.f561a, this, r4, this.f562b);
    }

    public synchronized void a() {
        monitor-enter(this);
        this.g.a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(View r2) {
        a(new a(r2));
    }

    public void a(com.bumptech.glide.request.a.e<?> r3) {
        com.bumptech.glide.request.a.e<?> r4 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        c(r4);
    }

    synchronized void a(com.bumptech.glide.request.a.e<?> r3, com.bumptech.glide.request.d r4) {
        monitor-enter(this);
        com.bumptech.glide.request.a.e<?> r5 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        com.bumptech.glide.request.d r6 = (com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.i.a(r5);     // Catch: Throwable -> L6
        this.g.a(r6);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(com.bumptech.glide.request.f r3) {
        monitor-enter(this);
        this.m = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(r3.b(), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin")).d(), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    <T> j<?, T> b(Class<T> r3) {
        return ((e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f561a.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")).a(r3);
    }

    public synchronized void b() {
        monitor-enter(this);
        this.g.b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized boolean b(com.bumptech.glide.request.a.e<?> r4) {
        monitor-enter(this);
        com.bumptech.glide.request.a.e<?> r5 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        com.bumptech.glide.request.d r0 = r5.b();     // Catch: Throwable -> L16
        if (r0 != null) goto L9;
        monitor-exit(this);
        return true;
    L9:
        if (this.g.b(r0) == false) goto L14;
        this.i.b(r5);     // Catch: Throwable -> L16
        r5.a(null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized void c() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L10
        Iterator<i> r0 = this.h.a().iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        ((i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.memorydata.plugin")).b();     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void d() {
        monitor-enter(this);
        this.g.c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void e() {
        monitor-enter(this);
        d();     // Catch: Throwable -> L6
        this.i.e();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void f() {
        monitor-enter(this);
        this.i.f();     // Catch: Throwable -> L9
        if (this.o == false) goto L6;
        k();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        a();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.manager.k
    public synchronized void g() {
        monitor-enter(this);
        this.i.g();     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        this.g.d();     // Catch: Throwable -> L6
        this.c.removeListener(this);     // Catch: Throwable -> L6
        this.c.removeListener(this.k);     // Catch: Throwable -> L6
        com.bumptech.glide.util.k.b(this.j);     // Catch: Throwable -> L6
        this.f561a.b(this);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public h<Bitmap> h() {
        return a(Bitmap.class).a(d);
    }

    List<com.bumptech.glide.request.e<Object>> i() {
        return this.l;
    }

    synchronized com.bumptech.glide.request.f j() {
        monitor-enter(this);
        com.bumptech.glide.request.f r0 = this.m;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        if (r2 == 60) goto L5;
        return;
    L5:
        if (this.n == false) goto L9;
        c();
        return;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = super.toString() + "{tracker=" + this.g + ", treeNode=" + this.h + "}";     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
