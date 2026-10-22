package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class e extends com.ss.android.socialbase.downloader.downloader.a {
    private static final String d = "e";

    static {
    }

    public e() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void a() {
        c();
        ExecutorService r0 = com.ss.android.socialbase.downloader.downloader.b.i();
        if (r0 == null) goto L6;
        r0.execute(new AnonymousClass1(this));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(Intent r1, int r2, int r3) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(d, "onStartCommand", "Run");
    L5:
        e();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void c() {
        this.f15398b = true;
        this.c.set(false);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(d, "onStartCommandOnMainThread", "Run");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
        ZeusTransformUtils.startService(r5, new Intent(r5, DownloadService.class), "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
        ZeusTransformUtils.stopService(r5, new Intent(r5, DownloadService.class), "com.obric.memorydata.plugin");
        this.f15398b = false;
    }
}
