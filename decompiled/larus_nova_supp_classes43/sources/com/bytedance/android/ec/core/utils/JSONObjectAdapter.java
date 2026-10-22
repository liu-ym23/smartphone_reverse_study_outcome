package com.bytedance.android.ec.core.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/utils/JSONObjectAdapter;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONObject;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JSONObjectAdapter implements JsonSerializer<JSONObject>, JsonDeserializer<JSONObject> {
    public JSONObjectAdapter() {
    }

    public final Object deserialize(JsonElement r1, Type r10, JsonDeserializationContext r11) {
        if (r1 != null) goto L9;
        return null;
    L9:
        return tv5.a.c(r1);
    L6:
        e = move-exception;
        throw new JsonParseException(e);
    }

    public final JsonElement serialize(Object r10, Type r11, JsonSerializationContext r12) {
        JSONObject r13 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "context");
        if (r13 != null) goto L5;
        return null;
    L5:
        JsonObject r14 = new JsonObject();
        Iterator<String> r0 = r13.keys();
    L7:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        Object r15 = r13.opt(r1);
        r14.add(r1, r12.serialize(r15, r15.getClass()));
        goto L7
    L10:
        return r14;
    }
}
