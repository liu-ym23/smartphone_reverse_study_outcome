package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.net.URL;
import n4a.l0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static int a = 0;
    public static String b = "";
    public static c c;

    public c() {
        i.x();
    }

    public static void c() {
        if (c != null) goto L6;
        c = new c();
        return;
    }

    public static boolean d(bo r2) throws l {
        e(r2);
        String r0 = r2.e();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return false;
    L7:
        String r1 = new URL(r0).getHost();     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2.j()) == true) goto L10;
        r1 = r2.j();     // Catch: Throwable -> L12
    L10:
        return i.B(r1);
    L12:
        return true;
    }

    public static void e(bo r1) throws l {
        if (r1.c() == null) goto L8;
        if (NameKeys.UnloadStrategy_No_Strategy.equals(r1.c()) == true) goto L8;
        return;
    L8:
        throw new l("request url is empty");
    }

    public static l0 a(bo r14) throws l {
        boolean r0 = r14.h;
        e(r14);
        if (r0 == false) goto L5;
        bo.c r1 = bo.c.b;
    L6:
        r14.b(r1);
        int r2 = 5000;
        boolean r3 = false;
        long r4 = 0;
        l0 r5 = null;
        if (d(r14) == false) goto L57;
        e(r14);
        if (d(r14) == false) goto L21;
        if (r14.c().equals(r14.e()) == false) goto L16;
    L20:
        boolean r6 = false;
    L100:
        long r7 = SystemClock.elapsedRealtime();     // Catch: l -> L46
        bo.a r9 = r14.i;     // Catch: l -> L44
        bo.a r10 = bo.a.d;     // Catch: l -> L44
        if (r9 != r10) goto L27;
        bo.b r11 = bo.b.e;     // Catch: l -> L44
    L98:
        e(r14);     // Catch: Throwable -> L41
        int r12 = r14.a;     // Catch: Throwable -> L41
        int r13 = i.o;     // Catch: Throwable -> L41
        bo.a r15 = r14.i;     // Catch: Throwable -> L41
        if (r15 == r10) goto L42;
        if (r15 == bo.a.e) goto L42;
        if (r12 < r13) goto L42;
        if (r6 == false) goto L42;
        r12 = r13;
    L42:
        r5 = b(r14, r11, r12);     // Catch: l -> L44
    L58:
        if (r5 == null) goto L104;
        byte[] r8 = r5.a;
        if (r8 == null) goto L104;
        if (r8.length <= 0) goto L104;
        return r5;
    L104:
        bo.a r16 = r14.i;     // Catch: l -> L91
        bo.a r17 = bo.a.d;     // Catch: l -> L91
        if (r16 != r17) goto L68;
        if (r3 == false) goto L67;
        bo.b r18 = bo.b.f;     // Catch: l -> L91
    L95:
        e(r14);     // Catch: Throwable -> L93
        if (r7 == 0) goto L75;
        r4 = SystemClock.elapsedRealtime() - r7;     // Catch: Throwable -> L93
    L75:
        int r19 = r14.a;     // Catch: Throwable -> L93
        bo.a r20 = r14.i;     // Catch: Throwable -> L93
        if (r20 != r17) goto L78;
    L88:
        r2 = r19;
        goto L89
    L78:
        if (r20 == bo.a.e) goto L88;
        long r21 = r19;
        if (r4 >= r21) goto L86;
        long r22 = r21 - r4;     // Catch: Throwable -> L93
        if (r22 < 1000) goto L86;
        r2 = (int) r22;     // Catch: Throwable -> L93
    L86:
        r2 = Math.min(1000, r19);     // Catch: Throwable -> L93
    L89:
        return b(r14, r18, r2);
    L67:
        r18 = bo.b.g;     // Catch: l -> L91
        goto L95
    L68:
        if (r3 == false) goto L70;
        r18 = bo.b.c;     // Catch: l -> L91
        goto L95
    L70:
        r18 = bo.b.d;     // Catch: l -> L91
    L91:
        e = move-exception;
        throw e;
    L41:
        r12 = 5000;
        goto L42
    L27:
        if (r9 == bo.a.e) goto L31;
        if (r6 == false) goto L31;
        r11 = bo.b.a;     // Catch: l -> L44
    L31:
        r11 = bo.b.b;     // Catch: l -> L44
    L44:
        e = e;
    L49:
        if (e.f() == 21) goto L51;
    L54:
        if (r6 == false) goto L56;
        r3 = true;
        goto L58
    L56:
        throw e;
    L51:
        if (r14.i != bo.a.b) goto L54;
        throw e;
    L46:
        e = e;
        r7 = 0;
        goto L49
    L16:
        if (r14.i == bo.a.e) goto L20;
        if (i.s == false) goto L20;
    L21:
        r6 = true;
        goto L100
    L57:
        r7 = 0;
        goto L58
    L5:
        r1 = bo.c.a;
        goto L6
    }

    public static l0 b(bo r0, bo.b r1, int r2) throws l {
        e(r0);     // Catch: Throwable -> L4 l -> L7
        r0.j = r1;     // Catch: Throwable -> L4 l -> L7
        r0.d = r2;     // Catch: Throwable -> L4 l -> L7
        return new d().d(r0);
    L7:
        e = move-exception;
        throw e;
    L4:
        th = move-exception;
        th.printStackTrace();
        throw new l("未知的错误");
    }
}
