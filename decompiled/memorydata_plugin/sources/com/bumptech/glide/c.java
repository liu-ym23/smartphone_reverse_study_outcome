package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f527b;
    private final com.bumptech.glide.load.engine.i c;
    private final com.bumptech.glide.load.engine.bitmap_recycle.e d;
    private final com.bumptech.glide.load.engine.a.h e;
    private final e f;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b g;
    private final n h;
    private final com.bumptech.glide.manager.c i;
    private final List<i> j;
    private final a k;
    private MemoryCategory l;

    public interface a {
        com.bumptech.glide.request.f a();
    }

    c(Context r15, com.bumptech.glide.load.engine.i r16, com.bumptech.glide.load.engine.a.h r17, com.bumptech.glide.load.engine.bitmap_recycle.e r18, com.bumptech.glide.load.engine.bitmap_recycle.b r19, n r20, com.bumptech.glide.manager.c r21, int r22, a r23, Map<Class<?>, j<?, ?>> r24, List<com.bumptech.glide.request.e<Object>> r25, List<com.bumptech.glide.c.c> r26, com.bumptech.glide.c.a r27, f r28) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.a.h r1 = (com.bumptech.glide.load.engine.a.h) ZeusTransformUtils.wrapperContextForParams(r17, com.bumptech.glide.load.engine.a.h.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r3 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r18, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r5 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r19, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.manager.c r6 = (com.bumptech.glide.manager.c) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.manager.c.class, "com.obric.memorydata.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r23, a.class, "com.obric.memorydata.plugin");
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r24, Map.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        this.j = new ArrayList();
        this.l = MemoryCategory.NORMAL;
        this.c = r16;
        this.d = r3;
        this.g = r5;
        this.e = r1;
        this.h = r20;
        this.i = r6;
        this.k = r8;
        this.f = new e(r4, r5, g.a(this, r2, r27), new com.bumptech.glide.request.a.c(), r8, r9, r10, r16, r28, r22);
    }

    public static c a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (f526a != null) goto L15;
        GeneratedAppGlideModule r0 = c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f526a != null) goto L9;
        a(r4, r0);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f526a;
    }

    public static i a(View r3) {
        return d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a(r3);
    }

    static void a(Context r2, GeneratedAppGlideModule r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f527b == true) goto L12;
        f527b = true;
        b(r4, r3);     // Catch: Throwable -> L8
        f527b = false;
        return;
    L8:
        th = move-exception;
        f527b = false;
        throw th;
    L12:
        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
    }

    private static void a(Context r9, d r10, GeneratedAppGlideModule r11) {
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        List<com.bumptech.glide.c.c> r0 = Collections.emptyList();
        if (r11 != null) goto L5;
    L6:
        r0 = new com.bumptech.glide.c.e(r12).a();
    L8:
        if (r11 == null) goto L22;
        if (r11.a().isEmpty() == true) goto L22;
        Set<Class<?>> r4 = r11.a();
        Iterator<com.bumptech.glide.c.c> r5 = r0.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        com.bumptech.glide.c.c r6 = (com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r5.next(), com.bumptech.glide.c.c.class, "com.obric.memorydata.plugin");
        if (r4.contains(r6.getClass()) == false) goto L13;
        if (Log.isLoggable("Glide", 3) == false) goto L20;
        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + r6);
    L20:
        r5.remove();
    L22:
        if (Log.isLoggable("Glide", 3) == false) goto L27;
        Iterator<com.bumptech.glide.c.c> r2 = r0.iterator();
    L25:
        if (r2.hasNext() == false) goto L27;
        Log.d("Glide", "Discovered GlideModule from manifest: " + ((com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r2.next(), com.bumptech.glide.c.c.class, "com.obric.memorydata.plugin")).getClass());
    L27:
        if (r11 == null) goto L29;
        n.a r3 = r11.b();
    L30:
        r10.a(r3);
        Iterator<com.bumptech.glide.c.c> r7 = r0.iterator();
    L32:
        if (r7.hasNext() == false) goto L34;
        ((com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r7.next(), com.bumptech.glide.c.c.class, "com.obric.memorydata.plugin")).a(r12, r10);
        goto L32
    L34:
        if (r11 == null) goto L36;
        r11.a(r12, r10);
    L36:
        c r13 = r10.a(r12, r0, r11);
        r12.registerComponentCallbacks(r13);
        f526a = r13;
        return;
    L29:
        r3 = null;
        goto L30
    L5:
        if (r11.c() == false) goto L8;
        goto L6
    }

    private static void a(Exception r2) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", r2);
    }

    public static i b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        return d(r3).a(r3);
    }

    private static void b(Context r2, GeneratedAppGlideModule r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), new d(), r3);
    }

    private static GeneratedAppGlideModule c(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        goto L8
    L14:
        return (GeneratedAppGlideModule) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), GeneratedAppGlideModule.class, "com.obric.memorydata.plugin");
    L5:
        e = move-exception;
        a(e);
    L10:
        return null;
    L8:
        if (Log.isLoggable("Glide", 5) == false) goto L10;
        Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
        goto L10
    }

    private static n d(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.j.a(r3, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(r3).f();
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.e a() {
        return this.d;
    }

    public void a(int r6) {
        k.a();
        List<i> r0 = this.j;
        monitor-enter(r0);
        Iterator<i> r1 = this.j.iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L8;
        ((i) ZeusTransformUtils.preCheckCast(r1.next(), i.class, "com.obric.memorydata.plugin")).onTrimMemory(r6);     // Catch: Throwable -> L11
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.e.a(r6);
        this.d.a(r6);
        this.g.a(r6);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void a(i r3) {
        List<i> r0 = this.j;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.j.contains(r3) == true) goto L10;
        this.j.add(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot register already registered manager");     // Catch: Throwable -> L11
    }

    boolean a(com.bumptech.glide.request.a.e<?> r5) {
        com.bumptech.glide.request.a.e<?> r6 = (com.bumptech.glide.request.a.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.request.a.e.class, "com.obric.memorydata.plugin");
        List<i> r0 = this.j;
        monitor-enter(r0);
        Iterator<i> r4 = this.j.iterator();     // Catch: Throwable -> L15
    L6:
        if (r4.hasNext() == false) goto L12;
        if (((i) ZeusTransformUtils.preCheckCast(r4.next(), i.class, "com.obric.memorydata.plugin")).b(r6) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b b() {
        return this.g;
    }

    void b(i r3) {
        List<i> r0 = this.j;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.j.contains(r3) == false) goto L10;
        this.j.remove(r3);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("Cannot unregister not yet registered manager");     // Catch: Throwable -> L11
    }

    com.bumptech.glide.manager.c c() {
        return this.i;
    }

    e d() {
        return this.f;
    }

    public void e() {
        k.a();
        this.e.a();
        this.d.a();
        this.g.a();
    }

    public n f() {
        return this.h;
    }

    public Registry g() {
        return this.f.d();
    }

    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        e();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r1) {
        a(r1);
    }
}
