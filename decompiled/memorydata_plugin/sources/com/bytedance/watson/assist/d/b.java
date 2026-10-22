package com.bytedance.watson.assist.d;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3390a;

    static {
        f3390a = Log.isLoggable("watson_assist", 3);
    }

    public static void a(String r1) {
        a("watson_assist", r1);
    }

    public static void a(String r1, String r2) {
        if (f3390a == false) goto L6;
        Log.d(r1, r2);
        return;
    }

    public static void b(String r1) {
        b("watson_assist", r1);
    }

    public static void b(String r0, String r1) {
        Log.i(r0, r1);
    }

    public static void c(String r1) {
        c("watson_assist", r1);
    }

    public static void c(String r0, String r1) {
        Log.w(r0, r1);
    }

    public static void d(String r1) {
        d("watson_assist", r1);
    }

    public static void d(String r0, String r1) {
        Log.e(r0, r1);
    }
}
