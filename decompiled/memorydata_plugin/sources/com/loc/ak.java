package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5292a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5293b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static ak f;

    public interface a {
        URLConnection a();
    }

    static {
    }

    public ak() {
        fn.e();
    }

    private static int a(bo r3, long r4) {
        d(r3);     // Catch: Throwable -> L21
        long r0 = 0;
        if (r4 == 0) goto L6;
        r0 = SystemClock.elapsedRealtime() - r4;     // Catch: Throwable -> L21
    L6:
        int r5 = r3.q();     // Catch: Throwable -> L21
        if (r3.s() != bo.a.d) goto L9;
    L20:
        return r5;
    L9:
        if (r3.s() == bo.a.e) goto L20;
        long r6 = r5;
        if (r0 >= r6) goto L19;
        long r7 = r6 - r0;     // Catch: Throwable -> L21
        if (r7 < 1000) goto L19;
        return (int) r7;
    L19:
        return Math.min(1000, r3.q());
    L21:
        return 5000;
    }

    public static ak a() {
        if (f != null) goto L6;
        f = new ak();
    L6:
        return f;
    }

    public static aq a(bo r1) {
        return a(r1, r1.v());
    }

    private static aq a(bo r0, bo.b r1, int r2) {
        d(r0);     // Catch: Throwable -> L4 l -> L7
        r0.a(r1);     // Catch: Throwable -> L4 l -> L7
        r0.c(r2);     // Catch: Throwable -> L4 l -> L7
        return new ao().a(r0);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new l("未知的错误");
    }

    @Deprecated
    private static aq a(bo r7, boolean r8) {
        d(r7);
        if (r8 == false) goto L5;
        bo.c r9 = bo.c.f5374b;
    L6:
        r7.a(r9);
        aq r10 = null;
        long r0 = 0;
        boolean r2 = false;
        if (b(r7) == false) goto L21;
        boolean r3 = c(r7);
        r0 = SystemClock.elapsedRealtime();     // Catch: l -> L11
        r10 = a(r7, b(r7, r3), d(r7, r3));     // Catch: l -> L11
    L11:
        e = move-exception;
        if (e.f() == 21) goto L15;
    L18:
        if (r3 == false) goto L20;
        r2 = true;
        goto L21
    L20:
        throw e;
    L15:
        if (r7.s() != bo.a.f5370b) goto L18;
        throw e;
    L21:
        if (r10 != null) goto L23;
    L32:
        return a(r7, c(r7, r2), a(r7, r0));
    L30:
        e = move-exception;
        throw e;
    L23:
        if (r10.f5322a == null) goto L32;
        if (r10.f5322a.length <= 0) goto L32;
        return r10;
    L5:
        r9 = bo.c.f5373a;
        goto L6
    }

    private static bo.b b(bo r2, boolean r3) {
        if (r2.s() != bo.a.d) goto L7;
        return bo.b.e;
    L7:
        if (r2.s() == bo.a.e) goto L9;
        if (r3 == false) goto L14;
        return bo.b.f5371a;
    L14:
        return bo.b.f5372b;
    L9:
        return bo.b.f5372b;
    }

    private static boolean b(bo r2) {
        d(r2);
        String r0 = r2.p();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return false;
    L7:
        String r1 = new URL(r0).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2.o()) == true) goto L10;
        r1 = r2.o();     // Catch: Throwable -> L12
    L10:
        return fn.g(r1);
    L12:
        return true;
    }

    private static bo.b c(bo r1, boolean r2) {
        if (r1.s() != bo.a.d) goto L9;
        if (r2 == false) goto L8;
        return bo.b.f;
    L8:
        return bo.b.g;
    L9:
        if (r2 == false) goto L13;
        return bo.b.c;
    L13:
        return bo.b.d;
    }

    private static boolean c(bo r3) {
        d(r3);
        if (b(r3) == true) goto L6;
        return true;
    L6:
        String r1 = r3.p();     // Catch: Throwable -> L16
        if (r3.c().equals(r1) == false) goto L10;
        return false;
    L10:
        if (r3.s() != bo.a.e) goto L12;
        return false;
    L12:
        if (fn.h == true) goto L15;
        return false;
    L15:
        return true;
    }

    private static int d(bo r4, boolean r5) {
        d(r4);     // Catch: Throwable -> L12
        int r0 = r4.q();     // Catch: Throwable -> L12
        int r1 = fn.e;     // Catch: Throwable -> L12
        if (r4.s() == bo.a.d) goto L11;
        if (r4.s() == bo.a.e) goto L11;
        if (r0 >= r1) goto L9;
        return r0;
    L9:
        if (r5 == false) goto L11;
        return r1;
    L11:
        return r0;
    L12:
        return 5000;
    }

    private static void d(bo r1) {
        if (r1 == null) goto L11;
        if (r1.c() == null) goto L9;
        if ("".equals(r1.c()) == true) goto L9;
        return;
    L9:
        throw new l("request url is empty");
    L11:
        throw new l("requeust is null");
    }
}
