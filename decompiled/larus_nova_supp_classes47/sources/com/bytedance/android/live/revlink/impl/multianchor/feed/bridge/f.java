package com.bytedance.android.live.revlink.impl.multianchor.feed.bridge;

import com.bytedance.android.livesdk.link.model.f4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final boolean a;
    public final f4 b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof f) == false) goto L10;
        f r4 = (f) r3;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        f4 r3 = this.b;
        if (r3 == null) goto L8;
        int r4 = r3.hashCode();
    L10:
        return r2 + r4;
    L8:
        r4 = 0;
        goto L10
    }

    public final String toString() {
        return "IRealEffectInfo(isSelf=" + this.a + ", effectInfo=" + this.b + ")";
    }

    public f(boolean r2, f4 r3) {
        Intrinsics.checkNotNullParameter(r3, "effectInfo");
        this.a = r2;
        this.b = r3;
    }
}
