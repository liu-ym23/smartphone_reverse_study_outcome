package com.ttnet.org.chromium.base;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class StreamUtil {
    public StreamUtil() {
    }

    public static void closeQuietly(Closeable r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: IOException -> L6
        return;
    }

    public static void closeQuietly(ZipFile r10) {
        if (r10 != null) goto L7;
        return;
    L7:
        r10.close();     // Catch: IOException -> L6
        return;
    }
}
