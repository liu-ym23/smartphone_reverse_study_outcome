package com.loc;

import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class dt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5467b;
    public int c;
    public int d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public short m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public long t;

    public dt(int r5, boolean r6) {
        this.f5466a = 0;
        this.f5467b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = 32767;
        this.p = Integer.MAX_VALUE;
        this.q = Integer.MAX_VALUE;
        this.r = true;
        this.s = 99;
        this.t = 0;
        this.l = r5;
        this.n = r6;
    }

    private String e() {
        int r0 = this.l;
        return this.l + "#" + this.f5466a + "#" + this.f5467b + "#0#" + a();
    }

    private String f() {
        return this.l + "#" + this.h + "#" + this.i + "#" + this.j;
    }

    public final long a() {
        if (this.l != 5) goto L7;
        return this.e;
    L7:
        return this.d;
    }

    public final String b() {
        int r0 = this.l;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L17;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L17;
        return null;
    L15:
        return f();
    L17:
        return e();
    }

    public final String c() {
        String r0 = b();
        if (r0 != null) goto L5;
        return "";
    L5:
        if (r0.length() > 0) goto L7;
        return "";
    L7:
        return (this.r ? 1 : 0) + "#" + r0;
    }

    public final /* synthetic */ Object clone() {
        return d();
    }

    public final dt d() {
        dt r0 = new dt(this.l, this.n);
        r0.f5466a = this.f5466a;
        r0.f5467b = this.f5467b;
        r0.c = this.c;
        r0.d = this.d;
        r0.e = this.e;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.k;
        r0.m = this.m;
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        r0.t = this.t;
        return r0;
    }

    public final boolean equals(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, dt.class) == false) goto L72;
        dt r9 = (dt) ZeusTransformUtils.preCheckCast(r8, dt.class, "com.obric.memorydata.plugin");
        int r0 = r9.l;
        if (r0 == 1) goto L63;
        if (r0 == 2) goto L52;
        if (r0 == 3) goto L41;
        if (r0 == 4) goto L30;
        if (r0 == 5) goto L19;
        return false;
    L19:
        if (this.l == 5) goto L22;
        return false;
    L22:
        if (r9.c == this.c) goto L24;
    L28:
        return false;
    L24:
        if (r9.e != this.e) goto L28;
        if (r9.q != this.q) goto L28;
        return true;
    L30:
        if (this.l == 4) goto L33;
        return false;
    L33:
        if (r9.c == this.c) goto L35;
    L39:
        return false;
    L35:
        if (r9.d != this.d) goto L39;
        if (r9.f5467b != this.f5467b) goto L39;
        return true;
    L41:
        if (this.l == 3) goto L44;
        return false;
    L44:
        if (r9.c == this.c) goto L46;
    L50:
        return false;
    L46:
        if (r9.d != this.d) goto L50;
        if (r9.f5467b != this.f5467b) goto L50;
        return true;
    L52:
        if (this.l == 2) goto L55;
        return false;
    L55:
        if (r9.j == this.j) goto L57;
    L61:
        return false;
    L57:
        if (r9.i != this.i) goto L61;
        if (r9.h != this.h) goto L61;
        return true;
    L63:
        if (this.l == 1) goto L66;
        return false;
    L66:
        if (r9.c != this.c) goto L72;
        if (r9.d != this.d) goto L72;
        if (r9.f5467b != this.f5467b) goto L72;
        return true;
    L72:
        return false;
    }

    public final int hashCode() {
        int r0 = String.valueOf(this.l).hashCode();
        if (this.l != 2) goto L5;
        int r1 = String.valueOf(this.j).hashCode() + String.valueOf(this.i).hashCode();
        int r3 = this.h;
    L7:
        return r0 + (r1 + String.valueOf(r3).hashCode());
    L5:
        r1 = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
        r3 = this.f5467b;
        goto L7
    }
}
