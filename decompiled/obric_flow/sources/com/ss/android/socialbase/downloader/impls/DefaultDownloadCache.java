package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.db.EmptySqlDownloadCache;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultDownloadCache implements IDownloadCache {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f15672j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f15673k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DownloadCache f15674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ISqlDownloadCache f15675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f15676c;
    public volatile boolean d;
    public final int e;
    public final int f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ThreadLocal f15677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakDownloadHandler f15678i;

    static {
        f15672j = new AtomicBoolean(false);
        f15673k = new AtomicBoolean(false);
    }

    public DefaultDownloadCache() {
        boolean r5 = false;
        this.g = false;
        this.f15677h = new ThreadLocal();
        WeakDownloadHandler.IHandler r10 = new AnonymousClass1(this);
        this.f15678i = null;
        if (DownloadUtils.d.get() != 1) goto L8;
        if (DownloadHelper.b() == true) goto L8;
        this.f15675b = new EmptySqlDownloadCache();
    L16:
        this.f15676c = false;
        this.f15678i = new WeakDownloadHandler(Looper.getMainLooper(), r10);
        LruCache r11 = DownloadSetting.e;
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("lru_download_info_cache_enable", 0) <= 0) goto L19;
    L22:
        boolean r12 = true;
    L24:
        if (r12 == false) goto L26;
        Logger.a("DefaultDownloadCache", "Construct enableLru");
    L27:
        if (r12 == true) goto L29;
        Context r13 = DownloadComponentManager.f15515a;
    L32:
        this.f15674a = new DownloadCache();
    L33:
        this.e = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("load_db_wait_time_ms", 5000);
        this.f = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("biz_close_db_batch_init", 0);
        if (((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("thread_load_download_cache_only_once") <= 0) goto L36;
        r5 = true;
    L36:
        this.g = r5;
        Runnable r14 = new AnonymousClass3(this);
        long r15 = DownloadSetting.f.a("delay_init_download_cache_ms", 0);
        if (r15 <= 0) goto L40;
        DownloadComponentManager.a(r14, r15, TimeUnit.MILLISECONDS);
        return;
    L40:
        b();
        return;
    L29:
        ISqlDownloadCache r16 = this.f15675b;
        if ((r16 instanceof EmptySqlDownloadCache) == true) goto L32;
        this.f15674a = new LruDownloadCache(r16);
        goto L33
    L26:
        Logger.a("DefaultDownloadCache", "Construct disableLru:" + Log.getStackTraceString(new Throwable("LruConstruct")));
        goto L27
    L19:
        if (DownloadHelper.b("lru_download_info_cache_enable") > 0) goto L22;
        r12 = false;
    L8:
        if (DownloadHelper.b() == false) goto L10;
    L15:
        this.f15675b = new SqlDownloadCache();
        goto L16
    L10:
        if (DownloadComponentManager.f == null) goto L15;
        if (DownloadComponentManager.f == null) goto L14;
        DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener r17 = new AnonymousClass2(this);
        SqlDownloadCacheAidlWrapper r18 = new SqlDownloadCacheAidlWrapper();
        r18.d = r17;
        this.f15675b = r18;
        goto L16
    L14:
        this.f15675b = new SqlDownloadCache();
        goto L16
    }

    public static void a(DefaultDownloadCache r5) {
        r5.getClass();
        if (f15673k.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (Logger.b() == false) goto L9;
        Logger.b("DefaultDownloadCache", "onDownloadCacheSyncSuccess", "Run");
    L9:
        if (r5.f15674a.f15694c == false) goto L11;
        r5.g();
    L14:
        Message r10 = r5.f15678i.obtainMessage(1);
        r5.f15678i.sendMessageDelayed(r10, 4000);
        DownloadComponentManager.a(DownloadCacheSyncStatus.f15273b);
        return;
    L11:
        monitor-enter(r5);
        r5.f15676c = true;     // Catch: Throwable -> L16
        r5.notifyAll();     // Catch: Throwable -> L16
        monitor-exit(r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final void b() {
        if (Logger.b() == false) goto L5;
        Logger.b("DefaultDownloadCache", "initImmediately", "Run isRunInit:" + f15672j.get());
    L5:
        boolean r5 = this.f15674a instanceof LruDownloadCache;
        if (f15672j.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        if (Logger.b() == false) goto L11;
        Logger.b("DefaultDownloadCache", "init", "Run");
    L11:
        DownloadComponentManager.a(DownloadCacheSyncStatus.f15272a);
        final SparseArray r10 = new SparseArray();
        Iterator r11 = this.f15674a.f15692a.entrySet().iterator();
    L13:
        if (r11.hasNext() == false) goto L19;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (((Integer) r12.getKey()).intValue() == 0) goto L13;
        if (r12.getValue() == null) goto L13;
        r10.put(((Integer) r12.getKey()).intValue(), r12.getValue());
        goto L13
    L19:
        ISqlDownloadCache r13 = this.f15675b;
        HashMap r14 = this.f15674a.g();
        List r15 = this.f15674a.b();
        this.f15674a.f();
        r13.a(r10, r14, r15, null, new AnonymousClass4(this, r10));
        LruCache r16 = DownloadSetting.e;
        int r17 = ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).c().optInt("init_download_cache_timeout_ms");
        if (Logger.b() == false) goto L22;
        Logger.b("DefaultDownloadCache", "init", "InitTimeout:" + r17);
    L22:
        if (r17 > 0) goto L24;
        return;
    L24:
        DownloadComponentManager.a(new AnonymousClass5(this), r17, TimeUnit.MILLISECONDS);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean c() {
        return this.f15676c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d(String r5) {
        return this.f15674a.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean e() {
        if (this.f15676c == false) goto L7;
        return true;
    L7:
        if (this.f15674a.f15694c == false) goto L10;
        f();
        return this.f15676c;
    L10:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (this.f15676c == false) goto L14;
    L28:
        monitor-exit(this);     // Catch: Throwable -> L16
        return this.f15676c;
    L14:
        if (Logger.b() == false) goto L19;
        Logger.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting start:" + this.e);     // Catch: Throwable -> L16
    L19:
        if (this.f <= 0) goto L25;
        ISqlDownloadCache r5 = this.f15675b;     // Catch: Throwable -> L16
        if (r5 == null) goto L25;
        if ((r5 instanceof SqlDownloadCache) == false) goto L25;
        ((SqlDownloadCache) r5).e = Integer.MAX_VALUE;     // Catch: Throwable -> L16
    L25:
        a(this);     // Catch: Throwable -> L16
        if (Logger.b() == false) goto L28;
        Logger.b("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L16
        goto L28
    }

    public final void f() {
        AbsDownloadEngine r5 = DownloadComponentManager.j();
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f15676c == false) goto L7;
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L7:
        if (Logger.b() == false) goto L11;
        Logger.b("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting start");     // Catch: Throwable -> L9
    L11:
        b();     // Catch: Throwable -> L9
        a(r5);     // Catch: Throwable -> L9
        if (Logger.b() == false) goto L14;
        Logger.b("DefaultDownloadCache", "newEnsureDownloadCacheSyncSuccess", "Waiting end");     // Catch: Throwable -> L9
        goto L14
    }

    public final void g() {
        AbsDownloadEngine r5 = DownloadComponentManager.j();
        monitor-enter(r5);
        this.f15676c = true;     // Catch: Throwable -> L8
        r5.notifyAll();     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo h(int r5) {
        DownloadInfo r10 = this.f15674a.h(r5);
        a(r10, true);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo j(int r5) {
        DownloadInfo r10 = this.f15674a.j(r5);
        a(r10, true);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo k(int r5) {
        DownloadInfo r10 = this.f15674a.k(r5);
        a(r10, true);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List o(int r5) {
        List r10 = this.f15674a.o(r5);
        if (r10 == null) goto L9;
        if (((ArrayList) r10).size() == 0) goto L9;
        return r10;
    L9:
        return this.f15675b.o(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void q(int r5) {
        this.f15674a.q(r5);
        this.f15675b.q(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final Map r(int r5) {
        Map r10 = this.f15674a.r(r5);
        if (r10 != null) goto L5;
    L8:
        Map r11 = this.f15675b.r(r5);
        this.f15674a.a(r5, r11);
        return r11;
    L5:
        if (r10.isEmpty() == true) goto L8;
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List c(String r5) {
        return this.f15674a.c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d() {
        return this.f15674a.d();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo c(int r5, long r10) {
        DownloadInfo r11 = this.f15674a.c(r5, r10);
        c(r5);
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean d(int r5) {
        if (DownloadHelper.c() == true) goto L5;
    L10:
        this.f15675b.d(r5);
    L11:
        this.f15674a.d(r5);
        return true;
    L5:
        if (DownloadUtils.b() == true) goto L10;
        IDownloadProxy r10 = DownloadProxy.a(true);
        if (r10 == null) goto L9;
        r10.d(r5);
        goto L11
    L9:
        this.f15675b.d(r5);
        goto L11
    }

    public final void h() {
        if (this.f15676c == true) goto L6;
        return;
    L6:
        if (this.d == true) goto L8;
        this.d = true;
        if (DownloadHelper.b() == true) goto L17;
        if (DownloadUtils.b() == true) goto L17;
        return;
    L17:
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L22
        char[] r10 = DownloadUtils.f16142a;     // Catch: Throwable -> L22
        monitor-exit(DownloadComponentManager.class);
        this.f15674a.b();
        return;
    L22:
        th = move-exception;
        throw th;
    L8:
        if (Logger.b() == false) goto L15;
        Logger.b("DefaultDownloadCache", "resumeUnCompleteTask", "Has resumed, return");
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void c(int r5) {
        a(this.f15674a.a(r5));     // Catch: Exception -> L10
        if (DownloadHelper.c() == true) goto L5;
    L14:
        this.f15675b.c(r5);     // Catch: Exception -> L10
        return;
    L5:
        if (DownloadUtils.b() == true) goto L14;
        IDownloadProxy r10 = DownloadProxy.a(true);     // Catch: Exception -> L10
        if (r10 == null) goto L12;
        r10.c(r5);     // Catch: Exception -> L10
        return;
    L12:
        this.f15675b.c(r5);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo d(int r5, long r10) {
        DownloadInfo r11 = this.f15674a.d(r5, r10);
        c(r5);
        return r11;
    }

    public final void a(Object r10) {
        if (this.g == false) goto L9;
        if (this.f15677h.get() != null) goto L18;
        this.f15677h.set(Boolean.TRUE);
        goto L9
    L18:
        return;
    L9:
        if (Logger.b() == false) goto L16;
        Logger.b("DefaultDownloadCache", "waitDBLoad", "Run loadDBWaitTime:" + this.e);
    L16:
        r10.wait(this.e);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        Logger.c("DefaultDownloadCache", "waitDBLoad", "Error:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo e(int r5) {
        DownloadInfo r10 = this.f15674a.e(r5);
        a(r10, true);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List b(String r5) {
        return this.f15674a.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5) {
        return this.f15674a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean b(int r5) {
    L10:
        e = move-exception;
        e.printStackTrace();
    L16:
        this.f15674a.b(r5);
        return true;
    L4:
        if (DownloadHelper.c() == true) goto L6;
    L13:
        this.f15675b.b(r5);     // Catch: SQLiteException -> L10
    L18:
        goto L16
    L6:
        if (DownloadUtils.b() == true) goto L13;
        IDownloadProxy r10 = DownloadProxy.a(true);     // Catch: SQLiteException -> L10
        if (r10 == null) goto L12;
        r10.b(r5);     // Catch: SQLiteException -> L10
        goto L18
    L12:
        this.f15675b.b(r5);     // Catch: SQLiteException -> L10
        goto L18
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5) {
        return this.f15674a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5, String r10) {
        return this.f15674a.a(r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(DownloadInfo r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        boolean r10 = this.f15674a.a(r5);
        a(r5, true);
        return r10;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void a() {
        this.f15674a.a();     // Catch: SQLiteException -> L4
    L7:
        if (DownloadHelper.c() == true) goto L9;
    L14:
        this.f15675b.a();
        return;
    L9:
        if (DownloadUtils.b() == true) goto L14;
        IDownloadProxy r5 = DownloadProxy.a(true);
        if (r5 == null) goto L13;
        r5.a();
        return;
    L13:
        this.f15675b.a();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo b(int r5, long r10) {
        DownloadInfo r11 = this.f15674a.b(r5, r10);
        a(r11, false);
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void b(DownloadInfo r5) {
        this.f15674a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r10, long r11, String r12, String r13) {
        DownloadInfo r14 = this.f15674a.a(r10, r11, r12, r13);
        a(r14, true);
        return r14;
    }

    public final void a(DownloadInfo r5, boolean r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (DownloadHelper.c() == true) goto L7;
    L15:
        this.f15675b.a(r5);
        return;
    L7:
        if (DownloadUtils.b() == true) goto L15;
        if (r10 == false) goto L17;
        IDownloadProxy r11 = DownloadProxy.a(true);
        if (r11 == null) goto L13;
        r11.a(r5);
        return;
    L13:
        this.f15675b.a(r5);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10) {
        DownloadInfo r11 = this.f15674a.a(r5, r10);
        c(r5);
        return r11;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(int r5, Map r10) {
        this.f15674a.a(r5, r10);
        this.f15675b.a(r5, r10);
        return false;
    }
}
