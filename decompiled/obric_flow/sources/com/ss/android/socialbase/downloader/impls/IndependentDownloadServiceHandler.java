package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import td.c;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentDownloadServiceHandler extends AbsDownloadServiceHandler implements ServiceConnection {
    public IDownloadAidlService f;
    public IndependentProcessDownloadHandler g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f15698h;

    public IndependentDownloadServiceHandler() {
        this.f15698h = -1;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public final void a(Context r5, ServiceConnection r10) {
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (Logger.b() == false) goto L7;
        Logger.b("IndependentDownloadServiceHandler", "startService", "BindService");     // Catch: Throwable -> L5
    L7:
        Intent r11 = new Intent(r5, IndependentProcessDownloadService.class);     // Catch: Throwable -> L5
        if (r10 == null) goto L10;
        r5.bindService(r11, r10, 1);     // Catch: Throwable -> L5
    L10:
        r5.startService(r11);     // Catch: Throwable -> L5
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final IBinder b() {
        if (Logger.b() == false) goto L6;
        Logger.b("IndependentDownloadServiceHandler", "onBind", "IndependentDownloadBinder");
    L6:
        return new IndependentDownloadBinder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void c() {
        if (this.f == null) goto L5;
        return;
    L5:
        monitor-enter(DownloadComponentManager.class);
        Context r5 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L10
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L10
        a(r5, this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void g() {
        SparseArray r5 = this.f15508a;     // Catch: Throwable -> L22
        monitor-enter(r5);     // Catch: Throwable -> L22
        SparseArray r10 = this.f15508a.clone();     // Catch: Throwable -> L28
        this.f15508a.clear();     // Catch: Throwable -> L28
        monitor-exit(r5);     // Catch: Throwable -> L28
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.size() > 0) goto L10;
        return;
    L10:
        if (DownloadComponentManager.j() == null) goto L46;
        int r11 = 0;
    L13:
        if (r11 >= r10.size()) goto L47;
        List r12 = (List) r10.get(r10.keyAt(r11));     // Catch: Throwable -> L22
        if (r12 == null) goto L27;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L22
    L18:
        if (r13.hasNext() == false) goto L27;
        DownloadTask r14 = (DownloadTask) r13.next();     // Catch: Throwable -> L22
        this.f.a(IPCUtils.a(r14));     // Catch: Throwable -> L22 RemoteException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
    L27:
        r11 = r11 + 1;
        goto L13
    L47:
        return;
    L46:
        return;
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        c.e("Exception:", th, "IndependentDownloadServiceHandler", "resumePendingTaskForIndependent");
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r5) {
        this.f = null;
        IndependentProcessDownloadHandler r10 = this.g;
        if (r10 == null) goto L6;
        r10.f15699a = null;
        return;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r10) {
        if (Logger.b() == false) goto L5;
        Logger.b("IndependentDownloadServiceHandler", "onServiceConnected", "Run");
    L5:
        this.f = IDownloadAidlService.Stub.a(r10);
        IndependentProcessDownloadHandler r11 = this.g;
        if (r11 == null) goto L16;
        r11.f15699a = IDownloadAidlService.Stub.a(r10);
        if (DownloadHelper.b() == false) goto L16;
        IndependentProcessDownloadHandler.AnonymousClass1 r12 = new IndependentProcessDownloadHandler.AnonymousClass1();
        if (r11.f15699a == null) goto L16;
        r11.f15699a.a(IPCUtils.a(r12));     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (Logger.b() == false) goto L23;
        StringBuilder r13 = new StringBuilder("AidlService!=null");
        if (this.f == null) goto L20;
        boolean r14 = true;
    L21:
        r13.append(r14);
        r13.append(" pendingTasks.size:");
        r13.append(this.f15508a.size());
        Logger.b("IndependentDownloadServiceHandler", "onServiceConnected", r13.toString());
        goto L23
    L20:
        r14 = false;
    L23:
        if (this.f == null) goto L48;
        DownloadProcessDispatcher r15 = DownloadProcessDispatcher.a();
        ArrayList r16 = r15.f15539b;
        monitor-enter(r16);
        Iterator r17 = r15.f15539b.iterator();     // Catch: Throwable -> L34
    L28:
        if (r17.hasNext() == false) goto L36;
        if (r17.next() == null) goto L28;
        throw new ClassCastException();     // Catch: Throwable -> L34
    L36:
        monitor-exit(r16);     // Catch: Throwable -> L34
        this.f15509b = true;
        this.f15510c.set(false);
        int r18 = this.f15698h;
        if (r18 == (-1)) goto L44;
        this.f.p(r18);     // Catch: RemoteException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L44:
        if (this.f == null) goto L56;
        g();
        return;
    L56:
        return;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r5) {
        if (Logger.b() == false) goto L5;
        Logger.b("IndependentDownloadServiceHandler", "onServiceDisconnected", "Run");
    L5:
        this.f = null;
        this.f15509b = false;
        IndependentProcessDownloadHandler r10 = this.g;
        if (r10 == null) goto L9;
        r10.f15699a = null;
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void b(DownloadTask r5) {
        if (r5 == null) goto L9;
        DownloadProcessDispatcher.a().b(r5.e(), true);
        AbsDownloadEngine r10 = DownloadComponentManager.j();
        if (r10 == null) goto L8;
        r10.b(r5);
        return;
    L8:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void a(DownloadTask r10) {
        if (Logger.b() == false) goto L10;
        int r5 = r10.e();
        StringBuilder r11 = new StringBuilder("AidlService == null:");
        if (this.f != null) goto L7;
        boolean r12 = true;
    L8:
        r11.append(r12);
        Logger.a("IndependentDownloadServiceHandler", r5, null, "tryDownload", r11.toString(), false);
        goto L10
    L7:
        r12 = false;
    L10:
        if (this.f != null) goto L32;
        int r13 = r10.e();
        DownloadInfo r14 = r10.f15878a;
        SparseArray r15 = this.f15508a;
        monitor-enter(r15);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (Logger.a(r14) == false) goto L18;
        Logger.a("AbsDownloadServiceHandler", r14, "pendDownloadTask", "PendingTasks.size:" + this.f15508a.size());     // Catch: Throwable -> L16
    L18:
        List r16 = (List) this.f15508a.get(r13);     // Catch: Throwable -> L16
        if (r16 != null) goto L22;
        r16 = new ArrayList();     // Catch: Throwable -> L16
        this.f15508a.put(r13, r16);     // Catch: Throwable -> L16
    L22:
        if (Logger.a(r14) == false) goto L24;
        Logger.a("AbsDownloadServiceHandler", r14, "pendDownloadTask", "Before taskArray.size:" + r16.size());     // Catch: Throwable -> L16
    L24:
        r16.add(r10);     // Catch: Throwable -> L16
        if (Logger.a(r14) == false) goto L27;
        Logger.a("AbsDownloadServiceHandler", r14, "pendDownloadTask", "After pendingTasks.size:" + this.f15508a.size());     // Catch: Throwable -> L16
    L27:
        monitor-exit(r15);     // Catch: Throwable -> L16
        a(DownloadComponentManager.b(), this);
        return;
    L32:
        g();
        this.f.a(IPCUtils.a(r10));     // Catch: RemoteException -> L35
        return;
    L35:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public final void a(IndependentProcessDownloadHandler r5) {
        this.g = r5;
    }
}
