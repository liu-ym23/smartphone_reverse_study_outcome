package com.ss.android.socialbase.downloader.db;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes3.dex */
public class SqlDownloadCacheAidlWrapper implements ISqlDownloadCache, ServiceConnection {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f15441h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f15442i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static long f15443j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ISqlDownloadCacheAidl f15444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f15445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ISqlCacheLoadCompleteCallbackAidl f15446c;
    public DownloadComponentManager$IndependentHolderCreator$OnMainProcessRebindErrorListener d;
    public final Runnable e;
    public Future f;
    public final CountDownLatch g;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.db.SqlDownloadCacheAidlWrapper$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SqlDownloadCacheAidlWrapper f15451a;

        public AnonymousClass3(SqlDownloadCacheAidlWrapper r5) {
            this.f15451a = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            monitor-enter(DownloadComponentManager.class);
            Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L8
            monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L8
            SqlDownloadCacheService.a(r5, this.f15451a);
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    public SqlDownloadCacheAidlWrapper() {
        this.f15445b = new Handler(Looper.getMainLooper());
        this.f15446c = null;
        this.e = new AnonymousClass1(this);
        this.g = new CountDownLatch(1);
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L8
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L8
        SqlDownloadCacheService.a(r5, this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(int r5, Map r10) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List b(String r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.b(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List c(String r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.c(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d(String r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.d(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo e(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.e(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo h(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.h(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo j(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.j(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo k(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.k(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final /* bridge */ /* synthetic */ List o(int r5) {
        return null;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, final IBinder r10) {
        f15441h = true;
        this.f15445b.removeCallbacks(this.e);
        int r11 = ISqlDownloadCacheAidl.Stub.f15398a;     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
        ISqlDownloadCacheAidl r12 = null;
    L14:
        this.f15444a = r12;     // Catch: Throwable -> L11
    L17:
        this.f = DownloadComponentManager.c().submit(new AnonymousClass2(this, r10));
        return;
    L6:
        IInterface r13 = r10.queryLocalInterface("com.ss.android.socialbase.downloader.db.ISqlDownloadCacheAidl");     // Catch: Throwable -> L11
        if (r13 != null) goto L9;
    L13:
        r12 = new ISqlDownloadCacheAidl.Stub.Proxy(r10);     // Catch: Throwable -> L11
        goto L14
    L9:
        if ((r13 instanceof ISqlDownloadCacheAidl) == false) goto L13;
        r12 = (ISqlDownloadCacheAidl) r13;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L17
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        this.f15444a = null;
        f15441h = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void q(int r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final Map r(int r5) {
        return null;
    }

    public static boolean a(SqlDownloadCacheAidlWrapper r5) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache
    public final void a(final SparseArray r10, final HashMap r11, final List r12, List r13, final SqlCacheLoadCompleteCallback r14) {
        DownloadComponentManager.c().submit(new AnonymousClass4(this, r10, r11, r12, r14));
    }

    public final void a(ISqlCacheLoadCompleteCallbackAidl r5) {
        monitor-enter(this);
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: Throwable -> L7
        if (r10 != null) goto L18;
        this.f15446c = r5;     // Catch: Throwable -> L7
    L12:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L18:
        r10.a(r5);     // Catch: Throwable -> L7 RemoteException -> L9
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean b(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.b(r5);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo c(int r5, long r10) {
        ISqlDownloadCacheAidl r11 = this.f15444a;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.c(r5, r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List d() {
        ISqlDownloadCacheAidl r5 = this.f15444a;     // Catch: RemoteException -> L6
        if (r5 == null) goto L12;
        return r5.d();
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean e() {
        ISqlDownloadCacheAidl r5 = this.f15444a;     // Catch: RemoteException -> L6
        if (r5 == null) goto L12;
        return r5.e();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo b(int r5, long r10) {
        ISqlDownloadCacheAidl r11 = this.f15444a;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.b(r5, r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean c() {
        ISqlDownloadCacheAidl r5 = this.f15444a;     // Catch: RemoteException -> L6
        if (r5 == null) goto L12;
        return r5.c();
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean d(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.d(r5);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void b(DownloadInfo r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L11;
        r10.b(r5);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void c(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L11;
        r10.c(r5);     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo d(int r5, long r10) {
        ISqlDownloadCacheAidl r11 = this.f15444a;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.d(r5, r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.a(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.a(r5);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final List a(String r5, String r10) {
        ISqlDownloadCacheAidl r11 = this.f15444a;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.a(r5, r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final boolean a(DownloadInfo r5) {
        ISqlDownloadCacheAidl r10 = this.f15444a;     // Catch: RemoteException -> L6
        if (r10 == null) goto L12;
        return r10.a(r5);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final void a() {
        ISqlDownloadCacheAidl r5 = this.f15444a;     // Catch: RemoteException -> L6
        if (r5 == null) goto L11;
        r5.a();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r10, long r11, String r12, String r13) {
        ISqlDownloadCacheAidl r5 = this.f15444a;     // Catch: RemoteException -> L6
        if (r5 == null) goto L12;
        return r5.a(r10, r11, r12, r13);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public final DownloadInfo a(int r5, long r10) {
        ISqlDownloadCacheAidl r11 = this.f15444a;     // Catch: RemoteException -> L6
        if (r11 == null) goto L12;
        return r11.a(r5, r10);
    L12:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
