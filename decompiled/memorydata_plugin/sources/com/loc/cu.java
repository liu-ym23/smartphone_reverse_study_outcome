package com.loc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class cu {

    public static class a implements cs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f5411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5412b;
        private int c;

        a(int r1, int r2, int r3) {
            this.f5411a = r1;
            this.f5412b = r2;
            this.c = r3;
        }

        @Override // com.loc.cs
        public final long a() {
            return cu.a(this.f5411a, this.f5412b);
        }

        @Override // com.loc.cs
        public final int b() {
            return this.c;
        }
    }

    public static class b implements cs {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f5413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f5414b;

        b(long r1, int r3) {
            this.f5413a = r1;
            this.f5414b = r3;
        }

        @Override // com.loc.cs
        public final long a() {
            return this.f5413a;
        }

        @Override // com.loc.cs
        public final int b() {
            return this.f5414b;
        }
    }

    public static long a(int r4, int r5) {
        long r0 = (((long) r4) & 4294967295L) << 32;
        return (((long) r5) & 4294967295L) | r0;
    }

    public static synchronized short a(long r2) {
        monitor-enter(cu.class);
        short r3 = ct.a().a(r2);     // Catch: Throwable -> L7
        monitor-exit(cu.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(List<dv> r6) {
        monitor-enter(cu.class);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r7 != null) goto L7;
    L28:
        monitor-exit(cu.class);
        return;
    L7:
        if (r7.isEmpty() == true) goto L28;
        ArrayList r1 = new ArrayList(r7.size());     // Catch: Throwable -> L30
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L30
    L11:
        if (r8.hasNext() == false) goto L25;
        dv r2 = (dv) ZeusTransformUtils.preCheckCast(r8.next(), dv.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (ZeusTransformUtils.instanceOf(r2, dx.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, dy.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r2, dz.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r2, dw.class) == false) goto L11;
        dw r3 = (dw) ZeusTransformUtils.preCheckCast(r2, dw.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        a r4 = new a(r3.k, r3.l, r3.c);     // Catch: Throwable -> L30
    L15:
        r1.add(r4);     // Catch: Throwable -> L30
        goto L11
    L21:
        dz r5 = (dz) ZeusTransformUtils.preCheckCast(r2, dz.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        r4 = new a(r5.j, r5.k, r5.c);     // Catch: Throwable -> L30
        goto L15
    L18:
        dy r9 = (dy) ZeusTransformUtils.preCheckCast(r2, dy.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        r4 = new a(r9.j, r9.k, r9.c);     // Catch: Throwable -> L30
        goto L15
    L14:
        dx r10 = (dx) ZeusTransformUtils.preCheckCast(r2, dx.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        r4 = new a(r10.j, r10.k, r10.c);     // Catch: Throwable -> L30
        goto L15
    L25:
        ct.a().a(r1);     // Catch: Throwable -> L30
        monitor-exit(cu.class);
        return;
    L30:
        th = move-exception;
        throw th;
    }

    public static synchronized short b(long r2) {
        monitor-enter(cu.class);
        short r3 = ct.a().b(r2);     // Catch: Throwable -> L7
        monitor-exit(cu.class);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(List<db> r6) {
        monitor-enter(cu.class);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r7 != null) goto L7;
    L16:
        monitor-exit(cu.class);
        return;
    L7:
        if (r7.isEmpty() == true) goto L16;
        ArrayList r1 = new ArrayList(r7.size());     // Catch: Throwable -> L18
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L18
    L11:
        if (r8.hasNext() == false) goto L13;
        db r2 = (db) ZeusTransformUtils.preCheckCast(r8.next(), db.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        r1.add(new b(r2.f5428a, r2.c));     // Catch: Throwable -> L18
        goto L11
    L13:
        ct.a().b(r1);     // Catch: Throwable -> L18
        monitor-exit(cu.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }
}
