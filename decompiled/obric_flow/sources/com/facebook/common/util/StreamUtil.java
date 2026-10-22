package com.facebook.common.util;

import com.facebook.common.memory.PooledByteArrayBufferedInputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class StreamUtil {
    public static void a(PooledByteArrayBufferedInputStream r5, long r10) {
        if (r10 < 0) goto L14;
    L5:
        if (r10 <= 0) goto L12;
        long r11 = r5.skip(r10);
        if (r11 > 0) goto L8;
        if (r5.read() == (-1)) goto L19;
        r11 = 1;
        goto L8
    L19:
        return;
    L8:
        r10 = r10 - r11;
        goto L5
    L12:
        return;
    L14:
        throw new IllegalArgumentException();
    }
}
