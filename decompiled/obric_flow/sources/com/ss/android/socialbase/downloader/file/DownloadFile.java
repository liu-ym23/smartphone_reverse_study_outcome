package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFile implements IDownloadFileOp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadFileOp f15607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15608b;

    public DownloadFile(String r5, String r10, boolean r11) {
        this.f15608b = r5;
        int r12 = DownloadFileUtils.b(r5);
        if (r12 != 1) goto L11;
        this.f15607a = new FileOpImpl(r5, r10, r11);
        return;
    L11:
        Uri r13 = Uri.parse(r5);     // Catch: Throwable -> L8
        DownloadFileUtils.a(r13, r12);     // Catch: Throwable -> L8
        this.f15607a = new MediaStoreOpImpl(r13, r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        this.f15607a = new ErrorOpImpl(th.toString());
        th.printStackTrace();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(long r5) {
        return this.f15607a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean b() {
        return this.f15607a.b();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileInputStream c() {
        return this.f15607a.c();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File d() {
        return this.f15607a.d();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String e() {
        return this.f15607a.e();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean f() {
        return this.f15607a.f();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final int g() {
        return this.f15607a.g();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String h() {
        return this.f15607a.h();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long i() {
        return this.f15607a.i();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean j() {
        return this.f15607a.j();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileOutputStream k() {
        return this.f15607a.k();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File l() {
        return this.f15607a.l();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long length() {
        return this.f15607a.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean m() {
        return this.f15607a.m();
    }

    public final boolean n() {
        if (this.f15607a.g() != (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean o() {
        if (this.f15607a.g() != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean p() {
        int r5 = this.f15607a.g();
        if (r5 != 2) goto L5;
        return true;
    L5:
        if (r5 != 3) goto L7;
        return true;
    L7:
        if (r5 != 4) goto L9;
        return true;
    L9:
        if (r5 == 5) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(DownloadFile r5) {
        return this.f15607a.a(r5);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String a() {
        return this.f15607a.a();
    }
}
