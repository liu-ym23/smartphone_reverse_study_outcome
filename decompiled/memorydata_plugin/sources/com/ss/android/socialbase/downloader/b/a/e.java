package com.ss.android.socialbase.downloader.b.a;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class e extends com.ss.android.socialbase.downloader.b.a {
    public e() {
    }

    private void d() {
        com.ss.android.socialbase.downloader.d.a r0 = new com.ss.android.socialbase.downloader.d.a(this.c.getSavePath(), this.c.getName());
        if (r0.o() == false) goto L5;
        this.f15249a.d(this.c.getId());
        throw new BaseException(1081, "download savePath error:" + this.c.getSavePath() + " extra:" + r0.p());
    L5:
        if (this.d.a("fix_vulnerability_file_name", 1) <= 0) goto L14;
        if (TextUtils.isEmpty(this.c.getName()) == true) goto L14;
        if (this.c.getName().contains("..") == false) goto L14;
        throw new BaseException(1093, "File name error:" + this.c.getName());
    L14:
        if (r0.n() == false) goto L16;
        return;
    L16:
        File r1 = new File(this.c.getSavePath());
        if (r1.exists() == true) goto L41;
        boolean r2 = r1.mkdirs();
        if (r2 == false) goto L21;
        return;
    L21:
        if (r1.exists() == true) goto L57;
        int r3 = 0;
    L24:
        if (r2 == true) goto L30;
        int r4 = r3 + 1;
        if (r3 >= 3) goto L30;
        Thread.sleep(10);     // Catch: InterruptedException -> L52
        r2 = r1.mkdirs();
        r3 = r4;
    L30:
        if (r2 == false) goto L32;
        return;
    L32:
        if (r1.exists() == false) goto L34;
        return;
    L34:
        if (com.ss.android.socialbase.downloader.utils.g.c(this.c.getSavePath()) >= 16384) goto L38;
        throw new BaseException(1006, "download savePath directory can not created:" + this.c.getSavePath());
    L38:
        throw new BaseException(1030, "download savePath directory can not created:" + this.c.getSavePath());
    L57:
        return;
    L41:
        if (r1.isDirectory() == true) goto L59;
        r1.delete();
        if (r1.mkdirs() == false) goto L45;
        return;
    L45:
        if (r1.exists() == false) goto L48;
        return;
    L48:
        throw new BaseException(1031, "download savePath is not directory:path=" + this.c.getSavePath());
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckPathModule", this.c, "proceed", "Run");
    L5:
        d();
        r6.a();
    }
}
