package com.aiassistant.security.platformkey;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class PlatformKeyManager {
    private PlatformKeyManager() {
    }

    public static PlatformKeyManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public byte[] decrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public byte[] encrypt(Context r1, int r2, byte[] r3, byte[] r4, Bundle r5) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public byte[] exportPubKey(Context r1, Bundle r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
