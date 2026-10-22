package com.bytedance.android.livesdk.event;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q {
    public final List<r> a;

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof q) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((q) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<r> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "MentionInfo(infoList=" + this.a + ")";
    }

    public q(List<r> r1) {
        this.a = r1;
    }
}
