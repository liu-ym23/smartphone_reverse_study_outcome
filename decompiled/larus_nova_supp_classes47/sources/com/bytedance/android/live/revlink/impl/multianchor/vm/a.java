package com.bytedance.android.live.revlink.impl.multianchor.vm;

import com.bytedance.android.livesdk.link.model.g6;
import com.bytedance.android.livesdk.link.model.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public final p a;
    public final g6 b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L10;
        a r4 = (a) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        p r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        g6 r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorLeaveEvent(leaveAnchor=" + this.a + ", content=" + this.b + ")";
    }

    public a(p r2, g6 r3) {
        Intrinsics.checkNotNullParameter(r2, "leaveAnchor");
        this.a = r2;
        this.b = r3;
    }
}
