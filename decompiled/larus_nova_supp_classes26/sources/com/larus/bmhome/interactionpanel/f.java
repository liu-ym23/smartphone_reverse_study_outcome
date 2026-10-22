package com.larus.bmhome.interactionpanel;

import com.larus.im.internal.protocol.bean.GeneralInteractionAskNotifyDownlinkBody;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final GeneralInteractionAskNotifyDownlinkBody a;
    public final w b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        w r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "GeneralInteractionAskNotifyPayload(notify=" + this.a + ", trackContext=" + this.b + ')';
    }

    public f(GeneralInteractionAskNotifyDownlinkBody r2) {
        Intrinsics.checkNotNullParameter(r2, "notify");
        this.a = r2;
        this.b = null;
    }
}
