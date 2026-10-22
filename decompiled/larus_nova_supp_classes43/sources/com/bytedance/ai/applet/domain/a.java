package com.bytedance.ai.applet.domain;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final long b;
    public final boolean c;
    public final Set<String> d;
    public final Set<String> e;
    public final Set<String> f;
    public final Set<String> g;
    public final Set<String> h;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r11.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r11.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r11.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r10 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        if (this.c == false) goto L5;
        int r11 = 1231;
    L7:
        return ((((((((((r10 + r11) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    L5:
        r11 = 1237;
        goto L7
    }

    public final String toString() {
        return "AppletDomainPolicy(appKey=" + this.a + ", snapshotVersion=" + this.b + ", domainVerifySwitch=" + this.c + ", requestDomains=" + this.d + ", downloadDomains=" + this.e + ", uploadDomains=" + this.f + ", socketDomains=" + this.g + ", webviewDomains=" + this.h + ')';
    }

    public a(String r10, long r11, boolean r12, Set<String> r13, Set<String> r14, Set<String> r15, Set<String> r16, Set<String> r17) {
        Intrinsics.checkNotNullParameter(r10, "appKey");
        Intrinsics.checkNotNullParameter(r13, "requestDomains");
        Intrinsics.checkNotNullParameter(r14, "downloadDomains");
        Intrinsics.checkNotNullParameter(r15, "uploadDomains");
        Intrinsics.checkNotNullParameter(r16, "socketDomains");
        Intrinsics.checkNotNullParameter(r17, "webviewDomains");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.g = r16;
        this.h = r17;
    }
}
