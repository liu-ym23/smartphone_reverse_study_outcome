package com.ss.android.socialbase.downloader.network;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class NetTrafficManagerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExponentialGeometricAverage f15965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f15966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f15967c;
    public AtomicReference d;
    public final CopyOnWriteArrayList e;
    public int f;

    public static class ConnectionClassManagerHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final NetTrafficManagerImpl f15968a = null;

        static {
            f15968a = new NetTrafficManagerImpl();
        }
    }

    public NetTrafficManagerImpl() {
        this.f15965a = new ExponentialGeometricAverage(0.05d);
        this.f15966b = false;
        this.f15967c = new AtomicReference(NetworkQuality.e);
        this.e = new CopyOnWriteArrayList();
    }

    public static NetTrafficManagerImpl b() {
        return ConnectionClassManagerHolder.f15968a;
    }

    public final synchronized NetworkQuality a() {
        monitor-enter(this);
        ExponentialGeometricAverage r5 = this.f15965a;     // Catch: Throwable -> L8
        if (r5 != null) goto L40;
        NetworkQuality r10 = NetworkQuality.e;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L40:
        double r11 = r5.f15962c;     // Catch: Throwable -> L15
        if (r11 >= 0.0d) goto L18;
        NetworkQuality r12 = NetworkQuality.e;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r12;
    L18:
        if (r11 >= 150.0d) goto L23;
        NetworkQuality r13 = NetworkQuality.f15969a;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r13;
    L23:
        if (r11 >= 550.0d) goto L28;
        NetworkQuality r14 = NetworkQuality.f15970b;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r14;
    L28:
        if (r11 >= 2000.0d) goto L32;
        NetworkQuality r15 = NetworkQuality.f15971c;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r15;
    L32:
        NetworkQuality r16 = NetworkQuality.d;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r16;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L8
        return NetworkQuality.e;
    L8:
        th = move-exception;
        throw th;
    }
}
