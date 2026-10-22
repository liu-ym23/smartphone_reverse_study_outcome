package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class ListFieldSchemas {
    private static final ListFieldSchema FULL_SCHEMA = null;
    private static final ListFieldSchema LITE_SCHEMA = null;

    static {
        FULL_SCHEMA = loadSchemaForFullRuntime();
        LITE_SCHEMA = new ListFieldSchemaLite();
    }

    private ListFieldSchemas() {
    }

    public static ListFieldSchema full() {
        return FULL_SCHEMA;
    }

    public static ListFieldSchema lite() {
        return LITE_SCHEMA;
    }

    private static ListFieldSchema loadSchemaForFullRuntime() {
        if (Android.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        int r8 = ListFieldSchemaFull.f5188a;     // Catch: Exception -> L7
        return (ListFieldSchema) ListFieldSchemaFull.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L7:
        return null;
    }
}
