package com.alibaba.excel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import org.slf4j.d;

/* JADX INFO: loaded from: classes.dex */
public class c implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f137a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.alibaba.excel.a.a f138b;

    static {
        f137a = d.a(c.class);
    }

    public c(com.alibaba.excel.h.c.c r2) {
        this.f138b = new com.alibaba.excel.a.b(r2);
    }

    public c a(List<com.alibaba.excel.h.c.b> r3) {
        List<com.alibaba.excel.h.c.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.f138b.a(r4, Boolean.FALSE);
        return this;
    }

    public c a(com.alibaba.excel.h.c.b... r1) {
        return a(Arrays.asList(r1));
    }

    public void a() {
        this.f138b.a(null, Boolean.TRUE);
    }

    public void b() {
        com.alibaba.excel.a.a r0 = this.f138b;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b();
    }

    public void finalize() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        f137a.warn("Destroy object failed", th);
    }
}
