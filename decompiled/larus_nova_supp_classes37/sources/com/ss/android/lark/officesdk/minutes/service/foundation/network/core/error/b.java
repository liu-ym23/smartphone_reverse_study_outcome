package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final MmHttpErrorMsg a;
    public final boolean b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        MmHttpErrorMsg r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = r1 * 31;
        int r3 = 1231;
        if (this.b == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r2 + r4) * 31;
        if (this.c == true) goto L15;
        r3 = 1237;
    L15:
        return r5 + r3;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmHttpCommonErrorProcessResult(commonError=" + this.a + ", displayed=" + this.b + ", suppressLocalFallback=" + this.c + ')';
    }

    public b(MmHttpErrorMsg r1, boolean r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
