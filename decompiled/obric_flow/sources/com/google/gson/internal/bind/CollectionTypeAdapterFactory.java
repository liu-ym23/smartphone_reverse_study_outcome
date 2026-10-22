package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.GsonTypes;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;

        public Adapter(TypeAdapter<E> r5, ObjectConstructor<? extends Collection<E>> r10) {
            this.elementTypeAdapter = r5;
            this.constructor = r10;
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r5) throws IOException {
            return read(r5);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r5, Object r10) throws IOException {
            write(r5, (Collection) r10);
        }

        @Override // com.google.gson.TypeAdapter
        public Collection<E> read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L6;
            r5.nextNull();
            return null;
        L6:
            Collection<E> r10 = this.constructor.construct();
            r5.beginArray();
        L8:
            if (r5.hasNext() == false) goto L10;
            r10.add(this.elementTypeAdapter.read(r5));
            goto L8
        L10:
            r5.endArray();
            return r10;
        }

        public void write(JsonWriter r5, Collection<E> r10) throws IOException {
            if (r10 != null) goto L5;
            r5.nullValue();
            return;
        L5:
            r5.beginArray();
            Iterator<E> r11 = r10.iterator();
        L7:
            if (r11.hasNext() == false) goto L9;
            E r12 = r11.next();
            this.elementTypeAdapter.write(r5, r12);
            goto L7
        L9:
            r5.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor r5) {
        this.constructorConstructor = r5;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r5, TypeToken<T> r10) {
        Type r11 = r10.getType();
        Class<? super T> r12 = r10.getRawType();
        if (Collection.class.isAssignableFrom(r12) == true) goto L6;
        return null;
    L6:
        Type r13 = GsonTypes.getCollectionElementType(r11, r12);
        return new Adapter(new TypeAdapterRuntimeTypeWrapper(r5, r5.getAdapter(TypeToken.get(r13)), r13), this.constructorConstructor.get(r10, false));
    }
}
