package com.bytedance.android.ec.core.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/core/utils/JSONArrayAdapter;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONArray;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JSONArrayAdapter implements JsonSerializer<JSONArray>, JsonDeserializer<JSONArray> {

    public static final class a {
    }

    public JSONArrayAdapter() {
    }

    static {
        new JSONArrayAdapter();
    }

    public final Object deserialize(JsonElement r1, Type r10, JsonDeserializationContext r11) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return new JSONArray(r1.toString());
    L7:
        e = move-exception;
        throw new JsonParseException(e);
    }

    public final JsonElement serialize(Object r10, Type r11, JsonSerializationContext r12) {
        JSONArray r13 = (JSONArray) r10;
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r13 != null) goto L5;
        return null;
    L5:
        JsonArray r14 = new JsonArray();
        int r0 = r13.length();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L9;
        Object r15 = r13.opt(r1);
        r14.add(r12.serialize(r15, r15.getClass()));
        r1 = r1 + 1;
        goto L6
    L9:
        return r14;
    }
}
