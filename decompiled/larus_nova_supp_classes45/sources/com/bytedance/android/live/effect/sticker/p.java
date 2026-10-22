package com.bytedance.android.live.effect.sticker;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p {
    public final String a;
    public final List<String> b;
    public final String c;

    public p() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L12;
        p r4 = (p) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "StickerPanelExtraInfo(liveSearchTips=" + this.a + ", liveSearchRecommend=" + this.b + ", liveRecommendTips=" + this.c + ")";
    }

    public /* synthetic */ p(int r2) {
        this("", CollectionsKt.emptyList(), "");
    }

    public p(String r2, List<String> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "liveSearchTips");
        Intrinsics.checkNotNullParameter(r3, "liveSearchRecommend");
        Intrinsics.checkNotNullParameter(r4, "liveRecommendTips");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
