package com.bytedance.android.live.core.setting.v2.helper;

import a70.b;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {
    public MapDeserializerDoubleAsIntFix() {
    }

    public final Object a(JsonElement r6) {
        if (r6.isJsonArray() == false) goto L12;
        ArrayList r0 = new ArrayList();
        JsonArray r7 = r6.getAsJsonArray();
        if (r7 == null) goto L10;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        r0.add(a((JsonElement) r8.next()));
    L10:
        return r0;
    L12:
        if (r6.isJsonObject() == false) goto L21;
        LinkedTreeMap r1 = new LinkedTreeMap();
        JsonObject r9 = r6.getAsJsonObject();
        if (r9 == null) goto L19;
        Iterator r11 = r9.entrySet().iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        Map.Entry r2 = (Map.Entry) r11.next();
        r1.put((String) r2.getKey(), a((JsonElement) r2.getValue()));
    L19:
        return r1;
    L21:
        if (r6.isJsonPrimitive() == false) goto L49;
        JsonPrimitive r12 = r6.getAsJsonPrimitive();
        if (r12.isBoolean() == false) goto L27;
        return Boolean.valueOf(r12.getAsBoolean());
    L27:
        if (r12.isString() == false) goto L31;
        return r12.getAsString();
    L31:
        if (r12.isNumber() == false) goto L53;
        Number r13 = r12.getAsNumber();
        if (Math.ceil(r13.doubleValue()) != r13.longValue()) goto L48;
        if (r13.floatValue() >= 0.0f) goto L46;
        if ((r13 instanceof LazilyParsedNumber) == true) goto L39;
    L41:
        boolean r3 = false;
    L42:
        if (r3 == false) goto L46;
        b.e("_GSON", "isFloat num= " + r13);
        return Double.valueOf(r13.doubleValue());
    L39:
        if (new BigDecimal(r13.toString()).scale() <= 0) goto L41;
        r3 = true;
    L46:
        return Long.valueOf(r13.longValue());
    L48:
        return Double.valueOf(r13.doubleValue());
    L53:
        return null;
    L49:
        return null;
    }

    public final Object deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) throws JsonParseException {
        Object r4 = a(r1);
        if (r4 != null) goto L7;
        return null;
    L7:
        return (Map) r4;
    }
}
