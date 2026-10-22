package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
final class NewInstanceSchemas {
    private static final NewInstanceSchema FULL_SCHEMA = null;
    private static final NewInstanceSchema LITE_SCHEMA = null;

    static {
        FULL_SCHEMA = loadSchemaForFullRuntime();
        LITE_SCHEMA = new NewInstanceSchemaLite();
    }

    private NewInstanceSchemas() {
    }

    static NewInstanceSchema full() {
        return FULL_SCHEMA;
    }

    static NewInstanceSchema lite() {
        return LITE_SCHEMA;
    }

    private static NewInstanceSchema loadSchemaForFullRuntime() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        return (NewInstanceSchema) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("com.google.protobuf.NewInstanceSchemaFull", "com.obric.memorydata.plugin").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), NewInstanceSchema.class, "com.obric.memorydata.plugin");
    L7:
        return null;
    }
}
