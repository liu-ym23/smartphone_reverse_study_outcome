package com.larus.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final String a;
    public final ErrorCode b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        return "ErrorMsg(errorMsg=" + this.a + ", errorCode=" + this.b + ')';
    }

    public a(String r2, ErrorCode r3) {
        Intrinsics.checkNotNullParameter(r2, "errorMsg");
        Intrinsics.checkNotNullParameter(r3, "errorCode");
        this.a = r2;
        this.b = r3;
    }
}
