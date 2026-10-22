package com.ss.android.socialbase.downloader.b.a;

import androidx.core.view.InputDeviceCompat;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class d extends com.ss.android.socialbase.downloader.b.a {
    public d() {
    }

    private void d() {
        int r0 = this.c.getId();
        int r1 = com.ss.android.socialbase.downloader.downloader.b.a(this.c);
        DownloadInfo r2 = this.f15249a.b(r1);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.getId() != r0) goto L7;
        return;
    L7:
        if (r2.equalsTask(this.c) == true) goto L10;
        return;
    L10:
        if (com.ss.android.socialbase.downloader.downloader.b.F().a(r2.getId()) == true) goto L16;
        com.ss.android.socialbase.downloader.utils.g.c(this.c);
        this.f15249a.d(r1);
        if (r2.isFileDataValid() == true) goto L14;
        return;
    L14:
        this.c.copyFromCacheData(r2, false);
        this.f15249a.a(this.c);
        throw new BaseException(1089, "retry task because id generator changed");
    L16:
        this.f15249a.d(r0);
        throw new BaseException(InputDeviceCompat.SOURCE_GAMEPAD, "another same task is downloading");
    }

    @Override // com.ss.android.socialbase.downloader.b.a, com.ss.android.socialbase.downloader.b.e
    public com.ss.android.socialbase.downloader.b.e a(i r2) {
        if (r2.c.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.a(r2);
    }

    @Override // com.ss.android.socialbase.downloader.b.e
    public void a(com.ss.android.socialbase.downloader.b.f r5) {
        com.ss.android.socialbase.downloader.b.f r6 = (com.ss.android.socialbase.downloader.b.f) ZeusTransformUtils.wrapperContextForParams(r5, com.ss.android.socialbase.downloader.b.f.class, "com.obric.memorydata.plugin");
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L5;
        com.ss.android.socialbase.downloader.e.a.a("DownloadCheckHasAnotherSameTaskModule", this.c, "proceed", "Run");
    L5:
        d();
        r6.a();
    }
}
