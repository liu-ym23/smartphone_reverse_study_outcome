package com.ss.android.lark.chat.cot.detail;

import com.ss.android.lark.chat.entity.message.CotStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class t implements b {
    public final CotStatus a;
    public final String b;

    public t() {
        this(null, 3);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "CotStatusDetailExtra(overallStatus=" + this.a + ", statusText=" + this.b + ')';
    }

    public t(CotStatus r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "overallStatus");
        this.a = r2;
        this.b = r3;
    }

    public /* synthetic */ t(CotStatus r1, int r2) {
        if ((r2 & 1) == 0) goto L5;
        r1 = CotStatus.NONE;
    L5:
        this(r1, null);
    }
}
