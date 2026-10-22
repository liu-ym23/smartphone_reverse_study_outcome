package com.bytedance.security.e2ee;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class E2EEManager {
    private E2EEManager() {
    }

    public static E2EEManager getInstance() {
        throw new RuntimeException("Stub!!");
    }

    public E2EEResult processCmd(Context r1, int r2, byte[] r3, Bundle r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
