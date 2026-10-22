package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadPauseReserveWifiException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15416a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15417b;
    private final boolean c;
    private DownloadInfo d;
    private h e;
    private final Handler f;
    private DownloadTask g;
    private Map<Integer, IDownloadListener> h;
    private Map<Integer, IDownloadListener> i;
    private Map<Integer, IDownloadListener> j;
    private boolean k;
    private volatile long l;
    private final AtomicLong m;
    private boolean n;
    private int o;
    private long p;
    private long q;
    private boolean r;
    private boolean s;
    private IDownloadMonitorDepend t;

    static {
    }

    public e(DownloadTask r4, Handler r5) {
        boolean r0 = false;
        this.k = false;
        this.l = 0;
        this.m = new AtomicLong();
        this.n = false;
        this.g = r4;
        this.d = r4.getDownloadInfo();
        this.h = r4.getDownloadListeners(ListenerType.MAIN);
        this.j = r4.getDownloadListeners(ListenerType.NOTIFICATION);
        this.i = r4.getDownloadListeners(ListenerType.SUB);
        this.t = r4.getMonitorDepend();
        this.f = r5;
        this.e = b.C();
        boolean r6 = this.d.isFastDownload();
        this.r = r6;
        if (r6 == false) goto L8;
        if (ZeusTransformUtils.instanceOf(this.e, com.ss.android.socialbase.downloader.impls.b.class) == false) goto L8;
        this.e = ((com.ss.android.socialbase.downloader.impls.b) ZeusTransformUtils.preCheckCast(this.e, com.ss.android.socialbase.downloader.impls.b.class, "com.obric.memorydata.plugin")).e();
    L8:
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_anr_progress_handle_msg") <= 0) goto L10;
        boolean r7 = true;
    L11:
        this.f15417b = r7;
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_same_task_monitor_report") <= 0) goto L14;
        boolean r8 = true;
    L15:
        this.c = r8;
        if (com.ss.android.socialbase.downloader.g.a.c().b("remove_useless_monitor_report") <= 0) goto L18;
        r0 = true;
    L18:
        this.s = r0;
        return;
    L14:
        r8 = false;
        goto L15
    L10:
        r7 = false;
        goto L11
    }

    private void a(int r3, BaseException r4) {
        if (this.r == false) goto L10;
        if (r3 != 1) goto L6;
        return;
    L6:
        if (r3 != 6) goto L8;
        return;
    L8:
        if (r3 != 2) goto L10;
        return;
    L10:
        a(r3, r4, true);
    }

    private void a(int r10, BaseException r11, boolean r12) {
        int r0 = this.d.getStatus();
        if (r0 != (-3)) goto L10;
        if (r10 != 4) goto L10;
        if (com.ss.android.socialbase.downloader.e.a.a(this.d) == false) goto L65;
        com.ss.android.socialbase.downloader.e.a.a(f15416a, this.d, "onStatusChanged", "Status = " + r0 + ", monitorStatus = " + r10);
        return;
    L65:
        return;
    L10:
        if (r10 != 4) goto L12;
    L24:
        if (r10 != 6) goto L27;
        this.d.setStatus(2);
    L30:
        if (r0 == (-3)) goto L34;
        if (r0 == (-1)) goto L34;
    L39:
        com.ss.android.socialbase.downloader.utils.e.a(r10, this.i, true, this.d, r11, ListenerType.SUB, this.g);
        if (r10 != (-4)) goto L42;
        return;
    L42:
        if (r12 == true) goto L44;
    L61:
        com.ss.android.socialbase.downloader.impls.a r13 = b.F();
        if (r13 == null) goto L68;
        r13.a(this.d.getId(), this.g.getHashCodeForSameTask(), r10);
        return;
    L68:
        return;
    L44:
        if (this.f == null) goto L61;
        Map<Integer, IDownloadListener> r14 = this.h;
        if (r14 != null) goto L48;
    L49:
        Map<Integer, IDownloadListener> r15 = this.j;
        if (r15 == null) goto L61;
        if (r15.size() <= 0) goto L61;
        if (this.d.canShowNotification() == false) goto L56;
    L58:
        if (this.f15417b == false) goto L60;
        a(b.F(), r10, r11);
        return;
    L60:
        this.f.obtainMessage(r10, this.d.getId(), this.g.getHashCodeForSameTask(), r11).sendToTarget();
        return;
    L56:
        if (this.d.isAutoInstallWithoutNotification() == false) goto L61;
    L48:
        if (r14.size() > 0) goto L58;
    L34:
        if (this.d.getAsyncHandleStatus() != AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING) goto L37;
        this.d.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADED);
    L37:
        if (this.d.getByteInvalidRetryStatus() != ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) goto L39;
        this.d.setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
        goto L39
    L27:
        if (r10 != (-6)) goto L29;
        this.d.setStatus(-3);
        goto L30
    L29:
        this.d.setStatus(r10);
        goto L30
    L12:
        if (DownloadStatus.isRealTimeUploadStatus(r10) == false) goto L17;
        this.d.updateRealDownloadTime(false);
        if (DownloadStatus.isTimeUploadStatus(r10) == false) goto L17;
        this.d.updateDownloadTime();
    L17:
        if (this.d.isAddListenerToSameTask() == false) goto L21;
        if (this.c == false) goto L24;
    L21:
        if (this.s == false) goto L23;
        if (r10 == 6) goto L24;
    L23:
        com.ss.android.socialbase.downloader.f.a.a(this.g, r11, r10);
        goto L24
    }

    private void a(com.ss.android.socialbase.downloader.impls.a r12, final int r13, final BaseException r14) {
        final DownloadTask r8 = r12.a(this.d.getId(), this.g.getHashCodeForSameTask());
        if (r8 != null) goto L6;
        com.ss.android.socialbase.downloader.e.a.b(f15416a, this.d.getId(), "notifyDownloadTaskStatus", "DownloadTask is null");
        return;
    L6:
        final DownloadInfo r6 = r8.getDownloadInfo();
        if (r6 != null) goto L10;
        com.ss.android.socialbase.downloader.e.a.b(f15416a, this.d.getId(), "notifyDownloadTaskStatus", "DownloadInfo is null");
        return;
    L10:
        final Map<Integer, IDownloadListener> r5 = r8.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> r9 = r8.getDownloadListeners(ListenerType.NOTIFICATION);
        if (r8.canShowNotification() == false) goto L13;
    L16:
        boolean r0 = true;
    L17:
        final boolean r10 = r0;
        this.f.post(new AnonymousClass1(this, r13, r5, r6, r14, r8, r9, r10));
        r12.a(this.d.getId(), this.g.getHashCodeForSameTask(), r13);
        return;
    L13:
        if (r6.isAutoInstallWithoutNotification() == true) goto L16;
        r0 = false;
        goto L17
    }

    private boolean a(long r3, boolean r5) {
        boolean r4 = false;
        if (this.d.getCurBytes() != this.d.getTotalBytes()) goto L10;
        this.e.a(this.d.getId(), this.d.getCurBytes());     // Catch: Exception -> L6
    L8:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    L10:
        if (this.k == false) goto L13;
        this.k = false;
        this.d.setStatus(4);
    L13:
        if (this.d.isNeedPostProgress() == false) goto L16;
        if (r5 == false) goto L16;
        r4 = true;
    L16:
        a(4, null, r4);
        return r5;
    }

    private boolean b(long r9) {
        boolean r1 = true;
        if (this.n == true) goto L6;
        this.n = true;
        return true;
    L6:
        long r2 = r9 - this.l;
        if (this.m.get() < this.p) goto L9;
    L12:
        if (r1 == false) goto L14;
        this.l = r9;
        this.m.set(0);
    L14:
        return r1;
    L9:
        if (r2 >= this.o) goto L12;
        r1 = false;
        goto L12
    }

    private void c(BaseException r6) {
        String r0 = f15416a;
        com.ss.android.socialbase.downloader.e.a.b(r0, this.d.getId(), "handleError", "Exception:" + r6);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L28;
        com.ss.android.socialbase.downloader.e.a.b(r0, this.d.getId(), "handleError", "Exception Trace:" + Log.getStackTraceString(new Throwable()));
    L28:
        if (r6 != null) goto L7;
    L25:
        this.e.b(this.d.getId(), this.d.getCurBytes());     // Catch: SQLiteException -> L16
    L27:
    L17:
        BaseException r7 = d(r6);
        this.d.setFailedException(r7);
        if (ZeusTransformUtils.instanceOf(r7, DownloadPauseReserveWifiException.class) == false) goto L20;
        int r1 = -2;
    L21:
        a(r1, r7);
        if (com.ss.android.socialbase.downloader.g.a.a(this.d.getId()).a("retry_schedule", 0) <= 0) goto L30;
        com.ss.android.socialbase.downloader.impls.n.a().a(this.d);
        return;
    L30:
        return;
    L20:
        r1 = -1;
    L16:
        this.e.d(this.d.getId());     // Catch: SQLiteException -> L12
        goto L27
    L7:
        if (r6.getCause() == null) goto L25;
        if (ZeusTransformUtils.instanceOf(r6.getCause(), SQLiteFullException.class) == false) goto L25;
        this.e.d(this.d.getId());     // Catch: SQLiteException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    private BaseException d(BaseException r3) {
        if (com.ss.android.socialbase.downloader.g.a.a(this.d.getId()).a("download_failed_check_net", 1) == 1) goto L5;
    L14:
        return r3;
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.b(r3) == false) goto L14;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        if (com.ss.android.socialbase.downloader.utils.g.c(r2) == true) goto L14;
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("disable_check_no_network") == true) goto L14;
        return new BaseException(1049, r3.getErrorMessage());
    }

    private void e(BaseException r3) {
        this.e.f(this.d.getId());
        a(5, r3);
    }

    private void j() {
        List<com.ss.android.socialbase.downloader.depend.l> r0 = this.g.getDownloadCompleteHandlers();
        if (r0.isEmpty() == true) goto L17;
        DownloadInfo r1 = this.d;
        a(11, null);
        this.e.a(r1);
        Iterator<com.ss.android.socialbase.downloader.depend.l> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L25;
        com.ss.android.socialbase.downloader.depend.l r3 = (com.ss.android.socialbase.downloader.depend.l) ZeusTransformUtils.preCheckCast(r2.next(), com.ss.android.socialbase.downloader.depend.l.class, "com.obric.memorydata.plugin");
    L15:
        e = move-exception;
        throw e;
    L12:
        th = move-exception;
        throw new BaseException(1071, th);
    L9:
        if (r3.b(r1) == false) goto L6;
        r3.a(r1);     // Catch: Throwable -> L12 BaseException -> L15
        this.e.a(r1);     // Catch: Throwable -> L12 BaseException -> L15
    L25:
        return;
    }

    public void a() {
        this.q = System.currentTimeMillis();
        if (this.d.canSkipStatusHandler() == false) goto L5;
        return;
    L5:
        this.d.setStatus(1);
    }

    public void a(long r8, String r10, String r11) {
        this.d.setTotalBytes(r8);
        this.d.seteTag(r10);
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L13:
        this.e.a(this.d.getId(), r8, r10, r11);     // Catch: Exception -> L9
    L11:
        a(3, null);
        this.p = this.d.getMinByteIntervalForPostToMainThread(r8);
        this.o = this.d.getMinProgressTimeMsInterval();
        this.k = true;
        com.ss.android.socialbase.downloader.impls.n.a().c();
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L5:
        if (TextUtils.isEmpty(this.d.getName()) == false) goto L13;
        this.d.setName(r11);
        goto L13
    }

    public void a(BaseException r4) {
        this.d.setFirstDownload(false);
        this.m.set(0);
        e(r4);
    }

    public void a(String r2) {
        com.ss.android.socialbase.downloader.utils.e.a(this.i, this.d, r2);
    }

    public void a(String r5, String r6) {
        if (com.ss.android.socialbase.downloader.e.a.a(this.d) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(f15416a, this.d, "onCompleteForFileExist", "ExistTargetFileName:" + r6 + " but curName is " + this.d.getName());
    L5:
        com.ss.android.socialbase.downloader.utils.c.a(this.d, r5, r6);
        j();
        this.d.setSuccessByCache(true);
        a(-3, null);
        this.e.a(this.d);
    }

    public void a(List<Pair<String, String>> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.utils.e.a(this.i, this.d, r4);
    }

    public void a(byte[] r2, int r3) {
        com.ss.android.socialbase.downloader.utils.e.a(this.i, this.d, r2, r3);
    }

    public boolean a(long r2) {
        this.m.addAndGet(r2);
        this.d.increaseCurBytes(r2);
        long r3 = SystemClock.uptimeMillis();
        return a(r3, b(r3));
    }

    public void b() {
        com.ss.android.socialbase.downloader.model.e r0 = this.g.getTimingInfo();
        r0.g = System.currentTimeMillis();
        if (this.d.canSkipStatusHandler() == true) goto L5;
        this.e.g(this.d.getId());
        a(1, null);
    L5:
        long r1 = this.q;
        if (r1 > 0) goto L11;
    L8:
        com.ss.android.socialbase.downloader.model.e r4 = this.g.getTimingInfo();
        r4.h = System.currentTimeMillis();
        return;
    L11:
        this.d.increaseDownloadPrepareTime(r1);     // Catch: Throwable -> L10
        goto L8
    }

    public void b(BaseException r3) {
        this.d.setFirstDownload(false);
        c(r3);
    }

    public void c() {
        com.ss.android.socialbase.downloader.model.e r0 = this.g.getTimingInfo();
        r0.i = System.currentTimeMillis();
        if (this.d.canSkipStatusHandler() == false) goto L6;
        this.d.changeSkipStatus();
    L12:
        com.ss.android.socialbase.downloader.model.e r4 = this.g.getTimingInfo();
        r4.j = System.currentTimeMillis();
        return;
    L6:
        if (this.d.getDownloadStartTimeStamp() > 0) goto L8;
        this.d.setDownloadStartTimeStamp(System.currentTimeMillis());
    L8:
        this.e.e(this.d.getId());
        if (this.d.isFirstDownload() == false) goto L11;
        a(6, null);
    L11:
        a(2, null);
        goto L12
    }

    public void d() {
        a(-4, null);
    }

    public void e() {
        this.d.setStatus(-2);
        this.e.d(this.d.getId(), this.d.getCurBytes());     // Catch: SQLiteException -> L5
    L7:
        a(-2, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void f() {
        this.d.setStatus(-7);
        this.e.h(this.d.getId());     // Catch: SQLiteException -> L5
    L7:
        a(-7, null);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public void g() {
    L17:
        th = move-exception;
        b(new BaseException(1008, com.ss.android.socialbase.downloader.utils.g.a(th, "onCompleted")));
        return;
    L3:
        if (com.ss.android.socialbase.downloader.e.a.a(this.d) == false) goto L21;
        com.ss.android.socialbase.downloader.e.a.a(f15416a, this.d, "onSaveTempFileSuccess", "Success");     // Catch: Throwable -> L17
    L21:
        j();     // Catch: BaseException -> L14 Throwable -> L17
        DownloadInfo r0 = this.d;     // Catch: Throwable -> L17
        if (r0 != null) goto L10;
        b(new BaseException(1087, "onSaveTempFileSuccess DownloadInfo is null"));     // Catch: Throwable -> L17
        return;
    L10:
        r0.setFirstSuccess(false);     // Catch: Throwable -> L17
        this.d.setSuccessByCache(false);     // Catch: Throwable -> L17
        if (this.d.getDownloadFinishTimeStamp() > 0) goto L13;
        this.d.setDownloadFinishTimeStamp(System.currentTimeMillis());     // Catch: Throwable -> L17
    L13:
        a(-3, null);     // Catch: Throwable -> L17
        this.e.c(this.d.getId(), this.d.getTotalBytes());     // Catch: Throwable -> L17
        this.e.l(this.d.getId());     // Catch: Throwable -> L17
        return;
    L14:
        e = move-exception;
        b(e);     // Catch: Throwable -> L17
    }

    public void h() {
        if (this.d == null) goto L10;
        j();
        if (com.ss.android.socialbase.downloader.e.a.a(this.d) == false) goto L7;
        com.ss.android.socialbase.downloader.e.a.a(f15416a, this.d, "onCompleteForFileExist", "Success");
    L7:
        this.d.setSuccessByCache(true);
        a(-3, null);
        this.e.c(this.d.getId(), this.d.getTotalBytes());
        this.e.a(this.d);
        this.e.l(this.d.getId());
        return;
    L10:
        throw new BaseException(1087, "onCompleteForFileExist DownloadInfo is null");
    }

    public void i() {
        this.d.setStatus(8);
        this.d.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a r0 = b.F();
        if (r0 == null) goto L6;
        r0.a(this.d.getId(), this.g.getHashCodeForSameTask(), 8);
        return;
    }
}
