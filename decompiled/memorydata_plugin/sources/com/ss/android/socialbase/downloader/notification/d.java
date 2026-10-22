package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    private static volatile d g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f15605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f15606b;
    private long c;
    private volatile e d;
    private final SparseArray<Notification> e;
    private AtomicBoolean f;
    private boolean h;

    public d() {
        this.c = 1000;
        this.e = new SparseArray(2);
        this.f = new AtomicBoolean(false);
        this.h = d();
    }

    public static d a() {
        if (g != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    private void a(NotificationManager r5, int r6) {
        SparseArray<Notification> r0 = this.e;
        monitor-enter(r0);
        Notification r1 = (Notification) ZeusTransformUtils.preCheckCast(this.e.get(r6), Notification.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        this.e.remove(r6);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        b(r5, r6, r1);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void a(final NotificationManager r8, final int r9, Notification r10) {
        SparseArray<Notification> r0 = this.e;
        monitor-enter(r0);
        int r1 = this.e.indexOfKey(r9);     // Catch: Throwable -> L32
        if (r1 >= 0) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L32
        long r2 = this.c - (System.currentTimeMillis() - this.f15605a);
        if (r2 > 0) goto L16;
        r2 = 0;
    L16:
        if (r2 <= 20000) goto L18;
        r2 = 20000;
    L18:
        long r4 = System.currentTimeMillis() + r2;
        this.f15606b = r4;
        this.f15605a = r4;
        if (r2 > 0) goto L22;
        b(r8, r9, r10);
        return;
    L22:
        if (this.d == null) goto L38;
        SparseArray<Notification> r3 = this.e;
        monitor-enter(r3);
        this.e.put(r9, r10);     // Catch: Throwable -> L28
        monitor-exit(r3);     // Catch: Throwable -> L28
        this.d.a(new AnonymousClass2(this, r8, r9), r2);
        return;
    L28:
        th = move-exception;
        throw th;
    L38:
        return;
    L7:
        if (r1 >= this.e.size()) goto L11;
        this.e.setValueAt(r1, r10);     // Catch: Throwable -> L32
        monitor-exit(r0);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(d r0, NotificationManager r1, int r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(d r0, Intent r1) {
        r0.b(r1);
    }

    private void b(NotificationManager r1, int r2) {
        r1.cancel(r2);     // Catch: Throwable -> L4
        return;
    }

    private void b(NotificationManager r5, int r6, Notification r7) {
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (this.f15605a >= r0) goto L5;
        this.f15605a = r0;     // Catch: Throwable -> L7
    L5:
        r5.notify(r6, r7);     // Catch: Throwable -> L7
        return;
    }

    private void b(Intent r8) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        com.ss.android.socialbase.downloader.e.a.b("DownloadNotificationServiceImpl", "handleIntentImpl", "Context is null");
        return;
    L6:
        String r2 = r8.getAction();
        NotificationManager r3 = (NotificationManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("notification"), NotificationManager.class, "com.obric.memorydata.plugin");
        int r4 = r8.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(r2) == false) goto L29;
        Notification r1 = (Notification) ZeusTransformUtils.preCheckCast(r8.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA"), Notification.class, "com.obric.memorydata.plugin");
        int r9 = r8.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
        if (r4 == 0) goto L65;
        if (r1 == null) goto L66;
        if (r3 != null) goto L13;
        return;
    L13:
        if (r9 != 4) goto L25;
        if (Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).isDownloading(r4) == true) goto L17;
        return;
    L17:
        DownloadInfo r10 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getDownloadInfo(r4);
        if (r10 != null) goto L20;
        return;
    L20:
        if (r10.canNotifyProgress() == true) goto L22;
        return;
    L22:
        if ((System.currentTimeMillis() - this.f15606b) <= this.c) goto L70;
        b(r3, r4, r1);
        r10.setLastNotifyProgressTime();
        return;
    L70:
        return;
    L25:
        if (r9 != (-2)) goto L27;
    L27:
        a(r3, r4, r1);
        return;
    L66:
        return;
    L65:
        return;
    L29:
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(r2) == false) goto L62;
        if (r4 == 0) goto L73;
        b(r3, r4);
        return;
    L73:
        return;
    L62:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r2) == false) goto L53;
        if (com.ss.android.socialbase.downloader.utils.c.a(r0, "android.permission.ACCESS_NETWORK_STATE") == false) goto L49;
        ConnectivityManager r7 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L50
        if (r7 != null) goto L39;
        return;
    L39:
        NetworkInfo r11 = r7.getActiveNetworkInfo();     // Catch: Exception -> L50
        if (r11 != null) goto L42;
        return;
    L42:
        if (r11.isConnected() == false) goto L64;
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L50
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.b.f15352a) == true) goto L47;
        r12.add(com.ss.android.socialbase.downloader.constants.b.f15352a);     // Catch: Exception -> L50
    L47:
        r12.add("mime_type_plg");     // Catch: Exception -> L50
        Downloader.getInstance(r0).restartAllFailedDownloadTasks(r12);     // Catch: Exception -> L50
        Downloader.getInstance(r0).restartAllPauseReserveOnWifiDownloadTasks(r12);     // Catch: Exception -> L50
        return;
    L64:
        return;
    L49:
        return;
    L53:
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(r2) == false) goto L55;
    L60:
        Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).pauseAll();     // Catch: Exception -> L50
        return;
    L55:
        if ("android.intent.action.MEDIA_REMOVED".equals(r2) == true) goto L60;
        if ("android.intent.action.MEDIA_BAD_REMOVAL".equals(r2) == true) goto L60;
        if ("android.intent.action.MEDIA_EJECT".equals(r2) == true) goto L60;
        return;
    L50:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean d() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_notification_leak", 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void a(final Intent r4) {
        if (r4 != null) goto L5;
    L13:
        com.ss.android.socialbase.downloader.e.a.b("DownloadNotificationServiceImpl", "handleIntent", "Intent Error:" + r4);
        return;
    L5:
        if (TextUtils.isEmpty(r4.getAction()) == true) goto L13;
        b();
        if (this.d != null) goto L11;
        com.ss.android.socialbase.downloader.e.a.b("DownloadNotificationServiceImpl", "handleIntent", "NotifyThreadHandler is null");
        return;
    L11:
        this.d.a(new AnonymousClass1(this, r4));
    }

    public void b() {
        if (this.h == false) goto L8;
        if (this.f.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L10;
        com.ss.android.socialbase.downloader.e.a.a("DownloadNotificationServiceImpl", CommonConsts.APM_INNER_EVENT_COST_INIT, "Create DownloaderNotifyThread");
    L10:
        this.d = new e("DownloaderNotifyThread");
        this.d.a();
        long r0 = com.ss.android.socialbase.downloader.g.a.c().a("notification_time_window", 1000);
        this.c = r0;
        if (r0 >= 0) goto L13;
    L14:
        this.c = 1000;
        return;
    L13:
        if (r0 > 1200) goto L14;
    }

    public void c() {
        if (com.ss.android.socialbase.downloader.g.a.c().b("enable_target_34") <= 0) goto L6;
        return;
    L6:
        if (this.d != null) goto L12;
        return;
    L12:
        this.d.b();     // Catch: Throwable -> L11
    L9:
        this.d = null;
    }
}
