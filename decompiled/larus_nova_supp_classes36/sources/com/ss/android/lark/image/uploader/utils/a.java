package com.ss.android.lark.image.uploader.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    static {
    }

    public static void a(Closeable r3) {
        if (r3 == null) goto L10;
        r3.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        int r0 = c.a;
        c.b("IOUtils", "closeSafety err:" + e, null, false);
        return;
    }
}
