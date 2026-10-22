package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1385a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f1386b = null;
    private static int c = 0;
    private static int d = 0;
    private static long e = 0;
    private static int f = 100;

    static {
    }

    public static void a() {
        SharedPreferences r0 = f1386b;
        if (r0 == null) goto L6;
        r0.edit().putInt("monitor_switch_config_first_flag", d).putLong("monitor_switch_config_atrace_flag", e).putInt("monitor_thread_info_count", f).apply();
        return;
    }

    public static void a(int r0) {
        if (r0 <= 0) goto L5;
        f = r0;
        return;
    }

    public static void a(int r1, int r2) {
        int r0 = d;
        d = (r2 & r1) + ((~r1) & r0);
    }

    public static void a(int r0, boolean r1) {
        if (r1 == false) goto L4;
        int r2 = r0 | d;
    L5:
        d = r2;
        return;
    L4:
        int r3 = d;
        r2 = (~r0) & r3;
        goto L5
    }

    public static void a(long r0) {
        e = r0;
    }

    public static synchronized void a(Context r4) {
        monitor-enter(a.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (f1385a == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f1385a = true;     // Catch: Throwable -> L17
        if (f1386b != null) goto L12;
        f1386b = r5.getSharedPreferences("monitor_switch_config", 0);     // Catch: Throwable -> L17
    L12:
        SharedPreferences r6 = f1386b;     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        int r7 = r6.getInt("monitor_switch_config_first_flag", 0);     // Catch: Throwable -> L17
        c = r7;     // Catch: Throwable -> L17
        d = r7;     // Catch: Throwable -> L17
        e = f1386b.getLong("monitor_switch_config_atrace_flag", 0);     // Catch: Throwable -> L17
        f = f1386b.getInt("monitor_thread_info_count", 100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(a.class);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public static long b() {
        return e;
    }

    public static boolean b(int r1) {
        if ((r1 & c) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int c() {
        return (c & (-536870912)) >>> 29;
    }

    public static int d() {
        return f;
    }
}
