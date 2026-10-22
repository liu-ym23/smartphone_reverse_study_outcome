package com.larus.dora.impl.util;

import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class l0 {
    public static Boolean a;

    static {
    }

    public static boolean a() {
        PolarisFileWrapper r1 = new PolarisFileWrapper("/proc/self/cgroup");
        StringBuilder r2 = new StringBuilder();
        BufferedReader r4 = new BufferedReader(new PolarisFileReaderWrapper(r1));     // Catch: IOException -> L15
    L45:
        String r3 = r4.readLine();     // Catch: Throwable -> L10
        if (r3 == null) goto L7;
        r2.append(r3);     // Catch: Throwable -> L10
        r2.append("\n");     // Catch: Throwable -> L10
        goto L45
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r4, null);     // Catch: IOException -> L15
        String r6 = r2.toString();     // Catch: IOException -> L15
    L18:
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == false) goto L27;
        g49.d.e("MachineUtils", "don't allow read cgroup info，default non-container environment or insufficient permissions");
        return false;
    L27:
        g49.d.d("MachineUtils", "full cgroup info:\n" + r6);
        String[] r8 = {"isulad", "lxc", "zhuoyi", "com.huawei.zhuoyitong"};
        int r9 = 0;
    L29:
        if (r9 >= 4) goto L36;
        String r10 = r8[r9];
        if (StringsKt.contains$default(r6.toLowerCase(Locale.ROOT), r10, false, 2, null) == true) goto L32;
        r9 = r9 + 1;
        goto L29
    L32:
        g49.d.d("MachineUtils", "environmental characteristics detected: " + r10);
        return true;
    L36:
        if (StringsKt.contains$default(r6, "/lxc/", false, 2, null) == false) goto L38;
    L42:
        g49.d.d("MachineUtils", "the container path structure is detected and determined to be the zyt environment.");
        return true;
    L38:
        if (StringsKt.contains$default(r6, "/isulad/", false, 2, null) == true) goto L42;
        g49.d.d("MachineUtils", "no obvious zyt-related features were detected, and it was determined to be a native environment or a non-container environment.");
        return false;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L24
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: IOException -> L15
        throw th;     // Catch: IOException -> L15
    L15:
        e = move-exception;
        g49.d.c("MachineUtils", "Error reading cgroup file", e);
        r6 = null;
        goto L18
    }
}
