package com.ss.android.socialbase.downloader.network;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static volatile c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache<String, b> f15585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f15586b;
    private final Handler c;
    private final Looper d;

    public interface a {
        void a(String r1, List<InetAddress> r2);
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<InetAddress> f15591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f15592b;

        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }
    }

    private c() {
        this.f15585a = new LruCache(4, 16, false);
        HandlerThread r0 = new HandlerThread("Network-Handler");
        r0.start();
        Looper r1 = r0.getLooper();
        this.d = r1;
        this.f15586b = new Handler(r1);
        this.c = new Handler(com.ss.android.socialbase.downloader.h.c.a());
    }

    public static c a() {
        if (e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    static /* synthetic */ void a(c r2, String r3, a r4, long r5) {
        r2.b(r3, (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin"), r5);
    }

    private void a(String r5, List<InetAddress> r6) {
        List<InetAddress> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        LruCache<String, b> r0 = this.f15585a;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f15585a.get(r5), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new b(null);     // Catch: Throwable -> L10
        this.f15585a.put(r5, r1);     // Catch: Throwable -> L10
    L7:
        r1.f15591a = r7;     // Catch: Throwable -> L10
        r1.f15592b = System.currentTimeMillis();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void b(final String r8, a r9, long r10) {
        final a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        String r0 = Uri.parse(r8).getHost();     // Catch: Throwable -> L43
        LruCache<String, b> r1 = this.f15585a;     // Catch: Throwable -> L43
        monitor-enter(r1);     // Catch: Throwable -> L43
        final b r2 = (b) ZeusTransformUtils.preCheckCast(this.f15585a.get(r0), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        if (r2 != null) goto L9;
    L13:
        Runnable r3 = new AnonymousClass2(this, r11, r8, r2);     // Catch: Throwable -> L43
        this.c.postDelayed(r3, r10);     // Catch: Throwable -> L43
        List<InetAddress> r12 = null;
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_host_dns", 1) != 1) goto L21;
        f r13 = com.ss.android.socialbase.downloader.downloader.b.z();     // Catch: Throwable -> L43
        if (r13 == null) goto L21;
        r12 = r13.a(r0);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L43
    L21:
        if (r12 == null) goto L48;
        if (r12.isEmpty() == true) goto L48;
    L29:
        if (r12 != null) goto L31;
    L34:
        if (r2 == null) goto L36;
        r12 = r2.f15591a;     // Catch: Throwable -> L43
    L36:
        this.c.removeCallbacks(r3);     // Catch: Throwable -> L43
        if (r11 == null) goto L54;
        r11.a(r8, r12);     // Catch: Throwable -> L43
        return;
    L54:
        return;
    L31:
        if (r12.isEmpty() == true) goto L34;
        a(r0, r12);     // Catch: Throwable -> L43
    L48:
        r12 = com.ss.android.socialbase.downloader.downloader.b.A().a(r0);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L43
        goto L29
    L9:
        if ((System.currentTimeMillis() - r2.f15592b) >= ((com.ss.android.socialbase.downloader.g.a.c().a("dns_expire_min", 10) * 60) * 1000)) goto L13;
        if (r11 == null) goto L53;
        r11.a(r8, r2.f15591a);     // Catch: Throwable -> L43
        return;
    L53:
        return;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    }

    public void a(final String r8, a r9, final long r10) {
        final a r3 = (a) ZeusTransformUtils.wrapperContextForParams(r9, a.class, "com.obric.memorydata.plugin");
        this.f15586b.post(new AnonymousClass1(this, r8, r3, r10));
    }
}
