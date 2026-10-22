package com.lynx.animax.composition;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXCompositionFactory {
    private native void nativeCreate(String r1, long r2);

    private native void nativeLoadJson(String r1, String r2, float r3, AnimaXCompositionNativeCallback r4);

    private native void nativeLoadUri(String r1, String r2, float r3, AnimaXCompositionNativeCallback r4);

    private native void nativeRelease();

    public AnimaXCompositionFactory() {
        new ConcurrentHashMap();
    }
}
