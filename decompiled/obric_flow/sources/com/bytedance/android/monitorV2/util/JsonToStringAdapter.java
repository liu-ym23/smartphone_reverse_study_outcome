package com.bytedance.android.monitorV2.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import k5.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/util/JsonToStringAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class JsonToStringAdapter extends TypeAdapter<String> {
    public JsonToStringAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final String read(JsonReader r5) {
        Intrinsics.checkNotNullParameter(r5, "readIn");
        JsonToken r10 = r5.peek();
        if (r10 != null) goto L5;
        int r11 = -1;
    L7:
        if (r11 != 1) goto L9;
        r5.nextNull();
        return null;
    L9:
        if (r11 == 2) goto L16;
        JsonElement r12 = Streams.parse(r5);
        if (r12 != null) goto L13;
        return null;
    L13:
        return r12.toString();
    L16:
        return r5.nextString();
    L5:
        r11 = f.f18614a[r10.ordinal()];
        goto L7
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r5, String r10) {
        String r11 = r10;
        Intrinsics.checkNotNullParameter(r5, "out");
        if (r11 != null) goto L6;
        r5.nullValue();
        return;
    L6:
        JsonElement r12 = new JsonParser().parse(r11);
        TypeAdapters.JSON_ELEMENT.write(r5, r12);
    }
}
