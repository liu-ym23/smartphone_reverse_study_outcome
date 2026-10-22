package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15638b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final double h;
    private final int i;
    private final int j;
    private SparseArray k;
    private volatile int l;
    private volatile int m;

    public b() {
        this.f15637a = "globalThrottle";
        this.f15638b = 2097152;
        this.c = 512000;
        this.d = 51200;
        this.e = 0;
        this.f = -1;
        this.g = -2;
        this.h = 0.5d;
        this.i = 2000;
        this.j = 204800;
        this.k = new SparseArray();
        this.l = 0;
        this.m = 0;
    }

    private void a() {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "stopThrottle", "stop throttle!");
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.k.size()) goto L12;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.k.valueAt(r0), DownloadTask.class, "com.obric.memorydata.plugin");
        r3.getDownloadInfo().setThrottleNetSpeed(0);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "stopThrottle", "TTNet api set speed=0");
    L11:
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setThrottleNetSpeed(r3.getDownloadId(), 0);
        r0 = r0 + 1;
        goto L7
    }

    static /* synthetic */ void a(b r0, int r1, int r2) {
        r0.b(r1, r2);
    }

    static /* synthetic */ void a(b r0, DownloadTask r1) {
        r0.e(r1);
    }

    private int b() {
        int r1 = 0;
        if (this.k.size() != 0) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L7:
        if (r1 >= this.k.size()) goto L14;
        if (((DownloadTask) ZeusTransformUtils.preCheckCast(this.k.valueAt(r1), DownloadTask.class, "com.obric.memorydata.plugin")).getTaskPriority() > this.m) goto L12;
        r0 = r0 + 1;
    L12:
        r1 = r1 + 1;
        goto L7
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "getThrottleTaskSize", "throttle task size=" + r0);
    L16:
        return r0;
    }

    private void b(int r5, int r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "setGlobalThrottleInternal", "global throttle speed=" + r5 + ",priority=" + r6);
    L5:
        this.l = r5;
        if (r5 != (-1)) goto L8;
        this.l = e();
    L8:
        this.m = r6;
        SparseArray r7 = this.k;
        monitor-enter(r7);
        if (r5 > 0) goto L17;
        if (r5 == (-1)) goto L17;
        if (r5 != (-2)) goto L16;
        f();     // Catch: Throwable -> L20
    L18:
        monitor-exit(r7);     // Catch: Throwable -> L20
        return;
    L16:
        this.l = 0;     // Catch: Throwable -> L20
        a();     // Catch: Throwable -> L20
    L17:
        c();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void b(b r0, DownloadTask r1) {
        r0.f(r1);
    }

    private void c() {
        int r0 = b();
        int r2 = 0;
        if (this.l <= 0) goto L7;
        if (r0 <= 0) goto L7;
        int r1 = this.l / r0;
    L11:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "throttleSpeedReset", "mThrottleSpeed=" + this.l + ",taskCount=" + r0);
    L14:
        if (r2 >= this.k.size()) goto L27;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.k.valueAt(r2), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r3.getTaskPriority() > this.m) goto L26;
        int r4 = 51200;
        if (r1 == 0) goto L21;
        if (r1 >= 51200) goto L21;
    L23:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L25;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "throttleSpeedReset", "TTNet api set speed=" + r4);
    L25:
        long r8 = r4;
        r3.getDownloadInfo().setThrottleNetSpeed(r8);
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setThrottleNetSpeed(r3.getDownloadId(), r8);
    L21:
        r4 = r1;
    L26:
        r2 = r2 + 1;
        goto L14
    L27:
        return;
    L7:
        if (this.l != 0) goto L9;
        r1 = 0;
        goto L11
    L9:
        r1 = 2097152;
        goto L11
    }

    private void c(DownloadTask r6) {
        SparseArray r0 = this.k;
        monitor-enter(r0);
        this.k.remove(r6.getDownloadId());     // Catch: Throwable -> L14
        if (com.ss.android.socialbase.downloader.e.a.a(r6.getDownloadInfo()) == false) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", r6.getDownloadInfo(), "deleteTaskAndThrottleSpeedReset", "taskCount=" + this.k.size() + ",mThrottleSpeed=" + this.l);     // Catch: Throwable -> L14
    L8:
        if (this.l != 0) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        c();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private int d() {
        int r2 = Math.max(com.ss.android.socialbase.downloader.utils.c.a(com.ss.android.socialbase.downloader.network.j.a().c()), com.ss.android.socialbase.downloader.utils.c.a(com.ss.android.socialbase.downloader.network.j.a().b()));
        if (r2 >= 0) goto L6;
        return 0;
    L6:
        return r2;
    }

    private void d(DownloadTask r5) {
        if (com.ss.android.socialbase.downloader.e.a.a(r5.getDownloadInfo()) == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", r5.getDownloadInfo(), "addTaskAndThrottleSpeedReset", "add to map!");
    L6:
        if (r5.getTaskPriority() <= this.m) goto L8;
        return;
    L8:
        SparseArray r0 = this.k;
        monitor-enter(r0);
        this.k.put(r5.getDownloadId(), r5);     // Catch: Throwable -> L17
        if (this.l > 0) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L14:
        c();     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private int e() {
        SparseArray r0 = this.k;
        monitor-enter(r0);
        int r1 = b();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        int r6 = d();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "getGlobalThrottleSpeed", "bandwidth=" + r6 + ",taskRunningTime=" + com.ss.android.socialbase.downloader.network.j.a().d() + ",taskCount=" + r1);
    L9:
        if (r1 > 0) goto L11;
    L16:
        double r2 = 2097152.0d;
    L18:
        if (r2 >= 512000.0d) goto L21;
        r2 = 512000.0d;
    L21:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L24;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", "getGlobalThrottleSpeed", "throttleSpeed=" + r2);
    L24:
        return (int) r2;
    L11:
        if (com.ss.android.socialbase.downloader.network.j.a().d() < 2000) goto L13;
    L15:
        r2 = ((double) r6) * 0.5d;
        goto L18
    L13:
        if (r6 >= 204800) goto L15;
    L25:
        th = move-exception;
        throw th;
    }

    private void e(DownloadTask r1) {
        d(r1);
    }

    private void f() {
        int r0 = 0;
    L4:
        if (r0 >= this.k.size()) goto L9;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.k.valueAt(r0), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r1.getTaskPriority() > this.m) goto L8;
        long r5 = -1;
        r1.getDownloadInfo().setThrottleNetSpeed(r5);
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).setThrottleNetSpeed(r1.getDownloadId(), r5);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private void f(DownloadTask r5) {
        if (com.ss.android.socialbase.downloader.e.a.a(r5.getDownloadInfo()) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", r5.getDownloadInfo(), "endInternal", "task end!");
    L5:
        c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.m
    public void a(final int r4, final int r5) {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("global_throttle_enable", 0) > 0) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.utils.g.a() == false) goto L8;
        com.ss.android.socialbase.downloader.downloader.b.n().submit(new AnonymousClass3(this, r4, r5));
        return;
    L8:
        b(r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.m
    public void a(final DownloadTask r5) {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("global_throttle_enable", 0) > 0) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.e.a.a(r5.getDownloadInfo()) == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("globalThrottle", r5.getDownloadInfo(), CommonConsts.APM_INNER_EVENT_COST_START, "start throttle!");
    L9:
        if (com.ss.android.socialbase.downloader.utils.g.a() == false) goto L11;
        com.ss.android.socialbase.downloader.downloader.b.n().submit(new AnonymousClass1(this, r5));
        return;
    L11:
        e(r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.m
    public void b(final DownloadTask r4) {
        if (com.ss.android.socialbase.downloader.g.a.b().optInt("global_throttle_enable", 0) > 0) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.b.n().submit(new AnonymousClass2(this, r4));
    }
}
