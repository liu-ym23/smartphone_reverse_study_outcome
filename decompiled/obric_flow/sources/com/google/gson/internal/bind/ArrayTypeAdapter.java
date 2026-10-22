package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final TypeAdapterFactory FACTORY = null;
    private final Class<E> componentType;
    private final TypeAdapter<E> componentTypeAdapter;

    static {
        FACTORY = new AnonymousClass1();
    }

    public ArrayTypeAdapter(Gson r5, TypeAdapter<E> r10, Class<E> r11) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(r5, r10, r11);
        this.componentType = r11;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader r5) throws IOException {
        if (r5.peek() != JsonToken.NULL) goto L6;
        r5.nextNull();
        return null;
    L6:
        ArrayList r10 = new ArrayList();
        r5.beginArray();
    L8:
        if (r5.hasNext() == false) goto L10;
        r10.add(this.componentTypeAdapter.read(r5));
        goto L8
    L10:
        r5.endArray();
        int r11 = r10.size();
        if (this.componentType.isPrimitive() == false) goto L17;
        Object r12 = Array.newInstance(this.componentType, r11);
        int r13 = 0;
    L13:
        if (r13 >= r11) goto L15;
        Array.set(r12, r13, r10.get(r13));
        r13 = r13 + 1;
        goto L13
    L15:
        return r12;
    L17:
        return r10.toArray((Object[]) Array.newInstance(this.componentType, r11));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r5, Object r10) throws IOException {
        if (r10 != null) goto L5;
        r5.nullValue();
        return;
    L5:
        r5.beginArray();
        int r11 = Array.getLength(r10);
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        Object r13 = Array.get(r10, r12);
        this.componentTypeAdapter.write(r5, (E) r13);
        r12 = r12 + 1;
        goto L6
    L8:
        r5.endArray();
    }
}
