package com.larus.dora.impl.resource;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    public final String a;
    public final long b;
    public final String c;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof m) == true) goto L8;
        return false;
    L8:
        m r9 = (m) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DoraResourceArtifactIdentity(packageId=" + this.a + ", versionCode=" + this.b + ", sha256=" + this.c + ')';
    }

    public final String a() {
        return this.a;
    }

    public m(String r2, long r3, String r5) {
        Intrinsics.checkNotNullParameter(r2, "packageId");
        Intrinsics.checkNotNullParameter(r5, "sha256");
        this.a = r2;
        this.b = r3;
        this.c = r5;
    }
}
