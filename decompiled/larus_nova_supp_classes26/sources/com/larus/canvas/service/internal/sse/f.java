package com.larus.canvas.service.internal.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final int a;
    public final String b;
    public final int c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.c) * 31) + this.d.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "ChunkEndData(status=" + this.a + ", logId=" + this.b + ", errorCode=" + this.c + ", errorMsg=" + this.d + ')';
    }

    public /* synthetic */ f(int r3, String r4, int r5) {
        String r1 = "";
        if ((r5 & 2) == 0) goto L6;
        r4 = "";
    L6:
        if ((r5 & 8) != 0) goto L9;
        r1 = null;
    L9:
        this(r3, r4, 0, r1);
    }

    public f(int r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
