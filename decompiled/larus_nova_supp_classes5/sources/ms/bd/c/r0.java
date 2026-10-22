package ms.bd.c;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.KotlinVersion;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r0 implements j0 {
    public static final String A = null;
    public static final String B = null;
    public static final String C = null;
    public static final String D = null;
    public static final String E = null;
    public static final String F = null;
    public static volatile r0 G;
    public static final HashMap H = null;
    public static final AtomicInteger I = null;
    public static final HashMap J = null;
    public static final int b = 0;
    public static final int c = 0;
    public static final AtomicBoolean d = null;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static final AtomicInteger o = null;
    public static final AtomicInteger p = null;
    public static final AtomicInteger q = null;
    public static final AtomicInteger r = null;
    public static final AtomicInteger s = null;
    public static final AtomicInteger t = null;
    public static final String u = null;
    public static final String v = null;
    public static final String w = null;
    public static final String x = null;
    public static final String y = null;
    public static final String z = null;
    public volatile Object a;

    static {
        u = (String) p2.a(16777217, 0, 0, "dc4870", new byte[]{99, 100, 85});
        v = (String) p2.a(16777217, 0, 0, "1e5945", new byte[]{53, 114, 66});
        w = (String) p2.a(16777217, 0, 0, "5b61e0", new byte[]{39, 109, 65});
        x = (String) p2.a(16777217, 0, 0, "91ee37", new byte[]{59, 62, 18});
        y = (String) p2.a(16777217, 0, 0, "f39636", new byte[]{113, 35, 79});
        z = (String) p2.a(16777217, 0, 0, "9a6810", new byte[]{59, 96, 64});
        A = (String) p2.a(16777217, 0, 0, "85e760", new byte[]{58, 62, 18});
        B = (String) p2.a(16777217, 0, 0, "edbd4b", new byte[]{112, 118, 21});
        C = (String) p2.a(16777217, 0, 0, "9b74bf", new byte[]{44, 115, 71});
        D = (String) p2.a(16777217, 0, 0, "137299", new byte[]{35, 57, 79});
        E = (String) p2.a(16777217, 0, 0, "b54cc7", new byte[]{99, 54, 85, 26});
        F = (String) p2.a(16777217, 0, 0, "01bb30", new byte[]{44, 43, 3});
        b = 257;
        c = -1;
        d = new AtomicBoolean(false);
        new AtomicBoolean(true);
        e = 2;
        f = KotlinVersion.MAX_COMPONENT_VALUE;
        g = 5;
        h = 5;
        i = 5;
        j = 5;
        k = 3;
        l = 20;
        m = 50;
        n = 5000;
        o = new AtomicInteger(0);
        p = new AtomicInteger(0);
        q = new AtomicInteger(0);
        r = new AtomicInteger(0);
        s = new AtomicInteger(0);
        t = new AtomicInteger(0);
        H = new HashMap();
        I = new AtomicInteger(o0.b.a);
        J = new HashMap();
    }

    public static r0 a() {
        if (G != null) goto L15;
        monitor-enter(r0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (G != null) goto L9;
        G = new r0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0.class);     // Catch: Throwable -> L11
    L15:
        return G;
    }

    public r0() {
        k0.a().b = this;
    }

    public final void b(String r26, int r27) {
        int r3 = n0.b.a;
        int r4 = o0.c.a;
        if (r27 != i0.b.a) goto L5;
    L7:
        if (r26 != null) goto L10;
    L124:
        l0 r0 = null;
    L125:
        int r10 = 0;
    L129:
        if (r0 != null) goto L131;
    L279:
        if (r0 != null) goto L281;
    L283:
        if (r10 > 0) goto L285;
    L292:
        if (r0 != null) goto L294;
    L296:
        AtomicInteger r1 = t;
        if (r1.decrementAndGet() < e) goto L299;
        k0.a().b(i0.d, null);
        boolean r2 = false;
        r1.set(0);
    L300:
        d.set(r2);
        return;
    L299:
        r2 = false;
        goto L300
    L294:
        if (r4 <= r0.n) goto L296;
        r0.n = r4;
        goto L296
    L285:
        if (r3 != n0.c.a) goto L287;
    L288:
        if (r0 != null) goto L290;
    L291:
        p2.a(134217732, r10, r4, null, null);
        goto L292
    L290:
        if (r0.n >= r4) goto L292;
    L287:
        if (r3 != n0.d.a) goto L292;
    L281:
        if (r0.d != p0.c.a) goto L283;
        I.set(r4);
        goto L283
    L131:
        if (r4 < o0.e.a) goto L279;
        int r5 = r0.b;
        n0 r9 = n0.f;
        if (r5 == r9.a) goto L135;
    L137:
        o0 r6 = o0.f;
        r6.getClass();
        if (r0.d != p0.c.a) goto L140;
        int r7 = I.get();
    L142:
        if (r0.d != p0.d.a) goto L157;
        if (r0.m < r0.k) goto L147;
    L165:
        boolean r8 = false;
    L167:
        Enum r11 = g0.b;
        int r12 = r6.a;
        if (r8 == true) goto L170;
        boolean r15 = true;
        boolean r16 = false;
    L190:
        if (r12 < o0.h.a) goto L277;
        r0.m++;
        r0.l = System.currentTimeMillis();
        o0.i.getClass();
        int r13 = c;
        if (r16 == true) goto L195;
    L227:
        int r14 = 0;
    L229:
        if (r14 == 0) goto L231;
        o0 r17 = o0.j;
    L276:
        int r18 = r17.a;
    L278:
        r4 = r18;
        goto L279
    L231:
        if (r0.b != r9.a) goto L233;
        r17 = o0.k;
        goto L276
    L233:
        o0.l.getClass();
        int r19 = r11.ordinal();
        if (r19 == 2) goto L247;
        if (r19 == 3) goto L245;
        if (r19 != 4) goto L238;
        g0 r20 = g0.e;
    L246:
        boolean r21 = false;
    L248:
        int r22 = r20.a;
        if (r15 == false) goto L251;
        int r110 = 134217731;
    L252:
        r13 = ((Integer) p2.a(r110, r22, r0.f, r0.e, r0.i)).intValue();
    L253:
        if (r13 != 0) goto L274;
        o0 r23 = o0.n;
        r23.getClass();
        if (r21 == true) goto L258;
        r18 = r23.a;
        goto L278
    L258:
        if (this.a == null) goto L260;
    L269:
        Object r24 = this.a;
        if (r24 != null) goto L272;
        o0 r25 = o0.o;
    L273:
        r18 = r25.a;
        goto L278
    L272:
        p2.a(33554433, r0.f, ((Long) r24).longValue(), r0.e, d2.b.a);
        r25 = o0.p;
        goto L273
    L260:
        monitor-enter(r0.class);
    L266:
        th = move-exception;
        throw th;
    L262:
        if (this.a != null) goto L264;
        this.a = p2.a(50331651, 0, 0, null, null);     // Catch: Throwable -> L266
    L264:
        monitor-exit(r0.class);     // Catch: Throwable -> L266
        goto L269
    L274:
        r18 = o0.m.a;
        goto L278
    L251:
        r110 = 134217730;
        goto L252
    L238:
        if (r19 != 5) goto L240;
        r20 = g0.f;
        goto L246
    L240:
        if (r19 == 6) goto L242;
        r21 = false;
        goto L253
    L242:
        r20 = g0.g;
        goto L246
    L245:
        r20 = g0.d;
        goto L246
    L247:
        r20 = g0.e;
        r21 = true;
        goto L248
    L195:
        if (r0.n >= o0.k.a) goto L227;
        if (r0.m > 3) goto L228;
        int r28 = ((q0[]) q0.f.clone())[r0.c].ordinal();
        if (r28 == 1) goto L204;
        if (r28 != 2) goto L228;
    L204:
        int r29 = r0.g;
        int r30 = r0.b;
        m0 r31 = m0.b;
        r31.getClass();
        int r32 = ((n0[]) n0.h.clone())[r30].ordinal();
        if (r32 == 1) goto L215;
        if (r32 == 2) goto L214;
        if (r32 == 3) goto L213;
        if (r32 == 4) goto L212;
        if (r32 == 5) goto L211;
        int r33 = r31.a;
    L218:
        if (r33 == r31.a) goto L228;
        if (r0.c != q0.c.a) goto L226;
        if (r0.a >= b) goto L226;
        r29 = 1;
    L226:
        if (((Integer) p2.a(134217729, r33, r29, r0.h, r0.j)).intValue() != 0) goto L228;
    L211:
        m0 r34 = m0.g;
    L216:
        r33 = r34.a;
        goto L218
    L212:
        r34 = m0.f;
        goto L216
    L213:
        r34 = m0.d;
        goto L216
    L214:
        r34 = m0.e;
        goto L216
    L215:
        r34 = m0.c;
    L228:
        r14 = r13;
        goto L229
    L277:
        r18 = o0.g.a;
        goto L278
    L170:
        int r35 = ((n0[]) n0.h.clone())[r0.b].ordinal();
        if (r35 == 1) goto L183;
        if (r35 == 2) goto L180;
        if (r35 == 3) goto L179;
        if (r35 == 4) goto L178;
        if (r35 == 5) goto L177;
        Enum r36 = r11;
        r15 = true;
    L184:
        r16 = false;
    L185:
        if (r36 == r11) goto L188;
        r12 = o0.h.a;
    L188:
        r11 = r36;
        goto L190
    L177:
        r36 = g0.g;
    L181:
        r15 = false;
    L182:
        r16 = true;
        goto L185
    L178:
        r36 = g0.f;
        r15 = true;
        goto L182
    L179:
        r36 = g0.d;
        goto L181
    L180:
        r36 = g0.e;
        goto L181
    L183:
        r36 = g0.c;
        r15 = false;
        goto L184
    L147:
        if ((System.currentTimeMillis() - r0.l) < n) goto L165;
        if (r7 != o0.p.a) goto L152;
    L166:
        r8 = true;
        goto L167
    L152:
        if (r7 == o0.n.a) goto L166;
        if (r7 == o0.r.a) goto L166;
    L157:
        if (r7 == o0.b.a) goto L166;
        if (r7 == o0.j.a) goto L166;
        if (r7 == o0.q.a) goto L166;
        if (r7 != o0.o.a) goto L165;
    L140:
        r7 = r0.n;
        goto L142
    L135:
        if (r27 == i0.c.a) goto L137;
    L10:
        if (r27 != i0.c.a) goto L312;
        r0 = (l0) J.get(r26);
        if (r0 == null) goto L125;
        int r37 = r0.f;
    L14:
        r10 = r37;
        goto L129
    L312:
        JSONObject r38 = new JSONObject(r26);     // Catch: Exception -> L126
        int r111 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, u));     // Catch: Exception -> L126
        int r39 = b;     // Catch: Exception -> L126
        if (r111 < (r39 - 1)) goto L124;
        if (r111 > r39) goto L124;
        String r40 = JSONObjectProtectorUtils.getString(r38, v);     // Catch: Exception -> L126
        if (r40 == null) goto L124;
        l0 r112 = (l0) H.get(r40);     // Catch: Exception -> L126
        if (r112 == null) goto L25;
        r4 = r112.n;     // Catch: Exception -> L123
        r0 = r112;
        goto L125
    L25:
        r3 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, w));     // Catch: Exception -> L123
        String r113 = JSONObjectProtectorUtils.getString(r38, E);     // Catch: Exception -> L123
        String r41 = "";
        if (r3 != n0.c.a) goto L32;
        if (o.get() > g) goto L122;
        String r114 = "";
        String r115 = "";
        int r116 = 0;
        int r117 = 0;
    L74:
        String r118 = JSONObjectProtectorUtils.getString(r38, z);     // Catch: Exception -> L123
        if (r118 == null) goto L122;
        if (r118.length() > l) goto L122;
        int r119 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, A));     // Catch: Exception -> L123
        if (r119 > 0) goto L310;
    L121:
        r10 = r119;
        r0 = r112;
        goto L129
    L310:
    L119:
        int r210 = r119;
    L120:
        int r120 = r210;
        l0 r121 = r112;
    L127:
        r37 = r120;
        r0 = r121;
    L128:
        r4 = o0.d.a;
        goto L14
    L82:
        if (r119 > f) goto L121;
        int r122 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, y));     // Catch: Exception -> L119
        if (r122 >= p0.e.a) goto L121;
        if (r122 <= p0.b.a) goto L121;
        int r211 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, F));     // Catch: Exception -> L91
    L92:
        if (r211 < 0) goto L121;
        r210 = r119;
        l0 r42 = new l0(r111, r3, r116, r122, r118, r210, r117, r115, r113, r114, r211);     // Catch: Exception -> L302
        H.put(r40, r42);     // Catch: Exception -> L118
        if (r3 != n0.c.a) goto L101;
        AtomicInteger r43 = o;     // Catch: Exception -> L118
    L115:
        r43.incrementAndGet();     // Catch: Exception -> L118
    L116:
        r10 = r210;
        r4 = o0.e.a;     // Catch: Exception -> L118
        r0 = r42;
        goto L129
    L101:
        if (r3 != n0.d.a) goto L104;
        r43 = p;     // Catch: Exception -> L118
        goto L115
    L104:
        if (r3 != n0.e.a) goto L107;
        r43 = q;     // Catch: Exception -> L118
        goto L115
    L107:
        if (r3 != n0.f.a) goto L113;
        HashMap r44 = J;     // Catch: Exception -> L118
        if (r44.get(r113) != null) goto L111;
        r44.put(r113, r42);     // Catch: Exception -> L118
    L111:
        r43 = r;     // Catch: Exception -> L118
        goto L115
    L113:
        if (r3 != n0.g.a) goto L116;
        r43 = s;     // Catch: Exception -> L118
    L118:
        r0 = r42;
        r37 = r210;
    L91:
        r211 = 1;
    L122:
        r0 = r112;
        goto L125
    L32:
        if (r3 != n0.d.a) goto L37;
        if (p.get() > h) goto L122;
    L55:
        int r123 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, x));     // Catch: Exception -> L123
        if (r123 >= q0.e.a) goto L122;
        if (r123 <= q0.b.a) goto L122;
        int r124 = CastIntegerProtector.parseInt(JSONObjectProtectorUtils.getString(r38, B));     // Catch: Exception -> L123
        if (r124 < 0) goto L122;
        if (r123 != q0.d.a) goto L70;
        r41 = JSONObjectProtectorUtils.getString(r38, C);     // Catch: Exception -> L123
        if (r41 == null) goto L122;
        if (r41.isEmpty() == true) goto L122;
    L70:
        String r125 = JSONObjectProtectorUtils.getString(r38, D);     // Catch: Exception -> L123
        if (r125 == null) goto L122;
        r114 = r41;
        r117 = r124;
        r115 = r125;
        r116 = r123;
        goto L74
    L37:
        if (r3 != n0.e.a) goto L42;
        if (q.get() <= i) goto L55;
    L42:
        if (r3 != n0.f.a) goto L51;
        if (r.get() > j) goto L122;
        if (r113 == null) goto L122;
        if (r113.length() <= m) goto L55;
    L51:
        if (r3 != n0.g.a) goto L122;
        if (s.get() <= k) goto L55;
    L123:
        r121 = r112;
        r120 = 0;
    L126:
        r120 = 0;
        r121 = null;
        goto L127
    L5:
        if (r27 == i0.c.a) goto L7;
        goto L7
    }
}
