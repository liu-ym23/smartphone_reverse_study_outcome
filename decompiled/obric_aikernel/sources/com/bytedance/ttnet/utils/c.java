package com.bytedance.ttnet.utils;

import com.bytedance.frameworks.baselib.network.http.util.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f2943a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f2944b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f2945c = true;

    public interface a {
        void a(String r10, a5.b r11);
    }

    public interface b {
        void a(String r10, String r11, String r12, a5.b r13);

        void b(String r10, String r11, int r12, boolean r13, JSONObject r14);
    }

    static {
    }

    public static void a(String r10, String r11, String r12, a5.b r13) {
        b r14 = f2943a;
        if (r14 == null) goto L6;
        r14.a(r10, r11, r12, r13);
        return;
    }

    public static a b() {
        return f2944b;
    }

    public static b c() {
        return f2943a;
    }

    public static void d(String r10, String r11, int r12, boolean r13, JSONObject r14) {
        b r15 = f2943a;
        if (r15 == null) goto L6;
        r15.b(r10, r11, r12, r13, r14);
        return;
    }

    public static void e(boolean r10) {
        f2945c = r10;
    }

    public static void f(b r10) {
        f2943a = r10;
    }

    public static String g(String r10) {
        if (f2945c == true) goto L11;
        return null;
    L11:
        if (i.b(r10).getHost().endsWith(com.bytedance.ttnet.b.a()) == false) goto L9;
        return String.valueOf(System.currentTimeMillis());
    L9:
        return null;
    }
}
