package com.larus.share.impl.util;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L15;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L15;
        return false;
    L11:
        if (StringsKt.startsWith(r3, "https://", true) != true) goto L13;
        r4 = true;
    L15:
        return true;
    L5:
        if (StringsKt.startsWith(r3, "http://", true) != true) goto L7;
        r2 = true;
        goto L8
    }
}
