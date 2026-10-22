package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.IDownloadAidlService;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class IndependentDownloadBinder extends IDownloadAidlService.Stub {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProcessDownloadHandler f15697b;

    public IndependentDownloadBinder() {
        this.f15697b = new ProcessDownloadHandler(true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a(DownloadAidlTask r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L5;
        return;
    L5:
        DownloadTask r11 = IPCUtils.a(r5);
        DownloadComponentManager.a(r11, true);
        r10.a(new ProcessDownloadHandler.AnonymousClass11(r10, r11));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void b(int r5, boolean r10) {
        ProcessDownloadHandler r11 = this.f15697b;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.b(r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void c(int r5, boolean r10) {
        ProcessDownloadHandler r11 = this.f15697b;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.a(new ProcessDownloadHandler.AnonymousClass2(r11, r5, r10));
    }

    public final void d(int r5, boolean r10) {
        ProcessDownloadHandler r11 = this.f15697b;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.a(new ProcessDownloadHandler.AnonymousClass8(r11, r5, r10, false));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final boolean f(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f15741a.i(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void g(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.a(new ProcessDownloadHandler.AnonymousClass4(r10, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final int i(int r5) {
        return DownloadProcessDispatcher.a().c(r5);
    }

    public final void o(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.a(new ProcessDownloadHandler.AnonymousClass3(r10, r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void p(int r5) {
        if (this.f15697b != null) goto L5;
        return;
    L5:
        Object r10 = Logger.f15791a;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L8:
        if (Logger.f15792b == false) goto L13;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L13:
        Logger.f15793c = r5;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    public final boolean q(DownloadInfo r10) {
        ProcessDownloadHandler r11 = this.f15697b;
        boolean r5 = false;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r10 != null) goto L7;
        return false;
    L7:
        int r12 = r10.o();
        String r13 = r10.e;
        String r14 = r10.f15808b;
        char[] r15 = DownloadUtils.f16142a;
        if (r12 == (-3)) goto L10;
    L21:
        if (r5 == false) goto L23;
        r11.a(new ProcessDownloadHandler.AnonymousClass9(r11, r10.l()));
    L23:
        return r5;
    L10:
        if (TextUtils.isEmpty(r13) == false) goto L12;
    L18:
        boolean r16 = false;
    L19:
        if (r16 == true) goto L21;
        r5 = true;
        goto L21
    L12:
        if (TextUtils.isEmpty(r14) == true) goto L18;
        if (DownloadFileUtils.e(r13) == true) goto L25;
    L17:
        r16 = new DownloadFile(r13, r14, true).f();
        goto L19
    L25:
        DownloadFileUtils.a(Uri.parse(r13), DownloadFileUtils.b(r13));     // Catch: Throwable -> L24
        goto L17
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void b() {
        ProcessDownloadHandler r5 = this.f15697b;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.a(new ProcessDownloadHandler.AnonymousClass5(r5));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void c(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.f15742b.c(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final boolean d(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f15742b.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final DownloadInfo a(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f15741a.d(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void b(ArrayList r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 == null) goto L6;
        r10.a(new ProcessDownloadHandler.AnonymousClass7(r10, r5));
        return;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void b(int r10, int r11, IDownloadAidlListener r12, int r13, boolean r14) {
        ProcessDownloadHandler r15 = this.f15697b;
        if (r15 != null) goto L5;
        return;
    L5:
        IDownloadListener r5 = IPCUtils.a(r12);
        ListenerType r16 = DownloadHelper.a(r13);
        r15.f15741a.a(r10, r11, r5, r16, r14);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a(ArrayList r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.a(new ProcessDownloadHandler.AnonymousClass6(r10, r5));
    }

    public final void a(int r5, boolean r10, boolean r11) {
        ProcessDownloadHandler r12 = this.f15697b;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(new ProcessDownloadHandler.AnonymousClass8(r12, r5, r10, r11));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final boolean b(int r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f15742b.b(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a(int r10, int r11, IDownloadAidlListener r12, int r13, boolean r14) {
        ProcessDownloadHandler r15 = this.f15697b;
        if (r15 != null) goto L5;
        return;
    L5:
        IDownloadListener r5 = IPCUtils.a(r12);
        ListenerType r16 = DownloadHelper.a(r13);
        r15.f15741a.b(r10, r11, r5, r16, r14);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void b(int r5, int r10) {
        ProcessDownloadHandler r11 = this.f15697b;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.b(r5, r10);
    }

    public final void a(int r10, long r11, int r12) {
        ProcessDownloadHandler r13 = this.f15697b;
        if (r13 != null) goto L5;
        return;
    L5:
        r13.a(new ProcessDownloadHandler.AnonymousClass12(r13, r10, r11, r12));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a(int r5, boolean r10) {
        DownloadProcessDispatcher.a().a(r5, r10);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final boolean a(DownloadInfo r5) {
        ProcessDownloadHandler r10 = this.f15697b;
        if (r10 != null) goto L7;
        return false;
    L7:
        return r10.f15742b.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a() {
        ProcessDownloadHandler r5 = this.f15697b;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.f15742b.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
    public final void a(ProcessAidlCallback r5) {
        if (this.f15697b != null) goto L5;
        return;
    L5:
        ProcessCallback r10 = IPCUtils.a(r5);
        if (r10 != null) goto L9;
        Context r11 = DownloadComponentManager.f15515a;
        return;
    L9:
        DownloadComponentManager.f15528r.add(r10);
    }
}
