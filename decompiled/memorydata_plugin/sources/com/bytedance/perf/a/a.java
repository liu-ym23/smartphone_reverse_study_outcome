package com.bytedance.perf.a;

import android.util.Log;
import com.bytedance.apm.block.a.h;
import com.bytedance.apm.e.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: com.bytedance.perf.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0149a {
        int a();

        void a(List<h> r1, int r2);

        boolean a(long r1, int r3);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h f2968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b f2969b;
        LinkedList<b> c;

        b(h r2, b r3) {
            this.c = new LinkedList();
            this.f2968a = r2;
            this.f2969b = r3;
        }

        private int a() {
            h r0 = this.f2968a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.d;
        }

        static /* synthetic */ int a(b r0) {
            return r0.a();
        }

        static /* synthetic */ void a(b r0, b r1) {
            r0.b(r1);
        }

        private void b(b r1) {
            this.c.addFirst(r1);
        }
    }

    public static int a(long r2) {
        return (int) ((r2 >> 43) & 1048575);
    }

    private static int a(LinkedList<h> r3, h r4) {
        if (com.bytedance.apm.b.k() == false) goto L5;
        Log.v("TraceDataUtils", "method:" + r4);
    L5:
        h r0 = null;
        if (r3.isEmpty() == true) goto L8;
        r0 = (h) ZeusTransformUtils.preCheckCast(r3.peek(), h.class, "com.obric.memorydata.plugin");
    L8:
        if (r0 != null) goto L10;
    L21:
        r3.push(r4);
        return r4.f1221b;
    L10:
        if (r0.f1220a != r4.f1220a) goto L21;
        if (r0.d != r4.d) goto L21;
        if (r4.d == 0) goto L21;
        if (r4.f1221b != 5000) goto L18;
        int r5 = r0.f1221b;
    L19:
        r4.f1221b = r5;
        r0.a(r4.f1221b);
        return r0.f1221b;
    L18:
        r5 = r4.f1221b;
        goto L19
    }

    public static int a(LinkedList<h> r7, b r8) {
        ListIterator<h> r9 = r7.listIterator(0);
        b r1 = null;
        int r2 = 0;
    L4:
        if (r9.hasNext() == false) goto L31;
        b r3 = new b((h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.memorydata.plugin"), r1);
        r2 = r2 + 1;
        if (r1 == null) goto L8;
    L13:
        int r4 = b.a(r3);
        if (r1 == null) goto L29;
        if (r4 == 0) goto L29;
        if (b.a(r1) < r4) goto L28;
    L19:
        if (r1 == null) goto L23;
        if (b.a(r1) <= r4) goto L23;
        r1 = r1.f2969b;
    L23:
        if (r1 == null) goto L4;
        if (r1.f2969b == null) goto L30;
        r3.f2969b = r1.f2969b;
        r1 = r1.f2969b;
    L30:
        r1 = r3;
    L28:
        b.a(r1, r3);
    L29:
        b.a(r8, r3);
        goto L30
    L8:
        if (b.a(r3) == 0) goto L13;
        if (com.bytedance.apm.b.k() == false) goto L12;
        g.c("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        g.a("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r2)});
        return r2;
    }

    public static long a(LinkedList<h> r5, StringBuilder r6) {
        Iterator<h> r7 = r5.iterator();
        long r0 = 0;
    L4:
        if (r7.hasNext() == false) goto L8;
        h r2 = (h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.memorydata.plugin");
        r6.append(r2.toString()).append('\n');
        if (r0 >= r2.f1221b) goto L4;
        r0 = r2.f1221b;
        goto L4
    L8:
        return r0;
    }

    public static String a(List<h> r7, long r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        long r10 = (long) (r8 * 0.3f);
        LinkedList r2 = new LinkedList();
        Iterator r3 = r9.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3.next(), h.class, "com.obric.memorydata.plugin");
        if (r4.f1221b < r10) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Collections.sort(r2, new AnonymousClass1());
        if (r2.isEmpty() == false) goto L14;
        if (r9.isEmpty() == true) goto L14;
        r2.add((h) ZeusTransformUtils.preCheckCast(r9.get(0), h.class, "com.obric.memorydata.plugin"));
    L18:
        Iterator r11 = r2.iterator();
        if (r11.hasNext() == false) goto L22;
        r0.append(((h) ZeusTransformUtils.preCheckCast(r11.next(), h.class, "com.obric.memorydata.plugin")).f1220a + "\n");
    L22:
        return r0.toString();
    L14:
        if (r2.size() <= 1) goto L18;
        if (((h) ZeusTransformUtils.preCheckCast(r2.peek(), h.class, "com.obric.memorydata.plugin")).f1220a != 1048574) goto L18;
        r2.removeFirst();
        goto L18
    }

    public static void a(int r24, long[] r25, LinkedList<h> r26, boolean r27, long r28, int r30) {
        if (r25 != null) goto L5;
        return;
    L5:
        if (r25.length == 0) goto L116;
        long r3 = Long.MAX_VALUE;
        long r9 = 0;
        if (r25[r25.length - 1] == 0) goto L10;
        r3 = c(r25[r25.length - 1]);
    L10:
        int r5 = 0;
        int r7 = 0;
    L12:
        if (r7 >= r25.length) goto L17;
        if (c(r25[r7]) < r3) goto L17;
        r7 = r7 + 1;
    L17:
        if (r24 > 0) goto L19;
        int r4 = 1048574;
    L20:
        LinkedList r6 = new LinkedList();
        int r8 = 0;
        boolean r11 = false;
    L22:
        if (r7 >= r25.length) goto L72;
        long r16 = r25[r7];
        if (r9 != r16) goto L26;
    L25:
        long r22 = r9;
    L71:
        r7 = r7 + 1;
        r9 = r22;
        r5 = 0;
        goto L22
    L26:
        if (r27 == false) goto L37;
        if (b(r16) == true) goto L30;
    L32:
        if (r11 == true) goto L37;
        if (a(r16) <= 1048000) goto L25;
        Object[] r10 = new Object[2];
        r10[r5] = Integer.valueOf(a(r16));
        r10[1] = Boolean.valueOf(b(r16));
        g.a("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", r10);
        goto L25
    L30:
        if (r4 != a(r16)) goto L32;
        r11 = true;
    L37:
        if (b(r16) == true) goto L39;
        int r12 = a(r16);
        if (r6.isEmpty() == true) goto L68;
        long r13 = ((Long) ZeusTransformUtils.preCheckCast(r6.pop(), Long.class, "com.obric.memorydata.plugin")).longValue();
        r8 = r8 - 1;
        LinkedList r14 = new LinkedList();
    L45:
        r14.push(Long.valueOf(r13));
        int r15 = a(r13);
        if (r15 == r12) goto L53;
        if (r6.isEmpty() == true) goto L53;
        if (com.bytedance.apm.b.k() == false) goto L52;
        g.b("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r15), Integer.valueOf(r12)});
    L52:
        r13 = ((Long) ZeusTransformUtils.preCheckCast(r6.pop(), Long.class, "com.obric.memorydata.plugin")).longValue();
        r8 = r8 - 1;
    L53:
        if (r15 == r12) goto L56;
        if (r15 != r4) goto L56;
        com.bytedance.apm.b.k();
        r6.addAll(r14);
        r8 = r8 + r6.size();
    L67:
        r22 = 0;
    L56:
        long r17 = c(r16) + com.bytedance.apm.block.a.g.f();
    L58:
        if (r14.size() == 0) goto L67;
        long r19 = c(((Long) ZeusTransformUtils.preCheckCast(r14.pop(), Long.class, "com.obric.memorydata.plugin")).longValue()) + com.bytedance.apm.block.a.g.f();
        LinkedList r29 = r14;
        long r18 = r17 - r19;
        if (r18 < 0) goto L62;
        a(r26, new h(r12, (int) r18, r19, r8));
        r14 = r29;
        goto L58
    L62:
        if (com.bytedance.apm.b.k() == false) goto L64;
        g.c("TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r18)});
    L64:
        r6.clear();
        r26.clear();
        return;
    L68:
        r22 = r9;
        if (com.bytedance.apm.b.k() == false) goto L71;
        g.b("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r12)});
        goto L71
    L39:
        if (a(r16) != r4) goto L41;
        r6.clear();
        r8 = r5;
    L41:
        r8 = r8 + 1;
        r6.push(Long.valueOf(r16));
        goto L25
    L72:
        g.a("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r26.size() + ", " + r6.size(), new Object[0]);
    L74:
        if (r6.isEmpty() == true) goto L89;
        long r20 = ((Long) ZeusTransformUtils.preCheckCast(r6.pop(), Long.class, "com.obric.memorydata.plugin")).longValue();
        int r110 = a(r20);
        boolean r0 = b(r20);
        long r111 = c(r20) + com.bytedance.apm.block.a.g.f();
        if (com.bytedance.apm.b.k() == false) goto L78;
        g.b("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r110), Boolean.valueOf(r0), Long.valueOf(r111), Long.valueOf(r28), Integer.valueOf(r6.size())});
    L78:
        if (r0 == false) goto L80;
        if (r30 <= 0) goto L85;
        boolean r21 = true;
    L86:
        if (r21 == false) goto L88;
        if (r8 > r30) goto L74;
    L88:
        a(r26, new h(r110, (int) (r28 - r111), r111, r6.size()));
        goto L74
    L85:
        r21 = false;
        goto L86
    L80:
        if (com.bytedance.apm.b.k() == false) goto L74;
        g.c("TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r110)});
        goto L74
    L89:
        b r1 = new b(null, null);
        a(r26, r1);
        r26.clear();
        a(r1, r26);
        return;
    L19:
        r4 = r24;
        goto L20
    }

    private static void a(b r3, LinkedList<h> r4) {
        LinkedList r0 = new LinkedList();
    L3:
        if (r3 == null) goto L13;
        if (r3.f2968a == null) goto L7;
        r4.add(r3.f2968a);
    L7:
        LinkedList<b> r5 = r3.c;
        if (r5.isEmpty() == true) goto L12;
        int r1 = r5.size() - 1;
    L10:
        if (r1 < 0) goto L12;
        r0.add(r5.get(r1));
        r1 = r1 - 1;
    L12:
        r3 = (b) ZeusTransformUtils.preCheckCast(r0.pollLast(), b.class, "com.obric.memorydata.plugin");
        goto L3
    }

    public static void a(List<h> r3, int r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ListIterator r6 = r5.listIterator(r5.size());
    L4:
        if (r6.hasPrevious() == false) goto L10;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r6.previous(), h.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        if (r0.f1221b >= r4) goto L4;
        r6.remove();
        goto L4
    }

    public static void a(List<h> r6, int r7, InterfaceC0149a r8) {
        List<h> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        InterfaceC0149a r10 = (InterfaceC0149a) ZeusTransformUtils.wrapperContextForParams(r8, InterfaceC0149a.class, "com.obric.memorydata.plugin");
        if (r7 >= 0) goto L6;
        r9.clear();
        return;
    L6:
        int r0 = r9.size();
        int r2 = 1;
    L7:
        if (r0 <= r7) goto L18;
        ListIterator<h> r3 = r9.listIterator(r9.size());
    L10:
        if (r3.hasPrevious() == false) goto L16;
        if (r10.a(((h) ZeusTransformUtils.preCheckCast(r3.previous(), h.class, "com.obric.memorydata.plugin")).f1221b, r2) == false) goto L10;
        r3.remove();
        r0 = r0 - 1;
        if (r0 > r7) goto L10;
        return;
    L16:
        r0 = r9.size();
        r2 = r2 + 1;
        if (r10.a() >= r2) goto L7;
    L18:
        int r1 = r9.size();
        if (r1 <= r7) goto L31;
        r10.a(r9, r1);
        return;
    }

    public static void a(long[] r7, LinkedList<h> r8, boolean r9, long r10) {
        a(1048574, r7, r8, r9, r10, -1);
    }

    public static void b(List<h> r3, int r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r4 >= 0) goto L6;
        r5.clear();
        return;
    L6:
        ListIterator r6 = r5.listIterator(r5.size());
    L8:
        if (r6.hasPrevious() == false) goto L12;
        if (((h) ZeusTransformUtils.preCheckCast(r6.previous(), h.class, "com.obric.memorydata.plugin")).f1221b >= r4) goto L8;
        r6.remove();
        goto L8
    }

    private static boolean b(long r2) {
        if (((r2 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    private static long c(long r2) {
        return r2 & 8796093022207L;
    }
}
