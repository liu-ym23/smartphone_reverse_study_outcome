package com.obric.assistant.cocreationreview;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public static final String a(JsonObject r2, String r3) {
        JsonElement r4 = r2.get(r3);
        String r0 = null;
        if (r4 != null) goto L5;
    L10:
        String r5 = null;
    L11:
        if (r5 == null) goto L18;
        if ((!StringsKt.isBlank(r5)) == false) goto L15;
        r0 = r5;
    L15:
        if (r0 == null) goto L18;
        return r0;
    L18:
        throw new IllegalStateException("Missing feedback media field: ".concat(r3).toString());
    L5:
        if (r4.isJsonNull() == false) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L10;
        r5 = r4.getAsString();
        goto L11
    }
}
