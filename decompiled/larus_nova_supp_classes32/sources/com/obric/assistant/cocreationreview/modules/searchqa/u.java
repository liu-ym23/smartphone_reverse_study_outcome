package com.obric.assistant.cocreationreview.modules.searchqa;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u {
    public static final String a(String r2) {
        String r3 = StringsKt.substringBefore(StringsKt.substringBefore(r2, "：", r2), ":", r2);
        if ((!StringsKt.isBlank(r3)) == true) goto L6;
        r3 = null;
    L6:
        if (r3 != null) goto L9;
        return "资料";
    L9:
        return r3;
    }
}
