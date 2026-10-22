package com.bytedance.monitor.collector;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f2379a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f2380b = -1;

    static {
    }

    private static long a(String r10, long r11) {
        int r12 = Class.forName("libcore.io.OsConstants").getField(r10).getInt(null);     // Catch: Throwable -> L4
        Class<?> r13 = Class.forName("libcore.io.Libcore");     // Catch: Throwable -> L4
        Class<?> r14 = Class.forName("libcore.io.Os");     // Catch: Throwable -> L4
        Object r15 = r13.getField("os").get(null);     // Catch: Throwable -> L4
        return ((Long) r14.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r15, new Object[]{Integer.valueOf(r12)})).longValue();
    L4:
        th = move-exception;
        th.printStackTrace();
        return r11;
    }

    public static long b() {
        if (f2380b != (-1)) goto L6;
        f2380b = 1000 / c();
    L6:
        return f2380b;
    }

    public static long c() {
        return d(100);
    }

    public static long d(long r10) {
        long r11 = f2379a;
        if (r11 <= 0) goto L5;
        return r11;
    L5:
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 21) goto L9;
        long r13 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L13:
        if (r13 <= 0) goto L15;
        r10 = r13;
    L15:
        f2379a = r10;
        return r10;
    L9:
        if (r12 < 14) goto L11;
        r13 = a("_SC_CLK_TCK", r10);
        goto L13
    L11:
        r13 = r10;
        goto L13
    }
}
