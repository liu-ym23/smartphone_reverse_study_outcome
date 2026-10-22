package com.bytedance.pia.core.utils;

import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonWriter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7151a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonParser f7152b = null;

    static {
        f7151a = LazyKt.lazy(GsonUtils$gson$2.f7127a);
        f7152b = new JsonParser();
    }

    public static final Gson a() {
        return (Gson) f7151a.getValue();
    }

    public static final Object b(String r5) {
        Intrinsics.checkNotNullParameter(JSONObject.class, "type");
        if (r5.length() != 0) goto L14;
        return null;
    L14:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.m124constructorimpl(a().fromJson(r5, JSONObject.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m130isFailureimpl(r11) == false) goto L13;
        return null;
    L13:
        return r11;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final JSONArray c(JsonArray r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JSONArray r10 = new JSONArray();
        Iterator<JsonElement> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        JsonElement r12 = r11.next();
        if ((r12 instanceof JsonObject) == true) goto L7;
        if ((r12 instanceof JsonArray) == true) goto L10;
        if ((r12 instanceof JsonNull) == true) goto L13;
        if ((r12 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r13 = (JsonPrimitive) r12;
        if (r13.isBoolean() == true) goto L18;
        if (r13.isString() == true) goto L21;
        if (r13.isNumber() == false) goto L4;
        if (StringsKt.f(r13.getAsNumber().toString(), '.') == true) goto L26;
        r10.put(r13.getAsNumber().longValue());
        goto L4
    L26:
        r10.put(r13.getAsNumber().doubleValue());
        goto L4
    L21:
        r10.put(r13.getAsString());
        goto L4
    L18:
        r10.put(r13.getAsBoolean());
        goto L4
    L13:
        r10.put(JSONObject.NULL);
        goto L4
    L10:
        r10.put(c((JsonArray) r12));
        goto L4
    L7:
        r10.put(d((JsonObject) r12));
        goto L4
    L28:
        return r10;
    }

    public static final JSONObject d(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        JSONObject r10 = new JSONObject();
        Iterator<T> r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        JsonElement r14 = (JsonElement) r12.getValue();
        if ((r14 instanceof JsonObject) == true) goto L7;
        if ((r14 instanceof JsonArray) == true) goto L10;
        if ((r14 instanceof JsonNull) == true) goto L13;
        if ((r14 instanceof JsonPrimitive) == false) goto L4;
        JsonPrimitive r15 = (JsonPrimitive) r14;
        if (r15.isBoolean() == true) goto L18;
        if (r15.isString() == true) goto L21;
        if (r15.isNumber() == false) goto L4;
        if (StringsKt.f(r15.getAsNumber().toString(), '.') == true) goto L26;
        r10.put(r13, r15.getAsNumber().longValue());
        goto L4
    L26:
        r10.put(r13, r15.getAsNumber().doubleValue());
        goto L4
    L21:
        r10.put(r13, r15.getAsString());
        goto L4
    L18:
        r10.put(r13, r15.getAsBoolean());
        goto L4
    L13:
        r10.put(r13, JSONObject.NULL);
        goto L4
    L10:
        r10.put(r13, c((JsonArray) r14));
        goto L4
    L7:
        r10.put(r13, d((JsonObject) r14));
        goto L4
    L28:
        return r10;
    }

    public static void e(JsonWriter r5, Object r10) {
        if ((r10 instanceof Boolean) == false) goto L7;
        r5.value(((Boolean) r10).booleanValue());
        return;
    L7:
        if ((r10 instanceof Number) == false) goto L11;
        r5.value((Number) r10);
        return;
    L11:
        if ((r10 instanceof String) == false) goto L15;
        r5.value((String) r10);
        return;
    L15:
        if ((r10 instanceof JSONObject) == false) goto L23;
        JSONObject r11 = (JSONObject) r10;
        r5.beginObject();
        Iterator<String> r12 = r11.keys();
    L18:
        if (r12.hasNext() == false) goto L20;
        String r13 = r12.next();
        r5.name(r13);
        e(r5, r11.opt(r13));
        goto L18
    L20:
        r5.endObject();
        return;
    L23:
        if ((r10 instanceof JSONArray) == false) goto L26;
        f(r5, (JSONArray) r10);
        return;
    L26:
        r5.nullValue();
    }

    public static void f(JsonWriter r5, JSONArray r10) {
        r5.beginArray();
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        e(r5, r10.opt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        r5.endArray();
    }

    public static void g(JSONObject r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L21
        Iterator<String> r12 = r10.keys();     // Catch: Throwable -> L21
    L5:
        if (r12.hasNext() == false) goto L23;
        String r13 = r12.next();     // Catch: Throwable -> L21
        Object r14 = r10.get(r13);     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L21
        Intrinsics.checkNotNullParameter(r13, STGroup.DICT_KEY);     // Catch: Throwable -> L21
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
        if (r14 == null) goto L12;
        JSONObject r16 = r5.put(r13, r14);     // Catch: Throwable -> L10
    L13:
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L10
    L17:
        if (Result.m127exceptionOrNullimpl(r17) == null) goto L20;
        r17 = new JSONObject();     // Catch: Throwable -> L21
    L20:
        JSONObject r18 = (JSONObject) r17;     // Catch: Throwable -> L21
        goto L5
    L12:
        r16 = r5;
        goto L13
    L10:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L21
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L21
        goto L17
    L23:
        Object r20 = Result.m124constructorimpl(r5);     // Catch: Throwable -> L21
    L27:
        if (Result.m127exceptionOrNullimpl(r20) == null) goto L30;
        r20 = new JSONObject();
    L30:
        JSONObject r21 = (JSONObject) r20;
        return;
    L21:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
