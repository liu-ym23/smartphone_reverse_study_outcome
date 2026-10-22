package com.bytedance.android.anniex.solutions.card.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class DataTypeAdapter extends TypeAdapter<Object> {
    public final TypeAdapter<Object> a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            a = r0;
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public DataTypeAdapter() {
        this.a = new Gson().getAdapter(Object.class);
    }

    public final Object read(JsonReader r10) throws IOException {
        switch(a.a[r10.peek().ordinal()]) {
            case 1: goto L31;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r10.nextNull();
        return null;
    L10:
        double r0 = r10.nextDouble();
        if (r0 > 9.223372036854776E18d) goto L13;
        long r11 = (long) r0;
        if (r0 != r11) goto L22;
        return Integer.valueOf((int) r11);
    L20:
        return Long.valueOf(r11);
    L22:
        return Double.valueOf(r0);
    L13:
        return Double.valueOf(r0);
    L25:
        LinkedTreeMap r1 = new LinkedTreeMap();
        r10.beginObject();
    L27:
        if (r10.hasNext() == false) goto L29;
        r1.put(r10.nextName(), read(r10));
        goto L27
    L29:
        r10.endObject();
        return r1;
    L31:
        ArrayList r12 = new ArrayList();
        r10.beginArray();
    L33:
        if (r10.hasNext() == false) goto L35;
        r12.add(read(r10));
        goto L33
    L35:
        r10.endArray();
        return r12;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r10.nextBoolean());
    L24:
        return r10.nextString();
    }

    public final void write(JsonWriter r10, Object r11) throws IOException {
        this.a.write(r10, r11);
    }
}
