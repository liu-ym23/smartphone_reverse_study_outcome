package com.amap.api.location;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static String f498b;
    static boolean c;
    private static a d;
    private static long e;

    static {
        f497a = new Handler();
        f498b = null;
        e = 30000;
        c = true;
    }

    public static String a() {
        return f498b;
    }
}
