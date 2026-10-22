package com.ss.android.lark.chameleon.util;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/util/IntTypeAdapter;", "Lcom/google/gson/TypeAdapter;", BuildConfig.FLAVOR, "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", BuildConfig.FLAVOR, "out", "Lcom/google/gson/stream/JsonWriter;", "value", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntTypeAdapter extends TypeAdapter<Number> {
    public IntTypeAdapter() {
    }

    public Number read(JsonReader r4) {
        if (r4 == null) goto L5;
        JsonToken r1 = r4.peek();
    L7:
        if (r1 != JsonToken.NULL) goto L10;
        r4.nextNull();
        return null;
    L10:
        if (r4 != null) goto L22;
        String r2 = null;
    L14:
        if (r2 == null) goto L24;
        return Integer.valueOf(CastIntegerProtector.parseInt(r2));
    L17:
        if (r4 == null) goto L25;
        String r5 = r4.nextString();
        if (r5 != null) goto L21;
        return null;
    L21:
        return Long.valueOf(CastLongProtector.parseLong(r5));
    L25:
        return null;
    L24:
        return null;
    L22:
        r2 = r4.nextString();     // Catch: NumberFormatException -> L12
        goto L14
    L5:
        r1 = null;
        goto L7
    }

    /* JADX INFO: renamed from: read, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8read(JsonReader r1) {
        return read(r1);
    }

    public void write(JsonWriter r1, Number r2) {
        if (r1 == null) goto L5;
        r1.value(r2);
        return;
    }

    public /* bridge */ /* synthetic */ void write(JsonWriter r1, Object r2) {
        write(r1, (Number) r2);
    }
}
