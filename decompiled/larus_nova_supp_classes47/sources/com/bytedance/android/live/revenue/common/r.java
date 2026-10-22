package com.bytedance.android.live.revenue.common;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r {
    public static final Object a(JsonElement r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toOrgJsonValue");
        if ((r3 instanceof JsonObject) == false) goto L9;
        JSONObject r0 = new JSONObject();
        Iterator r4 = ((JsonObject) r3).entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L40;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), a((JsonElement) r1.getValue()));
        goto L6
    L40:
        return r0;
    L9:
        if ((r3 instanceof JsonArray) == false) goto L16;
        Iterable r5 = (Iterable) r3;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r6 = r5.iterator();
    L12:
        if (r6.hasNext() == false) goto L36;
        r2.add(a((JsonElement) r6.next()));
        goto L12
    L36:
        return new JSONArray(r2);
    L16:
        if ((r3 instanceof JsonPrimitive) == false) goto L29;
        JsonPrimitive r7 = (JsonPrimitive) r3;
        if (r7.isBoolean() == false) goto L21;
        return Boolean.valueOf(r7.getAsBoolean());
    L21:
        if (r7.isNumber() == false) goto L24;
        return r7.getAsNumber();
    L24:
        if (r7.isString() == false) goto L27;
        return r7.getAsString();
    L27:
        throw new IllegalArgumentException("Unexpected JsonPrimitive value: " + r3);
    L29:
        if ((r3 instanceof JsonNull) == false) goto L33;
        return JSONObject.NULL;
    L33:
        throw new IllegalArgumentException("Unexpected JsonElement type " + r3.getClass());
    }
}
