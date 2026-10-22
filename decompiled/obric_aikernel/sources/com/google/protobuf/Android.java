package com.google.protobuf;

/* JADX INFO: loaded from: classes2.dex */
final class Android {
    private static boolean ASSUME_ANDROID;
    private static final boolean IS_ROBOLECTRIC = false;
    private static final Class<?> MEMORY_CLASS = null;

    static {
        MEMORY_CLASS = getClassForName("libcore.io.Memory");
        if (ASSUME_ANDROID == false) goto L5;
    L7:
        boolean r10 = false;
    L8:
        IS_ROBOLECTRIC = r10;
        return;
    L5:
        if (getClassForName("org.robolectric.Robolectric") == null) goto L7;
        r10 = true;
        goto L8
    }

    private Android() {
    }

    private static <T> Class<T> getClassForName(String r10) {
        return (Class<T>) Class.forName(r10);
    L4:
        return null;
    }

    static Class<?> getMemoryClass() {
        return MEMORY_CLASS;
    }

    static boolean isOnAndroidDevice() {
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
