package com.bytedance.android.annie.param;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class UtilsKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(UtilsKt$JS_SAFE_ELEMENT_ADAPTER$2.INSTANCE);
    }

    public static final Object a(JsonElement r10) {
        if ((r10 instanceof JsonNull) == false) goto L6;
        return null;
    L6:
        if ((r10 instanceof JsonObject) == false) goto L10;
        JsonObject r11 = (JsonObject) r10;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Object r0 = new JsGsonMap(r11);
    L31:
        return r0;
    L10:
        if ((r10 instanceof JsonArray) == false) goto L13;
        JsonArray r12 = (JsonArray) r10;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r0 = new GsonList(r12);
        goto L31
    L13:
        if ((r10 instanceof JsonPrimitive) == false) goto L29;
        JsonPrimitive r1 = (JsonPrimitive) r10;
        if (r1.isNumber() == false) goto L20;
        Number r13 = r1.getAsNumber();
        if ((r13 instanceof LazilyParsedNumber) == true) goto L33;
        return r13;
    L33:
        return Double.valueOf(r13.doubleValue());
    L20:
        if (r1.isString() == false) goto L23;
        return r1.getAsString();
    L23:
        if (r1.isBoolean() == false) goto L27;
        return Boolean.valueOf(r1.getAsBoolean());
    L27:
        throw new IllegalStateException("Unknown JsonPrimitive type: " + r10.getClass().getCanonicalName());
    L29:
        throw new IllegalStateException("Unknown JsonElement type: " + r10.getClass().getCanonicalName());
    }

    public static final Object b(Object r1) {
        if ((r1 instanceof JSONObject) == false) goto L7;
        Object r0 = new ReadonlyJSONObjectMap((JSONObject) r1);
    L13:
        return r0;
    L7:
        if ((r1 instanceof JSONArray) == false) goto L10;
        r0 = new o((JSONArray) r1);
        goto L13
    L10:
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L14;
        return null;
    L14:
        return r1;
    }

    public static final Object c(JsonElement r10) {
        if ((r10 instanceof JsonNull) == false) goto L6;
        return null;
    L6:
        if ((r10 instanceof JsonObject) == false) goto L9;
        return i((JsonObject) r10);
    L9:
        if ((r10 instanceof JsonArray) == false) goto L12;
        JsonArray r11 = (JsonArray) r10;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        return new GsonList(r11);
    L12:
        if ((r10 instanceof JsonPrimitive) == false) goto L26;
        JsonPrimitive r0 = (JsonPrimitive) r10;
        if (r0.isNumber() == false) goto L17;
        return r0.getAsNumber();
    L17:
        if (r0.isString() == false) goto L20;
        return r0.getAsString();
    L20:
        if (r0.isBoolean() == false) goto L24;
        return Boolean.valueOf(r0.getAsBoolean());
    L24:
        throw new IllegalStateException("Unknown JsonPrimitive type: " + r10.getClass().getCanonicalName());
    L26:
        throw new IllegalStateException("Unknown JsonElement type: " + r10.getClass().getCanonicalName());
    }

    public static final void f(JsonArray r10) {
        int r0 = r10.size();
        int r11 = 0;
    L3:
        if (r11 >= r0) goto L36;
        JsonElement r12 = r10.get(r11);
        if (r12 == null) goto L33;
        if (r12.isJsonObject() == false) goto L11;
        g(r12.getAsJsonObject());
        goto L33
    L11:
        if (r12.isJsonArray() == false) goto L14;
        f(r12.getAsJsonArray());
        goto L33
    L14:
        if (r12.isJsonPrimitive() == false) goto L35;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L17
        Object r14 = Result.constructor-impl(Long.valueOf(r12.getAsLong()));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r14) == false) goto L22;
        r14 = null;
    L22:
        Long r15 = (Long) r14;
        if (r15 == null) goto L33;
        long r16 = r15.longValue();
        if (r16 < Integer.MAX_VALUE) goto L27;
    L30:
        boolean r17 = true;
    L31:
        if (r17 == false) goto L33;
        r10.set(r11, new JsonPrimitive(String.valueOf(r16)));
        goto L33
    L27:
        if (r16 <= Integer.MIN_VALUE) goto L30;
        r17 = false;
    L17:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L35:
        throw new RuntimeException("Unknown type of json: " + r12);
    L33:
        r11 = r11 + 1;
        goto L3
    }

    public static final void g(JsonObject r10) {
        Iterator r11 = SequencesKt.filter(CollectionsKt.asSequence(r10.entrySet()), UtilsKt$memberNumbersToString$1.INSTANCE).iterator();
    L4:
        if (r11.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) r11.next();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r12 = Result.constructor-impl(Long.valueOf(((JsonElement) r0.getValue()).getAsLong()));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r12) == false) goto L13;
        r12 = null;
    L13:
        Long r13 = (Long) r12;
        if (r13 == null) goto L4;
        long r14 = r13.longValue();
        if (r14 < Integer.MAX_VALUE) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == false) goto L4;
        r0.setValue(new JsonPrimitive(String.valueOf(r14)));
        goto L4
    L18:
        if (r14 <= Integer.MIN_VALUE) goto L21;
        r15 = false;
    L8:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final <T extends JsonElement> String h(T r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        StringWriter r0 = new StringWriter();
        JsonWriter r1 = new JsonWriter(r0);
        r1.setLenient(true);
        ((TypeAdapter) a.getValue()).write(r1, r10);
        return r0.toString();
    }

    public static final GsonMap i(JsonObject r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new GsonMap(r1);
    }

    public static final JSONArray d(JSONArray r10, JSONArray r11, JSONObject r12) {
        int r0 = r12.optInt("_length", -1);
        JSONObject r13 = r12.optJSONObject("_filter_keys");
        if (r0 <= (-1)) goto L5;
        int r1 = RangesKt.coerceAtMost(r0, r10.length());
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r1) goto L23;
        Object r15 = r10.opt(r14);
        if ((r15 instanceof JSONObject) == false) goto L15;
        if (r13 != null) goto L12;
        Object r16 = (JSONObject) r15;
    L13:
        r11.put(r16);
    L22:
        r14 = r14 + 1;
        goto L7
    L12:
        JSONObject r17 = new JSONObject();
        e((JSONObject) r15, r17, r13);
        r16 = r17;
        goto L13
    L15:
        if ((r15 instanceof JSONArray) == false) goto L21;
        JSONArray r18 = (JSONArray) r15;
        if (r13 == null) goto L20;
        JSONArray r19 = new JSONArray();
        d(r18, r19, r13);
        r18 = r19;
    L20:
        r11.put(r18);
        goto L22
    L21:
        r11.put(r15);
        goto L22
    L23:
        return r11;
    L5:
        r1 = r10.length();
        goto L6
    }

    public static final JSONObject e(JSONObject r10, JSONObject r11, JSONObject r12) {
        Iterator<String> r0 = r12.keys();
    L4:
        if (r0.hasNext() == false) goto L20;
        String r1 = r0.next();
        Object r13 = r10.opt(r1);
        if ((r13 instanceof JSONObject) == true) goto L7;
        if ((r13 instanceof JSONArray) == true) goto L14;
        r11.put(r1, r13);
        goto L4
    L14:
        JSONObject r14 = r12.optJSONObject(r1);
        JSONArray r15 = (JSONArray) r13;
        if (r14 == null) goto L18;
        JSONArray r16 = new JSONArray();
        d(r15, r16, r14);
        r15 = r16;
    L18:
        r11.put(r1, r15);
        goto L4
    L7:
        JSONObject r17 = r12.optJSONObject(r1);
        JSONObject r18 = (JSONObject) r13;
        if (r17 == null) goto L11;
        JSONObject r19 = new JSONObject();
        e(r18, r19, r17);
        r18 = r19;
    L11:
        r11.put(r1, r18);
        goto L4
    L20:
        return r11;
    }
}
