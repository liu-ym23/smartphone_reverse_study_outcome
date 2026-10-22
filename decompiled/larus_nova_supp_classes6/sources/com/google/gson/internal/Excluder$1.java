package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Excluder$1<T> extends TypeAdapter<T> {
    private TypeAdapter<T> delegate;
    final /* synthetic */ Excluder this$0;
    final /* synthetic */ Gson val$gson;
    final /* synthetic */ boolean val$skipDeserialize;
    final /* synthetic */ boolean val$skipSerialize;
    final /* synthetic */ TypeToken val$type;

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> r0 = this.delegate;
        if (r0 != null) goto L7;
        TypeAdapter<T> r1 = this.val$gson.getDelegateAdapter(this.this$0, this.val$type);
        this.delegate = r1;
        return r1;
    L7:
        return r0;
    }

    public T read(JsonReader r2) throws IOException {
        if (this.val$skipDeserialize == false) goto L7;
        r2.skipValue();
        return null;
    L7:
        return (T) delegate().read(r2);
    }

    public void write(JsonWriter r2, T r3) throws IOException {
        if (this.val$skipSerialize == false) goto L6;
        r2.nullValue();
        return;
    L6:
        delegate().write(r2, r3);
    }

    public Excluder$1(Excluder r1, boolean r2, boolean r3, Gson r4, TypeToken r5) {
        this.this$0 = r1;
        this.val$skipDeserialize = r2;
        this.val$skipSerialize = r3;
        this.val$gson = r4;
        this.val$type = r5;
    }
}
