package com.bytedance.android.ad.sdk.utils;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import u6.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ad/sdk/utils/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "runtime-api_release"}, k = 1, mv = {1, 4, 0})
public final class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    public final Object read(JsonReader r10) {
        JsonToken r0 = r10.peek();
        if (r0 == null) goto L9;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        r10.nextNull();
    L14:
        return null;
    L8:
        if (r1 != 2) goto L9;
        return r10.nextString();
    L9:
        JsonElement r11 = Streams.parse(r10);
        if (r11 == null) goto L14;
        return r11.toString();
    }

    public final void write(JsonWriter r10, Object r11) {
        String r12 = (String) r11;
        if (r12 != null) goto L5;
        r10.nullValue();
        return;
    L5:
        JsonElement r13 = GsonProtectorUtils.parse(new JsonParser(), r12);
        TypeAdapters.JSON_ELEMENT.write(r10, r13);
    }
}
