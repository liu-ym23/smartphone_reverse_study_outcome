package com.bytedance.android.livesdk.gift.platform.business.pkTray;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o {
    public final TrayActionType a;
    public final long b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof o) == false) goto L10;
        o r6 = (o) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r6.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        TrayActionType r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        long r2 = this.b;
        return (r1 * 31) + ((int) (r2 ^ (r2 >>> 32)));
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "TrayAction(actionType=" + this.a + ", duration=" + this.b + ")";
    }

    public o(TrayActionType r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "actionType");
        this.a = r2;
        this.b = r3;
    }
}
