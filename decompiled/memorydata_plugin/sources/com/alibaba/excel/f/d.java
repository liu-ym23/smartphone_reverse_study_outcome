package com.alibaba.excel.f;

import com.alibaba.excel.i.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<c.a, b<?>> f155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<c.a, b<?>> f156b;

    static {
        d();
        c();
    }

    public static Map<c.a, b<?>> a() {
        return b();
    }

    private static void a(b<?> r2) {
        b<?> r3 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.memorydata.plugin");
        f155a.put(c.a(r3.a()), r3);
    }

    public static Map<c.a, b<?>> b() {
        return f156b;
    }

    private static void b(b<?> r3) {
        b<?> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        f155a.put(c.a(r4.a(), r4.b()), r4);
    }

    private static void c() {
        f156b = j.a(40);
        c(new com.alibaba.excel.f.a.a());
        c(new com.alibaba.excel.f.a.b());
        c(new com.alibaba.excel.f.a.c());
        c(new com.alibaba.excel.f.b.a());
        c(new com.alibaba.excel.f.b.b());
        c(new com.alibaba.excel.f.b.c());
        c(new com.alibaba.excel.f.c.a());
        c(new com.alibaba.excel.f.c.b());
        c(new com.alibaba.excel.f.c.c());
        c(new com.alibaba.excel.f.e.a());
        c(new com.alibaba.excel.f.e.b());
        c(new com.alibaba.excel.f.e.c());
        c(new com.alibaba.excel.f.f.b());
        c(new com.alibaba.excel.f.f.c());
        c(new com.alibaba.excel.f.l.b());
        c(new com.alibaba.excel.f.l.c());
        c(new com.alibaba.excel.f.m.b());
        c(new com.alibaba.excel.f.m.c());
        c(new com.alibaba.excel.f.g.a());
        c(new com.alibaba.excel.f.g.b());
        c(new com.alibaba.excel.f.g.c());
        c(new com.alibaba.excel.f.i.a());
        c(new com.alibaba.excel.f.i.b());
        c(new com.alibaba.excel.f.i.c());
        c(new com.alibaba.excel.f.k.a());
        c(new com.alibaba.excel.f.k.b());
        c(new com.alibaba.excel.f.k.c());
        c(new com.alibaba.excel.f.n.a());
        c(new com.alibaba.excel.f.n.b());
        c(new com.alibaba.excel.f.n.c());
        c(new com.alibaba.excel.f.o.a());
        c(new com.alibaba.excel.f.o.b());
        c(new com.alibaba.excel.f.o.c());
        c(new com.alibaba.excel.f.p.a());
        c(new com.alibaba.excel.f.p.c());
        c(new com.alibaba.excel.f.p.d());
        c(new com.alibaba.excel.f.p.b());
    }

    private static void c(b<?> r3) {
        b<?> r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        f156b.put(c.a(r4.a(), r4.b()), r4);
    }

    private static void d() {
        f155a = j.a(40);
        a(new com.alibaba.excel.f.a.b());
        a(new com.alibaba.excel.f.b.b());
        a(new com.alibaba.excel.f.c.a());
        a(new com.alibaba.excel.f.e.b());
        a(new com.alibaba.excel.f.f.a());
        a(new com.alibaba.excel.f.m.a());
        a(new com.alibaba.excel.f.l.a());
        a(new com.alibaba.excel.f.g.b());
        a(new com.alibaba.excel.f.i.b());
        a(new com.alibaba.excel.f.k.b());
        a(new com.alibaba.excel.f.n.b());
        a(new com.alibaba.excel.f.o.b());
        a(new com.alibaba.excel.f.p.d());
        a(new com.alibaba.excel.f.h.a());
        a(new com.alibaba.excel.f.j.a());
        a(new com.alibaba.excel.f.d.b());
        a(new com.alibaba.excel.f.d.a());
        a(new com.alibaba.excel.f.q.a());
        b(new com.alibaba.excel.f.a.c());
        b(new com.alibaba.excel.f.b.c());
        b(new com.alibaba.excel.f.c.c());
        b(new com.alibaba.excel.f.e.c());
        b(new com.alibaba.excel.f.f.c());
        b(new com.alibaba.excel.f.l.c());
        b(new com.alibaba.excel.f.m.c());
        b(new com.alibaba.excel.f.g.c());
        b(new com.alibaba.excel.f.i.c());
        b(new com.alibaba.excel.f.k.c());
        b(new com.alibaba.excel.f.n.c());
        b(new com.alibaba.excel.f.o.c());
        b(new com.alibaba.excel.f.p.d());
    }
}
