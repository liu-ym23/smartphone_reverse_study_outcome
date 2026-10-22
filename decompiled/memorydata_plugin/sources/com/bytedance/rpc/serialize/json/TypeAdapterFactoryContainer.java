package com.bytedance.rpc.serialize.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TypeAdapterFactoryContainer implements TypeAdapterFactory {
    private final List<TypeAdapterFactory> mFactories;

    public TypeAdapterFactoryContainer() {
        this.mFactories = new ArrayList();
    }

    public void addFactory(TypeAdapterFactory r3) {
        TypeAdapterFactory r4 = (TypeAdapterFactory) ZeusTransformUtils.wrapperContextForParams(r3, TypeAdapterFactory.class, "com.obric.memorydata.plugin");
        this.mFactories.add(r4);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r4, TypeToken<T> r5) {
        Iterator<TypeAdapterFactory> r3 = this.mFactories.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        TypeAdapter<T> r0 = ((TypeAdapterFactory) ZeusTransformUtils.preCheckCast(r3.next(), TypeAdapterFactory.class, "com.obric.memorydata.plugin")).create(r4, r5);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }
}
