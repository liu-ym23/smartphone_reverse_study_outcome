package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class IoUtil {
    private IoUtil() {
    }

    public static void close(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
