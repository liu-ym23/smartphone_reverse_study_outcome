package com.larus.business.multitask_management.impl.component;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ll9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i {
    public final List<t> a;
    public final int b;
    public final boolean c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "QuickAccessListData(items=" + this.a + ", foldThreshold=" + this.b + ", hasMore=" + this.c + ')';
    }

    public i(List<t> r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static i a(i r1, List r2, int r3, int r4) {
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.a;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.b;
    L9:
        if ((r4 & 4) == 0) goto L11;
        boolean r5 = r1.c;
    L12:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "items");
        return new i(r2, r3, r5);
    L11:
        r5 = false;
        goto L12
    }
}
