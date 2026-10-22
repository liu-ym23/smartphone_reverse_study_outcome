package com.bytedance.ai.applet.render.core.lynx;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    public static final JavaOnlyArray a(JsonArray r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyArray r0 = new JavaOnlyArray();
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonPrimitive r1 = (JsonElement) r11.next();
        if ((r1 instanceof JsonNull) == true) goto L7;
        if ((r1 instanceof JsonObject) == true) goto L10;
        if ((r1 instanceof JsonArray) == true) goto L13;
        if ((r1 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r12 = r1;
        if (r12.isBoolean() == true) goto L18;
        if (r12.isString() == true) goto L21;
        if (r12.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r12.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.add(Long.valueOf(r12.getAsNumber().longValue()));
        goto L4
    L26:
        r0.add(Double.valueOf(r12.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.add(r12.getAsString());
        goto L4
    L18:
        r0.add(Boolean.valueOf(r12.getAsBoolean()));
        goto L4
    L13:
        r0.add(a((JsonArray) r1));
        goto L4
    L10:
        r0.add(b((JsonObject) r1));
        goto L4
    L7:
        r0.add(null);
        goto L4
    L28:
        return r0;
    }

    public static final JavaOnlyMap b(JsonObject r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        JavaOnlyMap r0 = new JavaOnlyMap();
        Iterator r1 = r10.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        String r11 = (String) r1.next();
        JsonPrimitive r12 = r10.get(r11);
        if ((r12 instanceof JsonNull) == true) goto L7;
        if ((r12 instanceof JsonObject) == true) goto L10;
        if ((r12 instanceof JsonArray) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.contains$default(r13.getAsNumber().toString(), '.', false, 2, null) == true) goto L26;
        r0.put(r11, Long.valueOf(r13.getAsNumber().longValue()));
        goto L4
    L26:
        r0.put(r11, Double.valueOf(r13.getAsNumber().doubleValue()));
        goto L4
    L21:
        r0.put(r11, r13.getAsString());
        goto L4
    L18:
        r0.put(r11, Boolean.valueOf(r13.getAsBoolean()));
        goto L4
    L13:
        r0.put(r11, a((JsonArray) r12));
        goto L4
    L10:
        r0.put(r11, b((JsonObject) r12));
        goto L4
    L7:
        r0.put(r11, null);
        goto L4
    L28:
        return r0;
    }
}
