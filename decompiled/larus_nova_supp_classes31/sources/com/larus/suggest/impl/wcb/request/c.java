package com.larus.suggest.impl.wcb.request;

import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.render.p;
import ic8.k0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final z a;
    public final WcbRequestTrigger b;
    public final k0 c;
    public final String d;
    public final p e;
    public final int f;
    public final boolean g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        p r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.f) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbRequest(policy=" + this.a + ", trigger=" + this.b + ", params=" + this.c + ", reqSrc=" + this.d + ", target=" + this.e + ", requestScene=" + this.f + ", isFirstModeEntry=" + this.g + ')';
    }

    public c(z r2, WcbRequestTrigger r3, k0 r4, String r5, p r6, int r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "policy");
        Intrinsics.checkNotNullParameter(r3, "trigger");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "reqSrc");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
