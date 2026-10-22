package com.larus.bmhome.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class q3 {
    public final String a;
    public final com.larus.network.http.a<wc9.e> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q3) == true) goto L8;
        return false;
    L8:
        q3 r6 = (q3) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        com.larus.network.http.a<wc9.e> r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "SimpleConvInfo(convId=" + this.a + ", remoteResp=" + this.b + ')';
    }

    public q3(String r5) {
        Intrinsics.checkNotNullParameter(r5, "convId");
        this.a = r5;
        this.b = null;
        StringsKt.contains$default(r5, "local", false, 2, null);
    }
}
