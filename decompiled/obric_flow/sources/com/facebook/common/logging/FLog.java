package com.facebook.common.logging;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FLog {
    public static void a(Class r5, String r10, Integer r11, Object r12, Object r13) {
        FLogDefaultLoggingDelegate r14 = FLogDefaultLoggingDelegate.f7658a;
        if (r14.a(2) == false) goto L8;
        String r15 = String.format(null, r10, new Object[]{r11, r12, r13});
        if (r14.a(2) == false) goto L9;
        Log.println(2, FLogDefaultLoggingDelegate.a(r5.getSimpleName()), r15);
        return;
    L9:
        return;
    }

    public static void b(String r5, String r10) {
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L6;
        Log.println(6, FLogDefaultLoggingDelegate.a(r5), r10);
        return;
    }

    public static void a(Exception r5, String r10, Object... r11) {
        FLogDefaultLoggingDelegate r12 = FLogDefaultLoggingDelegate.f7658a;
        if (r12.a(5) == false) goto L8;
        String r13 = String.format(null, r10, r11);
        if (r12.a(5) == false) goto L9;
        FLogDefaultLoggingDelegate.a(5, "BufferedDiskCache", r13, r5);
        return;
    L9:
        return;
    }

    public static void a(Class r5, String r10, Object r11) {
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L6;
        String r12 = r5.getSimpleName();
        String r13 = String.format(null, r10, new Object[]{r11});
        Log.println(2, FLogDefaultLoggingDelegate.a(r12), r13);
        return;
    }

    public static void a(Class r5, String r10, Object r11, Object r12) {
        if (FLogDefaultLoggingDelegate.f7658a.a(2) == false) goto L6;
        String r13 = r5.getSimpleName();
        String r14 = String.format(null, r10, new Object[]{r11, r12});
        Log.println(2, FLogDefaultLoggingDelegate.a(r13), r14);
        return;
    }

    public static void a(String r5, String r10) {
        if (FLogDefaultLoggingDelegate.f7658a.a(3) == false) goto L6;
        Log.println(3, FLogDefaultLoggingDelegate.a(r5), r10);
        return;
    }

    public static void a(Class r5, String r10) {
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L6;
        Log.println(6, FLogDefaultLoggingDelegate.a(r5.getSimpleName()), r10);
        return;
    }

    public static void a(String r5, String r10, Throwable r11) {
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L6;
        FLogDefaultLoggingDelegate.a(6, r5, r10, r11);
        return;
    }

    public static void a(String r5, String r10, Object... r11) {
        if (FLogDefaultLoggingDelegate.f7658a.a(6) == false) goto L6;
        String r12 = String.format(null, r10, r11);
        Log.println(6, FLogDefaultLoggingDelegate.a(r5), r12);
        return;
    }
}
