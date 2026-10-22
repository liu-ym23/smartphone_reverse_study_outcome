package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
        private final ObjectConstructor<? extends Map<K, V>> constructor;
        private final TypeAdapter<K> keyTypeAdapter;
        final /* synthetic */ MapTypeAdapterFactory this$0;
        private final TypeAdapter<V> valueTypeAdapter;

        public Adapter(MapTypeAdapterFactory r5, TypeAdapter<K> r10, TypeAdapter<V> r11, ObjectConstructor<? extends Map<K, V>> r12) {
            this.this$0 = r5;
            this.keyTypeAdapter = r10;
            this.valueTypeAdapter = r11;
            this.constructor = r12;
        }

        private String keyToString(JsonElement r5) {
            if (r5.isJsonPrimitive() == false) goto L19;
            JsonPrimitive r10 = r5.getAsJsonPrimitive();
            if (r10.isNumber() == false) goto L9;
            return String.valueOf(r10.getAsNumber());
        L9:
            if (r10.isBoolean() == false) goto L13;
            return Boolean.toString(r10.getAsBoolean());
        L13:
            if (r10.isString() == false) goto L17;
            return r10.getAsString();
        L17:
            throw new AssertionError();
        L19:
            if (r5.isJsonNull() == false) goto L23;
            return "null";
        L23:
            throw new AssertionError();
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r5) throws IOException {
            return read(r5);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r5, Object r10) throws IOException {
            write(r5, (Map) r10);
        }

        @Override // com.google.gson.TypeAdapter
        public Map<K, V> read(JsonReader r10) throws IOException {
            JsonToken r5 = r10.peek();
            if (r5 != JsonToken.NULL) goto L6;
            r10.nextNull();
            return null;
        L6:
            Map<K, V> r11 = this.constructor.construct();
            if (r5 != JsonToken.BEGIN_ARRAY) goto L17;
            r10.beginArray();
        L10:
            if (r10.hasNext() == false) goto L16;
            r10.beginArray();
            K r12 = this.keyTypeAdapter.read(r10);
            V r13 = this.valueTypeAdapter.read(r10);
            if (r11.containsKey(r12) == true) goto L15;
            r11.put(r12, r13);
            r10.endArray();
            goto L10
        L15:
            throw new JsonSyntaxException("duplicate key: " + r12);
        L16:
            r10.endArray();
        L26:
            return r11;
        L17:
            r10.beginObject();
        L19:
            if (r10.hasNext() == false) goto L25;
            JsonReaderInternalAccess.INSTANCE.promoteNameToValue(r10);
            K r14 = this.keyTypeAdapter.read(r10);
            V r15 = this.valueTypeAdapter.read(r10);
            if (r11.containsKey(r14) == true) goto L24;
            r11.put(r14, r15);
            goto L19
        L24:
            throw new JsonSyntaxException("duplicate key: " + r14);
        L25:
            r10.endObject();
            goto L26
        }

        public void write(JsonWriter r10, Map<K, V> r11) throws IOException {
            if (r11 != null) goto L6;
            r10.nullValue();
            return;
        L6:
            if (this.this$0.complexMapKeySerialization == true) goto L13;
            r10.beginObject();
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<K, V> r5 = r12.next();
            r10.name(String.valueOf(r5.getKey()));
            this.valueTypeAdapter.write(r10, r5.getValue());
            goto L9
        L11:
            r10.endObject();
            return;
        L13:
            ArrayList r13 = new ArrayList(r11.size());
            ArrayList r14 = new ArrayList(r11.size());
            Iterator<Map.Entry<K, V>> r15 = r11.entrySet().iterator();
            int r16 = 0;
            boolean r17 = false;
        L15:
            if (r15.hasNext() == false) goto L24;
            Map.Entry<K, V> r18 = r15.next();
            JsonElement r19 = this.keyTypeAdapter.toJsonTree(r18.getKey());
            r13.add(r19);
            r14.add(r18.getValue());
            if (r19.isJsonArray() == false) goto L19;
        L22:
            boolean r20 = true;
        L23:
            r17 = r17 | r20;
            goto L15
        L19:
            if (r19.isJsonObject() == true) goto L22;
            r20 = false;
            goto L23
        L24:
            if (r17 == false) goto L29;
            r10.beginArray();
            int r21 = r13.size();
        L26:
            if (r16 >= r21) goto L28;
            r10.beginArray();
            Streams.write((JsonElement) r13.get(r16), r10);
            this.valueTypeAdapter.write(r10, (V) r14.get(r16));
            r10.endArray();
            r16 = r16 + 1;
            goto L26
        L28:
            r10.endArray();
            return;
        L29:
            r10.beginObject();
            int r22 = r13.size();
        L30:
            if (r16 >= r22) goto L32;
            r10.name(keyToString((JsonElement) r13.get(r16)));
            this.valueTypeAdapter.write(r10, (V) r14.get(r16));
            r16 = r16 + 1;
            goto L30
        L32:
            r10.endObject();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor r5, boolean r10) {
        this.constructorConstructor = r5;
        this.complexMapKeySerialization = r10;
    }

    private TypeAdapter<?> getKeyAdapter(Gson r5, Type r10) {
        if (r10 == Boolean.TYPE) goto L9;
        if (r10 == Boolean.class) goto L9;
        return r5.getAdapter(TypeToken.get(r10));
    L9:
        return TypeAdapters.BOOLEAN_AS_STRING;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r10, TypeToken<T> r11) {
        Type r5 = r11.getType();
        Class<? super T> r12 = r11.getRawType();
        if (Map.class.isAssignableFrom(r12) == true) goto L6;
        return null;
    L6:
        Type[] r13 = GsonTypes.getMapKeyAndValueTypes(r5, r12);
        Type r14 = r13[0];
        Type r15 = r13[1];
        return new Adapter(this, new TypeAdapterRuntimeTypeWrapper(r10, getKeyAdapter(r10, r14), r14), new TypeAdapterRuntimeTypeWrapper(r10, r10.getAdapter(TypeToken.get(r15)), r15), this.constructorConstructor.get(r11, false));
    }
}
