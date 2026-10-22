package com.bytedance.ai.debugscene;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final String a;
    public final boolean b;
    public final String c;
    public final Map<String, String> d;

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
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r10 = (r0 + r1) * 31;
        String r11 = this.c;
        if (r11 != null) goto L9;
        int r12 = 0;
    L11:
        return ((r10 + r12) * 31) + this.d.hashCode();
    L9:
        r12 = r11.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AIDebugCommandCompletion(action=" + this.a + ", success=" + this.b + ", message=" + this.c + ", data=" + this.d + ')';
    }

    public a(String r10, boolean r11, String r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Intrinsics.checkNotNullParameter(r13, "data");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
    }
}
