package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.work.WorkRequest;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadOutOfSpaceException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import jb.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Handler.Callback, za.a.b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile n f8060m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static m.a f8061n;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f8062c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f8063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseArray<d> f8064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f8065i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f8066j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8067k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ConnectivityManager f8068l;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f8069c;

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.n$a$a, reason: collision with other inner class name */
        class C0148a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f8070a;

            C0148a(a r10) {
                this.f8070a = r10;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network r10) {
                if (lb.a.a() == false) goto L5;
                lb.a.b("RetryScheduler", "onAvailable", "network onAvailable");
            L5:
                n.f(this.f8070a.f8069c, 1, true);
            }
        }

        a(n r10) {
            this.f8069c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L8:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if (n.c(this.f8069c) != null) goto L5;
            return;
        L5:
            if (Build.VERSION.SDK_INT < 21) goto L14;
            n r10 = this.f8069c;     // Catch: Exception -> L8
            n.e(r10, (ConnectivityManager) n.c(r10).getApplicationContext().getSystemService("connectivity"));     // Catch: Exception -> L8
            n.d(this.f8069c).registerNetworkCallback(new NetworkRequest.Builder().build(), new C0148a(this));     // Catch: Exception -> L8
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8071c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f8072g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ n f8073h;

        b(n r10, int r11, boolean r12) {
            this.f8073h = r10;
            this.f8071c = r11;
            this.f8072g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.g(this.f8073h) > 0) goto L5;
            return;
        L5:
            int r10 = n.h(this.f8073h);     // Catch: Exception -> L37
            if (r10 != 0) goto L9;
            return;
        L9:
            if (lb.a.a() == false) goto L11;
            lb.a.b("RetryScheduler", "doScheduleAllTaskRetry", "WaitingRetryTasksCount = " + n.g(this.f8073h));     // Catch: Exception -> L37
        L11:
            long r11 = System.currentTimeMillis();     // Catch: Exception -> L37
            ArrayList r12 = new ArrayList();     // Catch: Exception -> L37
            SparseArray r13 = n.i(this.f8073h);     // Catch: Exception -> L37
            monitor-enter(r13);     // Catch: Exception -> L37
            int r14 = 0;
        L39:
        L33:
            th = move-exception;
            throw th;     // Catch: Exception -> L37
        L15:
            if (r14 >= n.i(this.f8073h).size()) goto L25;
            d r15 = (d) n.i(this.f8073h).valueAt(r14);     // Catch: Throwable -> L33
            if (r15 == null) goto L24;
            if (r15.e(r11, this.f8071c, r10, this.f8072g) == false) goto L24;
            if (this.f8072g == false) goto L23;
            r15.i();     // Catch: Throwable -> L33
        L23:
            r12.add(r15);     // Catch: Throwable -> L33
        L24:
            r14 = r14 + 1;     // Catch: Throwable -> L33
            goto L39
        L25:
            monitor-exit(r13);     // Catch: Throwable -> L33
            goto L46
        L27:
            if (r12.size() <= 0) goto L36;
            Iterator r16 = r12.iterator();     // Catch: Exception -> L37
        L30:
            if (r16.hasNext() == false) goto L47;
            n.j(this.f8073h, ((d) r16.next()).f8076a, r10, false);     // Catch: Exception -> L37
            goto L30
        L47:
            return;
        L36:
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8074c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f8075g;

        c(n r10, int r11) {
            this.f8075g = r10;
            this.f8074c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            n r10 = this.f8075g;     // Catch: Exception -> L4
            n.j(r10, this.f8074c, n.h(r10), true);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f8076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f8077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f8078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f8079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f8080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f8081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int[] f8082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private AtomicInteger f8083h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private AtomicInteger f8084i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f8085j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private AtomicLong f8086k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f8087l;

        d(int r10, int r11, int r12, int r13, int r14, boolean r15, int[] r16) {
            if (r13 >= 3000) goto L6;
            r13 = 3000;
        L6:
            if (r14 >= 5000) goto L8;
            r14 = 5000;
        L8:
            this.f8076a = r10;
            this.f8077b = r11;
            this.f8078c = r12;
            this.f8079d = r13;
            this.f8080e = r14;
            this.f8081f = r15;
            this.f8082g = r16;
            this.f8083h = new AtomicInteger(r13);
            this.f8086k = new AtomicLong(0);
            this.f8084i = new AtomicInteger(0);
        }

        static /* synthetic */ AtomicInteger a(d r10) {
            return r10.f8084i;
        }

        static /* synthetic */ boolean b(d r10, boolean r11) {
            r10.f8085j = r11;
            return r11;
        }

        static /* synthetic */ boolean c(d r10) {
            return r10.f8087l;
        }

        static /* synthetic */ boolean d(d r10, boolean r11) {
            r10.f8087l = r11;
            return r11;
        }

        boolean e(long r10, int r11, int r12, boolean r13) {
            if (this.f8087l == true) goto L9;
            if (lb.a.a() == false) goto L7;
            lb.a.g("RetryScheduler", this.f8076a, "canRetry", "IsWaitingRetry is false, return false");
        L7:
            return false;
        L9:
            if (this.f8077b >= r11) goto L12;
            return false;
        L12:
            if (this.f8084i.get() < this.f8078c) goto L15;
            return false;
        L15:
            if (this.f8085j == true) goto L17;
        L19:
            if (r13 == false) goto L21;
            return true;
        L21:
            if ((r10 - this.f8086k.get()) >= this.f8079d) goto L25;
            return false;
        L25:
            return true;
        L17:
            if (r12 == 2) goto L19;
            return false;
        }

        int f() {
            return this.f8083h.get();
        }

        void g() {
            this.f8084i.incrementAndGet();
        }

        void h() {
            this.f8083h.addAndGet(this.f8080e);
        }

        void i() {
            this.f8083h.set(this.f8079d);
        }

        void j(long r10) {
            this.f8086k.set(r10);
        }
    }

    private n() {
        this.f8063g = new Handler(Looper.getMainLooper(), this);
        this.f8064h = new SparseArray();
        this.f8067k = 0;
        this.f8062c = com.ss.android.socialbase.downloader.downloader.a.h();
        u();
        this.f8065i = com.ss.android.socialbase.downloader.utils.c.A();
        za.a.k().p(this);
    }

    private void A(DownloadInfo r10, boolean r11, int r12) {
        BaseException r13 = r10.getFailedException();
        if (r13 != null) goto L5;
        return;
    L5:
        d r14 = s(r10.getId());
        if (d.a(r14).get() > r14.f8078c) goto L8;
        int r15 = r13.getErrorCode();
        if (com.ss.android.socialbase.downloader.utils.g.N(r13) == false) goto L14;
    L25:
        d.b(r14, r11);
        SparseArray<d> r16 = this.f8064h;
        monitor-enter(r16);
    L48:
        th = move-exception;
        throw th;
    L28:
        if (d.c(r14) == true) goto L30;
        d.d(r14, true);     // Catch: Throwable -> L48
        this.f8067k++;     // Catch: Throwable -> L48
    L30:
        monitor-exit(r16);     // Catch: Throwable -> L48
        int r17 = r14.f();
        if (lb.a.a() == false) goto L35;
        lb.a.g("RetryScheduler", r10.getId(), "tryStartScheduleRetry", "Id = " + r14.f8076a + ", delayTimeMills = " + r17 + ", mWaitingRetryTasks = " + this.f8067k);
    L35:
        if (r14.f8081f == false) goto L44;
        if (r12 != 0) goto L38;
        r14.i();
    L38:
        m.a r18 = f8061n;
        if (r18 == null) goto L42;
        r18.a(r10, r17, r11, r12);
    L42:
        if (this.f8065i == false) goto L54;
        r14.j(System.currentTimeMillis());
        r14.g();
        r14.h();
        return;
    L54:
        return;
    L44:
        if (r11 == false) goto L46;
        return;
    L46:
        this.f8063g.removeMessages(r10.getId());
        this.f8063g.sendEmptyMessageDelayed(r10.getId(), r17);
        return;
    L14:
        if (com.ss.android.socialbase.downloader.utils.g.R(r13) == true) goto L25;
        if (r10.statusInPause() == false) goto L20;
        if (r10.isPauseReserveOnWifi() == true) goto L25;
    L20:
        if (k(r14, r15) == true) goto L23;
        return;
    L23:
        if (lb.a.a() == false) goto L25;
        lb.a.g("RetryScheduler", r10.getId(), "tryStartScheduleRetry", "Allow error code, id = " + r14.f8076a + ", error code = " + r15);
        goto L25
    L8:
        if (lb.a.a() == false) goto L53;
        lb.a.g("RetryScheduler", r10.getId(), "tryStartScheduleRetry", "Id = " + r14.f8076a + ", mRetryCount = " + d.a(r14) + ", maxCount = " + r14.f8078c);
        return;
    }

    static /* synthetic */ Context c(n r10) {
        return r10.f8062c;
    }

    static /* synthetic */ ConnectivityManager d(n r10) {
        return r10.f8068l;
    }

    static /* synthetic */ ConnectivityManager e(n r10, ConnectivityManager r11) {
        r10.f8068l = r11;
        return r11;
    }

    static /* synthetic */ void f(n r10, int r11, boolean r12) {
        r10.w(r11, r12);
    }

    static /* synthetic */ int g(n r10) {
        return r10.f8067k;
    }

    static /* synthetic */ int h(n r10) {
        return r10.r();
    }

    static /* synthetic */ SparseArray i(n r10) {
        return r10.f8064h;
    }

    static /* synthetic */ void j(n r10, int r11, int r12, boolean r13) {
        r10.p(r11, r12, r13);
    }

    private boolean k(d r10, int r11) {
        int[] r12 = r10.f8082g;
        if (r12 != null) goto L5;
    L14:
        return false;
    L5:
        if (r12.length == 0) goto L14;
        int r13 = r12.length;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L14;
        if (r12[r14] == r11) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        return true;
    }

    private boolean l(DownloadInfo r12, BaseException r13) {
        long r10 = com.ss.android.socialbase.downloader.utils.g.n(r12.getTempPath());     // Catch: BaseException -> L5
    L8:
        if ((r13 instanceof DownloadOutOfSpaceException) == false) goto L10;
        long r11 = ((DownloadOutOfSpaceException) r13).getRequiredSpaceBytes();
    L12:
        if (r10 >= r11) goto L39;
        rb.a r14 = rb.a.g(r12.getId());
        if (r14.o("space_fill_part_download", 0) == 1) goto L16;
    L38:
        return false;
    L16:
        if (r10 <= 0) goto L37;
        int r15 = r14.o("space_fill_min_keep_mb", 100);
        if (r15 <= 0) goto L39;
        long r16 = r10 - (((long) r15) * 1048576);
        if (lb.a.a() == false) goto L31;
        int r17 = r12.getId();
        StringBuilder r18 = new StringBuilder();
        r18.append("Retry schedule: available = ");
        if (r10 <= 0) goto L24;
        boolean r19 = true;
    L25:
        r18.append(r19);
        r18.append(", minKeep = ");
        r18.append(r15);
        r18.append("MB, canDownload = ");
        if (r16 <= 0) goto L28;
        boolean r110 = true;
    L29:
        r18.append(r110);
        lb.a.g("RetryScheduler", r17, "canRetryWhenInsufficientSpace", r18.toString());
        goto L31
    L28:
        r110 = false;
        goto L29
    L24:
        r19 = false;
    L31:
        if (r16 > 0) goto L39;
        if (lb.a.a() == false) goto L35;
        lb.a.g("RetryScheduler", r12.getId(), "canRetryWhenInsufficientSpace", "CanDownload <= 0 , canRetry = false");
    L35:
        return false;
    L37:
        if (r14.o("download_when_space_negative", 0) != 1) goto L38;
    L39:
        return true;
    L10:
        r11 = r12.getTotalBytes() - r12.getCurBytes();
    L5:
        e = move-exception;
        e.printStackTrace();
        r10 = 0;
        goto L8
    }

    private d m(int r12) {
        rb.a r10 = rb.a.g(r12);
        boolean r11 = false;
        int r13 = r10.o("retry_schedule", 0);
        JSONObject r14 = r10.q("retry_schedule_config");
        int r15 = 60;
        if (r14 == null) goto L12;
        int r16 = r14.optInt("max_count", 60);
        int r17 = r14.optInt("interval_sec", 60);
        int r18 = r14.optInt("interval_sec_acceleration", 60);
        if (Build.VERSION.SDK_INT >= 21) goto L7;
    L11:
        int[] r19 = t(r14.optString("allow_error_code"));
        int r110 = r18;
        boolean r20 = r11;
        int r21 = r16;
        r15 = r17;
    L14:
        return new d(r12, r13, r21, r15 * 1000, r110 * 1000, r20, r19);
    L7:
        if (f8061n == null) goto L11;
        if (r14.optInt("use_job_scheduler", 0) != 1) goto L11;
        r11 = true;
        goto L11
    L12:
        r19 = null;
        r110 = 60;
        r21 = 60;
        r20 = false;
        goto L14
    }

    private void n(int r10, boolean r11) {
        com.ss.android.socialbase.downloader.downloader.a.i().execute(new b(this, r10, r11));
    }

    private void p(int r10, int r11, boolean r12) {
        Context r13 = this.f8062c;
        if (r13 != null) goto L5;
        return;
    L5:
        SparseArray<d> r14 = this.f8064h;
        monitor-enter(r14);
        d r15 = this.f8064h.get(r10);     // Catch: Throwable -> L82
        if (r15 != null) goto L11;
        monitor-exit(r14);     // Catch: Throwable -> L82
        return;
    L11:
        boolean r16 = true;
        if (d.c(r15) == false) goto L16;
        d.d(r15, false);     // Catch: Throwable -> L82
        int r17 = this.f8067k - 1;     // Catch: Throwable -> L82
        this.f8067k = r17;     // Catch: Throwable -> L82
        if (r17 >= 0) goto L16;
        this.f8067k = 0;     // Catch: Throwable -> L82
    L16:
        monitor-exit(r14);     // Catch: Throwable -> L82
        if (lb.a.a() == false) goto L20;
        lb.a.g("RetryScheduler", r10, "doSchedulerRetryInSubThread", "RetryCount = " + d.a(r15) + ", mWaitingRetryTasksCount = " + this.f8067k);
    L20:
        DownloadInfo r18 = jb.f.u(r13).c(r10);
        if (r18 != null) goto L24;
        v(r10);
        return;
    L24:
        int r19 = r18.getRealStatus();
        if (r19 != (-3)) goto L27;
    L80:
        v(r10);
        return;
    L27:
        if (r19 == (-4)) goto L80;
        if (r19 == (-5)) goto L71;
        if (r19 != (-2)) goto L36;
        if (r18.isPauseReserveOnWifi() == true) goto L71;
    L36:
        if (r19 == (-1)) goto L38;
        return;
    L38:
        if (r11 == 0) goto L40;
        boolean r20 = true;
    L44:
        BaseException r21 = r18.getFailedException();
        if (r20 == true) goto L47;
    L49:
        r15.g();
        if (r20 == true) goto L52;
        if (r12 == false) goto L63;
        r15.h();
    L63:
        if (r18.isOnlyWifi() == false) goto L65;
    L68:
        A(r18, r16, r11);
        return;
    L65:
        if (r18.isPauseReserveOnWifi() == true) goto L68;
        r16 = false;
        goto L68
    L52:
        if (lb.a.a() == false) goto L54;
        lb.a.g("RetryScheduler", r10, "doSchedulerRetryInSubThread", "doSchedulerRetry: restart task, ****** id = " + r15.f8076a);
    L54:
        r15.j(System.currentTimeMillis());
        if (r12 == false) goto L57;
        r15.h();
    L57:
        r18.setRetryScheduleCount(d.a(r15).get());
        if (r18.getStatus() != (-1)) goto L86;
        jb.f.u(r13).l(r18.getId());
        return;
    L86:
        return;
    L47:
        if (com.ss.android.socialbase.downloader.utils.g.N(r21) == false) goto L49;
        r20 = l(r18, r21);
        goto L49
    L40:
        if (r15.f8081f == false) goto L42;
        r20 = false;
        goto L44
    L42:
        return;
    L71:
        if (r19 != (-2)) goto L75;
        t r110 = jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).g();
        if (r110 == null) goto L75;
        r110.a(r18, 4, 3);
    L75:
        jb.k r111 = com.ss.android.socialbase.downloader.downloader.a.w();
        if (r111 == null) goto L78;
        r111.a(Collections.singletonList(r18), 3);
    L78:
        v(r10);
        return;
    L82:
        th = move-exception;
        throw th;
    }

    public static n q() {
        if (f8060m != null) goto L15;
        monitor-enter(n.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f8060m != null) goto L9;
        f8060m = new n();     // Catch: Throwable -> L11
    L9:
        monitor-exit(n.class);     // Catch: Throwable -> L11
    L15:
        return f8060m;
    }

    private int r() {
        int r10 = 0;
        if (this.f8068l != null) goto L6;
        this.f8068l = (ConnectivityManager) this.f8062c.getApplicationContext().getSystemService("connectivity");     // Catch: Exception -> L17
    L6:
        NetworkInfo r11 = this.f8068l.getActiveNetworkInfo();     // Catch: Exception -> L17
        if (r11 == null) goto L16;
        if (r11.isConnected() == false) goto L16;
        r10 = 1;
        if (r11.getType() != 1) goto L16;
        return 2;
    L16:
        return r10;
    }

    private d s(int r10) {
        d r11 = this.f8064h.get(r10);
        if (r11 != null) goto L15;
        SparseArray<d> r12 = this.f8064h;
        monitor-enter(r12);
        r11 = this.f8064h.get(r10);     // Catch: Throwable -> L12
        if (r11 != null) goto L9;
        r11 = m(r10);     // Catch: Throwable -> L12
    L9:
        this.f8064h.put(r10, r11);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        return r11;
    }

    private int[] t(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L15;
        return null;
    L15:
        String[] r11 = r10.split(",");     // Catch: Throwable -> L14
        if (r11.length > 0) goto L8;
        return null;
    L8:
        int[] r12 = new int[r11.length];     // Catch: Throwable -> L14
        int r13 = 0;
    L10:
        if (r13 >= r11.length) goto L13;
        r12[r13] = Integer.parseInt(r11[r13]);     // Catch: Throwable -> L14
        r13 = r13 + 1;
        goto L10
    L13:
        return r12;
    L14:
        return null;
    }

    private void u() {
        if (rb.a.j().o("use_network_callback", 0) == 1) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.downloader.a.i().execute(new a(this));
    }

    private void v(int r10) {
        SparseArray<d> r11 = this.f8064h;
        monitor-enter(r11);
        this.f8064h.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void w(int r10, boolean r11) {
        if (this.f8067k > 0) goto L5;
        return;
    L5:
        long r12 = System.currentTimeMillis();
        monitor-enter(this);
        if (r11 == false) goto L25;
    L12:
        this.f8066j = r12;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (lb.a.a() == false) goto L18;
        lb.a.b("RetryScheduler", "scheduleAllTaskRetry", "level = [" + r10 + "], force = [" + r11 + "]");
    L18:
        if (r11 == false) goto L20;
        this.f8063g.removeMessages(0);
    L20:
        Message r13 = Message.obtain();
        r13.what = 0;
        r13.arg1 = r10;
        r13.arg2 = r11 ? 1 : 0;
        this.f8063g.sendMessageDelayed(r13, 2000);
        return;
    L25:
    L22:
        th = move-exception;
        throw th;
    L9:
        if ((r12 - this.f8066j) >= WorkRequest.MIN_BACKOFF_MILLIS) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L22
    }

    @Override // za.a.b
    public void a() {
        w(4, false);
    }

    @Override // za.a.b
    public void b() {
        w(3, false);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        if (r10.what != 0) goto L10;
        int r11 = r10.arg1;
        if (r10.arg2 != 1) goto L7;
        boolean r12 = true;
    L8:
        n(r11, r12);
    L13:
        return true;
    L7:
        r12 = false;
        goto L8
    L10:
        if (lb.a.a() == false) goto L12;
        lb.a.g("RetryScheduler", r10.what, "handleMessage", "DoSchedulerRetry");
    L12:
        o(r10.what);
        goto L13
    }

    public void o(int r10) {
        com.ss.android.socialbase.downloader.downloader.a.i().execute(new c(this, r10));
    }

    public void x() {
        w(5, false);
    }

    public void y() {
        w(2, true);
    }

    public void z(DownloadInfo r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(ab.b.f128a) == false) goto L6;
        return;
    L6:
        if (ab.b.f128a.equals(r10.getMimeType()) == true) goto L9;
        return;
    L9:
        if (r10.isOnlyWifi() == false) goto L11;
    L14:
        boolean r11 = true;
    L15:
        A(r10, r11, r());
        return;
    L11:
        if (r10.isPauseReserveOnWifi() == true) goto L14;
        r11 = false;
        goto L15
    }
}
