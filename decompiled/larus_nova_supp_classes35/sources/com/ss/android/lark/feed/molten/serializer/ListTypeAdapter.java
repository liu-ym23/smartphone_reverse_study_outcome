package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ListTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", BuildConfig.FLAVOR, "elementAdapter", "<init>", "(Lcom/google/gson/TypeAdapter;)V", "write", BuildConfig.FLAVOR, "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListTypeAdapter<T> extends TypeAdapter<List<? extends T>> {
    public final TypeAdapter<T> a;

    public ListTypeAdapter(TypeAdapter<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "elementAdapter");
        this.a = r2;
    }

    public final Object read(JsonReader r3) {
        Intrinsics.checkNotNullParameter(r3, "reader");
        if (r3.peek() != JsonToken.NULL) goto L5;
        r3.nextNull();
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        r3.beginArray();
    L7:
        if (r3.hasNext() == false) goto L11;
        Object r1 = this.a.read(r3);
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        r3.endArray();
        return r0;
    }

    public final void write(JsonWriter r3, Object r4) {
        List r5 = (List) r4;
        Intrinsics.checkNotNullParameter(r3, "out");
        if (r5 != null) goto L5;
        r3.nullValue();
        return;
    L5:
        r3.beginArray();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        T r0 = r6.next();
        this.a.write(r3, r0);
        goto L7
    L9:
        r3.endArray();
    }
}
