package com.bytedance.ai.applet.base.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.json.JSONObject;
import z0.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/JSONObjectSerializer;", "Lcom/google/gson/JsonSerializer;", "Lorg/json/JSONObject;", "<init>", "()V", "applet-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JSONObjectSerializer implements JsonSerializer<JSONObject> {
    public JSONObjectSerializer() {
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(JSONObject r5, Type r10, JsonSerializationContext r11) {
        JSONObject r12 = r5;
        if (r12 == null) goto L7;
        return c.b(r12);
    L7:
        return new JsonObject();
    }
}
