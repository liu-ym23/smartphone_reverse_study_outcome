package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite r10 = invokeSubclassFactory("newInstance");
        if (r10 == null) goto L6;
        return r10;
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite r10 = invokeSubclassFactory("getEmptyRegistry");
        if (r10 == null) goto L6;
        return r10;
    L6:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String r10) {
        Class<?> r11 = EXTENSION_REGISTRY_CLASS;
        if (r11 != null) goto L9;
        return null;
    L9:
        return (ExtensionRegistryLite) r11.getDeclaredMethod(r10, new Class[0]).invoke(null, new Object[0]);
    L8:
        return null;
    }

    static boolean isFullRegistry(ExtensionRegistryLite r10) {
        if (Protobuf.assumeLiteRuntime == true) goto L9;
        Class<?> r11 = EXTENSION_REGISTRY_CLASS;
        if (r11 == null) goto L9;
        if (r11.isAssignableFrom(r10.getClass()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    static Class<?> reflectExtensionRegistry() {
        ExtensionRegistry r10 = ExtensionRegistry.EMPTY_REGISTRY;     // Catch: ClassNotFoundException -> L4
        return ExtensionRegistry.class;
    L4:
        return null;
    }
}
