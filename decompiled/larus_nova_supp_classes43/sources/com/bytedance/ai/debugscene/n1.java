package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.AIDebugCommand;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n1 {
    public static final String a(AIDebugCommand r0, String r1) {
        String r10 = r0.c.get(r1);
        if (r10 != null) goto L7;
        return null;
    L7:
        return StringsKt.trim(r10).toString();
    }

    public static final boolean b(AIDebugCommand r0, String r1, boolean r10) {
        String r11 = r0.c.get(r1);
        if (r11 != null) goto L6;
        return r10;
    L6:
        if (StringsKt.equals(r11, "true", true) == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r11, "1") == true) goto L13;
        return false;
    L13:
        return true;
    }
}
