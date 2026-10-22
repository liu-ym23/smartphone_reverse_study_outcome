package com.ss.android.socialbase.downloader.file;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class FileOpImpl implements IDownloadFileOp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f15615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15616b;

    public FileOpImpl(String r5, String r10, boolean r11) {
        this.f15616b = true;
        if (TextUtils.isEmpty(r10) == true) goto L5;
        this.f15615a = new File(r5, r10);
    L6:
        if (r11 == false) goto L9;
        this.f15616b = DownloadDirUtils.a(r5);
        return;
    L9:
        return;
    L5:
        this.f15615a = new File(r5);
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(long r5) {
        return this.f15615a.setLastModified(r5);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean b() {
        return this.f15615a.canWrite();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileInputStream c() {
        if (this.f15615a.isFile() == false) goto L7;
        return new FileInputStream(this.f15615a);
    L7:
        throw new IOException(this.f15615a.getAbsolutePath() + " Fail to obtain InputStream, file type error");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File d() {
        return this.f15615a.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String e() {
        return this.f15615a.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean f() {
        return this.f15615a.exists();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final int g() {
        return 1;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String h() {
        return this.f15615a.getPath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long i() {
        return this.f15615a.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean j() {
        return this.f15615a.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileOutputStream k() {
        return new FileOutputStream(this.f15615a);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File l() {
        return this.f15615a;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long length() {
        return this.f15615a.length();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean m() {
        if (this.f15616b == true) goto L7;
        return true;
    L7:
        return this.f15615a.delete();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(DownloadFile r5) {
        return this.f15615a.renameTo(r5.f15607a.l());
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String a() {
        return "";
    }
}
