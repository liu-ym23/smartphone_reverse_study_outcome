package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i implements t {
    public i() {
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public int a(String r1, String r2) {
        return com.ss.android.socialbase.downloader.downloader.c.a().a(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> a(String r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadInfoList");
        return com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a() {
        com.ss.android.socialbase.downloader.downloader.c.a().c();
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r1) {
        com.ss.android.socialbase.downloader.downloader.c.a().d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r1, long r2, int r4) {
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1, r2, r4);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
        IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.utils.c.c("removeDownloadListener");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1, r0, r3, false);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r7, IDownloadListener r8, ListenerType r9, boolean r10, boolean r11) {
        IDownloadListener r2 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r8, IDownloadListener.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.utils.c.c("addDownloadListener");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r7, r2, r9, r10, r11);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r2, aa r3) {
        aa r1 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.utils.c.c("setDownloadNotificationEventListener");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r2, r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.c.a().c(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(com.ss.android.socialbase.downloader.depend.i r2) {
        com.ss.android.socialbase.downloader.depend.i r1 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(DownloadTask r6) {
        if (com.ss.android.socialbase.downloader.e.a.b() == false) goto L8;
        if (r6 == null) goto L8;
        DownloadInfo r5 = r6.getDownloadInfo();
        if (r5 == null) goto L8;
        com.ss.android.socialbase.downloader.e.a.a("DownloadProcessDispatcherService", r5, "tryDownload", r5.toDetailString(), true);
        com.ss.android.socialbase.downloader.e.a.a("DownloadProcessDispatcherService", r5, "tryDownload", "Setting:" + com.ss.android.socialbase.downloader.g.a.a(r5.getId()), true);
    L8:
        com.ss.android.socialbase.downloader.downloader.c.a().a(r6);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void a(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public boolean a(DownloadInfo r1) {
        com.ss.android.socialbase.downloader.utils.c.c("isDownloadSuccessAndFileNotExist");
        return com.ss.android.socialbase.downloader.downloader.c.a().a(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public DownloadInfo b(String r1, String r2) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadInfo");
        return com.ss.android.socialbase.downloader.downloader.c.a().b(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> b(String r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getSuccessedDownloadInfosWithMimeType");
        return com.ss.android.socialbase.downloader.downloader.c.a().b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(int r1) {
        com.ss.android.socialbase.downloader.downloader.c.a().f(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(int r2, IDownloadListener r3, ListenerType r4, boolean r5) {
        IDownloadListener r1 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r3, IDownloadListener.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.utils.c.c("addDownloadListener");
        com.ss.android.socialbase.downloader.downloader.c.a().b(r2, r1, r4, r5);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(int r1, boolean r2) {
        com.ss.android.socialbase.downloader.downloader.c.a().d(r1, r2);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(af r2) {
        af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(com.ss.android.socialbase.downloader.depend.i r2) {
        com.ss.android.socialbase.downloader.depend.i r1 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void b(List<String> r2) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.ss.android.socialbase.downloader.downloader.c.a().b(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public boolean b() {
        return com.ss.android.socialbase.downloader.downloader.c.a().d();
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> c() {
        com.ss.android.socialbase.downloader.utils.c.c("getAllDownloadInfo");
        return com.ss.android.socialbase.downloader.downloader.c.a().e();
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> c(String r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getUnCompletedDownloadInfosWithMimeType");
        return com.ss.android.socialbase.downloader.downloader.c.a().c(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public boolean c(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("canResume");
        return com.ss.android.socialbase.downloader.downloader.c.a().e(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> d(String r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadingDownloadInfosWithMimeType");
        return com.ss.android.socialbase.downloader.downloader.c.a().d(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void d(int r1) {
        com.ss.android.socialbase.downloader.downloader.c.a().g(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public boolean d() {
        return com.ss.android.socialbase.downloader.downloader.c.a().f();
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public long e(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getCurBytes");
        return com.ss.android.socialbase.downloader.downloader.c.a().h(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public List<DownloadInfo> e(String r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadInfosByFileExtension");
        return com.ss.android.socialbase.downloader.downloader.c.a().e(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public int f(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getStatus");
        return com.ss.android.socialbase.downloader.downloader.c.a().i(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public boolean g(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("isDownloading");
        return com.ss.android.socialbase.downloader.downloader.c.a().j(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public DownloadInfo h(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadInfo");
        return com.ss.android.socialbase.downloader.downloader.c.a().k(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public aa i(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadNotificationEventListener");
        return com.ss.android.socialbase.downloader.downloader.c.a().l(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public void j(int r1) {
        com.ss.android.socialbase.downloader.downloader.c.a().m(r1);
    }

    @Override // com.ss.android.socialbase.downloader.service.t
    public com.ss.android.socialbase.downloader.depend.t k(int r1) {
        com.ss.android.socialbase.downloader.utils.c.c("getDownloadFileUriProvider");
        return com.ss.android.socialbase.downloader.downloader.c.a().o(r1);
    }
}
