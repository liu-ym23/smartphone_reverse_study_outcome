package jb;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import ib.a0;
import ib.b0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9817t = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DownloadInfo f9820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f9821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f9822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.d f9823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Integer, a0> f9824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<Integer, a0> f9825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<Integer, a0> f9826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile long f9828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicLong f9829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f9830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f9831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f9832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f9833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f9834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9835r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private b0 f9836s;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9837c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map f9838g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f9839h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ BaseException f9840i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f9841j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ Map f9842k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f9843l;

        a(e r10, int r11, Map r12, DownloadInfo r13, BaseException r14, com.ss.android.socialbase.downloader.model.d r15, Map r16, boolean r17) {
            this.f9837c = r11;
            this.f9838g = r12;
            this.f9839h = r13;
            this.f9840i = r14;
            this.f9841j = r15;
            this.f9842k = r16;
            this.f9843l = r17;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.utils.e.a(this.f9837c, this.f9838g, true, this.f9839h, this.f9840i, ListenerType.MAIN, this.f9841j);
            com.ss.android.socialbase.downloader.utils.e.a(this.f9837c, this.f9842k, this.f9843l, this.f9839h, this.f9840i, ListenerType.NOTIFICATION, this.f9841j);
        }
    }

    static {
    }

    public e(com.ss.android.socialbase.downloader.model.d r10, Handler r11) {
        boolean r12 = false;
        this.f9827j = false;
        this.f9828k = 0;
        this.f9829l = new AtomicLong();
        this.f9830m = false;
        this.f9823f = r10;
        this.f9820c = r10.y();
        this.f9824g = r10.B(ListenerType.MAIN);
        this.f9826i = r10.B(ListenerType.NOTIFICATION);
        this.f9825h = r10.B(ListenerType.SUB);
        this.f9836s = r10.G();
        this.f9822e = r11;
        this.f9821d = com.ss.android.socialbase.downloader.downloader.a.o();
        boolean r13 = this.f9820c.isFastDownload();
        this.f9834q = r13;
        if (r13 == false) goto L8;
        i r14 = this.f9821d;
        if ((r14 instanceof com.ss.android.socialbase.downloader.impls.b) == false) goto L8;
        this.f9821d = ((com.ss.android.socialbase.downloader.impls.b) r14).q();
    L8:
        if (rb.a.j().n("fix_anr_progress_handle_msg") <= 0) goto L10;
        boolean r15 = true;
    L11:
        this.f9818a = r15;
        if (rb.a.j().n("fix_same_task_monitor_report") <= 0) goto L14;
        boolean r16 = true;
    L15:
        this.f9819b = r16;
        if (rb.a.j().n("remove_useless_monitor_report") <= 0) goto L18;
        r12 = true;
    L18:
        this.f9835r = r12;
        return;
    L14:
        r16 = false;
        goto L15
    L10:
        r15 = false;
        goto L11
    }

    private void a() {
        List<ib.m> r10 = this.f9823f.w();
        if (r10.isEmpty() == true) goto L17;
        DownloadInfo r11 = this.f9820c;
        x(11, null);
        this.f9821d.b(r11);
        Iterator<ib.m> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L25;
        ib.m r13 = r12.next();
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        throw new BaseException(1071, th);
    L9:
        if (r13.S(r11) == false) goto L6;
        r13.m0(r11);     // Catch: Throwable -> L12 BaseException -> L15
        this.f9821d.b(r11);     // Catch: Throwable -> L12 BaseException -> L15
    L25:
        return;
    }

    private void b(BaseException r10) {
        String r11 = f9817t;
        lb.a.h(r11, this.f9820c.getId(), "handleError", "Exception:" + r10);
        if (lb.a.a() == false) goto L28;
        lb.a.h(r11, this.f9820c.getId(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
    L28:
        if (r10 != null) goto L7;
    L25:
        this.f9821d.V(this.f9820c.getId(), this.f9820c.getCurBytes());     // Catch: SQLiteException -> L16
    L27:
    L17:
        BaseException r12 = z(r10);
        this.f9820c.setFailedException(r12);
        if ((r12 instanceof DownloadPauseReserveWifiException) == false) goto L20;
        int r13 = -2;
    L21:
        x(r13, r12);
        if (rb.a.g(this.f9820c.getId()).o("retry_schedule", 0) <= 0) goto L30;
        com.ss.android.socialbase.downloader.impls.m.d().b(this.f9820c);
        return;
    L30:
        return;
    L20:
        r13 = -1;
    L16:
        this.f9821d.j(this.f9820c.getId());     // Catch: SQLiteException -> L12
        goto L27
    L7:
        if (r10.getCause() == null) goto L25;
        if ((r10.getCause() instanceof SQLiteFullException) == false) goto L25;
        this.f9821d.j(this.f9820c.getId());     // Catch: SQLiteException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private boolean d(long r10, boolean r11) {
        boolean r12 = false;
        if (this.f9820c.getCurBytes() != this.f9820c.getTotalBytes()) goto L10;
        this.f9821d.n0(this.f9820c.getId(), this.f9820c.getCurBytes());     // Catch: Exception -> L6
    L8:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.f9827j == false) goto L13;
        this.f9827j = false;
        this.f9820c.setStatus(4);
    L13:
        if (this.f9820c.isNeedPostProgress() == false) goto L16;
        if (r11 == false) goto L16;
        r12 = true;
    L16:
        y(4, null, r12);
        return r11;
    }

    private void e(BaseException r10) {
        this.f9821d.E(this.f9820c.getId());
        x(5, r10);
    }

    private boolean g(long r10) {
        boolean r11 = true;
        if (this.f9830m == true) goto L6;
        this.f9830m = true;
        return true;
    L6:
        long r12 = r10 - this.f9828k;
        if (this.f9829l.get() < this.f9832o) goto L9;
    L12:
        if (r11 == false) goto L14;
        this.f9828k = r10;
        this.f9829l.set(0);
    L14:
        return r11;
    L9:
        if (r12 >= this.f9831n) goto L12;
        r11 = false;
        goto L12
    }

    private void h(com.ss.android.socialbase.downloader.impls.a r12, int r13, BaseException r14) {
        com.ss.android.socialbase.downloader.model.d r10 = r12.y(this.f9820c.getId(), this.f9823f.E());
        if (r10 != null) goto L6;
        lb.a.h(f9817t, this.f9820c.getId(), "notifyDownloadTaskStatus", "DownloadTask is null");
        return;
    L6:
        DownloadInfo r11 = r10.y();
        if (r11 != null) goto L10;
        lb.a.h(f9817t, this.f9820c.getId(), "notifyDownloadTaskStatus", "DownloadInfo is null");
        return;
    L10:
        Map<Integer, a0> r15 = r10.B(ListenerType.MAIN);
        Map<Integer, a0> r16 = r10.B(ListenerType.NOTIFICATION);
        if (r10.i() == false) goto L13;
    L16:
        boolean r17 = true;
    L17:
        boolean r18 = r17;
        this.f9822e.post(new a(this, r13, r15, r11, r14, r10, r16, r18));
        r12.I(this.f9820c.getId(), this.f9823f.E(), r13);
        return;
    L13:
        if (r11.isAutoInstallWithoutNotification() == true) goto L16;
        r17 = false;
        goto L17
    }

    private void x(int r10, BaseException r11) {
        if (this.f9834q == false) goto L10;
        if (r10 != 1) goto L6;
        return;
    L6:
        if (r10 != 6) goto L8;
        return;
    L8:
        if (r10 != 2) goto L10;
        return;
    L10:
        y(r10, r11, true);
    }

    private void y(int r10, BaseException r11, boolean r12) {
        int r13 = this.f9820c.getStatus();
        if (r13 != (-3)) goto L10;
        if (r10 != 4) goto L10;
        if (lb.a.a() == false) goto L65;
        lb.a.g(f9817t, this.f9820c.getId(), "onStatusChanged", "Status = " + r13 + ", monitorStatus = " + r10);
        return;
    L65:
        return;
    L10:
        if (r10 != 4) goto L12;
    L24:
        if (r10 != 6) goto L27;
        this.f9820c.setStatus(2);
    L30:
        if (r13 == (-3)) goto L34;
        if (r13 == (-1)) goto L34;
    L39:
        com.ss.android.socialbase.downloader.utils.e.a(r10, this.f9825h, true, this.f9820c, r11, ListenerType.SUB, this.f9823f);
        if (r10 != (-4)) goto L42;
        return;
    L42:
        if (r12 == true) goto L44;
    L61:
        com.ss.android.socialbase.downloader.impls.a r14 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r14 == null) goto L68;
        r14.I(this.f9820c.getId(), this.f9823f.E(), r10);
        return;
    L68:
        return;
    L44:
        if (this.f9822e == null) goto L61;
        Map<Integer, a0> r15 = this.f9824g;
        if (r15 != null) goto L48;
    L49:
        Map<Integer, a0> r16 = this.f9826i;
        if (r16 == null) goto L61;
        if (r16.size() <= 0) goto L61;
        if (this.f9820c.canShowNotification() == false) goto L56;
    L58:
        if (this.f9818a == false) goto L60;
        h(com.ss.android.socialbase.downloader.downloader.a.s(), r10, r11);
        return;
    L60:
        this.f9822e.obtainMessage(r10, this.f9820c.getId(), this.f9823f.E(), r11).sendToTarget();
        return;
    L56:
        if (this.f9820c.isAutoInstallWithoutNotification() == false) goto L61;
    L48:
        if (r15.size() > 0) goto L58;
    L34:
        if (this.f9820c.getAsyncHandleStatus() != AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) goto L37;
        this.f9820c.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
    L37:
        if (this.f9820c.getByteInvalidRetryStatus() != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) goto L39;
        this.f9820c.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
        goto L39
    L27:
        if (r10 != (-6)) goto L29;
        this.f9820c.setStatus(-3);
        goto L30
    L29:
        this.f9820c.setStatus(r10);
        goto L30
    L12:
        if (ab.d.e(r10) == false) goto L17;
        this.f9820c.updateRealDownloadTime(false);
        if (ab.d.f(r10) == false) goto L17;
        this.f9820c.updateDownloadTime();
    L17:
        if (this.f9820c.isAddListenerToSameTask() == false) goto L21;
        if (this.f9819b == false) goto L24;
    L21:
        if (this.f9835r == false) goto L23;
        if (r10 == 6) goto L24;
    L23:
        mb.a.l(this.f9823f, r11, r10);
        goto L24
    }

    private BaseException z(BaseException r10) {
        if (rb.a.g(this.f9820c.getId()).o("download_failed_check_net", 1) == 1) goto L5;
    L14:
        return r10;
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.R(r10) == false) goto L14;
        Context r11 = com.ss.android.socialbase.downloader.downloader.a.h();
        if (r11 == null) goto L14;
        if (com.ss.android.socialbase.downloader.utils.g.Q(r11) == true) goto L14;
        if (rb.a.d().optBoolean("disable_check_no_network") == true) goto L14;
        return new BaseException(1049, r10.getErrorMessage());
    }

    public void c() {
        com.ss.android.socialbase.downloader.model.f r10 = this.f9823f.M();
        r10.f8187g = System.currentTimeMillis();
        if (this.f9820c.canSkipStatusHandler() == true) goto L5;
        this.f9821d.I0(this.f9820c.getId());
        x(1, null);
    L5:
        long r11 = this.f9833p;
        if (r11 > 0) goto L11;
    L8:
        com.ss.android.socialbase.downloader.model.f r12 = this.f9823f.M();
        r12.f8188h = System.currentTimeMillis();
        return;
    L11:
        this.f9820c.increaseDownloadPrepareTime(r11);     // Catch: Throwable -> L10
        goto L8
    }

    public void f() {
        this.f9820c.setStatus(8);
        this.f9820c.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a r10 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r10 == null) goto L6;
        r10.I(this.f9820c.getId(), this.f9823f.E(), 8);
        return;
    }

    public void i() {
        x(-4, null);
    }

    public void j() {
        if (this.f9820c == null) goto L10;
        a();
        if (lb.a.a() == false) goto L7;
        lb.a.g(f9817t, this.f9820c.getId(), "onCompleteForFileExist", "Success");
    L7:
        this.f9820c.setSuccessByCache(true);
        x(-3, null);
        this.f9821d.d0(this.f9820c.getId(), this.f9820c.getTotalBytes());
        this.f9821d.b(this.f9820c);
        this.f9821d.f2(this.f9820c.getId());
        return;
    L10:
        throw new BaseException(1087, "onCompleteForFileExist DownloadInfo is null");
    }

    public void k(String r10, String r11) {
        if (lb.a.a() == false) goto L5;
        lb.a.g(f9817t, this.f9820c.getId(), "onCompleteForFileExist", "ExistTargetFileName:" + r11 + " but curName is " + this.f9820c.getName());
    L5:
        com.ss.android.socialbase.downloader.utils.c.h(this.f9820c, r10, r11);
        a();
        this.f9820c.setSuccessByCache(true);
        x(-3, null);
        this.f9821d.b(this.f9820c);
    }

    public void l(BaseException r10) {
        this.f9820c.setFirstDownload(false);
        b(r10);
    }

    public void m(long r10, String r11, String r12) {
        this.f9820c.setTotalBytes(r10);
        this.f9820c.seteTag(r11);
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L13:
        this.f9821d.t0(this.f9820c.getId(), r10, r11, r12);     // Catch: Exception -> L9
    L11:
        x(3, null);
        this.f9832o = this.f9820c.getMinByteIntervalForPostToMainThread(r10);
        this.f9831n = this.f9820c.getMinProgressTimeMsInterval();
        this.f9827j = true;
        com.ss.android.socialbase.downloader.impls.m.d().a();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.f9820c.getName()) == false) goto L13;
        this.f9820c.setName(r12);
        goto L13
    }

    public void n() {
        this.f9820c.setStatus(-7);
        this.f9821d.B0(this.f9820c.getId());     // Catch: SQLiteException -> L5
    L7:
        x(-7, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void o() {
        this.f9820c.setStatus(-2);
        this.f9821d.y(this.f9820c.getId(), this.f9820c.getCurBytes());     // Catch: SQLiteException -> L5
    L7:
        x(-2, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void p() {
        this.f9833p = System.currentTimeMillis();
        if (this.f9820c.canSkipStatusHandler() == false) goto L5;
        return;
    L5:
        this.f9820c.setStatus(1);
    }

    public boolean q(long r10) {
        this.f9829l.addAndGet(r10);
        this.f9820c.increaseCurBytes(r10);
        long r11 = SystemClock.uptimeMillis();
        return d(r11, g(r11));
    }

    public void r(byte[] r10, int r11) {
        com.ss.android.socialbase.downloader.utils.e.c(this.f9825h, this.f9820c, r10, r11);
    }

    public void s(List<Pair<String, String>> r10) {
        com.ss.android.socialbase.downloader.utils.e.d(this.f9825h, this.f9820c, r10);
    }

    public void t(String r10) {
        com.ss.android.socialbase.downloader.utils.e.e(this.f9825h, this.f9820c, r10);
    }

    public void u(BaseException r10) {
        this.f9820c.setFirstDownload(false);
        this.f9829l.set(0);
        e(r10);
    }

    public void v() {
    L17:
        th = move-exception;
        l(new BaseException(PointerIconCompat.TYPE_TEXT, com.ss.android.socialbase.downloader.utils.g.w(th, "onCompleted")));
        return;
    L3:
        if (lb.a.a() == false) goto L20;
        lb.a.g(f9817t, this.f9820c.getId(), "onSaveTempFileSuccess", "Success");     // Catch: Throwable -> L17
    L20:
        a();     // Catch: BaseException -> L14 Throwable -> L17
        DownloadInfo r10 = this.f9820c;     // Catch: Throwable -> L17
        if (r10 != null) goto L10;
        l(new BaseException(1087, "onSaveTempFileSuccess DownloadInfo is null"));     // Catch: Throwable -> L17
        return;
    L10:
        r10.setFirstSuccess(false);     // Catch: Throwable -> L17
        this.f9820c.setSuccessByCache(false);     // Catch: Throwable -> L17
        if (this.f9820c.getDownloadFinishTimeStamp() > 0) goto L13;
        this.f9820c.setDownloadFinishTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L17
    L13:
        x(-3, null);     // Catch: Throwable -> L17
        this.f9821d.d0(this.f9820c.getId(), this.f9820c.getTotalBytes());     // Catch: Throwable -> L17
        this.f9821d.f2(this.f9820c.getId());     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        l(e);     // Catch: Throwable -> L17
    }

    public void w() {
        com.ss.android.socialbase.downloader.model.f r10 = this.f9823f.M();
        r10.f8189i = System.currentTimeMillis();
        if (this.f9820c.canSkipStatusHandler() == false) goto L6;
        this.f9820c.changeSkipStatus();
    L12:
        com.ss.android.socialbase.downloader.model.f r11 = this.f9823f.M();
        r11.f8190j = System.currentTimeMillis();
        return;
    L6:
        if (this.f9820c.getDownloadStartTimeStamp() > 0) goto L8;
        this.f9820c.setDownloadStartTimeStamp(System.currentTimeMillis());
    L8:
        this.f9821d.w0(this.f9820c.getId());
        if (this.f9820c.isFirstDownload() == false) goto L11;
        x(6, null);
    L11:
        x(2, null);
        goto L12
    }
}
