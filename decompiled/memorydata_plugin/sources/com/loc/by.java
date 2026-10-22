package com.loc;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class by {
    private static volatile by g;
    private static Object h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bx f5387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private bz f5388b;
    private long c;
    private da d;
    private bu e;
    private da f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public da f5389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<db> f5390b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<dv> i;
        public boolean j;

        public a() {
        }
    }

    static {
        h = new Object();
    }

    private by() {
        this.f = new da();
        this.f5387a = new bx();
        this.f5388b = new bz();
        this.e = new bu();
    }

    public static by a() {
        if (g != null) goto L15;
        Object r0 = h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new by();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final ca a(a r22) {
        ca r2 = null;
        if (r22 != null) goto L5;
        return null;
    L5:
        long r11 = System.currentTimeMillis();
        long r13 = SystemClock.elapsedRealtime();
        if (this.d != null) goto L8;
    L9:
        bx.a r17 = this.f5387a.a(r22.f5389a, r22.j, r22.g, r22.h, r22.i);
        List<db> r20 = this.f5388b.a(r22.f5389a, r22.f5390b, r22.e, r22.d, r11);
        if (r17 != null) goto L12;
        if (r20 != null) goto L12;
    L13:
        this.d = r22.f5389a;
        this.c = r13;
    L14:
        return r2;
    L12:
        cw.a(this.f, r22.f5389a, r22.f, r11);
        r2 = new ca(0, this.e.a(this.f, r17, r22.c, r20));
        goto L13
    L8:
        if (r22.f5389a.a(this.d) < 10.0d) goto L14;
        goto L9
    }
}
