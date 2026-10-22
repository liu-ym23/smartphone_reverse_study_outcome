package com.squareup.wire;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import f4.b;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class DefaultValueMessageTypeAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends TypeAdapter<M> {
    private static final BigInteger POWER_64 = null;
    private final M defaultValue;
    private final Map<String, FieldBinding<M, B>> fieldBindings;
    private final Gson gson;
    private final WireDeserializeErrorListener listener;
    private final RuntimeMessageAdapter<M, B> messageAdapter;
    private final String path;
    private final TypeToken<M> type;

    static {
        POWER_64 = new BigInteger("18446744073709551616");
    }

    public DefaultValueMessageTypeAdapter(Gson r5, TypeToken<M> r10, String r11, M r12, WireDeserializeErrorListener r13) {
        this.gson = r5;
        RuntimeMessageAdapter<M, B> r14 = WireFiledWorkaround.create(r10.getRawType());
        this.messageAdapter = r14;
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<FieldBinding<M, B>> r16 = r14.fieldBindings().values().iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        FieldBinding<M, B> r17 = r16.next();
        r15.put(r17.name, r17);
        goto L4
    L6:
        this.fieldBindings = Collections.unmodifiableMap(r15);
        this.type = r10;
        this.defaultValue = r12;
        this.path = r11;
        this.listener = r13;
    }

    private void emitJson(JsonWriter r5, Object r10, ProtoAdapter<?> r11, WireField.Label r12) {
        if (r11 == ProtoAdapter.UINT64) goto L5;
        this.gson.toJson(r10, r10.getClass(), r5);
        return;
    L5:
        if (r12.isRepeated() == false) goto L11;
        List r13 = (List) r10;
        r5.beginArray();
        int r14 = r13.size();
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        emitUint64((Long) r13.get(r15), r5);
        r15 = r15 + 1;
        goto L7
    L9:
        r5.endArray();
        return;
    L11:
        emitUint64((Long) r10, r5);
    }

    private void emitUint64(Long r5, JsonWriter r10) {
        if (r5.longValue() >= 0) goto L6;
        r10.value(POWER_64.add(BigInteger.valueOf(r5.longValue())));
        return;
    L6:
        r10.value(r5);
    }

    private <T> Object fromJson(JsonElement r10, Class<T> r11, String r12, Object r13) {
        TypeAdapter<T> r5 = this.gson.getAdapter(r11);
        if (r13 == null) goto L43;
        if (Message.class.isAssignableFrom(r11) == false) goto L43;
        if ((r5 instanceof MessageTypeAdapter) == false) goto L9;
    L11:
        Message r14 = (Message) r13;
        JsonTreeReader r15 = new JsonTreeReader(r10);
        boolean r16 = r15.isLenient();
        boolean r17 = true;
        r15.setLenient(true);
        r15.peek();     // Catch: Throwable -> L19 AssertionError -> L21 IOException -> L23 IllegalStateException -> L25 EOFException -> L27
        r17 = false;
        TypeToken r18 = TypeToken.get(r11);     // Catch: Throwable -> L19 AssertionError -> L21 IOException -> L23 IllegalStateException -> L25 EOFException -> L27
        Gson r19 = this.gson;     // Catch: Throwable -> L19 AssertionError -> L21 IOException -> L23 IllegalStateException -> L25 EOFException -> L27
        if (TextUtils.isEmpty(this.path) == true) goto L16;
        r12 = this.path + "." + r12;     // Catch: Throwable -> L19 AssertionError -> L21 IOException -> L23 IllegalStateException -> L25 EOFException -> L27
    L16:
        Object r20 = new DefaultValueMessageTypeAdapter(r19, r18, r12, r14, this.listener).read(r15);     // Catch: Throwable -> L19 AssertionError -> L21 IOException -> L23 IllegalStateException -> L25 EOFException -> L27
        r15.setLenient(r16);
        return r20;
    L19:
        th = move-exception;
        r15.setLenient(r16);
        throw th;
    L23:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L19
    L25:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L19
    L27:
        e = move-exception;
        if (r17 == false) goto L39;
        r15.setLenient(r16);
        return null;
    L39:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L19
    L21:
        e = move-exception;
        throw new JsonSyntaxException("AssertionError (GSON 2.8.5): " + e.getMessage(), e);     // Catch: Throwable -> L19
    L9:
        if ((r5 instanceof DefaultValueMessageTypeAdapter) == true) goto L11;
    L43:
        return this.gson.fromJson(r10, r11);
    }

    private void onDeserializeError(Throwable r5, String r10) {
        if (this.listener != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.path) == true) goto L8;
        r10 = b.b(new StringBuilder(), this.path, ".", r10);
    L8:
        this.listener.onError(this.type.getRawType(), r10, r5);
    }

    private Object parseValue(FieldBinding<?, ?> r5, JsonElement r10, String r11, Object r12) {
        if (r5.label.isRepeated() == false) goto L14;
        if (r10.isJsonNull() == true) goto L7;
        Class<?> r13 = r5.singleAdapter().javaType;
        JsonArray r14 = r10.getAsJsonArray();
        ArrayList r15 = new ArrayList(r14.size());
        Iterator<JsonElement> r16 = r14.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        JsonElement r17 = r16.next();
        r15.add(this.gson.fromJson(r17, r13));
        goto L10
    L12:
        return r15;
    L7:
        return Collections.EMPTY_LIST;
    L14:
        if (r5.isMap() == false) goto L25;
        if (r10.isJsonNull() == true) goto L18;
        Class<?> r18 = r5.keyAdapter().javaType;
        Class<?> r19 = r5.singleAdapter().javaType;
        JsonObject r20 = r10.getAsJsonObject();
        LinkedHashMap r21 = new LinkedHashMap(r20.size());
        Iterator<Map.Entry<String, JsonElement>> r22 = r20.entrySet().iterator();
    L21:
        if (r22.hasNext() == false) goto L23;
        Map.Entry<String, JsonElement> r23 = r22.next();
        r21.put(this.gson.fromJson(r23.getKey(), r18), this.gson.fromJson(r23.getValue(), r19));
        goto L21
    L23:
        return r21;
    L18:
        return Collections.EMPTY_MAP;
    L25:
        return fromJson(r10, r5.singleAdapter().javaType, r11, r12);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r5) {
        return read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Object r10) {
        write(r5, (Message) r10);
    }

    @Override // com.google.gson.TypeAdapter
    public M read(JsonReader r10) {
        if (r10.peek() != JsonToken.NULL) goto L6;
        r10.nextNull();
        return null;
    L6:
        TypeAdapter r5 = this.gson.getAdapter(JsonElement.class);
        Message.Builder<M, B> r11 = this.defaultValue.newBuilder();
        r10.beginObject();
    L8:
        if (r10.peek() == JsonToken.END_OBJECT) goto L23;
        String r12 = r10.nextName();
        FieldBinding<M, B> r13 = this.fieldBindings.get(r12);
        if (r13 == null) goto L11;
        Object r14 = parseValue(r13, (JsonElement) r5.read(r10), r12, r13.getFromBuilder(r11));     // Catch: Throwable -> L18
        if (r14 != null) goto L20;
        if (r13.label != WireField.Label.REQUIRED) goto L20;
        onDeserializeError(new IllegalStateException(r12 + " is null"), r12);     // Catch: Throwable -> L18
    L20:
        r13.set(r11, r14);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        onDeserializeError(th, r12);
        goto L8
    L11:
        r10.skipValue();
        goto L8
    L23:
        r10.endObject();
        return (M) r11.build();
    L26:
        e = move-exception;
        onDeserializeError(e, null);
        throw e;
    }

    public void write(JsonWriter r5, M r10) {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        r5.beginObject();
        Iterator<FieldBinding<M, B>> r11 = this.messageAdapter.fieldBindings().values().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        FieldBinding<M, B> r12 = r11.next();
        Object r13 = r12.get(r10);
        if (r13 == null) goto L7;
        r5.name(r12.name);
        emitJson(r5, r13, r12.singleAdapter(), r12.label);
        goto L7
    L12:
        r5.endObject();
    }
}
