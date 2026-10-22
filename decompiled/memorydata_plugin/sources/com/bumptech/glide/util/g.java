package com.bumptech.glide.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<T, a<Y>> f982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f983b;
    private long c;
    private long d;

    static final class a<Y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Y f984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f985b;

        a(Y r1, int r2) {
            this.f984a = r1;
            this.f985b = r2;
        }
    }

    public g(long r5) {
        this.f982a = new LinkedHashMap(100, 0.75f, true);
        this.f983b = r5;
        this.c = r5;
    }

    private void c() {
        a(this.c);
    }

    public int a(Y r1) {
        return 1;
    }

    public void a() {
        a(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void a(long r8) {
        monitor-enter(this);
    L12:
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.d <= r8) goto L7;
        Iterator<Map.Entry<T, a<Y>>> r0 = this.f982a.entrySet().iterator();     // Catch: Throwable -> L9
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        this.d -= (long) r2.f985b;     // Catch: Throwable -> L9
        Object r3 = r1.getKey();     // Catch: Throwable -> L9
        r0.remove();     // Catch: Throwable -> L9
        a(r3, r2.f984a);     // Catch: Throwable -> L9
        goto L12
    L7:
        monitor-exit(this);
    }

    public void a(T r1, Y r2) {
    }

    public synchronized long b() {
        monitor-enter(this);
        long r0 = this.c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Y b(T r3) {
        monitor-enter(this);
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f982a.get(r3), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r4 == null) goto L7;
        Y r5 = r4.f984a;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r5;
    L7:
        r5 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized Y b(T r8, Y r9) {
        monitor-enter(this);
        int r0 = a(r9);     // Catch: Throwable -> L24
        long r1 = r0;
        Y r4 = null;
        if (r1 < this.c) goto L8;
        a(r8, r9);     // Catch: Throwable -> L24
        monitor-exit(this);
        return null;
    L8:
        if (r9 == null) goto L10;
        this.d += r1;     // Catch: Throwable -> L24
    L10:
        Map<T, a<Y>> r2 = this.f982a;     // Catch: Throwable -> L24
        if (r9 != null) goto L13;
        a<Y> r3 = null;
    L14:
        a r5 = (a) ZeusTransformUtils.preCheckCast(r2.put(r8, r3), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r5 == null) goto L19;
        this.d -= (long) r5.f985b;     // Catch: Throwable -> L24
        if (r5.f984a.equals(r9) == true) goto L19;
        a(r8, r5.f984a);     // Catch: Throwable -> L24
    L19:
        c();     // Catch: Throwable -> L24
        if (r5 == null) goto L22;
        r4 = r5.f984a;     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return r4;
    L13:
        r3 = new a(r9, r0);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized Y c(T r5) {
        monitor-enter(this);
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.f982a.remove(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        if (r6 == null) goto L6;
        this.d -= (long) r6.f985b;     // Catch: Throwable -> L11
        Y r7 = r6.f984a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L6:
        monitor-exit(this);
        return null;
    L11:
        th = move-exception;
        throw th;
    }
}
