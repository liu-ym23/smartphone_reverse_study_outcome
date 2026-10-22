package com.ss.android.socialbase.downloader.file;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class MediaStoreOpImpl implements IDownloadFileOp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f15617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f15618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15619c;

    public MediaStoreOpImpl(Uri r5, int r10) {
        this.f15617a = r5;
        this.f15619c = r10;
        String r11 = DownloadFileUtils.a(r5);
        if (TextUtils.isEmpty(r11) == true) goto L6;
        this.f15618b = new File(r11);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(DownloadFile r5) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean b() {
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileInputStream c() {
        if (this.f15617a == null) goto L11;
        if (DownloadFileUtils.b() == false) goto L9;
        return new ParcelFileDescriptor.AutoCloseInputStream(DownloadFileUtils.a(this.f15617a, "r"));
    L9:
        return new FileInputStream(DownloadFileUtils.a(this.f15617a, "r").getFileDescriptor());
    L11:
        throw new IOException("Fail to obtain InputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File d() {
        File r5 = this.f15618b;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getParentFile();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String e() {
        File r5 = this.f15618b;
        if (r5 != null) goto L5;
        return "";
    L5:
        return r5.getAbsolutePath();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean f() {
        if (DownloadFileUtils.b(this.f15617a) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final int g() {
        return this.f15619c;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String h() {
        return DownloadFileUtils.a(this.f15617a);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long i() {
        File r5 = this.f15618b;
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.exists() == true) goto L7;
        return 0;
    L7:
        return this.f15618b.lastModified();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean j() {
        File r5 = this.f15618b;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isDirectory();
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final FileOutputStream k() {
        if (this.f15617a == null) goto L11;
        if (DownloadFileUtils.b() == false) goto L9;
        return new ParcelFileDescriptor.AutoCloseOutputStream(DownloadFileUtils.a(this.f15617a, "w"));
    L9:
        return new FileOutputStream(DownloadFileUtils.a(this.f15617a, "w").getFileDescriptor());
    L11:
        throw new IOException("Fail to obtain OutputStream, uri is null");
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final File l() {
        return this.f15618b;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final long length() {
        return DownloadFileUtils.b(this.f15617a);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean m() {
    L8:
        th = move-exception;
        th.printStackTrace();
    L19:
        return false;
    L4:
        if (DownloadFileUtils.b() == true) goto L6;
        FileOutputStream r5 = k();     // Catch: Throwable -> L8
        r5.write(new byte[0]);     // Catch: Throwable -> L15
        r5.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Logger.c("DownloadFileUtils", "emptyFile", "Error:" + th);     // Catch: Throwable -> L8
        goto L19
    L6:
        if (f() == false) goto L10;
        ((IDownloadComponentManagerService) DownloadServiceManager.a(IDownloadComponentManagerService.class)).e().getContentResolver().delete(this.f15617a, null, null);     // Catch: Throwable -> L8
        return true;
    L10:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final boolean a(long r5) {
        File r10 = this.f15618b;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.exists() == true) goto L7;
        return false;
    L7:
        return this.f15618b.setLastModified(r5);
    }

    @Override // com.ss.android.socialbase.downloader.file.IDownloadFileOp
    public final String a() {
        return "";
    }
}
