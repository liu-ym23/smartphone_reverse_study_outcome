package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.d;
import com.bytedance.apm.util.g;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static long[] b() {
        long[] r0 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L8;
        File r1 = g.c(d.getContext());
        if (r1 != null) goto L7;
        return r0;
    L7:
        StatFs r2 = new StatFs(r1.getPath());
        long r3 = r2.getBlockSize();
        long r5 = r2.getBlockCount();
        long r4 = r2.getAvailableBlocks();
        r0[0] = ((r5 * r3) / 1024) / 1024;
        r0[1] = ((r3 * r4) / 1024) / 1024;
    L8:
        return r0;
    }

    public static String[] a() {
        String[] r2 = {NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy};
        BufferedReader r3 = null;
        PolarisFileReaderWrapper r4 = new PolarisFileReaderWrapper("/proc/cpuinfo");     // Catch: Throwable -> L16 IOException -> L20
        BufferedReader r1 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L14 IOException -> L24
        String[] r5 = r1.readLine().split("\\s+");     // Catch: Throwable -> L11 IOException -> L13
        int r6 = 2;
    L7:
        if (r6 >= r5.length) goto L9;
        r2[0] = r2[0] + r5[r6] + " ";     // Catch: Throwable -> L11 IOException -> L13
        r6 = r6 + 1;     // Catch: Throwable -> L11 IOException -> L13
        goto L7
    L9:
        r2[1] = r2[1] + r1.readLine().split("\\s+")[2];     // Catch: Throwable -> L11 IOException -> L13
        xu3.c.a(r1);
    L22:
        xu3.c.a(r4);
        return r2;
    L13:
        r3 = r1;
    L11:
        th = th;
        r3 = r1;
    L18:
        xu3.c.a(r3);
        xu3.c.a(r4);
        throw th;
    L14:
        th = th;
    L21:
        xu3.c.a(r3);
        goto L22
    L20:
        r4 = null;
    L16:
        th = th;
        r4 = null;
        goto L18
    }

    public static String[] c() {
        String[] r0 = {"null", "null", "null", "null"};
        BufferedReader r3 = null;
        PolarisFileReaderWrapper r4 = new PolarisFileReaderWrapper("/proc/version");     // Catch: Throwable -> L12 IOException -> L16
    L23:
        BufferedReader r1 = new BufferedReader(r4, 8192);     // Catch: Throwable -> L10 IOException -> L20
        goto L17
    L25:
        r0[0] = r1.readLine().split("\\s+")[2];     // Catch: Throwable -> L7 IOException -> L9
        xu3.c.a(r1);
    L18:
        xu3.c.a(r4);
        r0[1] = Build.VERSION.RELEASE;
        r0[2] = Build.MODEL;
        r0[3] = Build.DISPLAY;
        return r0;
    L9:
        r3 = r1;
    L7:
        th = th;
        r3 = r1;
    L14:
        xu3.c.a(r3);
        xu3.c.a(r4);
        throw th;
    L10:
        th = th;
    L17:
        xu3.c.a(r3);
    L16:
        r4 = null;
    L12:
        th = th;
        r4 = null;
        goto L14
    }
}
