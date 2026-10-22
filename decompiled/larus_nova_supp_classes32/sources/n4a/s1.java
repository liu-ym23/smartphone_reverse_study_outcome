package n4a;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.loc.dv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s1 {
    public static volatile s1 f;
    public static final Object g = null;
    public final r1 a;
    public final u1 b;
    public u2 c;
    public final o1 d;
    public final u2 e;

    public static class a {
        public u2 a;
        public List<v2> b;
        public long c;
        public long d;
        public boolean e;
        public long f;
        public byte g;
        public String h;
        public List<dv> i;
        public boolean j;

        public a() {
        }
    }

    static {
        g = new Object();
    }

    public s1() {
        this.e = new u2();
        this.a = new r1();
        this.b = new u1();
        this.d = new o1();
    }

    public final v1 a(a r20) {
        long r2 = System.currentTimeMillis();
        SystemClock.elapsedRealtime();
        u2 r4 = this.c;
        if (r4 != null) goto L5;
    L8:
        r1 r5 = this.a;
        u2 r6 = r20.a;
        boolean r7 = r20.j;
        byte r8 = r20.g;
        String r9 = r20.h;
        List<dv> r10 = r20.i;
        if (r7 == false) goto L11;
        r5.d.a();
    L69:
        r1.a r11 = null;
    L70:
        u1 r12 = this.b;
        u2 r13 = r20.a;
        List<v2> r14 = r20.b;
        boolean r15 = r20.e;
        long r16 = r20.d;
        r12.getClass();
        if (r15 == true) goto L74;
    L72:
        u1 r17 = r12;
        boolean r18 = false;
    L127:
        if (r18 == false) goto L141;
        u1 r19 = r17;
        ArrayList<v2> r21 = r19.c;
        r21.clear();
        if (r14 == null) goto L140;
        ArrayList r22 = new ArrayList();
        HashMap r110 = new HashMap();
        int r111 = 0;
    L132:
        if (r111 >= ((ArrayList) r14).size()) goto L134;
        v2 r112 = (v2) ListProtector.get(r14, r111);
        r110.put(Integer.valueOf(r112.c), r112);
        r111 = r111 + 1;
        goto L132
    L134:
        r22.addAll(r110.values());
        Collections.sort(r22, new t1());
        int r113 = r22.size();
        if (r113 <= 40) goto L137;
        r113 = 40;
    L137:
        int r114 = 0;
    L138:
        if (r114 >= r113) goto L140;
        r21.add((v2) ListProtector.get(r22, r114));
        r114 = r114 + 1;
    L140:
        ((ArrayList) r19.a).clear();
        ((ArrayList) r19.a).addAll(r14);
        r19.b = r13;
        ArrayList<v2> r23 = r19.c;
    L142:
        if (r11 != null) goto L146;
        if (r23 != null) goto L146;
        v1 r24 = null;
    L168:
        this.c = r20.a;
        return r24;
    L146:
        u2 r25 = this.e;
        u2 r26 = r20.a;
        r25.h = r20.f;
        r25.a = r2;
        r25.c = r26.c;
        r25.b = r26.b;
        r25.d = r26.d;
        r25.g = r26.g;
        r25.e = r26.e;
        r25.f = r26.f;
        o1 r3 = this.d;
        long r27 = r20.c;
        r3.a.j(r3.b);
        int r28 = r3.c(r25);     // Catch: Throwable -> L166
        int r29 = -1;
        if (r11 == null) goto L154;
        List<dv> r115 = r11.f;     // Catch: Throwable -> L166
        if (r115 == null) goto L154;
        if (((ArrayList) r115).size() <= 0) goto L154;
        int r30 = r3.b(r11);     // Catch: Throwable -> L166
    L155:
        if (r23 != null) goto L157;
    L159:
        p1 r31 = r3.a;     // Catch: Throwable -> L166
        int r32 = y1.a;     // Catch: Throwable -> L166
        r31.l(3);     // Catch: Throwable -> L166
        r3.a.m(0, r28);     // Catch: Throwable -> L166
        if (r30 <= 0) goto L162;
        r3.a.m(2, r30);     // Catch: Throwable -> L166
    L162:
        if (r29 <= 0) goto L164;
        r3.a.m(1, r29);     // Catch: Throwable -> L166
    L164:
        r3.a.o(r3.a.k());     // Catch: Throwable -> L166
        byte[] r33 = r3.a.q();     // Catch: Throwable -> L166
        int r34 = 0;
    L167:
        r24 = new v1(r34, r33);
        goto L168
    L157:
        if (r23.size() <= 0) goto L159;
        r29 = r3.a(r27, r23);     // Catch: Throwable -> L166
    L154:
        r30 = -1;
    L166:
        r34 = 0;
        r33 = null;
        goto L167
    L141:
        r23 = null;
        goto L142
    L74:
        if (r13.e < 10.0f) goto L76;
        int r35 = 2000;
    L78:
        if (r16 > 0) goto L80;
    L82:
        boolean r36 = false;
    L83:
        if (r36 == false) goto L72;
        if (r14 == null) goto L72;
        ArrayList r37 = (ArrayList) r14;
        if (r37.size() <= 0) goto L72;
        u2 r116 = r12.b;
        if (r116 == null) goto L125;
        float r117 = r13.e;
        if (r117 <= 10.0f) goto L93;
        float r118 = 200.0f;
    L97:
        if (r13.a(r116) <= r118) goto L99;
        boolean r119 = true;
    L100:
        if (r119 == true) goto L124;
        List<v2> r120 = r12.a;
        if (r120 != null) goto L104;
        r17 = r12;
    L122:
        boolean r121 = false;
    L123:
        r18 = !r121;
        goto L127
    L104:
        int r38 = r37.size();
        int r122 = ((ArrayList) r120).size();
        int r123 = r38 + r122;
        if (r38 <= r122) goto L107;
        List<v2> r39 = r120;
        r120 = r14;
    L108:
        HashMap r124 = new HashMap(r120.size());
        Iterator<v2> r125 = r120.iterator();
    L110:
        if (r125.hasNext() == false) goto L112;
        r124.put(Long.valueOf(r125.next().a), 1);
        r125 = r125;
        goto L110
    L112:
        Iterator<v2> r40 = r39.iterator();
        int r126 = 0;
    L114:
        if (r40.hasNext() == false) goto L119;
        u1 r127 = r12;
        if (((Integer) r124.get(Long.valueOf(r40.next().a))) == null) goto L118;
        r126 = r126 + 1;
    L118:
        r12 = r127;
        goto L114
    L119:
        r17 = r12;
        if ((((double) r126) * 2.0d) < (((double) r123) * 0.5d)) goto L122;
        r121 = true;
        goto L123
    L107:
        r39 = r14;
        goto L108
    L124:
        r17 = r12;
        r18 = r119;
        goto L127
    L99:
        r119 = false;
        goto L100
    L93:
        if (r117 <= 2.0f) goto L95;
        r118 = 50.0f;
        goto L97
    L95:
        r118 = 10.0f;
        goto L97
    L125:
        r17 = r12;
        r18 = true;
        goto L127
    L80:
        if ((r2 - r16) >= r35) goto L82;
        r36 = true;
        goto L83
    L76:
        r35 = 3500;
        goto L78
    L11:
        r1.a r41 = r5.d;
        r41.a();
        r41.a = r8;
        r41.b = r9;
        if (r10 == null) goto L25;
        ((ArrayList) r41.f).addAll(r10);
        Iterator r42 = ((ArrayList) r41.f).iterator();
    L15:
        if (r42.hasNext() == false) goto L25;
        dv r43 = (dv) r42.next();
        boolean r128 = r43.i;
        if (r128 == true) goto L21;
        if (r43.h == false) goto L21;
        r41.d = r43;
    L21:
        if (r128 == false) goto L15;
        if (r43.h == false) goto L15;
        r41.e = r43;
    L25:
        dv r44 = r41.d;
        if (r44 != null) goto L28;
        r44 = r41.e;
    L28:
        r41.c = r44;
        if (r5.d.c == null) goto L69;
        u2 r45 = r5.c;
        if (r45 == null) goto L51;
        float r46 = r6.e;
        if (r46 <= 10.0f) goto L37;
        float r47 = 2000.0f;
    L41:
        if (r6.a(r45) <= r47) goto L43;
        boolean r48 = true;
    L44:
        if (r48 == true) goto L51;
        if (r1.a.b(r5.d.d, r5.a) == false) goto L51;
        if (r1.a.b(r5.d.e, r5.b) == false) goto L51;
        boolean r49 = false;
    L52:
        if (r49 == false) goto L69;
        r1.a r50 = r5.d;
        r5.a = r50.d;
        r5.b = r50.e;
        r5.c = r6;
        p2.a(r50.f);
        r1.a r51 = r5.d;
        List<dv> r52 = r5.e;
        monitor-enter(r52);
        Iterator r53 = ((ArrayList) r51.f).iterator();     // Catch: Throwable -> L66
    L57:
        if (r53.hasNext() == false) goto L63;
        dv r54 = (dv) r53.next();     // Catch: Throwable -> L66
        if (r54 == null) goto L57;
        if (r54.h == false) goto L57;
        dv r55 = r54.a();     // Catch: Throwable -> L66
        r55.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L66
        r5.a(r55);     // Catch: Throwable -> L66
        goto L57
    L63:
        ((ArrayList) r5.d.g).clear();     // Catch: Throwable -> L66
        ((ArrayList) r5.d.g).addAll(r5.e);     // Catch: Throwable -> L66
        monitor-exit(r52);     // Catch: Throwable -> L66
        r11 = r5.d;
    L66:
        th = move-exception;
        throw th;
    L43:
        r48 = false;
        goto L44
    L37:
        if (r46 <= 2.0f) goto L39;
        r47 = 500.0f;
        goto L41
    L39:
        r47 = 100.0f;
    L51:
        r49 = true;
        goto L52
    L5:
        if (r20.a.a(r4) >= 10.0d) goto L8;
        return null;
    }
}
