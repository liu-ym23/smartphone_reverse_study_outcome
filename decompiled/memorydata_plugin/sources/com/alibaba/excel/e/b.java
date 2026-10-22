package com.alibaba.excel.e;

import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.h.c.a.d;
import com.alibaba.excel.h.c.a.e;
import com.alibaba.excel.support.ExcelTypeEnum;

/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f149a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f150b;
    private d c;
    private com.alibaba.excel.h.c.a.c d;
    private com.alibaba.excel.h.c.a.b e;
    private final com.alibaba.excel.h.d.a f;

    /* JADX INFO: renamed from: com.alibaba.excel.e.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f151a = null;

        static {
            int[] r0 = new int[ExcelTypeEnum.values().length];
            f151a = r0;
            r0[ExcelTypeEnum.XLS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f151a[ExcelTypeEnum.XLSX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f151a[ExcelTypeEnum.CSV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f149a = org.slf4j.d.a(b.class);
    }

    public b(com.alibaba.excel.h.c.c r2, ExcelTypeEnum r3) {
        if (r2 == null) goto L20;
        int r4 = AnonymousClass1.f151a[r3.ordinal()];
        if (r4 != 1) goto L7;
        e r5 = new com.alibaba.excel.h.c.a.b.b(r2);
    L14:
        this.f150b = r5;
    L15:
        this.e = this.f150b;
        this.f = new com.alibaba.excel.h.d.b();
        org.slf4j.c r1 = f149a;
        if (r1.isDebugEnabled() == false) goto L21;
        r1.debug("Initialization 'AnalysisContextImpl' complete");
        return;
    L21:
        return;
    L7:
        if (r4 != 2) goto L9;
        r5 = new com.alibaba.excel.h.c.a.c.b(r2);
        goto L14
    L9:
        if (r4 != 3) goto L15;
        r5 = new com.alibaba.excel.h.c.a.a.b(r2);
        goto L14
    L20:
        throw new IllegalArgumentException("Workbook argument cannot be null");
    }

    @Override // com.alibaba.excel.e.a
    public e a() {
        return this.f150b;
    }

    @Override // com.alibaba.excel.e.a
    public void a(com.alibaba.excel.h.c.a.c r1) {
        this.d = r1;
    }

    @Override // com.alibaba.excel.e.a
    public void a(com.alibaba.excel.h.c.b r3) {
        int r0 = AnonymousClass1.f151a[this.f150b.u().ordinal()];
        if (r0 != 1) goto L5;
        d r1 = new com.alibaba.excel.h.c.a.b.a(r3, this.f150b);
    L12:
        this.c = r1;
    L13:
        this.e = this.c;
        if (this.f150b.F().contains(this.c.p()) == true) goto L20;
        this.f150b.F().add(this.c.p());
        org.slf4j.c r4 = f149a;
        if (r4.isDebugEnabled() == false) goto L21;
        r4.debug("Began to read：{}", this.c);
        return;
    L21:
        return;
    L20:
        throw new ExcelAnalysisException("Cannot read sheet repeatedly.");
    L5:
        if (r0 != 2) goto L7;
        r1 = new com.alibaba.excel.h.c.a.c.a(r3, this.f150b);
        goto L12
    L7:
        if (r0 != 3) goto L13;
        r1 = new com.alibaba.excel.h.c.a.a.a(r3, this.f150b);
        goto L12
    }

    @Override // com.alibaba.excel.e.a
    public d b() {
        return this.c;
    }

    @Override // com.alibaba.excel.e.a
    public com.alibaba.excel.h.c.a.c c() {
        return this.d;
    }

    @Override // com.alibaba.excel.e.a
    public com.alibaba.excel.h.c.a.b d() {
        return this.e;
    }

    @Override // com.alibaba.excel.e.a
    public com.alibaba.excel.h.d.a e() {
        return this.f;
    }
}
