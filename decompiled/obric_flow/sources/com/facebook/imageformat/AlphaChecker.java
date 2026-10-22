package com.facebook.imageformat;

import com.facebook.common.internal.ByteStreams;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AlphaChecker {
    public static void a(int r5, InputStream r10, byte[] r11) {
        r10.getClass();
        if (r11.length < r5) goto L15;
        if (r10.markSupported() == true) goto L16;
        ByteStreams.a(r10, r11, r5);
        return;
    L16:
        r10.mark(r5);     // Catch: Throwable -> L9
        ByteStreams.a(r10, r11, r5);     // Catch: Throwable -> L9
        r10.reset();
        return;
    L9:
        th = move-exception;
        r10.reset();
        throw th;
    L15:
        throw new IllegalArgumentException();
    }
}
