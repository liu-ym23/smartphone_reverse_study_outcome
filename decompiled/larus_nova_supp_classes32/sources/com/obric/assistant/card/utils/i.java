package com.obric.assistant.card.utils;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final String a(String r3, String r4, char r5) {
        boolean r0 = false;
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
    L23:
        if (r4 != null) goto L26;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L26:
        return StringsKt.trim(r4).toString();
    L11:
        if (StringsKt.isBlank(r3) == true) goto L23;
        if (r4 != null) goto L15;
    L16:
        r0 = true;
    L17:
        if (r0 == true) goto L28;
        if (StringsKt.isBlank(r4) == true) goto L28;
        return StringsKt.trim(r3).toString() + r5 + StringsKt.trim(r4).toString();
    L28:
        return StringsKt.trim(r3).toString();
    L15:
        if (r4.length() != 0) goto L17;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
