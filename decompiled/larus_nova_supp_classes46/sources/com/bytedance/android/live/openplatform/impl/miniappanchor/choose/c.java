package com.bytedance.android.live.openplatform.impl.miniappanchor.choose;

import kotlin.jvm.internal.Intrinsics;
import mh1.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final String a;
    public final String b;
    public final boolean c;
    public final p d;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L14;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (this.c == r4.c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.c;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        p r10 = this.d;
        if (r10 == null) goto L17;
        r1 = r10.hashCode();
    L17:
        return r9 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "MiniAppChooseStartParameter(clickSource=" + this.a + ", liveType=" + this.b + ", supportTalent=" + this.c + ", miniAppOuterHelper=" + this.d + ")";
    }

    public c(String r2, String r3, boolean r4, p r5) {
        Intrinsics.checkNotNullParameter(r2, "clickSource");
        Intrinsics.checkNotNullParameter(r3, "liveType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
