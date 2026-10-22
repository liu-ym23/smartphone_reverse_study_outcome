package com.obric.assistant.settings.autogui;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class m0 {
    public static final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        int r1 = l.a;
        Intrinsics.checkNotNullParameter(r2, "value");
        com.obric.assistant.e.a.getClass();
        com.obric.assistant.e.a r3 = com.obric.assistant.e.a(r2);
        if (r3 == null) goto L16;
        String r4 = r3.a;
        if (r4 == null) goto L16;
        if (r4.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L16;
        return r4;
    L9:
        r0 = false;
    L16:
        return l.a().a;
    }
}
