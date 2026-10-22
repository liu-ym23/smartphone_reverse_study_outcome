package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.DownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadCheckPathModule extends AbsDownloadModule {
    public DownloadCheckPathModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public final void a(DownloadModuleChain r5) {
        if (Logger.a(this.f15290c) == false) goto L13;
        Logger.a("DownloadCheckPathModule", this.f15290c, "proceed", "Run");
    L13:
        c();     // Catch: BaseException -> L8
        r5.c();
        return;
    L8:
        e = move-exception;
        if (this.d.a("save_path_invalid_downgrade", 0) <= 0) goto L12;
        DownloadInfo r10 = this.f15290c;
        r10.e = DownloadDirUtils.a();
    L12:
        throw e;
    }

    public final void c() {
        DownloadInfo r5 = this.f15290c;
        DownloadFile r10 = new DownloadFile(r5.e, r5.f15808b, true);
        if (r10.n() == false) goto L12;
        this.f15288a.d(this.f15290c.l());
        if (DownloadFileUtils.b() == false) goto L10;
        if (DownloadFileUtils.e(this.f15290c.e) == false) goto L10;
        DownloadFileUtils.f15610b = Boolean.FALSE;
        this.f15290c.e = DownloadDirUtils.a();
    L10:
        throw new BaseException(1081, "download savePath error:" + this.f15290c.e + " extra:" + r10.a());
    L12:
        if (this.d.a("fix_vulnerability_file_name", 1) <= 0) goto L21;
        if (TextUtils.isEmpty(this.f15290c.f15808b) == true) goto L21;
        if (this.f15290c.f15808b.contains("..") == false) goto L21;
        throw new BaseException(1093, "File name error:" + this.f15290c.f15808b);
    L21:
        if (r10.p() == true) goto L65;
        File r11 = new File(this.f15290c.e);
        if (r11.exists() == true) goto L47;
        boolean r12 = r11.mkdirs();
        if (r12 == false) goto L28;
        return;
    L28:
        if (r11.exists() == true) goto L66;
        int r13 = 0;
    L31:
        if (r12 == true) goto L37;
        int r14 = r13 + 1;
        if (r13 >= 3) goto L37;
        Thread.sleep(10);     // Catch: InterruptedException -> L56
        r12 = r11.mkdirs();
        r13 = r14;
    L37:
        if (r12 == false) goto L39;
        return;
    L39:
        if (r11.exists() == false) goto L41;
        return;
    L41:
        if (DownloadUtils.b(this.f15290c.e) >= Http2Stream.EMIT_BUFFER_SIZE) goto L45;
        throw new BaseException(PointerIconCompat.TYPE_CELL, "download savePath directory can not created:" + this.f15290c.e);
    L45:
        throw new BaseException(1030, "download savePath directory can not created:" + this.f15290c.e);
    L66:
        return;
    L47:
        if (r11.isDirectory() == true) goto L63;
        r11.delete();
        if (r11.mkdirs() == false) goto L51;
        return;
    L51:
        if (r11.exists() == false) goto L54;
        return;
    L54:
        throw new BaseException(1031, "download savePath is not directory:path=" + this.f15290c.e);
    L63:
        return;
    }
}
