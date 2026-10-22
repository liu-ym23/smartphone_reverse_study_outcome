package com.bytedance.crash.util;

import android.content.Context;
import com.bytedance.crash.NpthBus;
import com.bytedance.librarian.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SoUtils {
    public SoUtils() {
    }

    public static boolean loadLib(String r3) {
        System.loadLibrary(r3);     // Catch: Throwable -> L5
        return true;
    L5:
        a.a(r3, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(NpthBus.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }
}
