package pb;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import jb.f;
import sb.e;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile d f12364h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile long f12365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile long f12366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile e f12368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<Notification> f12369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f12370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f12371g;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f12372c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f12373g;

        a(d r10, Intent r11) {
            this.f12373g = r10;
            this.f12372c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a(this.f12373g, this.f12372c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ NotificationManager f12374c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f12375g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f12376h;

        b(d r10, NotificationManager r11, int r12) {
            this.f12376h = r10;
            this.f12374c = r11;
            this.f12375g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b(this.f12376h, this.f12374c, this.f12375g);
        }
    }

    public d() {
        this.f12367c = 1000;
        this.f12369e = new SparseArray(2);
        this.f12370f = new AtomicBoolean(false);
        this.f12371g = j();
    }

    static /* synthetic */ void a(d r10, Intent r11) {
        r10.h(r11);
    }

    static /* synthetic */ void b(d r10, NotificationManager r11, int r12) {
        r10.l(r11, r12);
    }

    private void c(NotificationManager r10, int r11) {
        r10.cancel(r11);     // Catch: Throwable -> L4
        return;
    }

    private void d(NotificationManager r10, int r11, Notification r12) {
        SparseArray<Notification> r13 = this.f12369e;
        monitor-enter(r13);
        int r14 = this.f12369e.indexOfKey(r11);     // Catch: Throwable -> L32
        if (r14 >= 0) goto L7;
    L11:
        monitor-exit(r13);     // Catch: Throwable -> L32
        long r15 = this.f12367c - (System.currentTimeMillis() - this.f12365a);
        if (r15 > 0) goto L16;
        r15 = 0;
    L16:
        if (r15 <= 20000) goto L18;
        r15 = 20000;
    L18:
        long r16 = System.currentTimeMillis() + r15;
        this.f12366b = r16;
        this.f12365a = r16;
        if (r15 > 0) goto L22;
        e(r10, r11, r12);
        return;
    L22:
        if (this.f12368d == null) goto L38;
        SparseArray<Notification> r17 = this.f12369e;
        monitor-enter(r17);
        this.f12369e.put(r11, r12);     // Catch: Throwable -> L28
        monitor-exit(r17);     // Catch: Throwable -> L28
        this.f12368d.f(new b(this, r10, r11), r15);
        return;
    L28:
        th = move-exception;
        throw th;
    L38:
        return;
    L7:
        if (r14 >= this.f12369e.size()) goto L11;
        this.f12369e.setValueAt(r14, r12);     // Catch: Throwable -> L32
        monitor-exit(r13);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private void e(NotificationManager r10, int r11, Notification r12) {
        long r13 = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (this.f12365a >= r13) goto L5;
        this.f12365a = r13;     // Catch: Throwable -> L7
    L5:
        r10.notify(r11, r12);     // Catch: Throwable -> L7
        return;
    }

    public static d f() {
        if (f12364h != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12364h != null) goto L9;
        f12364h = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f12364h;
    }

    private void h(Intent r10) {
        Context r11 = com.ss.android.socialbase.downloader.downloader.a.h();
        if (r11 != null) goto L6;
        lb.a.c("DownloadNotificationServiceImpl", "handleIntentImpl", "Context is null");
        return;
    L6:
        String r12 = r10.getAction();
        NotificationManager r13 = (NotificationManager) r11.getSystemService("notification");
        int r14 = r10.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY".equals(r12) == false) goto L29;
        Notification r15 = (Notification) r10.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
        int r16 = r10.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
        if (r14 == 0) goto L65;
        if (r15 == null) goto L66;
        if (r13 != null) goto L13;
        return;
    L13:
        if (r16 != 4) goto L25;
        if (f.u(com.ss.android.socialbase.downloader.downloader.a.h()).i(r14) == true) goto L17;
        return;
    L17:
        DownloadInfo r17 = f.u(com.ss.android.socialbase.downloader.downloader.a.h()).c(r14);
        if (r17 != null) goto L20;
        return;
    L20:
        if (r17.canNotifyProgress() == true) goto L22;
        return;
    L22:
        if ((System.currentTimeMillis() - this.f12366b) <= this.f12367c) goto L70;
        e(r13, r14, r15);
        r17.setLastNotifyProgressTime();
        return;
    L70:
        return;
    L25:
        if (r16 != (-2)) goto L27;
    L27:
        d(r13, r14, r15);
        return;
    L66:
        return;
    L65:
        return;
    L29:
        if ("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL".equals(r12) == false) goto L62;
        if (r14 == 0) goto L73;
        c(r13, r14);
        return;
    L73:
        return;
    L62:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r12) == false) goto L53;
        if (com.ss.android.socialbase.downloader.utils.c.d(r11, "android.permission.ACCESS_NETWORK_STATE") == false) goto L49;
        ConnectivityManager r18 = (ConnectivityManager) r11.getSystemService("connectivity");     // Catch: Exception -> L50
        if (r18 != null) goto L39;
        return;
    L39:
        NetworkInfo r19 = r18.getActiveNetworkInfo();     // Catch: Exception -> L50
        if (r19 != null) goto L42;
        return;
    L42:
        if (r19.isConnected() == false) goto L64;
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L50
        if (TextUtils.isEmpty(ab.b.f128a) == true) goto L47;
        r20.add(ab.b.f128a);     // Catch: Exception -> L50
    L47:
        r20.add("mime_type_plg");     // Catch: Exception -> L50
        f.u(r11).m(r20);     // Catch: Exception -> L50
        f.u(r11).n(r20);     // Catch: Exception -> L50
        return;
    L64:
        return;
    L49:
        return;
    L53:
        if ("android.intent.action.MEDIA_UNMOUNTED".equals(r12) == false) goto L55;
    L60:
        f.u(com.ss.android.socialbase.downloader.downloader.a.h()).k();     // Catch: Exception -> L50
        return;
    L55:
        if ("android.intent.action.MEDIA_REMOVED".equals(r12) == true) goto L60;
        if ("android.intent.action.MEDIA_BAD_REMOVAL".equals(r12) == true) goto L60;
        if ("android.intent.action.MEDIA_EJECT".equals(r12) == true) goto L60;
        return;
    L50:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean j() {
        if (rb.a.j().o("fix_notification_leak", 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    private void l(NotificationManager r10, int r11) {
        SparseArray<Notification> r12 = this.f12369e;
        monitor-enter(r12);
        Notification r13 = this.f12369e.get(r11);     // Catch: Throwable -> L9
        this.f12369e.remove(r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        if (r13 == null) goto L14;
        e(r10, r11, r13);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void g(Intent r10) {
        if (r10 != null) goto L5;
    L13:
        lb.a.c("DownloadNotificationServiceImpl", "handleIntent", "Intent Error:" + r10);
        return;
    L5:
        if (TextUtils.isEmpty(r10.getAction()) == true) goto L13;
        i();
        if (this.f12368d != null) goto L11;
        lb.a.c("DownloadNotificationServiceImpl", "handleIntent", "NotifyThreadHandler is null");
        return;
    L11:
        this.f12368d.e(new a(this, r10));
    }

    public void i() {
        if (this.f12371g == false) goto L8;
        if (this.f12370f.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        if (lb.a.a() == false) goto L10;
        lb.a.b("DownloadNotificationServiceImpl", CommonConsts.APM_INNER_EVENT_COST_INIT, "Create DownloaderNotifyThread");
    L10:
        this.f12368d = new e("DownloaderNotifyThread");
        this.f12368d.h();
        long r10 = rb.a.j().s("notification_time_window", 1000);
        this.f12367c = r10;
        if (r10 >= 0) goto L13;
    L14:
        this.f12367c = 1000;
        return;
    L13:
        if (r10 > 1200) goto L14;
    }

    public void k() {
        if (this.f12368d != null) goto L9;
        return;
    L9:
        this.f12368d.g();     // Catch: Throwable -> L8
    L6:
        this.f12368d = null;
    }
}
