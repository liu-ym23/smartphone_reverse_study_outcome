package com.bytedance.android.live.revenue.platform.container.impl;

import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/container/impl/JsLongTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "<init>", "()V", "live-kmp-platform-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class JsLongTypeAdapter extends TypeAdapter<Long> {
    public JsLongTypeAdapter() {
    }

    public final Object read(JsonReader r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        JsonToken r0 = r4.peek();
        if (r0 == null) goto L12;
        int r1 = x.a[r0.ordinal()];
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L12;
        r4.nextNull();
        return null;
    L10:
        return Long.valueOf(r4.nextLong());
    L12:
        throw new JsonParseException("Expected NUMBER but was " + r0);
    }

    public final void write(JsonWriter r6, Object r7) {
        Long r8 = (Long) r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        if (r8 != null) goto L6;
        r6.nullValue();
        return;
    L6:
        if (r8.longValue() <= Integer.MAX_VALUE) goto L8;
    L10:
        r6.value(String.valueOf(r8.longValue()));
        return;
    L8:
        if (r8.longValue() < (-2147483647)) goto L10;
        r6.value(r8.longValue());
    }
}
