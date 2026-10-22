package com.bytedance.ai.bridge.method.message;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final String a(JsonObject r1, String r10) {
        JsonElement r11 = r1.get(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.isJsonPrimitive() == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L14;
        r11 = null;
    L14:
        if (r11 != null) goto L16;
        return null;
    L16:
        return r11.getAsString();
    L8:
        if (r11.getAsJsonPrimitive().isString() == false) goto L10;
        r0 = true;
        goto L11
    }
}
