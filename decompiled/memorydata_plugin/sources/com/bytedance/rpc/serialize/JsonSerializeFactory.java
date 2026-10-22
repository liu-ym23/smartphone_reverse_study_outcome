package com.bytedance.rpc.serialize;

import com.bytedance.rpc.log.Logger;
import com.bytedance.rpc.serialize.json.AdapterFactoryFiller;
import com.bytedance.rpc.serialize.json.ExcludeFieldStrategy;
import com.bytedance.rpc.serialize.json.GsonBuilderFiller;
import com.bytedance.rpc.serialize.json.JsonDeserializer;
import com.bytedance.rpc.serialize.json.JsonSerializer;
import com.bytedance.rpc.serialize.json.TypeAdapterFactoryContainer;
import com.bytedance.rpc.transport.TransportInput;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class JsonSerializeFactory implements SerializeFactory {
    private AdapterFactoryFiller mAdapterFactoryFiller;
    private volatile Gson mGson;
    private GsonBuilderFiller mGsonBuilderFiller;
    private final TypeAdapterFactoryContainer mTypeAdapterFactoryContainer;

    public static class Builder {
        private AdapterFactoryFiller mAdapterFactoryFiller;
        private GsonBuilderFiller mGsonBuilderFiller;

        public Builder() {
        }

        public JsonSerializeFactory build() {
            JsonSerializeFactory r0 = new JsonSerializeFactory();
            JsonSerializeFactory.access$002(r0, this.mGsonBuilderFiller);
            JsonSerializeFactory.access$102(r0, this.mAdapterFactoryFiller);
            return r0;
        }

        public Builder setAdapterFactoryFiller(AdapterFactoryFiller r3) {
            this.mAdapterFactoryFiller = (AdapterFactoryFiller) ZeusTransformUtils.wrapperContextForParams(r3, AdapterFactoryFiller.class, "com.obric.memorydata.plugin");
            return this;
        }

        public Builder setGsonBuilderFiller(GsonBuilderFiller r3) {
            this.mGsonBuilderFiller = (GsonBuilderFiller) ZeusTransformUtils.wrapperContextForParams(r3, GsonBuilderFiller.class, "com.obric.memorydata.plugin");
            return this;
        }
    }

    public JsonSerializeFactory() {
        this.mGson = null;
        this.mTypeAdapterFactoryContainer = new TypeAdapterFactoryContainer();
    }

    static /* synthetic */ GsonBuilderFiller access$002(JsonSerializeFactory r2, GsonBuilderFiller r3) {
        GsonBuilderFiller r4 = (GsonBuilderFiller) ZeusTransformUtils.wrapperContextForParams(r3, GsonBuilderFiller.class, "com.obric.memorydata.plugin");
        r2.mGsonBuilderFiller = r4;
        return r4;
    }

    static /* synthetic */ AdapterFactoryFiller access$102(JsonSerializeFactory r2, AdapterFactoryFiller r3) {
        AdapterFactoryFiller r4 = (AdapterFactoryFiller) ZeusTransformUtils.wrapperContextForParams(r3, AdapterFactoryFiller.class, "com.obric.memorydata.plugin");
        r2.mAdapterFactoryFiller = r4;
        return r4;
    }

    private void decorateGsonBuilder(GsonBuilder r3) {
        GsonBuilderFiller r0 = this.mGsonBuilderFiller;
        if (r0 == null) goto L5;
        r0.fill(r3);
        this.mGsonBuilderFiller = null;
    L5:
        r3.addSerializationExclusionStrategy(new ExcludeFieldStrategy(true));
        r3.addDeserializationExclusionStrategy(new ExcludeFieldStrategy(false));
        r3.registerTypeAdapterFactory(this.mTypeAdapterFactoryContainer);
    }

    private void fillFactory(ConstructorConstructor r4) {
        if (this.mAdapterFactoryFiller == null) goto L8;
        ArrayList r0 = new ArrayList();
        this.mAdapterFactoryFiller.fill(r4, r0);
        this.mAdapterFactoryFiller = null;
        Iterator r5 = r0.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        TypeAdapterFactory r1 = (TypeAdapterFactory) ZeusTransformUtils.preCheckCast(r5.next(), TypeAdapterFactory.class, "com.obric.memorydata.plugin");
        this.mTypeAdapterFactoryContainer.addFactory(r1);
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Deserializer getDeserializer(TransportInput r3, Type r4) {
        TransportInput r5 = (TransportInput) ZeusTransformUtils.wrapperContextForParams(r3, TransportInput.class, "com.obric.memorydata.plugin");
        Type r6 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        return new JsonDeserializer(getGson(), r5, r6);
    }

    public Gson getGson() {
        if (this.mGson != null) goto L20;
        monitor-enter(SerializeManager.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mGson != null) goto L14;
        GsonBuilder r1 = new GsonBuilder();     // Catch: Throwable -> L16
        decorateGsonBuilder(r1);     // Catch: Throwable -> L16
        this.mGson = r1.create();     // Catch: Throwable -> L16
        if (this.mAdapterFactoryFiller == null) goto L14;
        Field r2 = this.mGson.getClass().getDeclaredField("constructorConstructor");     // Catch: Exception -> L12 Throwable -> L16
        r2.setAccessible(true);     // Catch: Exception -> L12 Throwable -> L16
        fillFactory((ConstructorConstructor) ZeusTransformUtils.preCheckCast(r2.get(this.mGson), ConstructorConstructor.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        Logger.e(e);     // Catch: Throwable -> L16
    L14:
        monitor-exit(SerializeManager.class);     // Catch: Throwable -> L16
    L20:
        return this.mGson;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public SerializeType getSerializeType() {
        return SerializeType.JSON;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Serializer getSerializer(Object r2, SerializeType r3) {
        return new JsonSerializer(getGson(), r2, r3);
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public boolean isReflectSupported() {
        return true;
    }
}
