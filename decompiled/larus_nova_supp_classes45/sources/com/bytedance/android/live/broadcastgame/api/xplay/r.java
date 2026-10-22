package com.bytedance.android.live.broadcastgame.api.xplay;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r {
    public String a;
    public String b;
    public int c;
    public String d;
    public byte[] e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;

    public r() {
        this(0);
    }

    public final String toString() {
        return "XplayRTCEngineConfig(rtcExtInfo=" + this.a + ", appId=" + this.b + ", vendor=" + this.c + ", vendorName=" + this.d + ", appSignature=" + Arrays.toString(this.e) + ", channelId=" + this.f + ", token=" + this.g + ", userId=" + this.h + ", interactId=" + this.i + ", interactIdMode=" + this.j + ", businessId=" + this.k + ")";
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31;
        byte[] r1 = this.e;
        if (r1 == null) goto L5;
        int r2 = Arrays.hashCode(r1);
    L7:
        return ((((((((((((r0 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31) + this.k.hashCode();
    L5:
        r2 = 0;
        goto L7
    }

    public r(int r3) {
        Intrinsics.checkNotNullParameter("", "rtcExtInfo");
        Intrinsics.checkNotNullParameter("", "appId");
        Intrinsics.checkNotNullParameter("", "vendorName");
        Intrinsics.checkNotNullParameter("", "channelId");
        Intrinsics.checkNotNullParameter("", "token");
        Intrinsics.checkNotNullParameter("", "userId");
        Intrinsics.checkNotNullParameter("", "interactId");
        Intrinsics.checkNotNullParameter("", "businessId");
        this.a = "";
        this.b = "";
        this.c = 0;
        this.d = "";
        this.e = null;
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = 0;
        this.k = "";
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(r.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L56;
        r r6 = (r) r5;
        if ((!Intrinsics.areEqual(this.a, r6.a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.b, r6.b)) == false) goto L20;
        return false;
    L20:
        if (this.c == r6.c) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.d, r6.d)) == false) goto L25;
        return false;
    L25:
        byte[] r1 = this.e;
        if (r1 == null) goto L34;
        byte[] r3 = r6.e;
        if (r3 != null) goto L31;
        return false;
    L31:
        if (Arrays.equals(r1, r3) == true) goto L37;
        return false;
    L37:
        if ((!Intrinsics.areEqual(this.f, r6.f)) == false) goto L40;
        return false;
    L40:
        if ((!Intrinsics.areEqual(this.g, r6.g)) == false) goto L43;
        return false;
    L43:
        if ((!Intrinsics.areEqual(this.h, r6.h)) == false) goto L46;
        return false;
    L46:
        if ((!Intrinsics.areEqual(this.i, r6.i)) == false) goto L49;
        return false;
    L49:
        if (this.j == r6.j) goto L52;
        return false;
    L52:
        if ((!Intrinsics.areEqual(this.k, r6.k)) == false) goto L54;
        return false;
    L54:
        return true;
    L34:
        if (r6.e == null) goto L37;
        return false;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayRTCEngineConfig");
    L8:
        r2 = null;
        goto L10
    }
}
