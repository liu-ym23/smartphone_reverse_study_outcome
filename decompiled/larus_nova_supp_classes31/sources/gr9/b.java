package gr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;
    public final int f;
    public final boolean g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.d;
        int r4 = (((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.e) * 31) + this.f) * 31;
        if (this.g == false) goto L5;
        int r5 = 1231;
    L7:
        return r4 + r5;
    L5:
        r5 = 1237;
        goto L7
    }

    public final String toString() {
        return "SubConversationSimplifyModel(id=" + this.a + ", title=" + this.b + ", updateTime=" + this.c + ", version=" + this.d + ", badgeCount=" + this.e + ", readBadgeCount=" + this.f + ", isMainConversation=" + this.g + ')';
    }

    public b(String r2, String r3, long r4, long r6, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "title");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r8;
        this.f = r9;
        this.g = false;
    }
}
