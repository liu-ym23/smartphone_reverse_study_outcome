package com.bytedance.badger.x;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a0 {
    public final boolean a;
    public final String b;
    public final int c;
    public final List d;

    public /* synthetic */ a0(int r3, List r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        this(false, null, r3, r4);
    }

    public a0(boolean r1, String r2, int r3, List r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
    L22:
        return true;
    L5:
        if ((r5 instanceof a0) == false) goto L21;
        a0 r6 = (a0) r5;
        if (this.a != r6.a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L21;
        if (Intrinsics.areEqual(this.b, r6.b) == false) goto L21;
        if (this.c != r6.c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L21;
        if (Intrinsics.areEqual(this.d, r6.d) == false) goto L21;
    L16:
        r2 = false;
        goto L17
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
        int r2 = r1 * 31;
        String r3 = this.b;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (((r2 + r5) * 31) + this.c) * 31;
        List r7 = this.d;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "SourceExecutionResult(success=" + this.a + ", deviceFp1=" + this.b + ", attempts=" + this.c + ", errors=" + this.d + ")";
    }
}
