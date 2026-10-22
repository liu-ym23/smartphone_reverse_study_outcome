package k4;

import android.util.Log;
import com.bytedance.apm.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import t.f;
import t.g;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: k4.a$a, reason: collision with other inner class name */
    static class C0216a implements Comparator<g> {
        C0216a() {
        }

        public int a(g r10, g r11) {
            return Integer.compare((r11.f12919d + 1) * r11.f12917b, (r10.f12919d + 1) * r10.f12917b);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(g r10, g r11) {
            return a(r10, r11);
        }
    }

    public interface b {
        boolean a(long r10, int r11);

        int b();

        void c(List<g> r10, int r11);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f10059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f10060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        LinkedList<c> f10061c;

        c(g r10, c r11) {
            this.f10061c = new LinkedList();
            this.f10059a = r10;
            this.f10060b = r11;
        }

        static /* synthetic */ int a(c r10) {
            return r10.d();
        }

        static /* synthetic */ void b(c r10, c r11) {
            r10.c(r11);
        }

        private void c(c r10) {
            this.f10061c.addFirst(r10);
        }

        private int d() {
            g r10 = this.f10059a;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.f12919d;
        }
    }

    private static int a(LinkedList<g> r10, g r11) {
        if (d.D() == false) goto L5;
        Log.v("TraceDataUtils", "method:" + r11);
    L5:
        g r12 = null;
        if (r10.isEmpty() == true) goto L8;
        r12 = r10.peek();
    L8:
        if (r12 != null) goto L10;
    L19:
        r10.push(r11);
        return r11.f12917b;
    L10:
        if (r12.f12916a != r11.f12916a) goto L19;
        int r13 = r12.f12919d;
        int r14 = r11.f12919d;
        if (r13 != r14) goto L19;
        if (r14 == 0) goto L19;
        int r15 = r11.f12917b;
        if (r15 != 5000) goto L17;
        r15 = r12.f12917b;
    L17:
        r11.f12917b = r15;
        r12.a(r15);
        return r12.f12917b;
    }

    public static int b(long r10) {
        return (int) ((r10 >> 43) & 1048575);
    }

    private static long c(long r10) {
        return r10 & 8796093022207L;
    }

    public static String d(List<g> r10, long r11) {
        StringBuilder r12 = new StringBuilder();
        long r13 = (long) (r11 * 0.3f);
        LinkedList r14 = new LinkedList();
        Iterator<g> r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        g r16 = r15.next();
        if (r16.f12917b < r13) goto L4;
        r14.add(r16);
        goto L4
    L8:
        Collections.sort(r14, new C0216a());
        if (r14.isEmpty() == false) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r14.add(r10.get(0));
    L18:
        Iterator r17 = r14.iterator();
        if (r17.hasNext() == false) goto L22;
        r12.append(((g) r17.next()).f12916a + "\n");
    L22:
        return r12.toString();
    L14:
        if (r14.size() <= 1) goto L18;
        if (((g) r14.peek()).f12916a != 1048574) goto L18;
        r14.removeFirst();
        goto L18
    }

    private static boolean e(long r10) {
        if (((r10 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(List<g> r10, int r11) {
        if (r11 >= 0) goto L5;
        r10.clear();
        return;
    L5:
        ListIterator<g> r12 = r10.listIterator(r10.size());
    L7:
        if (r12.hasPrevious() == false) goto L11;
        if (r12.previous().f12917b >= r11) goto L7;
        r12.remove();
        goto L7
    }

    public static long g(LinkedList<g> r10, StringBuilder r11) {
        Iterator<g> r12 = r10.iterator();
        long r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L8;
        g r14 = r12.next();
        r11.append(r14.toString());
        r11.append('\n');
        int r15 = r14.f12917b;
        if (r13 >= r15) goto L4;
        r13 = r15;
        goto L4
    L8:
        return r13;
    }

    public static int h(LinkedList<g> r10, c r11) {
        ListIterator<g> r12 = r10.listIterator(0);
        c r13 = null;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L31;
        c r15 = new c(r12.next(), r13);
        r14 = r14 + 1;
        if (r13 == null) goto L8;
    L13:
        int r16 = c.a(r15);
        if (r13 == null) goto L29;
        if (r16 == 0) goto L29;
        if (c.a(r13) < r16) goto L28;
    L19:
        if (r13 == null) goto L23;
        if (c.a(r13) <= r16) goto L23;
        r13 = r13.f10060b;
    L23:
        if (r13 == null) goto L4;
        c r17 = r13.f10060b;
        if (r17 == null) goto L30;
        r15.f10060b = r17;
        r13 = r13.f10060b;
    L30:
        r13 = r15;
    L28:
        c.b(r13, r15);
    L29:
        c.b(r11, r15);
        goto L30
    L8:
        if (c.a(r15) == 0) goto L13;
        if (d.D() == false) goto L12;
        e0.g.a("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        e0.g.b("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r14)});
        return r14;
    }

    public static void i(int r24, long[] r25, LinkedList<g> r26, boolean r27, long r28, int r30) {
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L116;
        long r10 = Long.MAX_VALUE;
        int r11 = 1;
        long r12 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        r10 = c(r25[r25.length - 1]);
    L10:
        int r13 = 0;
        int r14 = 0;
    L12:
        if (r14 >= r25.length) goto L17;
        if (c(r25[r14]) < r10) goto L17;
        r14 = r14 + 1;
    L17:
        if (r24 > 0) goto L19;
        int r15 = 1048574;
    L20:
        LinkedList r16 = new LinkedList();
        int r17 = 0;
        int r18 = 0;
    L22:
        if (r14 >= r25.length) goto L72;
        long r19 = r25[r14];
        if (r12 != r19) goto L26;
    L25:
        long r22 = r12;
    L71:
        r14 = r14 + 1;
        r12 = r22;
        r13 = 0;
        r11 = 1;
        goto L22
    L26:
        if (r27 == false) goto L37;
        if (e(r19) == true) goto L30;
    L32:
        if (r18 != 0) goto L37;
        if (b(r19) <= 1048000) goto L25;
        Object[] r110 = new Object[2];
        r110[r13] = Integer.valueOf(b(r19));
        r110[r11] = Boolean.valueOf(e(r19));
        e0.g.b("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", r110);
        goto L25
    L30:
        if (r15 != b(r19)) goto L32;
        r18 = r11;
    L37:
        if (e(r19) == true) goto L39;
        int r111 = b(r19);
        if (r16.isEmpty() == true) goto L68;
        long r112 = ((Long) r16.pop()).longValue();
        r17 = r17 - 1;
        LinkedList r113 = new LinkedList();
    L45:
        r113.push(Long.valueOf(r112));
        int r20 = b(r112);
        if (r20 == r111) goto L53;
        if (r16.isEmpty() == true) goto L53;
        if (d.D() == false) goto L52;
        Object[] r114 = new Object[2];
        r114[r13] = Integer.valueOf(r20);
        r114[r11] = Integer.valueOf(r111);
        e0.g.c("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", r114);
    L52:
        r112 = ((Long) r16.pop()).longValue();
        r17 = r17 - 1;
    L53:
        if (r20 == r111) goto L56;
        if (r20 != r15) goto L56;
        d.D();
        r16.addAll(r113);
        r17 = r17 + r16.size();
    L67:
        r22 = 0;
    L56:
        long r21 = c(r19) + f.C();
    L58:
        if (r113.size() == 0) goto L67;
        long r115 = c(((Long) r113.pop()).longValue()) + f.C();
        long r23 = r21 - r115;
        if (r23 < 0) goto L62;
        a(r26, new g(r111, (int) r23, r115, r17));
        goto L58
    L62:
        if (d.D() == false) goto L64;
        e0.g.a("TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r23)});
    L64:
        r16.clear();
        r26.clear();
        return;
    L68:
        r22 = r12;
        if (d.D() == false) goto L71;
        e0.g.c("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r111)});
        goto L71
    L39:
        if (b(r19) != r15) goto L41;
        r16.clear();
        r17 = r13;
    L41:
        r17 = r17 + r11;
        r16.push(Long.valueOf(r19));
        goto L25
    L72:
        e0.g.b("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r16.size(), new Object[0]);
    L74:
        if (r16.isEmpty() == true) goto L89;
        long r29 = ((Long) r16.pop()).longValue();
        int r116 = b(r29);
        boolean r31 = e(r29);
        long r117 = c(r29) + f.C();
        if (d.D() == false) goto L78;
        e0.g.c("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r116), Boolean.valueOf(r31), Long.valueOf(r117), Long.valueOf(r28), Integer.valueOf(r16.size())});
    L78:
        if (r31 == false) goto L80;
        if (r30 <= 0) goto L85;
        boolean r32 = true;
    L86:
        if (r32 == false) goto L88;
        if (r17 > r30) goto L74;
    L88:
        a(r26, new g(r116, (int) (r28 - r117), r117, r16.size()));
        goto L74
    L85:
        r32 = false;
        goto L86
    L80:
        if (d.D() == false) goto L74;
        e0.g.a("TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r116)});
        goto L74
    L89:
        c r33 = new c(null, null);
        h(r26, r33);
        r26.clear();
        k(r33, r26);
        return;
    L19:
        r15 = r24;
        goto L20
    }

    public static void j(long[] r10, LinkedList<g> r11, boolean r12, long r13) {
        i(1048574, r10, r11, r12, r13, -1);
    }

    private static void k(c r10, LinkedList<g> r11) {
        LinkedList r12 = new LinkedList();
    L3:
        if (r10 == null) goto L13;
        g r13 = r10.f10059a;
        if (r13 == null) goto L7;
        r11.add(r13);
    L7:
        LinkedList<c> r14 = r10.f10061c;
        if (r14.isEmpty() == true) goto L12;
        int r15 = r14.size() - 1;
    L10:
        if (r15 < 0) goto L12;
        r12.add(r14.get(r15));
        r15 = r15 - 1;
    L12:
        r10 = (c) r12.pollLast();
        goto L3
    }

    public static void l(List<g> r10, int r11) {
        ListIterator<g> r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L10;
        g r13 = r12.previous();
        if (r13 == null) goto L4;
        if (r13.f12917b >= r11) goto L4;
        r12.remove();
        goto L4
    }

    public static void m(List<g> r10, int r11, b r12) {
        if (r11 >= 0) goto L5;
        r10.clear();
        return;
    L5:
        int r13 = r10.size();
        int r14 = 1;
    L6:
        if (r13 <= r11) goto L17;
        ListIterator<g> r15 = r10.listIterator(r10.size());
    L9:
        if (r15.hasPrevious() == false) goto L15;
        if (r12.a(r15.previous().f12917b, r14) == false) goto L9;
        r15.remove();
        r13 = r13 - 1;
        if (r13 > r11) goto L9;
        return;
    L15:
        r13 = r10.size();
        r14 = r14 + 1;
        if (r12.b() >= r14) goto L6;
    L17:
        int r16 = r10.size();
        if (r16 <= r11) goto L30;
        r12.c(r10, r16);
        return;
    }
}
