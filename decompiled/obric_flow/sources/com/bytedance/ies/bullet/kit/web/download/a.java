package com.bytedance.ies.bullet.kit.web.download;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f5494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5495b;

    public a(b r5, String r10) {
        this.f5494a = r5;
        this.f5495b = r10;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void a(DownloadInfo r5, BaseException r10) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        Intrinsics.checkNotNullParameter(r10, "e");
        boolean r11 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: download failed url=" + this.f5495b + ",errorCode=" + r10.f15601a + ",errorMsg=" + r10.f15602b, "XPreload");
        Downloader.b(this.f5494a.f5497a).a(r5.l(), this);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void l(DownloadInfo r5) {
        Intrinsics.checkNotNullParameter(r5, "entity");
        boolean r10 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.a(2, "WebResourceDownloader: download success " + r5.d, "XPreload");
        Downloader.b(this.f5494a.f5497a).a(r5.l(), this);
    }
}
