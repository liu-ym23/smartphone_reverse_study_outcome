package com.larus.common.account.platform.larkauth.util;

import a09.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    static {
    }

    public static Map a(a r4, String r5, boolean r6) {
        if (r4 == null) goto L4;
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r4.a();
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        if (r5 != null) goto L10;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L17;
    L20:
        r0.put("Authorization", "Bearer ".concat(r1));
    L21:
        if (r6 == false) goto L23;
        r0.put("OfficeSDK", r1);
    L23:
        return r0;
    L17:
        if (Intrinsics.areEqual(r4.c(), "Bearer") == true) goto L20;
        r0.put("DPoP", r5);
        r0.put("Authorization", "DPoP ".concat(r1));
        goto L21
    L10:
        if (r5.length() == 0) goto L13;
        r2 = false;
        goto L15
    L4:
        return MapsKt.emptyMap();
    }
}
