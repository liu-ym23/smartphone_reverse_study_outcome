package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl;
import com.ss.android.socialbase.downloader.network.NetworkQuality;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
    public DownloadNetTrafficManagerService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
    public final void a(long r10, long r11) {
        NetTrafficManagerImpl r12 = NetTrafficManagerImpl.b();
        monitor-enter(r12);
        double r13 = ((r10 * 1.0d) / r11) * 8.0d;
        if (r11 != 0) goto L7;
    L60:
        monitor-exit(r12);
        return;
    L7:
        if (r13 < 3.0d) goto L60;
        r12.f15965a.a(r13);     // Catch: Throwable -> L62
        NetworkQuality r14 = r12.a();     // Catch: Throwable -> L62
        if (r12.f15966b == false) goto L56;
        r12.f++;     // Catch: Throwable -> L62
        if (r14 == r12.d.get()) goto L15;
        r12.f15966b = false;     // Catch: Throwable -> L62
        r12.f = 1;     // Catch: Throwable -> L62
    L15:
        if (r12.f < 5.0d) goto L60;
        if (r12.f15965a == null) goto L60;
        int r15 = ((NetworkQuality) r12.f15967c.get()).ordinal();     // Catch: Throwable -> L53
        double r5 = 150.0d;
        if (r15 != 0) goto L22;
        double r16 = 0.0d;
    L32:
        double r17 = r12.f15965a.f15962c;     // Catch: Throwable -> L53
        goto L60
    L34:
        if (r17 <= r5) goto L39;
        if (r17 <= (r5 * 1.25d)) goto L60;
    L40:
        r12.f15966b = false;     // Catch: Throwable -> L62
        r12.f = 1;     // Catch: Throwable -> L62
        r12.f15967c.set(r12.d.get());     // Catch: Throwable -> L62
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L62
        goto L60
    L42:
        if (r12.e.size() <= 0) goto L60;
        if (r12.e.get(0) != null) goto L51;
        NetworkQuality r18 = (NetworkQuality) r12.f15967c.get();     // Catch: Throwable -> L48
        throw null;     // Catch: Throwable -> L48
    L51:
        throw new ClassCastException();     // Catch: Throwable -> L48
    L39:
        if (r17 >= (r16 * 0.8d)) goto L60;
    L22:
        if (r15 == 1) goto L30;
        r5 = 2000.0d;
        if (r15 != 2) goto L26;
        r16 = 550.0d;
        goto L32
    L26:
        if (r15 != 3) goto L40;
        r16 = 2000.0d;
        r5 = 3.4028234663852886E38d;
        goto L32
    L30:
        r16 = 150.0d;
        r5 = 550.0d;
    L53:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L62
        goto L60
    L56:
        if (r12.f15967c.get() == r14) goto L60;
        r12.f15966b = true;     // Catch: Throwable -> L62
        r12.d = new AtomicReference(r14);     // Catch: Throwable -> L62
        monitor-exit(r12);     // Catch: Throwable -> L62
    }
}
