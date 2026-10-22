package com.bytedance.ai.model.objects;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/model/objects/ChatConfigStringAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatConfigStringAdapter implements JsonSerializer<String>, JsonDeserializer<String> {
    public ChatConfigStringAdapter() {
    }

    public final Object deserialize(JsonElement r1, Type r10, JsonDeserializationContext r11) {
        if (r1 != null) goto L4;
    L12:
        return null;
    L4:
        if (r1.isJsonNull() == true) goto L12;
        if (r1.isJsonPrimitive() == false) goto L15;
        if (r1.getAsJsonPrimitive().isString() == false) goto L15;
        return r1.getAsString();
    L15:
        return r1.toString();
    }

    public final JsonElement serialize(Object r1, Type r10, JsonSerializationContext r11) {
        String r12 = (String) r1;
        if (r12 == null) goto L6;
        return new JsonPrimitive(r12);
    L6:
        return JsonNull.INSTANCE;
    }
}
