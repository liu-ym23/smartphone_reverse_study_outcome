package com.larus.agents.impl.webfetch;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k {
    public static final String a(String r13) {
        if (r13 != null) goto L4;
        r13 = "";
    L4:
        String r14 = StringsKt.replace$default(StringsKt.replace$default(StringsKt.take(r13, 128), '\r', '_', false, 4, null), '\n', '_', false, 4, null);
        if (r14.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return "missing";
    L11:
        return r14;
    L7:
        r0 = false;
        goto L8
    }
}
