package com.bytedance.apm.e;

import com.bytedance.apm6.foundation.UnSampleListener;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1305a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1306b;
    private static c c;
    private static c d;
    private static volatile UnSampleListener e;

    static {
    }

    public static void a(String r1, String r2) {
        if (f1305a == false) goto L8;
        c r0 = c;
        if (r0 == null) goto L9;
        r0.a(r1, r2);
        return;
    L9:
        return;
    }

    public static void a(boolean r0) {
        f1305a = r0;
    }

    public static boolean a() {
        return f1306b;
    }

    public static void b(String r1, String r2) {
        if (f1305a == false) goto L8;
        c r0 = c;
        if (r0 == null) goto L9;
        r0.c(r1, r2);
        return;
    L9:
        return;
    }

    public static boolean b() {
        if (e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static c c() {
        return d;
    }

    public static void c(String r1, String r2) {
        if (f1306b == false) goto L8;
        c r0 = c;
        if (r0 == null) goto L9;
        r0.c(r1, r2);
        return;
    L9:
        return;
    }

    public static void d(String r1, String r2) {
        if (e == null) goto L6;
        e.onLog(r1, r2);
        return;
    }
}
