package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5422b;
    public long c;
    public double d;
    public double e;
    public double f;
    public float g;
    public float h;
    public float i;
    public boolean j;

    public cz(String r3) {
        this.f5422b = 0;
        this.c = 0;
        this.d = 0.0d;
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.f5421a = r3;
    }

    public final double a(cz r9) {
        if (r9 != null) goto L4;
        return 0.0d;
    L4:
        return dk.a(this.e, this.d, r9.e, r9.d);
    }
}
