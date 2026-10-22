package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.lynx.jsbridge.a;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadEngine implements WeakDownloadHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f15620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray f15621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray f15622c;
    public final SparseArray d;
    public final SparseArray e;
    public final LruCache f;
    public final LinkedBlockingDeque g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final IDownloadCache f15623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f15625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakDownloadHandler f15626k;

    public AbsDownloadEngine() {
        this.f15620a = new SparseArray();
        this.f15621b = new SparseArray();
        this.f15622c = new SparseArray();
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.f = new LruCache(4, 4);
        this.g = new LinkedBlockingDeque();
        this.f15626k = new WeakDownloadHandler(Looper.getMainLooper(), this);
        this.f15623h = DownloadComponentManager.h();
        DownloadSetting r5 = DownloadSetting.f;
        boolean r10 = false;
        if (r5.a("fix_anr_isolate_engine_and_cache", 0) <= 0) goto L5;
        r10 = true;
    L5:
        this.f15624i = r10;
        this.f15625j = r5.b("fix_callback_deadlock");
    }

    public abstract DownloadRunnable a(int r5);

    public abstract ArrayList a();

    public List a(String r10) {
        if (this.f15624i == true) goto L7;
        return b(r10);
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        List r5 = this.f15623h.c(r10);
        if (r5 != null) goto L13;
    L16:
        monitor-enter(this);
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L26
        int r12 = this.f15620a.size();     // Catch: Throwable -> L26
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L29;
        DownloadTask r14 = (DownloadTask) this.f15620a.valueAt(r13);     // Catch: Throwable -> L26
        if (r14 == null) goto L28;
        DownloadInfo r15 = r14.f15878a;     // Catch: Throwable -> L26
        if (r15 == null) goto L28;
        if (r10.equals(r15.d) == false) goto L28;
        r11.add(r14.f15878a);     // Catch: Throwable -> L26
    L28:
        r13 = r13 + 1;     // Catch: Throwable -> L26
        goto L18
    L29:
        monitor-exit(this);     // Catch: Throwable -> L26
        return r11;
    L26:
        th = move-exception;
        throw th;
    L13:
        if (r5.isEmpty() == true) goto L16;
        return r5;
    }

    public abstract Future a(DownloadTask r5);

    public abstract void a(int r5, long r10, int r11);

    public abstract void a(DownloadRunnable r5);

    public abstract void b(int r5);

    public synchronized void b(DownloadTask r5) {
        monitor-enter(this);
        if (r5 != null) goto L59;
    L50:
        monitor-exit(this);
        return;
    L59:
        DownloadInfo r10 = r5.f15878a;     // Catch: Throwable -> L15
        if (r10 == null) goto L50;
        r10.W0 = false;     // Catch: Throwable -> L15
        if (r10.f15850z0 != EnqueueType.f15277a) goto L11;
        c(r5);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L11:
        if (PluginDownloadEngine.a(r10) == false) goto L58;
        PluginDownloadEngine r11 = PluginDownloadEngine.a();     // Catch: Throwable -> L15
        r11.f15729c.execute(new PluginDownloadEngine.AnonymousClass5(r11, r5));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L58:
        if (this.g.isEmpty() == false) goto L23;
        c(r5);     // Catch: Throwable -> L15 InterruptedException -> L57
        this.g.put(r5);     // Catch: Throwable -> L15 InterruptedException -> L57
        monitor-exit(this);
        return;
    L23:
        if (r10.f15850z0 == EnqueueType.f15279c) goto L25;
        DownloadTask r12 = (DownloadTask) this.g.getFirst();     // Catch: Throwable -> L15 InterruptedException -> L57
        if (r12.e() == r5.e()) goto L43;
    L45:
        k(r12.e());     // Catch: Throwable -> L15 InterruptedException -> L57
        c(r5);     // Catch: Throwable -> L15 InterruptedException -> L57
        if (r12.e() == r5.e()) goto L50;
        this.g.putFirst(r5);     // Catch: Throwable -> L15 InterruptedException -> L57
        monitor-exit(this);
        return;
    L43:
        if (i(r5.e()) == false) goto L45;
    L25:
        if (((DownloadTask) this.g.getFirst()).e() == r5.e()) goto L27;
    L29:
        Iterator r13 = this.g.iterator();     // Catch: Throwable -> L15 InterruptedException -> L57
    L31:
        if (r13.hasNext() == false) goto L37;
        DownloadTask r14 = (DownloadTask) r13.next();     // Catch: Throwable -> L15 InterruptedException -> L57
        if (r14 == null) goto L31;
        if (r14.e() != r5.e()) goto L31;
        r13.remove();     // Catch: Throwable -> L15 InterruptedException -> L57
    L37:
        this.g.put(r5);     // Catch: Throwable -> L15 InterruptedException -> L57
        monitor-exit(this);
        return;
    L27:
        if (i(r5.e()) == false) goto L29;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(DownloadTask r13) {
        if (r13 == null) goto L94;
        DownloadInfo r5 = r13.f15878a;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.t() == false) goto L11;
        Logger.a("AbsDownloadEngine", r5.l(), "tryDownload", "entity invalid");
        DownloadMonitorHelper.a(r13.f15883j, r5, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is Invalid, url is " + r5.d + " name is " + r5.f15808b + " savePath is " + r5.e), r5.o());
        return;
    L11:
        r13.s.f15904c = System.currentTimeMillis();
        boolean r10 = true;
        DownloadComponentManager.a(r13, true);
        int r11 = 0;
        if (DownloadSetting.a(r5.l(), null).a("no_net_opt", 0) == 1) goto L14;
    L28:
        int r12 = r5.l();
        if (Logger.a(r5) == false) goto L32;
        Logger.a("AbsDownloadEngine", r5.l(), r5.P, "tryDownload", "Url: " + r5.d + " savePath: " + r5.e + " saveName: " + r5.f15808b, false);
    L32:
        if (this.f15622c.get(r12) == null) goto L35;
        this.f15622c.remove(r12);
    L35:
        if (this.f15621b.get(r12) == null) goto L38;
        this.f15621b.remove(r12);
    L38:
        if (this.d.get(r12) == null) goto L41;
        this.d.remove(r12);
    L41:
        if (i(r12) == false) goto L50;
        if (r5.a() == true) goto L50;
        if (Logger.a(r5) == false) goto L47;
        Logger.a("AbsDownloadEngine", r5.l(), r5.P, "tryDownload", "Another task with same id is downloading when tryDownload", false);
    L47:
        r13.a();
        DownloadMonitorHelper.a(r13.f15883j, r5, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is isDownloading and addListenerToSameTask is false"), r5.o());
        return;
    L50:
        if (Logger.a(r5) == false) goto L53;
        Logger.a("AbsDownloadEngine", r5.l(), r5.P, "tryDownload", "No downloading task", false);
    L53:
        if (r5.a() == false) goto L55;
        r5.H = AsyncHandleStatus.f15265c;
    L55:
        DownloadTask r14 = (DownloadTask) this.f.remove(Integer.valueOf(r12));
        if (r14 == null) goto L59;
        r13.a(r14);
    L59:
        if ("mime_type_plg".equals(r5.f15839u) == false) goto L61;
        r13.f15878a.a("executor_group", 3);
    L61:
        DownloadTask r15 = (DownloadTask) this.f15620a.get(r12);
        if (r15 == null) goto L69;
        DownloadInfo r16 = r15.f15878a;
        if (r16 == null) goto L69;
        int r17 = r16.o();
        if (DownloadStatus.a(r17) == false) goto L68;
    L67:
        r11 = r17;
    L71:
        if (Logger.a(r5) == false) goto L73;
        Logger.a("AbsDownloadEngine", r5.l(), r5.P, "tryDownload", "Can add listener " + r10 + " , oldTaskStatus is :" + r11, false);
    L73:
        if (r10 == false) goto L76;
        r13.a();
        return;
    L76:
        int r18 = r13.f15894v;
        if (r18 == 0) goto L79;
    L81:
        if (r18 == 0) goto L90;
        SparseArray r19 = (SparseArray) this.e.get(r13.e());
        if (r19 != null) goto L87;
        r19 = new SparseArray();
        this.e.put(r13.e(), r19);
    L87:
        if (Logger.a(r13.f15878a) == false) goto L89;
        Logger.a("AbsDownloadEngine", r13.f15878a, "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r18);
    L89:
        r19.put(r18, r13);
    L90:
        this.f15620a.put(r12, r13);
        a(r13);
        return;
    L79:
        if (r13.f15895w == false) goto L81;
        r18 = r13.c();
        goto L81
    L68:
        r10 = false;
    L69:
        r10 = false;
        goto L71
    L14:
        monitor-enter(DownloadComponentManager.class);
        Context r20 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L25
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L25
        if (DownloadUtils.b(r20) == true) goto L28;
        if (r5.w() == true) goto L28;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optBoolean("disable_check_no_network") == true) goto L28;
        new DownloadStatusHandler(r13, this.f15626k).a(new BaseException(1049, "network_not_available"));
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public DownloadInfo d(int r5) {
        if (this.f15624i == false) goto L5;
        DownloadInfo r10 = this.f15623h.a(r5);
        if (r10 != null) goto L18;
        monitor-enter(this);
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L12
        if (r11 == null) goto L14;
        r10 = r11.f15878a;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);     // Catch: Throwable -> L12
        return r10;
    L12:
        th = move-exception;
        throw th;
    L18:
        return r10;
    L5:
        return e(r5);
    }

    public final synchronized DownloadInfo e(int r5) {
        monitor-enter(this);
        DownloadInfo r10 = this.f15623h.a(r5);     // Catch: Throwable -> L10
        if (r10 != null) goto L12;
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        DownloadInfo r12 = r11.f15878a;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L12:
        monitor-exit(this);
        return r10;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized IDownloadNotificationEventListener f(int r5) {
        monitor-enter(this);
        DownloadTask r10 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        IDownloadNotificationEventListener r11 = r10.g;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        DownloadTask r12 = (DownloadTask) this.f15621b.get(r5);     // Catch: Throwable -> L8
        if (r12 == null) goto L15;
        IDownloadNotificationEventListener r13 = r12.g;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L15:
        DownloadTask r14 = (DownloadTask) this.f15622c.get(r5);     // Catch: Throwable -> L8
        if (r14 == null) goto L20;
        IDownloadNotificationEventListener r15 = r14.g;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r15;
    L20:
        DownloadTask r16 = (DownloadTask) this.d.get(r5);     // Catch: Throwable -> L8
        if (r16 == null) goto L25;
        IDownloadNotificationEventListener r17 = r16.g;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r17;
    L25:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public final DownloadTask g(int r5) {
        if (this.f15624i == true) goto L13;
        DownloadTask r10 = (DownloadTask) this.f15620a.get(r5);
        if (r10 != null) goto L12;
        r10 = (DownloadTask) this.f15622c.get(r5);
        if (r10 != null) goto L12;
        r10 = (DownloadTask) this.f15621b.get(r5);
        if (r10 != null) goto L12;
        return (DownloadTask) this.d.get(r5);
    L12:
        return r10;
    L13:
        monitor-enter(this);
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L21
        if (r11 != null) goto L23;
        r11 = (DownloadTask) this.f15622c.get(r5);     // Catch: Throwable -> L21
        if (r11 != null) goto L23;
        r11 = (DownloadTask) this.f15621b.get(r5);     // Catch: Throwable -> L21
        if (r11 != null) goto L23;
        r11 = (DownloadTask) this.d.get(r5);     // Catch: Throwable -> L21
    L23:
        monitor-exit(this);     // Catch: Throwable -> L21
        return r11;
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized INotificationClickCallback h(int r5) {
        monitor-enter(this);
        DownloadTask r10 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        INotificationClickCallback r11 = r10.f15887n;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        DownloadTask r12 = (DownloadTask) this.f15621b.get(r5);     // Catch: Throwable -> L8
        if (r12 == null) goto L15;
        INotificationClickCallback r13 = r12.f15887n;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L15:
        DownloadTask r14 = (DownloadTask) this.f15622c.get(r5);     // Catch: Throwable -> L8
        if (r14 == null) goto L20;
        INotificationClickCallback r15 = r14.f15887n;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r15;
    L20:
        DownloadTask r16 = (DownloadTask) this.d.get(r5);     // Catch: Throwable -> L8
        if (r16 == null) goto L25;
        INotificationClickCallback r17 = r16.f15887n;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r17;
    L25:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public abstract boolean i(int r5);

    public synchronized boolean j(int r5) {
        monitor-enter(this);
        if (r5 != 0) goto L19;
    L16:
        monitor-exit(this);
        return false;
    L19:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f15620a.get(r5) != null) goto L11;
        if (this.f15622c.get(r5) == null) goto L16;
    L11:
        monitor-exit(this);
        return true;
    }

    public void k(int r10) {
        if (this.f15624i == true) goto L7;
        l(r10);
        return;
    L7:
        if (Logger.b() == false) goto L9;
        Logger.a("AbsDownloadEngine", r10, null, "pause", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L9:
        DownloadInfo r5 = this.f15623h.a(r10);
        if (r5 != null) goto L12;
    L14:
        b(r10);
        monitor-enter(this);
        if (r5 != null) goto L25;
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L22
        if (r11 == null) goto L36;
        new DownloadStatusHandler(r11, this.f15626k).c();     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L25:
        if (r5.o() != 1) goto L32;
        DownloadTask r12 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L22
        if (r12 == null) goto L36;
        new DownloadStatusHandler(r12, this.f15626k).c();     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L32:
        if (DownloadStatus.a(r5.o()) == false) goto L36;
        r5.a(-2);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L12:
        if (r5.o() != 11) goto L14;
    }

    public final synchronized boolean l(int r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (Logger.b() == false) goto L8;
        Logger.a("AbsDownloadEngine", r10, null, "pause", "Trace:" + Log.getStackTraceString(new Throwable()), false);     // Catch: Throwable -> L6
    L8:
        DownloadInfo r5 = this.f15623h.a(r10);     // Catch: Throwable -> L6
        if (r5 != null) goto L12;
    L15:
        SparseArray r11 = this.f15620a;     // Catch: Throwable -> L6
        monitor-enter(r11);     // Catch: Throwable -> L6
        b(r10);     // Catch: Throwable -> L40
        monitor-exit(r11);     // Catch: Throwable -> L40
    L20:
        if (r5 != null) goto L27;
        DownloadTask r12 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L6
        if (r12 == null) goto L38;
        new DownloadStatusHandler(r12, this.f15626k).c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return true;
    L38:
        monitor-exit(this);
        return false;
    L27:
        if (r5.o() != 1) goto L34;
        DownloadTask r13 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L6
        if (r13 == null) goto L38;
        new DownloadStatusHandler(r13, this.f15626k).c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return true;
    L34:
        if (DownloadStatus.a(r5.o()) == false) goto L38;
        r5.a(-2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return true;
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L6
    L12:
        if (r5.o() != 11) goto L15;
        monitor-exit(this);
        return false;
    }

    public void m(final int r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("AbsDownloadEngine", r10, null, "resetDownloadData", "DeleteFile:trueTrace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        this.f15626k.post(new AnonymousClass5(r10));
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass6(this, r10));
    }

    public synchronized void n(int r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (Logger.b() == false) goto L8;
        Logger.a("AbsDownloadEngine", r10, null, "restart", "Trace:" + Log.getStackTraceString(new Throwable()), false);     // Catch: Throwable -> L6
    L8:
        DownloadTask r11 = (DownloadTask) this.f15622c.get(r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L16;
        DownloadInfo r5 = r11.f15878a;     // Catch: Throwable -> L6
        if (r5 == null) goto L13;
        r5.W0 = false;     // Catch: Throwable -> L6
    L13:
        b(r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L16:
        monitor-exit(this);
    }

    public synchronized void o(int r5) {
        monitor-enter(this);
        DownloadTask r10 = (DownloadTask) this.d.get(r5);     // Catch: Throwable -> L11
        if (r10 == null) goto L15;
        DownloadInfo r11 = r10.f15878a;     // Catch: Throwable -> L11
        if (r11 == null) goto L15;
        if (r11.a() == false) goto L13;
        b(r10);     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);
        return;
    L15:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized void p(int r10) {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (Logger.b() == false) goto L8;
        Logger.a("AbsDownloadEngine", r10, null, "resume", "Trace:" + Log.getStackTraceString(new Throwable()), false);     // Catch: Throwable -> L6
    L8:
        DownloadTask r5 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L6
        if (r5 == null) goto L14;
        DownloadInfo r11 = r5.f15878a;     // Catch: Throwable -> L6
        if (r11 == null) goto L13;
        r11.W0 = false;     // Catch: Throwable -> L6
    L13:
        b(r5);     // Catch: Throwable -> L6
    L15:
        monitor-exit(this);
        return;
    L14:
        n(r10);     // Catch: Throwable -> L6
        goto L15
    }

    public final void q(int r5) {
        if (this.g.isEmpty() == true) goto L18;
        DownloadTask r10 = (DownloadTask) this.g.getFirst();
        if (r10 == null) goto L11;
        if (r10.e() != r5) goto L11;
        this.g.poll();
    L11:
        if (this.g.isEmpty() == true) goto L19;
        DownloadTask r11 = (DownloadTask) this.g.getFirst();
        if (r11 == null) goto L17;
        c(r11);
        return;
    L17:
        return;
    L19:
        return;
    }

    public void a(int r12, boolean r13) {
        if (this.f15624i == true) goto L22;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (Logger.b() == false) goto L10;
        Logger.a("AbsDownloadEngine", r12, null, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()), false);     // Catch: Throwable -> L8
    L10:
        final DownloadTask r5 = g(r12);     // Catch: Throwable -> L8
        if (r5 == null) goto L13;
        final DownloadInfo r10 = r5.f15878a;     // Catch: Throwable -> L8
        final ConcurrentHashMap r11 = r5.a(ListenerType.f15280a);     // Catch: Throwable -> L8
        final ConcurrentHashMap r14 = r5.a(ListenerType.f15282c);     // Catch: Throwable -> L8
        this.f15626k.post(new AnonymousClass2(this, r11, r5, r10, r14));     // Catch: Throwable -> L8
    L13:
        DownloadInfo r15 = this.f15623h.a(r12);     // Catch: Throwable -> L8
        if (r15 == null) goto L16;
        r15.a(-4);     // Catch: Throwable -> L8
    L16:
        a(r12, r13, false);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L22:
        if (Logger.b() == false) goto L24;
        Logger.a("AbsDownloadEngine", r12, null, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L24:
        final DownloadTask r16 = g(r12);
        if (r16 == null) goto L30;
        final DownloadInfo r17 = r16.f15878a;
        if (r17 == null) goto L29;
        r17.a(-4);
    L29:
        final ConcurrentHashMap r18 = r16.a(ListenerType.f15280a);
        final ConcurrentHashMap r19 = r16.a(ListenerType.f15282c);
        this.f15626k.post(new AnonymousClass1(this, r18, r16, r17, r19));
    L30:
        DownloadInfo r20 = this.f15623h.a(r12);
        if (r20 == null) goto L33;
        r20.a(-4);
    L33:
        a(r12, r13, false);
    }

    public final synchronized List b(String r10) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        List r5 = this.f15623h.c(r10);     // Catch: Throwable -> L15
        if (r5 != null) goto L11;
    L17:
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L15
        int r12 = this.f15620a.size();     // Catch: Throwable -> L15
        int r13 = 0;
    L18:
        if (r13 >= r12) goto L27;
        DownloadTask r14 = (DownloadTask) this.f15620a.valueAt(r13);     // Catch: Throwable -> L15
        if (r14 == null) goto L26;
        DownloadInfo r15 = r14.f15878a;     // Catch: Throwable -> L15
        if (r15 == null) goto L26;
        if (r10.equals(r15.d) == false) goto L26;
        r11.add(r14.f15878a);     // Catch: Throwable -> L15
    L26:
        r13 = r13 + 1;
        goto L18
    L27:
        monitor-exit(this);
        return r11;
    L11:
        if (r5.isEmpty() == true) goto L17;
        monitor-exit(this);
        return r5;
    }

    public synchronized void b(ArrayList r10) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            monitor-enter(r6)
            android.content.Context r0 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.b()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            boolean r0 = com.ss.android.socialbase.downloader.utils.DownloadUtils.c(r0)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r0 != 0) goto Lc
            goto L6c
        Lc:
            r0 = 0
            r1 = r0
        Le:
            android.util.SparseArray r2 = r6.f15620a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r1 >= r2) goto L6c
            android.util.SparseArray r2 = r6.f15620a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            int r2 = r2.keyAt(r1)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            android.util.SparseArray r3 = r6.f15620a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            com.ss.android.socialbase.downloader.model.DownloadTask r2 = (com.ss.android.socialbase.downloader.model.DownloadTask) r2     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r2 != 0) goto L27
            goto L66
        L27:
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r2.f15878a     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r3 == 0) goto L66
            java.lang.String r4 = r3.f15839u     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r4 == 0) goto L66
            boolean r4 = r7.contains(r4)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r4 == 0) goto L66
            int r4 = r3.n()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r5 = -2
            if (r4 == r5) goto L4a
            int r4 = r3.n()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r5 = -5
            if (r4 != r5) goto L44
            goto L4a
        L44:
            r4 = r0
            goto L4e
        L46:
            r7 = move-exception
            goto L6e
        L48:
            r7 = move-exception
            goto L69
        L4a:
            boolean r4 = r3.x()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L4e:
            if (r4 != 0) goto L51
            goto L66
        L51:
            r4 = 1
            r3.f15840u0 = r4     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r3.f15844w0 = r4     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r6.b(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r3.W0 = r4     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            android.content.Context r2 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.b()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            com.ss.android.socialbase.downloader.downloader.Downloader r2 = com.ss.android.socialbase.downloader.downloader.Downloader.b(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r2.a()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L66:
            int r1 = r1 + 1
            goto Le
        L69:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L46
        L6c:
            monitor-exit(r6)
            return
        L6e:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L46
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.AbsDownloadEngine.b(java.util.ArrayList):void");
    }

    public synchronized void a(int r5, IDownloadNotificationEventListener r10) {
        monitor-enter(this);
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        r11.g = r10;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void a(ArrayList r10) {
        monitor-enter(this);
        boolean r5 = DownloadUtils.c(DownloadComponentManager.b());     // Catch: Throwable -> L25 Exception -> L27
        int r11 = 0;
    L4:
        if (r11 >= this.f15622c.size()) goto L31;
        DownloadTask r12 = (DownloadTask) this.f15622c.get(this.f15622c.keyAt(r11));     // Catch: Throwable -> L25 Exception -> L27
        if (r12 == null) goto L29;
        DownloadInfo r13 = r12.f15878a;     // Catch: Throwable -> L25 Exception -> L27
        if (r13 == null) goto L29;
        if (r13.g == false) goto L16;
        if (r5 == false) goto L29;
    L16:
        if (DownloadSetting.a(r13.l(), null).a("auto_resume", 0) == 1) goto L23;
        String r14 = r13.f15839u;     // Catch: Throwable -> L25 Exception -> L27
        if (r14 == null) goto L29;
        if (r10.contains(r14) == false) goto L29;
    L23:
        r13.f15840u0 = true;     // Catch: Throwable -> L25 Exception -> L27
        r13.f15844w0 = true;     // Catch: Throwable -> L25 Exception -> L27
        b(r12);     // Catch: Throwable -> L25 Exception -> L27
    L29:
        r11 = r11 + 1;
    L31:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    L27:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L25
        goto L31
    }

    public void b() {
        Iterator r5 = a().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        k(((Integer) r5.next()).intValue());
        goto L4
    }

    public final synchronized void b(int r10, boolean r11, boolean r12) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (Logger.b() == false) goto L36;
        Logger.a("AbsDownloadEngine", r10, null, "clearDownloadDataInSubThread", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12, false);     // Catch: Throwable -> L7
    L36:
        DownloadInfo r5 = this.f15623h.a(r10);     // Catch: Throwable -> L14
        if (r5 == null) goto L40;
        if (r11 == false) goto L17;
        if (r12 == false) goto L16;
        new DownloadFile(r5.e, r5.f15808b, false).m();     // Catch: Throwable -> L14
    L16:
        DownloadUtils.b(r5, r11);     // Catch: Throwable -> L14
    L18:
        r5.f();     // Catch: Throwable -> L14
        goto L40
    L17:
        DownloadUtils.a(r5.q(), r5.p());     // Catch: Throwable -> L14
    L40:
        this.f15623h.d(r10);     // Catch: Throwable -> L14 SQLiteException -> L21
    L23:
        a(r10, 0, -4);     // Catch: Throwable -> L14
        if (this.f15622c.get(r10) == null) goto L27;
        this.f15622c.remove(r10);     // Catch: Throwable -> L14
    L27:
        if (this.f15621b.get(r10) == null) goto L29;
        this.f15621b.remove(r10);     // Catch: Throwable -> L14
    L29:
        this.f.remove(Integer.valueOf(r10));     // Catch: Throwable -> L14
        DownloadSetting.a(r10);     // Catch: Throwable -> L14
    L32:
        monitor-exit(this);
        return;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L7
        goto L32
    }

    public void a(final int r10, final boolean r11, final boolean r12) {
        if (Logger.b() == false) goto L5;
        Logger.a("AbsDownloadEngine", r10, null, "clearDownloadData", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12 + "Trace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        this.f15626k.post(new AnonymousClass3(r10));
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass4(this, r10, r11, r12));
    }

    public void a(int r10, int r11, IDownloadListener r12, ListenerType r13, boolean r14) {
        a(r10, r11, r12, r13, r14, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int r10, int r11, final IDownloadListener r12, final ListenerType r13, boolean r14, boolean r15) {
        if (this.f15624i == true) goto L6;
        b(r10, r11, r12, r13, r14, r15);
        return;
    L6:
        monitor-enter(this);
        final DownloadTask r5 = g(r10);     // Catch: Throwable -> L19
        if (r5 == null) goto L29;
        r5.a(r11, r12, r13, r14);     // Catch: Throwable -> L19
        final DownloadInfo r16 = r5.f15878a;     // Catch: Throwable -> L19
        if (r15 == false) goto L27;
        if (r16 == null) goto L27;
        if (i(r10) == true) goto L27;
        if (r13 == ListenerType.f15280a) goto L22;
        if (r13 != ListenerType.f15282c) goto L27;
    L22:
        if (r13 == ListenerType.f15282c) goto L24;
    L26:
        final int r17 = r16.o();     // Catch: Throwable -> L19
        this.f15626k.post(new AnonymousClass7(r12, r17, r16, r5, r13));     // Catch: Throwable -> L19
        goto L27
    L24:
        if (r16.b() == true) goto L26;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L29:
        monitor-exit(this);     // Catch: Throwable -> L19
        DownloadInfo r18 = this.f15623h.a(r10);
        monitor-enter(this);
        if (r18 != null) goto L47;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L47:
        if (r18.o() == (-3)) goto L41;
        DownloadTask r19 = (DownloadTask) this.f.get(Integer.valueOf(r10));     // Catch: Throwable -> L38
        if (r19 != null) goto L40;
        r19 = new DownloadTask();     // Catch: Throwable -> L38
        r19.f15878a = r18;     // Catch: Throwable -> L38
        this.f.put(Integer.valueOf(r10), r19);     // Catch: Throwable -> L38
    L40:
        r19.a(r11, r12, r13, r14);     // Catch: Throwable -> L38
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void b(int r5, int r10, IDownloadListener r11, ListenerType r12, boolean r13) {
        monitor-enter(this);
        DownloadTask r14 = g(r5);     // Catch: Throwable -> L6
        if (r14 != null) goto L8;
        r14 = (DownloadTask) this.f.get(Integer.valueOf(r5));     // Catch: Throwable -> L6
    L8:
        if (r14 == null) goto L12;
        r14.b(r10, r11, r12, r13);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L12:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void b(int r5, int r10, final IDownloadListener r11, final ListenerType r12, boolean r13, boolean r14) {
        monitor-enter(this);
        final DownloadTask r15 = g(r5);     // Catch: Throwable -> L15
        if (r15 == null) goto L25;
        r15.a(r10, r11, r12, r13);     // Catch: Throwable -> L15
        final DownloadInfo r16 = r15.f15878a;     // Catch: Throwable -> L15
        if (r14 == false) goto L35;
        if (r16 == null) goto L35;
        if (i(r5) == true) goto L35;
        if (r12 == ListenerType.f15280a) goto L18;
        if (r12 != ListenerType.f15282c) goto L35;
    L18:
        if (r12 == ListenerType.f15282c) goto L20;
    L22:
        this.f15626k.post(new AnonymousClass8(r11, r16, r15, r12));     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L20:
        if (r16.b() == true) goto L22;
    L35:
        monitor-exit(this);
        return;
    L25:
        DownloadInfo r17 = this.f15623h.a(r5);     // Catch: Throwable -> L15
        if (r17 == null) goto L35;
        if (r17.o() == (-3)) goto L35;
        DownloadTask r18 = (DownloadTask) this.f.get(Integer.valueOf(r5));     // Catch: Throwable -> L15
        if (r18 != null) goto L32;
        r18 = new DownloadTask();     // Catch: Throwable -> L15
        r18.f15878a = r17;     // Catch: Throwable -> L15
        this.f.put(Integer.valueOf(r5), r18);     // Catch: Throwable -> L15
    L32:
        r18.a(r10, r11, r12, r13);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized IDownloadFileUriProvider c(int r5) {
        monitor-enter(this);
        DownloadTask r10 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L8
        if (r10 == null) goto L10;
        IDownloadFileUriProvider r11 = r10.f15889p;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    L10:
        DownloadTask r12 = (DownloadTask) this.f15621b.get(r5);     // Catch: Throwable -> L8
        if (r12 == null) goto L15;
        IDownloadFileUriProvider r13 = r12.f15889p;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r13;
    L15:
        DownloadTask r14 = (DownloadTask) this.f15622c.get(r5);     // Catch: Throwable -> L8
        if (r14 == null) goto L20;
        IDownloadFileUriProvider r15 = r14.f15889p;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r15;
    L20:
        DownloadTask r16 = (DownloadTask) this.d.get(r5);     // Catch: Throwable -> L8
        if (r16 == null) goto L25;
        IDownloadFileUriProvider r17 = r16.f15889p;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r17;
    L25:
        monitor-exit(this);
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public void a(int r5, int r10, int r11) {
        if (r11 != (-7)) goto L5;
    L49:
        monitor-enter(this);
        DownloadTask r12 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L55
        if (r12 != null) goto L53;
    L58:
        q(r5);     // Catch: Throwable -> L55
        monitor-exit(this);     // Catch: Throwable -> L55
        return;
    L53:
        if (this.f15622c.get(r5) != null) goto L57;
        this.f15622c.put(r5, r12);     // Catch: Throwable -> L55
    L57:
        b(r5, r10);     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        throw th;
    L5:
        if (r11 != (-6)) goto L7;
        monitor-enter(this);
        DownloadTask r13 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L46
        this.f15621b.put(r5, r13);     // Catch: Throwable -> L46
        b(r5, r10);     // Catch: Throwable -> L46
        monitor-exit(this);     // Catch: Throwable -> L46
        return;
    L46:
        th = move-exception;
        throw th;
    L7:
        if (r11 != (-4)) goto L9;
        monitor-enter(this);
        b(r5, r10);     // Catch: Throwable -> L39
        q(r5);     // Catch: Throwable -> L39
        monitor-exit(this);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    L9:
        if (r11 != (-3)) goto L11;
        monitor-enter(this);
        DownloadTask r14 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L32
        this.f15621b.put(r5, r14);     // Catch: Throwable -> L32
        b(r5, r10);     // Catch: Throwable -> L32
        q(r5);     // Catch: Throwable -> L32
        monitor-exit(this);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    L11:
        if (r11 == (-1)) goto L49;
        if (r11 == 8) goto L15;
        return;
    L15:
        monitor-enter(this);
        DownloadTask r15 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L21
        if (r15 != null) goto L19;
    L23:
        q(r5);     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L19:
        if (this.d.get(r5) != null) goto L23;
        this.d.put(r5, r15);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final void b(int r10, int r11) {
        if (Logger.b() == false) goto L5;
        Logger.a("AbsDownloadEngine", r10, null, "removeTask", a.d(r11, "Listener hashCode: "), false);
    L5:
        if (r11 != 0) goto L8;
        this.f15620a.remove(r10);
        this.e.remove(r10);
        return;
    L8:
        SparseArray r5 = (SparseArray) this.e.get(r10);
        if (r5 == null) goto L17;
        r5.remove(r11);
        if (Logger.b() == false) goto L14;
        Logger.a("AbsDownloadEngine", r10, null, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r5.size(), false);
    L14:
        if (r5.size() != 0) goto L19;
        this.f15620a.remove(r10);
        this.e.remove(r10);
        return;
    L19:
        return;
    L17:
        this.f15620a.remove(r10);
    }

    public ArrayList c(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        Iterator r10 = a().iterator();
        ArrayList r11 = new ArrayList();
    L8:
        if (r10.hasNext() == false) goto L14;
        DownloadInfo r12 = d(((Integer) r10.next()).intValue());
        if (r12 == null) goto L8;
        if (r5.equals(r12.f15839u) == false) goto L8;
        r11.add(r12);
        goto L8
    L14:
        return r11;
    }

    public void b(int r5, long r10, int r11) {
        DownloadInfo r12 = this.f15623h.a(r5);
        if (r12 == null) goto L5;
        r12.I0 = r10;
        r12.J0 = r11;
    L5:
        a(r5, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public void a(Message r19) {
        int r10 = r19.arg1;
        int r11 = r19.arg2;
        if (Logger.b() == false) goto L5;
        Logger.a("AbsDownloadEngine", r10, null, "handleMsg", a.d(r11, "Listener hashCode: "), false);
    L5:
        Object r5 = r19.obj;
        DownloadTask r12 = null;
        if ((r5 instanceof Exception) == false) goto L8;
        BaseException r13 = (BaseException) r5;
    L9:
        monitor-enter(this);
        if (r11 != 0) goto L15;
        DownloadTask r14 = (DownloadTask) this.f15620a.get(r10);     // Catch: Throwable -> L13
    L12:
        r12 = r14;
    L18:
        if (r12 != null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L21:
        int r15 = r19.what;     // Catch: Throwable -> L13
        DownloadInfo r16 = r12.f15878a;     // Catch: Throwable -> L13
        if (r16 != null) goto L24;
        Logger.c("AbsDownloadEngine", "notifyDownloadTaskStatus", "DownloadInfo is null\"");     // Catch: Throwable -> L13
    L35:
        a(r10, r11, r19.what);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L24:
        ListenerType r17 = ListenerType.f15280a;     // Catch: Throwable -> L13
        ConcurrentHashMap r18 = r12.a(r17);     // Catch: Throwable -> L13
        ListenerType r20 = ListenerType.f15282c;     // Catch: Throwable -> L13
        ConcurrentHashMap r21 = r12.a(r20);     // Catch: Throwable -> L13
        DownloadInfo r110 = r12.f15878a;     // Catch: Throwable -> L13
        if (r110 == null) goto L27;
        boolean r111 = r110.b();     // Catch: Throwable -> L13
    L28:
        if (r111 == false) goto L30;
    L33:
        boolean r112 = true;
    L34:
        DownloadListenerUtils.a(r15, r18, true, r16, r13, r17, r12);     // Catch: Throwable -> L13
        DownloadListenerUtils.a(r15, r21, r112, r16, r13, r20, r12);     // Catch: Throwable -> L13
        goto L35
    L30:
        if (r16.r() == true) goto L33;
        r112 = false;
        goto L34
    L27:
        r111 = false;
        goto L28
    L15:
        SparseArray r22 = (SparseArray) this.e.get(r10);     // Catch: Throwable -> L13
        if (r22 == null) goto L18;
        r14 = (DownloadTask) r22.get(r11);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L8:
        r13 = null;
        goto L9
    }

    public DownloadTask a(int r5, int r10) {
        monitor-enter(this);
        if (r10 != 0) goto L7;
        DownloadTask r11 = (DownloadTask) this.f15620a.get(r5);     // Catch: Throwable -> L5
    L11:
        monitor-exit(this);     // Catch: Throwable -> L5
        return r11;
    L7:
        SparseArray r12 = (SparseArray) this.e.get(r5);     // Catch: Throwable -> L5
        if (r12 == null) goto L10;
        r11 = (DownloadTask) r12.get(r10);     // Catch: Throwable -> L5
        goto L11
    L10:
        r11 = null;
    L5:
        th = move-exception;
        throw th;
    }
}
