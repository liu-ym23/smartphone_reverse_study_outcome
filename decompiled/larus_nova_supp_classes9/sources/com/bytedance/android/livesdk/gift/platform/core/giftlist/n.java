package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n implements r {

    public static final class a {
    }

    static {
    }

    public n() {
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
        if (((q) RevenueImageUrlServiceKt.c.getValue()).c() == true) goto L6;
        return false;
    L6:
        if (StringsKt.startsWith$default(r9, "webcast/paygrade_badge_level_", false, 2, null) == true) goto L8;
    L25:
        return false;
    L8:
        if (StringsKt.indexOf$default(r9, ".png", 0, false, 6, null) != 33) goto L25;
        char r0 = r9.charAt(29);
        if ('4' > r0) goto L25;
        if ('7' < r0) goto L25;
        if (Character.isDigit(r9.charAt(30)) == false) goto L25;
        if (r9.charAt(31) != '_') goto L25;
        char r10 = r9.charAt(32);
        if ('1' > r10) goto L25;
        if ('3' < r10) goto L25;
        return true;
    }
}
