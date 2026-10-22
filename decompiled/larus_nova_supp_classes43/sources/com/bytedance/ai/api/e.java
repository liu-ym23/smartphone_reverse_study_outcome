package com.bytedance.ai.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final b a;
    public final String b;
    public final String c;
    public final List<d> d;
    public final c e;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r11.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r11.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        b r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletBottomSheetConfig(appInfo=" + this.a + ", title=" + this.b + ", content=" + this.c + ", buttons=" + this.d + ", behavior=" + this.e + ')';
    }

    public e(b r10, String r11, String r12, List<d> r13, c r14) {
        Intrinsics.checkNotNullParameter(r11, "title");
        Intrinsics.checkNotNullParameter(r12, "content");
        Intrinsics.checkNotNullParameter(r13, "buttons");
        Intrinsics.checkNotNullParameter(r14, "behavior");
        this.a = r10;
        this.b = r11;
        this.c = r12;
        this.d = r13;
        this.e = r14;
    }
}
