package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeAdapter<T> {

    /* JADX INFO: renamed from: com.google.gson.TypeAdapter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class NullSafeTypeAdapter extends TypeAdapter<T> {
        final /* synthetic */ TypeAdapter this$0;

        private NullSafeTypeAdapter(TypeAdapter r5) {
            this.this$0 = r5;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r5) throws IOException {
            if (r5.peek() != JsonToken.NULL) goto L7;
            r5.nextNull();
            return null;
        L7:
            return (T) this.this$0.read(r5);
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + this.this$0 + "]";
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r5, T r10) throws IOException {
            if (r10 != null) goto L4;
            r5.nullValue();
            return;
        L4:
            this.this$0.write(r5, r10);
        }

        public /* synthetic */ NullSafeTypeAdapter(TypeAdapter r5, AnonymousClass1 r10) {
            this(r5);
        }
    }

    public TypeAdapter() {
    }

    public final T fromJson(Reader r5) throws IOException {
        return read(new JsonReader(r5));
    }

    public final T fromJsonTree(JsonElement r5) {
        return read(new JsonTreeReader(r5));
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public final TypeAdapter<T> nullSafe() {
        if ((this instanceof NullSafeTypeAdapter) == false) goto L5;
        return this;
    L5:
        return new NullSafeTypeAdapter(this, null);
    }

    public abstract T read(JsonReader r5) throws IOException;

    public final void toJson(Writer r5, T r10) throws IOException {
        write(new JsonWriter(r5), r10);
    }

    public final JsonElement toJsonTree(T r5) {
        JsonTreeWriter r10 = new JsonTreeWriter();     // Catch: IOException -> L4
        write(r10, r5);     // Catch: IOException -> L4
        return r10.get();
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public abstract void write(JsonWriter r5, T r10) throws IOException;

    public final T fromJson(String r5) throws IOException {
        return fromJson(new StringReader(r5));
    }

    public final String toJson(T r5) {
        StringBuilder r10 = new StringBuilder();
        toJson(Streams.writerForAppendable(r10), r5);     // Catch: IOException -> L6
        return r10.toString();
    L6:
        e = move-exception;
        throw new JsonIOException(e);
    }
}
