package com.bytedance.ai.applet.domain;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public final String a;
    public final String b;
    public final long c;
    public final boolean d;
    public final long e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L21;
        return false;
    L21:
        if (this.e == r11.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.d == false) goto L5;
        int r11 = 1231;
    L6:
        int r12 = (r10 + r11) * 31;
        long r13 = this.e;
        return r12 + ((int) (r13 ^ (r13 >>> 32)));
    L5:
        r11 = 1237;
        goto L6
    }

    public final String toString() {
        return "CachedDomainPolicy(signedPayload=" + this.a + ", signature=" + this.b + ", snapshotVersion=" + this.c + ", domainVerifySwitch=" + this.d + ", cachedAtMillis=" + this.e + ')';
    }

    public d() {
        this("", "", 0, true, 0);
    }

    public d(String r10, String r11, long r12, boolean r13, long r14) {
        Intrinsics.checkNotNullParameter(r10, "signedPayload");
        Intrinsics.checkNotNullParameter(r11, "signature");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
