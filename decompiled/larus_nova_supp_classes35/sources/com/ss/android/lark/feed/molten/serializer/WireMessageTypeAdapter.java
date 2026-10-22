package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/WireMessageTypeAdapter;", "T", "Lcom/squareup/wire/Message;", "Lcom/google/gson/TypeAdapter;", "messageClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "write", BuildConfig.FLAVOR, "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Lcom/squareup/wire/Message;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Lcom/squareup/wire/Message;", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WireMessageTypeAdapter<T extends Message<?, ?>> extends TypeAdapter<T> {
    public final Class<T> a;

    public WireMessageTypeAdapter(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageClass");
        this.a = r2;
    }

    public final Object read(JsonReader r4) {
        Intrinsics.checkNotNullParameter(r4, "reader");
        if (r4.peek() != JsonToken.NULL) goto L5;
        r4.nextNull();
        return null;
    L5:
        String r5 = r4.nextString();
        ByteString.a r0 = ByteString.Companion;
        Intrinsics.checkNotNull(r5);
        r0.getClass();
        ByteString r6 = ByteString.a.a(r5);
        if (r6 == null) goto L13;
        byte[] r7 = r6.toByteArray();
        if (r7 == null) goto L14;
        int r1 = g.a;
        Class<T> r2 = this.a;
        Intrinsics.checkNotNullParameter(r2, "messageClass");
        Object r3 = r2.getField("ADAPTER").get(null);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.ss.android.lark.feed.molten.serializer.WireReflection.adapterOf>");
        return (Message) ((ProtoAdapter) r3).decode(r7);
    L14:
        return null;
    L13:
        return null;
    }

    public final void write(JsonWriter r3, Object r4) {
        Message r5 = (Message) r4;
        Intrinsics.checkNotNullParameter(r3, "out");
        if (r5 != null) goto L5;
        r3.nullValue();
        return;
    L5:
        int r0 = g.a;
        Class<T> r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "messageClass");
        Object r2 = r1.getField("ADAPTER").get(null);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.ss.android.lark.feed.molten.serializer.WireReflection.adapterOf>");
        byte[] r6 = ((ProtoAdapter) r2).encode(r5);
        ByteString.a r7 = ByteString.Companion;
        Intrinsics.checkNotNull(r6);
        r3.value(ByteString.a.e(r7, r6).base64());
    }
}
