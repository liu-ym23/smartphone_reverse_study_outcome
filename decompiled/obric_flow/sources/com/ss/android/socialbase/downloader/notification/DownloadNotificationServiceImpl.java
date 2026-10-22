package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.ThreadWithHandler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadNotificationServiceImpl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile DownloadNotificationServiceImpl f15997h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f15998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f15999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16000c;
    public volatile ThreadWithHandler d;
    public final SparseArray e;
    public final AtomicBoolean f;
    public final boolean g;

    public DownloadNotificationServiceImpl() {
        this.f16000c = 1000;
        this.e = new SparseArray(2);
        boolean r5 = false;
        this.f = new AtomicBoolean(false);
        if (DownloadSetting.f.a("fix_notification_leak", 1) <= 0) goto L5;
        r5 = true;
    L5:
        this.g = r5;
    }

    public static DownloadNotificationServiceImpl a() {
        if (f15997h != null) goto L16;
        monitor-enter(DownloadNotificationServiceImpl.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15997h != null) goto L11;
        f15997h = new DownloadNotificationServiceImpl();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadNotificationServiceImpl.class);     // Catch: Throwable -> L9
    L16:
        return f15997h;
    }

    public final void b() {
        if (this.g == false) goto L8;
        if (this.f.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (Logger.b() == false) goto L10;
        Logger.b("DownloadNotificationServiceImpl", "init", "Create DownloaderNotifyThread");
    L10:
        this.d = new ThreadWithHandler();
        this.d.f16120c.start();
        long r5 = DownloadSetting.f.a("notification_time_window", 1000);
        this.f16000c = r5;
        if (r5 >= 0) goto L13;
    L16:
        this.f16000c = 1000;
        return;
    L13:
        if (r5 > 1200) goto L16;
    }

    public final void a(final Intent r5) {
        if (r5 != null) goto L5;
    L13:
        Logger.c("DownloadNotificationServiceImpl", "handleIntent", "Intent Error:" + r5);
        return;
    L5:
        if (TextUtils.isEmpty(r5.getAction()) == true) goto L13;
        b();
        if (this.d != null) goto L11;
        Logger.c("DownloadNotificationServiceImpl", "handleIntent", "NotifyThreadHandler is null");
        return;
    L11:
        this.d.a(new AnonymousClass1(this, r5), 0);
    }

    public final void b(NotificationManager r5, int r10, Notification r11) {
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (this.f15998a >= r12) goto L5;
        this.f15998a = r12;     // Catch: Throwable -> L7
    L5:
        r5.notify(r10, r11);     // Catch: Throwable -> L7
        return;
    }

    public final void a(final NotificationManager r10, final int r11, Notification r12) {
        SparseArray r5 = this.e;
        monitor-enter(r5);
        int r13 = this.e.indexOfKey(r11);     // Catch: Throwable -> L11
        if (r13 >= 0) goto L7;
    L13:
        monitor-exit(r5);     // Catch: Throwable -> L11
        long r14 = this.f16000c - (System.currentTimeMillis() - this.f15998a);
        if (r14 > 0) goto L18;
        r14 = 0;
    L18:
        if (r14 <= 20000) goto L20;
        r14 = 20000;
    L20:
        long r15 = System.currentTimeMillis() + r14;
        this.f15999b = r15;
        this.f15998a = r15;
        if (r14 > 0) goto L25;
        b(r10, r11, r12);
        return;
    L25:
        if (this.d == null) goto L35;
        SparseArray r16 = this.e;
        monitor-enter(r16);
        this.e.put(r11, r12);     // Catch: Throwable -> L32
        monitor-exit(r16);     // Catch: Throwable -> L32
        this.d.a(new AnonymousClass2(this, r10, r11), r14);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        return;
    L7:
        if (r13 >= this.e.size()) goto L13;
        this.e.setValueAt(r13, r12);     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
