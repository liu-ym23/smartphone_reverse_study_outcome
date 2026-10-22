package com.obric.aikernel.service.res;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    public static final String a(int r10, String r11, boolean r12) {
        if (r12 == true) goto L6;
        return null;
    L6:
        if (r10 == 4) goto L8;
        return null;
    L8:
        if (r11 != null) goto L10;
    L14:
        r11 = "unknown";
    L16:
        return "bind:" + r11;
    L10:
        if ((!StringsKt.isBlank(r11)) == true) goto L13;
        r11 = null;
    L13:
        if (r11 != null) goto L16;
        goto L14
    }
}
