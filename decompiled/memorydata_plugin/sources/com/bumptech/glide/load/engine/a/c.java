package com.bumptech.glide.load.engine.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f717b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Lock f718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f719b;

        a() {
            this.f718a = new ReentrantLock();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<a> f720a;

        b() {
            this.f720a = new ArrayDeque();
        }

        a a() {
            Queue<a> r0 = this.f720a;
            monitor-enter(r0);
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.f720a.poll(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            if (r3 == null) goto L8;
            return r3;
        L8:
            return new a();
        L9:
            th = move-exception;
            throw th;
        }

        void a(a r4) {
            Queue<a> r0 = this.f720a;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.f720a.size() >= 10) goto L7;
            this.f720a.offer(r4);     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
        }
    }

    c() {
        this.f716a = new HashMap();
        this.f717b = new b();
    }

    void a(String r4) {
        monitor-enter(this);
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f716a.get(r4), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = this.f717b.a();     // Catch: Throwable -> L10
        this.f716a.put(r4, r0);     // Catch: Throwable -> L10
    L6:
        r0.f719b++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        r0.f718a.lock();
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void b(String r6) {
        monitor-enter(this);
        a r0 = (a) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.f716a.get(r6)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r0.f719b < 1) goto L16;
        r0.f719b--;     // Catch: Throwable -> L17
        if (r0.f719b != 0) goto L12;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f716a.remove(r6), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r1.equals(r0) == false) goto L11;
        this.f717b.a(r1);     // Catch: Throwable -> L17
        goto L12
    L11:
        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + r0 + ", but actually removed: " + r1 + ", safeKey: " + r6);     // Catch: Throwable -> L17
    L12:
        monitor-exit(this);     // Catch: Throwable -> L17
        r0.f718a.unlock();
        return;
    L16:
        throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + r6 + ", interestedThreads: " + r0.f719b);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }
}
