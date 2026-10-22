package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class StreamProcessor {
    public static int a(InputStream r5, int r10, boolean r11) {
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r10) goto L13;
        int r14 = r5.read();
        if (r14 == (-1)) goto L12;
        if (r11 == false) goto L9;
        int r15 = (r14 & 255) << (r12 * 8);
    L8:
        r13 = r13 | r15;
        r12 = r12 + 1;
        goto L3
    L9:
        r13 = r13 << 8;
        r15 = r14 & 255;
        goto L8
    L12:
        throw new IOException("no more bytes");
    L13:
        return r13;
    }
}
