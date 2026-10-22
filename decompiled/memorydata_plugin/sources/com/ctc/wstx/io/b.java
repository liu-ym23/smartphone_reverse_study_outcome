package com.ctc.wstx.io;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    r f3525b;
    protected char[] c;
    protected int d;
    long e;
    int f;
    int g;
    int h;
    transient WstxInputLocation i;

    public b(v r1, String r2, String r3, r r4) {
        super(r1, r2);
        this.e = 0;
        this.f = 1;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.f3525b = r4;
        this.f3524a = r3;
    }

    @Override // com.ctc.wstx.io.v
    public final WstxInputLocation a(long r10, int r12, int r13) {
        if (this.t != null) goto L7;
        WstxInputLocation r0 = null;
    L5:
        WstxInputLocation r2 = r0;
        return new WstxInputLocation(r2, b(), c(), r10, r12, r13);
    L7:
        if (this.i != null) goto L9;
        this.i = this.t.d();
    L9:
        r0 = this.t.d();
        goto L5
    }

    @Override // com.ctc.wstx.io.v
    public URL a() {
        r r0 = this.f3525b;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }

    @Override // com.ctc.wstx.io.v
    public void a(u r3) {
        this.h = r3.f3547J;
        this.e = r3.L;
        this.f = r3.M;
        this.g = r3.N;
    }

    public String b() {
        return this.f3524a;
    }

    @Override // com.ctc.wstx.io.v
    public void b(u r3) {
        r3.I = this.c;
        r3.K = this.d;
        r3.f3547J = this.h;
        r3.L = this.e;
        r3.M = this.f;
        r3.N = this.g;
    }

    @Override // com.ctc.wstx.io.v
    public String c() {
        r r0 = this.f3525b;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    @Override // com.ctc.wstx.io.v
    public final WstxInputLocation d() {
        long r0 = this.e;
        int r2 = this.h;
        return a((r0 + ((long) r2)) - 1, this.f, (r2 - this.g) + 1);
    }
}
