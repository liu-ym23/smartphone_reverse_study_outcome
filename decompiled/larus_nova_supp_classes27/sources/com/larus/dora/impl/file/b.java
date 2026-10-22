package com.larus.dora.impl.file;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final String a;
    public final String b;
    public final DoraFileType c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;

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
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
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
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.g;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    }

    public final String toString() {
        return "DoraFetchContext(transportType=" + this.a + ", fetchFrom=" + this.b + ", fileType=" + this.c + ", fileName=" + this.d + ", fileMd5=" + this.e + ", fileCreateTimeMs=" + this.f + ", fileTotalSize=" + this.g + ')';
    }

    public b(String r3, DoraFileType r4, String r5, String r6, long r7, long r9) {
        Intrinsics.checkNotNullParameter("bt", "transportType");
        Intrinsics.checkNotNullParameter(r3, "fetchFrom");
        Intrinsics.checkNotNullParameter(r4, "fileType");
        Intrinsics.checkNotNullParameter(r5, "fileName");
        Intrinsics.checkNotNullParameter(r6, "fileMd5");
        this.a = "bt";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
    }
}
