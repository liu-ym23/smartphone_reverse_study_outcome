package com.alibaba.excel.h.a;

import com.alibaba.excel.exception.ExcelGenerateException;
import com.alibaba.excel.metadata.d;

/* JADX INFO: loaded from: classes.dex */
public class c extends a<c, com.alibaba.excel.h.c.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.c f174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.alibaba.excel.h.c.b f175b;

    public c() {
        this.f175b = new com.alibaba.excel.h.c.b();
    }

    public c(com.alibaba.excel.c r2) {
        this.f175b = new com.alibaba.excel.h.c.b();
        this.f174a = r2;
    }

    public c a(Integer r2) {
        this.f175b.b(r2);
        return this;
    }

    public c a(String r2) {
        this.f175b.a(r2);
        return this;
    }

    @Override // com.alibaba.excel.metadata.c
    public /* synthetic */ d b() {
        return e();
    }

    public com.alibaba.excel.h.c.b c() {
        return this.f175b;
    }

    public void d() {
        com.alibaba.excel.c r0 = this.f174a;
        if (r0 == null) goto L7;
        r0.a(new com.alibaba.excel.h.c.b[]{c()});
        this.f174a.b();
        return;
    L7:
        throw new ExcelGenerateException("Must use 'EasyExcelFactory.read().sheet()' to call this method");
    }

    public com.alibaba.excel.h.c.b e() {
        return this.f175b;
    }
}
