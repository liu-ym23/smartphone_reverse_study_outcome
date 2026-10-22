package com.bytedance.geckox.gson;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import oa.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/geckox/gson/BooleanTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class BooleanTypeAdapter extends TypeAdapter<Boolean> {
    public BooleanTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public final Boolean read(JsonReader r5) {
        JsonToken r10 = r5.peek();
        if (r10 == null) goto L21;
        int r11 = a.f20420a[r10.ordinal()];
        boolean r12 = true;
        if (r11 == 1) goto L19;
        if (r11 != 2) goto L9;
        r5.nextNull();
        return null;
    L9:
        if (r11 != 3) goto L21;
        if (r5.nextInt() != 0) goto L15;
        r12 = false;
    L15:
        return Boolean.valueOf(r12);
    L19:
        return Boolean.valueOf(r5.nextBoolean());
    L21:
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r10);
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r5, Boolean r10) {
        Boolean r11 = r10;
        if (r11 != null) goto L6;
        r5.nullValue();
        return;
    L6:
        r5.value(r11.booleanValue());
    }
}
