package com.bytedance.ai.api;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final String a;
    public final String b;
    public final String c;
    public final HashMap<String, Object> d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "AppletRequestLunaMusicConfig(clientKey=" + this.a + ", scope=" + this.b + ", state=" + this.c + ", traceInfo=" + this.d + ')';
    }

    public g(String r10, String r11, String r12, HashMap<String, Object> r13) {
        Intrinsics.checkNotNullParameter(r10, "clientKey");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "traceInfo");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
