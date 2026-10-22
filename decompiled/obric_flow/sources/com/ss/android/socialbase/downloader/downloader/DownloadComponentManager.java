package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.NewDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.l0;
import org.json.JSONArray;
import org.json.JSONObject;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DownloadComponentManager {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = 0;
    public static final ArrayList D = null;
    public static final ArrayList E = null;
    public static boolean F;
    public static InnerEventListener G;
    public static volatile boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f15515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile DefaultDownloadCache f15516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AbsDownloadEngine f15517c;
    public static volatile DefaultDownloadServiceHandler d;
    public static volatile IndependentDownloadServiceHandler e;
    public static volatile MultiProcCreater f;
    public static volatile DefaultDownloadHttpService g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15518h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15519i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15520j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15521k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15522l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15523m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f15524n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f15526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile DownloadReceiver f15527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f15528r;
    public static volatile boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static volatile OkHttpClient f15529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile IDownloadDns f15530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile ITTNetHandler.DefaultTTNetHandler f15531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ArrayList f15532w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static boolean f15533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f15534y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f15535z = 0;

    static {
        f15528r = new CopyOnWriteArrayList();
        s = false;
        f15529t = null;
        f15532w = new ArrayList();
        f15533x = false;
        int r5 = Runtime.getRuntime().availableProcessors() + 1;
        f15534y = r5;
        f15535z = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        A = r5;
        B = r5;
        String r10 = DownloadConstants.f15275a;
        C = 32768;
        D = new ArrayList();
        E = new ArrayList();
        F = true;
        H = false;
        IDownloadMultiProcService r11 = (IDownloadMultiProcService) DownloadServiceManager.a(IDownloadMultiProcService.class);
        if (r11 == null) goto L6;
        r11.a();
        return;
    }

    public static void a(DownloadTask r5, boolean r10) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.f15878a.b1 == true) goto L15;
        if (r10 == false) goto L8;
        ConcurrentHashMap r11 = r5.f15892t.f15897a;
    L10:
        if (r11.isEmpty() == false) goto L16;
        r11.put("cpu", DownloadThreadInfo.a(f15518h));
        r11.put("io", DownloadThreadInfo.a(null));
        r11.put("mixDefault", DownloadThreadInfo.a(f15519i));
        r11.put("mixApk", DownloadThreadInfo.a(null));
        r11.put("db", DownloadThreadInfo.a(f15521k));
        r11.put("chunk", DownloadThreadInfo.a(f15522l));
        r11.put("segment", DownloadThreadInfo.a(f15523m));
        r11.put("okHttp", DownloadThreadInfo.a(null));
        r11.put("schedule", DownloadThreadInfo.a(f15524n));
        r11.put("single", DownloadThreadInfo.a(f15525o));
        r11.put("custom", DownloadThreadInfo.a(null));
        return;
    L16:
        return;
    L8:
        r11 = r5.f15892t.f15898b;
        goto L10
    }

    public static void b(DownloaderBuilder r5) {
        Context r10 = r5.f15567a;
        if (r10 == null) goto L6;
        a(r10);
    L6:
        if (r5.f15568b.isEmpty() == true) goto L16;
        ArrayList r11 = r5.f15568b;
        ArrayList r12 = f15532w;
        if (r12.isEmpty() == false) goto L16;
        monitor-enter(r12);
        r12.addAll(r11);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L16:
        F = r5.f15569c;
    }

    public static ExecutorService c() {
        if (f15518h != null) goto L26;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15518h != null) goto L21;
        int r5 = f15534y;     // Catch: Throwable -> L11
        if (t() == false) goto L13;
        long r10 = 8;
        int r11 = r5 / 2;     // Catch: Throwable -> L11
    L14:
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(r11, r5, r10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed"));     // Catch: Throwable -> L11
        r12.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L18
    L20:
        f15518h = r12;     // Catch: Throwable -> L11
        goto L21
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L20
    L13:
        r10 = 15;
        r11 = r5;
    L21:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L26:
        return f15518h;
    }

    public static ExecutorService d() {
        if (f15522l != null) goto L26;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15522l != null) goto L21;
        int r5 = f15535z;     // Catch: Throwable -> L11
        if (t() == false) goto L13;
        long r10 = 8;
        int r11 = r5 / 2;     // Catch: Throwable -> L11
    L14:
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(r11, r5, r10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed"));     // Catch: Throwable -> L11
        r12.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L18
    L20:
        f15522l = r12;     // Catch: Throwable -> L11
        goto L21
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L20
    L13:
        r10 = 15;
        r11 = r5;
    L21:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L26:
        return f15522l;
    }

    public static ExecutorService e() {
        if (f15521k != null) goto L26;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15521k != null) goto L21;
        int r5 = B;     // Catch: Throwable -> L11
        if (t() == false) goto L13;
        long r10 = 8;
        int r11 = r5 / 2;     // Catch: Throwable -> L11
    L14:
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(r11, r5, r10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed"));     // Catch: Throwable -> L11
        r12.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L18
    L20:
        f15521k = r12;     // Catch: Throwable -> L11
        goto L21
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L20
    L13:
        r10 = 15;
        r11 = r5;
    L21:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L26:
        return f15521k;
    }

    public static IDownloadDns f() {
        if (f15530u != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15530u != null) goto L11;
        f15530u = new AnonymousClass3();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return f15530u;
    }

    public static IDownloadHttpService g() {
        if (g != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L11;
        g = new DefaultDownloadHttpService();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return g;
    }

    public static IDownloadCache h() {
        if (f15516b != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15516b != null) goto L11;
        f15516b = new DefaultDownloadCache();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return f15516b;
    }

    public static OkHttpClient i() {
        if (f15529t != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15529t != null) goto L11;
        l0 r5 = a();     // Catch: Throwable -> L9
        r5.getClass();     // Catch: Throwable -> L9
        f15529t = new OkHttpClient(r5);     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return f15529t;
    }

    public static AbsDownloadEngine j() {
        if (f15517c != null) goto L19;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15517c == null) goto L9;
    L14:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
        goto L19
    L9:
        if (DownloadHelper.b("optimize_download_cache") <= 0) goto L13;
        f15517c = new NewDownloadEngine();     // Catch: Throwable -> L11
        goto L14
    L13:
        f15517c = new DefaultDownloadEngine();     // Catch: Throwable -> L11
    L19:
        return f15517c;
    }

    public static synchronized void k() {
        monitor-enter(DownloadComponentManager.class);
        char[] r5 = DownloadUtils.f16142a;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static IDownloadServiceHandler l() {
        if (d != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public static InnerEventListener m() {
        if (G != null) goto L6;
        G = new AnonymousClass4();
    L6:
        return G;
    }

    public static ExecutorService n() {
        if (f15526p != null) goto L24;
        monitor-enter(DownloadComponentManager.class);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (f15526p != null) goto L19;
        LruCache r5 = DownloadSetting.e;     // Catch: Throwable -> L17
        int r10 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("fast_download_thread_pool_size_limit");     // Catch: Throwable -> L17
        if (r10 > 0) goto L11;
        r10 = 20;
    L11:
        int r11 = r10;
        if (t() == false) goto L15;
        long r12 = 15;
    L14:
        long r13 = r12;
        f15526p = new ThreadPoolExecutor(0, r11, r13, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-Fast"));     // Catch: Throwable -> L17
        goto L19
    L15:
        r12 = 60;
    L19:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L17
    L24:
        return f15526p;
    }

    public static ExecutorService o() {
        if (f15520j != null) goto L27;
        monitor-enter(DownloadComponentManager.class);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (f15520j != null) goto L22;
        int r5 = A;     // Catch: Throwable -> L19
        int r10 = r5 * 2;     // Catch: Throwable -> L19
        LruCache r11 = DownloadSetting.e;     // Catch: Throwable -> L19
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("throttle_thread_pool_opt", 0) <= 0) goto L11;
        long r12 = 8;
        int r13 = r5;
    L12:
        ThreadPoolExecutor r14 = new ThreadPoolExecutor(r13, r10, r12, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-global-throttle"));     // Catch: Throwable -> L19
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("throttle_thread_pool_opt", 0) > 0) goto L30;
    L21:
        f15520j = r14;     // Catch: Throwable -> L19
        goto L22
    L30:
        r14.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L19
        goto L21
    L11:
        r12 = 15;
        r13 = r10;
    L22:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L19
    L27:
        return f15520j;
    }

    public static IDownloadServiceHandler p() {
        if (e != null) goto L21;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e == null) goto L9;
    L16:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
        goto L21
    L9:
        if (f == null) goto L13;
        f.getClass();     // Catch: Throwable -> L11
        e = new IndependentDownloadServiceHandler();     // Catch: Throwable -> L11
        goto L16
    L13:
        IDownloadServiceHandler r5 = l();     // Catch: Throwable -> L11
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
        return r5;
    L21:
        return e;
    }

    public static ExecutorService q() {
        if (f15519i != null) goto L26;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15519i != null) goto L21;
        int r5 = A;     // Catch: Throwable -> L11
        if (t() == false) goto L13;
        long r10 = 8;
        int r11 = r5 / 2;     // Catch: Throwable -> L11
    L14:
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(r11, r5, r10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed"));     // Catch: Throwable -> L11
        r12.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L18
    L20:
        f15519i = r12;     // Catch: Throwable -> L11
        goto L21
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
        goto L20
    L13:
        r10 = 15;
        r11 = r5;
    L21:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L26:
        return f15519i;
    }

    public static ExecutorService r() {
        if (f15523m != null) goto L22;
        monitor-enter(DownloadComponentManager.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f15523m != null) goto L17;
        ThreadPoolExecutor r5 = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-segment-fixed"));     // Catch: Throwable -> L15
        r5.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L12
    L14:
        f15523m = r5;     // Catch: Throwable -> L15
        goto L17
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
    L17:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L15
    L22:
        return f15523m;
    }

    public static ITTNetHandler s() {
        if (f15531v != null) goto L16;
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15531v != null) goto L11;
        f15531v = new ITTNetHandler.DefaultTTNetHandler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
    L16:
        return f15531v;
    }

    public static boolean t() {
        LruCache r5 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("global_thread_pool_opt", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static void u() {
        ArrayList r5 = E;
        monitor-enter(r5);
        Iterator r10 = r5.iterator();     // Catch: Throwable -> L12
    L6:
        if (r10.hasNext() == false) goto L14;
        if (r10.next() == null) goto L6;
        throw new ClassCastException();     // Catch: Throwable -> L12
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void v() {
        monitor-enter(DownloadComponentManager.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (s == false) goto L7;
    L22:
        monitor-exit(DownloadComponentManager.class);
        return;
    L7:
        if (f != null) goto L26;
        monitor-exit(DownloadComponentManager.class);
        return;
    L26:
        Intent r5 = new Intent(b(), DownloadHandleService.class);     // Catch: Throwable -> L11
        r5.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");     // Catch: Throwable -> L11
        b().startService(r5);     // Catch: Throwable -> L11
        if (DownloadHelper.a() == true) goto L13;
        a(new AnonymousClass2(), false);     // Catch: Throwable -> L11
    L13:
        s = true;     // Catch: Throwable -> L11
        monitor-exit(DownloadComponentManager.class);
        return;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L18
        goto L22
    }

    public static void b(Runnable r10) {
        if (f15525o == null) goto L5;
    L27:
        f15525o.execute(r10);
        return;
    L5:
        monitor-enter(DownloadComponentManager.class);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (f15525o == null) goto L9;
    L23:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L20
        goto L27
    L9:
        if (t() == false) goto L12;
        long r5 = 30;
    L11:
        long r11 = r5;
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(1, 1, r11, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DTP-Single"));     // Catch: Throwable -> L20
        if (t() == true) goto L29;
    L22:
        f15525o = r12;     // Catch: Throwable -> L20
        goto L23
    L29:
        r12.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
        goto L22
    L12:
        r5 = 60;
        goto L11
    }

    public static synchronized void a(DownloaderBuilder r11) {
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (H == false) goto L11;
        Logger.c("DownloadComponentManager", "initComponent", "Component has init");     // Catch: Throwable -> L9
        monitor-exit(DownloadComponentManager.class);
        return;
    L11:
        boolean r5 = s;     // Catch: Throwable -> L9
        b(r11);     // Catch: Throwable -> L9
        JSONObject r10 = DownloadConstants.f15276b;     // Catch: Throwable -> L16
        int r12 = r10.optInt("downloader_alog_level");     // Catch: Throwable -> L16
        if (Logger.b() == false) goto L18;
        Logger.b("DownloadComponentManager", "setLoggerReport", "ALogLevel:" + r12);     // Catch: Throwable -> L16
    L18:
        if (r12 <= 0) goto L52;
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L16
        JSONArray r14 = r10.optJSONArray("downloader_alog_task_scene_list");     // Catch: Throwable -> L16
        if (r14 != null) goto L23;
    L31:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L16
        if (r10.optInt("downloader_logger_global_report") <= 0) goto L34;
        boolean r16 = true;
    L35:
        JSONArray r17 = r10.optJSONArray("downloader_logger_task_report_scene_list");     // Catch: Throwable -> L16
        if (r17 != null) goto L38;
    L46:
        Logger.a(r12, r16, r15, r13);     // Catch: Throwable -> L16
        if (Logger.a() == false) goto L52;
        Logger.b("DownloadComponentManager", "setLoggerReport", "Setting: " + DownloadConstants.f15276b);     // Catch: Throwable -> L16
    L38:
        if (r17.length() <= 0) goto L46;
        int r18 = 0;
    L41:
        if (r18 >= r17.length()) goto L46;
        String r19 = r17.optString(r18);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r19) == true) goto L45;
        r15.add(r19);     // Catch: Throwable -> L16
    L45:
        r18 = r18 + 1;     // Catch: Throwable -> L16
        goto L41
    L34:
        r16 = false;
        goto L35
    L23:
        if (r14.length() <= 0) goto L31;
        int r20 = 0;
    L26:
        if (r20 >= r14.length()) goto L31;
        String r21 = r14.optString(r20);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r21) == true) goto L30;
        r13.add(r21);     // Catch: Throwable -> L16
    L30:
        r20 = r20 + 1;     // Catch: Throwable -> L16
    L52:
        if (f15516b != null) goto L55;
        f15516b = new DefaultDownloadCache();     // Catch: Throwable -> L9
    L55:
        if (d != null) goto L58;
        d = new DefaultDownloadServiceHandler();     // Catch: Throwable -> L9
    L58:
        if (e != null) goto L63;
        if (f == null) goto L63;
        f.getClass();     // Catch: Throwable -> L9
        e = new IndependentDownloadServiceHandler();     // Catch: Throwable -> L9
    L63:
        if (f15517c != null) goto L69;
        if (DownloadHelper.b("optimize_download_cache") <= 0) goto L67;
        f15517c = new NewDownloadEngine();     // Catch: Throwable -> L9
        goto L69
    L67:
        f15517c = new DefaultDownloadEngine();     // Catch: Throwable -> L9
    L69:
        if (s == false) goto L74;
        if (r5 == true) goto L74;
        if (DownloadHelper.a() == true) goto L74;
        final boolean r110 = true;
    L75:
        a(new AnonymousClass1(r110), false);     // Catch: Throwable -> L9
        if (TextUtils.isEmpty(DownloadConstants.f15275a) == false) goto L78;
        DownloadConstants.f15275a = "oppo";     // Catch: Throwable -> L9
        DownloadConstants.f15275a.toUpperCase();     // Catch: Throwable -> L9
        String r111 = DownloadConstants.f15275a;     // Catch: Throwable -> L9
    L78:
        H = true;     // Catch: Throwable -> L9
        monitor-exit(DownloadComponentManager.class);
        return;
    L74:
        r110 = false;
    L16:
        th = move-exception;
        c.e("Error:", th, "DownloadComponentManager", "setLoggerReport");     // Catch: Throwable -> L9
        goto L52
    }

    public static synchronized Context b() {
        monitor-enter(DownloadComponentManager.class);
        Context r5 = f15515a;     // Catch: Throwable -> L7
        monitor-exit(DownloadComponentManager.class);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }

    public static void a(DownloadCacheSyncStatus r5) {
        ArrayList r10 = D;
        monitor-enter(r10);
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L15;
        if (r11.next() == null) goto L6;
        throw new ClassCastException();     // Catch: Throwable -> L12
    L15:
        if (r5 != DownloadCacheSyncStatus.f15273b) goto L17;
        D.clear();     // Catch: Throwable -> L12
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void a(Runnable r5, boolean r10) {
        if (r10 == true) goto L4;
    L7:
        c().execute(r5);
        return;
    L4:
        if (DownloadUtils.a() == true) goto L7;
        r5.run();
    }

    public static void a(Runnable r5) {
        if (DownloadUtils.a() == true) goto L6;
        r5.run();
        return;
    L6:
        ((ThreadPoolExecutor) e()).execute(r5);
    }

    public static void a(Runnable r5, long r10, TimeUnit r11) {
        if (f15524n == null) goto L5;
    L15:
        f15524n.schedule(r5, r10, r11);
        return;
    L5:
        monitor-enter(DownloadComponentManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f15524n != null) goto L11;
        f15524n = new ScheduledThreadPoolExecutor(4, new DefaultThreadFactory("DownloadThreadPool-Schedule"));     // Catch: Throwable -> L9
    L11:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L9
        goto L15
    }

    public static l0 a() {
        l0 r5 = new l0();
        LruCache r10 = DownloadSetting.e;
        int r11 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("connect_timeout", 30000);
        int r12 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("io_timeout", 30000);
        TimeUnit r13 = TimeUnit.MILLISECONDS;
        r5.a(r11, r13);
        long r14 = r12;
        r5.c(r14, r13);
        r5.d(r14, r13);
        r5.f = true;
        r5.f20679h = true;
        r5.b(Collections.singletonList(Protocol.HTTP_1_1));
        return r5;
    }

    public static synchronized void a(Context r5) {
        monitor-enter(DownloadComponentManager.class);
        if (r5 != null) goto L17;
    L15:
        monitor-exit(DownloadComponentManager.class);
        return;
    L17:
    L12:
        th = move-exception;
        throw th;
    L6:
        if (f15515a != null) goto L15;
        f15515a = r5.getApplicationContext();     // Catch: Throwable -> L12
        AppStatusManager.b().a(f15515a);     // Catch: Throwable -> L12
        if (Logger.b() == false) goto L15;
        Logger.b("DownloadComponentManager", "setAppContext", "Context:" + r5);     // Catch: Throwable -> L12
        monitor-exit(DownloadComponentManager.class);
    }
}
