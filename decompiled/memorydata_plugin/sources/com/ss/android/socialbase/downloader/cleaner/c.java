package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.utils.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Semaphore f15347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15348b;
    private b c;
    private Map<Integer, List<Integer>> d;

    public c(b r3) {
        this.f15347a = new Semaphore(0);
        this.f15348b = false;
        this.c = r3;
        this.d = r3.c();
    }

    static /* synthetic */ void a(c r0) {
        r0.b();
    }

    static /* synthetic */ boolean a(c r0, boolean r1) {
        r0.f15348b = r1;
        return r1;
    }

    private void b() {
        if (this.f15348b == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, List<Integer>>> r3 = this.d.entrySet().iterator();
    L42:
    L33:
        th = move-exception;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L38;
        th.printStackTrace();
    L38:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L40;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startClean", "clean completed!");
    L40:
        this.f15347a.release();
        return;
    L7:
        if (r3.hasNext() == false) goto L38;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        int r5 = ((Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L33
        Iterator r6 = ((List) ZeusTransformUtils.preCheckCast(r4.getValue(), List.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L33
    L10:
        if (r6.hasNext() == false) goto L31;
        if (this.f15348b == true) goto L14;
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L33
        if (this.c.b(r7) == false) goto L21;
        g.c(this.c.c(r7), this.c.e(r7), this.c.d(r7));     // Catch: Throwable -> L33
        if (this.c.f(r7) == true) goto L28;
        com.ss.android.socialbase.downloader.downloader.b.C().d(r7);     // Catch: Throwable -> L33
    L28:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L30;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startClean", "clean cache downloadId=" + r7);     // Catch: Throwable -> L33
    L30:
        r6.remove();     // Catch: Throwable -> L33
        this.c.a(r7);     // Catch: Throwable -> L33
        goto L10
    L21:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L23;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startClean", "dwg888Find in visit history,can't do clean,downloadId=" + r7);     // Catch: Throwable -> L33
    L23:
        r6.remove();     // Catch: Throwable -> L33
        goto L10
    L14:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startClean", "stop cleaning");     // Catch: Throwable -> L33
    L16:
        this.f15348b = false;     // Catch: Throwable -> L33
        return;
    L31:
        r3.remove();     // Catch: Throwable -> L33
        this.c.g(r5);     // Catch: Throwable -> L33
        goto L42
    }

    public void a() {
        if (this.c.b() == true) goto L12;
        if (this.d.isEmpty() == true) goto L12;
        long r3 = System.currentTimeMillis();
        Detecter r0 = new Detecter(new AnonymousClass1(this));
        r0.a();
        b();
        this.f15347a.acquire();
        r0.b();
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - r3));
        return;
    L15:
        return;
    L12:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        com.ss.android.socialbase.downloader.e.a.a("CleanerImpl", "startSync", "CleanCacheKeyMaps Empty");
        return;
    }
}
