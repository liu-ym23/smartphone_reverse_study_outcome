package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r {
    public static final String a(JSONObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L11;
        String r3 = r5.optString(r6[r1]);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        r2 = r3;
    L8:
        if (r2 != null) goto L11;
        r1 = r1 + 1;
    L11:
        return r2;
    }
}
