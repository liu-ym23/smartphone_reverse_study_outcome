package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
final class ExtensionRegistryFactory {
    static final Class<?> EXTENSION_REGISTRY_CLASS = null;
    static final String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    static {
        EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    }

    public ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite create() {
        ExtensionRegistryLite r8 = invokeSubclassFactory("newInstance");
        if (r8 == null) goto L6;
        return r8;
    L6:
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite createEmpty() {
        ExtensionRegistryLite r8 = invokeSubclassFactory("getEmptyRegistry");
        if (r8 == null) goto L6;
        return r8;
    L6:
        return ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    private static final ExtensionRegistryLite invokeSubclassFactory(String r8) {
        Class<?> r10 = EXTENSION_REGISTRY_CLASS;
        if (r10 != null) goto L9;
        return null;
    L9:
        return (ExtensionRegistryLite) r10.getDeclaredMethod(r8, new Class[0]).invoke(null, new Object[0]);
    L8:
        return null;
    }

    public static boolean isFullRegistry(ExtensionRegistryLite r8) {
        if (Android.assumeLiteRuntime == true) goto L9;
        Class<?> r10 = EXTENSION_REGISTRY_CLASS;
        if (r10 == null) goto L9;
        if (r10.isAssignableFrom(r8.getClass()) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static Class<?> reflectExtensionRegistry() {
        ExtensionRegistry r8 = ExtensionRegistry.EMPTY_REGISTRY;     // Catch: ClassNotFoundException -> L4
        return ExtensionRegistry.class;
    L4:
        return null;
    }
}
