package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
class Util {
    Util() {
    }

    static String getAppVersion(Context r10) {
        String r11 = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 0).versionName;     // Catch: Exception -> L4
    L6:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        return "unknown";
    L11:
        return r11;
    L4:
        r11 = null;
        goto L6
    }

    static String getProcessName(Context r10) {
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/self/cmdline"));     // Catch: Throwable -> L14 Exception -> L19
        String r12 = r11.readLine();     // Catch: Throwable -> L12 Exception -> L26
        if (TextUtils.isEmpty(r12) == true) goto L27;
        String r13 = r12.trim();     // Catch: Throwable -> L12 Exception -> L26
        if (TextUtils.isEmpty(r13) == true) goto L27;
        r11.close();     // Catch: Exception -> L23
    L9:
        return r13;
    L27:
        r11.close();     // Catch: Exception -> L24
    L22:
        return null;
    L12:
        Throwable th = th;
    L16:
        if (r11 != null) goto L29;
    L18:
        throw th;
    L29:
        r11.close();     // Catch: Exception -> L25
    L20:
        if (r11 == null) goto L22;
    L19:
        r11 = null;
    L14:
        th = move-exception;
        r11 = null;
        th = th;
        goto L16
    }
}
