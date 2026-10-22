package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class JsonElementTypeAdapter extends TypeAdapter<JsonElement> {
    public static final JsonElementTypeAdapter ADAPTER = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonElementTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r5 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r5;
            r5[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        ADAPTER = new JsonElementTypeAdapter();
    }

    private JsonElementTypeAdapter() {
    }

    private JsonElement readTerminal(JsonReader r5, JsonToken r10) throws IOException {
        int r11 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[r10.ordinal()];
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L17;
        if (r11 == 5) goto L15;
        if (r11 != 6) goto L13;
        r5.nextNull();
        return JsonNull.INSTANCE;
    L13:
        throw new IllegalStateException("Unexpected token: " + r10);
    L15:
        return new JsonPrimitive(Boolean.valueOf(r5.nextBoolean()));
    L17:
        return new JsonPrimitive(new LazilyParsedNumber(r5.nextString()));
    L19:
        return new JsonPrimitive(r5.nextString());
    }

    private JsonElement tryBeginNesting(JsonReader r5, JsonToken r10) throws IOException {
        int r11 = AnonymousClass1.$SwitchMap$com$google$gson$stream$JsonToken[r10.ordinal()];
        if (r11 != 1) goto L5;
        r5.beginArray();
        return new JsonArray();
    L5:
        if (r11 == 2) goto L8;
        return null;
    L8:
        r5.beginObject();
        return new JsonObject();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ JsonElement read(JsonReader r5) throws IOException {
        return read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, JsonElement r10) throws IOException {
        write2(r5, r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public JsonElement read(JsonReader r10) throws IOException {
        if ((r10 instanceof JsonTreeReader) == true) goto L5;
        JsonToken r5 = r10.peek();
        JsonElement r11 = tryBeginNesting(r10, r5);
        if (r11 == null) goto L9;
        ArrayDeque r12 = new ArrayDeque();
    L12:
        if (r10.hasNext() == true) goto L14;
        if ((r11 instanceof JsonArray) == false) goto L32;
        r10.endArray();
    L34:
        if (r12.isEmpty() == true) goto L35;
        r11 = (JsonElement) r12.removeLast();
        goto L12
    L35:
        return r11;
    L32:
        r10.endObject();
        goto L34
    L14:
        if ((r11 instanceof JsonObject) == false) goto L16;
        String r13 = r10.nextName();
    L17:
        JsonToken r14 = r10.peek();
        JsonElement r15 = tryBeginNesting(r10, r14);
        if (r15 == null) goto L20;
        boolean r16 = true;
    L21:
        if (r15 != null) goto L24;
        r15 = readTerminal(r10, r14);
    L24:
        if ((r11 instanceof JsonArray) == false) goto L26;
        ((JsonArray) r11).add(r15);
    L27:
        if (r16 == false) goto L12;
        r12.addLast(r11);
        r11 = r15;
        goto L12
    L26:
        ((JsonObject) r11).add(r13, r15);
        goto L27
    L20:
        r16 = false;
        goto L21
    L16:
        r13 = null;
        goto L17
    L9:
        return readTerminal(r10, r5);
    L5:
        return ((JsonTreeReader) r10).nextJsonElement();
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r5, JsonElement r10) throws IOException {
        if (r10 != null) goto L4;
    L31:
        r5.nullValue();
        return;
    L4:
        if (r10.isJsonNull() == true) goto L31;
        if (r10.isJsonPrimitive() == false) goto L16;
        JsonPrimitive r11 = r10.getAsJsonPrimitive();
        if (r11.isNumber() == false) goto L12;
        r5.value(r11.getAsNumber());
        return;
    L12:
        if (r11.isBoolean() == false) goto L14;
        r5.value(r11.getAsBoolean());
        return;
    L14:
        r5.value(r11.getAsString());
        return;
    L16:
        if (r10.isJsonArray() == false) goto L23;
        r5.beginArray();
        Iterator<JsonElement> r12 = r10.getAsJsonArray().iterator();
    L19:
        if (r12.hasNext() == false) goto L21;
        write2(r5, r12.next());
        goto L19
    L21:
        r5.endArray();
        return;
    L23:
        if (r10.isJsonObject() == false) goto L30;
        r5.beginObject();
        Iterator<Map.Entry<String, JsonElement>> r13 = r10.getAsJsonObject().entrySet().iterator();
    L26:
        if (r13.hasNext() == false) goto L28;
        Map.Entry<String, JsonElement> r14 = r13.next();
        r5.name(r14.getKey());
        write2(r5, r14.getValue());
        goto L26
    L28:
        r5.endObject();
        return;
    L30:
        throw new IllegalArgumentException("Couldn't write " + r10.getClass());
    }
}
