package ub0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final String a;
    public final long b;
    public final int c;
    public final String d;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L14;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r7.b) goto L10;
        return false;
    L10:
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        long r3 = this.b;
        int r4 = ((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
        String r5 = this.d;
        if (r5 == null) goto L10;
        r1 = r5.hashCode();
    L10:
        return r4 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LyricsDownloadInfo(lyricsUrl=" + this.a + ", musicId=" + this.b + ", lyricsType=" + this.c + ", savePath=" + this.d + ")";
    }

    public c(String r2, long r3, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "lyricsUrl");
        Intrinsics.checkNotNullParameter(r6, "savePath");
        this.a = r2;
        this.b = r3;
        this.c = r5;
        this.d = r6;
    }
}
