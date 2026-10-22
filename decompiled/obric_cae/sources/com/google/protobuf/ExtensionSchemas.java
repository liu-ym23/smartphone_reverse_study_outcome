package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
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

    public static ExtensionSchema<?> full() {
        ExtensionSchema<?> r8 = FULL_SCHEMA;
        if (r8 == null) goto L6;
        return r8;
    L6:
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        if (Android.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        int r8 = ExtensionSchemaFull.f5186a;     // Catch: Exception -> L7
        return (ExtensionSchema) ExtensionSchemaFull.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L7:
        return null;
    }
}
