package com.larus.platform.api;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v4 {
    public final Map<String, String> a;
    public final ArrayList<String> b;
    public final boolean c;
    public final Map<String, String> d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof v4) == true) goto L8;
        return false;
    L8:
        v4 r6 = (v4) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        ArrayList<String> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        if (this.c == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r4 + r5) * 31;
        Map<String, String> r7 = this.d;
        if (r7 == null) goto L15;
        r2 = r7.hashCode();
    L15:
        return r6 + r2;
    L9:
        r5 = 1237;
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "PrefetchRecommendVideoResult(itemsToRequestIdHashMap=" + this.a + ", itemIdList=" + this.b + ", innerLoadMoreRequestFromSecondRun=" + this.c + ", itemsToChannelIdHashMap=" + this.d + ')';
    }

    public v4(Map<String, String> r2, ArrayList<String> r3, boolean r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "itemsToRequestIdHashMap");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
