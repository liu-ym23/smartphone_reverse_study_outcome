package com.larus.bmhome.bot;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q5 {
    public final String a;
    public final List<d6> b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q5) == true) goto L8;
        return false;
    L8:
        q5 r6 = (q5) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "ServiceBotSettingBlock(categoryName=" + this.a + ", items=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q5(String r2, List<? extends d6> r3) {
        Intrinsics.checkNotNullParameter(r2, "categoryName");
        Intrinsics.checkNotNullParameter(r3, "items");
        this.a = r2;
        this.b = r3;
    }
}
