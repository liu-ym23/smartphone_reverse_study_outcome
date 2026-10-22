package l79;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;
    public final String i;
    public final int j;
    public final int k;
    public final String l;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r9.j) goto L39;
        return false;
    L39:
        if (this.k == r9.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r9.l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.g;
        int r4 = (((((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j) * 31) + this.k) * 31;
        String r5 = this.l;
        if (r5 != null) goto L5;
        int r6 = 0;
    L7:
        return r4 + r6;
    L5:
        r6 = r5.hashCode();
        goto L7
    }

    public final String toString() {
        return "DriveFileMineEntity(fileToken=" + this.a + ", driveToken=" + this.b + ", orderIndex=" + this.c + ", fileName=" + this.d + ", fileURL=" + this.e + ", openTime=" + this.f + ", editTime=" + this.g + ", iconInfo=" + this.h + ", fileTypeValue=" + this.i + ", isOwner=" + this.j + ", driveObjType=" + this.k + ", extra=" + this.l + ')';
    }

    public a(String r2, String r3, int r4, String r5, String r6, long r7, long r9, String r11, String r12, int r13, int r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r3, "driveToken");
        Intrinsics.checkNotNullParameter(r5, "fileName");
        Intrinsics.checkNotNullParameter(r6, "fileURL");
        Intrinsics.checkNotNullParameter(r11, "iconInfo");
        Intrinsics.checkNotNullParameter(r12, "fileTypeValue");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r14;
        this.l = r15;
    }
}
