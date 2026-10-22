package gx0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final String a;
    public final String b;
    public final String c;

    public a() {
        this(null, 7);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ExchangeCommonLog(exchangeReason=" + this.a + ", eventModule=" + this.b + ", popupType=" + this.c + ")";
    }

    public a(String r4, int r5) {
        String r1 = "";
        if ((r5 & 1) == 0) goto L5;
        r4 = "";
    L5:
        String r2 = null;
        if ((r5 & 2) != 0) goto L10;
        r1 = null;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r2 = "insufficient_balance_popup";
    L12:
        Intrinsics.checkNotNullParameter(r4, "exchangeReason");
        Intrinsics.checkNotNullParameter(r1, "eventModule");
        Intrinsics.checkNotNullParameter(r2, "popupType");
        this.a = r4;
        this.b = r1;
        this.c = r2;
    }
}
