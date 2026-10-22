package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
final class Android {
    private static boolean ASSUME_ANDROID = false;
    private static final boolean IS_ROBOLECTRIC = false;
    private static final Class<?> MEMORY_CLASS = null;
    static boolean assumeLiteRuntime = false;

    static {
        MEMORY_CLASS = getClassForName("libcore.io.Memory");
        if (ASSUME_ANDROID == false) goto L5;
    L7:
        boolean r8 = false;
    L8:
        IS_ROBOLECTRIC = r8;
        return;
    L5:
        if (getClassForName("org.robolectric.Robolectric") == null) goto L7;
        r8 = true;
        goto L8
    }

    private Android() {
    }

    private static <T> Class<T> getClassForName(String r8) {
        return (Class<T>) Class.forName(r8);
    L4:
        return null;
    }

    public static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    public static boolean isOnAndroidDevice() {
        if (ASSUME_ANDROID == false) goto L5;
    L10:
        return true;
    L5:
        if (MEMORY_CLASS != null) goto L7;
    L9:
        return false;
    L7:
        if (IS_ROBOLECTRIC == true) goto L9;
        goto L9
    }
}
