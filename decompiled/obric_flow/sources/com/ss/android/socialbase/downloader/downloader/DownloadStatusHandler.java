package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.lynx.tasm.base.h;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadStatusHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f15549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadInfo f15551c;
    public final IDownloadCache d;
    public final Handler e;
    public final DownloadTask f;
    public final ConcurrentHashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ConcurrentHashMap f15552h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap f15553i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f15554j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f15555k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f15556l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f15557m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f15558n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f15559o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f15560p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f15561q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f15562r;

    public DownloadStatusHandler(DownloadTask r5, Handler r10) {
        boolean r11 = false;
        this.f15554j = false;
        this.f15555k = 0;
        this.f15556l = new AtomicLong();
        this.f15557m = false;
        this.f = r5;
        DownloadInfo r12 = r5.f15878a;
        this.f15551c = r12;
        this.g = r5.a(ListenerType.f15280a);
        this.f15553i = r5.a(ListenerType.f15282c);
        this.f15552h = r5.a(ListenerType.f15281b);
        this.e = r10;
        IDownloadCache r13 = DownloadComponentManager.h();
        this.d = r13;
        boolean r14 = r12.b1;
        this.f15561q = r14;
        if (r14 == true) goto L5;
    L7:
        DownloadSetting r15 = DownloadSetting.f;
        if (r15.a("fix_anr_progress_handle_msg", 0) <= 0) goto L10;
        boolean r16 = true;
    L11:
        this.f15549a = r16;
        if (r15.a("fix_same_task_monitor_report", 0) <= 0) goto L14;
        boolean r17 = true;
    L15:
        this.f15550b = r17;
        if (r15.a("remove_useless_monitor_report", 0) <= 0) goto L18;
        r11 = true;
    L18:
        this.f15562r = r11;
        return;
    L14:
        r17 = false;
        goto L15
    L10:
        r16 = false;
        goto L11
    L5:
        if ((r13 instanceof DefaultDownloadCache) == false) goto L7;
        this.d = ((DefaultDownloadCache) r13).f15674a;
        goto L7
    }

    public final void a(long r10, String r11, String r12) {
        DownloadInfo r5 = this.f15551c;
        r5.f15817h0 = r10;
        r5.F = r11;
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L22:
        this.d.a(this.f15551c.l(), r10, r11, r12);     // Catch: Exception -> L9
    L11:
        a(3, null);
        DownloadInfo r13 = this.f15551c;
        int r14 = r13.f15832q;
        if (r14 > 0) goto L14;
        r14 = 100;
    L14:
        long r15 = r10 / ((long) (r14 + 1));
        if (r15 > 0) goto L17;
        r15 = 1048576;
    L17:
        this.f15559o = r15;
        int r16 = r13.f15834r;
        if (r16 >= 1000) goto L20;
        r16 = 1000;
    L20:
        this.f15558n = r16;
        this.f15554j = true;
        RetryScheduler.c().f15771a.a();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.f15551c.f15808b) == false) goto L22;
        this.f15551c.f15808b = r12;
        goto L22
    }

    public final void b() {
        DownloadTimingInfo r5 = this.f.s;
        r5.g = System.currentTimeMillis();
        if (this.f15551c.c() == true) goto L5;
        this.d.k(this.f15551c.l());
        a(1, null);
    L5:
        long r10 = this.f15560p;
        if (r10 > 0) goto L16;
    L13:
        DownloadTimingInfo r11 = this.f.s;
        r11.f15905h = System.currentTimeMillis();
        return;
    L16:
        DownloadInfo r12 = this.f15551c;     // Catch: Throwable -> L15
        if (r12.b1 == true) goto L13;
        long r13 = System.currentTimeMillis() - r10;     // Catch: Throwable -> L15
        if (r13 <= 0) goto L13;
        r12.d();     // Catch: Throwable -> L15
        r12.a("dbjson_key_download_prepare_time", Long.valueOf(r12.T0.optLong("dbjson_key_download_prepare_time") + r13));     // Catch: Throwable -> L15
        goto L13
    }

    public final void c() {
        this.f15551c.a(-2);
        this.d.a(this.f15551c.l(), this.f15551c.i());     // Catch: SQLiteException -> L5
    L7:
        a(-2, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void a(BaseException r10) {
        DownloadInfo r5 = this.f15551c;
        r5.f15822k0 = false;
        Logger.a("DownloadStatusHandler", r5.l(), "handleError", "Exception:" + r10);
        if (Logger.b() == false) goto L6;
        Logger.a("DownloadStatusHandler", this.f15551c.l(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
    L6:
        if (r10.getCause() != null) goto L8;
    L46:
        this.d.c(this.f15551c.l(), this.f15551c.i());     // Catch: SQLiteException -> L15
    L20:
        if (DownloadSetting.a(this.f15551c.l(), null).a("download_failed_check_net", 1) == 1) goto L22;
    L36:
        this.f15551c.Q0 = r10;
        if ((r10 instanceof DownloadPauseReserveWifiException) == false) goto L39;
        int r11 = -2;
    L40:
        a(r11, r10);
        if (DownloadSetting.a(this.f15551c.l(), null).a("retry_schedule", 0) <= 0) goto L51;
        RetryScheduler r12 = RetryScheduler.c();
        r12.f15771a.a(this.f15551c);
        return;
    L51:
        return;
    L39:
        r11 = -1;
        goto L40
    L22:
        if (DownloadUtils.c(r10) == false) goto L36;
        monitor-enter(DownloadComponentManager.class);
        Context r13 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L33
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L33
        if (r13 == null) goto L36;
        if (DownloadUtils.b(r13) == true) goto L36;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optBoolean("disable_check_no_network") == true) goto L36;
        r10 = new BaseException(1049, r10.f15602b);
    L33:
        th = move-exception;
        throw th;
    L15:
        this.d.d(this.f15551c.l());     // Catch: SQLiteException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L8:
        if ((r10.getCause() instanceof SQLiteFullException) == false) goto L46;
        this.d.d(this.f15551c.l());     // Catch: SQLiteException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L20
    }

    public final void a() {
        CopyOnWriteArrayList r5 = this.f.f15890q;
        if (r5.isEmpty() == true) goto L19;
        DownloadInfo r10 = this.f15551c;
        a(11, null);
        this.d.a(r10);
        Iterator r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        IDownloadCompleteHandler r12 = (IDownloadCompleteHandler) r11.next();
    L14:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        throw new BaseException(1071, DownloadUtils.a(th));
    L9:
        if (r12.k(r10) == false) goto L6;
        r12.e(r10);     // Catch: Throwable -> L12 BaseException -> L14
        this.d.a(r10);     // Catch: Throwable -> L12 BaseException -> L14
    L27:
        return;
    }

    public final void a(int r5, BaseException r10) {
        if (this.f15561q == false) goto L10;
        if (r5 != 1) goto L6;
        return;
    L6:
        if (r5 != 6) goto L8;
        return;
    L8:
        if (r5 != 2) goto L10;
        return;
    L10:
        a(r5, r10, true);
    }

    public final void a(final int r17, final BaseException r18, boolean r19) {
        int r5 = this.f15551c.o();
        if (r5 != (-3)) goto L10;
        if (r17 != 4) goto L10;
        if (Logger.a(this.f15551c) == false) goto L101;
        Logger.a("DownloadStatusHandler", this.f15551c, "onStatusChanged", h.b(r5, r17, "Status = ", ", monitorStatus = "));
        return;
    L101:
        return;
    L10:
        if (r17 == 4) goto L41;
        if (r17 == (-3)) goto L20;
        if (r17 == (-1)) goto L20;
        if (r17 == (-4)) goto L20;
        if (r17 == (-2)) goto L20;
        if (r17 == 5) goto L20;
        if (r17 == 8) goto L20;
    L34:
        if (this.f15551c.O0 == false) goto L38;
        if (this.f15550b == false) goto L41;
    L38:
        if (this.f15562r == false) goto L40;
        if (r17 == 6) goto L41;
    L40:
        DownloadMonitorHelper.a(this.f, r18, r17);
    L20:
        this.f15551c.a(false);
        if (r17 == (-3)) goto L24;
        if (r17 == (-1)) goto L24;
        if (r17 != (-4)) goto L34;
    L24:
        DownloadInfo r10 = this.f15551c;
        if (r10.f15835r0 == 0) goto L34;
        long r11 = SystemClock.uptimeMillis() - r10.f15835r0;
        if (r10.f15825m0 >= 0) goto L31;
        r10.f15825m0 = 0;
    L31:
        if (r11 <= 0) goto L34;
        r10.f15825m0 = r11;
    L41:
        if (r17 != 6) goto L44;
        this.f15551c.a(2);
    L47:
        if (r5 == (-3)) goto L49;
        if (r5 == (-1)) goto L49;
    L55:
        DownloadListenerUtils.a(r17, this.f15552h, true, this.f15551c, r18, ListenerType.f15281b, this.f);
        if (r17 == (-4)) goto L103;
        if (r19 == true) goto L60;
    L97:
        AbsDownloadEngine r12 = DownloadComponentManager.j();
        if (r12 == null) goto L102;
        r12.a(this.f15551c.l(), this.f.f15894v, r17);
        return;
    L102:
        return;
    L60:
        if (this.e == null) goto L97;
        ConcurrentHashMap r13 = this.g;
        if (r13 != null) goto L64;
    L65:
        ConcurrentHashMap r14 = this.f15553i;
        if (r14 == null) goto L97;
        if (r14.size() <= 0) goto L97;
        if (this.f15551c.b() == false) goto L72;
    L74:
        if (this.f15549a == false) goto L95;
        AbsDownloadEngine r15 = DownloadComponentManager.j();
        final DownloadTask r16 = r15.a(this.f15551c.l(), this.f.f15894v);
        if (r16 != null) goto L79;
        Logger.a("DownloadStatusHandler", this.f15551c.l(), "notifyDownloadTaskStatus", "DownloadTask is null");
        return;
    L79:
        final DownloadInfo r20 = r16.f15878a;
        if (r20 != null) goto L83;
        Logger.a("DownloadStatusHandler", this.f15551c.l(), "notifyDownloadTaskStatus", "DownloadInfo is null");
        return;
    L83:
        final ConcurrentHashMap r21 = r16.a(ListenerType.f15280a);
        final ConcurrentHashMap r22 = r16.a(ListenerType.f15282c);
        DownloadInfo r23 = r16.f15878a;
        if (r23 == null) goto L86;
        boolean r24 = r23.b();
    L87:
        if (r24 == false) goto L89;
    L92:
        boolean r110 = true;
    L93:
        final boolean r25 = r110;
        this.e.post(new AnonymousClass1(r17, r21, r20, r18, r16, r22, r25));
        r15.a(this.f15551c.l(), this.f.f15894v, r17);
        return;
    L89:
        if (r20.r() == true) goto L92;
        r110 = false;
        goto L93
    L86:
        r24 = false;
        goto L87
    L95:
        this.e.obtainMessage(r17, this.f15551c.l(), this.f.f15894v, r18).sendToTarget();
        return;
    L72:
        if (this.f15551c.r() == false) goto L97;
    L64:
        if (r13.size() > 0) goto L74;
    L103:
        return;
    L49:
        DownloadInfo r26 = this.f15551c;
        if (r26.H != AsyncHandleStatus.d) goto L53;
        r26.H = AsyncHandleStatus.e;
    L53:
        if (r26.f15848y0 != ByteInvalidRetryStatus.f15268c) goto L55;
        r26.f15848y0 = ByteInvalidRetryStatus.d;
        goto L55
    L44:
        if (r17 != (-6)) goto L46;
        this.f15551c.a(-3);
        goto L47
    L46:
        this.f15551c.a(r17);
        goto L47
    }
}
