package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.WireEnum;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0012\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/WireEnumTypeAdapter;", "E", BuildConfig.FLAVOR, "Lcom/squareup/wire/WireEnum;", "Lcom/google/gson/TypeAdapter;", "enumClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "write", BuildConfig.FLAVOR, "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Enum;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Enum;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WireEnumTypeAdapter<E extends Enum<E> & WireEnum> extends TypeAdapter<E> {
    public final Class<E> a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            r0[JsonToken.STRING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public WireEnumTypeAdapter(Class<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "enumClass");
        this.a = r2;
    }

    public final Object read(JsonReader r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        if (r3.peek() != JsonToken.NULL) goto L5;
        r3.nextNull();
    L15:
        return null;
    L5:
        JsonToken r0 = r3.peek();
        if (r0 != null) goto L8;
        int r1 = -1;
    L10:
        if (r1 != 1) goto L12;
        Integer r4 = StringsKt.toIntOrNull(r3.nextString());
    L13:
        if (r4 == null) goto L15;
        int r5 = r4.intValue();
        int r2 = g.a;
        return (Enum) g.a(this.a, r5);
    L12:
        r4 = Integer.valueOf(r3.nextInt());
        goto L13
    L8:
        r1 = a.a[r0.ordinal()];
        goto L10
    }

    public final void write(JsonWriter r2, Object r3) {
        WireEnum r4 = (Enum) r3;
        Intrinsics.checkNotNullParameter(r2, "out");
        if (r4 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        r2.value(Integer.valueOf(r4.getValue()));
    }
}
