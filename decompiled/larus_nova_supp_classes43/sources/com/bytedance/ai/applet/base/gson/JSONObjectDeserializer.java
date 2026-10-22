package com.bytedance.ai.applet.base.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/JSONObjectDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lorg/json/JSONObject;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSONObjectDeserializer implements JsonDeserializer<JSONObject> {
    public JSONObjectDeserializer() {
    }

    public final Object deserialize(JsonElement r1, Type r10, JsonDeserializationContext r11) {
        if (r1 != null) goto L9;
    L7:
        return null;
    L9:
        return new JSONObject(r1.getAsJsonObject().toString());
    L5:
        e = move-exception;
        com.bytedance.ai.applet.base.log.a.b("JSONObjectDeserializer", "JSONObject deserialize fail", e);
        goto L7
    }
}
