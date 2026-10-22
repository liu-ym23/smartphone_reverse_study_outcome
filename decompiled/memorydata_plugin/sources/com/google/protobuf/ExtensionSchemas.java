package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
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
        ExtensionSchema<?> r0 = FULL_SCHEMA;
        if (r0 == null) goto L6;
        return r0;
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
        return (ExtensionSchema) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.protobuf.ExtensionSchemaFull", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), ExtensionSchema.class, "com.obric.memorydata.plugin");
    L7:
        return null;
    }
}
