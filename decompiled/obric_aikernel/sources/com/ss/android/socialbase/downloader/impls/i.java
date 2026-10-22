package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends jb.a implements ServiceConnection {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f7998o = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private jb.h f7999l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private jb.n f8000m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8001n;

    static {
        f7998o = i.class.getSimpleName();
    }

    public i() {
        this.f8001n = -1;
    }

    private void k() {
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r10 = this.f9794c;     // Catch: Throwable -> L29
        monitor-enter(r10);     // Catch: Throwable -> L29
        SparseArray<List<com.ss.android.socialbase.downloader.model.d>> r11 = this.f9794c.clone();     // Catch: Throwable -> L26
        this.f9794c.clear();     // Catch: Throwable -> L26
        monitor-exit(r10);     // Catch: Throwable -> L26
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.size() > 0) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.downloader.a.s() == null) goto L45;
        int r12 = 0;
    L13:
        if (r12 >= r11.size()) goto L46;
        List<com.ss.android.socialbase.downloader.model.d> r13 = r11.get(r11.keyAt(r12));     // Catch: Throwable -> L29
        if (r13 == null) goto L25;
        Iterator<com.ss.android.socialbase.downloader.model.d> r14 = r13.iterator();     // Catch: Throwable -> L29
    L18:
        if (r14.hasNext() == false) goto L25;
        this.f7999l.U1(com.ss.android.socialbase.downloader.utils.h.n(r14.next()));     // Catch: RemoteException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
    L25:
        r12 = r12 + 1;
        goto L13
    L46:
        return;
    L45:
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        lb.a.c(f7998o, "resumePendingTaskForIndependent", "Exception:" + th);
    }

    @Override // jb.a, jb.o
    public void B() {
        if (this.f7999l != null) goto L6;
        j(com.ss.android.socialbase.downloader.downloader.a.h(), this);
        return;
    }

    @Override // jb.a, jb.o
    public void C(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        jb.c.i().t(r10.x(), true);
        a r11 = com.ss.android.socialbase.downloader.downloader.a.s();
        if (r11 == null) goto L8;
        r11.Z(r10);
        return;
    }

    @Override // jb.a, jb.o
    public void a(jb.n r10) {
        this.f8000m = r10;
    }

    @Override // jb.a
    public void j(Context r10, ServiceConnection r11) {
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (lb.a.a() == false) goto L5;
        lb.a.b(f7998o, "startService", "BindService");     // Catch: Throwable -> L10
    L5:
        Intent r12 = new Intent(r10, IndependentProcessDownloadService.class);     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        r10.bindService(r12, r11, 1);     // Catch: Throwable -> L10
    L8:
        r10.startService(r12);     // Catch: Throwable -> L10
    }

    @Override // jb.a, jb.o
    public IBinder onBind(Intent r10) {
        if (lb.a.a() == false) goto L6;
        lb.a.b(f7998o, "onBind", "IndependentDownloadBinder");
    L6:
        return new h();
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r10) {
        this.f7999l = null;
        jb.n r11 = this.f8000m;
        if (r11 == null) goto L6;
        r11.M();
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r10, IBinder r11) {
        if (lb.a.a() == false) goto L5;
        lb.a.b(f7998o, "onServiceConnected", "Run");
    L5:
        this.f7999l = jb.h.a.U0(r11);
        jb.n r12 = this.f8000m;
        if (r12 == null) goto L9;
        r12.H(r11);
    L9:
        if (lb.a.a() == false) goto L16;
        String r13 = f7998o;
        StringBuilder r14 = new StringBuilder();
        r14.append("AidlService!=null");
        if (this.f7999l == null) goto L13;
        boolean r15 = true;
    L14:
        r14.append(r15);
        r14.append(" pendingTasks.size:");
        r14.append(this.f9794c.size());
        lb.a.b(r13, "onServiceConnected", r14.toString());
        goto L16
    L13:
        r15 = false;
    L16:
        if (this.f7999l == null) goto L29;
        jb.c.i().c();
        this.f9795g = true;
        this.f9796h.set(false);
        int r16 = this.f8001n;
        if (r16 == (-1)) goto L24;
        this.f7999l.x(r16);     // Catch: RemoteException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (this.f7999l == null) goto L30;
        k();
        return;
    L30:
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r10) {
        if (lb.a.a() == false) goto L5;
        lb.a.b(f7998o, "onServiceDisconnected", "Run");
    L5:
        this.f7999l = null;
        this.f9795g = false;
        jb.n r11 = this.f8000m;
        if (r11 == null) goto L9;
        r11.M();
        return;
    }

    @Override // jb.a, jb.o
    public void x(int r10) {
        jb.h r11 = this.f7999l;
        if (r11 != null) goto L10;
        this.f8001n = r10;
        return;
    L10:
        r11.x(r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // jb.a, jb.o
    public void y(com.ss.android.socialbase.downloader.model.d r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (lb.a.a() == false) goto L12;
        String r11 = f7998o;
        int r12 = r10.x();
        StringBuilder r13 = new StringBuilder();
        r13.append("AidlService == null:");
        if (this.f7999l != null) goto L9;
        boolean r14 = true;
    L10:
        r13.append(r14);
        lb.a.g(r11, r12, "tryDownload", r13.toString());
        goto L12
    L9:
        r14 = false;
    L12:
        if (this.f7999l != null) goto L14;
        g(r10);
        j(com.ss.android.socialbase.downloader.downloader.a.h(), this);
        return;
    L14:
        k();
        this.f7999l.U1(com.ss.android.socialbase.downloader.utils.h.n(r10));     // Catch: RemoteException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }
}
