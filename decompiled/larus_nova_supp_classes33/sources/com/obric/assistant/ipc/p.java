package com.obric.assistant.ipc;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(int r2) {
        String r3 = String.valueOf(r2);
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        return "***" + StringsKt.takeLast(r3, 4);
    L5:
        r0 = false;
        goto L6
    }
}
