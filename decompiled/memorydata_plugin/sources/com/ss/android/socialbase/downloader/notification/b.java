package com.ss.android.socialbase.downloader.notification;

import com.ss.android.socialbase.downloader.service.k;
import com.ss.android.socialbase.downloader.service.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class b implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f15601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private s f15602b;

    static {
    }

    private b() {
        this.f15602b = (s) ZeusTransformUtils.preCheckCast(k.a(s.class), s.class, "com.obric.memorydata.plugin");
    }

    public static b a() {
        if (f15601a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15601a != null) goto L9;
        f15601a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f15601a;
    }

    @Override // com.ss.android.socialbase.downloader.service.s
    public void a(int r1) {
        this.f15602b.a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.s
    public void b(int r1) {
        this.f15602b.b(r1);
    }
}
