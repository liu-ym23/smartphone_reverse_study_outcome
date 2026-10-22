package com.bytedance.android.live.revlink.link.core.layoutstatus;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l {
    public static final l c = null;
    public final int a;
    public final Map<String, Integer> b;

    public static final class a {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l) == false) goto L10;
        l r4 = (l) r3;
        if (this.a == r4.a) goto L8;
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
        int r0 = this.a * 31;
        Map<String, Integer> r1 = this.b;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "MinFramesInfo(minFrames=" + this.a + ", positionMap=" + this.b + ")";
    }

    static {
        c = new l(2, null);
    }

    public l(int r1, Map<String, Integer> r2) {
        this.a = r1;
        this.b = r2;
    }
}
