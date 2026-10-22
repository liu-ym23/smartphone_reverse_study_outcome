package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e extends ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final j<?, ?> f547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f548b;
    private final com.bumptech.glide.util.e.a<Registry> c;
    private final com.bumptech.glide.request.a.c d;
    private final c.a e;
    private final List<com.bumptech.glide.request.e<Object>> f;
    private final Map<Class<?>, j<?, ?>> g;
    private final com.bumptech.glide.load.engine.i h;
    private final f i;
    private final int j;
    private com.bumptech.glide.request.f k;

    static {
        f547a = new b();
    }

    public e(Context r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4, com.bumptech.glide.util.e.a<Registry> r5, com.bumptech.glide.request.a.c r6, c.a r7, Map<Class<?>, j<?, ?>> r8, List<com.bumptech.glide.request.e<Object>> r9, com.bumptech.glide.load.engine.i r10, f r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r14 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.util.e.a r15 = (com.bumptech.glide.util.e.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.util.e.a.class, "com.obric.memorydata.plugin");
        c.a r16 = (c.a) ZeusTransformUtils.wrapperContextForParams(r7, c.a.class, "com.obric.memorydata.plugin");
        Map<Class<?>, j<?, ?>> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        List<com.bumptech.glide.request.e<Object>> r18 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r13.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.f548b = r14;
        this.d = r6;
        this.e = r16;
        this.f = r18;
        this.g = r17;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.c = com.bumptech.glide.util.e.a(r15);
    }

    public <T> j<?, T> a(Class<T> r6) {
        j<?, T> r0 = (j) ZeusTransformUtils.preCheckCast(this.g.get(r6), j.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, j<?, ?>>> r5 = this.g.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Class) ZeusTransformUtils.preCheckCast(r1.getKey(), Class.class, "com.obric.memorydata.plugin")).isAssignableFrom(r6) == false) goto L6;
        r0 = (j) ZeusTransformUtils.preCheckCast(r1.getValue(), j.class, "com.obric.memorydata.plugin");
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        return (j<?, T>) f547a;
    }

    public List<com.bumptech.glide.request.e<Object>> a() {
        return this.f;
    }

    public synchronized com.bumptech.glide.request.f b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.k != null) goto L6;
        this.k = (com.bumptech.glide.request.f) ZeusTransformUtils.preCheckCast(this.e.a().c(), com.bumptech.glide.request.f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L6:
        com.bumptech.glide.request.f r0 = this.k;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public com.bumptech.glide.load.engine.i c() {
        return this.h;
    }

    public Registry d() {
        return (Registry) ZeusTransformUtils.preCheckCast(this.c.b(), Registry.class, "com.obric.memorydata.plugin");
    }

    public int e() {
        return this.j;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.b f() {
        return this.f548b;
    }

    public f g() {
        return this.i;
    }
}
