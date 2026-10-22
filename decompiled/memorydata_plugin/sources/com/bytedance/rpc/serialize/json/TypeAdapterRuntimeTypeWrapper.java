package com.bytedance.rpc.serialize.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {
    private final Gson context;
    private final TypeAdapter<T> delegate;
    private final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson r3, TypeAdapter<T> r4, Type r5) {
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        this.context = r3;
        this.delegate = r4;
        this.type = r6;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type r2, Object r3) {
        Type r1 = (Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return r1;
    L5:
        if (r1 == Object.class) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, TypeVariable.class) == true) goto L11;
        if (ZeusTransformUtils.instanceOf(r1, Class.class) == true) goto L11;
        return r1;
    L11:
        return r3.getClass();
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader r1) {
        return this.delegate.read(r1);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter r4, T r5) {
        TypeAdapter<T> r0 = this.delegate;
        Type r1 = getRuntimeTypeIfMoreSpecific(this.type, r5);
        if (r1 == this.type) goto L10;
        r0 = this.context.getAdapter(TypeToken.get(r1));
        if (ZeusTransformUtils.instanceOf(r0, ReflectiveTypeAdapterFactory.Adapter.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(this.delegate, ReflectiveTypeAdapterFactory.Adapter.class) == true) goto L10;
        r0 = this.delegate;
    L10:
        r0.write(r4, r5);
    }
}
