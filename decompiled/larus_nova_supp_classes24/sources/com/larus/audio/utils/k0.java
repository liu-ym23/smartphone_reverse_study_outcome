package com.larus.audio.utils;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class k0 {
    public static void a(Closeable r0) {
        if (r0 == null) goto L8;
        r0.close();     // Catch: IOException -> L5
        return;
    L9:
        return;
    }
}
