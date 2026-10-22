package com.ss.android.lark.officesdk.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final String a;
    public final String b;
    public final long c;

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
        if (this.c == r9.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "OfficeSDKBootTaskTraceRecord(taskName=" + this.a + ", phase=" + this.b + ", costMs=" + this.c + ')';
    }

    public b(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        Intrinsics.checkNotNullParameter(r3, "phase");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
