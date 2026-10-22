package com.google.common.cache;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.google.common.base.e0 f8701o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final i f8702p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final e f8703q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Logger f8704r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f8707c;
    public long d;
    public z0 e;
    public LocalCache$Strength f;
    public LocalCache$Strength g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f8709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.google.common.base.p f8710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.google.common.base.p f8711k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public w0 f8712l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.google.common.base.h0 f8713m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.google.common.base.e0 f8714n;

    static {
        f8701o = com.google.common.base.b0.C(new d());
        f8702p = new i(0, 0, 0, 0, 0, 0);
        f8703q = new e();
        f8704r = Logger.getLogger(f.class.getName());
    }

    public final void a() {
        boolean r5 = false;
        if (this.e != null) goto L9;
        if (this.d != (-1)) goto L7;
        r5 = true;
    L7:
        com.google.common.base.b0.u(r5, "maximumWeight requires weigher");
        return;
    L9:
        if (this.f8705a == false) goto L15;
        if (this.d == (-1)) goto L13;
        r5 = true;
    L13:
        com.google.common.base.b0.u(r5, "weigher requires maximumWeight");
        return;
    L15:
        if (this.d != (-1)) goto L20;
        f8704r.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        return;
    }

    public final String toString() {
        com.google.common.base.w r5 = com.google.common.base.b0.E(this);
        int r10 = this.f8706b;
        if (r10 == (-1)) goto L5;
        r5.c("concurrencyLevel", String.valueOf(r10));
    L5:
        long r11 = this.f8707c;
        if (r11 == (-1)) goto L8;
        r5.a(r11, "maximumSize");
    L8:
        long r12 = this.d;
        if (r12 == (-1)) goto L11;
        r5.a(r12, "maximumWeight");
    L11:
        long r13 = this.f8708h;
        if (r13 == (-1)) goto L14;
        StringBuilder r14 = new StringBuilder(22);
        r14.append(r13);
        r14.append("ns");
        r5.b(r14.toString(), "expireAfterWrite");
    L14:
        long r15 = this.f8709i;
        if (r15 == (-1)) goto L17;
        StringBuilder r16 = new StringBuilder(22);
        r16.append(r15);
        r16.append("ns");
        r5.b(r16.toString(), "expireAfterAccess");
    L17:
        LocalCache$Strength r17 = this.f;
        if (r17 == null) goto L20;
        r5.b(com.google.common.base.b0.D(r17.toString()), "keyStrength");
    L20:
        LocalCache$Strength r18 = this.g;
        if (r18 == null) goto L24;
        r5.b(com.google.common.base.b0.D(r18.toString()), "valueStrength");
    L24:
        if (this.f8710j == null) goto L27;
        com.google.common.base.w r19 = new com.google.common.base.w();
        ((com.google.common.base.w) r5.d).f8673c = r19;
        r5.d = r19;
        r19.d = "keyEquivalence";
    L27:
        if (this.f8711k == null) goto L30;
        com.google.common.base.w r20 = new com.google.common.base.w();
        ((com.google.common.base.w) r5.d).f8673c = r20;
        r5.d = r20;
        r20.d = "valueEquivalence";
    L30:
        if (this.f8712l == null) goto L33;
        com.google.common.base.w r21 = new com.google.common.base.w();
        ((com.google.common.base.w) r5.d).f8673c = r21;
        r5.d = r21;
        r21.d = "removalListener";
    L33:
        return r5.toString();
    }
}
