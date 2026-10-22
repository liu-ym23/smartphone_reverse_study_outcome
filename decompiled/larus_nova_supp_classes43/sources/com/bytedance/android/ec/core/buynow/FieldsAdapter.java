package com.bytedance.android.ec.core.buynow;

import com.bytedance.android.ec.core.utils.t0;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/buynow/FieldsAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FieldsAdapter extends TypeAdapter<Object> {
    public final TypeAdapter<Object> a;

    public FieldsAdapter() {
        int r0 = t0.a;
        this.a = t0.a.a.getAdapter(Object.class);
    }

    public final Object read(JsonReader r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "in");
        JsonToken r0 = r10.peek();
        if (r0 != null) goto L6;
    L39:
        return null;
    L6:
        switch(c.a[r0.ordinal()]) {
            case 1: goto L33;
            case 2: goto L28;
            case 3: goto L47;
            case 4: goto L10;
            case 5: goto L43;
            case 6: goto L8;
            default: goto L39;
        };
    L8:
        r10.nextNull();
        goto L39
    L10:
        double r1 = r10.nextDouble();
        if (r1 > Long.MAX_VALUE) goto L26;
        if (r1 < Long.MIN_VALUE) goto L26;
        long r11 = (long) r1;
        if (r1 != r11) goto L46;
        if (r11 > Integer.MAX_VALUE) goto L45;
        if (r11 < Integer.MIN_VALUE) goto L45;
        return Integer.valueOf((int) r11);
    L45:
        return Long.valueOf(r11);
    L46:
        return Double.valueOf(r1);
    L26:
        return Double.valueOf(r1);
    L28:
        LinkedTreeMap r12 = new LinkedTreeMap();
        r10.beginObject();
    L30:
        if (r10.hasNext() == false) goto L32;
        r12.put(r10.nextName(), read(r10));
        goto L30
    L32:
        r10.endObject();
    L48:
        return r12;
    L33:
        r12 = new ArrayList();
        r10.beginArray();
    L35:
        if (r10.hasNext() == false) goto L37;
        r12.add(read(r10));
        goto L35
    L37:
        r10.endArray();
        goto L48
    L43:
        return Boolean.valueOf(r10.nextBoolean());
    L47:
        return r10.nextString();
    }

    public final void write(JsonWriter r10, Object r11) throws IOException {
        this.a.write(r10, r11);
    }
}
