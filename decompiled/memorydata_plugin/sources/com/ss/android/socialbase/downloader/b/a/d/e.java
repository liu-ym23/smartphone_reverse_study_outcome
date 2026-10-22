package com.ss.android.socialbase.downloader.b.a.d;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.h.d f15259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.h f15260b;
    private DownloadInfo c;
    private Map<Integer, a> d;
    private int e;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.b.a.d.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f15262b;
        private boolean c;

        private a(e r1) {
            this.f15261a = r1;
        }

        /* synthetic */ a(e r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ long a(a r2) {
            return r2.f15262b;
        }

        static /* synthetic */ long a(a r0, long r1) {
            r0.f15262b = r1;
            return r1;
        }

        static /* synthetic */ boolean a(a r0, boolean r1) {
            r0.c = r1;
            return r1;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.c;
        }
    }

    public e(com.ss.android.socialbase.downloader.h.d r3, com.ss.android.socialbase.downloader.downloader.h r4, DownloadInfo r5) {
        com.ss.android.socialbase.downloader.h.d r6 = (com.ss.android.socialbase.downloader.h.d) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.h.d.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.h r7 = (com.ss.android.socialbase.downloader.downloader.h) ZeusTransformUtils.wrapperContextForParams(r4, com.ss.android.socialbase.downloader.downloader.h.class, "com.obric.memorydata.plugin");
        this.d = new HashMap();
        this.f15259a = r6;
        this.f15260b = r7;
        this.c = r5;
    }

    public void a(int r9) {
        monitor-enter(this);
        int r0 = this.e;     // Catch: Throwable -> L28
        if (r9 != r0) goto L6;
        this.e = r0 + 1;     // Catch: Throwable -> L28
        long r4 = 0;
    L11:
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(this.e)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r10 == null) goto L18;
        r4 = r4 + a.a(r10);     // Catch: Throwable -> L28
        if (a.b(r10) == false) goto L16;
        this.d.remove(Integer.valueOf(this.e));     // Catch: Throwable -> L28
        this.e++;     // Catch: Throwable -> L28
        goto L11
    L16:
        a.a(r10, 0);     // Catch: Throwable -> L28
        this.d.put(Integer.valueOf(this.e), r10);     // Catch: Throwable -> L28
    L18:
        if (r4 > 0) goto L31;
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L31:
        this.f15259a.a(r4);     // Catch: Throwable -> L23
        this.c.updateRealDownloadTime(true);     // Catch: Throwable -> L23
        this.f15260b.a(this.c);     // Catch: Throwable -> L23
    L25:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L23:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        goto L25
    L6:
        if (this.d.containsKey(Integer.valueOf(r9)) == false) goto L8;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r9)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        a.a(r1, true);     // Catch: Throwable -> L28
        this.d.put(Integer.valueOf(r9), r1);     // Catch: Throwable -> L28
    L8:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    }

    public boolean a(int r4, long r5) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r4 != this.e) goto L8;
        boolean r6 = this.f15259a.a(r5);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return r6;
    L8:
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r4)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r0 != null) goto L11;
        r0 = new a(this, null);     // Catch: Throwable -> L14
    L11:
        a.a(r0, a.a(r0) + r5);     // Catch: Throwable -> L14
        this.d.put(Integer.valueOf(r4), r0);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return false;
    }
}
