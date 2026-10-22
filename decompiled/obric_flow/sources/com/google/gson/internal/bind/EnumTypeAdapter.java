package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
    static final TypeAdapterFactory FACTORY = null;
    private final Map<T, String> constantToName;
    private final Map<String, T> nameToConstant;
    private final Map<String, T> stringToConstant;

    static {
        FACTORY = new AnonymousClass1();
    }

    public /* synthetic */ EnumTypeAdapter(Class r5, AnonymousClass1 r10) {
        this(r5);
    }

    private static int calculateHashMapCapacity(int r5) {
        return (int) Math.ceil(r5 / 0.75f);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Object read(JsonReader r5) throws IOException {
        return read(r5);
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r5, Object r10) throws IOException {
        write(r5, (Enum) r10);
    }

    private EnumTypeAdapter(Class<T> r12) {
        Field[] r13 = r12.getDeclaredFields();     // Catch: IllegalAccessException -> L8
        int r5 = r13.length;     // Catch: IllegalAccessException -> L8
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r10 >= r5) goto L11;
        Field r14 = r13[r10];     // Catch: IllegalAccessException -> L8
        if (r14.isEnumConstant() == false) goto L10;
        r13[r11] = r14;     // Catch: IllegalAccessException -> L8
        r11 = r11 + 1;     // Catch: IllegalAccessException -> L8
    L10:
        r10 = r10 + 1;     // Catch: IllegalAccessException -> L8
        goto L4
    L11:
        Field[] r15 = (Field[]) Arrays.copyOf(r13, r11);     // Catch: IllegalAccessException -> L8
        int r16 = calculateHashMapCapacity(r11);     // Catch: IllegalAccessException -> L8
        this.nameToConstant = new HashMap(r16);     // Catch: IllegalAccessException -> L8
        this.stringToConstant = new HashMap(r16);     // Catch: IllegalAccessException -> L8
        this.constantToName = new HashMap(r16);     // Catch: IllegalAccessException -> L8
        AccessibleObject.setAccessible(r15, true);     // Catch: IllegalAccessException -> L8
        int r17 = r15.length;     // Catch: IllegalAccessException -> L8
        int r18 = 0;
    L12:
        if (r18 >= r17) goto L20;
        Field r19 = r15[r18];     // Catch: IllegalAccessException -> L8
        Enum r20 = (Enum) r19.get(null);     // Catch: IllegalAccessException -> L8
        String r21 = r20.name();     // Catch: IllegalAccessException -> L8
        String r22 = r20.toString();     // Catch: IllegalAccessException -> L8
        SerializedName r23 = (SerializedName) r19.getAnnotation(SerializedName.class);     // Catch: IllegalAccessException -> L8
        if (r23 == null) goto L18;
        r21 = r23.value();     // Catch: IllegalAccessException -> L8
        String[] r24 = r23.alternate();     // Catch: IllegalAccessException -> L8
        int r25 = r24.length;     // Catch: IllegalAccessException -> L8
        int r26 = 0;
    L16:
        if (r26 >= r25) goto L18;
        this.nameToConstant.put(r24[r26], (T) r20);     // Catch: IllegalAccessException -> L8
        r26 = r26 + 1;     // Catch: IllegalAccessException -> L8
    L18:
        this.nameToConstant.put(r21, (T) r20);     // Catch: IllegalAccessException -> L8
        this.stringToConstant.put(r22, (T) r20);     // Catch: IllegalAccessException -> L8
        this.constantToName.put((T) r20, r21);     // Catch: IllegalAccessException -> L8
        r18 = r18 + 1;
        goto L12
    L20:
        return;
    L8:
        e = move-exception;
        throw new AssertionError(e);
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r5) throws IOException {
        if (r5.peek() != JsonToken.NULL) goto L6;
        r5.nextNull();
        return null;
    L6:
        String r10 = r5.nextString();
        T r11 = this.nameToConstant.get(r10);
        if (r11 == null) goto L9;
        return r11;
    L9:
        return this.stringToConstant.get(r10);
    }

    public void write(JsonWriter r5, T r10) throws IOException {
        if (r10 != null) goto L4;
        String r11 = null;
    L5:
        r5.value(r11);
        return;
    L4:
        r11 = this.constantToName.get(r10);
        goto L5
    }
}
