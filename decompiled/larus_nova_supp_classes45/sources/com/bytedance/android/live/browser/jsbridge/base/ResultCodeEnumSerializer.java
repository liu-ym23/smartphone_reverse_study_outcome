package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import kotlin.Metadata;
import w20.z9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ResultCodeEnumSerializer;", "Lcom/google/gson/JsonSerializer;", "Lw20/z9;", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResultCodeEnumSerializer implements JsonSerializer<z9> {
    public ResultCodeEnumSerializer() {
    }

    public final JsonElement serialize(Object r1, Type r2, JsonSerializationContext r3) {
        z9 r4 = (z9) r1;
        if (r4 == null) goto L5;
        Integer r5 = Integer.valueOf(r4.getCode());
    L7:
        return new JsonPrimitive(r5);
    L5:
        r5 = null;
        goto L7
    }
}
