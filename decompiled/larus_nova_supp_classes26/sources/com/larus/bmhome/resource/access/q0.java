package com.larus.bmhome.resource.access;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q0 {
    public final String a;
    public final ResourcePhase b;
    public final ResourceNodeStatus c;
    public final long d;
    public final String e;
    public final Map<String, String> f;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r9 = (q0) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        String r3 = this.e;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return ((r2 + r4) * 31) + this.f.hashCode();
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public final String toString() {
        return "ResourceNodeState(nodeKey=" + this.a + ", phase=" + this.b + ", status=" + this.c + ", costMs=" + this.d + ", errorCode=" + this.e + ", attributes=" + this.f + ')';
    }

    public q0(String r2, ResourcePhase r3, ResourceNodeStatus r4, long r5, String r7, Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r2, "nodeKey");
        Intrinsics.checkNotNullParameter(r3, "phase");
        Intrinsics.checkNotNullParameter(r4, "status");
        Intrinsics.checkNotNullParameter(r8, "attributes");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
    }
}
