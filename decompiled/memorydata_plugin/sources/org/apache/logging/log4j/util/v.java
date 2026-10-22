package org.apache.logging.log4j.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.status.StatusLogger;

/* JADX INFO: loaded from: classes6.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.apache.logging.log4j.c f17942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f17943b = 0;
    private static final int c = 0;
    private static ThreadLocal<a> d;
    private static b e;

    /* JADX INFO: renamed from: org.apache.logging.log4j.util.v$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StringBuilder[] f17944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17945b;

        a() {
            this.f17944a = new StringBuilder[v.a()];
            int r0 = 0;
        L3:
            StringBuilder[] r1 = this.f17944a;
            if (r0 >= r1.length) goto L6;
            r1[r0] = new StringBuilder(21);
            r0 = r0 + 1;
            goto L3
        }

        public StringBuilder a() {
            StringBuilder[] r0 = this.f17944a;
            int r1 = v.b();
            int r2 = this.f17945b;
            this.f17945b = r2 + 1;
            StringBuilder r4 = r0[r1 & r2];
            r4.setLength(0);
            return r4;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ThreadLocal<StringBuilder[]> f17946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ThreadLocal<int[]> f17947b;

        private b() {
            this.f17946a = new ThreadLocal();
            this.f17947b = new ThreadLocal();
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        public StringBuilder a() {
            StringBuilder[] r0 = (StringBuilder[]) ZeusTransformUtils.preCheckCast(this.f17946a.get(), StringBuilder[].class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L8;
            int r1 = v.a();
            StringBuilder[] r3 = new StringBuilder[r1];
            int r4 = 0;
        L5:
            if (r4 >= r1) goto L7;
            r3[r4] = new StringBuilder(21);
            r4 = r4 + 1;
            goto L5
        L7:
            this.f17946a.set(r3);
            this.f17947b.set(new int[1]);
            r0 = r3;
        L8:
            int[] r7 = (int[]) ZeusTransformUtils.preCheckCast(this.f17947b.get(), int[].class, "com.obric.memorydata.plugin");
            int r2 = v.b();
            int r5 = r7[0];
            r7[0] = r5 + 1;
            StringBuilder r8 = r0[r2 & r5];
            r8.setLength(0);
            return r8;
        }
    }

    static {
        f17942a = StatusLogger.getLogger();
        int r0 = a("log4j.unbox.ringbuffer.size");
        f17943b = r0;
        c = r0 - 1;
        d = new ThreadLocal();
        e = new b(null);
    }

    static /* synthetic */ int a() {
        return f17943b;
    }

    private static int a(String r5) {
        String r0 = PropertiesUtil.a().a(r5, String.valueOf(32));
        int r3 = Integer.parseInt(r0.trim());     // Catch: Exception -> L8
        if (r3 >= 32) goto L6;
        f17942a.warn("Invalid {} {}, using minimum size {}.", r5, r0, 32);     // Catch: Exception -> L8
        r3 = 32;
    L6:
        return b(r3);
    L8:
        f17942a.warn("Invalid {} {}, using default size {}.", r5, r0, 32);
        return 32;
    }

    public static StringBuilder a(byte r1) {
        return d().append(r1);
    }

    public static StringBuilder a(int r1) {
        return d().append(r1);
    }

    public static StringBuilder a(long r1) {
        return d().append(r1);
    }

    public static StringBuilder a(short r1) {
        return d().append(r1);
    }

    static /* synthetic */ int b() {
        return c;
    }

    private static int b(int r1) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r1 - 1));
    }

    private static a c() {
        a r0 = (a) ZeusTransformUtils.preCheckCast(d.get(), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        a r1 = new a();
        d.set(r1);
        return r1;
    L6:
        return r0;
    }

    private static StringBuilder d() {
        if (c.f17920b == false) goto L6;
        return c().a();
    L6:
        return e.a();
    }
}
