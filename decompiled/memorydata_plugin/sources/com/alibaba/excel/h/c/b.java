package com.alibaba.excel.h.c;

/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f198b;

    public b() {
    }

    public b(Integer r1, String r2) {
        this.f197a = r1;
        this.f198b = r2;
    }

    public void a(b r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        a(r2.i());
        c(r2.j());
        a(r2.a());
        a(r2.b());
        b(r2.c());
        a(r2.d());
        b(r2.e());
    }

    public void a(String r1) {
        this.f198b = r1;
    }

    public void b(Integer r1) {
        this.f197a = r1;
    }

    public Integer k() {
        return this.f197a;
    }

    public String l() {
        return this.f198b;
    }

    public String toString() {
        return "ReadSheet{sheetNo=" + this.f197a + ", sheetName='" + this.f198b + "'} " + super.toString();
    }
}
