package com.larus.dora.impl.device.ota;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 {
    public int a;
    public String b;
    public int c;
    public int d;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l0) == true) goto L8;
        return false;
    L8:
        l0 r6 = (l0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "Property(errcode=" + this.a + ", errmsg=" + this.b + ", retryCount=" + this.c + ", status=" + this.d + ')';
    }

    public l0(int r3) {
        int r4 = EventTypeOTAErrorCode.SUCCESS.getCode();
        Intrinsics.checkNotNullParameter("", "errmsg");
        this.a = 0;
        this.b = "";
        this.c = 0;
        this.d = r4;
    }
}
