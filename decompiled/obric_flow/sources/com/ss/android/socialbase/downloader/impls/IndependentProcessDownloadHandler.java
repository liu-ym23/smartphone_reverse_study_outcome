package com.ss.android.socialbase.downloader.impls;

import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentProcessDownloadHandler implements IDownloadProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile IDownloadAidlService f15699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadServiceHandler f15700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProcessDownloadHandler f15701c;

    public IndependentProcessDownloadHandler() {
        this.f15701c = new ProcessDownloadHandler(false);
        IDownloadServiceHandler r5 = DownloadComponentManager.p();
        this.f15700b = r5;
        r5.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final DownloadInfo a(int r5) {
        if (this.f15699a == null) goto L5;
        return this.f15699a.a(r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.f15701c.f15741a.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(DownloadInfo r5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void c() {
        IDownloadServiceHandler r5 = this.f15700b;
        if (r5 == null) goto L6;
        r5.c();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean d(int r5) {
        if (this.f15699a == null) goto L5;
        return this.f15699a.d(r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f15701c.f15742b.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void e(int r5) {
        if (this.f15699a == null) goto L12;
        this.f15699a.c(r5, true);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean f(int r5) {
        if (this.f15699a != null) goto L10;
        return false;
    L10:
        return this.f15699a.f(r5);
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void g(int r5) {
        if (this.f15699a == null) goto L12;
        this.f15699a.g(r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final int i(int r5) {
        if (this.f15699a == null) goto L5;
        return this.f15699a.i(r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L5:
        return DownloadProcessDispatcher.a().c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(int r5, boolean r10) {
        if (this.f15699a == null) goto L12;
        this.f15699a.b(r5, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void c(int r5) {
        if (this.f15699a != null) goto L11;
        this.f15701c.f15742b.c(r5);
        return;
    L11:
        this.f15699a.c(r5);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b() {
        if (this.f15699a == null) goto L12;
        this.f15699a.b();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(ArrayList r5) {
        if (this.f15699a != null) goto L11;
        ProcessDownloadHandler r10 = this.f15701c;
        r10.getClass();
        r10.a(new ProcessDownloadHandler.AnonymousClass6(r10, r5));
        return;
    L11:
        this.f15699a.a(r5);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean d() {
        if (this.f15699a == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(ArrayList r5) {
        if (this.f15699a != null) goto L11;
        ProcessDownloadHandler r10 = this.f15701c;
        r10.getClass();
        r10.a(new ProcessDownloadHandler.AnonymousClass7(r10, r5));
        return;
    L11:
        this.f15699a.b(r5);     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r10, int r11, IDownloadListener r12, ListenerType r13) {
        if (this.f15699a == null) goto L16;
        IDownloadAidlService r5 = this.f15699a;     // Catch: RemoteException -> L11
        if (r13 != ListenerType.f15281b) goto L8;
        boolean r14 = false;
    L9:
        r5.b(r10, r11, IPCUtils.a(r12, r14), r13.ordinal(), false);     // Catch: RemoteException -> L11
        return;
    L8:
        r14 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean b(int r5) {
        if (this.f15699a == null) goto L5;
        return this.f15699a.b(r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f15701c.f15742b.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r10, int r11, AbsDownloadListener r12, ListenerType r13) {
        if (this.f15699a == null) goto L16;
        IDownloadAidlService r5 = this.f15699a;     // Catch: RemoteException -> L11
        if (r13 != ListenerType.f15281b) goto L8;
        boolean r14 = false;
    L9:
        r5.a(r10, r11, IPCUtils.a(r12, r14), r13.ordinal(), false);     // Catch: RemoteException -> L11
        return;
    L8:
        r14 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(DownloadTask r5) {
        IDownloadServiceHandler r10 = this.f15700b;
        if (r10 == null) goto L6;
        r10.a(r5);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(int r5, int r10) {
        if (this.f15699a == null) goto L11;
        this.f15699a.b(r5, r10);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r5, boolean r10) {
        if (this.f15699a == null) goto L12;
        this.f15699a.a(r5, r10);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean a(DownloadInfo r5) {
        if (this.f15699a == null) goto L5;
        return this.f15699a.a(r5);
    L8:
        e = move-exception;
        e.printStackTrace();
        return false;
    L5:
        return this.f15701c.f15742b.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a() {
        if (this.f15699a != null) goto L11;
        this.f15701c.f15742b.a();
        return;
    L11:
        this.f15699a.a();     // Catch: RemoteException -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
