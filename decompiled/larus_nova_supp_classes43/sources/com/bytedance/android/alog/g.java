package com.bytedance.android.alog;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import java.io.BufferedReader;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static String a() {
        BufferedReader r0 = null;
        BufferedReader r1 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L13 Exception -> L17
        String r10 = r1.readLine();     // Catch: Throwable -> L10 Exception -> L12
        if (TextUtils.isEmpty(r10) == true) goto L24;
        String r11 = r10.trim();     // Catch: Throwable -> L10 Exception -> L12
        if (TextUtils.isEmpty(r11) == true) goto L24;
        r1.close();     // Catch: Exception -> L21
    L9:
        return r11;
    L24:
        r1.close();     // Catch: Exception -> L22
    L20:
        return null;
    L10:
        th = move-exception;
        th = th;
        r0 = r1;
    L14:
        if (r0 != null) goto L28;
    L16:
        throw th;
    L28:
        r0.close();     // Catch: Exception -> L23
    L18:
        if (r1 == null) goto L20;
    L17:
        r1 = null;
    L13:
        th = th;
        goto L14
    }
}
