package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g0 {
    public final long a;
    public final String b;
    public final boolean c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r9 = (g0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.b;
        if (r2 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r1 + r3) * 31;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L11:
        return r4 + r5;
    L9:
        r5 = 1237;
        goto L11
    L5:
        r3 = r2.hashCode();
        goto L6
    }

    public final String toString() {
        return "MenuTabItem(tabId=" + this.a + ", name=" + this.b + ", selected=" + this.c + ')';
    }

    public g0(long r1, String r3, boolean r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }
}
