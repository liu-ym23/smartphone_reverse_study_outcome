package com.bytedance.ai.applet.base.gson;

import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/applet/base/gson/ByteArrayTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "Companion", "applet-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ByteArrayTypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public ByteArrayTypeAdapter() {
    }

    public final Object deserialize(JsonElement r1, Type r10, JsonDeserializationContext r11) {
        if ((r1 instanceof JsonPrimitive) == false) goto L11;
        JsonPrimitive r12 = (JsonPrimitive) r1;
        if (r12.isString() == false) goto L9;
        String r13 = r12.getAsString();
        Intrinsics.checkNotNull(r13);
        return Base64.decode(r13, 2);
    L9:
        throw new JsonParseException("ByteArray base64: value not a string");
    L11:
        throw new JsonParseException("ByteArray base64: expected string");
    }

    public final JsonElement serialize(Object r1, Type r10, JsonSerializationContext r11) {
        byte[] r12 = (byte[]) r1;
        if (r12 != null) goto L5;
        r12 = new byte[0];
    L5:
        Intrinsics.checkNotNullParameter(r12, "bytes");
        Intrinsics.checkNotNullParameter(r12, "bytes");
        return new JsonPrimitive(Base64.encodeToString(r12, 2));
    }
}
