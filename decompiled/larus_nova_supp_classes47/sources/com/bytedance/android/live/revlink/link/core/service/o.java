package com.bytedance.android.live.revlink.link.core.service;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o {
    public final Map<String, com.bytedance.android.livesdk.link.model.bridge.g> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof o) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((o) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<String, com.bytedance.android.livesdk.link.model.bridge.g> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("LayoutDetails(positionDetails={");
        Iterator<Map.Entry<String, com.bytedance.android.livesdk.link.model.bridge.g>> r1 = this.a.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.android.livesdk.link.model.bridge.g> r2 = r1.next();
        r0.append(r2.getKey() + '=' + r2.getValue().getPosition() + ", ");
        goto L4
    L6:
        r0.append("})");
        return r0.toString();
    }

    public o(Map<String, ? extends com.bytedance.android.livesdk.link.model.bridge.g> r2) {
        Intrinsics.checkNotNullParameter(r2, "positionDetails");
        this.a = r2;
    }
}
