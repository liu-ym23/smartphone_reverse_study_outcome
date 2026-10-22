package n4a;

import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q2 {
    public static byte[] c() {
        q1 r0 = q1.c;
        r0.a.j(r0.b);
        int r5 = r0.a.b(w2.e);     // Catch: Exception -> L5
        int r6 = r0.a.b(w2.b);     // Catch: Exception -> L5
        int r8 = r0.a.b(w2.h);     // Catch: Exception -> L5
        int r9 = r0.a.b(w2.g);     // Catch: Exception -> L5
        int r10 = r0.a.b(w2.f);     // Catch: Exception -> L5
        int r11 = r0.a.b(w2.i);     // Catch: Exception -> L5
        long r12 = v2.a(w2.m);     // Catch: Exception -> L5
        int r14 = r0.a.b(w2.k);     // Catch: Exception -> L5
        int r15 = r0.a.b(w2.j);     // Catch: Exception -> L5
        int r16 = r0.a.b(w2.c);     // Catch: Exception -> L5
        int r17 = r0.a.b(w2.d);     // Catch: Exception -> L5
        int r1 = x2.a(r0.a, w2.a, r5, r6, (byte) w2.l, r8, r9, r10, r11, r12, r14, r15, r16, r17);     // Catch: Exception -> L5
        r0.a.o(r1);     // Catch: Exception -> L5
        return r0.a.q();
    L5:
        return null;
    }

    public static v1 a(s1.a r2) {
        if (s1.f != null) goto L15;
        Object r0 = s1.g;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s1.f != null) goto L9;
        s1.f = new s1();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return s1.f.a(r2);
    }

    public static boolean b(byte[] r6) {
        if (r6 != null) goto L22;
    L17:
        return false;
    L22:
        HashMap r1 = new HashMap();     // Catch: Exception -> L19
        r1.put("Content-Type", "application/octet-stream");     // Catch: Exception -> L19
        r1.put("aps_c_src", Base64.encodeToString(("lc_" + w2.a).getBytes(), 2));     // Catch: Exception -> L19
        r1.put("aps_c_key", Base64.encodeToString((w2.b + "*" + w2.e).getBytes(), 2));     // Catch: Exception -> L19
        String r0 = "https://".concat("cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&");     // Catch: Exception -> L19
        ((d3) r2.a).getClass();     // Catch: Exception -> L19
        byte[] r3 = null;
        x3 r4 = new x3();     // Catch: Throwable -> L8
        r4.k = r1;     // Catch: Throwable -> L8
        r4.m = r0;     // Catch: Throwable -> L8
        r4.n = r6;     // Catch: Throwable -> L8
        com.loc.c.c();     // Catch: Throwable -> L8
        l0 r7 = com.loc.c.a(r4);     // Catch: Throwable -> L8
        y2 r2 = new y2();     // Catch: Throwable -> L8
        r2.c = r7.a;     // Catch: Throwable -> L8
        r2.b = r7.b;     // Catch: Throwable -> L8
        r2.a = 200;     // Catch: Throwable -> L8
    L9:
        if (r2 != null) goto L11;
    L13:
        if (r3 == null) goto L17;
        if ("true".equals(new String(r3, StandardCharsets.UTF_8)) == false) goto L17;
        return true;
    L11:
        if (r2.a != 200) goto L13;
        r3 = r2.c;     // Catch: Exception -> L19
    L8:
        r2 = null;
        goto L9
    }

    public static void e(List<v2> r6) {
        monitor-enter(p2.class);
        if (r6 != null) goto L19;
    L17:
        monitor-exit(p2.class);
        return;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r6.isEmpty() == true) goto L17;
        ArrayList r1 = new ArrayList(r6.size());     // Catch: Throwable -> L14
        Iterator<v2> r7 = r6.iterator();     // Catch: Throwable -> L14
    L10:
        if (r7.hasNext() == false) goto L12;
        v2 r2 = r7.next();     // Catch: Throwable -> L14
        r1.add(new p2.b(r2.a, r2.c));     // Catch: Throwable -> L14
        goto L10
    L12:
        o2.a().e(r1);     // Catch: Throwable -> L14
        goto L17
    }

    public q2(String r2, String r3, z2 r4) {
        w2.a = 4;
        if (r3 == null) goto L5;
        w2.e = r3;
    L5:
        byte r5 = w2.a;
        w2.b = "6.4.8";
        if (r2 == null) goto L8;
        w2.d = r2;
    L8:
        w2.c = "S128DF1572465B890OE3F7A13167KLEI";
        if (r4 == null) goto L12;
        r2.a = r4;
        return;
    }

    public static byte[] d(byte[] r12, byte[] r13, List<v1> r14) {
        q1 r0 = q1.c;
        r0.getClass();
        int r1 = ((ArrayList) r14).size();     // Catch: Throwable -> L31
        if (r1 <= 0) goto L29;
        if (r12 == null) goto L29;
        r0.a.j(r0.b);     // Catch: Throwable -> L31
        p1 r2 = r0.a;     // Catch: Throwable -> L31
        int r3 = z1.a;     // Catch: Throwable -> L31
        r2.g(1, r12.length, 1);     // Catch: Throwable -> L31
        int r4 = r12.length - 1;     // Catch: Throwable -> L31
    L7:
        if (r4 < 0) goto L9;
        r2.c(r12[r4]);     // Catch: Throwable -> L31
        r4 = r4 - 1;     // Catch: Throwable -> L31
        goto L7
    L9:
        int r15 = r2.a();     // Catch: Throwable -> L31
        int[] r5 = new int[r1];     // Catch: Throwable -> L31
        int r6 = 0;
    L11:
        if (r6 >= r1) goto L16;
        v1 r7 = (v1) ListProtector.get(r14, r6);     // Catch: Throwable -> L31
        p1 r8 = r0.a;     // Catch: Throwable -> L31
        byte[] r9 = r7.b;     // Catch: Throwable -> L31
        int r10 = e2.a;     // Catch: Throwable -> L31
        r8.g(1, r9.length, 1);     // Catch: Throwable -> L31
        int r11 = r9.length - 1;     // Catch: Throwable -> L31
    L13:
        if (r11 < 0) goto L15;
        r8.c(r9[r11]);     // Catch: Throwable -> L31
        r11 = r11 - 1;     // Catch: Throwable -> L31
        goto L13
    L15:
        int r16 = r8.a();     // Catch: Throwable -> L31
        p1 r17 = r0.a;     // Catch: Throwable -> L31
        byte r18 = (byte) r7.a;     // Catch: Throwable -> L31
        r17.l(2);     // Catch: Throwable -> L31
        r17.m(1, r16);     // Catch: Throwable -> L31
        r17.e(0, r18);     // Catch: Throwable -> L31
        r5[r6] = r17.k();     // Catch: Throwable -> L31
        r6 = r6 + 1;     // Catch: Throwable -> L31
        goto L11
    L16:
        p1 r19 = r0.a;     // Catch: Throwable -> L31
        r19.g(4, r1, 4);     // Catch: Throwable -> L31
    L17:
        r1 = r1 - 1;     // Catch: Throwable -> L31
        if (r1 < 0) goto L20;
        r19.d(r5[r1]);     // Catch: Throwable -> L31
        goto L17
    L20:
        int r110 = r19.a();     // Catch: Throwable -> L31
        if (r13 == null) goto L26;
        p1 r20 = r0.a;     // Catch: Throwable -> L31
        r20.g(1, r13.length, 1);     // Catch: Throwable -> L31
        int r21 = r13.length - 1;     // Catch: Throwable -> L31
    L23:
        if (r21 < 0) goto L25;
        r20.c(r13[r21]);     // Catch: Throwable -> L31
        r21 = r21 - 1;     // Catch: Throwable -> L31
        goto L23
    L25:
        int r111 = r20.a();     // Catch: Throwable -> L31
    L27:
        p1 r22 = r0.a;     // Catch: Throwable -> L31
        r22.l(3);     // Catch: Throwable -> L31
        r22.m(2, r110);     // Catch: Throwable -> L31
        r22.m(1, r111);     // Catch: Throwable -> L31
        r22.m(0, r15);     // Catch: Throwable -> L31
        r0.a.o(r22.k());     // Catch: Throwable -> L31
        return r0.a.q();
    L26:
        r111 = 0;
    L29:
        return null;
    }
}
