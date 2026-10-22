package com.alibaba.excel.h.a;

import com.alibaba.excel.metadata.d;
import com.alibaba.excel.support.ExcelTypeEnum;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b extends a<b, com.alibaba.excel.h.c.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.alibaba.excel.h.c.c f173a;

    public b() {
        this.f173a = new com.alibaba.excel.h.c.c();
    }

    public b a(ExcelTypeEnum r2) {
        this.f173a.a(r2);
        return this;
    }

    public b a(InputStream r2) {
        this.f173a.a(r2);
        return this;
    }

    public c a(Integer r2, String r3) {
        c r0 = new c(c());
        if (r2 == null) goto L5;
        r0.a(r2);
    L5:
        if (r3 == null) goto L7;
        r0.a(r3);
    L7:
        return r0;
    }

    @Override // com.alibaba.excel.metadata.c
    public /* synthetic */ d b() {
        return f();
    }

    public com.alibaba.excel.c c() {
        return new com.alibaba.excel.c(this.f173a);
    }

    public void d() {
        com.alibaba.excel.c r2 = c();
        r2.a();     // Catch: Throwable -> L7
        if (r2 == null) goto L22;
        r2.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r2 != null) goto L16;
    L15:
        throw th;
    L16:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public c e() {
        return a(null, null);
    }

    public com.alibaba.excel.h.c.c f() {
        return this.f173a;
    }
}
