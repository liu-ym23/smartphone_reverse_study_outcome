package com.monitor.cloudmessage.utils;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.bytedance.apm.util.f;
import com.bytedance.apm6.util.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static String[] a() {
        String[] r10 = {"", ""};
        BufferedReader r11 = null;
        FileReader r12 = new FileReader("/proc/cpuinfo");     // Catch: Throwable -> L16 IOException -> L20
        BufferedReader r13 = new BufferedReader(r12, 8192);     // Catch: Throwable -> L14 IOException -> L24
        String[] r14 = r13.readLine().split("\\s+");     // Catch: Throwable -> L11 IOException -> L13
        int r15 = 2;
    L7:
        if (r15 >= r14.length) goto L9;
        r10[0] = r10[0] + r14[r15] + " ";     // Catch: Throwable -> L11 IOException -> L13
        r15 = r15 + 1;     // Catch: Throwable -> L11 IOException -> L13
        goto L7
    L9:
        r10[1] = r10[1] + r13.readLine().split("\\s+")[2];     // Catch: Throwable -> L11 IOException -> L13
        IOUtils.closeQuietly(r13);
    L22:
        IOUtils.closeQuietly(r12);
        return r10;
    L13:
        r11 = r13;
    L11:
        th = th;
        r11 = r13;
    L18:
        IOUtils.closeQuietly(r11);
        IOUtils.closeQuietly(r12);
        throw th;
    L14:
        th = th;
    L21:
        IOUtils.closeQuietly(r11);
        goto L22
    L20:
        r12 = null;
    L16:
        th = th;
        r12 = null;
        goto L18
    }

    public static long[] b() {
        long[] r10 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L8;
        File r11 = f.a(com.bytedance.apm.d.g());
        if (r11 != null) goto L7;
        return r10;
    L7:
        StatFs r12 = new StatFs(r11.getPath());
        long r13 = r12.getBlockSize();
        long r14 = r12.getBlockCount();
        long r15 = r12.getAvailableBlocks();
        r10[0] = ((r14 * r13) / 1024) / 1024;
        r10[1] = ((r13 * r15) / 1024) / 1024;
    L8:
        return r10;
    }

    public static long c() {
        return (Runtime.getRuntime().maxMemory() / 1024) / 1024;
    }

    public static long d() {
        return (Runtime.getRuntime().totalMemory() / 1024) / 1024;
    }

    public static String[] e() {
        String[] r10 = {"null", "null", "null", "null"};
        BufferedReader r11 = null;
        FileReader r12 = new FileReader("/proc/version");     // Catch: Throwable -> L12 IOException -> L16
    L23:
        BufferedReader r13 = new BufferedReader(r12, 8192);     // Catch: Throwable -> L10 IOException -> L20
        goto L17
    L25:
        r10[0] = r13.readLine().split("\\s+")[2];     // Catch: Throwable -> L7 IOException -> L9
        IOUtils.closeQuietly(r13);
    L18:
        IOUtils.closeQuietly(r12);
        r10[1] = Build.VERSION.RELEASE;
        r10[2] = Build.MODEL;
        r10[3] = Build.DISPLAY;
        return r10;
    L9:
        r11 = r13;
    L7:
        th = th;
        r11 = r13;
    L14:
        IOUtils.closeQuietly(r11);
        IOUtils.closeQuietly(r12);
        throw th;
    L10:
        th = th;
    L17:
        IOUtils.closeQuietly(r11);
    L16:
        r12 = null;
    L12:
        th = th;
        r12 = null;
        goto L14
    }
}
