package com.bytedance.android.livesdk.gift.platform.business.sendGift;

import com.bytedance.android.livesdk.gift.platform.core.model.s;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final Iterator<s> a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Iterator<s> r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (r1 * 31) + this.b;
    L5:
        r1 = 0;
        goto L7
    }

    public final String toString() {
        return "CurrentPlugin(iterator=" + this.a + ", currentPluginPipeline=" + this.b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends s> r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
