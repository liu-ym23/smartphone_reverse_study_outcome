package com.alibaba.excel.support.cglib.core;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.support.asm.q f382b;
    private com.alibaba.excel.support.asm.q c;

    public c(g r1) {
        this.f381a = r1;
        this.f382b = r1.H();
    }

    public void a() {
        if (this.c != null) goto L7;
        this.c = this.f381a.H();
        return;
    L7:
        throw new IllegalStateException("end of label already set");
    }

    public com.alibaba.excel.support.asm.q b() {
        return this.f382b;
    }

    public com.alibaba.excel.support.asm.q c() {
        return this.c;
    }
}
