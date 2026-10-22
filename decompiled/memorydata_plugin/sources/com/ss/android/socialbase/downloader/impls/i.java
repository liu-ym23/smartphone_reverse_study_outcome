package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i extends com.ss.android.socialbase.downloader.downloader.a implements ServiceConnection {
    private static final String d = "i";
    private com.ss.android.socialbase.downloader.downloader.g e;
    private com.ss.android.socialbase.downloader.downloader.m f;
    private int g;

    static {
    }

    public i() {
        this.g = -1;
    }

    private void g() {
        SparseArray<List<DownloadTask>> r0 = this.f15397a;     // Catch: Throwable -> L29
        monitor-enter(r0);     // Catch: Throwable -> L29
        SparseArray<List<DownloadTask>> r1 = this.f15397a.clone();     // Catch: Throwable -> L26
        this.f15397a.clear();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.size() > 0) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.downloader.b.F() == null) goto L45;
        int r2 = 0;
    L13:
        if (r2 >= r1.size()) goto L46;
        List r3 = (List) ZeusTransformUtils.preCheckCast(r1.get(r1.keyAt(r2)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L29
    L18:
        if (r4.hasNext() == false) goto L25;
        this.e.a(com.ss.android.socialbase.downloader.utils.h.a((DownloadTask) ZeusTransformUtils.preCheckCast(r4.next(), DownloadTask.class, "com.obric.memorydata.plugin")));     // Catch: RemoteException -> L22 Throwable -> L29
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L29
    L25:
        r2 = r2 + 1;
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
        com.ss.android.socialbase.downloader.e.a.b(d, "resumePendingTaskForIndependent", "Exception:" + th);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public IBinder a(Intent r2) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(d, "onBind", "IndependentDownloadBinder");
    L6:
        return new h();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(int r2) {
        com.ss.android.socialbase.downloader.downloader.g r0 = this.e;
        if (r0 != null) goto L10;
        this.g = r2;
        return;
    L10:
        r0.h(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void a(com.ss.android.socialbase.downloader.downloader.m r3) {
        this.f = (com.ss.android.socialbase.downloader.downloader.m) ZeusTransformUtils.wrapperContextForParams(r3, com.ss.android.socialbase.downloader.downloader.m.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void b(DownloadTask r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L12;
        String r0 = d;
        int r1 = r5.getDownloadId();
        StringBuilder r2 = new StringBuilder().append("AidlService == null:");
        if (this.e != null) goto L9;
        boolean r3 = true;
    L10:
        com.ss.android.socialbase.downloader.e.a.a(r0, r1, "tryDownload", r2.append(r3).toString());
        goto L12
    L9:
        r3 = false;
    L12:
        if (this.e != null) goto L14;
        a(r5);
        startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
        return;
    L14:
        g();
        this.e.a(com.ss.android.socialbase.downloader.utils.h.a(r5));     // Catch: RemoteException -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void c(DownloadTask r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.ss.android.socialbase.downloader.downloader.c.a().a(r3.getDownloadId(), true);
        a r2 = com.ss.android.socialbase.downloader.downloader.b.F();
        if (r2 == null) goto L8;
        r2.b(r3);
        return;
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName r1) {
        this.e = null;
        com.ss.android.socialbase.downloader.downloader.m r0 = this.f;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r5, IBinder r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(d, "onServiceConnected", "Run");
    L5:
        this.e = com.ss.android.socialbase.downloader.downloader.g.a.a(r7);
        com.ss.android.socialbase.downloader.downloader.m r8 = this.f;
        if (r8 == null) goto L9;
        r8.a(r7);
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L16;
        String r9 = d;
        StringBuilder r2 = new StringBuilder().append("AidlService!=null");
        if (this.e == null) goto L13;
        boolean r3 = true;
    L14:
        com.ss.android.socialbase.downloader.e.a.a(r9, "onServiceConnected", r2.append(r3).append(" pendingTasks.size:").append(this.f15397a.size()).toString());
        goto L16
    L13:
        r3 = false;
    L16:
        if (this.e == null) goto L29;
        com.ss.android.socialbase.downloader.downloader.c.a().b();
        this.f15398b = true;
        this.c.set(false);
        int r10 = this.g;
        if (r10 == (-1)) goto L24;
        this.e.h(r10);     // Catch: RemoteException -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
    L24:
        if (this.e == null) goto L30;
        g();
        return;
    L30:
        return;
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r3) {
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(d, "onServiceDisconnected", "Run");
    L5:
        this.e = null;
        this.f15398b = false;
        com.ss.android.socialbase.downloader.downloader.m r2 = this.f;
        if (r2 == null) goto L9;
        r2.g();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a, com.ss.android.socialbase.downloader.downloader.n
    public void startService() {
        if (this.e != null) goto L6;
        startService((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ss.android.socialbase.downloader.downloader.b.S(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void startService(Context r4, ServiceConnection r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r6 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r5, ServiceConnection.class, "com.obric.memorydata.plugin");
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L6;
        com.ss.android.socialbase.downloader.e.a.a(d, "startService", "BindService");     // Catch: Throwable -> L11
    L6:
        Intent r7 = new Intent(r3, IndependentProcessDownloadService.class);     // Catch: Throwable -> L11
        if (r6 == null) goto L9;
        ZeusTransformUtils.bindService(r3, r7, r6, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L9:
        ZeusTransformUtils.startService(r3, r7, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    }

    @Override // com.ss.android.socialbase.downloader.downloader.a
    public void stopService(Context r5, ServiceConnection r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r6, ServiceConnection.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a() == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a(d, "stopService", "Run");
    L5:
        this.f15398b = false;
        Intent r4 = new Intent(r7, IndependentProcessDownloadService.class);
        if (r8 == null) goto L8;
        ZeusTransformUtils.unbindService(r7, r8, "com.obric.memorydata.plugin");
    L8:
        ZeusTransformUtils.stopService(r7, r4, "com.obric.memorydata.plugin");
    }
}
