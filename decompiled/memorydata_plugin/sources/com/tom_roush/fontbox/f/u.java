package com.tom_roush.fontbox.f;

import android.util.Log;
import java.io.EOFException;

/* JADX INFO: loaded from: classes6.dex */
public class u extends af {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private long G;
    private long H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private int f16019J;
    private int K;
    private int L;
    private int M;
    private int c;
    private short d;
    private int e;
    private int f;
    private short g;
    private short h;
    private short i;
    private short j;
    private short k;
    private short l;
    private short m;
    private short n;
    private short o;
    private short p;
    private short q;
    private int r;
    private byte[] s;
    private long t;
    private long u;
    private long v;
    private long w;
    private String x;
    private int y;
    private int z;

    u(ah r3) {
        super(r3);
        this.s = new byte[10];
        this.x = "XXXX";
        this.G = 0;
        this.H = 0;
    }

    public long a() {
        return this.G;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r4, ad r5) {
        this.c = r5.d();
        this.d = r5.e();
        this.e = r5.d();
        this.f = r5.d();
        this.g = r5.e();
        this.h = r5.e();
        this.i = r5.e();
        this.j = r5.e();
        this.k = r5.e();
        this.l = r5.e();
        this.m = r5.e();
        this.n = r5.e();
        this.o = r5.e();
        this.p = r5.e();
        this.q = r5.e();
        this.r = r5.e();
        this.s = r5.d(10);
        this.t = r5.k();
        this.u = r5.k();
        this.v = r5.k();
        this.w = r5.k();
        this.x = r5.a(4);
        this.y = r5.d();
        this.z = r5.d();
        this.A = r5.d();
        this.B = r5.e();     // Catch: EOFException -> L21
        this.C = r5.e();     // Catch: EOFException -> L21
        this.D = r5.e();     // Catch: EOFException -> L21
        this.E = r5.d();     // Catch: EOFException -> L21
        this.F = r5.d();     // Catch: EOFException -> L21
        if (this.c < 1) goto L14;
        this.G = r5.k();     // Catch: EOFException -> L8
        this.H = r5.k();     // Catch: EOFException -> L8
    L8:
        e = e;
        this.c = 0;
        String r1 = "Could not read all expected parts of version >= 1, setting version to 0";
    L10:
        Log.w("PdfBox-Android", r1, e);
    L11:
        this.f15974a = true;
        return;
    L14:
        if (this.c >= 2) goto L24;
    L19:
        this.f15974a = true;
        return;
    L24:
        this.I = r5.e();     // Catch: EOFException -> L17
        this.f16019J = r5.e();     // Catch: EOFException -> L17
        this.K = r5.d();     // Catch: EOFException -> L17
        this.L = r5.d();     // Catch: EOFException -> L17
        this.M = r5.d();     // Catch: EOFException -> L17
    L17:
        e = e;
        this.c = 1;
        r1 = "Could not read all expected parts of version >= 2, setting version to 1";
    L21:
        Log.d("PdfBox-Android", "EOF, probably some legacy TrueType font");
        goto L11
    }

    public long b() {
        return this.H;
    }

    public int c() {
        return this.r;
    }

    public byte[] d() {
        return this.s;
    }

    public int e() {
        return this.e;
    }
}
