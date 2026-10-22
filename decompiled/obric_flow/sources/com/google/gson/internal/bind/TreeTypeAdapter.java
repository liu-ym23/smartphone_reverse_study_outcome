package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context;
    private volatile TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final boolean nullSafe;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPastForGetDelegateAdapter;
    private final TypeToken<T> typeToken;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TreeTypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        final /* synthetic */ TreeTypeAdapter this$0;

        private GsonContextImpl(TreeTypeAdapter r5) {
            this.this$0 = r5;
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement r5, Type r10) throws JsonParseException {
            return (R) this.this$0.gson.fromJson(r5, r10);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r5) {
            return this.this$0.gson.toJsonTree(r5);
        }

        public /* synthetic */ GsonContextImpl(TreeTypeAdapter r5, AnonymousClass1 r10) {
            this(r5);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object r5, Type r10) {
            return this.this$0.gson.toJsonTree(r5, r10);
        }
    }

    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        public SingleTypeFactory(Object r5, TypeToken<?> r10, boolean r11, Class<?> r12) {
            JsonDeserializer<?> r13 = null;
            if ((r5 instanceof JsonSerializer) == false) goto L5;
            JsonSerializer<?> r14 = (JsonSerializer) r5;
        L6:
            this.serializer = r14;
            if ((r5 instanceof JsonDeserializer) == false) goto L9;
            r13 = (JsonDeserializer) r5;
        L9:
            this.deserializer = r13;
            if (r14 != null) goto L15;
            if (r13 != null) goto L15;
            Objects.requireNonNull(r5);
            throw new IllegalArgumentException("Type adapter " + r5.getClass().getName() + " must implement JsonSerializer or JsonDeserializer");
        L15:
            this.exactType = r10;
            this.matchRawType = r11;
            this.hierarchyType = r12;
            return;
        L5:
            r14 = null;
            goto L6
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
            TypeToken<?> r5 = this.exactType;
            if (r5 != null) goto L5;
            boolean r12 = this.hierarchyType.isAssignableFrom(r11.getRawType());
        L14:
            if (r12 == true) goto L18;
            return null;
        L18:
            return new TreeTypeAdapter(this.serializer, this.deserializer, r10, r11, this);
        L5:
            if (r5.equals(r11) == false) goto L7;
        L12:
            r12 = true;
            goto L14
        L7:
            if (this.matchRawType == true) goto L9;
        L11:
            r12 = false;
            goto L14
        L9:
            if (this.exactType.getType() != r11.getRawType()) goto L11;
            goto L11
        }
    }

    public TreeTypeAdapter(JsonSerializer<T> r5, JsonDeserializer<T> r10, Gson r11, TypeToken<T> r12, TypeAdapterFactory r13, boolean r14) {
        this.context = new GsonContextImpl(this, null);
        this.serializer = r5;
        this.deserializer = r10;
        this.gson = r11;
        this.typeToken = r12;
        this.skipPastForGetDelegateAdapter = r13;
        this.nullSafe = r14;
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r5 = this.delegate;
        if (r5 != null) goto L6;
        TypeAdapter<T> r10 = this.gson.getDelegateAdapter(this.skipPastForGetDelegateAdapter, this.typeToken);
        this.delegate = r10;
        return r10;
    L6:
        return r5;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> r5, Object r10) {
        return new SingleTypeFactory(r10, r5, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> r5, Object r10) {
        if (r5.getType() != r5.getRawType()) goto L5;
        boolean r11 = true;
    L7:
        return new SingleTypeFactory(r10, r5, r11, null);
    L5:
        r11 = false;
        goto L7
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> r5, Object r10) {
        return new SingleTypeFactory(r10, null, false, r5);
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public TypeAdapter<T> getSerializationDelegate() {
        if (this.serializer == null) goto L6;
        return this;
    L6:
        return delegate();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r5) throws IOException {
        if (this.deserializer == null) goto L5;
        JsonElement r10 = Streams.parse(r5);
        if (this.nullSafe == false) goto L13;
        if (r10.isJsonNull() == false) goto L13;
        return null;
    L13:
        return this.deserializer.deserialize(r10, this.typeToken.getType(), this.context);
    L5:
        return delegate().read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, T r10) throws IOException {
        JsonSerializer<T> r11 = this.serializer;
        if (r11 != null) goto L7;
        delegate().write(r5, r10);
        return;
    L7:
        if (this.nullSafe == false) goto L11;
        if (r10 != null) goto L11;
        r5.nullValue();
        return;
    L11:
        Streams.write(r11.serialize(r10, this.typeToken.getType(), this.context), r5);
    }

    public TreeTypeAdapter(JsonSerializer<T> r10, JsonDeserializer<T> r11, Gson r12, TypeToken<T> r13, TypeAdapterFactory r14) {
        this(r10, r11, r12, r13, r14, true);
    }
}
