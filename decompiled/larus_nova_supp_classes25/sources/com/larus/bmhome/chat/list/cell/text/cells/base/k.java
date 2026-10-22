package com.larus.bmhome.chat.list.cell.text.cells.base;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class k {
    public final String a;
    public final List<Integer> b;
    public final ec8.b.a c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DeepThinkContentNeedRefreshInfo(messageId=" + this.a + ", indexList=" + this.b + ", typingCacheInfo=" + this.c + ')';
    }

    public k(String r2, List<Integer> r3, ec8.b.a r4) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "indexList");
        Intrinsics.checkNotNullParameter(r4, "typingCacheInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
