package com.larus.dora.api.offline.record;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public final int a;
    public final int b;
    public final String c;
    public final int d;
    public final String e;
    public final int f;
    public final long g;

    /* JADX INFO: renamed from: com.larus.dora.api.offline.record.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
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
        int r0 = ((((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d) * 31;
        String r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (((r0 + r2) * 31) + this.f) * 31;
        long r4 = this.g;
        return r3 + ((int) (r4 ^ (r4 >>> 32)));
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraOfflineRecordFileReadyNotify(status=" + this.a + ", businessType=" + this.b + ", vuiId=" + this.c + ", contextType=" + this.d + ", contextId=" + this.e + ", fileType=" + this.f + ", durationSec=" + this.g + ')';
    }

    public a(int r2, int r3, String r4, int r5, String r6, int r7, long r8) {
        Intrinsics.checkNotNullParameter(r4, "vuiId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
