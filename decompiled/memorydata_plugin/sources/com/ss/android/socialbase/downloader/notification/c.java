package com.ss.android.socialbase.downloader.notification;

import android.content.Context;
import android.content.Intent;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.util.SparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    private static volatile c c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f15603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<Long> f15604b;
    private final SparseArray<a> d;

    static {
    }

    private c() {
        this.f15603a = 1000;
        this.f15604b = new SparseArray();
        this.d = new SparseArray();
    }

    public static c a() {
        if (c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public void a(int r5) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L19;
        if (r5 == 0) goto L21;
        Intent r1 = new Intent(r4, DownloadNotificationService.class);
        r1.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");     // Catch: Throwable -> L13
        r1.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", r5);     // Catch: Throwable -> L13
        if (com.ss.android.socialbase.downloader.g.a.c().b("enable_target_34") <= 0) goto L11;
        d.a().a(r1);     // Catch: Throwable -> L13
        return;
    L11:
        ZeusTransformUtils.startService(r4, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        com.ss.android.socialbase.downloader.e.a.b("DownloadNotificationManagerImpl", r5, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "Error:" + th);
        th.printStackTrace();
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_background_notification") == false) goto L20;
        d.a().a(r1);
        return;
    L20:
        return;
    L21:
        return;
    }

    public a b(int r5) {
        if (r5 != 0) goto L5;
        return null;
    L5:
        SparseArray<a> r0 = this.d;
        monitor-enter(r0);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        this.d.remove(r5);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    }

    public void c(int r1) {
        b(r1);
        if (r1 == 0) goto L6;
        b.a().a(r1);
        return;
    }
}
