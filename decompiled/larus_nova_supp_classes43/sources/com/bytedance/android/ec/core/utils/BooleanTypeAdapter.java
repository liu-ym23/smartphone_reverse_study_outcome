package com.bytedance.android.ec.core.utils;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BooleanTypeAdapter extends TypeAdapter<Boolean> {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            a = r0;
            r0[JsonToken.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[JsonToken.NULL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[JsonToken.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public BooleanTypeAdapter() {
    }

    public final Object read(JsonReader r10) throws IOException {
        JsonToken r0 = r10.peek();
        int r1 = a.a[r0.ordinal()];
        boolean r11 = true;
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L7;
        r10.nextNull();
        return null;
    L7:
        if (r1 != 3) goto L14;
        if (r10.nextInt() != 0) goto L18;
        r11 = false;
    L18:
        return Boolean.valueOf(r11);
    L14:
        throw new JsonParseException("Expected BOOLEAN or NUMBER but was " + r0);
    L17:
        return Boolean.valueOf(r10.nextBoolean());
    }

    public final void write(JsonWriter r1, Object r10) throws IOException {
        Boolean r11 = (Boolean) r10;
        if (r11 != null) goto L5;
        r1.nullValue();
        return;
    L5:
        r1.value(r11);
    }
}
