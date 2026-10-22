package com.bytedance.android.livesdk.gift.platform.core;

import com.bytedance.android.livesdk.gift.model.c2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l {
    public final c2 a;

    public l() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof l) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((l) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        c2 r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "GiftStructInfo(giftTip=" + this.a + ")";
    }

    public l(c2 r1) {
        this.a = r1;
    }
}
