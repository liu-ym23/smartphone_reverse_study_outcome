package g0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((r4 + r2) * 31) + this.g.hashCode()) * 31;
        long r7 = this.h;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobLeaveTabParamsKmp(enterMethod=" + this.a + ", leaveMethod=" + this.b + ", recommendFrom=" + this.c + ", tabType=" + this.d + ", tabName=" + this.e + ", tabId=" + this.f + ", currentPage=" + this.g + ", duration=" + this.h + ')';
    }

    public j(String r3, String r4, String r5, String r6, String r7, String r8, long r9) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        Intrinsics.checkNotNullParameter(r4, "leaveMethod");
        Intrinsics.checkNotNullParameter("creation_feed", "recommendFrom");
        Intrinsics.checkNotNullParameter(r5, "tabType");
        Intrinsics.checkNotNullParameter(r8, "currentPage");
        this.a = r3;
        this.b = r4;
        this.c = "creation_feed";
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
