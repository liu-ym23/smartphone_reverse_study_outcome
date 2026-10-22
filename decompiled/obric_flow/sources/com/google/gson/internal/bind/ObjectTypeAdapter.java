package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {
    private static final TypeAdapterFactory DOUBLE_FACTORY = null;
    private final Gson gson;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
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
        DOUBLE_FACTORY = newFactory(ToNumberPolicy.DOUBLE);
    }

    public /* synthetic */ ObjectTypeAdapter(Gson r5, ToNumberStrategy r10, AnonymousClass1 r11) {
        this(r5, r10);
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r5) {
        if (r5 != ToNumberPolicy.DOUBLE) goto L7;
        return DOUBLE_FACTORY;
    L7:
        return newFactory(r5);
    }

    private static TypeAdapterFactory newFactory(final ToNumberStrategy r5) {
        return new AnonymousClass1(r5);
    }

    private Object readTerminal(JsonReader r5, JsonToken r10) throws IOException {
        int r11 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r10.ordinal()];
        if (r11 == 3) goto L19;
        if (r11 == 4) goto L17;
        if (r11 == 5) goto L15;
        if (r11 != 6) goto L13;
        r5.nextNull();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r10);
    L15:
        return Boolean.valueOf(r5.nextBoolean());
    L17:
        return this.toNumberStrategy.readNumber(r5);
    L19:
        return r5.nextString();
    }

    private Object tryBeginNesting(JsonReader r5, JsonToken r10) throws IOException {
        int r11 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r10.ordinal()];
        if (r11 != 1) goto L5;
        r5.beginArray();
        return new ArrayList();
    L5:
        if (r11 == 2) goto L8;
        return null;
    L8:
        r5.beginObject();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r10) throws IOException {
        JsonToken r5 = r10.peek();
        Object r11 = tryBeginNesting(r10, r5);
        if (r11 == null) goto L5;
        ArrayDeque r12 = new ArrayDeque();
    L8:
        if (r10.hasNext() == true) goto L10;
        if ((r11 instanceof List) == false) goto L28;
        r10.endArray();
    L30:
        if (r12.isEmpty() == true) goto L31;
        r11 = r12.removeLast();
        goto L8
    L31:
        return r11;
    L28:
        r10.endObject();
        goto L30
    L10:
        if ((r11 instanceof Map) == false) goto L12;
        String r13 = r10.nextName();
    L13:
        JsonToken r14 = r10.peek();
        Object r15 = tryBeginNesting(r10, r14);
        if (r15 == null) goto L16;
        boolean r16 = true;
    L17:
        if (r15 != null) goto L20;
        r15 = readTerminal(r10, r14);
    L20:
        if ((r11 instanceof List) == false) goto L22;
        ((List) r11).add(r15);
    L23:
        if (r16 == false) goto L8;
        r12.addLast(r11);
        r11 = r15;
        goto L8
    L22:
        ((Map) r11).put(r13, r15);
        goto L23
    L16:
        r16 = false;
        goto L17
    L12:
        r13 = null;
        goto L13
    L5:
        return readTerminal(r10, r5);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, Object r10) throws IOException {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        TypeAdapter r11 = this.gson.getAdapter(r10.getClass());
        if ((r11 instanceof ObjectTypeAdapter) == false) goto L9;
        r5.beginObject();
        r5.endObject();
        return;
    L9:
        r11.write(r5, r10);
    }

    private ObjectTypeAdapter(Gson r5, ToNumberStrategy r10) {
        this.gson = r5;
        this.toNumberStrategy = r10;
    }
}
