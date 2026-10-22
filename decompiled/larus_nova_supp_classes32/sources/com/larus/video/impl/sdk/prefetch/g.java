package com.larus.video.impl.sdk.prefetch;

import com.lynx.tasm.event.LynxTouchEvent;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public final String a;
    public final Map<String, String> b;
    public final ArrayList<String> c;
    public final long d;
    public final int e;
    public final boolean f;
    public final Integer g;
    public final Map<String, String> h;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        long r1 = this.d;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.e) * 31;
        if (this.f == false) goto L5;
        int r3 = 1231;
    L6:
        int r4 = (r2 + r3) * 31;
        Integer r5 = this.g;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        Map<String, String> r9 = this.h;
        if (r9 == null) goto L15;
        r6 = r9.hashCode();
    L15:
        return r8 + r6;
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r3 = 1237;
        goto L6
    }

    public final String toString() {
        return "CachedPreloadItemIdsData(messageId=" + this.a + ", itemIdToRequestIdMap=" + this.b + ", itemIdList=" + this.c + ", cacheValidTimeStamp=" + this.d + ", dataFrom=" + this.e + ", firstUse=" + this.f + ", imprIndex=" + this.g + ", itemIdToChannelIdMap=" + this.h + ')';
    }

    public static g a(g r10) {
        String r1 = r10.a;
        Map<String, String> r2 = r10.b;
        ArrayList<String> r3 = r10.c;
        long r4 = r10.d;
        int r6 = r10.e;
        Integer r8 = r10.g;
        Map<String, String> r9 = r10.h;
        Intrinsics.checkNotNullParameter(r1, "messageId");
        Intrinsics.checkNotNullParameter(r2, "itemIdToRequestIdMap");
        Intrinsics.checkNotNullParameter(r3, "itemIdList");
        return new g(r1, r2, r3, r4, r6, false, r8, r9);
    }

    public /* synthetic */ g(String r13, Map r14, ArrayList r15, long r16, int r18, Integer r19, Map r20, int r21) {
        if ((r21 & 32) == 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r21 & 64) == 0) goto L9;
        Integer r10 = null;
    L11:
        if ((r21 & LynxTouchEvent.kPseudoStateFocusTransition) == 0) goto L13;
        Map r11 = null;
    L14:
        this(r13, r14, r15, r16, r18, r9, r10, r11);
        return;
    L13:
        r11 = r20;
        goto L14
    L9:
        r10 = r19;
        goto L11
    L5:
        r9 = false;
        goto L7
    }

    public g(String r2, Map<String, String> r3, ArrayList<String> r4, long r5, int r7, boolean r8, Integer r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r2, "messageId");
        Intrinsics.checkNotNullParameter(r3, "itemIdToRequestIdMap");
        Intrinsics.checkNotNullParameter(r4, "itemIdList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
