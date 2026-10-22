package com.larksuite.framework.utils;

import com.ss.android.lark.log.Log;
import java.io.Closeable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o {
    public static final void a(Closeable... r4) {
        if (r4.length <= 0) goto L15;
        int r0 = r4.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L22;
        Closeable r2 = r4[r1];
        if (r2 == null) goto L14;
        r2.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Log.d("IoStreamUtils", th.toString());
    L14:
        r1 = r1 + 1;
        goto L6
    L22:
        return;
    }
}
