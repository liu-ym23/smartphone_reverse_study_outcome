package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class SqlDownloadCacheService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15396a = "SqlDownloadCacheService";

    static {
    }

    public SqlDownloadCacheService() {
    }

    public static void a(Context r3, ServiceConnection r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        Intent r0 = new Intent(r5, SqlDownloadCacheService.class);     // Catch: Throwable -> L9
        if (r6 == null) goto L7;
        ZeusTransformUtils.bindService(r5, r0, r6, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L7:
        ZeusTransformUtils.startService(r5, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b(f15396a, "startServiceAndBind", "Exception:" + th.toString());
        return;
    }

    public IBinder onBind(Intent r2) {
        h r1 = b.C();
        if (ZeusTransformUtils.instanceOf(r1, com.ss.android.socialbase.downloader.impls.b.class) == false) goto L6;
        s r3 = ((com.ss.android.socialbase.downloader.impls.b) ZeusTransformUtils.preCheckCast(r1, com.ss.android.socialbase.downloader.impls.b.class, "com.obric.memorydata.plugin")).f();
    L10:
        if (ZeusTransformUtils.instanceOf(r3, IBinder.class) == false) goto L14;
        return (IBinder) ZeusTransformUtils.preCheckCast(r3, IBinder.class, "com.obric.memorydata.plugin");
    L14:
        return new Binder();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, s.class) == false) goto L8;
        r3 = (s) ZeusTransformUtils.preCheckCast(r1, s.class, "com.obric.memorydata.plugin");
        goto L10
    L8:
        r3 = null;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public int onStartCommand(Intent r1, int r2, int r3) {
        return 2;
    }
}
