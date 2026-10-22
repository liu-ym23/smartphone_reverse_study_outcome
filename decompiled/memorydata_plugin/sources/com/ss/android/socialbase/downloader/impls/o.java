package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class o implements Handler.Callback, com.ss.android.socialbase.downloader.a.a.InterfaceC0809a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile o f15545a;
    private static n.a i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15546b;
    private final Handler c;
    private final SparseArray<a> d;
    private final boolean e;
    private long f;
    private int g;
    private ConnectivityManager h;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f15553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f15554b;
        final int c;
        final int d;
        final int e;
        final boolean f;
        final int[] g;
        private AtomicInteger h;
        private AtomicInteger i;
        private boolean j;
        private AtomicLong k;
        private boolean l;

        a(int r2, int r3, int r4, int r5, int r6, boolean r7, int[] r8) {
            if (r5 >= 3000) goto L6;
            r5 = 3000;
        L6:
            if (r6 >= 5000) goto L8;
            r6 = 5000;
        L8:
            this.f15553a = r2;
            this.f15554b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = new AtomicInteger(r5);
            this.k = new AtomicLong(0);
            this.i = new AtomicInteger(0);
        }

        static /* synthetic */ AtomicInteger a(a r0) {
            return r0.i;
        }

        static /* synthetic */ boolean a(a r0, boolean r1) {
            r0.j = r1;
            return r1;
        }

        static /* synthetic */ boolean b(a r0) {
            return r0.l;
        }

        static /* synthetic */ boolean b(a r0, boolean r1) {
            r0.l = r1;
            return r1;
        }

        void a() {
            this.h.addAndGet(this.e);
        }

        void a(long r1) {
            this.k.set(r1);
        }

        boolean a(long r3, int r5, int r6, boolean r7) {
            if (this.l == true) goto L9;
            if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L7;
            com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", this.f15553a, "canRetry", "IsWaitingRetry is false, return false");
        L7:
            return false;
        L9:
            if (this.f15554b >= r5) goto L12;
            return false;
        L12:
            if (this.i.get() < this.c) goto L15;
            return false;
        L15:
            if (this.j == true) goto L17;
        L19:
            if (r7 == false) goto L21;
            return true;
        L21:
            if ((r3 - this.k.get()) >= this.d) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r6 == 2) goto L19;
            return false;
        }

        void b() {
            this.i.incrementAndGet();
        }

        void c() {
            this.h.set(this.d);
        }

        int d() {
            return this.h.get();
        }
    }

    private o() {
        this.c = new Handler(Looper.getMainLooper(), this);
        this.d = new SparseArray();
        this.g = 0;
        this.f15546b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        f();
        this.e = com.ss.android.socialbase.downloader.utils.c.c();
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    static /* synthetic */ Context a(o r0) {
        return r0.f15546b;
    }

    static /* synthetic */ ConnectivityManager a(o r0, ConnectivityManager r1) {
        r0.h = r1;
        return r1;
    }

    private void a(int r10, int r11, boolean r12) {
        Context r0 = this.f15546b;
        if (r0 != null) goto L5;
        return;
    L5:
        SparseArray<a> r1 = this.d;
        monitor-enter(r1);
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r10), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L82
        if (r2 != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L82
        return;
    L11:
        boolean r4 = true;
        if (a.b(r2) == false) goto L16;
        a.b(r2, false);     // Catch: Throwable -> L82
        int r3 = this.g - 1;     // Catch: Throwable -> L82
        this.g = r3;     // Catch: Throwable -> L82
        if (r3 >= 0) goto L16;
        this.g = 0;     // Catch: Throwable -> L82
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L82
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L20;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r10, "doSchedulerRetryInSubThread", "RetryCount = " + a.a(r2) + ", mWaitingRetryTasksCount = " + this.g);
    L20:
        DownloadInfo r5 = Downloader.getInstance(r0).getDownloadInfo(r10);
        if (r5 != null) goto L24;
        c(r10);
        return;
    L24:
        int r6 = r5.getRealStatus();
        if (r6 != (-3)) goto L27;
    L80:
        c(r10);
        return;
    L27:
        if (r6 == (-4)) goto L80;
        if (r6 == (-5)) goto L71;
        if (r6 != (-2)) goto L36;
        if (r5.isPauseReserveOnWifi() == true) goto L71;
    L36:
        if (r6 == (-1)) goto L38;
        return;
    L38:
        if (r11 == 0) goto L40;
        boolean r7 = true;
    L44:
        BaseException r8 = r5.getFailedException();
        if (r7 == true) goto L47;
    L49:
        r2.b();
        if (r7 == true) goto L52;
        if (r12 == false) goto L63;
        r2.a();
    L63:
        if (r5.isOnlyWifi() == false) goto L65;
    L68:
        a(r5, r4, r11);
        return;
    L65:
        if (r5.isPauseReserveOnWifi() == true) goto L68;
        r4 = false;
        goto L68
    L52:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L54;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r10, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + r2.f15553a);
    L54:
        r2.a(System.currentTimeMillis());
        if (r12 == false) goto L57;
        r2.a();
    L57:
        r5.setRetryScheduleCount(a.a(r2).get());
        if (r5.getStatus() != (-1)) goto L86;
        Downloader.getInstance(r0).restart(r5.getId());
        return;
    L86:
        return;
    L47:
        if (com.ss.android.socialbase.downloader.utils.g.c(r8) == false) goto L49;
        r7 = a(r5, r8);
        goto L49
    L40:
        if (r2.f == false) goto L42;
        r7 = false;
        goto L44
    L42:
        return;
    L71:
        if (r6 != (-2)) goto L75;
        q r13 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getReserveWifiStatusListener();
        if (r13 == null) goto L75;
        r13.a(r5, 4, 3);
    L75:
        com.ss.android.socialbase.downloader.downloader.j r14 = com.ss.android.socialbase.downloader.downloader.b.B();
        if (r14 == null) goto L78;
        r14.a(Collections.singletonList(r5), 3);
    L78:
        c(r10);
        return;
    L82:
        th = move-exception;
        throw th;
    }

    private void a(int r7, boolean r8) {
        if (this.g > 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        monitor-enter(this);
        if (r8 == false) goto L25;
    L12:
        this.f = r0;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L18;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", "scheduleAllTaskRetry", "level = [" + r7 + "], force = [" + r8 + "]");
    L18:
        if (r8 == false) goto L20;
        this.c.removeMessages(0);
    L20:
        Message r1 = Message.obtain();
        r1.what = 0;
        r1.arg1 = r7;
        r1.arg2 = r8 ? 1 : 0;
        this.c.sendMessageDelayed(r1, 2000);
        return;
    L25:
    L22:
        th = move-exception;
        throw th;
    L9:
        if ((r0 - this.f) >= 10000) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L22
    }

    static /* synthetic */ void a(o r0, int r1, int r2, boolean r3) {
        r0.a(r1, r2, r3);
    }

    static /* synthetic */ void a(o r0, int r1, boolean r2) {
        r0.a(r1, r2);
    }

    private void a(DownloadInfo r10, boolean r11, int r12) {
        BaseException r0 = r10.getFailedException();
        if (r0 != null) goto L5;
        return;
    L5:
        a r1 = b(r10.getId());
        if (a.a(r1).get() > r1.c) goto L8;
        int r2 = r0.getErrorCode();
        if (com.ss.android.socialbase.downloader.utils.g.c(r0) == false) goto L14;
    L25:
        a.a(r1, r11);
        SparseArray<a> r3 = this.d;
        monitor-enter(r3);
    L48:
        th = move-exception;
        throw th;
    L28:
        if (a.b(r1) == true) goto L30;
        a.b(r1, true);     // Catch: Throwable -> L48
        this.g++;     // Catch: Throwable -> L48
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L48
        int r4 = r1.d();
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L35;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r10, "tryStartScheduleRetry", "Id = " + r1.f15553a + ", delayTimeMills = " + r4 + ", mWaitingRetryTasks = " + this.g);
    L35:
        if (r1.f == false) goto L44;
        if (r12 != 0) goto L38;
        r1.c();
    L38:
        n.a r5 = i;
        if (r5 == null) goto L42;
        r5.a(r10, r4, r11, r12);
    L42:
        if (this.e == false) goto L54;
        r1.a(System.currentTimeMillis());
        r1.b();
        r1.a();
        return;
    L54:
        return;
    L44:
        if (r11 == false) goto L46;
        return;
    L46:
        this.c.removeMessages(r10.getId());
        this.c.sendEmptyMessageDelayed(r10.getId(), r4);
        return;
    L14:
        if (com.ss.android.socialbase.downloader.utils.g.b(r0) == true) goto L25;
        if (r10.statusInPause() == false) goto L20;
        if (r10.isPauseReserveOnWifi() == true) goto L25;
    L20:
        if (a(r1, r2) == true) goto L23;
        return;
    L23:
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L25;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r10, "tryStartScheduleRetry", "Allow error code, id = " + r1.f15553a + ", error code = " + r2);
        goto L25
    L8:
        if (com.ss.android.socialbase.downloader.e.a.a(r10) == false) goto L53;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r10, "tryStartScheduleRetry", "Id = " + r1.f15553a + ", mRetryCount = " + a.a(r1) + ", maxCount = " + r1.c);
        return;
    }

    private boolean a(a r4, int r5) {
        int[] r3 = r4.g;
        if (r3 != null) goto L5;
    L14:
        return false;
    L5:
        if (r3.length == 0) goto L14;
        int r0 = r3.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L14;
        if (r3[r1] == r5) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return true;
    }

    private boolean a(DownloadInfo r11, BaseException r12) {
        long r2 = com.ss.android.socialbase.downloader.utils.g.c(r11.getTempPath());     // Catch: BaseException -> L5
    L8:
        if (ZeusTransformUtils.instanceOf(r12, DownloadOutOfSpaceException.class) == false) goto L10;
        long r4 = ((DownloadOutOfSpaceException) ZeusTransformUtils.preCheckCast(r12, DownloadOutOfSpaceException.class, "com.obric.memorydata.plugin")).getRequiredSpaceBytes();
    L12:
        if (r2 >= r4) goto L39;
        com.ss.android.socialbase.downloader.g.a r10 = com.ss.android.socialbase.downloader.g.a.a(r11.getId());
        if (r10.a("space_fill_part_download", 0) == 1) goto L16;
    L38:
        return false;
    L16:
        if (r2 <= 0) goto L37;
        int r13 = r10.a("space_fill_min_keep_mb", 100);
        if (r13 <= 0) goto L39;
        long r3 = r2 - (((long) r13) * 1048576);
        if (com.ss.android.socialbase.downloader.e.a.a(r11) == false) goto L31;
        StringBuilder r6 = new StringBuilder().append("Retry schedule: available = ");
        if (r2 <= 0) goto L24;
        boolean r5 = true;
    L25:
        StringBuilder r14 = r6.append(r5).append(", minKeep = ").append(r13).append("MB, canDownload = ");
        if (r3 <= 0) goto L28;
        boolean r7 = true;
    L29:
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r11, "canRetryWhenInsufficientSpace", r14.append(r7).toString());
        goto L31
    L28:
        r7 = false;
        goto L29
    L24:
        r5 = false;
    L31:
        if (r3 > 0) goto L39;
        if (com.ss.android.socialbase.downloader.e.a.a(r11) == false) goto L35;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r11, "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false");
    L35:
        return false;
    L37:
        if (r10.a("download_when_space_negative", 0) != 1) goto L38;
    L39:
        return true;
    L10:
        r4 = r11.getTotalBytes() - r11.getCurBytes();
    L5:
        e = move-exception;
        e.printStackTrace();
        r2 = 0;
        goto L8
    }

    private int[] a(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L15;
        return null;
    L15:
        String[] r3 = r4.split(",");     // Catch: Throwable -> L14
        if (r3.length > 0) goto L8;
        return null;
    L8:
        int[] r5 = new int[r3.length];     // Catch: Throwable -> L14
        int r1 = 0;
    L10:
        if (r1 >= r3.length) goto L13;
        r5[r1] = Integer.parseInt(r3[r1]);     // Catch: Throwable -> L14
        r1 = r1 + 1;
        goto L10
    L13:
        return r5;
    L14:
        return null;
    }

    static /* synthetic */ ConnectivityManager b(o r0) {
        return r0.h;
    }

    private a b(int r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L15;
        SparseArray<a> r1 = this.d;
        monitor-enter(r1);
        r0 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r5), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r0 != null) goto L9;
        r0 = d(r5);     // Catch: Throwable -> L12
    L9:
        this.d.put(r5, r0);     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r0;
    }

    private void b(final int r3, final boolean r4) {
        com.ss.android.socialbase.downloader.downloader.b.i().execute(new AnonymousClass2(this, r3, r4));
    }

    static /* synthetic */ int c(o r0) {
        return r0.g;
    }

    public static o c() {
        if (f15545a != null) goto L15;
        monitor-enter(o.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15545a != null) goto L9;
        f15545a = new o();     // Catch: Throwable -> L11
    L9:
        monitor-exit(o.class);     // Catch: Throwable -> L11
    L15:
        return f15545a;
    }

    private void c(int r2) {
        SparseArray<a> r0 = this.d;
        monitor-enter(r0);
        this.d.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int d(o r0) {
        return r0.g();
    }

    private a d(int r12) {
        com.ss.android.socialbase.downloader.g.a r0 = com.ss.android.socialbase.downloader.g.a.a(r12);
        boolean r2 = false;
        int r5 = r0.a("retry_schedule", 0);
        JSONObject r1 = r0.e("retry_schedule_config");
        int r3 = 60;
        if (r1 == null) goto L12;
        int r4 = r1.optInt("max_count", 60);
        int r6 = r1.optInt("interval_sec", 60);
        int r7 = r1.optInt("interval_sec_acceleration", 60);
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L11:
        int[] r10 = a(r1.optString("allow_error_code"));
        int r11 = r7;
        boolean r9 = r2;
        int r8 = r4;
        r3 = r6;
    L14:
        return new a(r12, r5, r8, r3 * 1000, r11 * 1000, r9, r10);
    L7:
        if (i == null) goto L11;
        if (r1.optInt("use_job_scheduler", 0) != 1) goto L11;
        r2 = true;
        goto L11
    L12:
        r10 = null;
        r11 = 60;
        r8 = 60;
        r9 = false;
        goto L14
    }

    static /* synthetic */ SparseArray e(o r0) {
        return r0.d;
    }

    private void f() {
        if (com.ss.android.socialbase.downloader.g.a.c().a("use_network_callback", 0) == 1) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.b.i().execute(new AnonymousClass1(this));
    }

    private int g() {
        if (this.h != null) goto L6;
        this.h = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f15546b.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
    L6:
        NetworkInfo r4 = this.h.getActiveNetworkInfo();     // Catch: Exception -> L18
        if (r4 == null) goto L17;
        if (r4.isConnected() == false) goto L17;
        if (r4.getType() != 1) goto L16;
        return 2;
    L16:
        return 1;
    L17:
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0809a
    public void a() {
        a(4, false);
    }

    public void a(final int r3) {
        com.ss.android.socialbase.downloader.downloader.b.i().execute(new AnonymousClass3(this, r3));
    }

    public void a(DownloadInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.b.f15352a) == false) goto L6;
        return;
    L6:
        if (com.ss.android.socialbase.downloader.constants.b.f15352a.equals(r3.getMimeType()) == true) goto L9;
        return;
    L9:
        if (r3.isOnlyWifi() == false) goto L11;
    L14:
        boolean r0 = true;
    L15:
        a(r3, r0, g());
        return;
    L11:
        if (r3.isPauseReserveOnWifi() == true) goto L14;
        r0 = false;
        goto L15
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0809a
    public void b() {
        a(3, false);
    }

    public void d() {
        a(2, true);
    }

    public void e() {
        a(5, false);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r6) {
        if (r6.what != 0) goto L10;
        int r0 = r6.arg1;
        if (r6.arg2 != 1) goto L7;
        boolean r7 = true;
    L8:
        b(r0, r7);
    L13:
        return true;
    L7:
        r7 = false;
        goto L8
    L10:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        com.ss.android.socialbase.downloader.e.a.a("RetryScheduler", r6.what, "handleMessage", "DoSchedulerRetry");
    L12:
        a(r6.what);
        goto L13
    }
}
