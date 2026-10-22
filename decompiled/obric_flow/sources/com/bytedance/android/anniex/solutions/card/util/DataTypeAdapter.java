package com.bytedance.android.anniex.solutions.card.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import m4.a;

/* JADX INFO: loaded from: classes2.dex */
public class DataTypeAdapter extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeAdapter f3462a;

    public DataTypeAdapter() {
        this.f3462a = new Gson().getAdapter(Object.class);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object read(JsonReader r5) {
        switch(a.f19979a[r5.peek().ordinal()]) {
            case 1: goto L31;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        r5.nextNull();
        return null;
    L10:
        double r10 = r5.nextDouble();
        if (r10 > 9.223372036854776E18d) goto L13;
        long r11 = (long) r10;
        if (r10 != r11) goto L22;
        return Integer.valueOf((int) r11);
    L20:
        return Long.valueOf(r11);
    L22:
        return Double.valueOf(r10);
    L13:
        return Double.valueOf(r10);
    L25:
        LinkedTreeMap r12 = new LinkedTreeMap();
        r5.beginObject();
    L27:
        if (r5.hasNext() == false) goto L29;
        r12.put(r5.nextName(), read(r5));
        goto L27
    L29:
        r5.endObject();
        return r12;
    L31:
        ArrayList r13 = new ArrayList();
        r5.beginArray();
    L33:
        if (r5.hasNext() == false) goto L35;
        r13.add(read(r5));
        goto L33
    L35:
        r5.endArray();
        return r13;
    L5:
        throw new IllegalStateException();
    L9:
        return Boolean.valueOf(r5.nextBoolean());
    L24:
        return r5.nextString();
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter r5, Object r10) {
        this.f3462a.write(r5, r10);
    }
}
