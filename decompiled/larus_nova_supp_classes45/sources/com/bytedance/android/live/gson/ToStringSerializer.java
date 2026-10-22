package com.bytedance.android.live.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class ToStringSerializer implements JsonSerializer<Object> {
    public ToStringSerializer() {
    }

    public JsonElement serialize(Object r1, Type r2, JsonSerializationContext r3) {
        if (r1 == null) goto L6;
        return r3.serialize(r1.toString());
    L6:
        return r3.serialize(null);
    }
}
