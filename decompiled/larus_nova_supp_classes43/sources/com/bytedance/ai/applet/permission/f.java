package com.bytedance.ai.applet.permission;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public final boolean a;
    public final String b;
    public final Map<String, Object> c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof f) == true) goto L8;
        return false;
    L8:
        f r11 = (f) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r10 = this.b;
        if (r10 != null) goto L9;
        int r11 = 0;
    L11:
        return ((r1 + r11) * 31) + this.c.hashCode();
    L9:
        r11 = r10.hashCode();
        goto L11
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletAuthorizeResult(success=" + this.a + ", reason=" + this.b + ", extras=" + this.c + ')';
    }

    public f(boolean r10, String r11, Map<String, ? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "extras");
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }

    public /* synthetic */ f(boolean r10, String r11, Map r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = MapsKt.emptyMap();
    L8:
        this(r10, r11, r12);
    }
}
