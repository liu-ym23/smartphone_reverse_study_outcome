package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m {
    public static final Long a(Map r10, String r11) {
        Object r12 = r10.get(r11);
        if ((r12 instanceof Number) == false) goto L5;
        Number r13 = (Number) r12;
    L6:
        if (r13 == null) goto L14;
        Long r14 = Long.valueOf(r13.longValue());
        if (r14.longValue() < 0) goto L10;
        boolean r15 = true;
    L11:
        if (r15 == true) goto L13;
        return null;
    L13:
        return r14;
    L10:
        r15 = false;
        goto L11
    L14:
        return null;
    L5:
        r13 = null;
        goto L6
    }
}
