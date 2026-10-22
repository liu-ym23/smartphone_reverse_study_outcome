package g8;

import android.util.Log;
import c2.k;
import i2.e;
import i2.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f7757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f7758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedList<a> f7759c;

        public a(g r8, a r10) {
            this.f7759c = new LinkedList();
            this.f7757a = r8;
            this.f7758b = r10;
        }
    }

    public static void a(LinkedList r8, g r10) {
        if (k.d() == false) goto L6;
        Log.v("TraceDataUtils", "method:" + r10);
    L6:
        if (r8.isEmpty() == true) goto L8;
        g r11 = (g) r8.peek();
    L9:
        if (r11 != null) goto L11;
    L20:
        r8.push(r10);
        return;
    L11:
        if (r11.f8130a != r10.f8130a) goto L20;
        int r12 = r11.f8133d;
        int r13 = r10.f8133d;
        if (r12 != r13) goto L20;
        if (r13 == 0) goto L20;
        int r14 = r10.f8131b;
        if (r14 != 5000) goto L18;
        r14 = r11.f8131b;
    L18:
        r10.f8131b = r14;
        r11.f8134e++;
        r11.f8131b = (int) (r11.f8131b + ((long) r14));
        return;
    L8:
        r11 = null;
        goto L9
    }

    public static int b(long r8) {
        return (int) ((r8 >> 43) & 1048575);
    }

    public static String c(long r8, LinkedList r10) {
        StringBuilder r11 = new StringBuilder();
        long r12 = (long) (r8 * 0.3f);
        LinkedList r13 = new LinkedList();
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        g r15 = (g) r14.next();
        if (r15.f8131b < r12) goto L4;
        r13.add(r15);
        goto L4
    L8:
        Collections.sort(r13, new g8.a());
        if (r13.isEmpty() == false) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r13.add((g) r10.get(0));
    L18:
        Iterator r16 = r13.iterator();
        if (r16.hasNext() == false) goto L22;
        r11.append(((g) r16.next()).f8130a + "\n");
    L22:
        return r11.toString();
    L14:
        if (r13.size() <= 1) goto L18;
        if (((g) r13.peek()).f8130a != 1048574) goto L18;
        r13.removeFirst();
        goto L18
    }

    public static boolean d(long r8) {
        if (((r8 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static long e(LinkedList<g> r8, StringBuilder r10) {
        Iterator<g> r11 = r8.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        g r13 = r11.next();
        r10.append(r13.toString());
        r10.append('\n');
        long r14 = r13.f8131b;
        if (r12 >= r14) goto L4;
        r12 = r14;
        goto L4
    L8:
        return r12;
    }

    public static void f(long[] r25, LinkedList r26, long r27) {
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L170;
        int r8 = 1;
        long r10 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        long r11 = r25[r25.length - 1] & 8796093022207L;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= r25.length) goto L18;
        if ((r25[r12] & 8796093022207L) < r11) goto L18;
        r12 = r12 + 1;
    L18:
        LinkedList r13 = new LinkedList();
        int r14 = 0;
        int r15 = 0;
    L20:
        if (r12 >= r25.length) goto L67;
        long r16 = r25[r12];
        if (r10 == r16) goto L66;
        if (d(r16) == true) goto L27;
    L29:
        if (r15 != 0) goto L34;
        if (b(r16) <= 1048000) goto L66;
        Log.i("SceneMethodsInfo", String.format("s2 pass this method[%s], isIn [%b] ", new Object[]{Integer.valueOf(b(r16)), Boolean.valueOf(d(r16))}));
        goto L66
    L34:
        if (d(r16) == true) goto L36;
        int r17 = b(r16);
        if (r13.isEmpty() == true) goto L64;
        long r18 = ((Long) r13.pop()).longValue();
        r14 = r14 - 1;
        LinkedList r19 = new LinkedList();
    L42:
        r19.push(Long.valueOf(r18));
        int r20 = b(r18);
        if (r20 == r17) goto L50;
        if (r13.isEmpty() == true) goto L50;
        if (k.d() == false) goto L49;
        l6.a.c1("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r20), Integer.valueOf(r17)});
    L49:
        r18 = ((Long) r13.pop()).longValue();
        r14 = r14 - 1;
    L50:
        if (r20 == r17) goto L53;
        if (r20 != 1048574) goto L53;
        boolean r21 = k.f3297a;
        r13.addAll(r19);
        r14 = r13.size() + r14;
    L53:
        long r22 = (r16 & 8796093022207L) + e.f8112h;
    L55:
        if (r19.size() == 0) goto L66;
        long r23 = (((Long) r19.pop()).longValue() & 8796093022207L) + e.f8112h;
        long r110 = r22 - r23;
        if (r110 < 0) goto L59;
        a(r26, new g(r17, (int) r110, r14, r23));
        goto L55
    L59:
        if (k.d() == false) goto L61;
        Log.e("TraceDataUtils", String.format("[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r110)}));
    L61:
        r13.clear();
        r26.clear();
        return;
    L64:
        if (k.d() == false) goto L66;
        l6.a.c1("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r17)});
        goto L66
    L36:
        if (b(r16) != 1048574) goto L38;
        r13.clear();
        r14 = 0;
    L38:
        r14 = r14 + r8;
        r13.push(Long.valueOf(r16));
        goto L66
    L27:
        if (1048574 != b(r16)) goto L29;
        r15 = r8;
    L66:
        r12 = r12 + 1;
        r8 = 1;
        r10 = 0;
        goto L20
    L67:
        Log.i("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r13.size());
    L69:
        if (r13.isEmpty() == true) goto L78;
        long r24 = ((Long) r13.pop()).longValue();
        int r111 = b(r24);
        boolean r28 = d(r24);
        long r29 = (r24 & 8796093022207L) + e.f8112h;
        if (k.d() == false) goto L73;
        l6.a.c1("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r111), Boolean.valueOf(r28), Long.valueOf(r29), Long.valueOf(r27), Integer.valueOf(r13.size())});
    L73:
        if (r28 == false) goto L75;
        a(r26, new g(r111, (int) (r27 - r29), r13.size(), r29));
        goto L69
    L75:
        if (k.d() == false) goto L69;
        Log.e("TraceDataUtils", String.format("[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r111)}));
        goto L69
    L78:
        a r30 = null;
        a r31 = new a(null, null);
        ListIterator r32 = r26.listIterator(0);
        int r33 = 0;
    L80:
        if (r32.hasNext() == false) goto L117;
        a r34 = new a((g) r32.next(), r30);
        r33 = r33 + 1;
        g r35 = r34.f7757a;
        if (r30 != null) goto L90;
        if (r35 != null) goto L85;
        int r36 = 0;
    L86:
        if (r36 == 0) goto L90;
        if (k.d() == false) goto L118;
        Log.e("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!");
    L118:
        r26.clear();
        LinkedList r37 = new LinkedList();
    L119:
        if (r31 == null) goto L171;
        g r38 = r31.f7757a;
        if (r38 == null) goto L123;
        r26.add(r38);
    L123:
        LinkedList<a> r39 = r31.f7759c;
        if (r39.isEmpty() == true) goto L129;
        int r40 = r39.size();
    L126:
        r40 = r40 - 1;
        if (r40 < 0) goto L129;
        r37.add(r39.get(r40));
    L129:
        r31 = (a) r37.pollLast();
        goto L119
    L171:
        return;
    L85:
        r36 = r35.f8133d;
    L90:
        if (r35 != null) goto L92;
        int r41 = 0;
    L93:
        if (r30 == null) goto L114;
        if (r41 == 0) goto L114;
        g r42 = r30.f7757a;
        if (r42 != null) goto L99;
        int r43 = 0;
    L100:
        if (r43 < r41) goto L113;
    L101:
        if (r30 == null) goto L108;
        g r44 = r30.f7757a;
        if (r44 != null) goto L105;
        int r45 = 0;
    L106:
        if (r45 <= r41) goto L108;
        r30 = r30.f7758b;
        goto L101
    L105:
        r45 = r44.f8133d;
    L108:
        if (r30 == null) goto L80;
        a r46 = r30.f7758b;
        if (r46 == null) goto L116;
        r34.f7758b = r46;
        r30 = r30.f7758b;
    L116:
        r30 = r34;
    L113:
        LinkedList<a> r47 = r30.f7759c;
    L115:
        r47.addFirst(r34);
        goto L116
    L99:
        r43 = r42.f8133d;
    L114:
        r47 = r31.f7759c;
        goto L115
    L92:
        r41 = r35.f8133d;
        goto L93
    L117:
        Log.i("SceneMethodsInfo", String.format("[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r33)}));
        goto L118
    L10:
        r11 = Long.MAX_VALUE;
        goto L11
    }

    public static void g(LinkedList r8, h8.b r10) {
        int r11 = r8.size();
        int r12 = 1;
    L4:
        if (r11 <= 30) goto L18;
        ListIterator r13 = r8.listIterator(r8.size());
    L7:
        if (r13.hasPrevious() == false) goto L16;
        if (((g) r13.previous()).f8131b >= (r12 * 5)) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L7;
        r13.remove();
        r11 = r11 - 1;
        if (r11 > 30) goto L7;
        return;
    L11:
        r14 = false;
        goto L12
    L16:
        r11 = r8.size();
        r12 = r12 + 1;
        if (60 >= r12) goto L4;
    L18:
        int r15 = r8.size();
        if (r15 > 30) goto L21;
        return;
    L21:
        if (k.d() == false) goto L23;
        l6.a.c1("EvilMethodTracer", "[fallback] size:%s targetSize:%s stack:%s", new Object[]{Integer.valueOf(r15), 30, r8});
    L23:
        ListIterator r16 = r8.listIterator(Math.min(r15, 30));
    L25:
        if (r16.hasNext() == false) goto L38;
        r16.next();
        r16.remove();
        goto L25
    }
}
