package com.ss.android.socialbase.downloader.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.core.module.pcdn.PCDNBandwidthSampler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DeviceBandwidthSampler {
    public static volatile int f = 0;
    public static long g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile DeviceBandwidthSampler f15944h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f15945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetTrafficManager f15946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f15947c;
    public final SamplingHandler d;
    public long e;

    public interface ISampleListener {
    }

    public class SamplingHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeviceBandwidthSampler f15948a;

        public SamplingHandler(DeviceBandwidthSampler r5, Looper r10) {
            this.f15948a = r5;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            if (r5.what == 1) goto L5;
            return;
        L5:
            this.f15948a.a();
            sendEmptyMessageDelayed(1, 1000);
        }
    }

    public DeviceBandwidthSampler() {
        this.f15945a = new CopyOnWriteArrayList();
        this.f15946b = NetTrafficManager.ConnectionClassManagerHolder.f15964a;
        this.f15947c = new AtomicInteger();
        this.d = new SamplingHandler(this, DownloadWatchDog.a());
    }

    public static DeviceBandwidthSampler b() {
        if (f15944h != null) goto L16;
        monitor-enter(DeviceBandwidthSampler.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15944h != null) goto L11;
        f15944h = new DeviceBandwidthSampler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DeviceBandwidthSampler.class);     // Catch: Throwable -> L9
    L16:
        return f15944h;
    }

    public static void c() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L27
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L27
        char[] r10 = DownloadUtils.f16142a;
        if (r5 != null) goto L33;
    L24:
        int r11 = 0;
    L25:
        f = r11;
        return;
    L33:
        ConnectivityManager r12 = DownloadUtils.f16143b;     // Catch: Exception -> L30
        if (r12 != null) goto L12;
        r12 = (ConnectivityManager) r5.getSystemService("connectivity");     // Catch: Exception -> L30
        DownloadUtils.f16143b = r12;     // Catch: Exception -> L30
    L12:
        if (r12 == null) goto L24;
        NetworkInfo r13 = r12.getActiveNetworkInfo();     // Catch: Exception -> L30
        if (r13 == null) goto L24;
        if (r13.isAvailable() == false) goto L24;
        r11 = 1;
        if (1 == r13.getType()) goto L25;
        r11 = 2;
    L27:
        th = move-exception;
        throw th;
    }

    public final void a() {
        System.currentTimeMillis();     // Catch: Exception -> L5
        c();     // Catch: Exception -> L5
        if (f != 1) goto L7;
        long r5 = TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();     // Catch: Exception -> L5
    L8:
        long r10 = g;     // Catch: Exception -> L5
        long r11 = r5 - r10;     // Catch: Exception -> L5
        if (r10 < 0) goto L17;
        monitor-enter(this);     // Catch: Exception -> L5
        long r12 = SystemClock.uptimeMillis();     // Catch: Throwable -> L14
        NetTrafficManager r13 = this.f15946b;     // Catch: Throwable -> L14
        long r14 = r12 - this.e;     // Catch: Throwable -> L14
        r13.f15963a.a(r11, r14);     // Catch: Throwable -> L14
        this.e = r12;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L5
    L17:
        g = r5;     // Catch: Exception -> L5
        Iterator r15 = this.f15945a.iterator();     // Catch: Exception -> L5
    L19:
        if (r15.hasNext() == false) goto L28;
        ((PCDNBandwidthSampler) ((ISampleListener) r15.next())).a();     // Catch: Exception -> L5
        goto L19
    L28:
        return;
    L7:
        r5 = TrafficStats.getMobileRxBytes();     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
