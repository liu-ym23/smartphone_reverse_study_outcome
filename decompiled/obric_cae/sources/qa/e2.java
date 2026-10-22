package qa;

import android.os.SystemClock;
import android.util.Base64;
import com.obric.cae.statusReport.network.NetworkReportUtil;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e2 {
    public e2(String r8, String r10, p2 r11) {
        l6.a.f9140i = 4;
        if (r10 == null) goto L5;
        l6.a.f9144m = r10;
    L5:
        l6.a.f9141j = "6.4.8";
        if (r8 == null) goto L8;
        l6.a.f9143l = r8;
    L8:
        l6.a.f9142k = "S128DF1572465B890OE3F7A13167KLEI";
        if (r11 == null) goto L12;
        l6.a.f9139h = r11;
        return;
    }

    public static v1 a(s1.a r18) {
        if (s1.f11019f != null) goto L14;
        Object r8 = s1.f11020g;
        monitor-enter(r8);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (s1.f11019f != null) goto L9;
        s1.f11019f = new s1();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r8);     // Catch: Throwable -> L11
    L14:
        s1 r10 = s1.f11019f;
        r10.getClass();
        long r11 = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        m2 r12 = r10.f11023c;
        if (r12 != null) goto L17;
    L20:
        r1 r13 = r10.f11021a;
        m2 r14 = r18.f11026a;
        boolean r15 = r18.f11035j;
        byte r16 = r18.f11032g;
        String r17 = r18.f11033h;
        ArrayList r19 = r18.f11034i;
        float r110 = 10.0f;
        if (r15 == false) goto L23;
        r13.f10966d.a();
    L81:
        r1.a r20 = null;
    L82:
        u1 r21 = r10.f11022b;
        m2 r22 = r18.f11026a;
        ArrayList r23 = r18.f11027b;
        boolean r24 = r18.f11030e;
        long r111 = r18.f11029d;
        ArrayList r25 = r21.f11133a;
        if (r24 == true) goto L86;
    L134:
        boolean r112 = false;
    L135:
        if (r112 == false) goto L149;
        ArrayList r26 = r21.f11135c;
        r26.clear();
        if (r23 == null) goto L148;
        ArrayList r113 = new ArrayList();
        HashMap r114 = new HashMap();
        int r115 = 0;
    L140:
        if (r115 >= r23.size()) goto L142;
        n2 r116 = (n2) r23.get(r115);
        r114.put(Integer.valueOf(r116.f10853c), r116);
        r115 = r115 + 1;
        goto L140
    L142:
        r113.addAll(r114.values());
        Collections.sort(r113, new t1());
        int r117 = r113.size();
        if (r117 <= 40) goto L145;
        r117 = 40;
    L145:
        int r118 = 0;
    L146:
        if (r118 >= r117) goto L148;
        r26.add(r113.get(r118));
        r118 = r118 + 1;
    L148:
        r25.clear();
        r25.addAll(r23);
        r21.f11134b = r22;
    L150:
        if (r20 != null) goto L154;
        if (r26 != null) goto L154;
        v1 r27 = null;
    L176:
        r10.f11023c = r18.f11026a;
        return r27;
    L154:
        m2 r28 = r10.f11025e;
        m2 r29 = r18.f11026a;
        r28.f10825h = r18.f11031f;
        r28.f10785a = r11;
        r28.f10787c = r29.f10787c;
        r28.f10786b = r29.f10786b;
        r28.f10788d = r29.f10788d;
        r28.f10791g = r29.f10791g;
        r28.f10789e = r29.f10789e;
        r28.f10790f = r29.f10790f;
        o1 r30 = r10.f11024d;
        long r31 = r18.f11028c;
        Object r32 = r30.f10252a;
        ((p1) r32).j((ByteBuffer) r30.f10253b);
        int r33 = r30.f(r28);     // Catch: Throwable -> L174
        int r119 = -1;
        if (r20 == null) goto L162;
        ArrayList r120 = r20.f10973f;     // Catch: Throwable -> L174
        if (r120 == null) goto L162;
        if (r120.size() <= 0) goto L162;
        int r34 = r30.e(r20);     // Catch: Throwable -> L174
    L163:
        if (r26 != null) goto L165;
    L167:
        int r35 = r119;
        int r36 = y1.f11230a;     // Catch: Throwable -> L174
        ((p1) r32).l(3);     // Catch: Throwable -> L174
        ((p1) r32).m(0, r33);     // Catch: Throwable -> L174
        if (r34 <= 0) goto L170;
        ((p1) r32).m(2, r34);     // Catch: Throwable -> L174
    L170:
        if (r35 <= 0) goto L172;
        ((p1) r32).m(1, r35);     // Catch: Throwable -> L174
    L172:
        ((p1) r32).o(((p1) r32).k());     // Catch: Throwable -> L174
        byte[] r37 = ((p1) r32).q();     // Catch: Throwable -> L174
        int r38 = 0;
    L175:
        r27 = new v1(r38, r37);
        goto L176
    L165:
        if (r26.size() <= 0) goto L167;
        r119 = r30.d(r31, r26);     // Catch: Throwable -> L174
    L162:
        r34 = -1;
    L174:
        r38 = 0;
        r37 = null;
        goto L175
    L149:
        r26 = null;
        goto L150
    L86:
        if (r22.f10789e < 10.0f) goto L88;
        int r39 = NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY;
    L90:
        if (r111 > 0) goto L92;
    L94:
        boolean r121 = false;
    L95:
        if (r121 == false) goto L134;
        if (r23 == null) goto L134;
        if (r23.size() <= 0) goto L134;
        m2 r40 = r21.f11134b;
        if (r40 == null) goto L133;
        float r122 = r22.f10789e;
        if (r122 <= 10.0f) goto L105;
        r110 = 200.0f;
    L108:
        if (r22.a(r40) <= r110) goto L110;
        r112 = true;
    L111:
        if (r112 == true) goto L135;
        if (r25 == null) goto L131;
        int r41 = r23.size();
        int r123 = r25.size();
        int r124 = r41 + r123;
        if (r41 <= r123) goto L117;
        ArrayList r125 = r25;
        ArrayList r42 = r23;
    L118:
        HashMap r126 = new HashMap(r42.size());
        Iterator r43 = r42.iterator();
    L120:
        if (r43.hasNext() == false) goto L122;
        r126.put(Long.valueOf(((n2) r43.next()).f10851a), 1);
        goto L120
    L122:
        Iterator r44 = r125.iterator();
        int r127 = 0;
    L124:
        if (r44.hasNext() == false) goto L129;
        if (((Integer) r126.get(Long.valueOf(((n2) r44.next()).f10851a))) == null) goto L124;
        r127 = r127 + 1;
        goto L124
    L129:
        if ((((double) r127) * 2.0d) < (((double) r124) * 0.5d)) goto L131;
        boolean r45 = true;
        boolean r128 = true;
    L132:
        r112 = r128 ^ r45;
        goto L135
    L117:
        r42 = r25;
        r125 = r23;
    L131:
        r45 = true;
        r128 = false;
        goto L132
    L110:
        r112 = false;
        goto L111
    L105:
        if (r122 <= 2.0f) goto L108;
        r110 = 50.0f;
        goto L108
    L133:
        r112 = true;
        goto L135
    L92:
        if ((r11 - r111) >= r39) goto L94;
        r121 = true;
        goto L95
    L88:
        r39 = 3500;
        goto L90
    L23:
        r1.a r46 = r13.f10966d;
        r46.a();
        r46.f10968a = r16;
        r46.f10969b = r17;
        if (r19 == null) goto L37;
        ArrayList r47 = r46.f10973f;
        r47.addAll(r19);
        Iterator r48 = r47.iterator();
    L27:
        if (r48.hasNext() == false) goto L37;
        f2 r49 = (f2) r48.next();
        boolean r129 = r49.f10410s;
        if (r129 == true) goto L33;
        if (r49.f10409r == false) goto L33;
        r46.f10971d = r49;
    L33:
        if (r129 == false) goto L27;
        if (r49.f10409r == false) goto L27;
        r46.f10972e = r49;
    L37:
        f2 r50 = r46.f10971d;
        if (r50 != null) goto L40;
        r50 = r46.f10972e;
    L40:
        r46.f10970c = r50;
        if (r13.f10966d.f10970c == null) goto L81;
        m2 r51 = r13.f10965c;
        if (r51 == null) goto L63;
        float r52 = r14.f10789e;
        if (r52 <= 10.0f) goto L49;
        float r53 = 2000.0f;
    L53:
        if (r14.a(r51) <= r53) goto L55;
        boolean r54 = true;
    L56:
        if (r54 == true) goto L63;
        if (r1.a.b(r13.f10966d.f10971d, r13.f10963a) == false) goto L63;
        if (r1.a.b(r13.f10966d.f10972e, r13.f10964b) == false) goto L63;
        boolean r55 = false;
    L64:
        if (r55 == false) goto L81;
        r1.a r56 = r13.f10966d;
        r13.f10963a = r56.f10971d;
        r13.f10964b = r56.f10972e;
        r13.f10965c = r14;
        d2.a(r56.f10973f);
        r1.a r57 = r13.f10966d;
        ArrayList r58 = r13.f10967e;
        monitor-enter(r58);
        Iterator r59 = r57.f10973f.iterator();     // Catch: Throwable -> L78
    L69:
        if (r59.hasNext() == false) goto L75;
        f2 r60 = (f2) r59.next();     // Catch: Throwable -> L78
        if (r60 == null) goto L69;
        if (r60.f10409r == false) goto L69;
        f2 r61 = r60.a();     // Catch: Throwable -> L78
        r61.f10406o = SystemClock.elapsedRealtime();     // Catch: Throwable -> L78
        r13.a(r61);     // Catch: Throwable -> L78
        goto L69
    L75:
        r13.f10966d.f10974g.clear();     // Catch: Throwable -> L78
        r13.f10966d.f10974g.addAll(r13.f10967e);     // Catch: Throwable -> L78
        monitor-exit(r58);     // Catch: Throwable -> L78
        r20 = r13.f10966d;
    L78:
        th = move-exception;
        throw th;
    L55:
        r54 = false;
        goto L56
    L49:
        if (r52 <= 2.0f) goto L51;
        r53 = 500.0f;
        goto L53
    L51:
        r53 = 100.0f;
    L63:
        r55 = true;
        goto L64
    L17:
        if (r18.f11026a.a(r12) >= 10.0d) goto L20;
        return null;
    }

    public static boolean b(byte[] r8) {
        if (r8 != null) goto L17;
    L14:
        return false;
    L17:
        o2 r10 = new o2();     // Catch: Exception -> L16
        r10.f10873b.put("Content-Type", "application/octet-stream");     // Catch: Exception -> L16
        r10.f10873b.put("aps_c_src", Base64.encodeToString(("lc_" + l6.a.f9140i).getBytes(), 2));     // Catch: Exception -> L16
        r10.f10873b.put("aps_c_key", Base64.encodeToString((l6.a.f9141j + "*" + l6.a.f9144m).getBytes(), 2));     // Catch: Exception -> L16
        r10.f10874c = r8;     // Catch: Exception -> L16
        r10.f10872a = "https://".concat("cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&");     // Catch: Exception -> L16
        e6.a r11 = ((u2) l6.a.f9139h).a(r10);     // Catch: Exception -> L16
        if (r11 != null) goto L7;
    L9:
        byte[] r12 = null;
    L10:
        if (r12 == null) goto L14;
        if ("true".equals(new String(r12, StandardCharsets.UTF_8)) == false) goto L14;
        return true;
    L7:
        if (r11.f7124a != 200) goto L9;
        r12 = (byte[]) r11.f7126c;     // Catch: Exception -> L16
        goto L10
    }

    public static byte[] c() {
        q1 r8 = q1.f10949c;
        ((p1) r8.f10252a).j((ByteBuffer) r8.f10253b);
        int r10 = ((p1) r8.f10252a).b(l6.a.f9144m);     // Catch: Exception -> L5
        int r11 = ((p1) r8.f10252a).b(l6.a.f9141j);     // Catch: Exception -> L5
        int r12 = ((p1) r8.f10252a).b(l6.a.f9147p);     // Catch: Exception -> L5
        int r13 = ((p1) r8.f10252a).b(l6.a.f9146o);     // Catch: Exception -> L5
        int r14 = ((p1) r8.f10252a).b(l6.a.f9145n);     // Catch: Exception -> L5
        int r15 = ((p1) r8.f10252a).b(l6.a.f9148q);     // Catch: Exception -> L5
        long r16 = n2.a(l6.a.f9152u);     // Catch: Exception -> L5
        int r17 = ((p1) r8.f10252a).b(l6.a.f9150s);     // Catch: Exception -> L5
        int r18 = ((p1) r8.f10252a).b(l6.a.f9149r);     // Catch: Exception -> L5
        int r19 = ((p1) r8.f10252a).b(l6.a.f9142k);     // Catch: Exception -> L5
        int r110 = ((p1) r8.f10252a).b(l6.a.f9143l);     // Catch: Exception -> L5
        int r20 = y1.a((p1) r8.f10252a, l6.a.f9140i, r10, r11, (byte) l6.a.f9151t, r12, r13, r14, r15, r16, r17, r18, r19, r110);     // Catch: Exception -> L5
        ((p1) r8.f10252a).o(r20);     // Catch: Exception -> L5
        return ((p1) r8.f10252a).q();
    L5:
        return null;
    }

    public static byte[] d(byte[] r12, byte[] r13, ArrayList r14) {
        q1 r8 = q1.f10949c;
        Object r10 = r8.f10252a;
        int r11 = r14.size();     // Catch: Throwable -> L31
        if (r11 <= 0) goto L29;
        if (r12 == null) goto L29;
        ((p1) r8.f10252a).j((ByteBuffer) r8.f10253b);     // Catch: Throwable -> L31
        p1 r15 = (p1) r10;     // Catch: Throwable -> L31
        int r16 = z1.f11249a;     // Catch: Throwable -> L31
        r15.g(1, r12.length, 1);     // Catch: Throwable -> L31
        int r17 = r12.length - 1;     // Catch: Throwable -> L31
    L7:
        if (r17 < 0) goto L9;
        r15.c(r12[r17]);     // Catch: Throwable -> L31
        r17 = r17 - 1;     // Catch: Throwable -> L31
        goto L7
    L9:
        int r18 = r15.a();     // Catch: Throwable -> L31
        int[] r19 = new int[r11];     // Catch: Throwable -> L31
        int r20 = 0;
    L11:
        if (r20 >= r11) goto L16;
        v1 r21 = (v1) r14.get(r20);     // Catch: Throwable -> L31
        p1 r22 = (p1) r10;     // Catch: Throwable -> L31
        byte[] r23 = r21.f11157b;     // Catch: Throwable -> L31
        int r110 = y1.f11230a;     // Catch: Throwable -> L31
        r22.g(1, r23.length, 1);     // Catch: Throwable -> L31
        int r111 = r23.length - 1;     // Catch: Throwable -> L31
    L13:
        if (r111 < 0) goto L15;
        r22.c(r23[r111]);     // Catch: Throwable -> L31
        r111 = r111 - 1;     // Catch: Throwable -> L31
        goto L13
    L15:
        int r24 = r22.a();     // Catch: Throwable -> L31
        p1 r25 = (p1) r10;     // Catch: Throwable -> L31
        byte r26 = (byte) r21.f11156a;     // Catch: Throwable -> L31
        r25.l(2);     // Catch: Throwable -> L31
        r25.m(1, r24);     // Catch: Throwable -> L31
        r25.d(r26, 0);     // Catch: Throwable -> L31
        r19[r20] = r25.k();     // Catch: Throwable -> L31
        r20 = r20 + 1;     // Catch: Throwable -> L31
        goto L11
    L16:
        p1 r112 = (p1) r10;     // Catch: Throwable -> L31
        r112.g(4, r11, 4);     // Catch: Throwable -> L31
    L17:
        r11 = r11 - 1;     // Catch: Throwable -> L31
        if (r11 < 0) goto L20;
        r112.e(r19[r11]);     // Catch: Throwable -> L31
        goto L17
    L20:
        int r113 = r112.a();     // Catch: Throwable -> L31
        if (r13 == null) goto L26;
        p1 r27 = (p1) r10;     // Catch: Throwable -> L31
        r27.g(1, r13.length, 1);     // Catch: Throwable -> L31
        int r28 = r13.length - 1;     // Catch: Throwable -> L31
    L23:
        if (r28 < 0) goto L25;
        r27.c(r13[r28]);     // Catch: Throwable -> L31
        r28 = r28 - 1;     // Catch: Throwable -> L31
        goto L23
    L25:
        int r114 = r27.a();     // Catch: Throwable -> L31
    L27:
        p1 r29 = (p1) r10;     // Catch: Throwable -> L31
        r29.l(3);     // Catch: Throwable -> L31
        r29.m(2, r113);     // Catch: Throwable -> L31
        r29.m(1, r114);     // Catch: Throwable -> L31
        r29.m(0, r18);     // Catch: Throwable -> L31
        ((p1) r10).o(r29.k());     // Catch: Throwable -> L31
        return ((p1) r10).q();
    L26:
        r114 = 0;
    L29:
        return null;
    }

    public static void e(ArrayList r8) {
        monitor-enter(d2.class);
        if (r8 != null) goto L19;
    L17:
        monitor-exit(d2.class);
        return;
    L19:
    L14:
        th = move-exception;
        throw th;
    L6:
        if (r8.isEmpty() == true) goto L17;
        ArrayList r10 = new ArrayList(r8.size());     // Catch: Throwable -> L14
        Iterator r11 = r8.iterator();     // Catch: Throwable -> L14
    L10:
        if (r11.hasNext() == false) goto L12;
        n2 r12 = (n2) r11.next();     // Catch: Throwable -> L14
        r10.add(new d2.b(r12.f10851a, r12.f10853c));     // Catch: Throwable -> L14
        goto L10
    L12:
        c2.a().e(r10);     // Catch: Throwable -> L14
        goto L17
    }
}
