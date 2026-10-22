package com.lynx.clay.embedding.android;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class SystemLoaderFaker {
    public SystemLoaderFaker() {
    }

    private static native boolean nativeLoadLibrary(String r0, String r1);

    public static boolean loadLibrary(String r0, String r1) {
        return nativeLoadLibrary(r0, r1);
    }
}
