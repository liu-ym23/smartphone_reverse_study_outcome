package com.bytedance.badger.network;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b0 {
    public final boolean a;
    public final int b;
    public final List<Pair<String, String>> c;
    public final String d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L22:
        return true;
    L5:
        if ((r5 instanceof b0) == false) goto L21;
        b0 r6 = (b0) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L21;
        if (this.b != r6.b) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L21;
        if (Intrinsics.areEqual(this.c, r6.c) == false) goto L21;
        if (Intrinsics.areEqual(this.d, r6.d) == false) goto L21;
    L14:
        r2 = false;
        goto L15
    L9:
        r1 = false;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r0 = this.a;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.b) * 31;
        List<Pair<String, String>> r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        String r7 = this.d;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "ResponseBundle(isSuccess=" + this.a + ", status=" + this.b + ", headers=" + this.c + ", body=" + this.d + ")";
    }

    public b0(boolean r1, int r2, List<Pair<String, String>> r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
