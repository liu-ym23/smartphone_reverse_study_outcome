package com.larus.chat.job.impl.page.edit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public final ChatJobEditOptionKey a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r6 = (a0) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatJobEditOptionRow(key=" + this.a + ", label=" + this.b + ", value=" + this.c + ", enabled=" + this.d + ", clickable=" + this.e + ')';
    }

    public a0(ChatJobEditOptionKey r3, String r4, String r5, int r6) {
        boolean r1 = false;
        if ((r6 & 8) == 0) goto L5;
        boolean r0 = true;
    L7:
        if ((r6 & 16) == 0) goto L9;
        r1 = r0;
    L9:
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "label");
        Intrinsics.checkNotNullParameter(r5, "value");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r0;
        this.e = r1;
        return;
    L5:
        r0 = false;
        goto L7
    }
}
