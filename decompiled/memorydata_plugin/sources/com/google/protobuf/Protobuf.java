package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class Protobuf {
    private static final Protobuf INSTANCE = null;
    static boolean assumeLiteRuntime;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache;
    private final SchemaFactory schemaFactory;

    static {
        INSTANCE = new Protobuf();
        assumeLiteRuntime = false;
    }

    private Protobuf() {
        this.schemaCache = new ConcurrentHashMap();
        this.schemaFactory = new ManifestSchemaFactory();
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    int getTotalSchemaSize() {
        Iterator<Schema<?>> r4 = this.schemaCache.values().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L8;
        Schema r1 = (Schema) ZeusTransformUtils.preCheckCast(r4.next(), Schema.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, MessageSchema.class) == false) goto L4;
        r0 = r0 + ((MessageSchema) ZeusTransformUtils.preCheckCast(r1, MessageSchema.class, "com.obric.memorydata.plugin")).getSchemaSize();
        goto L4
    L8:
        return r0;
    }

    <T> boolean isInitialized(T r1) {
        return schemaFor(r1).isInitialized(r1);
    }

    public <T> void makeImmutable(T r1) {
        schemaFor(r1).makeImmutable(r1);
    }

    public <T> void mergeFrom(T r3, Reader r4) {
        mergeFrom(r3, (Reader) ZeusTransformUtils.wrapperContextForParams(r4, Reader.class, "com.obric.memorydata.plugin"), ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T> void mergeFrom(T r3, Reader r4, ExtensionRegistryLite r5) {
        Reader r6 = (Reader) ZeusTransformUtils.wrapperContextForParams(r4, Reader.class, "com.obric.memorydata.plugin");
        schemaFor(r3).mergeFrom(r3, r6, r5);
    }

    public Schema<?> registerSchema(Class<?> r3, Schema<?> r4) {
        Schema<?> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        Internal.checkNotNull(r3, "messageType");
        Internal.checkNotNull(r5, "schema");
        return (Schema) ZeusTransformUtils.preCheckCast(this.schemaCache.putIfAbsent(r3, r5), Schema.class, "com.obric.memorydata.plugin");
    }

    public Schema<?> registerSchemaOverride(Class<?> r3, Schema<?> r4) {
        Schema<?> r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        Internal.checkNotNull(r3, "messageType");
        Internal.checkNotNull(r5, "schema");
        return (Schema) ZeusTransformUtils.preCheckCast(this.schemaCache.put(r3, r5), Schema.class, "com.obric.memorydata.plugin");
    }

    public <T> Schema<T> schemaFor(Class<T> r4) {
        Internal.checkNotNull(r4, "messageType");
        Schema<T> r0 = (Schema) ZeusTransformUtils.preCheckCast(this.schemaCache.get(r4), Schema.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        Schema<T> r1 = this.schemaFactory.createSchema(r4);
        Schema<T> r3 = (Schema<T>) registerSchema(r4, r1);
        if (r3 != null) goto L7;
        return r1;
    L7:
        return r3;
    L8:
        return r0;
    }

    public <T> Schema<T> schemaFor(T r1) {
        return schemaFor(r1.getClass());
    }

    public <T> void writeTo(T r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        schemaFor(r3).writeTo(r3, r5);
    }
}
