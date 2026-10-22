package com.squareup.wire;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class MessageTypeAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends TypeAdapter<M> {
    private static final BigInteger POWER_64 = null;
    private final Map<String, FieldBinding<M, B>> fieldBindings;
    private final Gson gson;
    private final RuntimeMessageAdapter<M, B> messageAdapter;

    static {
        POWER_64 = new BigInteger("18446744073709551616");
    }

    public MessageTypeAdapter(Gson r5, TypeToken<M> r10) {
        this.gson = r5;
        RuntimeMessageAdapter<M, B> r11 = WireFiledWorkaround.create(r10.getRawType());
        this.messageAdapter = r11;
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<FieldBinding<M, B>> r13 = r11.fieldBindings().values().iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        FieldBinding<M, B> r14 = r13.next();
        r12.put(r14.name, r14);
        goto L4
    L6:
        this.fieldBindings = Collections.unmodifiableMap(r12);
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

    private Object parseValue(FieldBinding<?, ?> r10, JsonElement r11) {
        if (r10.label.isRepeated() == false) goto L14;
        if (r11.isJsonNull() == true) goto L7;
        Class<?> r12 = r10.singleAdapter().javaType;
        JsonArray r13 = r11.getAsJsonArray();
        ArrayList r5 = new ArrayList(r13.size());
        Iterator<JsonElement> r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        JsonElement r15 = r14.next();
        r5.add(this.gson.fromJson(r15, r12));
        goto L10
    L12:
        return r5;
    L7:
        return Collections.EMPTY_LIST;
    L14:
        if (r10.isMap() == true) goto L16;
        Class<?> r16 = r10.singleAdapter().javaType;
        return this.gson.fromJson(r11, r16);
    L16:
        if (r11.isJsonNull() == true) goto L18;
        Class<?> r17 = r10.keyAdapter().javaType;
        Class<?> r18 = r10.singleAdapter().javaType;
        JsonObject r19 = r11.getAsJsonObject();
        LinkedHashMap r20 = new LinkedHashMap(r19.size());
        Iterator<Map.Entry<String, JsonElement>> r21 = r19.entrySet().iterator();
    L21:
        if (r21.hasNext() == false) goto L23;
        Map.Entry<String, JsonElement> r22 = r21.next();
        r20.put(this.gson.fromJson(r22.getKey(), r17), this.gson.fromJson(r22.getValue(), r18));
        goto L21
    L23:
        return r20;
    L18:
        return Collections.EMPTY_MAP;
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
    public M read(JsonReader r5) {
        if (r5.peek() != JsonToken.NULL) goto L6;
        r5.nextNull();
        return null;
    L6:
        TypeAdapter r10 = this.gson.getAdapter(JsonElement.class);
        Message.Builder r11 = this.messageAdapter.newBuilder();
        r5.beginObject();
    L8:
        if (r5.peek() == JsonToken.END_OBJECT) goto L13;
        String r12 = r5.nextName();
        FieldBinding<M, B> r13 = this.fieldBindings.get(r12);
        if (r13 == null) goto L11;
        r13.set(r11, parseValue(r13, (JsonElement) r10.read(r5)));
        goto L8
    L11:
        r5.skipValue();
        goto L8
    L13:
        r5.endObject();
        return (M) r11.build();
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
