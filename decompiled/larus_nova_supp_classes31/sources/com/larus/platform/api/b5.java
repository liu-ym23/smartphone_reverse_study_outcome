package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b5 {
    public final String a;
    public final SdkCalendarErrorCode b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r6 = (b5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "SdkCalendarResult(errorMsg=" + this.a + ", errorCode=" + this.b + ')';
    }

    public b5(String r2, SdkCalendarErrorCode r3) {
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
        Intrinsics.checkNotNullParameter(r3, "errorCode");
        this.a = r2;
        this.b = r3;
    }
}
