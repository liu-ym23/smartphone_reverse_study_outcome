package ct9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final String a;
    public final String b;
    public final Boolean c;
    public int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.d;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ThirdPartyAccountUiData(thirdPartyKey=" + this.a + ", thirdPartyName=" + this.b + ", choseStatus=" + this.c + ", uiStatus=" + this.d + ')';
    }

    public b() {
        this("", "", Boolean.FALSE, 0);
    }

    public b(String r1, String r2, Boolean r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public static b a(b r3, Boolean r4, int r5, int r6) {
        String r1 = null;
        if ((r6 & 1) == 0) goto L5;
        String r0 = r3.a;
    L7:
        if ((r6 & 2) == 0) goto L10;
        r1 = r3.b;
    L10:
        if ((r6 & 4) == 0) goto L13;
        r4 = r3.c;
    L13:
        if ((r6 & 8) == 0) goto L16;
        r5 = r3.d;
    L16:
        return new b(r0, r1, r4, r5);
    L5:
        r0 = null;
        goto L7
    }
}
