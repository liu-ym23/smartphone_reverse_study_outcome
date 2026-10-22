package com.bytedance.ies.abmock.datacenter.storage;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f2734a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static boolean f2735b = false;
    static boolean c = false;
    static boolean d = false;
    static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = true;
    public static boolean i = false;
    public static boolean j = false;
    private static int k = 20;
    private static a l;

    public interface a {
        String a(JsonObject r1);
    }

    static {
    }

    public static a a() {
        return l;
    }

    public static int b() {
        return k;
    }

    public static boolean c() {
        int r0 = k;
        if (r0 >= (-20)) goto L5;
        return false;
    L5:
        if (r0 > 19) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean d() {
        return true;
    }

    static boolean e() {
        return true;
    }

    static boolean f() {
        return l.c;
    }
}
