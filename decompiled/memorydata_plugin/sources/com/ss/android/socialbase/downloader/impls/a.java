package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.security.obric.guard.ObricSecurityGuardStub;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.LruCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements com.ss.android.socialbase.downloader.h.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.h.f f15459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<DownloadTask> f15460b;
    private final SparseArray<DownloadTask> c;
    private final SparseArray<DownloadTask> d;
    private final SparseArray<DownloadTask> e;
    private final SparseArray<SparseArray<DownloadTask>> f;
    private final LruCache<Integer, DownloadTask> g;
    private final LinkedBlockingDeque<DownloadTask> h;
    private final com.ss.android.socialbase.downloader.downloader.h i;
    private boolean j;

    public a() {
        this.f15460b = new SparseArray();
        this.c = new SparseArray();
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.f = new SparseArray();
        this.g = new LruCache();
        this.h = new LinkedBlockingDeque();
        this.f15459a = new com.ss.android.socialbase.downloader.h.f(Looper.getMainLooper(), this);
        this.i = com.ss.android.socialbase.downloader.downloader.b.C();
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_anr_isolate_engine_and_cache") <= 0) goto L5;
        boolean r0 = true;
    L6:
        this.j = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    static /* synthetic */ DownloadTask a(a r0, int r1) {
        return r0.o(r1);
    }

    private void a(int r10, BaseException r11, DownloadTask r12) {
        if (r12 == null) goto L16;
        DownloadInfo r9 = r12.getDownloadInfo();
        if (r9 != null) goto L7;
        com.ss.android.socialbase.downloader.e.a.b("AbsDownloadEngine", "notifyDownloadTaskStatus", "DownloadInfo is null\"");
        return;
    L7:
        Map<Integer, IDownloadListener> r1 = r12.getDownloadListeners(ListenerType.MAIN);
        Map<Integer, IDownloadListener> r7 = r12.getDownloadListeners(ListenerType.NOTIFICATION);
        if (r12.canShowNotification() == false) goto L10;
    L13:
        boolean r0 = true;
    L14:
        com.ss.android.socialbase.downloader.utils.e.a(r10, r1, true, r9, r11, ListenerType.MAIN, r12);
        com.ss.android.socialbase.downloader.utils.e.a(r10, r7, r0, r9, r11, ListenerType.NOTIFICATION, r12);
        return;
    L10:
        if (r9.isAutoInstallWithoutNotification() == true) goto L13;
        r0 = false;
        goto L14
    }

    static /* synthetic */ void a(a r0, int r1, boolean r2) {
        r0.d(r1, r2);
    }

    private boolean a(DownloadInfo r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.statusInPause() == true) goto L8;
        return false;
    L8:
        return r2.isPauseReserveOnWifi();
    }

    private void b(int r6, int r7) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r6, "removeTask", "Listener hashCode: " + r7);
    L5:
        if (r7 != 0) goto L8;
    L6:
        this.f15460b.remove(r6);
        SparseArray r5 = this.f;
    L7:
        r5.remove(r6);
        return;
    L8:
        SparseArray r0 = (SparseArray) ZeusTransformUtils.preCheckCast(this.f.get(r6), SparseArray.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L16;
        r0.remove(r7);
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L14;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r6, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r0.size());
    L14:
        if (r0.size() == 0) goto L6;
        return;
    L16:
        r5 = this.f15460b;
        goto L7
    }

    private synchronized void b(int r7, int r8, IDownloadListener r9, final ListenerType r10, boolean r11, boolean r12) {
        monitor-enter(this);
        final IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r9, IDownloadListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        final DownloadTask r4 = o(r7);     // Catch: Throwable -> L31
        if (r4 == null) goto L21;
        r4.addDownloadListener(r8, r2, r10, r11);     // Catch: Throwable -> L31
        final DownloadInfo r3 = r4.getDownloadInfo();     // Catch: Throwable -> L31
        if (r12 == false) goto L29;
        if (r3 == null) goto L29;
        if (a(r7) == true) goto L29;
        if (r10 != ListenerType.MAIN) goto L13;
    L14:
        boolean r13 = true;
        if (r10 == ListenerType.NOTIFICATION) goto L17;
    L19:
        if (r13 == false) goto L29;
        this.f15459a.post(new AnonymousClass8(this, r2, r3, r4, r10));     // Catch: Throwable -> L31
        goto L29
    L17:
        if (r3.canShowNotification() == true) goto L19;
        r13 = false;
        goto L19
    L13:
        if (r10 == ListenerType.NOTIFICATION) goto L14;
    L29:
        monitor-exit(this);
        return;
    L21:
        DownloadInfo r14 = this.i.b(r7);     // Catch: Throwable -> L31
        if (r14 == null) goto L29;
        if (r14.getStatus() == (-3)) goto L29;
        DownloadTask r15 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r7)), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r15 != null) goto L28;
        r15 = new DownloadTask(r14);     // Catch: Throwable -> L31
        this.g.put(Integer.valueOf(r7), r15);     // Catch: Throwable -> L31
    L28:
        r15.addDownloadListener(r8, r2, r10, r11);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private synchronized List<DownloadInfo> c(String r7) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r7) == true) goto L6;
        List<DownloadInfo> r0 = this.i.a(r7);     // Catch: Throwable -> L27
        if (r0 != null) goto L11;
    L15:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L27
        int r2 = this.f15460b.size();     // Catch: Throwable -> L27
        int r3 = 0;
    L16:
        if (r3 >= r2) goto L25;
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.valueAt(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r4 == null) goto L24;
        if (r4.getDownloadInfo() == null) goto L24;
        if (r7.equals(r4.getDownloadInfo().getUrl()) == false) goto L24;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L27
    L24:
        r3 = r3 + 1;
        goto L16
    L25:
        monitor-exit(this);
        return r1;
    L11:
        if (r0.isEmpty() == true) goto L15;
        monitor-exit(this);
        return r0;
    L6:
        monitor-exit(this);
        return null;
    }

    private synchronized void c(int r5, boolean r6, boolean r7) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L36;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);     // Catch: Throwable -> L30
    L36:
        DownloadInfo r0 = this.i.b(r5);     // Catch: Throwable -> L26
        if (r0 == null) goto L34;
        if (r6 == false) goto L12;
        if (r7 == false) goto L11;
        new com.ss.android.socialbase.downloader.d.a(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L26
    L11:
        com.ss.android.socialbase.downloader.utils.g.b(r0, r6);     // Catch: Throwable -> L26
    L13:
        r0.erase();     // Catch: Throwable -> L26
        goto L34
    L12:
        com.ss.android.socialbase.downloader.utils.g.e(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L26
    L34:
        this.i.d(r5);     // Catch: SQLiteException -> L16 Throwable -> L26
    L18:
        a(r5, 0, -4);     // Catch: Throwable -> L26
        if (this.d.get(r5) == null) goto L22;
        this.d.remove(r5);     // Catch: Throwable -> L26
    L22:
        if (this.c.get(r5) == null) goto L24;
        this.c.remove(r5);     // Catch: Throwable -> L26
    L24:
        this.g.remove(Integer.valueOf(r5));     // Catch: Throwable -> L26
        com.ss.android.socialbase.downloader.g.a.b(r5);     // Catch: Throwable -> L26
    L28:
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
        goto L28
    }

    private void c(DownloadTask r6) {
        int r0 = r6.getHashCodeForSameTask();
        if (r0 == 0) goto L5;
    L7:
        if (r0 != 0) goto L9;
        return;
    L9:
        SparseArray<DownloadTask> r1 = (SparseArray) ZeusTransformUtils.preCheckCast(this.f.get(r6.getDownloadId()), SparseArray.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L13;
        r1 = new SparseArray();
        this.f.put(r6.getDownloadId(), r1);
    L13:
        if (com.ss.android.socialbase.downloader.e.a.a(r6.getDownloadInfo()) == false) goto L15;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r6.getDownloadInfo(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r0);
    L15:
        r1.put(r0, r6);
        return;
    L5:
        if (r6.isAutoSetHashCodeForSameTask() == false) goto L7;
        r0 = r6.autoCalAndGetHashCodeForSameTask();
        goto L7
    }

    private synchronized boolean c(int r9, boolean r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r9, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        final DownloadTask r4 = o(r9);     // Catch: Throwable -> L16
        if (r4 == null) goto L9;
        final DownloadInfo r3 = r4.getDownloadInfo();     // Catch: Throwable -> L16
        final Map<Integer, IDownloadListener> r2 = r4.getDownloadListeners(ListenerType.MAIN);     // Catch: Throwable -> L16
        final Map<Integer, IDownloadListener> r5 = r4.getDownloadListeners(ListenerType.NOTIFICATION);     // Catch: Throwable -> L16
        this.f15459a.post(new AnonymousClass2(this, r2, r3, r4, r5));     // Catch: Throwable -> L16
    L9:
        DownloadInfo r0 = this.i.b(r9);     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        r0.setStatus(-4);     // Catch: Throwable -> L16
    L12:
        a(r9, r10, false);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    }

    private void d(int r2, boolean r3) {
        if (this.j == true) goto L33;
        e(r2, r3);
        return;
    L33:
        DownloadInfo r0 = this.i.b(r2);     // Catch: Throwable -> L26
        if (r0 == null) goto L31;
        com.ss.android.socialbase.downloader.utils.g.b(r0, r3);     // Catch: Throwable -> L26
        r0.erase();     // Catch: Throwable -> L26
    L31:
        this.i.a(r0);     // Catch: SQLiteException -> L11 Throwable -> L26
    L13:
        monitor-enter(this);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (this.d.get(r2) == null) goto L18;
        this.d.remove(r2);     // Catch: Throwable -> L23
    L18:
        if (this.c.get(r2) == null) goto L20;
        this.c.remove(r2);     // Catch: Throwable -> L23
    L20:
        this.g.remove(Integer.valueOf(r2));     // Catch: Throwable -> L23
        com.ss.android.socialbase.downloader.g.a.b(r2);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
    L35:
        return;
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.printStackTrace();
    }

    private void d(DownloadTask r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r11.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isEntityInvalid() == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.b("AbsDownloadEngine", r0.getId(), "tryDownload", "entity invalid");
        com.ss.android.socialbase.downloader.f.a.a(r11.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is Invalid, url is " + r0.getUrl() + " name is " + r0.getName() + " savePath is " + r0.getSavePath()), r0.getStatus());
        return;
    L11:
        r11.getTimingInfo().c = System.currentTimeMillis();
        boolean r1 = true;
        com.ss.android.socialbase.downloader.downloader.b.a(r11, true);
        int r7 = 0;
        if (com.ss.android.socialbase.downloader.g.a.a(r0.getId()).a("no_net_opt", 0) == 1) goto L14;
    L21:
        int r5 = r0.getId();
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L25;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r0, "tryDownload", "Url: " + r0.getUrl() + " savePath: " + r0.getSavePath() + " saveName: " + r0.getName());
    L25:
        if (this.d.get(r5) == null) goto L28;
        this.d.remove(r5);
    L28:
        if (this.c.get(r5) == null) goto L31;
        this.c.remove(r5);
    L31:
        if (this.e.get(r5) == null) goto L34;
        this.e.remove(r5);
    L34:
        if (a(r5) == false) goto L43;
        if (r0.canReStartAsyncTask() == true) goto L43;
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L40;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r0, "tryDownload", "Another task with same id is downloading when tryDownload");
    L40:
        r11.addListenerToDownloadingSameTask();
        com.ss.android.socialbase.downloader.f.a.a(r11.getMonitorDepend(), r0, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), r0.getStatus());
        return;
    L43:
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L46;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r0, "tryDownload", "No downloading task");
    L46:
        if (r0.canReStartAsyncTask() == false) goto L48;
        r0.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
    L48:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.g.remove(Integer.valueOf(r5)), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L52;
        r11.copyListenerFromPendingTask(r2);
    L52:
        if ("mime_type_plg".equals(r0.getMimeType()) == false) goto L54;
        r11.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
    L54:
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L63;
        DownloadInfo r4 = r3.getDownloadInfo();
        if (r4 == null) goto L63;
        int r6 = r4.getStatus();
        if (DownloadStatus.isDownloading(r6) == true) goto L62;
        r1 = false;
    L62:
        r7 = r6;
    L65:
        if (com.ss.android.socialbase.downloader.e.a.a(r0) == false) goto L67;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r0, "tryDownload", "Can add listener " + r1 + " , oldTaskStatus is :" + r7);
    L67:
        if (r1 == false) goto L69;
        r11.addListenerToDownloadingSameTask();
        return;
    L69:
        c(r11);
        this.f15460b.put(r5, r11);
        a(r11);
        return;
    L63:
        r1 = false;
        goto L65
    L14:
        if (com.ss.android.socialbase.downloader.utils.g.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L21;
        if (r0.isFirstDownload() == true) goto L21;
        if (com.ss.android.socialbase.downloader.g.a.b().optBoolean("disable_check_no_network") == true) goto L21;
        new com.ss.android.socialbase.downloader.downloader.e(r11, this.f15459a).b(new BaseException(1049, "network_not_available"));
    }

    private void e(int r2, boolean r3) {
        DownloadInfo r0 = this.i.b(r2);     // Catch: Throwable -> L17
        if (r0 == null) goto L20;
        com.ss.android.socialbase.downloader.utils.g.b(r0, r3);     // Catch: Throwable -> L17
        r0.erase();     // Catch: Throwable -> L17
    L20:
        this.i.a(r0);     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.d.get(r2) == null) goto L13;
        this.d.remove(r2);     // Catch: Throwable -> L17
    L13:
        if (this.c.get(r2) == null) goto L15;
        this.c.remove(r2);     // Catch: Throwable -> L17
    L15:
        this.g.remove(Integer.valueOf(r2));     // Catch: Throwable -> L17
        com.ss.android.socialbase.downloader.g.a.b(r2);     // Catch: Throwable -> L17
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    private void e(DownloadTask r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        DownloadInfo r0 = r5.getDownloadInfo();
        if (r0 != null) goto L8;
        return;
    L8:
        if (l.a(r0) == false) goto L41;
        l.a().a(r5);
        return;
    L41:
        if (this.h.isEmpty() == false) goto L17;
        d(r5);     // Catch: InterruptedException -> L40
    L14:
        this.h.put(r5);     // Catch: InterruptedException -> L40
        return;
    L17:
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) goto L19;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.h.getFirst(), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L40
        if (r1.getDownloadId() == r5.getDownloadId()) goto L34;
    L36:
        e(r1.getDownloadId());     // Catch: InterruptedException -> L40
        d(r5);     // Catch: InterruptedException -> L40
        if (r1.getDownloadId() == r5.getDownloadId()) goto L49;
        this.h.putFirst(r5);     // Catch: InterruptedException -> L40
        return;
    L49:
        return;
    L34:
        if (a(r5.getDownloadId()) == false) goto L36;
        return;
    L19:
        if (((DownloadTask) ZeusTransformUtils.preCheckCast(this.h.getFirst(), DownloadTask.class, "com.obric.memorydata.plugin")).getDownloadId() == r5.getDownloadId()) goto L21;
    L23:
        Iterator<DownloadTask> r2 = this.h.iterator();     // Catch: InterruptedException -> L40
    L25:
        if (r2.hasNext() == false) goto L14;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(r2.next(), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L40
        if (r3 == null) goto L25;
        if (r3.getDownloadId() != r5.getDownloadId()) goto L25;
        r2.remove();     // Catch: InterruptedException -> L40
        goto L14
    L21:
        if (a(r5.getDownloadId()) == false) goto L23;
        return;
    }

    private synchronized DownloadInfo m(int r4) {
        monitor-enter(this);
        DownloadInfo r0 = this.i.b(r4);     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5 == null) goto L8;
        r0 = r5.getDownloadInfo();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized boolean n(int r5) {
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L41
    L6:
        DownloadInfo r0 = this.i.b(r5);     // Catch: Throwable -> L41
        if (r0 != null) goto L10;
    L13:
        SparseArray<DownloadTask> r2 = this.f15460b;     // Catch: Throwable -> L41
        monitor-enter(r2);     // Catch: Throwable -> L41
        b(r5);     // Catch: Throwable -> L38
        monitor-exit(r2);     // Catch: Throwable -> L38
    L18:
        if (r0 != null) goto L25;
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (r6 == null) goto L36;
        new com.ss.android.socialbase.downloader.downloader.e(r6, this.f15459a).e();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L36:
        monitor-exit(this);
        return false;
    L25:
        if (r0.getStatus() != 1) goto L32;
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        if (r7 == null) goto L36;
        new com.ss.android.socialbase.downloader.downloader.e(r7, this.f15459a).e();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L32:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L36;
        r0.setStatus(-2);     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L10:
        if (r0.getStatus() != 11) goto L13;
        monitor-exit(this);
        return false;
    }

    private DownloadTask o(int r4) {
        if (this.j == false) goto L5;
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.c.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L14;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r0;
    L16:
        th = move-exception;
        throw th;
    L5:
        return p(r4);
    }

    private DownloadTask p(int r4) {
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L11;
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.c.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        return r2;
    L9:
        return (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");
    L11:
        return r1;
    L10:
        return r0;
    }

    private void q(int r4) {
        if (this.h.isEmpty() == false) goto L5;
        return;
    L5:
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.h.getFirst(), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        if (r0.getDownloadId() != r4) goto L11;
        this.h.poll();
    L11:
        if (this.h.isEmpty() == false) goto L13;
        return;
    L13:
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.h.getFirst(), DownloadTask.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L17;
        d(r5);
        return;
    }

    public DownloadTask a(int r3, int r4) {
        monitor-enter(this);
        if (r4 != 0) goto L6;
        Object r5 = ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
    L5:
        DownloadTask r6 = (DownloadTask) r5;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return r6;
    L6:
        SparseArray r7 = (SparseArray) ZeusTransformUtils.preCheckCast(this.f.get(r3), SparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (r7 == null) goto L9;
        r5 = ZeusTransformUtils.preCheckCast(r7.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        goto L5
    L9:
        r6 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public abstract List<Integer> a();

    public List<DownloadInfo> a(String r7) {
        if (this.j == true) goto L7;
        return c(r7);
    L7:
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return null;
    L10:
        List<DownloadInfo> r0 = this.i.a(r7);
        if (r0 != null) goto L13;
    L16:
        monitor-enter(this);
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L29
        int r2 = this.f15460b.size();     // Catch: Throwable -> L29
        int r3 = 0;
    L18:
        if (r3 >= r2) goto L27;
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.valueAt(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r4 == null) goto L26;
        if (r4.getDownloadInfo() == null) goto L26;
        if (r7.equals(r4.getDownloadInfo().getUrl()) == false) goto L26;
        r1.add(r4.getDownloadInfo());     // Catch: Throwable -> L29
    L26:
        r3 = r3 + 1;     // Catch: Throwable -> L29
        goto L18
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return r1;
    L29:
        th = move-exception;
        throw th;
    L13:
        if (r0.isEmpty() == true) goto L16;
        return r0;
    }

    public abstract Future a(DownloadTask r1);

    public void a(int r3, int r4, int r5) {
        if (r5 != (-7)) goto L5;
    L48:
        monitor-enter(this);
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L58
        if (r6 != null) goto L52;
    L55:
        q(r3);     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L52:
        if (this.d.get(r3) != null) goto L54;
        this.d.put(r3, r6);     // Catch: Throwable -> L58
    L54:
        b(r3, r4);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    L5:
        if (r5 != (-6)) goto L7;
        monitor-enter(this);
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        this.c.put(r3, r7);     // Catch: Throwable -> L45
        b(r3, r4);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        throw th;
    L7:
        if (r5 != (-4)) goto L9;
        monitor-enter(this);
        b(r3, r4);     // Catch: Throwable -> L38
        q(r3);     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L9:
        if (r5 != (-3)) goto L11;
        monitor-enter(this);
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        this.c.put(r3, r8);     // Catch: Throwable -> L31
        b(r3, r4);     // Catch: Throwable -> L31
        q(r3);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L11:
        if (r5 == (-1)) goto L48;
        if (r5 != 8) goto L75;
        monitor-enter(this);
        DownloadTask r9 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r9 != null) goto L19;
    L21:
        q(r3);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L19:
        if (this.e.get(r3) != null) goto L21;
        this.e.put(r3, r9);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void a(int r3, int r4, IDownloadListener r5, ListenerType r6, boolean r7) {
        monitor-enter(this);
        IDownloadListener r8 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r5, IDownloadListener.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        DownloadTask r0 = o(r3);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r3)), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L6:
        if (r0 == null) goto L8;
        r0.removeDownloadListener(r4, r8, r6, r7);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void a(int r8, int r9, IDownloadListener r10, final ListenerType r11, boolean r12, boolean r13) {
        final IDownloadListener r14 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.memorydata.plugin");
        if (this.j == true) goto L6;
        b(r8, r9, r14, r11, r12, r13);
        return;
    L6:
        monitor-enter(this);
        final DownloadTask r5 = o(r8);     // Catch: Throwable -> L42
        if (r5 == null) goto L27;
        r5.addDownloadListener(r9, r14, r11, r12);     // Catch: Throwable -> L42
        final DownloadInfo r4 = r5.getDownloadInfo();     // Catch: Throwable -> L42
        if (r13 == false) goto L25;
        if (r4 == null) goto L25;
        if (a(r8) == true) goto L25;
        if (r11 != ListenerType.MAIN) goto L17;
    L18:
        boolean r15 = true;
        if (r11 == ListenerType.NOTIFICATION) goto L21;
    L23:
        if (r15 == false) goto L25;
        final int r3 = r4.getStatus();     // Catch: Throwable -> L42
        this.f15459a.post(new AnonymousClass7(this, r14, r3, r4, r5, r11));     // Catch: Throwable -> L42
        goto L25
    L21:
        if (r4.canShowNotification() == true) goto L23;
        r15 = false;
        goto L23
    L17:
        if (r11 == ListenerType.NOTIFICATION) goto L18;
    L25:
        monitor-exit(this);     // Catch: Throwable -> L42
        return;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L42
        DownloadInfo r16 = this.i.b(r8);
        monitor-enter(this);
        if (r16 != null) goto L45;
    L37:
        monitor-exit(this);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    L45:
        if (r16.getStatus() == (-3)) goto L37;
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r8)), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
        if (r0 != null) goto L36;
        r0 = new DownloadTask(r16);     // Catch: Throwable -> L39
        this.g.put(Integer.valueOf(r8), r0);     // Catch: Throwable -> L39
    L36:
        r0.addDownloadListener(r9, r14, r11, r12);     // Catch: Throwable -> L39
    L42:
        th = move-exception;
        throw th;
    }

    public abstract void a(int r1, long r2, int r4);

    public synchronized void a(int r3, aa r4) {
        monitor-enter(this);
        aa r5 = (aa) ZeusTransformUtils.wrapperContextForParams(r4, aa.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r6 == null) goto L6;
        r6.setNotificationEventListener(r5);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(final int r4, final boolean r5, final boolean r6) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r4, "clearDownloadData", "DeleteFile:" + r5 + " deleteFileIgnoreSecurity:" + r6 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.f15459a.post(new AnonymousClass3(this, r4));
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass4(this, r4, r5, r6), false);
    }

    @Override // com.ss.android.socialbase.downloader.h.f.a
    public void a(Message r8) {
        int r0 = r8.arg1;
        int r1 = r8.arg2;
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r0, "handleMsg", "Listener hashCode: " + r1);
    L5:
        DownloadTask r3 = null;
        if (ZeusTransformUtils.instanceOf(r8.obj, Exception.class) == false) goto L8;
        BaseException r2 = (BaseException) ZeusTransformUtils.preCheckCast(r8.obj, BaseException.class, "com.obric.memorydata.plugin");
    L9:
        monitor-enter(this);
        if (r1 != 0) goto L13;
        Object r4 = ZeusTransformUtils.preCheckCast(this.f15460b.get(r0), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L12:
        r3 = (DownloadTask) r4;     // Catch: Throwable -> L22
    L16:
        if (r3 != null) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L19:
        a(r8.what, r2, r3);     // Catch: Throwable -> L22
        a(r0, r1, r8.what);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L13:
        SparseArray r5 = (SparseArray) ZeusTransformUtils.preCheckCast(this.f.get(r0), SparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r5 == null) goto L16;
        r4 = ZeusTransformUtils.preCheckCast(r5.get(r1), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L8:
        r2 = null;
        goto L9
    }

    public abstract void a(com.ss.android.socialbase.downloader.b.c r1);

    public synchronized void a(List<String> r8) {
        monitor-enter(this);
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        boolean r0 = com.ss.android.socialbase.downloader.utils.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L28 Throwable -> L32
        int r2 = 0;
    L5:
        if (r2 >= this.d.size()) goto L30;
        DownloadTask r3 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(this.d.keyAt(r2)), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L28 Throwable -> L32
        if (r3 == null) goto L27;
        DownloadInfo r4 = r3.getDownloadInfo();     // Catch: Exception -> L28 Throwable -> L32
        if (r4 == null) goto L27;
        if (r4.isOnlyWifi() == false) goto L17;
        if (r0 == false) goto L27;
    L17:
        if (com.ss.android.socialbase.downloader.g.a.a(r4.getId()).a("auto_resume", 0) != 1) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L22;
    L26:
        r4.setAutoResumed(true);     // Catch: Exception -> L28 Throwable -> L32
        r4.setShowNotificationForNetworkResumed(true);     // Catch: Exception -> L28 Throwable -> L32
        b(r3);     // Catch: Exception -> L28 Throwable -> L32
        goto L27
    L22:
        if (r4.getMimeType() == null) goto L27;
        if (r9.contains(r4.getMimeType()) == true) goto L26;
    L19:
        r5 = false;
    L27:
        r2 = r2 + 1;
    L30:
        monitor-exit(this);
        return;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    public abstract boolean a(int r1);

    public boolean a(int r10, boolean r11) {
        if (this.j == true) goto L7;
        return c(r10, r11);
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r10, ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        final DownloadTask r7 = o(r10);
        if (r7 == null) goto L15;
        final DownloadInfo r6 = r7.getDownloadInfo();
        if (r6 == null) goto L14;
        r6.setStatus(-4);
    L14:
        final Map<Integer, IDownloadListener> r5 = r7.getDownloadListeners(ListenerType.MAIN);
        final Map<Integer, IDownloadListener> r8 = r7.getDownloadListeners(ListenerType.NOTIFICATION);
        this.f15459a.post(new AnonymousClass1(this, r5, r6, r7, r8));
    L15:
        DownloadInfo r1 = this.i.b(r10);
        if (r1 == null) goto L18;
        r1.setStatus(-4);
    L18:
        a(r10, r11, false);
        return true;
    }

    public List<DownloadInfo> b(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        return null;
    L6:
        Iterator<Integer> r0 = a().iterator();
        ArrayList r1 = new ArrayList();
    L8:
        if (r0.hasNext() == false) goto L14;
        DownloadInfo r2 = d(((Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        if (r2 == null) goto L8;
        if (r6.equals(r2.getMimeType()) == false) goto L8;
        r1.add(r2);
        goto L8
    L14:
        return r1;
    }

    public void b() {
        List<Integer> r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<Integer> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        e(((Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    }

    public abstract void b(int r1);

    public void b(int r8, int r9, IDownloadListener r10, ListenerType r11, boolean r12) {
        a(r8, r9, (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r10, IDownloadListener.class, "com.obric.memorydata.plugin"), r11, r12, true);
    }

    public void b(int r2, long r3, int r5) {
        DownloadInfo r0 = this.i.b(r2);
        if (r0 == null) goto L5;
        r0.setThrottleNetSpeed(r3, r5);
    L5:
        a(r2, r3, r5);
    }

    public void b(final int r4, final boolean r5) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r4, "resetDownloadData", "DeleteFile:" + r5 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.f15459a.post(new AnonymousClass5(this, r4));
        com.ss.android.socialbase.downloader.downloader.b.a(new AnonymousClass6(this, r4, r5), false);
    }

    public void b(int r5, boolean r6, boolean r7) {
        if (this.j == true) goto L7;
        c(r5, r6, r7);
        return;
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L42;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "clearDownloadDataInSubThread", "DeleteFile:" + r6 + " deleteFileIgnoreSecurity:" + r7);
    L42:
        DownloadInfo r0 = this.i.b(r5);     // Catch: Throwable -> L35
        if (r0 == null) goto L38;
        if (r6 == false) goto L15;
        if (r7 == false) goto L14;
        new com.ss.android.socialbase.downloader.d.a(r0.getSavePath(), r0.getName(), false, false).delete();     // Catch: Throwable -> L35
    L14:
        com.ss.android.socialbase.downloader.utils.g.b(r0, r6);     // Catch: Throwable -> L35
    L16:
        r0.erase();     // Catch: Throwable -> L35
        goto L38
    L15:
        com.ss.android.socialbase.downloader.utils.g.e(r0.getTempPath(), r0.getTempName());     // Catch: Throwable -> L35
    L38:
        this.i.d(r5);     // Catch: SQLiteException -> L19 Throwable -> L35
    L21:
        monitor-enter(this);     // Catch: Throwable -> L35
        a(r5, 0, -4);     // Catch: Throwable -> L32
        if (this.d.get(r5) == null) goto L27;
        this.d.remove(r5);     // Catch: Throwable -> L32
    L27:
        if (this.c.get(r5) == null) goto L29;
        this.c.remove(r5);     // Catch: Throwable -> L32
    L29:
        this.g.remove(Integer.valueOf(r5));     // Catch: Throwable -> L32
        com.ss.android.socialbase.downloader.g.a.b(r5);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
    L44:
        return;
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.printStackTrace();
    }

    public synchronized void b(DownloadTask r3) {
        monitor-enter(this);
        if (r3 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        DownloadInfo r0 = r3.getDownloadInfo();     // Catch: Throwable -> L17
        if (r0 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        r0.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
        if (r0.getEnqueueType() == EnqueueType.ENQUEUE_NONE) goto L14;
        e(r3);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        d(r3);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void b(List<String> r6) {
        monitor-enter(this);
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);
        return;
    L5:
        if (com.ss.android.socialbase.downloader.utils.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= this.f15460b.size()) goto L29;
        int r1 = this.f15460b.keyAt(r0);     // Catch: Exception -> L27 Throwable -> L31
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r1), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27 Throwable -> L31
        if (r2 == null) goto L26;
        DownloadInfo r3 = r2.getDownloadInfo();     // Catch: Exception -> L27 Throwable -> L31
        if (r3 == null) goto L26;
        if (r3.getMimeType() == null) goto L26;
        if (r7.contains(r3.getMimeType()) == false) goto L26;
        if (a(r3) == false) goto L26;
        r3.setAutoResumed(true);     // Catch: Exception -> L27 Throwable -> L31
        r3.setShowNotificationForNetworkResumed(true);     // Catch: Exception -> L27 Throwable -> L31
        b(r2);     // Catch: Exception -> L27 Throwable -> L31
        r3.setDownloadFromReserveWifi(true);     // Catch: Exception -> L27 Throwable -> L31
        q r4 = Downloader.getInstance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getReserveWifiStatusListener();     // Catch: Exception -> L27 Throwable -> L31
        if (r4 == null) goto L26;
        r4.a(r3, 5, 2);     // Catch: Exception -> L27 Throwable -> L31
    L26:
        r0 = r0 + 1;
    L31:
        th = move-exception;
        throw th;
    }

    public abstract com.ss.android.socialbase.downloader.b.c c(int r1);

    public DownloadInfo d(int r4) {
        if (this.j == false) goto L5;
        DownloadInfo r0 = this.i.b(r4);
        if (r0 != null) goto L17;
        monitor-enter(this);
        DownloadTask r5 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r0 = r5.getDownloadInfo();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        return r0;
    L5:
        return m(r4);
    }

    public boolean e(int r5) {
        if (this.j == true) goto L7;
        return n(r5);
    L7:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L9;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        DownloadInfo r0 = this.i.b(r5);
        if (r0 != null) goto L12;
    L14:
        b(r5);
        monitor-enter(this);
        if (r0 != null) goto L24;
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r6 == null) goto L35;
        new com.ss.android.socialbase.downloader.downloader.e(r6, this.f15459a).e();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L35:
        monitor-exit(this);     // Catch: Throwable -> L37
        return false;
    L24:
        if (r0.getStatus() != 1) goto L31;
        DownloadTask r7 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        if (r7 == null) goto L35;
        new com.ss.android.socialbase.downloader.downloader.e(r7, this.f15459a).e();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L31:
        if (DownloadStatus.isDownloading(r0.getStatus()) == false) goto L35;
        r0.setStatus(-2);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L37:
        th = move-exception;
        throw th;
    L12:
        if (r0.getStatus() != 11) goto L14;
        return false;
    }

    public synchronized boolean f(int r5) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r0 == null) goto L12;
        DownloadInfo r6 = r0.getDownloadInfo();     // Catch: Throwable -> L16
        if (r6 == null) goto L11;
        r6.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L16
    L11:
        b(r0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return true;
    L12:
        g(r5);     // Catch: Throwable -> L16
        goto L14
    }

    public synchronized boolean g(int r5) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a("AbsDownloadEngine", r5, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L17
    L6:
        DownloadTask r6 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r5), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r6 == null) goto L15;
        DownloadInfo r1 = r6.getDownloadInfo();     // Catch: Throwable -> L17
        if (r1 == null) goto L11;
        r1.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
    L11:
        b(r6);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L15:
        monitor-exit(this);
        return false;
    }

    public synchronized ah h(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        ah r5 = r0.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.c.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        ah r6 = r1.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        ah r7 = r2.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        ah r9 = r8.getNotificationClickCallback();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized aa i(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        aa r5 = r0.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.c.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        aa r6 = r1.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        aa r7 = r2.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        aa r9 = r8.getNotificationEventListener();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized t j(int r4) {
        monitor-enter(this);
        DownloadTask r0 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.f15460b.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r0 == null) goto L8;
        t r5 = r0.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r5;
    L8:
        DownloadTask r1 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.c.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L13;
        t r6 = r1.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r6;
    L13:
        DownloadTask r2 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.d.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L18;
        t r7 = r2.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r7;
    L18:
        DownloadTask r8 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r4), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        t r9 = r8.getFileUriProvider();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r9;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized boolean k(int r3) {
        monitor-enter(this);
        DownloadTask r4 = (DownloadTask) ZeusTransformUtils.preCheckCast(this.e.get(r3), DownloadTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r4 == null) goto L13;
        DownloadInfo r0 = r4.getDownloadInfo();     // Catch: Throwable -> L14
        if (r0 == null) goto L13;
        if (r0.canReStartAsyncTask() == false) goto L10;
        b(r4);     // Catch: Throwable -> L14
    L10:
        boolean r5 = true;
    L11:
        monitor-exit(this);
        return r5;
    L13:
        r5 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized boolean l(int r2) {
        monitor-enter(this);
        if (r2 != 0) goto L15;
    L12:
        boolean r3 = false;
    L13:
        monitor-exit(this);
        return r3;
    L15:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f15460b.get(r2) != null) goto L8;
        if (this.d.get(r2) == null) goto L12;
    L8:
        r3 = true;
        goto L13
    }
}
