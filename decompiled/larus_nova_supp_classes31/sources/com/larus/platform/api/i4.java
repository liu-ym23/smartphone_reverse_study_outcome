package com.larus.platform.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i4 {
    public final String a;
    public final String b;
    public final String c;
    public final HashMap<String, Object> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i4) == true) goto L8;
        return false;
    L8:
        i4 r6 = (i4) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "LunaRequestLunaMusicConfig(clientKey=" + this.a + ", scope=" + this.b + ", state=" + this.c + ", traceInfo=" + this.d + ')';
    }

    public i4(String r2, String r3, String r4, HashMap<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "clientKey");
        Intrinsics.checkNotNullParameter(r3, "scope");
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "traceInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
