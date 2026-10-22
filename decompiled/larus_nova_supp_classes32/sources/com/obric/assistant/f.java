package com.obric.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final String a;
    public final DoraAuthTrustType b;
    public final DoraAuthTrustType c;
    public final boolean d;
    public final String e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.e;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r5 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraAuthTrustBuryPointState(sessionId=" + this.a + ", originAuthType=" + this.b + ", actualAuthType=" + this.c + ", wearingState=" + this.d + ", bluetoothEncryptId=" + this.e + ')';
    }

    public f(String r2, DoraAuthTrustType r3, DoraAuthTrustType r4, boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "originAuthType");
        Intrinsics.checkNotNullParameter(r4, "actualAuthType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
