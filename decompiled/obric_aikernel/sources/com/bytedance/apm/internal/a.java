package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f987a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SharedPreferences f988b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f989c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f990d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f991e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f992f = 100;

    static {
    }

    public static long a() {
        return f991e;
    }

    public static int b() {
        return f992f;
    }

    public static int c() {
        return (f989c & (-536870912)) >>> 29;
    }

    public static boolean d(int r10) {
        if ((r10 & f989c) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static synchronized void e(Context r10) {
        monitor-enter(a.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f987a == false) goto L9;
        monitor-exit(a.class);
        return;
    L9:
        f987a = true;     // Catch: Throwable -> L17
        if (f988b != null) goto L12;
        f988b = r10.getSharedPreferences("monitor_switch_config", 0);     // Catch: Throwable -> L17
    L12:
        SharedPreferences r11 = f988b;     // Catch: Throwable -> L17
        if (r11 == null) goto L15;
        int r12 = r11.getInt("monitor_switch_config_first_flag", 0);     // Catch: Throwable -> L17
        f989c = r12;     // Catch: Throwable -> L17
        f990d = r12;     // Catch: Throwable -> L17
        f991e = f988b.getLong("monitor_switch_config_atrace_flag", 0);     // Catch: Throwable -> L17
        f992f = f988b.getInt("monitor_thread_info_count", 100);     // Catch: Throwable -> L17
    L15:
        monitor-exit(a.class);
    }

    public static void f() {
        SharedPreferences r10 = f988b;
        if (r10 == null) goto L6;
        r10.edit().putInt("monitor_switch_config_first_flag", f990d).putLong("monitor_switch_config_atrace_flag", f991e).putInt("monitor_thread_info_count", f992f).apply();
        return;
    }

    public static void g(long r10) {
        f991e = r10;
    }

    public static void h(int r10) {
        if (r10 <= 0) goto L5;
        f992f = r10;
        return;
    }

    public static void i(int r10, int r11) {
        int r12 = f990d;
        f990d = (r11 & r10) + ((~r10) & r12);
    }

    public static void j(int r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = r10 | f990d;
    L5:
        f990d = r12;
        return;
    L4:
        int r13 = f990d;
        r12 = (~r10) & r13;
        goto L5
    }
}
