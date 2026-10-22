package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class ByteStreams {
    public static int a(InputStream r5, byte[] r10, int r11) {
        r5.getClass();
        if (r11 < 0) goto L12;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        int r13 = r5.read(r10, r12, r11 - r12);
        if (r13 == (-1)) goto L10;
        r12 = r12 + r13;
    L10:
        return r12;
    L12:
        throw new IndexOutOfBoundsException("len is negative");
    }
}
