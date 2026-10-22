package com.google.protobuf;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class Protobuf {
    private static final Protobuf INSTANCE = null;
    private final ConcurrentMap<Class<?>, Schema<?>> schemaCache;
    private final SchemaFactory schemaFactory;

    static {
        INSTANCE = new Protobuf();
    }

    private Protobuf() {
        this.schemaCache = new ConcurrentHashMap();
        this.schemaFactory = new ManifestSchemaFactory();
    }

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public int getTotalSchemaSize() {
        Iterator<Schema<?>> r8 = this.schemaCache.values().iterator();
        int r10 = 0;
    L4:
        if (r8.hasNext() == false) goto L8;
        Schema<?> r11 = r8.next();
        if ((r11 instanceof MessageSchema) == false) goto L4;
        r10 = r10 + ((MessageSchema) r11).getSchemaSize();
        goto L4
    L8:
        return r10;
    }

    public <T> boolean isInitialized(T r8) {
        return schemaFor(r8).isInitialized(r8);
    }

    public <T> void makeImmutable(T r8) {
        schemaFor(r8).makeImmutable(r8);
    }

    public <T> void mergeFrom(T r8, Reader r10) {
        mergeFrom(r8, r10, ExtensionRegistryLite.getEmptyRegistry());
    }

    public Schema<?> registerSchema(Class<?> r8, Schema<?> r10) {
        Internal.checkNotNull(r8, "messageType");
        Internal.checkNotNull(r10, "schema");
        return this.schemaCache.putIfAbsent(r8, r10);
    }

    @CanIgnoreReturnValue
    public Schema<?> registerSchemaOverride(Class<?> r8, Schema<?> r10) {
        Internal.checkNotNull(r8, "messageType");
        Internal.checkNotNull(r10, "schema");
        return this.schemaCache.put(r8, r10);
    }

    public <T> Schema<T> schemaFor(Class<T> r8) {
        Internal.checkNotNull(r8, "messageType");
        Schema<T> r10 = (Schema) this.schemaCache.get(r8);
        if (r10 != null) goto L8;
        Schema<T> r11 = this.schemaFactory.createSchema(r8);
        Schema<T> r12 = (Schema<T>) registerSchema(r8, r11);
        if (r12 != null) goto L7;
        return r11;
    L7:
        return r12;
    L8:
        return r10;
    }

    public <T> void writeTo(T r8, Writer r10) {
        schemaFor(r8).writeTo(r8, r10);
    }

    public <T> void mergeFrom(T r8, Reader r10, ExtensionRegistryLite r11) {
        schemaFor(r8).mergeFrom(r8, r10, r11);
    }

    public <T> Schema<T> schemaFor(T r8) {
        return schemaFor(r8.getClass());
    }
}
