package com.ss.android.lark.chat.base.model.dispatch;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i {
    public static long a;
    public static long b;
    public static int c;
    public static PreprocessParams d;
    public static boolean e;
    public static long f;
    public static long g;
    public static int h;

    static {
    }

    public static void a() {
        a = 0;
        b = 0;
        c = 0;
        d = null;
        e = false;
        f = 0;
        g = 0;
        h = 0;
    }

    public static void b(boolean r8) {
        long r0 = System.currentTimeMillis();
        if (a != 0) goto L5;
        a = r0;
    L5:
        b = r0;
        if (r8 == false) goto L8;
        g += r0 - f;
        h++;
    L8:
        d = null;
        f = 0;
        e = false;
    }
}
