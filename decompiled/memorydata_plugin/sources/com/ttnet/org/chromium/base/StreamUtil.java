package com.ttnet.org.chromium.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes6.dex */
public class StreamUtil {
    public StreamUtil() {
    }

    public static void closeQuietly(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        return;
    L8:
        r3.close();     // Catch: IOException -> L7
        return;
    }

    public static void closeQuietly(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: IOException -> L6
        return;
    }
}
