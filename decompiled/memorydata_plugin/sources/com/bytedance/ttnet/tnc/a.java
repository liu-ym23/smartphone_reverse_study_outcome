package com.bytedance.ttnet.tnc;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3321b;
    public Map<String, Integer> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public String l;
    public int m;
    public long n;

    public a() {
        this.f3320a = false;
        this.f3321b = true;
        this.c = null;
        this.d = 10;
        this.e = 3;
        this.f = 3;
        this.g = 10;
        this.h = 3;
        this.i = 3;
        this.j = 900;
        this.k = 120;
        this.l = null;
        this.m = 0;
        this.n = 0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(" localEnable: ").append(this.f3320a);
        r0.append(" probeEnable: ").append(this.f3321b);
        StringBuilder r1 = r0.append(" hostFilter: ");
        Map<String, Integer> r2 = this.c;
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r0.append(" reqTo: ").append(this.d).append("#").append(this.e).append("#").append(this.f);
        r0.append(" reqErr: ").append(this.g).append("#").append(this.h).append("#").append(this.i);
        r0.append(" updateInterval: ").append(this.j);
        r0.append(" updateRandom: ").append(this.k);
        r0.append(" httpBlack: ").append(this.l);
        return r0.toString();
    L5:
        r3 = 0;
        goto L6
    }
}
