package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DownloadThreadPool;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadListenerUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public class NewDownloadEngine extends BaseDownloadEngine implements WeakDownloadHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ConcurrentHashMap f15704l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f15705m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConcurrentHashMap f15706n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f15707o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap f15708p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap f15709q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedBlockingDeque f15710r;
    public final IDownloadCache s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final WeakDownloadHandler f15711t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DownloadThreadPool f15712u;

    public NewDownloadEngine() {
        this.f15704l = new ConcurrentHashMap();
        this.f15705m = new ConcurrentHashMap();
        this.f15706n = new ConcurrentHashMap();
        this.f15707o = new ConcurrentHashMap();
        this.f15708p = new ConcurrentHashMap();
        this.f15709q = new ConcurrentHashMap();
        this.f15710r = new LinkedBlockingDeque();
        this.s = DownloadComponentManager.h();
        this.f15711t = new WeakDownloadHandler(Looper.getMainLooper(), this);
        this.f15712u = new DownloadThreadPool();
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final Future a(DownloadTask r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (Logger.a(r5.f15878a) == false) goto L8;
        Logger.a("NewDownloadEngine", r5.f15878a, "doDownload", "start doDownload for task");
    L8:
        DownloadTimingInfo r10 = r5.s;
        r10.d = System.currentTimeMillis();
        return this.f15712u.a(new DownloadRunnable(r5, this.f15711t));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(int r5, int r10, IDownloadListener r11, ListenerType r12, boolean r13) {
        DownloadTask r14 = r(r5);
        if (r14 != null) goto L5;
        r14 = (DownloadTask) this.f15709q.get(Integer.valueOf(r5));
    L5:
        if (r14 == null) goto L8;
        r14.b(r10, r11, r12, r13);
        return;
    }

    public final void c(int r10, int r11) {
        if (Logger.b() == false) goto L5;
        Logger.a("NewDownloadEngine", r10, null, "removeTask", a.d(r11, "Listener hashCode: "), false);
    L5:
        if (r11 != 0) goto L8;
        this.f15704l.remove(Integer.valueOf(r10));
        this.f15708p.remove(Integer.valueOf(r10));
        return;
    L8:
        Map r5 = (Map) this.f15708p.get(Integer.valueOf(r10));
        if (r5 == null) goto L17;
        r5.remove(Integer.valueOf(r11));
        if (Logger.b() == false) goto L14;
        Logger.a("NewDownloadEngine", r10, null, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r5.size(), false);
    L14:
        if (r5.size() != 0) goto L19;
        this.f15704l.remove(Integer.valueOf(r10));
        this.f15708p.remove(Integer.valueOf(r10));
        return;
    L19:
        return;
    L17:
        this.f15704l.remove(Integer.valueOf(r10));
    }

    @Override // com.ss.android.socialbase.downloader.impls.BaseDownloadEngine
    public final void d(DownloadTask r12) {
        if (r12 == null) goto L143;
        DownloadInfo r5 = r12.f15878a;
        if (r5 == null) goto L144;
        boolean r10 = false;
        r5.W0 = false;
        if (r5.f15850z0 == EnqueueType.f15277a) goto L48;
        if (PluginDownloadEngine.a(r5) == false) goto L133;
        PluginDownloadEngine r11 = PluginDownloadEngine.a();
        r11.f15729c.execute(new PluginDownloadEngine.AnonymousClass5(r11, r12));
        return;
    L133:
    L17:
        th = move-exception;
        Logger.a("NewDownloadEngine", r5.l(), "enqueue", "Error:" + th);
        return;
    L14:
        if (this.f15710r.isEmpty() == false) goto L20;
        d(r12);     // Catch: Throwable -> L17
        this.f15710r.put(r12);     // Catch: Throwable -> L17
        return;
    L20:
        if (r5.f15850z0 == EnqueueType.f15279c) goto L22;
        DownloadTask r13 = (DownloadTask) this.f15710r.getFirst();     // Catch: Throwable -> L17
        if (r13.e() == r12.e()) goto L39;
    L41:
        k(r13.e());     // Catch: Throwable -> L17
        d(r12);     // Catch: Throwable -> L17
        if (r13.e() == r12.e()) goto L142;
        this.f15710r.putFirst(r12);     // Catch: Throwable -> L17
        return;
    L142:
        return;
    L39:
        if (i(r12.e()) == false) goto L41;
        return;
    L22:
        if (((DownloadTask) this.f15710r.getFirst()).e() == r12.e()) goto L24;
    L26:
        Iterator r14 = this.f15710r.iterator();     // Catch: Throwable -> L17
    L28:
        if (r14.hasNext() == false) goto L34;
        DownloadTask r15 = (DownloadTask) r14.next();     // Catch: Throwable -> L17
        if (r15 == null) goto L28;
        if (r15.e() != r12.e()) goto L28;
        r14.remove();     // Catch: Throwable -> L17
    L34:
        this.f15710r.put(r12);     // Catch: Throwable -> L17
        return;
    L24:
        if (i(r12.e()) == false) goto L26;
        return;
    L48:
        if (r5.t() == false) goto L51;
        Logger.a("NewDownloadEngine", r5.l(), "doDownloadImpl", "Entity invalid");
        DownloadMonitorHelper.a(r12.f15883j, r5, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is Invalid, url is " + r5.d + " name is " + r5.f15808b + " savePath is " + r5.e), r5.o());
        return;
    L51:
        r12.s.f15904c = System.currentTimeMillis();
        DownloadComponentManager.a(r12, true);
        if (DownloadSetting.a(r5.l(), null).a("no_net_opt", 0) != 1) goto L69;
        monitor-enter(DownloadComponentManager.class);
        Context r16 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L65
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L65
        if (DownloadUtils.b(r16) == true) goto L69;
        if (r5.w() == true) goto L69;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optBoolean("disable_check_no_network") == true) goto L69;
        new DownloadStatusHandler(r12, this.f15711t).a(new BaseException(1049, "network_not_available"));
        return;
    L65:
        th = move-exception;
        throw th;
    L69:
        if (Logger.a(r5) == false) goto L71;
        Logger.a("NewDownloadEngine", r5.l(), r5.P, "doDownloadImpl", "Url: " + r5.d + " savePath: " + r5.e + " saveName: " + r5.f15808b, false);
    L71:
        int r17 = r5.l();
        if (this.f15706n.containsKey(Integer.valueOf(r17)) == false) goto L75;
        this.f15706n.remove(Integer.valueOf(r17));
    L75:
        if (this.f15705m.containsKey(Integer.valueOf(r17)) == false) goto L78;
        this.f15705m.remove(Integer.valueOf(r17));
    L78:
        if (this.f15707o.containsKey(Integer.valueOf(r17)) == false) goto L81;
        this.f15707o.remove(Integer.valueOf(r17));
    L81:
        if (i(r17) == false) goto L90;
        if (r5.a() == true) goto L90;
        if (Logger.a(r5) == false) goto L87;
        Logger.a("NewDownloadEngine", r5.l(), r5.P, "doDownloadImpl", "Another task with same id is downloading when tryDownload", false);
    L87:
        r12.a();
        DownloadMonitorHelper.a(r12.f15883j, r5, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is isDownloading and addListenerToSameTask is false"), r5.o());
        return;
    L90:
        if (Logger.a(r5) == false) goto L93;
        Logger.a("NewDownloadEngine", r5.l(), r5.P, "doDownloadImpl", "No downloading task", false);
    L93:
        if (r5.a() == false) goto L95;
        r5.H = AsyncHandleStatus.f15265c;
    L95:
        DownloadTask r18 = (DownloadTask) this.f15709q.remove(Integer.valueOf(r17));
        if (r18 == null) goto L99;
        r12.a(r18);
    L99:
        if ("mime_type_plg".equals(r5.f15839u) == false) goto L101;
        r12.f15878a.a("executor_group", 3);
    L101:
        DownloadTask r19 = (DownloadTask) this.f15704l.get(Integer.valueOf(r17));
        if (r19 == null) goto L108;
        DownloadInfo r20 = r19.f15878a;
        if (r20 == null) goto L108;
        int r21 = r20.o();
        if (DownloadStatus.a(r21) == false) goto L110;
        r10 = true;
    L110:
        if (Logger.a(r5) == false) goto L112;
        Logger.a("NewDownloadEngine", r5.l(), r5.P, "doDownloadImpl", "Can add listener " + r10 + " , oldTaskStatus is :" + r21, false);
    L112:
        if (r10 == false) goto L115;
        r12.a();
        return;
    L115:
        int r22 = r12.f15894v;
        if (r22 == 0) goto L118;
    L120:
        if (r22 == 0) goto L129;
        Map r23 = (Map) this.f15708p.get(Integer.valueOf(r12.e()));
        if (r23 != null) goto L126;
        r23 = new ConcurrentHashMap();
        this.f15708p.put(Integer.valueOf(r12.e()), r23);
    L126:
        if (Logger.a(r12.f15878a) == false) goto L128;
        Logger.a("NewDownloadEngine", r12.f15878a, "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r22);
    L128:
        r23.put(Integer.valueOf(r22), r12);
    L129:
        this.f15704l.put(Integer.valueOf(r17), r12);
        a(r12);
        return;
    L118:
        if (r12.f15895w == false) goto L120;
        r22 = r12.c();
    L108:
        r21 = 0;
        goto L110
    L144:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final IDownloadNotificationEventListener f(int r5) {
        DownloadTask r10 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
        DownloadTask r11 = (DownloadTask) this.f15705m.get(Integer.valueOf(r5));
        if (r11 != null) goto L9;
        DownloadTask r12 = (DownloadTask) this.f15706n.get(Integer.valueOf(r5));
        if (r12 != null) goto L13;
        DownloadTask r13 = (DownloadTask) this.f15707o.get(Integer.valueOf(r5));
        if (r13 != null) goto L17;
        return null;
    L17:
        return r13.g;
    L13:
        return r12.g;
    L9:
        return r11.g;
    L5:
        return r10.g;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final INotificationClickCallback h(int r5) {
        DownloadTask r10 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
        DownloadTask r11 = (DownloadTask) this.f15705m.get(Integer.valueOf(r5));
        if (r11 != null) goto L9;
        DownloadTask r12 = (DownloadTask) this.f15706n.get(Integer.valueOf(r5));
        if (r12 != null) goto L13;
        DownloadTask r13 = (DownloadTask) this.f15707o.get(Integer.valueOf(r5));
        if (r13 != null) goto L17;
        return null;
    L17:
        return r13.f15887n;
    L13:
        return r12.f15887n;
    L9:
        return r11.f15887n;
    L5:
        return r10.f15887n;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final boolean i(int r5) {
        DownloadRunnable r10 = (DownloadRunnable) this.f15712u.f16114a.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
    L11:
        return false;
    L5:
        if (r10.f15294a.g == false) goto L11;
        DownloadInfo r11 = d(r5);
        if (r11 != null) goto L10;
        return false;
    L10:
        return DownloadStatus.a(r11.o());
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final boolean j(int r5) {
        if (r5 != 0) goto L4;
        return false;
    L4:
        if (this.f15704l.get(Integer.valueOf(r5)) == null) goto L6;
        return true;
    L6:
        if (this.f15706n.get(Integer.valueOf(r5)) == null) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void m(final int r10) {
        if (Logger.b() == false) goto L5;
        Logger.a("NewDownloadEngine", r10, null, "resetDownloadData", "DeleteFile:trueTrace:" + Log.getStackTraceString(new Throwable()), false);
    L5:
        this.f15711t.post(new AnonymousClass5(r10));
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass6(this, r10));
    }

    public final DownloadTask r(int r5) {
        DownloadTask r10 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r10 != null) goto L10;
        r10 = (DownloadTask) this.f15706n.get(Integer.valueOf(r5));
        if (r10 != null) goto L10;
        r10 = (DownloadTask) this.f15705m.get(Integer.valueOf(r5));
        if (r10 != null) goto L10;
        return (DownloadTask) this.f15707o.get(Integer.valueOf(r5));
    L10:
        return r10;
    }

    public final void s(int r5) {
        if (this.f15710r.isEmpty() == true) goto L18;
        DownloadTask r10 = (DownloadTask) this.f15710r.getFirst();
        if (r10 == null) goto L11;
        if (r10.e() != r5) goto L11;
        this.f15710r.poll();
    L11:
        if (this.f15710r.isEmpty() == true) goto L19;
        DownloadTask r11 = (DownloadTask) this.f15710r.getFirst();
        if (r11 != null) goto L16;
        return;
    L16:
        d(r11);
        return;
    L19:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b(int r5) {
        this.f15712u.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void b() {
        DownloadThreadPool r5 = this.f15712u;
        r5.a();
        Iterator r10 = new ArrayList(r5.f16114a.keySet()).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        k(((Integer) r10.next()).intValue());
        goto L4
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r10, int r11, IDownloadListener r12, ListenerType r13, boolean r14) {
        BaseDownloadEngine.a(new BaseDownloadEngine.AnonymousClass11(this, r10, r11, r12, r13, r14, true));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final List a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        List r10 = this.s.c(r5);
        if (r10 != null) goto L9;
    L12:
        ArrayList r11 = new ArrayList();
        Iterator r12 = this.f15704l.values().iterator();
    L14:
        if (r12.hasNext() == false) goto L22;
        DownloadTask r13 = (DownloadTask) r12.next();
        if (r13 == null) goto L14;
        DownloadInfo r14 = r13.f15878a;
        if (r14 == null) goto L14;
        if (r5.equals(r14.d) == false) goto L14;
        r11.add(r13.f15878a);
        goto L14
    L22:
        return r11;
    L9:
        if (r10.isEmpty() == true) goto L12;
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final IDownloadFileUriProvider c(int r5) {
        DownloadTask r10 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r10 != null) goto L5;
        DownloadTask r11 = (DownloadTask) this.f15705m.get(Integer.valueOf(r5));
        if (r11 != null) goto L9;
        DownloadTask r12 = (DownloadTask) this.f15706n.get(Integer.valueOf(r5));
        if (r12 != null) goto L13;
        DownloadTask r13 = (DownloadTask) this.f15707o.get(Integer.valueOf(r5));
        if (r13 != null) goto L17;
        return null;
    L17:
        return r13.f15889p;
    L13:
        return r12.f15889p;
    L9:
        return r11.f15889p;
    L5:
        return r10.f15889p;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r5, IDownloadNotificationEventListener r10) {
        DownloadTask r11 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r11 != null) goto L5;
        return;
    L5:
        r11.g = r10;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final DownloadTask a(int r5, int r10) {
        if (r10 == 0) goto L4;
        Map r11 = (Map) this.f15708p.get(Integer.valueOf(r5));
        if (r11 != null) goto L8;
        return null;
    L8:
        return (DownloadTask) r11.get(Integer.valueOf(r10));
    L4:
        return (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final ArrayList c(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        DownloadThreadPool r10 = this.f15712u;
        r10.a();
        Iterator r11 = new ArrayList(r10.f16114a.keySet()).iterator();
        ArrayList r12 = new ArrayList();
    L8:
        if (r11.hasNext() == false) goto L14;
        DownloadInfo r13 = d(((Integer) r11.next()).intValue());
        if (r13 == null) goto L8;
        if (r5.equals(r13.f15839u) == false) goto L8;
        r12.add(r13);
        goto L8
    L14:
        return r12;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(final int r10, final boolean r11, final boolean r12) {
        if (Logger.b() == false) goto L5;
        Logger.a("NewDownloadEngine", r10, null, "clearDownloadData", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12, false);
    L5:
        this.f15711t.post(new AnonymousClass3(r10));
        ((ThreadPoolExecutor) DownloadComponentManager.c()).execute(new AnonymousClass4(this, r10, r11, r12));
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine, com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
    public final void a(Message r19) {
        int r10 = r19.arg1;
        int r11 = r19.arg2;
        if (Logger.b() == false) goto L5;
        Logger.a("NewDownloadEngine", r10, null, "handleMsg", a.d(r11, "Listener hashCode: "), false);
    L5:
        Object r5 = r19.obj;
        DownloadTask r12 = null;
        if ((r5 instanceof Exception) == false) goto L8;
        BaseException r13 = (BaseException) r5;
    L9:
        if (r11 != 0) goto L11;
        r12 = (DownloadTask) this.f15704l.get(Integer.valueOf(r10));
    L14:
        if (r12 != null) goto L16;
        return;
    L16:
        int r14 = r19.what;
        DownloadInfo r15 = r12.f15878a;
        if (r15 != null) goto L19;
        Logger.c("NewDownloadEngine", "notifyDownloadTaskStatus", "DownloadInfo is null");
    L30:
        BaseDownloadEngine.a(new BaseDownloadEngine.AnonymousClass9(this, r10, r11, r19.what));
        return;
    L19:
        ListenerType r16 = ListenerType.f15280a;
        ConcurrentHashMap r17 = r12.a(r16);
        ListenerType r18 = ListenerType.f15282c;
        ConcurrentHashMap r20 = r12.a(r18);
        DownloadInfo r110 = r12.f15878a;
        if (r110 == null) goto L22;
        boolean r111 = r110.b();
    L23:
        if (r111 == false) goto L25;
    L28:
        boolean r112 = true;
    L29:
        BaseException r113 = r13;
        DownloadTask r114 = r12;
        DownloadListenerUtils.a(r14, r17, true, r15, r113, r16, r114);
        DownloadListenerUtils.a(r14, r20, r112, r15, r113, r18, r114);
        goto L30
    L25:
        if (r15.r() == true) goto L28;
        r112 = false;
        goto L29
    L22:
        r111 = false;
        goto L23
    L11:
        Map r21 = (Map) this.f15708p.get(Integer.valueOf(r10));
        if (r21 == null) goto L14;
        r12 = (DownloadTask) r21.get(Integer.valueOf(r11));
        goto L14
    L8:
        r13 = null;
        goto L9
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(DownloadRunnable r5) {
        Iterator r10 = this.f15712u.f16114a.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        if (((Map.Entry) r10.next()).getValue() != r5) goto L4;
        r10.remove();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final DownloadRunnable a(int r5) {
        return this.f15712u.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final ArrayList a() {
        DownloadThreadPool r5 = this.f15712u;
        r5.a();
        return new ArrayList(r5.f16114a.keySet());
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final void a(int r5, long r10, int r11) {
        DownloadRunnable r12 = (DownloadRunnable) this.f15712u.f16114a.get(Integer.valueOf(r5));
        if (r12 == null) goto L6;
        r12.f15295b.a(r10, r11);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.impls.AbsDownloadEngine
    public final DownloadInfo d(int r5) {
        DownloadInfo r10 = this.s.a(r5);
        if (r10 != null) goto L8;
        DownloadTask r11 = (DownloadTask) this.f15704l.get(Integer.valueOf(r5));
        if (r11 == null) goto L8;
        return r11.f15878a;
    L8:
        return r10;
    }
}
