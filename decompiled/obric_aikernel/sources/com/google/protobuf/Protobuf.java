package com.google.protobuf;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
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
        Iterator<Schema<?>> r10 = this.schemaCache.values().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L8;
        Schema<?> r12 = r10.next();
        if ((r12 instanceof MessageSchema) == false) goto L4;
        r11 = r11 + ((MessageSchema) r12).getSchemaSize();
        goto L4
    L8:
        return r11;
    }

    <T> boolean isInitialized(T r10) {
        return schemaFor(r10).isInitialized(r10);
    }

    public <T> void makeImmutable(T r10) {
        schemaFor(r10).makeImmutable(r10);
    }

    public <T> void mergeFrom(T r10, Reader r11) {
        mergeFrom(r10, r11, ExtensionRegistryLite.getEmptyRegistry());
    }

    public <T> void mergeFrom(T r10, Reader r11, ExtensionRegistryLite r12) {
        schemaFor(r10).mergeFrom(r10, r11, r12);
    }

    public Schema<?> registerSchema(Class<?> r10, Schema<?> r11) {
        Internal.checkNotNull(r10, "messageType");
        Internal.checkNotNull(r11, "schema");
        return this.schemaCache.putIfAbsent(r10, r11);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> r10, Schema<?> r11) {
        Internal.checkNotNull(r10, "messageType");
        Internal.checkNotNull(r11, "schema");
        return this.schemaCache.put(r10, r11);
    }

    public <T> Schema<T> schemaFor(Class<T> r10) {
        Internal.checkNotNull(r10, "messageType");
        Schema<T> r11 = (Schema) this.schemaCache.get(r10);
        if (r11 != null) goto L8;
        Schema<T> r12 = this.schemaFactory.createSchema(r10);
        Schema<T> r13 = (Schema<T>) registerSchema(r10, r12);
        if (r13 != null) goto L7;
        return r12;
    L7:
        return r13;
    L8:
        return r11;
    }

    public <T> Schema<T> schemaFor(T r10) {
        return schemaFor(r10.getClass());
    }

    public <T> void writeTo(T r10, Writer r11) {
        schemaFor(r10).writeTo(r10, r11);
    }
}
