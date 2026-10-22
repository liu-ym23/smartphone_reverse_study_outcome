package com.larus.suggest.impl.wcb.render;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class i {
    public final int a;
    public final NexPulseResponseData b;
    public final String c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        if (this.d == false) goto L9;
        int r4 = 1231;
    L11:
        return r3 + r4;
    L9:
        r4 = 1237;
        goto L11
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "WcbPresentation(scene=" + this.a + ", response=" + this.b + ", renderStatus=" + this.c + ", isInTaskMode=" + this.d + ')';
    }

    public i(int r2, NexPulseResponseData r3, @WcbRenderStatus String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "response");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
