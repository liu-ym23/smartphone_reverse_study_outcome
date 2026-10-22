package com.ss.android.lark.image.impl.compress2;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class IOUtils {
    public static void closeSafety(Closeable r0) {
        if (r0 == null) goto L10;
        r0.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
