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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.BEGIN_ARRAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
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

    private ObjectTypeAdapter(Gson r3, ToNumberStrategy r4) {
        ToNumberStrategy r5 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r4, ToNumberStrategy.class, "com.obric.memorydata.plugin");
        this.gson = r3;
        this.toNumberStrategy = r5;
    }

    /* synthetic */ ObjectTypeAdapter(Gson r2, ToNumberStrategy r3, AnonymousClass1 r4) {
        this(r2, (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r3, ToNumberStrategy.class, "com.obric.memorydata.plugin"));
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r2) {
        ToNumberStrategy r3 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r2, ToNumberStrategy.class, "com.obric.memorydata.plugin");
        if (r3 != ToNumberPolicy.DOUBLE) goto L7;
        return DOUBLE_FACTORY;
    L7:
        return newFactory(r3);
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy r2) {
        final ToNumberStrategy r3 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r2, ToNumberStrategy.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3);
    }

    private Object readTerminal(JsonReader r3, JsonToken r4) {
        int r0 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r4.ordinal()];
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 == 5) goto L15;
        if (r0 != 6) goto L13;
        r3.nextNull();
        return null;
    L13:
        throw new IllegalStateException("Unexpected token: " + r4);
    L15:
        return Boolean.valueOf(r3.nextBoolean());
    L17:
        return this.toNumberStrategy.readNumber(r3);
    L19:
        return r3.nextString();
    }

    private Object tryBeginNesting(JsonReader r1, JsonToken r2) {
        int r0 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r2.ordinal()];
        if (r0 != 1) goto L5;
        r1.beginArray();
        return new ArrayList();
    L5:
        if (r0 == 2) goto L8;
        return null;
    L8:
        r1.beginObject();
        return new LinkedTreeMap();
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r8) {
        JsonToken r0 = r8.peek();
        Object r1 = tryBeginNesting(r8, r0);
        if (r1 == null) goto L5;
        ArrayDeque r2 = new ArrayDeque();
    L8:
        if (r8.hasNext() == true) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, List.class) == false) goto L27;
        r8.endArray();
    L29:
        if (r2.isEmpty() == true) goto L30;
        r1 = r2.removeLast();
        goto L8
    L30:
        return r1;
    L27:
        r8.endObject();
        goto L29
    L9:
        String r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, Map.class) == false) goto L12;
        r3 = r8.nextName();
    L12:
        JsonToken r4 = r8.peek();
        Object r5 = tryBeginNesting(r8, r4);
        if (r5 == null) goto L15;
        boolean r6 = true;
    L16:
        if (r5 != null) goto L19;
        r5 = readTerminal(r8, r4);
    L19:
        if (ZeusTransformUtils.instanceOf(r1, List.class) == false) goto L21;
        ((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin")).add(r5);
    L22:
        if (r6 == false) goto L8;
        r2.addLast(r1);
        r1 = r5;
        goto L8
    L21:
        ((Map) ZeusTransformUtils.preCheckCast(r1, Map.class, "com.obric.memorydata.plugin")).put(r3, r5);
        goto L22
    L15:
        r6 = false;
        goto L16
    L5:
        return readTerminal(r8, r0);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r2, Object r3) {
        if (r3 != null) goto L5;
        r2.nullValue();
        return;
    L5:
        TypeAdapter r1 = this.gson.getAdapter(r3.getClass());
        if (ZeusTransformUtils.instanceOf(r1, ObjectTypeAdapter.class) == false) goto L9;
        r2.beginObject();
        r2.endObject();
        return;
    L9:
        r1.write(r2, r3);
    }
}
