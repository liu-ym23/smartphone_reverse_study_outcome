package com.ss.ugc.effectplatform.algorithm;

import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h {
    public final com.ss.ugc.effectplatform.model.d a;
    public final ModelInfo b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof h) == false) goto L10;
        h r4 = (h) r3;
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
        com.ss.ugc.effectplatform.model.d r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ModelInfo r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ModelInfoCache(localModelInfo=" + this.a + ", serverModelInfo=" + this.b + ")";
    }

    public h(com.ss.ugc.effectplatform.model.d r1, ModelInfo r2) {
        this.a = r1;
        this.b = r2;
    }
}
