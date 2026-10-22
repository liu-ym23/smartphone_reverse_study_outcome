package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class RetrySchedulerImpl implements Handler.Callback, AppStatusManager.AppStatusChangeListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile RetrySchedulerImpl f15772h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f15774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f15775c;
    public final boolean d;
    public long e;
    public int f;
    public ConnectivityManager g;

    public static class RetryInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f15783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f15784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f15785c;
        public final int d;
        public final int e;
        public final boolean f;
        public final int[] g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final AtomicInteger f15786h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicInteger f15787i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f15788j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AtomicLong f15789k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f15790l;

        public RetryInfo(int r5, int r10, int r11, int r12, int r13, boolean r14, int[] r15) {
            if (r12 >= 3000) goto L6;
            r12 = 3000;
        L6:
            if (r13 >= 5000) goto L8;
            r13 = 5000;
        L8:
            this.f15783a = r5;
            this.f15784b = r10;
            this.f15785c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
            this.g = r15;
            this.f15786h = new AtomicInteger(r12);
            this.f15789k = new AtomicLong(0);
            this.f15787i = new AtomicInteger(0);
        }

        public final boolean a(long r10, int r11, int r12, boolean r13) {
            if (this.f15790l == true) goto L9;
            if (Logger.b() == false) goto L7;
            Logger.a("RetryScheduler", this.f15783a, null, "canRetry", "IsWaitingRetry is false, return false", false);
        L7:
            return false;
        L9:
            if (this.f15784b >= r11) goto L12;
            return false;
        L12:
            if (this.f15787i.get() < this.f15785c) goto L15;
            return false;
        L15:
            if (this.f15788j == true) goto L17;
        L19:
            if (r13 == false) goto L21;
            return true;
        L21:
            if ((r10 - this.f15789k.get()) >= this.d) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r12 == 2) goto L19;
            return false;
        }
    }

    public RetrySchedulerImpl() {
        this.f15774b = new Handler(Looper.getMainLooper(), this);
        this.f15775c = new SparseArray();
        this.f = 0;
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L12
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L12
        this.f15773a = r5;
        if (DownloadSetting.f.a("use_network_callback", 0) != 1) goto L10;
        ExecutorService r10 = DownloadComponentManager.c();
        ThreadPoolExecutor r11 = (ThreadPoolExecutor) r10;
        r11.execute(new AnonymousClass1(this));
    L10:
        this.d = DownloadHelper.a();
        AppStatusManager.b().a(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static RetryInfo a(int r12) {
        DownloadSetting r5 = DownloadSetting.a(r12, null);
        int r10 = 0;
        int r11 = r5.a("retry_schedule", 0);
        JSONObject r13 = r5.d("retry_schedule_config");
        int r14 = 60;
        if (r13 == null) goto L18;
        int r15 = r13.optInt("max_count", 60);
        int r16 = r13.optInt("interval_sec", 60);
        r14 = r13.optInt("interval_sec_acceleration", 60);
        String r17 = r13.optString("allow_error_code");
        if (TextUtils.isEmpty(r17) == false) goto L22;
    L17:
        int[] r18 = null;
    L16:
        int r19 = r15;
    L20:
        return new RetryInfo(r12, r11, r19, r16 * 1000, r14 * 1000, false, r18);
    L22:
        String[] r20 = r17.split(",");     // Catch: Throwable -> L21
        if (r20.length <= 0) goto L17;
        int[] r21 = new int[r20.length];     // Catch: Throwable -> L21
    L12:
        if (r10 >= r20.length) goto L15;
        r21[r10] = Integer.parseInt(r20[r10]);     // Catch: Throwable -> L21
        r10 = r10 + 1;
        goto L12
    L15:
        r18 = r21;
        goto L16
    L18:
        r18 = null;
        r16 = 60;
        r19 = 60;
        goto L20
    }

    public static RetrySchedulerImpl c() {
        if (f15772h != null) goto L16;
        monitor-enter(RetrySchedulerImpl.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15772h != null) goto L11;
        f15772h = new RetrySchedulerImpl();     // Catch: Throwable -> L9
    L11:
        monitor-exit(RetrySchedulerImpl.class);     // Catch: Throwable -> L9
    L16:
        return f15772h;
    }

    public final RetryInfo b(int r5) {
        RetryInfo r10 = (RetryInfo) this.f15775c.get(r5);
        if (r10 != null) goto L16;
        SparseArray r11 = this.f15775c;
        monitor-enter(r11);
        RetryInfo r12 = (RetryInfo) this.f15775c.get(r5);     // Catch: Throwable -> L9
        if (r12 != null) goto L11;
        r12 = a(r5);     // Catch: Throwable -> L9
    L11:
        this.f15775c.put(r5, r12);     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return r12;
    L9:
        th = move-exception;
        throw th;
    L16:
        return r10;
    }

    public final int d() {
        int r5 = 0;
        if (this.g != null) goto L6;
        this.g = (ConnectivityManager) this.f15773a.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L17
    L6:
        NetworkInfo r10 = this.g.getActiveNetworkInfo();     // Catch: Exception -> L17
        if (r10 == null) goto L16;
        if (r10.isConnected() == false) goto L16;
        r5 = 1;
        if (r10.getType() != 1) goto L16;
        return 2;
    L16:
        return r5;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r10) {
        if (r10.what != 0) goto L10;
        final int r5 = r10.arg1;
        if (r10.arg2 != 1) goto L7;
        final boolean r11 = true;
    L8:
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass2(this, r5, r11));
    L13:
        return true;
    L7:
        r11 = false;
        goto L8
    L10:
        if (Logger.b() == false) goto L12;
        Logger.a("RetryScheduler", r10.what, null, "handleMessage", "DoSchedulerRetry", false);
    L12:
        final int r12 = r10.what;
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass3(this, r12));
        goto L13
    }

    public final void c(int r5) {
        SparseArray r10 = this.f15775c;
        monitor-enter(r10);
        this.f15775c.remove(r5);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public final void b() {
        a(3, false);
    }

    public final void a(int r10, boolean r11) {
        if (this.f > 0) goto L5;
        return;
    L5:
        long r5 = System.currentTimeMillis();
        monitor-enter(this);
        if (r11 == false) goto L26;
    L14:
        this.e = r5;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (Logger.b() == false) goto L20;
        Logger.b("RetryScheduler", "scheduleAllTaskRetry", "level = [" + r10 + "], force = [" + r11 + "]");
    L20:
        if (r11 == false) goto L22;
        this.f15774b.removeMessages(0);
    L22:
        Message r12 = Message.obtain();
        r12.what = 0;
        r12.arg1 = r10;
        r12.arg2 = r11 ? 1 : 0;
        this.f15774b.sendMessageDelayed(r12, 2000);
        return;
    L26:
    L12:
        th = move-exception;
        throw th;
    L9:
        if ((r5 - this.e) >= 10000) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    public static void a(RetrySchedulerImpl r22, int r23, int r24, boolean r25) {
        Context r10 = r22.f15773a;
        if (r10 == null) goto L117;
        SparseArray r5 = r22.f15775c;
        monitor-enter(r5);
        RetryInfo r11 = (RetryInfo) r22.f15775c.get(r23);     // Catch: Throwable -> L11
        if (r11 != null) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L13:
        boolean r12 = true;
        if (r11.f15790l == false) goto L18;
        r11.f15790l = false;     // Catch: Throwable -> L11
        int r13 = r22.f - 1;     // Catch: Throwable -> L11
        r22.f = r13;     // Catch: Throwable -> L11
        if (r13 >= 0) goto L18;
        r22.f = 0;     // Catch: Throwable -> L11
    L18:
        monitor-exit(r5);     // Catch: Throwable -> L11
        if (Logger.b() == false) goto L22;
        Logger.a("RetryScheduler", r23, null, "doSchedulerRetryInSubThread", "RetryCount = " + r11.f15787i + ", mWaitingRetryTasksCount = " + r22.f, false);
    L22:
        DownloadInfo r14 = Downloader.b(r10).b(r23);
        if (r14 != null) goto L26;
        r22.c(r23);
        return;
    L26:
        int r15 = r14.n();
        if (r15 != (-3)) goto L29;
    L107:
        r22.c(r23);
        return;
    L29:
        if (r15 == (-4)) goto L107;
        if (r15 == (-5)) goto L103;
        if (r15 != (-2)) goto L38;
        if (r14.x() == true) goto L103;
    L38:
        if (r15 != (-1)) goto L118;
        if (r24 == 0) goto L42;
        boolean r16 = true;
    L45:
        BaseException r17 = r14.Q0;
        if (r16 == true) goto L48;
    L82:
        r11.f15787i.incrementAndGet();
        if (r16 == true) goto L85;
        if (r25 == false) goto L96;
        r11.f15786h.addAndGet(r11.e);
    L96:
        if (r14.g == false) goto L98;
    L101:
        r22.a(r14, r12, r24);
        return;
    L98:
        if (r14.x() == true) goto L101;
        r12 = false;
        goto L101
    L85:
        if (Logger.b() == false) goto L87;
        Logger.a("RetryScheduler", r23, null, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + r11.f15783a, false);
    L87:
        r11.f15789k.set(System.currentTimeMillis());
        if (r25 == false) goto L90;
        r11.f15786h.addAndGet(r11.e);
    L90:
        r14.a("retry_schedule_count", Integer.valueOf(r11.f15787i.get()));
        if (r14.o() != (-1)) goto L115;
        Downloader.b(r10).e(r14.l());
        return;
    L115:
        return;
    L48:
        if (DownloadUtils.b(r17) == false) goto L82;
        long r18 = DownloadUtils.b(r14.q());     // Catch: BaseException -> L52
    L55:
        if (r18 >= (r14.f15817h0 - r14.i())) goto L81;
        DownloadSetting r19 = DownloadSetting.a(r14.l(), null);
        if (r19.a("space_fill_part_download", 0) == 1) goto L59;
    L80:
        r16 = false;
        goto L82
    L59:
        if (r18 <= 0) goto L79;
        int r20 = r19.a("space_fill_min_keep_mb", 100);
        if (r20 <= 0) goto L81;
        long r21 = r18 - (((long) r20) * 1048576);
        if (Logger.a(r14) == false) goto L74;
        StringBuilder r110 = new StringBuilder("Retry schedule: available = ");
        if (r18 <= 0) goto L67;
        boolean r26 = true;
    L68:
        r110.append(r26);
        r110.append(", minKeep = ");
        r110.append(r20);
        r110.append("MB, canDownload = ");
        if (r21 <= 0) goto L71;
        boolean r27 = true;
    L72:
        r110.append(r27);
        Logger.a("RetryScheduler", r14.l(), r14.P, "canRetryWhenInsufficientSpace", r110.toString(), false);
        goto L74
    L71:
        r27 = false;
        goto L72
    L67:
        r26 = false;
    L74:
        if (r21 > 0) goto L81;
        if (Logger.a(r14) == false) goto L80;
        Logger.a("RetryScheduler", r14.l(), r14.P, "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false", false);
        goto L80
    L79:
        if (r19.a("download_when_space_negative", 0) != 1) goto L80;
    L81:
        r16 = true;
    L52:
        e = move-exception;
        e.printStackTrace();
        r18 = 0;
        goto L55
    L42:
        if (r11.f == false) goto L114;
        r16 = false;
        goto L45
    L114:
        return;
    L118:
        return;
    L103:
        if (r15 != (-2)) goto L105;
        Downloader.b(DownloadComponentManager.b()).a();
    L105:
        DownloadComponentManager.k();
        r22.c(r23);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public final void a() {
        a(4, false);
    }

    public final void a(DownloadInfo r10, boolean r11, int r12) {
        BaseException r5 = r10.Q0;
        if (r5 == null) goto L66;
        RetryInfo r13 = b(r10.l());
        if (r13.f15787i.get() > r13.f15785c) goto L8;
        int r14 = r5.f15601a;
        if (DownloadUtils.b(r5) == false) goto L14;
    L34:
        r13.f15788j = r11;
        SparseArray r15 = this.f15775c;
        monitor-enter(r15);
    L39:
        th = move-exception;
        throw th;
    L37:
        if (r13.f15790l == true) goto L41;
        r13.f15790l = true;     // Catch: Throwable -> L39
        this.f++;     // Catch: Throwable -> L39
    L41:
        monitor-exit(r15);     // Catch: Throwable -> L39
        int r16 = r13.f15786h.get();
        if (Logger.a(r10) == false) goto L46;
        StringBuilder r17 = new StringBuilder("Id = ");
        a.C(r17, r13.f15783a, ", delayTimeMills = ", r16, ", mWaitingRetryTasks = ");
        r17.append(this.f);
        Logger.a("RetryScheduler", r10.l(), r10.P, "tryStartScheduleRetry", r17.toString(), false);
    L46:
        if (r13.f == false) goto L53;
        if (r12 != 0) goto L50;
        r13.f15786h.set(r13.d);
    L50:
        if (this.d == false) goto L64;
        r13.f15789k.set(System.currentTimeMillis());
        r13.f15787i.incrementAndGet();
        r13.f15786h.addAndGet(r13.e);
        return;
    L64:
        return;
    L53:
        if (r11 == true) goto L65;
        this.f15774b.removeMessages(r10.l());
        this.f15774b.sendEmptyMessageDelayed(r10.l(), r16);
        return;
    L65:
        return;
    L14:
        if (DownloadUtils.c(r5) == true) goto L34;
        if (r10.n() == (-2)) goto L20;
        if (r10.n() == (-5)) goto L20;
    L21:
        int[] r18 = r13.g;
        if (r18 != null) goto L24;
        return;
    L24:
        if (r18.length == 0) goto L67;
        int r19 = r18.length;
        int r20 = 0;
    L27:
        if (r20 >= r19) goto L68;
        if (r18[r20] == r14) goto L31;
        r20 = r20 + 1;
        goto L27
    L31:
        if (Logger.a(r10) == false) goto L34;
        Logger.a("RetryScheduler", r10.l(), r10.P, "tryStartScheduleRetry", "Allow error code, id = " + r13.f15783a + ", error code = " + r14, false);
        goto L34
    L68:
        return;
    L67:
        return;
    L20:
        if (r10.x() == true) goto L34;
    L8:
        if (Logger.a(r10) == false) goto L54;
        Logger.a("RetryScheduler", r10.l(), r10.P, "tryStartScheduleRetry", "Id = " + r13.f15783a + ", mRetryCount = " + r13.f15787i + ", maxCount = " + r13.f15785c, false);
        return;
    L54:
        return;
    }
}
