package com.bytedance.applog.filter;

/* JADX INFO: loaded from: classes.dex */
public class NativeFilterJNI {
    public NativeFilterJNI() {
    }

    public static native void nativeClearCache(String r8);

    public static native int nativeInitServerFilter(String r8, String r10);

    public static native boolean nativeIsEventAllowed(String r8, String r10);

    public static native boolean nativeIsServerFilterEmpty(String r8);

    public static native int nativeSetServerFilterConfig(String r8, String r10);
}
