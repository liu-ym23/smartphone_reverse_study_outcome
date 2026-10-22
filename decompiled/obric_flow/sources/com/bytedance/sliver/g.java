package com.bytedance.sliver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f7519c;
    public volatile long d;
    public final int e;
    public final Sliver.Mode f;
    public volatile boolean g;

    public g(int r5, int r10, int r11, Sliver.Mode r12) {
        this.d = 0;
        this.g = false;
        this.f7517a = r5;
        this.f7518b = r10;
        this.f7519c = new HashSet();
        this.e = r11;
        this.f = r12;
    }

    public final synchronized void a() {
        monitor-enter(this);
        monitor-enter(this);     // Catch: Throwable -> L27
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L6:
        if (this.d == 0) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L27
    L13:
        if (this.d != 0) goto L17;
        monitor-exit(this);
        return;
    L17:
        if (this.g == true) goto L20;
        monitor-exit(this);
        return;
    L20:
        ArrayList r5 = new ArrayList(this.f7519c.size());     // Catch: Throwable -> L27
        ArrayList r10 = new ArrayList(this.f7519c.size());     // Catch: Throwable -> L27
        Iterator r11 = this.f7519c.iterator();     // Catch: Throwable -> L27
    L22:
        if (r11.hasNext() == false) goto L29;
        Thread r12 = (Thread) r11.next();     // Catch: Throwable -> L27
        long r13 = Sliver.getThreadPeer(r12);     // Catch: Throwable -> L27
        if (r13 == 0) goto L22;
        r5.add(Long.valueOf(r13));     // Catch: Throwable -> L27
        r10.add(r12);     // Catch: Throwable -> L27
        goto L22
    L29:
        long[] r14 = new long[r5.size()];     // Catch: Throwable -> L27
        int r15 = 0;
    L31:
        if (r15 >= r5.size()) goto L33;
        r14[r15] = ((Long) r5.get(r15)).longValue();     // Catch: Throwable -> L27
        r15 = r15 + 1;     // Catch: Throwable -> L27
        goto L31
    L33:
        SliverAllThreadSupport.access$500(this.d, (Thread[]) r10.toArray(new Thread[0]), r14);     // Catch: Throwable -> L27
        this.g = false;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L9:
        this.d = SliverAllThreadSupport.access$600(this.f7518b, this.e, Sliver.mode2Int(this.f), this.f7517a);     // Catch: Throwable -> L36
        monitor-exit(this);     // Catch: Throwable -> L27
        goto L13
    L27:
        th = move-exception;
        throw th;
    }
}
