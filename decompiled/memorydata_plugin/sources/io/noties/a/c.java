package io.noties.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
abstract class c {

    /* JADX INFO: renamed from: io.noties.a.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class a extends c {

        /* JADX INFO: renamed from: io.noties.a.c$a$a, reason: collision with other inner class name */
        interface InterfaceC0855a {
            h.a a(h.a r1);

            h.c a(h.c r1);

            h.f a(h.f r1);

            void a(h.a r1, h.a r2);

            void a(h.c r1, h.c r2);

            void a(h.f r1, h.f r2);
        }

        private static class b implements InterfaceC0855a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Map<Integer, Object> f16377a;

            private b() {
                this.f16377a = new HashMap(3);
            }

            /* synthetic */ b(AnonymousClass1 r1) {
                this();
            }

            private static int a(Object r0) {
                return System.identityHashCode(r0);
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public h.a a(h.a r3) {
                h.a r4 = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.memorydata.plugin");
                return (h.a) ZeusTransformUtils.preCheckCast(this.f16377a.get(Integer.valueOf(a(r4))), h.a.class, "com.obric.memorydata.plugin");
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public h.c a(h.c r3) {
                h.c r4 = (h.c) ZeusTransformUtils.wrapperContextForParams(r3, h.c.class, "com.obric.memorydata.plugin");
                return (h.c) ZeusTransformUtils.preCheckCast(this.f16377a.get(Integer.valueOf(a(r4))), h.c.class, "com.obric.memorydata.plugin");
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public h.f a(h.f r3) {
                h.f r4 = (h.f) ZeusTransformUtils.wrapperContextForParams(r3, h.f.class, "com.obric.memorydata.plugin");
                return (h.f) ZeusTransformUtils.preCheckCast(this.f16377a.get(Integer.valueOf(a(r4))), h.f.class, "com.obric.memorydata.plugin");
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public void a(h.a r3, h.a r4) {
                h.a r5 = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.memorydata.plugin");
                h.a r6 = (h.a) ZeusTransformUtils.wrapperContextForParams(r4, h.a.class, "com.obric.memorydata.plugin");
                this.f16377a.put(Integer.valueOf(a(r5)), r6);
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public void a(h.c r3, h.c r4) {
                h.c r5 = (h.c) ZeusTransformUtils.wrapperContextForParams(r3, h.c.class, "com.obric.memorydata.plugin");
                h.c r6 = (h.c) ZeusTransformUtils.wrapperContextForParams(r4, h.c.class, "com.obric.memorydata.plugin");
                this.f16377a.put(Integer.valueOf(a(r5)), r6);
            }

            @Override // io.noties.a.c.a.InterfaceC0855a
            public void a(h.f r3, h.f r4) {
                h.f r5 = (h.f) ZeusTransformUtils.wrapperContextForParams(r3, h.f.class, "com.obric.memorydata.plugin");
                h.f r6 = (h.f) ZeusTransformUtils.wrapperContextForParams(r4, h.f.class, "com.obric.memorydata.plugin");
                this.f16377a.put(Integer.valueOf(a(r5)), r6);
            }
        }

        a() {
        }

        private h.a a(InterfaceC0855a r6, h.a r7) {
            InterfaceC0855a r8 = (InterfaceC0855a) ZeusTransformUtils.wrapperContextForParams(r6, InterfaceC0855a.class, "com.obric.memorydata.plugin");
            h.a r9 = (h.a) ZeusTransformUtils.wrapperContextForParams(r7, h.a.class, "com.obric.memorydata.plugin");
            h.a r0 = r8.a(r9);
            if (r0 == null) goto L5;
            return r0;
        L5:
            List<h.f> r1 = r9.b();
            ArrayList r2 = new ArrayList(r1.size());
            d r3 = new d(r9.a(), r2);
            r8.a(r9, r3);
            Iterator<h.f> r10 = r1.iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            r2.add(a(r8, (h.f) ZeusTransformUtils.preCheckCast(r10.next(), h.f.class, "com.obric.memorydata.plugin")));
            goto L7
        L9:
            return r3;
        }

        private h.c a(InterfaceC0855a r9, h.c r10) {
            InterfaceC0855a r11 = (InterfaceC0855a) ZeusTransformUtils.wrapperContextForParams(r9, InterfaceC0855a.class, "com.obric.memorydata.plugin");
            h.c r12 = (h.c) ZeusTransformUtils.wrapperContextForParams(r10, h.c.class, "com.obric.memorydata.plugin");
            h.c r0 = r11.a(r12);
            if (r0 == null) goto L5;
            return r0;
        L5:
            h.a r1 = r12.e();
            Pattern r2 = r12.a();
            boolean r3 = r12.b();
            boolean r4 = r12.c();
            String r5 = r12.d();
            if (r1 == null) goto L8;
            h.a r8 = a(r11, r1);
        L9:
            g r7 = new g(r2, r3, r4, r5, r8);
            r11.a(r12, r7);
            return r7;
        L8:
            r8 = null;
            goto L9
        }

        private h.f a(InterfaceC0855a r6, h.f r7) {
            InterfaceC0855a r8 = (InterfaceC0855a) ZeusTransformUtils.wrapperContextForParams(r6, InterfaceC0855a.class, "com.obric.memorydata.plugin");
            h.f r9 = (h.f) ZeusTransformUtils.wrapperContextForParams(r7, h.f.class, "com.obric.memorydata.plugin");
            h.f r0 = r8.a(r9);
            if (r0 == null) goto L5;
            return r0;
        L5:
            List<h.c> r1 = r9.b();
            ArrayList r2 = new ArrayList(r1.size());
            l r3 = new l(r9.a(), r2);
            r8.a(r9, r3);
            Iterator<h.c> r10 = r1.iterator();
        L7:
            if (r10.hasNext() == false) goto L9;
            r2.add(a(r8, (h.c) ZeusTransformUtils.preCheckCast(r10.next(), h.c.class, "com.obric.memorydata.plugin")));
            goto L7
        L9:
            return r3;
        }

        @Override // io.noties.a.c
        h.a a(h.a r3) {
            h.a r4 = (h.a) ZeusTransformUtils.wrapperContextForParams(r3, h.a.class, "com.obric.memorydata.plugin");
            return a(new b(null), r4);
        }

        @Override // io.noties.a.c
        h.f a(h.f r3) {
            h.f r4 = (h.f) ZeusTransformUtils.wrapperContextForParams(r3, h.f.class, "com.obric.memorydata.plugin");
            return a(new b(null), r4);
        }
    }

    c() {
    }

    static c a() {
        return new a();
    }

    abstract h.a a(h.a r1);

    abstract h.f a(h.f r1);
}
