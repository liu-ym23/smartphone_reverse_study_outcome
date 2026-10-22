package com.bytedance.android.annie.bridge.method.abs;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import e7.j0;
import java.lang.reflect.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/ResultCodeEnumSerializer;", "Lcom/google/gson/JsonSerializer;", "Le7/j0;", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ResultCodeEnumSerializer implements JsonSerializer<j0> {
    public ResultCodeEnumSerializer() {
    }

    public final JsonElement serialize(Object r1, Type r10, JsonSerializationContext r11) {
        j0 r12 = (j0) r1;
        if (r12 == null) goto L5;
        Integer r13 = Integer.valueOf(r12.getCode());
    L7:
        return new JsonPrimitive(r13);
    L5:
        r13 = null;
        goto L7
    }
}
