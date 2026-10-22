package com.bytedance.android.live.browser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class UtilsKt {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(UtilsKt$JS_SAFE_ELEMENT_ADAPTER$2.INSTANCE);
    }

    public static final Object a(Object r1) {
        if ((r1 instanceof JSONObject) == false) goto L7;
        Object r0 = new ReadonlyJSONObjectMap((JSONObject) r1);
    L13:
        return r0;
    L7:
        if ((r1 instanceof JSONArray) == false) goto L10;
        r0 = new f0((JSONArray) r1);
        goto L13
    L10:
        if (Intrinsics.areEqual(r1, JSONObject.NULL) == false) goto L14;
        return null;
    L14:
        return r1;
    }

    public static final Object b(JsonElement r3) {
        if ((r3 instanceof JsonNull) == false) goto L6;
        return null;
    L6:
        if ((r3 instanceof JsonObject) == false) goto L9;
        return i((JsonObject) r3);
    L9:
        if ((r3 instanceof JsonArray) == false) goto L12;
        JsonArray r4 = (JsonArray) r3;
        Intrinsics.checkNotNullParameter(r4, "$this$toList");
        return new GsonList(r4);
    L12:
        if ((r3 instanceof JsonPrimitive) == false) goto L26;
        JsonPrimitive r5 = (JsonPrimitive) r3;
        if (r5.isNumber() == false) goto L17;
        return r5.getAsNumber();
    L17:
        if (r5.isString() == false) goto L20;
        return r5.getAsString();
    L20:
        if (r5.isBoolean() == false) goto L24;
        return Boolean.valueOf(r5.getAsBoolean());
    L24:
        throw new IllegalStateException("Unknown JsonPrimitive type: " + JsonPrimitive.class.getCanonicalName());
    L26:
        throw new IllegalStateException("Unknown JsonElement type: " + r3.getClass().getCanonicalName());
    }

    public static final void e(JsonArray r8) {
        int r0 = r8.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L36;
        JsonElement r3 = r8.get(r2);
        if (r3 == null) goto L33;
        if (r3.isJsonObject() == false) goto L11;
        f(r3.getAsJsonObject());
        goto L33
    L11:
        if (r3.isJsonArray() == false) goto L14;
        e(r3.getAsJsonArray());
        goto L33
    L14:
        if (r3.isJsonPrimitive() == false) goto L35;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L17
        Object r5 = Result.constructor-impl(Long.valueOf(r3.getAsLong()));     // Catch: Throwable -> L17
    L20:
        if (Result.isFailure-impl(r5) == false) goto L22;
        r5 = null;
    L22:
        Long r6 = (Long) r5;
        if (r6 == null) goto L33;
        long r7 = r6.longValue();
        if (r7 < Integer.MAX_VALUE) goto L27;
    L30:
        boolean r9 = true;
    L31:
        if (r9 == false) goto L33;
        r8.set(r2, new JsonPrimitive(String.valueOf(r7)));
        goto L33
    L27:
        if (r7 <= Integer.MIN_VALUE) goto L30;
        r9 = false;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L35:
        throw new RuntimeException("Unknown type of json: " + r3);
    L33:
        r2 = r2 + 1;
        goto L3
    }

    public static final void f(JsonObject r6) {
        Iterator r7 = SequencesKt.filter(CollectionsKt.asSequence(r6.entrySet()), UtilsKt$memberNumbersToString$1.INSTANCE).iterator();
    L4:
        if (r7.hasNext() == false) goto L24;
        Map.Entry r0 = (Map.Entry) r7.next();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.constructor-impl(Long.valueOf(((JsonElement) r0.getValue()).getAsLong()));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = null;
    L13:
        Long r3 = (Long) r2;
        if (r3 == null) goto L4;
        long r4 = r3.longValue();
        if (r4 < Integer.MAX_VALUE) goto L18;
    L21:
        boolean r5 = true;
    L22:
        if (r5 == false) goto L4;
        r0.setValue(new JsonPrimitive(String.valueOf(r4)));
        goto L4
    L18:
        if (r4 <= Integer.MIN_VALUE) goto L21;
        r5 = false;
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static final ReadonlyJSONObjectMap g(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toImmutableDelegatedMap");
        return new ReadonlyJSONObjectMap(r1);
    }

    public static final <T extends JsonElement> String h(T r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$toJsSafeString");
        StringWriter r0 = new StringWriter();
        JsonWriter r1 = new JsonWriter(r0);
        r1.setLenient(true);
        ((TypeAdapter) a.getValue()).write(r1, r3);
        return r0.toString();
    }

    public static final GsonMap i(JsonObject r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$toMap");
        return new GsonMap(r1);
    }

    public static final JSONArray c(JSONArray r4, JSONArray r5, JSONObject r6) {
        int r0 = r6.optInt("_length", -1);
        JSONObject r7 = r6.optJSONObject("_filter_keys");
        if (r0 <= (-1)) goto L5;
        int r1 = RangesKt.coerceAtMost(r0, r4.length());
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L23;
        Object r3 = r4.opt(r2);
        if ((r3 instanceof JSONObject) == false) goto L15;
        if (r7 != null) goto L12;
        Object r8 = (JSONObject) r3;
    L13:
        r5.put(r8);
    L22:
        r2 = r2 + 1;
        goto L7
    L12:
        JSONObject r9 = new JSONObject();
        d((JSONObject) r3, r9, r7);
        r8 = r9;
        goto L13
    L15:
        if ((r3 instanceof JSONArray) == false) goto L21;
        JSONArray r11 = (JSONArray) r3;
        if (r7 == null) goto L20;
        JSONArray r12 = new JSONArray();
        c(r11, r12, r7);
        r11 = r12;
    L20:
        r5.put(r11);
        goto L22
    L21:
        r5.put(r3);
        goto L22
    L23:
        return r5;
    L5:
        r1 = r4.length();
        goto L6
    }

    public static final JSONObject d(JSONObject r5, JSONObject r6, JSONObject r7) {
        Iterator<String> r0 = r7.keys();
    L4:
        if (r0.hasNext() == false) goto L20;
        String r1 = r0.next();
        Object r2 = r5.opt(r1);
        if ((r2 instanceof JSONObject) == true) goto L7;
        if ((r2 instanceof JSONArray) == true) goto L14;
        r6.put(r1, r2);
        goto L4
    L14:
        JSONObject r3 = r7.optJSONObject(r1);
        JSONArray r4 = (JSONArray) r2;
        if (r3 == null) goto L18;
        JSONArray r8 = new JSONArray();
        c(r4, r8, r3);
        r4 = r8;
    L18:
        r6.put(r1, r4);
        goto L4
    L7:
        JSONObject r9 = r7.optJSONObject(r1);
        JSONObject r11 = (JSONObject) r2;
        if (r9 == null) goto L11;
        JSONObject r12 = new JSONObject();
        d(r11, r12, r9);
        r11 = r12;
    L11:
        r6.put(r1, r11);
        goto L4
    L20:
        return r6;
    }
}
