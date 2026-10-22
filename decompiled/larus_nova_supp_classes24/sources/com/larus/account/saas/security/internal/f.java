package com.larus.account.saas.security.internal;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public f() {
    }

    public static String a(String... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        String r3 = r6[r2];
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L12:
        if ((true ^ r5) == true) goto L19;
        r2 = r2 + 1;
        goto L3
    L19:
        return r3;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r5 = false;
        goto L12
    L15:
        return null;
    }
}
