package g0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + this.f.hashCode();
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobEnterTabParamsKmp(currentPage=" + this.a + ", tabId=" + this.b + ", tabName=" + this.c + ", fromTabId=" + this.d + ", tabType=" + this.e + ", enterMethod=" + this.f + ')';
    }

    public i(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "currentPage");
        Intrinsics.checkNotNullParameter(r3, "tabId");
        Intrinsics.checkNotNullParameter(r4, "tabName");
        Intrinsics.checkNotNullParameter(r7, "enterMethod");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
