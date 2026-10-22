package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.Process;
import com.ss.android.socialbase.downloader.core.DownloadSingleResponseHandler;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import java.util.ArrayList;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNChunkRunnableModule extends BaseDownloadNetworkModule implements Runnable, PCDNBandwidthSampler.LowSpeedListener {
    public Future g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f15355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PCDNChunk f15356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DownloadSingleResponseHandler f15357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IDownloadHttpConnection f15358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PCDNChunkProgressManager f15359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PCDNChunkAllocater f15360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PCDNBandwidthSampler f15361n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PCDNStats f15362o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PCDNChunkUrlPolicy f15363p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f15364q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DownloadPCDNSegmentModule f15365r;
    public PCDNChunkUrlPolicy s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PCDNRetryPolicy f15366t;

    public PCDNChunkRunnableModule(PCDNChunkProgressManager r5, PCDNChunkAllocater r10, PCDNBandwidthSampler r11, PCDNStats r12, PCDNChunkUrlPolicy r13, int r14, DownloadPCDNSegmentModule r15) {
        this.f15355h = false;
        this.f15359l = r5;
        this.f15360m = r10;
        this.f15361n = r11;
        r11.f.add(this);
        this.f15362o = r12;
        this.f15363p = r13;
        this.f15364q = r14;
        this.f15365r = r15;
    }

    @Override // com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule, com.ss.android.socialbase.downloader.thread.IDownloadRunnableCallback
    public final boolean a(long r5) {
        if (this.s.a() == false) goto L5;
        this.f15361n.e.addAndGet(r5);
    L5:
        PCDNChunkProgressManager r10 = this.f15359l;
        int r11 = this.f15356i.f15344a;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (r11 != r10.e) goto L14;
        boolean r12 = r10.f15350a.a(r5);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r12;
    L14:
        PCDNChunkProgressManager.ChunkCacheItem r13 = (PCDNChunkProgressManager.ChunkCacheItem) r10.d.get(Integer.valueOf(r11));     // Catch: Throwable -> L12
        if (r13 != null) goto L17;
        r13 = new PCDNChunkProgressManager.ChunkCacheItem();     // Catch: Throwable -> L12
    L17:
        r13.f15353a += r5;     // Catch: Throwable -> L12
        r10.d.put(Integer.valueOf(r11), r13);     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void cancel() {
        this.f15355h = true;
        DownloadSingleResponseHandler r5 = this.f15357j;
        if (r5 == null) goto L5;
        r5.a();
    L11:
        this.g.cancel(true);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        BaseDownloadNetworkModule.a(this.f15358k);
        goto L11
    }

    public final void d() {
        PCDNChunkUrlPolicy r5 = this.f15363p;
        if (r5 != null) goto L5;
    L7:
        DownloadInfo r10 = this.f15290c;
        this.s = new PCDNChunkUrlPolicy(r10.f15845x, r10.f15847y);
    L8:
        this.f15366t = new PCDNRetryPolicy(this.f15364q);
    L9:
        String r15 = this.s.b();
        boolean r14 = this.s.a();
        if (Logger.a(this.f15290c) == false) goto L12;
        Logger.a("PCDNChunkRunnableModule", this.f15290c, "doDownload", "Before Url:" + r15 + " isPcdn:" + r14 + " index:" + this.f15356i.f15344a);
    L12:
        PCDNStats r11 = this.f15362o;
        monitor-enter(r11);
        PCDNStats.UrlStats r12 = (PCDNStats.UrlStats) r11.g.get(r15);     // Catch: Throwable -> L17
        if (r12 != null) goto L20;
        r12 = new PCDNStats.UrlStats();     // Catch: Throwable -> L17
        r12.f15379a = r14;     // Catch: Throwable -> L17
    L20:
        if (r12.f15382h > 0) goto L22;
        r12.f15382h = System.currentTimeMillis();     // Catch: Throwable -> L17
    L22:
        r12.g++;     // Catch: Throwable -> L17
        r11.g.put(r15, r12);     // Catch: Throwable -> L17
        if (r14 == false) goto L29;
        if (r11.f15375h > 0) goto L27;
        r11.f15375h = System.currentTimeMillis();     // Catch: Throwable -> L17
    L27:
        r11.f15378k++;     // Catch: Throwable -> L17
    L32:
        monitor-exit(r11);     // Catch: Throwable -> L17
        PCDNChunk r13 = this.f15356i;
        ArrayList r16 = a(r13.f15345b, r13.f15346c, true);
        PCDNChunk r17 = this.f15356i;
        long r18 = r17.f15346c;
        long r19 = r17.f15345b;
        long r20 = 1 + (r18 - r19);
        IDownloadHttpConnection r21 = a(r15, r16, r19);     // Catch: Throwable -> L36
        this.f15358k = r21;     // Catch: Throwable -> L36
        DownloadSingleResponseHandler r22 = new DownloadSingleResponseHandler(this.f, r21, this.f15356i.f15345b, r20, this);     // Catch: Throwable -> L36
        this.f15357j = r22;     // Catch: Throwable -> L36
        r22.b();     // Catch: Throwable -> L36
        this.f15359l.a(this.f15356i.f15344a);     // Catch: Throwable -> L36
        th = null;
    L40:
        PCDNStats r23 = this.f15362o;
        long r110 = this.f15356i.f15345b;
        if (b() == false) goto L43;
    L46:
        boolean r24 = true;
    L47:
        r23.a(r15, r110, r14, r24, this.f15358k, this.f15357j, th);
        DownloadSingleResponseHandler r25 = this.f15357j;
        if (r25 == null) goto L51;
        this.f15356i.f15345b = r25.f;
    L51:
        if (Logger.a(this.f15290c) == false) goto L53;
        Logger.a("PCDNChunkRunnableModule", this.f15290c, "doDownload", "After Url:" + r15 + " isPcdn:" + r14 + " index:" + this.f15356i.f15344a);
    L53:
        if (th == null) goto L81;
        PCDNRetryPolicy r26 = this.f15366t;
        int r27 = r26.f15370a;
        if (r27 >= r26.f15371b) goto L58;
        r26.f15370a = r27 + 1;
        if (b() == true) goto L82;
        if (this.f15355h == false) goto L9;
        return;
    L82:
        return;
    L58:
        if (b() == false) goto L60;
        return;
    L60:
        if (this.f15355h == true) goto L80;
        DownloadPCDNSegmentModule r28 = this.f15365r;
        r28.s = th;
        r28.cancel();
        return;
    L80:
        return;
    L81:
        return;
    L43:
        if (this.f15355h == true) goto L46;
        r24 = false;
    L36:
        th = th;
        th.printStackTrace();
        this.s.c();
        if (Logger.a(this.f15290c) == false) goto L40;
        Logger.a("PCDNChunkRunnableModule", this.f15290c, "doDownload", "OnError index:" + this.f15356i.f15344a);
        goto L40
    L29:
        if (r11.f15376i > 0) goto L31;
        r11.f15376i = System.currentTimeMillis();     // Catch: Throwable -> L17
    L31:
        r11.f15377j++;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r5.a() == true) goto L7;
        PCDNChunkUrlPolicy r29 = this.f15363p;
        PCDNChunkUrlPolicy r30 = new PCDNChunkUrlPolicy(r29.f15368b, r29.f15367a);
        r30.e = r29.e;
        r30.d = r29.d;
        r30.f15369c = r29.f15369c;
        this.s = r30;
        goto L8
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        if (Logger.a(this.f15290c) == false) goto L5;
        Logger.a("PCDNChunkRunnableModule", this.f15290c, "run", "Run");
    L5:
        this.f15361n.f15339a = true;
    L7:
        if (b() == true) goto L33;
        if (this.f15355h == true) goto L33;
        PCDNChunkAllocater r5 = this.f15360m;
        monitor-enter(r5);
        long r10 = r5.d;     // Catch: Throwable -> L17
        DownloadInfo r11 = r5.f15347a;     // Catch: Throwable -> L17
        long r12 = r11.f15817h0;     // Catch: Throwable -> L17
        if (r10 < r12) goto L19;
        monitor-exit(r5);     // Catch: Throwable -> L17
        PCDNChunk r13 = null;
    L26:
        this.f15356i = r13;
        if (r13 == null) goto L42;
        d();
        goto L7
    L42:
        return;
    L19:
        PCDNChunk r14 = new PCDNChunk();     // Catch: Throwable -> L17
        r14.f15344a = r5.f15349c;     // Catch: Throwable -> L17
        r14.f15345b = r10;     // Catch: Throwable -> L17
        long r15 = (r10 + r5.f15348b) - 1;     // Catch: Throwable -> L17
        if (r15 >= r12) goto L22;
        r14.f15346c = r15;     // Catch: Throwable -> L17
    L23:
        r5.d += r5.f15348b;     // Catch: Throwable -> L17
        r5.f15349c++;     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        r13 = r14;
        goto L26
    L22:
        r11.d();     // Catch: Throwable -> L17
        r14.f15346c = (r11.T0.optLong("start_offset") + r5.f15347a.f15817h0) - 1;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L33:
        if (Logger.a(this.f15290c) == false) goto L41;
        Logger.a("PCDNChunkRunnableModule", this.f15290c, "run", "Run End");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a() {
        this.f15355h = true;
        DownloadSingleResponseHandler r5 = this.f15357j;
        if (r5 == null) goto L5;
        r5.c();
    L11:
        this.g.cancel(true);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        BaseDownloadNetworkModule.a(this.f15358k);
        goto L11
    }
}
