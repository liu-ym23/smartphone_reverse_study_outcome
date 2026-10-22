package com.larus.bmhome.chat.larkforward;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public final List<String> a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final boolean f;
    public final e0 g;
    public final String h;
    public final String i;

    public p() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof p) == true) goto L8;
        return false;
    L8:
        p r6 = (p) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
        int r5 = 1231;
        if (this.d == false) goto L9;
        int r6 = 1231;
    L10:
        int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
        if (this.f == true) goto L14;
        r5 = 1237;
    L14:
        int r8 = (((r7 + r5) * 31) + this.g.hashCode()) * 31;
        String r9 = this.h;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        String r12 = this.i;
        if (r12 == null) goto L23;
        r2 = r12.hashCode();
    L23:
        return r11 + r2;
    L17:
        r10 = r9.hashCode();
        goto L18
    L9:
        r6 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowLarkToDoubaoRequest(larkMessageIds=" + this.a + ", extraNote=" + this.b + ", quasiTitle=" + this.c + ", isGroupChat=" + this.d + ", chatId=" + this.e + ", isThreadRootMsg=" + this.f + ", trackParams=" + this.g + ", functionScene=" + this.h + ", originMergeForwardId=" + this.i + ')';
    }

    public p(List r2, String r3, String r4, boolean r5, String r6, boolean r7, e0 r8, String r9) {
        Intrinsics.checkNotNullParameter(r2, "larkMessageIds");
        Intrinsics.checkNotNullParameter(r4, "quasiTitle");
        Intrinsics.checkNotNullParameter(r6, "chatId");
        Intrinsics.checkNotNullParameter(r8, "trackParams");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = null;
        this.i = r9;
    }
}
