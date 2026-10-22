package com.bytedance.android.live.browser.jsbridge;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/JsFloatTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class JsFloatTypeAdapter extends TypeAdapter<Float> {
    public JsFloatTypeAdapter() {
    }

    public final Object read(JsonReader r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        JsonToken r0 = r4.peek();
        if (r0 == null) goto L12;
        int r1 = n.a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L12;
        r4.nextNull();
        return null;
    L10:
        return Float.valueOf((float) r4.nextDouble());
    L12:
        throw new JsonParseException("Expected NUMBER but was " + r0);
    }

    public final void write(JsonWriter r2, Object r3) {
        Float r4 = (Float) r3;
        Intrinsics.checkNotNullParameter(r2, "writer");
        if (r4 != null) goto L6;
        r2.nullValue();
        return;
    L6:
        if (Intrinsics.areEqual(r4, 0.0f) == false) goto L8;
        r2.value(r4);
        return;
    L8:
        r2.value(String.valueOf(r4.floatValue()));
    }
}
