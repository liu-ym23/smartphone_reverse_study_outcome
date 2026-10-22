package com.ss.android.socialbase.downloader.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class ErrorOpImpl implements IDownloadFileOp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15614a;

    public ErrorOpImpl(String r5) {
        this.f15614a = r5;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(long r5) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean b() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileInputStream c() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File d() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String e() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean f() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final int g() {
        return -1;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String h() {
        return "";
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long i() {
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean j() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileOutputStream k() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File l() {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long length() {
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean m() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(DownloadFile r5) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String a() {
        return this.f15614a;
    }
}
