package com.bytedance.android.live.broadcastgame;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 {
    public final int a;
    public final String b;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ j0() {
        this(0, null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j0) == false) goto L10;
        j0 r4 = (j0) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "Status(statusCode=" + this.a + ", errorMsg=" + this.b + ")";
    }

    public j0(int r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
