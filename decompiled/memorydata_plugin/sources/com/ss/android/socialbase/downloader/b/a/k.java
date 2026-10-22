package com.ss.android.socialbase.downloader.b.a;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class k extends com.ss.android.socialbase.downloader.b.a {
    public k() {
    }

    private void d() {
        int r0 = this.c.getId();
        boolean r1 = this.f15249a.d();
        DownloadInfo r2 = this.f15249a.b(r0);
        if (r2 != null) goto L9;
        if (r1 == true) goto L6;
    L7:
        r2 = ((com.ss.android.socialbase.downloader.impls.b) ZeusTransformUtils.preCheckCast(this.f15249a, com.ss.android.socialbase.downloader.impls.b.class, "com.obric.memorydata.plugin")).f().b(r0);
        goto L9
    L6:
        if (com.ss.android.socialbase.downloader.utils.c.a(com.ss.android.socialbase.downloader.utils.c.d(), com.ss.android.socialbase.downloader.utils.c.e(), com.ss.android.socialbase.downloader.utils.c.f(), this.c.getMimeType(), this.c.getMonitorScene()) == true) goto L7;
    L9:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L11;
        com.ss.android.socialbase.downloader.e.a.a("DownloadLoadCacheModule", this.c, "doLoadCache", "Find Cache:" + r1 + "CacheDownloadInfo" + r2);
    L11:
        boolean r3 = true;
        if (r2 != null) goto L14;
    L35:
        this.c.reset();
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L38;
        com.ss.android.socialbase.downloader.e.a.a("DownloadLoadCacheModule", this.c, "doLoadCache", "Download reset");
    L38:
        if (r3 == false) goto L41;
        this.f15249a.a(this.c);
    L41:
        if (com.ss.android.socialbase.downloader.e.a.a(this.c) == false) goto L44;
        com.ss.android.socialbase.downloader.e.a.a("DownloadLoadCacheModule", this.c, "doLoadCache", "After load:" + this.c);
        return;
    L44:
        return;
    L14:
        if (r2.isNewTask() == true) goto L35;
        if (r2.isForce() == true) goto L35;
        if (this.c.getStartOffset() != r2.getStartOffset()) goto L35;
        if (this.c.getEndOffset() != r2.getEndOffset()) goto L35;
        this.c.copyFromCacheData(r2, true);
        if (r2 == this.c) goto L25;
        boolean r4 = true;
    L27:
        if (this.c.getSavePath().equals(r2.getSavePath()) == false) goto L32;
        if (r2.isDownloaded() == false) goto L32;
        this.f.l = r2.getName();
        this.f.k = r2.getSavePath();
    L34:
        r3 = r4;
    L32:
        if (com.ss.android.socialbase.downloader.downloader.b.a(r2) == r0) goto L34;
        this.f15249a.d(r0);
        goto L38
    L25:
        r4 = false;
        goto L27
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
        com.ss.android.socialbase.downloader.e.a.a("DownloadLoadCacheModule", this.c, "proceed", "Run");
    L5:
        d();
        if (j_() == false) goto L8;
        return;
    L8:
        r6.a();
    }
}
