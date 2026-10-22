package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class e {
    public boolean a;
    public int b;
    public long c;
    public int d;
    public final long e;
    public long f;
    public boolean g;
    public boolean h;
    public final long i;
    public final String[] j;
    public final String k;
    public final long l;
    public final boolean m;

    public static final class a {
    }

    static {
    }

    public int a() {
        return 0;
    }

    public final String b() {
        return this.j[Math.min(this.b, this.j.length - 1)];
    }

    public final void c() {
        this.b++;
    }

    public String toString() {
        return "GetResourceRequest{id=" + this.i + ", urls='" + this.j.toString() + "', md5='" + this.k + "', sourceFrom='" + this.l + "', needToUnzip=" + this.m + '}';
    }

    public e(long r2, String[] r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "urls");
        Intrinsics.checkNotNullParameter(r5, "md5");
        this.i = r2;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = true;
        this.b = -1;
        this.c = 0;
        this.d = 1;
        i97.a r3 = i97.a.a;
        this.e = System.currentTimeMillis();
    }
}
