package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final String a;
    public final String b;
    public final int c;
    public final long d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        long r1 = this.d;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e.hashCode();
    }

    public final String toString() {
        return "HostForwardFileContent(resourceUri=" + this.a + ", fileName=" + this.b + ", storageType=" + this.c + ", fileSize=" + this.d + ", mimeType=" + this.e + ')';
    }

    public c(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "resourceUri");
        Intrinsics.checkNotNullParameter(r3, "fileName");
        Intrinsics.checkNotNullParameter(r4, "mimeType");
        this.a = r2;
        this.b = r3;
        this.c = 3;
        this.d = 0;
        this.e = r4;
    }
}
