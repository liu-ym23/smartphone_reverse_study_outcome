package com.bytedance.ai.applet.base.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final JsonArray a(JSONArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JsonArray r0 = new JsonArray();
        int r1 = r10.length();
        int r11 = 0;
    L3:
        if (r11 >= r1) goto L23;
        Object r12 = r10.get(r11);
        if ((r12 instanceof Number) == false) goto L8;
        r0.add((Number) r12);
    L22:
        r11 = r11 + 1;
        goto L3
    L8:
        if ((r12 instanceof String) == false) goto L11;
        r0.add((String) r12);
        goto L22
    L11:
        if ((r12 instanceof Character) == false) goto L14;
        r0.add((Character) r12);
        goto L22
    L14:
        if ((r12 instanceof Boolean) == false) goto L17;
        r0.add((Boolean) r12);
        goto L22
    L17:
        if ((r12 instanceof JSONObject) == false) goto L20;
        r0.add(b((JSONObject) r12));
        goto L22
    L20:
        if ((r12 instanceof JSONArray) == false) goto L22;
        r0.add(a((JSONArray) r12));
        goto L22
    L23:
        return r0;
    }

    public static final JsonObject b(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JsonObject r0 = new JsonObject();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L23;
        String r11 = r1.next();
        Object r12 = r10.get(r11);
        if ((r12 instanceof Number) == true) goto L7;
        if ((r12 instanceof String) == true) goto L10;
        if ((r12 instanceof Character) == true) goto L13;
        if ((r12 instanceof Boolean) == true) goto L16;
        if ((r12 instanceof JSONObject) == true) goto L19;
        if ((r12 instanceof JSONArray) == false) goto L4;
        r0.add(r11, a((JSONArray) r12));
        goto L4
    L19:
        r0.add(r11, b((JSONObject) r12));
        goto L4
    L16:
        r0.addProperty(r11, (Boolean) r12);
        goto L4
    L13:
        r0.addProperty(r11, (Character) r12);
        goto L4
    L10:
        r0.addProperty(r11, (String) r12);
        goto L4
    L7:
        r0.addProperty(r11, (Number) r12);
        goto L4
    L23:
        return r0;
    }
}
