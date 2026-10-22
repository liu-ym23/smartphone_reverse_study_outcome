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
public interface t {

    public static class a implements t {
        public a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public int a(String r1, String r2) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> a(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a() {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1, long r2, int r4) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1, IDownloadListener r2, ListenerType r3, boolean r4, boolean r5) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1, aa r2) {
            aa r0 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(af r2) {
            af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(com.ss.android.socialbase.downloader.depend.i r2) {
            com.ss.android.socialbase.downloader.depend.i r1 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(DownloadTask r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void a(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public boolean a(DownloadInfo r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public DownloadInfo b(String r1, String r2) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> b(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(int r1, IDownloadListener r2, ListenerType r3, boolean r4) {
            IDownloadListener r0 = (IDownloadListener) ZeusTransformUtils.wrapperContextForParams(r2, IDownloadListener.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(int r1, boolean r2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(af r2) {
            af r1 = (af) ZeusTransformUtils.wrapperContextForParams(r2, af.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(com.ss.android.socialbase.downloader.depend.i r2) {
            com.ss.android.socialbase.downloader.depend.i r1 = (com.ss.android.socialbase.downloader.depend.i) ZeusTransformUtils.wrapperContextForParams(r2, com.ss.android.socialbase.downloader.depend.i.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void b(List<String> r2) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public boolean b() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> c() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> c(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public boolean c(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> d(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void d(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public boolean d() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public long e(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public List<DownloadInfo> e(String r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public int f(int r1) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public boolean g(int r1) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public DownloadInfo h(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public aa i(int r1) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public void j(int r1) {
        }

        @Override // com.ss.android.socialbase.downloader.service.t
        public com.ss.android.socialbase.downloader.depend.t k(int r1) {
            return null;
        }
    }

    int a(String r1, String r2);

    List<DownloadInfo> a(String r1);

    void a();

    void a(int r1);

    void a(int r1, long r2, int r4);

    void a(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void a(int r1, IDownloadListener r2, ListenerType r3, boolean r4, boolean r5);

    void a(int r1, aa r2);

    void a(int r1, boolean r2);

    void a(af r1);

    void a(com.ss.android.socialbase.downloader.depend.i r1);

    void a(DownloadTask r1);

    void a(List<String> r1);

    boolean a(DownloadInfo r1);

    DownloadInfo b(String r1, String r2);

    List<DownloadInfo> b(String r1);

    void b(int r1);

    void b(int r1, IDownloadListener r2, ListenerType r3, boolean r4);

    void b(int r1, boolean r2);

    void b(af r1);

    void b(com.ss.android.socialbase.downloader.depend.i r1);

    void b(List<String> r1);

    boolean b();

    List<DownloadInfo> c();

    List<DownloadInfo> c(String r1);

    boolean c(int r1);

    List<DownloadInfo> d(String r1);

    void d(int r1);

    boolean d();

    long e(int r1);

    List<DownloadInfo> e(String r1);

    int f(int r1);

    boolean g(int r1);

    DownloadInfo h(int r1);

    aa i(int r1);

    void j(int r1);

    com.ss.android.socialbase.downloader.depend.t k(int r1);
}
