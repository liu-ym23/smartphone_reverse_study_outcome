package com.tom_roush.pdfbox.pdmodel.font;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f16224b;
    private final int c;

    public b(String r1, String r2, int r3) {
        this.f16223a = r1;
        this.f16224b = r2;
        this.c = r3;
    }

    public String a() {
        return this.f16223a;
    }

    public String b() {
        return this.f16224b;
    }

    public int c() {
        return this.c;
    }

    public String toString() {
        return a() + "-" + b() + "-" + c();
    }
}
