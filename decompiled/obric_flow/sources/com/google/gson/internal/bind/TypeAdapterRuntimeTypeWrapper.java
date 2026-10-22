package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson r5, TypeAdapter<T> r10, Type r11) {
        this.context = r5;
        this.delegate = r10;
        this.type = r11;
    }

    private static Type getRuntimeTypeIfMoreSpecific(Type r5, Object r10) {
        if (r10 != null) goto L4;
        return r5;
    L4:
        if ((r5 instanceof Class) == true) goto L8;
        if ((r5 instanceof TypeVariable) == true) goto L8;
        return r5;
    L8:
        return r10.getClass();
    }

    private static boolean isReflective(TypeAdapter<?> r5) {
    L3:
        if ((r5 instanceof SerializationDelegatingTypeAdapter) == false) goto L9;
        TypeAdapter<?> r10 = ((SerializationDelegatingTypeAdapter) r5).getSerializationDelegate();
        if (r10 == r5) goto L9;
        r5 = r10;
    L9:
        return r5 instanceof ReflectiveTypeAdapterFactory.Adapter;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r5) throws IOException {
        return this.delegate.read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, T r10) throws IOException {
        TypeAdapter<T> r11 = this.delegate;
        Type r12 = getRuntimeTypeIfMoreSpecific(this.type, r10);
        if (r12 == this.type) goto L10;
        r11 = this.context.getAdapter(TypeToken.get(r12));
        if ((r11 instanceof ReflectiveTypeAdapterFactory.Adapter) == false) goto L10;
        if (isReflective(this.delegate) == true) goto L10;
        r11 = this.delegate;
    L10:
        r11.write(r5, r10);
    }
}
