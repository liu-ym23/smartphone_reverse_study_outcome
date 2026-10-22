package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements r {

    public static final class a {
    }

    static {
    }

    public o() {
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
    public final boolean b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        boolean r1 = false;
        if (((q) RevenueImageUrlServiceKt.c.getValue()).d() == true) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r9, "webcast/new_user_grade_level_v1_", false, 2, null) == false) goto L17;
        int r0 = StringsKt.indexOf$default(r9, ".png", 0, false, 6, null);
        if (r0 <= 32) goto L17;
        Integer r2 = StringsKt.toIntOrNull(r9.substring(32, r0));
        IntRange r3 = new IntRange(1, 75);
        if (r2 != null) goto L12;
    L14:
        if (r1 == false) goto L17;
        return true;
    L12:
        if (r3.contains(r2.intValue()) == false) goto L14;
        r1 = true;
    L17:
        return Intrinsics.areEqual(r9, "webcast/hide_paygrade_badge_v2.png");
    }
}
