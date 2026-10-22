package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.LruCache;
import ib.a0;
import ib.d0;
import ib.k0;
import ib.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import jb.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements sb.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.model.d> f7927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.model.d> f7928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.model.d> f7929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<com.ss.android.socialbase.downloader.model.d> f7930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<SparseArray<com.ss.android.socialbase.downloader.model.d>> f7931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LruCache<Integer, com.ss.android.socialbase.downloader.model.d> f7932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedBlockingDeque<com.ss.android.socialbase.downloader.model.d> f7933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final jb.i f7934h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7935i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final sb.f f7936j;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.a$a, reason: collision with other inner class name */
    class RunnableC0144a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7937c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f7938g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f7939h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f7940i;

        RunnableC0144a(a r10, Map r11, DownloadInfo r12, com.ss.android.socialbase.downloader.model.d r13, Map r14) {
            this.f7937c = r11;
            this.f7938g = r12;
            this.f7939h = r13;
            this.f7940i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map r10 = this.f7937c;
            if (r10 == null) goto L16;
            monitor-enter(r10);
            Iterator r11 = this.f7937c.values().iterator();     // Catch: Throwable -> L13
        L7:
            if (r11.hasNext() == false) goto L11;
            a0 r12 = (a0) r11.next();     // Catch: Throwable -> L13
            if (r12 == null) goto L7;
            r12.q0(this.f7938g);     // Catch: Throwable -> L13
            this.f7939h.a0(ListenerType.MAIN, r12);     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L16:
            DownloadInfo r13 = this.f7938g;
            if (r13 != null) goto L19;
            return;
        L19:
            if (r13.canShowNotification() == false) goto L49;
            Map r14 = this.f7940i;
            if (r14 == null) goto L50;
            monitor-enter(r14);
            Iterator r15 = this.f7940i.values().iterator();     // Catch: Throwable -> L31
        L25:
            if (r15.hasNext() == false) goto L29;
            a0 r16 = (a0) r15.next();     // Catch: Throwable -> L31
            if (r16 == null) goto L25;
            r16.q0(this.f7938g);     // Catch: Throwable -> L31
            this.f7939h.a0(ListenerType.NOTIFICATION, r16);     // Catch: Throwable -> L31
            goto L25
        L29:
            monitor-exit(r14);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            throw th;
        L50:
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f7941c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f7942g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f7943h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Map f7944i;

        b(a r10, Map r11, DownloadInfo r12, com.ss.android.socialbase.downloader.model.d r13, Map r14) {
            this.f7941c = r11;
            this.f7942g = r12;
            this.f7943h = r13;
            this.f7944i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map r10 = this.f7941c;
            if (r10 == null) goto L16;
            monitor-enter(r10);
            Iterator r11 = this.f7941c.values().iterator();     // Catch: Throwable -> L13
        L7:
            if (r11.hasNext() == false) goto L11;
            a0 r12 = (a0) r11.next();     // Catch: Throwable -> L13
            if (r12 == null) goto L7;
            r12.q0(this.f7942g);     // Catch: Throwable -> L13
            this.f7943h.a0(ListenerType.MAIN, r12);     // Catch: Throwable -> L13
            goto L7
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        L16:
            DownloadInfo r13 = this.f7942g;
            if (r13 != null) goto L19;
            return;
        L19:
            if (r13.canShowNotification() == false) goto L49;
            Map r14 = this.f7944i;
            if (r14 == null) goto L50;
            monitor-enter(r14);
            Iterator r15 = this.f7944i.values().iterator();     // Catch: Throwable -> L31
        L25:
            if (r15.hasNext() == false) goto L29;
            a0 r16 = (a0) r15.next();     // Catch: Throwable -> L31
            if (r16 == null) goto L25;
            r16.q0(this.f7942g);     // Catch: Throwable -> L31
            this.f7943h.a0(ListenerType.NOTIFICATION, r16);     // Catch: Throwable -> L31
            goto L25
        L29:
            monitor-exit(r14);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            throw th;
        L50:
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7945c;

        c(a r10, int r11) {
            this.f7945c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            pb.b.b().cancelNotification(this.f7945c);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7946c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f7948h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f7949i;

        d(a r10, int r11, boolean r12, boolean r13) {
            this.f7949i = r10;
            this.f7946c = r11;
            this.f7947g = r12;
            this.f7948h = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7949i.k(this.f7946c) != null) goto L20;
            com.ss.android.socialbase.downloader.model.d r10 = a.a(this.f7949i, this.f7946c);
            if (r10 == null) goto L20;
            DownloadInfo r11 = r10.y();
            Map<Integer, a0> r12 = r10.B(ListenerType.SUB);
            if (r12 == null) goto L20;
            monitor-enter(r12);
            Iterator<a0> r13 = r12.values().iterator();     // Catch: Throwable -> L17
        L11:
            if (r13.hasNext() == false) goto L15;
            a0 r14 = r13.next();     // Catch: Throwable -> L17
            if (r14 == null) goto L11;
            r14.q0(r11);     // Catch: Throwable -> L17
            r10.a0(ListenerType.SUB, r14);     // Catch: Throwable -> L17
            goto L11
        L15:
            monitor-exit(r12);     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        L20:
            this.f7949i.i(this.f7946c, this.f7947g, this.f7948h);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7950c;

        e(a r10, int r11) {
            this.f7950c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            pb.b.b().cancelNotification(this.f7950c);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7951c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f7952g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f7953h;

        f(a r10, int r11, boolean r12) {
            this.f7953h = r10;
            this.f7951c = r11;
            this.f7952g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7953h.k(this.f7951c);
            a.b(this.f7953h, this.f7951c, this.f7952g);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a0 f7954c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f7955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f7956h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f7957i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ ListenerType f7958j;

        g(a r10, a0 r11, int r12, DownloadInfo r13, com.ss.android.socialbase.downloader.model.d r14, ListenerType r15) {
            this.f7954c = r11;
            this.f7955g = r12;
            this.f7956h = r13;
            this.f7957i = r14;
            this.f7958j = r15;
        }

        @Override // java.lang.Runnable
        public void run() {
            a0 r10 = this.f7954c;
            if (r10 == null) goto L11;
            int r11 = this.f7955g;
            if (r11 != (-3)) goto L9;
            r10.W(this.f7956h);
        L7:
            this.f7957i.a0(this.f7958j, this.f7954c);
            return;
        L9:
            if (r11 != (-1)) goto L13;
            r10.p0(this.f7956h, new BaseException(1000, "try add listener for failed task"));
            goto L7
        L13:
            return;
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a0 f7959c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ DownloadInfo f7960g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.model.d f7961h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ ListenerType f7962i;

        h(a r10, a0 r11, DownloadInfo r12, com.ss.android.socialbase.downloader.model.d r13, ListenerType r14) {
            this.f7959c = r11;
            this.f7960g = r12;
            this.f7961h = r13;
            this.f7962i = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7959c != null) goto L5;
            return;
        L5:
            if (this.f7960g.getStatus() != (-3)) goto L9;
            this.f7959c.W(this.f7960g);
        L7:
            this.f7961h.a0(this.f7962i, this.f7959c);
            return;
        L9:
            if (this.f7960g.getStatus() != (-1)) goto L13;
            this.f7959c.p0(this.f7960g, new BaseException(1000, "try add listener for failed task"));
            goto L7
        }
    }

    protected a() {
        this.f7927a = new SparseArray();
        this.f7928b = new SparseArray();
        this.f7929c = new SparseArray();
        this.f7930d = new SparseArray();
        this.f7931e = new SparseArray();
        this.f7932f = new LruCache();
        this.f7933g = new LinkedBlockingDeque();
        this.f7936j = new sb.f(Looper.getMainLooper(), this);
        this.f7934h = com.ss.android.socialbase.downloader.downloader.a.o();
        if (rb.a.j().n("fix_anr_isolate_engine_and_cache") <= 0) goto L5;
        boolean r10 = true;
    L6:
        this.f7935i = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    private boolean E(DownloadInfo r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.statusInPause() == true) goto L8;
        return false;
    L8:
        return r10.isPauseReserveOnWifi();
    }

    private void F(int r11, BaseException r12, com.ss.android.socialbase.downloader.model.d r13) {
        if (r13 == null) goto L16;
        DownloadInfo r10 = r13.y();
        if (r10 != null) goto L7;
        lb.a.c("AbsDownloadEngine", "notifyDownloadTaskStatus", "DownloadInfo is null\"");
        return;
    L7:
        ListenerType r14 = ListenerType.MAIN;
        Map<Integer, a0> r15 = r13.B(r14);
        ListenerType r16 = ListenerType.NOTIFICATION;
        Map<Integer, a0> r17 = r13.B(r16);
        if (r13.i() == false) goto L10;
    L13:
        boolean r18 = true;
    L14:
        com.ss.android.socialbase.downloader.utils.e.a(r11, r15, true, r10, r12, r14, r13);
        com.ss.android.socialbase.downloader.utils.e.a(r11, r17, r18, r10, r12, r16, r13);
        return;
    L10:
        if (r10.isAutoInstallWithoutNotification() == true) goto L13;
        r18 = false;
        goto L14
    }

    private synchronized boolean H(int r10) {
        monitor-enter(this);
    L41:
        th = move-exception;
        throw th;
    L4:
        if (lb.a.a() == false) goto L6;
        lb.a.g("AbsDownloadEngine", r10, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L41
    L6:
        DownloadInfo r11 = this.f7934h.a(r10);     // Catch: Throwable -> L41
        if (r11 != null) goto L10;
    L13:
        SparseArray<com.ss.android.socialbase.downloader.model.d> r12 = this.f7927a;     // Catch: Throwable -> L41
        monitor-enter(r12);     // Catch: Throwable -> L41
        n(r10);     // Catch: Throwable -> L38
        monitor-exit(r12);     // Catch: Throwable -> L38
    L18:
        if (r11 != null) goto L25;
        com.ss.android.socialbase.downloader.model.d r13 = this.f7927a.get(r10);     // Catch: Throwable -> L41
        if (r13 == null) goto L36;
        new jb.e(r13, this.f7936j).o();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L36:
        monitor-exit(this);
        return false;
    L25:
        if (r11.getStatus() != 1) goto L32;
        com.ss.android.socialbase.downloader.model.d r14 = this.f7927a.get(r10);     // Catch: Throwable -> L41
        if (r14 == null) goto L36;
        new jb.e(r14, this.f7936j).o();     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L32:
        if (ab.d.b(r11.getStatus()) == false) goto L36;
        r11.setStatus(-2);     // Catch: Throwable -> L41
        monitor-exit(this);
        return true;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L10:
        if (r11.getStatus() != 11) goto L13;
        monitor-exit(this);
        return false;
    }

    private void L(int r10, int r11) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("AbsDownloadEngine", r10, "removeTask", "Listener hashCode: " + r11);
    L5:
        if (r11 != 0) goto L8;
    L6:
        this.f7927a.remove(r10);
        SparseArray r12 = this.f7931e;
    L7:
        r12.remove(r10);
        return;
    L8:
        SparseArray<com.ss.android.socialbase.downloader.model.d> r13 = this.f7931e.get(r10);
        if (r13 == null) goto L16;
        r13.remove(r11);
        if (lb.a.a() == false) goto L14;
        lb.a.g("AbsDownloadEngine", r10, "removeTask", "After downloadTaskWithListenerMap removeTask taskArray.size: " + r13.size());
    L14:
        if (r13.size() == 0) goto L6;
        return;
    L16:
        r12 = this.f7927a;
        goto L7
    }

    private void N(int r10, boolean r11) {
        if (this.f7935i == true) goto L33;
        O(r10, r11);
        return;
    L33:
        DownloadInfo r12 = this.f7934h.a(r10);     // Catch: Throwable -> L26
        if (r12 == null) goto L31;
        com.ss.android.socialbase.downloader.utils.g.j(r12, r11);     // Catch: Throwable -> L26
        r12.erase();     // Catch: Throwable -> L26
    L31:
        this.f7934h.b(r12);     // Catch: SQLiteException -> L11 Throwable -> L26
    L13:
        monitor-enter(this);     // Catch: Throwable -> L26
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L15:
        if (this.f7929c.get(r10) == null) goto L18;
        this.f7929c.remove(r10);     // Catch: Throwable -> L23
    L18:
        if (this.f7928b.get(r10) == null) goto L20;
        this.f7928b.remove(r10);     // Catch: Throwable -> L23
    L20:
        this.f7932f.remove(Integer.valueOf(r10));     // Catch: Throwable -> L23
        rb.a.v(r10);     // Catch: Throwable -> L23
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

    private void O(int r10, boolean r11) {
        DownloadInfo r12 = this.f7934h.a(r10);     // Catch: Throwable -> L17
        if (r12 == null) goto L20;
        com.ss.android.socialbase.downloader.utils.g.j(r12, r11);     // Catch: Throwable -> L17
        r12.erase();     // Catch: Throwable -> L17
    L20:
        this.f7934h.b(r12);     // Catch: SQLiteException -> L7 Throwable -> L17
    L10:
        if (this.f7929c.get(r10) == null) goto L13;
        this.f7929c.remove(r10);     // Catch: Throwable -> L17
    L13:
        if (this.f7928b.get(r10) == null) goto L15;
        this.f7928b.remove(r10);     // Catch: Throwable -> L17
    L15:
        this.f7932f.remove(Integer.valueOf(r10));     // Catch: Throwable -> L17
        rb.a.v(r10);     // Catch: Throwable -> L17
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    private void Y(com.ss.android.socialbase.downloader.model.d r10) {
        int r11 = r10.E();
        if (r11 == 0) goto L5;
    L7:
        if (r11 != 0) goto L9;
        return;
    L9:
        SparseArray<com.ss.android.socialbase.downloader.model.d> r12 = this.f7931e.get(r10.x());
        if (r12 != null) goto L13;
        r12 = new SparseArray();
        this.f7931e.put(r10.x(), r12);
    L13:
        if (lb.a.a() == false) goto L15;
        lb.a.g("AbsDownloadEngine", r10.x(), "tryCacheSameTaskWithListenerHashCode", "Listener hashCode:" + r11);
    L15:
        r12.put(r11, r10);
        return;
    L5:
        if (r10.O() == false) goto L7;
        r11 = r10.g();
        goto L7
    }

    static /* synthetic */ com.ss.android.socialbase.downloader.model.d a(a r10, int r11) {
        return r10.x(r11);
    }

    private void a0(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        DownloadInfo r11 = r10.y();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.isEntityInvalid() == false) goto L11;
        lb.a.h("AbsDownloadEngine", r11.getId(), "tryDownload", "entity invalid");
        mb.a.n(r10.G(), r11, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is Invalid, url is " + r11.getUrl() + " name is " + r11.getName() + " savePath is " + r11.getSavePath()), r11.getStatus());
        return;
    L11:
        r10.M().f8183c = System.currentTimeMillis();
        boolean r12 = true;
        com.ss.android.socialbase.downloader.downloader.a.O0(r10, true);
        int r13 = 0;
        if (rb.a.g(r11.getId()).o("no_net_opt", 0) == 1) goto L14;
    L21:
        int r14 = r11.getId();
        if (lb.a.a() == false) goto L25;
        lb.a.g("AbsDownloadEngine", r14, "tryDownload", "Url: " + r11.getUrl() + " savePath: " + r11.getSavePath() + " saveName: " + r11.getName());
    L25:
        if (this.f7929c.get(r14) == null) goto L28;
        this.f7929c.remove(r14);
    L28:
        if (this.f7928b.get(r14) == null) goto L31;
        this.f7928b.remove(r14);
    L31:
        if (this.f7930d.get(r14) == null) goto L34;
        this.f7930d.remove(r14);
    L34:
        if (C(r14) == false) goto L43;
        if (r11.canReStartAsyncTask() == true) goto L43;
        if (lb.a.a() == false) goto L40;
        lb.a.g("AbsDownloadEngine", r14, "tryDownload", "Another task with same id is downloading when tryDownload");
    L40:
        r10.d();
        mb.a.n(r10.G(), r11, new BaseException(PointerIconCompat.TYPE_HELP, "downloadInfo is isDownloading and addListenerToSameTask is false"), r11.getStatus());
        return;
    L43:
        if (lb.a.a() == false) goto L46;
        lb.a.g("AbsDownloadEngine", r14, "tryDownload", "No downloading task");
    L46:
        if (r11.canReStartAsyncTask() == false) goto L48;
        r11.setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_RESTART);
    L48:
        com.ss.android.socialbase.downloader.model.d r15 = this.f7932f.remove(Integer.valueOf(r14));
        if (r15 == null) goto L52;
        r10.j(r15);
    L52:
        if ("mime_type_plg".equals(r11.getMimeType()) == false) goto L54;
        r10.y().safePutToDBJsonData("executor_group", 3);
    L54:
        com.ss.android.socialbase.downloader.model.d r16 = this.f7927a.get(r14);
        if (r16 == null) goto L63;
        DownloadInfo r17 = r16.y();
        if (r17 == null) goto L63;
        int r18 = r17.getStatus();
        if (ab.d.b(r18) == true) goto L62;
        r12 = false;
    L62:
        r13 = r18;
    L65:
        if (lb.a.a() == false) goto L67;
        lb.a.g("AbsDownloadEngine", r14, "tryDownload", "Can add listener " + r12 + " , oldTaskStatus is :" + r13);
    L67:
        if (r12 == false) goto L69;
        r10.d();
        return;
    L69:
        Y(r10);
        this.f7927a.put(r14, r10);
        l(r10);
        return;
    L63:
        r12 = false;
        goto L65
    L14:
        if (com.ss.android.socialbase.downloader.utils.g.Q(com.ss.android.socialbase.downloader.downloader.a.h()) == true) goto L21;
        if (r11.isFirstDownload() == true) goto L21;
        if (rb.a.d().optBoolean("disable_check_no_network") == true) goto L21;
        new jb.e(r10, this.f7936j).l(new BaseException(1049, "network_not_available"));
    }

    static /* synthetic */ void b(a r10, int r11, boolean r12) {
        r10.N(r11, r12);
    }

    private void b0(int r10) {
        if (this.f7933g.isEmpty() == false) goto L5;
        return;
    L5:
        com.ss.android.socialbase.downloader.model.d r11 = this.f7933g.getFirst();
        if (r11 == null) goto L11;
        if (r11.x() != r10) goto L11;
        this.f7933g.poll();
    L11:
        if (this.f7933g.isEmpty() == false) goto L13;
        return;
    L13:
        com.ss.android.socialbase.downloader.model.d r12 = this.f7933g.getFirst();
        if (r12 == null) goto L17;
        a0(r12);
        return;
    }

    private synchronized void e(int r10, int r11, a0 r12, ListenerType r13, boolean r14, boolean r15) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r16 = x(r10);     // Catch: Throwable -> L31
        if (r16 == null) goto L21;
        r16.c(r11, r12, r13, r14);     // Catch: Throwable -> L31
        DownloadInfo r17 = r16.y();     // Catch: Throwable -> L31
        if (r15 == false) goto L29;
        if (r17 == null) goto L29;
        if (C(r10) == true) goto L29;
        if (r13 != ListenerType.MAIN) goto L13;
    L14:
        boolean r18 = true;
        if (r13 == ListenerType.NOTIFICATION) goto L17;
    L19:
        if (r18 == false) goto L29;
        this.f7936j.post(new h(this, r12, r17, r16, r13));     // Catch: Throwable -> L31
        goto L29
    L17:
        if (r17.canShowNotification() == true) goto L19;
        r18 = false;
        goto L19
    L13:
        if (r13 == ListenerType.NOTIFICATION) goto L14;
    L29:
        monitor-exit(this);
        return;
    L21:
        DownloadInfo r19 = this.f7934h.a(r10);     // Catch: Throwable -> L31
        if (r19 == null) goto L29;
        if (r19.getStatus() == (-3)) goto L29;
        com.ss.android.socialbase.downloader.model.d r20 = this.f7932f.get(Integer.valueOf(r10));     // Catch: Throwable -> L31
        if (r20 != null) goto L28;
        r20 = new com.ss.android.socialbase.downloader.model.d(r19);     // Catch: Throwable -> L31
        this.f7932f.put(Integer.valueOf(r10), r20);     // Catch: Throwable -> L31
    L28:
        r20.c(r11, r12, r13, r14);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    private synchronized boolean g(int r10, boolean r11) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (lb.a.a() == false) goto L6;
        lb.a.g("AbsDownloadEngine", r10, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        com.ss.android.socialbase.downloader.model.d r12 = x(r10);     // Catch: Throwable -> L16
        if (r12 == null) goto L9;
        DownloadInfo r13 = r12.y();     // Catch: Throwable -> L16
        this.f7936j.post(new b(this, r12.B(ListenerType.MAIN), r13, r12, r12.B(ListenerType.NOTIFICATION)));     // Catch: Throwable -> L16
    L9:
        DownloadInfo r14 = this.f7934h.a(r10);     // Catch: Throwable -> L16
        if (r14 == null) goto L12;
        r14.setStatus(-4);     // Catch: Throwable -> L16
    L12:
        h(r10, r11, false);     // Catch: Throwable -> L16
        monitor-exit(this);
        return true;
    }

    private synchronized void j(int r10, boolean r11, boolean r12) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (lb.a.a() == false) goto L34;
        lb.a.g("AbsDownloadEngine", r10, "clearDownloadDataInSubThread", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12);     // Catch: Throwable -> L30
    L34:
        DownloadInfo r13 = this.f7934h.a(r10);     // Catch: Throwable -> L26
        if (r13 == null) goto L36;
        if (r11 == false) goto L12;
        if (r12 == false) goto L11;
        new kb.a(r13.getSavePath(), r13.getName(), false, false).l();     // Catch: Throwable -> L26
    L11:
        com.ss.android.socialbase.downloader.utils.g.j(r13, r11);     // Catch: Throwable -> L26
    L13:
        r13.erase();     // Catch: Throwable -> L26
        goto L36
    L12:
        com.ss.android.socialbase.downloader.utils.g.l(r13.getTempPath(), r13.getTempName());     // Catch: Throwable -> L26
    L36:
        this.f7934h.j(r10);     // Catch: SQLiteException -> L16 Throwable -> L26
    L18:
        I(r10, 0, -4);     // Catch: Throwable -> L26
        if (this.f7929c.get(r10) == null) goto L22;
        this.f7929c.remove(r10);     // Catch: Throwable -> L26
    L22:
        if (this.f7928b.get(r10) == null) goto L24;
        this.f7928b.remove(r10);     // Catch: Throwable -> L26
    L24:
        this.f7932f.remove(Integer.valueOf(r10));     // Catch: Throwable -> L26
        rb.a.v(r10);     // Catch: Throwable -> L26
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

    private void p(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        DownloadInfo r11 = r10.y();
        if (r11 != null) goto L8;
        return;
    L8:
        if (k.j(r11) == false) goto L40;
        k.f().d(r10);
        return;
    L40:
        if (this.f7933g.isEmpty() == false) goto L16;
        a0(r10);     // Catch: InterruptedException -> L39
    L14:
        this.f7933g.put(r10);     // Catch: InterruptedException -> L39
        return;
    L16:
        if (r11.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) goto L18;
        com.ss.android.socialbase.downloader.model.d r12 = this.f7933g.getFirst();     // Catch: InterruptedException -> L39
        if (r12.x() == r10.x()) goto L33;
    L35:
        G(r12.x());     // Catch: InterruptedException -> L39
        a0(r10);     // Catch: InterruptedException -> L39
        if (r12.x() == r10.x()) goto L48;
        this.f7933g.putFirst(r10);     // Catch: InterruptedException -> L39
        return;
    L48:
        return;
    L33:
        if (C(r10.x()) == false) goto L35;
        return;
    L18:
        if (this.f7933g.getFirst().x() == r10.x()) goto L20;
    L22:
        Iterator<com.ss.android.socialbase.downloader.model.d> r13 = this.f7933g.iterator();     // Catch: InterruptedException -> L39
    L24:
        if (r13.hasNext() == false) goto L14;
        com.ss.android.socialbase.downloader.model.d r14 = r13.next();     // Catch: InterruptedException -> L39
        if (r14 == null) goto L24;
        if (r14.x() != r10.x()) goto L24;
        r13.remove();     // Catch: InterruptedException -> L39
        goto L14
    L20:
        if (C(r10.x()) == false) goto L22;
        return;
    }

    private synchronized DownloadInfo t(int r10) {
        monitor-enter(this);
        DownloadInfo r11 = this.f7934h.a(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        com.ss.android.socialbase.downloader.model.d r12 = this.f7927a.get(r10);     // Catch: Throwable -> L10
        if (r12 == null) goto L8;
        r11 = r12.y();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r11;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized List<DownloadInfo> v(String r10) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L6;
        List<DownloadInfo> r11 = this.f7934h.l(r10);     // Catch: Throwable -> L27
        if (r11 != null) goto L11;
    L15:
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L27
        int r13 = this.f7927a.size();     // Catch: Throwable -> L27
        int r14 = 0;
    L16:
        if (r14 >= r13) goto L25;
        com.ss.android.socialbase.downloader.model.d r15 = this.f7927a.valueAt(r14);     // Catch: Throwable -> L27
        if (r15 == null) goto L24;
        if (r15.y() == null) goto L24;
        if (r10.equals(r15.y().getUrl()) == false) goto L24;
        r12.add(r15.y());     // Catch: Throwable -> L27
    L24:
        r14 = r14 + 1;
        goto L16
    L25:
        monitor-exit(this);
        return r12;
    L11:
        if (r11.isEmpty() == true) goto L15;
        monitor-exit(this);
        return r11;
    L6:
        monitor-exit(this);
        return null;
    }

    private com.ss.android.socialbase.downloader.model.d x(int r10) {
        if (this.f7935i == false) goto L5;
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        r11 = this.f7929c.get(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        r11 = this.f7928b.get(r10);     // Catch: Throwable -> L16
        if (r11 != null) goto L14;
        r11 = this.f7930d.get(r10);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return r11;
    L16:
        th = move-exception;
        throw th;
    L5:
        return z(r10);
    }

    private com.ss.android.socialbase.downloader.model.d z(int r10) {
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);
        if (r11 != null) goto L10;
        com.ss.android.socialbase.downloader.model.d r12 = this.f7929c.get(r10);
        if (r12 != null) goto L11;
        com.ss.android.socialbase.downloader.model.d r13 = this.f7928b.get(r10);
        if (r13 == null) goto L9;
        return r13;
    L9:
        return this.f7930d.get(r10);
    L11:
        return r12;
    L10:
        return r11;
    }

    public List<DownloadInfo> A(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return null;
    L6:
        Iterator<Integer> r11 = q().iterator();
        ArrayList r12 = new ArrayList();
    L8:
        if (r11.hasNext() == false) goto L14;
        DownloadInfo r13 = s(r11.next().intValue());
        if (r13 == null) goto L8;
        if (r10.equals(r13.getMimeType()) == false) goto L8;
        r12.add(r13);
        goto L8
    L14:
        return r12;
    }

    public synchronized k0 B(int r10) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);     // Catch: Throwable -> L26
        if (r11 == null) goto L8;
        k0 r12 = r11.H();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r12;
    L8:
        com.ss.android.socialbase.downloader.model.d r13 = this.f7928b.get(r10);     // Catch: Throwable -> L26
        if (r13 == null) goto L13;
        k0 r14 = r13.H();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r14;
    L13:
        com.ss.android.socialbase.downloader.model.d r15 = this.f7929c.get(r10);     // Catch: Throwable -> L26
        if (r15 == null) goto L18;
        k0 r16 = r15.H();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r16;
    L18:
        com.ss.android.socialbase.downloader.model.d r17 = this.f7930d.get(r10);     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        k0 r18 = r17.H();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r18;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public abstract boolean C(int r10);

    public synchronized boolean D(int r10) {
        monitor-enter(this);
        if (r10 != 0) goto L15;
    L12:
        boolean r11 = false;
    L13:
        monitor-exit(this);
        return r11;
    L15:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f7927a.get(r10) != null) goto L8;
        if (this.f7929c.get(r10) == null) goto L12;
    L8:
        r11 = true;
        goto L13
    }

    public boolean G(int r10) {
        if (this.f7935i == true) goto L7;
        return H(r10);
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g("AbsDownloadEngine", r10, "pause", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        DownloadInfo r11 = this.f7934h.a(r10);
        if (r11 != null) goto L12;
    L14:
        n(r10);
        monitor-enter(this);
        if (r11 != null) goto L24;
        com.ss.android.socialbase.downloader.model.d r12 = this.f7927a.get(r10);     // Catch: Throwable -> L37
        if (r12 == null) goto L35;
        new jb.e(r12, this.f7936j).o();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L35:
        monitor-exit(this);     // Catch: Throwable -> L37
        return false;
    L24:
        if (r11.getStatus() != 1) goto L31;
        com.ss.android.socialbase.downloader.model.d r13 = this.f7927a.get(r10);     // Catch: Throwable -> L37
        if (r13 == null) goto L35;
        new jb.e(r13, this.f7936j).o();     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L31:
        if (ab.d.b(r11.getStatus()) == false) goto L35;
        r11.setStatus(-2);     // Catch: Throwable -> L37
        monitor-exit(this);     // Catch: Throwable -> L37
        return true;
    L37:
        th = move-exception;
        throw th;
    L12:
        if (r11.getStatus() != 11) goto L14;
        return false;
    }

    public void I(int r10, int r11, int r12) {
        if (r12 != (-7)) goto L5;
    L48:
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r13 = this.f7927a.get(r10);     // Catch: Throwable -> L58
        if (r13 != null) goto L52;
    L55:
        b0(r10);     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L52:
        if (this.f7929c.get(r10) != null) goto L54;
        this.f7929c.put(r10, r13);     // Catch: Throwable -> L58
    L54:
        L(r10, r11);     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        throw th;
    L5:
        if (r12 != (-6)) goto L7;
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r14 = this.f7927a.get(r10);     // Catch: Throwable -> L45
        this.f7928b.put(r10, r14);     // Catch: Throwable -> L45
        L(r10, r11);     // Catch: Throwable -> L45
        monitor-exit(this);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        throw th;
    L7:
        if (r12 != (-4)) goto L9;
        monitor-enter(this);
        L(r10, r11);     // Catch: Throwable -> L38
        b0(r10);     // Catch: Throwable -> L38
        monitor-exit(this);     // Catch: Throwable -> L38
        return;
    L38:
        th = move-exception;
        throw th;
    L9:
        if (r12 != (-3)) goto L11;
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r15 = this.f7927a.get(r10);     // Catch: Throwable -> L31
        this.f7928b.put(r10, r15);     // Catch: Throwable -> L31
        L(r10, r11);     // Catch: Throwable -> L31
        b0(r10);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        throw th;
    L11:
        if (r12 == (-1)) goto L48;
        if (r12 != 8) goto L75;
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r16 = this.f7927a.get(r10);     // Catch: Throwable -> L24
        if (r16 != null) goto L19;
    L21:
        b0(r10);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L19:
        if (this.f7930d.get(r10) != null) goto L21;
        this.f7930d.put(r10, r16);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void J(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r15 = x(r10);     // Catch: Throwable -> L10
        if (r15 != null) goto L6;
        r15 = this.f7932f.get(Integer.valueOf(r10));     // Catch: Throwable -> L10
    L6:
        if (r15 == null) goto L8;
        r15.b0(r11, r12, r13, r14);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public abstract void K(bb.c r10);

    public void M(int r10, boolean r11) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("AbsDownloadEngine", r10, "resetDownloadData", "DeleteFile:" + r11 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.f7936j.post(new e(this, r10));
        com.ss.android.socialbase.downloader.downloader.a.H0(new f(this, r10, r11), false);
    }

    public synchronized boolean P(int r10) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (lb.a.a() == false) goto L6;
        lb.a.g("AbsDownloadEngine", r10, "restart", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L17
    L6:
        com.ss.android.socialbase.downloader.model.d r11 = this.f7929c.get(r10);     // Catch: Throwable -> L17
        if (r11 == null) goto L15;
        DownloadInfo r12 = r11.y();     // Catch: Throwable -> L17
        if (r12 == null) goto L11;
        r12.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
    L11:
        Z(r11);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L15:
        monitor-exit(this);
        return false;
    }

    public synchronized void Q(List<String> r10) {
        monitor-enter(this);
        boolean r11 = com.ss.android.socialbase.downloader.utils.g.T(com.ss.android.socialbase.downloader.downloader.a.h());     // Catch: Throwable -> L27 Exception -> L29
        int r12 = 0;
    L4:
        if (r12 >= this.f7929c.size()) goto L31;
        com.ss.android.socialbase.downloader.model.d r13 = this.f7929c.get(this.f7929c.keyAt(r12));     // Catch: Throwable -> L27 Exception -> L29
        if (r13 == null) goto L26;
        DownloadInfo r14 = r13.y();     // Catch: Throwable -> L27 Exception -> L29
        if (r14 == null) goto L26;
        if (r14.isOnlyWifi() == false) goto L16;
        if (r11 == false) goto L26;
    L16:
        if (rb.a.g(r14.getId()).o("auto_resume", 0) != 1) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L21;
    L25:
        r14.setAutoResumed(true);     // Catch: Throwable -> L27 Exception -> L29
        r14.setShowNotificationForNetworkResumed(true);     // Catch: Throwable -> L27 Exception -> L29
        Z(r13);     // Catch: Throwable -> L27 Exception -> L29
        goto L26
    L21:
        if (r14.getMimeType() == null) goto L26;
        if (r10.contains(r14.getMimeType()) == true) goto L25;
    L18:
        r15 = false;
    L26:
        r12 = r12 + 1;
    L31:
        monitor-exit(this);
        return;
    L27:
        th = move-exception;
        throw th;
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        goto L31
    }

    public synchronized void R(List<String> r10) {
        monitor-enter(this);
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
    L30:
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    L4:
        if (com.ss.android.socialbase.downloader.utils.g.T(com.ss.android.socialbase.downloader.downloader.a.h()) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r11 = 0;
    L9:
        if (r11 >= this.f7927a.size()) goto L30;
        int r12 = this.f7927a.keyAt(r11);     // Catch: Throwable -> L26 Exception -> L28
        com.ss.android.socialbase.downloader.model.d r13 = this.f7927a.get(r12);     // Catch: Throwable -> L26 Exception -> L28
        if (r13 == null) goto L25;
        DownloadInfo r14 = r13.y();     // Catch: Throwable -> L26 Exception -> L28
        if (r14 == null) goto L25;
        if (r14.getMimeType() == null) goto L25;
        if (r10.contains(r14.getMimeType()) == false) goto L25;
        if (E(r14) == false) goto L25;
        r14.setAutoResumed(true);     // Catch: Throwable -> L26 Exception -> L28
        r14.setShowNotificationForNetworkResumed(true);     // Catch: Throwable -> L26 Exception -> L28
        Z(r13);     // Catch: Throwable -> L26 Exception -> L28
        r14.setDownloadFromReserveWifi(true);     // Catch: Throwable -> L26 Exception -> L28
        t r15 = jb.f.u(com.ss.android.socialbase.downloader.downloader.a.h()).g();     // Catch: Throwable -> L26 Exception -> L28
        if (r15 == null) goto L25;
        r15.a(r14, 5, 2);     // Catch: Throwable -> L26 Exception -> L28
    L25:
        r11 = r11 + 1;
        goto L9
    }

    public synchronized boolean S(int r10) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r11 = this.f7930d.get(r10);     // Catch: Throwable -> L14
        if (r11 == null) goto L13;
        DownloadInfo r12 = r11.y();     // Catch: Throwable -> L14
        if (r12 == null) goto L13;
        if (r12.canReStartAsyncTask() == false) goto L10;
        Z(r11);     // Catch: Throwable -> L14
    L10:
        boolean r13 = true;
    L11:
        monitor-exit(this);
        return r13;
    L13:
        r13 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized boolean T(int r10) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (lb.a.a() == false) goto L6;
        lb.a.g("AbsDownloadEngine", r10, "resume", "Trace:" + Log.getStackTraceString(new Throwable()));     // Catch: Throwable -> L16
    L6:
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);     // Catch: Throwable -> L16
        if (r11 == null) goto L12;
        DownloadInfo r12 = r11.y();     // Catch: Throwable -> L16
        if (r12 == null) goto L11;
        r12.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L16
    L11:
        Z(r11);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return true;
    L12:
        P(r10);     // Catch: Throwable -> L16
        goto L14
    }

    public synchronized void U(int r10, d0 r11) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r12 = this.f7927a.get(r10);     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.g0(r11);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void V(int r10, boolean r11) {
        DownloadInfo r12 = this.f7934h.a(r10);
        if (r12 == null) goto L5;
        r12.setDynamicThrottleEnable(r11);
    L5:
        m(r10, r11);
    }

    public void W(int r10, long r11, int r12) {
        DownloadInfo r13 = this.f7934h.a(r10);
        if (r13 == null) goto L5;
        r13.setThrottleNetSpeed(r11, r12);
    L5:
        o(r10, r11, r12);
    }

    public void X() {
        List<Integer> r10 = q();
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<Integer> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        G(r11.next().intValue());
        goto L7
    }

    public synchronized void Z(com.ss.android.socialbase.downloader.model.d r10) {
        monitor-enter(this);
        if (r10 != null) goto L20;
        monitor-exit(this);
        return;
    L20:
        DownloadInfo r11 = r10.y();     // Catch: Throwable -> L17
        if (r11 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        r11.setDownloadFromReserveWifi(false);     // Catch: Throwable -> L17
        if (r11.getEnqueueType() == EnqueueType.ENQUEUE_NONE) goto L14;
        p(r10);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L14:
        a0(r10);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public void c(int r10, int r11, a0 r12, ListenerType r13, boolean r14) {
        d(r10, r11, r12, r13, r14, true);
    }

    public void d(int r10, int r11, a0 r12, ListenerType r13, boolean r14, boolean r15) {
        if (this.f7935i == true) goto L6;
        e(r10, r11, r12, r13, r14, r15);
        return;
    L6:
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r16 = x(r10);     // Catch: Throwable -> L42
        if (r16 == null) goto L27;
        r16.c(r11, r12, r13, r14);     // Catch: Throwable -> L42
        DownloadInfo r17 = r16.y();     // Catch: Throwable -> L42
        if (r15 == false) goto L25;
        if (r17 == null) goto L25;
        if (C(r10) == true) goto L25;
        if (r13 != ListenerType.MAIN) goto L17;
    L18:
        boolean r18 = true;
        if (r13 == ListenerType.NOTIFICATION) goto L21;
    L23:
        if (r18 == false) goto L25;
        int r19 = r17.getStatus();     // Catch: Throwable -> L42
        this.f7936j.post(new g(this, r12, r19, r17, r16, r13));     // Catch: Throwable -> L42
        goto L25
    L21:
        if (r17.canShowNotification() == true) goto L23;
        r18 = false;
        goto L23
    L17:
        if (r13 == ListenerType.NOTIFICATION) goto L18;
    L25:
        monitor-exit(this);     // Catch: Throwable -> L42
        return;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L42
        DownloadInfo r110 = this.f7934h.a(r10);
        monitor-enter(this);
        if (r110 != null) goto L45;
    L37:
        monitor-exit(this);     // Catch: Throwable -> L39
        return;
    L39:
        th = move-exception;
        throw th;
    L45:
        if (r110.getStatus() == (-3)) goto L37;
        com.ss.android.socialbase.downloader.model.d r20 = this.f7932f.get(Integer.valueOf(r10));     // Catch: Throwable -> L39
        if (r20 != null) goto L36;
        r20 = new com.ss.android.socialbase.downloader.model.d(r110);     // Catch: Throwable -> L39
        this.f7932f.put(Integer.valueOf(r10), r20);     // Catch: Throwable -> L39
    L36:
        r20.c(r11, r12, r13, r14);     // Catch: Throwable -> L39
    L42:
        th = move-exception;
        throw th;
    }

    public boolean f(int r10, boolean r11) {
        if (this.f7935i == true) goto L7;
        return g(r10, r11);
    L7:
        if (lb.a.a() == false) goto L9;
        lb.a.g("AbsDownloadEngine", r10, "cancel", "Trace:" + Log.getStackTraceString(new Throwable()));
    L9:
        com.ss.android.socialbase.downloader.model.d r12 = x(r10);
        if (r12 == null) goto L15;
        DownloadInfo r13 = r12.y();
        if (r13 == null) goto L14;
        r13.setStatus(-4);
    L14:
        this.f7936j.post(new RunnableC0144a(this, r12.B(ListenerType.MAIN), r13, r12, r12.B(ListenerType.NOTIFICATION)));
    L15:
        DownloadInfo r14 = this.f7934h.a(r10);
        if (r14 == null) goto L18;
        r14.setStatus(-4);
    L18:
        h(r10, r11, false);
        return true;
    }

    public void h(int r10, boolean r11, boolean r12) {
        if (lb.a.a() == false) goto L5;
        lb.a.g("AbsDownloadEngine", r10, "clearDownloadData", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12 + "Trace:" + Log.getStackTraceString(new Throwable()));
    L5:
        this.f7936j.post(new c(this, r10));
        com.ss.android.socialbase.downloader.downloader.a.H0(new d(this, r10, r11, r12), false);
    }

    @Override // sb.f.a
    public void handleMsg(Message r10) {
        int r11 = r10.arg1;
        int r12 = r10.arg2;
        if (lb.a.a() == false) goto L5;
        lb.a.g("AbsDownloadEngine", r11, "handleMsg", "Listener hashCode: " + r12);
    L5:
        Object r13 = r10.obj;
        com.ss.android.socialbase.downloader.model.d r14 = null;
        if ((r13 instanceof Exception) == false) goto L8;
        BaseException r15 = (BaseException) r13;
    L9:
        monitor-enter(this);
        if (r12 != 0) goto L13;
        com.ss.android.socialbase.downloader.model.d r16 = this.f7927a.get(r11);     // Catch: Throwable -> L22
    L12:
        r14 = r16;     // Catch: Throwable -> L22
    L16:
        if (r14 != null) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L19:
        F(r10.what, r15, r14);     // Catch: Throwable -> L22
        I(r11, r12, r10.what);     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L13:
        SparseArray<com.ss.android.socialbase.downloader.model.d> r17 = this.f7931e.get(r11);     // Catch: Throwable -> L22
        if (r17 == null) goto L16;
        r16 = r17.get(r12);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L8:
        r15 = null;
        goto L9
    }

    public void i(int r10, boolean r11, boolean r12) {
        if (this.f7935i == true) goto L7;
        j(r10, r11, r12);
        return;
    L7:
        if (lb.a.a() == false) goto L42;
        lb.a.g("AbsDownloadEngine", r10, "clearDownloadDataInSubThread", "DeleteFile:" + r11 + " deleteFileIgnoreSecurity:" + r12);
    L42:
        DownloadInfo r13 = this.f7934h.a(r10);     // Catch: Throwable -> L35
        if (r13 == null) goto L40;
        if (r11 == false) goto L15;
        if (r12 == false) goto L14;
        new kb.a(r13.getSavePath(), r13.getName(), false, false).l();     // Catch: Throwable -> L35
    L14:
        com.ss.android.socialbase.downloader.utils.g.j(r13, r11);     // Catch: Throwable -> L35
    L16:
        r13.erase();     // Catch: Throwable -> L35
        goto L40
    L15:
        com.ss.android.socialbase.downloader.utils.g.l(r13.getTempPath(), r13.getTempName());     // Catch: Throwable -> L35
    L40:
        this.f7934h.j(r10);     // Catch: SQLiteException -> L19 Throwable -> L35
    L21:
        monitor-enter(this);     // Catch: Throwable -> L35
        I(r10, 0, -4);     // Catch: Throwable -> L32
        if (this.f7929c.get(r10) == null) goto L27;
        this.f7929c.remove(r10);     // Catch: Throwable -> L32
    L27:
        if (this.f7928b.get(r10) == null) goto L29;
        this.f7928b.remove(r10);     // Catch: Throwable -> L32
    L29:
        this.f7932f.remove(Integer.valueOf(r10));     // Catch: Throwable -> L32
        rb.a.v(r10);     // Catch: Throwable -> L32
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

    protected abstract bb.c k(int r10);

    protected abstract void l(com.ss.android.socialbase.downloader.model.d r10);

    public abstract void m(int r10, boolean r11);

    protected abstract void n(int r10);

    public abstract void o(int r10, long r11, int r12);

    protected abstract List<Integer> q();

    public synchronized u r(int r10) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);     // Catch: Throwable -> L26
        if (r11 == null) goto L8;
        u r12 = r11.C();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r12;
    L8:
        com.ss.android.socialbase.downloader.model.d r13 = this.f7928b.get(r10);     // Catch: Throwable -> L26
        if (r13 == null) goto L13;
        u r14 = r13.C();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r14;
    L13:
        com.ss.android.socialbase.downloader.model.d r15 = this.f7929c.get(r10);     // Catch: Throwable -> L26
        if (r15 == null) goto L18;
        u r16 = r15.C();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r16;
    L18:
        com.ss.android.socialbase.downloader.model.d r17 = this.f7930d.get(r10);     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        u r18 = r17.C();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r18;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public DownloadInfo s(int r10) {
        if (this.f7935i == false) goto L5;
        DownloadInfo r11 = this.f7934h.a(r10);
        if (r11 != null) goto L17;
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r12 = this.f7927a.get(r10);     // Catch: Throwable -> L14
        if (r12 == null) goto L12;
        r11 = r12.y();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        return r11;
    L5:
        return t(r10);
    }

    public List<DownloadInfo> u(String r10) {
        if (this.f7935i == true) goto L7;
        return v(r10);
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return null;
    L10:
        List<DownloadInfo> r11 = this.f7934h.l(r10);
        if (r11 != null) goto L13;
    L16:
        monitor-enter(this);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L29
        int r13 = this.f7927a.size();     // Catch: Throwable -> L29
        int r14 = 0;
    L18:
        if (r14 >= r13) goto L27;
        com.ss.android.socialbase.downloader.model.d r15 = this.f7927a.valueAt(r14);     // Catch: Throwable -> L29
        if (r15 == null) goto L26;
        if (r15.y() == null) goto L26;
        if (r10.equals(r15.y().getUrl()) == false) goto L26;
        r12.add(r15.y());     // Catch: Throwable -> L29
    L26:
        r14 = r14 + 1;     // Catch: Throwable -> L29
        goto L18
    L27:
        monitor-exit(this);     // Catch: Throwable -> L29
        return r12;
    L29:
        th = move-exception;
        throw th;
    L13:
        if (r11.isEmpty() == true) goto L16;
        return r11;
    }

    public synchronized d0 w(int r10) {
        monitor-enter(this);
        com.ss.android.socialbase.downloader.model.d r11 = this.f7927a.get(r10);     // Catch: Throwable -> L26
        if (r11 == null) goto L8;
        d0 r12 = r11.I();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r12;
    L8:
        com.ss.android.socialbase.downloader.model.d r13 = this.f7928b.get(r10);     // Catch: Throwable -> L26
        if (r13 == null) goto L13;
        d0 r14 = r13.I();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r14;
    L13:
        com.ss.android.socialbase.downloader.model.d r15 = this.f7929c.get(r10);     // Catch: Throwable -> L26
        if (r15 == null) goto L18;
        d0 r16 = r15.I();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r16;
    L18:
        com.ss.android.socialbase.downloader.model.d r17 = this.f7930d.get(r10);     // Catch: Throwable -> L26
        if (r17 == null) goto L24;
        d0 r18 = r17.I();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r18;
    L24:
        monitor-exit(this);
        return null;
    L26:
        th = move-exception;
        throw th;
    }

    public com.ss.android.socialbase.downloader.model.d y(int r10, int r11) {
        monitor-enter(this);
        if (r11 != 0) goto L6;
        com.ss.android.socialbase.downloader.model.d r12 = this.f7927a.get(r10);     // Catch: Throwable -> L12
    L5:
        com.ss.android.socialbase.downloader.model.d r13 = r12;     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);     // Catch: Throwable -> L12
        return r13;
    L6:
        SparseArray<com.ss.android.socialbase.downloader.model.d> r14 = this.f7931e.get(r10);     // Catch: Throwable -> L12
        if (r14 == null) goto L9;
        r12 = r14.get(r11);     // Catch: Throwable -> L12
        goto L5
    L9:
        r13 = null;
    L12:
        th = move-exception;
        throw th;
    }
}
