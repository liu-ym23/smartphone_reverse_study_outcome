package com.larus.platform.api;

import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k {
    public final HashMap<String, String> a;
    public final String b;
    public final long c;
    public final ArrayList<String> d;
    public final CachedVideosPreloadFrom e;
    public final Integer f;
    public final HashMap<String, String> g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof k) == true) goto L8;
        return false;
    L8:
        k r9 = (k) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        Integer r3 = this.f;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        HashMap<String, String> r7 = this.g;
        if (r7 == null) goto L11;
        r4 = r7.hashCode();
    L11:
        return r6 + r4;
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "CmdCachedVideoItems(cachedVideoItemsToRequestId=" + this.a + ", messageId=" + this.b + ", cacheTimeStamp=" + this.c + ", itemIdList=" + this.d + ", dataFrom=" + this.e + ", imprIndex=" + this.f + ", cachedVideoItemsToChannelId=" + this.g + ')';
    }

    public k(HashMap<String, String> r2, String r3, long r4, ArrayList<String> r6, CachedVideosPreloadFrom r7, Integer r8, HashMap<String, String> r9) {
        Intrinsics.checkNotNullParameter(r2, "cachedVideoItemsToRequestId");
        Intrinsics.checkNotNullParameter(r3, "messageId");
        Intrinsics.checkNotNullParameter(r6, "itemIdList");
        Intrinsics.checkNotNullParameter(r7, "dataFrom");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
