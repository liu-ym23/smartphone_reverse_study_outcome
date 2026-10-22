package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = null;
    private static final ExtensionSchema<?> LITE_SCHEMA = null;

    static {
        LITE_SCHEMA = new ExtensionSchemaLite();
        FULL_SCHEMA = loadSchemaForFullRuntime();
    }

    private ExtensionSchemas() {
    }

    static ExtensionSchema<?> full() {
        ExtensionSchema<?> r10 = FULL_SCHEMA;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        int r10 = ExtensionSchemaFull.f4290a;     // Catch: Exception -> L7
        return (ExtensionSchema) ExtensionSchemaFull.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L7:
        return null;
    }
}
