package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor r1) {
        this.constructorConstructor = r1;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r4, TypeToken<T> r5) {
        JsonAdapter r0 = (JsonAdapter) ZeusTransformUtils.preCheckCast(r5.getRawType().getAnnotation(JsonAdapter.class), JsonAdapter.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, r4, r5, r0);
    }

    TypeAdapter<?> getTypeAdapter(ConstructorConstructor r9, Gson r10, TypeToken<?> r11, JsonAdapter r12) {
        JsonAdapter r8 = (JsonAdapter) ZeusTransformUtils.wrapperContextForParams(r12, JsonAdapter.class, "com.obric.memorydata.plugin");
        Object r13 = r9.get(TypeToken.get(r8.value())).construct();
        boolean r7 = r8.nullSafe();
        if (ZeusTransformUtils.instanceOf(r13, TypeAdapter.class) == false) goto L6;
        TypeAdapter<?> r14 = (TypeAdapter) ZeusTransformUtils.preCheckCast(r13, TypeAdapter.class, "com.obric.memorydata.plugin");
    L24:
        if (r14 == null) goto L28;
        if (r7 == true) goto L27;
        return r14;
    L27:
        return r14.nullSafe();
    L28:
        return r14;
    L6:
        if (ZeusTransformUtils.instanceOf(r13, TypeAdapterFactory.class) == false) goto L9;
        r14 = ((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(r13, TypeAdapterFactory.class, "com.obric.memorydata.plugin")).create(r10, r11);
        goto L24
    L9:
        if (ZeusTransformUtils.instanceOf(r13, JsonSerializer.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(r13, JsonDeserializer.class) == true) goto L16;
        throw new IllegalArgumentException("Invalid attempt to bind an instance of " + r13.getClass().getName() + " as a @JsonAdapter for " + r11.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
    L16:
        if (ZeusTransformUtils.instanceOf(r13, JsonSerializer.class) == false) goto L18;
        JsonSerializer r2 = (JsonSerializer) ZeusTransformUtils.preCheckCast(r13, JsonSerializer.class, "com.obric.memorydata.plugin");
    L20:
        if (ZeusTransformUtils.instanceOf(r13, JsonDeserializer.class) == false) goto L22;
        JsonDeserializer r3 = (JsonDeserializer) ZeusTransformUtils.preCheckCast(r13, JsonDeserializer.class, "com.obric.memorydata.plugin");
    L23:
        r14 = new TreeTypeAdapter(r2, r3, r10, r11, null, r7);
        r7 = false;
        goto L24
    L22:
        r3 = null;
        goto L23
    L18:
        r2 = null;
        goto L20
    }
}
