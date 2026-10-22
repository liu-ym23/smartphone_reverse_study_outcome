package com.bytedance.monitor.collector;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f2875a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f2876b = -1;

    static {
    }

    public static long a() {
        if (f2876b != (-1)) goto L6;
        f2876b = 1000 / b();
    L6:
        return f2876b;
    }

    public static long a(long r5) {
        long r0 = f2875a;
        if (r0 <= 0) goto L6;
        return r0;
    L6:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        long r1 = Os.sysconf(OsConstants._SC_CLK_TCK);
    L13:
        if (r1 <= 0) goto L15;
        r5 = r1;
    L15:
        f2875a = r5;
        return r5;
    L9:
        if (Build.VERSION.SDK_INT < 14) goto L11;
        r1 = a("_SC_CLK_TCK", r5);
        goto L13
    L11:
        r1 = r5;
        goto L13
    }

    private static long a(String r8, long r9) {
        int r10 = ZeusTransformUtils.forName("libcore.io.OsConstants", "com.obric.memorydata.plugin").getField(r8).getInt(null);     // Catch: Throwable -> L5
        Class r2 = ZeusTransformUtils.forName("libcore.io.Libcore", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Class r3 = ZeusTransformUtils.forName("libcore.io.Os", "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r1 = r2.getField("os").get(null);     // Catch: Throwable -> L5
        return ((Long) ZeusTransformUtils.preCheckCast(r3.getMethod("sysconf", new Class[]{Integer.TYPE}).invoke(r1, new Object[]{Integer.valueOf(r10)}), Long.class, "com.obric.memorydata.plugin")).longValue();
    L5:
        th = move-exception;
        th.printStackTrace();
        return r9;
    }

    public static long b() {
        return a(100);
    }
}
