package com.bytedance.forest.chain.fetchers;

import java.io.File;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static boolean a(String r5, com.bytedance.forest.pollyfill.l r10, File r11, com.bytedance.forest.utils.e r12, int r13) {
        if (r11 != null) goto L5;
    L7:
        Long r14 = com.bytedance.forest.utils.k.b(r10);
        if (r14 == null) goto L10;
        long r15 = r14.longValue();
    L11:
        long r16 = com.bytedance.forest.utils.k.f(r10);
        if (r10 == null) goto L18;
        String r17 = (String) r10.f4528c.get("age");
        if (r17 == null) goto L18;
        Integer r18 = StringsKt.toIntOrNull(r17);
        if (r18 == null) goto L18;
        int r19 = r18.intValue();
    L20:
        if (System.currentTimeMillis() <= Math.max(r15, (((long) (r13 - r19)) * 1000) + r16)) goto L23;
        return true;
    L23:
        return false;
    L18:
        r19 = 0;
        goto L20
    L10:
        r15 = com.bytedance.forest.utils.k.f(r10);
        goto L11
    L5:
        if (com.bytedance.forest.pollyfill.b.b(r5, r11, r12) == true) goto L7;
        return false;
    }
}
