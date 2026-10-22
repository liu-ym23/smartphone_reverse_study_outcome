package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.core.module.BaseDownloadNetworkModule;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import dn.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class PCDNBandwidthSampler implements DeviceBandwidthSampler.ISampleListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f15339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f15341c;
    public long d;
    public final AtomicLong e;
    public final CopyOnWriteArrayList f;
    public final long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f15342h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15343i;

    public interface LowSpeedListener {
    }

    public PCDNBandwidthSampler(int r5, long r10, int r11) {
        this.f15339a = false;
        this.e = new AtomicLong(0);
        this.f = new CopyOnWriteArrayList();
        this.f15343i = r5;
        this.g = r10;
        this.f15342h = r11;
        if (r10 <= 0) goto L7;
        if (r11 <= 0) goto L8;
        DeviceBandwidthSampler.b().f15945a.add(this);
        return;
    L8:
        return;
    }

    public final void a() {
        if (this.f15339a == true) goto L5;
        return;
    L5:
        long r5 = SystemClock.uptimeMillis();
        long r10 = this.e.get();
        long r11 = this.f15341c;
        if (r11 > 0) goto L9;
        this.f15341c = r5;
        this.d = r10;
        return;
    L9:
        long r12 = r10 - this.d;
        long r13 = r5 - r11;
        if (r13 == 0) goto L43;
        long r14 = r12 / r13;
        if (Logger.b() == false) goto L16;
        int r15 = this.f15343i;
        StringBuilder r16 = a.K(r14, "Speed:", " byteDiff:");
        r16.append(r12);
        r16.append(" timeDiff:");
        r16.append(r13);
        Logger.a("PCDNBandwidthSampler", r15, null, "addSampleImpl", r16.toString(), false);
    L16:
        if (r14 >= this.g) goto L42;
        int r17 = this.f15340b + 1;
        this.f15340b = r17;
        if (r17 <= this.f15342h) goto L43;
        Iterator r18 = this.f.iterator();
    L21:
        if (r18.hasNext() == false) goto L41;
        PCDNChunkRunnableModule r19 = (PCDNChunkRunnableModule) ((LowSpeedListener) r18.next());
        if (Logger.a(r19.f15290c) == false) goto L25;
        Logger.a("PCDNChunkRunnableModule", r19.f15290c, "onLowSpeed", "Run");
    L25:
        PCDNRetryPolicy r20 = r19.f15366t;
        if (r20 == null) goto L21;
        if (r20.f15370a >= r20.f15371b) goto L21;
        PCDNChunkUrlPolicy r21 = r19.s;
        if (r21 == null) goto L21;
        if (r21.f15367a.isEmpty() == true) goto L21;
        if (r21.e == 2) goto L21;
        r21.e = 2;
        if (Logger.a(r19.f15290c) == false) goto L40;
        Logger.a("PCDNChunkRunnableModule", r19.f15290c, "onLowSpeed", "Run switch cdn");
    L40:
        BaseDownloadNetworkModule.a(r19.f15358k);
        goto L21
    L41:
        this.f15340b = 0;
        goto L43
    L42:
        this.f15340b = 0;
    L43:
        this.f15341c = r5;
        this.d = r10;
    }
}
