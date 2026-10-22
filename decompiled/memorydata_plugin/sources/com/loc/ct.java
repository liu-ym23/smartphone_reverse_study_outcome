package com.loc;

import android.os.SystemClock;
import android.util.LongSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ct {
    private static volatile ct g;
    private static Object h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LongSparseArray<a> f5407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LongSparseArray<a> f5408b;
    private LongSparseArray<a> c;
    private LongSparseArray<a> d;
    private Object e;
    private Object f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5410b;
        boolean c;

        private a() {
        }

        /* synthetic */ a(byte r1) {
            this();
        }
    }

    static {
        h = new Object();
    }

    private ct() {
        this.e = new Object();
        this.f = new Object();
        this.f5407a = new LongSparseArray();
        this.f5408b = new LongSparseArray();
        this.c = new LongSparseArray();
        this.d = new LongSparseArray();
    }

    public static ct a() {
        if (g != null) goto L15;
        Object r0 = h;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new ct();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    private static short a(LongSparseArray<a> r8, long r9) {
        monitor-enter(r8);
        a r10 = (a) ZeusTransformUtils.preCheckCast(r8.get(r9), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r10 == null) goto L6;
        short r11 = (short) Math.max(1, Math.min(32767, (b() - r10.f5410b) / 1000));     // Catch: Throwable -> L14
        if (r10.c == true) goto L12;
        r11 = (short) (-r11);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return r11;
    L6:
        monitor-exit(r8);     // Catch: Throwable -> L14
        return 0;
    L14:
        th = move-exception;
        throw th;
    }

    private static void a(List<cs> r11, LongSparseArray<a> r12, LongSparseArray<a> r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        long r2 = b();
        int r0 = r12.size();
        byte r4 = 0;
        Iterator r15 = r14.iterator();
        if (r0 != 0) goto L9;
    L5:
        if (r15.hasNext() == false) goto L7;
        cs r16 = (cs) ZeusTransformUtils.preCheckCast(r15.next(), cs.class, "com.obric.memorydata.plugin");
        a r1 = new a(r4);
        r1.f5409a = r16.b();
        r1.f5410b = r2;
        r1.c = false;
        r13.put(r16.a(), r1);
        goto L5
    L7:
        return;
    L9:
        if (r15.hasNext() == false) goto L18;
        cs r3 = (cs) ZeusTransformUtils.preCheckCast(r15.next(), cs.class, "com.obric.memorydata.plugin");
        long r5 = r3.a();
        a r7 = (a) ZeusTransformUtils.preCheckCast(r12.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L15;
        r7 = new a(r4);
    L13:
        r7.f5409a = r3.b();
        r7.f5410b = r2;
        r7.c = true;
    L17:
        r13.put(r5, r7);
        goto L9
    L15:
        if (r7.f5409a == r3.b()) goto L17;
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    final short a(long r1) {
        return a(this.f5407a, r1);
    }

    final void a(List<cs> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.e;
        monitor-enter(r0);
        a(r5, this.f5407a, this.f5408b);     // Catch: Throwable -> L10
        LongSparseArray<a> r6 = this.f5407a;     // Catch: Throwable -> L10
        this.f5407a = this.f5408b;     // Catch: Throwable -> L10
        this.f5408b = r6;     // Catch: Throwable -> L10
        r6.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    final short b(long r1) {
        return a(this.c, r1);
    }

    final void b(List<cs> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Object r0 = this.f;
        monitor-enter(r0);
        a(r5, this.c, this.d);     // Catch: Throwable -> L10
        LongSparseArray<a> r6 = this.c;     // Catch: Throwable -> L10
        this.c = this.d;     // Catch: Throwable -> L10
        this.d = r6;     // Catch: Throwable -> L10
        r6.clear();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
