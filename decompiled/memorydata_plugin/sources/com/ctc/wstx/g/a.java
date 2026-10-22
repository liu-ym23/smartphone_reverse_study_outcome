package com.ctc.wstx.g;

import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f3508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f3509b;
    protected String c;
    protected int d;
    protected String e;

    public a(String r1, String r2, int r3) {
        this.f3508a = r2;
        this.f3509b = r1;
        this.d = r3;
    }

    public String a(String r2, int r3) {
        if (this.e != null) goto L6;
        this.e = r2.substring(this.d, r3);
    L6:
        return this.e;
    }

    public QName a() {
        String r0 = this.f3509b;
        if (r0 == null) goto L5;
        String r1 = this.c;
        if (r1 != null) goto L14;
        r1 = "";
    L14:
        return com.ctc.wstx.c.a.a(r1, this.f3508a, r0);
    L5:
        if (this.c != null) goto L9;
        return new QName(this.f3508a);
    L9:
        return new QName(this.c, this.f3508a);
    }

    public void a(String r1) {
        this.e = r1;
    }

    public void a(String r1, String r2, int r3) {
        this.f3508a = r2;
        this.f3509b = r1;
        this.d = r3;
        this.c = null;
        this.e = null;
    }

    public String b(String r2) {
        if (this.e != null) goto L10;
        int r0 = this.d;
        if (r0 == 0) goto L8;
        r2 = r2.substring(r0);
    L8:
        this.e = r2;
    L10:
        return this.e;
    }
}
