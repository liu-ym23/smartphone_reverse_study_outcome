package com.obric.miniapp.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class j {
    public static final Long a(JSONObject r4, String... r5) {
        if (r4 == null) goto L15;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L15;
        Object r2 = r4.opt(r5[r1]);
        if ((r2 instanceof Number) == true) goto L22;
        if ((r2 instanceof String) == false) goto L14;
        Long r3 = StringsKt.toLongOrNull(StringsKt.trim((String) r2).toString());
        if (r3 == null) goto L14;
        return Long.valueOf(r3.longValue());
    L14:
        r1 = r1 + 1;
        goto L5
    L22:
        return Long.valueOf(((Number) r2).longValue());
    L15:
        return null;
    }

    public static final String b(JSONObject r4, String... r5) {
        if (r4 == null) goto L12;
        int r0 = r5.length;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L12;
        String r2 = r4.optString(r5[r1]);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == false) goto L11;
        if (Intrinsics.areEqual(r2, "null") == true) goto L11;
        return r2;
    L11:
        r1 = r1 + 1;
    L12:
        return null;
    }
}
