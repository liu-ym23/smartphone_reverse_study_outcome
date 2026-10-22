package com.bytedance.monitor.collector;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.ArrayList;
import jg.b;
import jg.c;

/* JADX INFO: loaded from: classes2.dex */
public class BinderMonitor extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f6945a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f6946b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f6947c;

    static {
        f6945a = new ArrayList(200);
        f6946b = new Object();
        f6947c = 0;
    }

    public static ArrayList a() {
        ArrayList r5 = new ArrayList();
        Object r10 = f6946b;
        monitor-enter(r10);
        int r11 = 0;
    L6:
        if (r11 >= 200) goto L12;
        int r12 = ((f6947c - 1) + r11) % 200;     // Catch: Throwable -> L10
        ArrayList r13 = f6945a;     // Catch: Throwable -> L10
        if (r12 >= r13.size()) goto L12;
        r5.add(r13.get(((f6947c - 1) + r11) % 200));     // Catch: Throwable -> L10
        r11 = r11 + 1;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r5;
    }

    @Keep
    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    @Keep
    public static void saveBinderInfo(long r5, long r10, long r11) {
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        Object r13 = f6946b;
        monitor-enter(r13);
        ArrayList r14 = f6945a;     // Catch: Throwable -> L7
        if (r14.size() != 200) goto L9;
        c r15 = (c) r14.get(f6947c % 200);     // Catch: Throwable -> L7
        r15.f18322a = r5;     // Catch: Throwable -> L7
        r15.f18323b = r10;     // Catch: Throwable -> L7
        r15.f18324c = r11;     // Catch: Throwable -> L7
        r15.d = r12;     // Catch: Throwable -> L7
    L10:
        f6947c++;     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L9:
        c r16 = new c();     // Catch: Throwable -> L7
        r16.f18322a = r5;     // Catch: Throwable -> L7
        r16.f18323b = r10;     // Catch: Throwable -> L7
        r16.f18324c = r11;     // Catch: Throwable -> L7
        r16.d = r12;     // Catch: Throwable -> L7
        r14.add(r16);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
