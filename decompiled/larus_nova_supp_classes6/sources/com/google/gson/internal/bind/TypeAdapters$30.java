package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class TypeAdapters$30 implements TypeAdapterFactory {
    final /* synthetic */ TypeToken val$type;
    final /* synthetic */ TypeAdapter val$typeAdapter;

    public TypeAdapters$30(TypeToken r1, TypeAdapter r2) {
        this.val$type = r1;
        this.val$typeAdapter = r2;
    }

    public <T> TypeAdapter<T> create(Gson r1, TypeToken<T> r2) {
        if (r2.equals(this.val$type) == true) goto L7;
        return null;
    L7:
        return this.val$typeAdapter;
    }
}
