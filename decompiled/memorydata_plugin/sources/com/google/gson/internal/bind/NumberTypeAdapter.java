package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = null;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r0 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r0;
            r0[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        LAZILY_PARSED_NUMBER_FACTORY = newFactory(ToNumberPolicy.LAZILY_PARSED_NUMBER);
    }

    private NumberTypeAdapter(ToNumberStrategy r3) {
        this.toNumberStrategy = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r3, ToNumberStrategy.class, "com.obric.memorydata.plugin");
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r2) {
        ToNumberStrategy r3 = (ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r2, ToNumberStrategy.class, "com.obric.memorydata.plugin");
        if (r3 != ToNumberPolicy.LAZILY_PARSED_NUMBER) goto L7;
        return LAZILY_PARSED_NUMBER_FACTORY;
    L7:
        return newFactory(r3);
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy r2) {
        final NumberTypeAdapter r0 = new NumberTypeAdapter((ToNumberStrategy) ZeusTransformUtils.wrapperContextForParams(r2, ToNumberStrategy.class, "com.obric.memorydata.plugin"));
        return new AnonymousClass1(r0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader r4) {
        JsonToken r0 = r4.peek();
        int r1 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r0.ordinal()];
        if (r1 != 1) goto L5;
        r4.nextNull();
        return null;
    L5:
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L12;
        throw new JsonSyntaxException("Expecting number, got: " + r0 + "; at path " + r4.getPath());
    L12:
        return this.toNumberStrategy.readNumber(r4);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number read(JsonReader r1) {
        return read(r1);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r1, Number r2) {
        r1.value(r2);
    }

    @Override // com.google.gson.TypeAdapter
    public /* synthetic */ void write(JsonWriter r3, Number r4) {
        write2(r3, (Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
    }
}
