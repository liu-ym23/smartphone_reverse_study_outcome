package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JfifUtil {
    public static int a(int r5) {
        if (r5 != 3) goto L5;
        return 180;
    L5:
        if (r5 != 6) goto L7;
        return 90;
    L7:
        if (r5 == 8) goto L10;
        return 0;
    L10:
        return 270;
    }

    public static int a(InputStream r5) {
        r5.getClass();     // Catch: IOException -> L32
    L5:
        if (StreamProcessor.a(r5, 1, false) != 255) goto L27;
        int r10 = 255;
    L7:
        if (r10 != 255) goto L10;
        r10 = StreamProcessor.a(r5, 1, false);     // Catch: IOException -> L32
        goto L7
    L10:
        if (r10 == 225) goto L11;
        if (r10 == 216) goto L5;
        if (r10 == 1) goto L5;
        if (r10 == 217) goto L27;
        if (r10 == 218) goto L27;
        r5.skip(StreamProcessor.a(r5, 2, false) - 2);     // Catch: IOException -> L32
        goto L5
    L11:
        int r11 = StreamProcessor.a(r5, 2, false);     // Catch: IOException -> L32
        if ((r11 - 2) <= 6) goto L27;
        int r12 = StreamProcessor.a(r5, 4, false);     // Catch: IOException -> L32
        int r13 = StreamProcessor.a(r5, 2, false);     // Catch: IOException -> L32
        int r14 = r11 - 8;     // Catch: IOException -> L32
        if (r12 != 1165519206) goto L27;
        if (r13 != 0) goto L27;
    L28:
        if (r14 != 0) goto L30;
        return 0;
    L30:
        return TiffUtil.a(r5, r14);
    L27:
        r14 = 0;
    L32:
        return 0;
    }
}
