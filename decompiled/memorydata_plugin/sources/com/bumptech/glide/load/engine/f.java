package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class f<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.load.a.o.a<?>> f775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f776b;
    private com.bumptech.glide.e c;
    private Object d;
    private int e;
    private int f;
    private Class<?> g;
    private DecodeJob.d h;
    private com.bumptech.glide.load.e i;
    private Map<Class<?>, com.bumptech.glide.load.h<?>> j;
    private Class<Transcode> k;
    private boolean l;
    private boolean m;
    private com.bumptech.glide.load.c n;
    private Priority o;
    private h p;
    private boolean q;
    private boolean r;

    f() {
        this.f775a = new ArrayList();
        this.f776b = new ArrayList();
    }

    <T> com.bumptech.glide.load.data.e<T> a(T r1) {
        return this.c.d().b(r1);
    }

    List<com.bumptech.glide.load.a.o<File, ?>> a(File r1) {
        return this.c.d().c(r1);
    }

    void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f775a.clear();
        this.l = false;
        this.f776b.clear();
        this.m = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <R> void a(com.bumptech.glide.e r8, Object r9, com.bumptech.glide.load.c r10, int r11, int r12, h r13, Class<?> r14, Class<R> r15, Priority r16, com.bumptech.glide.load.e r17, Map<Class<?>, com.bumptech.glide.load.h<?>> r18, boolean r19, boolean r20, DecodeJob.d r21) {
        com.bumptech.glide.e r1 = (com.bumptech.glide.e) ZeusTransformUtils.wrapperContextForParams(r8, com.bumptech.glide.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.c r3 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r10, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        Map<Class<?>, com.bumptech.glide.load.h<?>> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.memorydata.plugin");
        DecodeJob.d r2 = (DecodeJob.d) ZeusTransformUtils.wrapperContextForParams(r21, DecodeJob.d.class, "com.obric.memorydata.plugin");
        this.c = r1;
        this.d = r9;
        this.n = r3;
        this.e = r11;
        this.f = r12;
        this.p = r13;
        this.g = r14;
        this.h = r2;
        this.k = r15;
        this.o = r16;
        this.i = r17;
        this.j = r4;
        this.q = r19;
        this.r = r20;
    }

    boolean a(com.bumptech.glide.load.c r7) {
        com.bumptech.glide.load.c r8 = (com.bumptech.glide.load.c) ZeusTransformUtils.wrapperContextForParams(r7, com.bumptech.glide.load.c.class, "com.obric.memorydata.plugin");
        List<com.bumptech.glide.load.a.o.a<?>> r6 = n();
        int r0 = r6.size();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        if (((com.bumptech.glide.load.a.o.a) ZeusTransformUtils.preCheckCast(r6.get(r3), com.bumptech.glide.load.a.o.a.class, "com.obric.memorydata.plugin")).f622a.equals(r8) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    boolean a(s<?> r3) {
        s<?> r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        return this.c.d().a(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean a(Class<?> r1) {
        if (b(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    <X> com.bumptech.glide.load.a<X> b(X r1) {
        return this.c.d().a(r1);
    }

    com.bumptech.glide.load.engine.a.a b() {
        return this.h.a();
    }

    <Data> q<Data, ?, Transcode> b(Class<Data> r3) {
        return this.c.d().a(r3, this.g, this.k);
    }

    <Z> com.bumptech.glide.load.g<Z> b(s<Z> r3) {
        s r4 = (s) ZeusTransformUtils.wrapperContextForParams(r3, s.class, "com.obric.memorydata.plugin");
        return this.c.d().b(r4);
    }

    h c() {
        return this.p;
    }

    <Z> com.bumptech.glide.load.h<Z> c(Class<Z> r7) {
        com.bumptech.glide.load.h<Z> r0 = (com.bumptech.glide.load.h) ZeusTransformUtils.preCheckCast(this.j.get(r7), com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        Iterator<Map.Entry<Class<?>, com.bumptech.glide.load.h<?>>> r1 = this.j.entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Class) ZeusTransformUtils.preCheckCast(r3.getKey(), Class.class, "com.obric.memorydata.plugin")).isAssignableFrom(r7) == false) goto L6;
        r0 = (com.bumptech.glide.load.h) ZeusTransformUtils.preCheckCast(r3.getValue(), com.bumptech.glide.load.h.class, "com.obric.memorydata.plugin");
    L10:
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (this.j.isEmpty() == false) goto L19;
        if (this.q == false) goto L19;
        throw new IllegalArgumentException("Missing transformation for " + r7 + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    L19:
        return com.bumptech.glide.load.resource.c.a();
    }

    Priority d() {
        return this.o;
    }

    com.bumptech.glide.load.e e() {
        return this.i;
    }

    com.bumptech.glide.load.c f() {
        return this.n;
    }

    int g() {
        return this.e;
    }

    int h() {
        return this.f;
    }

    com.bumptech.glide.load.engine.bitmap_recycle.b i() {
        return this.c.f();
    }

    Class<?> j() {
        return this.k;
    }

    Class<?> k() {
        return this.d.getClass();
    }

    List<Class<?>> l() {
        return this.c.d().b(this.d.getClass(), this.g, this.k);
    }

    boolean m() {
        return this.r;
    }

    List<com.bumptech.glide.load.a.o.a<?>> n() {
        if (this.l == true) goto L11;
        this.l = true;
        this.f775a.clear();
        List r0 = this.c.d().c(this.d);
        int r1 = 0;
        int r2 = r0.size();
    L5:
        if (r1 >= r2) goto L11;
        com.bumptech.glide.load.a.o.a<?> r3 = ((com.bumptech.glide.load.a.o) ZeusTransformUtils.preCheckCast(r0.get(r1), com.bumptech.glide.load.a.o.class, "com.obric.memorydata.plugin")).a(this.d, this.e, this.f, this.i);
        if (r3 == null) goto L9;
        this.f775a.add(r3);
    L9:
        r1 = r1 + 1;
    L11:
        return this.f775a;
    }

    List<com.bumptech.glide.load.c> o() {
        if (this.m == true) goto L18;
        this.m = true;
        this.f776b.clear();
        List<com.bumptech.glide.load.a.o.a<?>> r0 = n();
        int r1 = r0.size();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L18;
        com.bumptech.glide.load.a.o.a r4 = (com.bumptech.glide.load.a.o.a) ZeusTransformUtils.preCheckCast(r0.get(r3), com.bumptech.glide.load.a.o.a.class, "com.obric.memorydata.plugin");
        if (this.f776b.contains(r4.f622a) == true) goto L9;
        this.f776b.add(r4.f622a);
    L9:
        int r5 = 0;
    L11:
        if (r5 >= r4.f623b.size()) goto L16;
        if (this.f776b.contains(r4.f623b.get(r5)) == true) goto L15;
        this.f776b.add(r4.f623b.get(r5));
    L15:
        r5 = r5 + 1;
        goto L11
    L16:
        r3 = r3 + 1;
    L18:
        return this.f776b;
    }
}
