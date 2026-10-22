package com.bytedance.ai.applet.base.gson;

import a1.a;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/JSONObjectDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lorg/json/JSONObject;", "<init>", "()V", "applet-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JSONObjectDeserializer implements JsonDeserializer<JSONObject> {
    public JSONObjectDeserializer() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final JSONObject deserialize(JsonElement r5, Type r10, JsonDeserializationContext r11) {
        if (r5 != null) goto L9;
    L8:
        return null;
    L9:
        return new JSONObject(r5.getAsJsonObject().toString());
    L6:
        e = move-exception;
        Intrinsics.checkNotNullParameter("JSONObjectDeserializer", "tag");
        Intrinsics.checkNotNullParameter("JSONObject deserialize fail", "msg");
        a.f43a.e("JSONObjectDeserializer", "JSONObject deserialize fail", e);
        goto L8
    }
}
