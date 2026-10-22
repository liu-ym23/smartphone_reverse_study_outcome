package com.obric.assistant.settings.autogui;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public static final String a(JsonObject r0, String r1) {
        JsonElement r2 = r0.get(r1);
        if (r2 != null) goto L6;
    L13:
        return "";
    L6:
        if (r2.isJsonNull() == true) goto L13;
        if (r2.isJsonPrimitive() == false) goto L11;
        JsonPrimitive r3 = r2.getAsJsonPrimitive();
    L12:
        if (r3 == null) goto L13;
        return r3.getAsString();
    L11:
        r3 = null;
        goto L12
    }
}
