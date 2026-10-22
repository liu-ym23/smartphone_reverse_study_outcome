package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;
import com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ProcessDownloadHandler implements IDownloadProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbsDownloadEngine f15741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDownloadCache f15742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDownloadServiceHandler f15743c;
    public final boolean d;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15753a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15754b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ProcessDownloadHandler f15755c;

        public AnonymousClass2(ProcessDownloadHandler r5, int r10, boolean r11) {
            this.f15755c = r5;
            this.f15753a = r10;
            this.f15754b = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15755c.f15741a.a(this.f15753a, this.f15754b);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProcessDownloadHandler f15759b;

        public AnonymousClass4(ProcessDownloadHandler r5, int r10) {
            this.f15759b = r5;
            this.f15758a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15759b.f15741a.n(this.f15758a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProcessDownloadHandler f15760a;

        public AnonymousClass5(ProcessDownloadHandler r5) {
            this.f15760a = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15760a.f15741a.b();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$6, reason: invalid class name */
    class AnonymousClass6 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProcessDownloadHandler f15762b;

        public AnonymousClass6(ProcessDownloadHandler r5, ArrayList r10) {
            this.f15762b = r5;
            this.f15761a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15762b.f15741a.a(this.f15761a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f15763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ProcessDownloadHandler f15764b;

        public AnonymousClass7(ProcessDownloadHandler r5, ArrayList r10) {
            this.f15764b = r5;
            this.f15763a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f15764b.f15741a.b(this.f15763a);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f15767c;
        public final /* synthetic */ ProcessDownloadHandler d;

        public AnonymousClass8(ProcessDownloadHandler r5, int r10, boolean r11, boolean r12) {
            this.d = r5;
            this.f15765a = r10;
            this.f15766b = r11;
            this.f15767c = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.d.f15741a.a(this.f15765a, this.f15766b, this.f15767c);
        }
    }

    public ProcessDownloadHandler(boolean r5) {
        this.f15741a = DownloadComponentManager.j();
        this.f15742b = DownloadComponentManager.h();
        if (r5 == true) goto L5;
        this.f15743c = DownloadComponentManager.l();
    L6:
        boolean r10 = false;
        if (DownloadSetting.f.a("single_async_handle_operation", 0) <= 0) goto L9;
        r10 = true;
    L9:
        this.d = r10;
        return;
    L5:
        this.f15743c = DownloadComponentManager.p();
        goto L6
    }

    public final void a(Runnable r5) {
        if (this.d == false) goto L6;
        DownloadComponentManager.b(r5);
        return;
    L6:
        r5.run();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(final int r5, boolean r10) {
        Runnable r11 = new AnonymousClass1(this, r5);
        if (r10 == false) goto L6;
        r11.run();
        return;
    L6:
        a(r11);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void c() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean d(int r5) {
        return this.f15742b.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void e(int r5) {
        a(new AnonymousClass2(this, r5, true));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean f(int r5) {
        return this.f15741a.i(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void g(int r5) {
        a(new AnonymousClass4(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final int i(int r5) {
        return DownloadProcessDispatcher.a().b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void c(int r5) {
        this.f15742b.c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean d() {
        IDownloadServiceHandler r5 = this.f15743c;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (((AbsDownloadServiceHandler) r5).f15509b == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(ArrayList r5) {
        a(new AnonymousClass6(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b() {
        a(new AnonymousClass5(this));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final DownloadInfo a(int r5) {
        return this.f15741a.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(ArrayList r5) {
        a(new AnonymousClass7(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r10, int r11, IDownloadListener r12, ListenerType r13) {
        this.f15741a.a(r10, r11, r12, r13, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(DownloadInfo r5) {
        this.f15742b.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r10, int r11, AbsDownloadListener r12, ListenerType r13) {
        this.f15741a.b(r10, r11, r12, r13, false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean b(int r5) {
        return this.f15742b.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(final DownloadTask r5) {
        DownloadComponentManager.a(r5, true);
        a(new AnonymousClass10(this, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void b(int r5, int r10) {
        if (DownloadComponentManager.f15528r == null) goto L10;
        Iterator r11 = DownloadComponentManager.f15528r.iterator();
    L6:
        if (r11.hasNext() == false) goto L16;
        ProcessCallback r12 = (ProcessCallback) r11.next();
        if (r12 == null) goto L6;
        r12.a(r10, r5);
        goto L6
    L16:
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a(int r5, boolean r10) {
        DownloadProcessDispatcher.a().b(r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final boolean a(DownloadInfo r5) {
        return this.f15742b.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadProxy
    public final void a() {
        this.f15742b.a();
    }
}
