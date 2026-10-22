package com.larus.voice.output.volume;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a$b {
    public static boolean a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (Intrinsics.areEqual(r2.c, "tts_im") == false) goto L11;
        Map<String, String> r3 = r2.d;
        if (r3 == null) goto L7;
        String r4 = r3.get("start_method");
    L9:
        if (Intrinsics.areEqual(r4, "auto_play") == false) goto L11;
        return true;
    L7:
        r4 = null;
    L11:
        return false;
    }
}
