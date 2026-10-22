package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes6.dex */
abstract class k {

    /* JADX INFO: renamed from: io.noties.a.k$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private interface a {
        boolean a(Object r1);

        void b(Object r1);
    }

    private static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Integer> f16387a;

        private b() {
            this.f16387a = new HashSet(3);
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        private static Integer c(Object r0) {
            return Integer.valueOf(System.identityHashCode(r0));
        }

        @Override // io.noties.a.k.a
        public boolean a(Object r1) {
            return this.f16387a.contains(c(r1));
        }

        @Override // io.noties.a.k.a
        public void b(Object r1) {
            this.f16387a.add(c(r1));
        }
    }

    static String a(h.a r3) {
        h.a r4 = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        a(r0, new b(null), r4);
        return r0.toString();
    }

    static String a(h.c r3) {
        h.c r4 = (h.c) ZeusTransformUtils.wrapperContextForParams(r3, h.c.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        a(r0, new b(null), r4);
        return r0.toString();
    }

    static String a(h.f r3) {
        h.f r4 = (h.f) ZeusTransformUtils.wrapperContextForParams(r3, h.f.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        a(r0, new b(null), r4);
        return r0.toString();
    }

    private static void a(StringBuilder r4, a r5, h.a r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        h.a r8 = (h.a) ZeusTransformUtils.wrapperContextForParams(r6, h.a.class, "com.obric.memorydata.plugin");
        r4.append("Grammar{id=0x").append(Integer.toHexString(System.identityHashCode(r8))).append(",name=\"").append(r8.a()).append(Typography.quote);
        if (r7.a(r8) == false) goto L5;
        r4.append(",[...]");
    L14:
        r4.append('}');
        return;
    L5:
        r7.b(r8);
        r4.append(",tokens=[");
        boolean r0 = true;
        Iterator<h.f> r9 = r8.b().iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        h.f r2 = (h.f) ZeusTransformUtils.preCheckCast(r9.next(), h.f.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L11;
        r0 = false;
    L12:
        a(r4, r7, r2);
        goto L7
    L11:
        r4.append(',');
        goto L12
    L13:
        r4.append(']');
        goto L14
    }

    private static void a(StringBuilder r3, a r4, h.c r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        h.c r7 = (h.c) ZeusTransformUtils.wrapperContextForParams(r5, h.c.class, "com.obric.memorydata.plugin");
        r3.append("Pattern{id=0x").append(Integer.toHexString(System.identityHashCode(r7)));
        if (r6.a(r7) == false) goto L5;
        r3.append(",[...]");
    L17:
        r3.append('}');
        return;
    L5:
        r6.b(r7);
        r3.append(",regex=\"").append(r7.a()).append(Typography.quote);
        if (r7.b() == false) goto L9;
        r3.append(",lookbehind=true");
    L9:
        if (r7.c() == false) goto L12;
        r3.append(",greedy=true");
    L12:
        if (r7.d() == null) goto L14;
        r3.append(",alias=\"").append(r7.d()).append(Typography.quote);
    L14:
        h.a r8 = r7.e();
        if (r8 == null) goto L17;
        r3.append(",inside=");
        a(r3, r6, r8);
        goto L17
    }

    private static void a(StringBuilder r4, a r5, h.f r6) {
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        h.f r8 = (h.f) ZeusTransformUtils.wrapperContextForParams(r6, h.f.class, "com.obric.memorydata.plugin");
        r4.append("Token{id=0x").append(Integer.toHexString(System.identityHashCode(r8))).append(",name=\"").append(r8.a()).append(Typography.quote);
        if (r7.a(r8) == false) goto L5;
        r4.append(",[...]");
    L14:
        r4.append('}');
        return;
    L5:
        r7.b(r8);
        r4.append(",patterns=[");
        boolean r0 = true;
        Iterator<h.c> r9 = r8.b().iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        h.c r2 = (h.c) ZeusTransformUtils.preCheckCast(r9.next(), h.c.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L11;
        r0 = false;
    L12:
        a(r4, r7, r2);
        goto L7
    L11:
        r4.append(',');
        goto L12
    L13:
        r4.append(']');
        goto L14
    }
}
