package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.ToNumberStrategy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {
    private static final TypeAdapterFactory LAZILY_PARSED_NUMBER_FACTORY = null;
    private final ToNumberStrategy toNumberStrategy;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r5 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r5;
            r5[JsonToken.NULL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
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

    private NumberTypeAdapter(ToNumberStrategy r5) {
        this.toNumberStrategy = r5;
    }

    public static TypeAdapterFactory getFactory(ToNumberStrategy r5) {
        if (r5 != ToNumberPolicy.LAZILY_PARSED_NUMBER) goto L7;
        return LAZILY_PARSED_NUMBER_FACTORY;
    L7:
        return newFactory(r5);
    }

    private static TypeAdapterFactory newFactory(ToNumberStrategy r5) {
        final NumberTypeAdapter r10 = new NumberTypeAdapter(r5);
        return new AnonymousClass1(r10);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Number read(JsonReader r5) throws IOException {
        return read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Number r10) throws IOException {
        write2(r5, r10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader r5) throws IOException {
        JsonToken r10 = r5.peek();
        int r11 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r10.ordinal()];
        if (r11 != 1) goto L5;
        r5.nextNull();
        return null;
    L5:
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L12;
        throw new JsonSyntaxException("Expecting number, got: " + r10 + "; at path " + r5.getPath());
    L12:
        return this.toNumberStrategy.readNumber(r5);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r5, Number r10) throws IOException {
        r5.value(r10);
    }
}
