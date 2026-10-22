package com.bytedance.android.live.gson;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    public final Object read(JsonReader r1) throws IOException {
        JsonElement r2 = Streams.parse(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.toString();
    }

    public final void write(JsonWriter r2, Object r3) throws IOException {
        JsonParser r0 = new JsonParser();
        JsonElement r4 = GsonProtectorUtils.parse(r0, (String) r3);
        TypeAdapters.JSON_ELEMENT.write(r2, r4);
    }
}
