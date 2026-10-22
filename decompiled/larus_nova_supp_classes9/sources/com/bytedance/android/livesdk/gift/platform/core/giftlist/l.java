package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements r {
    public final List<Triple<String, String, IntRange>> a;

    public static final class a {
    }

    static {
    }

    public l() {
        this.a = CollectionsKt.listOf(new Triple[]{new Triple("webcast/fansclub_new_advanced_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/ranklist_fansclub_pop_advanced_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/ranklist_fansclub_pop_super_badge_", "_xmp.png", new IntRange(1, 20)), new Triple("webcast/fansclub_effect_badge_", ".png", new IntRange(10, 20))});
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.r
    public final List<String> a(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "urls");
        List<String> r6 = r5;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        String r1 = (String) r7.next();
        int r2 = RevenueImageUrlService.c;
        r0.add(RevenueImageUrlService.a.c(r1, null, 6));
        goto L4
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.giftlist.r
    public final boolean b(String r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (((q) RevenueImageUrlServiceKt.c.getValue()).a() == true) goto L5;
        return false;
    L5:
        Iterator<T> r0 = this.a.iterator();
    L6:
        Object r3 = null;
        if (r0.hasNext() == false) goto L11;
        Object r2 = r0.next();
        if (StringsKt.startsWith$default(r11, (String) ((Triple) r2).getFirst(), false, 2, null) == false) goto L6;
        r3 = r2;
    L11:
        Triple r4 = (Triple) r3;
        if (r4 == null) goto L23;
        String r1 = (String) r4.component1();
        String r5 = (String) r4.component2();
        IntRange r6 = (IntRange) r4.component3();
        int r7 = StringsKt.indexOf$default(r11, r5, 0, false, 6, null);
        if (r7 <= r1.length()) goto L23;
        Integer r13 = StringsKt.toIntOrNull(r11.substring(r1.length(), r7));
        if (r13 != null) goto L18;
    L20:
        boolean r14 = false;
    L21:
        if (r14 == false) goto L23;
        return true;
    L18:
        if (r6.contains(r13.intValue()) == false) goto L20;
        r14 = true;
    L23:
        return false;
    }
}
