package com.suite.lark.platform.component.storage.file.dirs;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public static final String a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return r5;
    L12:
        if (r5.length() == 0) goto L15;
        r0 = false;
    L15:
        if (r0 == true) goto L22;
        StringBuilder r1 = new StringBuilder();
        r1.append(r5);
        String r4 = "/";
        if (StringsKt.endsWith$default(r5, "/", false, 2, null) == false) goto L20;
        r4 = "";
    L20:
        r1.append(r4);
        r1.append(r6);
        return r1.toString();
    L22:
        return r6;
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
