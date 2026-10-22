package com.ss.android.lark.chat.cot.detail;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class u implements b {
    public final com.ss.android.lark.chat.cot.c a;
    public final List<v> b;
    public final String c;

    /* JADX WARN: Multi-variable type inference failed */
    public u() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 7);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        com.ss.android.lark.chat.cot.c r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
        String r4 = this.c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "CotToolCallDetailExtra(iconSpec=" + this.a + ", resultAreas=" + this.b + ", parentGroupId=" + this.c + ')';
    }

    public /* synthetic */ u(com.ss.android.lark.chat.cot.c r3, List r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r4 = CollectionsKt.emptyList();
    L8:
        this(r3, r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(com.ss.android.lark.chat.cot.c r2, List<? extends v> r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "resultAreas");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
